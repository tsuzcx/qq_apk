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
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.net.URI;
import java.util.List;

public final class ar
{
  private static Typeface QSP = null;
  
  public static Bitmap Cr(String paramString)
  {
    AppMethodBeat.i(96819);
    String str = b.bmz() + "/sns_ad_landingpages";
    paramString = "adId" + "_image_" + MD5Util.getMD5String(paramString);
    paramString = str + "/" + paramString;
    if (y.ZC(paramString))
    {
      paramString = BackwardSupportUtil.BitmapFactory.decodeFile(paramString, 1.0F);
      AppMethodBeat.o(96819);
      return paramString;
    }
    AppMethodBeat.o(96819);
    return null;
  }
  
  public static boolean a(Context paramContext, final String paramString1, final String paramString2, final Intent paramIntent, final String paramString3, final ap paramap, final int paramInt)
  {
    AppMethodBeat.i(307035);
    if ((paramContext == null) || ((TextUtils.isEmpty(paramString1)) && (paramIntent == null)))
    {
      AppMethodBeat.o(307035);
      return false;
    }
    if (paramIntent != null) {
      com.tencent.mm.ci.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(307252);
          List localList = ar.queryIntentActivities(ar.this, paramIntent);
          if ((localList != null) && (!localList.isEmpty())) {
            h.a(ar.this, paramIntent, paramString3, paramInt, new ap()
            {
              public final void onLaunchApp(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
              {
                AppMethodBeat.i(307060);
                if (!paramAnonymous2Boolean1) {
                  ar.jS(ar.this);
                }
                if (ar.1.this.QSR != null) {
                  ar.1.this.QSR.onLaunchApp(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
                }
                AppMethodBeat.o(307060);
              }
            }, null);
          }
          AppMethodBeat.o(307252);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(307035);
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
            com.tencent.mm.ci.a.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(307256);
                h.a(ar.this, paramString2, paramString3, paramInt, new ap()
                {
                  public final void onLaunchApp(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
                  {
                    AppMethodBeat.i(307180);
                    if (!paramAnonymous2Boolean1) {
                      ar.jS(ar.this);
                    }
                    if (ar.2.this.QSR != null) {
                      ar.2.this.QSR.onLaunchApp(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
                    }
                    AppMethodBeat.o(307180);
                  }
                }, null);
                AppMethodBeat.o(307256);
              }
            });
            break;
          }
        }
      }
      else
      {
        label179:
        com.tencent.mm.ci.a.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(307258);
            Intent localIntent = ar.this.getPackageManager().getLaunchIntentForPackage(paramString1);
            h.a(ar.this, localIntent, paramString3, paramInt, new ap()
            {
              public final void onLaunchApp(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
              {
                AppMethodBeat.i(306933);
                if (!paramAnonymous2Boolean1) {
                  ar.jS(ar.this);
                }
                if (ar.3.this.QSR != null) {
                  ar.3.this.QSR.onLaunchApp(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
                }
                AppMethodBeat.o(306933);
              }
            }, null);
            AppMethodBeat.o(307258);
          }
        });
      }
    }
  }
  
  public static boolean aZB(String paramString)
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
  
  public static String aZC(String paramString)
  {
    AppMethodBeat.i(96827);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96827);
      return "";
    }
    Object localObject = new u(b.bms(), "tmpLargeCanvasDir");
    if (!((u)localObject).jKS()) {
      ((u)localObject).jKY();
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      localObject = ah.v(new u((u)localObject, System.currentTimeMillis()).jKT());
      int i = y.f((String)localObject, paramString, paramString.length);
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
  
  public static String aZD(String paramString)
  {
    AppMethodBeat.i(96828);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96828);
      return "";
    }
    try
    {
      u localu = new u(paramString);
      if (!localu.jKS())
      {
        AppMethodBeat.o(96828);
        return "";
      }
      paramString = y.bEn(paramString);
      localu.diJ();
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
  
  public static void bs(Activity paramActivity)
  {
    AppMethodBeat.i(96821);
    boolean bool = aw.bx(paramActivity);
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
  
  public static void bt(Activity paramActivity)
  {
    AppMethodBeat.i(306967);
    Log.i("LandingPageUtil", "setFullScreen");
    int i = 1542;
    if (Build.VERSION.SDK_INT >= 19) {
      i = 5638;
    }
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
    AppMethodBeat.o(306967);
  }
  
  public static int dl(float paramFloat)
  {
    int j = (int)paramFloat;
    int i = j;
    if (paramFloat - j > 0.001D) {
      i = j + 1;
    }
    return i;
  }
  
  public static void i(String paramString, Context paramContext)
  {
    AppMethodBeat.i(96822);
    androidx.i.a.a.al(paramContext).d(new Intent(paramString));
    AppMethodBeat.o(96822);
  }
  
  public static int[] jR(Context paramContext)
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
  
  public static void jS(Context paramContext)
  {
    AppMethodBeat.i(96823);
    i("com.tencent.mm.adlanding.set_uioption", paramContext);
    AppMethodBeat.o(96823);
  }
  
  public static Typeface jT(Context paramContext)
  {
    AppMethodBeat.i(96825);
    if (QSP == null) {
      QSP = Typeface.createFromAsset(paramContext.getAssets(), "fonts/WeChatNum.ttf");
    }
    paramContext = QSP;
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
    AppMethodBeat.i(307026);
    try
    {
      paramContext = Util.queryIntentActivities(paramContext, paramIntent);
      AppMethodBeat.o(307026);
      return paramContext;
    }
    finally
    {
      Log.e("LandingPageUtil", "queryIntentActivities fail");
      AppMethodBeat.o(307026);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar
 * JD-Core Version:    0.7.0.1
 */