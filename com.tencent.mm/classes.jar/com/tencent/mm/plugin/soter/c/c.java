package com.tencent.mm.plugin.soter.c;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.b;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.a.f.e;
import java.lang.ref.WeakReference;

public abstract class c
{
  protected WeakReference<Activity> fOk = null;
  public int fzn = -1;
  protected Handler handler = null;
  protected j pse = null;
  protected k psf = null;
  public e psg = null;
  public e psh = null;
  public c.a psi = null;
  
  public c(WeakReference<Activity> paramWeakReference, j paramj, k paramk, Handler paramHandler)
  {
    this.pse = paramj;
    this.psf = paramk;
    this.fOk = paramWeakReference;
    this.handler = paramHandler;
  }
  
  protected final void A(String[] paramArrayOfString)
  {
    if (this.handler != null)
    {
      Message localMessage = this.handler.obtainMessage(3);
      Bundle localBundle = new Bundle();
      localBundle.putStringArray("permissions", paramArrayOfString);
      localBundle.putInt("request_code", 0);
      localMessage.setData(localBundle);
      localMessage.sendToTarget();
      return;
    }
    y.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void a(b paramb)
  {
    if (paramb == null)
    {
      y.e("MicroMsg.SoterMpBaseController", "hy: dialog is null.");
      return;
    }
    if (this.handler != null)
    {
      bKJ();
      this.handler.obtainMessage(6, paramb).sendToTarget();
      return;
    }
    y.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void bKI()
  {
    if (this.handler != null)
    {
      this.handler.obtainMessage(4).sendToTarget();
      return;
    }
    y.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void bKJ()
  {
    if (this.handler != null)
    {
      this.handler.obtainMessage(5).sendToTarget();
      return;
    }
    y.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void bKK()
  {
    if (this.handler != null)
    {
      bKJ();
      this.handler.obtainMessage(0, this.psf).sendToTarget();
      return;
    }
    y.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void bKL()
  {
    if (this.handler != null)
    {
      bKJ();
      this.handler.obtainMessage(1, this.psf).sendToTarget();
      return;
    }
    y.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void bKM()
  {
    if (this.handler != null)
    {
      bKJ();
      this.handler.obtainMessage(2, this.psf).sendToTarget();
      return;
    }
    y.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  public abstract void ef();
  
  public abstract void onPause();
  
  public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void onResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.c
 * JD-Core Version:    0.7.0.1
 */