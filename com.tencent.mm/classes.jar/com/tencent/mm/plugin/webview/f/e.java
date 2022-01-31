package com.tencent.mm.plugin.webview.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
{
  public static boolean ajp(String paramString)
  {
    AppMethodBeat.i(10147);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(10147);
      return false;
    }
    try
    {
      paramString = Uri.parse(paramString).getPathSegments();
      if (paramString != null)
      {
        int i = paramString.size();
        if (i > 0) {}
      }
      else
      {
        AppMethodBeat.o(10147);
        return false;
      }
      paramString = (String)paramString.get(paramString.size() - 1);
      if (paramString != null)
      {
        boolean bool = paramString.toLowerCase().trim().endsWith(".apk");
        if (bool)
        {
          AppMethodBeat.o(10147);
          return true;
        }
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(10147);
    }
    return false;
  }
  
  public static boolean ajq(String paramString)
  {
    AppMethodBeat.i(10148);
    if (Pattern.compile("^(http|https)://mp.weixin.qq.com/(s|mp/author|mp/appmsg/show)", 2).matcher(paramString).find())
    {
      AppMethodBeat.o(10148);
      return true;
    }
    if (Pattern.compile("^(http|https)://(sh.|hk.|sz.)?open.weixin.qq.com/connect/(confirm|oauth2/(authorize|explorer_authorize))", 2).matcher(paramString).find())
    {
      AppMethodBeat.o(10148);
      return true;
    }
    AppMethodBeat.o(10148);
    return false;
  }
  
  public static void i(String paramString, Context paramContext)
  {
    AppMethodBeat.i(10146);
    paramContext = paramContext.getSharedPreferences("webview_url_prefs", 4).edit();
    paramContext.putString("url", paramString);
    paramContext.apply();
    AppMethodBeat.o(10146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.e
 * JD-Core Version:    0.7.0.1
 */