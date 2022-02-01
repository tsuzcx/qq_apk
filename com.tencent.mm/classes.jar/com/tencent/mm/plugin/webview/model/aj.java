package com.tencent.mm.plugin.webview.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.bw.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.modelmsg.SendTdiAuth.Resp;
import com.tencent.mm.protocal.protobuf.cuh;
import com.tencent.mm.protocal.protobuf.drk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;

public final class aj
{
  private boolean IYZ;
  boolean IZa = false;
  private String lDx;
  public String mAppId;
  private Context mContext;
  private String xFX;
  String xOq;
  private String xyo;
  
  public aj(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.IZa = true;
    this.mAppId = paramString1;
    this.xyo = paramString2;
  }
  
  public aj(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mContext = paramContext;
    this.mAppId = paramString1;
    this.xOq = paramString2;
    this.lDx = paramString3;
    this.IYZ = false;
    this.xFX = paramString4;
  }
  
  public static void a(drk paramdrk, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(78984);
    if (e("snsapi_userinfo", paramdrk.Mzs) != null)
    {
      paramLinkedList.add("snsapi_userinfo");
      AppMethodBeat.o(78984);
      return;
    }
    if (e("snsapi_login", paramdrk.Mzs) != null)
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
    Log.i("MicroMsg.SDKOauthUtil", "doQRCodeOauthAuthorizeConfirm selectedScopes: %s", new Object[] { localStringBuilder.toString() });
    paramLinkedList = new aa(1, paramString, paramLinkedList, paramInt);
    com.tencent.mm.kernel.g.azz().a(paramLinkedList, 0);
    AppMethodBeat.o(78971);
  }
  
