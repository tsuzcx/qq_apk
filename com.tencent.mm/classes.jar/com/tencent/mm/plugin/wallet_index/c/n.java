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
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.a.io.a;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.g.a.oo.a;
import com.tencent.mm.g.a.yp;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.sc;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.tenpay.model.o;
import java.util.ArrayList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class n
  extends c<yp>
  implements com.tencent.mm.al.f
{
  int DpX;
  io DpY;
  oo DpZ;
  private Queue<oo> Dqa;
  public c Dqb;
  public c<oo> Dqc;
  int mPayChannel;
  long mRequestTime;
  
  public n()
  {
    AppMethodBeat.i(71839);
    this.mPayChannel = 0;
    this.Dqb = new c()
    {
      private boolean a(io paramAnonymousio)
      {
        int i = 0;
        AppMethodBeat.i(71830);
        n.this.DpY = paramAnonymousio;
        Object localObject1 = n.this.DpY.dvh.result;
        if (n.this.DpY.dvh.dvj != null) {
          n.this.mPayChannel = n.this.DpY.dvh.dvj.getInt("pay_channel", 0);
        }
        Object localObject2;
        switch (n.this.DpY.dvh.actionCode)
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
          paramAnonymousio = null;
          localObject1 = null;
          if (i < j)
          {
            String str = arrayOfString[i];
            Object localObject4;
            Object localObject3;
            if (str.startsWith("errcode="))
            {
              localObject4 = str.replace("errcode=", "");
              localObject3 = paramAnonymousio;
            }
            for (;;)
            {
              i += 1;
              paramAnonymousio = (io)localObject3;
              localObject1 = localObject4;
              break;
              if (str.startsWith("errmsg="))
              {
                localObject3 = str.replace("errmsg=", "");
                localObject4 = localObject1;
              }
              else
              {
                localObject3 = paramAnonymousio;
                localObject4 = localObject1;
                if (str.startsWith("importkey="))
                {
                  localObject2 = str.replace("importkey=", "");
                  localObject3 = paramAnonymousio;
                  localObject4 = localObject1;
                }
              }
            }
          }
          if (("0".equals(localObject1)) && (!bt.isNullOrNil((String)localObject2)))
          {
            paramAnonymousio = localn.DpY.dvh.context;
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("key_import_key", (String)localObject2);
            ((Intent)localObject1).putExtra("key_bind_scene", 2);
            ((Intent)localObject1).putExtra("key_custom_bind_tips", null);
            d.b(paramAnonymousio, "wallet", ".bind.ui.WalletBindUI", (Intent)localObject1);
            if (localn.DpY.callback != null)
            {
              localn.DpY.dvi.ret = 1;
              localn.DpY.callback.run();
            }
          }
          for (;;)
          {
            AppMethodBeat.o(71830);
            return true;
            localObject1 = paramAnonymousio;
            if (bt.isNullOrNil(paramAnonymousio)) {
              localObject1 = localn.DpY.dvh.context.getString(2131765901);
            }
            h.d(localn.DpY.dvh.context, (String)localObject1, "", new n.6(localn));
          }
        }
        if (!com.tencent.mm.sdk.b.a.IbL.e(this)) {
          alive();
        }
        ad.d("MicroMsg.WalletGetA8KeyRedirectListener", "ReqKey = ".concat(String.valueOf(localObject1)));
        if (localObject1 != null)
        {
          if (((String)localObject1).startsWith("weixin://wxpay")) {
            if (bu.flY())
            {
              ad.i("MicroMsg.WalletGetA8KeyRedirectListener", "go pay test logic");
              localObject2 = new oo();
              ((oo)localObject2).dCw.url = ((String)localObject1);
              ((oo)localObject2).dCw.scene = 4;
              ((oo)localObject2).dCw.channel = 12;
              ((oo)localObject2).dCw.sourceType = 0;
              ((oo)localObject2).dCw.source = "";
              ((oo)localObject2).dCw.context = paramAnonymousio.dvh.context;
              n.a(n.this, (oo)localObject2);
              Toast.makeText(paramAnonymousio.dvh.context, "click to do pay test", 1).show();
            }
          }
          for (;;)
          {
            AppMethodBeat.o(71830);
            return true;
            n.this.DpX = 4;
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.a(233, n.this);
            paramAnonymousio = new k((String)localObject1, n.this.DpY.dvh.username, 4, 0, (int)System.currentTimeMillis(), new byte[0]);
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.a(paramAnonymousio, 0);
            n.this.mRequestTime = System.currentTimeMillis();
            continue;
            n.this.DpX = 1;
            n.a(n.this, (String)localObject1, n.this.mPayChannel);
          }
        }
        AppMethodBeat.o(71830);
        return true;
      }
    };
    this.Dqc = new c()
    {
      private boolean a(oo paramAnonymousoo)
      {
        AppMethodBeat.i(71832);
        n.a(n.this, paramAnonymousoo);
        AppMethodBeat.o(71832);
        return false;
      }
    };
    this.__eventId = yp.class.getName().hashCode();
    AppMethodBeat.o(71839);
  }
  
  private void fp(String paramString, int paramInt)
  {
    AppMethodBeat.i(71841);
    ad.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay reqKey = ".concat(String.valueOf(paramString)));
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dCC = this.DpX;
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
          localPayInfo.dlu = str2.replace("reqkey=", "");
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
          localPayInfo.DpS = str2.replace("appsource=", "");
          str1 = paramString;
          localObject2 = localObject1;
        }
        else
        {
          str1 = paramString;
          localObject2 = localObject1;
          if (str2.startsWith("productid="))
          {
            localPayInfo.dok = str2.replace("productid=", "");
            str1 = paramString;
            localObject2 = localObject1;
          }
        }
      }
    }
    localPayInfo.channel = paramInt;
    if ("0".equals(localObject1))
    {
      com.tencent.mm.wallet_core.b.fQJ();
      if ((com.tencent.mm.wallet_core.b.b(b.a.qwl, true)) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_NATIVE_PAY_SWTICH_KEY")))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label496;
        }
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayQueryCashierPay(localPayInfo.dlu, localPayInfo.dCC);
        label413:
        if (this.DpY.callback != null)
        {
          this.DpY.dvi.ret = 1;
          this.DpY.callback.run();
        }
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(localObject1)) && (Pattern.compile("[0-9]*").matcher(localObject1).matches())) {
        o(0, Integer.valueOf(localObject1).intValue(), 0L);
      }
      AppMethodBeat.o(71841);
      return;
      paramInt = 0;
      break;
      label496:
      com.tencent.mm.pluginsdk.wallet.f.a(this.DpY.dvh.context, localPayInfo, 0);
      break label413;
      str1 = paramString;
      if (bt.isNullOrNil(paramString)) {
        str1 = this.DpY.dvh.context.getString(2131765901);
      }
      h.d(this.DpY.dvh.context, str1, "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(71836);
          if (n.this.DpY.callback != null)
          {
            n.this.DpY.dvi.ret = 1;
            n.this.DpY.callback.run();
          }
          AppMethodBeat.o(71836);
        }
      });
    }
  }
  
  private void o(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(71842);
    int i = 132;
    if (this.DpX == 1) {
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
    else if ((this.DpX == 4) && (paramLong > 0L))
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
      com.tencent.mm.plugin.report.service.g.yhR.b(localArrayList, true);
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
      com.tencent.mm.plugin.report.service.g.yhR.f(11170, new Object[] { Integer.valueOf(233), Integer.valueOf(0), Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(ay.getNetType(aj.getContext())), "" });
      o(paramInt1, paramInt2, l);
      ad.d("MicroMsg.WalletGetA8KeyRedirectListener", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.b(233, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramn = paramString;
        if (bt.isNullOrNil(paramString)) {
          paramn = this.DpY.dvh.context.getString(2131765901);
        }
        h.d(this.DpY.dvh.context, paramn, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71834);
            if (n.this.DpY.callback != null)
            {
              n.this.DpY.dvi.ret = 1;
              n.this.DpY.callback.run();
            }
            AppMethodBeat.o(71834);
          }
        });
        AppMethodBeat.o(71840);
        return;
      }
      fp(((k)paramn).aKr(), this.mPayChannel);
      AppMethodBeat.o(71840);
      return;
    }
    if ((paramn instanceof o))
    {
      ad.d("MicroMsg.WalletGetA8KeyRedirectListener", "native auth, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.b(385, this);
      if ((paramInt1 != 0) || (paramInt2 != 0) || (!"0".equals(((o)paramn).Lzs)))
      {
        if (this.DpZ.callback != null) {
          this.DpZ.dCx.ret = 1;
        }
        if (!bt.isNullOrNil(paramString)) {}
        for (;;)
        {
          af.w(this.DpX, "", paramInt2);
          h.d(this.DpZ.dCw.context, paramString, "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(71835);
              if (n.this.DpZ.callback != null)
              {
                n.this.DpZ.dCx.ret = 1;
                n.this.DpZ.callback.run();
              }
              AppMethodBeat.o(71835);
            }
          });
          AppMethodBeat.o(71840);
          return;
          if (!bt.isNullOrNil(((o)paramn).krz)) {
            paramString = ((o)paramn).krz;
          } else {
            paramString = this.DpZ.dCw.context.getString(2131765901);
          }
        }
      }
      if (this.DpZ.callback != null)
      {
        this.DpZ.dCx.ret = 2;
        this.DpZ.callback.run();
      }
      af.w(this.DpX, ((o)paramn).dlu, paramInt2);
      paramString = ((o)paramn).DpT;
      if ((paramString != null) && (!bt.isNullOrNil(paramString.HNX)))
      {
        paramn = (o)paramn;
        paramString = new Intent();
        paramString.putExtra("prepayId", paramn.dlu);
        paramString.putExtra("is_jsapi_offline_pay", false);
        paramn = paramn.DpT;
        paramString.putExtra("pay_gate_url", paramn.HNX);
        paramString.putExtra("need_dialog", paramn.HNZ);
        paramString.putExtra("dialog_text", paramn.HOa);
        paramString.putExtra("max_count", paramn.HNY.FOR);
        paramString.putExtra("inteval_time", paramn.HNY.FOQ);
        paramString.putExtra("default_wording", paramn.HNY.FOS);
        d.c((Activity)this.DpZ.dCw.context, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
        if (this.DpZ.callback != null)
        {
          this.DpZ.dCx.ret = 2;
          this.DpZ.callback.run();
        }
        ad.d("MicroMsg.WalletGetA8KeyRedirectListener", "mAuthNativeEvent.data.context: %s", new Object[] { this.DpZ.dCw.context });
        AppMethodBeat.o(71840);
        return;
      }
      paramString = (o)paramn;
      paramn = new PayInfo();
      paramn.dCC = this.DpX;
      paramn.dlu = paramString.dlu;
      paramn.appId = paramString.appId;
      paramn.DpS = paramString.DpS;
      paramn.dok = paramString.dok;
      paramn.channel = paramString.channel;
      ad.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay native, payInfo: %s", new Object[] { paramn.toString() });
      com.tencent.mm.pluginsdk.wallet.f.a(this.DpZ.dCw.context, paramn, 0);
      if (this.DpZ.callback != null)
      {
        this.DpZ.dCx.ret = 2;
        this.DpZ.callback.run();
      }
      AppMethodBeat.o(71840);
      return;
    }
    ad.i("MicroMsg.WalletGetA8KeyRedirectListener", "other scene");
    AppMethodBeat.o(71840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.n
 * JD-Core Version:    0.7.0.1
 */