package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class v
  extends q
{
  public final String a(Context paramContext, ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(125839);
    if ((paramContext == null) || (paramResolveInfo == null) || (paramResolveInfo.activityInfo == null))
    {
      AppMethodBeat.o(125839);
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
        AppMethodBeat.o(125839);
        return paramContext;
      }
      paramContext = paramContext.toString();
      AppMethodBeat.o(125839);
      return paramContext;
    }
    AppMethodBeat.o(125839);
    return null;
  }
  
  public final boolean alg(String paramString)
  {
    AppMethodBeat.i(125837);
    if ((paramString != null) && ("com.tencent.map".equals(paramString)))
    {
      AppMethodBeat.o(125837);
      return true;
    }
    AppMethodBeat.o(125837);
    return false;
  }
  
  public final String aoo()
  {
    return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
  }
  
  public final String dkX()
  {
    return "TencentMap.apk";
  }
  
  public final r.a dkY()
  {
    AppMethodBeat.i(125838);
    r.a locala = new r.a();
    locala.vKJ = 2131304273;
    String str = g.Nq().getValue("QQMapDownloadTips");
    if (!bo.isNullOrNil(str)) {
      locala.vKK = str;
    }
    locala.vKL = 2131304278;
    locala.vKI = 2130839140;
    AppMethodBeat.o(125838);
    return locala;
  }
  
  public final boolean fL(Context paramContext)
  {
    AppMethodBeat.i(125836);
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
          AppMethodBeat.o(125836);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(125836);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.v
 * JD-Core Version:    0.7.0.1
 */