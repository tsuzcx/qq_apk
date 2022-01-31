package com.tencent.mm.plugin.soter.c;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.b;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.f.e;
import java.lang.ref.WeakReference;

public abstract class c
{
  protected Handler handler = null;
  protected WeakReference<Activity> hkv = null;
  public int mScene = -1;
  protected j sog = null;
  protected k soh = null;
  public e soi = null;
  public e soj = null;
  public c.a sok = null;
  
  public c(WeakReference<Activity> paramWeakReference, j paramj, k paramk, Handler paramHandler)
  {
    this.sog = paramj;
    this.soh = paramk;
    this.hkv = paramWeakReference;
    this.handler = paramHandler;
  }
  
  protected final void G(String[] paramArrayOfString)
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
    ab.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void a(b paramb)
  {
    if (paramb == null)
    {
      ab.e("MicroMsg.SoterMpBaseController", "hy: dialog is null.");
      return;
    }
    if (this.handler != null)
    {
      cxV();
      this.handler.obtainMessage(6, paramb).sendToTarget();
      return;
    }
    ab.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void cxU()
  {
    if (this.handler != null)
    {
      this.handler.obtainMessage(4).sendToTarget();
      return;
    }
    ab.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void cxV()
  {
    if (this.handler != null)
    {
      this.handler.obtainMessage(5).sendToTarget();
      return;
    }
    ab.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void cxW()
  {
    if (this.handler != null)
    {
      cxV();
      this.handler.obtainMessage(0, this.soh).sendToTarget();
      return;
    }
    ab.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void cxX()
  {
    if (this.handler != null)
    {
      cxV();
      this.handler.obtainMessage(1, this.soh).sendToTarget();
      return;
    }
    ab.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void cxY()
  {
    if (this.handler != null)
    {
      cxV();
      this.handler.obtainMessage(2, this.soh).sendToTarget();
      return;
    }
    ab.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  public abstract void eB();
  
  public abstract void onPause();
  
  public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void onResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.c
 * JD-Core Version:    0.7.0.1
 */