package com.tencent.mm.ui.conversation.a;

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
import com.tencent.mm.an.a;
import com.tencent.mm.an.a.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public final class n
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements View.OnClickListener
{
  private static int dNc()
  {
    AppMethodBeat.i(34702);
    if (Build.VERSION.SDK_INT < 23)
    {
      AppMethodBeat.o(34702);
      return 1;
    }
    PowerManager localPowerManager = (PowerManager)ah.getContext().getSystemService("power");
    for (;;)
    {
      try
      {
        boolean bool = localPowerManager.isIgnoringBatteryOptimizations(ah.getContext().getPackageName());
        ab.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]app is ignore:".concat(String.valueOf(bool)));
        ab.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]is device idle mode:" + localPowerManager.isDeviceIdleMode());
        if (bool) {
          continue;
        }
        i = 2;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.MsgDelayTipsBanner", "[oneliang]ignoring battery optimizations check failure.use another way.");
        int i = 3;
        continue;
      }
      AppMethodBeat.o(34702);
      return i;
      i = 3;
    }
  }
  
  private static int dNd()
  {
    AppMethodBeat.i(34703);
    String str = Build.BRAND;
    if (str == null)
    {
      AppMethodBeat.o(34703);
      return 2131306194;
    }
    if (str.toLowerCase().startsWith("samsung"))
    {
      AppMethodBeat.o(34703);
      return 2131306195;
    }
    if (str.toLowerCase().equalsIgnoreCase("huawei"))
    {
      if ((Build.VERSION.SDK_INT == 21) || (Build.VERSION.SDK_INT == 22) || (Build.VERSION.SDK_INT == 23))
      {
        AppMethodBeat.o(34703);
        return 2131306192;
      }
      if (Build.VERSION.SDK_INT == 24)
      {
        AppMethodBeat.o(34703);
        return 2131306193;
      }
    }
    else
    {
      AppMethodBeat.o(34703);
      return 2131306194;
    }
    AppMethodBeat.o(34703);
    return 2131306194;
  }
  
  public static void iv(Context paramContext)
  {
    AppMethodBeat.i(34704);
    if (paramContext == null)
    {
      AppMethodBeat.o(34704);
      return;
    }
    switch (dNc())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34704);
      return;
      int i = dNd();
      if (i > 0)
      {
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(i), "", new n.1());
        AppMethodBeat.o(34704);
        return;
      }
      ab.e("MicroMsg.MsgDelayTipsBanner", "[oneliang]impossible......");
      AppMethodBeat.o(34704);
      return;
      ab.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to add ignore");
      Intent localIntent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS").setData(Uri.parse("package:" + ah.getContext().getPackageName()));
      localIntent.setFlags(268435456);
      paramContext.startActivity(localIntent);
    }
  }
  
  public static void iw(Context paramContext)
  {
    AppMethodBeat.i(34705);
    paramContext.getString(2131297087);
    localObject2 = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131297112), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(34700);
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.dismiss();
        }
        AppMethodBeat.o(34700);
      }
    });
    Object localObject3 = a.agj();
    Object localObject1 = new StringBuilder();
    if (localObject3 != null)
    {
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (a.a)((Iterator)localObject3).next();
        ((StringBuilder)localObject1).append(((a.a)localObject4).toString());
        ab.i("MicroMsg.MsgDelayTipsBanner", ((a.a)localObject4).toString());
      }
    }
    if (localObject2 != null) {
      ((Dialog)localObject2).dismiss();
    }
    localObject2 = new StringBuilder();
    aw.aaz();
    localObject2 = c.Yv() + "/delayedMsg";
    com.tencent.mm.vfs.e.um((String)localObject2);
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
          localObject3 = com.tencent.mm.vfs.e.s((com.tencent.mm.vfs.b)localObject4);
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
          ab.i("MicroMsg.MsgDelayTipsBanner", "exception:" + localException5.getMessage());
          if (localException2 == null) {
            continue;
          }
          try
          {
            localException2.close();
          }
          catch (Exception localException3)
          {
            ab.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + localException3.getMessage());
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
            AppMethodBeat.o(34705);
            throw paramContext;
          }
          catch (Exception localException4)
          {
            ab.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + localException4.getMessage());
            continue;
          }
          localException4.setStatus(3);
          continue;
        }
        try
        {
          ((OutputStream)localObject3).close();
          Toast.makeText(paramContext, com.tencent.mm.vfs.j.p(((com.tencent.mm.vfs.b)localObject4).dQJ()), 1).show();
          paramContext = com.tencent.mm.vfs.j.p(((com.tencent.mm.vfs.b)localObject4).dQJ());
          localObject1 = new bi();
          ((bi)localObject1).kj("weixin");
          ((bi)localObject1).setContent(paramContext);
          ((bi)localObject1).setType(1);
          ((bi)localObject1).hL(0);
          if (((dd)localObject1).field_isSend == 1)
          {
            ((bi)localObject1).setStatus(4);
            long l = System.currentTimeMillis();
            ((bi)localObject1).fP(l);
            ((bi)localObject1).fQ(l);
            ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Z((bi)localObject1);
            AppMethodBeat.o(34705);
            return;
            localException1 = localException1;
            ab.i("MicroMsg.MsgDelayTipsBanner", "create new file exception:" + localException1.getMessage());
          }
        }
        catch (Exception localException2)
        {
          ab.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + localException2.getMessage());
        }
      }
    }
  }
  
  public final boolean aMK()
  {
    AppMethodBeat.i(34706);
    ab.i("MicroMsg.MsgDelayTipsBanner", "refresh banner.");
    g.RM();
    boolean bool = g.RL().Ru().getBoolean(ac.a.yIv, false);
    ab.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to show banner:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      if (this.view != null) {
        this.view.setVisibility(0);
      }
    }
    for (;;)
    {
      bool = super.aMK();
      AppMethodBeat.o(34706);
      return bool;
      if (this.view != null) {
        this.view.setVisibility(8);
      }
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2130970072;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34701);
    iv((Context)this.vUD.get());
    g.RM();
    g.RL().Ru().set(ac.a.yIv, Boolean.FALSE);
    if (this.view != null) {
      this.view.setVisibility(8);
    }
    AppMethodBeat.o(34701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.n
 * JD-Core Version:    0.7.0.1
 */