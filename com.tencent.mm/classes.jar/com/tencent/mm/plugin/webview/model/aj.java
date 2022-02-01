package com.tencent.mm.plugin.webview.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.modelmsg.SendTdiAuth.Resp;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;

public final class aj
{
  private boolean DTZ;
  boolean DUa;
  private String[] DUb;
  private String kvP;
  public String mAppId;
  private Context mContext;
  private String tVg;
  private String ucB;
  String ukS;
  
  public aj(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207958);
    this.DUa = false;
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qty, "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.DUb = ((String)localObject).split(",");
      int i = 0;
      while (i < this.DUb.length)
      {
        localObject = this.DUb;
        localObject[i] = localObject[i].trim();
        i += 1;
      }
    }
    this.DUb = new String[] { "snsapi_runtime_sdk" };
    this.mContext = paramContext;
    this.DUa = true;
    this.mAppId = paramString1;
    this.tVg = paramString2;
    AppMethodBeat.o(207958);
  }
  
  public aj(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(207959);
    this.DUa = false;
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qty, "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.DUb = ((String)localObject).split(",");
      int i = 0;
      while (i < this.DUb.length)
      {
        localObject = this.DUb;
        localObject[i] = localObject[i].trim();
        i += 1;
      }
    }
    this.DUb = new String[] { "snsapi_runtime_sdk" };
    this.mContext = paramContext;
    this.mAppId = paramString1;
    this.ukS = paramString2;
    this.kvP = paramString3;
    this.DTZ = false;
    this.ucB = paramString4;
    AppMethodBeat.o(207959);
  }
  
  private boolean WN(int paramInt)
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
  
  public static void a(cxv paramcxv, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(78984);
    if (e("snsapi_userinfo", paramcxv.GXl) != null)
    {
      paramLinkedList.add("snsapi_userinfo");
      AppMethodBeat.o(78984);
      return;
    }
    if (e("snsapi_login", paramcxv.GXl) != null)
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
    com.tencent.mm.kernel.g.aiU().a(paramLinkedList, 0);
    AppMethodBeat.o(78971);
  }
  
  private boolean aHl(String paramString)
  {
    AppMethodBeat.i(207960);
    String[] arrayOfString = this.DUb;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.contains(arrayOfString[i]))
      {
        AppMethodBeat.o(207960);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(207960);
    return false;
  }
  
  static String aHm(String paramString)
  {
    AppMethodBeat.i(78978);
    Object localObject = null;
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.m(paramString, false, false);
    if (localg != null) {}
    for (paramString = localg.field_packageName;; paramString = localObject)
    {
      AppMethodBeat.o(78978);
      return paramString;
      ad.w("MicroMsg.SDKOauthUtil", "dealWithCancel getAppInfo null; appid: %s", new Object[] { paramString });
    }
  }
  
  public static void aM(Activity paramActivity)
  {
    AppMethodBeat.i(78982);
    paramActivity.overridePendingTransition(2130771986, 2130771986);
    if (d.ly(28))
    {
      paramActivity.finish();
      AppMethodBeat.o(78982);
      return;
    }
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78967);
        this.iNQ.finish();
        AppMethodBeat.o(78967);
      }
    }, 500L);
    AppMethodBeat.o(78982);
  }
  
  private void ajs(final String paramString)
  {
    AppMethodBeat.i(78976);
    com.tencent.mm.ui.base.h.d(this.mContext, paramString, this.mContext.getString(2131766178), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(78966);
        if (!aj.this.DUa)
        {
          paramAnonymousDialogInterface = aj.this;
          String str1 = paramString;
          String str2 = aj.aHm(paramAnonymousDialogInterface.mAppId);
          if (bt.isNullOrNil(str2))
          {
            ad.e("MicroMsg.SDKOauthUtil", "dealWithError pkg nil");
            AppMethodBeat.o(78966);
            return;
          }
          SendAuth.Resp localResp = new SendAuth.Resp();
          localResp.transaction = paramAnonymousDialogInterface.ukS;
          localResp.errCode = -1;
          localResp.errStr = str1;
          localResp.lang = paramAnonymousDialogInterface.eQn();
          localResp.country = aj.getCountry();
          paramAnonymousDialogInterface.a(str2, localResp);
        }
        AppMethodBeat.o(78966);
      }
    });
    AppMethodBeat.o(78976);
  }
  
  public static boolean b(cxv paramcxv)
  {
    AppMethodBeat.i(78983);
    if ((e("snsapi_userinfo", paramcxv.GXl) != null) || (e("snsapi_login", paramcxv.GXl) != null) || (e("group_sns_login", paramcxv.GXl) != null))
    {
      AppMethodBeat.o(78983);
      return true;
    }
    AppMethodBeat.o(78983);
    return false;
  }
  
  public static cdg e(String paramString, LinkedList<cdg> paramLinkedList)
  {
    AppMethodBeat.i(78974);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      cdg localcdg = (cdg)paramLinkedList.next();
      if (paramString.equals(localcdg.scope))
      {
        AppMethodBeat.o(78974);
        return localcdg;
      }
    }
    AppMethodBeat.o(78974);
    return null;
  }
  
  static String getCountry()
  {
    AppMethodBeat.i(78979);
    String str = bt.bI((String)com.tencent.mm.kernel.g.ajC().ajl().get(274436, null), null);
    AppMethodBeat.o(78979);
    return str;
  }
  
  public final void O(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(78972);
    ad.i("MicroMsg.SDKOauthUtil", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ((MMActivity)this.mContext).finish();
      AppMethodBeat.o(78972);
      return;
    }
    if (!WN(paramInt1))
    {
      ajs(this.mContext.getString(2131766179));
      AppMethodBeat.o(78972);
      return;
    }
    ajs(paramString);
    AppMethodBeat.o(78972);
  }
  
  public final void WM(int paramInt)
  {
    AppMethodBeat.i(78975);
    ad.i("MicroMsg.SDKOauthUtil", "dealWithCancel");
    if (this.DUa)
    {
      localObject1 = new aa(2, this.tVg, null, 0);
      com.tencent.mm.kernel.g.aiU().a((n)localObject1, 0);
      ((MMActivity)this.mContext).finish();
      AppMethodBeat.o(78975);
      return;
    }
    Object localObject1 = aHm(this.mAppId);
    Object localObject2 = new ac(2, this.mAppId, this.kvP, (String)localObject1, null, this.ucB);
    com.tencent.mm.kernel.g.aiU().a((n)localObject2, 0);
    localObject2 = new SendAuth.Resp();
    ((SendAuth.Resp)localObject2).transaction = this.ukS;
    ((SendAuth.Resp)localObject2).errCode = paramInt;
    ((SendAuth.Resp)localObject2).lang = eQn();
    ((SendAuth.Resp)localObject2).country = getCountry();
    a((String)localObject1, (SendAuth.Resp)localObject2);
    ((MMActivity)this.mContext).finish();
    AppMethodBeat.o(78975);
  }
  
  public final void a(ai paramai, String paramString)
  {
    AppMethodBeat.i(207961);
    String str1 = paramai.eQl();
    ad.i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback url : %s", new Object[] { str1 });
    String str2 = aHm(this.mAppId);
    if (bt.isNullOrNil(str2))
    {
      ad.e("MicroMsg.SDKOauthUtil", "dealWithLoginCallback pkg nil");
      AppMethodBeat.o(207961);
      return;
    }
    boolean bool = paramString.trim().equals("snsapi_wxaapp_info");
    Object localObject;
    if (aHl(paramString))
    {
      localObject = new SendTdiAuth.Resp(Bundle.EMPTY);
      paramString = (String)localObject;
      if (paramai.eQm() != null)
      {
        ((SendTdiAuth.Resp)localObject).tdiAuthBuffer = paramai.eQm().toByteArray();
        paramString = (String)localObject;
      }
      paramString.transaction = this.ukS;
      paramString.lang = eQn();
      paramString.country = getCountry();
      if (bt.isNullOrNil(str1)) {
        break label358;
      }
    }
    label358:
    for (paramai = Uri.parse(str1);; paramai = null)
    {
      if (paramai != null)
      {
        localObject = paramai.getQueryParameter("code");
        paramString.state = paramai.getQueryParameter("state");
        paramString.errStr = paramai.getQueryParameter("reason");
      }
      for (paramai = (ai)localObject;; paramai = null)
      {
        if ((bt.isNullOrNil(paramai)) && (!bool)) {
          paramString.errCode = -1;
        }
        for (;;)
        {
          if (!bool) {
            paramString.url = str1;
          }
          ad.i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback, pkg:%s code:%s errCode:%d state:%s", new Object[] { str2, paramString.code, Integer.valueOf(paramString.errCode), paramString.state });
          a(str2, paramString);
          ((MMActivity)this.mContext).finish();
          AppMethodBeat.o(207961);
          return;
          paramString = new SendAuth.Resp();
          break;
          if (bt.nullAsNil(paramai).toLowerCase().equals("authdeny"))
          {
            paramString.errCode = -4;
          }
          else
          {
            paramString.errCode = 0;
            if (!bool) {
              paramString.code = paramai;
            } else {
              paramString.authResult = true;
            }
          }
        }
      }
    }
  }
  
  final void a(String paramString, SendAuth.Resp paramResp)
  {
    AppMethodBeat.i(78977);
    if (this.DTZ)
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
    this.DTZ = true;
    Bundle localBundle = new Bundle();
    paramResp.toBundle(localBundle);
    com.tencent.mm.pluginsdk.model.app.q.bb(localBundle);
    paramResp = new MMessageActV2.Args();
    paramResp.targetPkgName = paramString;
    paramResp.bundle = localBundle;
    MMessageActV2.send(this.mContext, paramResp);
    AppMethodBeat.o(78977);
  }
  
  public final void bi(LinkedList<String> paramLinkedList)
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
    paramLinkedList = new ac(1, this.mAppId, this.kvP, aHm(this.mAppId), paramLinkedList, this.ucB);
    com.tencent.mm.kernel.g.aiU().a(paramLinkedList, 0);
    AppMethodBeat.o(78968);
  }
  
  final String eQn()
  {
    AppMethodBeat.i(78980);
    String str = com.tencent.mm.sdk.platformtools.ac.f(this.mContext.getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.fkC(), 0));
    AppMethodBeat.o(78980);
    return str;
  }
  
  public final void j(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(78970);
    ad.i("MicroMsg.SDKOauthUtil", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((ac)paramn).eQb();
      paramn = org.apache.commons.b.g.a(new LinkedList(((ac)paramn).DTb), ",");
      a(ai.a.a(paramString), paramn);
      AppMethodBeat.o(78970);
      return;
    }
    if (!WN(paramInt1))
    {
      ajs(this.mContext.getString(2131766179));
      AppMethodBeat.o(78970);
      return;
    }
    ajs(paramString);
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
    paramLinkedList = new ac(this.mAppId, this.kvP, aHm(this.mAppId), paramLinkedList, paramInt, this.ucB);
    com.tencent.mm.kernel.g.aiU().a(paramLinkedList, 0);
    AppMethodBeat.o(78969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.aj
 * JD-Core Version:    0.7.0.1
 */