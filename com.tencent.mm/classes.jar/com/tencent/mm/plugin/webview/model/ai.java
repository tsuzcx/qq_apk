package com.tencent.mm.plugin.webview.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;

public final class ai
{
  private boolean AYk;
  boolean AYl = false;
  private String jAX;
  public String mAppId;
  private Context mContext;
  private String rQe;
  private String rWS;
  String seA;
  
  public ai(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.AYl = true;
    this.mAppId = paramString1;
    this.rQe = paramString2;
  }
  
  public ai(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mContext = paramContext;
    this.mAppId = paramString1;
    this.seA = paramString2;
    this.jAX = paramString3;
    this.AYk = false;
    this.rWS = paramString4;
  }
  
  private boolean SP(int paramInt)
  {
    AppMethodBeat.i(78981);
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8))
    {
      ad.e("MicroMsg.SDKOauthUtil", "isNetworkAvailable false, errType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(78981);
      return false;
    }
    if (!ay.isConnected(this.mContext))
    {
      ad.e("MicroMsg.SDKOauthUtil", "isNetworkAvailable false, not connected");
      AppMethodBeat.o(78981);
      return false;
    }
    AppMethodBeat.o(78981);
    return true;
  }
  
  public static void a(cne paramcne, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(78984);
    if (e("snsapi_userinfo", paramcne.DRk) != null)
    {
      paramLinkedList.add("snsapi_userinfo");
      AppMethodBeat.o(78984);
      return;
    }
    if (e("snsapi_login", paramcne.DRk) != null)
    {
      paramLinkedList.add("snsapi_login");
      AppMethodBeat.o(78984);
      return;
    }
    paramLinkedList.add("group_sns_login");
    AppMethodBeat.o(78984);
  }
  
  public static void a(LinkedList<String> paramLinkedList, int paramInt, String paramString)
  {
    AppMethodBeat.i(78971);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append((String)paramLinkedList.get(i)).append(",");
      i += 1;
    }
    ad.i("MicroMsg.SDKOauthUtil", "doQRCodeOauthAuthorizeConfirm selectedScopes: %s", new Object[] { localStringBuilder.toString() });
    paramLinkedList = new aa(1, paramString, paramLinkedList, paramInt);
    com.tencent.mm.kernel.g.aeS().a(paramLinkedList, 0);
    AppMethodBeat.o(78971);
  }
  
  public static boolean a(cne paramcne)
  {
    AppMethodBeat.i(78983);
    if ((e("snsapi_userinfo", paramcne.DRk) != null) || (e("snsapi_login", paramcne.DRk) != null) || (e("group_sns_login", paramcne.DRk) != null))
    {
      AppMethodBeat.o(78983);
      return true;
    }
    AppMethodBeat.o(78983);
    return false;
  }
  
  public static void aI(Activity paramActivity)
  {
    AppMethodBeat.i(78982);
    paramActivity.overridePendingTransition(2130771986, 2130771986);
    if (d.lf(28))
    {
      paramActivity.finish();
      AppMethodBeat.o(78982);
      return;
    }
    aq.n(new ai.2(paramActivity), 500L);
    AppMethodBeat.o(78982);
  }
  
  private void aaf(final String paramString)
  {
    AppMethodBeat.i(78976);
    com.tencent.mm.ui.base.h.d(this.mContext, paramString, this.mContext.getString(2131766178), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(78966);
        if (!ai.this.AYl)
        {
          paramAnonymousDialogInterface = ai.this;
          String str1 = paramString;
          String str2 = ai.awu(paramAnonymousDialogInterface.mAppId);
          if (bt.isNullOrNil(str2))
          {
            ad.e("MicroMsg.SDKOauthUtil", "dealWithError pkg nil");
            AppMethodBeat.o(78966);
            return;
          }
          SendAuth.Resp localResp = new SendAuth.Resp();
          localResp.transaction = paramAnonymousDialogInterface.seA;
          localResp.errCode = -1;
          localResp.errStr = str1;
          localResp.lang = paramAnonymousDialogInterface.elX();
          localResp.country = ai.getCountry();
          paramAnonymousDialogInterface.a(str2, localResp);
        }
        AppMethodBeat.o(78966);
      }
    });
    AppMethodBeat.o(78976);
  }
  
  static String awu(String paramString)
  {
    AppMethodBeat.i(78978);
    Object localObject = null;
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.j(paramString, false, false);
    if (localg != null) {}
    for (paramString = localg.field_packageName;; paramString = localObject)
    {
      AppMethodBeat.o(78978);
      return paramString;
      ad.w("MicroMsg.SDKOauthUtil", "dealWithCancel getAppInfo null; appid: %s", new Object[] { paramString });
    }
  }
  
  public static bty e(String paramString, LinkedList<bty> paramLinkedList)
  {
    AppMethodBeat.i(78974);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      bty localbty = (bty)paramLinkedList.next();
      if (paramString.equals(localbty.scope))
      {
        AppMethodBeat.o(78974);
        return localbty;
      }
    }
    AppMethodBeat.o(78974);
    return null;
  }
  
  static String getCountry()
  {
    AppMethodBeat.i(78979);
    String str = bt.by((String)com.tencent.mm.kernel.g.afB().afk().get(274436, null), null);
    AppMethodBeat.o(78979);
    return str;
  }
  
  public final void N(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(78972);
    ad.i("MicroMsg.SDKOauthUtil", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ((MMActivity)this.mContext).finish();
      AppMethodBeat.o(78972);
      return;
    }
    if (!SP(paramInt1))
    {
      aaf(this.mContext.getString(2131766179));
      AppMethodBeat.o(78972);
      return;
    }
    aaf(paramString);
    AppMethodBeat.o(78972);
  }
  
  public final void SO(int paramInt)
  {
    AppMethodBeat.i(78975);
    ad.i("MicroMsg.SDKOauthUtil", "dealWithCancel");
    if (this.AYl)
    {
      localObject1 = new aa(2, this.rQe, null, 0);
      com.tencent.mm.kernel.g.aeS().a((n)localObject1, 0);
      ((MMActivity)this.mContext).finish();
      AppMethodBeat.o(78975);
      return;
    }
    Object localObject1 = awu(this.mAppId);
    Object localObject2 = new ac(2, this.mAppId, this.jAX, (String)localObject1, null, this.rWS);
    com.tencent.mm.kernel.g.aeS().a((n)localObject2, 0);
    localObject2 = new SendAuth.Resp();
    ((SendAuth.Resp)localObject2).transaction = this.seA;
    ((SendAuth.Resp)localObject2).errCode = paramInt;
    ((SendAuth.Resp)localObject2).lang = elX();
    ((SendAuth.Resp)localObject2).country = getCountry();
    a((String)localObject1, (SendAuth.Resp)localObject2);
    ((MMActivity)this.mContext).finish();
    AppMethodBeat.o(78975);
  }
  
  final void a(String paramString, SendAuth.Resp paramResp)
  {
    AppMethodBeat.i(78977);
    if (this.AYk)
    {
      ad.i("MicroMsg.SDKOauthUtil", "doCallback has callback");
      AppMethodBeat.o(78977);
      return;
    }
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78977);
      return;
    }
    this.AYk = true;
    Bundle localBundle = new Bundle();
    paramResp.toBundle(localBundle);
    com.tencent.mm.pluginsdk.model.app.q.aS(localBundle);
    paramResp = new MMessageActV2.Args();
    paramResp.targetPkgName = paramString;
    paramResp.bundle = localBundle;
    MMessageActV2.send(this.mContext, paramResp);
    AppMethodBeat.o(78977);
  }
  
  public final void ba(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(78968);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append((String)paramLinkedList.get(i)).append(",");
      i += 1;
    }
    ad.i("MicroMsg.SDKOauthUtil", "doSDKOauthAuthorizeConfirm selectedScopes: %s", new Object[] { localStringBuilder.toString() });
    paramLinkedList = new ac(1, this.mAppId, this.jAX, awu(this.mAppId), paramLinkedList, this.rWS);
    com.tencent.mm.kernel.g.aeS().a(paramLinkedList, 0);
    AppMethodBeat.o(78968);
  }
  
  public final void ca(String paramString, boolean paramBoolean)
  {
    String str1 = null;
    AppMethodBeat.i(78973);
    ad.i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback url : %s", new Object[] { paramString });
    String str2 = awu(this.mAppId);
    if (bt.isNullOrNil(str2))
    {
      ad.e("MicroMsg.SDKOauthUtil", "dealWithLoginCallback pkg nil");
      AppMethodBeat.o(78973);
      return;
    }
    SendAuth.Resp localResp = new SendAuth.Resp();
    localResp.transaction = this.seA;
    localResp.lang = elX();
    localResp.country = getCountry();
    if (!bt.isNullOrNil(paramString)) {}
    for (Uri localUri = Uri.parse(paramString);; localUri = null)
    {
      if (localUri != null)
      {
        str1 = localUri.getQueryParameter("code");
        localResp.state = localUri.getQueryParameter("state");
        localResp.errStr = localUri.getQueryParameter("reason");
      }
      if ((bt.isNullOrNil(str1)) && (!paramBoolean)) {
        localResp.errCode = -1;
      }
      for (;;)
      {
        if (!paramBoolean) {
          localResp.url = paramString;
        }
        ad.i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback, pkg:%s code:%s errCode:%d state:%s", new Object[] { str2, localResp.code, Integer.valueOf(localResp.errCode), localResp.state });
        a(str2, localResp);
        ((MMActivity)this.mContext).finish();
        AppMethodBeat.o(78973);
        return;
        if (str1.toLowerCase().equals("authdeny"))
        {
          localResp.errCode = -4;
        }
        else
        {
          localResp.errCode = 0;
          if (!paramBoolean) {
            localResp.code = str1;
          } else {
            localResp.authResult = true;
          }
        }
      }
    }
  }
  
  final String elX()
  {
    AppMethodBeat.i(78980);
    String str = com.tencent.mm.sdk.platformtools.ac.f(this.mContext.getSharedPreferences(aj.eFD(), 0));
    AppMethodBeat.o(78980);
    return str;
  }
  
  public final void j(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(78970);
    ad.i("MicroMsg.SDKOauthUtil", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((ac)paramn).elN();
      boolean bool = new LinkedList(((ac)paramn).AXq).contains("snsapi_wxaapp_info");
      ca(paramString.CzB, bool);
      AppMethodBeat.o(78970);
      return;
    }
    if (!SP(paramInt1))
    {
      aaf(this.mContext.getString(2131766179));
      AppMethodBeat.o(78970);
      return;
    }
    aaf(paramString);
    AppMethodBeat.o(78970);
  }
  
  public final void k(LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(78969);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append((String)paramLinkedList.get(i)).append(",");
      i += 1;
    }
    ad.i("MicroMsg.SDKOauthUtil", "doSDKOauthAuthorizeConfirm selectedScopes: %s", new Object[] { localStringBuilder.toString() });
    paramLinkedList = new ac(this.mAppId, this.jAX, awu(this.mAppId), paramLinkedList, paramInt, this.rWS);
    com.tencent.mm.kernel.g.aeS().a(paramLinkedList, 0);
    AppMethodBeat.o(78969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ai
 * JD-Core Version:    0.7.0.1
 */