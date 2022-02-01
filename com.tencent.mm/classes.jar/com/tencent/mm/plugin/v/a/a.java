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
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.q;
import com.tencent.mm.ar.c;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.g.a.hz.b;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.g.a.z;
import com.tencent.mm.g.b.a.gv;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.plugin.emojicapture.api.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.VcardContactUI;
import com.tencent.mm.plugin.scanner.util.o.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.bgq;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.e.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class a
{
  private static final SparseIntArray uRs;
  private static final SparseIntArray uRt;
  private static final SparseIntArray uRu;
  
  static
  {
    AppMethodBeat.i(51552);
    uRs = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(51545);
        paramAnonymousInt = super.get(paramAnonymousInt, 1011);
        AppMethodBeat.o(51545);
        return paramAnonymousInt;
      }
    };
    uRt = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(51547);
        paramAnonymousInt = super.get(paramAnonymousInt, 1047);
        AppMethodBeat.o(51547);
        return paramAnonymousInt;
      }
    };
    uRu = new SparseIntArray()
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
  
  protected static int JS(int paramInt)
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
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.scanner.GetA8KeyRedirect", "actionCode = %s, url = %s", new Object[] { Integer.valueOf(paramInt1), paramString });
    final hz localhz = new hz();
    localhz.dlM.actionCode = paramInt1;
    localhz.dlM.result = paramString;
    localhz.dlM.context = parama.getContext();
    paramString = new Bundle();
    paramString.putInt("pay_channel", paramInt2);
    localhz.dlM.dlO = paramString;
    localhz.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51543);
        if ((this.uRx == null) || (localhz == null) || (localhz.dlN == null))
        {
          AppMethodBeat.o(51543);
          return;
        }
        if (localhz.dlN.ret == 1)
        {
          this.uRx.ok(true);
          AppMethodBeat.o(51543);
          return;
        }
        if (localhz.dlN.ret == 2) {
          this.uRx.ok(false);
        }
        AppMethodBeat.o(51543);
      }
    };
    com.tencent.mm.sdk.b.a.ESL.a(localhz, Looper.myLooper());
    AppMethodBeat.o(51551);
  }
  
  public static boolean a(final a parama, final k paramk, DialogInterface.OnClickListener paramOnClickListener, final String paramString, final int paramInt1, final int paramInt2, final Runnable paramRunnable, Bundle paramBundle)
  {
    AppMethodBeat.i(51550);
    if (parama.getContext() == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect, null redirectContext");
      AppMethodBeat.o(51550);
      return false;
    }
    int i = paramk.aAs();
    int j = ((aoi)paramk.rr.gUS.gUX).CVW;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "actionCode : %s, codeType : %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "source=".concat(String.valueOf(paramInt1)));
    Intent localIntent = new Intent();
    localIntent.putExtra("geta8key_scene", paramInt1);
    localIntent.putExtra("KPublisherId", "qrcode");
    localIntent.putExtra("prePublishId", "qrcode");
    com.tencent.mm.pluginsdk.wallet.h.Vs(JS(paramInt1));
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
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-not_catch: action code = " + paramk.aAs());
      AppMethodBeat.o(51550);
      return false;
    case 1: 
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-text: " + paramk.getContent());
      ((com.tencent.mm.plugin.expt.a.a)g.ab(com.tencent.mm.plugin.expt.a.a.class)).Vl(paramk.getContent());
      localIntent.putExtra("data", paramk.getContent());
      localIntent.putExtra("showShare", false);
      if (paramInt2 == 2) {
        localIntent.putExtra("stastic_scene", 13);
      }
      for (;;)
      {
        localIntent.putExtra("pay_channel", JS(paramInt1));
        localIntent.putExtra("geta8key_session_id", paramk.aAy());
        com.tencent.mm.plugin.scanner.f.hYt.i(localIntent, parama.getContext());
        new ap(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        if (paramInt2 == 1) {
          localIntent.putExtra("stastic_scene", 14);
        } else {
          localIntent.putExtra("stastic_scene", 11);
        }
      }
    case 2: 
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview: " + paramk.aAq());
      paramRunnable = parama.getContext();
      paramBundle = parama.getContext();
      if (!bt.isNullOrNil(paramString)) {}
      for (;;)
      {
        com.tencent.mm.ui.base.h.a(paramRunnable, paramBundle.getString(2131762117, new Object[] { paramString }), parama.getContext().getString(2131755906), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(51538);
            this.val$intent.putExtra("title", paramk.getTitle());
            this.val$intent.putExtra("rawUrl", paramk.aAq());
            if (paramInt2 == 2) {
              this.val$intent.putExtra("stastic_scene", 13);
            }
            for (;;)
            {
              this.val$intent.putExtra("pay_channel", a.JS(paramInt1));
              this.val$intent.putExtra("geta8key_session_id", paramk.aAy());
              this.val$intent.putExtra("geta8key_cookie", paramk.aAA());
              com.tencent.mm.plugin.scanner.f.hYt.i(this.val$intent, parama.getContext());
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
        paramString = paramk.aAq();
      }
    case 7: 
    case 30: 
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview_no_notice: reqUrl : %s,  fullUrl : %s, shareUrl : %s", new Object[] { paramk.aAr(), paramk.aAq(), paramk.aAu() });
      localIntent.putExtra("title", paramk.getTitle());
      localIntent.putExtra("rawUrl", paramk.aAq());
      localIntent.putExtra("k_share_url", paramk.aAu());
      if (paramInt2 == 2)
      {
        localIntent.putExtra("stastic_scene", 13);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "start webview with channel : ".concat(String.valueOf(JS(paramInt1))));
        localIntent.putExtra("pay_channel", JS(paramInt1));
        localIntent.putExtra("geta8key_session_id", paramk.aAy());
        localIntent.putExtra("geta8key_cookie", paramk.aAA());
        paramk = paramk.aAx();
        if (bt.gL(paramk)) {
          break label1053;
        }
        paramOnClickListener = paramk.iterator();
        while (paramOnClickListener.hasNext())
        {
          localObject1 = (bgq)paramOnClickListener.next();
          if ((localObject1 == null) || (bt.isNullOrNil(((bgq)localObject1).sdv)) || (bt.isNullOrNil(((bgq)localObject1).vJI))) {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
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
            Object localObject2 = (bgq)paramk.get(paramInt1);
            String str = ((bgq)localObject2).sdv;
            localObject2 = ((bgq)localObject2).vJI;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", new Object[] { Integer.valueOf(paramInt1), str, localObject2 });
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
      label1053:
      if ((i == 30) && (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plZ, 0) == 1))
      {
        localIntent.putExtra("auth_raw_url", paramString);
        localIntent.putExtra("auth_from_scan", true);
        d.b(parama.getContext(), "webview", ".ui.tools.SDKOAuthUI", localIntent);
        new ap(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
      }
      if ((paramBundle != null) && (paramBundle.getString("stat_send_msg_user") != null)) {
        localIntent.putExtra(e.m.FIA, paramBundle.getString("stat_send_msg_user"));
      }
      com.tencent.mm.plugin.scanner.f.hYt.i(localIntent, parama.getContext());
      new ap(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
      AppMethodBeat.o(51550);
      return true;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-special_webview: " + paramk.aAq());
      localIntent.putExtra("rawUrl", paramk.aAq());
      localIntent.putExtra("pay_channel", JS(paramInt1));
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("isWebwx", false);
      localIntent.putExtra("geta8key_session_id", paramk.aAy());
      localIntent.putExtra("geta8key_cookie", paramk.aAA());
      com.tencent.mm.plugin.scanner.f.hYt.i(localIntent, parama.getContext());
      AppMethodBeat.o(51550);
      return true;
      AppMethodBeat.o(51550);
      return false;
      paramString = paramk.aAq();
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app: ".concat(String.valueOf(paramString)));
      if ((paramString == null) || (paramString.length() == 0))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app, fullUrl is null");
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
        if (bt.T(parama.getContext(), paramString))
        {
          com.tencent.mm.ui.base.h.a(parama.getContext(), paramk, parama.getContext().getString(2131755906), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(51539);
              paramAnonymousDialogInterface = this.uRx.getContext();
              Object localObject = paramString;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.scanner.GetA8KeyRedirect", "get vcard from server: ".concat(String.valueOf(paramk)));
      if (!bt.isNullOrNil(paramk)) {
        paramString = new com.tencent.mm.plugin.scanner.model.ad();
      }
      try
      {
        paramString.amB(paramk);
        paramRunnable = new Intent(parama.getContext(), VcardContactUI.class);
        paramString = parama.getContext();
        paramRunnable = new com.tencent.mm.hellhoundlib.b.a().bd(paramRunnable);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, paramRunnable.adn(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramRunnable.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.ok(false);
        AppMethodBeat.o(51550);
        return true;
      }
      catch (XmlPullParserException paramString)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + paramString.getMessage() + " " + paramk);
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", paramString, "", new Object[0]);
        com.tencent.mm.ui.base.h.a(parama.getContext(), parama.getContext().getString(2131762127), parama.getContext().getString(2131755906), false, paramOnClickListener);
        AppMethodBeat.o(51550);
        return true;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + paramString.getMessage() + " " + paramk);
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", paramString, "", new Object[0]);
        }
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.scanner.GetA8KeyRedirect", "ftf pay url:" + paramk.aAq());
      com.tencent.mm.pluginsdk.wallet.f.a(parama.getContext(), 1, paramk.aAq(), JS(paramInt1), null);
      new ap(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
      AppMethodBeat.o(51550);
      return true;
      paramOnClickListener = new Bundle();
      paramOnClickListener.putInt("key_scene", 5);
      boolean bool = com.tencent.mm.plugin.scanner.f.hYt.b(parama.getContext(), paramk.aAq(), paramOnClickListener);
      AppMethodBeat.o(51550);
      return bool;
      a(parama, i, paramk.aAq(), JS(paramInt1));
      new ap(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
      AppMethodBeat.o(51550);
      return true;
      a(parama, i, paramk.aAq(), JS(paramInt1));
      AppMethodBeat.o(51550);
      return true;
      paramOnClickListener = paramk.aAq();
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
      paramOnClickListener.putExtra("key_Qrcode_Url", paramk.aAq());
      parama = parama.getContext();
      paramk = new com.tencent.mm.hellhoundlib.b.a().bd(paramOnClickListener);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramk.adn(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramk.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(51550);
      return true;
      paramOnClickListener = paramk.aAq();
      parama = new Intent().setClassName(aj.getContext(), "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService");
      paramk = bt.U(aj.getContext(), parama);
      if (paramk != null) {
        parama = paramk;
      }
      for (;;)
      {
        d.aY(parama.putExtra("url", paramOnClickListener).putExtra("isFromWifi", true));
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.scanner.GetA8KeyRedirect", "GET_CONNECT_INFO start end");
        AppMethodBeat.o(51550);
        return true;
      }
      paramk = com.tencent.mm.plugin.scanner.util.o.amQ(paramk.aAq());
      if (paramk == null) {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.scanner.GetA8KeyRedirect", "item == null");
      }
      for (;;)
      {
        AppMethodBeat.o(51550);
        return false;
        if (com.tencent.mm.plugin.scanner.util.o.yQ(paramk.lpz)) {
          break;
        }
        com.tencent.mm.plugin.scanner.util.o.aX(parama.getContext(), parama.getContext().getString(2131756947));
      }
      paramOnClickListener = new Intent();
      paramOnClickListener.putExtra("key_card_id", paramk.nrr);
      paramOnClickListener.putExtra("key_card_ext", paramk.dyd);
      paramOnClickListener.putExtra("key_from_scene", 0);
      if (paramInt2 == 2) {
        paramOnClickListener.putExtra("key_stastic_scene", 13);
      }
      for (;;)
      {
        d.b(parama.getContext(), "card", ".ui.CardDetailUI", paramOnClickListener);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_CARD start end");
        break;
        if (paramInt2 == 1) {
          paramOnClickListener.putExtra("key_stastic_scene", 14);
        } else {
          paramOnClickListener.putExtra("key_stastic_scene", 11);
        }
      }
      paramk = paramk.aAq();
      paramOnClickListener = com.tencent.mm.plugin.scanner.util.o.amR(paramk);
      if ((paramOnClickListener == null) || (paramOnClickListener.size() == 0)) {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.scanner.GetA8KeyRedirect", "list == null || list.size() == 0");
      }
      for (;;)
      {
        AppMethodBeat.o(51550);
        return false;
        if (com.tencent.mm.plugin.scanner.util.o.am(paramOnClickListener)) {
          break;
        }
        com.tencent.mm.plugin.scanner.util.o.aX(parama.getContext(), parama.getContext().getString(2131756947));
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
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_MULTIPLE_CARD start end");
        break;
        if (paramInt2 == 1) {
          paramOnClickListener.putExtra("key_stastic_scene", 14);
        } else {
          paramOnClickListener.putExtra("key_stastic_scene", 11);
        }
      }
      paramRunnable = new Intent();
      paramRunnable.putExtra("free_wifi_url", paramk.aAq());
      paramString = (aoj)paramk.rr.gUT.gUX;
      if ((paramString == null) || (paramString.Cth == null))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetA8Key", "get mid failed");
        paramString = null;
        paramRunnable.putExtra("free_wifi_mid", paramString);
        paramString = (aoj)paramk.rr.gUT.gUX;
        if ((paramString != null) && (paramString.SSID != null)) {
          break label2856;
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetA8Key", "get ssid failed");
        paramString = null;
        label2759:
        paramRunnable.putExtra("free_wifi_ssid", paramString);
        paramRunnable.putExtra("free_wifi_source", 1);
        paramRunnable.putExtra("free_wifi_ap_key", paramk.aAq());
        if (g.afB().afk().get(303104, null) == null) {
          break label2864;
        }
        com.tencent.mm.ui.base.h.b(parama.getContext(), 2131759617, 2131755906, 2131755700, 2131755691, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(51540);
            d.b(this.uRx.getContext(), "freewifi", ".ui.FreeWifiEntryUI", paramRunnable);
            this.uRx.ok(false);
            AppMethodBeat.o(51540);
          }
        }, paramOnClickListener);
      }
      for (;;)
      {
        AppMethodBeat.o(51550);
        return true;
        paramString = paramString.Cth;
        break;
        label2856:
        paramString = paramString.SSID;
        break label2759;
        label2864:
        d.b(parama.getContext(), "freewifi", ".ui.FreeWifiEntryUI", paramRunnable);
        parama.ok(false);
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-emoticon full url: " + paramk.aAq());
      parama = new c(paramk.aAq());
      g.aeS().a(parama, 0);
      AppMethodBeat.o(51550);
      return true;
      parama = new rt();
      parama.dxp.dxq = paramString;
      com.tencent.mm.sdk.b.a.ESL.l(parama);
      AppMethodBeat.o(51550);
      return true;
      parama = paramk.aAq();
      if (bt.isNullOrNil(parama))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.scanner.GetA8KeyRedirect", "onStartCommand url is null");
        AppMethodBeat.o(51550);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "summerbak start url, url:%s", new Object[] { parama });
      paramk = new z();
      paramk.dbR.url = parama;
      com.tencent.mm.sdk.b.a.ESL.l(paramk);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "publish BackupGetA8keyRedirectEvent");
      AppMethodBeat.o(51550);
      return true;
      paramOnClickListener = paramk.aAq();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "fullURL: ".concat(String.valueOf(paramOnClickListener)));
      paramString = parama.getContext();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "processAppBrandFullURL, fullURL: ".concat(String.valueOf(paramOnClickListener)));
      paramRunnable = Uri.parse(paramOnClickListener);
      if ((paramRunnable.getQueryParameter("search_query") != null) && (paramRunnable.getQueryParameter("search_query").length() > 0))
      {
        paramk = paramRunnable.getQueryParameter("search_query");
        paramString = paramRunnable.getQueryParameter("appid");
        paramBundle = paramRunnable.getQueryParameter("search_extInfo");
        paramInt1 = bt.getInt(paramRunnable.getQueryParameter("debug"), 0);
        paramInt2 = bt.getInt(paramRunnable.getQueryParameter("version"), 0);
        paramRunnable = new nc();
        paramRunnable.dsg.scene = 1;
        paramRunnable.dsg.appId = paramString;
        paramRunnable.dsg.type = paramInt1;
        paramRunnable.dsg.version = paramInt2;
        paramRunnable.dsg.dsh = paramk;
        paramRunnable.dsg.url = paramOnClickListener;
        paramRunnable.dsg.dsi = paramBundle;
        com.tencent.mm.sdk.b.a.ESL.l(paramRunnable);
        paramString = aa.ehS();
        paramString.putExtra("ftsbizscene", 99999);
        paramString.putExtra("ftsQuery", paramk);
        paramString.putExtra("ftsqrcodestring", paramOnClickListener);
        paramOnClickListener = aa.f(300, false, 262144);
        paramOnClickListener.put("query", paramk);
        paramk = aa.RY(bt.aGh((String)paramOnClickListener.get("scene")));
        paramOnClickListener.put("sessionid", paramk);
        paramString.putExtra("rawUrl", aa.aR(paramOnClickListener));
        paramString.putExtra("key_session_id", paramk);
        d.b(aj.getContext(), "webview", ".ui.tools.fts.FTSWebViewUI", paramString);
        parama.ok(false);
        AppMethodBeat.o(51550);
        return true;
      }
      if (bt.getInt(paramRunnable.getQueryParameter("qr_type4wxa"), 0) == 2) {
        paramk = uRu;
      }
      for (;;)
      {
        paramInt1 = paramk.get(paramInt2);
        ((com.tencent.mm.plugin.appbrand.service.o)g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).b(paramString, paramOnClickListener, paramInt1, paramBundle);
        break;
        switch (j)
        {
        default: 
          paramk = uRs;
          break;
        case 22: 
          paramk = uRt;
        }
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "jump to forceNotify UI");
      localIntent.putExtra("data", paramk.aAr());
      localIntent.setClassName(parama.getContext(), "com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI");
      parama.ok(false);
      parama = parama.getContext();
      paramk = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramk.adn(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramk.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(51550);
      return true;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect: %s, %s", new Object[] { paramString, paramk.aAq() });
      paramk = paramk.aAq();
      ((com.tencent.mm.plugin.emojicapture.api.a)g.ad(com.tencent.mm.plugin.emojicapture.api.a.class)).prepareStickerPreview(parama.getContext(), paramk, new a.b()
      {
        public final void df(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(51541);
          this.uRx.ok(paramAnonymousBoolean);
          AppMethodBeat.o(51541);
        }
      });
      AppMethodBeat.o(51550);
      return true;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect: %s, %s", new Object[] { paramString, paramk.aAq() });
      paramk = paramk.aAq();
      ((com.tencent.mm.plugin.emojicapture.api.a)g.ad(com.tencent.mm.plugin.emojicapture.api.a.class)).prepareEmojiCapture(parama.getContext(), paramk, new a.b()
      {
        public final void df(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(51542);
          this.uRx.ok(paramAnonymousBoolean);
          AppMethodBeat.o(51542);
        }
      });
      AppMethodBeat.o(51550);
      return true;
      ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).gotoRedPacketPreviewUI(parama.getContext(), paramString);
      parama.ok(false);
      AppMethodBeat.o(51550);
      return true;
      paramOnClickListener = new Intent();
      paramOnClickListener.putExtra("key_qrcode_string", paramk.aAq());
      d.b(parama.getContext(), "account", ".friend.ui.RecoverAccountUI1", paramOnClickListener);
      new ap(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
      parama = new gv();
      parama.dJy = 1;
      parama.aBj();
      AppMethodBeat.o(51550);
      return true;
    }
  }
  
  public static abstract interface a
  {
    public abstract Context getContext();
    
    public abstract void ok(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.v.a.a
 * JD-Core Version:    0.7.0.1
 */