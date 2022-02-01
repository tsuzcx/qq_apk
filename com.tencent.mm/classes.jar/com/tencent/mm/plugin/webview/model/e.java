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
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
{
  private static List<com.tencent.mm.aj.e.a> Ekz;
  
  static
  {
    AppMethodBeat.i(78854);
    Ekz = new LinkedList();
    AppMethodBeat.o(78854);
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(78849);
    ae.i("MicroMsg.WebviewShrotcutManager", "buildIntent, install = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBitmap == null) && (paramBoolean))
    {
      ae.e("MicroMsg.WebviewShrotcutManager", "no bmp");
      AppMethodBeat.o(78849);
      return null;
    }
    String str = aIC(paramString1);
    if (bu.isNullOrNil(str))
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
      i locali = p.aEN().DL(paramString1);
      paramString1 = (String)localObject;
      if (locali != null) {
        paramString1 = com.tencent.mm.b.g.getMessageDigest((paramString3 + locali.aEH()).getBytes());
      }
      localObject = new Intent("com.tencent.mm.action.WX_SHORTCUT");
      ((Intent)localObject).putExtra("type", 2);
      ((Intent)localObject).putExtra("id", str);
      ((Intent)localObject).putExtra("ext_info", aIC(paramString2));
      ((Intent)localObject).putExtra("ext_info_1", aIC(paramString3));
      paramString3 = new StringBuilder();
      com.tencent.mm.kernel.g.ajP();
      ((Intent)localObject).putExtra("token", eH(paramString2, a.getUin()));
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
    if ((paramContext == null) || (bu.isNullOrNil(paramString1)))
    {
      ae.e("MicroMsg.WebviewShrotcutManager", "context or username is null");
      if (parama != null) {
        parama.nc(false);
      }
      AppMethodBeat.o(78845);
      return;
    }
    ae.d("MicroMsg.WebviewShrotcutManager", "addShortcut, username = %s", new Object[] { paramString1 });
    if (!com.tencent.mm.kernel.g.ajM())
    {
      ae.e("MicroMsg.WebviewShrotcutManager", "acc not ready");
      if (parama != null) {
        parama.nc(false);
      }
      AppMethodBeat.o(78845);
      return;
    }
    an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramString1);
    String str = "";
    if (localan != null) {
      str = localan.adF();
    }
    if (bu.isNullOrNil(str))
    {
      ae.e("MicroMsg.WebviewShrotcutManager", "displayname is nil, should pull from service");
      au.a.hIG.a(paramString1, "", new au.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(78841);
          ae.i("MicroMsg.WebviewShrotcutManager", "getContactCallBack, suc = %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (!paramAnonymousBoolean)
          {
            if (this.EkA != null)
            {
              this.EkA.nc(false);
              AppMethodBeat.o(78841);
            }
          }
          else
          {
            paramAnonymousString = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramString1);
            if ((paramAnonymousString == null) || (bu.isNullOrNil(paramAnonymousString.adF())))
            {
              if (this.EkA != null)
              {
                this.EkA.nc(false);
                AppMethodBeat.o(78841);
              }
            }
            else {
              e.a(paramContext, paramString1, paramString2, paramAnonymousString.adF(), this.EkA);
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
    if (bA(paramContext, paramString3))
    {
      ae.i("MicroMsg.WebviewShrotcutManager", "shortcut has exist");
      if (parama != null) {
        parama.nc(true);
      }
      AppMethodBeat.o(78846);
      return;
    }
    com.tencent.mm.aj.e.a local2 = new com.tencent.mm.aj.e.a()
    {
      public final void DG(String paramAnonymousString)
      {
        AppMethodBeat.i(78842);
        if (!this.fOj.equals(paramAnonymousString))
        {
          AppMethodBeat.o(78842);
          return;
        }
        ae.i("MicroMsg.WebviewShrotcutManager", "notifyChanged avatar(%s).", new Object[] { paramAnonymousString });
        e.Ekz.remove(this);
        p.aEA().b(this);
        paramAnonymousString = e.bB(paramContext, this.fOj);
        if ((paramAnonymousString == null) || (paramAnonymousString.isRecycled()))
        {
          if (parama != null)
          {
            parama.nc(false);
            AppMethodBeat.o(78842);
          }
        }
        else
        {
          paramAnonymousString = e.a(paramContext, this.fOj, paramString2, paramString3, paramAnonymousString, true);
          if (paramAnonymousString == null)
          {
            ae.e("MicroMsg.WebviewShrotcutManager", "intent is null");
            if (parama != null)
            {
              parama.nc(false);
              AppMethodBeat.o(78842);
            }
          }
          else
          {
            b.p(paramContext, paramAnonymousString);
            if (parama != null) {
              parama.nc(true);
            }
          }
        }
        AppMethodBeat.o(78842);
      }
    };
    Ekz.add(local2);
    p.aEA().a(local2);
    Bitmap localBitmap = bz(paramContext, paramString1);
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      ae.e("MicroMsg.WebviewShrotcutManager", "getAvatarBitmap fail, bmp is null, start timer.");
      new aw(new b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78843);
          ae.i("MicroMsg.WebviewShrotcutManager", "expired");
          if (e.Ekz.contains(this.EkC))
          {
            e.Ekz.remove(this.EkC);
            p.aEA().b(this.EkC);
            if (parama != null) {
              parama.nc(false);
            }
          }
          AppMethodBeat.o(78843);
        }
      }), false).ay(5000L, 5000L);
      AppMethodBeat.o(78846);
      return;
    }
    Ekz.remove(local2);
    p.aEA().b(local2);
    paramString1 = a(paramContext, paramString1, paramString2, paramString3, localBitmap, true);
    if (paramString1 == null)
    {
      ae.e("MicroMsg.WebviewShrotcutManager", "intent is null");
      if (parama != null) {
        parama.nc(false);
      }
      AppMethodBeat.o(78846);
      return;
    }
    b.p(paramContext, paramString1);
    if (parama != null) {
      parama.nc(true);
    }
    AppMethodBeat.o(78846);
  }
  
  private static String aIC(String paramString)
  {
    AppMethodBeat.i(78850);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(78850);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    paramString = b.eF(paramString, a.getUin() + "_" + System.currentTimeMillis());
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78850);
      return null;
    }
    paramString = "shortcut_" + b.Z(paramString.getBytes());
    AppMethodBeat.o(78850);
    return paramString;
  }
  
  private static boolean bA(Context paramContext, String paramString)
  {
    AppMethodBeat.i(78852);
    label241:
    for (;;)
    {
      try
      {
        ContentResolver localContentResolver = paramContext.getContentResolver();
        paramContext = ak.getContext().getPackageManager().getInstalledPackages(8);
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
  
  private static Bitmap bz(Context paramContext, String paramString)
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
  
  public static void d(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78848);
    if ((paramContext == null) || (bu.isNullOrNil(paramString3))) {
      ae.e("MicroMsg.WebviewShrotcutManager", "remove failed, invalid params");
    }
    paramString1 = a(paramContext, paramString1, paramString2, paramString3, null, false);
    if (paramString1 == null)
    {
      ae.e("MicroMsg.WebviewShrotcutManager", "remove failed, intent is null");
      AppMethodBeat.o(78848);
      return;
    }
    b.q(paramContext, paramString1);
    AppMethodBeat.o(78848);
  }
  
  public static String eH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78851);
    paramString1 = com.tencent.mm.b.g.getMessageDigest((com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) + b.eF(paramString2, paramString1)).getBytes());
    AppMethodBeat.o(78851);
    return paramString1;
  }
  
  public static abstract interface a
  {
    public abstract void nc(boolean paramBoolean);
  }
  
  static final class b
    implements aw.a
  {
    private Runnable cEv;
    
    b(Runnable paramRunnable)
    {
      this.cEv = paramRunnable;
    }
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(78844);
      if (this.cEv != null) {
        this.cEv.run();
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