package com.tencent.mm.pluginsdk.model;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class o
  extends q
{
  public static final String[] vKA = { "application/msword", "application/vnd.ms-powerpoint", "application/vnd.ms-excel", "application/pdf", "application/epub+zip", "text/plain", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "application/zip", "application/rar" };
  public static final int[] vKB = { 2131230830, 2131230816, 2131230802, 2131230813, 2131230801, 2131230821, 2131230830, 2131230802, 2131230816, 2131230818, 2131230818 };
  public static final int[] vKC = { 2131230830, 2131230816, 2131230802, 2131230813, 2131230801, 2131230821, 2131230830, 2131230802, 2131230816, 2131230818, 2131230818 };
  
  public static int alm(String paramString)
  {
    AppMethodBeat.i(125828);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.length() > 0) {
        localObject1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() != 0) {}
    }
    else
    {
      localObject2 = "*/".concat(String.valueOf(paramString));
    }
    int i = 0;
    int j = -1;
    while (i < vKA.length)
    {
      if (vKA[i].equals(localObject2)) {
        j = i;
      }
      i += 1;
    }
    if (j != -1)
    {
      i = vKB[j];
      AppMethodBeat.o(125828);
      return i;
    }
    AppMethodBeat.o(125828);
    return 2131230822;
  }
  
  public static int bt(Context paramContext, String paramString)
  {
    AppMethodBeat.i(125824);
    if (paramContext == null)
    {
      AppMethodBeat.o(125824);
      return 3;
    }
    boolean bool;
    if ((paramString == null) || (paramString.length() == 0)) {
      bool = false;
    }
    Object localObject1;
    Object localObject3;
    for (;;)
    {
      localObject2 = paramString;
      if (!bool) {
        localObject2 = "http://".concat(String.valueOf(paramString));
      }
      try
      {
        paramString = Uri.parse((String)localObject2);
        int i;
        if (paramString == null)
        {
          AppMethodBeat.o(125824);
          return 2;
          localObject1 = paramString.trim();
          i = ((String)localObject1).toLowerCase().indexOf("://");
          int j = ((String)localObject1).toLowerCase().indexOf('.');
          if ((i > 0) && (j > 0) && (i > j)) {
            bool = false;
          } else {
            bool = ((String)localObject1).toLowerCase().contains("://");
          }
        }
        else
        {
          localObject1 = paramString;
          if (paramString.getScheme().toLowerCase().equals("qb"))
          {
            localObject1 = fN(paramContext);
            if (((o.a)localObject1).vKD != -1) {
              break label219;
            }
            i = 0;
          }
          for (;;)
          {
            localObject1 = paramString;
            if (i == 0) {
              localObject1 = Uri.parse("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10375" + URLEncoder.encode((String)localObject2, "UTF-8"));
            }
            localObject3 = fN(paramContext);
            if (((o.a)localObject3).vKD != -1) {
              break;
            }
            AppMethodBeat.o(125824);
            return 4;
            label219:
            if (((o.a)localObject1).vKD == 2)
            {
              i = ((o.a)localObject1).ver;
              if (i < 42)
              {
                i = 0;
                continue;
              }
            }
            i = 1;
          }
          if (((o.a)localObject3).vKD != 2) {
            break label284;
          }
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(125824);
        return 2;
      }
    }
    if (((o.a)localObject3).ver < 33)
    {
      AppMethodBeat.o(125824);
      return 5;
    }
    label284:
    Object localObject2 = new Intent("android.intent.action.VIEW");
    if (((o.a)localObject3).vKD == 2) {
      if ((((o.a)localObject3).ver >= 33) && (((o.a)localObject3).ver <= 39))
      {
        ((Intent)localObject2).setClassName("com.tencent.mtt", "com.tencent.mtt.PhotoEditUI");
        paramString = (String)localObject2;
      }
    }
    for (;;)
    {
      paramString.setData((Uri)localObject1);
      try
      {
        paramString.putExtra("loginType", 24);
        paramString.putExtra("ChannelID", "com.tencent.mm");
        paramString.putExtra("PosID", 0);
        paramContext.startActivity(paramString);
        AppMethodBeat.o(125824);
        return 0;
      }
      catch (ActivityNotFoundException paramContext)
      {
        AppMethodBeat.o(125824);
      }
      if ((((o.a)localObject3).ver >= 40) && (((o.a)localObject3).ver <= 45))
      {
        ((Intent)localObject2).setClassName("com.tencent.mtt", "com.tencent.mtt.SplashActivity");
        paramString = (String)localObject2;
      }
      else
      {
        paramString = (String)localObject2;
        if (((o.a)localObject3).ver >= 46)
        {
          localObject2 = new Intent("com.tencent.QQBrowser.action.VIEW");
          localObject3 = g(paramContext, (Uri)localObject1);
          paramString = (String)localObject2;
          if (localObject3 != null)
          {
            paramString = (String)localObject2;
            if (!TextUtils.isEmpty(((o.b)localObject3).classname))
            {
              ((Intent)localObject2).setClassName(((o.b)localObject3).vKF, ((o.b)localObject3).classname);
              paramString = (String)localObject2;
              continue;
              if (((o.a)localObject3).vKD == 1)
              {
                if (((o.a)localObject3).ver == 1)
                {
                  ((Intent)localObject2).setClassName("com.tencent.qbx5", "com.tencent.qbx5.PhotoEditUI");
                  paramString = (String)localObject2;
                }
                else
                {
                  paramString = (String)localObject2;
                  if (((o.a)localObject3).ver == 2)
                  {
                    ((Intent)localObject2).setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                    paramString = (String)localObject2;
                  }
                }
              }
              else if (((o.a)localObject3).vKD == 0)
              {
                if ((((o.a)localObject3).ver >= 4) && (((o.a)localObject3).ver <= 6))
                {
                  ((Intent)localObject2).setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                  paramString = (String)localObject2;
                }
                else
                {
                  paramString = (String)localObject2;
                  if (((o.a)localObject3).ver > 6)
                  {
                    localObject2 = new Intent("com.tencent.QQBrowser.action.VIEW");
                    localObject3 = g(paramContext, (Uri)localObject1);
                    paramString = (String)localObject2;
                    if (localObject3 != null)
                    {
                      paramString = (String)localObject2;
                      if (!TextUtils.isEmpty(((o.b)localObject3).classname))
                      {
                        ((Intent)localObject2).setClassName(((o.b)localObject3).vKF, ((o.b)localObject3).classname);
                        paramString = (String)localObject2;
                      }
                    }
                  }
                }
              }
              else
              {
                localObject2 = new Intent("com.tencent.QQBrowser.action.VIEW");
                localObject3 = g(paramContext, (Uri)localObject1);
                paramString = (String)localObject2;
                if (localObject3 != null)
                {
                  paramString = (String)localObject2;
                  if (!TextUtils.isEmpty(((o.b)localObject3).classname))
                  {
                    ((Intent)localObject2).setClassName(((o.b)localObject3).vKF, ((o.b)localObject3).classname);
                    paramString = (String)localObject2;
                  }
                }
              }
            }
          }
        }
      }
    }
    return 4;
  }
  
  public static boolean fM(Context paramContext)
  {
    AppMethodBeat.i(125820);
    if (fN(paramContext).vKD == -1)
    {
      AppMethodBeat.o(125820);
      return false;
    }
    AppMethodBeat.o(125820);
    return true;
  }
  
  private static o.a fN(Context paramContext)
  {
    AppMethodBeat.i(125825);
    locala = new o.a();
    for (;;)
    {
      try
      {
        localPackageManager = paramContext.getPackageManager();
        localObject1 = null;
        try
        {
          localObject6 = localPackageManager.getPackageInfo("com.tencent.mtt", 0);
          localObject1 = localObject6;
          locala.vKD = 2;
          localObject1 = localObject6;
          locala.vKE = "ADRQB_";
          Object localObject3 = localObject6;
          if (localObject6 != null)
          {
            localObject1 = localObject6;
            localObject3 = localObject6;
            if (((PackageInfo)localObject6).versionCode > 420000)
            {
              localObject1 = localObject6;
              locala.ver = ((PackageInfo)localObject6).versionCode;
              localObject1 = localObject6;
              locala.vKE += ((PackageInfo)localObject6).versionName.replaceAll("\\.", "");
              AppMethodBeat.o(125825);
              return locala;
            }
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException3)
        {
          localObject4 = localObject1;
        }
      }
      catch (Exception paramContext)
      {
        PackageManager localPackageManager;
        Object localObject1;
        Object localObject6;
        Object localObject4;
        PackageInfo localPackageInfo1;
        Object localObject2;
        continue;
      }
      try
      {
        localObject1 = localPackageManager.getPackageInfo("com.tencent.qbx", 0);
        localObject4 = localObject1;
        locala.vKD = 0;
        localObject4 = localObject1;
        locala.vKE = "ADRQBX_";
        paramContext = (Context)localObject1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        try
        {
          localPackageInfo1 = localPackageManager.getPackageInfo("com.tencent.qbx5", 0);
          localObject4 = localPackageInfo1;
          locala.vKD = 1;
          localObject4 = localPackageInfo1;
          locala.vKE = "ADRQBX5_";
          paramContext = localPackageInfo1;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2)
        {
          localObject2 = localObject4;
          try
          {
            localObject4 = localPackageManager.getPackageInfo("com.tencent.mtt", 0);
            localObject2 = localObject4;
            locala.vKD = 2;
            localObject2 = localObject4;
            locala.vKE = "ADRQB_";
            paramContext = (Context)localObject4;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException4)
          {
            try
            {
              PackageInfo localPackageInfo2 = localPackageManager.getPackageInfo("com.tencent.mtt.x86", 0);
              localObject2 = localPackageInfo2;
              locala.vKD = 2;
              localObject2 = localPackageInfo2;
              locala.vKE = "ADRQB_";
              paramContext = localPackageInfo2;
            }
            catch (Exception localException)
            {
              Object localObject5 = localObject2;
              try
              {
                localObject6 = g(paramContext, Uri.parse("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10375"));
                paramContext = localObject2;
                if (localObject6 == null) {
                  continue;
                }
                paramContext = localObject2;
                localObject5 = localObject2;
                if (TextUtils.isEmpty(((o.b)localObject6).vKF)) {
                  continue;
                }
                localObject5 = localObject2;
                paramContext = localPackageManager.getPackageInfo(((o.b)localObject6).vKF, 0);
                localObject5 = paramContext;
                locala.vKD = 2;
                localObject5 = paramContext;
                locala.vKE = "ADRQB_";
              }
              catch (Exception paramContext)
              {
                paramContext = (Context)localObject5;
              }
            }
          }
        }
      }
    }
    if (paramContext != null)
    {
      locala.ver = paramContext.versionCode;
      locala.vKE += paramContext.versionName.replaceAll("\\.", "");
    }
    AppMethodBeat.o(125825);
    return locala;
  }
  
  private static o.b g(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(125826);
    Object localObject = new Intent("com.tencent.QQBrowser.action.VIEW");
    ((Intent)localObject).setData(paramUri);
    paramUri = paramContext.getPackageManager().queryIntentActivities((Intent)localObject, 0);
    if (paramUri.size() <= 0)
    {
      AppMethodBeat.o(125826);
      return null;
    }
    paramContext = new o.b((byte)0);
    paramUri = paramUri.iterator();
    while (paramUri.hasNext())
    {
      localObject = (ResolveInfo)paramUri.next();
      String str = ((ResolveInfo)localObject).activityInfo.packageName;
      if (str.contains("com.tencent.mtt"))
      {
        paramContext.classname = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.vKF = ((ResolveInfo)localObject).activityInfo.packageName;
        AppMethodBeat.o(125826);
        return paramContext;
      }
      if (str.contains("com.tencent.qbx"))
      {
        paramContext.classname = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.vKF = ((ResolveInfo)localObject).activityInfo.packageName;
      }
    }
    AppMethodBeat.o(125826);
    return paramContext;
  }
  
  public final boolean F(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(125827);
    paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 0);
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        paramIntent = ((ResolveInfo)paramContext.next()).activityInfo.packageName;
        if (paramIntent.contains("com.tencent.mtt"))
        {
          AppMethodBeat.o(125827);
          return true;
        }
        if (paramIntent.contains("com.tencent.qbx"))
        {
          AppMethodBeat.o(125827);
          return true;
        }
      }
    }
    AppMethodBeat.o(125827);
    return false;
  }
  
  public final String a(Context paramContext, ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(125823);
    if ((paramContext == null) || (paramResolveInfo == null) || (paramResolveInfo.activityInfo == null) || (paramResolveInfo.activityInfo.packageName == null))
    {
      AppMethodBeat.o(125823);
      return null;
    }
    Object localObject = paramResolveInfo.activityInfo.packageName;
    if ("com.qihoo.browser".equals(localObject))
    {
      AppMethodBeat.o(125823);
      return "360浏览器";
    }
    if ("com.mx.browser".equals(localObject))
    {
      AppMethodBeat.o(125823);
      return "傲游云浏览器";
    }
    if ("com.dolphin.browser.xf".equals(localObject))
    {
      AppMethodBeat.o(125823);
      return "海豚浏览器";
    }
    if ("com.UCMobile".equals(localObject))
    {
      AppMethodBeat.o(125823);
      return "UC浏览器";
    }
    if ("com.baidu.browser.apps".equals(localObject))
    {
      AppMethodBeat.o(125823);
      return "百度浏览器";
    }
    if ("sogou.mobile.explorer".equals(localObject))
    {
      AppMethodBeat.o(125823);
      return "搜狗浏览器";
    }
    if ("com.ijinshan.browser".equals(localObject))
    {
      AppMethodBeat.o(125823);
      return "猎豹浏览器";
    }
    if ("com.mediawoz.xbrowser".equals(localObject))
    {
      AppMethodBeat.o(125823);
      return "GO浏览器";
    }
    if ("com.oupeng.browser".equals(localObject))
    {
      AppMethodBeat.o(125823);
      return "欧朋浏览器";
    }
    if ("com.tiantianmini.android.browser".equals(localObject))
    {
      AppMethodBeat.o(125823);
      return "天天浏览器";
    }
    localObject = paramResolveInfo.activityInfo.loadLabel(paramContext.getPackageManager());
    if (localObject != null)
    {
      localObject = ((CharSequence)localObject).toString();
      localObject = Pattern.compile("\\(.*推荐.*\\)", 2).matcher((CharSequence)localObject);
      if (((Matcher)localObject).find())
      {
        paramContext = ((Matcher)localObject).replaceAll("");
        AppMethodBeat.o(125823);
        return paramContext;
      }
    }
    paramContext = paramResolveInfo.activityInfo.loadLabel(paramContext.getPackageManager()).toString();
    AppMethodBeat.o(125823);
    return paramContext;
  }
  
  public final boolean alg(String paramString)
  {
    AppMethodBeat.i(125821);
    if (("com.tencent.mtt".equals(paramString)) || ("com.tencent.qbx".equals(paramString)) || ("com.tencent.mtt.x86".equals(paramString)) || ("com.tencent.qbx5".equals(paramString)))
    {
      AppMethodBeat.o(125821);
      return true;
    }
    AppMethodBeat.o(125821);
    return false;
  }
  
  public final String aoo()
  {
    return "http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10318";
  }
  
  public final String dkX()
  {
    return "qq_browser.apk";
  }
  
  public final r.a dkY()
  {
    AppMethodBeat.i(125822);
    r.a locala = new r.a();
    locala.vKJ = 2131302192;
    locala.vKL = 2131302193;
    locala.vKI = 2130839137;
    AppMethodBeat.o(125822);
    return locala;
  }
  
  public final boolean fL(Context paramContext)
  {
    AppMethodBeat.i(125819);
    paramContext = fN(paramContext);
    if (paramContext.vKD == -1)
    {
      AppMethodBeat.o(125819);
      return false;
    }
    if ((paramContext.vKD == 2) && (paramContext.ver < 33))
    {
      AppMethodBeat.o(125819);
      return false;
    }
    AppMethodBeat.o(125819);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.o
 * JD-Core Version:    0.7.0.1
 */