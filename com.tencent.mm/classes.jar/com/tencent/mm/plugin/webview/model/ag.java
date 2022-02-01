package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.gdpr.a;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.widget.r.a;
import com.tencent.mm.protocal.protobuf.cua;
import com.tencent.mm.protocal.protobuf.cub;
import com.tencent.mm.protocal.protobuf.cuc;
import com.tencent.mm.protocal.protobuf.cud;
import com.tencent.mm.protocal.protobuf.cuh;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ag
{
  private static String[] IYa;
  private static boolean IYb = false;
  
  public static LinkedList<drb> aZ(ArrayList<byte[]> paramArrayList)
  {
    AppMethodBeat.i(78963);
    LinkedList localLinkedList = new LinkedList();
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      AppMethodBeat.o(78963);
      return localLinkedList;
    }
    int i = 0;
    while (i < paramArrayList.size()) {
      try
      {
        cuh localcuh = new cuh();
        localcuh.parseFrom((byte[])paramArrayList.get(i));
        drb localdrb = new drb();
        localdrb.MTI = localcuh.MzA;
        localdrb.Desc = localcuh.desc;
        localdrb.KWK = localcuh.scope;
        localdrb.nBo = localcuh.nBo;
        localLinkedList.add(localdrb);
        i += 1;
      }
      catch (IOException paramArrayList)
      {
        Log.w("MicroMsg.OauthAuthorizeLogic", "bytesListToBytesListScopeInfoList: i:%d, exp:%s", new Object[] { Integer.valueOf(i), paramArrayList.getLocalizedMessage() });
        localLinkedList.clear();
        AppMethodBeat.o(78963);
        return localLinkedList;
      }
    }
    AppMethodBeat.o(78963);
    return localLinkedList;
  }
  
  private static ArrayList<byte[]> bA(LinkedList<cuh> paramLinkedList)
  {
    AppMethodBeat.i(78962);
    ArrayList localArrayList = new ArrayList();
    if ((paramLinkedList == null) || (paramLinkedList.isEmpty()))
    {
      AppMethodBeat.o(78962);
      return localArrayList;
    }
    int i = 0;
    while (i < paramLinkedList.size()) {
      try
      {
        localArrayList.add(((cuh)paramLinkedList.get(i)).toByteArray());
        i += 1;
      }
      catch (IOException paramLinkedList)
      {
        Log.w("MicroMsg.OauthAuthorizeLogic", "oauthScopeInfoListToBytesList index:%d, exp:%s ", new Object[] { Integer.valueOf(i), paramLinkedList.getLocalizedMessage() });
        localArrayList.clear();
        AppMethodBeat.o(78962);
        return localArrayList;
      }
    }
    AppMethodBeat.o(78962);
    return localArrayList;
  }
  
  public static String gcB()
  {
    AppMethodBeat.i(210998);
    String str = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rSS, "");
    Log.i("MicroMsg.OauthAuthorizeLogic", "getOauthHostPaths %s", new Object[] { str });
    AppMethodBeat.o(210998);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void xr();
  }
  
  public static final class b
  {
    public static long IYc = 0L;
    public static long startTime = 0L;
    
    private static void a(e parame, String paramString, int paramInt, ArrayList<String> paramArrayList, final ag.a parama, final boolean paramBoolean, final ag.c paramc, final Context paramContext)
    {
      AppMethodBeat.i(210995);
      if (parame == null)
      {
        Log.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm invoker null");
        AppMethodBeat.o(210995);
        return;
      }
      IYc = System.currentTimeMillis();
      cua localcua = new cua();
      localcua.Mzp = paramString;
      localcua.Mzq = paramInt;
      localcua.Mzr = new LinkedList(paramArrayList);
      paramString = new d.a();
      paramString.iLN = localcua;
      paramString.iLO = new cub();
      paramString.uri = "/cgi-bin/mmbiz-bin/oauth_authorize_confirm";
      paramString.funcId = 1373;
      paramString.iLP = 0;
      paramString.respCmdId = 0;
      IPCRunCgi.a(paramString.aXF(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd)
        {
          AppMethodBeat.i(210992);
          Log.i("MicroMsg.OauthAuthorizeLogic", "onSceneEnd doOauthAuthorizeConfirm errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((this.IYe == null) || (parama == null) || (!paramBoolean))
          {
            AppMethodBeat.o(210992);
            return;
          }
          Bundle localBundle = new Bundle();
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousd != null) && (paramAnonymousd.iLL.iLR != null) && ((paramAnonymousd.iLL.iLR instanceof cub)))
          {
            localBundle.putString("redirect_url", ((cub)paramAnonymousd.iLL.iLR).KJw);
            ag.b.a(true, paramAnonymousString, localBundle, paramContext, paramc, parama);
            AppMethodBeat.o(210992);
            return;
          }
          ag.b.a(false, paramAnonymousString, localBundle, paramContext, paramc, parama);
          AppMethodBeat.o(210992);
        }
      });
      AppMethodBeat.o(210995);
    }
    
    public static void a(boolean paramBoolean, final String paramString, Bundle paramBundle, Context paramContext, final ag.c paramc, ag.a parama)
    {
      AppMethodBeat.i(78955);
      Log.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd suc: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      if ((paramContext == null) || (((WebViewUI)paramContext).isFinishing()))
      {
        AppMethodBeat.o(78955);
        return;
      }
      parama.xr();
      if (!paramBoolean)
      {
        com.tencent.f.h.RTc.aV(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(210990);
            com.tencent.mm.ui.base.h.d(this.val$context, paramString, MMApplicationContext.getContext().getString(2131768654), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(210989);
                ag.b.7.this.IYi.goBack();
                AppMethodBeat.o(210989);
              }
            });
            AppMethodBeat.o(210990);
          }
        });
        AppMethodBeat.o(78955);
        return;
      }
      paramString = paramBundle.getString("redirect_url");
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirect null");
        AppMethodBeat.o(78955);
        return;
      }
      paramc.aXL(paramString);
      Log.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirectUrl: %s", new Object[] { paramString });
      AppMethodBeat.o(78955);
    }
    
    public static void a(boolean paramBoolean, final String paramString, final Bundle paramBundle, Context paramContext, final e parame, final ag.c paramc, final ag.a parama, final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(78954);
      Log.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd suc: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      paramc.cGW();
      final String str = aYE(paramBundle.getString("oauth_url"));
      Log.i("MicroMsg.OauthAuthorizeLogic", "parse appID:%s", new Object[] { str });
      if (!paramBoolean)
      {
        com.tencent.f.h.RTc.aV(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(210982);
            com.tencent.mm.ui.base.h.d(this.val$context, paramString, MMApplicationContext.getContext().getString(2131768654), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(210981);
                ag.b.3.this.IYi.goBack();
                AppMethodBeat.o(210981);
              }
            });
            AppMethodBeat.o(210982);
          }
        });
        paramBundle = com.tencent.mm.plugin.webview.k.b.JBk;
        if (str == null) {}
        for (paramString = "";; paramString = str)
        {
          paramBundle.a(paramString, startTime, 2, 1, 0, 0, paramInt2);
          com.tencent.mm.plugin.webview.k.b.JBk.aO(1, (int)(System.currentTimeMillis() - startTime), paramInt2);
          AppMethodBeat.o(78954);
          return;
        }
      }
      paramBoolean = paramBundle.getBoolean("is_recent_has_auth");
      boolean bool = paramBundle.getBoolean("is_silence_auth");
      if ((paramBoolean) || (bool))
      {
        paramString = paramBundle.getString("redirect_url");
        if (Util.isNullOrNil(paramString))
        {
          Log.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd redirect null");
          AppMethodBeat.o(78954);
          return;
        }
        Log.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd isRecentHasAuth:%b isSilenceAuth:%b redirectUrl:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), paramString });
        c.a(paramContext, a.iGO, str, new com.tencent.mm.model.gdpr.b()
        {
          public final void sx(final int paramAnonymousInt)
          {
            AppMethodBeat.i(210984);
            Log.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(210983);
                if (paramAnonymousInt == 1)
                {
                  ag.b.4.this.IYi.goBack();
                  localb = com.tencent.mm.plugin.webview.k.b.JBk;
                  if (ag.b.4.this.IYk == null) {}
                  for (str = "";; str = ag.b.4.this.IYk)
                  {
                    localb.a(str, ag.b.startTime, 0, 1, 0, 0, ag.b.4.this.val$errCode);
                    com.tencent.mm.plugin.webview.k.b.JBk.aO(1, (int)(System.currentTimeMillis() - ag.b.startTime), ag.b.4.this.val$errCode);
                    AppMethodBeat.o(210983);
                    return;
                  }
                }
                ag.b.4.this.IYi.aXL(ag.b.4.this.IYl);
                com.tencent.mm.plugin.webview.k.b localb = com.tencent.mm.plugin.webview.k.b.JBk;
                if (ag.b.4.this.IYk == null) {}
                for (String str = "";; str = ag.b.4.this.IYk)
                {
                  localb.a(str, ag.b.startTime, 1, 1, 0, 0, ag.b.4.this.val$errCode);
                  break;
                }
              }
            });
            AppMethodBeat.o(210984);
          }
        });
        AppMethodBeat.o(78954);
        return;
      }
      paramBoolean = paramBundle.getBoolean("is_use_new_page", false);
      int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rSU, 1);
      Log.i("MicroMsg.OauthAuthorizeLogic", "isUseNewPage = %b, open= %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      if ((paramBoolean) && (1 == i)) {
        com.tencent.f.h.RTc.aV(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(210985);
            ah.a(this.val$context, paramBundle, paramInt1, paramc);
            AppMethodBeat.o(210985);
          }
        });
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.k.b.JBk.aO(1, (int)(System.currentTimeMillis() - startTime), paramInt2);
        AppMethodBeat.o(78954);
        return;
        paramString = new r.a()
        {
          public final void i(int paramAnonymousInt, final Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(210988);
            Log.i("MicroMsg.OauthAuthorizeLogic", "WebAuthorizeDialog#onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            switch (paramAnonymousInt)
            {
            default: 
              paramc.goBack();
              AppMethodBeat.o(210988);
              return;
            case 1: 
              c.a(this.val$context, a.iGO, str, new com.tencent.mm.model.gdpr.b()
              {
                public final void sx(final int paramAnonymous2Int)
                {
                  AppMethodBeat.i(210987);
                  Log.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(210986);
                      if (paramAnonymous2Int == 1)
                      {
                        ag.b.6.this.IYi.goBack();
                        localb = com.tencent.mm.plugin.webview.k.b.JBk;
                        if (ag.b.6.this.IYk == null) {}
                        for (str = "";; str = ag.b.6.this.IYk)
                        {
                          localb.a(str, ag.b.startTime, 0, 1, 0, 1, ag.b.6.this.val$errCode);
                          com.tencent.mm.plugin.webview.k.b.JBk.aO(2, (int)(System.currentTimeMillis() - ag.b.IYc), ag.b.6.this.val$errCode);
                          AppMethodBeat.o(210986);
                          return;
                        }
                      }
                      com.tencent.mm.plugin.webview.k.b localb = com.tencent.mm.plugin.webview.k.b.JBk;
                      if (ag.b.6.this.IYk == null) {}
                      for (String str = "";; str = ag.b.6.this.IYk)
                      {
                        localb.a(str, ag.b.startTime, 1, 1, 0, 1, ag.b.6.this.val$errCode);
                        ag.b.a(ag.b.6.this.IYn, ag.b.6.1.this.IYo, ag.b.6.this.IYi, ag.b.6.this.IYe, ag.b.6.this.IYf, ag.b.6.this.val$context);
                        break;
                      }
                    }
                  });
                  AppMethodBeat.o(210987);
                }
              });
              AppMethodBeat.o(210988);
              return;
            }
            ag.b.b(paramBundle, paramAnonymousBundle, paramc, parame, parama, this.val$context);
            com.tencent.mm.plugin.webview.k.b localb = com.tencent.mm.plugin.webview.k.b.JBk;
            if (str == null) {}
            for (paramAnonymousBundle = "";; paramAnonymousBundle = str)
            {
              localb.a(paramAnonymousBundle, ag.b.startTime, 0, 1, 0, 1, paramInt2);
              com.tencent.mm.plugin.webview.k.b.JBk.aO(2, (int)(System.currentTimeMillis() - ag.b.IYc), paramInt2);
              AppMethodBeat.o(210988);
              return;
            }
          }
        };
        if (((paramContext instanceof WebViewUI)) && (((WebViewUI)paramContext).isFinishing()))
        {
          Log.i("MicroMsg.OauthAuthorizeLogic", "showWebAuthorizeDialog isFinishing");
        }
        else
        {
          parame = ag.aZ((ArrayList)paramBundle.getSerializable("scope_list"));
          paramc = paramBundle.getString("appname");
          paramBundle = paramBundle.getString("appicon_url");
          com.tencent.f.h.RTc.aV(new ag.b.8(paramContext, parame, paramc, paramBundle, paramString));
        }
      }
    }
    
    public static boolean a(final String paramString1, String paramString2, int paramInt1, final e parame, final ag.c paramc, final ag.a parama, final int paramInt2, Context paramContext)
    {
      AppMethodBeat.i(210994);
      if (parame == null)
      {
        Log.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize invoker null");
        AppMethodBeat.o(210994);
        return false;
      }
      startTime = System.currentTimeMillis();
      com.tencent.mm.plugin.webview.k.b.JBk.da(1, "");
      Log.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize scene: %d", new Object[] { Integer.valueOf(paramInt1) });
      paramc.e(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(78944);
          Log.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize user cancel");
          this.IYd.cGW();
          AppMethodBeat.o(78944);
        }
      });
      cuc localcuc = new cuc();
      localcuc.Mzp = paramString1;
      localcuc.KUC = paramString2;
      localcuc.scene = paramInt1;
      paramString2 = new d.a();
      paramString2.iLN = localcuc;
      paramString2.iLO = new cud();
      paramString2.uri = "/cgi-bin/mmbiz-bin/oauth_authorize";
      paramString2.funcId = 1254;
      paramString2.iLP = 0;
      paramString2.respCmdId = 0;
      IPCRunCgi.a(paramString2.aXF(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd)
        {
          AppMethodBeat.i(210980);
          Log.i("MicroMsg.OauthAuthorizeLogic", "onSceneEnd doOauthAuthorize errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((this.val$context == null) || (parame == null) || (paramc == null) || (parama == null))
          {
            AppMethodBeat.o(210980);
            return;
          }
          Bundle localBundle = new Bundle();
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousd != null) && (paramAnonymousd.iLL.iLR != null) && ((paramAnonymousd.iLL.iLR instanceof cud)))
          {
            paramAnonymousd = (cud)paramAnonymousd.iLL.iLR;
            localBundle.putString("oauth_url", paramString1);
            localBundle.putSerializable("scope_list", ag.bB(paramAnonymousd.Mzs));
            localBundle.putString("appname", paramAnonymousd.ixZ);
            localBundle.putString("appicon_url", paramAnonymousd.Mzt);
            localBundle.putString("redirect_url", paramAnonymousd.KJw);
            localBundle.putBoolean("is_recent_has_auth", paramAnonymousd.Mzu);
            localBundle.putBoolean("is_silence_auth", paramAnonymousd.Mzv);
            localBundle.putBoolean("is_call_server_when_confirm", paramAnonymousd.Mzw);
            localBundle.putSerializable("avatar_list", ah.bC(paramAnonymousd.Mzx));
            localBundle.putBoolean("is_use_new_page", paramAnonymousd.Mzy);
            localBundle.putBoolean("is_ban_modify_avatar", paramAnonymousd.lHF);
            localBundle.putInt("avatar_limit", paramAnonymousd.lHG);
            localBundle.putInt("default_avatar_id", paramAnonymousd.lHH);
            localBundle.putString("default_headimg_url", paramAnonymousd.lHI);
            localBundle.putString("default_headimg_fileid", paramAnonymousd.lHJ);
            ag.b.a(true, paramAnonymousString, localBundle, this.val$context, parame, paramc, parama, paramInt2, paramAnonymousInt2);
            AppMethodBeat.o(210980);
            return;
          }
          ag.b.a(false, paramAnonymousString, localBundle, this.val$context, parame, paramc, parama, paramInt2, paramAnonymousInt2);
          AppMethodBeat.o(210980);
        }
      });
      AppMethodBeat.o(210994);
      return true;
    }
    
    public static String aYE(String paramString)
    {
      localObject1 = null;
      AppMethodBeat.i(78959);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(78959);
        return null;
      }
      try
      {
        String str = Uri.parse(paramString).getQueryParameter("appid");
        localObject2 = str;
        localObject1 = str;
        if (Util.isNullOrNil(str))
        {
          localObject1 = str;
          Log.i("MicroMsg.OauthAuthorizeLogic", "parseAppId try case not sensitive, oauthUrl:%s", new Object[] { paramString });
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
      AppMethodBeat.o(78959);
      return localObject2;
    }
    
    public static boolean gr(String paramString, int paramInt)
    {
      AppMethodBeat.i(210993);
      if (6 == paramInt)
      {
        Log.i("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept from oauth");
        AppMethodBeat.o(210993);
        return false;
      }
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(210993);
        return false;
      }
      paramInt = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rSS, 1);
      Log.i("MicroMsg.OauthAuthorizeLogic", "isABTestOpen %d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1)
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label296;
        }
        if ((ag.gcC() == null) && (!ag.IYb))
        {
          String str2 = ag.gcB();
          String str1 = str2;
          if (Util.isNullOrNil(str2)) {
            str1 = WeChatHosts.domainString(2131761728) + "/connect/oauth2/authorize";
          }
          ag.access$302(str1.split(";"));
          ag.gcD();
        }
        if ((ag.gcC() != null) && (ag.gcC().length != 0)) {
          break label198;
        }
        Log.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost sOauthHostPaths nil");
      }
      label294:
      for (;;)
      {
        paramInt = 0;
        if (paramInt == 0) {
          break label296;
        }
        AppMethodBeat.o(210993);
        return true;
        paramInt = 0;
        break;
        label198:
        paramString = Uri.parse(paramString);
        paramString = paramString.getAuthority() + paramString.getPath();
        if (Util.isNullOrNil(paramString))
        {
          Log.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost target nil");
        }
        else
        {
          Log.d("MicroMsg.OauthAuthorizeLogic", "isOauthHost target:%s", new Object[] { paramString });
          paramInt = 0;
          for (;;)
          {
            if (paramInt >= ag.gcC().length) {
              break label294;
            }
            if (paramString.equalsIgnoreCase(ag.gcC()[paramInt]))
            {
              paramInt = 1;
              break;
            }
            paramInt += 1;
          }
        }
      }
      label296:
      AppMethodBeat.o(210993);
      return false;
    }
  }
  
  public static abstract interface c
  {
    public abstract void aXL(String paramString);
    
    public abstract void cGW();
    
    public abstract void e(DialogInterface.OnCancelListener paramOnCancelListener);
    
    public abstract void goBack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ag
 * JD-Core Version:    0.7.0.1
 */