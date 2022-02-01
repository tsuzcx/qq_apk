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

public final class q
  extends s
{
  public static final String[] Dhs = { "application/msword", "application/vnd.ms-powerpoint", "application/vnd.ms-excel", "application/pdf", "application/epub+zip", "text/plain", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "application/zip", "application/rar" };
  public static final int[] Dht = { 2131689585, 2131689571, 2131689557, 2131689568, 2131689556, 2131689576, 2131689585, 2131689557, 2131689571, 2131689573, 2131689573 };
  public static final int[] Dhu = { 2131689585, 2131689571, 2131689557, 2131689568, 2131689556, 2131689576, 2131689585, 2131689557, 2131689571, 2131689573, 2131689573 };
  
  public static int aGb(String paramString)
  {
    AppMethodBeat.i(109472);
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
    while (i < Dhs.length)
    {
      if (Dhs[i].equals(localObject2)) {
        j = i;
      }
      i += 1;
    }
    if (j != -1)
    {
      i = Dht[j];
      AppMethodBeat.o(109472);
      return i;
    }
    AppMethodBeat.o(109472);
    return 2131689577;
  }
  
  public static int bH(Context paramContext, String paramString)
  {
    AppMethodBeat.i(109468);
    if (paramContext == null)
    {
      AppMethodBeat.o(109468);
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
          AppMethodBeat.o(109468);
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
            localObject1 = hk(paramContext);
            if (((a)localObject1).Dhv != -1) {
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
            localObject3 = hk(paramContext);
            if (((a)localObject3).Dhv != -1) {
              break;
            }
            AppMethodBeat.o(109468);
            return 4;
            label219:
            if (((a)localObject1).Dhv == 2)
            {
              i = ((a)localObject1).ver;
              if (i < 42)
              {
                i = 0;
                continue;
              }
            }
            i = 1;
          }
          if (((a)localObject3).Dhv != 2) {
            break label284;
          }
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(109468);
        return 2;
      }
    }
    if (((a)localObject3).ver < 33)
    {
      AppMethodBeat.o(109468);
      return 5;
    }
    label284:
    Object localObject2 = new Intent("android.intent.action.VIEW");
    if (((a)localObject3).Dhv == 2) {
      if ((((a)localObject3).ver >= 33) && (((a)localObject3).ver <= 39))
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
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.aeD(), "com/tencent/mm/pluginsdk/model/QQBrowserHelper", "loadUrl", "(Landroid/content/Context;Ljava/lang/String;)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramString.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/model/QQBrowserHelper", "loadUrl", "(Landroid/content/Context;Ljava/lang/String;)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(109468);
        return 0;
      }
      catch (ActivityNotFoundException paramContext)
      {
        AppMethodBeat.o(109468);
      }
      if ((((a)localObject3).ver >= 40) && (((a)localObject3).ver <= 45))
      {
        ((Intent)localObject2).setClassName("com.tencent.mtt", "com.tencent.mtt.SplashActivity");
        paramString = (String)localObject2;
      }
      else
      {
        paramString = (String)localObject2;
        if (((a)localObject3).ver >= 46)
        {
          localObject2 = new Intent("com.tencent.QQBrowser.action.VIEW");
          localObject3 = g(paramContext, (Uri)localObject1);
          paramString = (String)localObject2;
          if (localObject3 != null)
          {
            paramString = (String)localObject2;
            if (!TextUtils.isEmpty(((b)localObject3).classname))
            {
              ((Intent)localObject2).setClassName(((b)localObject3).Dhx, ((b)localObject3).classname);
              paramString = (String)localObject2;
              continue;
              if (((a)localObject3).Dhv == 1)
              {
                if (((a)localObject3).ver == 1)
                {
                  ((Intent)localObject2).setClassName("com.tencent.qbx5", "com.tencent.qbx5.PhotoEditUI");
                  paramString = (String)localObject2;
                }
                else
                {
                  paramString = (String)localObject2;
                  if (((a)localObject3).ver == 2)
                  {
                    ((Intent)localObject2).setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                    paramString = (String)localObject2;
                  }
                }
              }
              else if (((a)localObject3).Dhv == 0)
              {
                if ((((a)localObject3).ver >= 4) && (((a)localObject3).ver <= 6))
                {
                  ((Intent)localObject2).setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                  paramString = (String)localObject2;
                }
                else
                {
                  paramString = (String)localObject2;
                  if (((a)localObject3).ver > 6)
                  {
                    localObject2 = new Intent("com.tencent.QQBrowser.action.VIEW");
                    localObject3 = g(paramContext, (Uri)localObject1);
                    paramString = (String)localObject2;
                    if (localObject3 != null)
                    {
                      paramString = (String)localObject2;
                      if (!TextUtils.isEmpty(((b)localObject3).classname))
                      {
                        ((Intent)localObject2).setClassName(((b)localObject3).Dhx, ((b)localObject3).classname);
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
                  if (!TextUtils.isEmpty(((b)localObject3).classname))
                  {
                    ((Intent)localObject2).setClassName(((b)localObject3).Dhx, ((b)localObject3).classname);
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
  
  private static b g(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(109470);
    Object localObject = new Intent("com.tencent.QQBrowser.action.VIEW");
    ((Intent)localObject).setData(paramUri);
    paramUri = paramContext.getPackageManager().queryIntentActivities((Intent)localObject, 0);
    if (paramUri.size() <= 0)
    {
      AppMethodBeat.o(109470);
      return null;
    }
    paramContext = new b((byte)0);
    paramUri = paramUri.iterator();
    while (paramUri.hasNext())
    {
      localObject = (ResolveInfo)paramUri.next();
      String str = ((ResolveInfo)localObject).activityInfo.packageName;
      if (str.contains("com.tencent.mtt"))
      {
        paramContext.classname = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.Dhx = ((ResolveInfo)localObject).activityInfo.packageName;
        AppMethodBeat.o(109470);
        return paramContext;
      }
      if (str.contains("com.tencent.qbx"))
      {
        paramContext.classname = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.Dhx = ((ResolveInfo)localObject).activityInfo.packageName;
      }
    }
    AppMethodBeat.o(109470);
    return paramContext;
  }
  
  public static boolean hj(Context paramContext)
  {
    AppMethodBeat.i(109464);
    if (hk(paramContext).Dhv == -1)
    {
      AppMethodBeat.o(109464);
      return false;
    }
    AppMethodBeat.o(109464);
    return true;
  }
  
  private static a hk(Context paramContext)
  {
    AppMethodBeat.i(109469);
    locala = new a();
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
          locala.Dhv = 2;
          localObject1 = localObject6;
          locala.Dhw = "ADRQB_";
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
              locala.Dhw += ((PackageInfo)localObject6).versionName.replaceAll("\\.", "");
              AppMethodBeat.o(109469);
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
        locala.Dhv = 0;
        localObject4 = localObject1;
        locala.Dhw = "ADRQBX_";
        paramContext = (Context)localObject1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        try
        {
          localPackageInfo1 = localPackageManager.getPackageInfo("com.tencent.qbx5", 0);
          localObject4 = localPackageInfo1;
          locala.Dhv = 1;
          localObject4 = localPackageInfo1;
          locala.Dhw = "ADRQBX5_";
          paramContext = localPackageInfo1;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2)
        {
          localObject2 = localObject4;
          try
          {
            localObject4 = localPackageManager.getPackageInfo("com.tencent.mtt", 0);
            localObject2 = localObject4;
            locala.Dhv = 2;
            localObject2 = localObject4;
            locala.Dhw = "ADRQB_";
            paramContext = (Context)localObject4;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException4)
          {
            try
            {
              PackageInfo localPackageInfo2 = localPackageManager.getPackageInfo("com.tencent.mtt.x86", 0);
              localObject2 = localPackageInfo2;
              locala.Dhv = 2;
              localObject2 = localPackageInfo2;
              locala.Dhw = "ADRQB_";
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
                if (TextUtils.isEmpty(((b)localObject6).Dhx)) {
                  continue;
                }
                localObject5 = localObject2;
                paramContext = localPackageManager.getPackageInfo(((b)localObject6).Dhx, 0);
                localObject5 = paramContext;
                locala.Dhv = 2;
                localObject5 = paramContext;
                locala.Dhw = "ADRQB_";
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
      locala.Dhw += paramContext.versionName.replaceAll("\\.", "");
    }
    AppMethodBeat.o(109469);
    return locala;
  }
  
  public final String a(Context paramContext, ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(109467);
    if ((paramContext == null) || (paramResolveInfo == null) || (paramResolveInfo.activityInfo == null) || (paramResolveInfo.activityInfo.packageName == null))
    {
      AppMethodBeat.o(109467);
      return null;
    }
    Object localObject = paramResolveInfo.activityInfo.packageName;
    if ("com.qihoo.browser".equals(localObject))
    {
      AppMethodBeat.o(109467);
      return "360浏览器";
    }
    if ("com.mx.browser".equals(localObject))
    {
      AppMethodBeat.o(109467);
      return "傲游云浏览器";
    }
    if ("com.dolphin.browser.xf".equals(localObject))
    {
      AppMethodBeat.o(109467);
      return "海豚浏览器";
    }
    if ("com.UCMobile".equals(localObject))
    {
      AppMethodBeat.o(109467);
      return "UC浏览器";
    }
    if ("com.baidu.browser.apps".equals(localObject))
    {
      AppMethodBeat.o(109467);
      return "百度浏览器";
    }
    if ("sogou.mobile.explorer".equals(localObject))
    {
      AppMethodBeat.o(109467);
      return "搜狗浏览器";
    }
    if ("com.ijinshan.browser".equals(localObject))
    {
      AppMethodBeat.o(109467);
      return "猎豹浏览器";
    }
    if ("com.mediawoz.xbrowser".equals(localObject))
    {
      AppMethodBeat.o(109467);
      return "GO浏览器";
    }
    if ("com.oupeng.browser".equals(localObject))
    {
      AppMethodBeat.o(109467);
      return "欧朋浏览器";
    }
    if ("com.tiantianmini.android.browser".equals(localObject))
    {
      AppMethodBeat.o(109467);
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
        AppMethodBeat.o(109467);
        return paramContext;
      }
    }
    paramContext = paramResolveInfo.activityInfo.loadLabel(paramContext.getPackageManager()).toString();
    AppMethodBeat.o(109467);
    return paramContext;
  }
  
  public final boolean aFV(String paramString)
  {
    AppMethodBeat.i(109465);
    if (("com.tencent.mtt".equals(paramString)) || ("com.tencent.qbx".equals(paramString)) || ("com.tencent.mtt.x86".equals(paramString)) || ("com.tencent.qbx5".equals(paramString)))
    {
      AppMethodBeat.o(109465);
      return true;
    }
    AppMethodBeat.o(109465);
    return false;
  }
  
  public final String aNm()
  {
    return "http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10318";
  }
  
  public final boolean af(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(109471);
    paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 0);
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        paramIntent = ((ResolveInfo)paramContext.next()).activityInfo.packageName;
        if (paramIntent.contains("com.tencent.mtt"))
        {
          AppMethodBeat.o(109471);
          return true;
        }
        if (paramIntent.contains("com.tencent.qbx"))
        {
          AppMethodBeat.o(109471);
          return true;
        }
      }
    }
    AppMethodBeat.o(109471);
    return false;
  }
  
  public final String eKy()
  {
    return "qq_browser.apk";
  }
  
  public final t.a eKz()
  {
    AppMethodBeat.i(109466);
    t.a locala = new t.a();
    locala.DhB = 2131762069;
    locala.DhD = 2131762070;
    locala.DhA = 2131232696;
    AppMethodBeat.o(109466);
    return locala;
  }
  
  public final boolean hi(Context paramContext)
  {
    AppMethodBeat.i(109463);
    paramContext = hk(paramContext);
    if (paramContext.Dhv == -1)
    {
      AppMethodBeat.o(109463);
      return false;
    }
    if ((paramContext.Dhv == 2) && (paramContext.ver < 33))
    {
      AppMethodBeat.o(109463);
      return false;
    }
    AppMethodBeat.o(109463);
    return true;
  }
  
  public static final class a
  {
    public int Dhv = -1;
    public String Dhw = "";
    public int ver = -1;
  }
  
  static final class b
  {
    public String Dhx = "";
    public String classname = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.q
 * JD-Core Version:    0.7.0.1
 */