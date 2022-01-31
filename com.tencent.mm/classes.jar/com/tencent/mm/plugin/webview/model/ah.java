package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.protocal.protobuf.bgv;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ah
{
  private static String[] uVM;
  private static boolean uVN = false;
  
  private static LinkedList<bwv> Z(ArrayList<byte[]> paramArrayList)
  {
    AppMethodBeat.i(6674);
    LinkedList localLinkedList = new LinkedList();
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      AppMethodBeat.o(6674);
      return localLinkedList;
    }
    int i = 0;
    while (i < paramArrayList.size()) {
      try
      {
        bgv localbgv = new bgv();
        localbgv.parseFrom((byte[])paramArrayList.get(i));
        bwv localbwv = new bwv();
        localbwv.xJY = localbgv.xwa;
        localbwv.Desc = localbgv.desc;
        localbwv.wAh = localbgv.scope;
        localbwv.iEA = localbgv.iEA;
        localLinkedList.add(localbwv);
        i += 1;
      }
      catch (IOException paramArrayList)
      {
        ab.w("MicroMsg.OauthAuthorizeLogic", "bytesListToBytesListScopeInfoList: i:%d, exp:%s", new Object[] { Integer.valueOf(i), paramArrayList.getLocalizedMessage() });
        localLinkedList.clear();
        AppMethodBeat.o(6674);
        return localLinkedList;
      }
    }
    AppMethodBeat.o(6674);
    return localLinkedList;
  }
  
  private static ArrayList<byte[]> aE(LinkedList<bgv> paramLinkedList)
  {
    AppMethodBeat.i(6673);
    ArrayList localArrayList = new ArrayList();
    if ((paramLinkedList == null) || (paramLinkedList.isEmpty()))
    {
      AppMethodBeat.o(6673);
      return localArrayList;
    }
    int i = 0;
    while (i < paramLinkedList.size()) {
      try
      {
        localArrayList.add(((bgv)paramLinkedList.get(i)).toByteArray());
        i += 1;
      }
      catch (IOException paramLinkedList)
      {
        ab.w("MicroMsg.OauthAuthorizeLogic", "oauthScopeInfoListToBytesList index:%d, exp:%s ", new Object[] { Integer.valueOf(i), paramLinkedList.getLocalizedMessage() });
        localArrayList.clear();
        AppMethodBeat.o(6673);
        return localArrayList;
      }
    }
    AppMethodBeat.o(6673);
    return localArrayList;
  }
  
  public static abstract interface b
  {
    public abstract void add(int paramInt);
    
    public abstract boolean dbU();
    
    public abstract void remove(int paramInt);
  }
  
  public static final class c
  {
    private static long startTime = 0L;
    private static long uVO = 0L;
    
    private static void a(d paramd, String paramString, int paramInt1, ArrayList<String> paramArrayList, ah.b paramb, boolean paramBoolean, int paramInt2)
    {
      AppMethodBeat.i(6669);
      if (paramd == null)
      {
        ab.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm invoker null");
        AppMethodBeat.o(6669);
        return;
      }
      uVO = System.currentTimeMillis();
      Bundle localBundle = new Bundle();
      localBundle.putString("oauth_url", paramString);
      localBundle.putInt("opt", paramInt1);
      localBundle.putStringArrayList("scopes", paramArrayList);
      localBundle.putInt("webview_binder_id", paramInt2);
      if (paramBoolean) {}
      try
      {
        paramb.add(1373);
        paramd.v(1373, localBundle);
        AppMethodBeat.o(6669);
        return;
      }
      catch (RemoteException paramd)
      {
        ab.w("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm doScene exp : %s", new Object[] { paramd.getLocalizedMessage() });
        AppMethodBeat.o(6669);
      }
    }
    
    public static void a(boolean paramBoolean, String paramString, Bundle paramBundle, Context paramContext, ah.d paramd, ah.b paramb)
    {
      AppMethodBeat.i(154604);
      ab.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd suc: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      paramb.remove(1373);
      if (!paramBoolean)
      {
        h.a(paramContext, paramString, com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131305933), new ah.c.5(paramd));
        AppMethodBeat.o(154604);
        return;
      }
      if (paramBundle == null)
      {
        ab.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd resp null");
        AppMethodBeat.o(154604);
        return;
      }
      paramString = paramBundle.getString("redirect_url");
      if (bo.isNullOrNil(paramString))
      {
        ab.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirect null");
        AppMethodBeat.o(154604);
        return;
      }
      paramd.aha(paramString);
      ab.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirectUrl: %s", new Object[] { paramString });
      AppMethodBeat.o(154604);
    }
    
    public static void a(boolean paramBoolean, String paramString, Bundle paramBundle, Context paramContext, d paramd, ah.d paramd1, ah.b paramb, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(154603);
      ab.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd suc: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      paramd1.bmh();
      paramb.remove(1254);
      String str;
      if (paramBundle == null)
      {
        str = "";
        ab.i("MicroMsg.OauthAuthorizeLogic", "parse appID:%s", new Object[] { str });
        if (paramBoolean) {
          break label160;
        }
        h.a(paramContext, paramString, com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131305933), new ah.c.2(paramd1));
        paramBundle = com.tencent.mm.plugin.webview.f.a.vtM;
        if (str != null) {
          break label154;
        }
      }
      label154:
      for (paramString = "";; paramString = str)
      {
        paramBundle.a(paramString, startTime, 2, 1, 0, 0, paramInt2);
        com.tencent.mm.plugin.webview.f.a.vtM.ap(1, (int)(System.currentTimeMillis() - startTime), paramInt2);
        AppMethodBeat.o(154603);
        return;
        str = agZ(paramBundle.getString("oauth_url"));
        break;
      }
      label160:
      if (paramBundle == null)
      {
        ab.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd_Tools resp null");
        AppMethodBeat.o(154603);
        return;
      }
      paramBoolean = paramBundle.getBoolean("is_recent_has_auth");
      boolean bool = paramBundle.getBoolean("is_silence_auth");
      if ((paramBoolean) || (bool))
      {
        paramString = paramBundle.getString("redirect_url");
        if (bo.isNullOrNil(paramString))
        {
          ab.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd redirect null");
          AppMethodBeat.o(154603);
          return;
        }
        ab.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd isRecentHasAuth:%b isSilenceAuth:%b redirectUrl:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), paramString });
        c.a(paramContext, com.tencent.mm.model.gdpr.a.foA, str, new ah.c.3(paramd1, str, paramInt2, paramString));
        AppMethodBeat.o(154603);
        return;
      }
      paramString = new ah.c.4(paramContext, str, paramd1, paramInt2, paramBundle, paramd, paramb, paramInt1);
      if (((WebViewUI)paramContext).isFinishing()) {
        ab.i("MicroMsg.OauthAuthorizeLogic", "showWebAuthorizeDialog isFinishing");
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.f.a.vtM.ap(1, (int)(System.currentTimeMillis() - startTime), paramInt2);
        AppMethodBeat.o(154603);
        return;
        paramd = ah.aa((ArrayList)paramBundle.getSerializable("scope_list"));
        paramd1 = paramBundle.getString("appname");
        paramBundle = paramBundle.getString("appicon_url");
        new n(paramContext).a(paramd, paramd1, paramBundle, paramContext.getString(2131305944), paramString);
      }
    }
    
    private static boolean a(d paramd)
    {
      AppMethodBeat.i(6671);
      try
      {
        paramd = paramd.i(93, new Bundle());
        if (paramd == null)
        {
          ab.w("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept Bundle isOauthNative null");
          AppMethodBeat.o(6671);
          return false;
        }
        boolean bool = paramd.getBoolean("is_oauth_native");
        AppMethodBeat.o(6671);
        return bool;
      }
      catch (RemoteException paramd)
      {
        ab.w("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept exp:%s", new Object[] { paramd.getLocalizedMessage() });
        AppMethodBeat.o(6671);
      }
      return false;
    }
    
    private static boolean a(String paramString, d paramd)
    {
      AppMethodBeat.i(6670);
      if ((ah.dbR() == null) && (!ah.aTR())) {}
      try
      {
        Object localObject = paramd.i(94, new Bundle());
        paramd = null;
        if (localObject != null) {
          paramd = ((Bundle)localObject).getString("oauth_host_paths");
        }
        localObject = paramd;
        if (bo.isNullOrNil(paramd)) {
          localObject = "open.weixin.qq.com/connect/oauth2/authorize";
        }
        ah.K(((String)localObject).split(";"));
        ah.dbS();
        if ((ah.dbR() == null) || (ah.dbR().length == 0))
        {
          ab.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost sOauthHostPaths nil");
          AppMethodBeat.o(6670);
          return false;
        }
      }
      catch (RemoteException paramString)
      {
        ab.w("MicroMsg.OauthAuthorizeLogic", "isOauthHost exp:%s", new Object[] { paramString.getLocalizedMessage() });
        AppMethodBeat.o(6670);
        return false;
      }
      paramString = Uri.parse(paramString);
      paramString = paramString.getAuthority() + paramString.getPath();
      if (bo.isNullOrNil(paramString))
      {
        ab.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost target nil");
        AppMethodBeat.o(6670);
        return false;
      }
      ab.d("MicroMsg.OauthAuthorizeLogic", "isOauthHost target:%s", new Object[] { paramString });
      int i = 0;
      while (i < ah.dbR().length)
      {
        if (paramString.equalsIgnoreCase(ah.dbR()[i]))
        {
          AppMethodBeat.o(6670);
          return true;
        }
        i += 1;
      }
      AppMethodBeat.o(6670);
      return false;
    }
    
    public static boolean a(String paramString, d paramd, int paramInt)
    {
      AppMethodBeat.i(154602);
      if (6 == paramInt)
      {
        ab.i("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept from oauth");
        AppMethodBeat.o(154602);
        return false;
      }
      if (bo.isNullOrNil(paramString))
      {
        AppMethodBeat.o(154602);
        return false;
      }
      if (paramd == null)
      {
        AppMethodBeat.o(154602);
        return false;
      }
      if ((a(paramd)) && (a(paramString, paramd)))
      {
        AppMethodBeat.o(154602);
        return true;
      }
      AppMethodBeat.o(154602);
      return false;
    }
    
    public static boolean a(String paramString1, String paramString2, int paramInt1, d paramd, ah.d paramd1, ah.b paramb, int paramInt2)
    {
      AppMethodBeat.i(6668);
      if (paramd == null)
      {
        ab.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize invoker null");
        AppMethodBeat.o(6668);
        return false;
      }
      startTime = System.currentTimeMillis();
      com.tencent.mm.plugin.webview.f.a.vtM.reset(1);
      ab.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize scene: %d", new Object[] { Integer.valueOf(paramInt1) });
      paramd1.d(new ah.c.1(paramd1, paramb));
      paramd1 = new Bundle();
      paramd1.putString("oauth_url", paramString1);
      paramd1.putString("biz_username", paramString2);
      paramd1.putInt("scene", paramInt1);
      paramd1.putInt("webview_binder_id", paramInt2);
      try
      {
        paramb.add(1254);
        paramd.v(1254, paramd1);
        AppMethodBeat.o(6668);
        return true;
      }
      catch (RemoteException paramString1)
      {
        ab.w("MicroMsg.OauthAuthorizeLogic", "invoker.doScene exp : %s", new Object[] { paramString1.getLocalizedMessage() });
        AppMethodBeat.o(6668);
      }
      return false;
    }
    
    private static String agZ(String paramString)
    {
      localObject1 = null;
      AppMethodBeat.i(6672);
      if (bo.isNullOrNil(paramString))
      {
        AppMethodBeat.o(6672);
        return null;
      }
      try
      {
        String str = Uri.parse(paramString).getQueryParameter("appid");
        localObject2 = str;
        localObject1 = str;
        if (bo.isNullOrNil(str))
        {
          localObject1 = str;
          ab.i("MicroMsg.OauthAuthorizeLogic", "parseAppId try case not sensitive, oauthUrl:%s", new Object[] { paramString });
          localObject1 = str;
          localObject2 = Uri.parse(paramString.toLowerCase()).getQueryParameter("appid");
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Object localObject2 = localObject1;
        }
      }
      AppMethodBeat.o(6672);
      return localObject2;
    }
  }
  
  public static abstract interface d
  {
    public abstract void aha(String paramString);
    
    public abstract void bmh();
    
    public abstract void d(DialogInterface.OnCancelListener paramOnCancelListener);
    
    public abstract void goBack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ah
 * JD-Core Version:    0.7.0.1
 */