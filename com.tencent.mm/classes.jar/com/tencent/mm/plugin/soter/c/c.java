package com.tencent.mm.plugin.soter.c;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.soter.a.f.e;
import com.tencent.soter.core.c.i;
import java.lang.ref.WeakReference;

public abstract class c
{
  protected j AWU = null;
  protected k AWV = null;
  public e AWW = null;
  public e AWX = null;
  public a AWY = null;
  protected Handler handler = null;
  protected WeakReference<Activity> lZK = null;
  public int mScene = -1;
  
  public c(WeakReference<Activity> paramWeakReference, j paramj, k paramk, Handler paramHandler)
  {
    this.AWU = paramj;
    this.AWV = paramk;
    this.lZK = paramWeakReference;
    this.handler = paramHandler;
  }
  
  protected final void b(d paramd)
  {
    if (paramd == null)
    {
      ae.e("MicroMsg.SoterMpBaseController", "hy: dialog is null.");
      return;
    }
    if (this.handler != null)
    {
      eje();
      this.handler.obtainMessage(6, paramd).sendToTarget();
      return;
    }
    ae.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void ejd()
  {
    if (this.handler != null)
    {
      this.handler.obtainMessage(4).sendToTarget();
      return;
    }
    ae.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void eje()
  {
    if (this.handler != null)
    {
      this.handler.obtainMessage(5).sendToTarget();
      return;
    }
    ae.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void ejf()
  {
    if (this.handler != null)
    {
      eje();
      this.handler.obtainMessage(0, this.AWV).sendToTarget();
      return;
    }
    ae.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void ejg()
  {
    if (this.handler != null)
    {
      eje();
      this.handler.obtainMessage(1, this.AWV).sendToTarget();
      return;
    }
    ae.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  protected final void ejh()
  {
    if (this.handler != null)
    {
      eje();
      this.handler.obtainMessage(2, this.AWV).sendToTarget();
      return;
    }
    ae.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
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
    ae.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
  }
  
  public static abstract interface a
  {
    public abstract void a(i parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.c
 * JD-Core Version:    0.7.0.1
 */