package com.tencent.mm.plugin.v.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.aq.c;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.aa;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.g.a.ig.b;
import com.tencent.mm.g.a.nl;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.g.b.a.in;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.plugin.emojicapture.api.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.scanner.model.af;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.VcardContactUI;
import com.tencent.mm.plugin.scanner.util.o.a;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.bki;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.e.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class a
{
  private static final SparseIntArray wah;
  private static final SparseIntArray wai;
  private static final SparseIntArray waj;
  
  static
  {
    AppMethodBeat.i(51552);
    wah = new a.7();
    wai = new a.8();
    waj = new a.9();
    AppMethodBeat.o(51552);
  }
  
  protected static int LR(int paramInt)
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
  
  private static void a(a parama, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(51551);
    ac.d("MicroMsg.scanner.GetA8KeyRedirect", "actionCode = %s, url = %s", new Object[] { Integer.valueOf(paramInt1), paramString });
    final ig localig = new ig();
    localig.dju.actionCode = paramInt1;
    localig.dju.result = paramString;
    localig.dju.context = parama.getContext();
    paramString = new Bundle();
    paramString.putInt("pay_channel", paramInt2);
    localig.dju.djw = paramString;
    localig.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51543);
        if ((this.wam == null) || (localig == null) || (localig.djv == null))
        {
          AppMethodBeat.o(51543);
          return;
        }
        if (localig.djv.ret == 1)
        {
          this.wam.pe(true);
          AppMethodBeat.o(51543);
          return;
        }
        if (localig.djv.ret == 2) {
          this.wam.pe(false);
        }
        AppMethodBeat.o(51543);
      }
    };
    com.tencent.mm.sdk.b.a.GpY.a(localig, Looper.myLooper());
    AppMethodBeat.o(51551);
  }
  
  public static boolean a(final a parama, final k paramk, DialogInterface.OnClickListener paramOnClickListener, final String paramString, final int paramInt1, final int paramInt2, final Runnable paramRunnable, Bundle paramBundle)
  {
    AppMethodBeat.i(51550);
    if (parama.getContext() == null)
    {
      ac.e("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect, null redirectContext");
      AppMethodBeat.o(51550);
      return false;
    }
    int i = paramk.aHi();
    int j = ((arm)paramk.rr.hvr.hvw).EoF;
    ac.i("MicroMsg.scanner.GetA8KeyRedirect", "actionCode : %s, codeType : %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    ac.i("MicroMsg.scanner.GetA8KeyRedirect", "source=".concat(String.valueOf(paramInt1)));
    Intent localIntent = new Intent();
    localIntent.putExtra("geta8key_scene", paramInt1);
    localIntent.putExtra("KPublisherId", "qrcode");
    localIntent.putExtra("prePublishId", "qrcode");
    com.tencent.mm.pluginsdk.wallet.h.XB(LR(paramInt1));
    Object localObject1;
    switch (i)
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
      ac.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-not_catch: action code = " + paramk.aHi());
      AppMethodBeat.o(51550);
      return false;
    case 1: 
      ac.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-text: " + paramk.getContent());
      ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.a.class)).Zx(paramk.getContent());
      localIntent.putExtra("data", paramk.getContent());
      localIntent.putExtra("showShare", false);
      if (paramInt2 == 2) {
        localIntent.putExtra("stastic_scene", 13);
      }
      for (;;)
      {
        localIntent.putExtra("pay_channel", LR(paramInt1));
        localIntent.putExtra("geta8key_session_id", paramk.aHo());
        com.tencent.mm.plugin.scanner.g.iyx.i(localIntent, parama.getContext());
        new ao(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        if (paramInt2 == 1) {
          localIntent.putExtra("stastic_scene", 14);
        } else {
          localIntent.putExtra("stastic_scene", 11);
        }
      }
    case 2: 
      ac.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview: " + paramk.aHg());
      paramRunnable = parama.getContext();
      paramBundle = parama.getContext();
      if (!bs.isNullOrNil(paramString)) {}
      for (;;)
      {
        com.tencent.mm.ui.base.h.a(paramRunnable, paramBundle.getString(2131762117, new Object[] { paramString }), parama.getContext().getString(2131755906), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(51538);
            this.val$intent.putExtra("title", paramk.getTitle());
            this.val$intent.putExtra("rawUrl", paramk.aHg());
            if (paramInt2 == 2) {
              this.val$intent.putExtra("stastic_scene", 13);
            }
            for (;;)
            {
              this.val$intent.putExtra("pay_channel", a.LR(paramInt1));
              this.val$intent.putExtra("geta8key_session_id", paramk.aHo());
              this.val$intent.putExtra("geta8key_cookie", paramk.aHq());
              com.tencent.mm.plugin.scanner.g.iyx.i(this.val$intent, parama.getContext());
              AppMethodBeat.o(51538);
              return;
              if (paramInt2 == 1) {
                this.val$intent.putExtra("stastic_scene", 14);
              } else {
                this.val$intent.putExtra("stastic_scene", 11);
              }
            }
          }
        }, paramOnClickListener);
        AppMethodBeat.o(51550);
        return true;
        paramString = paramk.aHg();
      }
    case 7: 
    case 30: 
      ac.i("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview_no_notice: reqUrl : %s,  fullUrl : %s, shareUrl : %s", new Object[] { paramk.aHh(), paramk.aHg(), paramk.aHk() });
      localIntent.putExtra("title", paramk.getTitle());
      localIntent.putExtra("rawUrl", paramk.aHg());
      localIntent.putExtra("k_share_url", paramk.aHk());
      if (paramInt2 == 2)
      {
        localIntent.putExtra("stastic_scene", 13);
        ac.i("MicroMsg.scanner.GetA8KeyRedirect", "start webview with channel : ".concat(String.valueOf(LR(paramInt1))));
        localIntent.putExtra("pay_channel", LR(paramInt1));
        localIntent.putExtra("geta8key_session_id", paramk.aHo());
        localIntent.putExtra("geta8key_cookie", paramk.aHq());
        paramk = paramk.aHn();
        if (bs.gY(paramk)) {
          break label1057;
        }
        paramOnClickListener = paramk.iterator();
        while (paramOnClickListener.hasNext())
        {
          localObject1 = (bki)paramOnClickListener.next();
          if ((localObject1 == null) || (bs.isNullOrNil(((bki)localObject1).tlp)) || (bs.isNullOrNil(((bki)localObject1).wTM))) {
            ac.e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
          }
        }
      }
      break;
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0)
      {
        paramOnClickListener = new String[paramk.size()];
        localObject1 = new String[paramk.size()];
        paramInt1 = 0;
        for (;;)
        {
          if (paramInt1 < paramk.size())
          {
            Object localObject2 = (bki)paramk.get(paramInt1);
            String str = ((bki)localObject2).tlp;
            localObject2 = ((bki)localObject2).wTM;
            ac.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", new Object[] { Integer.valueOf(paramInt1), str, localObject2 });
            paramOnClickListener[paramInt1] = str;
            localObject1[paramInt1] = localObject2;
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
        localIntent.putExtra("geta8key_result_http_header_value_list", (String[])localObject1);
        localIntent.putExtra("k_has_http_header", true);
      }
      label1057:
      if ((i == 30) && (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pPv, 0) == 1))
      {
        localIntent.putExtra("auth_raw_url", paramString);
        localIntent.putExtra("auth_from_scan", true);
        d.b(parama.getContext(), "webview", ".ui.tools.SDKOAuthUI", localIntent);
        new ao(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
      }
      if ((paramBundle != null) && (paramBundle.getString("stat_send_msg_user") != null)) {
        localIntent.putExtra(e.m.HhI, paramBundle.getString("stat_send_msg_user"));
      }
      com.tencent.mm.plugin.scanner.g.iyx.i(localIntent, parama.getContext());
      new ao(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
      AppMethodBeat.o(51550);
      return true;
      ac.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-special_webview: " + paramk.aHg());
      localIntent.putExtra("rawUrl", paramk.aHg());
      localIntent.putExtra("pay_channel", LR(paramInt1));
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("isWebwx", false);
      localIntent.putExtra("geta8key_session_id", paramk.aHo());
      localIntent.putExtra("geta8key_cookie", paramk.aHq());
      com.tencent.mm.plugin.scanner.g.iyx.i(localIntent, parama.getContext());
      AppMethodBeat.o(51550);
      return true;
      AppMethodBeat.o(51550);
      return false;
      paramString = paramk.aHg();
      ac.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app: ".concat(String.valueOf(paramString)));
      if ((paramString == null) || (paramString.length() == 0))
      {
        ac.e("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app, fullUrl is null");
        AppMethodBeat.o(51550);
        return false;
      }
      paramk = parama.getContext().getString(2131762116);
      if (paramString.startsWith("http")) {
        paramk = parama.getContext().getString(2131762117, new Object[] { paramString });
      }
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = new Intent("android.intent.action.VIEW", paramString);
        paramString.addFlags(268435456);
        if (bs.ah(parama.getContext(), paramString))
        {
          com.tencent.mm.ui.base.h.a(parama.getContext(), paramk, parama.getContext().getString(2131755906), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(51539);
              paramAnonymousDialogInterface = this.wam.getContext();
              Object localObject = paramString;
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(51539);
            }
          }, paramOnClickListener);
          AppMethodBeat.o(51550);
          return true;
        }
      }
      AppMethodBeat.o(51550);
      return false;
      paramk = paramk.getContent();
      ac.d("MicroMsg.scanner.GetA8KeyRedirect", "get vcard from server: ".concat(String.valueOf(paramk)));
      if (!bs.isNullOrNil(paramk)) {
        paramString = new af();
      }
      try
      {
        paramString.arK(paramk);
        paramRunnable = new Intent(parama.getContext(), VcardContactUI.class);
        paramString = parama.getContext();
        paramRunnable = new com.tencent.mm.hellhoundlib.b.a().ba(paramRunnable);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, paramRunnable.aeD(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramRunnable.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.pe(false);
        AppMethodBeat.o(51550);
        return true;
      }
      catch (XmlPullParserException paramString)
      {
        ac.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + paramString.getMessage() + " " + paramk);
        ac.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", paramString, "", new Object[0]);
        com.tencent.mm.ui.base.h.a(parama.getContext(), parama.getContext().getString(2131762127), parama.getContext().getString(2131755906), false, paramOnClickListener);
        AppMethodBeat.o(51550);
        return true;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ac.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + paramString.getMessage() + " " + paramk);
          ac.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", paramString, "", new Object[0]);
        }
      }
      ac.d("MicroMsg.scanner.GetA8KeyRedirect", "ftf pay url:" + paramk.aHg());
      f.a(parama.getContext(), 1, paramk.aHg(), LR(paramInt1), null);
      new ao(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
      AppMethodBeat.o(51550);
      return true;
      paramOnClickListener = new Bundle();
      paramOnClickListener.putInt("key_scene", 5);
      boolean bool = com.tencent.mm.plugin.scanner.g.iyx.b(parama.getContext(), paramk.aHg(), paramOnClickListener);
      AppMethodBeat.o(51550);
      return bool;
      a(parama, i, paramk.aHg(), LR(paramInt1));
      new ao(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
      AppMethodBeat.o(51550);
      return true;
      a(parama, i, paramk.aHg(), LR(paramInt1));
      AppMethodBeat.o(51550);
      return true;
      paramOnClickListener = paramk.aHg();
      paramk = paramOnClickListener;
      if (paramOnClickListener != null) {
        paramk = paramOnClickListener.replace("wxpd://", "");
      }
      paramOnClickListener = new Intent();
      paramOnClickListener.putExtra("key_product_id", paramk);
      paramOnClickListener.putExtra("key_product_scene", 7);
      d.b(parama.getContext(), "product", ".ui.MallProductUI", paramOnClickListener);
      AppMethodBeat.o(51550);
      return true;
      paramOnClickListener = new Intent();
      paramOnClickListener.setClass(parama.getContext(), ProductUI.class);
      paramOnClickListener.putExtra("key_ProductUI_getProductInfoScene", 5);
      paramOnClickListener.putExtra("key_Qrcode_Url", paramk.aHg());
      parama = parama.getContext();
      paramk = new com.tencent.mm.hellhoundlib.b.a().ba(paramOnClickListener);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramk.aeD(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramk.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(51550);
      return true;
      paramOnClickListener = paramk.aHg();
      parama = new Intent().setClassName(ai.getContext(), "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService");
      paramk = bs.ai(ai.getContext(), parama);
      if (paramk != null) {
        parama = paramk;
      }
      for (;;)
      {
        d.aZ(parama.putExtra("url", paramOnClickListener).putExtra("isFromWifi", true));
        ac.d("MicroMsg.scanner.GetA8KeyRedirect", "GET_CONNECT_INFO start end");
        AppMethodBeat.o(51550);
        return true;
      }
      paramk = com.tencent.mm.plugin.scanner.util.o.arZ(paramk.aHg());
      if (paramk == null) {
        ac.e("MicroMsg.scanner.GetA8KeyRedirect", "item == null");
      }
      for (;;)
      {
        AppMethodBeat.o(51550);
        return false;
        if (com.tencent.mm.plugin.scanner.util.o.zG(paramk.lRv)) {
          break;
        }
        com.tencent.mm.plugin.scanner.util.o.aY(parama.getContext(), parama.getContext().getString(2131756947));
      }
      paramOnClickListener = new Intent();
      paramOnClickListener.putExtra("key_card_id", paramk.nUr);
      paramOnClickListener.putExtra("key_card_ext", paramk.dvP);
      paramOnClickListener.putExtra("key_from_scene", 0);
      if (paramInt2 == 2) {
        paramOnClickListener.putExtra("key_stastic_scene", 13);
      }
      for (;;)
      {
        d.b(parama.getContext(), "card", ".ui.CardDetailUI", paramOnClickListener);
        ac.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_CARD start end");
        break;
        if (paramInt2 == 1) {
          paramOnClickListener.putExtra("key_stastic_scene", 14);
        } else {
          paramOnClickListener.putExtra("key_stastic_scene", 11);
        }
      }
      paramk = paramk.aHg();
      paramOnClickListener = com.tencent.mm.plugin.scanner.util.o.asa(paramk);
      if ((paramOnClickListener == null) || (paramOnClickListener.size() == 0)) {
        ac.e("MicroMsg.scanner.GetA8KeyRedirect", "list == null || list.size() == 0");
      }
      for (;;)
      {
        AppMethodBeat.o(51550);
        return false;
        if (com.tencent.mm.plugin.scanner.util.o.ay(paramOnClickListener)) {
          break;
        }
        com.tencent.mm.plugin.scanner.util.o.aY(parama.getContext(), parama.getContext().getString(2131756947));
      }
      paramOnClickListener = new Intent();
      paramOnClickListener.putExtra("key_from_scene", 0);
      paramOnClickListener.putExtra("src_username", "");
      paramOnClickListener.putExtra("js_url", "");
      paramOnClickListener.putExtra("key_in_card_list", paramk);
      if (paramInt2 == 2) {
        paramOnClickListener.putExtra("key_stastic_scene", 13);
      }
      for (;;)
      {
        d.b(parama.getContext(), "card", ".ui.CardAddEntranceUI", paramOnClickListener);
        ac.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_MULTIPLE_CARD start end");
        break;
        if (paramInt2 == 1) {
          paramOnClickListener.putExtra("key_stastic_scene", 14);
        } else {
          paramOnClickListener.putExtra("key_stastic_scene", 11);
        }
      }
      paramRunnable = new Intent();
      paramRunnable.putExtra("free_wifi_url", paramk.aHg());
      paramString = (arn)paramk.rr.hvs.hvw;
      if ((paramString == null) || (paramString.DLy == null))
      {
        ac.e("MicroMsg.NetSceneGetA8Key", "get mid failed");
        paramString = null;
        paramRunnable.putExtra("free_wifi_mid", paramString);
        paramString = (arn)paramk.rr.hvs.hvw;
        if ((paramString != null) && (paramString.SSID != null)) {
          break label2860;
        }
        ac.e("MicroMsg.NetSceneGetA8Key", "get ssid failed");
        paramString = null;
        label2763:
        paramRunnable.putExtra("free_wifi_ssid", paramString);
        paramRunnable.putExtra("free_wifi_source", 1);
        paramRunnable.putExtra("free_wifi_ap_key", paramk.aHg());
        if (com.tencent.mm.kernel.g.agR().agA().get(303104, null) == null) {
          break label2868;
        }
        com.tencent.mm.ui.base.h.b(parama.getContext(), 2131759617, 2131755906, 2131755700, 2131755691, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(51540);
            d.b(this.wam.getContext(), "freewifi", ".ui.FreeWifiEntryUI", paramRunnable);
            this.wam.pe(false);
            AppMethodBeat.o(51540);
          }
        }, paramOnClickListener);
      }
      for (;;)
      {
        AppMethodBeat.o(51550);
        return true;
        paramString = paramString.DLy;
        break;
        label2860:
        paramString = paramString.SSID;
        break label2763;
        label2868:
        d.b(parama.getContext(), "freewifi", ".ui.FreeWifiEntryUI", paramRunnable);
        parama.pe(false);
      }
      ac.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-emoticon full url: " + paramk.aHg());
      parama = new c(paramk.aHg());
      com.tencent.mm.kernel.g.agi().a(parama, 0);
      AppMethodBeat.o(51550);
      return true;
      parama = new sc();
      parama.dvc.dvd = paramString;
      com.tencent.mm.sdk.b.a.GpY.l(parama);
      AppMethodBeat.o(51550);
      return true;
      parama = paramk.aHg();
      if (bs.isNullOrNil(parama))
      {
        ac.e("MicroMsg.scanner.GetA8KeyRedirect", "onStartCommand url is null");
        AppMethodBeat.o(51550);
        return true;
      }
      ac.i("MicroMsg.scanner.GetA8KeyRedirect", "summerbak start url, url:%s", new Object[] { parama });
      paramk = new aa();
      paramk.cZq.url = parama;
      com.tencent.mm.sdk.b.a.GpY.l(paramk);
      ac.i("MicroMsg.scanner.GetA8KeyRedirect", "publish BackupGetA8keyRedirectEvent");
      AppMethodBeat.o(51550);
      return true;
      paramOnClickListener = paramk.aHg();
      ac.i("MicroMsg.scanner.GetA8KeyRedirect", "fullURL: ".concat(String.valueOf(paramOnClickListener)));
      paramString = parama.getContext();
      ac.i("MicroMsg.scanner.GetA8KeyRedirect", "processAppBrandFullURL, fullURL: ".concat(String.valueOf(paramOnClickListener)));
      paramRunnable = Uri.parse(paramOnClickListener);
      if ((paramRunnable.getQueryParameter("search_query") != null) && (paramRunnable.getQueryParameter("search_query").length() > 0))
      {
        paramk = paramRunnable.getQueryParameter("search_query");
        paramString = paramRunnable.getQueryParameter("appid");
        paramBundle = paramRunnable.getQueryParameter("search_extInfo");
        paramInt1 = bs.getInt(paramRunnable.getQueryParameter("debug"), 0);
        paramInt2 = bs.getInt(paramRunnable.getQueryParameter("version"), 0);
        paramRunnable = new nl();
        paramRunnable.dpR.scene = 1;
        paramRunnable.dpR.appId = paramString;
        paramRunnable.dpR.type = paramInt1;
        paramRunnable.dpR.version = paramInt2;
        paramRunnable.dpR.dpS = paramk;
        paramRunnable.dpR.url = paramOnClickListener;
        paramRunnable.dpR.dpT = paramBundle;
        com.tencent.mm.sdk.b.a.GpY.l(paramRunnable);
        paramString = z.exm();
        paramString.putExtra("ftsbizscene", 99999);
        paramString.putExtra("ftsQuery", paramk);
        paramString.putExtra("ftsqrcodestring", paramOnClickListener);
        paramOnClickListener = z.f(300, false, 262144);
        paramOnClickListener.put("query", paramk);
        paramk = z.Ui(bs.aLy((String)paramOnClickListener.get("scene")));
        paramOnClickListener.put("sessionid", paramk);
        paramString.putExtra("rawUrl", z.aV(paramOnClickListener));
        paramString.putExtra("key_session_id", paramk);
        d.b(ai.getContext(), "webview", ".ui.tools.fts.FTSWebViewUI", paramString);
        parama.pe(false);
        AppMethodBeat.o(51550);
        return true;
      }
      if (bs.getInt(paramRunnable.getQueryParameter("qr_type4wxa"), 0) == 2) {
        paramk = waj;
      }
      for (;;)
      {
        paramInt1 = paramk.get(paramInt2);
        ((com.tencent.mm.plugin.appbrand.service.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).b(paramString, paramOnClickListener, paramInt1, paramBundle);
        break;
        switch (j)
        {
        default: 
          paramk = wah;
          break;
        case 22: 
          paramk = wai;
        }
      }
      ac.i("MicroMsg.scanner.GetA8KeyRedirect", "jump to forceNotify UI");
      localIntent.putExtra("data", paramk.aHh());
      localIntent.setClassName(parama.getContext(), "com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI");
      parama.pe(false);
      parama = parama.getContext();
      paramk = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramk.aeD(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramk.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(51550);
      return true;
      ac.i("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect: %s, %s", new Object[] { paramString, paramk.aHg() });
      paramk = paramk.aHg();
      ((com.tencent.mm.plugin.emojicapture.api.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emojicapture.api.a.class)).prepareStickerPreview(parama.getContext(), paramk, new a.b()
      {
        public final void de(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(51541);
          this.wam.pe(paramAnonymousBoolean);
          AppMethodBeat.o(51541);
        }
      });
      AppMethodBeat.o(51550);
      return true;
      ac.i("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect: %s, %s", new Object[] { paramString, paramk.aHg() });
      paramk = paramk.aHg();
      ((com.tencent.mm.plugin.emojicapture.api.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emojicapture.api.a.class)).prepareEmojiCapture(parama.getContext(), paramk, new a.b()
      {
        public final void de(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(51542);
          this.wam.pe(paramAnonymousBoolean);
          AppMethodBeat.o(51542);
        }
      });
      AppMethodBeat.o(51550);
      return true;
      ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).gotoRedPacketPreviewUI(parama.getContext(), paramString);
      parama.pe(false);
      AppMethodBeat.o(51550);
      return true;
      paramOnClickListener = new Intent();
      paramOnClickListener.putExtra("key_qrcode_string", paramk.aHg());
      d.b(parama.getContext(), "account", ".friend.ui.RecoverAccountUI1", paramOnClickListener);
      new ao(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
      parama = new in();
      parama.dHA = 1;
      parama.aHZ();
      AppMethodBeat.o(51550);
      return true;
    }
  }
  
  public static abstract interface a
  {
    public abstract Context getContext();
    
    public abstract void pe(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.v.a.a
 * JD-Core Version:    0.7.0.1
 */