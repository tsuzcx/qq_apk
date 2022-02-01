package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.d;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.net.URI;
import java.util.List;

public final class ap
{
  private static Typeface Ehi = null;
  
  public static boolean a(Context paramContext, final String paramString1, final String paramString2, final Intent paramIntent, final String paramString3, final al paramal, final int paramInt)
  {
    AppMethodBeat.i(203117);
    if ((paramContext == null) || ((TextUtils.isEmpty(paramString1)) && (paramIntent == null)))
    {
      AppMethodBeat.o(203117);
      return false;
    }
    if (paramIntent != null) {
      a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203110);
          List localList = ap.queryIntentActivities(this.val$context, paramIntent);
          if ((localList != null) && (!localList.isEmpty())) {
            h.a(this.val$context, paramIntent, paramString3, paramInt, new al()
            {
              public final void v(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
              {
                AppMethodBeat.i(203109);
                if (!paramAnonymous2Boolean1) {
                  ap.hb(ap.1.this.val$context);
                }
                if (ap.1.this.Ehk != null) {
                  ap.1.this.Ehk.v(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
                }
                AppMethodBeat.o(203109);
              }
            }, null);
          }
          AppMethodBeat.o(203110);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(203117);
      return true;
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = new Intent("android.intent.action.VIEW", Uri.parse(paramString2));
        paramString2.addFlags(268435456);
        paramString1 = queryIntentActivities(paramContext, paramString2);
        if ((paramString1 != null) && (!paramString1.isEmpty()))
        {
          if ((TextUtils.isEmpty(paramString2.getPackage())) && (paramString1.size() == 1)) {}
          for (paramString1 = h.b((ResolveInfo)paramString1.get(0));; paramString1 = paramString2.getPackage())
          {
            if (Util.nullAsNil(MMApplicationContext.getPackageName()).equals(paramString1)) {
              break label179;
            }
            a.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(203112);
                h.a(this.val$context, paramString2, paramString3, paramInt, new al()
                {
                  public final void v(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
                  {
                    AppMethodBeat.i(203111);
                    if (!paramAnonymous2Boolean1) {
                      ap.hb(ap.2.this.val$context);
                    }
                    if (ap.2.this.Ehk != null) {
                      ap.2.this.Ehk.v(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
                    }
                    AppMethodBeat.o(203111);
                  }
                }, null);
                AppMethodBeat.o(203112);
              }
            });
            break;
          }
        }
      }
      else
      {
        label179:
        a.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(203114);
            Intent localIntent = this.val$context.getPackageManager().getLaunchIntentForPackage(paramString1);
            h.a(this.val$context, localIntent, paramString3, paramInt, new al()
            {
              public final void v(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
              {
                AppMethodBeat.i(203113);
                if (!paramAnonymous2Boolean1) {
                  ap.hb(ap.3.this.val$context);
                }
                if (ap.3.this.Ehk != null) {
                  ap.3.this.Ehk.v(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
                }
                AppMethodBeat.o(203113);
              }
            }, null);
            AppMethodBeat.o(203114);
          }
        });
      }
    }
  }
  
  public static void aK(Activity paramActivity)
  {
    AppMethodBeat.i(96821);
    boolean bool = ao.aQ(paramActivity);
    Log.i("LandingPageUtil", "setFullScreen, hasCut=".concat(String.valueOf(bool)));
    int i = 514;
    if (!bool) {
      i = 1542;
    }
    int j = i;
    if (Build.VERSION.SDK_INT >= 19) {
      j = i | 0x1000;
    }
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(j);
    AppMethodBeat.o(96821);
  }
  
  public static void aL(Activity paramActivity)
  {
    AppMethodBeat.i(203115);
    Log.i("LandingPageUtil", "setFullScreen");
    int i = 1542;
    if (Build.VERSION.SDK_INT >= 19) {
      i = 5638;
    }
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
    AppMethodBeat.o(203115);
  }
  
  public static boolean aQb(String paramString)
  {
    AppMethodBeat.i(96826);
    if ((paramString != null) && (paramString.length() >= 102400))
    {
      AppMethodBeat.o(96826);
      return true;
    }
    AppMethodBeat.o(96826);
    return false;
  }
  
  public static String aQc(String paramString)
  {
    AppMethodBeat.i(96827);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96827);
      return "";
    }
    Object localObject = new o(b.aKC().replace("/data/user/0", "/data/data"), "tmpLargeCanvasDir");
    if (!((o)localObject).exists()) {
      ((o)localObject).mkdirs();
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      localObject = aa.z(new o((o)localObject, System.currentTimeMillis()).her());
      int i = s.f((String)localObject, paramString, paramString.length);
      if (i == 0)
      {
        AppMethodBeat.o(96827);
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      Log.e("LandingPageUtil", "writeTempCanvasXmlToLocal fail");
      AppMethodBeat.o(96827);
    }
    return "";
  }
  
  public static String aQd(String paramString)
  {
    AppMethodBeat.i(96828);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96828);
      return "";
    }
    try
    {
      o localo = new o(paramString);
      if (!localo.exists())
      {
        AppMethodBeat.o(96828);
        return "";
      }
      paramString = s.boY(paramString);
      localo.delete();
      AppMethodBeat.o(96828);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("LandingPageUtil", "readTempCanvasXmlFromLocalAndDeleteIt fail");
      AppMethodBeat.o(96828);
    }
    return "";
  }
  
  public static int bU(float paramFloat)
  {
    int j = (int)paramFloat;
    int i = j;
    if (paramFloat - j > 0.001D) {
      i = j + 1;
    }
    return i;
  }
  
  public static Bitmap getBitmap(String paramString)
  {
    AppMethodBeat.i(96819);
    String str = b.aKJ() + "/sns_ad_landingpages";
    paramString = "adId" + "_image_" + MD5Util.getMD5String(paramString);
    paramString = str + "/" + paramString;
    if (s.YS(paramString))
    {
      paramString = BackwardSupportUtil.BitmapFactory.decodeFile(paramString, 1.0F);
      AppMethodBeat.o(96819);
      return paramString;
    }
    AppMethodBeat.o(96819);
    return null;
  }
  
  public static void h(String paramString, Context paramContext)
  {
    AppMethodBeat.i(96822);
    d.W(paramContext).b(new Intent(paramString));
    AppMethodBeat.o(96822);
  }
  
  public static int[] ha(Context paramContext)
  {
    AppMethodBeat.i(96820);
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Point localPoint;
    int j;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getRealSize(localPoint);
      j = localPoint.x;
    }
    for (int i = localPoint.y;; i = paramContext.getHeight())
    {
      AppMethodBeat.o(96820);
      return new int[] { j, i };
      j = paramContext.getWidth();
    }
  }
  
  public static void hb(Context paramContext)
  {
    AppMethodBeat.i(96823);
    h("com.tencent.mm.adlanding.set_uioption", paramContext);
    AppMethodBeat.o(96823);
  }
  
  public static Typeface hc(Context paramContext)
  {
    AppMethodBeat.i(96825);
    if (Ehi == null) {
      Ehi = Typeface.createFromAsset(paramContext.getAssets(), "fonts/WeChatNum.ttf");
    }
    paramContext = Ehi;
    AppMethodBeat.o(96825);
    return paramContext;
  }
  
  public static String n(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(96824);
    try
    {
      URI localURI = new URI(paramString);
      Object localObject = new StringBuilder();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject).append(paramVarArgs[i]).append("&");
        i += 1;
      }
      if (((StringBuilder)localObject).length() > 1)
      {
        paramVarArgs = ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
        localObject = localURI.getQuery();
        if (localObject == null) {}
        for (paramVarArgs = paramVarArgs.toString();; paramVarArgs = (String)localObject + "&" + paramVarArgs.toString())
        {
          paramVarArgs = new URI(localURI.getScheme(), localURI.getAuthority(), localURI.getPath(), paramVarArgs, localURI.getFragment()).toString();
          AppMethodBeat.o(96824);
          return paramVarArgs;
        }
      }
      return paramString;
    }
    catch (Exception paramVarArgs)
    {
      Log.printErrStackTrace("LandingPageUtil", paramVarArgs, "", new Object[0]);
      AppMethodBeat.o(96824);
    }
  }
  
  public static List<ResolveInfo> queryIntentActivities(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(203116);
    try
    {
      paramContext = Util.queryIntentActivities(paramContext, paramIntent);
      AppMethodBeat.o(203116);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      Log.e("LandingPageUtil", "queryIntentActivities fail");
      AppMethodBeat.o(203116);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap
 * JD-Core Version:    0.7.0.1
 */