  public static void aT(Activity paramActivity)
  {
    AppMethodBeat.i(78982);
    paramActivity.overridePendingTransition(2130771986, 2130771986);
    if (d.oD(28))
    {
      paramActivity.finish();
      AppMethodBeat.o(78982);
      return;
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78967);
        this.dnO.finish();
        AppMethodBeat.o(78967);
      }
    }, 500L);
    AppMethodBeat.o(78982);
  }
  
  static String aYG(String paramString)
  {
    AppMethodBeat.i(78978);
    Object localObject = null;
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.o(paramString, false, false);
    if (localg != null) {}
    for (paramString = localg.field_packageName;; paramString = localObject)
    {
      AppMethodBeat.o(78978);
      return paramString;
      Log.w("MicroMsg.SDKOauthUtil", "dealWithCancel getAppInfo null; appid: %s", new Object[] { paramString });
    }
  }
  
  private boolean agc(int paramInt)
  {
    AppMethodBeat.i(78981);
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8))
    {
      Log.e("MicroMsg.SDKOauthUtil", "isNetworkAvailable false, errType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(78981);
      return false;
    }
    if (!NetStatusUtil.isConnected(this.mContext))
    {
      Log.e("MicroMsg.SDKOauthUtil", "isNetworkAvailable false, not connected");
      AppMethodBeat.o(78981);
      return false;
    }
    AppMethodBeat.o(78981);
    return true;
  }
  
  private void axc(final String paramString)
  {
    AppMethodBeat.i(78976);
    com.tencent.mm.ui.base.h.d(this.mContext, paramString, this.mContext.getString(2131768654), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(78966);
        if (!aj.this.IZa)
        {
          paramAnonymousDialogInterface = aj.this;
          String str1 = paramString;
          String str2 = aj.aYG(paramAnonymousDialogInterface.mAppId);
          if (Util.isNullOrNil(str2))
          {
            Log.e("MicroMsg.SDKOauthUtil", "dealWithError pkg nil");
            AppMethodBeat.o(78966);
            return;
          }
          SendAuth.Resp localResp = new SendAuth.Resp();
          localResp.transaction = paramAnonymousDialogInterface.xOq;
          localResp.errCode = -1;
          localResp.errStr = str1;
          localResp.lang = paramAnonymousDialogInterface.gcM();
          localResp.country = aj.getCountry();
          paramAnonymousDialogInterface.a(str2, localResp);
        }
        AppMethodBeat.o(78966);
      }
    });
    AppMethodBeat.o(78976);
  }
  
  public static boolean b(drk paramdrk)
  {
    AppMethodBeat.i(78983);
    if ((e("snsapi_userinfo", paramdrk.Mzs) != null) || (e("snsapi_login", paramdrk.Mzs) != null) || (e("group_sns_login", paramdrk.Mzs) != null))
    {
      AppMethodBeat.o(78983);
      return true;
    }
    AppMethodBeat.o(78983);
    return false;
  }
  
  public static cuh e(String paramString, LinkedList<cuh> paramLinkedList)
  {
    AppMethodBeat.i(78974);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      cuh localcuh = (cuh)paramLinkedList.next();
      if (paramString.equals(localcuh.scope))
      {
        AppMethodBeat.o(78974);
        return localcuh;
      }
    }
    AppMethodBeat.o(78974);
    return null;
  }
  
  static String getCountry()
  {
    AppMethodBeat.i(78979);
    String str = Util.nullAs((String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null), null);
    AppMethodBeat.o(78979);
    return str;
  }
  
  public final void Q(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(78972);
    Log.i("MicroMsg.SDKOauthUtil", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ((MMActivity)this.mContext).finish();
      AppMethodBeat.o(78972);
      return;
    }
    if (!agc(paramInt1))
    {
      axc(this.mContext.getString(2131768655));
      AppMethodBeat.o(78972);
      return;
    }
    axc(paramString);
    AppMethodBeat.o(78972);
  }
  
  public final void a(ai paramai, String paramString)
  {
    AppMethodBeat.i(211000);
    String str2 = paramai.gcK();
    Log.i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback url : %s", new Object[] { str2 });
    String str3 = aYG(this.mAppId);
    if (Util.isNullOrNil(str3))
    {
      Log.e("MicroMsg.SDKOauthUtil", "dealWithLoginCallback pkg nil");
      AppMethodBeat.o(211000);
      return;
    }
    boolean bool = paramString.trim().equals("snsapi_wxaapp_info");
    if ((paramai.gcL() != null) && (paramai.gcL().zy.length > 0))
    {
      paramString = new SendTdiAuth.Resp(Bundle.EMPTY);
      ((SendTdiAuth.Resp)paramString).tdiAuthBuffer = paramai.gcL().toByteArray();
      paramai = paramString;
      paramai.transaction = this.xOq;
      paramai.lang = gcM();
      paramai.country = getCountry();
      if (Util.isNullOrNil(str2)) {
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
        if ((Util.isNullOrNil(paramString)) && (!bool)) {
          paramai.errCode = -1;
        }
        for (;;)
        {
          if (!bool) {
            paramai.url = str2;
          }
          Log.i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback, pkg:%s code:%s errCode:%d state:%s", new Object[] { str3, paramai.code, Integer.valueOf(paramai.errCode), paramai.state });
          a(str3, paramai);
          ((MMActivity)this.mContext).finish();
          AppMethodBeat.o(211000);
          return;
          paramai = new SendAuth.Resp();
          break;
          if (Util.nullAsNil(paramString).toLowerCase().equals("authdeny"))
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
    if (this.IYZ)
    {
      Log.i("MicroMsg.SDKOauthUtil", "doCallback has callback");
      AppMethodBeat.o(78977);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78977);
      return;
    }
    this.IYZ = true;
    Bundle localBundle = new Bundle();
    paramResp.toBundle(localBundle);
    com.tencent.mm.pluginsdk.model.app.q.bo(localBundle);
    paramResp = new MMessageActV2.Args();
    paramResp.targetPkgName = paramString;
    paramResp.bundle = localBundle;
    MMessageActV2.send(this.mContext, paramResp);
    AppMethodBeat.o(78977);
  }
  
  public final void agb(int paramInt)
  {
    AppMethodBeat.i(78975);
    Log.i("MicroMsg.SDKOauthUtil", "dealWithCancel");
    if (this.IZa)
    {
      localObject1 = new aa(2, this.xyo, null, 0);
      com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject1, 0);
      ((MMActivity)this.mContext).finish();
      AppMethodBeat.o(78975);
      return;
    }
    Object localObject1 = aYG(this.mAppId);
    Object localObject2 = new ac(2, this.mAppId, this.lDx, (String)localObject1, null, this.xFX);
    com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject2, 0);
    localObject2 = new SendAuth.Resp();
    ((SendAuth.Resp)localObject2).transaction = this.xOq;
    ((SendAuth.Resp)localObject2).errCode = paramInt;
    ((SendAuth.Resp)localObject2).lang = gcM();
    ((SendAuth.Resp)localObject2).country = getCountry();
    a((String)localObject1, (SendAuth.Resp)localObject2);
    ((MMActivity)this.mContext).finish();
    AppMethodBeat.o(78975);
  }
  
  public final void bE(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(78968);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append((String)paramLinkedList.get(i)).append(",");
      i += 1;
    }
    Log.i("MicroMsg.SDKOauthUtil", "doSDKOauthAuthorizeConfirm selectedScopes: %s", new Object[] { localStringBuilder.toString() });
    paramLinkedList = new ac(1, this.mAppId, this.lDx, aYG(this.mAppId), paramLinkedList, this.xFX);
    com.tencent.mm.kernel.g.azz().a(paramLinkedList, 0);
    AppMethodBeat.o(78968);
  }
  
  final String gcM()
  {
    AppMethodBeat.i(78980);
    String str = LocaleUtil.loadApplicationLanguage(this.mContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.mContext);
    AppMethodBeat.o(78980);
    return str;
  }
  
  public final void i(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(78970);
    Log.i("MicroMsg.SDKOauthUtil", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((ac)paramq).gcA();
      paramq = org.apache.commons.b.g.a(new LinkedList(((ac)paramq).IXZ), ",");
      a(ai.a.a(paramString), paramq);
      AppMethodBeat.o(78970);
      return;
    }
    if (!agc(paramInt1))
    {
      axc(this.mContext.getString(2131768655));
      AppMethodBeat.o(78970);
      return;
    }
    axc(paramString);
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
    Log.i("MicroMsg.SDKOauthUtil", "doSDKOauthAuthorizeConfirm selectedScopes: %s", new Object[] { localStringBuilder.toString() });
    paramLinkedList = new ac(this.mAppId, this.lDx, aYG(this.mAppId), paramLinkedList, paramInt, this.xFX);
    com.tencent.mm.kernel.g.azz().a(paramLinkedList, 0);
    AppMethodBeat.o(78969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.aj
 * JD-Core Version:    0.7.0.1
 */