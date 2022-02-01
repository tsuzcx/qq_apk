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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.abh;
import com.tencent.mm.f.a.ju;
import com.tencent.mm.f.a.ju.a;
import com.tencent.mm.f.a.qf;
import com.tencent.mm.f.a.qf.a;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.fhv;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.af;
import java.util.ArrayList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class o
  extends IListener<abh>
  implements i
{
  private static final String PjA;
  private static final String PjB;
  private int PjC;
  private ju PjD;
  private qf PjE;
  private Queue<qf> PjF;
  public IListener PjG;
  public IListener<qf> PjH;
  private int mPayChannel;
  private long mRequestTime;
  
  static
  {
    AppMethodBeat.i(250046);
    PjA = "http://" + WeChatHosts.domainString(a.i.host_p_weixin_qq_com) + "?";
    PjB = "http://" + WeChatHosts.domainString(a.i.host_p_qq_com) + "?";
    AppMethodBeat.o(250046);
  }
  
  public o()
  {
    AppMethodBeat.i(71839);
    this.mPayChannel = 0;
    this.PjG = new IListener()
    {
      private boolean a(ju paramAnonymousju)
      {
        AppMethodBeat.i(71830);
        o.a(o.this, paramAnonymousju);
        String str = o.a(o.this).fHe.result;
        if (o.a(o.this).fHe.fHg != null) {
          o.a(o.this, o.a(o.this).fHe.fHg.getInt("pay_channel", 0));
        }
        switch (o.a(o.this).fHe.actionCode)
        {
        default: 
          AppMethodBeat.o(71830);
          return false;
        case 12: 
          o.a(o.this, str);
          AppMethodBeat.o(71830);
          return true;
        }
        if (!EventCenter.instance.hadListened(this)) {
          alive();
        }
        Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "ReqKey = ".concat(String.valueOf(str)));
        if (str != null)
        {
          if (str.startsWith("weixin://wxpay")) {
            if (WeChatEnvironment.hasDebugger())
            {
              Log.i("MicroMsg.WalletGetA8KeyRedirectListener", "go pay test logic");
              qf localqf = new qf();
              localqf.fOS.url = str;
              localqf.fOS.scene = 4;
              localqf.fOS.channel = 12;
              localqf.fOS.sourceType = 0;
              localqf.fOS.source = "";
              localqf.fOS.context = paramAnonymousju.fHe.context;
              o.a(o.this, localqf);
              Toast.makeText(paramAnonymousju.fHe.context, "click to do pay test", 1).show();
            }
          }
          for (;;)
          {
            AppMethodBeat.o(71830);
            return true;
            o.b(o.this, 4);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(233, o.this);
            paramAnonymousju = new l(str, o.a(o.this).fHe.username, 4, 0, l.boo(), new byte[0]);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymousju, 0);
            o.a(o.this, System.currentTimeMillis());
            continue;
            o.b(o.this, 1);
            o.a(o.this, str, o.b(o.this));
          }
        }
        AppMethodBeat.o(71830);
        return true;
      }
    };
    this.PjH = new IListener() {};
    this.__eventId = abh.class.getName().hashCode();
    AppMethodBeat.o(71839);
  }
  
  private void gK(String paramString, int paramInt)
  {
    AppMethodBeat.i(71841);
    Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay reqKey = ".concat(String.valueOf(paramString)));
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.fOY = this.PjC;
    String[] arrayOfString = paramString.replace(PjB, "").split("&");
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
          localPayInfo.fwv = str2.replace("reqkey=", "");
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
          localPayInfo.Pjv = str2.replace("appsource=", "");
          str1 = paramString;
          localObject2 = localObject1;
        }
        else
        {
          str1 = paramString;
          localObject2 = localObject1;
          if (str2.startsWith("productid="))
          {
            localPayInfo.productId = str2.replace("productid=", "");
            str1 = paramString;
            localObject2 = localObject1;
          }
        }
      }
    }
    localPayInfo.channel = paramInt;
    if ("0".equals(localObject1))
    {
      b.iie();
      if (b.b(b.a.vCG, true))
      {
        ((a)com.tencent.mm.kernel.h.ae(a.class)).startWxpayQueryCashierPay(localPayInfo.fwv, localPayInfo.fOY);
        if (this.PjD.callback != null)
        {
          this.PjD.fHf.ret = 1;
          this.PjD.callback.run();
        }
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(localObject1)) && (Pattern.compile("[0-9]*").matcher(localObject1).matches())) {
        u(0, Integer.valueOf(localObject1).intValue(), 0L);
      }
      AppMethodBeat.o(71841);
      return;
      f.a(this.PjD.fHe.context, localPayInfo, 0);
      break;
      str1 = paramString;
      if (Util.isNullOrNil(paramString)) {
        str1 = this.PjD.fHe.context.getString(a.i.wallet_unknown_err);
      }
      com.tencent.mm.ui.base.h.d(this.PjD.fHe.context, str1, "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(71836);
          if (o.a(o.this).callback != null)
          {
            o.a(o.this).fHf.ret = 1;
            o.a(o.this).callback.run();
          }
          AppMethodBeat.o(71836);
        }
      });
    }
  }
  
  private void u(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(71842);
    int i = 132;
    if (this.PjC == 1) {
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
    else if ((this.PjC == 4) && (paramLong > 0L))
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
      com.tencent.mm.plugin.report.service.h.IzE.b(localArrayList, true);
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(71840);
    if ((paramq instanceof l))
    {
      long l = System.currentTimeMillis() - this.mRequestTime;
      com.tencent.mm.plugin.report.service.h.IzE.a(11170, new Object[] { Integer.valueOf(233), Integer.valueOf(0), Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(NetStatusUtil.getNetType(MMApplicationContext.getContext())), "" });
      u(paramInt1, paramInt2, l);
      Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(233, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramq = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramq = this.PjD.fHe.context.getString(a.i.wallet_unknown_err);
        }
        com.tencent.mm.ui.base.h.d(this.PjD.fHe.context, paramq, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71834);
            if (o.a(o.this).callback != null)
            {
              o.a(o.this).fHf.ret = 1;
              o.a(o.this).callback.run();
            }
            AppMethodBeat.o(71834);
          }
        });
        AppMethodBeat.o(71840);
        return;
      }
      gK(((l)paramq).bof(), this.mPayChannel);
      AppMethodBeat.o(71840);
      return;
    }
    if ((paramq instanceof com.tencent.mm.wallet_core.tenpay.model.o))
    {
      Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "native auth, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(385, this);
      if ((paramInt1 != 0) || (paramInt2 != 0) || (!"0".equals(((com.tencent.mm.wallet_core.tenpay.model.o)paramq).YWv)))
      {
        if (this.PjE.callback != null) {
          this.PjE.fOT.ret = 1;
        }
        if (!Util.isNullOrNil(paramString)) {}
        for (;;)
        {
          af.B(this.PjC, "", paramInt2);
          com.tencent.mm.ui.base.h.d(this.PjE.fOS.context, paramString, "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(71835);
              if (o.c(o.this).callback != null)
              {
                o.c(o.this).fOT.ret = 1;
                o.c(o.this).callback.run();
              }
              AppMethodBeat.o(71835);
            }
          });
          AppMethodBeat.o(71840);
          return;
          if (!Util.isNullOrNil(((com.tencent.mm.wallet_core.tenpay.model.o)paramq).tVH)) {
            paramString = ((com.tencent.mm.wallet_core.tenpay.model.o)paramq).tVH;
          } else {
            paramString = this.PjE.fOS.context.getString(a.i.wallet_unknown_err);
          }
        }
      }
      if (this.PjE.callback != null)
      {
        this.PjE.fOT.ret = 2;
        this.PjE.callback.run();
      }
      af.B(this.PjC, ((com.tencent.mm.wallet_core.tenpay.model.o)paramq).fwv, paramInt2);
      paramString = ((com.tencent.mm.wallet_core.tenpay.model.o)paramq).Pjw;
      if ((paramString != null) && (!Util.isNullOrNil(paramString.UHJ)))
      {
        paramq = (com.tencent.mm.wallet_core.tenpay.model.o)paramq;
        paramString = new Intent();
        paramString.putExtra("prepayId", paramq.fwv);
        paramString.putExtra("is_jsapi_offline_pay", false);
        paramq = paramq.Pjw;
        paramString.putExtra("pay_gate_url", paramq.UHJ);
        paramString.putExtra("need_dialog", paramq.UHL);
        paramString.putExtra("dialog_text", paramq.UHM);
        paramString.putExtra("max_count", paramq.UHK.Sdg);
        paramString.putExtra("inteval_time", paramq.UHK.Sdf);
        paramString.putExtra("default_wording", paramq.UHK.Sdh);
        com.tencent.mm.by.c.c((Activity)this.PjE.fOS.context, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
        if (this.PjE.callback != null)
        {
          this.PjE.fOT.ret = 2;
          this.PjE.callback.run();
        }
        Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "mAuthNativeEvent.data.context: %s", new Object[] { this.PjE.fOS.context });
        AppMethodBeat.o(71840);
        return;
      }
      paramString = (com.tencent.mm.wallet_core.tenpay.model.o)paramq;
      paramq = new PayInfo();
      paramq.fOY = this.PjC;
      paramq.fwv = paramString.fwv;
      paramq.appId = paramString.appId;
      paramq.Pjv = paramString.Pjv;
      paramq.productId = paramString.productId;
      paramq.channel = paramString.channel;
      Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay native, payInfo: %s", new Object[] { paramq.toString() });
      f.a(this.PjE.fOS.context, paramq, 0);
      if (this.PjE.callback != null)
      {
        this.PjE.fOT.ret = 2;
        this.PjE.callback.run();
      }
      AppMethodBeat.o(71840);
      return;
    }
    Log.i("MicroMsg.WalletGetA8KeyRedirectListener", "other scene");
    AppMethodBeat.o(71840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.o
 * JD-Core Version:    0.7.0.1
 */