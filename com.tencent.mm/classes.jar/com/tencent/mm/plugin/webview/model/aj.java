package com.tencent.mm.plugin.webview.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.modelmsg.SendTdiAuth.Resp;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;

public final class aj
{
  private boolean ElZ;
  boolean Ema = false;
  private String kze;
  public String mAppId;
  private Context mContext;
  private String ugc;
  private String unF;
  String uwp;
  
  public aj(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.Ema = true;
    this.mAppId = paramString1;
    this.ugc = paramString2;
  }
  
  public aj(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mContext = paramContext;
    this.mAppId = paramString1;
    this.uwp = paramString2;
    this.kze = paramString3;
    this.ElZ = false;
    this.unF = paramString4;
  }
  
  private boolean Xu(int paramInt)
  {
    AppMethodBeat.i(78981);
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8))
    {
      ae.e("MicroMsg.SDKOauthUtil", "isNetworkAvailable false, errType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(78981);
      return false;
    }
    if (!az.isConnected(this.mContext))
    {
      ae.e("MicroMsg.SDKOauthUtil", "isNetworkAvailable false, not connected");
      AppMethodBeat.o(78981);
      return false;
    }
    AppMethodBeat.o(78981);
    return true;
  }
  
  public static void a(cyp paramcyp, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(78984);
    if (e("snsapi_userinfo", paramcyp.HqL) != null)
    {
      paramLinkedList.add("snsapi_userinfo");
      AppMethodBeat.o(78984);
      return;
    }
    if (e("snsapi_login", paramcyp.HqL) != null)
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
    ae.i("MicroMsg.SDKOauthUtil", "doQRCodeOauthAuthorizeConfirm selectedScopes: %s", new Object[] { localStringBuilder.toString() });
    paramLinkedList = new aa(1, paramString, paramLinkedList, paramInt);
    com.tencent.mm.kernel.g.ajj().a(paramLinkedList, 0);
    AppMethodBeat.o(78971);
  }
  
  static String aIF(String paramString)
  {
    AppMethodBeat.i(78978);
    Object localObject = null;
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.m(paramString, false, false);
    if (localg != null) {}
    for (paramString = localg.field_packageName;; paramString = localObject)
    {
      AppMethodBeat.o(78978);
      return paramString;
      ae.w("MicroMsg.SDKOauthUtil", "dealWithCancel getAppInfo null; appid: %s", new Object[] { paramString });
    }
  }
  
  public static void aN(Activity paramActivity)
  {
    AppMethodBeat.i(78982);
    paramActivity.overridePendingTransition(2130771986, 2130771986);
    if (d.lA(28))
    {
      paramActivity.finish();
      AppMethodBeat.o(78982);
      return;
    }
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78967);
        this.iQK.finish();
        AppMethodBeat.o(78967);
      }
    }, 500L);
    AppMethodBeat.o(78982);
  }
  
  private void akq(final String paramString)
  {
    AppMethodBeat.i(78976);
    com.tencent.mm.ui.base.h.d(this.mContext, paramString, this.mContext.getString(2131766178), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(78966);
        if (!aj.this.Ema)
        {
          paramAnonymousDialogInterface = aj.this;
          String str1 = paramString;
          String str2 = aj.aIF(paramAnonymousDialogInterface.mAppId);
          if (bu.isNullOrNil(str2))
          {
            ae.e("MicroMsg.SDKOauthUtil", "dealWithError pkg nil");
            AppMethodBeat.o(78966);
            return;
          }
          SendAuth.Resp localResp = new SendAuth.Resp();
          localResp.transaction = paramAnonymousDialogInterface.uwp;
          localResp.errCode = -1;
          localResp.errStr = str1;
          localResp.lang = paramAnonymousDialogInterface.eTZ();
          localResp.country = aj.getCountry();
          paramAnonymousDialogInterface.a(str2, localResp);
        }
        AppMethodBeat.o(78966);
      }
    });
    AppMethodBeat.o(78976);
  }
  
  public static boolean b(cyp paramcyp)
  {
    AppMethodBeat.i(78983);
    if ((e("snsapi_userinfo", paramcyp.HqL) != null) || (e("snsapi_login", paramcyp.HqL) != null) || (e("group_sns_login", paramcyp.HqL) != null))
    {
      AppMethodBeat.o(78983);
      return true;
    }
    AppMethodBeat.o(78983);
    return false;
  }
  
  public static cea e(String paramString, LinkedList<cea> paramLinkedList)
  {
    AppMethodBeat.i(78974);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      cea localcea = (cea)paramLinkedList.next();
      if (paramString.equals(localcea.scope))
      {
        AppMethodBeat.o(78974);
        return localcea;
      }
    }
    AppMethodBeat.o(78974);
    return null;
  }
  
  static String getCountry()
  {
    AppMethodBeat.i(78979);
    String str = bu.bI((String)com.tencent.mm.kernel.g.ajR().ajA().get(274436, null), null);
    AppMethodBeat.o(78979);
    return str;
  }
  
  public final void O(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(78972);
    ae.i("MicroMsg.SDKOauthUtil", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ((MMActivity)this.mContext).finish();
      AppMethodBeat.o(78972);
      return;
    }
    if (!Xu(paramInt1))
    {
      akq(this.mContext.getString(2131766179));
      AppMethodBeat.o(78972);
      return;
    }
    akq(paramString);
    AppMethodBeat.o(78972);
  }
  
  public final void Xt(int paramInt)
  {
    AppMethodBeat.i(78975);
    ae.i("MicroMsg.SDKOauthUtil", "dealWithCancel");
    if (this.Ema)
    {
      localObject1 = new aa(2, this.ugc, null, 0);
      com.tencent.mm.kernel.g.ajj().a((n)localObject1, 0);
      ((MMActivity)this.mContext).finish();
      AppMethodBeat.o(78975);
      return;
    }
    Object localObject1 = aIF(this.mAppId);
    Object localObject2 = new ac(2, this.mAppId, this.kze, (String)localObject1, null, this.unF);
    com.tencent.mm.kernel.g.ajj().a((n)localObject2, 0);
    localObject2 = new SendAuth.Resp();
    ((SendAuth.Resp)localObject2).transaction = this.uwp;
    ((SendAuth.Resp)localObject2).errCode = paramInt;
    ((SendAuth.Resp)localObject2).lang = eTZ();
    ((SendAuth.Resp)localObject2).country = getCountry();
    a((String)localObject1, (SendAuth.Resp)localObject2);
    ((MMActivity)this.mContext).finish();
    AppMethodBeat.o(78975);
  }
  
  public final void a(ai paramai, String paramString)
  {
    AppMethodBeat.i(198138);
    String str2 = paramai.eTX();
    ae.i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback url : %s", new Object[] { str2 });
    String str3 = aIF(this.mAppId);
    if (bu.isNullOrNil(str3))
    {
      ae.e("MicroMsg.SDKOauthUtil", "dealWithLoginCallback pkg nil");
      AppMethodBeat.o(198138);
      return;
    }
    boolean bool = paramString.trim().equals("snsapi_wxaapp_info");
    if ((paramai.eTY() != null) && (paramai.eTY().zr.length > 0))
    {
      paramString = new SendTdiAuth.Resp(Bundle.EMPTY);
      ((SendTdiAuth.Resp)paramString).tdiAuthBuffer = paramai.eTY().toByteArray();
      paramai = paramString;
      paramai.transaction = this.uwp;
      paramai.lang = eTZ();
      paramai.country = getCountry();
      if (bu.isNullOrNil(str2)) {
        break label357;
      }
    }
    label357:
    for (paramString = Uri.parse(str2);; paramString = null)
    {
      String str1;
      if (paramString != null)
      {
        str1 = paramString.getQueryParameter("code");
        paramai.state = paramString.getQueryParameter("state");
        paramai.errStr = paramString.getQueryParameter("reason");
      }
      for (paramString = str1;; paramString = null)
      {
        if ((bu.isNullOrNil(paramString)) && (!bool)) {
          paramai.errCode = -1;
        }
        for (;;)
        {
          if (!bool) {
            paramai.url = str2;
          }
          ae.i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback, pkg:%s code:%s errCode:%d state:%s", new Object[] { str3, paramai.code, Integer.valueOf(paramai.errCode), paramai.state });
          a(str3, paramai);
          ((MMActivity)this.mContext).finish();
          AppMethodBeat.o(198138);
          return;
          paramai = new SendAuth.Resp();
          break;
          if (bu.nullAsNil(paramString).toLowerCase().equals("authdeny"))
          {
            paramai.errCode = -4;
          }
          else
          {
            paramai.errCode = 0;
            if (!bool) {
              paramai.code = paramString;
            } else {
              paramai.authResult = true;
            }
          }
        }
      }
    }
  }
  
  final void a(String paramString, SendAuth.Resp paramResp)
  {
    AppMethodBeat.i(78977);
    if (this.ElZ)
    {
      ae.i("MicroMsg.SDKOauthUtil", "doCallback has callback");
      AppMethodBeat.o(78977);
      return;
    }
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78977);
      return;
    }
    this.ElZ = true;
    Bundle localBundle = new Bundle();
    paramResp.toBundle(localBundle);
    com.tencent.mm.pluginsdk.model.app.q.bc(localBundle);
    paramResp = new MMessageActV2.Args();
    paramResp.targetPkgName = paramString;
    paramResp.bundle = localBundle;
    MMessageActV2.send(this.mContext, paramResp);
    AppMethodBeat.o(78977);
  }
  
  public final void bj(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(78968);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append((String)paramLinkedList.get(i)).append(",");
      i += 1;
    }
    ae.i("MicroMsg.SDKOauthUtil", "doSDKOauthAuthorizeConfirm selectedScopes: %s", new Object[] { localStringBuilder.toString() });
    paramLinkedList = new ac(1, this.mAppId, this.kze, aIF(this.mAppId), paramLinkedList, this.unF);
    com.tencent.mm.kernel.g.ajj().a(paramLinkedList, 0);
    AppMethodBeat.o(78968);
  }
  
  final String eTZ()
  {
    AppMethodBeat.i(78980);
    String str = ad.f(this.mContext.getSharedPreferences(ak.fow(), 0));
    AppMethodBeat.o(78980);
    return str;
  }
  
  public final void j(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(78970);
    ae.i("MicroMsg.SDKOauthUtil", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((ac)paramn).eTN();
      paramn = org.apache.commons.b.g.a(new LinkedList(((ac)paramn).Elb), ",");
      a(ai.a.a(paramString), paramn);
      AppMethodBeat.o(78970);
      return;
    }
    if (!Xu(paramInt1))
    {
      akq(this.mContext.getString(2131766179));
      AppMethodBeat.o(78970);
      return;
    }
    akq(paramString);
    AppMethodBeat.o(78970);
  }
  
  public final void l(LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(78969);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append((String)paramLinkedList.get(i)).append(",");
      i += 1;
    }
    ae.i("MicroMsg.SDKOauthUtil", "doSDKOauthAuthorizeConfirm selectedScopes: %s", new Object[] { localStringBuilder.toString() });
    paramLinkedList = new ac(this.mAppId, this.kze, aIF(this.mAppId), paramLinkedList, paramInt, this.unF);
    com.tencent.mm.kernel.g.ajj().a(paramLinkedList, 0);
    AppMethodBeat.o(78969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.aj
 * JD-Core Version:    0.7.0.1
 */