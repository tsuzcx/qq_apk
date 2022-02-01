package com.tencent.mm.plugin.webview.model;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.gdpr.a;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.widget.t;
import com.tencent.mm.plugin.webview.ui.tools.widget.t.a;
import com.tencent.mm.protocal.protobuf.dux;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.protocal.protobuf.dva;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.protocal.protobuf.dvf;
import com.tencent.mm.protocal.protobuf.eul;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.k;
import com.tencent.threadpool.i;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ag
{
  private static String[] WLd;
  private static boolean WLe = false;
  
  public static LinkedList<eul> bP(ArrayList<byte[]> paramArrayList)
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
        dve localdve = new dve();
        localdve.parseFrom((byte[])paramArrayList.get(i));
        eul localeul = new eul();
        localeul.abxm = localdve.abbc;
        localeul.IGG = localdve.desc;
        localeul.YVX = localdve.scope;
        localeul.tIs = localdve.tIs;
        localeul.abxn = localdve.aaAp;
        localLinkedList.add(localeul);
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
  
  private static ArrayList<byte[]> ci(LinkedList<dve> paramLinkedList)
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
        localArrayList.add(((dve)paramLinkedList.get(i)).toByteArray());
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
  
  public static String ivh()
  {
    AppMethodBeat.i(298309);
    String str = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMW, "");
    Log.i("MicroMsg.OauthAuthorizeLogic", "getOauthHostPaths %s", new Object[] { str });
    AppMethodBeat.o(298309);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void gaS();
  }
  
  public static final class b
  {
    public static long WLf = 0L;
    private static int WLg = -1;
    public static long startTime = 0L;
    
    private static void a(e parame, String paramString, int paramInt, ArrayList<String> paramArrayList, final ag.a parama, final boolean paramBoolean, final ag.c paramc, final Context paramContext)
    {
      AppMethodBeat.i(298393);
      if (parame == null)
      {
        Log.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm invoker null");
        AppMethodBeat.o(298393);
        return;
      }
      WLf = System.currentTimeMillis();
      dux localdux = new dux();
      localdux.abaO = paramString;
      localdux.abaP = paramInt;
      localdux.abaQ = new LinkedList(paramArrayList);
      paramString = new com.tencent.mm.am.c.a();
      paramString.otE = localdux;
      paramString.otF = new duy();
      paramString.uri = "/cgi-bin/mmbiz-bin/oauth_authorize_confirm";
      paramString.funcId = 1373;
      paramString.otG = 0;
      paramString.respCmdId = 0;
      IPCRunCgi.a(paramString.bEF(), new IPCRunCgi.a()
      {
        public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc)
        {
          AppMethodBeat.i(298340);
          Log.i("MicroMsg.OauthAuthorizeLogic", "onSceneEnd doOauthAuthorizeConfirm errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((ag.b.this == null) || (parama == null) || (!paramBoolean))
          {
            AppMethodBeat.o(298340);
            return;
          }
          Bundle localBundle = new Bundle();
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousc != null) && (c.c.b(paramAnonymousc.otC) != null) && ((c.c.b(paramAnonymousc.otC) instanceof duy)))
          {
            localBundle.putString("redirect_url", ((duy)c.c.b(paramAnonymousc.otC)).ZhF);
            ag.b.a(true, paramAnonymousString, localBundle, paramContext, paramc, parama);
            AppMethodBeat.o(298340);
            return;
          }
          ag.b.a(false, paramAnonymousString, localBundle, paramContext, paramc, parama);
          AppMethodBeat.o(298340);
        }
      });
      AppMethodBeat.o(298393);
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
      parama.gaS();
      if (!paramBoolean)
      {
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(298350);
            k.d(ag.b.this, paramString, MMApplicationContext.getContext().getString(c.i.wechat_auth_failed), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(298412);
                ag.b.9.this.WLl.goBack();
                AppMethodBeat.o(298412);
              }
            });
            AppMethodBeat.o(298350);
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
      paramc.bjr(paramString);
      Log.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirectUrl: %s", new Object[] { paramString });
      AppMethodBeat.o(78955);
    }
    
    public static void a(boolean paramBoolean, final String paramString, final Bundle paramBundle, Context paramContext, final e parame, final ag.c paramc, final ag.a parama, final int paramInt1, final int paramInt2, final Dialog paramDialog)
    {
      AppMethodBeat.i(298388);
      boolean bool1;
      final String str2;
      final String str3;
      final String str1;
      if ((paramContext instanceof MutableContextWrapper))
      {
        paramContext = ((MutableContextWrapper)paramContext).getBaseContext();
        bool1 = paramBundle.getBoolean("is_tourist_oauth");
        str2 = paramBundle.getString("tourist_banner_wording");
        str3 = paramBundle.getString("redirect_url");
        str1 = bkj(paramBundle.getString("oauth_url"));
        Log.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd suc: %b, isTouristOauth:%b, appID:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), str1 });
        if (paramBoolean) {
          break label176;
        }
        paramc.dismissLoadingDialog();
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(298337);
            if ((ag.b.this == null) || (!(ag.b.this instanceof Activity)) || (((Activity)ag.b.this).isFinishing()))
            {
              AppMethodBeat.o(298337);
              return;
            }
            k.d(ag.b.this, paramString, MMApplicationContext.getContext().getString(c.i.wechat_auth_failed), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(298358);
                ag.b.4.this.WLl.goBack();
                AppMethodBeat.o(298358);
              }
            });
            AppMethodBeat.o(298337);
          }
        });
        paramBundle = com.tencent.mm.plugin.webview.k.b.XsD;
        if (str1 != null) {
          break label170;
        }
      }
      label170:
      for (paramString = "";; paramString = str1)
      {
        paramBundle.a(paramString, startTime, 2, 1, 0, 0, paramInt2);
        com.tencent.mm.plugin.webview.k.b.XsD.bt(1, (int)(System.currentTimeMillis() - startTime), paramInt2);
        AppMethodBeat.o(298388);
        return;
        break;
      }
      label176:
      paramBoolean = paramBundle.getBoolean("is_recent_has_auth");
      boolean bool2 = paramBundle.getBoolean("is_silence_auth");
      if ((paramBoolean) || (bool2))
      {
        paramc.dismissLoadingDialog();
        if (Util.isNullOrNil(str3))
        {
          Log.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd redirect null");
          AppMethodBeat.o(298388);
          return;
        }
        Log.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd isRecentHasAuth:%b isSilenceAuth:%b redirectUrl:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), str3 });
        com.tencent.mm.model.gdpr.c.a(paramContext, a.oop, str1, new com.tencent.mm.model.gdpr.b()
        {
          public final void onPermissionReturn(final int paramAnonymousInt)
          {
            AppMethodBeat.i(298336);
            Log.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(298414);
                if (paramAnonymousInt == 1)
                {
                  ag.b.this.goBack();
                  localb = com.tencent.mm.plugin.webview.k.b.XsD;
                  if (ag.b.5.this.WLq == null) {}
                  for (str = "";; str = ag.b.5.this.WLq)
                  {
                    localb.a(str, ag.b.startTime, 0, 1, 0, 0, ag.b.5.this.val$errCode);
                    com.tencent.mm.plugin.webview.k.b.XsD.bt(1, (int)(System.currentTimeMillis() - ag.b.startTime), ag.b.5.this.val$errCode);
                    AppMethodBeat.o(298414);
                    return;
                  }
                }
                ag.b.this.bjr(ag.b.5.this.WLr);
                com.tencent.mm.plugin.webview.k.b localb = com.tencent.mm.plugin.webview.k.b.XsD;
                if (ag.b.5.this.WLq == null) {}
                for (String str = "";; str = ag.b.5.this.WLq)
                {
                  localb.a(str, ag.b.startTime, 1, 1, 0, 0, ag.b.5.this.val$errCode);
                  break;
                }
              }
            });
            AppMethodBeat.o(298336);
          }
        });
        AppMethodBeat.o(298388);
        return;
      }
      if ((paramc.isF()) && (bool1) && (!Util.isNullOrNil(str3)))
      {
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(298355);
            ag.b.this.nZ(str3, str2);
            AppMethodBeat.o(298355);
          }
        });
        AppMethodBeat.o(298388);
        return;
      }
      paramc.dismissLoadingDialog();
      paramBoolean = paramBundle.getBoolean("is_use_new_page", false);
      int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMY, 1);
      Log.i("MicroMsg.OauthAuthorizeLogic", "isUseNewPage = %b, open= %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      if ((paramBoolean) && (1 == i)) {
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(298346);
            ah.a(ag.b.this, paramBundle, paramInt1, paramc, paramDialog);
            AppMethodBeat.o(298346);
          }
        });
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.k.b.XsD.bt(1, (int)(System.currentTimeMillis() - startTime), paramInt2);
        AppMethodBeat.o(298388);
        return;
        paramString = new t.a()
        {
          public final void l(int paramAnonymousInt, final Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(298353);
            Log.i("MicroMsg.OauthAuthorizeLogic", "WebAuthorizeDialog#onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            switch (paramAnonymousInt)
            {
            default: 
              paramc.goBack();
              AppMethodBeat.o(298353);
              return;
            case 1: 
              com.tencent.mm.model.gdpr.c.a(ag.b.this, a.oop, str1, new com.tencent.mm.model.gdpr.b()
              {
                public final void onPermissionReturn(final int paramAnonymous2Int)
                {
                  AppMethodBeat.i(298348);
                  Log.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(298418);
                      if (paramAnonymous2Int == 1)
                      {
                        ag.b.8.this.WLl.goBack();
                        localb = com.tencent.mm.plugin.webview.k.b.XsD;
                        if (ag.b.8.this.WLq == null) {}
                        for (str = "";; str = ag.b.8.this.WLq)
                        {
                          localb.a(str, ag.b.startTime, 0, 1, 0, 1, ag.b.8.this.val$errCode);
                          com.tencent.mm.plugin.webview.k.b.XsD.bt(2, (int)(System.currentTimeMillis() - ag.b.WLf), ag.b.8.this.val$errCode);
                          AppMethodBeat.o(298418);
                          return;
                        }
                      }
                      com.tencent.mm.plugin.webview.k.b localb = com.tencent.mm.plugin.webview.k.b.XsD;
                      if (ag.b.8.this.WLq == null) {}
                      for (String str = "";; str = ag.b.8.this.WLq)
                      {
                        localb.a(str, ag.b.startTime, 1, 1, 0, 1, ag.b.8.this.val$errCode);
                        ag.b.a(ag.b.8.this.WLu, ag.b.8.1.this.WLv, ag.b.8.this.WLl, ag.b.8.this.WLi, ag.b.8.this.WLj, ag.b.this);
                        break;
                      }
                    }
                  });
                  AppMethodBeat.o(298348);
                }
              });
              AppMethodBeat.o(298353);
              return;
            }
            ag.b.b(paramBundle, paramAnonymousBundle, paramc, parame, parama, ag.b.this);
            com.tencent.mm.plugin.webview.k.b localb = com.tencent.mm.plugin.webview.k.b.XsD;
            if (str1 == null) {}
            for (paramAnonymousBundle = "";; paramAnonymousBundle = str1)
            {
              localb.a(paramAnonymousBundle, ag.b.startTime, 0, 1, 0, 1, paramInt2);
              com.tencent.mm.plugin.webview.k.b.XsD.bt(2, (int)(System.currentTimeMillis() - ag.b.WLf), paramInt2);
              AppMethodBeat.o(298353);
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
          parame = ag.bP((ArrayList)paramBundle.getSerializable("scope_list"));
          paramc = paramBundle.getString("appname");
          paramBundle = paramBundle.getString("appicon_url");
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(298349);
              new t(ag.b.this).a(parame, paramc, paramBundle, ag.b.this.getString(c.i.wechat_login_title), paramString);
              AppMethodBeat.o(298349);
            }
          });
        }
      }
    }
    
    public static boolean a(final String paramString1, String paramString2, int paramInt1, final e parame, final ag.c paramc, final ag.a parama, final int paramInt2, Context paramContext, int paramInt3, final Dialog paramDialog)
    {
      AppMethodBeat.i(298383);
      if (parame == null)
      {
        Log.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize invoker null");
        AppMethodBeat.o(298383);
        return false;
      }
      startTime = System.currentTimeMillis();
      com.tencent.mm.plugin.webview.k.b.XsD.dQ(1, "");
      Log.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize scene: %d, autoOauth: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
      paramc.d(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(78944);
          Log.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize user cancel");
          ag.b.this.dismissLoadingDialog();
          AppMethodBeat.o(78944);
        }
      });
      duz localduz = new duz();
      localduz.abaO = paramString1;
      localduz.ADE = paramString2;
      localduz.scene = paramInt1;
      localduz.abaR = paramInt3;
      paramString2 = new com.tencent.mm.am.c.a();
      paramString2.otE = localduz;
      paramString2.otF = new dva();
      paramString2.uri = "/cgi-bin/mmbiz-bin/oauth_authorize";
      paramString2.funcId = 1254;
      paramString2.otG = 0;
      paramString2.respCmdId = 0;
      paramContext = new WeakReference(paramContext);
      IPCRunCgi.a(paramString2.bEF(), new IPCRunCgi.a()
      {
        public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc)
        {
          AppMethodBeat.i(298335);
          Context localContext = (Context)ag.b.this.get();
          Log.i("MicroMsg.OauthAuthorizeLogic", "onSceneEnd doOauthAuthorize errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((localContext == null) || (parame == null) || (paramc == null) || (parama == null))
          {
            AppMethodBeat.o(298335);
            return;
          }
          Bundle localBundle = new Bundle();
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousc != null) && (c.c.b(paramAnonymousc.otC) != null) && ((c.c.b(paramAnonymousc.otC) instanceof dva)))
          {
            paramAnonymousc = (dva)c.c.b(paramAnonymousc.otC);
            localBundle.putString("oauth_url", paramString1);
            localBundle.putSerializable("scope_list", ag.cj(paramAnonymousc.abaS));
            localBundle.putString("appname", paramAnonymousc.nSt);
            localBundle.putString("appicon_url", paramAnonymousc.abaT);
            localBundle.putString("redirect_url", paramAnonymousc.ZhF);
            localBundle.putBoolean("is_recent_has_auth", paramAnonymousc.abaU);
            localBundle.putBoolean("is_silence_auth", paramAnonymousc.abaV);
            localBundle.putBoolean("is_call_server_when_confirm", paramAnonymousc.abaW);
            localBundle.putSerializable("avatar_list", ah.ck(paramAnonymousc.abaX));
            localBundle.putBoolean("is_use_new_page", paramAnonymousc.abaY);
            localBundle.putBoolean("is_ban_modify_avatar", paramAnonymousc.rGY);
            if (paramAnonymousc.abba != null) {
              localBundle.putString("create_avatar_title", paramAnonymousc.abba.abbe);
            }
            localBundle.putInt("avatar_limit", paramAnonymousc.rGZ);
            localBundle.putInt("default_avatar_id", paramAnonymousc.rHa);
            localBundle.putString("default_headimg_url", paramAnonymousc.rHb);
            localBundle.putString("default_headimg_fileid", paramAnonymousc.rHc);
            localBundle.putBoolean("is_tourist_oauth", paramAnonymousc.abaZ);
            localBundle.putString("tourist_banner_wording", paramAnonymousc.abba.abbf);
            ag.b.a(true, paramAnonymousString, localBundle, localContext, parame, paramc, parama, paramInt2, paramAnonymousInt2, paramDialog);
            AppMethodBeat.o(298335);
            return;
          }
          ag.b.a(false, paramAnonymousString, localBundle, localContext, parame, paramc, parama, paramInt2, paramAnonymousInt2, paramDialog);
          AppMethodBeat.o(298335);
        }
      });
      AppMethodBeat.o(298383);
      return true;
    }
    
    public static String bkj(String paramString)
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
    
    public static boolean hZ(String paramString, int paramInt)
    {
      AppMethodBeat.i(298378);
      if (6 == paramInt)
      {
        Log.i("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept from oauth");
        AppMethodBeat.o(298378);
        return false;
      }
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(298378);
        return false;
      }
      if (WLg != -1) {
        if (WLg == 1)
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label326;
          }
          if ((ag.ivi() == null) && (!ag.WLe))
          {
            String str2 = ag.ivh();
            String str1 = str2;
            if (Util.isNullOrNil(str2)) {
              str1 = WeChatHosts.domainString(c.i.host_open_weixin_qq_com) + "/connect/oauth2/authorize";
            }
            ag.access$302(str1.split(";"));
            ag.ivj();
          }
          if ((ag.ivi() != null) && (ag.ivi().length != 0)) {
            break label228;
          }
          Log.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost sOauthHostPaths nil");
        }
      }
      label324:
      for (;;)
      {
        paramInt = 0;
        if (paramInt == 0) {
          break label326;
        }
        AppMethodBeat.o(298378);
        return true;
        paramInt = 0;
        break;
        WLg = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yMW, 1);
        Log.i("MicroMsg.OauthAuthorizeLogic", "isABTestOpen %d", new Object[] { Integer.valueOf(WLg) });
        if (WLg == 1)
        {
          paramInt = 1;
          break;
        }
        paramInt = 0;
        break;
        label228:
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
            if (paramInt >= ag.ivi().length) {
              break label324;
            }
            if (paramString.equalsIgnoreCase(ag.ivi()[paramInt]))
            {
              paramInt = 1;
              break;
            }
            paramInt += 1;
          }
        }
      }
      label326:
      AppMethodBeat.o(298378);
      return false;
    }
  }
  
  public static abstract interface c
  {
    public abstract void bjr(String paramString);
    
    public abstract void d(DialogInterface.OnCancelListener paramOnCancelListener);
    
    public abstract void dismissLoadingDialog();
    
    public abstract void goBack();
    
    public abstract boolean isF();
    
    public abstract void nZ(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ag
 * JD-Core Version:    0.7.0.1
 */