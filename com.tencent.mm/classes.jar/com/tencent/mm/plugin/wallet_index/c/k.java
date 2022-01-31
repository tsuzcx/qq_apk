package com.tencent.mm.plugin.wallet_index.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.hc;
import com.tencent.mm.h.a.hc.a;
import com.tencent.mm.h.a.lu;
import com.tencent.mm.h.a.lu.a;
import com.tencent.mm.h.a.tp;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.cia;
import com.tencent.mm.protocal.c.li;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.tenpay.model.l;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class k
  extends c<tp>
  implements f
{
  int qLm;
  int qLn = 0;
  hc qLo;
  lu qLp;
  long qLq;
  public c qLr = new k.1(this);
  public c<lu> qLs = new k.2(this);
  
  public k()
  {
    this.udX = tp.class.getName().hashCode();
  }
  
  private void cH(String paramString, int paramInt)
  {
    y.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay reqKey = " + paramString);
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.bUV = this.qLm;
    String[] arrayOfString = paramString.replace("http://p.qq.com?", "").split("&");
    int j = arrayOfString.length;
    int i = 0;
    paramString = null;
    Object localObject1 = null;
    String str1;
    if (i < j)
    {
      String str2 = arrayOfString[i];
      Object localObject2;
      if (str2.startsWith("errcode="))
      {
        localObject2 = str2.replace("errcode=", "");
        str1 = paramString;
      }
      for (;;)
      {
        i += 1;
        paramString = str1;
        localObject1 = localObject2;
        break;
        if (str2.startsWith("errmsg="))
        {
          str1 = str2.replace("errmsg=", "");
          localObject2 = localObject1;
        }
        else if (str2.startsWith("reqkey="))
        {
          localPayInfo.bMX = str2.replace("reqkey=", "");
          str1 = paramString;
          localObject2 = localObject1;
        }
        else if (str2.startsWith("uuid="))
        {
          localPayInfo.dCX = str2.replace("uuid=", "");
          str1 = paramString;
          localObject2 = localObject1;
        }
        else if (str2.startsWith("appid="))
        {
          localPayInfo.appId = str2.replace("appid=", "");
          str1 = paramString;
          localObject2 = localObject1;
        }
        else if (str2.startsWith("appsource="))
        {
          localPayInfo.qLi = str2.replace("appsource=", "");
          str1 = paramString;
          localObject2 = localObject1;
        }
        else
        {
          str1 = paramString;
          localObject2 = localObject1;
          if (str2.startsWith("productid="))
          {
            localPayInfo.bJd = str2.replace("productid=", "");
            str1 = paramString;
            localObject2 = localObject1;
          }
        }
      }
    }
    localPayInfo.bUR = paramInt;
    if ("0".equals(localObject1))
    {
      com.tencent.mm.pluginsdk.wallet.h.a(this.qLo.bOW.context, localPayInfo, 0);
      if (this.qLo.bFJ != null)
      {
        this.qLo.bOX.ret = 1;
        this.qLo.bFJ.run();
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(localObject1)) && (Pattern.compile("[0-9]*").matcher(localObject1).matches())) {
        i(0, Integer.valueOf(localObject1).intValue(), 0L);
      }
      return;
      str1 = paramString;
      if (bk.bl(paramString)) {
        str1 = this.qLo.bOW.context.getString(a.i.wallet_unknown_err);
      }
      com.tencent.mm.ui.base.h.a(this.qLo.bOW.context, str1, "", new k.5(this));
    }
  }
  
  private void i(int paramInt1, int paramInt2, long paramLong)
  {
    int i = 132;
    if (this.qLm == 1) {
      i = 163;
    }
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(i);
    localIDKey1.SetValue(1L);
    localIDKey1.SetKey(26);
    localArrayList.add(localIDKey1);
    IDKey localIDKey2;
    IDKey localIDKey3;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      localIDKey1 = new IDKey();
      localIDKey1.SetID(i);
      localIDKey1.SetValue(1L);
      localIDKey2 = new IDKey();
      localIDKey2.SetID(i);
      localIDKey2.SetValue(1L);
      localIDKey1.SetKey(8);
      if (paramInt2 < 0) {
        localIDKey2.SetKey(9);
      }
    }
    else if ((this.qLm == 4) && (paramLong > 0L))
    {
      localIDKey1 = new IDKey();
      localIDKey1.SetID(i);
      localIDKey1.SetValue(1L);
      localIDKey2 = new IDKey();
      localIDKey2.SetID(i);
      localIDKey2.SetValue(1L);
      localIDKey3 = new IDKey();
      localIDKey3.SetID(i);
      localIDKey3.SetValue((int)paramLong);
      localIDKey1.SetKey(0);
      if (paramLong > 1000L) {
        break label290;
      }
      localIDKey2.SetKey(1);
      localIDKey3.SetKey(4);
    }
    for (;;)
    {
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      localArrayList.add(localIDKey3);
      com.tencent.mm.plugin.report.service.h.nFQ.b(localArrayList, true);
      return;
      if (paramInt2 <= 0) {
        break;
      }
      localIDKey2.SetKey(10);
      break;
      label290:
      if ((paramLong > 1000L) && (paramLong <= 3000L))
      {
        localIDKey2.SetKey(2);
        localIDKey3.SetKey(5);
      }
      else if (paramLong > 3000L)
      {
        localIDKey2.SetKey(3);
        localIDKey3.SetKey(6);
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.modelsimple.h))
    {
      long l = System.currentTimeMillis() - this.qLq;
      com.tencent.mm.plugin.report.service.h.nFQ.f(11170, new Object[] { Integer.valueOf(233), Integer.valueOf(0), Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(aq.getNetType(ae.getContext())), "" });
      i(paramInt1, paramInt2, l);
      y.d("MicroMsg.WalletGetA8KeyRedirectListener", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
      g.DQ();
      g.DO().dJT.b(233, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramm = paramString;
        if (bk.bl(paramString)) {
          paramm = this.qLo.bOW.context.getString(a.i.wallet_unknown_err);
        }
        com.tencent.mm.ui.base.h.a(this.qLo.bOW.context, paramm, "", new k.3(this));
      }
    }
    do
    {
      return;
      cH(((com.tencent.mm.modelsimple.h)paramm).Qf(), this.qLn);
      return;
      if (!(paramm instanceof l)) {
        break;
      }
      y.d("MicroMsg.WalletGetA8KeyRedirectListener", "native auth, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      g.DQ();
      g.DO().dJT.b(385, this);
      if ((paramInt1 != 0) || (paramInt2 != 0) || (!"0".equals(((l)paramm).wBD)))
      {
        if (!bk.bl(paramString)) {}
        for (;;)
        {
          aa.l(this.qLm, "", paramInt2);
          com.tencent.mm.ui.base.h.a(this.qLp.bUP.context, paramString, "", new k.4(this));
          return;
          if (!bk.bl(((l)paramm).gfH)) {
            paramString = ((l)paramm).gfH;
          } else {
            paramString = this.qLp.bUP.context.getString(a.i.wallet_unknown_err);
          }
        }
      }
      aa.l(this.qLm, ((l)paramm).bMX, paramInt2);
      paramString = ((l)paramm).qLj;
      if ((paramString != null) && (!bk.bl(paramString.tWB)))
      {
        paramm = (l)paramm;
        paramString = new Intent();
        paramString.putExtra("prepayId", paramm.bMX);
        paramString.putExtra("is_jsapi_offline_pay", false);
        paramm = paramm.qLj;
        paramString.putExtra("pay_gate_url", paramm.tWB);
        paramString.putExtra("need_dialog", paramm.tWD);
        paramString.putExtra("dialog_text", paramm.tWE);
        paramString.putExtra("max_count", paramm.tWC.sHa);
        paramString.putExtra("inteval_time", paramm.tWC.sGZ);
        paramString.putExtra("default_wording", paramm.tWC.sHb);
        d.c((Activity)this.qLp.bUP.context, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
        if (this.qLp.bFJ != null)
        {
          this.qLp.bUQ.ret = 1;
          this.qLp.bFJ.run();
        }
        y.d("MicroMsg.WalletGetA8KeyRedirectListener", "mAuthNativeEvent.data.context: %s", new Object[] { this.qLp.bUP.context });
        return;
      }
      paramString = (l)paramm;
      paramm = new PayInfo();
      paramm.bUV = this.qLm;
      paramm.bMX = paramString.bMX;
      paramm.appId = paramString.appId;
      paramm.qLi = paramString.qLi;
      paramm.bJd = paramString.bJd;
      paramm.bUR = paramString.bUR;
      y.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay native, payInfo: %s", new Object[] { paramm.toString() });
      com.tencent.mm.pluginsdk.wallet.h.a(this.qLp.bUP.context, paramm, 0);
    } while (this.qLp.bFJ == null);
    this.qLp.bUQ.ret = 1;
    this.qLp.bFJ.run();
    return;
    y.i("MicroMsg.WalletGetA8KeyRedirectListener", "other scene");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.k
 * JD-Core Version:    0.7.0.1
 */