package com.tencent.mm.plugin.qrcode.model;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ag;
import com.tencent.mm.autogen.a.kw;
import com.tencent.mm.autogen.a.kw.b;
import com.tencent.mm.autogen.a.qw;
import com.tencent.mm.autogen.a.wd;
import com.tencent.mm.autogen.a.we;
import com.tencent.mm.autogen.a.wf;
import com.tencent.mm.autogen.mmdata.rpt.uo;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.openim.api.OpenIMKefuStartConversationRequest;
import com.tencent.mm.openim.api.h.a;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.appbrand.service.u;
import com.tencent.mm.plugin.emojicapture.api.a.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.model.at;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.VcardContactUI;
import com.tencent.mm.plugin.scanner.util.t;
import com.tencent.mm.plugin.scanner.util.t.a;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.protocal.protobuf.cde;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.f.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class a
{
  private static final SparseIntArray NpX;
  private static final SparseIntArray NpY;
  private static final SparseIntArray NpZ;
  
  static
  {
    AppMethodBeat.i(51552);
    NpX = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(51545);
        paramAnonymousInt = super.get(paramAnonymousInt, 1011);
        AppMethodBeat.o(51545);
        return paramAnonymousInt;
      }
    };
    NpY = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(51547);
        paramAnonymousInt = super.get(paramAnonymousInt, 1047);
        AppMethodBeat.o(51547);
        return paramAnonymousInt;
      }
    };
    NpZ = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(51549);
        paramAnonymousInt = super.get(paramAnonymousInt, 1124);
        AppMethodBeat.o(51549);
        return paramAnonymousInt;
      }
    };
    AppMethodBeat.o(51552);
  }
  
  private static void a(Intent paramIntent, n paramn)
  {
    AppMethodBeat.i(260351);
    if (paramn.bLX() != null) {
      paramIntent.putExtra("scan_jspermission", new JsapiPermissionWrapper(paramn.bLX().aalV));
    }
    paramIntent.putExtra("scan_general_ctrl", new GeneralControlWrapper(paramn.bLX()));
    AppMethodBeat.o(260351);
  }
  
  private static void a(a.a parama, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(51551);
    Log.d("MicroMsg.scanner.GetA8KeyRedirect", "actionCode = %s, url = %s", new Object[] { Integer.valueOf(paramInt1), paramString });
    if (parama != null) {}
    for (Context localContext = parama.getContext(); localContext == null; localContext = null)
    {
      AppMethodBeat.o(51551);
      return;
    }
    final kw localkw = new kw();
    localkw.hMB.actionCode = paramInt1;
    localkw.hMB.result = paramString;
    localkw.hMB.context = localContext;
    paramString = new Bundle();
    paramString.putInt("pay_channel", paramInt2);
    localkw.hMB.hMD = paramString;
    localkw.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51543);
        if ((a.this == null) || (localkw == null) || (localkw.hMC == null))
        {
          AppMethodBeat.o(51543);
          return;
        }
        if (localkw.hMC.ret == 1)
        {
          a.this.AO(true);
          AppMethodBeat.o(51543);
          return;
        }
        if (localkw.hMC.ret == 2) {
          a.this.AO(false);
        }
        AppMethodBeat.o(51543);
      }
    };
    localkw.asyncPublish(Looper.myLooper());
    AppMethodBeat.o(51551);
  }
  
  public static boolean a(a.a parama, n paramn, DialogInterface.OnClickListener paramOnClickListener, String paramString, int paramInt1, int paramInt2, Runnable paramRunnable, Bundle paramBundle)
  {
    AppMethodBeat.i(51550);
    Context localContext = parama.getContext();
    if (localContext == null)
    {
      Log.e("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect, null redirectContext");
      AppMethodBeat.o(51550);
      return false;
    }
    int j = paramn.bLV();
    int i = ((cde)c.b.b(paramn.rr.otB)).ZiC;
    Log.i("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect actionCode : %s, codeType : %s, source: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt1) });
    Intent localIntent = new Intent();
    localIntent.putExtra("geta8key_scene", paramInt1);
    localIntent.putExtra("KPublisherId", "qrcode");
    localIntent.putExtra("prePublishId", "qrcode");
    com.tencent.mm.pluginsdk.wallet.h.setPayChannel(agh(paramInt1));
    boolean bool;
    switch (j)
    {
    case 5: 
    case 13: 
    case 19: 
    case 27: 
    case 28: 
    case 29: 
    case 31: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    default: 
      Log.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-not_catch: action code = " + paramn.bLV());
      AppMethodBeat.o(51550);
      return false;
    case 1: 
      Log.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-text: " + paramn.getContent());
      ((b)com.tencent.mm.kernel.h.ax(b.class)).aqa(paramn.getContent());
      localIntent.putExtra("data", paramn.getContent());
      localIntent.putExtra("showShare", false);
      if (paramInt2 == 2) {
        localIntent.putExtra("stastic_scene", 13);
      }
      for (;;)
      {
        localIntent.putExtra("pay_channel", agh(paramInt1));
        localIntent.putExtra("geta8key_session_id", paramn.bMc());
        a(localIntent, paramn);
        com.tencent.mm.plugin.scanner.m.dFc().h(localIntent, localContext);
        new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        if (paramInt2 == 1) {
          localIntent.putExtra("stastic_scene", 14);
        } else {
          localIntent.putExtra("stastic_scene", 11);
        }
      }
    case 2: 
      Log.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview: " + paramn.bLT());
      i = l.i.OKJ;
      if (!Util.isNullOrNil(paramString)) {}
      for (;;)
      {
        k.a(localContext, localContext.getString(i, new Object[] { paramString }), localContext.getString(l.i.app_tip), new a.1(localIntent, paramn, paramInt2, paramInt1, localContext), paramOnClickListener);
        AppMethodBeat.o(51550);
        return true;
        paramString = paramn.bLT();
      }
    case 7: 
    case 30: 
      Log.i("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview_no_notice: reqUrl : %s,  fullUrl : %s, shareUrl : %s", new Object[] { paramn.bLU(), paramn.bLT(), paramn.bLY() });
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yNr, 0) == 1) {
        bool = true;
      }
      break;
    }
    for (;;)
    {
      Log.i("MicroMsg.scanner.GetA8KeyRedirect", "webViewUseOuterGetA8key:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {}
      try
      {
        parama = (cdf)c.c.b(paramn.rr.otC);
        localIntent.putExtra("key_scan_qr_code_get_a8key_req", ((cde)c.b.b(paramn.rr.otB)).toByteArray());
        localIntent.putExtra("key_scan_qr_code_get_a8key_resp", parama.toByteArray());
        localIntent.putExtra("title", paramn.getTitle());
        localIntent.putExtra("rawUrl", paramn.bLT());
        localIntent.putExtra("k_share_url", paramn.bLY());
        if (paramInt2 == 2) {
          localIntent.putExtra("stastic_scene", 13);
        }
        Object localObject1;
        for (;;)
        {
          i = 0;
          if (paramInt2 == 2)
          {
            i = com.tencent.mm.plugin.appbrand.launching.d.n(1012, paramBundle);
            localIntent.putExtra("code_scene", i);
          }
          paramInt2 = agh(paramInt1);
          Log.i("MicroMsg.scanner.GetA8KeyRedirect", "start webview with channel : " + paramInt2 + " codeScene : " + i);
          localIntent.putExtra("pay_channel", agh(paramInt1));
          localIntent.putExtra("geta8key_session_id", paramn.bMc());
          localIntent.putExtra("geta8key_cookie", paramn.bMe());
          parama = paramn.bMb();
          if (Util.isNullOrNil(parama)) {
            break label1217;
          }
          paramOnClickListener = parama.iterator();
          do
          {
            if (!paramOnClickListener.hasNext()) {
              break;
            }
            localObject1 = (dam)paramOnClickListener.next();
          } while ((localObject1 != null) && (!Util.isNullOrNil(((dam)localObject1).ILw)) && (!Util.isNullOrNil(((dam)localObject1).OzQ)));
          Log.e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
          paramInt1 = 1;
          if (paramInt1 != 0) {
            break label1217;
          }
          paramOnClickListener = new String[parama.size()];
          localObject1 = new String[parama.size()];
          paramInt1 = 0;
          while (paramInt1 < parama.size())
          {
            Object localObject2 = (dam)parama.get(paramInt1);
            String str = ((dam)localObject2).ILw;
            localObject2 = ((dam)localObject2).OzQ;
            Log.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", new Object[] { Integer.valueOf(paramInt1), str, localObject2 });
            paramOnClickListener[paramInt1] = str;
            localObject1[paramInt1] = localObject2;
            paramInt1 += 1;
          }
          bool = false;
          break;
          if (paramInt2 == 1) {
            localIntent.putExtra("stastic_scene", 14);
          } else {
            localIntent.putExtra("stastic_scene", 11);
          }
        }
        localIntent.putExtra("geta8key_result_http_header_key_list", paramOnClickListener);
        localIntent.putExtra("geta8key_result_http_header_value_list", (String[])localObject1);
        localIntent.putExtra("k_has_http_header", true);
        label1217:
        if ((j == 30) && (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yMC, 1) == 1))
        {
          localIntent.putExtra("auth_raw_url", paramString);
          localIntent.putExtra("auth_from_scan", true);
          com.tencent.mm.br.c.b(localContext, "webview", ".ui.tools.SDKOAuthUI", localIntent);
          new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
          AppMethodBeat.o(51550);
          return true;
        }
        if ((paramBundle != null) && (paramBundle.getString("stat_send_msg_user") != null)) {
          localIntent.putExtra(f.s.adxd, paramBundle.getString("stat_send_msg_user"));
        }
        localIntent.putExtra("key_enable_teen_mode_check", true);
        a(localIntent, paramn);
        com.tencent.mm.plugin.scanner.m.dFc().h(localIntent, localContext);
        new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        Log.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-special_webview: " + paramn.bLT());
        localIntent.putExtra("rawUrl", paramn.bLT());
        localIntent.putExtra("pay_channel", agh(paramInt1));
        localIntent.putExtra("showShare", false);
        localIntent.putExtra("show_bottom", false);
        localIntent.putExtra("isWebwx", false);
        localIntent.putExtra("geta8key_session_id", paramn.bMc());
        localIntent.putExtra("geta8key_cookie", paramn.bMe());
        localIntent.putExtra("key_enable_teen_mode_check", true);
        a(localIntent, paramn);
        com.tencent.mm.plugin.scanner.m.dFc().h(localIntent, localContext);
        AppMethodBeat.o(51550);
        return true;
        AppMethodBeat.o(51550);
        return false;
        paramn = paramn.bLT();
        Log.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app: ".concat(String.valueOf(paramn)));
        if ((paramn == null) || (paramn.length() == 0))
        {
          Log.e("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app, fullUrl is null");
          AppMethodBeat.o(51550);
          return false;
        }
        parama = localContext.getString(l.i.OKI);
        if (paramn.startsWith("http")) {
          parama = localContext.getString(l.i.OKJ, new Object[] { paramn });
        }
        paramn = Uri.parse(paramn);
        if (paramn != null)
        {
          paramn = new Intent("android.intent.action.VIEW", paramn);
          paramn.addFlags(268435456);
          if (Util.isIntentAvailable(localContext, paramn))
          {
            k.a(localContext, parama, localContext.getString(l.i.app_tip), false, new a.2(localContext, paramn), paramOnClickListener);
            AppMethodBeat.o(51550);
            return true;
          }
        }
        AppMethodBeat.o(51550);
        return false;
        paramn = paramn.getContent();
        Log.d("MicroMsg.scanner.GetA8KeyRedirect", "get vcard from server: ".concat(String.valueOf(paramn)));
        if (!Util.isNullOrNil(paramn)) {
          paramString = new at();
        }
        try
        {
          paramString.aUQ(paramn);
          paramString = new Intent(localContext, VcardContactUI.class);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aYi(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.AO(false);
          AppMethodBeat.o(51550);
          return true;
        }
        catch (XmlPullParserException parama)
        {
          Log.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + parama.getMessage() + " " + paramn);
          Log.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", parama, "", new Object[0]);
          k.a(localContext, localContext.getString(l.i.OKL), localContext.getString(l.i.app_tip), false, paramOnClickListener);
          AppMethodBeat.o(51550);
          return true;
        }
        catch (IOException parama)
        {
          for (;;)
          {
            Log.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + parama.getMessage() + " " + paramn);
            Log.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", parama, "", new Object[0]);
          }
        }
        Log.d("MicroMsg.scanner.GetA8KeyRedirect", "ftf pay url:" + paramn.bLT());
        f.a(localContext, 1, paramn.bLT(), agh(paramInt1), null);
        new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        parama = new Bundle();
        parama.putInt("key_scene", 5);
        bool = com.tencent.mm.plugin.scanner.m.dFc().b(localContext, paramn.bLT(), parama);
        AppMethodBeat.o(51550);
        return bool;
        a(parama, j, paramn.bLT(), agh(paramInt1));
        new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        a(parama, j, paramn.bLT(), agh(paramInt1));
        AppMethodBeat.o(51550);
        return true;
        if (paramString.contains("livescreencast"))
        {
          parama = paramString.split("ticket_s=")[1];
          paramn = new wf();
          paramn.hZQ.hFb = parama;
          paramn.publish();
          new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
          AppMethodBeat.o(51550);
          return true;
        }
        AppMethodBeat.o(51550);
        return false;
        paramn = paramn.bLT();
        parama = paramn;
        if (paramn != null) {
          parama = paramn.replace("wxpd://", "");
        }
        paramn = new Intent();
        paramn.putExtra("key_product_id", parama);
        paramn.putExtra("key_product_scene", 7);
        com.tencent.mm.br.c.b(localContext, "product", ".ui.MallProductUI", paramn);
        AppMethodBeat.o(51550);
        return true;
        parama = new Intent();
        parama.setClass(localContext, ProductUI.class);
        parama.putExtra("key_ProductUI_getProductInfoScene", 5);
        parama.putExtra("key_Qrcode_Url", paramn.bLT());
        if (localContext != null)
        {
          parama = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, parama.aYi(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)parama.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(51550);
        return true;
        paramOnClickListener = paramn.bLT();
        parama = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService");
        paramn = Util.createExplicitFromImplicitIntent(MMApplicationContext.getContext(), parama);
        if (paramn != null) {
          parama = paramn;
        }
        for (;;)
        {
          com.tencent.mm.br.c.startService(parama.putExtra("url", paramOnClickListener).putExtra("isFromWifi", true));
          Log.d("MicroMsg.scanner.GetA8KeyRedirect", "GET_CONNECT_INFO start end");
          AppMethodBeat.o(51550);
          return true;
        }
        parama = t.aVm(paramn.bLT());
        if (parama == null) {
          Log.e("MicroMsg.scanner.GetA8KeyRedirect", "item == null");
        }
        for (;;)
        {
          AppMethodBeat.o(51550);
          return false;
          if (t.Ii(parama.tNW)) {
            break;
          }
          if (localContext != null) {
            t.bK(localContext, localContext.getString(l.i.card_not_support_card_type));
          }
        }
        paramn = new Intent();
        paramn.putExtra("key_card_id", parama.wsy);
        paramn.putExtra("key_card_ext", parama.iaJ);
        paramn.putExtra("key_from_scene", 0);
        if (paramInt2 == 2) {
          paramn.putExtra("key_stastic_scene", 13);
        }
        for (;;)
        {
          com.tencent.mm.br.c.b(localContext, "card", ".ui.CardDetailUI", paramn);
          Log.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_CARD start end");
          break;
          if (paramInt2 == 1) {
            paramn.putExtra("key_stastic_scene", 14);
          } else {
            paramn.putExtra("key_stastic_scene", 11);
          }
        }
        parama = paramn.bLT();
        paramn = t.aVn(parama);
        if ((paramn == null) || (paramn.size() == 0)) {
          Log.e("MicroMsg.scanner.GetA8KeyRedirect", "list == null || list.size() == 0");
        }
        for (;;)
        {
          AppMethodBeat.o(51550);
          return false;
          if ((t.by(paramn)) || (localContext == null)) {
            break;
          }
          t.bK(localContext, localContext.getString(l.i.card_not_support_card_type));
        }
        paramn = new Intent();
        paramn.putExtra("key_from_scene", 0);
        paramn.putExtra("src_username", "");
        paramn.putExtra("js_url", "");
        paramn.putExtra("key_in_card_list", parama);
        if (paramInt2 == 2) {
          paramn.putExtra("key_stastic_scene", 13);
        }
        for (;;)
        {
          com.tencent.mm.br.c.b(localContext, "card", ".ui.CardAddEntranceUI", paramn);
          Log.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_MULTIPLE_CARD start end");
          break;
          if (paramInt2 == 1) {
            paramn.putExtra("key_stastic_scene", 14);
          } else {
            paramn.putExtra("key_stastic_scene", 11);
          }
        }
        Log.w("MicroMsg.scanner.GetA8KeyRedirect", "freewifi had Deprecated");
        AppMethodBeat.o(51550);
        return true;
        Log.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-emoticon full url: " + paramn.bLT());
        parama = new com.tencent.mm.modelemoji.c(paramn.bLT());
        com.tencent.mm.kernel.h.aZW().a(parama, 0);
        AppMethodBeat.o(51550);
        return true;
        if (!WeChatBrands.Business.Entries.DiscoveryScanExtDevice.checkAvailable(localContext, new a.3(paramOnClickListener)))
        {
          AppMethodBeat.o(51550);
          return true;
        }
        parama = new wd();
        parama.hZN.hZO = paramString;
        parama.publish();
        AppMethodBeat.o(51550);
        return true;
        parama = new we();
        parama.hZP.hZO = paramString;
        parama.hZP.deviceName = com.tencent.mm.protocal.d.Yxf;
        parama.publish();
        new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        parama = paramn.bLT();
        if (Util.isNullOrNil(parama))
        {
          Log.e("MicroMsg.scanner.GetA8KeyRedirect", "onStartCommand url is null");
          AppMethodBeat.o(51550);
          return true;
        }
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "summerbak start url, url:%s", new Object[] { parama });
        paramn = new ag();
        paramn.hAb.url = parama;
        paramn.publish();
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "publish BackupGetA8keyRedirectEvent");
        AppMethodBeat.o(51550);
        return true;
        paramOnClickListener = paramn.bLT();
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "fullURL: ".concat(String.valueOf(paramOnClickListener)));
        paramRunnable = paramn.oSo;
        paramRunnable.putLong("CgiSpeedOutSideStructResponseSize", ((cdf)c.c.b(paramn.rr.otC)).computeSize());
        paramRunnable.putInt("CgiSpeedOutSideStructBizRet", ((cdf)c.c.b(paramn.rr.otC)).BaseResponse.Idd);
        paramRunnable.putString("CgiSpeedOutSideStructNetworkType", ((p)com.tencent.mm.kernel.h.ax(p.class)).getNetworkType());
        paramString = new Bundle();
        paramString.putBundle("stat_get_a8_key_cgi_speed", paramRunnable);
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "processAppBrandFullURL, fullURL: ".concat(String.valueOf(paramOnClickListener)));
        paramn = Uri.parse(paramOnClickListener);
        if ((paramn.getQueryParameter("search_query") != null) && (paramn.getQueryParameter("search_query").length() > 0))
        {
          paramString = paramn.getQueryParameter("search_query");
          paramRunnable = paramn.getQueryParameter("appid");
          paramBundle = paramn.getQueryParameter("search_extInfo");
          paramInt1 = Util.getInt(paramn.getQueryParameter("debug"), 0);
          paramInt2 = Util.getInt(paramn.getQueryParameter("version"), 0);
          paramn = new qw();
          paramn.hTT.scene = 1;
          paramn.hTT.appId = paramRunnable;
          paramn.hTT.type = paramInt1;
          paramn.hTT.version = paramInt2;
          paramn.hTT.hTU = paramString;
          paramn.hTT.url = paramOnClickListener;
          paramn.hTT.hTV = paramBundle;
          paramn.publish();
          paramn = aj.ipS();
          paramn.putExtra("ftsbizscene", 99999);
          paramn.putExtra("ftsQuery", paramString);
          paramn.putExtra("ftsqrcodestring", paramOnClickListener);
          paramOnClickListener = aj.r(300, false, 262144);
          paramOnClickListener.put("query", paramString);
          paramString = aj.asV(Util.safeParseInt((String)paramOnClickListener.get("scene")));
          paramOnClickListener.put("sessionid", paramString);
          paramn.putExtra("rawUrl", aj.bo(paramOnClickListener));
          paramn.putExtra("key_session_id", paramString);
          com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.fts.FTSWebViewUI", paramn);
          parama.AO(false);
          AppMethodBeat.o(51550);
          return true;
        }
        if (Util.getInt(paramn.getQueryParameter("qr_type4wxa"), 0) == 2) {
          paramn = NpZ;
        }
        for (;;)
        {
          paramInt1 = paramn.get(paramInt2);
          ((u)com.tencent.mm.kernel.h.ax(u.class)).b(localContext, paramOnClickListener, paramInt1, paramBundle, paramString);
          break;
          switch (i)
          {
          default: 
            paramn = NpX;
            break;
          case 22: 
            paramn = NpY;
          }
        }
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "jump to forceNotify UI");
        if (localContext != null)
        {
          localIntent.putExtra("data", paramn.bLU());
          localIntent.setClassName(localContext, "com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI");
          parama.AO(false);
          parama = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, parama.aYi(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)parama.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(51550);
        return true;
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect: %s, %s", new Object[] { paramString, paramn.bLT() });
        paramn = paramn.bLT();
        if (localContext != null) {
          ((com.tencent.mm.plugin.emojicapture.api.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emojicapture.api.a.class)).prepareStickerPreview(localContext, paramn, new a.b()
          {
            public final void onResult(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(51541);
              a.this.AO(paramAnonymousBoolean);
              AppMethodBeat.o(51541);
            }
          });
        }
        AppMethodBeat.o(51550);
        return true;
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect: %s, %s", new Object[] { paramString, paramn.bLT() });
        paramn = paramn.bLT();
        if (localContext != null) {
          ((com.tencent.mm.plugin.emojicapture.api.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emojicapture.api.a.class)).prepareEmojiCapture(localContext, paramn, new a.b()
          {
            public final void onResult(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(51542);
              a.this.AO(paramAnonymousBoolean);
              AppMethodBeat.o(51542);
            }
          });
        }
        AppMethodBeat.o(51550);
        return true;
        if (localContext != null) {
          ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).gotoRedPacketPreviewUI(localContext, paramString);
        }
        parama.AO(false);
        AppMethodBeat.o(51550);
        return true;
        parama = new Intent();
        parama.putExtra("key_qrcode_string", paramn.bLT());
        com.tencent.mm.br.c.b(localContext, "account", ".friend.ui.RecoverAccountUI1", parama);
        new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        parama = new uo();
        parama.ipB = 1;
        parama.bMH();
        AppMethodBeat.o(51550);
        return true;
        paramn = paramn.bLT();
        paramOnClickListener = new OpenIMKefuStartConversationRequest();
        paramOnClickListener.hBk = System.currentTimeMillis();
        paramOnClickListener.prw = 1;
        paramOnClickListener.context = parama.getContext();
        paramOnClickListener.pry = new du();
        paramOnClickListener.pry.url = paramn;
        paramOnClickListener.pry.YFV = paramn;
        paramOnClickListener.prD = true;
        paramOnClickListener.prz = true;
        paramOnClickListener.prA = paramOnClickListener.context.getString(l.i.open_im_kefu_start_conversation_error_tips);
        paramOnClickListener.prx = h.a.xD(paramOnClickListener.prw);
        paramOnClickListener.prB = true;
        paramOnClickListener.prF = new Intent();
        paramOnClickListener.prF.putExtra("key_result_receiver", new OpenCustomerServiceChatResultReceiver(MMHandler.createFreeHandler(Looper.getMainLooper()), parama, paramRunnable));
        ((com.tencent.mm.openim.api.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.d.class)).a(paramOnClickListener);
        AppMethodBeat.o(51550);
        return true;
      }
      catch (IOException parama)
      {
        for (;;)
        {
          continue;
          paramInt1 = 0;
        }
      }
    }
  }
  
  protected static int agh(int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qrcode.model.a
 * JD-Core Version:    0.7.0.1
 */