package com.tencent.mm.plugin.wallet.wecoin.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.g;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.bwm;
import com.tencent.mm.protocal.protobuf.cgj;
import com.tencent.mm.protocal.protobuf.cgl;
import com.tencent.mm.protocal.protobuf.cma;
import com.tencent.mm.protocal.protobuf.dms;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"lastClickSaveButtonTime", "", "getLastClickSaveButtonTime", "()J", "setLastClickSaveButtonTime", "(J)V", "disableMidasSDKX5", "", "divide", "", "d1", "", "d2", "roundingMode", "", "generateUniqueID", "getRealBottomHeight", "context", "Landroid/content/Context;", "handleNetRespError", "", "info", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "handleWeCoinInterceptWin", "interceptWin", "Lcom/tencent/mm/protocal/protobuf/InterceptPopUp;", "listener", "Lcom/tencent/mm/plugin/wallet/wecoin/model/InterceptWinClickListener;", "handleWeCoinJumpItem", "jumpItem", "Lcom/tencent/mm/protocal/protobuf/PopUpJumpInfo;", "hasShowWecoinEntranceTutorial", "hasShowWecoinTutorial", "isCgiReturnError", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "callback", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "isFastClick", "isMidasInitOnceABTest", "isWeCoinCloseEntranceABTestHit", "loadWecoinBalanceSnapshot", "loadWecoinIncomePageInfoResponseSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetIncomePageInfoResponse;", "loadWecoinPageInfoResponseSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPageInfoResponse;", "loadWecoinPriceListResponseSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPriceListResponse;", "multiply", "printPbLog", "tag", "originObj", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "saveWecoinBalanceSnapshot", "balance", "saveWecoinIncomePageInfoResponseSnapshot", "response", "saveWecoinPageInfoResponseSnapshot", "saveWecoinPriceListResponseSnapshot", "setFixedTextSize", "textView", "Landroid/widget/TextView;", "dpSize", "setHasShowWecoinEntranceTutorial", "setHasShowWecoinTutorial", "plugin-wxpay_release"})
public final class c
{
  private static long Otm;
  
