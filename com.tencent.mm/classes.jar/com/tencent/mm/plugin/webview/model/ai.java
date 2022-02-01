package com.tencent.mm.plugin.webview.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;

public final class ai
{
  private boolean Cqx;
  boolean Cqy = false;
  private String kbt;
  public String mAppId;
  private Context mContext;
  private String sXV;
  private String teK;
  String tmt;
  
  public ai(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.Cqy = true;
    this.mAppId = paramString1;
    this.sXV = paramString2;
  }
  
  public ai(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mContext = paramContext;
    this.mAppId = paramString1;
    this.tmt = paramString2;
    this.kbt = paramString3;
    this.Cqx = false;
    this.teK = paramString4;
  }
  
  private boolean UX(int paramInt)
  {
    AppMethodBeat.i(78981);
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SDKOauthUtil", "isNetworkAvailable false, errType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(78981);
      return false;
    }
    if (!ax.isConnected(this.mContext))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SDKOauthUtil", "isNetworkAvailable false, not connected");
      AppMethodBeat.o(78981);
      return false;
    }
    AppMethodBeat.o(78981);
    return true;
  }
  
  public static void a(csl paramcsl, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(78984);
    if (e("snsapi_userinfo", paramcsl.FnC) != null)
    {
      paramLinkedList.add("snsapi_userinfo");
      AppMethodBeat.o(78984);
      return;
    }
    if (e("snsapi_login", paramcsl.FnC) != null)
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SDKOauthUtil", "doQRCodeOauthAuthorizeConfirm selectedScopes: %s", new Object[] { localStringBuilder.toString() });
    paramLinkedList = new aa(1, paramString, paramLinkedList, paramInt);
    com.tencent.mm.kernel.g.agi().a(paramLinkedList, 0);
    AppMethodBeat.o(78971);
  }
  
  public static boolean a(csl paramcsl)
  {
    AppMethodBeat.i(78983);
    if ((e("snsapi_userinfo", paramcsl.FnC) != null) || (e("snsapi_login", paramcsl.FnC) != null) || (e("group_sns_login", paramcsl.FnC) != null))
    {
      AppMethodBeat.o(78983);
      return true;
    }
    AppMethodBeat.o(78983);
    return false;
  }
  
  static String aBM(String paramString)
  {
    AppMethodBeat.i(78978);
    Object localObject = null;
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.k(paramString, false, false);
    if (localg != null) {}
    for (paramString = localg.field_packageName;; paramString = localObject)
    {
      AppMethodBeat.o(78978);
      return paramString;
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.SDKOauthUtil", "dealWithCancel getAppInfo null; appid: %s", new Object[] { paramString });
    }
  }
  
  public static void aM(Activity paramActivity)
  {
    AppMethodBeat.i(78982);
    paramActivity.overridePendingTransition(2130771986, 2130771986);
    if (d.kZ(28))
    {
      paramActivity.finish();
      AppMethodBeat.o(78982);
      return;
    }
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78967);
        this.iuN.finish();
        AppMethodBeat.o(78967);
      }
    }, 500L);
    AppMethodBeat.o(78982);
  }
  
  private void aeU(final String paramString)
  {
    AppMethodBeat.i(78976);
    com.tencent.mm.ui.base.h.d(this.mContext, paramString, this.mContext.getString(2131766178), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(78966);
        if (!ai.this.Cqy)
        {
          paramAnonymousDialogInterface = ai.this;
          String str1 = paramString;
          String str2 = ai.aBM(paramAnonymousDialogInterface.mAppId);
          if (bs.isNullOrNil(str2))
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SDKOauthUtil", "dealWithError pkg nil");
            AppMethodBeat.o(78966);
            return;
          }
          SendAuth.Resp localResp = new SendAuth.Resp();
          localResp.transaction = paramAnonymousDialogInterface.tmt;
          localResp.errCode = -1;
          localResp.errStr = str1;
          localResp.lang = paramAnonymousDialogInterface.eBt();
          localResp.country = ai.getCountry();
          paramAnonymousDialogInterface.a(str2, localResp);
        }
        AppMethodBeat.o(78966);
      }
    });
    AppMethodBeat.o(78976);
  }
  
  public static byp e(String paramString, LinkedList<byp> paramLinkedList)
  {
    AppMethodBeat.i(78974);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      byp localbyp = (byp)paramLinkedList.next();
      if (paramString.equals(localbyp.scope))
      {
        AppMethodBeat.o(78974);
        return localbyp;
      }
    }
    AppMethodBeat.o(78974);
    return null;
  }
  
  static String getCountry()
  {
    AppMethodBeat.i(78979);
    String str = bs.bG((String)com.tencent.mm.kernel.g.agR().agA().get(274436, null), null);
    AppMethodBeat.o(78979);
    return str;
  }
  
  public final void M(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(78972);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SDKOauthUtil", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ((MMActivity)this.mContext).finish();
      AppMethodBeat.o(78972);
      return;
    }
    if (!UX(paramInt1))
    {
      aeU(this.mContext.getString(2131766179));
      AppMethodBeat.o(78972);
      return;
    }
    aeU(paramString);
    AppMethodBeat.o(78972);
  }
  
  public final void UW(int paramInt)
  {
    AppMethodBeat.i(78975);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SDKOauthUtil", "dealWithCancel");
    if (this.Cqy)
    {
      localObject1 = new aa(2, this.sXV, null, 0);
      com.tencent.mm.kernel.g.agi().a((n)localObject1, 0);
      ((MMActivity)this.mContext).finish();
      AppMethodBeat.o(78975);
      return;
    }
    Object localObject1 = aBM(this.mAppId);
    Object localObject2 = new ac(2, this.mAppId, this.kbt, (String)localObject1, null, this.teK);
    com.tencent.mm.kernel.g.agi().a((n)localObject2, 0);
    localObject2 = new SendAuth.Resp();
    ((SendAuth.Resp)localObject2).transaction = this.tmt;
    ((SendAuth.Resp)localObject2).errCode = paramInt;
    ((SendAuth.Resp)localObject2).lang = eBt();
    ((SendAuth.Resp)localObject2).country = getCountry();
    a((String)localObject1, (SendAuth.Resp)localObject2);
    ((MMActivity)this.mContext).finish();
    AppMethodBeat.o(78975);
  }
  
  final void a(String paramString, SendAuth.Resp paramResp)
  {
    AppMethodBeat.i(78977);
    if (this.Cqx)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SDKOauthUtil", "doCallback has callback");
      AppMethodBeat.o(78977);
      return;
    }
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78977);
      return;
    }
    this.Cqx = true;
    Bundle localBundle = new Bundle();
    paramResp.toBundle(localBundle);
    com.tencent.mm.pluginsdk.model.app.q.aW(localBundle);
    paramResp = new MMessageActV2.Args();
    paramResp.targetPkgName = paramString;
    paramResp.bundle = localBundle;
    MMessageActV2.send(this.mContext, paramResp);
    AppMethodBeat.o(78977);
  }
  
  public final void bh(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(78968);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append((String)paramLinkedList.get(i)).append(",");
      i += 1;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SDKOauthUtil", "doSDKOauthAuthorizeConfirm selectedScopes: %s", new Object[] { localStringBuilder.toString() });
    paramLinkedList = new ac(1, this.mAppId, this.kbt, aBM(this.mAppId), paramLinkedList, this.teK);
    com.tencent.mm.kernel.g.agi().a(paramLinkedList, 0);
    AppMethodBeat.o(78968);
  }
  
  public final void cg(String paramString, boolean paramBoolean)
  {
    String str1 = null;
    AppMethodBeat.i(78973);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback url : %s", new Object[] { paramString });
    String str2 = aBM(this.mAppId);
    if (bs.isNullOrNil(str2))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SDKOauthUtil", "dealWithLoginCallback pkg nil");
      AppMethodBeat.o(78973);
      return;
    }
    SendAuth.Resp localResp = new SendAuth.Resp();
    localResp.transaction = this.tmt;
    localResp.lang = eBt();
    localResp.country = getCountry();
    if (!bs.isNullOrNil(paramString)) {}
    for (Uri localUri = Uri.parse(paramString);; localUri = null)
    {
      if (localUri != null)
      {
        str1 = localUri.getQueryParameter("code");
        localResp.state = localUri.getQueryParameter("state");
        localResp.errStr = localUri.getQueryParameter("reason");
      }
      if ((bs.isNullOrNil(str1)) && (!paramBoolean)) {
        localResp.errCode = -1;
      }
      for (;;)
      {
        if (!paramBoolean) {
          localResp.url = paramString;
        }
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback, pkg:%s code:%s errCode:%d state:%s", new Object[] { str2, localResp.code, Integer.valueOf(localResp.errCode), localResp.state });
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
  
  final String eBt()
  {
    AppMethodBeat.i(78980);
    String str = ab.f(this.mContext.getSharedPreferences(com.tencent.mm.sdk.platformtools.ai.eUX(), 0));
    AppMethodBeat.o(78980);
    return str;
  }
  
  public final void j(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(78970);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SDKOauthUtil", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((ac)paramn).eBj();
      boolean bool = new LinkedList(((ac)paramn).CpD).contains("snsapi_wxaapp_info");
      cg(paramString.DRX, bool);
      AppMethodBeat.o(78970);
      return;
    }
    if (!UX(paramInt1))
    {
      aeU(this.mContext.getString(2131766179));
      AppMethodBeat.o(78970);
      return;
    }
    aeU(paramString);
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SDKOauthUtil", "doSDKOauthAuthorizeConfirm selectedScopes: %s", new Object[] { localStringBuilder.toString() });
    paramLinkedList = new ac(this.mAppId, this.kbt, aBM(this.mAppId), paramLinkedList, paramInt, this.teK);
    com.tencent.mm.kernel.g.agi().a(paramLinkedList, 0);
    AppMethodBeat.o(78969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ai
 * JD-Core Version:    0.7.0.1
 */