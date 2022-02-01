package com.tencent.mm.plugin.wallet.wecoin.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet.wecoin.model.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.protocal.protobuf.cwm;
import com.tencent.mm.protocal.protobuf.cwo;
import com.tencent.mm.protocal.protobuf.dcl;
import com.tencent.mm.protocal.protobuf.efg;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.ui.i;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.d;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"lastClickSaveButtonTime", "", "getLastClickSaveButtonTime", "()J", "setLastClickSaveButtonTime", "(J)V", "ResultReceiver", "Landroid/os/ResultReceiver;", "handler", "Landroid/os/Handler;", "receive", "Lkotlin/Function2;", "", "Landroid/os/Bundle;", "", "disableMidasSDKX5", "", "divide", "", "d1", "", "d2", "roundingMode", "generateUniqueID", "getRealBottomHeight", "context", "Landroid/content/Context;", "getReportedRechargeScene", "rechargeScene", "handleNetRespError", "info", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "listener", "Landroid/content/DialogInterface$OnClickListener;", "handleWeCoinInterceptWin", "interceptWin", "Lcom/tencent/mm/protocal/protobuf/InterceptPopUp;", "Lcom/tencent/mm/plugin/wallet/wecoin/model/InterceptWinClickListener;", "handleWeCoinJumpItem", "jumpItem", "Lcom/tencent/mm/protocal/protobuf/PopUpJumpInfo;", "hasShowWecoinEntranceTutorial", "hasShowWecoinTutorial", "hasShowWecoinTutorialInEmojiStore", "isCgiError", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "callback", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "isCgiReturnError", "isFastClick", "isMidasInitOnceABTest", "isNotEnoughScene", "isWeCoinCloseEntranceABTestHit", "loadWecoinBalanceSnapshot", "loadWecoinIncomePageInfoResponseSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetIncomePageInfoResponse;", "loadWecoinPageInfoResponseSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPageInfoResponse;", "loadWecoinPriceListResponseSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPriceListResponse;", "businessId", "multiply", "printPbLog", "tag", "originObj", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "saveWecoinBalanceSnapshot", "balance", "saveWecoinIncomePageInfoResponseSnapshot", "response", "saveWecoinPageInfoResponseSnapshot", "saveWecoinPriceListResponseSnapshot", "setFixedTextSize", "textView", "Landroid/widget/TextView;", "dpSize", "setHasShowWecoinEntranceTutorial", "setHasShowWecoinTutorial", "setHasShowWecoinTutorialInEmojiStore", "plugin-wxpay_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  private static long Vit;
  
  public static final void a(Context paramContext, com.tencent.mm.plugin.wallet.wecoin.model.a parama)
  {
    AppMethodBeat.i(315758);
    s.u(paramContext, "context");
    if ((parama != null) && ((parama.hDx != 0) || (parama.errorCode != 0)))
    {
      CharSequence localCharSequence = (CharSequence)parama.errorMsg;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        k.a(paramContext, paramContext.getString(a.i.wecoin_network_dialog_common_wording), "", paramContext.getString(a.i.wecoin_dialog_left_button_common_wording), false, null);
        AppMethodBeat.o(315758);
        return;
      }
      k.a(paramContext, parama.errorMsg, "", paramContext.getString(a.i.wecoin_dialog_left_button_common_wording), false, null);
    }
    AppMethodBeat.o(315758);
  }
  
  public static final void a(Context paramContext, dcl paramdcl, b paramb)
  {
    AppMethodBeat.i(315761);
    s.u(paramContext, "context");
    if (paramdcl != null) {
      switch (paramdcl.aaIr)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(315761);
      return;
      k.a(paramContext, paramdcl.wording, "", paramdcl.aaIp.wording, false, new c..ExternalSyntheticLambda0(paramContext, paramdcl, paramb));
      AppMethodBeat.o(315761);
      return;
      k.a(paramContext, paramdcl.wording, "", paramdcl.aaIq.wording, paramdcl.aaIp.wording, false, new c..ExternalSyntheticLambda2(paramContext, paramdcl, paramb), new c..ExternalSyntheticLambda1(paramContext, paramdcl, paramb));
    }
  }
  
  private static final void a(Context paramContext, dcl paramdcl, b paramb, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(315840);
    s.u(paramContext, "$context");
    s.u(paramdcl, "$this_apply");
    a(paramContext, paramdcl.aaIp, paramb);
    AppMethodBeat.o(315840);
  }
  
  private static final void a(Context paramContext, efg paramefg, b paramb)
  {
    AppMethodBeat.i(315771);
    if (paramefg != null) {
      switch (paramefg.action)
      {
      }
    }
    for (;;)
    {
      if (paramb != null) {
        paramb.a(paramefg);
      }
      AppMethodBeat.o(315771);
      return;
      Log.d("MicroMsg.WeCoinUtils", s.X("handleWeCoinJumpItem h5 url ", paramefg.url));
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramefg.url);
      i.aS(paramContext, localIntent);
      continue;
      Log.d("MicroMsg.WeCoinUtils", "handleWeCoinJumpItem TinyApp, username: " + paramefg.username + ", pagepath: " + paramefg.OkP);
      i.y(paramefg.username, paramefg.OkP, 0, 1188);
    }
  }
  
  public static final int asg(int paramInt)
  {
    int i = 5;
    switch (paramInt)
    {
    case 5: 
    case 7: 
    default: 
      i = -1;
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      return i;
    case 0: 
      return 2;
    case 1: 
    case 2: 
      return 1;
    case 3: 
    case 4: 
      return 3;
    case 6: 
    case 8: 
      return 4;
    case 13: 
    case 14: 
      return 6;
    }
    return 7;
  }
  
  public static final cwo ash(int paramInt)
  {
    AppMethodBeat.i(315832);
    Log.d("MicroMsg.WeCoinUtils", "load WecoinPriceListResponse snapshot");
    Object localObject3 = (String)h.baE().ban().R(paramInt + at.a.acXX.name(), "");
    Object localObject1 = (CharSequence)localObject3;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      AppMethodBeat.o(315832);
      return null;
    }
    localObject1 = (com.tencent.mm.bx.a)new cwo();
    Charset localCharset = d.ISO_8859_1;
    if (localObject3 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(315832);
      throw ((Throwable)localObject1);
    }
    localObject3 = ((String)localObject3).getBytes(localCharset);
    s.s(localObject3, "(this as java.lang.String).getBytes(charset)");
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (cwo)localObject1;
      AppMethodBeat.o(315832);
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
  
  private static final void b(Context paramContext, dcl paramdcl, b paramb, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(315848);
    s.u(paramContext, "$context");
    s.u(paramdcl, "$this_apply");
    a(paramContext, paramdcl.aaIq, paramb);
    AppMethodBeat.o(315848);
  }
  
  private static final void c(Context paramContext, dcl paramdcl, b paramb, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(315856);
    s.u(paramContext, "$context");
    s.u(paramdcl, "$this_apply");
    a(paramContext, paramdcl.aaIp, paramb);
    AppMethodBeat.o(315856);
  }
  
  public static final void d(String paramString, com.tencent.mm.bx.a parama)
  {
    AppMethodBeat.i(315740);
    s.u(paramString, "tag");
    s.u(parama, "originObj");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.ae.f.a(parama, localJSONObject);
      parama = localJSONObject.toString();
      s.s(parama, "jsonObject.toString()");
      Log.i(paramString, parama);
      AppMethodBeat.o(315740);
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
  
  public static final boolean ihE()
  {
    AppMethodBeat.i(315790);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zbE, 1);
    Log.i("MicroMsg.WeCoinUtils", "isMidasInitOnceABTest, %s", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(315790);
      return false;
    }
    AppMethodBeat.o(315790);
    return true;
  }
  
  public static final long ihF()
  {
    AppMethodBeat.i(315797);
    Object localObject = h.baE().ban().get(at.a.acXY, Long.valueOf(0L));
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
      AppMethodBeat.o(315797);
      throw ((Throwable)localObject);
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(315797);
    return l;
  }
  
  public static final cwm ihG()
  {
    AppMethodBeat.i(315812);
    Log.d("MicroMsg.WeCoinUtils", "load WecoinPageInfoResponse snapshot");
    Object localObject3 = (String)h.baE().ban().get(at.a.acXU, "");
    Object localObject1 = (CharSequence)localObject3;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(315812);
      return null;
    }
    localObject1 = (com.tencent.mm.bx.a)new cwm();
    Charset localCharset = d.ISO_8859_1;
    if (localObject3 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(315812);
      throw ((Throwable)localObject1);
    }
    localObject3 = ((String)localObject3).getBytes(localCharset);
    s.s(localObject3, "(this as java.lang.String).getBytes(charset)");
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (cwm)localObject1;
      AppMethodBeat.o(315812);
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
  
  public static final clp ihH()
  {
    AppMethodBeat.i(315821);
    Log.d("MicroMsg.WeCoinUtils", "load WecoinIncomePageInfoResponse snapshot");
    Object localObject3 = (String)h.baE().ban().get(at.a.acXV, "");
    Object localObject1 = (CharSequence)localObject3;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(315821);
      return null;
    }
    localObject1 = (com.tencent.mm.bx.a)new clp();
    Charset localCharset = d.ISO_8859_1;
    if (localObject3 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(315821);
      throw ((Throwable)localObject1);
    }
    localObject3 = ((String)localObject3).getBytes(localCharset);
    s.s(localObject3, "(this as java.lang.String).getBytes(charset)");
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (clp)localObject1;
      AppMethodBeat.o(315821);
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
  
  public static final String ihq()
  {
    AppMethodBeat.i(315731);
    String str = UUID.randomUUID().toString();
    s.s(str, "uuid.toString()");
    AppMethodBeat.o(315731);
    return str;
  }
  
  public static final boolean isFastClick()
  {
    AppMethodBeat.i(315728);
    if (Util.ticksToNow(Vit) < 600L)
    {
      Log.d("MicroMsg.WeCoinUtils", s.X("button click too soon, save time ", Long.valueOf(Vit)));
      AppMethodBeat.o(315728);
      return true;
    }
    Vit = Util.currentTicks();
    AppMethodBeat.o(315728);
    return false;
  }
  
  public static final double nx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(315778);
    s.u(paramString1, "d1");
    s.u(paramString2, "d2");
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
        label69:
        label100:
        Log.printErrStackTrace("MicroMsg.WeCoinUtils", (Throwable)paramString1, "", new Object[0]);
        label155:
        label201:
        label220:
        d = 0.0D;
      }
    }
    if (s.compare(localCharSequence.charAt(m), 32) <= 0)
    {
      m = 1;
      break label300;
      if (Util.getDouble(localCharSequence.subSequence(i, j + 1).toString(), 0.0D) != 0.0D) {
        break label399;
      }
      i = 1;
      break label352;
      for (;;)
      {
        paramString1 = new BigDecimal(paramString1);
        paramString2 = (CharSequence)paramString2;
        j = paramString2.length() - 1;
        k = 0;
        i = 0;
        break;
        if (s.compare(paramString2.charAt(m), 32) > 0) {
          break label483;
        }
        m = 1;
        break label383;
        paramString1 = (CharSequence)paramString1;
        j = paramString1.length() - 1;
        k = 0;
        i = 0;
        break label405;
        if (s.compare(paramString1.charAt(m), 32) > 0) {
          break label447;
        }
        m = 1;
        break label424;
        paramString1 = paramString1.subSequence(i, j + 1).toString();
      }
    }
    label281:
    label300:
    label350:
    label352:
    label364:
    label510:
    for (;;)
    {
      double d = paramString1.divide(new BigDecimal(paramString2.subSequence(i, j + 1).toString()), 5, 2).doubleValue();
      AppMethodBeat.o(315778);
      return d;
      for (;;)
      {
        if (i > j) {
          break label350;
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
              break label281;
              m = j;
              break;
              m = 0;
              continue;
            }
            i += 1;
            break label281;
          }
        }
        if (m == 0) {
          break label69;
        }
        j -= 1;
      }
      break label69;
      if (i != 0)
      {
        paramString1 = "0";
        break label100;
      }
      for (;;)
      {
        if (i > j) {
          break label510;
        }
        if (k == 0)
        {
          m = i;
          break;
        }
        for (;;)
        {
          label383:
          if (k == 0)
          {
            if (m == 0)
            {
              k = 1;
              break label364;
              i = 0;
              break label352;
              break label155;
              for (;;)
              {
                if (i > j) {
                  break label474;
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
                      break label405;
                      m = j;
                      break;
                      m = 0;
                      continue;
                    }
                    i += 1;
                    break label405;
                  }
                }
                if (m == 0) {
                  break label201;
                }
                j -= 1;
              }
              break label201;
              m = j;
              break;
              m = 0;
              continue;
            }
            i += 1;
            break label364;
          }
        }
        if (m == 0) {
          break label220;
        }
        j -= 1;
      }
    }
  }
  
  public static final int ny(String paramString1, String paramString2)
  {
    int j = 1;
    AppMethodBeat.i(315782);
    s.u(paramString1, "d1");
    s.u(paramString2, "d2");
    int i;
    try
    {
      double d1 = Util.getDouble(paramString1, 0.0D);
      d2 = Util.getDouble(paramString2, 0.0D);
      if (d1 != 0.0D) {
        break label97;
      }
      i = 1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        double d2;
        Log.printErrStackTrace("MicroMsg.WeCoinUtils", (Throwable)paramString1, "", new Object[0]);
        i = 0;
        continue;
        if (i != 0) {
          paramString1 = "0";
        }
      }
    }
    paramString1 = new BigDecimal(paramString1);
    if (d2 == 0.0D) {
      i = j;
    }
    for (;;)
    {
      i = paramString1.multiply(new BigDecimal(paramString2)).intValue();
      AppMethodBeat.o(315782);
      return i;
      label97:
      i = 0;
      break label131;
      i = 0;
      label131:
      if (i != 0) {
        paramString2 = "0";
      }
    }
  }
  
  public static final <T extends esc> boolean o(b.a<T> parama)
  {
    AppMethodBeat.i(315745);
    s.u(parama, "callback");
    if ((parama.errType != 0) || (parama.errCode != 0))
    {
      AppMethodBeat.o(315745);
      return true;
    }
    AppMethodBeat.o(315745);
    return false;
  }
  
  public static final <T extends esc> boolean p(b.a<T> parama)
  {
    AppMethodBeat.i(315751);
    s.u(parama, "callback");
    if ((parama.errType != 0) || (parama.errCode != 0))
    {
      AppMethodBeat.o(315751);
      return true;
    }
    if (parama.ott == null)
    {
      AppMethodBeat.o(315751);
      return true;
    }
    if (parama.ott.BaseResponse == null)
    {
      AppMethodBeat.o(315751);
      return true;
    }
    if (parama.ott.BaseResponse.Idd != 0)
    {
      AppMethodBeat.o(315751);
      return true;
    }
    AppMethodBeat.o(315751);
    return false;
  }
  
  public static final void s(TextView paramTextView, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(315735);
    s.u(paramTextView, "textView");
    float f1 = com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext());
    float f2 = com.tencent.mm.ce.c.iRs();
    Log.d("MicroMsg.WeCoinUtils", "setFixedTextSize, fontScale: " + f1 + ", viewScale: " + f2);
    if (f1 == 1.0F)
    {
      i = 1;
      if (i != 0) {
        if (f2 != 1.0F) {
          break label114;
        }
      }
    }
    label114:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        paramTextView.setTextSize(0, com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), paramInt));
      }
      AppMethodBeat.o(315735);
      return;
      i = 0;
      break;
    }
  }
  
  public static final void xz(long paramLong)
  {
    AppMethodBeat.i(315803);
    h.baE().ban().set(at.a.acXY, Long.valueOf(paramLong));
    AppMethodBeat.o(315803);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    public a(clp paramclp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    public b(cwm paramcwm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    public c(cwo paramcwo, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.utils.c
 * JD-Core Version:    0.7.0.1
 */