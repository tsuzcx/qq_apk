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
import com.tencent.mm.protocal.protobuf.ccz;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cdb;
import com.tencent.mm.protocal.protobuf.cdc;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.cxm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ag
{
  private static String[] DTc;
  private static boolean DTd = false;
  
  public static LinkedList<cxm> aG(ArrayList<byte[]> paramArrayList)
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
        cdg localcdg = new cdg();
        localcdg.parseFrom((byte[])paramArrayList.get(i));
        cxm localcxm = new cxm();
        localcxm.HoV = localcdg.GXt;
        localcxm.Desc = localcdg.desc;
        localcxm.FKf = localcdg.scope;
        localcxm.mlF = localcdg.mlF;
        localLinkedList.add(localcxm);
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
  
  private static ArrayList<byte[]> be(LinkedList<cdg> paramLinkedList)
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
        localArrayList.add(((cdg)paramLinkedList.get(i)).toByteArray());
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
  
  public static String eQc()
  {
    AppMethodBeat.i(207956);
    String str = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qtQ, "");
    ad.i("MicroMsg.OauthAuthorizeLogic", "getOauthHostPaths %s", new Object[] { str });
    AppMethodBeat.o(207956);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void xj();
  }
  
  public static final class b
  {
    public static long DTe = 0L;
    public static long startTime = 0L;
    
    private static void a(e parame, String paramString, int paramInt, ArrayList<String> paramArrayList, final ag.a parama, final boolean paramBoolean, final ag.c paramc, final Context paramContext)
    {
      AppMethodBeat.i(207953);
      if (parame == null)
      {
        ad.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm invoker null");
        AppMethodBeat.o(207953);
        return;
      }
      DTe = System.currentTimeMillis();
      ccz localccz = new ccz();
      localccz.GXi = paramString;
      localccz.GXj = paramInt;
      localccz.GXk = new LinkedList(paramArrayList);
      paramString = new com.tencent.mm.al.b.a();
      paramString.hNM = localccz;
      paramString.hNN = new cda();
      paramString.uri = "/cgi-bin/mmbiz-bin/oauth_authorize_confirm";
      paramString.funcId = 1373;
      paramString.hNO = 0;
      paramString.respCmdId = 0;
      IPCRunCgi.a(paramString.aDC(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
        {
          AppMethodBeat.i(207950);
          ad.i("MicroMsg.OauthAuthorizeLogic", "onSceneEnd doOauthAuthorizeConfirm errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((this.DTg == null) || (parama == null) || (!paramBoolean))
          {
            AppMethodBeat.o(207950);
            return;
          }
          Bundle localBundle = new Bundle();
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hNL.hNQ != null) && ((paramAnonymousb.hNL.hNQ instanceof cda)))
          {
            localBundle.putString("redirect_url", ((cda)paramAnonymousb.hNL.hNQ).Fxq);
            ag.b.a(true, paramAnonymousString, localBundle, paramContext, paramc, parama);
            AppMethodBeat.o(207950);
            return;
          }
          ag.b.a(false, paramAnonymousString, localBundle, paramContext, paramc, parama);
          AppMethodBeat.o(207950);
        }
      });
      AppMethodBeat.o(207953);
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
      parama.xj();
      if (!paramBoolean)
      {
        com.tencent.mm.ui.base.h.d(paramContext, paramString, aj.getContext().getString(2131766178), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(207948);
            this.DTk.goBack();
            AppMethodBeat.o(207948);
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
      paramc.aGr(paramString);
      ad.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirectUrl: %s", new Object[] { paramString });
      AppMethodBeat.o(78955);
    }
    
    public static void a(boolean paramBoolean, final String paramString, final Bundle paramBundle, Context paramContext, final e parame, final ag.c paramc, final ag.a parama, final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(78954);
      ad.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd suc: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      paramc.chI();
      final String str = aHj(paramBundle.getString("oauth_url"));
      ad.i("MicroMsg.OauthAuthorizeLogic", "parse appID:%s", new Object[] { str });
      if (!paramBoolean)
      {
        com.tencent.mm.ui.base.h.d(paramContext, paramString, aj.getContext().getString(2131766178), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(207941);
            this.DTk.goBack();
            AppMethodBeat.o(207941);
          }
        });
        paramBundle = com.tencent.mm.plugin.webview.j.b.EsZ;
        if (str == null) {}
        for (paramString = "";; paramString = str)
        {
          paramBundle.a(paramString, startTime, 2, 1, 0, 0, paramInt2);
          com.tencent.mm.plugin.webview.j.b.EsZ.aF(1, (int)(System.currentTimeMillis() - startTime), paramInt2);
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
        c.a(paramContext, a.hIT, str, new com.tencent.mm.model.gdpr.b()
        {
          public final void oG(final int paramAnonymousInt)
          {
            AppMethodBeat.i(207943);
            ad.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(207942);
                if (paramAnonymousInt == 1)
                {
                  ag.b.4.this.DTk.goBack();
                  localb = com.tencent.mm.plugin.webview.j.b.EsZ;
                  if (ag.b.4.this.DTl == null) {}
                  for (str = "";; str = ag.b.4.this.DTl)
                  {
                    localb.a(str, ag.b.startTime, 0, 1, 0, 0, ag.b.4.this.val$errCode);
                    com.tencent.mm.plugin.webview.j.b.EsZ.aF(1, (int)(System.currentTimeMillis() - ag.b.startTime), ag.b.4.this.val$errCode);
                    AppMethodBeat.o(207942);
                    return;
                  }
                }
                ag.b.4.this.DTk.aGr(ag.b.4.this.DTm);
                com.tencent.mm.plugin.webview.j.b localb = com.tencent.mm.plugin.webview.j.b.EsZ;
                if (ag.b.4.this.DTl == null) {}
                for (String str = "";; str = ag.b.4.this.DTl)
                {
                  localb.a(str, ag.b.startTime, 1, 1, 0, 0, ag.b.4.this.val$errCode);
                  break;
                }
              }
            });
            AppMethodBeat.o(207943);
          }
        });
        AppMethodBeat.o(78954);
        return;
      }
      paramBoolean = paramBundle.getBoolean("is_use_new_page", false);
      int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qtS, 1);
      ad.i("MicroMsg.OauthAuthorizeLogic", "isUseNewPage = %b, open= %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      if ((paramBoolean) && (1 == i)) {
        com.tencent.e.h.LTJ.aP(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(207944);
            ah.a(this.val$context, paramBundle, paramInt1, paramc);
            AppMethodBeat.o(207944);
          }
        });
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.j.b.EsZ.aF(1, (int)(System.currentTimeMillis() - startTime), paramInt2);
        AppMethodBeat.o(78954);
        return;
        paramString = new r.a()
        {
          public final void j(int paramAnonymousInt, final Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(207947);
            ad.i("MicroMsg.OauthAuthorizeLogic", "WebAuthorizeDialog#onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            switch (paramAnonymousInt)
            {
            default: 
              paramc.goBack();
              AppMethodBeat.o(207947);
              return;
            case 1: 
              c.a(this.val$context, a.hIT, str, new com.tencent.mm.model.gdpr.b()
              {
                public final void oG(final int paramAnonymous2Int)
                {
                  AppMethodBeat.i(207946);
                  ad.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  aq.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(207945);
                      if (paramAnonymous2Int == 1)
                      {
                        ag.b.6.this.DTk.goBack();
                        localb = com.tencent.mm.plugin.webview.j.b.EsZ;
                        if (ag.b.6.this.DTl == null) {}
                        for (str = "";; str = ag.b.6.this.DTl)
                        {
                          localb.a(str, ag.b.startTime, 0, 1, 0, 1, ag.b.6.this.val$errCode);
                          com.tencent.mm.plugin.webview.j.b.EsZ.aF(2, (int)(System.currentTimeMillis() - ag.b.DTe), ag.b.6.this.val$errCode);
                          AppMethodBeat.o(207945);
                          return;
                        }
                      }
                      com.tencent.mm.plugin.webview.j.b localb = com.tencent.mm.plugin.webview.j.b.EsZ;
                      if (ag.b.6.this.DTl == null) {}
                      for (String str = "";; str = ag.b.6.this.DTl)
                      {
                        localb.a(str, ag.b.startTime, 1, 1, 0, 1, ag.b.6.this.val$errCode);
                        ag.b.a(ag.b.6.this.DTo, ag.b.6.1.this.DTp, ag.b.6.this.DTk, ag.b.6.this.DTg, ag.b.6.this.DTh, ag.b.6.this.val$context);
                        break;
                      }
                    }
                  });
                  AppMethodBeat.o(207946);
                }
              });
              AppMethodBeat.o(207947);
              return;
            }
            ag.b.b(paramBundle, paramAnonymousBundle, paramc, parame, parama, this.val$context);
            com.tencent.mm.plugin.webview.j.b localb = com.tencent.mm.plugin.webview.j.b.EsZ;
            if (str == null) {}
            for (paramAnonymousBundle = "";; paramAnonymousBundle = str)
            {
              localb.a(paramAnonymousBundle, ag.b.startTime, 0, 1, 0, 1, paramInt2);
              com.tencent.mm.plugin.webview.j.b.EsZ.aF(2, (int)(System.currentTimeMillis() - ag.b.DTe), paramInt2);
              AppMethodBeat.o(207947);
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
          parame = ag.aG((ArrayList)paramBundle.getSerializable("scope_list"));
          paramc = paramBundle.getString("appname");
          paramBundle = paramBundle.getString("appicon_url");
          com.tencent.e.h.LTJ.aP(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(207949);
              new r(this.val$context).a(parame, paramc, paramBundle, this.val$context.getString(2131766191), paramString);
              AppMethodBeat.o(207949);
            }
          });
        }
      }
    }
    
    public static boolean a(final String paramString1, String paramString2, int paramInt1, final e parame, final ag.c paramc, final ag.a parama, final int paramInt2, Context paramContext)
    {
      AppMethodBeat.i(207952);
      if (parame == null)
      {
        ad.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize invoker null");
        AppMethodBeat.o(207952);
        return false;
      }
      startTime = System.currentTimeMillis();
      com.tencent.mm.plugin.webview.j.b.EsZ.cH(1, "");
      ad.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize scene: %d", new Object[] { Integer.valueOf(paramInt1) });
      paramc.d(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(78944);
          ad.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize user cancel");
          this.DTf.chI();
          AppMethodBeat.o(78944);
        }
      });
      cdb localcdb = new cdb();
      localcdb.GXi = paramString1;
      localcdb.FIk = paramString2;
      localcdb.scene = paramInt1;
      paramString2 = new com.tencent.mm.al.b.a();
      paramString2.hNM = localcdb;
      paramString2.hNN = new cdc();
      paramString2.uri = "/cgi-bin/mmbiz-bin/oauth_authorize";
      paramString2.funcId = 1254;
      paramString2.hNO = 0;
      paramString2.respCmdId = 0;
      IPCRunCgi.a(paramString2.aDC(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
        {
          AppMethodBeat.i(207940);
          ad.i("MicroMsg.OauthAuthorizeLogic", "onSceneEnd doOauthAuthorize errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((this.val$context == null) || (parame == null) || (paramc == null) || (parama == null))
          {
            AppMethodBeat.o(207940);
            return;
          }
          Bundle localBundle = new Bundle();
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hNL.hNQ != null) && ((paramAnonymousb.hNL.hNQ instanceof cdc)))
          {
            paramAnonymousb = (cdc)paramAnonymousb.hNL.hNQ;
            localBundle.putString("oauth_url", paramString1);
            localBundle.putSerializable("scope_list", ag.bf(paramAnonymousb.GXl));
            localBundle.putString("appname", paramAnonymousb.hBg);
            localBundle.putString("appicon_url", paramAnonymousb.GXm);
            localBundle.putString("redirect_url", paramAnonymousb.Fxq);
            localBundle.putBoolean("is_recent_has_auth", paramAnonymousb.GXn);
            localBundle.putBoolean("is_silence_auth", paramAnonymousb.GXo);
            localBundle.putBoolean("is_call_server_when_confirm", paramAnonymousb.GXp);
            localBundle.putSerializable("avatar_list", ah.bg(paramAnonymousb.GXq));
            localBundle.putBoolean("is_use_new_page", paramAnonymousb.GXr);
            localBundle.putBoolean("is_ban_modify_avatar", paramAnonymousb.kzP);
            localBundle.putInt("avatar_limit", paramAnonymousb.kzQ);
            localBundle.putInt("default_avatar_id", paramAnonymousb.kzR);
            localBundle.putString("default_headimg_url", paramAnonymousb.kzS);
            localBundle.putString("default_headimg_fileid", paramAnonymousb.kzT);
            ag.b.a(true, paramAnonymousString, localBundle, this.val$context, parame, paramc, parama, paramInt2, paramAnonymousInt2);
            AppMethodBeat.o(207940);
            return;
          }
          ag.b.a(false, paramAnonymousString, localBundle, this.val$context, parame, paramc, parama, paramInt2, paramAnonymousInt2);
          AppMethodBeat.o(207940);
        }
      });
      AppMethodBeat.o(207952);
      return true;
    }
    
    public static String aHj(String paramString)
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
    
    public static boolean fJ(String paramString, int paramInt)
    {
      AppMethodBeat.i(207951);
      if (6 == paramInt)
      {
        ad.i("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept from oauth");
        AppMethodBeat.o(207951);
        return false;
      }
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(207951);
        return false;
      }
      paramInt = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qtQ, 1);
      ad.i("MicroMsg.OauthAuthorizeLogic", "isABTestOpen %d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1)
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label274;
        }
        if ((ag.eQd() == null) && (!ag.DTd))
        {
          String str2 = ag.eQc();
          String str1 = str2;
          if (bt.isNullOrNil(str2)) {
            str1 = "open.weixin.qq.com/connect/oauth2/authorize";
          }
          ag.access$302(str1.split(";"));
          ag.eQe();
        }
        if ((ag.eQd() != null) && (ag.eQd().length != 0)) {
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
        AppMethodBeat.o(207951);
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
            if (paramInt >= ag.eQd().length) {
              break label272;
            }
            if (paramString.equalsIgnoreCase(ag.eQd()[paramInt]))
            {
              paramInt = 1;
              break;
            }
            paramInt += 1;
          }
        }
      }
      label274:
      AppMethodBeat.o(207951);
      return false;
    }
  }
  
  public static abstract interface c
  {
    public abstract void aGr(String paramString);
    
    public abstract void chI();
    
    public abstract void d(DialogInterface.OnCancelListener paramOnCancelListener);
    
    public abstract void goBack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ag
 * JD-Core Version:    0.7.0.1
 */