package com.tencent.mm.plugin.wallet_index.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.hf.a;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.a.mk.a;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.cvm;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.tenpay.model.o;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class l
  extends c<vk>
  implements f
{
  long mRequestTime;
  int uAj;
  int uAk;
  hf uAl;
  mk uAm;
  public c uAn;
  public c<mk> uAo;
  
  public l()
  {
    AppMethodBeat.i(48205);
    this.uAk = 0;
    this.uAn = new l.1(this);
    this.uAo = new l.2(this);
    this.__eventId = vk.class.getName().hashCode();
    AppMethodBeat.o(48205);
  }
  
  private void dG(String paramString, int paramInt)
  {
    AppMethodBeat.i(48207);
    ab.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay reqKey = ".concat(String.valueOf(paramString)));
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.cCD = this.uAj;
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
          localPayInfo.cnI = str2.replace("reqkey=", "");
          str1 = paramString;
          localObject2 = localObject1;
        }
        else if (str2.startsWith("uuid="))
        {
          localPayInfo.eAx = str2.replace("uuid=", "");
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
          localPayInfo.uAe = str2.replace("appsource=", "");
          str1 = paramString;
          localObject2 = localObject1;
        }
        else
        {
          str1 = paramString;
          localObject2 = localObject1;
          if (str2.startsWith("productid="))
          {
            localPayInfo.cqx = str2.replace("productid=", "");
            str1 = paramString;
            localObject2 = localObject1;
          }
        }
      }
    }
    localPayInfo.cCy = paramInt;
    if ("0".equals(localObject1))
    {
      com.tencent.mm.pluginsdk.wallet.h.a(this.uAl.cwn.context, localPayInfo, 0);
      if (this.uAl.callback != null)
      {
        this.uAl.cwo.ret = 1;
        this.uAl.callback.run();
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(localObject1)) && (Pattern.compile("[0-9]*").matcher(localObject1).matches())) {
        k(0, Integer.valueOf(localObject1).intValue(), 0L);
      }
      AppMethodBeat.o(48207);
      return;
      str1 = paramString;
      if (bo.isNullOrNil(paramString)) {
        str1 = this.uAl.cwn.context.getString(2131305682);
      }
      com.tencent.mm.ui.base.h.a(this.uAl.cwn.context, str1, "", new l.6(this));
    }
  }
  
  private void k(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(48208);
    int i = 132;
    if (this.uAj == 1) {
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
    else if ((this.uAj == 4) && (paramLong > 0L))
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
        break label302;
      }
      localIDKey2.SetKey(1);
      localIDKey3.SetKey(4);
    }
    for (;;)
    {
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      localArrayList.add(localIDKey3);
      com.tencent.mm.plugin.report.service.h.qsU.b(localArrayList, true);
      AppMethodBeat.o(48208);
      return;
      if (paramInt2 <= 0) {
        break;
      }
      localIDKey2.SetKey(10);
      break;
      label302:
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
    AppMethodBeat.i(48206);
    if ((paramm instanceof j))
    {
      long l = System.currentTimeMillis() - this.mRequestTime;
      com.tencent.mm.plugin.report.service.h.qsU.e(11170, new Object[] { Integer.valueOf(233), Integer.valueOf(0), Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(at.getNetType(ah.getContext())), "" });
      k(paramInt1, paramInt2, l);
      ab.d("MicroMsg.WalletGetA8KeyRedirectListener", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
      g.RM();
      g.RK().eHt.b(233, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramm = paramString;
        if (bo.isNullOrNil(paramString)) {
          paramm = this.uAl.cwn.context.getString(2131305682);
        }
        com.tencent.mm.ui.base.h.a(this.uAl.cwn.context, paramm, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(48202);
            if (l.this.uAl.callback != null)
            {
              l.this.uAl.cwo.ret = 1;
              l.this.uAl.callback.run();
            }
            AppMethodBeat.o(48202);
          }
        });
        AppMethodBeat.o(48206);
        return;
      }
      dG(((j)paramm).ajl(), this.uAk);
      AppMethodBeat.o(48206);
      return;
    }
    if ((paramm instanceof o))
    {
      ab.d("MicroMsg.WalletGetA8KeyRedirectListener", "native auth, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      g.RM();
      g.RK().eHt.b(385, this);
      if ((paramInt1 != 0) || (paramInt2 != 0) || (!"0".equals(((o)paramm).AXZ)))
      {
        if (this.uAm.callback != null) {
          this.uAm.cCx.ret = 1;
        }
        if (!bo.isNullOrNil(paramString)) {}
        for (;;)
        {
          ad.q(this.uAj, "", paramInt2);
          com.tencent.mm.ui.base.h.a(this.uAm.cCw.context, paramString, "", new l.5(this));
          AppMethodBeat.o(48206);
          return;
          if (!bo.isNullOrNil(((o)paramm).hxt)) {
            paramString = ((o)paramm).hxt;
          } else {
            paramString = this.uAm.cCw.context.getString(2131305682);
          }
        }
      }
      if (this.uAm.callback != null)
      {
        this.uAm.cCx.ret = 2;
        this.uAm.callback.run();
      }
      ad.q(this.uAj, ((o)paramm).cnI, paramInt2);
      paramString = ((o)paramm).uAf;
      if ((paramString != null) && (!bo.isNullOrNil(paramString.ydT)))
      {
        paramm = (o)paramm;
        paramString = new Intent();
        paramString.putExtra("prepayId", paramm.cnI);
        paramString.putExtra("is_jsapi_offline_pay", false);
        paramm = paramm.uAf;
        paramString.putExtra("pay_gate_url", paramm.ydT);
        paramString.putExtra("need_dialog", paramm.ydV);
        paramString.putExtra("dialog_text", paramm.ydW);
        paramString.putExtra("max_count", paramm.ydU.wDy);
        paramString.putExtra("inteval_time", paramm.ydU.wDx);
        paramString.putExtra("default_wording", paramm.ydU.wDz);
        d.c((Activity)this.uAm.cCw.context, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
        if (this.uAm.callback != null)
        {
          this.uAm.cCx.ret = 2;
          this.uAm.callback.run();
        }
        ab.d("MicroMsg.WalletGetA8KeyRedirectListener", "mAuthNativeEvent.data.context: %s", new Object[] { this.uAm.cCw.context });
        AppMethodBeat.o(48206);
        return;
      }
      paramString = (o)paramm;
      paramm = new PayInfo();
      paramm.cCD = this.uAj;
      paramm.cnI = paramString.cnI;
      paramm.appId = paramString.appId;
      paramm.uAe = paramString.uAe;
      paramm.cqx = paramString.cqx;
      paramm.cCy = paramString.cCy;
      ab.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay native, payInfo: %s", new Object[] { paramm.toString() });
      com.tencent.mm.pluginsdk.wallet.h.a(this.uAm.cCw.context, paramm, 0);
      if (this.uAm.callback != null)
      {
        this.uAm.cCx.ret = 2;
        this.uAm.callback.run();
      }
      AppMethodBeat.o(48206);
      return;
    }
    ab.i("MicroMsg.WalletGetA8KeyRedirectListener", "other scene");
    AppMethodBeat.o(48206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.l
 * JD-Core Version:    0.7.0.1
 */