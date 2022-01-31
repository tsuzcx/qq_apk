package com.tencent.mm.plugin.soter.ui;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

public final class SoterAuthenticationUI$a
  extends Handler
{
  private WeakReference<SoterAuthenticationUI> mkX;
  
  private SoterAuthenticationUI$a(SoterAuthenticationUI paramSoterAuthenticationUI)
  {
    AppMethodBeat.i(73897);
    this.mkX = null;
    this.mkX = new WeakReference(paramSoterAuthenticationUI);
    AppMethodBeat.o(73897);
  }
  
  @TargetApi(23)
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(73898);
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      ab.e("MicroMsg.SoterAuthenticationUI", "hy: unidentified msg: %d", new Object[] { Integer.valueOf(paramMessage.what) });
      AppMethodBeat.o(73898);
      return;
    case 0: 
      ab.i("MicroMsg.SoterAuthenticationUI", "hy: inform ok");
      paramMessage = (k)paramMessage.obj;
      if ((this.mkX != null) && (this.mkX.get() != null))
      {
        SoterAuthenticationUI.a((SoterAuthenticationUI)this.mkX.get(), paramMessage);
        AppMethodBeat.o(73898);
        return;
      }
      ab.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
      AppMethodBeat.o(73898);
      return;
    case 1: 
      ab.i("MicroMsg.SoterAuthenticationUI", "hy: inform cancel");
      paramMessage = (k)paramMessage.obj;
      if ((this.mkX != null) && (this.mkX.get() != null))
      {
        SoterAuthenticationUI.b((SoterAuthenticationUI)this.mkX.get(), paramMessage);
        AppMethodBeat.o(73898);
        return;
      }
      ab.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
      AppMethodBeat.o(73898);
      return;
    case 2: 
      ab.i("MicroMsg.SoterAuthenticationUI", "hy: inform fail");
      paramMessage = (k)paramMessage.obj;
      if ((this.mkX != null) && (this.mkX.get() != null))
      {
        SoterAuthenticationUI.c((SoterAuthenticationUI)this.mkX.get(), paramMessage);
        AppMethodBeat.o(73898);
        return;
      }
      ab.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
      AppMethodBeat.o(73898);
      return;
    case 3: 
      ab.i("MicroMsg.SoterAuthenticationUI", "hy: request permission");
      if ((this.mkX != null) && (this.mkX.get() != null))
      {
        String[] arrayOfString = paramMessage.getData().getStringArray("permissions");
        int i = paramMessage.getData().getInt("request_code");
        if ((arrayOfString == null) || (arrayOfString.length <= 1))
        {
          ab.e("MicroMsg.SoterAuthenticationUI", "hy: permission null");
          AppMethodBeat.o(73898);
          return;
        }
        ((SoterAuthenticationUI)this.mkX.get()).requestPermissions(arrayOfString, i);
        AppMethodBeat.o(73898);
        return;
      }
      ab.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
      AppMethodBeat.o(73898);
      return;
    case 4: 
      ab.i("MicroMsg.SoterAuthenticationUI", "hy: show progress");
      if ((this.mkX != null) && (this.mkX.get() != null))
      {
        SoterAuthenticationUI.a((SoterAuthenticationUI)this.mkX.get());
        AppMethodBeat.o(73898);
        return;
      }
      ab.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
      AppMethodBeat.o(73898);
      return;
    case 5: 
      ab.i("MicroMsg.SoterAuthenticationUI", "hy: dismiss progress");
      if ((this.mkX != null) && (this.mkX.get() != null))
      {
        SoterAuthenticationUI.b((SoterAuthenticationUI)this.mkX.get());
        AppMethodBeat.o(73898);
        return;
      }
      ab.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
      AppMethodBeat.o(73898);
      return;
    }
    ab.i("MicroMsg.SoterAuthenticationUI", "hy: show dialog");
    if ((this.mkX != null) && (this.mkX.get() != null))
    {
      SoterAuthenticationUI.b((b)paramMessage.obj);
      AppMethodBeat.o(73898);
      return;
    }
    ab.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
    AppMethodBeat.o(73898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterAuthenticationUI.a
 * JD-Core Version:    0.7.0.1
 */