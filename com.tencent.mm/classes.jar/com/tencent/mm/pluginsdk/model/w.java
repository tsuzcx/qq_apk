package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.d.a.b;
import com.tencent.mm.plugin.d.a.f;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class w
  extends r
{
  public final String UP()
  {
    return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
  }
  
  public final boolean VJ(String paramString)
  {
    return (paramString != null) && ("com.tencent.map".equals(paramString));
  }
  
  public final String a(Context paramContext, ResolveInfo paramResolveInfo)
  {
    if ((paramContext == null) || (paramResolveInfo == null) || (paramResolveInfo.activityInfo == null)) {}
    do
    {
      return null;
      paramContext = paramResolveInfo.activityInfo.loadLabel(paramContext.getPackageManager());
    } while (paramContext == null);
    paramResolveInfo = paramContext.toString();
    paramResolveInfo = Pattern.compile("\\(.*推荐.*\\)", 2).matcher(paramResolveInfo);
    if (paramResolveInfo.find()) {
      return paramResolveInfo.replaceAll("");
    }
    return paramContext.toString();
  }
  
  public final String cks()
  {
    return "TencentMap.apk";
  }
  
  public final s.a ckt()
  {
    s.a locala = new s.a();
    locala.rTM = a.f.tencent_map_desc;
    String str = g.AA().getValue("QQMapDownloadTips");
    if (!bk.bl(str)) {
      locala.rTN = str;
    }
    locala.rTO = a.f.tencent_map_label;
    locala.rTL = a.b.icon_tencent_map;
    return locala;
  }
  
  public final boolean eL(Context paramContext)
  {
    Object localObject = new Intent("android.intent.action.VIEW", Uri.parse("sosomap://type=nav"));
    paramContext = paramContext.getPackageManager().queryIntentActivities((Intent)localObject, 0);
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      int j = paramContext.size();
      int i = 0;
      while (i < j)
      {
        localObject = (ResolveInfo)paramContext.get(i);
        if ((localObject != null) && (((ResolveInfo)localObject).activityInfo != null) && ("com.tencent.map".equals(((ResolveInfo)localObject).activityInfo.packageName))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.w
 * JD-Core Version:    0.7.0.1
 */