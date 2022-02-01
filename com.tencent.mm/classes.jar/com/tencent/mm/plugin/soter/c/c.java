package com.tencent.mm.plugin.soter.c;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.soter.a.f.e;
import com.tencent.soter.core.c.i;
import java.lang.ref.WeakReference;

public abstract class c
{
  protected j AFr = null;
  protected k AFs = null;
  public e AFt = null;
  public e AFu = null;
  public a AFv = null;
  protected Handler handler = null;
  protected WeakReference<Activity> lVh = null;
  public int mScene = -1;
  
  public c(WeakReference<Activity> paramWeakReference, j paramj, k paramk, Handler paramHandler)
  {
    this.AFr = paramj;
    this.AFs = paramk;
    this.lVh = paramWeakReference;
    this.handler = paramHandler;
  }
  
  protected final void b(d paramd)
  {
    if (paramd == null)
    {
      ad.e("MicroMsg.SoterMpBaseController", "hy: dialog is null.");
      return;
    }
    if (this.handler != null)
    {
      efw();
      this.handler.obtainMessage(6, paramd).sendToTarget();
      return;
    }
    ad.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void efv()
  {
    if (this.handler != null)
    {
      this.handler.obtainMessage(4).sendToTarget();
      return;
    }
    ad.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void efw()
  {
    if (this.handler != null)
    {
      this.handler.obtainMessage(5).sendToTarget();
      return;
    }
    ad.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void efx()
  {
    if (this.handler != null)
    {
      efw();
      this.handler.obtainMessage(0, this.AFs).sendToTarget();
      return;
    }
    ad.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void efy()
  {
    if (this.handler != null)
    {
      efw();
      this.handler.obtainMessage(1, this.AFs).sendToTarget();
      return;
    }
    ad.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void efz()
  {
    if (this.handler != null)
    {
      efw();
      this.handler.obtainMessage(2, this.AFs).sendToTarget();
      return;
    }
    ad.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  public abstract void gt();
  
  public abstract void onPause();
  
  public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void onResume();
  
  protected final void requestPermissions(String[] paramArrayOfString, int paramInt)
  {
    if (this.handler != null)
    {
      Message localMessage = this.handler.obtainMessage(3);
      Bundle localBundle = new Bundle();
      localBundle.putStringArray("permissions", paramArrayOfString);
      localBundle.putInt("request_code", paramInt);
      localMessage.setData(localBundle);
      localMessage.sendToTarget();
      return;
    }
    ad.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  public static abstract interface a
  {
    public abstract void a(i parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.c
 * JD-Core Version:    0.7.0.1
 */