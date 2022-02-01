package com.tencent.mm.plugin.wallet.wecoin.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.byr;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.h;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"lastClickSaveButtonTime", "", "getLastClickSaveButtonTime", "()J", "setLastClickSaveButtonTime", "(J)V", "divide", "", "d1", "", "d2", "roundingMode", "", "generateUniqueID", "getRealBottomHeight", "context", "Landroid/content/Context;", "handleNetRespError", "", "info", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "handleWeCoinInterceptWin", "interceptWin", "Lcom/tencent/mm/protocal/protobuf/InterceptPopUp;", "listener", "Lcom/tencent/mm/plugin/wallet/wecoin/model/InterceptWinClickListener;", "handleWeCoinJumpItem", "jumpItem", "Lcom/tencent/mm/protocal/protobuf/PopUpJumpInfo;", "hasShowWecoinEntranceTutorial", "", "hasShowWecoinTutorial", "isCgiReturnError", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "callback", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "isFastClick", "isMidasInitOnceABTest", "isWeCoinCloseEntranceABTestHit", "loadWecoinBalanceSnapshot", "loadWecoinIncomePageInfoResponseSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetIncomePageInfoResponse;", "loadWecoinPageInfoResponseSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPageInfoResponse;", "loadWecoinPriceListResponseSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPriceListResponse;", "multiply", "printPbLog", "tag", "originObj", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "saveWecoinBalanceSnapshot", "balance", "saveWecoinIncomePageInfoResponseSnapshot", "response", "saveWecoinPageInfoResponseSnapshot", "saveWecoinPriceListResponseSnapshot", "setFixedTextSize", "textView", "Landroid/widget/TextView;", "dpSize", "setHasShowWecoinEntranceTutorial", "setHasShowWecoinTutorial", "plugin-wxpay_release"})
public final class c
{
  private static long HBw;
  
