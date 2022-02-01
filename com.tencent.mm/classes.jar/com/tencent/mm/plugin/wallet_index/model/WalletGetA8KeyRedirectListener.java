package com.tencent.mm.plugin.wallet_index.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.lifecycle.q;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ade;
import com.tencent.mm.autogen.a.kw;
import com.tencent.mm.autogen.a.kw.a;
import com.tencent.mm.autogen.a.rs;
import com.tencent.mm.autogen.a.rs.a;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.protocal.protobuf.geh;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.model.ag;
import com.tencent.mm.wallet_core.tenpay.model.o;
import java.util.ArrayList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WalletGetA8KeyRedirectListener
  extends IListener<ade>
  implements com.tencent.mm.am.h
{
  private static final String Was;
  private static final String Wat;
  private int Wau;
  private kw Wav;
  private rs Waw;
  private Queue<rs> Wax;
  public IListener Way;
  public IListener<rs> Waz;
  private int mPayChannel;
  private long mRequestTime;
  
  static
  {
    AppMethodBeat.i(263783);
    Was = "http://" + WeChatHosts.domainString(a.i.host_p_weixin_qq_com) + "?";
    Wat = "http://" + WeChatHosts.domainString(a.i.host_p_qq_com) + "?";
    AppMethodBeat.o(263783);
  }
  
  public WalletGetA8KeyRedirectListener()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(71839);
    this.mPayChannel = 0;
    this.Way = new IListener(com.tencent.mm.app.f.hfK)
    {
      private boolean a(kw paramAnonymouskw)
      {
        AppMethodBeat.i(71830);
        WalletGetA8KeyRedirectListener.a(WalletGetA8KeyRedirectListener.this, paramAnonymouskw);
        String str = WalletGetA8KeyRedirectListener.a(WalletGetA8KeyRedirectListener.this).hMB.result;
        if (WalletGetA8KeyRedirectListener.a(WalletGetA8KeyRedirectListener.this).hMB.hMD != null) {
          WalletGetA8KeyRedirectListener.a(WalletGetA8KeyRedirectListener.this, WalletGetA8KeyRedirectListener.a(WalletGetA8KeyRedirectListener.this).hMB.hMD.getInt("pay_channel", 0));
        }
        switch (WalletGetA8KeyRedirectListener.a(WalletGetA8KeyRedirectListener.this).hMB.actionCode)
        {
        default: 
          AppMethodBeat.o(71830);
          return false;
        case 12: 
          WalletGetA8KeyRedirectListener.a(WalletGetA8KeyRedirectListener.this, str);
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
              rs localrs = new rs();
              localrs.hUL.url = str;
              localrs.hUL.scene = 4;
              localrs.hUL.channel = 12;
              localrs.hUL.sourceType = 0;
              localrs.hUL.source = "";
              localrs.hUL.context = paramAnonymouskw.hMB.context;
              WalletGetA8KeyRedirectListener.a(WalletGetA8KeyRedirectListener.this, localrs);
              Toast.makeText(paramAnonymouskw.hMB.context, "click to do pay test", 1).show();
            }
          }
          for (;;)
          {
            AppMethodBeat.o(71830);
            return true;
            WalletGetA8KeyRedirectListener.b(WalletGetA8KeyRedirectListener.this, 4);
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(233, WalletGetA8KeyRedirectListener.this);
            paramAnonymouskw = new n(str, WalletGetA8KeyRedirectListener.a(WalletGetA8KeyRedirectListener.this).hMB.username, 4, 0, n.bMd(), new byte[0]);
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(paramAnonymouskw, 0);
            WalletGetA8KeyRedirectListener.a(WalletGetA8KeyRedirectListener.this, System.currentTimeMillis());
            continue;
            WalletGetA8KeyRedirectListener.b(WalletGetA8KeyRedirectListener.this, 1);
            WalletGetA8KeyRedirectListener.a(WalletGetA8KeyRedirectListener.this, str, WalletGetA8KeyRedirectListener.b(WalletGetA8KeyRedirectListener.this));
          }
        }
        AppMethodBeat.o(71830);
        return true;
      }
    };
    this.Waz = new IListener(com.tencent.mm.app.f.hfK) {};
    this.__eventId = ade.class.getName().hashCode();
    AppMethodBeat.o(71839);
  }
  
  private void hH(String paramString, int paramInt)
  {
    AppMethodBeat.i(71841);
    Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay reqKey = ".concat(String.valueOf(paramString)));
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.hUR = this.Wau;
    String[] arrayOfString = paramString.replace(Wat, "").split("&");
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
          localPayInfo.hAT = str2.replace("reqkey=", "");
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
          localPayInfo.Wan = str2.replace("appsource=", "");
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
      b.jNX();
      if (b.b(c.a.yRc, true))
      {
        ((a)com.tencent.mm.kernel.h.ax(a.class)).startWxpayQueryCashierPay(localPayInfo.hAT, localPayInfo.hUR);
        if (this.Wav.callback != null)
        {
          this.Wav.hMC.ret = 1;
          this.Wav.callback.run();
        }
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(localObject1)) && (Pattern.compile("[0-9]*").matcher(localObject1).matches())) {
        x(0, Integer.valueOf(localObject1).intValue(), 0L);
      }
      AppMethodBeat.o(71841);
      return;
      com.tencent.mm.pluginsdk.wallet.f.a(this.Wav.hMB.context, localPayInfo, 0);
      break;
      str1 = paramString;
      if (Util.isNullOrNil(paramString)) {
        str1 = this.Wav.hMB.context.getString(a.i.wallet_unknown_err);
      }
      k.d(this.Wav.hMB.context, str1, "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(71836);
          if (WalletGetA8KeyRedirectListener.a(WalletGetA8KeyRedirectListener.this).callback != null)
          {
            WalletGetA8KeyRedirectListener.a(WalletGetA8KeyRedirectListener.this).hMC.ret = 1;
            WalletGetA8KeyRedirectListener.a(WalletGetA8KeyRedirectListener.this).callback.run();
          }
          AppMethodBeat.o(71836);
        }
      });
    }
  }
  
  private void x(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(71842);
    int i = 132;
    if (this.Wau == 1) {
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
    else if ((this.Wau == 4) && (paramLong > 0L))
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
      com.tencent.mm.plugin.report.service.h.OAn.b(localArrayList, true);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(71840);
    if ((paramp instanceof n))
    {
      long l = System.currentTimeMillis() - this.mRequestTime;
      com.tencent.mm.plugin.report.service.h.OAn.b(11170, new Object[] { Integer.valueOf(233), Integer.valueOf(0), Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(NetStatusUtil.getNetType(MMApplicationContext.getContext())), "" });
      x(paramInt1, paramInt2, l);
      Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(233, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramp = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramp = this.Wav.hMB.context.getString(a.i.wallet_unknown_err);
        }
        k.d(this.Wav.hMB.context, paramp, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71834);
            if (WalletGetA8KeyRedirectListener.a(WalletGetA8KeyRedirectListener.this).callback != null)
            {
              WalletGetA8KeyRedirectListener.a(WalletGetA8KeyRedirectListener.this).hMC.ret = 1;
              WalletGetA8KeyRedirectListener.a(WalletGetA8KeyRedirectListener.this).callback.run();
            }
            AppMethodBeat.o(71834);
          }
        });
        AppMethodBeat.o(71840);
        return;
      }
      hH(((n)paramp).bLT(), this.mPayChannel);
      AppMethodBeat.o(71840);
      return;
    }
    if ((paramp instanceof o))
    {
      Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "native auth, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(385, this);
      if ((paramInt1 != 0) || (paramInt2 != 0) || (!"0".equals(((o)paramp).agUp)))
      {
        if (this.Waw.callback != null) {
          this.Waw.hUM.ret = 1;
        }
        if (!Util.isNullOrNil(paramString)) {}
        for (;;)
        {
          ag.G(this.Wau, "", paramInt2);
          k.d(this.Waw.hUL.context, paramString, "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(71835);
              if (WalletGetA8KeyRedirectListener.c(WalletGetA8KeyRedirectListener.this).callback != null)
              {
                WalletGetA8KeyRedirectListener.c(WalletGetA8KeyRedirectListener.this).hUM.ret = 1;
                WalletGetA8KeyRedirectListener.c(WalletGetA8KeyRedirectListener.this).callback.run();
              }
              AppMethodBeat.o(71835);
            }
          });
          AppMethodBeat.o(71840);
          return;
          if (!Util.isNullOrNil(((o)paramp).wZb)) {
            paramString = ((o)paramp).wZb;
          } else {
            paramString = this.Waw.hUL.context.getString(a.i.wallet_unknown_err);
          }
        }
      }
      if (this.Waw.callback != null)
      {
        this.Waw.hUM.ret = 2;
        this.Waw.callback.run();
      }
      ag.G(this.Wau, ((o)paramp).hAT, paramInt2);
      paramString = ((o)paramp).Wao;
      if ((paramString != null) && (!Util.isNullOrNil(paramString.acbS)))
      {
        paramp = (o)paramp;
        paramString = new Intent();
        paramString.putExtra("prepayId", paramp.hAT);
        paramString.putExtra("is_jsapi_offline_pay", false);
        paramp = paramp.Wao;
        paramString.putExtra("pay_gate_url", paramp.acbS);
        paramString.putExtra("need_dialog", paramp.acbU);
        paramString.putExtra("dialog_text", paramp.acbV);
        paramString.putExtra("max_count", paramp.acbT.ZaY);
        paramString.putExtra("inteval_time", paramp.acbT.ZaX);
        paramString.putExtra("default_wording", paramp.acbT.ZaZ);
        com.tencent.mm.br.c.c((Activity)this.Waw.hUL.context, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
        if (this.Waw.callback != null)
        {
          this.Waw.hUM.ret = 2;
          this.Waw.callback.run();
        }
        Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "mAuthNativeEvent.data.context: %s", new Object[] { this.Waw.hUL.context });
        AppMethodBeat.o(71840);
        return;
      }
      paramString = (o)paramp;
      paramp = new PayInfo();
      paramp.hUR = this.Wau;
      paramp.hAT = paramString.hAT;
      paramp.appId = paramString.appId;
      paramp.Wan = paramString.Wan;
      paramp.productId = paramString.productId;
      paramp.channel = paramString.channel;
      Log.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay native, payInfo: %s", new Object[] { paramp.toString() });
      com.tencent.mm.pluginsdk.wallet.f.a(this.Waw.hUL.context, paramp, 0);
      if (this.Waw.callback != null)
      {
        this.Waw.hUM.ret = 2;
        this.Waw.callback.run();
      }
      AppMethodBeat.o(71840);
      return;
    }
    Log.i("MicroMsg.WalletGetA8KeyRedirectListener", "other scene");
    AppMethodBeat.o(71840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.model.WalletGetA8KeyRedirectListener
 * JD-Core Version:    0.7.0.1
 */