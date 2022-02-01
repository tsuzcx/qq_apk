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
import com.tencent.mm.ap.a.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public final class n
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements View.OnClickListener
{
  private static int gWk()
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
  
  private static int gWl()
  {
    AppMethodBeat.i(38829);
    String str = Build.BRAND;
    if (str == null)
    {
      AppMethodBeat.o(38829);
      return 2131763184;
    }
    if (str.toLowerCase().startsWith("samsung"))
    {
      AppMethodBeat.o(38829);
      return 2131763185;
    }
    if (str.toLowerCase().equalsIgnoreCase("huawei"))
    {
      if ((Build.VERSION.SDK_INT == 21) || (Build.VERSION.SDK_INT == 22) || (Build.VERSION.SDK_INT == 23))
      {
        AppMethodBeat.o(38829);
        return 2131763182;
      }
      if (Build.VERSION.SDK_INT == 24)
      {
        AppMethodBeat.o(38829);
        return 2131763183;
      }
    }
    else
    {
      AppMethodBeat.o(38829);
      return 2131763184;
    }
    AppMethodBeat.o(38829);
    return 2131763184;
  }
  
  public static void kv(Context paramContext)
  {
    AppMethodBeat.i(38830);
    if (paramContext == null)
    {
      AppMethodBeat.o(38830);
      return;
    }
    switch (gWk())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38830);
      return;
      int i = gWl();
      if (i > 0)
      {
        h.d(paramContext, paramContext.getString(i), "", new n.1());
        AppMethodBeat.o(38830);
        return;
      }
      Log.e("MicroMsg.MsgDelayTipsBanner", "[oneliang]impossible......");
      AppMethodBeat.o(38830);
      return;
      Log.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to add ignore");
      Object localObject = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS").setData(Uri.parse("package:" + MMApplicationContext.getContext().getPackageName()));
      ((Intent)localObject).setFlags(268435456);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/conversation/banner/MsgDelayTipsBanner", "showTips", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/conversation/banner/MsgDelayTipsBanner", "showTips", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public static void kw(Context paramContext)
  {
    AppMethodBeat.i(38831);
    paramContext.getString(2131755998);
    localObject2 = h.a(paramContext, paramContext.getString(2131756029), true, new DialogInterface.OnCancelListener()
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
    Object localObject3 = com.tencent.mm.ap.a.bbr();
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
    bg.aVF();
    localObject2 = c.aSJ() + "/delayedMsg";
    s.boN((String)localObject2);
    Object localObject4 = new o((String)localObject2, "data.txt");
    String str = ((StringBuilder)localObject1).toString();
    if (!((o)localObject4).exists()) {}
    try
    {
      ((o)localObject4).createNewFile();
      localObject2 = null;
      localObject1 = null;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          localObject3 = s.d((o)localObject4, false);
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
          Toast.makeText(paramContext, aa.z(((o)localObject4).her()), 1).show();
          paramContext = aa.z(((o)localObject4).her());
          localObject1 = new ca();
          ((ca)localObject1).Cy("weixin");
          ((ca)localObject1).setContent(paramContext);
          ((ca)localObject1).setType(1);
          ((ca)localObject1).nv(0);
          if (((eo)localObject1).field_isSend == 1)
          {
            ((ca)localObject1).setStatus(4);
            long l = System.currentTimeMillis();
            ((ca)localObject1).yF(l);
            ((ca)localObject1).setCreateTime(l);
            ((l)g.af(l.class)).eiy().aC((ca)localObject1);
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
  
  public final boolean bYa()
  {
    AppMethodBeat.i(38832);
    Log.i("MicroMsg.MsgDelayTipsBanner", "refresh banner.");
    g.aAi();
    boolean bool = g.aAh().azQ().getBoolean(ar.a.Oet, false);
    Log.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to show banner:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      if (this.view != null) {
        this.view.setVisibility(0);
      }
    }
    for (;;)
    {
      bool = super.bYa();
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
    return 2131495412;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38827);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MsgDelayTipsBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    kv((Context)this.Kgr.get());
    g.aAi();
    g.aAh().azQ().set(ar.a.Oet, Boolean.FALSE);
    if (this.view != null) {
      this.view.setVisibility(8);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MsgDelayTipsBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(38827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.n
 * JD-Core Version:    0.7.0.1
 */