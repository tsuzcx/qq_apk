package com.tencent.mm.plugin.webview.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class ac$c
{
  public static String Sd(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return localObject2;
      try
      {
        String str = Uri.parse(paramString).getQueryParameter("appid");
        localObject2 = str;
        localObject1 = str;
        if (bk.bl(str))
        {
          localObject1 = str;
          y.i("MicroMsg.OauthAuthorizeLogic", "parseAppId try case not sensitive, oauthUrl:%s", new Object[] { paramString });
          localObject1 = str;
          paramString = Uri.parse(paramString.toLowerCase()).getQueryParameter("appid");
          return paramString;
        }
      }
      catch (Exception paramString) {}
    }
    return localObject1;
  }
  
  static void a(d paramd, String paramString, int paramInt1, ArrayList<String> paramArrayList, ac.b paramb, boolean paramBoolean, int paramInt2)
  {
    if (paramd == null)
    {
      y.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm invoker null");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("oauth_url", paramString);
    localBundle.putInt("opt", paramInt1);
    localBundle.putStringArrayList("scopes", paramArrayList);
    localBundle.putInt("webview_binder_id", paramInt2);
    if (paramBoolean) {}
    try
    {
      paramb.add(1373);
      paramd.r(1373, localBundle);
      return;
    }
    catch (RemoteException paramd)
    {
      y.w("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm doScene exp : %s", new Object[] { paramd.getLocalizedMessage() });
    }
  }
  
  public static boolean a(d paramd)
  {
    try
    {
      paramd = paramd.f(93, new Bundle());
      if (paramd == null)
      {
        y.w("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept Bundle isOauthNative null");
        return false;
      }
      boolean bool = paramd.getBoolean("is_oauth_native");
      return bool;
    }
    catch (RemoteException paramd)
    {
      y.w("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept exp:%s", new Object[] { paramd.getLocalizedMessage() });
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt1, d paramd, ac.d paramd1, ac.b paramb, int paramInt2)
  {
    if (paramd == null)
    {
      y.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize invoker null");
      return false;
    }
    y.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize scene: %d", new Object[] { Integer.valueOf(paramInt1) });
    paramd1.c(new ac.c.1(paramd1, paramb));
    paramd1 = new Bundle();
    paramd1.putString("oauth_url", paramString1);
    paramd1.putString("biz_username", paramString2);
    paramd1.putInt("scene", paramInt1);
    paramd1.putInt("webview_binder_id", paramInt2);
    try
    {
      paramb.add(1254);
      paramd.r(1254, paramd1);
      return true;
    }
    catch (RemoteException paramString1)
    {
      y.w("MicroMsg.OauthAuthorizeLogic", "invoker.doScene exp : %s", new Object[] { paramString1.getLocalizedMessage() });
    }
    return false;
  }
  
  public static boolean b(String paramString, d paramd)
  {
    if ((ac.cbO() == null) && (!ac.cbP())) {}
    for (;;)
    {
      try
      {
        Object localObject = paramd.f(94, new Bundle());
        paramd = null;
        if (localObject != null) {
          paramd = ((Bundle)localObject).getString("oauth_host_paths");
        }
        localObject = paramd;
        if (bk.bl(paramd)) {
          localObject = "open.weixin.qq.com/connect/oauth2/authorize";
        }
        ac.C(((String)localObject).split(";"));
        ac.yC();
        if ((ac.cbO() == null) || (ac.cbO().length == 0))
        {
          y.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost sOauthHostPaths nil");
          return false;
        }
      }
      catch (RemoteException paramString)
      {
        y.w("MicroMsg.OauthAuthorizeLogic", "isOauthHost exp:%s", new Object[] { paramString.getLocalizedMessage() });
        return false;
      }
      paramString = Uri.parse(paramString);
      paramString = paramString.getAuthority() + paramString.getPath();
      if (bk.bl(paramString))
      {
        y.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost target nil");
        return false;
      }
      y.d("MicroMsg.OauthAuthorizeLogic", "isOauthHost target:%s", new Object[] { paramString });
      int i = 0;
      while (i < ac.cbO().length)
      {
        if (paramString.equalsIgnoreCase(ac.cbO()[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ac.c
 * JD-Core Version:    0.7.0.1
 */