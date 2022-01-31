package com.tencent.mm.plugin.soter.ui;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.b;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public final class SoterAuthenticationUIWC$a
  extends Handler
{
  private WeakReference<SoterAuthenticationUIWC> jQC = null;
  
  private SoterAuthenticationUIWC$a(SoterAuthenticationUIWC paramSoterAuthenticationUIWC)
  {
    this.jQC = new WeakReference(paramSoterAuthenticationUIWC);
  }
  
  @TargetApi(23)
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      y.e("MicroMsg.SoterAuthenticationUIWC", "hy: unidentified msg: %d", new Object[] { Integer.valueOf(paramMessage.what) });
      return;
    case 0: 
      y.i("MicroMsg.SoterAuthenticationUIWC", "hy: inform ok");
      paramMessage = (k)paramMessage.obj;
      if ((this.jQC != null) && (this.jQC.get() != null))
      {
        SoterAuthenticationUIWC.a((SoterAuthenticationUIWC)this.jQC.get(), paramMessage);
        return;
      }
      y.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
      return;
    case 1: 
      y.i("MicroMsg.SoterAuthenticationUIWC", "hy: inform cancel");
      paramMessage = (k)paramMessage.obj;
      if ((this.jQC != null) && (this.jQC.get() != null))
      {
        SoterAuthenticationUIWC.b((SoterAuthenticationUIWC)this.jQC.get(), paramMessage);
        return;
      }
      y.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
      return;
    case 2: 
      y.i("MicroMsg.SoterAuthenticationUIWC", "hy: inform fail");
      paramMessage = (k)paramMessage.obj;
      if ((this.jQC != null) && (this.jQC.get() != null))
      {
        SoterAuthenticationUIWC.c((SoterAuthenticationUIWC)this.jQC.get(), paramMessage);
        return;
      }
      y.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
      return;
    case 3: 
      y.i("MicroMsg.SoterAuthenticationUIWC", "hy: request permission");
      if ((this.jQC != null) && (this.jQC.get() != null))
      {
        String[] arrayOfString = paramMessage.getData().getStringArray("permissions");
        int i = paramMessage.getData().getInt("request_code");
        if ((arrayOfString == null) || (arrayOfString.length <= 1))
        {
          y.e("MicroMsg.SoterAuthenticationUIWC", "hy: permission null");
          return;
        }
        ((SoterAuthenticationUIWC)this.jQC.get()).requestPermissions(arrayOfString, i);
        return;
      }
      y.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
      return;
    case 4: 
      y.i("MicroMsg.SoterAuthenticationUIWC", "hy: show progress");
      if ((this.jQC != null) && (this.jQC.get() != null))
      {
        SoterAuthenticationUIWC.a((SoterAuthenticationUIWC)this.jQC.get());
        return;
      }
      y.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
      return;
    case 5: 
      y.i("MicroMsg.SoterAuthenticationUIWC", "hy: dismiss progress");
      if ((this.jQC != null) && (this.jQC.get() != null))
      {
        SoterAuthenticationUIWC.b((SoterAuthenticationUIWC)this.jQC.get());
        return;
      }
      y.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
      return;
    }
    y.i("MicroMsg.SoterAuthenticationUIWC", "hy: show dialog");
    if ((this.jQC != null) && (this.jQC.get() != null))
    {
      SoterAuthenticationUIWC.b((b)paramMessage.obj);
      return;
    }
    y.w("MicroMsg.SoterAuthenticationUIWC", "hy: ui cleared");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterAuthenticationUIWC.a
 * JD-Core Version:    0.7.0.1
 */