package com.tencent.mm.plugin.qrcode.model;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public class OpenCustomerServiceChatResultReceiver
  extends ResultReceiver
{
  private a.a Nqg;
  private Runnable Nqh = null;
  private boolean rUh = false;
  
  public OpenCustomerServiceChatResultReceiver(Handler paramHandler, a.a parama, Runnable paramRunnable)
  {
    super(paramHandler);
    this.Nqg = parama;
    this.Nqh = paramRunnable;
  }
  
  private void gET()
  {
    AppMethodBeat.i(260346);
    if (this.Nqg != null) {
      this.Nqg.AO(true);
    }
    AppMethodBeat.o(260346);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(260349);
    if (paramBundle == null)
    {
      AppMethodBeat.o(260349);
      return;
    }
    paramInt = paramBundle.getInt("result_key_action", -1);
    if (paramInt < 0)
    {
      AppMethodBeat.o(260349);
      return;
    }
    Log.i("MicroMsg.OpenCustomerServiceChatResultReceiver", "alvinluo startKfConversation onReceiveResult action: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBundle.getInt("result_key_err_code", -1)), paramBundle.getString("result_key_err_msg") });
    if (paramInt == 5)
    {
      this.rUh = true;
      AppMethodBeat.o(260349);
      return;
    }
    if (paramInt == 2)
    {
      gET();
      AppMethodBeat.o(260349);
      return;
    }
    if (paramInt == 4)
    {
      if (!this.rUh)
      {
        gET();
        AppMethodBeat.o(260349);
      }
    }
    else if (paramInt == 3)
    {
      if (this.Nqh != null)
      {
        Log.d("MicroMsg.OpenCustomerServiceChatResultReceiver", "release");
        this.Nqg = null;
        h.ahAA.o(this.Nqh, 600L);
        AppMethodBeat.o(260349);
      }
    }
    else if ((paramInt == 6) && (!this.rUh)) {
      gET();
    }
    AppMethodBeat.o(260349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qrcode.model.OpenCustomerServiceChatResultReceiver
 * JD-Core Version:    0.7.0.1
 */