  public static final void LS(long paramLong)
  {
    AppMethodBeat.i(212935);
    e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.OhY, Long.valueOf(paramLong));
    AppMethodBeat.o(212935);
  }
  
  public static final void a(Context paramContext, com.tencent.mm.plugin.wallet.wecoin.model.a parama)
  {
    AppMethodBeat.i(212930);
    p.h(paramContext, "context");
    if (parama != null)
    {
      if ((parama.dGe != 0) || (parama.errorCode != 0))
      {
        CharSequence localCharSequence = (CharSequence)parama.errorMsg;
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          h.a(paramContext, paramContext.getString(2131768692), "", paramContext.getString(2131768685), false, null);
          AppMethodBeat.o(212930);
          return;
        }
        h.a(paramContext, parama.errorMsg, "", paramContext.getString(2131768685), false, null);
      }
      AppMethodBeat.o(212930);
      return;
    }
    AppMethodBeat.o(212930);
  }
  
  public static final void a(final Context paramContext, cdg paramcdg, final com.tencent.mm.plugin.wallet.wecoin.model.b paramb)
  {
    AppMethodBeat.i(212931);
    p.h(paramContext, "context");
    if (paramcdg != null)
    {
      switch (paramcdg.Mje)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(212931);
        return;
        h.a(paramContext, paramcdg.dQx, "", paramcdg.Mjc.dQx, false, (DialogInterface.OnClickListener)new a(paramcdg, paramContext, paramb));
        AppMethodBeat.o(212931);
        return;
        h.a(paramContext, paramcdg.dQx, "", paramcdg.Mjd.dQx, paramcdg.Mjc.dQx, false, (DialogInterface.OnClickListener)new b(paramcdg, paramContext, paramb), (DialogInterface.OnClickListener)new c(paramcdg, paramContext, paramb));
      }
    }
    AppMethodBeat.o(212931);
  }
  
  public static final void d(String paramString, com.tencent.mm.bw.a parama)
  {
    AppMethodBeat.i(212928);
    p.h(paramString, "tag");
    p.h(parama, "originObj");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.ac.g.a(parama, localJSONObject);
      parama = localJSONObject.toString();
      p.g(parama, "jsonObject.toString()");
      Log.i(paramString, parama);
      AppMethodBeat.o(212928);
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
  
  public static final String fPE()
  {
    AppMethodBeat.i(212926);
    String str = UUID.randomUUID().toString();
    p.g(str, "uuid.toString()");
    AppMethodBeat.o(212926);
    return str;
  }
  
  public static final boolean fPK()
  {
    AppMethodBeat.i(212934);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.scJ, 1);
    Log.i("MicroMsg.WeCoinUtils", "isMidasInitOnceABTest, %s", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(212934);
      return false;
    }
    AppMethodBeat.o(212934);
    return true;
  }
  
  public static final byp fPL()
  {
    AppMethodBeat.i(212936);
    Log.d("MicroMsg.WeCoinUtils", "load WecoinPageInfoResponse snapshot");
    Object localObject1 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject1, "MMKernel.storage()");
    Object localObject3 = (String)((e)localObject1).azQ().get(ar.a.OhU, "");
    localObject1 = (CharSequence)localObject3;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(212936);
      return null;
    }
    localObject1 = (com.tencent.mm.bw.a)new byp();
    Charset localCharset = d.ISO_8859_1;
    if (localObject3 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(212936);
      throw ((Throwable)localObject1);
    }
    localObject3 = ((String)localObject3).getBytes(localCharset);
    p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (byp)localObject1;
      AppMethodBeat.o(212936);
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
  
  public static final bop fPM()
  {
    AppMethodBeat.i(212937);
    Log.d("MicroMsg.WeCoinUtils", "load WecoinIncomePageInfoResponse snapshot");
    Object localObject1 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject1, "MMKernel.storage()");
    Object localObject3 = (String)((e)localObject1).azQ().get(ar.a.OhV, "");
    localObject1 = (CharSequence)localObject3;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(212937);
      return null;
    }
    localObject1 = (com.tencent.mm.bw.a)new bop();
    Charset localCharset = d.ISO_8859_1;
    if (localObject3 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(212937);
      throw ((Throwable)localObject1);
    }
    localObject3 = ((String)localObject3).getBytes(localCharset);
    p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (bop)localObject1;
      AppMethodBeat.o(212937);
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
  
  public static final byr fPN()
  {
    AppMethodBeat.i(212938);
    Log.d("MicroMsg.WeCoinUtils", "load WecoinPriceListResponse snapshot");
    Object localObject1 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject1, "MMKernel.storage()");
    Object localObject3 = (String)((e)localObject1).azQ().get(ar.a.OhX, "");
    localObject1 = (CharSequence)localObject3;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(212938);
      return null;
    }
    localObject1 = (com.tencent.mm.bw.a)new byr();
    Charset localCharset = d.ISO_8859_1;
    if (localObject3 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(212938);
      throw ((Throwable)localObject1);
    }
    localObject3 = ((String)localObject3).getBytes(localCharset);
    p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (byr)localObject1;
      AppMethodBeat.o(212938);
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
  
  public static final <T extends dpc> boolean h(com.tencent.mm.ak.c.a<T> parama)
  {
    AppMethodBeat.i(212929);
    p.h(parama, "callback");
    if ((parama.errType != 0) || (parama.errCode != 0))
    {
      AppMethodBeat.o(212929);
      return true;
    }
    AppMethodBeat.o(212929);
    return false;
  }
  
  public static final boolean isFastClick()
  {
    AppMethodBeat.i(212925);
    if (Util.ticksToNow(HBw) < 600L)
    {
      Log.d("MicroMsg.WeCoinUtils", "button click too soon, save time " + HBw);
      AppMethodBeat.o(212925);
      return true;
    }
    HBw = Util.currentTicks();
    AppMethodBeat.o(212925);
    return false;
  }
  
  public static final double lo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212932);
    p.h(paramString1, "d1");
    p.h(paramString2, "d2");
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
      AppMethodBeat.o(212932);
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
  
  public static final int lp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212933);
    p.h(paramString1, "d1");
    p.h(paramString2, "d2");
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
    AppMethodBeat.o(212933);
    return i;
  }
  
  public static final void o(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(212927);
    p.h(paramTextView, "textView");
    float f1 = com.tencent.mm.cb.a.ez(MMApplicationContext.getContext());
    float f2 = com.tencent.mm.cc.a.gvi();
    Log.d("MicroMsg.WeCoinUtils", "setFixedTextSize, fontScale: " + f1 + ", viewScale: " + f2);
    if ((f1 != 1.0F) || (f2 != 1.0F)) {
      paramTextView.setTextSize(0, com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), paramInt));
    }
    AppMethodBeat.o(212927);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick", "com/tencent/mm/plugin/wallet/wecoin/utils/WeCoinUtilsKt$handleWeCoinInterceptWin$1$1"})
  static final class a
    implements DialogInterface.OnClickListener
  {
    a(cdg paramcdg, Context paramContext, com.tencent.mm.plugin.wallet.wecoin.model.b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(212919);
      c.a(paramContext, this.HPq.Mjc, paramb);
      AppMethodBeat.o(212919);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick", "com/tencent/mm/plugin/wallet/wecoin/utils/WeCoinUtilsKt$handleWeCoinInterceptWin$1$2"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(cdg paramcdg, Context paramContext, com.tencent.mm.plugin.wallet.wecoin.model.b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(212920);
      c.a(paramContext, this.HPq.Mjd, paramb);
      AppMethodBeat.o(212920);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick", "com/tencent/mm/plugin/wallet/wecoin/utils/WeCoinUtilsKt$handleWeCoinInterceptWin$1$3"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(cdg paramcdg, Context paramContext, com.tencent.mm.plugin.wallet.wecoin.model.b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(212921);
      c.a(paramContext, this.HPq.Mjc, paramb);
      AppMethodBeat.o(212921);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    public d(bop parambop)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    public e(byp parambyp)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    public f(byr parambyr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.c.c
 * JD-Core Version:    0.7.0.1
 */