package com.tencent.mm.plugin.webview.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.model.gdpr.a;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.widget.p.a;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.ddd;
import com.tencent.mm.protocal.protobuf.dde;
import com.tencent.mm.protocal.protobuf.ddf;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.protocal.protobuf.eax;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ag
{
  private static String[] PUr;
  private static boolean PUs = false;
  
  private static ArrayList<byte[]> bX(LinkedList<ddj> paramLinkedList)
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
        localArrayList.add(((ddj)paramLinkedList.get(i)).toByteArray());
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
  
  public static LinkedList<eax> bo(ArrayList<byte[]> paramArrayList)
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
        ddj localddj = new ddj();
        localddj.parseFrom((byte[])paramArrayList.get(i));
        eax localeax = new eax();
        localeax.UfR = localddj.TLg;
        localeax.CMB = localddj.desc;
        localeax.RXY = localddj.scope;
        localeax.qDz = localddj.qDz;
        localLinkedList.add(localeax);
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
  
  public static String gVw()
  {
    AppMethodBeat.i(218596);
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vzr, "");
    Log.i("MicroMsg.OauthAuthorizeLogic", "getOauthHostPaths %s", new Object[] { str });
    AppMethodBeat.o(218596);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void eRX();
  }
  
  public static final class b
  {
    public static long PUt = 0L;
    public static long startTime = 0L;
    
    private static void a(e parame, String paramString, int paramInt, ArrayList<String> paramArrayList, ag.a parama, boolean paramBoolean, ag.c paramc, Context paramContext)
    {
      AppMethodBeat.i(267781);
      if (parame == null)
      {
        Log.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm invoker null");
        AppMethodBeat.o(267781);
        return;
      }
      PUt = System.currentTimeMillis();
      ddc localddc = new ddc();
      localddc.TKV = paramString;
      localddc.TKW = paramInt;
      localddc.TKX = new LinkedList(paramArrayList);
      paramString = new d.a();
      paramString.lBU = localddc;
      paramString.lBV = new ddd();
      paramString.uri = "/cgi-bin/mmbiz-bin/oauth_authorize_confirm";
      paramString.funcId = 1373;
      paramString.lBW = 0;
      paramString.respCmdId = 0;
      IPCRunCgi.a(paramString.bgN(), new ag.b.9(parame, parama, paramBoolean, paramContext, paramc));
      AppMethodBeat.o(267781);
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
      parama.eRX();
      if (!paramBoolean)
      {
        com.tencent.e.h.ZvG.bc(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(221977);
            com.tencent.mm.ui.base.h.d(this.val$context, paramString, MMApplicationContext.getContext().getString(c.i.wechat_auth_failed), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(265122);
                ag.b.7.this.PUA.goBack();
                AppMethodBeat.o(265122);
              }
            });
            AppMethodBeat.o(221977);
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
      paramc.bjG(paramString);
      Log.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirectUrl: %s", new Object[] { paramString });
      AppMethodBeat.o(78955);
    }
    
    public static void a(boolean paramBoolean, final String paramString, final Bundle paramBundle, Context paramContext, final e parame, final ag.c paramc, final ag.a parama, final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(78954);
      Log.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd suc: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      final String str;
      if ((paramContext instanceof MutableContextWrapper))
      {
        paramContext = ((MutableContextWrapper)paramContext).getBaseContext();
        paramc.cVG();
        str = bky(paramBundle.getString("oauth_url"));
        Log.i("MicroMsg.OauthAuthorizeLogic", "parse appID:%s", new Object[] { str });
        if (paramBoolean) {
          break label154;
        }
        com.tencent.e.h.ZvG.bc(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(226822);
            if ((this.val$context == null) || (!(this.val$context instanceof Activity)) || (((Activity)this.val$context).isFinishing()))
            {
              AppMethodBeat.o(226822);
              return;
            }
            com.tencent.mm.ui.base.h.d(this.val$context, paramString, MMApplicationContext.getContext().getString(c.i.wechat_auth_failed), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(263108);
                ag.b.3.this.PUA.goBack();
                AppMethodBeat.o(263108);
              }
            });
            AppMethodBeat.o(226822);
          }
        });
        paramBundle = com.tencent.mm.plugin.webview.k.b.QzJ;
        if (str != null) {
          break label148;
        }
      }
      label148:
      for (paramString = "";; paramString = str)
      {
        paramBundle.a(paramString, startTime, 2, 1, 0, 0, paramInt2);
        com.tencent.mm.plugin.webview.k.b.QzJ.aS(1, (int)(System.currentTimeMillis() - startTime), paramInt2);
        AppMethodBeat.o(78954);
        return;
        break;
      }
      label154:
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
        c.a(paramContext, a.lwQ, str, new com.tencent.mm.model.gdpr.b()
        {
          public final void vu(final int paramAnonymousInt)
          {
            AppMethodBeat.i(215970);
            Log.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(222609);
                if (paramAnonymousInt == 1)
                {
                  ag.b.4.this.PUA.goBack();
                  localb = com.tencent.mm.plugin.webview.k.b.QzJ;
                  if (ag.b.4.this.PUC == null) {}
                  for (str = "";; str = ag.b.4.this.PUC)
                  {
                    localb.a(str, ag.b.startTime, 0, 1, 0, 0, ag.b.4.this.val$errCode);
                    com.tencent.mm.plugin.webview.k.b.QzJ.aS(1, (int)(System.currentTimeMillis() - ag.b.startTime), ag.b.4.this.val$errCode);
                    AppMethodBeat.o(222609);
                    return;
                  }
                }
                ag.b.4.this.PUA.bjG(ag.b.4.this.PUD);
                com.tencent.mm.plugin.webview.k.b localb = com.tencent.mm.plugin.webview.k.b.QzJ;
                if (ag.b.4.this.PUC == null) {}
                for (String str = "";; str = ag.b.4.this.PUC)
                {
                  localb.a(str, ag.b.startTime, 1, 1, 0, 0, ag.b.4.this.val$errCode);
                  break;
                }
              }
            });
            AppMethodBeat.o(215970);
          }
        });
        AppMethodBeat.o(78954);
        return;
      }
      paramBoolean = paramBundle.getBoolean("is_use_new_page", false);
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vzt, 1);
      Log.i("MicroMsg.OauthAuthorizeLogic", "isUseNewPage = %b, open= %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      if ((paramBoolean) && (1 == i)) {
        com.tencent.e.h.ZvG.bc(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(249532);
            ah.a(this.val$context, paramBundle, paramInt1, paramc);
            AppMethodBeat.o(249532);
          }
        });
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.k.b.QzJ.aS(1, (int)(System.currentTimeMillis() - startTime), paramInt2);
        AppMethodBeat.o(78954);
        return;
        paramString = new p.a()
        {
          public final void k(int paramAnonymousInt, final Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(229966);
            Log.i("MicroMsg.OauthAuthorizeLogic", "WebAuthorizeDialog#onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            switch (paramAnonymousInt)
            {
            default: 
              paramc.goBack();
              AppMethodBeat.o(229966);
              return;
            case 1: 
              c.a(this.val$context, a.lwQ, str, new com.tencent.mm.model.gdpr.b()
              {
                public final void vu(final int paramAnonymous2Int)
                {
                  AppMethodBeat.i(252333);
                  Log.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(219733);
                      if (paramAnonymous2Int == 1)
                      {
                        ag.b.6.this.PUA.goBack();
                        localb = com.tencent.mm.plugin.webview.k.b.QzJ;
                        if (ag.b.6.this.PUC == null) {}
                        for (str = "";; str = ag.b.6.this.PUC)
                        {
                          localb.a(str, ag.b.startTime, 0, 1, 0, 1, ag.b.6.this.val$errCode);
                          com.tencent.mm.plugin.webview.k.b.QzJ.aS(2, (int)(System.currentTimeMillis() - ag.b.PUt), ag.b.6.this.val$errCode);
                          AppMethodBeat.o(219733);
                          return;
                        }
                      }
                      com.tencent.mm.plugin.webview.k.b localb = com.tencent.mm.plugin.webview.k.b.QzJ;
                      if (ag.b.6.this.PUC == null) {}
                      for (String str = "";; str = ag.b.6.this.PUC)
                      {
                        localb.a(str, ag.b.startTime, 1, 1, 0, 1, ag.b.6.this.val$errCode);
                        ag.b.a(ag.b.6.this.PUF, ag.b.6.1.this.PUG, ag.b.6.this.PUA, ag.b.6.this.PUw, ag.b.6.this.PUx, ag.b.6.this.val$context);
                        break;
                      }
                    }
                  });
                  AppMethodBeat.o(252333);
                }
              });
              AppMethodBeat.o(229966);
              return;
            }
            ag.b.b(paramBundle, paramAnonymousBundle, paramc, parame, parama, this.val$context);
            com.tencent.mm.plugin.webview.k.b localb = com.tencent.mm.plugin.webview.k.b.QzJ;
            if (str == null) {}
            for (paramAnonymousBundle = "";; paramAnonymousBundle = str)
            {
              localb.a(paramAnonymousBundle, ag.b.startTime, 0, 1, 0, 1, paramInt2);
              com.tencent.mm.plugin.webview.k.b.QzJ.aS(2, (int)(System.currentTimeMillis() - ag.b.PUt), paramInt2);
              AppMethodBeat.o(229966);
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
          parame = ag.bo((ArrayList)paramBundle.getSerializable("scope_list"));
          paramc = paramBundle.getString("appname");
          paramBundle = paramBundle.getString("appicon_url");
          com.tencent.e.h.ZvG.bc(new ag.b.8(paramContext, parame, paramc, paramBundle, paramString));
        }
      }
    }
    
    public static boolean a(String paramString1, String paramString2, int paramInt1, e parame, ag.c paramc, ag.a parama, int paramInt2, Context paramContext)
    {
      AppMethodBeat.i(267778);
      if (parame == null)
      {
        Log.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize invoker null");
        AppMethodBeat.o(267778);
        return false;
      }
      startTime = System.currentTimeMillis();
      com.tencent.mm.plugin.webview.k.b.QzJ.da(1, "");
      Log.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize scene: %d", new Object[] { Integer.valueOf(paramInt1) });
      paramc.e(new ag.b.1(paramc));
      dde localdde = new dde();
      localdde.TKV = paramString1;
      localdde.RVH = paramString2;
      localdde.scene = paramInt1;
      paramString2 = new d.a();
      paramString2.lBU = localdde;
      paramString2.lBV = new ddf();
      paramString2.uri = "/cgi-bin/mmbiz-bin/oauth_authorize";
      paramString2.funcId = 1254;
      paramString2.lBW = 0;
      paramString2.respCmdId = 0;
      paramContext = new WeakReference(paramContext);
      IPCRunCgi.a(paramString2.bgN(), new ag.b.2(paramContext, parame, paramc, parama, paramString1, paramInt2));
      AppMethodBeat.o(267778);
      return true;
    }
    
    public static String bky(String paramString)
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
    
    public static boolean gZ(String paramString, int paramInt)
    {
      AppMethodBeat.i(267777);
      if (6 == paramInt)
      {
        Log.i("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept from oauth");
        AppMethodBeat.o(267777);
        return false;
      }
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(267777);
        return false;
      }
      paramInt = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vzr, 1);
      Log.i("MicroMsg.OauthAuthorizeLogic", "isABTestOpen %d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1)
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label296;
        }
        if ((ag.gVx() == null) && (!ag.PUs))
        {
          String str2 = ag.gVw();
          String str1 = str2;
          if (Util.isNullOrNil(str2)) {
            str1 = WeChatHosts.domainString(c.i.host_open_weixin_qq_com) + "/connect/oauth2/authorize";
          }
          ag.access$302(str1.split(";"));
          ag.gVy();
        }
        if ((ag.gVx() != null) && (ag.gVx().length != 0)) {
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
        AppMethodBeat.o(267777);
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
            if (paramInt >= ag.gVx().length) {
              break label294;
            }
            if (paramString.equalsIgnoreCase(ag.gVx()[paramInt]))
            {
              paramInt = 1;
              break;
            }
            paramInt += 1;
          }
        }
      }
      label296:
      AppMethodBeat.o(267777);
      return false;
    }
  }
  
  public static abstract interface c
  {
    public abstract void bjG(String paramString);
    
    public abstract void cVG();
    
    public abstract void e(DialogInterface.OnCancelListener paramOnCancelListener);
    
    public abstract void goBack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ag
 * JD-Core Version:    0.7.0.1
 */