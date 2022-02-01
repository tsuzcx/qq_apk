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
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.q;
import com.tencent.mm.ar.c;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.aa;
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.a.io.b;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.b.a.js;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.plugin.appbrand.service.l;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.emojicapture.api.a.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.VcardContactUI;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.plugin.scanner.util.o.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.bos;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.e.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class a
{
  private static final SparseIntArray xhR;
  private static final SparseIntArray xhS;
  private static final SparseIntArray xhT;
  
  static
  {
    AppMethodBeat.i(51552);
    xhR = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(51545);
        paramAnonymousInt = super.get(paramAnonymousInt, 1011);
        AppMethodBeat.o(51545);
        return paramAnonymousInt;
      }
    };
    xhS = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(51547);
        paramAnonymousInt = super.get(paramAnonymousInt, 1047);
        AppMethodBeat.o(51547);
        return paramAnonymousInt;
      }
    };
    xhT = new SparseIntArray()
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
  
  protected static int Nq(int paramInt)
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
    final io localio = new io();
    localio.dvh.actionCode = paramInt1;
    localio.dvh.result = paramString;
    localio.dvh.context = parama.getContext();
    paramString = new Bundle();
    paramString.putInt("pay_channel", paramInt2);
    localio.dvh.dvj = paramString;
    localio.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51543);
        if ((this.xhW == null) || (localio == null) || (localio.dvi == null))
        {
          AppMethodBeat.o(51543);
          return;
        }
        if (localio.dvi.ret == 1)
        {
          this.xhW.pB(true);
          AppMethodBeat.o(51543);
          return;
        }
        if (localio.dvi.ret == 2) {
          this.xhW.pB(false);
        }
        AppMethodBeat.o(51543);
      }
    };
    com.tencent.mm.sdk.b.a.IbL.a(localio, Looper.myLooper());
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
    int i = paramk.aKt();
    int j = ((avi)paramk.rr.hNK.hNQ).FVR;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "actionCode : %s, codeType : %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "source=".concat(String.valueOf(paramInt1)));
    Intent localIntent = new Intent();
    localIntent.putExtra("geta8key_scene", paramInt1);
    localIntent.putExtra("KPublisherId", "qrcode");
    localIntent.putExtra("prePublishId", "qrcode");
    com.tencent.mm.pluginsdk.wallet.h.Zx(Nq(paramInt1));
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
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-not_catch: action code = " + paramk.aKt());
      AppMethodBeat.o(51550);
      return false;
    case 1: 
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-text: " + paramk.getContent());
      ((com.tencent.mm.plugin.expt.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.a.class)).add(paramk.getContent());
      localIntent.putExtra("data", paramk.getContent());
      localIntent.putExtra("showShare", false);
      if (paramInt2 == 2) {
        localIntent.putExtra("stastic_scene", 13);
      }
      for (;;)
      {
        localIntent.putExtra("pay_channel", Nq(paramInt1));
        localIntent.putExtra("geta8key_session_id", paramk.aKz());
        com.tencent.mm.plugin.scanner.g.iRG.i(localIntent, parama.getContext());
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
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview: " + paramk.aKr());
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
            this.val$intent.putExtra("rawUrl", paramk.aKr());
            if (paramInt2 == 2) {
              this.val$intent.putExtra("stastic_scene", 13);
            }
            for (;;)
            {
              this.val$intent.putExtra("pay_channel", a.Nq(paramInt1));
              this.val$intent.putExtra("geta8key_session_id", paramk.aKz());
              this.val$intent.putExtra("geta8key_cookie", paramk.aKB());
              com.tencent.mm.plugin.scanner.g.iRG.i(this.val$intent, parama.getContext());
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
        paramString = paramk.aKr();
      }
    case 7: 
    case 30: 
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview_no_notice: reqUrl : %s,  fullUrl : %s, shareUrl : %s", new Object[] { paramk.aKs(), paramk.aKr(), paramk.aKv() });
      localIntent.putExtra("title", paramk.getTitle());
      localIntent.putExtra("rawUrl", paramk.aKr());
      localIntent.putExtra("k_share_url", paramk.aKv());
      if (paramInt2 == 2)
      {
        localIntent.putExtra("stastic_scene", 13);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "start webview with channel : ".concat(String.valueOf(Nq(paramInt1))));
        localIntent.putExtra("pay_channel", Nq(paramInt1));
        localIntent.putExtra("geta8key_session_id", paramk.aKz());
        localIntent.putExtra("geta8key_cookie", paramk.aKB());
        paramk = paramk.aKy();
        if (bt.hj(paramk)) {
          break label1057;
        }
        paramOnClickListener = paramk.iterator();
        while (paramOnClickListener.hasNext())
        {
          localObject1 = (bos)paramOnClickListener.next();
          if ((localObject1 == null) || (bt.isNullOrNil(((bos)localObject1).ujy)) || (bt.isNullOrNil(((bos)localObject1).yhw))) {
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
            Object localObject2 = (bos)paramk.get(paramInt1);
            String str = ((bos)localObject2).ujy;
            localObject2 = ((bos)localObject2).yhw;
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
      label1057:
      if ((i == 30) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qtv, 0) == 1))
      {
        localIntent.putExtra("auth_raw_url", paramString);
        localIntent.putExtra("auth_from_scan", true);
        d.b(parama.getContext(), "webview", ".ui.tools.SDKOAuthUI", localIntent);
        new ap(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
      }
      if ((paramBundle != null) && (paramBundle.getString("stat_send_msg_user") != null)) {
        localIntent.putExtra(e.m.IUY, paramBundle.getString("stat_send_msg_user"));
      }
      com.tencent.mm.plugin.scanner.g.iRG.i(localIntent, parama.getContext());
      new ap(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
      AppMethodBeat.o(51550);
      return true;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-special_webview: " + paramk.aKr());
      localIntent.putExtra("rawUrl", paramk.aKr());
      localIntent.putExtra("pay_channel", Nq(paramInt1));
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("isWebwx", false);
      localIntent.putExtra("geta8key_session_id", paramk.aKz());
      localIntent.putExtra("geta8key_cookie", paramk.aKB());
      com.tencent.mm.plugin.scanner.g.iRG.i(localIntent, parama.getContext());
      AppMethodBeat.o(51550);
      return true;
      AppMethodBeat.o(51550);
      return false;
      paramString = paramk.aKr();
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
        if (bt.aj(parama.getContext(), paramString))
        {
          com.tencent.mm.ui.base.h.a(parama.getContext(), paramk, parama.getContext().getString(2131755906), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(51539);
              paramAnonymousDialogInterface = this.xhW.getContext();
              Object localObject = paramString;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
        paramString = new com.tencent.mm.plugin.scanner.model.ai();
      }
      try
      {
        paramString.awL(paramk);
        paramRunnable = new Intent(parama.getContext(), VcardContactUI.class);
        paramString = parama.getContext();
        paramRunnable = new com.tencent.mm.hellhoundlib.b.a().bc(paramRunnable);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, paramRunnable.ahp(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramRunnable.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.pB(false);
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
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.scanner.GetA8KeyRedirect", "ftf pay url:" + paramk.aKr());
      f.a(parama.getContext(), 1, paramk.aKr(), Nq(paramInt1), null);
      new ap(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
      AppMethodBeat.o(51550);
      return true;
      paramOnClickListener = new Bundle();
      paramOnClickListener.putInt("key_scene", 5);
      boolean bool = com.tencent.mm.plugin.scanner.g.iRG.b(parama.getContext(), paramk.aKr(), paramOnClickListener);
      AppMethodBeat.o(51550);
      return bool;
      a(parama, i, paramk.aKr(), Nq(paramInt1));
      new ap(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
      AppMethodBeat.o(51550);
      return true;
      a(parama, i, paramk.aKr(), Nq(paramInt1));
      AppMethodBeat.o(51550);
      return true;
      paramOnClickListener = paramk.aKr();
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
      paramOnClickListener.putExtra("key_Qrcode_Url", paramk.aKr());
      parama = parama.getContext();
      paramk = new com.tencent.mm.hellhoundlib.b.a().bc(paramOnClickListener);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramk.ahp(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramk.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(51550);
      return true;
      paramOnClickListener = paramk.aKr();
      parama = new Intent().setClassName(aj.getContext(), "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService");
      paramk = bt.ak(aj.getContext(), parama);
      if (paramk != null) {
        parama = paramk;
      }
      for (;;)
      {
        d.be(parama.putExtra("url", paramOnClickListener).putExtra("isFromWifi", true));
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.scanner.GetA8KeyRedirect", "GET_CONNECT_INFO start end");
        AppMethodBeat.o(51550);
        return true;
      }
      paramk = o.axa(paramk.aKr());
      if (paramk == null) {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.scanner.GetA8KeyRedirect", "item == null");
      }
      for (;;)
      {
        AppMethodBeat.o(51550);
        return false;
        if (o.Ap(paramk.mrl)) {
          break;
        }
        o.bb(parama.getContext(), parama.getContext().getString(2131756947));
      }
      paramOnClickListener = new Intent();
      paramOnClickListener.putExtra("key_card_id", paramk.oxM);
      paramOnClickListener.putExtra("key_card_ext", paramk.dHY);
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
      paramk = paramk.aKr();
      paramOnClickListener = o.axb(paramk);
      if ((paramOnClickListener == null) || (paramOnClickListener.size() == 0)) {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.scanner.GetA8KeyRedirect", "list == null || list.size() == 0");
      }
      for (;;)
      {
        AppMethodBeat.o(51550);
        return false;
        if (o.aw(paramOnClickListener)) {
          break;
        }
        o.bb(parama.getContext(), parama.getContext().getString(2131756947));
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
      paramRunnable.putExtra("free_wifi_url", paramk.aKr());
      paramString = (avj)paramk.rr.hNL.hNQ;
      if ((paramString == null) || (paramString.FqD == null))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetA8Key", "get mid failed");
        paramString = null;
        paramRunnable.putExtra("free_wifi_mid", paramString);
        paramString = (avj)paramk.rr.hNL.hNQ;
        if ((paramString != null) && (paramString.SSID != null)) {
          break label2860;
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetA8Key", "get ssid failed");
        paramString = null;
        label2763:
        paramRunnable.putExtra("free_wifi_ssid", paramString);
        paramRunnable.putExtra("free_wifi_source", 1);
        paramRunnable.putExtra("free_wifi_ap_key", paramk.aKr());
        if (com.tencent.mm.kernel.g.ajC().ajl().get(303104, null) == null) {
          break label2868;
        }
        com.tencent.mm.ui.base.h.a(parama.getContext(), 2131759617, 2131755906, 2131755700, 2131755691, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(51540);
            d.b(this.xhW.getContext(), "freewifi", ".ui.FreeWifiEntryUI", paramRunnable);
            this.xhW.pB(false);
            AppMethodBeat.o(51540);
          }
        }, paramOnClickListener);
      }
      for (;;)
      {
        AppMethodBeat.o(51550);
        return true;
        paramString = paramString.FqD;
        break;
        label2860:
        paramString = paramString.SSID;
        break label2763;
        label2868:
        d.b(parama.getContext(), "freewifi", ".ui.FreeWifiEntryUI", paramRunnable);
        parama.pB(false);
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-emoticon full url: " + paramk.aKr());
      parama = new c(paramk.aKr());
      com.tencent.mm.kernel.g.aiU().a(parama, 0);
      AppMethodBeat.o(51550);
      return true;
      parama = new so();
      parama.dHd.dHe = paramString;
      com.tencent.mm.sdk.b.a.IbL.l(parama);
      AppMethodBeat.o(51550);
      return true;
      parama = paramk.aKr();
      if (bt.isNullOrNil(parama))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.scanner.GetA8KeyRedirect", "onStartCommand url is null");
        AppMethodBeat.o(51550);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "summerbak start url, url:%s", new Object[] { parama });
      paramk = new aa();
      paramk.dkI.url = parama;
      com.tencent.mm.sdk.b.a.IbL.l(paramk);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "publish BackupGetA8keyRedirectEvent");
      AppMethodBeat.o(51550);
      return true;
      paramOnClickListener = paramk.aKr();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "fullURL: ".concat(String.valueOf(paramOnClickListener)));
      paramRunnable = paramk.ili;
      paramRunnable.putLong("CgiSpeedOutSideStructResponseSize", ((avj)paramk.rr.hNL.hNQ).computeSize());
      paramRunnable.putInt("CgiSpeedOutSideStructBizRet", ((avj)paramk.rr.hNL.hNQ).BaseResponse.Ret);
      paramRunnable.putString("CgiSpeedOutSideStructNetworkType", ((l)com.tencent.mm.kernel.g.ab(l.class)).bxa());
      paramString = new Bundle();
      paramString.putBundle("stat_get_a8_key_cgi_speed", paramRunnable);
      paramRunnable = parama.getContext();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "processAppBrandFullURL, fullURL: ".concat(String.valueOf(paramOnClickListener)));
      paramk = Uri.parse(paramOnClickListener);
      if ((paramk.getQueryParameter("search_query") != null) && (paramk.getQueryParameter("search_query").length() > 0))
      {
        paramString = paramk.getQueryParameter("search_query");
        paramRunnable = paramk.getQueryParameter("appid");
        paramBundle = paramk.getQueryParameter("search_extInfo");
        paramInt1 = bt.getInt(paramk.getQueryParameter("debug"), 0);
        paramInt2 = bt.getInt(paramk.getQueryParameter("version"), 0);
        paramk = new nt();
        paramk.dBE.scene = 1;
        paramk.dBE.appId = paramRunnable;
        paramk.dBE.type = paramInt1;
        paramk.dBE.version = paramInt2;
        paramk.dBE.dBF = paramString;
        paramk.dBE.url = paramOnClickListener;
        paramk.dBE.dBG = paramBundle;
        com.tencent.mm.sdk.b.a.IbL.l(paramk);
        paramk = com.tencent.mm.plugin.websearch.api.ad.eMd();
        paramk.putExtra("ftsbizscene", 99999);
        paramk.putExtra("ftsQuery", paramString);
        paramk.putExtra("ftsqrcodestring", paramOnClickListener);
        paramOnClickListener = com.tencent.mm.plugin.websearch.api.ad.f(300, false, 262144);
        paramOnClickListener.put("query", paramString);
        paramString = com.tencent.mm.plugin.websearch.api.ad.Wb(bt.aRe((String)paramOnClickListener.get("scene")));
        paramOnClickListener.put("sessionid", paramString);
        paramk.putExtra("rawUrl", com.tencent.mm.plugin.websearch.api.ad.aY(paramOnClickListener));
        paramk.putExtra("key_session_id", paramString);
        d.b(aj.getContext(), "webview", ".ui.tools.fts.FTSWebViewUI", paramk);
        parama.pB(false);
        AppMethodBeat.o(51550);
        return true;
      }
      if (bt.getInt(paramk.getQueryParameter("qr_type4wxa"), 0) == 2) {
        paramk = xhT;
      }
      for (;;)
      {
        paramInt1 = paramk.get(paramInt2);
        ((p)com.tencent.mm.kernel.g.ab(p.class)).b(paramRunnable, paramOnClickListener, paramInt1, paramBundle, paramString);
        break;
        switch (j)
        {
        default: 
          paramk = xhR;
          break;
        case 22: 
          paramk = xhS;
        }
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "jump to forceNotify UI");
      localIntent.putExtra("data", paramk.aKs());
      localIntent.setClassName(parama.getContext(), "com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI");
      parama.pB(false);
      parama = parama.getContext();
      paramk = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramk.ahp(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramk.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(51550);
      return true;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect: %s, %s", new Object[] { paramString, paramk.aKr() });
      paramk = paramk.aKr();
      ((com.tencent.mm.plugin.emojicapture.api.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emojicapture.api.a.class)).prepareStickerPreview(parama.getContext(), paramk, new a.b()
      {
        public final void dg(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(51541);
          this.xhW.pB(paramAnonymousBoolean);
          AppMethodBeat.o(51541);
        }
      });
      AppMethodBeat.o(51550);
      return true;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect: %s, %s", new Object[] { paramString, paramk.aKr() });
      paramk = paramk.aKr();
      ((com.tencent.mm.plugin.emojicapture.api.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emojicapture.api.a.class)).prepareEmojiCapture(parama.getContext(), paramk, new a.b()
      {
        public final void dg(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(51542);
          this.xhW.pB(paramAnonymousBoolean);
          AppMethodBeat.o(51542);
        }
      });
      AppMethodBeat.o(51550);
      return true;
      ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).gotoRedPacketPreviewUI(parama.getContext(), paramString);
      parama.pB(false);
      AppMethodBeat.o(51550);
      return true;
      paramOnClickListener = new Intent();
      paramOnClickListener.putExtra("key_qrcode_string", paramk.aKr());
      d.b(parama.getContext(), "account", ".friend.ui.RecoverAccountUI1", paramOnClickListener);
      new ap(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
      parama = new js();
      parama.dUD = 1;
      parama.aLk();
      AppMethodBeat.o(51550);
      return true;
    }
  }
  
  public static abstract interface a
  {
    public abstract Context getContext();
    
    public abstract void pB(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.w.a.a
 * JD-Core Version:    0.7.0.1
 */