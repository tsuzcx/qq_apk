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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.je.a;
import com.tencent.mm.g.a.ph;
import com.tencent.mm.g.a.ph.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.exi;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.wallet_core.c.af;
import java.util.ArrayList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class o
  extends IListener<aaa>
  implements i
{
  private static final String IqR;
  private static final String IqS;
  private int IqT;
  private je IqU;
  private ph IqV;
  private Queue<ph> IqW;
  public IListener IqX;
  public IListener<ph> IqY;
  private int mPayChannel;
  private long mRequestTime;
  
  static
  {
    AppMethodBeat.i(214271);
    IqR = "http://" + WeChatHosts.domainString(2131761730) + "?";
    IqS = "http://" + WeChatHosts.domainString(2131761729) + "?";
    AppMethodBeat.o(214271);
  }
  
  public o()
  {
    AppMethodBeat.i(71839);
    this.mPayChannel = 0;
    this.IqX = new IListener()
    {
      private boolean a(je paramAnonymousje)
      {
        AppMethodBeat.i(71830);
        o.a(o.this, paramAnonymousje);
        String str = o.a(o.this).dNT.result;
        if (o.a(o.this).dNT.dNV != null) {
          o.a(o.this, o.a(o.this).dNT.dNV.getInt("pay_channel", 0));
        }
        switch (o.a(o.this).dNT.actionCode)
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
              ph localph = new ph();
              localph.dVp.url = str;
              localph.dVp.scene = 4;
              localph.dVp.channel = 12;
              localph.dVp.sourceType = 0;
              localph.dVp.source = "";
              localph.dVp.context = paramAnonymousje.dNT.context;
              o.a(o.this, localph);
              Toast.makeText(paramAnonymousje.dNT.context, "click to do pay test", 1).show();
            }
          }
          for (;;)
          {
            AppMethodBeat.o(71830);
            return true;
            o.b(o.this, 4);
            g.aAi();
            g.aAg().hqi.a(233, o.this);
            paramAnonymousje = new l(str, o.a(o.this).dNT.username, 4, 0, (int)System.currentTimeMillis(), new byte[0]);
            g.aAi();
            g.aAg().hqi.a(paramAnonymousje, 0);
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
    this.IqY = new IListener() {};
    this.__eventId = aaa.class.getName().hashCode();
    AppMethodBeat.o(71839);
  }
  
  private void gb(String paramString, int paramInt)
  {
    AppMethodBeat.i(71841);
    Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay reqKey = ".concat(String.valueOf(paramString)));
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dVv = this.IqT;
    String[] arrayOfString = paramString.replace(IqS, "").split("&");
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
          localPayInfo.dDL = str2.replace("reqkey=", "");
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
          localPayInfo.IqM = str2.replace("appsource=", "");
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
      com.tencent.mm.wallet_core.b.hgC();
      if (com.tencent.mm.wallet_core.b.b(b.a.rWd, true))
      {
        ((a)g.af(a.class)).startWxpayQueryCashierPay(localPayInfo.dDL, localPayInfo.dVv);
        if (this.IqU.callback != null)
        {
          this.IqU.dNU.ret = 1;
          this.IqU.callback.run();
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
      f.a(this.IqU.dNT.context, localPayInfo, 0);
      break;
      str1 = paramString;
      if (Util.isNullOrNil(paramString)) {
        str1 = this.IqU.dNT.context.getString(2131768354);
      }
      com.tencent.mm.ui.base.h.d(this.IqU.dNT.context, str1, "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(71836);
          if (o.a(o.this).callback != null)
          {
            o.a(o.this).dNU.ret = 1;
            o.a(o.this).callback.run();
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
    if (this.IqT == 1) {
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
    else if ((this.IqT == 4) && (paramLong > 0L))
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
      com.tencent.mm.plugin.report.service.h.CyF.b(localArrayList, true);
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
      com.tencent.mm.plugin.report.service.h.CyF.a(11170, new Object[] { Integer.valueOf(233), Integer.valueOf(0), Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(NetStatusUtil.getNetType(MMApplicationContext.getContext())), "" });
      o(paramInt1, paramInt2, l);
      Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
      g.aAi();
      g.aAg().hqi.b(233, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramq = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramq = this.IqU.dNT.context.getString(2131768354);
        }
        com.tencent.mm.ui.base.h.d(this.IqU.dNT.context, paramq, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71834);
            if (o.a(o.this).callback != null)
            {
              o.a(o.this).dNU.ret = 1;
              o.a(o.this).callback.run();
            }
            AppMethodBeat.o(71834);
          }
        });
        AppMethodBeat.o(71840);
        return;
      }
      gb(((l)paramq).beQ(), this.mPayChannel);
      AppMethodBeat.o(71840);
      return;
    }
    if ((paramq instanceof com.tencent.mm.wallet_core.tenpay.model.o))
    {
      Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "native auth, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      g.aAi();
      g.aAg().hqi.b(385, this);
      if ((paramInt1 != 0) || (paramInt2 != 0) || (!"0".equals(((com.tencent.mm.wallet_core.tenpay.model.o)paramq).RuX)))
      {
        if (this.IqV.callback != null) {
          this.IqV.dVq.ret = 1;
        }
        if (!Util.isNullOrNil(paramString)) {}
        for (;;)
        {
          af.z(this.IqT, "", paramInt2);
          com.tencent.mm.ui.base.h.d(this.IqV.dVp.context, paramString, "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(71835);
              if (o.c(o.this).callback != null)
              {
                o.c(o.this).dVq.ret = 1;
                o.c(o.this).callback.run();
              }
              AppMethodBeat.o(71835);
            }
          });
          AppMethodBeat.o(71840);
          return;
          if (!Util.isNullOrNil(((com.tencent.mm.wallet_core.tenpay.model.o)paramq).qwG)) {
            paramString = ((com.tencent.mm.wallet_core.tenpay.model.o)paramq).qwG;
          } else {
            paramString = this.IqV.dVp.context.getString(2131768354);
          }
        }
      }
      if (this.IqV.callback != null)
      {
        this.IqV.dVq.ret = 2;
        this.IqV.callback.run();
      }
      af.z(this.IqT, ((com.tencent.mm.wallet_core.tenpay.model.o)paramq).dDL, paramInt2);
      paramString = ((com.tencent.mm.wallet_core.tenpay.model.o)paramq).IqN;
      if ((paramString != null) && (!Util.isNullOrNil(paramString.NuI)))
      {
        paramq = (com.tencent.mm.wallet_core.tenpay.model.o)paramq;
        paramString = new Intent();
        paramString.putExtra("prepayId", paramq.dDL);
        paramString.putExtra("is_jsapi_offline_pay", false);
        paramq = paramq.IqN;
        paramString.putExtra("pay_gate_url", paramq.NuI);
        paramString.putExtra("need_dialog", paramq.NuK);
        paramString.putExtra("dialog_text", paramq.NuL);
        paramString.putExtra("max_count", paramq.NuJ.LbT);
        paramString.putExtra("inteval_time", paramq.NuJ.LbS);
        paramString.putExtra("default_wording", paramq.NuJ.LbU);
        c.c((Activity)this.IqV.dVp.context, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
        if (this.IqV.callback != null)
        {
          this.IqV.dVq.ret = 2;
          this.IqV.callback.run();
        }
        Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "mAuthNativeEvent.data.context: %s", new Object[] { this.IqV.dVp.context });
        AppMethodBeat.o(71840);
        return;
      }
      paramString = (com.tencent.mm.wallet_core.tenpay.model.o)paramq;
      paramq = new PayInfo();
      paramq.dVv = this.IqT;
      paramq.dDL = paramString.dDL;
      paramq.appId = paramString.appId;
      paramq.IqM = paramString.IqM;
      paramq.productId = paramString.productId;
      paramq.channel = paramString.channel;
      Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay native, payInfo: %s", new Object[] { paramq.toString() });
      f.a(this.IqV.dVp.context, paramq, 0);
      if (this.IqV.callback != null)
      {
        this.IqV.dVq.ret = 2;
        this.IqV.callback.run();
      }
      AppMethodBeat.o(71840);
      return;
    }
    Log.i("MicroMsg.WalletGetA8KeyRedirectListener", "other scene");
    AppMethodBeat.o(71840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.o
 * JD-Core Version:    0.7.0.1
 */