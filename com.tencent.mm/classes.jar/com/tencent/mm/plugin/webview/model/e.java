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
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
{
  private static List<com.tencent.mm.ak.e.a> AWO;
  
  static
  {
    AppMethodBeat.i(78854);
    AWO = new LinkedList();
    AppMethodBeat.o(78854);
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(78849);
    ad.i("MicroMsg.WebviewShrotcutManager", "buildIntent, install = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBitmap == null) && (paramBoolean))
    {
      ad.e("MicroMsg.WebviewShrotcutManager", "no bmp");
      AppMethodBeat.o(78849);
      return null;
    }
    String str = awr(paramString1);
    if (bt.isNullOrNil(str))
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
      i locali = p.auF().we(paramString1);
      paramString1 = (String)localObject;
      if (locali != null) {
        paramString1 = com.tencent.mm.b.g.getMessageDigest((paramString3 + locali.auy()).getBytes());
      }
      localObject = new Intent("com.tencent.mm.action.WX_SHORTCUT");
      ((Intent)localObject).putExtra("type", 2);
      ((Intent)localObject).putExtra("id", str);
      ((Intent)localObject).putExtra("ext_info", awr(paramString2));
      ((Intent)localObject).putExtra("ext_info_1", awr(paramString3));
      paramString3 = new StringBuilder();
      com.tencent.mm.kernel.g.afz();
      ((Intent)localObject).putExtra("token", ej(paramString2, a.getUin()));
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
    if ((paramContext == null) || (bt.isNullOrNil(paramString1)))
    {
      ad.e("MicroMsg.WebviewShrotcutManager", "context or username is null");
      if (parama != null) {
        parama.lM(false);
      }
      AppMethodBeat.o(78845);
      return;
    }
    ad.d("MicroMsg.WebviewShrotcutManager", "addShortcut, username = %s", new Object[] { paramString1 });
    if (!com.tencent.mm.kernel.g.afw())
    {
      ad.e("MicroMsg.WebviewShrotcutManager", "acc not ready");
      if (parama != null) {
        parama.lM(false);
      }
      AppMethodBeat.o(78845);
      return;
    }
    af localaf = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(paramString1);
    String str = "";
    if (localaf != null) {
      str = localaf.ZW();
    }
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.WebviewShrotcutManager", "displayname is nil, should pull from service");
      ar.a.gMW.a(paramString1, "", new ar.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(78841);
          ad.i("MicroMsg.WebviewShrotcutManager", "getContactCallBack, suc = %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (!paramAnonymousBoolean)
          {
            if (this.AWP != null)
            {
              this.AWP.lM(false);
              AppMethodBeat.o(78841);
            }
          }
          else
          {
            paramAnonymousString = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(paramString1);
            if ((paramAnonymousString == null) || (bt.isNullOrNil(paramAnonymousString.ZW())))
            {
              if (this.AWP != null)
              {
                this.AWP.lM(false);
                AppMethodBeat.o(78841);
              }
            }
            else {
              e.a(paramContext, paramString1, paramString2, paramAnonymousString.ZW(), this.AWP);
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
    if (bu(paramContext, paramString3))
    {
      ad.i("MicroMsg.WebviewShrotcutManager", "shortcut has exist");
      if (parama != null) {
        parama.lM(true);
      }
      AppMethodBeat.o(78846);
      return;
    }
    com.tencent.mm.ak.e.a local2 = new com.tencent.mm.ak.e.a()
    {
      public final void vZ(String paramAnonymousString)
      {
        AppMethodBeat.i(78842);
        if (!this.fqK.equals(paramAnonymousString))
        {
          AppMethodBeat.o(78842);
          return;
        }
        ad.i("MicroMsg.WebviewShrotcutManager", "notifyChanged avatar(%s).", new Object[] { paramAnonymousString });
        e.apA().remove(this);
        p.auq().b(this);
        paramAnonymousString = e.bv(paramContext, this.fqK);
        if ((paramAnonymousString == null) || (paramAnonymousString.isRecycled()))
        {
          if (parama != null)
          {
            parama.lM(false);
            AppMethodBeat.o(78842);
          }
        }
        else
        {
          paramAnonymousString = e.a(paramContext, this.fqK, paramString2, paramString3, paramAnonymousString, true);
          if (paramAnonymousString == null)
          {
            ad.e("MicroMsg.WebviewShrotcutManager", "intent is null");
            if (parama != null)
            {
              parama.lM(false);
              AppMethodBeat.o(78842);
            }
          }
          else
          {
            b.p(paramContext, paramAnonymousString);
            if (parama != null) {
              parama.lM(true);
            }
          }
        }
        AppMethodBeat.o(78842);
      }
    };
    AWO.add(local2);
    p.auq().a(local2);
    Bitmap localBitmap = bt(paramContext, paramString1);
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      ad.e("MicroMsg.WebviewShrotcutManager", "getAvatarBitmap fail, bmp is null, start timer.");
      new av(new b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78843);
          ad.i("MicroMsg.WebviewShrotcutManager", "expired");
          if (e.apA().contains(this.AWR))
          {
            e.apA().remove(this.AWR);
            p.auq().b(this.AWR);
            if (parama != null) {
              parama.lM(false);
            }
          }
          AppMethodBeat.o(78843);
        }
      }), false).av(5000L, 5000L);
      AppMethodBeat.o(78846);
      return;
    }
    AWO.remove(local2);
    p.auq().b(local2);
    paramString1 = a(paramContext, paramString1, paramString2, paramString3, localBitmap, true);
    if (paramString1 == null)
    {
      ad.e("MicroMsg.WebviewShrotcutManager", "intent is null");
      if (parama != null) {
        parama.lM(false);
      }
      AppMethodBeat.o(78846);
      return;
    }
    b.p(paramContext, paramString1);
    if (parama != null) {
      parama.lM(true);
    }
    AppMethodBeat.o(78846);
  }
  
  private static String awr(String paramString)
  {
    AppMethodBeat.i(78850);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(78850);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    paramString = b.eh(paramString, a.getUin() + "_" + System.currentTimeMillis());
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78850);
      return null;
    }
    paramString = "shortcut_" + b.aa(paramString.getBytes());
    AppMethodBeat.o(78850);
    return paramString;
  }
  
  private static Bitmap bt(Context paramContext, String paramString)
  {
    AppMethodBeat.i(78847);
    paramString = c.a(paramString, false, -1, null);
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
  
  private static boolean bu(Context paramContext, String paramString)
  {
    AppMethodBeat.i(78852);
    label241:
    for (;;)
    {
      try
      {
        ContentResolver localContentResolver = paramContext.getContentResolver();
        paramContext = aj.getContext().getPackageManager().getInstalledPackages(8);
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
  
  public static void d(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78848);
    if ((paramContext == null) || (bt.isNullOrNil(paramString3))) {
      ad.e("MicroMsg.WebviewShrotcutManager", "remove failed, invalid params");
    }
    paramString1 = a(paramContext, paramString1, paramString2, paramString3, null, false);
    if (paramString1 == null)
    {
      ad.e("MicroMsg.WebviewShrotcutManager", "remove failed, intent is null");
      AppMethodBeat.o(78848);
      return;
    }
    b.q(paramContext, paramString1);
    AppMethodBeat.o(78848);
  }
  
  public static String ej(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78851);
    paramString1 = com.tencent.mm.b.g.getMessageDigest((com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) + b.eh(paramString2, paramString1)).getBytes());
    AppMethodBeat.o(78851);
    return paramString1;
  }
  
  public static abstract interface a
  {
    public abstract void lM(boolean paramBoolean);
  }
  
  static final class b
    implements av.a
  {
    private Runnable cvK;
    
    b(Runnable paramRunnable)
    {
      this.cvK = paramRunnable;
    }
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(78844);
      if (this.cvK != null) {
        this.cvK.run();
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