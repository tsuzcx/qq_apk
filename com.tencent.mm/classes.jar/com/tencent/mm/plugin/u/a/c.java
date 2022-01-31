package com.tencent.mm.plugin.u.a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.g.a.x;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.k;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.VcardContactUI;
import com.tencent.mm.plugin.scanner.util.t.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.aff;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class c
{
  private static final SparseIntArray pPu;
  private static final SparseIntArray pPv;
  private static final SparseIntArray pPw;
  
  static
  {
    AppMethodBeat.i(80769);
    pPu = new c.5();
    pPv = new c.6();
    pPw = new c.7();
    AppMethodBeat.o(80769);
  }
  
  protected static int Cd(int paramInt)
  {
    if ((paramInt == 30) || (paramInt == 37) || (paramInt == 38) || (paramInt == 40)) {
      return 13;
    }
    if ((paramInt == 4) || (paramInt == 47)) {
      return 12;
    }
    if (paramInt == 34) {
      return 24;
    }
    return 0;
  }
  
  private static void a(c.a parama, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(80768);
    ab.d("MicroMsg.scanner.GetA8KeyRedirect", "actionCode = %s, url = %s", new Object[] { Integer.valueOf(paramInt1), paramString });
    hf localhf = new hf();
    localhf.cwn.actionCode = paramInt1;
    localhf.cwn.result = paramString;
    localhf.cwn.context = parama.getContext();
    paramString = new Bundle();
    paramString.putInt("pay_channel", paramInt2);
    localhf.cwn.cwp = paramString;
    localhf.callback = new c.4(parama, localhf);
    com.tencent.mm.sdk.b.a.ymk.a(localhf, Looper.myLooper());
    AppMethodBeat.o(80768);
  }
  
  public static boolean a(c.a parama, com.tencent.mm.modelsimple.j paramj, DialogInterface.OnClickListener paramOnClickListener, String paramString, int paramInt1, int paramInt2, Runnable paramRunnable, Bundle paramBundle)
  {
    AppMethodBeat.i(80767);
    if (parama.getContext() == null)
    {
      ab.e("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect, null redirectContext");
      AppMethodBeat.o(80767);
      return false;
    }
    int i = paramj.ajn();
    int j = ((aff)paramj.rr.fsV.fta).wJM;
    ab.i("MicroMsg.scanner.GetA8KeyRedirect", "actionCode : %s, codeType : %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    ab.i("MicroMsg.scanner.GetA8KeyRedirect", "source=".concat(String.valueOf(paramInt1)));
    Intent localIntent = new Intent();
    localIntent.putExtra("geta8key_scene", paramInt1);
    localIntent.putExtra("KPublisherId", "qrcode");
    localIntent.putExtra("prePublishId", "qrcode");
    com.tencent.mm.pluginsdk.wallet.j.Mx(Cd(paramInt1));
    switch (i)
    {
    case 5: 
    case 13: 
    case 19: 
    case 27: 
    case 28: 
    case 29: 
    case 31: 
    default: 
      ab.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-not_catch: action code = " + paramj.ajn());
      AppMethodBeat.o(80767);
      return false;
    case 1: 
      ab.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-text: " + paramj.getContent());
      localIntent.putExtra("data", paramj.getContent());
      localIntent.putExtra("showShare", false);
      if (paramInt2 == 2) {
        localIntent.putExtra("stastic_scene", 13);
      }
      for (;;)
      {
        localIntent.putExtra("pay_channel", Cd(paramInt1));
        localIntent.putExtra("geta8key_session_id", paramj.ajt());
        com.tencent.mm.plugin.scanner.c.gmO.i(localIntent, parama.getContext());
        new ak(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(80767);
        return true;
        if (paramInt2 == 1) {
          localIntent.putExtra("stastic_scene", 14);
        } else {
          localIntent.putExtra("stastic_scene", 11);
        }
      }
    case 2: 
      ab.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview: " + paramj.ajl());
      paramRunnable = parama.getContext();
      paramBundle = parama.getContext();
      if (!bo.isNullOrNil(paramString)) {}
      for (;;)
      {
        com.tencent.mm.ui.base.h.a(paramRunnable, paramBundle.getString(2131302238, new Object[] { paramString }), parama.getContext().getString(2131297087), new c.1(localIntent, paramj, paramInt2, paramInt1, parama), paramOnClickListener);
        AppMethodBeat.o(80767);
        return true;
        paramString = paramj.ajl();
      }
    case 7: 
    case 30: 
      ab.i("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview_no_notice: reqUrl : %s,  fullUrl : %s, shareUrl : %s", new Object[] { paramj.ajm(), paramj.ajl(), paramj.ajp() });
      localIntent.putExtra("title", paramj.getTitle());
      localIntent.putExtra("rawUrl", paramj.ajl());
      localIntent.putExtra("k_share_url", paramj.ajp());
      if (paramInt2 == 2)
      {
        localIntent.putExtra("stastic_scene", 13);
        ab.i("MicroMsg.scanner.GetA8KeyRedirect", "start webview with channel : ".concat(String.valueOf(Cd(paramInt1))));
        localIntent.putExtra("pay_channel", Cd(paramInt1));
        localIntent.putExtra("geta8key_session_id", paramj.ajt());
        localIntent.putExtra("geta8key_cookie", paramj.ajv());
        paramj = paramj.ajs();
        if (bo.es(paramj)) {
          break label992;
        }
        paramOnClickListener = paramj.iterator();
        while (paramOnClickListener.hasNext())
        {
          paramBundle = (avl)paramOnClickListener.next();
          if ((paramBundle == null) || (bo.isNullOrNil(paramBundle.wxP)) || (bo.isNullOrNil(paramBundle.qsu))) {
            ab.e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
          }
        }
      }
      break;
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0)
      {
        paramOnClickListener = new String[paramj.size()];
        paramBundle = new String[paramj.size()];
        paramInt1 = 0;
        for (;;)
        {
          if (paramInt1 < paramj.size())
          {
            Object localObject = (avl)paramj.get(paramInt1);
            String str = ((avl)localObject).wxP;
            localObject = ((avl)localObject).qsu;
            ab.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", new Object[] { Integer.valueOf(paramInt1), str, localObject });
            paramOnClickListener[paramInt1] = str;
            paramBundle[paramInt1] = localObject;
            paramInt1 += 1;
            continue;
            if (paramInt2 == 1)
            {
              localIntent.putExtra("stastic_scene", 14);
              break;
            }
            localIntent.putExtra("stastic_scene", 11);
            break;
          }
        }
        localIntent.putExtra("geta8key_result_http_header_key_list", paramOnClickListener);
        localIntent.putExtra("geta8key_result_http_header_value_list", paramBundle);
        localIntent.putExtra("k_has_http_header", true);
      }
      label992:
      if ((i == 30) && (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUo, 0) == 1))
      {
        localIntent.putExtra("auth_raw_url", paramString);
        localIntent.putExtra("auth_from_scan", true);
        d.b(parama.getContext(), "webview", ".ui.tools.SDKOAuthUI", localIntent);
        new ak(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(80767);
        return true;
      }
      com.tencent.mm.plugin.scanner.c.gmO.i(localIntent, parama.getContext());
      new ak(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
      AppMethodBeat.o(80767);
      return true;
      ab.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-special_webview: " + paramj.ajl());
      localIntent.putExtra("rawUrl", paramj.ajl());
      localIntent.putExtra("pay_channel", Cd(paramInt1));
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("isWebwx", false);
      localIntent.putExtra("geta8key_session_id", paramj.ajt());
      localIntent.putExtra("geta8key_cookie", paramj.ajv());
      com.tencent.mm.plugin.scanner.c.gmO.i(localIntent, parama.getContext());
      AppMethodBeat.o(80767);
      return true;
      AppMethodBeat.o(80767);
      return false;
      paramString = paramj.ajl();
      ab.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app: ".concat(String.valueOf(paramString)));
      if ((paramString == null) || (paramString.length() == 0))
      {
        ab.e("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app, fullUrl is null");
        AppMethodBeat.o(80767);
        return false;
      }
      paramj = parama.getContext().getString(2131302237);
      if (paramString.startsWith("http")) {
        paramj = parama.getContext().getString(2131302238, new Object[] { paramString });
      }
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = new Intent("android.intent.action.VIEW", paramString);
        paramString.addFlags(268435456);
        if (bo.k(parama.getContext(), paramString))
        {
          com.tencent.mm.ui.base.h.a(parama.getContext(), paramj, parama.getContext().getString(2131297087), false, new c.2(parama, paramString), paramOnClickListener);
          AppMethodBeat.o(80767);
          return true;
        }
      }
      AppMethodBeat.o(80767);
      return false;
      paramj = paramj.getContent();
      ab.d("MicroMsg.scanner.GetA8KeyRedirect", "get vcard from server: ".concat(String.valueOf(paramj)));
      if (!bo.isNullOrNil(paramj)) {
        paramString = new com.tencent.mm.plugin.scanner.model.t();
      }
      try
      {
        paramString.Yy(paramj);
        paramString = new Intent(parama.getContext(), VcardContactUI.class);
        parama.getContext().startActivity(paramString);
        parama.kn(false);
        AppMethodBeat.o(80767);
        return true;
      }
      catch (XmlPullParserException paramString)
      {
        ab.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + paramString.getMessage() + " " + paramj);
        ab.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", paramString, "", new Object[0]);
        com.tencent.mm.ui.base.h.a(parama.getContext(), parama.getContext().getString(2131302247), parama.getContext().getString(2131297087), false, paramOnClickListener);
        AppMethodBeat.o(80767);
        return true;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ab.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + paramString.getMessage() + " " + paramj);
          ab.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", paramString, "", new Object[0]);
        }
      }
      ab.d("MicroMsg.scanner.GetA8KeyRedirect", "ftf pay url:" + paramj.ajl());
      com.tencent.mm.pluginsdk.wallet.h.a(parama.getContext(), 1, paramj.ajl(), Cd(paramInt1), null);
      new ak(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
      AppMethodBeat.o(80767);
      return true;
      paramOnClickListener = new Bundle();
      paramOnClickListener.putInt("key_scene", 5);
      boolean bool = com.tencent.mm.plugin.scanner.c.gmO.b(parama.getContext(), paramj.ajl(), paramOnClickListener);
      AppMethodBeat.o(80767);
      return bool;
      a(parama, i, paramj.ajl(), Cd(paramInt1));
      new ak(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
      AppMethodBeat.o(80767);
      return true;
      a(parama, i, paramj.ajl(), Cd(paramInt1));
      AppMethodBeat.o(80767);
      return true;
      paramOnClickListener = paramj.ajl();
      paramj = paramOnClickListener;
      if (paramOnClickListener != null) {
        paramj = paramOnClickListener.replace("wxpd://", "");
      }
      paramOnClickListener = new Intent();
      paramOnClickListener.putExtra("key_product_id", paramj);
      paramOnClickListener.putExtra("key_product_scene", 7);
      d.b(parama.getContext(), "product", ".ui.MallProductUI", paramOnClickListener);
      AppMethodBeat.o(80767);
      return true;
      paramOnClickListener = new Intent();
      paramOnClickListener.setClass(parama.getContext(), ProductUI.class);
      paramOnClickListener.putExtra("key_ProductUI_getProductInfoScene", 5);
      paramOnClickListener.putExtra("key_Qrcode_Url", paramj.ajl());
      parama.getContext().startActivity(paramOnClickListener);
      AppMethodBeat.o(80767);
      return true;
      paramOnClickListener = paramj.ajl();
      parama = new Intent().setClassName(ah.getContext(), "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService");
      paramj = bo.I(ah.getContext(), parama);
      if (paramj != null) {
        parama = paramj;
      }
      for (;;)
      {
        d.aG(parama.putExtra("url", paramOnClickListener).putExtra("isFromWifi", true));
        ab.d("MicroMsg.scanner.GetA8KeyRedirect", "GET_CONNECT_INFO start end");
        AppMethodBeat.o(80767);
        return true;
      }
      paramj = com.tencent.mm.plugin.scanner.util.t.YQ(paramj.ajl());
      if (paramj == null) {
        ab.e("MicroMsg.scanner.GetA8KeyRedirect", "item == null");
      }
      for (;;)
      {
        AppMethodBeat.o(80767);
        return false;
        if (com.tencent.mm.plugin.scanner.util.t.sX(paramj.iFL)) {
          break;
        }
        com.tencent.mm.plugin.scanner.util.t.aP(parama.getContext(), parama.getContext().getString(2131298005));
      }
      paramOnClickListener = new Intent();
      paramOnClickListener.putExtra("key_card_id", paramj.kml);
      paramOnClickListener.putExtra("key_card_ext", paramj.cHo);
      paramOnClickListener.putExtra("key_from_scene", 0);
      if (paramInt2 == 2) {
        paramOnClickListener.putExtra("key_stastic_scene", 13);
      }
      for (;;)
      {
        d.b(parama.getContext(), "card", ".ui.CardDetailUI", paramOnClickListener);
        ab.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_CARD start end");
        break;
        if (paramInt2 == 1) {
          paramOnClickListener.putExtra("key_stastic_scene", 14);
        } else {
          paramOnClickListener.putExtra("key_stastic_scene", 11);
        }
      }
      paramj = paramj.ajl();
      paramOnClickListener = com.tencent.mm.plugin.scanner.util.t.YR(paramj);
      if ((paramOnClickListener == null) || (paramOnClickListener.size() == 0)) {
        ab.e("MicroMsg.scanner.GetA8KeyRedirect", "list == null || list.size() == 0");
      }
      for (;;)
      {
        AppMethodBeat.o(80767);
        return false;
        if (com.tencent.mm.plugin.scanner.util.t.P(paramOnClickListener)) {
          break;
        }
        com.tencent.mm.plugin.scanner.util.t.aP(parama.getContext(), parama.getContext().getString(2131298005));
      }
      paramOnClickListener = new Intent();
      paramOnClickListener.putExtra("key_from_scene", 0);
      paramOnClickListener.putExtra("src_username", "");
      paramOnClickListener.putExtra("js_url", "");
      paramOnClickListener.putExtra("key_in_card_list", paramj);
      if (paramInt2 == 2) {
        paramOnClickListener.putExtra("key_stastic_scene", 13);
      }
      for (;;)
      {
        d.b(parama.getContext(), "card", ".ui.CardAddEntranceUI", paramOnClickListener);
        ab.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_MULTIPLE_CARD start end");
        break;
        if (paramInt2 == 1) {
          paramOnClickListener.putExtra("key_stastic_scene", 14);
        } else {
          paramOnClickListener.putExtra("key_stastic_scene", 11);
        }
      }
      paramRunnable = new Intent();
      paramRunnable.putExtra("free_wifi_url", paramj.ajl());
      paramString = (afg)paramj.rr.fsW.fta;
      if ((paramString == null) || (paramString.wkT == null))
      {
        ab.e("MicroMsg.NetSceneGetA8Key", "get mid failed");
        paramString = null;
        paramRunnable.putExtra("free_wifi_mid", paramString);
        paramString = (afg)paramj.rr.fsW.fta;
        if ((paramString != null) && (paramString.SSID != null)) {
          break label2618;
        }
        ab.e("MicroMsg.NetSceneGetA8Key", "get ssid failed");
        paramString = null;
        label2521:
        paramRunnable.putExtra("free_wifi_ssid", paramString);
        paramRunnable.putExtra("free_wifi_source", 1);
        paramRunnable.putExtra("free_wifi_ap_key", paramj.ajl());
        if (g.RL().Ru().get(303104, null) == null) {
          break label2626;
        }
        com.tencent.mm.ui.base.h.a(parama.getContext(), 2131300145, 2131297087, 2131296894, 2131296888, new c.3(parama, paramRunnable), paramOnClickListener);
      }
      for (;;)
      {
        AppMethodBeat.o(80767);
        return true;
        paramString = paramString.wkT;
        break;
        label2618:
        paramString = paramString.SSID;
        break label2521;
        label2626:
        d.b(parama.getContext(), "freewifi", ".ui.FreeWifiEntryUI", paramRunnable);
        parama.kn(false);
      }
      ab.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-emoticon full url: " + paramj.ajl());
      parama = new com.tencent.mm.ao.c(paramj.ajl());
      g.Rc().a(parama, 0);
      AppMethodBeat.o(80767);
      return true;
      parama = new qb();
      parama.cGD.cGE = paramString;
      com.tencent.mm.sdk.b.a.ymk.l(parama);
      AppMethodBeat.o(80767);
      return true;
      parama = paramj.ajl();
      if (bo.isNullOrNil(parama))
      {
        ab.e("MicroMsg.scanner.GetA8KeyRedirect", "onStartCommand url is null");
        AppMethodBeat.o(80767);
        return true;
      }
      ab.i("MicroMsg.scanner.GetA8KeyRedirect", "summerbak start url, url:%s", new Object[] { parama });
      paramj = new x();
      paramj.cnd.url = parama;
      com.tencent.mm.sdk.b.a.ymk.l(paramj);
      ab.i("MicroMsg.scanner.GetA8KeyRedirect", "publish BackupGetA8keyRedirectEvent");
      AppMethodBeat.o(80767);
      return true;
      paramOnClickListener = paramj.ajl();
      ab.i("MicroMsg.scanner.GetA8KeyRedirect", "fullURL: ".concat(String.valueOf(paramOnClickListener)));
      paramString = parama.getContext();
      ab.i("MicroMsg.scanner.GetA8KeyRedirect", "processAppBrandFullURL, fullURL: ".concat(String.valueOf(paramOnClickListener)));
      paramRunnable = Uri.parse(paramOnClickListener);
      if ((paramRunnable.getQueryParameter("search_query") != null) && (paramRunnable.getQueryParameter("search_query").length() > 0))
      {
        paramj = paramRunnable.getQueryParameter("search_query");
        paramString = paramRunnable.getQueryParameter("appid");
        paramBundle = paramRunnable.getQueryParameter("search_extInfo");
        paramInt1 = bo.getInt(paramRunnable.getQueryParameter("debug"), 0);
        paramInt2 = bo.getInt(paramRunnable.getQueryParameter("version"), 0);
        paramRunnable = new lq();
        paramRunnable.cBH.scene = 1;
        paramRunnable.cBH.appId = paramString;
        paramRunnable.cBH.type = paramInt1;
        paramRunnable.cBH.version = paramInt2;
        paramRunnable.cBH.cBI = paramj;
        paramRunnable.cBH.url = paramOnClickListener;
        paramRunnable.cBH.cBJ = paramBundle;
        com.tencent.mm.sdk.b.a.ymk.l(paramRunnable);
        paramString = aa.cZp();
        paramString.putExtra("ftsbizscene", 99999);
        paramString.putExtra("ftsQuery", paramj);
        paramString.putExtra("ftsqrcodestring", paramOnClickListener);
        paramOnClickListener = aa.d(300, false, 262144);
        paramOnClickListener.put("query", paramj);
        paramj = aa.IZ(bo.apV((String)paramOnClickListener.get("scene")));
        paramOnClickListener.put("sessionid", paramj);
        paramString.putExtra("rawUrl", aa.F(paramOnClickListener));
        paramString.putExtra("key_session_id", paramj);
        d.b(ah.getContext(), "webview", ".ui.tools.fts.FTSWebViewUI", paramString);
        parama.kn(false);
        AppMethodBeat.o(80767);
        return true;
      }
      if (bo.getInt(paramRunnable.getQueryParameter("qr_type4wxa"), 0) == 2) {
        paramj = pPw;
      }
      for (;;)
      {
        paramInt1 = paramj.get(paramInt2);
        ((k)g.E(k.class)).b(paramString, paramOnClickListener, paramInt1, paramBundle);
        break;
        switch (j)
        {
        default: 
          paramj = pPu;
          break;
        case 22: 
          paramj = pPv;
        }
      }
      ab.i("MicroMsg.scanner.GetA8KeyRedirect", "jump to forceNotify UI");
      localIntent.putExtra("data", paramj.ajm());
      localIntent.setClassName(parama.getContext(), "com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI");
      parama.kn(false);
      parama.getContext().startActivity(localIntent);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.u.a.c
 * JD-Core Version:    0.7.0.1
 */