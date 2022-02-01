package com.tencent.mm.plugin.webview.model;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.d;
import com.tencent.mm.am.f;
import com.tencent.mm.am.f.a;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.am.q;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
{
  private static List<f.a> PTO;
  
  static
  {
    AppMethodBeat.i(78854);
    PTO = new LinkedList();
    AppMethodBeat.o(78854);
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(78849);
    Log.i("MicroMsg.WebviewShrotcutManager", "buildIntent, install = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBitmap == null) && (paramBoolean))
    {
      Log.e("MicroMsg.WebviewShrotcutManager", "no bmp");
      AppMethodBeat.o(78849);
      return null;
    }
    String str = bkx(paramString1);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(78849);
      return null;
    }
    if (paramBoolean) {}
    for (Object localObject = "com.android.launcher.action.INSTALL_SHORTCUT";; localObject = "com.android.launcher.action.UNINSTALL_SHORTCUT")
    {
      Intent localIntent = new Intent((String)localObject);
      localIntent.putExtra("android.intent.extra.shortcut.NAME", paramString3);
      localIntent.putExtra("duplicate", false);
      localObject = "";
      j localj = q.bhP().TS(paramString1);
      paramString1 = (String)localObject;
      if (localj != null) {
        paramString1 = g.getMessageDigest((paramString3 + localj.bhI()).getBytes());
      }
      localObject = new Intent("com.tencent.mm.action.WX_SHORTCUT");
      ((Intent)localObject).putExtra("type", 2);
      ((Intent)localObject).putExtra("id", str);
      ((Intent)localObject).putExtra("ext_info", bkx(paramString2));
      ((Intent)localObject).putExtra("ext_info_1", bkx(paramString3));
      paramString3 = new StringBuilder();
      h.aHE();
      ((Intent)localObject).putExtra("token", fm(paramString2, com.tencent.mm.kernel.b.getUin()));
      ((Intent)localObject).putExtra("digest", paramString1);
      ((Intent)localObject).setPackage(paramContext.getPackageName());
      ((Intent)localObject).addFlags(67108864);
      localIntent.putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)localObject);
      localIntent.putExtra("android.intent.extra.shortcut.ICON", paramBitmap);
      AppMethodBeat.o(78849);
      return localIntent;
    }
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2, a parama)
  {
    AppMethodBeat.i(78845);
    if ((paramContext == null) || (Util.isNullOrNil(paramString1)))
    {
      Log.e("MicroMsg.WebviewShrotcutManager", "context or username is null");
      if (parama != null) {
        parama.sf(false);
      }
      AppMethodBeat.o(78845);
      return;
    }
    Log.d("MicroMsg.WebviewShrotcutManager", "addShortcut, username = %s", new Object[] { paramString1 });
    if (!h.aHB())
    {
      Log.e("MicroMsg.WebviewShrotcutManager", "acc not ready");
      if (parama != null) {
        parama.sf(false);
      }
      AppMethodBeat.o(78845);
      return;
    }
    as localas = ((n)h.ae(n.class)).bbL().RG(paramString1);
    String str = "";
    if (localas != null) {
      str = localas.ayr();
    }
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.WebviewShrotcutManager", "displayname is nil, should pull from service");
      az.a.ltq.a(paramString1, "", new az.b.a()
      {
        public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(78841);
          Log.i("MicroMsg.WebviewShrotcutManager", "getContactCallBack, suc = %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (!paramAnonymousBoolean)
          {
            if (this.PTP != null)
            {
              this.PTP.sf(false);
              AppMethodBeat.o(78841);
            }
          }
          else
          {
            paramAnonymousString = ((n)h.ae(n.class)).bbL().RG(paramString1);
            if ((paramAnonymousString == null) || (Util.isNullOrNil(paramAnonymousString.ayr())))
            {
              if (this.PTP != null)
              {
                this.PTP.sf(false);
                AppMethodBeat.o(78841);
              }
            }
            else {
              e.a(paramContext, paramString1, paramString2, paramAnonymousString.ayr(), this.PTP);
            }
          }
          AppMethodBeat.o(78841);
        }
      });
      AppMethodBeat.o(78845);
      return;
    }
    a(paramContext, paramString1, paramString2, str, parama);
    AppMethodBeat.o(78845);
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final a parama)
  {
    AppMethodBeat.i(78846);
    if (cf(paramContext, paramString3))
    {
      Log.i("MicroMsg.WebviewShrotcutManager", "shortcut has exist");
      if (parama != null) {
        parama.sf(true);
      }
      AppMethodBeat.o(78846);
      return;
    }
    f.a local2 = new f.a()
    {
      public final void TM(String paramAnonymousString)
      {
        AppMethodBeat.i(78842);
        if (!this.iXG.equals(paramAnonymousString))
        {
          AppMethodBeat.o(78842);
          return;
        }
        Log.i("MicroMsg.WebviewShrotcutManager", "notifyChanged avatar(%s).", new Object[] { paramAnonymousString });
        e.PTO.remove(this);
        q.bhz().b(this);
        paramAnonymousString = e.cg(paramContext, this.iXG);
        if ((paramAnonymousString == null) || (paramAnonymousString.isRecycled()))
        {
          if (parama != null)
          {
            parama.sf(false);
            AppMethodBeat.o(78842);
          }
        }
        else
        {
          paramAnonymousString = e.a(paramContext, this.iXG, paramString2, paramString3, paramAnonymousString, true);
          if (paramAnonymousString == null)
          {
            Log.e("MicroMsg.WebviewShrotcutManager", "intent is null");
            if (parama != null)
            {
              parama.sf(false);
              AppMethodBeat.o(78842);
            }
          }
          else
          {
            com.tencent.mm.plugin.base.model.b.o(paramContext, paramAnonymousString);
            if (parama != null) {
              parama.sf(true);
            }
          }
        }
        AppMethodBeat.o(78842);
      }
    };
    PTO.add(local2);
    q.bhz().a(local2);
    Bitmap localBitmap = ce(paramContext, paramString1);
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      Log.e("MicroMsg.WebviewShrotcutManager", "getAvatarBitmap fail, bmp is null, start timer.");
      new MTimerHandler(new b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78843);
          Log.i("MicroMsg.WebviewShrotcutManager", "expired");
          if (e.PTO.contains(this.PTR))
          {
            e.PTO.remove(this.PTR);
            q.bhz().b(this.PTR);
            if (parama != null) {
              parama.sf(false);
            }
          }
          AppMethodBeat.o(78843);
        }
      }), false).startTimer(5000L);
      AppMethodBeat.o(78846);
      return;
    }
    PTO.remove(local2);
    q.bhz().b(local2);
    paramString1 = a(paramContext, paramString1, paramString2, paramString3, localBitmap, true);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.WebviewShrotcutManager", "intent is null");
      if (parama != null) {
        parama.sf(false);
      }
      AppMethodBeat.o(78846);
      return;
    }
    com.tencent.mm.plugin.base.model.b.o(paramContext, paramString1);
    if (parama != null) {
      parama.sf(true);
    }
    AppMethodBeat.o(78846);
  }
  
  private static String bkx(String paramString)
  {
    AppMethodBeat.i(78850);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(78850);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    h.aHE();
    paramString = com.tencent.mm.plugin.base.model.b.fk(paramString, com.tencent.mm.kernel.b.getUin() + "_" + System.currentTimeMillis());
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78850);
      return null;
    }
    paramString = "shortcut_" + com.tencent.mm.plugin.base.model.b.toHexString(paramString.getBytes());
    AppMethodBeat.o(78850);
    return paramString;
  }
  
  private static Bitmap ce(Context paramContext, String paramString)
  {
    AppMethodBeat.i(78847);
    paramString = d.a(paramString, false, -1, null);
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      int i = (int)(paramContext.getResources().getDisplayMetrics().density * 48.0F);
      paramContext = Bitmap.createScaledBitmap(paramString, i, i, false);
      AppMethodBeat.o(78847);
      return paramContext;
    }
    AppMethodBeat.o(78847);
    return paramString;
  }
  
  private static boolean cf(Context paramContext, String paramString)
  {
    AppMethodBeat.i(78852);
    label241:
    for (;;)
    {
      try
      {
        ContentResolver localContentResolver = paramContext.getContentResolver();
        paramContext = MMApplicationContext.getContext().getPackageManager().getInstalledPackages(8);
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          if (paramContext.hasNext())
          {
            ProviderInfo[] arrayOfProviderInfo = ((PackageInfo)paramContext.next()).providers;
            if (arrayOfProviderInfo == null) {
              continue;
            }
            int j = arrayOfProviderInfo.length;
            int i = 0;
            if (i < j)
            {
              ProviderInfo localProviderInfo = arrayOfProviderInfo[i];
              if ("com.android.launcher.permission.READ_SETTINGS".equals(localProviderInfo.readPermission))
              {
                paramContext = localProviderInfo.authority;
                paramContext = localContentResolver.query(Uri.parse("content://" + paramContext + "/favorites?notify=true"), new String[] { "title", "iconResource" }, "title=?", new String[] { paramString }, null);
                if (paramContext == null) {
                  break label241;
                }
                if (paramContext.getCount() <= 0) {
                  continue;
                }
                bool = true;
                paramContext.close();
                AppMethodBeat.o(78852);
                return bool;
              }
              if ("com.android.launcher.permission.READ_SETTINGS".equals(localProviderInfo.writePermission))
              {
                paramContext = localProviderInfo.authority;
                continue;
              }
              i += 1;
              continue;
            }
            continue;
          }
        }
        paramContext = null;
        continue;
        boolean bool = false;
        continue;
        bool = false;
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(78852);
        return false;
      }
    }
  }
  
  public static String fm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78851);
    paramString1 = g.getMessageDigest((g.getMessageDigest(paramString1.getBytes()) + com.tencent.mm.plugin.base.model.b.fk(paramString2, paramString1)).getBytes());
    AppMethodBeat.o(78851);
    return paramString1;
  }
  
  public static void h(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78848);
    if ((paramContext == null) || (Util.isNullOrNil(paramString3))) {
      Log.e("MicroMsg.WebviewShrotcutManager", "remove failed, invalid params");
    }
    paramString1 = a(paramContext, paramString1, paramString2, paramString3, null, false);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.WebviewShrotcutManager", "remove failed, intent is null");
      AppMethodBeat.o(78848);
      return;
    }
    com.tencent.mm.plugin.base.model.b.p(paramContext, paramString1);
    AppMethodBeat.o(78848);
  }
  
  public static abstract interface a
  {
    public abstract void sf(boolean paramBoolean);
  }
  
  static final class b
    implements MTimerHandler.CallBack
  {
    private Runnable fKd;
    
    b(Runnable paramRunnable)
    {
      this.fKd = paramRunnable;
    }
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(78844);
      if (this.fKd != null) {
        this.fKd.run();
      }
      AppMethodBeat.o(78844);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.e
 * JD-Core Version:    0.7.0.1
 */