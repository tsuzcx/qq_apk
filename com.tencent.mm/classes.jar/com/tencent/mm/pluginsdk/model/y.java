package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class y
  extends t
{
  public final boolean bdn(String paramString)
  {
    AppMethodBeat.i(109481);
    if ((paramString != null) && ("com.tencent.map".equals(paramString)))
    {
      AppMethodBeat.o(109481);
      return true;
    }
    AppMethodBeat.o(109481);
    return false;
  }
  
  public final String blB()
  {
    return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
  }
  
  public final String c(Context paramContext, ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(109483);
    if ((paramContext == null) || (paramResolveInfo == null) || (paramResolveInfo.activityInfo == null))
    {
      AppMethodBeat.o(109483);
      return null;
    }
    paramContext = paramResolveInfo.activityInfo.loadLabel(paramContext.getPackageManager());
    if (paramContext != null)
    {
      paramResolveInfo = paramContext.toString();
      paramResolveInfo = Pattern.compile("\\(.*推荐.*\\)", 2).matcher(paramResolveInfo);
      if (paramResolveInfo.find())
      {
        paramContext = paramResolveInfo.replaceAll("");
        AppMethodBeat.o(109483);
        return paramContext;
      }
      paramContext = paramContext.toString();
      AppMethodBeat.o(109483);
      return paramContext;
    }
    AppMethodBeat.o(109483);
    return null;
  }
  
  public final String gmq()
  {
    return "TencentMap.apk";
  }
  
  public final u.a gmr()
  {
    AppMethodBeat.i(109482);
    u.a locala = new u.a();
    locala.JVB = 2131766699;
    String str = h.aqJ().getValue("QQMapDownloadTips");
    if (!Util.isNullOrNil(str)) {
      locala.JVC = str;
    }
    locala.JVD = 2131766704;
    locala.JVA = 2131233116;
    AppMethodBeat.o(109482);
    return locala;
  }
  
  public final boolean in(Context paramContext)
  {
    AppMethodBeat.i(109480);
    Object localObject = new Intent("android.intent.action.VIEW", Uri.parse("sosomap://type=nav"));
    paramContext = paramContext.getPackageManager().queryIntentActivities((Intent)localObject, 0);
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      int j = paramContext.size();
      int i = 0;
      while (i < j)
      {
        localObject = (ResolveInfo)paramContext.get(i);
        if ((localObject != null) && (((ResolveInfo)localObject).activityInfo != null) && ("com.tencent.map".equals(((ResolveInfo)localObject).activityInfo.packageName)))
        {
          AppMethodBeat.o(109480);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(109480);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.y
 * JD-Core Version:    0.7.0.1
 */