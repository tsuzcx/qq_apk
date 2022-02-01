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
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public final class an
{
  private static Typeface zYR = null;
  
  public static boolean a(Context paramContext, final String paramString1, final String paramString2, final Intent paramIntent, final String paramString3, final com.tencent.mm.pluginsdk.model.app.al paramal, final int paramInt)
  {
    AppMethodBeat.i(219600);
    if ((paramContext == null) || ((TextUtils.isEmpty(paramString1)) && (paramIntent == null)))
    {
      AppMethodBeat.o(219600);
      return false;
    }
    if (paramIntent != null) {
      a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219593);
          List localList = an.ac(this.val$context, paramIntent);
          if ((localList != null) && (!localList.isEmpty())) {
            h.a(this.val$context, paramIntent, paramString3, paramInt, new com.tencent.mm.pluginsdk.model.app.al()
            {
              public final void v(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
              {
                AppMethodBeat.i(219592);
                if (!paramAnonymous2Boolean1) {
                  an.gq(an.1.this.val$context);
                }
                if (an.1.this.zYT != null) {
                  an.1.this.zYT.v(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
                }
                AppMethodBeat.o(219592);
              }
            }, null);
          }
          AppMethodBeat.o(219593);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(219600);
      return true;
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = new Intent("android.intent.action.VIEW", Uri.parse(paramString2));
        paramString2.addFlags(268435456);
        paramString1 = ac(paramContext, paramString2);
        if ((paramString1 != null) && (!paramString1.isEmpty()))
        {
          if ((TextUtils.isEmpty(paramString2.getPackage())) && (paramString1.size() == 1)) {}
          for (paramString1 = h.b((ResolveInfo)paramString1.get(0));; paramString1 = paramString2.getPackage())
          {
            if (bu.nullAsNil(ak.getPackageName()).equals(paramString1)) {
              break label179;
            }
            a.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(219595);
                h.a(this.val$context, paramString2, paramString3, paramInt, new com.tencent.mm.pluginsdk.model.app.al()
                {
                  public final void v(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
                  {
                    AppMethodBeat.i(219594);
                    if (!paramAnonymous2Boolean1) {
                      an.gq(an.2.this.val$context);
                    }
                    if (an.2.this.zYT != null) {
                      an.2.this.zYT.v(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
                    }
                    AppMethodBeat.o(219594);
                  }
                }, null);
                AppMethodBeat.o(219595);
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
            AppMethodBeat.i(219597);
            Intent localIntent = this.val$context.getPackageManager().getLaunchIntentForPackage(paramString1);
            h.a(this.val$context, localIntent, paramString3, paramInt, new com.tencent.mm.pluginsdk.model.app.al()
            {
              public final void v(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
              {
                AppMethodBeat.i(219596);
                if (!paramAnonymous2Boolean1) {
                  an.gq(an.3.this.val$context);
                }
                if (an.3.this.zYT != null) {
                  an.3.this.zYT.v(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
                }
                AppMethodBeat.o(219596);
              }
            }, null);
            AppMethodBeat.o(219597);
          }
        });
      }
    }
  }
  
  public static boolean aBh(String paramString)
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
  
  public static String aBi(String paramString)
  {
    AppMethodBeat.i(96827);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96827);
      return "";
    }
    Object localObject = new k(b.asc().replace("/data/user/0", "/data/data"), "tmpLargeCanvasDir");
    if (!((k)localObject).exists()) {
      ((k)localObject).mkdirs();
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      localObject = w.B(new k((k)localObject, System.currentTimeMillis()).fTh());
      int i = o.f((String)localObject, paramString, paramString.length);
      if (i == 0)
      {
        AppMethodBeat.o(96827);
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      ae.e("LandingPageUtil", "writeTempCanvasXmlToLocal fail");
      AppMethodBeat.o(96827);
    }
    return "";
  }
  
  public static String aBj(String paramString)
  {
    AppMethodBeat.i(96828);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96828);
      return "";
    }
    try
    {
      k localk = new k(paramString);
      if (!localk.exists())
      {
        AppMethodBeat.o(96828);
        return "";
      }
      paramString = o.aZT(paramString);
      localk.delete();
      AppMethodBeat.o(96828);
      return paramString;
    }
    catch (Exception paramString)
    {
      ae.e("LandingPageUtil", "readTempCanvasXmlFromLocalAndDeleteIt fail");
      AppMethodBeat.o(96828);
    }
    return "";
  }
  
  public static void aG(Activity paramActivity)
  {
    AppMethodBeat.i(96821);
    boolean bool = com.tencent.mm.ui.al.aH(paramActivity);
    ae.i("LandingPageUtil", "setFullScreen, hasCut=".concat(String.valueOf(bool)));
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
  
  public static void aH(Activity paramActivity)
  {
    AppMethodBeat.i(219598);
    ae.i("LandingPageUtil", "setFullScreen");
    int i = 1542;
    if (Build.VERSION.SDK_INT >= 19) {
      i = 5638;
    }
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
    AppMethodBeat.o(219598);
  }
  
  public static List<ResolveInfo> ac(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(219599);
    try
    {
      paramContext = bu.ac(paramContext, paramIntent);
      AppMethodBeat.o(219599);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      ae.e("LandingPageUtil", "queryIntentActivities fail");
      AppMethodBeat.o(219599);
    }
    return null;
  }
  
  public static int bA(float paramFloat)
  {
    int j = (int)paramFloat;
    int i = j;
    if (paramFloat - j > 0.001D) {
      i = j + 1;
    }
    return i;
  }
  
  public static void f(String paramString, Context paramContext)
  {
    AppMethodBeat.i(96822);
    d.V(paramContext).b(new Intent(paramString));
    AppMethodBeat.o(96822);
  }
  
  public static Bitmap getBitmap(String paramString)
  {
    AppMethodBeat.i(96819);
    String str = b.asj() + "/sns_ad_landingpages";
    paramString = "adId" + "_image_" + aj.ej(paramString);
    paramString = str + "/" + paramString;
    if (o.fB(paramString))
    {
      paramString = BackwardSupportUtil.b.p(paramString, 1.0F);
      AppMethodBeat.o(96819);
      return paramString;
    }
    AppMethodBeat.o(96819);
    return null;
  }
  
  public static int[] gp(Context paramContext)
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
  
  public static void gq(Context paramContext)
  {
    AppMethodBeat.i(96823);
    f("com.tencent.mm.adlanding.set_uioption", paramContext);
    AppMethodBeat.o(96823);
  }
  
  public static Typeface gr(Context paramContext)
  {
    AppMethodBeat.i(96825);
    if (zYR == null) {
      zYR = Typeface.createFromAsset(paramContext.getAssets(), "fonts/WeChatNum.ttf");
    }
    paramContext = zYR;
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
    catch (URISyntaxException paramVarArgs)
    {
      ae.printErrStackTrace("LandingPageUtil", paramVarArgs, "", new Object[0]);
      AppMethodBeat.o(96824);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an
 * JD-Core Version:    0.7.0.1
 */