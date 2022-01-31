package com.tencent.mm.plugin.soter.ui;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.b;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public final class SoterAuthenticationUI$a
  extends Handler
{
  private WeakReference<SoterAuthenticationUI> jQC = null;
  
  private SoterAuthenticationUI$a(SoterAuthenticationUI paramSoterAuthenticationUI)
  {
    this.jQC = new WeakReference(paramSoterAuthenticationUI);
  }
  
  @TargetApi(23)
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      y.e("MicroMsg.SoterAuthenticationUI", "hy: unidentified msg: %d", new Object[] { Integer.valueOf(paramMessage.what) });
      return;
    case 0: 
      y.i("MicroMsg.SoterAuthenticationUI", "hy: inform ok");
      paramMessage = (k)paramMessage.obj;
      if ((this.jQC != null) && (this.jQC.get() != null))
      {
        SoterAuthenticationUI.a((SoterAuthenticationUI)this.jQC.get(), paramMessage);
        return;
      }
      y.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
      return;
    case 1: 
      y.i("MicroMsg.SoterAuthenticationUI", "hy: inform cancel");
      paramMessage = (k)paramMessage.obj;
      if ((this.jQC != null) && (this.jQC.get() != null))
      {
        SoterAuthenticationUI.b((SoterAuthenticationUI)this.jQC.get(), paramMessage);
        return;
      }
      y.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
      return;
    case 2: 
      y.i("MicroMsg.SoterAuthenticationUI", "hy: inform fail");
      paramMessage = (k)paramMessage.obj;
      if ((this.jQC != null) && (this.jQC.get() != null))
      {
        SoterAuthenticationUI.c((SoterAuthenticationUI)this.jQC.get(), paramMessage);
        return;
      }
      y.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
      return;
    case 3: 
      y.i("MicroMsg.SoterAuthenticationUI", "hy: request permission");
      if ((this.jQC != null) && (this.jQC.get() != null))
      {
        String[] arrayOfString = paramMessage.getData().getStringArray("permissions");
        int i = paramMessage.getData().getInt("request_code");
        if ((arrayOfString == null) || (arrayOfString.length <= 1))
        {
          y.e("MicroMsg.SoterAuthenticationUI", "hy: permission null");
          return;
        }
        ((SoterAuthenticationUI)this.jQC.get()).requestPermissions(arrayOfString, i);
        return;
      }
      y.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
      return;
    case 4: 
      y.i("MicroMsg.SoterAuthenticationUI", "hy: show progress");
      if ((this.jQC != null) && (this.jQC.get() != null))
      {
        SoterAuthenticationUI.a((SoterAuthenticationUI)this.jQC.get());
        return;
      }
      y.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
      return;
    case 5: 
      y.i("MicroMsg.SoterAuthenticationUI", "hy: dismiss progress");
      if ((this.jQC != null) && (this.jQC.get() != null))
      {
        SoterAuthenticationUI.b((SoterAuthenticationUI)this.jQC.get());
        return;
      }
      y.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
      return;
    }
    y.i("MicroMsg.SoterAuthenticationUI", "hy: show dialog");
    if ((this.jQC != null) && (this.jQC.get() != null))
    {
      SoterAuthenticationUI.b((b)paramMessage.obj);
      return;
    }
    y.w("MicroMsg.SoterAuthenticationUI", "hy: ui cleared");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterAuthenticationUI.a
 * JD-Core Version:    0.7.0.1
 */