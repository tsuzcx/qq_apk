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
import com.tencent.mm.protocal.protobuf.byi;
import com.tencent.mm.protocal.protobuf.byj;
import com.tencent.mm.protocal.protobuf.byk;
import com.tencent.mm.protocal.protobuf.byl;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ag
{
  private static String[] CpE;
  private static boolean CpF = false;
  
  public static LinkedList<csf> aJ(ArrayList<byte[]> paramArrayList)
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
        byp localbyp = new byp();
        localbyp.parseFrom((byte[])paramArrayList.get(i));
        csf localcsf = new csf();
        localcsf.FEG = localbyp.FnK;
        localcsf.Desc = localbyp.desc;
        localcsf.EdG = localbyp.scope;
        localcsf.lLR = localbyp.lLR;
        localLinkedList.add(localcsf);
        i += 1;
      }
      catch (IOException paramArrayList)
      {
        ac.w("MicroMsg.OauthAuthorizeLogic", "bytesListToBytesListScopeInfoList: i:%d, exp:%s", new Object[] { Integer.valueOf(i), paramArrayList.getLocalizedMessage() });
        localLinkedList.clear();
        AppMethodBeat.o(78963);
        return localLinkedList;
      }
    }
    AppMethodBeat.o(78963);
    return localLinkedList;
  }
  
  private static ArrayList<byte[]> bd(LinkedList<byp> paramLinkedList)
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
        localArrayList.add(((byp)paramLinkedList.get(i)).toByteArray());
        i += 1;
      }
      catch (IOException paramLinkedList)
      {
        ac.w("MicroMsg.OauthAuthorizeLogic", "oauthScopeInfoListToBytesList index:%d, exp:%s ", new Object[] { Integer.valueOf(i), paramLinkedList.getLocalizedMessage() });
        localArrayList.clear();
        AppMethodBeat.o(78962);
        return localArrayList;
      }
    }
    AppMethodBeat.o(78962);
    return localArrayList;
  }
  
  public static String eBk()
  {
    AppMethodBeat.i(188337);
    String str = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPO, "");
    ac.i("MicroMsg.OauthAuthorizeLogic", "getOauthHostPaths %s", new Object[] { str });
    AppMethodBeat.o(188337);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void vM();
  }
  
  public static final class b
  {
    public static long CpG = 0L;
    public static long startTime = 0L;
    
    private static void a(e parame, String paramString, int paramInt, ArrayList<String> paramArrayList, final ag.a parama, final boolean paramBoolean, final ag.c paramc, final Context paramContext)
    {
      AppMethodBeat.i(188334);
      if (parame == null)
      {
        ac.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm invoker null");
        AppMethodBeat.o(188334);
        return;
      }
      CpG = System.currentTimeMillis();
      byi localbyi = new byi();
      localbyi.Fnz = paramString;
      localbyi.FnA = paramInt;
      localbyi.FnB = new LinkedList(paramArrayList);
      paramString = new com.tencent.mm.ak.b.a();
      paramString.hvt = localbyi;
      paramString.hvu = new byj();
      paramString.uri = "/cgi-bin/mmbiz-bin/oauth_authorize_confirm";
      paramString.funcId = 1373;
      paramString.reqCmdId = 0;
      paramString.respCmdId = 0;
      IPCRunCgi.a(paramString.aAz(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
        {
          AppMethodBeat.i(188331);
          ac.i("MicroMsg.OauthAuthorizeLogic", "onSceneEnd doOauthAuthorizeConfirm errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((this.CpI == null) || (parama == null) || (!paramBoolean))
          {
            AppMethodBeat.o(188331);
            return;
          }
          Bundle localBundle = new Bundle();
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hvs.hvw != null) && ((paramAnonymousb.hvs.hvw instanceof byj)))
          {
            localBundle.putString("redirect_url", ((byj)paramAnonymousb.hvs.hvw).DRX);
            ag.b.a(true, paramAnonymousString, localBundle, paramContext, paramc, parama);
            AppMethodBeat.o(188331);
            return;
          }
          ag.b.a(false, paramAnonymousString, localBundle, paramContext, paramc, parama);
          AppMethodBeat.o(188331);
        }
      });
      AppMethodBeat.o(188334);
    }
    
    public static void a(boolean paramBoolean, String paramString, Bundle paramBundle, Context paramContext, ag.c paramc, ag.a parama)
    {
      AppMethodBeat.i(78955);
      ac.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd suc: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      if ((paramContext == null) || (((WebViewUI)paramContext).isFinishing()))
      {
        AppMethodBeat.o(78955);
        return;
      }
      parama.vM();
      if (!paramBoolean)
      {
        com.tencent.mm.ui.base.h.d(paramContext, paramString, ai.getContext().getString(2131766178), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(188329);
            this.CpM.goBack();
            AppMethodBeat.o(188329);
          }
        });
        AppMethodBeat.o(78955);
        return;
      }
      paramString = paramBundle.getString("redirect_url");
      if (bs.isNullOrNil(paramString))
      {
        ac.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirect null");
        AppMethodBeat.o(78955);
        return;
      }
      paramc.aAW(paramString);
      ac.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirectUrl: %s", new Object[] { paramString });
      AppMethodBeat.o(78955);
    }
    
    public static void a(boolean paramBoolean, final String paramString, final Bundle paramBundle, Context paramContext, final e parame, final ag.c paramc, final ag.a parama, final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(78954);
      ac.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd suc: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      paramc.cdf();
      final String str = aBK(paramBundle.getString("oauth_url"));
      ac.i("MicroMsg.OauthAuthorizeLogic", "parse appID:%s", new Object[] { str });
      if (!paramBoolean)
      {
        com.tencent.mm.ui.base.h.d(paramContext, paramString, ai.getContext().getString(2131766178), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(188322);
            this.CpM.goBack();
            AppMethodBeat.o(188322);
          }
        });
        paramBundle = com.tencent.mm.plugin.webview.j.b.COZ;
        if (str == null) {}
        for (paramString = "";; paramString = str)
        {
          paramBundle.a(paramString, startTime, 2, 1, 0, 0, paramInt2);
          com.tencent.mm.plugin.webview.j.b.COZ.aD(1, (int)(System.currentTimeMillis() - startTime), paramInt2);
          AppMethodBeat.o(78954);
          return;
        }
      }
      paramBoolean = paramBundle.getBoolean("is_recent_has_auth");
      boolean bool = paramBundle.getBoolean("is_silence_auth");
      if ((paramBoolean) || (bool))
      {
        paramString = paramBundle.getString("redirect_url");
        if (bs.isNullOrNil(paramString))
        {
          ac.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd redirect null");
          AppMethodBeat.o(78954);
          return;
        }
        ac.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd isRecentHasAuth:%b isSilenceAuth:%b redirectUrl:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), paramString });
        c.a(paramContext, a.hqB, str, new com.tencent.mm.model.gdpr.b()
        {
          public final void og(final int paramAnonymousInt)
          {
            AppMethodBeat.i(188324);
            ac.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(188323);
                if (paramAnonymousInt == 1)
                {
                  ag.b.4.this.CpM.goBack();
                  localb = com.tencent.mm.plugin.webview.j.b.COZ;
                  if (ag.b.4.this.CpN == null) {}
                  for (str = "";; str = ag.b.4.this.CpN)
                  {
                    localb.a(str, ag.b.startTime, 0, 1, 0, 0, ag.b.4.this.val$errCode);
                    com.tencent.mm.plugin.webview.j.b.COZ.aD(1, (int)(System.currentTimeMillis() - ag.b.startTime), ag.b.4.this.val$errCode);
                    AppMethodBeat.o(188323);
                    return;
                  }
                }
                ag.b.4.this.CpM.aAW(ag.b.4.this.CpO);
                com.tencent.mm.plugin.webview.j.b localb = com.tencent.mm.plugin.webview.j.b.COZ;
                if (ag.b.4.this.CpN == null) {}
                for (String str = "";; str = ag.b.4.this.CpN)
                {
                  localb.a(str, ag.b.startTime, 1, 1, 0, 0, ag.b.4.this.val$errCode);
                  break;
                }
              }
            });
            AppMethodBeat.o(188324);
          }
        });
        AppMethodBeat.o(78954);
        return;
      }
      paramBoolean = paramBundle.getBoolean("is_use_new_page", false);
      int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPQ, 1);
      ac.i("MicroMsg.OauthAuthorizeLogic", "isUseNewPage = %b, open= %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      if ((paramBoolean) && (1 == i)) {
        com.tencent.e.h.JZN.aQ(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(188325);
            ah.a(this.val$context, paramBundle, paramInt1, paramc);
            AppMethodBeat.o(188325);
          }
        });
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.j.b.COZ.aD(1, (int)(System.currentTimeMillis() - startTime), paramInt2);
        AppMethodBeat.o(78954);
        return;
        paramString = new r.a()
        {
          public final void j(int paramAnonymousInt, final Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(188328);
            ac.i("MicroMsg.OauthAuthorizeLogic", "WebAuthorizeDialog#onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            switch (paramAnonymousInt)
            {
            default: 
              paramc.goBack();
              AppMethodBeat.o(188328);
              return;
            case 1: 
              c.a(this.val$context, a.hqB, str, new com.tencent.mm.model.gdpr.b()
              {
                public final void og(final int paramAnonymous2Int)
                {
                  AppMethodBeat.i(188327);
                  ac.i("MicroMsg.OauthAuthorizeLogic", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  ap.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(188326);
                      if (paramAnonymous2Int == 1)
                      {
                        ag.b.6.this.CpM.goBack();
                        localb = com.tencent.mm.plugin.webview.j.b.COZ;
                        if (ag.b.6.this.CpN == null) {}
                        for (str = "";; str = ag.b.6.this.CpN)
                        {
                          localb.a(str, ag.b.startTime, 0, 1, 0, 1, ag.b.6.this.val$errCode);
                          com.tencent.mm.plugin.webview.j.b.COZ.aD(2, (int)(System.currentTimeMillis() - ag.b.CpG), ag.b.6.this.val$errCode);
                          AppMethodBeat.o(188326);
                          return;
                        }
                      }
                      com.tencent.mm.plugin.webview.j.b localb = com.tencent.mm.plugin.webview.j.b.COZ;
                      if (ag.b.6.this.CpN == null) {}
                      for (String str = "";; str = ag.b.6.this.CpN)
                      {
                        localb.a(str, ag.b.startTime, 1, 1, 0, 1, ag.b.6.this.val$errCode);
                        ag.b.a(ag.b.6.this.CpQ, ag.b.6.1.this.kGq, ag.b.6.this.CpM, ag.b.6.this.CpI, ag.b.6.this.CpJ, ag.b.6.this.val$context);
                        break;
                      }
                    }
                  });
                  AppMethodBeat.o(188327);
                }
              });
              AppMethodBeat.o(188328);
              return;
            }
            ag.b.b(paramBundle, paramAnonymousBundle, paramc, parame, parama, this.val$context);
            com.tencent.mm.plugin.webview.j.b localb = com.tencent.mm.plugin.webview.j.b.COZ;
            if (str == null) {}
            for (paramAnonymousBundle = "";; paramAnonymousBundle = str)
            {
              localb.a(paramAnonymousBundle, ag.b.startTime, 0, 1, 0, 1, paramInt2);
              com.tencent.mm.plugin.webview.j.b.COZ.aD(2, (int)(System.currentTimeMillis() - ag.b.CpG), paramInt2);
              AppMethodBeat.o(188328);
              return;
            }
          }
        };
        if (((paramContext instanceof WebViewUI)) && (((WebViewUI)paramContext).isFinishing()))
        {
          ac.i("MicroMsg.OauthAuthorizeLogic", "showWebAuthorizeDialog isFinishing");
        }
        else
        {
          parame = ag.aJ((ArrayList)paramBundle.getSerializable("scope_list"));
          paramc = paramBundle.getString("appname");
          paramBundle = paramBundle.getString("appicon_url");
          com.tencent.e.h.JZN.aQ(new ag.b.8(paramContext, parame, paramc, paramBundle, paramString));
        }
      }
    }
    
    public static boolean a(final String paramString1, String paramString2, int paramInt1, final e parame, final ag.c paramc, final ag.a parama, final int paramInt2, Context paramContext)
    {
      AppMethodBeat.i(188333);
      if (parame == null)
      {
        ac.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize invoker null");
        AppMethodBeat.o(188333);
        return false;
      }
      startTime = System.currentTimeMillis();
      com.tencent.mm.plugin.webview.j.b.COZ.cB(1, "");
      ac.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize scene: %d", new Object[] { Integer.valueOf(paramInt1) });
      paramc.d(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(78944);
          ac.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize user cancel");
          this.CpH.cdf();
          AppMethodBeat.o(78944);
        }
      });
      byk localbyk = new byk();
      localbyk.Fnz = paramString1;
      localbyk.Ecn = paramString2;
      localbyk.scene = paramInt1;
      paramString2 = new com.tencent.mm.ak.b.a();
      paramString2.hvt = localbyk;
      paramString2.hvu = new byl();
      paramString2.uri = "/cgi-bin/mmbiz-bin/oauth_authorize";
      paramString2.funcId = 1254;
      paramString2.reqCmdId = 0;
      paramString2.respCmdId = 0;
      IPCRunCgi.a(paramString2.aAz(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
        {
          AppMethodBeat.i(188321);
          ac.i("MicroMsg.OauthAuthorizeLogic", "onSceneEnd doOauthAuthorize errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((this.val$context == null) || (parame == null) || (paramc == null) || (parama == null))
          {
            AppMethodBeat.o(188321);
            return;
          }
          Bundle localBundle = new Bundle();
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hvs.hvw != null) && ((paramAnonymousb.hvs.hvw instanceof byl)))
          {
            paramAnonymousb = (byl)paramAnonymousb.hvs.hvw;
            localBundle.putString("oauth_url", paramString1);
            localBundle.putSerializable("scope_list", ag.be(paramAnonymousb.FnC));
            localBundle.putString("appname", paramAnonymousb.hiX);
            localBundle.putString("appicon_url", paramAnonymousb.FnD);
            localBundle.putString("redirect_url", paramAnonymousb.DRX);
            localBundle.putBoolean("is_recent_has_auth", paramAnonymousb.FnE);
            localBundle.putBoolean("is_silence_auth", paramAnonymousb.FnF);
            localBundle.putBoolean("is_call_server_when_confirm", paramAnonymousb.FnG);
            localBundle.putSerializable("avatar_list", ah.bf(paramAnonymousb.FnH));
            localBundle.putBoolean("is_use_new_page", paramAnonymousb.FnI);
            localBundle.putBoolean("is_ban_modify_avatar", paramAnonymousb.kfb);
            localBundle.putInt("avatar_limit", paramAnonymousb.kfc);
            localBundle.putInt("default_avatar_id", paramAnonymousb.kfd);
            localBundle.putString("default_headimg_url", paramAnonymousb.kfe);
            localBundle.putString("default_headimg_fileid", paramAnonymousb.kff);
            ag.b.a(true, paramAnonymousString, localBundle, this.val$context, parame, paramc, parama, paramInt2, paramAnonymousInt2);
            AppMethodBeat.o(188321);
            return;
          }
          ag.b.a(false, paramAnonymousString, localBundle, this.val$context, parame, paramc, parama, paramInt2, paramAnonymousInt2);
          AppMethodBeat.o(188321);
        }
      });
      AppMethodBeat.o(188333);
      return true;
    }
    
    public static String aBK(String paramString)
    {
      localObject1 = null;
      AppMethodBeat.i(78959);
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(78959);
        return null;
      }
      try
      {
        String str = Uri.parse(paramString).getQueryParameter("appid");
        localObject2 = str;
        localObject1 = str;
        if (bs.isNullOrNil(str))
        {
          localObject1 = str;
          ac.i("MicroMsg.OauthAuthorizeLogic", "parseAppId try case not sensitive, oauthUrl:%s", new Object[] { paramString });
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
    
    public static boolean fm(String paramString, int paramInt)
    {
      AppMethodBeat.i(188332);
      if (6 == paramInt)
      {
        ac.i("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept from oauth");
        AppMethodBeat.o(188332);
        return false;
      }
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(188332);
        return false;
      }
      paramInt = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPO, 1);
      ac.i("MicroMsg.OauthAuthorizeLogic", "isABTestOpen %d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1)
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label274;
        }
        if ((ag.eBl() == null) && (!ag.CpF))
        {
          String str2 = ag.eBk();
          String str1 = str2;
          if (bs.isNullOrNil(str2)) {
            str1 = "open.weixin.qq.com/connect/oauth2/authorize";
          }
          ag.access$302(str1.split(";"));
          ag.eBm();
        }
        if ((ag.eBl() != null) && (ag.eBl().length != 0)) {
          break label176;
        }
        ac.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost sOauthHostPaths nil");
      }
      label272:
      for (;;)
      {
        paramInt = 0;
        if (paramInt == 0) {
          break label274;
        }
        AppMethodBeat.o(188332);
        return true;
        paramInt = 0;
        break;
        label176:
        paramString = Uri.parse(paramString);
        paramString = paramString.getAuthority() + paramString.getPath();
        if (bs.isNullOrNil(paramString))
        {
          ac.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost target nil");
        }
        else
        {
          ac.d("MicroMsg.OauthAuthorizeLogic", "isOauthHost target:%s", new Object[] { paramString });
          paramInt = 0;
          for (;;)
          {
            if (paramInt >= ag.eBl().length) {
              break label272;
            }
            if (paramString.equalsIgnoreCase(ag.eBl()[paramInt]))
            {
              paramInt = 1;
              break;
            }
            paramInt += 1;
          }
        }
      }
      label274:
      AppMethodBeat.o(188332);
      return false;
    }
  }
  
  public static abstract interface c
  {
    public abstract void aAW(String paramString);
    
    public abstract void cdf();
    
    public abstract void d(DialogInterface.OnCancelListener paramOnCancelListener);
    
    public abstract void goBack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ag
 * JD-Core Version:    0.7.0.1
 */