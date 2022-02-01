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
import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.a.ip.a;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.op.a;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.eda;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.tenpay.model.o;
import java.util.ArrayList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class n
  extends c<yv>
  implements com.tencent.mm.ak.f
{
  int DHD;
  ip DHE;
  op DHF;
  private Queue<op> DHG;
  public c DHH;
  public c<op> DHI;
  int mPayChannel;
  long mRequestTime;
  
  public n()
  {
    AppMethodBeat.i(71839);
    this.mPayChannel = 0;
    this.DHH = new c()
    {
      private boolean a(ip paramAnonymousip)
      {
        int i = 0;
        AppMethodBeat.i(71830);
        n.this.DHE = paramAnonymousip;
        Object localObject1 = n.this.DHE.dwm.result;
        if (n.this.DHE.dwm.dwo != null) {
          n.this.mPayChannel = n.this.DHE.dwm.dwo.getInt("pay_channel", 0);
        }
        Object localObject2;
        switch (n.this.DHE.dwm.actionCode)
        {
        default: 
          AppMethodBeat.o(71830);
          return false;
        case 12: 
          n localn = n.this;
          ae.d("MicroMsg.WalletGetA8KeyRedirectListener", "startBind reqKey = ".concat(String.valueOf(localObject1)));
          String[] arrayOfString = ((String)localObject1).replace("http://p.weixin.qq.com?", "").split("&");
          int j = arrayOfString.length;
          localObject2 = null;
          paramAnonymousip = null;
          localObject1 = null;
          if (i < j)
          {
            String str = arrayOfString[i];
            Object localObject4;
            Object localObject3;
            if (str.startsWith("errcode="))
            {
              localObject4 = str.replace("errcode=", "");
              localObject3 = paramAnonymousip;
            }
            for (;;)
            {
              i += 1;
              paramAnonymousip = (ip)localObject3;
              localObject1 = localObject4;
              break;
              if (str.startsWith("errmsg="))
              {
                localObject3 = str.replace("errmsg=", "");
                localObject4 = localObject1;
              }
              else
              {
                localObject3 = paramAnonymousip;
                localObject4 = localObject1;
                if (str.startsWith("importkey="))
                {
                  localObject2 = str.replace("importkey=", "");
                  localObject3 = paramAnonymousip;
                  localObject4 = localObject1;
                }
              }
            }
          }
          if (("0".equals(localObject1)) && (!bu.isNullOrNil((String)localObject2)))
          {
            paramAnonymousip = localn.DHE.dwm.context;
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("key_import_key", (String)localObject2);
            ((Intent)localObject1).putExtra("key_bind_scene", 2);
            ((Intent)localObject1).putExtra("key_custom_bind_tips", null);
            d.b(paramAnonymousip, "wallet", ".bind.ui.WalletBindUI", (Intent)localObject1);
            if (localn.DHE.callback != null)
            {
              localn.DHE.dwn.ret = 1;
              localn.DHE.callback.run();
            }
          }
          for (;;)
          {
            AppMethodBeat.o(71830);
            return true;
            localObject1 = paramAnonymousip;
            if (bu.isNullOrNil(paramAnonymousip)) {
              localObject1 = localn.DHE.dwm.context.getString(2131765901);
            }
            h.d(localn.DHE.dwm.context, (String)localObject1, "", new n.6(localn));
          }
        }
        if (!com.tencent.mm.sdk.b.a.IvT.e(this)) {
          alive();
        }
        ae.d("MicroMsg.WalletGetA8KeyRedirectListener", "ReqKey = ".concat(String.valueOf(localObject1)));
        if (localObject1 != null)
        {
          if (((String)localObject1).startsWith("weixin://wxpay")) {
            if (bv.fpT())
            {
              ae.i("MicroMsg.WalletGetA8KeyRedirectListener", "go pay test logic");
              localObject2 = new op();
              ((op)localObject2).dDB.url = ((String)localObject1);
              ((op)localObject2).dDB.scene = 4;
              ((op)localObject2).dDB.channel = 12;
              ((op)localObject2).dDB.sourceType = 0;
              ((op)localObject2).dDB.source = "";
              ((op)localObject2).dDB.context = paramAnonymousip.dwm.context;
              n.a(n.this, (op)localObject2);
              Toast.makeText(paramAnonymousip.dwm.context, "click to do pay test", 1).show();
            }
          }
          for (;;)
          {
            AppMethodBeat.o(71830);
            return true;
            n.this.DHD = 4;
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(233, n.this);
            paramAnonymousip = new l((String)localObject1, n.this.DHE.dwm.username, 4, 0, (int)System.currentTimeMillis(), new byte[0]);
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(paramAnonymousip, 0);
            n.this.mRequestTime = System.currentTimeMillis();
            continue;
            n.this.DHD = 1;
            n.a(n.this, (String)localObject1, n.this.mPayChannel);
          }
        }
        AppMethodBeat.o(71830);
        return true;
      }
    };
    this.DHI = new c()
    {
      private boolean a(op paramAnonymousop)
      {
        AppMethodBeat.i(71832);
        n.a(n.this, paramAnonymousop);
        AppMethodBeat.o(71832);
        return false;
      }
    };
    this.__eventId = yv.class.getName().hashCode();
    AppMethodBeat.o(71839);
  }
  
  private void fy(String paramString, int paramInt)
  {
    AppMethodBeat.i(71841);
    ae.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay reqKey = ".concat(String.valueOf(paramString)));
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dDH = this.DHD;
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
          localPayInfo.dmw = str2.replace("reqkey=", "");
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
          localPayInfo.DHy = str2.replace("appsource=", "");
          str1 = paramString;
          localObject2 = localObject1;
        }
        else
        {
          str1 = paramString;
          localObject2 = localObject1;
          if (str2.startsWith("productid="))
          {
            localPayInfo.dpp = str2.replace("productid=", "");
            str1 = paramString;
            localObject2 = localObject1;
          }
        }
      }
    }
    localPayInfo.channel = paramInt;
    if ("0".equals(localObject1))
    {
      com.tencent.mm.wallet_core.b.fVf();
      if ((com.tencent.mm.wallet_core.b.b(b.a.qDk, true)) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_NATIVE_PAY_SWTICH_KEY")))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label496;
        }
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayQueryCashierPay(localPayInfo.dmw, localPayInfo.dDH);
        label413:
        if (this.DHE.callback != null)
        {
          this.DHE.dwn.ret = 1;
          this.DHE.callback.run();
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
      com.tencent.mm.pluginsdk.wallet.f.a(this.DHE.dwm.context, localPayInfo, 0);
      break label413;
      str1 = paramString;
      if (bu.isNullOrNil(paramString)) {
        str1 = this.DHE.dwm.context.getString(2131765901);
      }
      h.d(this.DHE.dwm.context, str1, "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(71836);
          if (n.this.DHE.callback != null)
          {
            n.this.DHE.dwn.ret = 1;
            n.this.DHE.callback.run();
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
    if (this.DHD == 1) {
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
    else if ((this.DHD == 4) && (paramLong > 0L))
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
      com.tencent.mm.plugin.report.service.g.yxI.b(localArrayList, true);
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
    if ((paramn instanceof l))
    {
      long l = System.currentTimeMillis() - this.mRequestTime;
      com.tencent.mm.plugin.report.service.g.yxI.f(11170, new Object[] { Integer.valueOf(233), Integer.valueOf(0), Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(az.getNetType(ak.getContext())), "" });
      o(paramInt1, paramInt2, l);
      ae.d("MicroMsg.WalletGetA8KeyRedirectListener", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.b(233, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramn = paramString;
        if (bu.isNullOrNil(paramString)) {
          paramn = this.DHE.dwm.context.getString(2131765901);
        }
        h.d(this.DHE.dwm.context, paramn, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71834);
            if (n.this.DHE.callback != null)
            {
              n.this.DHE.dwn.ret = 1;
              n.this.DHE.callback.run();
            }
            AppMethodBeat.o(71834);
          }
        });
        AppMethodBeat.o(71840);
        return;
      }
      fy(((l)paramn).aKO(), this.mPayChannel);
      AppMethodBeat.o(71840);
      return;
    }
    if ((paramn instanceof o))
    {
      ae.d("MicroMsg.WalletGetA8KeyRedirectListener", "native auth, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.b(385, this);
      if ((paramInt1 != 0) || (paramInt2 != 0) || (!"0".equals(((o)paramn).LWh)))
      {
        if (this.DHF.callback != null) {
          this.DHF.dDC.ret = 1;
        }
        if (!bu.isNullOrNil(paramString)) {}
        for (;;)
        {
          af.w(this.DHD, "", paramInt2);
          h.d(this.DHF.dDB.context, paramString, "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(71835);
              if (n.this.DHF.callback != null)
              {
                n.this.DHF.dDC.ret = 1;
                n.this.DHF.callback.run();
              }
              AppMethodBeat.o(71835);
            }
          });
          AppMethodBeat.o(71840);
          return;
          if (!bu.isNullOrNil(((o)paramn).kuP)) {
            paramString = ((o)paramn).kuP;
          } else {
            paramString = this.DHF.dDB.context.getString(2131765901);
          }
        }
      }
      if (this.DHF.callback != null)
      {
        this.DHF.dDC.ret = 2;
        this.DHF.callback.run();
      }
      af.w(this.DHD, ((o)paramn).dmw, paramInt2);
      paramString = ((o)paramn).DHz;
      if ((paramString != null) && (!bu.isNullOrNil(paramString.Iie)))
      {
        paramn = (o)paramn;
        paramString = new Intent();
        paramString.putExtra("prepayId", paramn.dmw);
        paramString.putExtra("is_jsapi_offline_pay", false);
        paramn = paramn.DHz;
        paramString.putExtra("pay_gate_url", paramn.Iie);
        paramString.putExtra("need_dialog", paramn.Iig);
        paramString.putExtra("dialog_text", paramn.Iih);
        paramString.putExtra("max_count", paramn.Iif.Ghq);
        paramString.putExtra("inteval_time", paramn.Iif.Ghp);
        paramString.putExtra("default_wording", paramn.Iif.Ghr);
        d.c((Activity)this.DHF.dDB.context, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
        if (this.DHF.callback != null)
        {
          this.DHF.dDC.ret = 2;
          this.DHF.callback.run();
        }
        ae.d("MicroMsg.WalletGetA8KeyRedirectListener", "mAuthNativeEvent.data.context: %s", new Object[] { this.DHF.dDB.context });
        AppMethodBeat.o(71840);
        return;
      }
      paramString = (o)paramn;
      paramn = new PayInfo();
      paramn.dDH = this.DHD;
      paramn.dmw = paramString.dmw;
      paramn.appId = paramString.appId;
      paramn.DHy = paramString.DHy;
      paramn.dpp = paramString.dpp;
      paramn.channel = paramString.channel;
      ae.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay native, payInfo: %s", new Object[] { paramn.toString() });
      com.tencent.mm.pluginsdk.wallet.f.a(this.DHF.dDB.context, paramn, 0);
      if (this.DHF.callback != null)
      {
        this.DHF.dDC.ret = 2;
        this.DHF.callback.run();
      }
      AppMethodBeat.o(71840);
      return;
    }
    ae.i("MicroMsg.WalletGetA8KeyRedirectListener", "other scene");
    AppMethodBeat.o(71840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.n
 * JD-Core Version:    0.7.0.1
 */