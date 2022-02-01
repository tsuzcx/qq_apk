package com.tencent.mm.plugin.w.a;

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
import com.tencent.mm.aq.c;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.aa;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.a.ip.b;
import com.tencent.mm.g.a.nu;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.g.b.a.ju;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emojicapture.api.a.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.VcardContactUI;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.plugin.scanner.util.o.a;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.e.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class a
{
  private static final SparseIntArray xxN;
  private static final SparseIntArray xxO;
  private static final SparseIntArray xxP;
  
  static
  {
    AppMethodBeat.i(51552);
    xxN = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(51545);
        paramAnonymousInt = super.get(paramAnonymousInt, 1011);
        AppMethodBeat.o(51545);
        return paramAnonymousInt;
      }
    };
    xxO = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(51547);
        paramAnonymousInt = super.get(paramAnonymousInt, 1047);
        AppMethodBeat.o(51547);
        return paramAnonymousInt;
      }
    };
    xxP = new SparseIntArray()
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
  
  protected static int NW(int paramInt)
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
    ae.d("MicroMsg.scanner.GetA8KeyRedirect", "actionCode = %s, url = %s", new Object[] { Integer.valueOf(paramInt1), paramString });
    final ip localip = new ip();
    localip.dwm.actionCode = paramInt1;
    localip.dwm.result = paramString;
    localip.dwm.context = parama.getContext();
    paramString = new Bundle();
    paramString.putInt("pay_channel", paramInt2);
    localip.dwm.dwo = paramString;
    localip.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51543);
        if ((this.xxS == null) || (localip == null) || (localip.dwn == null))
        {
          AppMethodBeat.o(51543);
          return;
        }
        if (localip.dwn.ret == 1)
        {
          this.xxS.pJ(true);
          AppMethodBeat.o(51543);
          return;
        }
        if (localip.dwn.ret == 2) {
          this.xxS.pJ(false);
        }
        AppMethodBeat.o(51543);
      }
    };
    com.tencent.mm.sdk.b.a.IvT.a(localip, Looper.myLooper());
    AppMethodBeat.o(51551);
  }
  
  public static boolean a(final a parama, final com.tencent.mm.modelsimple.l paraml, DialogInterface.OnClickListener paramOnClickListener, final String paramString, final int paramInt1, final int paramInt2, final Runnable paramRunnable, Bundle paramBundle)
  {
    AppMethodBeat.i(51550);
    if (parama.getContext() == null)
    {
      ae.e("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect, null redirectContext");
      AppMethodBeat.o(51550);
      return false;
    }
    int i = paraml.aKQ();
    int j = ((avy)paraml.rr.hQD.hQJ).Goq;
    ae.i("MicroMsg.scanner.GetA8KeyRedirect", "actionCode : %s, codeType : %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    ae.i("MicroMsg.scanner.GetA8KeyRedirect", "source=".concat(String.valueOf(paramInt1)));
    Intent localIntent = new Intent();
    localIntent.putExtra("geta8key_scene", paramInt1);
    localIntent.putExtra("KPublisherId", "qrcode");
    localIntent.putExtra("prePublishId", "qrcode");
    com.tencent.mm.pluginsdk.wallet.h.aad(NW(paramInt1));
    boolean bool;
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
      ae.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-not_catch: action code = " + paraml.aKQ());
      AppMethodBeat.o(51550);
      return false;
    case 1: 
      ae.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-text: " + paraml.getContent());
      ((com.tencent.mm.plugin.expt.b.a)g.ab(com.tencent.mm.plugin.expt.b.a.class)).adU(paraml.getContent());
      localIntent.putExtra("data", paraml.getContent());
      localIntent.putExtra("showShare", false);
      if (paramInt2 == 2) {
        localIntent.putExtra("stastic_scene", 13);
      }
      for (;;)
      {
        localIntent.putExtra("pay_channel", NW(paramInt1));
        localIntent.putExtra("geta8key_session_id", paraml.aKW());
        com.tencent.mm.plugin.scanner.h.iUz.i(localIntent, parama.getContext());
        new aq(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        if (paramInt2 == 1) {
          localIntent.putExtra("stastic_scene", 14);
        } else {
          localIntent.putExtra("stastic_scene", 11);
        }
      }
    case 2: 
      ae.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview: " + paraml.aKO());
      paramRunnable = parama.getContext();
      paramBundle = parama.getContext();
      if (!bu.isNullOrNil(paramString)) {}
      for (;;)
      {
        com.tencent.mm.ui.base.h.a(paramRunnable, paramBundle.getString(2131762117, new Object[] { paramString }), parama.getContext().getString(2131755906), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(51538);
            this.val$intent.putExtra("title", paraml.getTitle());
            this.val$intent.putExtra("rawUrl", paraml.aKO());
            if (paramInt2 == 2) {
              this.val$intent.putExtra("stastic_scene", 13);
            }
            for (;;)
            {
              this.val$intent.putExtra("pay_channel", a.NW(paramInt1));
              this.val$intent.putExtra("geta8key_session_id", paraml.aKW());
              this.val$intent.putExtra("geta8key_cookie", paraml.aKY());
              com.tencent.mm.plugin.scanner.h.iUz.i(this.val$intent, parama.getContext());
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
        paramString = paraml.aKO();
      }
    case 7: 
    case 30: 
      ae.i("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview_no_notice: reqUrl : %s,  fullUrl : %s, shareUrl : %s", new Object[] { paraml.aKP(), paraml.aKO(), paraml.aKS() });
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAT, 0) == 1) {
        bool = true;
      }
      break;
    }
    for (;;)
    {
      ae.i("MicroMsg.scanner.GetA8KeyRedirect", "webViewUseOuterGetA8key:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {}
      try
      {
        paramOnClickListener = (avz)paraml.rr.hQE.hQJ;
        localIntent.putExtra("key_scan_qr_code_get_a8key_req", ((avy)paraml.rr.hQD.hQJ).toByteArray());
        localIntent.putExtra("key_scan_qr_code_get_a8key_resp", paramOnClickListener.toByteArray());
        localIntent.putExtra("title", paraml.getTitle());
        localIntent.putExtra("rawUrl", paraml.aKO());
        localIntent.putExtra("k_share_url", paraml.aKS());
        if (paramInt2 == 2) {
          localIntent.putExtra("stastic_scene", 13);
        }
        Object localObject1;
        for (;;)
        {
          ae.i("MicroMsg.scanner.GetA8KeyRedirect", "start webview with channel : ".concat(String.valueOf(NW(paramInt1))));
          localIntent.putExtra("pay_channel", NW(paramInt1));
          localIntent.putExtra("geta8key_session_id", paraml.aKW());
          localIntent.putExtra("geta8key_cookie", paraml.aKY());
          paraml = paraml.aKV();
          if (bu.ht(paraml)) {
            break label1165;
          }
          paramOnClickListener = paraml.iterator();
          do
          {
            if (!paramOnClickListener.hasNext()) {
              break;
            }
            localObject1 = (bpk)paramOnClickListener.next();
          } while ((localObject1 != null) && (!bu.isNullOrNil(((bpk)localObject1).uuW)) && (!bu.isNullOrNil(((bpk)localObject1).yxn)));
          ae.e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
          paramInt1 = 1;
          if (paramInt1 != 0) {
            break label1165;
          }
          paramOnClickListener = new String[paraml.size()];
          localObject1 = new String[paraml.size()];
          paramInt1 = 0;
          while (paramInt1 < paraml.size())
          {
            Object localObject2 = (bpk)paraml.get(paramInt1);
            String str = ((bpk)localObject2).uuW;
            localObject2 = ((bpk)localObject2).yxn;
            ae.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", new Object[] { Integer.valueOf(paramInt1), str, localObject2 });
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
        label1165:
        if ((i == 30) && (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAk, 0) == 1))
        {
          localIntent.putExtra("auth_raw_url", paramString);
          localIntent.putExtra("auth_from_scan", true);
          d.b(parama.getContext(), "webview", ".ui.tools.SDKOAuthUI", localIntent);
          new aq(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
          AppMethodBeat.o(51550);
          return true;
        }
        if ((paramBundle != null) && (paramBundle.getString("stat_send_msg_user") != null)) {
          localIntent.putExtra(e.m.JpG, paramBundle.getString("stat_send_msg_user"));
        }
        com.tencent.mm.plugin.scanner.h.iUz.i(localIntent, parama.getContext());
        new aq(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        ae.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-special_webview: " + paraml.aKO());
        localIntent.putExtra("rawUrl", paraml.aKO());
        localIntent.putExtra("pay_channel", NW(paramInt1));
        localIntent.putExtra("showShare", false);
        localIntent.putExtra("show_bottom", false);
        localIntent.putExtra("isWebwx", false);
        localIntent.putExtra("geta8key_session_id", paraml.aKW());
        localIntent.putExtra("geta8key_cookie", paraml.aKY());
        com.tencent.mm.plugin.scanner.h.iUz.i(localIntent, parama.getContext());
        AppMethodBeat.o(51550);
        return true;
        AppMethodBeat.o(51550);
        return false;
        paramString = paraml.aKO();
        ae.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app: ".concat(String.valueOf(paramString)));
        if ((paramString == null) || (paramString.length() == 0))
        {
          ae.e("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app, fullUrl is null");
          AppMethodBeat.o(51550);
          return false;
        }
        paraml = parama.getContext().getString(2131762116);
        if (paramString.startsWith("http")) {
          paraml = parama.getContext().getString(2131762117, new Object[] { paramString });
        }
        paramString = Uri.parse(paramString);
        if (paramString != null)
        {
          paramString = new Intent("android.intent.action.VIEW", paramString);
          paramString.addFlags(268435456);
          if (bu.aj(parama.getContext(), paramString))
          {
            com.tencent.mm.ui.base.h.a(parama.getContext(), paraml, parama.getContext().getString(2131755906), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(51539);
                paramAnonymousDialogInterface = this.xxS.getContext();
                Object localObject = paramString;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
        paraml = paraml.getContent();
        ae.d("MicroMsg.scanner.GetA8KeyRedirect", "get vcard from server: ".concat(String.valueOf(paraml)));
        if (!bu.isNullOrNil(paraml)) {
          paramString = new com.tencent.mm.plugin.scanner.model.aj();
        }
        try
        {
          paramString.aya(paraml);
          paramRunnable = new Intent(parama.getContext(), VcardContactUI.class);
          paramString = parama.getContext();
          paramRunnable = new com.tencent.mm.hellhoundlib.b.a().bc(paramRunnable);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramRunnable.ahE(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramRunnable.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.pJ(false);
          AppMethodBeat.o(51550);
          return true;
        }
        catch (XmlPullParserException paramString)
        {
          ae.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + paramString.getMessage() + " " + paraml);
          ae.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", paramString, "", new Object[0]);
          com.tencent.mm.ui.base.h.a(parama.getContext(), parama.getContext().getString(2131762127), parama.getContext().getString(2131755906), false, paramOnClickListener);
          AppMethodBeat.o(51550);
          return true;
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            ae.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + paramString.getMessage() + " " + paraml);
            ae.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", paramString, "", new Object[0]);
          }
        }
        ae.d("MicroMsg.scanner.GetA8KeyRedirect", "ftf pay url:" + paraml.aKO());
        f.a(parama.getContext(), 1, paraml.aKO(), NW(paramInt1), null);
        new aq(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        paramOnClickListener = new Bundle();
        paramOnClickListener.putInt("key_scene", 5);
        bool = com.tencent.mm.plugin.scanner.h.iUz.b(parama.getContext(), paraml.aKO(), paramOnClickListener);
        AppMethodBeat.o(51550);
        return bool;
        a(parama, i, paraml.aKO(), NW(paramInt1));
        new aq(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        a(parama, i, paraml.aKO(), NW(paramInt1));
        AppMethodBeat.o(51550);
        return true;
        paramOnClickListener = paraml.aKO();
        paraml = paramOnClickListener;
        if (paramOnClickListener != null) {
          paraml = paramOnClickListener.replace("wxpd://", "");
        }
        paramOnClickListener = new Intent();
        paramOnClickListener.putExtra("key_product_id", paraml);
        paramOnClickListener.putExtra("key_product_scene", 7);
        d.b(parama.getContext(), "product", ".ui.MallProductUI", paramOnClickListener);
        AppMethodBeat.o(51550);
        return true;
        paramOnClickListener = new Intent();
        paramOnClickListener.setClass(parama.getContext(), ProductUI.class);
        paramOnClickListener.putExtra("key_ProductUI_getProductInfoScene", 5);
        paramOnClickListener.putExtra("key_Qrcode_Url", paraml.aKO());
        parama = parama.getContext();
        paraml = new com.tencent.mm.hellhoundlib.b.a().bc(paramOnClickListener);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paraml.ahE(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paraml.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(51550);
        return true;
        paramOnClickListener = paraml.aKO();
        parama = new Intent().setClassName(ak.getContext(), "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService");
        paraml = bu.ak(ak.getContext(), parama);
        if (paraml != null) {
          parama = paraml;
        }
        for (;;)
        {
          d.bf(parama.putExtra("url", paramOnClickListener).putExtra("isFromWifi", true));
          ae.d("MicroMsg.scanner.GetA8KeyRedirect", "GET_CONNECT_INFO start end");
          AppMethodBeat.o(51550);
          return true;
        }
        paraml = o.ayp(paraml.aKO());
        if (paraml == null) {
          ae.e("MicroMsg.scanner.GetA8KeyRedirect", "item == null");
        }
        for (;;)
        {
          AppMethodBeat.o(51550);
          return false;
          if (o.AB(paraml.mwj)) {
            break;
          }
          o.bd(parama.getContext(), parama.getContext().getString(2131756947));
        }
        paramOnClickListener = new Intent();
        paramOnClickListener.putExtra("key_card_id", paraml.oEo);
        paramOnClickListener.putExtra("key_card_ext", paraml.dJc);
        paramOnClickListener.putExtra("key_from_scene", 0);
        if (paramInt2 == 2) {
          paramOnClickListener.putExtra("key_stastic_scene", 13);
        }
        for (;;)
        {
          d.b(parama.getContext(), "card", ".ui.CardDetailUI", paramOnClickListener);
          ae.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_CARD start end");
          break;
          if (paramInt2 == 1) {
            paramOnClickListener.putExtra("key_stastic_scene", 14);
          } else {
            paramOnClickListener.putExtra("key_stastic_scene", 11);
          }
        }
        paraml = paraml.aKO();
        paramOnClickListener = o.ayq(paraml);
        if ((paramOnClickListener == null) || (paramOnClickListener.size() == 0)) {
          ae.e("MicroMsg.scanner.GetA8KeyRedirect", "list == null || list.size() == 0");
        }
        for (;;)
        {
          AppMethodBeat.o(51550);
          return false;
          if (o.ax(paramOnClickListener)) {
            break;
          }
          o.bd(parama.getContext(), parama.getContext().getString(2131756947));
        }
        paramOnClickListener = new Intent();
        paramOnClickListener.putExtra("key_from_scene", 0);
        paramOnClickListener.putExtra("src_username", "");
        paramOnClickListener.putExtra("js_url", "");
        paramOnClickListener.putExtra("key_in_card_list", paraml);
        if (paramInt2 == 2) {
          paramOnClickListener.putExtra("key_stastic_scene", 13);
        }
        for (;;)
        {
          d.b(parama.getContext(), "card", ".ui.CardAddEntranceUI", paramOnClickListener);
          ae.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_MULTIPLE_CARD start end");
          break;
          if (paramInt2 == 1) {
            paramOnClickListener.putExtra("key_stastic_scene", 14);
          } else {
            paramOnClickListener.putExtra("key_stastic_scene", 11);
          }
        }
        paramRunnable = new Intent();
        paramRunnable.putExtra("free_wifi_url", paraml.aKO());
        paramString = (avz)paraml.rr.hQE.hQJ;
        if ((paramString == null) || (paramString.FJb == null))
        {
          ae.e("MicroMsg.NetSceneGetA8Key", "get mid failed");
          paramString = null;
          paramRunnable.putExtra("free_wifi_mid", paramString);
          paramString = (avz)paraml.rr.hQE.hQJ;
          if ((paramString != null) && (paramString.SSID != null)) {
            break label2968;
          }
          ae.e("MicroMsg.NetSceneGetA8Key", "get ssid failed");
          paramString = null;
          label2871:
          paramRunnable.putExtra("free_wifi_ssid", paramString);
          paramRunnable.putExtra("free_wifi_source", 1);
          paramRunnable.putExtra("free_wifi_ap_key", paraml.aKO());
          if (g.ajR().ajA().get(303104, null) == null) {
            break label2976;
          }
          com.tencent.mm.ui.base.h.a(parama.getContext(), 2131759617, 2131755906, 2131755700, 2131755691, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(51540);
              d.b(this.xxS.getContext(), "freewifi", ".ui.FreeWifiEntryUI", paramRunnable);
              this.xxS.pJ(false);
              AppMethodBeat.o(51540);
            }
          }, paramOnClickListener);
        }
        for (;;)
        {
          AppMethodBeat.o(51550);
          return true;
          paramString = paramString.FJb;
          break;
          label2968:
          paramString = paramString.SSID;
          break label2871;
          label2976:
          d.b(parama.getContext(), "freewifi", ".ui.FreeWifiEntryUI", paramRunnable);
          parama.pJ(false);
        }
        ae.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-emoticon full url: " + paraml.aKO());
        parama = new c(paraml.aKO());
        g.ajj().a(parama, 0);
        AppMethodBeat.o(51550);
        return true;
        parama = new sp();
        parama.dIj.dIk = paramString;
        com.tencent.mm.sdk.b.a.IvT.l(parama);
        AppMethodBeat.o(51550);
        return true;
        parama = paraml.aKO();
        if (bu.isNullOrNil(parama))
        {
          ae.e("MicroMsg.scanner.GetA8KeyRedirect", "onStartCommand url is null");
          AppMethodBeat.o(51550);
          return true;
        }
        ae.i("MicroMsg.scanner.GetA8KeyRedirect", "summerbak start url, url:%s", new Object[] { parama });
        paraml = new aa();
        paraml.dlK.url = parama;
        com.tencent.mm.sdk.b.a.IvT.l(paraml);
        ae.i("MicroMsg.scanner.GetA8KeyRedirect", "publish BackupGetA8keyRedirectEvent");
        AppMethodBeat.o(51550);
        return true;
        paramOnClickListener = paraml.aKO();
        ae.i("MicroMsg.scanner.GetA8KeyRedirect", "fullURL: ".concat(String.valueOf(paramOnClickListener)));
        paramRunnable = paraml.iob;
        paramRunnable.putLong("CgiSpeedOutSideStructResponseSize", ((avz)paraml.rr.hQE.hQJ).computeSize());
        paramRunnable.putInt("CgiSpeedOutSideStructBizRet", ((avz)paraml.rr.hQE.hQJ).BaseResponse.Ret);
        paramRunnable.putString("CgiSpeedOutSideStructNetworkType", ((com.tencent.mm.plugin.appbrand.service.l)g.ab(com.tencent.mm.plugin.appbrand.service.l.class)).bxT());
        paramString = new Bundle();
        paramString.putBundle("stat_get_a8_key_cgi_speed", paramRunnable);
        paramRunnable = parama.getContext();
        ae.i("MicroMsg.scanner.GetA8KeyRedirect", "processAppBrandFullURL, fullURL: ".concat(String.valueOf(paramOnClickListener)));
        paraml = Uri.parse(paramOnClickListener);
        if ((paraml.getQueryParameter("search_query") != null) && (paraml.getQueryParameter("search_query").length() > 0))
        {
          paramString = paraml.getQueryParameter("search_query");
          paramRunnable = paraml.getQueryParameter("appid");
          paramBundle = paraml.getQueryParameter("search_extInfo");
          paramInt1 = bu.getInt(paraml.getQueryParameter("debug"), 0);
          paramInt2 = bu.getInt(paraml.getQueryParameter("version"), 0);
          paraml = new nu();
          paraml.dCJ.scene = 1;
          paraml.dCJ.appId = paramRunnable;
          paraml.dCJ.type = paramInt1;
          paraml.dCJ.version = paramInt2;
          paraml.dCJ.dCK = paramString;
          paraml.dCJ.url = paramOnClickListener;
          paraml.dCJ.dCL = paramBundle;
          com.tencent.mm.sdk.b.a.IvT.l(paraml);
          paraml = ad.ePM();
          paraml.putExtra("ftsbizscene", 99999);
          paraml.putExtra("ftsQuery", paramString);
          paraml.putExtra("ftsqrcodestring", paramOnClickListener);
          paramOnClickListener = ad.f(300, false, 262144);
          paramOnClickListener.put("query", paramString);
          paramString = ad.WI(bu.aSB((String)paramOnClickListener.get("scene")));
          paramOnClickListener.put("sessionid", paramString);
          paraml.putExtra("rawUrl", ad.be(paramOnClickListener));
          paraml.putExtra("key_session_id", paramString);
          d.b(ak.getContext(), "webview", ".ui.tools.fts.FTSWebViewUI", paraml);
          parama.pJ(false);
          AppMethodBeat.o(51550);
          return true;
        }
        if (bu.getInt(paraml.getQueryParameter("qr_type4wxa"), 0) == 2) {
          paraml = xxP;
        }
        for (;;)
        {
          paramInt1 = paraml.get(paramInt2);
          ((com.tencent.mm.plugin.appbrand.service.q)g.ab(com.tencent.mm.plugin.appbrand.service.q.class)).b(paramRunnable, paramOnClickListener, paramInt1, paramBundle, paramString);
          break;
          switch (j)
          {
          default: 
            paraml = xxN;
            break;
          case 22: 
            paraml = xxO;
          }
        }
        ae.i("MicroMsg.scanner.GetA8KeyRedirect", "jump to forceNotify UI");
        localIntent.putExtra("data", paraml.aKP());
        localIntent.setClassName(parama.getContext(), "com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI");
        parama.pJ(false);
        parama = parama.getContext();
        paraml = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paraml.ahE(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paraml.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(51550);
        return true;
        ae.i("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect: %s, %s", new Object[] { paramString, paraml.aKO() });
        paraml = paraml.aKO();
        ((com.tencent.mm.plugin.emojicapture.api.a)g.ad(com.tencent.mm.plugin.emojicapture.api.a.class)).prepareStickerPreview(parama.getContext(), paraml, new a.b()
        {
          public final void dg(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(51541);
            this.xxS.pJ(paramAnonymousBoolean);
            AppMethodBeat.o(51541);
          }
        });
        AppMethodBeat.o(51550);
        return true;
        ae.i("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect: %s, %s", new Object[] { paramString, paraml.aKO() });
        paraml = paraml.aKO();
        ((com.tencent.mm.plugin.emojicapture.api.a)g.ad(com.tencent.mm.plugin.emojicapture.api.a.class)).prepareEmojiCapture(parama.getContext(), paraml, new a.b()
        {
          public final void dg(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(51542);
            this.xxS.pJ(paramAnonymousBoolean);
            AppMethodBeat.o(51542);
          }
        });
        AppMethodBeat.o(51550);
        return true;
        ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).gotoRedPacketPreviewUI(parama.getContext(), paramString);
        parama.pJ(false);
        AppMethodBeat.o(51550);
        return true;
        paramOnClickListener = new Intent();
        paramOnClickListener.putExtra("key_qrcode_string", paraml.aKO());
        d.b(parama.getContext(), "account", ".friend.ui.RecoverAccountUI1", paramOnClickListener);
        new aq(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        parama = new ju();
        parama.dVT = 1;
        parama.aLH();
        AppMethodBeat.o(51550);
        return true;
      }
      catch (IOException paramOnClickListener)
      {
        for (;;)
        {
          continue;
          paramInt1 = 0;
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract Context getContext();
    
    public abstract void pJ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.w.a.a
 * JD-Core Version:    0.7.0.1
 */