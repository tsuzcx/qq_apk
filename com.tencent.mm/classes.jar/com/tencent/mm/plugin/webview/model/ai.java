package com.tencent.mm.plugin.webview.model;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.protocal.protobuf.bgv;
import com.tencent.mm.protocal.protobuf.bwy;
import com.tencent.mm.protocal.protobuf.bxa;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;

public final class ai
{
  private String hBt;
  public String mAppId;
  private Context mContext;
  private String nkp;
  String nuV;
  private boolean uWa;
  boolean uWb = false;
  
  public ai(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.uWb = true;
    this.mAppId = paramString1;
    this.nkp = paramString2;
  }
  
  public ai(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.mContext = paramContext;
    this.mAppId = paramString1;
    this.nuV = paramString2;
    this.hBt = paramString3;
    this.uWa = false;
  }
  
  private boolean JV(int paramInt)
  {
    AppMethodBeat.i(6691);
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SDKOauthUtil", "isNetworkAvailable false, errType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(6691);
      return false;
    }
    if (!at.isConnected(this.mContext))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SDKOauthUtil", "isNetworkAvailable false, not connected");
      AppMethodBeat.o(6691);
      return false;
    }
    AppMethodBeat.o(6691);
    return true;
  }
  
  private void Oj(String paramString)
  {
    AppMethodBeat.i(6686);
    h.a(this.mContext, paramString, this.mContext.getString(2131305933), new ai.1(this, paramString));
    AppMethodBeat.o(6686);
  }
  
  public static void a(bxa parambxa, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(6694);
    if (d("snsapi_userinfo", parambxa.xvT) != null)
    {
      paramLinkedList.add("snsapi_userinfo");
      AppMethodBeat.o(6694);
      return;
    }
    if (d("snsapi_login", parambxa.xvT) != null)
    {
      paramLinkedList.add("snsapi_login");
      AppMethodBeat.o(6694);
      return;
    }
    paramLinkedList.add("group_sns_login");
    AppMethodBeat.o(6694);
  }
  
  public static void a(LinkedList<String> paramLinkedList, int paramInt, String paramString)
  {
    AppMethodBeat.i(6682);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append((String)paramLinkedList.get(i)).append(",");
      i += 1;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SDKOauthUtil", "doQRCodeOauthAuthorizeConfirm selectedScopes: %s", new Object[] { localStringBuilder.toString() });
    paramLinkedList = new ab(1, paramString, paramLinkedList, paramInt);
    com.tencent.mm.kernel.g.Rc().a(paramLinkedList, 0);
    AppMethodBeat.o(6682);
  }
  
  public static boolean a(bxa parambxa)
  {
    AppMethodBeat.i(156232);
    if ((d("snsapi_userinfo", parambxa.xvT) != null) || (d("snsapi_login", parambxa.xvT) != null) || (d("group_sns_login", parambxa.xvT) != null))
    {
      AppMethodBeat.o(156232);
      return true;
    }
    AppMethodBeat.o(156232);
    return false;
  }
  
  static String ahb(String paramString)
  {
    AppMethodBeat.i(6688);
    Object localObject = null;
    f localf = com.tencent.mm.pluginsdk.model.app.g.ca(paramString, false);
    if (localf != null) {}
    for (paramString = localf.field_packageName;; paramString = localObject)
    {
      AppMethodBeat.o(6688);
      return paramString;
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.SDKOauthUtil", "dealWithCancel getAppInfo null; appid: %s", new Object[] { paramString });
    }
  }
  
  public static void an(Activity paramActivity)
  {
    AppMethodBeat.i(6692);
    paramActivity.overridePendingTransition(2131034130, 2131034130);
    if (b.fv(28))
    {
      paramActivity.finish();
      AppMethodBeat.o(6692);
      return;
    }
    al.p(new ai.2(paramActivity), 500L);
    AppMethodBeat.o(6692);
  }
  
  public static bgv d(String paramString, LinkedList<bgv> paramLinkedList)
  {
    AppMethodBeat.i(6684);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      bgv localbgv = (bgv)paramLinkedList.next();
      if (paramString.equals(localbgv.scope))
      {
        AppMethodBeat.o(6684);
        return localbgv;
      }
    }
    AppMethodBeat.o(6684);
    return null;
  }
  
  static String getCountry()
  {
    AppMethodBeat.i(6689);
    String str = bo.bf((String)com.tencent.mm.kernel.g.RL().Ru().get(274436, null), null);
    AppMethodBeat.o(6689);
    return str;
  }
  
  public final void C(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(6683);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SDKOauthUtil", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ((MMActivity)this.mContext).finish();
      AppMethodBeat.o(6683);
      return;
    }
    if (!JV(paramInt1))
    {
      Oj(this.mContext.getString(2131305934));
      AppMethodBeat.o(6683);
      return;
    }
    Oj(paramString);
    AppMethodBeat.o(6683);
  }
  
  public final void JU(int paramInt)
  {
    AppMethodBeat.i(6685);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SDKOauthUtil", "dealWithCancel");
    if (this.uWb)
    {
      localObject1 = new ab(2, this.nkp, null, 0);
      com.tencent.mm.kernel.g.Rc().a((m)localObject1, 0);
      ((MMActivity)this.mContext).finish();
      AppMethodBeat.o(6685);
      return;
    }
    Object localObject1 = ahb(this.mAppId);
    Object localObject2 = new ad(2, this.mAppId, this.hBt, (String)localObject1, null);
    com.tencent.mm.kernel.g.Rc().a((m)localObject2, 0);
    localObject2 = new SendAuth.Resp();
    ((SendAuth.Resp)localObject2).transaction = this.nuV;
    ((SendAuth.Resp)localObject2).errCode = paramInt;
    ((SendAuth.Resp)localObject2).lang = dbV();
    ((SendAuth.Resp)localObject2).country = getCountry();
    a((String)localObject1, (SendAuth.Resp)localObject2);
    ((MMActivity)this.mContext).finish();
    AppMethodBeat.o(6685);
  }
  
  final void a(String paramString, SendAuth.Resp paramResp)
  {
    AppMethodBeat.i(6687);
    if (this.uWa)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SDKOauthUtil", "doCallback has callback");
      AppMethodBeat.o(6687);
      return;
    }
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6687);
      return;
    }
    this.uWa = true;
    Bundle localBundle = new Bundle();
    paramResp.toBundle(localBundle);
    com.tencent.mm.pluginsdk.model.app.p.aC(localBundle);
    paramResp = new MMessageActV2.Args();
    paramResp.targetPkgName = paramString;
    paramResp.bundle = localBundle;
    MMessageActV2.send(this.mContext, paramResp);
    AppMethodBeat.o(6687);
  }
  
  public final void aG(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(6679);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append((String)paramLinkedList.get(i)).append(",");
      i += 1;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SDKOauthUtil", "doSDKOauthAuthorizeConfirm selectedScopes: %s", new Object[] { localStringBuilder.toString() });
    paramLinkedList = new ad(1, this.mAppId, this.hBt, ahb(this.mAppId), paramLinkedList);
    com.tencent.mm.kernel.g.Rc().a(paramLinkedList, 0);
    AppMethodBeat.o(6679);
  }
  
  final String dbV()
  {
    AppMethodBeat.i(6690);
    String str = aa.f(this.mContext.getSharedPreferences(ah.dsP(), 0));
    AppMethodBeat.o(6690);
    return str;
  }
  
  public final void h(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    Object localObject = null;
    AppMethodBeat.i(6681);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SDKOauthUtil", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str1;
    String str2;
    SendAuth.Resp localResp;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      str1 = ((ad)paramm).dbQ().wqy;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback url : %s", new Object[] { str1 });
      str2 = ahb(this.mAppId);
      if (bo.isNullOrNil(str2))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SDKOauthUtil", "dealWithLoginCallback pkg nil");
        AppMethodBeat.o(6681);
        return;
      }
      localResp = new SendAuth.Resp();
      localResp.transaction = this.nuV;
      localResp.lang = dbV();
      localResp.country = getCountry();
      if (bo.isNullOrNil(str1)) {
        break label366;
      }
    }
    label366:
    for (paramString = Uri.parse(str1);; paramString = null)
    {
      paramm = localObject;
      if (paramString != null)
      {
        paramm = paramString.getQueryParameter("code");
        localResp.state = paramString.getQueryParameter("state");
        localResp.errStr = paramString.getQueryParameter("reason");
      }
      if (bo.isNullOrNil(paramm)) {
        localResp.errCode = -1;
      }
      for (;;)
      {
        localResp.url = str1;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback, pkg:%s code:%s errCode:%d state:%s", new Object[] { str2, localResp.code, Integer.valueOf(localResp.errCode), localResp.state });
        a(str2, localResp);
        ((MMActivity)this.mContext).finish();
        AppMethodBeat.o(6681);
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
      if (!JV(paramInt1))
      {
        Oj(this.mContext.getString(2131305934));
        AppMethodBeat.o(6681);
        return;
      }
      Oj(paramString);
      AppMethodBeat.o(6681);
      return;
    }
  }
  
  public final void h(LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(6680);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append((String)paramLinkedList.get(i)).append(",");
      i += 1;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SDKOauthUtil", "doSDKOauthAuthorizeConfirm selectedScopes: %s", new Object[] { localStringBuilder.toString() });
    paramLinkedList = new ad(this.mAppId, this.hBt, ahb(this.mAppId), paramLinkedList, paramInt);
    com.tencent.mm.kernel.g.Rc().a(paramLinkedList, 0);
    AppMethodBeat.o(6680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ai
 * JD-Core Version:    0.7.0.1
 */