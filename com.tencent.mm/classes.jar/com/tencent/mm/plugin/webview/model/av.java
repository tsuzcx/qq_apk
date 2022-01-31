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
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class av
{
  private static List<d.a> uXl;
  
  static
  {
    AppMethodBeat.i(6815);
    uXl = new LinkedList();
    AppMethodBeat.o(6815);
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(6810);
    ab.i("MicroMsg.WebviewShrotcutManager", "buildIntent, install = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBitmap == null) && (paramBoolean))
    {
      ab.e("MicroMsg.WebviewShrotcutManager", "no bmp");
      AppMethodBeat.o(6810);
      return null;
    }
    String str = aht(paramString1);
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(6810);
      return null;
    }
    if (paramBoolean) {}
    for (Object localObject = "com.android.launcher.action.INSTALL_SHORTCUT";; localObject = "com.android.launcher.action.UNINSTALL_SHORTCUT")
    {
      Intent localIntent = new Intent((String)localObject);
      localIntent.putExtra("android.intent.extra.shortcut.NAME", paramString3);
      localIntent.putExtra("duplicate", false);
      localObject = "";
      h localh = o.adg().rj(paramString1);
      paramString1 = (String)localObject;
      if (localh != null) {
        paramString1 = com.tencent.mm.a.g.w((paramString3 + localh.acY()).getBytes());
      }
      localObject = new Intent("com.tencent.mm.action.WX_SHORTCUT");
      ((Intent)localObject).putExtra("type", 2);
      ((Intent)localObject).putExtra("id", str);
      ((Intent)localObject).putExtra("ext_info", aht(paramString2));
      ((Intent)localObject).putExtra("ext_info_1", aht(paramString3));
      paramString3 = new StringBuilder();
      com.tencent.mm.kernel.g.RJ();
      ((Intent)localObject).putExtra("token", de(paramString2, a.getUin()));
      ((Intent)localObject).putExtra("digest", paramString1);
      ((Intent)localObject).setPackage(paramContext.getPackageName());
      ((Intent)localObject).addFlags(67108864);
      localIntent.putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)localObject);
      localIntent.putExtra("android.intent.extra.shortcut.ICON", paramBitmap);
      AppMethodBeat.o(6810);
      return localIntent;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, av.a parama)
  {
    AppMethodBeat.i(6806);
    if ((paramContext == null) || (bo.isNullOrNil(paramString1)))
    {
      ab.e("MicroMsg.WebviewShrotcutManager", "context or username is null");
      if (parama != null) {
        parama.ia(false);
      }
      AppMethodBeat.o(6806);
      return;
    }
    ab.d("MicroMsg.WebviewShrotcutManager", "addShortcut, username = %s", new Object[] { paramString1 });
    if (!com.tencent.mm.kernel.g.RG())
    {
      ab.e("MicroMsg.WebviewShrotcutManager", "acc not ready");
      if (parama != null) {
        parama.ia(false);
      }
      AppMethodBeat.o(6806);
      return;
    }
    ad localad = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(paramString1);
    String str = "";
    if (localad != null) {
      str = localad.Oe();
    }
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.WebviewShrotcutManager", "displayname is nil, should pull from service");
      ao.a.flI.a(paramString1, "", new av.1(parama, paramString1, paramContext, paramString2));
      AppMethodBeat.o(6806);
      return;
    }
    a(paramContext, paramString1, paramString2, str, parama);
    AppMethodBeat.o(6806);
  }
  
  public static void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final av.a parama)
  {
    AppMethodBeat.i(6807);
    if (bh(paramContext, paramString3))
    {
      ab.i("MicroMsg.WebviewShrotcutManager", "shortcut has exist");
      if (parama != null) {
        parama.ia(true);
      }
      AppMethodBeat.o(6807);
      return;
    }
    d.a local2 = new d.a()
    {
      public final void re(String paramAnonymousString)
      {
        AppMethodBeat.i(6803);
        if (!this.efI.equals(paramAnonymousString))
        {
          AppMethodBeat.o(6803);
          return;
        }
        ab.i("MicroMsg.WebviewShrotcutManager", "notifyChanged avatar(%s).", new Object[] { paramAnonymousString });
        av.Yo().remove(this);
        o.acQ().b(this);
        paramAnonymousString = av.bi(paramContext, this.efI);
        if ((paramAnonymousString == null) || (paramAnonymousString.isRecycled()))
        {
          if (parama != null)
          {
            parama.ia(false);
            AppMethodBeat.o(6803);
          }
        }
        else
        {
          paramAnonymousString = av.a(paramContext, this.efI, paramString2, paramString3, paramAnonymousString, true);
          if (paramAnonymousString == null)
          {
            ab.e("MicroMsg.WebviewShrotcutManager", "intent is null");
            if (parama != null)
            {
              parama.ia(false);
              AppMethodBeat.o(6803);
            }
          }
          else
          {
            com.tencent.mm.plugin.base.model.b.p(paramContext, paramAnonymousString);
            if (parama != null) {
              parama.ia(true);
            }
          }
        }
        AppMethodBeat.o(6803);
      }
    };
    uXl.add(local2);
    o.acQ().a(local2);
    Bitmap localBitmap = bg(paramContext, paramString1);
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      ab.e("MicroMsg.WebviewShrotcutManager", "getAvatarBitmap fail, bmp is null, start timer.");
      new ap(new av.b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(6804);
          ab.i("MicroMsg.WebviewShrotcutManager", "expired");
          if (av.Yo().contains(this.uXo))
          {
            av.Yo().remove(this.uXo);
            o.acQ().b(this.uXo);
            if (parama != null) {
              parama.ia(false);
            }
          }
          AppMethodBeat.o(6804);
        }
      }), false).ag(5000L, 5000L);
      AppMethodBeat.o(6807);
      return;
    }
    uXl.remove(local2);
    o.acQ().b(local2);
    paramString1 = a(paramContext, paramString1, paramString2, paramString3, localBitmap, true);
    if (paramString1 == null)
    {
      ab.e("MicroMsg.WebviewShrotcutManager", "intent is null");
      if (parama != null) {
        parama.ia(false);
      }
      AppMethodBeat.o(6807);
      return;
    }
    com.tencent.mm.plugin.base.model.b.p(paramContext, paramString1);
    if (parama != null) {
      parama.ia(true);
    }
    AppMethodBeat.o(6807);
  }
  
  private static String aht(String paramString)
  {
    AppMethodBeat.i(6811);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(6811);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.RJ();
    paramString = com.tencent.mm.plugin.base.model.b.dc(paramString, a.getUin() + "_" + System.currentTimeMillis());
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6811);
      return null;
    }
    paramString = "shortcut_" + com.tencent.mm.plugin.base.model.b.S(paramString.getBytes());
    AppMethodBeat.o(6811);
    return paramString;
  }
  
  private static Bitmap bg(Context paramContext, String paramString)
  {
    AppMethodBeat.i(6808);
    paramString = com.tencent.mm.ah.b.b(paramString, false, -1);
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      int i = (int)(paramContext.getResources().getDisplayMetrics().density * 48.0F);
      paramContext = Bitmap.createScaledBitmap(paramString, i, i, false);
      AppMethodBeat.o(6808);
      return paramContext;
    }
    AppMethodBeat.o(6808);
    return paramString;
  }
  
  private static boolean bh(Context paramContext, String paramString)
  {
    AppMethodBeat.i(6813);
    label241:
    for (;;)
    {
      try
      {
        ContentResolver localContentResolver = paramContext.getContentResolver();
        paramContext = ah.getContext().getPackageManager().getInstalledPackages(8);
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
                AppMethodBeat.o(6813);
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
        AppMethodBeat.o(6813);
        return false;
      }
    }
  }
  
  public static String de(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6812);
    paramString1 = com.tencent.mm.a.g.w((com.tencent.mm.a.g.w(paramString1.getBytes()) + com.tencent.mm.plugin.base.model.b.dc(paramString2, paramString1)).getBytes());
    AppMethodBeat.o(6812);
    return paramString1;
  }
  
  public static void f(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(6809);
    if ((paramContext == null) || (bo.isNullOrNil(paramString3))) {
      ab.e("MicroMsg.WebviewShrotcutManager", "remove failed, invalid params");
    }
    paramString1 = a(paramContext, paramString1, paramString2, paramString3, null, false);
    if (paramString1 == null)
    {
      ab.e("MicroMsg.WebviewShrotcutManager", "remove failed, intent is null");
      AppMethodBeat.o(6809);
      return;
    }
    com.tencent.mm.plugin.base.model.b.q(paramContext, paramString1);
    AppMethodBeat.o(6809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.av
 * JD-Core Version:    0.7.0.1
 */