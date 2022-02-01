package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.gdpr.a;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.widget.r;
import com.tencent.mm.plugin.webview.ui.tools.widget.r.a;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.btt;
import com.tencent.mm.protocal.protobuf.btu;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.protocal.protobuf.cmy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ag
{
  private static String[] AXr;
  private static boolean AXs = false;
  
  private static ArrayList<byte[]> aW(LinkedList<bty> paramLinkedList)
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
        localArrayList.add(((bty)paramLinkedList.get(i)).toByteArray());
        i += 1;
      }
      catch (IOException paramLinkedList)
      {
        ad.w("MicroMsg.OauthAuthorizeLogic", "oauthScopeInfoListToBytesList index:%d, exp:%s ", new Object[] { Integer.valueOf(i), paramLinkedList.getLocalizedMessage() });
        localArrayList.clear();
        AppMethodBeat.o(78962);
        return localArrayList;
      }
    }
    AppMethodBeat.o(78962);
    return localArrayList;
  }
  
  public static LinkedList<cmy> ax(ArrayList<byte[]> paramArrayList)
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
        bty localbty = new bty();
        localbty.parseFrom((byte[])paramArrayList.get(i));
        cmy localcmy = new cmy();
        localcmy.EhH = localbty.DRs;
        localcmy.Desc = localbty.desc;
        localcmy.CLe = localbty.scope;
        localcmy.lmb = localbty.lmb;
        localLinkedList.add(localcmy);
        i += 1;
      }
      catch (IOException paramArrayList)
      {
        ad.w("MicroMsg.OauthAuthorizeLogic", "bytesListToBytesListScopeInfoList: i:%d, exp:%s", new Object[] { Integer.valueOf(i), paramArrayList.getLocalizedMessage() });
        localLinkedList.clear();
        AppMethodBeat.o(78963);
        return localLinkedList;
      }
    }
    AppMethodBeat.o(78963);
    return localLinkedList;
  }
  
  public static String elO()
  {
    AppMethodBeat.i(187910);
    String str = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pmr, "");
    ad.i("MicroMsg.OauthAuthorizeLogic", "getOauthHostPaths %s", new Object[] { str });
    AppMethodBeat.o(187910);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void vX();
  }
  
  public static final class b
  {
    public static long AXt = 0L;
    public static long startTime = 0L;
    
    private static void a(e parame, String paramString, int paramInt, ArrayList<String> paramArrayList, final ag.a parama, final boolean paramBoolean, final ag.c paramc, final Context paramContext)
    {
      AppMethodBeat.i(187907);
      if (parame == null)
      {
        ad.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm invoker null");
        AppMethodBeat.o(187907);
        return;
      }
      AXt = System.currentTimeMillis();
      btr localbtr = new btr();
      localbtr.DRh = paramString;
      localbtr.DRi = paramInt;
      localbtr.DRj = new LinkedList(paramArrayList);
      paramString = new com.tencent.mm.al.b.a();
      paramString.gUU = localbtr;
      paramString.gUV = new bts();
      paramString.uri = "/cgi-bin/mmbiz-bin/oauth_authorize_confirm";
      paramString.funcId = 1373;
      paramString.reqCmdId = 0;
      paramString.respCmdId = 0;
      IPCRunCgi.a(paramString.atI(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
        {
          AppMethodBeat.i(187904);
          ad.i("MicroMsg.OauthAuthorizeLogic", "onSceneEnd doOauthAuthorizeConfirm errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((this.AXv == null) || (parama == null) || (!paramBoolean))
          {
            AppMethodBeat.o(187904);
            return;
          }
          Bundle localBundle = new Bundle();
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.gUT.gUX != null) && ((paramAnonymousb.gUT.gUX instanceof bts)))
          {
            localBundle.putString("redirect_url", ((bts)paramAnonymousb.gUT.gUX).CzB);
            ag.b.a(true, paramAnonymousString, localBundle, paramContext, paramc, parama);
            AppMethodBeat.o(187904);
            return;
          }
          ag.b.a(false, paramAnonymousString, localBundle, paramContext, paramc, parama);
          AppMethodBeat.o(187904);
        }
      });
      AppMethodBeat.o(187907);
    }
    
    public static void a(boolean paramBoolean, String paramString, Bundle paramBundle, Context paramContext, ag.c paramc, ag.a parama)
    {
      AppMethodBeat.i(78955);
      ad.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd suc: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      if ((paramContext == null) || (((WebViewUI)paramContext).isFinishing()))
      {
        AppMethodBeat.o(78955);
        return;
      }
      parama.vX();
      if (!paramBoolean)
      {
        com.tencent.mm.ui.base.h.d(paramContext, paramString, aj.getContext().getString(2131766178), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(187902);
            this.AXz.goBack();
            AppMethodBeat.o(187902);
          }
        });
        AppMethodBeat.o(78955);
        return;
      }
      paramString = paramBundle.getString("redirect_url");
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirect null");
        AppMethodBeat.o(78955);
        return;
      }
      paramc.avE(paramString);
      ad.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirectUrl: %s", new Object[] { paramString });
      AppMethodBeat.o(78955);
    }
    
    public static void a(boolean paramBoolean, final String paramString, final Bundle paramBundle, Context paramContext, final e parame, final ag.c paramc, final ag.a parama, final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(78954);
      ad.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd suc: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      paramc.bVS();
      final String str = aws(paramBundle.getString("oauth_url"));
      ad.i("MicroMsg.OauthAuthorizeLogic", "parse appID:%s", new Object[] { str });
      if (!paramBoolean)
      {
        com.tencent.mm.ui.base.h.d(paramContext, paramString, aj.getContext().getString(2131766178), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(187895);
            this.AXz.goBack();
            AppMethodBeat.o(187895);
          }
        });
        paramBundle = com.tencent.mm.plugin.webview.j.b.BwR;
        if (str == null) {}
        for (paramString = "";; paramString = str)
        {
          paramBundle.a(paramString, startTime, 2, 1, 0, 0, paramInt2);
          com.tencent.mm.plugin.webview.j.b.BwR.aC(1, (int)(System.currentTimeMillis() - startTime), paramInt2);
          AppMethodBeat.o(78954);
          return;
        }
      }
      paramBoolean = paramBundle.getBoolean("is_recent_has_auth");
      boolean bool = paramBundle.getBoolean("is_silence_auth");
      if ((paramBoolean) || (bool))
      {
        paramString = paramBundle.getString("redirect_url");
        if (bt.isNullOrNil(paramString))
        {
          ad.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd redirect null");
          AppMethodBeat.o(78954);
          return;
        }
        ad.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd isRecentHasAuth:%b isSilenceAuth:%b redirectUrl:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), paramString });
        c.a(paramContext, a.gQb, str, new com.tencent.mm.model.gdpr.b()
        {
          public final void ns(final int paramAnonymousInt)
          {
            AppMethodBeat.i(187897);
            ad.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(187896);
                if (paramAnonymousInt == 1)
                {
                  ag.b.4.this.AXz.goBack();
                  localb = com.tencent.mm.plugin.webview.j.b.BwR;
                  if (ag.b.4.this.AXA == null) {}
                  for (str = "";; str = ag.b.4.this.AXA)
                  {
                    localb.a(str, ag.b.startTime, 0, 1, 0, 0, ag.b.4.this.val$errCode);
                    com.tencent.mm.plugin.webview.j.b.BwR.aC(1, (int)(System.currentTimeMillis() - ag.b.startTime), ag.b.4.this.val$errCode);
                    AppMethodBeat.o(187896);
                    return;
                  }
                }
                ag.b.4.this.AXz.avE(ag.b.4.this.AXB);
                com.tencent.mm.plugin.webview.j.b localb = com.tencent.mm.plugin.webview.j.b.BwR;
                if (ag.b.4.this.AXA == null) {}
                for (String str = "";; str = ag.b.4.this.AXA)
                {
                  localb.a(str, ag.b.startTime, 1, 1, 0, 0, ag.b.4.this.val$errCode);
                  break;
                }
              }
            });
            AppMethodBeat.o(187897);
          }
        });
        AppMethodBeat.o(78954);
        return;
      }
      paramBoolean = paramBundle.getBoolean("is_use_new_page", false);
      int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pmt, 1);
      ad.i("MicroMsg.OauthAuthorizeLogic", "isUseNewPage = %b, open= %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      if ((paramBoolean) && (1 == i)) {
        com.tencent.e.h.Iye.aN(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187898);
            ah.a(this.val$context, paramBundle, paramInt1, paramc);
            AppMethodBeat.o(187898);
          }
        });
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.j.b.BwR.aC(1, (int)(System.currentTimeMillis() - startTime), paramInt2);
        AppMethodBeat.o(78954);
        return;
        paramString = new r.a()
        {
          public final void i(int paramAnonymousInt, final Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(187901);
            ad.i("MicroMsg.OauthAuthorizeLogic", "WebAuthorizeDialog#onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            switch (paramAnonymousInt)
            {
            default: 
              paramc.goBack();
              AppMethodBeat.o(187901);
              return;
            case 1: 
              c.a(this.val$context, a.gQb, str, new com.tencent.mm.model.gdpr.b()
              {
                public final void ns(final int paramAnonymous2Int)
                {
                  AppMethodBeat.i(187900);
                  ad.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  aq.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(187899);
                      if (paramAnonymous2Int == 1)
                      {
                        ag.b.6.this.AXz.goBack();
                        localb = com.tencent.mm.plugin.webview.j.b.BwR;
                        if (ag.b.6.this.AXA == null) {}
                        for (str = "";; str = ag.b.6.this.AXA)
                        {
                          localb.a(str, ag.b.startTime, 0, 1, 0, 1, ag.b.6.this.val$errCode);
                          com.tencent.mm.plugin.webview.j.b.BwR.aC(2, (int)(System.currentTimeMillis() - ag.b.AXt), ag.b.6.this.val$errCode);
                          AppMethodBeat.o(187899);
                          return;
                        }
                      }
                      com.tencent.mm.plugin.webview.j.b localb = com.tencent.mm.plugin.webview.j.b.BwR;
                      if (ag.b.6.this.AXA == null) {}
                      for (String str = "";; str = ag.b.6.this.AXA)
                      {
                        localb.a(str, ag.b.startTime, 1, 1, 0, 1, ag.b.6.this.val$errCode);
                        ag.b.a(ag.b.6.this.AXD, ag.b.6.1.this.kfA, ag.b.6.this.AXz, ag.b.6.this.AXv, ag.b.6.this.AXw, ag.b.6.this.val$context);
                        break;
                      }
                    }
                  });
                  AppMethodBeat.o(187900);
                }
              });
              AppMethodBeat.o(187901);
              return;
            }
            ag.b.b(paramBundle, paramAnonymousBundle, paramc, parame, parama, this.val$context);
            com.tencent.mm.plugin.webview.j.b localb = com.tencent.mm.plugin.webview.j.b.BwR;
            if (str == null) {}
            for (paramAnonymousBundle = "";; paramAnonymousBundle = str)
            {
              localb.a(paramAnonymousBundle, ag.b.startTime, 0, 1, 0, 1, paramInt2);
              com.tencent.mm.plugin.webview.j.b.BwR.aC(2, (int)(System.currentTimeMillis() - ag.b.AXt), paramInt2);
              AppMethodBeat.o(187901);
              return;
            }
          }
        };
        if (((paramContext instanceof WebViewUI)) && (((WebViewUI)paramContext).isFinishing()))
        {
          ad.i("MicroMsg.OauthAuthorizeLogic", "showWebAuthorizeDialog isFinishing");
        }
        else
        {
          parame = ag.ax((ArrayList)paramBundle.getSerializable("scope_list"));
          paramc = paramBundle.getString("appname");
          paramBundle = paramBundle.getString("appicon_url");
          com.tencent.e.h.Iye.aN(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187903);
              new r(this.val$context).a(parame, paramc, paramBundle, this.val$context.getString(2131766191), paramString);
              AppMethodBeat.o(187903);
            }
          });
        }
      }
    }
    
    public static boolean a(final String paramString1, String paramString2, int paramInt1, final e parame, final ag.c paramc, final ag.a parama, final int paramInt2, Context paramContext)
    {
      AppMethodBeat.i(187906);
      if (parame == null)
      {
        ad.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize invoker null");
        AppMethodBeat.o(187906);
        return false;
      }
      startTime = System.currentTimeMillis();
      com.tencent.mm.plugin.webview.j.b.BwR.cy(1, "");
      ad.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize scene: %d", new Object[] { Integer.valueOf(paramInt1) });
      paramc.d(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(78944);
          ad.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize user cancel");
          this.AXu.bVS();
          AppMethodBeat.o(78944);
        }
      });
      btt localbtt = new btt();
      localbtt.DRh = paramString1;
      localbtt.CJL = paramString2;
      localbtt.scene = paramInt1;
      paramString2 = new com.tencent.mm.al.b.a();
      paramString2.gUU = localbtt;
      paramString2.gUV = new btu();
      paramString2.uri = "/cgi-bin/mmbiz-bin/oauth_authorize";
      paramString2.funcId = 1254;
      paramString2.reqCmdId = 0;
      paramString2.respCmdId = 0;
      IPCRunCgi.a(paramString2.atI(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
        {
          AppMethodBeat.i(187894);
          ad.i("MicroMsg.OauthAuthorizeLogic", "onSceneEnd doOauthAuthorize errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((this.val$context == null) || (parame == null) || (paramc == null) || (parama == null))
          {
            AppMethodBeat.o(187894);
            return;
          }
          Bundle localBundle = new Bundle();
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.gUT.gUX != null) && ((paramAnonymousb.gUT.gUX instanceof btu)))
          {
            paramAnonymousb = (btu)paramAnonymousb.gUT.gUX;
            localBundle.putString("oauth_url", paramString1);
            localBundle.putSerializable("scope_list", ag.aX(paramAnonymousb.DRk));
            localBundle.putString("appname", paramAnonymousb.gIw);
            localBundle.putString("appicon_url", paramAnonymousb.DRl);
            localBundle.putString("redirect_url", paramAnonymousb.CzB);
            localBundle.putBoolean("is_recent_has_auth", paramAnonymousb.DRm);
            localBundle.putBoolean("is_silence_auth", paramAnonymousb.DRn);
            localBundle.putBoolean("is_call_server_when_confirm", paramAnonymousb.DRo);
            localBundle.putSerializable("avatar_list", ah.aY(paramAnonymousb.DRp));
            localBundle.putBoolean("is_use_new_page", paramAnonymousb.DRq);
            localBundle.putBoolean("is_ban_modify_avatar", paramAnonymousb.jEE);
            localBundle.putInt("avatar_limit", paramAnonymousb.jEF);
            localBundle.putInt("default_avatar_id", paramAnonymousb.jEG);
            localBundle.putString("default_headimg_url", paramAnonymousb.jEH);
            localBundle.putString("default_headimg_fileid", paramAnonymousb.jEI);
            ag.b.a(true, paramAnonymousString, localBundle, this.val$context, parame, paramc, parama, paramInt2, paramAnonymousInt2);
            AppMethodBeat.o(187894);
            return;
          }
          ag.b.a(false, paramAnonymousString, localBundle, this.val$context, parame, paramc, parama, paramInt2, paramAnonymousInt2);
          AppMethodBeat.o(187894);
        }
      });
      AppMethodBeat.o(187906);
      return true;
    }
    
    public static String aws(String paramString)
    {
      localObject1 = null;
      AppMethodBeat.i(78959);
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(78959);
        return null;
      }
      try
      {
        String str = Uri.parse(paramString).getQueryParameter("appid");
        localObject2 = str;
        localObject1 = str;
        if (bt.isNullOrNil(str))
        {
          localObject1 = str;
          ad.i("MicroMsg.OauthAuthorizeLogic", "parseAppId try case not sensitive, oauthUrl:%s", new Object[] { paramString });
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
    
    public static boolean fe(String paramString, int paramInt)
    {
      AppMethodBeat.i(187905);
      if (6 == paramInt)
      {
        ad.i("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept from oauth");
        AppMethodBeat.o(187905);
        return false;
      }
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(187905);
        return false;
      }
      paramInt = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pmr, 1);
      ad.i("MicroMsg.OauthAuthorizeLogic", "isABTestOpen %d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1)
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label274;
        }
        if ((ag.elP() == null) && (!ag.AXs))
        {
          String str2 = ag.elO();
          String str1 = str2;
          if (bt.isNullOrNil(str2)) {
            str1 = "open.weixin.qq.com/connect/oauth2/authorize";
          }
          ag.access$302(str1.split(";"));
          ag.elQ();
        }
        if ((ag.elP() != null) && (ag.elP().length != 0)) {
          break label176;
        }
        ad.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost sOauthHostPaths nil");
      }
      label272:
      for (;;)
      {
        paramInt = 0;
        if (paramInt == 0) {
          break label274;
        }
        AppMethodBeat.o(187905);
        return true;
        paramInt = 0;
        break;
        label176:
        paramString = Uri.parse(paramString);
        paramString = paramString.getAuthority() + paramString.getPath();
        if (bt.isNullOrNil(paramString))
        {
          ad.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost target nil");
        }
        else
        {
          ad.d("MicroMsg.OauthAuthorizeLogic", "isOauthHost target:%s", new Object[] { paramString });
          paramInt = 0;
          for (;;)
          {
            if (paramInt >= ag.elP().length) {
              break label272;
            }
            if (paramString.equalsIgnoreCase(ag.elP()[paramInt]))
            {
              paramInt = 1;
              break;
            }
            paramInt += 1;
          }
        }
      }
      label274:
      AppMethodBeat.o(187905);
      return false;
    }
  }
  
  public static abstract interface c
  {
    public abstract void avE(String paramString);
    
    public abstract void bVS();
    
    public abstract void d(DialogInterface.OnCancelListener paramOnCancelListener);
    
    public abstract void goBack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ag
 * JD-Core Version:    0.7.0.1
 */