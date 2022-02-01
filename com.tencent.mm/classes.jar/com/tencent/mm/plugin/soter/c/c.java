package com.tencent.mm.plugin.soter.c;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mm.plugin.soter.model.g;
import com.tencent.mm.plugin.soter.model.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.core.c.i;
import java.lang.ref.WeakReference;

public abstract class c
{
  protected g RZR = null;
  protected h RZS = null;
  public com.tencent.soter.a.f.e RZT = null;
  public com.tencent.soter.a.f.e RZU = null;
  public a RZV = null;
  protected Handler handler = null;
  public int mScene = -1;
  protected WeakReference<Activity> tLO = null;
  
  public c(WeakReference<Activity> paramWeakReference, g paramg, h paramh, Handler paramHandler)
  {
    this.RZR = paramg;
    this.RZS = paramh;
    this.tLO = paramWeakReference;
    this.handler = paramHandler;
  }
  
  protected final void b(com.tencent.mm.ui.widget.a.e parame)
  {
    if (parame == null)
    {
      Log.e("MicroMsg.SoterMpBaseController", "hy: dialog is null.");
      return;
    }
    if (this.handler != null)
    {
      htr();
      this.handler.obtainMessage(6, parame).sendToTarget();
      return;
    }
    Log.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  public abstract void bB();
  
  protected final void htq()
  {
    if (this.handler != null)
    {
      this.handler.obtainMessage(4).sendToTarget();
      return;
    }
    Log.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void htr()
  {
    if (this.handler != null)
    {
      this.handler.obtainMessage(5).sendToTarget();
      return;
    }
    Log.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void hts()
  {
    if (this.handler != null)
    {
      htr();
      this.handler.obtainMessage(0, this.RZS).sendToTarget();
      return;
    }
    Log.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void htt()
  {
    if (this.handler != null)
    {
      htr();
      this.handler.obtainMessage(1, this.RZS).sendToTarget();
      return;
    }
    Log.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void htu()
  {
    if (this.handler != null)
    {
      htr();
      this.handler.obtainMessage(2, this.RZS).sendToTarget();
      return;
    }
    Log.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
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
    Log.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  public static abstract interface a
  {
    public abstract void a(i parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.c
 * JD-Core Version:    0.7.0.1
 */