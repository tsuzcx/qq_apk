package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.azs;
import com.tencent.mm.protocal.c.bnd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;

public final class ad
{
  private String gif;
  String kWT;
  String mAppId;
  private Context mContext;
  private boolean rfN;
  
  public ad(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.mContext = paramContext;
    this.mAppId = paramString1;
    this.kWT = paramString2;
    this.gif = paramString3;
    this.rfN = false;
  }
  
  private void Dg(String paramString)
  {
    h.a(this.mContext, paramString, this.mContext.getString(R.l.wechat_auth_failed), new ad.1(this, paramString));
  }
  
  static String Sf(String paramString)
  {
    f localf = g.by(paramString, false);
    if (localf != null) {
      return localf.field_packageName;
    }
    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.SDKOauthUtil", "dealWithCancel getAppInfo null; appid: %s", new Object[] { paramString });
    return null;
  }
  
  public static azs d(String paramString, LinkedList<azs> paramLinkedList)
  {
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      azs localazs = (azs)paramLinkedList.next();
      if (paramString.equals(localazs.scope)) {
        return localazs;
      }
    }
    return null;
  }
  
  static String getCountry()
  {
    au.Hx();
    return bk.aM((String)c.Dz().get(274436, null), null);
  }
  
  public final void Ca(int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SDKOauthUtil", "dealWithCancel");
    String str = Sf(this.mAppId);
    Object localObject = new y(2, this.mAppId, this.gif, str, null);
    au.Dk().a((m)localObject, 0);
    localObject = new SendAuth.Resp();
    ((SendAuth.Resp)localObject).transaction = this.kWT;
    ((SendAuth.Resp)localObject).errCode = paramInt;
    ((SendAuth.Resp)localObject).lang = cbS();
    ((SendAuth.Resp)localObject).country = getCountry();
    a(str, (SendAuth.Resp)localObject);
    ((MMActivity)this.mContext).finish();
  }
  
  final void a(String paramString, SendAuth.Resp paramResp)
  {
    if (this.rfN) {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SDKOauthUtil", "doCallback has callback");
    }
    while (bk.bl(paramString)) {
      return;
    }
    this.rfN = true;
    Bundle localBundle = new Bundle();
    paramResp.toBundle(localBundle);
    com.tencent.mm.pluginsdk.model.app.p.ak(localBundle);
    paramResp = new MMessageActV2.Args();
    paramResp.targetPkgName = paramString;
    paramResp.bundle = localBundle;
    MMessageActV2.send(this.mContext, paramResp);
  }
  
  public final void av(LinkedList<String> paramLinkedList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append((String)paramLinkedList.get(i)).append(",");
      i += 1;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SDKOauthUtil", "doSDKOauthAuthorizeConfirm selectedScopes: %s", new Object[] { localStringBuilder.toString() });
    paramLinkedList = new y(1, this.mAppId, this.gif, Sf(this.mAppId), paramLinkedList);
    au.Dk().a(paramLinkedList, 0);
  }
  
  final String cbS()
  {
    return x.d(this.mContext.getSharedPreferences(ae.cqR(), 0));
  }
  
  public final void h(LinkedList<String> paramLinkedList, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append((String)paramLinkedList.get(i)).append(",");
      i += 1;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SDKOauthUtil", "doSDKOauthAuthorizeConfirm selectedScopes: %s", new Object[] { localStringBuilder.toString() });
    paramLinkedList = new y(this.mAppId, this.gif, Sf(this.mAppId), paramLinkedList, paramInt);
    au.Dk().a(paramLinkedList, 0);
  }
  
  public final void k(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    Object localObject = null;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SDKOauthUtil", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str1;
    String str2;
    SendAuth.Resp localResp;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      str1 = ((y)paramm).cbN().sLy;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback url : %s", new Object[] { str1 });
      str2 = Sf(this.mAppId);
      if (bk.bl(str2))
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SDKOauthUtil", "dealWithLoginCallback pkg nil");
        return;
      }
      localResp = new SendAuth.Resp();
      localResp.transaction = this.kWT;
      localResp.lang = cbS();
      localResp.country = getCountry();
      if (bk.bl(str1)) {
        break label406;
      }
    }
    label406:
    for (paramString = Uri.parse(str1);; paramString = null)
    {
      paramm = localObject;
      if (paramString != null)
      {
        paramm = paramString.getQueryParameter("code");
        localResp.state = paramString.getQueryParameter("state");
        localResp.errStr = paramString.getQueryParameter("reason");
      }
      if (bk.bl(paramm)) {
        localResp.errCode = -1;
      }
      for (;;)
      {
        localResp.url = str1;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback, pkg:%s code:%s errCode:%d state:%s", new Object[] { str2, localResp.code, Integer.valueOf(localResp.errCode), localResp.state });
        a(str2, localResp);
        ((MMActivity)this.mContext).finish();
        return;
        if (paramm.toLowerCase().equals("authdeny"))
        {
          localResp.errCode = -4;
        }
        else
        {
          localResp.errCode = 0;
          localResp.code = paramm;
        }
      }
      if ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 7) || (paramInt1 == 8))
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SDKOauthUtil", "isNetworkAvailable false, errType = " + paramInt1);
        paramInt1 = 0;
      }
      while (paramInt1 == 0)
      {
        Dg(this.mContext.getString(R.l.wechat_auth_network_failed));
        return;
        if (!aq.isConnected(this.mContext))
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SDKOauthUtil", "isNetworkAvailable false, not connected");
          paramInt1 = 0;
        }
        else
        {
          paramInt1 = 1;
        }
      }
      Dg(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ad
 * JD-Core Version:    0.7.0.1
 */