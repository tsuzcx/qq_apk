package com.tencent.mm.plugin.soter.c;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.soter.a.f.e;
import com.tencent.soter.core.c.i;
import java.lang.ref.WeakReference;

public abstract class c
{
  protected Handler handler = null;
  protected WeakReference<Activity> lvU = null;
  public int mScene = -1;
  public e znA = null;
  public a znB = null;
  protected j znx = null;
  protected k zny = null;
  public e znz = null;
  
  public c(WeakReference<Activity> paramWeakReference, j paramj, k paramk, Handler paramHandler)
  {
    this.znx = paramj;
    this.zny = paramk;
    this.lvU = paramWeakReference;
    this.handler = paramHandler;
  }
  
  protected final void b(d paramd)
  {
    if (paramd == null)
    {
      ac.e("MicroMsg.SoterMpBaseController", "hy: dialog is null.");
      return;
    }
    if (this.handler != null)
    {
      dTi();
      this.handler.obtainMessage(6, paramd).sendToTarget();
      return;
    }
    ac.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void dTh()
  {
    if (this.handler != null)
    {
      this.handler.obtainMessage(4).sendToTarget();
      return;
    }
    ac.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void dTi()
  {
    if (this.handler != null)
    {
      this.handler.obtainMessage(5).sendToTarget();
      return;
    }
    ac.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void dTj()
  {
    if (this.handler != null)
    {
      dTi();
      this.handler.obtainMessage(0, this.zny).sendToTarget();
      return;
    }
    ac.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void dTk()
  {
    if (this.handler != null)
    {
      dTi();
      this.handler.obtainMessage(1, this.zny).sendToTarget();
      return;
    }
    ac.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void dTl()
  {
    if (this.handler != null)
    {
      dTi();
      this.handler.obtainMessage(2, this.zny).sendToTarget();
      return;
    }
    ac.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  public abstract void gb();
  
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
    ac.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
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