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

public final class SoterAuthenticationUIWC$a
  extends Handler
{
  private WeakReference<SoterAuthenticationUIWC> mkX;
  
  private SoterAuthenticationUIWC$a(SoterAuthenticationUIWC paramSoterAuthenticationUIWC)
  {
    AppMethodBeat.i(59362);
    this.mkX = null;
    this.mkX = new WeakReference(paramSoterAuthenticationUIWC);
    AppMethodBeat.o(59362);
  }
  
  @TargetApi(23)
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(59363);
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: unidentified msg: %d", new Object[] { Integer.valueOf(paramMessage.what) });
      AppMethodBeat.o(59363);
      return;
    case 0: 
      ab.i("MicroMsg.SoterAuthenticationUIWC", "hy: inform ok");
      paramMessage = (k)paramMessage.obj;
      if ((this.mkX != null) && (this.mkX.get() != null))
      {
        SoterAuthenticationUIWC.a((SoterAuthenticationUIWC)this.mkX.get(), paramMessage);
        AppMethodBeat.o(59363);
        return;
      }
      ab.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
      AppMethodBeat.o(59363);
      return;
    case 1: 
      ab.i("MicroMsg.SoterAuthenticationUIWC", "hy: inform cancel");
      paramMessage = (k)paramMessage.obj;
      if ((this.mkX != null) && (this.mkX.get() != null))
      {
        SoterAuthenticationUIWC.b((SoterAuthenticationUIWC)this.mkX.get(), paramMessage);
        AppMethodBeat.o(59363);
        return;
      }
      ab.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
      AppMethodBeat.o(59363);
      return;
    case 2: 
      ab.i("MicroMsg.SoterAuthenticationUIWC", "hy: inform fail");
      paramMessage = (k)paramMessage.obj;
      if ((this.mkX != null) && (this.mkX.get() != null))
      {
        SoterAuthenticationUIWC.c((SoterAuthenticationUIWC)this.mkX.get(), paramMessage);
        AppMethodBeat.o(59363);
        return;
      }
      ab.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
      AppMethodBeat.o(59363);
      return;
    case 3: 
      ab.i("MicroMsg.SoterAuthenticationUIWC", "hy: request permission");
      if ((this.mkX != null) && (this.mkX.get() != null))
      {
        String[] arrayOfString = paramMessage.getData().getStringArray("permissions");
        int i = paramMessage.getData().getInt("request_code");
        if ((arrayOfString == null) || (arrayOfString.length <= 1))
        {
          ab.e("MicroMsg.SoterAuthenticationUIWC", "hy: permission null");
          AppMethodBeat.o(59363);
          return;
        }
        ((SoterAuthenticationUIWC)this.mkX.get()).requestPermissions(arrayOfString, i);
        AppMethodBeat.o(59363);
        return;
      }
      ab.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
      AppMethodBeat.o(59363);
      return;
    case 4: 
      ab.i("MicroMsg.SoterAuthenticationUIWC", "hy: show progress");
      if ((this.mkX != null) && (this.mkX.get() != null))
      {
        SoterAuthenticationUIWC.a((SoterAuthenticationUIWC)this.mkX.get());
        AppMethodBeat.o(59363);
        return;
      }
      ab.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
      AppMethodBeat.o(59363);
      return;
    case 5: 
      ab.i("MicroMsg.SoterAuthenticationUIWC", "hy: dismiss progress");
      if ((this.mkX != null) && (this.mkX.get() != null))
      {
        SoterAuthenticationUIWC.b((SoterAuthenticationUIWC)this.mkX.get());
        AppMethodBeat.o(59363);
        return;
      }
      ab.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
      AppMethodBeat.o(59363);
      return;
    }
    ab.i("MicroMsg.SoterAuthenticationUIWC", "hy: show dialog");
    if ((this.mkX != null) && (this.mkX.get() != null))
    {
      SoterAuthenticationUIWC.b((b)paramMessage.obj);
      AppMethodBeat.o(59363);
      return;
    }
    ab.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
    AppMethodBeat.o(59363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterAuthenticationUIWC.a
 * JD-Core Version:    0.7.0.1
 */