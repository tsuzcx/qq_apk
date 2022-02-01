package com.tencent.mm.ui.conversation.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.a.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public final class n
  extends b
  implements View.OnClickListener
{
  private static int fcQ()
  {
    AppMethodBeat.i(38828);
    if (Build.VERSION.SDK_INT < 23)
    {
      AppMethodBeat.o(38828);
      return 1;
    }
    PowerManager localPowerManager = (PowerManager)aj.getContext().getSystemService("power");
    for (;;)
    {
      try
      {
        boolean bool = localPowerManager.isIgnoringBatteryOptimizations(aj.getContext().getPackageName());
        ad.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]app is ignore:".concat(String.valueOf(bool)));
        ad.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]is device idle mode:" + localPowerManager.isDeviceIdleMode());
        if (bool) {
          continue;
        }
        i = 2;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.MsgDelayTipsBanner", "[oneliang]ignoring battery optimizations check failure.use another way.");
        int i = 3;
        continue;
      }
      AppMethodBeat.o(38828);
      return i;
      i = 3;
    }
  }
  
  private static int fcR()
  {
    AppMethodBeat.i(38829);
    String str = Build.BRAND;
    if (str == null)
    {
      AppMethodBeat.o(38829);
      return 2131761356;
    }
    if (str.toLowerCase().startsWith("samsung"))
    {
      AppMethodBeat.o(38829);
      return 2131761357;
    }
    if (str.toLowerCase().equalsIgnoreCase("huawei"))
    {
      if ((Build.VERSION.SDK_INT == 21) || (Build.VERSION.SDK_INT == 22) || (Build.VERSION.SDK_INT == 23))
      {
        AppMethodBeat.o(38829);
        return 2131761354;
      }
      if (Build.VERSION.SDK_INT == 24)
      {
        AppMethodBeat.o(38829);
        return 2131761355;
      }
    }
    else
    {
      AppMethodBeat.o(38829);
      return 2131761356;
    }
    AppMethodBeat.o(38829);
    return 2131761356;
  }
  
  public static void jX(Context paramContext)
  {
    AppMethodBeat.i(38830);
    if (paramContext == null)
    {
      AppMethodBeat.o(38830);
      return;
    }
    switch (fcQ())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38830);
      return;
      int i = fcR();
      if (i > 0)
      {
        com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(i), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38825);
            ad.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]yes");
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            AppMethodBeat.o(38825);
          }
        });
        AppMethodBeat.o(38830);
        return;
      }
      ad.e("MicroMsg.MsgDelayTipsBanner", "[oneliang]impossible......");
      AppMethodBeat.o(38830);
      return;
      ad.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to add ignore");
      Object localObject = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS").setData(Uri.parse("package:" + aj.getContext().getPackageName()));
      ((Intent)localObject).setFlags(268435456);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/conversation/banner/MsgDelayTipsBanner", "showTips", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/conversation/banner/MsgDelayTipsBanner", "showTips", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public static void jY(Context paramContext)
  {
    AppMethodBeat.i(38831);
    paramContext.getString(2131755906);
    localObject2 = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
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
    Object localObject3 = com.tencent.mm.aq.a.axk();
    Object localObject1 = new StringBuilder();
    if (localObject3 != null)
    {
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (a.a)((Iterator)localObject3).next();
        ((StringBuilder)localObject1).append(((a.a)localObject4).toString());
        ad.i("MicroMsg.MsgDelayTipsBanner", ((a.a)localObject4).toString());
      }
    }
    if (localObject2 != null) {
      ((Dialog)localObject2).dismiss();
    }
    localObject2 = new StringBuilder();
    az.arV();
    localObject2 = c.apI() + "/delayedMsg";
    i.aMF((String)localObject2);
    Object localObject4 = new com.tencent.mm.vfs.e((String)localObject2, "data.txt");
    String str = ((StringBuilder)localObject1).toString();
    if (!((com.tencent.mm.vfs.e)localObject4).exists()) {}
    try
    {
      ((com.tencent.mm.vfs.e)localObject4).createNewFile();
      localObject2 = null;
      localObject1 = null;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          localObject3 = i.d((com.tencent.mm.vfs.e)localObject4, false);
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
          ad.i("MicroMsg.MsgDelayTipsBanner", "exception:" + localException5.getMessage());
          if (localException2 == null) {
            continue;
          }
          try
          {
            localException2.close();
          }
          catch (Exception localException3)
          {
            ad.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + localException3.getMessage());
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
            ad.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + localException4.getMessage());
            continue;
          }
          localException4.setStatus(3);
          continue;
        }
        try
        {
          ((OutputStream)localObject3).close();
          Toast.makeText(paramContext, q.B(((com.tencent.mm.vfs.e)localObject4).fhU()), 1).show();
          paramContext = q.B(((com.tencent.mm.vfs.e)localObject4).fhU());
          localObject1 = new bl();
          ((bl)localObject1).nY("weixin");
          ((bl)localObject1).setContent(paramContext);
          ((bl)localObject1).setType(1);
          ((bl)localObject1).jV(0);
          if (((du)localObject1).field_isSend == 1)
          {
            ((bl)localObject1).setStatus(4);
            long l = System.currentTimeMillis();
            ((bl)localObject1).kX(l);
            ((bl)localObject1).kY(l);
            ((k)g.ab(k.class)).cOI().an((bl)localObject1);
            AppMethodBeat.o(38831);
            return;
            localException1 = localException1;
            ad.i("MicroMsg.MsgDelayTipsBanner", "create new file exception:" + localException1.getMessage());
          }
        }
        catch (Exception localException2)
        {
          ad.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + localException2.getMessage());
        }
      }
    }
  }
  
  public final boolean boZ()
  {
    AppMethodBeat.i(38832);
    ad.i("MicroMsg.MsgDelayTipsBanner", "refresh banner.");
    g.afC();
    boolean bool = g.afB().afk().getBoolean(ae.a.Frr, false);
    ad.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to show banner:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      if (this.view != null) {
        this.view.setVisibility(0);
      }
    }
    for (;;)
    {
      bool = super.boZ();
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
    return 2131494686;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38827);
    jX((Context)this.BZM.get());
    g.afC();
    g.afB().afk().set(ae.a.Frr, Boolean.FALSE);
    if (this.view != null) {
      this.view.setVisibility(8);
    }
    AppMethodBeat.o(38827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.n
 * JD-Core Version:    0.7.0.1
 */