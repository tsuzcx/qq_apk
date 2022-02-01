package com.tencent.mm.plugin.soter.c;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.soter.a.f.e;
import com.tencent.soter.core.c.i;
import java.lang.ref.WeakReference;

public abstract class c
{
  protected j Lws = null;
  protected k Lwt = null;
  public e Lwu = null;
  public e Lwv = null;
  public a Lww = null;
  protected Handler handler = null;
  public int mScene = -1;
  protected WeakReference<Activity> qHe = null;
  
  public c(WeakReference<Activity> paramWeakReference, j paramj, k paramk, Handler paramHandler)
  {
    this.Lws = paramj;
    this.Lwt = paramk;
    this.qHe = paramWeakReference;
    this.handler = paramHandler;
  }
  
  public abstract void aI();
  
  protected final void b(d paramd)
  {
    if (paramd == null)
    {
      Log.e("MicroMsg.SoterMpBaseController", "hy: dialog is null.");
      return;
    }
    if (this.handler != null)
    {
      gaa();
      this.handler.obtainMessage(6, paramd).sendToTarget();
      return;
    }
    Log.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void fZZ()
  {
    if (this.handler != null)
    {
      this.handler.obtainMessage(4).sendToTarget();
      return;
    }
    Log.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void gaa()
  {
    if (this.handler != null)
    {
      this.handler.obtainMessage(5).sendToTarget();
      return;
    }
    Log.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void gab()
  {
    if (this.handler != null)
    {
      gaa();
      this.handler.obtainMessage(0, this.Lwt).sendToTarget();
      return;
    }
    Log.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void gac()
  {
    if (this.handler != null)
    {
      gaa();
      this.handler.obtainMessage(1, this.Lwt).sendToTarget();
      return;
    }
    Log.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void gad()
  {
    if (this.handler != null)
    {
      gaa();
      this.handler.obtainMessage(2, this.Lwt).sendToTarget();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.c
 * JD-Core Version:    0.7.0.1
 */