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
import com.tencent.mm.plugin.d.a.b;
import com.tencent.mm.plugin.d.a.e;
import com.tencent.mm.plugin.d.a.f;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class o
  extends r
{
  public static final String[] rTD = { "application/msword", "application/vnd.ms-powerpoint", "application/vnd.ms-excel", "application/pdf", "application/epub+zip", "text/plain", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "application/zip", "application/rar" };
  public static final int[] rTE = { a.e.app_attach_file_icon_word, a.e.app_attach_file_icon_ppt, a.e.app_attach_file_icon_excel, a.e.app_attach_file_icon_pdf, a.e.app_attach_file_icon_epub, a.e.app_attach_file_icon_txt, a.e.app_attach_file_icon_word, a.e.app_attach_file_icon_excel, a.e.app_attach_file_icon_ppt, a.e.app_attach_file_icon_rar, a.e.app_attach_file_icon_rar };
  public static final int[] rTF = { a.e.app_attach_file_icon_word, a.e.app_attach_file_icon_ppt, a.e.app_attach_file_icon_excel, a.e.app_attach_file_icon_pdf, a.e.app_attach_file_icon_epub, a.e.app_attach_file_icon_txt, a.e.app_attach_file_icon_word, a.e.app_attach_file_icon_excel, a.e.app_attach_file_icon_ppt, a.e.app_attach_file_icon_rar, a.e.app_attach_file_icon_rar };
  
  public static boolean VO(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = rTD;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static int VP(String paramString)
  {
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
      localObject2 = "*/" + paramString;
    }
    int i = 0;
    int j = -1;
    while (i < rTD.length)
    {
      if (rTD[i].equals(localObject2)) {
        j = i;
      }
      i += 1;
    }
    if (j != -1) {
      return rTE[j];
    }
    return a.e.app_attach_file_icon_unknow;
  }
  
  public static int bh(Context paramContext, String paramString)
  {
    if (paramContext == null) {
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
        localObject2 = "http://" + paramString;
      }
      try
      {
        paramString = Uri.parse((String)localObject2);
        int i;
        if (paramString == null)
        {
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
            localObject1 = eN(paramContext);
            if (((o.a)localObject1).rTG != -1) {
              break label206;
            }
            i = 0;
          }
          for (;;)
          {
            localObject1 = paramString;
            if (i == 0) {
              localObject1 = Uri.parse("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10375" + URLEncoder.encode((String)localObject2, "UTF-8"));
            }
            localObject3 = eN(paramContext);
            if (((o.a)localObject3).rTG != -1) {
              break;
            }
            return 4;
            label206:
            if (((o.a)localObject1).rTG == 2)
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
          if (((o.a)localObject3).rTG != 2) {
            break label261;
          }
        }
      }
      catch (Exception paramContext)
      {
        return 2;
      }
    }
    if (((o.a)localObject3).ver < 33) {
      return 5;
    }
    label261:
    Object localObject2 = new Intent("android.intent.action.VIEW");
    if (((o.a)localObject3).rTG == 2) {
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
        return 0;
      }
      catch (ActivityNotFoundException paramContext) {}
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
          localObject3 = f(paramContext, (Uri)localObject1);
          paramString = (String)localObject2;
          if (localObject3 != null)
          {
            paramString = (String)localObject2;
            if (!TextUtils.isEmpty(((o.b)localObject3).classname))
            {
              ((Intent)localObject2).setClassName(((o.b)localObject3).rTI, ((o.b)localObject3).classname);
              paramString = (String)localObject2;
              continue;
              if (((o.a)localObject3).rTG == 1)
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
              else if (((o.a)localObject3).rTG == 0)
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
                    localObject3 = f(paramContext, (Uri)localObject1);
                    paramString = (String)localObject2;
                    if (localObject3 != null)
                    {
                      paramString = (String)localObject2;
                      if (!TextUtils.isEmpty(((o.b)localObject3).classname))
                      {
                        ((Intent)localObject2).setClassName(((o.b)localObject3).rTI, ((o.b)localObject3).classname);
                        paramString = (String)localObject2;
                      }
                    }
                  }
                }
              }
              else
              {
                localObject2 = new Intent("com.tencent.QQBrowser.action.VIEW");
                localObject3 = f(paramContext, (Uri)localObject1);
                paramString = (String)localObject2;
                if (localObject3 != null)
                {
                  paramString = (String)localObject2;
                  if (!TextUtils.isEmpty(((o.b)localObject3).classname))
                  {
                    ((Intent)localObject2).setClassName(((o.b)localObject3).rTI, ((o.b)localObject3).classname);
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
  
  public static boolean eM(Context paramContext)
  {
    return eN(paramContext).rTG != -1;
  }
  
  private static o.a eN(Context paramContext)
  {
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
          locala.rTG = 2;
          localObject1 = localObject6;
          locala.rTH = "ADRQB_";
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
              locala.rTH += ((PackageInfo)localObject6).versionName.replaceAll("\\.", "");
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
        locala.rTG = 0;
        localObject4 = localObject1;
        locala.rTH = "ADRQBX_";
        paramContext = (Context)localObject1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        try
        {
          localPackageInfo1 = localPackageManager.getPackageInfo("com.tencent.qbx5", 0);
          localObject4 = localPackageInfo1;
          locala.rTG = 1;
          localObject4 = localPackageInfo1;
          locala.rTH = "ADRQBX5_";
          paramContext = localPackageInfo1;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2)
        {
          localObject2 = localObject4;
          try
          {
            localObject4 = localPackageManager.getPackageInfo("com.tencent.mtt", 0);
            localObject2 = localObject4;
            locala.rTG = 2;
            localObject2 = localObject4;
            locala.rTH = "ADRQB_";
            paramContext = (Context)localObject4;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException4)
          {
            try
            {
              PackageInfo localPackageInfo2 = localPackageManager.getPackageInfo("com.tencent.mtt.x86", 0);
              localObject2 = localPackageInfo2;
              locala.rTG = 2;
              localObject2 = localPackageInfo2;
              locala.rTH = "ADRQB_";
              paramContext = localPackageInfo2;
            }
            catch (Exception localException)
            {
              Object localObject5 = localObject2;
              try
              {
                localObject6 = f(paramContext, Uri.parse("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10375"));
                paramContext = localObject2;
                if (localObject6 == null) {
                  continue;
                }
                paramContext = localObject2;
                localObject5 = localObject2;
                if (TextUtils.isEmpty(((o.b)localObject6).rTI)) {
                  continue;
                }
                localObject5 = localObject2;
                paramContext = localPackageManager.getPackageInfo(((o.b)localObject6).rTI, 0);
                localObject5 = paramContext;
                locala.rTG = 2;
                localObject5 = paramContext;
                locala.rTH = "ADRQB_";
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
      locala.rTH += paramContext.versionName.replaceAll("\\.", "");
    }
    return locala;
  }
  
  private static o.b f(Context paramContext, Uri paramUri)
  {
    Object localObject = new Intent("com.tencent.QQBrowser.action.VIEW");
    ((Intent)localObject).setData(paramUri);
    paramUri = paramContext.getPackageManager().queryIntentActivities((Intent)localObject, 0);
    if (paramUri.size() <= 0) {
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
        paramContext.rTI = ((ResolveInfo)localObject).activityInfo.packageName;
        return paramContext;
      }
      if (str.contains("com.tencent.qbx"))
      {
        paramContext.classname = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.rTI = ((ResolveInfo)localObject).activityInfo.packageName;
      }
    }
    return paramContext;
  }
  
  public final String UP()
  {
    return "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10318";
  }
  
  public final boolean VJ(String paramString)
  {
    return ("com.tencent.mtt".equals(paramString)) || ("com.tencent.qbx".equals(paramString)) || ("com.tencent.mtt.x86".equals(paramString)) || ("com.tencent.qbx5".equals(paramString));
  }
  
  public final String a(Context paramContext, ResolveInfo paramResolveInfo)
  {
    if ((paramContext == null) || (paramResolveInfo == null) || (paramResolveInfo.activityInfo == null) || (paramResolveInfo.activityInfo.packageName == null)) {
      return null;
    }
    Object localObject = paramResolveInfo.activityInfo.packageName;
    if ("com.qihoo.browser".equals(localObject)) {
      return "360浏览器";
    }
    if ("com.mx.browser".equals(localObject)) {
      return "傲游云浏览器";
    }
    if ("com.dolphin.browser.xf".equals(localObject)) {
      return "海豚浏览器";
    }
    if ("com.UCMobile".equals(localObject)) {
      return "UC浏览器";
    }
    if ("com.baidu.browser.apps".equals(localObject)) {
      return "百度浏览器";
    }
    if ("sogou.mobile.explorer".equals(localObject)) {
      return "搜狗浏览器";
    }
    if ("com.ijinshan.browser".equals(localObject)) {
      return "猎豹浏览器";
    }
    if ("com.mediawoz.xbrowser".equals(localObject)) {
      return "GO浏览器";
    }
    if ("com.oupeng.browser".equals(localObject)) {
      return "欧朋浏览器";
    }
    if ("com.tiantianmini.android.browser".equals(localObject)) {
      return "天天浏览器";
    }
    localObject = paramResolveInfo.activityInfo.loadLabel(paramContext.getPackageManager());
    if (localObject != null)
    {
      localObject = ((CharSequence)localObject).toString();
      localObject = Pattern.compile("\\(.*推荐.*\\)", 2).matcher((CharSequence)localObject);
      if (((Matcher)localObject).find()) {
        return ((Matcher)localObject).replaceAll("");
      }
    }
    return paramResolveInfo.activityInfo.loadLabel(paramContext.getPackageManager()).toString();
  }
  
  public final String cks()
  {
    return "qq_browser.apk";
  }
  
  public final s.a ckt()
  {
    s.a locala = new s.a();
    locala.rTM = a.f.qq_browser_desc_for_wb;
    locala.rTO = a.f.qq_browser_lable;
    locala.rTL = a.b.icon_qqbrowser;
    return locala;
  }
  
  public final boolean eL(Context paramContext)
  {
    paramContext = eN(paramContext);
    if (paramContext.rTG == -1) {}
    while ((paramContext.rTG == 2) && (paramContext.ver < 33)) {
      return false;
    }
    return true;
  }
  
  public final boolean y(Context paramContext, Intent paramIntent)
  {
    paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 0);
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        paramIntent = ((ResolveInfo)paramContext.next()).activityInfo.packageName;
        if (paramIntent.contains("com.tencent.mtt")) {
          return true;
        }
        if (paramIntent.contains("com.tencent.qbx")) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.o
 * JD-Core Version:    0.7.0.1
 */