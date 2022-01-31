package com.tencent.mm.plugin.webview.luggage.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.webkit.URLUtil;
import com.tencent.mm.plugin.appbrand.u.q;
import com.tencent.mm.plugin.appbrand.u.q.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.e;
import org.json.JSONObject;

public final class b
{
  private static q.a rfd = null;
  
  public static String aX(Context paramContext, String paramString)
  {
    if (rfd == null) {
      rfd = new q.a()
      {
        private String version;
        
        public final String pJ()
        {
          return " MicroMessenger/";
        }
        
        public final String pK()
        {
          return this.version;
        }
      };
    }
    return q.a(paramContext, paramString, rfd);
  }
  
  public static JSONObject tJ(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static boolean wD(String paramString)
  {
    return (!bk.bl(paramString)) && ((URLUtil.isHttpsUrl(paramString)) || (URLUtil.isHttpUrl(paramString)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d.b
 * JD-Core Version:    0.7.0.1
 */