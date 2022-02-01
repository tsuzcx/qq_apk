package com.tencent.mm.plugin.wallet_index.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.g.a.hz.a;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.g.a.nw.a;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.dpt;
import com.tencent.mm.protocal.protobuf.qb;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.tenpay.model.o;
import java.util.ArrayList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class n
  extends c<xk>
  implements com.tencent.mm.al.g
{
  int Axl;
  hz Axm;
  nw Axn;
  private Queue<nw> Axo;
  public c Axp;
  public c<nw> Axq;
  int mPayChannel;
  long mRequestTime;
  
  public n()
  {
    AppMethodBeat.i(71839);
    this.mPayChannel = 0;
    this.Axp = new c()
    {
      private boolean a(hz paramAnonymoushz)
      {
        int i = 0;
        AppMethodBeat.i(71830);
        n.this.Axm = paramAnonymoushz;
        Object localObject1 = n.this.Axm.dlM.result;
        if (n.this.Axm.dlM.dlO != null) {
          n.this.mPayChannel = n.this.Axm.dlM.dlO.getInt("pay_channel", 0);
        }
        Object localObject2;
        switch (n.this.Axm.dlM.actionCode)
        {
        default: 
          AppMethodBeat.o(71830);
          return false;
        case 12: 
          n localn = n.this;
          ad.d("MicroMsg.WalletGetA8KeyRedirectListener", "startBind reqKey = ".concat(String.valueOf(localObject1)));
          String[] arrayOfString = ((String)localObject1).replace("http://p.weixin.qq.com?", "").split("&");
          int j = arrayOfString.length;
          localObject2 = null;
          paramAnonymoushz = null;
          localObject1 = null;
          if (i < j)
          {
            String str = arrayOfString[i];
            Object localObject4;
            Object localObject3;
            if (str.startsWith("errcode="))
            {
              localObject4 = str.replace("errcode=", "");
              localObject3 = paramAnonymoushz;
            }
            for (;;)
            {
              i += 1;
              paramAnonymoushz = (hz)localObject3;
              localObject1 = localObject4;
              break;
              if (str.startsWith("errmsg="))
              {
                localObject3 = str.replace("errmsg=", "");
                localObject4 = localObject1;
              }
              else
              {
                localObject3 = paramAnonymoushz;
                localObject4 = localObject1;
                if (str.startsWith("importkey="))
                {
                  localObject2 = str.replace("importkey=", "");
                  localObject3 = paramAnonymoushz;
                  localObject4 = localObject1;
                }
              }
            }
          }
          if (("0".equals(localObject1)) && (!bt.isNullOrNil((String)localObject2)))
          {
            paramAnonymoushz = localn.Axm.dlM.context;
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("key_import_key", (String)localObject2);
            ((Intent)localObject1).putExtra("key_bind_scene", 2);
            ((Intent)localObject1).putExtra("key_custom_bind_tips", null);
            d.b(paramAnonymoushz, "wallet", ".bind.ui.WalletBindUI", (Intent)localObject1);
            if (localn.Axm.callback != null)
            {
              localn.Axm.dlN.ret = 1;
              localn.Axm.callback.run();
            }
          }
          for (;;)
          {
            AppMethodBeat.o(71830);
            return true;
            localObject1 = paramAnonymoushz;
            if (bt.isNullOrNil(paramAnonymoushz)) {
              localObject1 = localn.Axm.dlM.context.getString(2131765901);
            }
            com.tencent.mm.ui.base.h.d(localn.Axm.dlM.context, (String)localObject1, "", new n.6(localn));
          }
        }
        if (!com.tencent.mm.sdk.b.a.ESL.e(this)) {
          alive();
        }
        ad.d("MicroMsg.WalletGetA8KeyRedirectListener", "ReqKey = ".concat(String.valueOf(localObject1)));
        if (localObject1 != null)
        {
          if (((String)localObject1).startsWith("weixin://wxpay")) {
            if (bu.eGT())
            {
              ad.i("MicroMsg.WalletGetA8KeyRedirectListener", "go pay test logic");
              localObject2 = new nw();
              ((nw)localObject2).dsV.url = ((String)localObject1);
              ((nw)localObject2).dsV.scene = 4;
              ((nw)localObject2).dsV.channel = 12;
              ((nw)localObject2).dsV.sourceType = 0;
              ((nw)localObject2).dsV.source = "";
              ((nw)localObject2).dsV.context = paramAnonymoushz.dlM.context;
              n.a(n.this, (nw)localObject2);
              Toast.makeText(paramAnonymoushz.dlM.context, "click to do pay test", 1).show();
            }
          }
          for (;;)
          {
            AppMethodBeat.o(71830);
            return true;
            n.this.Axl = 4;
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(233, n.this);
            paramAnonymoushz = new k((String)localObject1, n.this.Axm.dlM.username, 4, 0, (int)System.currentTimeMillis(), new byte[0]);
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(paramAnonymoushz, 0);
            n.this.mRequestTime = System.currentTimeMillis();
            continue;
            n.this.Axl = 1;
            n.a(n.this, (String)localObject1, n.this.mPayChannel);
          }
        }
        AppMethodBeat.o(71830);
        return true;
      }
    };
    this.Axq = new c()
    {
      private boolean a(nw paramAnonymousnw)
      {
        AppMethodBeat.i(71832);
        n.a(n.this, paramAnonymousnw);
        AppMethodBeat.o(71832);
        return false;
      }
    };
    this.__eventId = xk.class.getName().hashCode();
    AppMethodBeat.o(71839);
  }
  
  private void eO(String paramString, int paramInt)
  {
    AppMethodBeat.i(71841);
    ad.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay reqKey = ".concat(String.valueOf(paramString)));
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dtb = this.Axl;
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
          localPayInfo.dcE = str2.replace("reqkey=", "");
          str1 = paramString;
          localObject2 = localObject1;
        }
        else if (str2.startsWith("uuid="))
        {
          localPayInfo.uuid = str2.replace("uuid=", "");
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
          localPayInfo.Axg = str2.replace("appsource=", "");
          str1 = paramString;
          localObject2 = localObject1;
        }
        else
        {
          str1 = paramString;
          localObject2 = localObject1;
          if (str2.startsWith("productid="))
          {
            localPayInfo.dft = str2.replace("productid=", "");
            str1 = paramString;
            localObject2 = localObject1;
          }
        }
      }
    }
    localPayInfo.channel = paramInt;
    if ("0".equals(localObject1))
    {
      com.tencent.mm.wallet_core.b.fjk();
      if ((com.tencent.mm.wallet_core.b.b(b.a.pom, true)) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_NATIVE_PAY_SWTICH_KEY")))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label496;
        }
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayQueryCashierPay(localPayInfo.dcE, localPayInfo.dtb);
        label413:
        if (this.Axm.callback != null)
        {
          this.Axm.dlN.ret = 1;
          this.Axm.callback.run();
        }
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(localObject1)) && (Pattern.compile("[0-9]*").matcher(localObject1).matches())) {
        n(0, Integer.valueOf(localObject1).intValue(), 0L);
      }
      AppMethodBeat.o(71841);
      return;
      paramInt = 0;
      break;
      label496:
      f.a(this.Axm.dlM.context, localPayInfo, 0);
      break label413;
      str1 = paramString;
      if (bt.isNullOrNil(paramString)) {
        str1 = this.Axm.dlM.context.getString(2131765901);
      }
      com.tencent.mm.ui.base.h.d(this.Axm.dlM.context, str1, "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(71836);
          if (n.this.Axm.callback != null)
          {
            n.this.Axm.dlN.ret = 1;
            n.this.Axm.callback.run();
          }
          AppMethodBeat.o(71836);
        }
      });
    }
  }
  
  private void n(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(71842);
    int i = 132;
    if (this.Axl == 1) {
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
    else if ((this.Axl == 4) && (paramLong > 0L))
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
      com.tencent.mm.plugin.report.service.h.vKh.b(localArrayList, true);
      AppMethodBeat.o(71842);
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(71840);
    if ((paramn instanceof k))
    {
      long l = System.currentTimeMillis() - this.mRequestTime;
      com.tencent.mm.plugin.report.service.h.vKh.f(11170, new Object[] { Integer.valueOf(233), Integer.valueOf(0), Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(ay.getNetType(aj.getContext())), "" });
      n(paramInt1, paramInt2, l);
      ad.d("MicroMsg.WalletGetA8KeyRedirectListener", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(233, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramn = paramString;
        if (bt.isNullOrNil(paramString)) {
          paramn = this.Axm.dlM.context.getString(2131765901);
        }
        com.tencent.mm.ui.base.h.d(this.Axm.dlM.context, paramn, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71834);
            if (n.this.Axm.callback != null)
            {
              n.this.Axm.dlN.ret = 1;
              n.this.Axm.callback.run();
            }
            AppMethodBeat.o(71834);
          }
        });
        AppMethodBeat.o(71840);
        return;
      }
      eO(((k)paramn).aAq(), this.mPayChannel);
      AppMethodBeat.o(71840);
      return;
    }
    if ((paramn instanceof o))
    {
      ad.d("MicroMsg.WalletGetA8KeyRedirectListener", "native auth, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(385, this);
      if ((paramInt1 != 0) || (paramInt2 != 0) || (!"0".equals(((o)paramn).IeM)))
      {
        if (this.Axn.callback != null) {
          this.Axn.dsW.ret = 1;
        }
        if (!bt.isNullOrNil(paramString)) {}
        for (;;)
        {
          af.v(this.Axl, "", paramInt2);
          com.tencent.mm.ui.base.h.d(this.Axn.dsV.context, paramString, "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(71835);
              if (n.this.Axn.callback != null)
              {
                n.this.Axn.dsW.ret = 1;
                n.this.Axn.callback.run();
              }
              AppMethodBeat.o(71835);
            }
          });
          AppMethodBeat.o(71840);
          return;
          if (!bt.isNullOrNil(((o)paramn).jwH)) {
            paramString = ((o)paramn).jwH;
          } else {
            paramString = this.Axn.dsV.context.getString(2131765901);
          }
        }
      }
      if (this.Axn.callback != null)
      {
        this.Axn.dsW.ret = 2;
        this.Axn.callback.run();
      }
      af.v(this.Axl, ((o)paramn).dcE, paramInt2);
      paramString = ((o)paramn).Axh;
      if ((paramString != null) && (!bt.isNullOrNil(paramString.EFF)))
      {
        paramn = (o)paramn;
        paramString = new Intent();
        paramString.putExtra("prepayId", paramn.dcE);
        paramString.putExtra("is_jsapi_offline_pay", false);
        paramn = paramn.Axh;
        paramString.putExtra("pay_gate_url", paramn.EFF);
        paramString.putExtra("need_dialog", paramn.EFH);
        paramString.putExtra("dialog_text", paramn.EFI);
        paramString.putExtra("max_count", paramn.EFG.COZ);
        paramString.putExtra("inteval_time", paramn.EFG.COY);
        paramString.putExtra("default_wording", paramn.EFG.CPa);
        d.c((Activity)this.Axn.dsV.context, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
        if (this.Axn.callback != null)
        {
          this.Axn.dsW.ret = 2;
          this.Axn.callback.run();
        }
        ad.d("MicroMsg.WalletGetA8KeyRedirectListener", "mAuthNativeEvent.data.context: %s", new Object[] { this.Axn.dsV.context });
        AppMethodBeat.o(71840);
        return;
      }
      paramString = (o)paramn;
      paramn = new PayInfo();
      paramn.dtb = this.Axl;
      paramn.dcE = paramString.dcE;
      paramn.appId = paramString.appId;
      paramn.Axg = paramString.Axg;
      paramn.dft = paramString.dft;
      paramn.channel = paramString.channel;
      ad.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay native, payInfo: %s", new Object[] { paramn.toString() });
      f.a(this.Axn.dsV.context, paramn, 0);
      if (this.Axn.callback != null)
      {
        this.Axn.dsW.ret = 2;
        this.Axn.callback.run();
      }
      AppMethodBeat.o(71840);
      return;
    }
    ad.i("MicroMsg.WalletGetA8KeyRedirectListener", "other scene");
    AppMethodBeat.o(71840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.n
 * JD-Core Version:    0.7.0.1
 */