  public static final void Tq(long paramLong)
  {
    AppMethodBeat.i(267224);
    f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.Vwo, Long.valueOf(paramLong));
    AppMethodBeat.o(267224);
  }
  
  public static final void a(Context paramContext, com.tencent.mm.plugin.wallet.wecoin.model.a parama)
  {
    AppMethodBeat.i(267217);
    p.k(paramContext, "context");
    if (parama != null)
    {
      if ((parama.fyO != 0) || (parama.errorCode != 0))
      {
        CharSequence localCharSequence = (CharSequence)parama.errorMsg;
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(a.i.wecoin_network_dialog_common_wording), "", paramContext.getString(a.i.wecoin_dialog_left_button_common_wording), false, null);
          AppMethodBeat.o(267217);
          return;
        }
        com.tencent.mm.ui.base.h.a(paramContext, parama.errorMsg, "", paramContext.getString(a.i.wecoin_dialog_left_button_common_wording), false, null);
      }
      AppMethodBeat.o(267217);
      return;
    }
    AppMethodBeat.o(267217);
  }
  
  public static final void a(final Context paramContext, cma paramcma, final com.tencent.mm.plugin.wallet.wecoin.model.b paramb)
  {
    AppMethodBeat.i(267218);
    p.k(paramContext, "context");
    if (paramcma != null)
    {
      switch (paramcma.TtT)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(267218);
        return;
        com.tencent.mm.ui.base.h.a(paramContext, paramcma.wording, "", paramcma.TtR.wording, false, (DialogInterface.OnClickListener)new a(paramcma, paramContext, paramb));
        AppMethodBeat.o(267218);
        return;
        com.tencent.mm.ui.base.h.a(paramContext, paramcma.wording, "", paramcma.TtS.wording, paramcma.TtR.wording, false, (DialogInterface.OnClickListener)new b(paramcma, paramContext, paramb), (DialogInterface.OnClickListener)new c(paramcma, paramContext, paramb));
      }
    }
    AppMethodBeat.o(267218);
  }
  
  public static final void d(String paramString, com.tencent.mm.cd.a parama)
  {
    AppMethodBeat.i(267215);
    p.k(paramString, "tag");
    p.k(parama, "originObj");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      g.a(parama, localJSONObject);
      parama = localJSONObject.toString();
      p.j(parama, "jsonObject.toString()");
      Log.i(paramString, parama);
      AppMethodBeat.o(267215);
      return;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Log.e("MicroMsg.WeCoinUtils", "printPbLog account exception, error: " + parama.getMessage() + ", stack trace: " + Util.stackTraceToString((Throwable)parama));
      }
    }
  }
  
  public static final String gIi()
  {
    AppMethodBeat.i(267212);
    String str = UUID.randomUUID().toString();
    p.j(str, "uuid.toString()");
    AppMethodBeat.o(267212);
    return str;
  }
  
  public static final boolean gIo()
  {
    AppMethodBeat.i(267221);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vLe, 1);
    Log.i("MicroMsg.WeCoinUtils", "isMidasInitOnceABTest, %s", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(267221);
      return false;
    }
    AppMethodBeat.o(267221);
    return true;
  }
  
  public static final boolean gIp()
  {
    AppMethodBeat.i(267222);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vLf, 0);
    Log.i("MicroMsg.WeCoinUtils", "disableMidasSDKX5, %s", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(267222);
      return false;
    }
    AppMethodBeat.o(267222);
    return true;
  }
  
  public static final long gIq()
  {
    AppMethodBeat.i(267223);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((f)localObject).aHp().get(ar.a.Vwo, Long.valueOf(0L));
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.Long");
      AppMethodBeat.o(267223);
      throw ((Throwable)localObject);
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(267223);
    return l;
  }
  
  public static final cgj gIr()
  {
    AppMethodBeat.i(267225);
    Log.d("MicroMsg.WeCoinUtils", "load WecoinPageInfoResponse snapshot");
    Object localObject1 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject1, "MMKernel.storage()");
    Object localObject3 = (String)((f)localObject1).aHp().get(ar.a.Vwk, "");
    localObject1 = (CharSequence)localObject3;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(267225);
      return null;
    }
    localObject1 = (com.tencent.mm.cd.a)new cgj();
    Charset localCharset = d.ISO_8859_1;
    if (localObject3 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(267225);
      throw ((Throwable)localObject1);
    }
    localObject3 = ((String)localObject3).getBytes(localCharset);
    p.j(localObject3, "(this as java.lang.String).getBytes(charset)");
    try
    {
      ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (cgj)localObject1;
      AppMethodBeat.o(267225);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
      }
    }
  }
  
  public static final bwm gIs()
  {
    AppMethodBeat.i(267226);
    Log.d("MicroMsg.WeCoinUtils", "load WecoinIncomePageInfoResponse snapshot");
    Object localObject1 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject1, "MMKernel.storage()");
    Object localObject3 = (String)((f)localObject1).aHp().get(ar.a.Vwl, "");
    localObject1 = (CharSequence)localObject3;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(267226);
      return null;
    }
    localObject1 = (com.tencent.mm.cd.a)new bwm();
    Charset localCharset = d.ISO_8859_1;
    if (localObject3 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(267226);
      throw ((Throwable)localObject1);
    }
    localObject3 = ((String)localObject3).getBytes(localCharset);
    p.j(localObject3, "(this as java.lang.String).getBytes(charset)");
    try
    {
      ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (bwm)localObject1;
      AppMethodBeat.o(267226);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
      }
    }
  }
  
  public static final cgl gIt()
  {
    AppMethodBeat.i(267228);
    Log.d("MicroMsg.WeCoinUtils", "load WecoinPriceListResponse snapshot");
    Object localObject1 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject1, "MMKernel.storage()");
    Object localObject3 = (String)((f)localObject1).aHp().get(ar.a.Vwn, "");
    localObject1 = (CharSequence)localObject3;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(267228);
      return null;
    }
    localObject1 = (com.tencent.mm.cd.a)new cgl();
    Charset localCharset = d.ISO_8859_1;
    if (localObject3 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(267228);
      throw ((Throwable)localObject1);
    }
    localObject3 = ((String)localObject3).getBytes(localCharset);
    p.j(localObject3, "(this as java.lang.String).getBytes(charset)");
    try
    {
      ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (cgl)localObject1;
      AppMethodBeat.o(267228);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
      }
    }
  }
  
  public static final <T extends dyy> boolean h(com.tencent.mm.an.c.a<T> parama)
  {
    AppMethodBeat.i(267216);
    p.k(parama, "callback");
    if ((parama.errType != 0) || (parama.errCode != 0))
    {
      AppMethodBeat.o(267216);
      return true;
    }
    AppMethodBeat.o(267216);
    return false;
  }
  
  public static final boolean isFastClick()
  {
    AppMethodBeat.i(267210);
    if (Util.ticksToNow(Otm) < 600L)
    {
      Log.d("MicroMsg.WeCoinUtils", "button click too soon, save time " + Otm);
      AppMethodBeat.o(267210);
      return true;
    }
    Otm = Util.currentTicks();
    AppMethodBeat.o(267210);
    return false;
  }
  
  public static final double lL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(267219);
    p.k(paramString1, "d1");
    p.k(paramString2, "d2");
    int j;
    int k;
    int i;
    int m;
    try
    {
      localCharSequence = (CharSequence)paramString1;
      j = localCharSequence.length() - 1;
      k = 0;
      i = 0;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        CharSequence localCharSequence;
        label66:
        label209:
        Log.printErrStackTrace("MicroMsg.WeCoinUtils", (Throwable)paramString1, "", new Object[0]);
        label190:
        d = 0.0D;
      }
    }
    if (localCharSequence.charAt(m) <= ' ')
    {
      m = 1;
      break label289;
      if (Util.getDouble(localCharSequence.subSequence(i, j + 1).toString(), 0.0D) == 0.0D) {}
      for (paramString1 = "0";; paramString1 = paramString1.subSequence(i, j + 1).toString())
      {
        paramString1 = new BigDecimal(paramString1);
        paramString2 = (CharSequence)paramString2;
        j = paramString2.length() - 1;
        k = 0;
        i = 0;
        break;
        if (paramString2.charAt(m) > ' ') {
          break label454;
        }
        m = 1;
        break label360;
        paramString1 = (CharSequence)paramString1;
        j = paramString1.length() - 1;
        k = 0;
        i = 0;
        break label376;
        if (paramString1.charAt(m) > ' ') {
          break label418;
        }
        m = 1;
        break label395;
      }
    }
    label270:
    label289:
    label339:
    label341:
    label481:
    for (;;)
    {
      double d = paramString1.divide(new BigDecimal(paramString2.subSequence(i, j + 1).toString()), 5, 2).doubleValue();
      AppMethodBeat.o(267219);
      return d;
      for (;;)
      {
        if (i > j) {
          break label339;
        }
        if (k == 0)
        {
          m = i;
          break;
        }
        for (;;)
        {
          if (k == 0)
          {
            if (m == 0)
            {
              k = 1;
              break label270;
              m = j;
              break;
              m = 0;
              continue;
            }
            i += 1;
            break label270;
          }
        }
        if (m == 0) {
          break label66;
        }
        j -= 1;
      }
      break label66;
      for (;;)
      {
        if (i > j) {
          break label481;
        }
        if (k == 0)
        {
          m = i;
          break;
        }
        for (;;)
        {
          label360:
          if (k == 0)
          {
            if (m == 0)
            {
              k = 1;
              break label341;
              for (;;)
              {
                label376:
                if (i > j) {
                  break label445;
                }
                if (k == 0)
                {
                  m = i;
                  break;
                }
                for (;;)
                {
                  if (k == 0)
                  {
                    if (m == 0)
                    {
                      k = 1;
                      break label376;
                      m = j;
                      break;
                      m = 0;
                      continue;
                    }
                    i += 1;
                    break label376;
                  }
                }
                if (m == 0) {
                  break label190;
                }
                j -= 1;
              }
              break label190;
              m = j;
              break;
              m = 0;
              continue;
            }
            i += 1;
            break label341;
          }
        }
        if (m == 0) {
          break label209;
        }
        j -= 1;
      }
    }
  }
  
  public static final int lM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(267220);
    p.k(paramString1, "d1");
    p.k(paramString2, "d2");
    try
    {
      double d1 = Util.getDouble(paramString1, 0.0D);
      double d2 = Util.getDouble(paramString2, 0.0D);
      if (d1 == 0.0D) {
        paramString1 = "0";
      }
      paramString1 = new BigDecimal(paramString1);
      if (d2 == 0.0D) {
        paramString2 = "0";
      }
      i = paramString1.multiply(new BigDecimal(paramString2)).intValue();
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WeCoinUtils", (Throwable)paramString1, "", new Object[0]);
        int i = 0;
      }
    }
    AppMethodBeat.o(267220);
    return i;
  }
  
  public static final void p(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(267214);
    p.k(paramTextView, "textView");
    float f1 = com.tencent.mm.ci.a.ez(MMApplicationContext.getContext());
    float f2 = com.tencent.mm.cj.a.hrd();
    Log.d("MicroMsg.WeCoinUtils", "setFixedTextSize, fontScale: " + f1 + ", viewScale: " + f2);
    if ((f1 != 1.0F) || (f2 != 1.0F)) {
      paramTextView.setTextSize(0, com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), paramInt));
    }
    AppMethodBeat.o(267214);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick", "com/tencent/mm/plugin/wallet/wecoin/utils/WeCoinUtilsKt$handleWeCoinInterceptWin$1$1"})
  static final class a
    implements DialogInterface.OnClickListener
  {
    a(cma paramcma, Context paramContext, com.tencent.mm.plugin.wallet.wecoin.model.b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(268547);
      c.a(paramContext, this.OHy.TtR, paramb);
      AppMethodBeat.o(268547);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick", "com/tencent/mm/plugin/wallet/wecoin/utils/WeCoinUtilsKt$handleWeCoinInterceptWin$1$2"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(cma paramcma, Context paramContext, com.tencent.mm.plugin.wallet.wecoin.model.b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(273013);
      c.a(paramContext, this.OHy.TtS, paramb);
      AppMethodBeat.o(273013);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick", "com/tencent/mm/plugin/wallet/wecoin/utils/WeCoinUtilsKt$handleWeCoinInterceptWin$1$3"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(cma paramcma, Context paramContext, com.tencent.mm.plugin.wallet.wecoin.model.b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(189323);
      c.a(paramContext, this.OHy.TtR, paramb);
      AppMethodBeat.o(189323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.c.c
 * JD-Core Version:    0.7.0.1
 */