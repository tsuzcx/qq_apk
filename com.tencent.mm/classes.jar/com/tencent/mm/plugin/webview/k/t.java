package com.tencent.mm.plugin.webview.k;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ba.a.e;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.xweb.a;
import com.tencent.xweb.ao;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class t
{
  private static Pattern XtN = null;
  private static String XtO = null;
  private static Boolean XtP = null;
  
  public static void bna(String paramString)
  {
    AppMethodBeat.i(295682);
    MultiProcessMMKV.getDefault().putString("webview_url_prefs_url", paramString);
    AppMethodBeat.o(295682);
  }
  
  public static boolean bnb(String paramString)
  {
    AppMethodBeat.i(295712);
    if ((ao.kgm()) && (bnc(paramString)) && (!"true".equals(a.keX().qM("disable_apk_hook", "tools"))))
    {
      AppMethodBeat.o(295712);
      return true;
    }
    AppMethodBeat.o(295712);
    return false;
  }
  
  private static boolean bnc(String paramString)
  {
    AppMethodBeat.i(82385);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(82385);
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
        AppMethodBeat.o(82385);
        return false;
      }
      paramString = (String)paramString.get(paramString.size() - 1);
      if (paramString != null)
      {
        boolean bool = paramString.toLowerCase().trim().endsWith(".apk");
        if (bool)
        {
          AppMethodBeat.o(82385);
          return true;
        }
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(82385);
    }
    return false;
  }
  
  public static boolean bnd(String paramString)
  {
    AppMethodBeat.i(82386);
    boolean bool;
    if ((XtP != null) && (Util.isEqual(paramString, XtO)))
    {
      bool = XtP.booleanValue();
      AppMethodBeat.o(82386);
      return bool;
    }
    XtO = paramString;
    if (Pattern.compile("^(http|https)://" + WeChatHosts.domainString(a.e.host_mp_weixin_qq_com) + "/(s|mp/author|mp/appmsg/show)", 2).matcher(paramString).find()) {
      bool = true;
    }
    for (;;)
    {
      paramString = Boolean.valueOf(bool);
      XtP = paramString;
      bool = paramString.booleanValue();
      AppMethodBeat.o(82386);
      return bool;
      if (Pattern.compile("^(http|https)://(sh.|hk.|sz.)?" + WeChatHosts.domainString(a.e.host_open_weixin_qq_com) + "/connect/(confirm|oauth2/(authorize|explorer_authorize))", 2).matcher(paramString).find())
      {
        bool = true;
      }
      else
      {
        if (XtN == null)
        {
          String str = ((c)h.ax(c.class)).a(c.a.yMS, "^(http|https)://" + WeChatHosts.domainString(a.e.host_mp_weixin_qq_com) + "/mp/(readtemplate\\?t=scanlogin/index_tmpl|scanlogin\\?action=index|relatedarticle\\?action=page|aboutbiz|infringement|qa)");
          Log.i("MicroMsg.WebViewUIUtil", "mpHosts=:%s", new Object[] { str });
          XtN = Pattern.compile(str);
        }
        if ((XtN != null) && (XtN.matcher(paramString).find())) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
  }
  
  public static String iCY()
  {
    AppMethodBeat.i(295687);
    String str = MultiProcessMMKV.getDefault().getString("webview_url_prefs_url", null);
    AppMethodBeat.o(295687);
    return str;
  }
  
  public static void iCZ()
  {
    AppMethodBeat.i(295692);
    MultiProcessMMKV.getDefault().remove("webview_url_prefs_url");
    AppMethodBeat.o(295692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.t
 * JD-Core Version:    0.7.0.1
 */