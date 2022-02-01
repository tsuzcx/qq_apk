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
import com.tencent.mm.loader.j.b;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.net.URI;
import java.util.List;

public final class ao
{
  private static Typeface Kup = null;
  
  public static Bitmap JL(String paramString)
  {
    AppMethodBeat.i(96819);
    String str = b.aSL() + "/sns_ad_landingpages";
    paramString = "adId" + "_image_" + MD5Util.getMD5String(paramString);
    paramString = str + "/" + paramString;
    if (u.agG(paramString))
    {
      paramString = BackwardSupportUtil.BitmapFactory.decodeFile(paramString, 1.0F);
      AppMethodBeat.o(96819);
      return paramString;
    }
    AppMethodBeat.o(96819);
    return null;
  }
  
  public static boolean a(Context paramContext, final String paramString1, final String paramString2, final Intent paramIntent, final String paramString3, final al paramal, final int paramInt)
  {
    AppMethodBeat.i(268041);
    if ((paramContext == null) || ((TextUtils.isEmpty(paramString1)) && (paramIntent == null)))
    {
      AppMethodBeat.o(268041);
      return false;
    }
    if (paramIntent != null) {
      com.tencent.mm.co.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(195904);
          List localList = ao.queryIntentActivities(this.val$context, paramIntent);
          if ((localList != null) && (!localList.isEmpty())) {
            h.a(this.val$context, paramIntent, paramString3, paramInt, new al()
            {
              public final void y(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
              {
                AppMethodBeat.i(230922);
                if (!paramAnonymous2Boolean1) {
                  ao.ic(ao.1.this.val$context);
                }
                if (ao.1.this.Kur != null) {
                  ao.1.this.Kur.y(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
                }
                AppMethodBeat.o(230922);
              }
            }, null);
          }
          AppMethodBeat.o(195904);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(268041);
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
            com.tencent.mm.co.a.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(207009);
                h.a(this.val$context, paramString2, paramString3, paramInt, new al()
                {
                  public final void y(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
                  {
                    AppMethodBeat.i(224448);
                    if (!paramAnonymous2Boolean1) {
                      ao.ic(ao.2.this.val$context);
                    }
                    if (ao.2.this.Kur != null) {
                      ao.2.this.Kur.y(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
                    }
                    AppMethodBeat.o(224448);
                  }
                }, null);
                AppMethodBeat.o(207009);
              }
            });
            break;
          }
        }
      }
      else
      {
        label179:
        com.tencent.mm.co.a.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(249251);
            Intent localIntent = this.val$context.getPackageManager().getLaunchIntentForPackage(paramString1);
            h.a(this.val$context, localIntent, paramString3, paramInt, new al()
            {
              public final void y(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
              {
                AppMethodBeat.i(212441);
                if (!paramAnonymous2Boolean1) {
                  ao.ic(ao.3.this.val$context);
                }
                if (ao.3.this.Kur != null) {
                  ao.3.this.Kur.y(paramAnonymous2Boolean1, paramAnonymous2Boolean2);
                }
                AppMethodBeat.o(212441);
              }
            }, null);
            AppMethodBeat.o(249251);
          }
        });
      }
    }
  }
  
  public static void aQ(Activity paramActivity)
  {
    AppMethodBeat.i(96821);
    boolean bool = ar.aN(paramActivity);
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
  
  public static void aR(Activity paramActivity)
  {
    AppMethodBeat.i(268037);
    Log.i("LandingPageUtil", "setFullScreen");
    int i = 1542;
    if (Build.VERSION.SDK_INT >= 19) {
      i = 5638;
    }
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
    AppMethodBeat.o(268037);
  }
  
  public static boolean bba(String paramString)
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
  
  public static String bbb(String paramString)
  {
    AppMethodBeat.i(96827);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96827);
      return "";
    }
    Object localObject = new q(b.aSE(), "tmpLargeCanvasDir");
    if (!((q)localObject).ifE()) {
      ((q)localObject).ifL();
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      localObject = new q((q)localObject, System.currentTimeMillis()).bOF();
      int i = u.f((String)localObject, paramString, paramString.length);
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
  
  public static String bbc(String paramString)
  {
    AppMethodBeat.i(96828);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96828);
      return "";
    }
    try
    {
      q localq = new q(paramString);
      if (!localq.ifE())
      {
        AppMethodBeat.o(96828);
        return "";
      }
      paramString = u.bBS(paramString);
      localq.cFq();
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
  
  public static int cc(float paramFloat)
  {
    int j = (int)paramFloat;
    int i = j;
    if (paramFloat - j > 0.001D) {
      i = j + 1;
    }
    return i;
  }
  
  public static int[] ib(Context paramContext)
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
  
  public static void ic(Context paramContext)
  {
    AppMethodBeat.i(96823);
    j("com.tencent.mm.adlanding.set_uioption", paramContext);
    AppMethodBeat.o(96823);
  }
  
  public static Typeface id(Context paramContext)
  {
    AppMethodBeat.i(96825);
    if (Kup == null) {
      Kup = Typeface.createFromAsset(paramContext.getAssets(), "fonts/WeChatNum.ttf");
    }
    paramContext = Kup;
    AppMethodBeat.o(96825);
    return paramContext;
  }
  
  public static void j(String paramString, Context paramContext)
  {
    AppMethodBeat.i(96822);
    androidx.h.a.a.V(paramContext).c(new Intent(paramString));
    AppMethodBeat.o(96822);
  }
  
  public static String m(String paramString, String... paramVarArgs)
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
    AppMethodBeat.i(268040);
    try
    {
      paramContext = Util.queryIntentActivities(paramContext, paramIntent);
      AppMethodBeat.o(268040);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      Log.e("LandingPageUtil", "queryIntentActivities fail");
      AppMethodBeat.o(268040);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao
 * JD-Core Version:    0.7.0.1
 */