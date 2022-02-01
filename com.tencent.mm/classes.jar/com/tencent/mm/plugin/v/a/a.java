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
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ac;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.je.b;
import com.tencent.mm.g.a.om;
import com.tencent.mm.g.a.tm;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.g.b.a.ns;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.emojicapture.api.a.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.scanner.model.am;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.VcardContactUI;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.plugin.scanner.util.r.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.e.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class a
{
  private static final SparseIntArray BxP;
  private static final SparseIntArray BxQ;
  private static final SparseIntArray BxR;
  
  static
  {
    AppMethodBeat.i(51552);
    BxP = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(51547);
        paramAnonymousInt = super.get(paramAnonymousInt, 1011);
        AppMethodBeat.o(51547);
        return paramAnonymousInt;
      }
    };
    BxQ = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(51549);
        paramAnonymousInt = super.get(paramAnonymousInt, 1047);
        AppMethodBeat.o(51549);
        return paramAnonymousInt;
      }
    };
    BxR = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(240702);
        paramAnonymousInt = super.get(paramAnonymousInt, 1124);
        AppMethodBeat.o(240702);
        return paramAnonymousInt;
      }
    };
    AppMethodBeat.o(51552);
  }
  
  protected static int Vl(int paramInt)
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
    Log.d("MicroMsg.scanner.GetA8KeyRedirect", "actionCode = %s, url = %s", new Object[] { Integer.valueOf(paramInt1), paramString });
    final je localje = new je();
    localje.dNT.actionCode = paramInt1;
    localje.dNT.result = paramString;
    localje.dNT.context = parama.getContext();
    paramString = new Bundle();
    paramString.putInt("pay_channel", paramInt2);
    localje.dNT.dNV = paramString;
    localje.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(240705);
        if ((this.BxU == null) || (localje == null) || (localje.dNU == null))
        {
          AppMethodBeat.o(240705);
          return;
        }
        if (localje.dNU.ret == 1)
        {
          this.BxU.sU(true);
          AppMethodBeat.o(240705);
          return;
        }
        if (localje.dNU.ret == 2) {
          this.BxU.sU(false);
        }
        AppMethodBeat.o(240705);
      }
    };
    EventCenter.instance.asyncPublish(localje, Looper.myLooper());
    AppMethodBeat.o(51551);
  }
  
  public static boolean a(final a parama, final l paraml, DialogInterface.OnClickListener paramOnClickListener, final String paramString, final int paramInt1, final int paramInt2, final Runnable paramRunnable, Bundle paramBundle)
  {
    AppMethodBeat.i(51550);
    if (parama.getContext() == null)
    {
      Log.e("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect, null redirectContext");
      AppMethodBeat.o(51550);
      return false;
    }
    int i = paraml.beS();
    int j = ((bhi)paraml.rr.iLK.iLR).Ljb;
    Log.i("MicroMsg.scanner.GetA8KeyRedirect", "actionCode : %s, codeType : %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    Log.i("MicroMsg.scanner.GetA8KeyRedirect", "source=".concat(String.valueOf(paramInt1)));
    Intent localIntent = new Intent();
    localIntent.putExtra("geta8key_scene", paramInt1);
    localIntent.putExtra("KPublisherId", "qrcode");
    localIntent.putExtra("prePublishId", "qrcode");
    com.tencent.mm.pluginsdk.wallet.h.setPayChannel(Vl(paramInt1));
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
      Log.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-not_catch: action code = " + paraml.beS());
      AppMethodBeat.o(51550);
      return false;
    case 1: 
      Log.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-text: " + paraml.getContent());
      ((com.tencent.mm.plugin.expt.b.a)g.af(com.tencent.mm.plugin.expt.b.a.class)).aod(paraml.getContent());
      localIntent.putExtra("data", paraml.getContent());
      localIntent.putExtra("showShare", false);
      if (paramInt2 == 2) {
        localIntent.putExtra("stastic_scene", 13);
      }
      for (;;)
      {
        localIntent.putExtra("pay_channel", Vl(paramInt1));
        localIntent.putExtra("geta8key_session_id", paraml.beY());
        com.tencent.mm.plugin.scanner.h.jRt.i(localIntent, parama.getContext());
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
      Log.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview: " + paraml.beQ());
      paramRunnable = parama.getContext();
      paramBundle = parama.getContext();
      if (!Util.isNullOrNil(paramString)) {}
      for (;;)
      {
        com.tencent.mm.ui.base.h.a(paramRunnable, paramBundle.getString(2131764138, new Object[] { paramString }), parama.getContext().getString(2131755998), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(51538);
            this.val$intent.putExtra("title", paraml.getTitle());
            this.val$intent.putExtra("rawUrl", paraml.beQ());
            if (paramInt2 == 2) {
              this.val$intent.putExtra("stastic_scene", 13);
            }
            for (;;)
            {
              this.val$intent.putExtra("pay_channel", a.Vl(paramInt1));
              this.val$intent.putExtra("geta8key_session_id", paraml.beY());
              this.val$intent.putExtra("geta8key_cookie", paraml.bfa());
              this.val$intent.putExtra("key_enable_teen_mode_check", true);
              com.tencent.mm.plugin.scanner.h.jRt.i(this.val$intent, parama.getContext());
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
        paramString = paraml.beQ();
      }
    case 7: 
    case 30: 
      Log.i("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview_no_notice: reqUrl : %s,  fullUrl : %s, shareUrl : %s", new Object[] { paraml.beR(), paraml.beQ(), paraml.beU() });
      if (((b)g.af(b.class)).a(b.a.rTl, 0) == 1) {
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
        paramOnClickListener = (bhj)paraml.rr.iLL.iLR;
        localIntent.putExtra("key_scan_qr_code_get_a8key_req", ((bhi)paraml.rr.iLK.iLR).toByteArray());
        localIntent.putExtra("key_scan_qr_code_get_a8key_resp", paramOnClickListener.toByteArray());
        localIntent.putExtra("title", paraml.getTitle());
        localIntent.putExtra("rawUrl", paraml.beQ());
        localIntent.putExtra("k_share_url", paraml.beU());
        if (paramInt2 == 2) {
          localIntent.putExtra("stastic_scene", 13);
        }
        Object localObject1;
        for (;;)
        {
          Log.i("MicroMsg.scanner.GetA8KeyRedirect", "start webview with channel : ".concat(String.valueOf(Vl(paramInt1))));
          localIntent.putExtra("pay_channel", Vl(paramInt1));
          localIntent.putExtra("geta8key_session_id", paraml.beY());
          localIntent.putExtra("geta8key_cookie", paraml.bfa());
          paraml = paraml.beX();
          if (Util.isNullOrNil(paraml)) {
            break label1170;
          }
          paramOnClickListener = paraml.iterator();
          do
          {
            if (!paramOnClickListener.hasNext()) {
              break;
            }
            localObject1 = (ccc)paramOnClickListener.next();
          } while ((localObject1 != null) && (!Util.isNullOrNil(((ccc)localObject1).xMX)) && (!Util.isNullOrNil(((ccc)localObject1).Cyk)));
          Log.e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
          paramInt1 = 1;
          if (paramInt1 != 0) {
            break label1170;
          }
          paramOnClickListener = new String[paraml.size()];
          localObject1 = new String[paraml.size()];
          paramInt1 = 0;
          while (paramInt1 < paraml.size())
          {
            Object localObject2 = (ccc)paraml.get(paramInt1);
            String str = ((ccc)localObject2).xMX;
            localObject2 = ((ccc)localObject2).Cyk;
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
        label1170:
        if ((i == 30) && (((b)g.af(b.class)).a(b.a.rSw, 0) == 1))
        {
          localIntent.putExtra("auth_raw_url", paramString);
          localIntent.putExtra("auth_from_scan", true);
          com.tencent.mm.br.c.b(parama.getContext(), "webview", ".ui.tools.SDKOAuthUI", localIntent);
          new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
          AppMethodBeat.o(51550);
          return true;
        }
        if ((paramBundle != null) && (paramBundle.getString("stat_send_msg_user") != null)) {
          localIntent.putExtra(e.p.OzH, paramBundle.getString("stat_send_msg_user"));
        }
        localIntent.putExtra("key_enable_teen_mode_check", true);
        com.tencent.mm.plugin.scanner.h.jRt.i(localIntent, parama.getContext());
        new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        Log.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-special_webview: " + paraml.beQ());
        localIntent.putExtra("rawUrl", paraml.beQ());
        localIntent.putExtra("pay_channel", Vl(paramInt1));
        localIntent.putExtra("showShare", false);
        localIntent.putExtra("show_bottom", false);
        localIntent.putExtra("isWebwx", false);
        localIntent.putExtra("geta8key_session_id", paraml.beY());
        localIntent.putExtra("geta8key_cookie", paraml.bfa());
        localIntent.putExtra("key_enable_teen_mode_check", true);
        com.tencent.mm.plugin.scanner.h.jRt.i(localIntent, parama.getContext());
        AppMethodBeat.o(51550);
        return true;
        AppMethodBeat.o(51550);
        return false;
        paramString = paraml.beQ();
        Log.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app: ".concat(String.valueOf(paramString)));
        if ((paramString == null) || (paramString.length() == 0))
        {
          Log.e("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app, fullUrl is null");
          AppMethodBeat.o(51550);
          return false;
        }
        paraml = parama.getContext().getString(2131764137);
        if (paramString.startsWith("http")) {
          paraml = parama.getContext().getString(2131764138, new Object[] { paramString });
        }
        paramString = Uri.parse(paramString);
        if (paramString != null)
        {
          paramString = new Intent("android.intent.action.VIEW", paramString);
          paramString.addFlags(268435456);
          if (Util.isIntentAvailable(parama.getContext(), paramString))
          {
            com.tencent.mm.ui.base.h.a(parama.getContext(), paraml, parama.getContext().getString(2131755998), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(51539);
                paramAnonymousDialogInterface = this.BxU.getContext();
                Object localObject = paramString;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
        Log.d("MicroMsg.scanner.GetA8KeyRedirect", "get vcard from server: ".concat(String.valueOf(paraml)));
        if (!Util.isNullOrNil(paraml)) {
          paramString = new am();
        }
        try
        {
          paramString.aME(paraml);
          paramRunnable = new Intent(parama.getContext(), VcardContactUI.class);
          paramString = parama.getContext();
          paramRunnable = new com.tencent.mm.hellhoundlib.b.a().bl(paramRunnable);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramRunnable.axQ(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramRunnable.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.sU(false);
          AppMethodBeat.o(51550);
          return true;
        }
        catch (XmlPullParserException paramString)
        {
          Log.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + paramString.getMessage() + " " + paraml);
          Log.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", paramString, "", new Object[0]);
          com.tencent.mm.ui.base.h.a(parama.getContext(), parama.getContext().getString(2131764148), parama.getContext().getString(2131755998), false, paramOnClickListener);
          AppMethodBeat.o(51550);
          return true;
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            Log.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + paramString.getMessage() + " " + paraml);
            Log.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", paramString, "", new Object[0]);
          }
        }
        Log.d("MicroMsg.scanner.GetA8KeyRedirect", "ftf pay url:" + paraml.beQ());
        f.a(parama.getContext(), 1, paraml.beQ(), Vl(paramInt1), null);
        new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        paramOnClickListener = new Bundle();
        paramOnClickListener.putInt("key_scene", 5);
        bool = com.tencent.mm.plugin.scanner.h.jRt.b(parama.getContext(), paraml.beQ(), paramOnClickListener);
        AppMethodBeat.o(51550);
        return bool;
        a(parama, i, paraml.beQ(), Vl(paramInt1));
        new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        a(parama, i, paraml.beQ(), Vl(paramInt1));
        AppMethodBeat.o(51550);
        return true;
        paramOnClickListener = paraml.beQ();
        paraml = paramOnClickListener;
        if (paramOnClickListener != null) {
          paraml = paramOnClickListener.replace("wxpd://", "");
        }
        paramOnClickListener = new Intent();
        paramOnClickListener.putExtra("key_product_id", paraml);
        paramOnClickListener.putExtra("key_product_scene", 7);
        com.tencent.mm.br.c.b(parama.getContext(), "product", ".ui.MallProductUI", paramOnClickListener);
        AppMethodBeat.o(51550);
        return true;
        paramOnClickListener = new Intent();
        paramOnClickListener.setClass(parama.getContext(), ProductUI.class);
        paramOnClickListener.putExtra("key_ProductUI_getProductInfoScene", 5);
        paramOnClickListener.putExtra("key_Qrcode_Url", paraml.beQ());
        parama = parama.getContext();
        paraml = new com.tencent.mm.hellhoundlib.b.a().bl(paramOnClickListener);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paraml.axQ(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paraml.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(51550);
        return true;
        paramOnClickListener = paraml.beQ();
        parama = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService");
        paraml = Util.createExplicitFromImplicitIntent(MMApplicationContext.getContext(), parama);
        if (paraml != null) {
          parama = paraml;
        }
        for (;;)
        {
          com.tencent.mm.br.c.startService(parama.putExtra("url", paramOnClickListener).putExtra("isFromWifi", true));
          Log.d("MicroMsg.scanner.GetA8KeyRedirect", "GET_CONNECT_INFO start end");
          AppMethodBeat.o(51550);
          return true;
        }
        paraml = r.aMU(paraml.beQ());
        if (paraml == null) {
          Log.e("MicroMsg.scanner.GetA8KeyRedirect", "item == null");
        }
        for (;;)
        {
          AppMethodBeat.o(51550);
          return false;
          if (r.Eg(paraml.nHh)) {
            break;
          }
          r.bv(parama.getContext(), parama.getContext().getString(2131757117));
        }
        paramOnClickListener = new Intent();
        paramOnClickListener.putExtra("key_card_id", paraml.pRX);
        paramOnClickListener.putExtra("key_card_ext", paraml.eaP);
        paramOnClickListener.putExtra("key_from_scene", 0);
        if (paramInt2 == 2) {
          paramOnClickListener.putExtra("key_stastic_scene", 13);
        }
        for (;;)
        {
          com.tencent.mm.br.c.b(parama.getContext(), "card", ".ui.CardDetailUI", paramOnClickListener);
          Log.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_CARD start end");
          break;
          if (paramInt2 == 1) {
            paramOnClickListener.putExtra("key_stastic_scene", 14);
          } else {
            paramOnClickListener.putExtra("key_stastic_scene", 11);
          }
        }
        paraml = paraml.beQ();
        paramOnClickListener = r.aMV(paraml);
        if ((paramOnClickListener == null) || (paramOnClickListener.size() == 0)) {
          Log.e("MicroMsg.scanner.GetA8KeyRedirect", "list == null || list.size() == 0");
        }
        for (;;)
        {
          AppMethodBeat.o(51550);
          return false;
          if (r.aO(paramOnClickListener)) {
            break;
          }
          r.bv(parama.getContext(), parama.getContext().getString(2131757117));
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
          com.tencent.mm.br.c.b(parama.getContext(), "card", ".ui.CardAddEntranceUI", paramOnClickListener);
          Log.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_MULTIPLE_CARD start end");
          break;
          if (paramInt2 == 1) {
            paramOnClickListener.putExtra("key_stastic_scene", 14);
          } else {
            paramOnClickListener.putExtra("key_stastic_scene", 11);
          }
        }
        paramRunnable = new Intent();
        paramRunnable.putExtra("free_wifi_url", paraml.beQ());
        paramString = (bhj)paraml.rr.iLL.iLR;
        if ((paramString == null) || (paramString.KCt == null))
        {
          Log.e("MicroMsg.NetSceneGetA8Key", "get mid failed");
          paramString = null;
          paramRunnable.putExtra("free_wifi_mid", paramString);
          paramString = (bhj)paraml.rr.iLL.iLR;
          if ((paramString != null) && (paramString.SSID != null)) {
            break label2994;
          }
          Log.e("MicroMsg.NetSceneGetA8Key", "get ssid failed");
          paramString = null;
          label2897:
          paramRunnable.putExtra("free_wifi_ssid", paramString);
          paramRunnable.putExtra("free_wifi_source", 1);
          paramRunnable.putExtra("free_wifi_ap_key", paraml.beQ());
          if (g.aAh().azQ().get(303104, null) == null) {
            break label3002;
          }
          com.tencent.mm.ui.base.h.a(parama.getContext(), 2131760938, 2131755998, 2131755771, 2131755761, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(51540);
              com.tencent.mm.br.c.b(this.BxU.getContext(), "freewifi", ".ui.FreeWifiEntryUI", paramRunnable);
              this.BxU.sU(false);
              AppMethodBeat.o(51540);
            }
          }, paramOnClickListener);
        }
        for (;;)
        {
          AppMethodBeat.o(51550);
          return true;
          paramString = paramString.KCt;
          break;
          label2994:
          paramString = paramString.SSID;
          break label2897;
          label3002:
          com.tencent.mm.br.c.b(parama.getContext(), "freewifi", ".ui.FreeWifiEntryUI", paramRunnable);
          parama.sU(false);
        }
        Log.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-emoticon full url: " + paraml.beQ());
        parama = new com.tencent.mm.aq.c(paraml.beQ());
        g.azz().a(parama, 0);
        AppMethodBeat.o(51550);
        return true;
        if (!WeChatBrands.Business.Entries.DiscoveryScanExtDevice.checkAvailable(parama.getContext(), new android.support.v4.e.c() {}))
        {
          AppMethodBeat.o(51550);
          return true;
        }
        parama = new tm();
        parama.dZV.dZW = paramString;
        EventCenter.instance.publish(parama);
        AppMethodBeat.o(51550);
        return true;
        parama = new tn();
        parama.dZX.dZW = paramString;
        parama.dZX.deviceName = com.tencent.mm.protocal.d.DEVICE_NAME;
        EventCenter.instance.publish(parama);
        new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        parama = paraml.beQ();
        if (Util.isNullOrNil(parama))
        {
          Log.e("MicroMsg.scanner.GetA8KeyRedirect", "onStartCommand url is null");
          AppMethodBeat.o(51550);
          return true;
        }
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "summerbak start url, url:%s", new Object[] { parama });
        paraml = new ac();
        paraml.dDa.url = parama;
        EventCenter.instance.publish(paraml);
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "publish BackupGetA8keyRedirectEvent");
        AppMethodBeat.o(51550);
        return true;
        paramOnClickListener = paraml.beQ();
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "fullURL: ".concat(String.valueOf(paramOnClickListener)));
        paramRunnable = paraml.jjj;
        paramRunnable.putLong("CgiSpeedOutSideStructResponseSize", ((bhj)paraml.rr.iLL.iLR).computeSize());
        paramRunnable.putInt("CgiSpeedOutSideStructBizRet", ((bhj)paraml.rr.iLL.iLR).BaseResponse.Ret);
        paramRunnable.putString("CgiSpeedOutSideStructNetworkType", ((n)g.af(n.class)).bUg());
        paramString = new Bundle();
        paramString.putBundle("stat_get_a8_key_cgi_speed", paramRunnable);
        paramRunnable = parama.getContext();
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "processAppBrandFullURL, fullURL: ".concat(String.valueOf(paramOnClickListener)));
        paraml = Uri.parse(paramOnClickListener);
        if ((paraml.getQueryParameter("search_query") != null) && (paraml.getQueryParameter("search_query").length() > 0))
        {
          paramString = paraml.getQueryParameter("search_query");
          paramRunnable = paraml.getQueryParameter("appid");
          paramBundle = paraml.getQueryParameter("search_extInfo");
          paramInt1 = Util.getInt(paraml.getQueryParameter("debug"), 0);
          paramInt2 = Util.getInt(paraml.getQueryParameter("version"), 0);
          paraml = new om();
          paraml.dUz.scene = 1;
          paraml.dUz.appId = paramRunnable;
          paraml.dUz.type = paramInt1;
          paraml.dUz.version = paramInt2;
          paraml.dUz.dUA = paramString;
          paraml.dUz.url = paramOnClickListener;
          paraml.dUz.dUB = paramBundle;
          EventCenter.instance.publish(paraml);
          paraml = ai.fXX();
          paraml.putExtra("ftsbizscene", 99999);
          paraml.putExtra("ftsQuery", paramString);
          paraml.putExtra("ftsqrcodestring", paramOnClickListener);
          paramOnClickListener = ai.h(300, false, 262144);
          paramOnClickListener.put("query", paramString);
          paramString = ai.afq(Util.safeParseInt((String)paramOnClickListener.get("scene")));
          paramOnClickListener.put("sessionid", paramString);
          paraml.putExtra("rawUrl", ai.bd(paramOnClickListener));
          paraml.putExtra("key_session_id", paramString);
          com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.fts.FTSWebViewUI", paraml);
          parama.sU(false);
          AppMethodBeat.o(51550);
          return true;
        }
        if (Util.getInt(paraml.getQueryParameter("qr_type4wxa"), 0) == 2) {
          paraml = BxR;
        }
        for (;;)
        {
          paramInt1 = paraml.get(paramInt2);
          ((s)g.af(s.class)).b(paramRunnable, paramOnClickListener, paramInt1, paramBundle, paramString);
          break;
          switch (j)
          {
          default: 
            paraml = BxP;
            break;
          case 22: 
            paraml = BxQ;
          }
        }
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "jump to forceNotify UI");
        localIntent.putExtra("data", paraml.beR());
        localIntent.setClassName(parama.getContext(), "com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI");
        parama.sU(false);
        parama = parama.getContext();
        paraml = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paraml.axQ(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paraml.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(51550);
        return true;
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect: %s, %s", new Object[] { paramString, paraml.beQ() });
        paraml = paraml.beQ();
        ((com.tencent.mm.plugin.emojicapture.api.a)g.ah(com.tencent.mm.plugin.emojicapture.api.a.class)).prepareStickerPreview(parama.getContext(), paraml, new a.b()
        {
          public final void dQ(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(51542);
            this.BxU.sU(paramAnonymousBoolean);
            AppMethodBeat.o(51542);
          }
        });
        AppMethodBeat.o(51550);
        return true;
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect: %s, %s", new Object[] { paramString, paraml.beQ() });
        paraml = paraml.beQ();
        ((com.tencent.mm.plugin.emojicapture.api.a)g.ah(com.tencent.mm.plugin.emojicapture.api.a.class)).prepareEmojiCapture(parama.getContext(), paraml, new a.b()
        {
          public final void dQ(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(240704);
            this.BxU.sU(paramAnonymousBoolean);
            AppMethodBeat.o(240704);
          }
        });
        AppMethodBeat.o(51550);
        return true;
        ((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).gotoRedPacketPreviewUI(parama.getContext(), paramString);
        parama.sU(false);
        AppMethodBeat.o(51550);
        return true;
        paramOnClickListener = new Intent();
        paramOnClickListener.putExtra("key_qrcode_string", paraml.beQ());
        com.tencent.mm.br.c.b(parama.getContext(), "account", ".friend.ui.RecoverAccountUI1", paramOnClickListener);
        new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        parama = new ns();
        parama.eqm = 1;
        parama.bfK();
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
    
    public abstract void sU(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.v.a.a
 * JD-Core Version:    0.7.0.1
 */