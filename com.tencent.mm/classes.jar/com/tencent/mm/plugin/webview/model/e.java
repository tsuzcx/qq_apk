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
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
{
  private static List<com.tencent.mm.aj.e.a> Cpb;
  
  static
  {
    AppMethodBeat.i(78854);
    Cpb = new LinkedList();
    AppMethodBeat.o(78854);
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(78849);
    ac.i("MicroMsg.WebviewShrotcutManager", "buildIntent, install = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBitmap == null) && (paramBoolean))
    {
      ac.e("MicroMsg.WebviewShrotcutManager", "no bmp");
      AppMethodBeat.o(78849);
      return null;
    }
    String str = aBJ(paramString1);
    if (bs.isNullOrNil(str))
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
      i locali = p.aBw().Ak(paramString1);
      paramString1 = (String)localObject;
      if (locali != null) {
        paramString1 = com.tencent.mm.b.g.getMessageDigest((paramString3 + locali.aBp()).getBytes());
      }
      localObject = new Intent("com.tencent.mm.action.WX_SHORTCUT");
      ((Intent)localObject).putExtra("type", 2);
      ((Intent)localObject).putExtra("id", str);
      ((Intent)localObject).putExtra("ext_info", aBJ(paramString2));
      ((Intent)localObject).putExtra("ext_info_1", aBJ(paramString3));
      paramString3 = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      ((Intent)localObject).putExtra("token", ev(paramString2, a.getUin()));
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
    if ((paramContext == null) || (bs.isNullOrNil(paramString1)))
    {
      ac.e("MicroMsg.WebviewShrotcutManager", "context or username is null");
      if (parama != null) {
        parama.mF(false);
      }
      AppMethodBeat.o(78845);
      return;
    }
    ac.d("MicroMsg.WebviewShrotcutManager", "addShortcut, username = %s", new Object[] { paramString1 });
    if (!com.tencent.mm.kernel.g.agM())
    {
      ac.e("MicroMsg.WebviewShrotcutManager", "acc not ready");
      if (parama != null) {
        parama.mF(false);
      }
      AppMethodBeat.o(78845);
      return;
    }
    com.tencent.mm.storage.ai localai = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramString1);
    String str = "";
    if (localai != null) {
      str = localai.aaR();
    }
    if (bs.isNullOrNil(str))
    {
      ac.e("MicroMsg.WebviewShrotcutManager", "displayname is nil, should pull from service");
      ar.a.hnw.a(paramString1, "", new ar.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(78841);
          ac.i("MicroMsg.WebviewShrotcutManager", "getContactCallBack, suc = %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (!paramAnonymousBoolean)
          {
            if (this.Cpc != null)
            {
              this.Cpc.mF(false);
              AppMethodBeat.o(78841);
            }
          }
          else
          {
            paramAnonymousString = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramString1);
            if ((paramAnonymousString == null) || (bs.isNullOrNil(paramAnonymousString.aaR())))
            {
              if (this.Cpc != null)
              {
                this.Cpc.mF(false);
                AppMethodBeat.o(78841);
              }
            }
            else {
              e.a(paramContext, paramString1, paramString2, paramAnonymousString.aaR(), this.Cpc);
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
    if (bv(paramContext, paramString3))
    {
      ac.i("MicroMsg.WebviewShrotcutManager", "shortcut has exist");
      if (parama != null) {
        parama.mF(true);
      }
      AppMethodBeat.o(78846);
      return;
    }
    com.tencent.mm.aj.e.a local2 = new com.tencent.mm.aj.e.a()
    {
      public final void Af(String paramAnonymousString)
      {
        AppMethodBeat.i(78842);
        if (!this.fur.equals(paramAnonymousString))
        {
          AppMethodBeat.o(78842);
          return;
        }
        ac.i("MicroMsg.WebviewShrotcutManager", "notifyChanged avatar(%s).", new Object[] { paramAnonymousString });
        e.Cpb.remove(this);
        p.aBh().b(this);
        paramAnonymousString = e.bw(paramContext, this.fur);
        if ((paramAnonymousString == null) || (paramAnonymousString.isRecycled()))
        {
          if (parama != null)
          {
            parama.mF(false);
            AppMethodBeat.o(78842);
          }
        }
        else
        {
          paramAnonymousString = e.a(paramContext, this.fur, paramString2, paramString3, paramAnonymousString, true);
          if (paramAnonymousString == null)
          {
            ac.e("MicroMsg.WebviewShrotcutManager", "intent is null");
            if (parama != null)
            {
              parama.mF(false);
              AppMethodBeat.o(78842);
            }
          }
          else
          {
            b.p(paramContext, paramAnonymousString);
            if (parama != null) {
              parama.mF(true);
            }
          }
        }
        AppMethodBeat.o(78842);
      }
    };
    Cpb.add(local2);
    p.aBh().a(local2);
    Bitmap localBitmap = bu(paramContext, paramString1);
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      ac.e("MicroMsg.WebviewShrotcutManager", "getAvatarBitmap fail, bmp is null, start timer.");
      new au(new b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78843);
          ac.i("MicroMsg.WebviewShrotcutManager", "expired");
          if (e.Cpb.contains(this.Cpe))
          {
            e.Cpb.remove(this.Cpe);
            p.aBh().b(this.Cpe);
            if (parama != null) {
              parama.mF(false);
            }
          }
          AppMethodBeat.o(78843);
        }
      }), false).au(5000L, 5000L);
      AppMethodBeat.o(78846);
      return;
    }
    Cpb.remove(local2);
    p.aBh().b(local2);
    paramString1 = a(paramContext, paramString1, paramString2, paramString3, localBitmap, true);
    if (paramString1 == null)
    {
      ac.e("MicroMsg.WebviewShrotcutManager", "intent is null");
      if (parama != null) {
        parama.mF(false);
      }
      AppMethodBeat.o(78846);
      return;
    }
    b.p(paramContext, paramString1);
    if (parama != null) {
      parama.mF(true);
    }
    AppMethodBeat.o(78846);
  }
  
  private static String aBJ(String paramString)
  {
    AppMethodBeat.i(78850);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(78850);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    paramString = b.et(paramString, a.getUin() + "_" + System.currentTimeMillis());
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78850);
      return null;
    }
    paramString = "shortcut_" + b.Z(paramString.getBytes());
    AppMethodBeat.o(78850);
    return paramString;
  }
  
  private static Bitmap bu(Context paramContext, String paramString)
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
  
  private static boolean bv(Context paramContext, String paramString)
  {
    AppMethodBeat.i(78852);
    label241:
    for (;;)
    {
      try
      {
        ContentResolver localContentResolver = paramContext.getContentResolver();
        paramContext = com.tencent.mm.sdk.platformtools.ai.getContext().getPackageManager().getInstalledPackages(8);
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
    if ((paramContext == null) || (bs.isNullOrNil(paramString3))) {
      ac.e("MicroMsg.WebviewShrotcutManager", "remove failed, invalid params");
    }
    paramString1 = a(paramContext, paramString1, paramString2, paramString3, null, false);
    if (paramString1 == null)
    {
      ac.e("MicroMsg.WebviewShrotcutManager", "remove failed, intent is null");
      AppMethodBeat.o(78848);
      return;
    }
    b.q(paramContext, paramString1);
    AppMethodBeat.o(78848);
  }
  
  public static String ev(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78851);
    paramString1 = com.tencent.mm.b.g.getMessageDigest((com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) + b.et(paramString2, paramString1)).getBytes());
    AppMethodBeat.o(78851);
    return paramString1;
  }
  
  public static abstract interface a
  {
    public abstract void mF(boolean paramBoolean);
  }
  
  static final class b
    implements au.a
  {
    private Runnable csS;
    
    b(Runnable paramRunnable)
    {
      this.csS = paramRunnable;
    }
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(78844);
      if (this.csS != null) {
        this.csS.run();
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