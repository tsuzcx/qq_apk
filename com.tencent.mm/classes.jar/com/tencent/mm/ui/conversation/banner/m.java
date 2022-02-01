package com.tencent.mm.ui.conversation.banner;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.aq.a.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public final class m
  extends com.tencent.mm.pluginsdk.ui.a.b
  implements View.OnClickListener
{
  private static int jBe()
  {
    AppMethodBeat.i(38828);
    if (Build.VERSION.SDK_INT < 23)
    {
      AppMethodBeat.o(38828);
      return 1;
    }
    PowerManager localPowerManager = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
    for (;;)
    {
      try
      {
        boolean bool = localPowerManager.isIgnoringBatteryOptimizations(MMApplicationContext.getContext().getPackageName());
        Log.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]app is ignore:".concat(String.valueOf(bool)));
        Log.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]is device idle mode:" + localPowerManager.isDeviceIdleMode());
        if (bool) {
          continue;
        }
        i = 2;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MsgDelayTipsBanner", "[oneliang]ignoring battery optimizations check failure.use another way.");
        int i = 3;
        continue;
      }
      AppMethodBeat.o(38828);
      return i;
      i = 3;
    }
  }
  
  private static int jBf()
  {
    AppMethodBeat.i(38829);
    String str = Build.BRAND;
    if (str == null)
    {
      i = R.l.gNY;
      AppMethodBeat.o(38829);
      return i;
    }
    if (str.toLowerCase().startsWith("samsung"))
    {
      i = R.l.gNZ;
      AppMethodBeat.o(38829);
      return i;
    }
    if (str.toLowerCase().equalsIgnoreCase("huawei"))
    {
      if ((Build.VERSION.SDK_INT == 21) || (Build.VERSION.SDK_INT == 22) || (Build.VERSION.SDK_INT == 23))
      {
        i = R.l.gNW;
        AppMethodBeat.o(38829);
        return i;
      }
      if (Build.VERSION.SDK_INT == 24)
      {
        i = R.l.gNX;
        AppMethodBeat.o(38829);
        return i;
      }
    }
    else
    {
      i = R.l.gNY;
      AppMethodBeat.o(38829);
      return i;
    }
    int i = R.l.gNY;
    AppMethodBeat.o(38829);
    return i;
  }
  
  public static void nx(Context paramContext)
  {
    AppMethodBeat.i(38830);
    if (paramContext == null)
    {
      AppMethodBeat.o(38830);
      return;
    }
    switch (jBe())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38830);
      return;
      int i = jBf();
      if (i > 0)
      {
        k.d(paramContext, paramContext.getString(i), "", new m.1());
        AppMethodBeat.o(38830);
        return;
      }
      Log.e("MicroMsg.MsgDelayTipsBanner", "[oneliang]impossible......");
      AppMethodBeat.o(38830);
      return;
      Log.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to add ignore");
      Object localObject = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS").setData(Uri.parse("package:" + MMApplicationContext.getContext().getPackageName()));
      ((Intent)localObject).setFlags(268435456);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/conversation/banner/MsgDelayTipsBanner", "showTips", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/conversation/banner/MsgDelayTipsBanner", "showTips", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public static void ny(Context paramContext)
  {
    AppMethodBeat.i(38831);
    paramContext.getString(R.l.app_tip);
    localObject2 = k.a(paramContext, paramContext.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(38826);
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.dismiss();
        }
        AppMethodBeat.o(38826);
      }
    });
    Object localObject3 = com.tencent.mm.aq.a.bIB();
    Object localObject1 = new StringBuilder();
    if (localObject3 != null)
    {
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (a.a)((Iterator)localObject3).next();
        ((StringBuilder)localObject1).append(((a.a)localObject4).toString());
        Log.i("MicroMsg.MsgDelayTipsBanner", ((a.a)localObject4).toString());
      }
    }
    if (localObject2 != null) {
      ((Dialog)localObject2).dismiss();
    }
    localObject2 = new StringBuilder();
    bh.bCz();
    localObject2 = c.bzv() + "/delayedMsg";
    y.bDX((String)localObject2);
    Object localObject4 = new u((String)localObject2, "data.txt");
    String str = ((StringBuilder)localObject1).toString();
    if (!((u)localObject4).jKS()) {}
    try
    {
      ((u)localObject4).jKZ();
      localObject2 = null;
      localObject1 = null;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          localObject3 = y.e((u)localObject4, false);
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
          Log.i("MicroMsg.MsgDelayTipsBanner", "exception:" + localException5.getMessage());
          if (localException2 == null) {
            continue;
          }
          try
          {
            localException2.close();
          }
          catch (Exception localException3)
          {
            Log.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + localException3.getMessage());
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
            AppMethodBeat.o(38831);
            throw paramContext;
          }
          catch (Exception localException4)
          {
            Log.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + localException4.getMessage());
            continue;
          }
          localException4.setStatus(3);
          continue;
        }
        try
        {
          ((OutputStream)localObject3).close();
          Toast.makeText(paramContext, ah.v(((u)localObject4).jKT()), 1).show();
          paramContext = ah.v(((u)localObject4).jKT());
          localObject1 = new cc();
          ((cc)localObject1).BS("weixin");
          ((cc)localObject1).setContent(paramContext);
          ((cc)localObject1).setType(1);
          ((cc)localObject1).pI(0);
          if (((fi)localObject1).field_isSend == 1)
          {
            ((cc)localObject1).setStatus(4);
            long l = System.currentTimeMillis();
            ((cc)localObject1).gX(l);
            ((cc)localObject1).setCreateTime(l);
            ((n)h.ax(n.class)).gaZ().ba((cc)localObject1);
            AppMethodBeat.o(38831);
            return;
            localException1 = localException1;
            Log.i("MicroMsg.MsgDelayTipsBanner", "create new file exception:" + localException1.getMessage());
          }
        }
        catch (Exception localException2)
        {
          Log.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + localException2.getMessage());
        }
      }
    }
  }
  
  public final boolean cMa()
  {
    AppMethodBeat.i(38832);
    Log.i("MicroMsg.MsgDelayTipsBanner", "refresh banner.");
    h.baF();
    boolean bool = h.baE().ban().getBoolean(at.a.acUj, false);
    Log.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to show banner:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      if (this.view != null) {
        this.view.setVisibility(0);
      }
    }
    for (;;)
    {
      bool = super.cMa();
      AppMethodBeat.o(38832);
      return bool;
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
    AppMethodBeat.i(38827);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/MsgDelayTipsBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    nx((Context)this.Ydi.get());
    h.baF();
    h.baE().ban().set(at.a.acUj, Boolean.FALSE);
    if (this.view != null) {
      this.view.setVisibility(8);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MsgDelayTipsBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(38827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.banner.m
 * JD-Core Version:    0.7.0.1
 */