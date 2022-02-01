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
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.g.a.ig.a;
import com.tencent.mm.g.a.of;
import com.tencent.mm.g.a.of.a;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.protocal.protobuf.ql;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.tenpay.model.o;
import java.util.ArrayList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class n
  extends c<xv>
  implements com.tencent.mm.ak.g
{
  int BPF;
  ig BPG;
  of BPH;
  private Queue<of> BPI;
  public c BPJ;
  public c<of> BPK;
  int mPayChannel;
  long mRequestTime;
  
  public n()
  {
    AppMethodBeat.i(71839);
    this.mPayChannel = 0;
    this.BPJ = new c()
    {
      private boolean a(ig paramAnonymousig)
      {
        int i = 0;
        AppMethodBeat.i(71830);
        n.this.BPG = paramAnonymousig;
        Object localObject1 = n.this.BPG.dju.result;
        if (n.this.BPG.dju.djw != null) {
          n.this.mPayChannel = n.this.BPG.dju.djw.getInt("pay_channel", 0);
        }
        Object localObject2;
        switch (n.this.BPG.dju.actionCode)
        {
        default: 
          AppMethodBeat.o(71830);
          return false;
        case 12: 
          n localn = n.this;
          ac.d("MicroMsg.WalletGetA8KeyRedirectListener", "startBind reqKey = ".concat(String.valueOf(localObject1)));
          String[] arrayOfString = ((String)localObject1).replace("http://p.weixin.qq.com?", "").split("&");
          int j = arrayOfString.length;
          localObject2 = null;
          paramAnonymousig = null;
          localObject1 = null;
          if (i < j)
          {
            String str = arrayOfString[i];
            Object localObject4;
            Object localObject3;
            if (str.startsWith("errcode="))
            {
              localObject4 = str.replace("errcode=", "");
              localObject3 = paramAnonymousig;
            }
            for (;;)
            {
              i += 1;
              paramAnonymousig = (ig)localObject3;
              localObject1 = localObject4;
              break;
              if (str.startsWith("errmsg="))
              {
                localObject3 = str.replace("errmsg=", "");
                localObject4 = localObject1;
              }
              else
              {
                localObject3 = paramAnonymousig;
                localObject4 = localObject1;
                if (str.startsWith("importkey="))
                {
                  localObject2 = str.replace("importkey=", "");
                  localObject3 = paramAnonymousig;
                  localObject4 = localObject1;
                }
              }
            }
          }
          if (("0".equals(localObject1)) && (!bs.isNullOrNil((String)localObject2)))
          {
            paramAnonymousig = localn.BPG.dju.context;
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("key_import_key", (String)localObject2);
            ((Intent)localObject1).putExtra("key_bind_scene", 2);
            ((Intent)localObject1).putExtra("key_custom_bind_tips", null);
            d.b(paramAnonymousig, "wallet", ".bind.ui.WalletBindUI", (Intent)localObject1);
            if (localn.BPG.callback != null)
            {
              localn.BPG.djv.ret = 1;
              localn.BPG.callback.run();
            }
          }
          for (;;)
          {
            AppMethodBeat.o(71830);
            return true;
            localObject1 = paramAnonymousig;
            if (bs.isNullOrNil(paramAnonymousig)) {
              localObject1 = localn.BPG.dju.context.getString(2131765901);
            }
            com.tencent.mm.ui.base.h.d(localn.BPG.dju.context, (String)localObject1, "", new n.6(localn));
          }
        }
        if (!com.tencent.mm.sdk.b.a.GpY.e(this)) {
          alive();
        }
        ac.d("MicroMsg.WalletGetA8KeyRedirectListener", "ReqKey = ".concat(String.valueOf(localObject1)));
        if (localObject1 != null)
        {
          if (((String)localObject1).startsWith("weixin://wxpay")) {
            if (bt.eWo())
            {
              ac.i("MicroMsg.WalletGetA8KeyRedirectListener", "go pay test logic");
              localObject2 = new of();
              ((of)localObject2).dqF.url = ((String)localObject1);
              ((of)localObject2).dqF.scene = 4;
              ((of)localObject2).dqF.channel = 12;
              ((of)localObject2).dqF.sourceType = 0;
              ((of)localObject2).dqF.source = "";
              ((of)localObject2).dqF.context = paramAnonymousig.dju.context;
              n.a(n.this, (of)localObject2);
              Toast.makeText(paramAnonymousig.dju.context, "click to do pay test", 1).show();
            }
          }
          for (;;)
          {
            AppMethodBeat.o(71830);
            return true;
            n.this.BPF = 4;
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.a(233, n.this);
            paramAnonymousig = new k((String)localObject1, n.this.BPG.dju.username, 4, 0, (int)System.currentTimeMillis(), new byte[0]);
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.a(paramAnonymousig, 0);
            n.this.mRequestTime = System.currentTimeMillis();
            continue;
            n.this.BPF = 1;
            n.a(n.this, (String)localObject1, n.this.mPayChannel);
          }
        }
        AppMethodBeat.o(71830);
        return true;
      }
    };
    this.BPK = new c()
    {
      private boolean a(of paramAnonymousof)
      {
        AppMethodBeat.i(71832);
        n.a(n.this, paramAnonymousof);
        AppMethodBeat.o(71832);
        return false;
      }
    };
    this.__eventId = xv.class.getName().hashCode();
    AppMethodBeat.o(71839);
  }
  
  private void eW(String paramString, int paramInt)
  {
    AppMethodBeat.i(71841);
    ac.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay reqKey = ".concat(String.valueOf(paramString)));
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dqL = this.BPF;
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
          localPayInfo.dac = str2.replace("reqkey=", "");
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
          localPayInfo.BPA = str2.replace("appsource=", "");
          str1 = paramString;
          localObject2 = localObject1;
        }
        else
        {
          str1 = paramString;
          localObject2 = localObject1;
          if (str2.startsWith("productid="))
          {
            localPayInfo.dcO = str2.replace("productid=", "");
            str1 = paramString;
            localObject2 = localObject1;
          }
        }
      }
    }
    localPayInfo.channel = paramInt;
    if ("0".equals(localObject1))
    {
      com.tencent.mm.wallet_core.b.fzz();
      if ((com.tencent.mm.wallet_core.b.b(b.a.pRO, true)) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_NATIVE_PAY_SWTICH_KEY")))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label496;
        }
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayQueryCashierPay(localPayInfo.dac, localPayInfo.dqL);
        label413:
        if (this.BPG.callback != null)
        {
          this.BPG.djv.ret = 1;
          this.BPG.callback.run();
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
      f.a(this.BPG.dju.context, localPayInfo, 0);
      break label413;
      str1 = paramString;
      if (bs.isNullOrNil(paramString)) {
        str1 = this.BPG.dju.context.getString(2131765901);
      }
      com.tencent.mm.ui.base.h.d(this.BPG.dju.context, str1, "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(71836);
          if (n.this.BPG.callback != null)
          {
            n.this.BPG.djv.ret = 1;
            n.this.BPG.callback.run();
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
    if (this.BPF == 1) {
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
    else if ((this.BPF == 4) && (paramLong > 0L))
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
      com.tencent.mm.plugin.report.service.h.wUl.b(localArrayList, true);
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(71840);
    if ((paramn instanceof k))
    {
      long l = System.currentTimeMillis() - this.mRequestTime;
      com.tencent.mm.plugin.report.service.h.wUl.f(11170, new Object[] { Integer.valueOf(233), Integer.valueOf(0), Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(ax.getNetType(ai.getContext())), "" });
      n(paramInt1, paramInt2, l);
      ac.d("MicroMsg.WalletGetA8KeyRedirectListener", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(233, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramn = paramString;
        if (bs.isNullOrNil(paramString)) {
          paramn = this.BPG.dju.context.getString(2131765901);
        }
        com.tencent.mm.ui.base.h.d(this.BPG.dju.context, paramn, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71834);
            if (n.this.BPG.callback != null)
            {
              n.this.BPG.djv.ret = 1;
              n.this.BPG.callback.run();
            }
            AppMethodBeat.o(71834);
          }
        });
        AppMethodBeat.o(71840);
        return;
      }
      eW(((k)paramn).aHg(), this.mPayChannel);
      AppMethodBeat.o(71840);
      return;
    }
    if ((paramn instanceof o))
    {
      ac.d("MicroMsg.WalletGetA8KeyRedirectListener", "native auth, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(385, this);
      if ((paramInt1 != 0) || (paramInt2 != 0) || (!"0".equals(((o)paramn).JGo)))
      {
        if (this.BPH.callback != null) {
          this.BPH.dqG.ret = 1;
        }
        if (!bs.isNullOrNil(paramString)) {}
        for (;;)
        {
          af.x(this.BPF, "", paramInt2);
          com.tencent.mm.ui.base.h.d(this.BPH.dqF.context, paramString, "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(71835);
              if (n.this.BPH.callback != null)
              {
                n.this.BPH.dqG.ret = 1;
                n.this.BPH.callback.run();
              }
              AppMethodBeat.o(71835);
            }
          });
          AppMethodBeat.o(71840);
          return;
          if (!bs.isNullOrNil(((o)paramn).jXd)) {
            paramString = ((o)paramn).jXd;
          } else {
            paramString = this.BPH.dqF.context.getString(2131765901);
          }
        }
      }
      if (this.BPH.callback != null)
      {
        this.BPH.dqG.ret = 2;
        this.BPH.callback.run();
      }
      af.x(this.BPF, ((o)paramn).dac, paramInt2);
      paramString = ((o)paramn).BPB;
      if ((paramString != null) && (!bs.isNullOrNil(paramString.GcR)))
      {
        paramn = (o)paramn;
        paramString = new Intent();
        paramString.putExtra("prepayId", paramn.dac);
        paramString.putExtra("is_jsapi_offline_pay", false);
        paramn = paramn.BPB;
        paramString.putExtra("pay_gate_url", paramn.GcR);
        paramString.putExtra("need_dialog", paramn.GcT);
        paramString.putExtra("dialog_text", paramn.GcU);
        paramString.putExtra("max_count", paramn.GcS.EhK);
        paramString.putExtra("inteval_time", paramn.GcS.EhJ);
        paramString.putExtra("default_wording", paramn.GcS.EhL);
        d.c((Activity)this.BPH.dqF.context, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
        if (this.BPH.callback != null)
        {
          this.BPH.dqG.ret = 2;
          this.BPH.callback.run();
        }
        ac.d("MicroMsg.WalletGetA8KeyRedirectListener", "mAuthNativeEvent.data.context: %s", new Object[] { this.BPH.dqF.context });
        AppMethodBeat.o(71840);
        return;
      }
      paramString = (o)paramn;
      paramn = new PayInfo();
      paramn.dqL = this.BPF;
      paramn.dac = paramString.dac;
      paramn.appId = paramString.appId;
      paramn.BPA = paramString.BPA;
      paramn.dcO = paramString.dcO;
      paramn.channel = paramString.channel;
      ac.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay native, payInfo: %s", new Object[] { paramn.toString() });
      f.a(this.BPH.dqF.context, paramn, 0);
      if (this.BPH.callback != null)
      {
        this.BPH.dqG.ret = 2;
        this.BPH.callback.run();
      }
      AppMethodBeat.o(71840);
      return;
    }
    ac.i("MicroMsg.WalletGetA8KeyRedirectListener", "other scene");
    AppMethodBeat.o(71840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.n
 * JD-Core Version:    0.7.0.1
 */