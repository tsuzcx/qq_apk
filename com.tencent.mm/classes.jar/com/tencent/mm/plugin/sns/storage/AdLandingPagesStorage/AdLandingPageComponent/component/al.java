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
import com.tencent.mm.ci.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public final class al
{
  private static Typeface yqA = null;
  
  public static boolean a(Context paramContext, final String paramString1, final String paramString2, final Intent paramIntent, final String paramString3, final am paramam)
  {
    AppMethodBeat.i(200303);
    if ((paramContext == null) || ((TextUtils.isEmpty(paramString1)) && (paramIntent == null)))
    {
      AppMethodBeat.o(200303);
      return false;
    }
    if (paramIntent != null) {
      a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200296);
          List localList = al.aa(this.val$context, paramIntent);
          if ((localList != null) && (!localList.isEmpty())) {
            h.a(this.val$context, paramIntent, paramString3, new am()
            {
              public final void v(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
              {
                AppMethodBeat.i(200295);
                if (!paramAnonymous2Boolean1) {
                  al.gh(al.1.this.val$context);
                }
                if (al.1.this.yqC != null) {
                  al.1.this.yqC.v(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
                }
                AppMethodBeat.o(200295);
              }
            });
          }
          AppMethodBeat.o(200296);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(200303);
      return true;
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = new Intent("android.intent.action.VIEW", Uri.parse(paramString2));
        paramString2.addFlags(268435456);
        paramString1 = aa(paramContext, paramString2);
        if ((paramString1 != null) && (!paramString1.isEmpty()))
        {
          if ((TextUtils.isEmpty(paramString2.getPackage())) && (paramString1.size() == 1)) {}
          for (paramString1 = h.b((ResolveInfo)paramString1.get(0));; paramString1 = paramString2.getPackage())
          {
            if (bs.nullAsNil(ai.getPackageName()).equals(paramString1)) {
              break label175;
            }
            a.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(200298);
                h.a(this.val$context, paramString2, paramString3, new am()
                {
                  public final void v(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
                  {
                    AppMethodBeat.i(200297);
                    if (!paramAnonymous2Boolean1) {
                      al.gh(al.2.this.val$context);
                    }
                    if (al.2.this.yqC != null) {
                      al.2.this.yqC.v(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
                    }
                    AppMethodBeat.o(200297);
                  }
                });
                AppMethodBeat.o(200298);
              }
            });
            break;
          }
        }
      }
      else
      {
        label175:
        a.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200300);
            Intent localIntent = this.val$context.getPackageManager().getLaunchIntentForPackage(paramString1);
            h.a(this.val$context, localIntent, paramString3, new am()
            {
              public final void v(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
              {
                AppMethodBeat.i(200299);
                if (!paramAnonymous2Boolean1) {
                  al.gh(al.3.this.val$context);
                }
                if (al.3.this.yqC != null) {
                  al.3.this.yqC.v(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
                }
                AppMethodBeat.o(200299);
              }
            });
            AppMethodBeat.o(200300);
          }
        });
      }
    }
  }
  
  public static void aF(Activity paramActivity)
  {
    AppMethodBeat.i(96821);
    boolean bool = aj.aG(paramActivity);
    ac.i("LandingPageUtil", "setFullScreen, hasCut=".concat(String.valueOf(bool)));
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
  
  public static void aG(Activity paramActivity)
  {
    AppMethodBeat.i(200301);
    ac.i("LandingPageUtil", "setFullScreen");
    int i = 1542;
    if (Build.VERSION.SDK_INT >= 19) {
      i = 5638;
    }
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
    AppMethodBeat.o(200301);
  }
  
  public static List<ResolveInfo> aa(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(200302);
    try
    {
      paramContext = bs.aa(paramContext, paramIntent);
      AppMethodBeat.o(200302);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      ac.e("LandingPageUtil", "queryIntentActivities fail");
      AppMethodBeat.o(200302);
    }
    return null;
  }
  
  public static boolean auJ(String paramString)
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
  
  public static String auK(String paramString)
  {
    AppMethodBeat.i(96827);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96827);
      return "";
    }
    Object localObject = new e(b.apa().replace("/data/user/0", "/data/data"), "tmpLargeCanvasDir");
    if (!((e)localObject).exists()) {
      ((e)localObject).mkdirs();
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      localObject = q.B(new e((e)localObject, System.currentTimeMillis()).fxV());
      int i = i.f((String)localObject, paramString, paramString.length);
      if (i == 0)
      {
        AppMethodBeat.o(96827);
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      ac.e("LandingPageUtil", "writeTempCanvasXmlToLocal fail");
      AppMethodBeat.o(96827);
    }
    return "";
  }
  
  public static String auL(String paramString)
  {
    AppMethodBeat.i(96828);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96828);
      return "";
    }
    try
    {
      e locale = new e(paramString);
      if (!locale.exists())
      {
        AppMethodBeat.o(96828);
        return "";
      }
      paramString = i.aSr(paramString);
      locale.delete();
      AppMethodBeat.o(96828);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.e("LandingPageUtil", "readTempCanvasXmlFromLocalAndDeleteIt fail");
      AppMethodBeat.o(96828);
    }
    return "";
  }
  
  public static int bz(float paramFloat)
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
    d.U(paramContext).b(new Intent(paramString));
    AppMethodBeat.o(96822);
  }
  
  public static Bitmap getBitmap(String paramString)
  {
    AppMethodBeat.i(96819);
    String str = b.aph() + "/sns_ad_landingpages";
    paramString = "adId" + "_image_" + ah.dg(paramString);
    paramString = str + "/" + paramString;
    if (i.eA(paramString))
    {
      paramString = BackwardSupportUtil.b.n(paramString, 1.0F);
      AppMethodBeat.o(96819);
      return paramString;
    }
    AppMethodBeat.o(96819);
    return null;
  }
  
  public static int[] gg(Context paramContext)
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
  
  public static void gh(Context paramContext)
  {
    AppMethodBeat.i(96823);
    f("com.tencent.mm.adlanding.set_uioption", paramContext);
    AppMethodBeat.o(96823);
  }
  
  public static Typeface gi(Context paramContext)
  {
    AppMethodBeat.i(96825);
    if (yqA == null) {
      yqA = Typeface.createFromAsset(paramContext.getAssets(), "fonts/WeChatNum.ttf");
    }
    paramContext = yqA;
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
      ac.printErrStackTrace("LandingPageUtil", paramVarArgs, "", new Object[0]);
      AppMethodBeat.o(96824);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al
 * JD-Core Version:    0.7.0.1
 */