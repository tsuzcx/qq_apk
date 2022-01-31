package com.tencent.mm.ui.conversation.a;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.a;
import com.tencent.mm.am.a.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public final class m
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements View.OnClickListener
{
  private static int cIv()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return 1;
    }
    PowerManager localPowerManager = (PowerManager)ae.getContext().getSystemService("power");
    try
    {
      boolean bool = localPowerManager.isIgnoringBatteryOptimizations(ae.getContext().getPackageName());
      y.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]app is ignore:" + bool);
      y.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]is device idle mode:" + localPowerManager.isDeviceIdleMode());
      if (!bool) {
        return 2;
      }
      return 3;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MsgDelayTipsBanner", "[oneliang]ignoring battery optimizations check failure.use another way.");
    }
    return 3;
  }
  
  public static void ha(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    switch (cIv())
    {
    default: 
      return;
    case 1: 
    case 3: 
      localObject = Build.BRAND;
      int i;
      if (localObject != null) {
        if (((String)localObject).toLowerCase().startsWith("samsung")) {
          i = R.l.msg_delay_wording_samsung;
        }
      }
      while (i > 0)
      {
        h.a(paramContext, paramContext.getString(i), "", new m.1());
        return;
        if (((String)localObject).toLowerCase().equalsIgnoreCase("huawei"))
        {
          if ((Build.VERSION.SDK_INT == 21) || (Build.VERSION.SDK_INT == 22) || (Build.VERSION.SDK_INT == 23))
          {
            i = R.l.msg_delay_wording_huawei_lm;
            continue;
          }
          if (Build.VERSION.SDK_INT == 24) {
            i = R.l.msg_delay_wording_huawei_n;
          }
        }
        else
        {
          i = R.l.msg_delay_wording_other;
          continue;
        }
        i = R.l.msg_delay_wording_other;
      }
      y.e("MicroMsg.MsgDelayTipsBanner", "[oneliang]impossible......");
      return;
    }
    y.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to add ignore");
    Object localObject = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS").setData(Uri.parse("package:" + ae.getContext().getPackageName()));
    ((Intent)localObject).setFlags(268435456);
    paramContext.startActivity((Intent)localObject);
  }
  
  public static void hb(Context paramContext)
  {
    paramContext.getString(R.l.app_tip);
    localObject2 = h.b(paramContext, paramContext.getString(R.l.app_waiting), true, new m.2());
    Object localObject3 = a.Nw();
    Object localObject1 = new StringBuilder();
    if (localObject3 != null)
    {
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (a.a)((Iterator)localObject3).next();
        ((StringBuilder)localObject1).append(((a.a)localObject4).toString());
        y.i("MicroMsg.MsgDelayTipsBanner", ((a.a)localObject4).toString());
      }
    }
    if (localObject2 != null) {
      ((Dialog)localObject2).dismiss();
    }
    localObject2 = new StringBuilder();
    au.Hx();
    localObject2 = c.Fr() + "/delayedMsg";
    com.tencent.mm.vfs.e.nb((String)localObject2);
    Object localObject4 = new com.tencent.mm.vfs.b((String)localObject2, "data.txt");
    String str = ((StringBuilder)localObject1).toString();
    if (!((com.tencent.mm.vfs.b)localObject4).exists()) {}
    try
    {
      ((com.tencent.mm.vfs.b)localObject4).createNewFile();
      localObject2 = null;
      localObject1 = null;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          localObject3 = com.tencent.mm.vfs.e.q((com.tencent.mm.vfs.b)localObject4);
          localObject1 = localObject3;
          localObject2 = localObject3;
          ((OutputStream)localObject3).write((str + "\n").getBytes("UTF-8"));
          localObject1 = localObject3;
          localObject2 = localObject3;
          ((OutputStream)localObject3).flush();
          if (localObject3 == null) {}
        }
        catch (Exception localException5)
        {
          localObject2 = localException2;
          y.i("MicroMsg.MsgDelayTipsBanner", "exception:" + localException5.getMessage());
          if (localException2 == null) {
            continue;
          }
          try
          {
            localException2.close();
          }
          catch (Exception localException3)
          {
            y.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + localException3.getMessage());
          }
          continue;
        }
        finally
        {
          if (localObject2 == null) {
            continue;
          }
          try
          {
            ((OutputStream)localObject2).close();
            throw paramContext;
          }
          catch (Exception localException4)
          {
            y.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + localException4.getMessage());
            continue;
          }
          localException4.setStatus(3);
          continue;
        }
        try
        {
          ((OutputStream)localObject3).close();
          Toast.makeText(paramContext, com.tencent.mm.vfs.j.n(((com.tencent.mm.vfs.b)localObject4).cLr()), 1).show();
          paramContext = com.tencent.mm.vfs.j.n(((com.tencent.mm.vfs.b)localObject4).cLr());
          localObject1 = new bi();
          ((bi)localObject1).ec("weixin");
          ((bi)localObject1).setContent(paramContext);
          ((bi)localObject1).setType(1);
          ((bi)localObject1).fA(0);
          if (((cs)localObject1).field_isSend == 1)
          {
            ((bi)localObject1).setStatus(4);
            long l = System.currentTimeMillis();
            ((bi)localObject1).bf(l);
            ((bi)localObject1).bg(l);
            ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().T((bi)localObject1);
            return;
            localException1 = localException1;
            y.i("MicroMsg.MsgDelayTipsBanner", "create new file exception:" + localException1.getMessage());
          }
        }
        catch (Exception localException2)
        {
          y.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + localException2.getMessage());
        }
      }
    }
  }
  
  public final boolean apu()
  {
    y.i("MicroMsg.MsgDelayTipsBanner", "refresh banner.");
    com.tencent.mm.kernel.g.DQ();
    boolean bool = com.tencent.mm.kernel.g.DP().Dz().getBoolean(ac.a.uyl, false);
    y.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to show banner:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      if (this.view != null) {
        this.view.setVisibility(0);
      }
    }
    for (;;)
    {
      return super.apu();
      if (this.view != null) {
        this.view.setVisibility(8);
      }
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return R.i.mainframe_banner_header_view;
  }
  
  public final void onClick(View paramView)
  {
    ha((Context)this.sdy.get());
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyl, Boolean.valueOf(false));
    if (this.view != null) {
      this.view.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.m
 * JD-Core Version:    0.7.0.1
 */