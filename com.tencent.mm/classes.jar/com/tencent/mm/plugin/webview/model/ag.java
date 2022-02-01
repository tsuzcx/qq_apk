package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.gdpr.a;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.widget.r.a;
import com.tencent.mm.protocal.protobuf.cdt;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.cdw;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ag
{
  private static String[] Elc;
  private static boolean Eld = false;
  
  public static LinkedList<cyg> aH(ArrayList<byte[]> paramArrayList)
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
        cea localcea = new cea();
        localcea.parseFrom((byte[])paramArrayList.get(i));
        cyg localcyg = new cyg();
        localcyg.HIx = localcea.HqT;
        localcyg.Desc = localcea.desc;
        localcyg.GcE = localcea.scope;
        localcyg.mqC = localcea.mqC;
        localLinkedList.add(localcyg);
        i += 1;
      }
      catch (IOException paramArrayList)
      {
        ae.w("MicroMsg.OauthAuthorizeLogic", "bytesListToBytesListScopeInfoList: i:%d, exp:%s", new Object[] { Integer.valueOf(i), paramArrayList.getLocalizedMessage() });
        localLinkedList.clear();
        AppMethodBeat.o(78963);
        return localLinkedList;
      }
    }
    AppMethodBeat.o(78963);
    return localLinkedList;
  }
  
  private static ArrayList<byte[]> bf(LinkedList<cea> paramLinkedList)
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
        localArrayList.add(((cea)paramLinkedList.get(i)).toByteArray());
        i += 1;
      }
      catch (IOException paramLinkedList)
      {
        ae.w("MicroMsg.OauthAuthorizeLogic", "oauthScopeInfoListToBytesList index:%d, exp:%s ", new Object[] { Integer.valueOf(i), paramLinkedList.getLocalizedMessage() });
        localArrayList.clear();
        AppMethodBeat.o(78962);
        return localArrayList;
      }
    }
    AppMethodBeat.o(78962);
    return localArrayList;
  }
  
  public static String eTO()
  {
    AppMethodBeat.i(198136);
    String str = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAE, "");
    ae.i("MicroMsg.OauthAuthorizeLogic", "getOauthHostPaths %s", new Object[] { str });
    AppMethodBeat.o(198136);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void xj();
  }
  
  public static final class b
  {
    public static long Ele = 0L;
    public static long startTime = 0L;
    
    private static void a(e parame, String paramString, int paramInt, ArrayList<String> paramArrayList, final ag.a parama, final boolean paramBoolean, final ag.c paramc, final Context paramContext)
    {
      AppMethodBeat.i(198133);
      if (parame == null)
      {
        ae.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm invoker null");
        AppMethodBeat.o(198133);
        return;
      }
      Ele = System.currentTimeMillis();
      cdt localcdt = new cdt();
      localcdt.HqI = paramString;
      localcdt.HqJ = paramInt;
      localcdt.HqK = new LinkedList(paramArrayList);
      paramString = new com.tencent.mm.ak.b.a();
      paramString.hQF = localcdt;
      paramString.hQG = new cdu();
      paramString.uri = "/cgi-bin/mmbiz-bin/oauth_authorize_confirm";
      paramString.funcId = 1373;
      paramString.hQH = 0;
      paramString.respCmdId = 0;
      IPCRunCgi.a(paramString.aDS(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
        {
          AppMethodBeat.i(198130);
          ae.i("MicroMsg.OauthAuthorizeLogic", "onSceneEnd doOauthAuthorizeConfirm errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((this.Elg == null) || (parama == null) || (!paramBoolean))
          {
            AppMethodBeat.o(198130);
            return;
          }
          Bundle localBundle = new Bundle();
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hQE.hQJ != null) && ((paramAnonymousb.hQE.hQJ instanceof cdu)))
          {
            localBundle.putString("redirect_url", ((cdu)paramAnonymousb.hQE.hQJ).FPO);
            ag.b.a(true, paramAnonymousString, localBundle, paramContext, paramc, parama);
            AppMethodBeat.o(198130);
            return;
          }
          ag.b.a(false, paramAnonymousString, localBundle, paramContext, paramc, parama);
          AppMethodBeat.o(198130);
        }
      });
      AppMethodBeat.o(198133);
    }
    
    public static void a(boolean paramBoolean, String paramString, Bundle paramBundle, Context paramContext, ag.c paramc, ag.a parama)
    {
      AppMethodBeat.i(78955);
      ae.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd suc: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      if ((paramContext == null) || (((WebViewUI)paramContext).isFinishing()))
      {
        AppMethodBeat.o(78955);
        return;
      }
      parama.xj();
      if (!paramBoolean)
      {
        com.tencent.mm.ui.base.h.d(paramContext, paramString, ak.getContext().getString(2131766178), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(198128);
            this.Elk.goBack();
            AppMethodBeat.o(198128);
          }
        });
        AppMethodBeat.o(78955);
        return;
      }
      paramString = paramBundle.getString("redirect_url");
      if (bu.isNullOrNil(paramString))
      {
        ae.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirect null");
        AppMethodBeat.o(78955);
        return;
      }
      paramc.aHL(paramString);
      ae.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirectUrl: %s", new Object[] { paramString });
      AppMethodBeat.o(78955);
    }
    
    public static void a(boolean paramBoolean, final String paramString, final Bundle paramBundle, Context paramContext, final e parame, final ag.c paramc, final ag.a parama, final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(78954);
      ae.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd suc: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      paramc.ciY();
      final String str = aID(paramBundle.getString("oauth_url"));
      ae.i("MicroMsg.OauthAuthorizeLogic", "parse appID:%s", new Object[] { str });
      if (!paramBoolean)
      {
        com.tencent.mm.ui.base.h.d(paramContext, paramString, ak.getContext().getString(2131766178), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(198121);
            this.Elk.goBack();
            AppMethodBeat.o(198121);
          }
        });
        paramBundle = com.tencent.mm.plugin.webview.j.b.ELt;
        if (str == null) {}
        for (paramString = "";; paramString = str)
        {
          paramBundle.a(paramString, startTime, 2, 1, 0, 0, paramInt2);
          com.tencent.mm.plugin.webview.j.b.ELt.aG(1, (int)(System.currentTimeMillis() - startTime), paramInt2);
          AppMethodBeat.o(78954);
          return;
        }
      }
      paramBoolean = paramBundle.getBoolean("is_recent_has_auth");
      boolean bool = paramBundle.getBoolean("is_silence_auth");
      if ((paramBoolean) || (bool))
      {
        paramString = paramBundle.getString("redirect_url");
        if (bu.isNullOrNil(paramString))
        {
          ae.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd redirect null");
          AppMethodBeat.o(78954);
          return;
        }
        ae.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd isRecentHasAuth:%b isSilenceAuth:%b redirectUrl:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), paramString });
        c.a(paramContext, a.hLM, str, new com.tencent.mm.model.gdpr.b()
        {
          public final void oJ(final int paramAnonymousInt)
          {
            AppMethodBeat.i(198123);
            ae.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(198122);
                if (paramAnonymousInt == 1)
                {
                  ag.b.4.this.Elk.goBack();
                  localb = com.tencent.mm.plugin.webview.j.b.ELt;
                  if (ag.b.4.this.Ell == null) {}
                  for (str = "";; str = ag.b.4.this.Ell)
                  {
                    localb.a(str, ag.b.startTime, 0, 1, 0, 0, ag.b.4.this.val$errCode);
                    com.tencent.mm.plugin.webview.j.b.ELt.aG(1, (int)(System.currentTimeMillis() - ag.b.startTime), ag.b.4.this.val$errCode);
                    AppMethodBeat.o(198122);
                    return;
                  }
                }
                ag.b.4.this.Elk.aHL(ag.b.4.this.Elm);
                com.tencent.mm.plugin.webview.j.b localb = com.tencent.mm.plugin.webview.j.b.ELt;
                if (ag.b.4.this.Ell == null) {}
                for (String str = "";; str = ag.b.4.this.Ell)
                {
                  localb.a(str, ag.b.startTime, 1, 1, 0, 0, ag.b.4.this.val$errCode);
                  break;
                }
              }
            });
            AppMethodBeat.o(198123);
          }
        });
        AppMethodBeat.o(78954);
        return;
      }
      paramBoolean = paramBundle.getBoolean("is_use_new_page", false);
      int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAG, 1);
      ae.i("MicroMsg.OauthAuthorizeLogic", "isUseNewPage = %b, open= %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      if ((paramBoolean) && (1 == i)) {
        com.tencent.e.h.MqF.aM(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(198124);
            ah.a(this.val$context, paramBundle, paramInt1, paramc);
            AppMethodBeat.o(198124);
          }
        });
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.j.b.ELt.aG(1, (int)(System.currentTimeMillis() - startTime), paramInt2);
        AppMethodBeat.o(78954);
        return;
        paramString = new r.a()
        {
          public final void j(int paramAnonymousInt, final Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(198127);
            ae.i("MicroMsg.OauthAuthorizeLogic", "WebAuthorizeDialog#onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            switch (paramAnonymousInt)
            {
            default: 
              paramc.goBack();
              AppMethodBeat.o(198127);
              return;
            case 1: 
              c.a(this.val$context, a.hLM, str, new com.tencent.mm.model.gdpr.b()
              {
                public final void oJ(final int paramAnonymous2Int)
                {
                  AppMethodBeat.i(198126);
                  ae.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  ar.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(198125);
                      if (paramAnonymous2Int == 1)
                      {
                        ag.b.6.this.Elk.goBack();
                        localb = com.tencent.mm.plugin.webview.j.b.ELt;
                        if (ag.b.6.this.Ell == null) {}
                        for (str = "";; str = ag.b.6.this.Ell)
                        {
                          localb.a(str, ag.b.startTime, 0, 1, 0, 1, ag.b.6.this.val$errCode);
                          com.tencent.mm.plugin.webview.j.b.ELt.aG(2, (int)(System.currentTimeMillis() - ag.b.Ele), ag.b.6.this.val$errCode);
                          AppMethodBeat.o(198125);
                          return;
                        }
                      }
                      com.tencent.mm.plugin.webview.j.b localb = com.tencent.mm.plugin.webview.j.b.ELt;
                      if (ag.b.6.this.Ell == null) {}
                      for (String str = "";; str = ag.b.6.this.Ell)
                      {
                        localb.a(str, ag.b.startTime, 1, 1, 0, 1, ag.b.6.this.val$errCode);
                        ag.b.a(ag.b.6.this.Elo, ag.b.6.1.this.Elp, ag.b.6.this.Elk, ag.b.6.this.Elg, ag.b.6.this.Elh, ag.b.6.this.val$context);
                        break;
                      }
                    }
                  });
                  AppMethodBeat.o(198126);
                }
              });
              AppMethodBeat.o(198127);
              return;
            }
            ag.b.b(paramBundle, paramAnonymousBundle, paramc, parame, parama, this.val$context);
            com.tencent.mm.plugin.webview.j.b localb = com.tencent.mm.plugin.webview.j.b.ELt;
            if (str == null) {}
            for (paramAnonymousBundle = "";; paramAnonymousBundle = str)
            {
              localb.a(paramAnonymousBundle, ag.b.startTime, 0, 1, 0, 1, paramInt2);
              com.tencent.mm.plugin.webview.j.b.ELt.aG(2, (int)(System.currentTimeMillis() - ag.b.Ele), paramInt2);
              AppMethodBeat.o(198127);
              return;
            }
          }
        };
        if (((paramContext instanceof WebViewUI)) && (((WebViewUI)paramContext).isFinishing()))
        {
          ae.i("MicroMsg.OauthAuthorizeLogic", "showWebAuthorizeDialog isFinishing");
        }
        else
        {
          parame = ag.aH((ArrayList)paramBundle.getSerializable("scope_list"));
          paramc = paramBundle.getString("appname");
          paramBundle = paramBundle.getString("appicon_url");
          com.tencent.e.h.MqF.aM(new ag.b.8(paramContext, parame, paramc, paramBundle, paramString));
        }
      }
    }
    
    public static boolean a(final String paramString1, String paramString2, int paramInt1, final e parame, final ag.c paramc, final ag.a parama, final int paramInt2, Context paramContext)
    {
      AppMethodBeat.i(198132);
      if (parame == null)
      {
        ae.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize invoker null");
        AppMethodBeat.o(198132);
        return false;
      }
      startTime = System.currentTimeMillis();
      com.tencent.mm.plugin.webview.j.b.ELt.cH(1, "");
      ae.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize scene: %d", new Object[] { Integer.valueOf(paramInt1) });
      paramc.d(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(78944);
          ae.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize user cancel");
          this.Elf.ciY();
          AppMethodBeat.o(78944);
        }
      });
      cdv localcdv = new cdv();
      localcdv.HqI = paramString1;
      localcdv.GaH = paramString2;
      localcdv.scene = paramInt1;
      paramString2 = new com.tencent.mm.ak.b.a();
      paramString2.hQF = localcdv;
      paramString2.hQG = new cdw();
      paramString2.uri = "/cgi-bin/mmbiz-bin/oauth_authorize";
      paramString2.funcId = 1254;
      paramString2.hQH = 0;
      paramString2.respCmdId = 0;
      IPCRunCgi.a(paramString2.aDS(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
        {
          AppMethodBeat.i(198120);
          ae.i("MicroMsg.OauthAuthorizeLogic", "onSceneEnd doOauthAuthorize errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((this.val$context == null) || (parame == null) || (paramc == null) || (parama == null))
          {
            AppMethodBeat.o(198120);
            return;
          }
          Bundle localBundle = new Bundle();
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hQE.hQJ != null) && ((paramAnonymousb.hQE.hQJ instanceof cdw)))
          {
            paramAnonymousb = (cdw)paramAnonymousb.hQE.hQJ;
            localBundle.putString("oauth_url", paramString1);
            localBundle.putSerializable("scope_list", ag.bg(paramAnonymousb.HqL));
            localBundle.putString("appname", paramAnonymousb.hDU);
            localBundle.putString("appicon_url", paramAnonymousb.HqM);
            localBundle.putString("redirect_url", paramAnonymousb.FPO);
            localBundle.putBoolean("is_recent_has_auth", paramAnonymousb.HqN);
            localBundle.putBoolean("is_silence_auth", paramAnonymousb.HqO);
            localBundle.putBoolean("is_call_server_when_confirm", paramAnonymousb.HqP);
            localBundle.putSerializable("avatar_list", ah.bh(paramAnonymousb.HqQ));
            localBundle.putBoolean("is_use_new_page", paramAnonymousb.HqR);
            localBundle.putBoolean("is_ban_modify_avatar", paramAnonymousb.kDe);
            localBundle.putInt("avatar_limit", paramAnonymousb.kDf);
            localBundle.putInt("default_avatar_id", paramAnonymousb.kDg);
            localBundle.putString("default_headimg_url", paramAnonymousb.kDh);
            localBundle.putString("default_headimg_fileid", paramAnonymousb.kDi);
            ag.b.a(true, paramAnonymousString, localBundle, this.val$context, parame, paramc, parama, paramInt2, paramAnonymousInt2);
            AppMethodBeat.o(198120);
            return;
          }
          ag.b.a(false, paramAnonymousString, localBundle, this.val$context, parame, paramc, parama, paramInt2, paramAnonymousInt2);
          AppMethodBeat.o(198120);
        }
      });
      AppMethodBeat.o(198132);
      return true;
    }
    
    public static String aID(String paramString)
    {
      localObject1 = null;
      AppMethodBeat.i(78959);
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(78959);
        return null;
      }
      try
      {
        String str = Uri.parse(paramString).getQueryParameter("appid");
        localObject2 = str;
        localObject1 = str;
        if (bu.isNullOrNil(str))
        {
          localObject1 = str;
          ae.i("MicroMsg.OauthAuthorizeLogic", "parseAppId try case not sensitive, oauthUrl:%s", new Object[] { paramString });
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
    
    public static boolean fU(String paramString, int paramInt)
    {
      AppMethodBeat.i(198131);
      if (6 == paramInt)
      {
        ae.i("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept from oauth");
        AppMethodBeat.o(198131);
        return false;
      }
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(198131);
        return false;
      }
      paramInt = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAE, 1);
      ae.i("MicroMsg.OauthAuthorizeLogic", "isABTestOpen %d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1)
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label274;
        }
        if ((ag.eTP() == null) && (!ag.Eld))
        {
          String str2 = ag.eTO();
          String str1 = str2;
          if (bu.isNullOrNil(str2)) {
            str1 = "open.weixin.qq.com/connect/oauth2/authorize";
          }
          ag.access$302(str1.split(";"));
          ag.eTQ();
        }
        if ((ag.eTP() != null) && (ag.eTP().length != 0)) {
          break label176;
        }
        ae.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost sOauthHostPaths nil");
      }
      label272:
      for (;;)
      {
        paramInt = 0;
        if (paramInt == 0) {
          break label274;
        }
        AppMethodBeat.o(198131);
        return true;
        paramInt = 0;
        break;
        label176:
        paramString = Uri.parse(paramString);
        paramString = paramString.getAuthority() + paramString.getPath();
        if (bu.isNullOrNil(paramString))
        {
          ae.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost target nil");
        }
        else
        {
          ae.d("MicroMsg.OauthAuthorizeLogic", "isOauthHost target:%s", new Object[] { paramString });
          paramInt = 0;
          for (;;)
          {
            if (paramInt >= ag.eTP().length) {
              break label272;
            }
            if (paramString.equalsIgnoreCase(ag.eTP()[paramInt]))
            {
              paramInt = 1;
              break;
            }
            paramInt += 1;
          }
        }
      }
      label274:
      AppMethodBeat.o(198131);
      return false;
    }
  }
  
  public static abstract interface c
  {
    public abstract void aHL(String paramString);
    
    public abstract void ciY();
    
    public abstract void d(DialogInterface.OnCancelListener paramOnCancelListener);
    
    public abstract void goBack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ag
 * JD-Core Version:    0.7.0.1
 */