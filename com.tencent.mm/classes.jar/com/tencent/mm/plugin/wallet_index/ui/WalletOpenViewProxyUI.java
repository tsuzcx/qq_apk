package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.cm.f;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.g.a.uy;
import com.tencent.mm.plugin.wallet.balance.a.a.ad;
import com.tencent.mm.plugin.wallet.balance.a.a.l;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(7)
public class WalletOpenViewProxyUI
  extends WalletBaseUI
{
  private Map<String, String> uBw;
  
  public WalletOpenViewProxyUI()
  {
    AppMethodBeat.i(48301);
    this.uBw = new HashMap();
    AppMethodBeat.o(48301);
  }
  
  private void afT(String paramString)
  {
    AppMethodBeat.i(48305);
    int i;
    if (!bo.isNullOrNil(paramString))
    {
      paramString = (String)this.uBw.get("openview");
      if ("open_wcpay_biz_view".equals(paramString))
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_index_ui");
        com.tencent.mm.pluginsdk.wallet.h.gc(getContext());
        i = 1;
      }
    }
    for (;;)
    {
      paramString = new Intent();
      paramString.putExtra("closeWebView", (String)this.uBw.get("closeWebView"));
      setResult(-1, paramString);
      if (i != 0) {
        finish();
      }
      AppMethodBeat.o(48305);
      return;
      if ("open_wcpay_balance_view".equals(paramString))
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open wallet_balance_manager_ui");
        com.tencent.mm.pluginsdk.wallet.h.an(getContext(), 0);
        i = 1;
      }
      else if ("open_wcpay_order_detail_view".equals(paramString))
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_order_transaction_info_ui");
        paramString = new Intent();
        paramString.putExtra("trans_id", (String)this.uBw.get("trans_id"));
        paramString.putExtra("scene", 1);
        if (this.uBw.containsKey("bill_id")) {
          paramString.putExtra("bill_id", (String)this.uBw.get("bill_id"));
        }
        com.tencent.mm.bq.d.b(getContext(), "order", ".ui.MallOrderTransactionInfoUI", paramString);
        i = 1;
      }
      else if ("open_wcpay_f2f_receive_detail".equals(paramString))
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_f2f_receive_detail");
        paramString = new Intent();
        paramString.putExtra("key_timestamp", bo.getLong((String)this.uBw.get("fromtimestamp"), 0L));
        paramString.putExtra("key_from_scene", 1);
        com.tencent.mm.bq.d.b(getContext(), "collect", ".ui.CollectBillUI", paramString);
        com.tencent.mm.plugin.report.service.h.qsU.e(13944, new Object[] { Integer.valueOf(2) });
        i = 1;
      }
      else if ("open_wcpay_grouppay_detail".equals(paramString))
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_grouppay_detail");
        paramString = new Intent();
        paramString.putExtra("bill_no", (String)this.uBw.get("billno"));
        paramString.putExtra("chatroom", (String)this.uBw.get("groupid"));
        paramString.putExtra("key_sign", (String)this.uBw.get("sign"));
        paramString.putExtra("key_ver", (String)this.uBw.get("ver"));
        paramString.putExtra("enter_scene", 5);
        com.tencent.mm.bq.d.b(getContext(), "aa", ".ui.PaylistAAUI", paramString);
        i = 1;
      }
      else if ("open_wcpay_t2bc_detail".equals(paramString))
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "do open_wcpay_t2bc_detail");
        paramString = new Intent();
        paramString.putExtra("key_transfer_bill_id", (String)this.uBw.get("transfer_bill_id"));
        paramString.putExtra("key_enter_scene", 1);
        com.tencent.mm.bq.d.b(getContext(), "remittance", ".bankcard.ui.BankRemitDetailUI", paramString);
        i = 1;
      }
      else if ("open_honey_pay_home".equals(paramString))
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "do open honey pay view");
        paramString = new Intent();
        com.tencent.mm.bq.d.b(getContext(), "honey_pay", ".ui.HoneyPayMainUI", paramString);
        i = 1;
      }
      else if ("open_wcpay_t2bc_view".equals(paramString))
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "do open VIEW_OPEN_T2BC_UI");
        paramString = new Intent();
        com.tencent.mm.bq.d.b(getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI", paramString);
        i = 1;
      }
      else if ("open_wcpay_fetch_balance_view".equals(paramString))
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "do open VIEW_OPEN_FETCH_BALANCE_UI");
        paramString = new uy();
        paramString.cLw.context = getContext();
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
        i = 1;
      }
      else if ("open_wcpay_wallet_lock_view".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("wallet_lock_jsapi_scene", (String)this.uBw.get("entry_scene"));
        ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.walletlock.a.b.class)).b(this, paramString);
        i = 1;
      }
      else if ("open_wcpay_security_setting_view".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("wallet_lock_jsapi_scene", (String)this.uBw.get("entry_scene"));
        com.tencent.mm.bq.d.b(this, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramString);
        i = 1;
      }
      else
      {
        Object localObject1;
        Object localObject2;
        if ("open_wcpay_c2c_message_view".equals(paramString))
        {
          if (this.uBw != null)
          {
            i = bo.getInt((String)this.uBw.get("bizType"), -1);
            if (i == 1)
            {
              paramString = (String)this.uBw.get("bizId");
              localObject1 = (String)this.uBw.get("username");
              long l = bo.getLong((String)this.uBw.get("createTime"), -1L);
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "view open c2c message view, bizType: %s, bizId: %s, username: %s, createTime: %s", new Object[] { Integer.valueOf(i), paramString, localObject1, Long.valueOf(l) });
              localObject2 = new iy();
              ((iy)localObject2).cyq.cyr = paramString;
              ((iy)localObject2).cyq.username = ((String)localObject1);
              ((iy)localObject2).cyq.cys = Long.valueOf(l);
              com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
            }
            i = 1;
          }
        }
        else
        {
          if ("open_lqt_auto_planindex_view".equals(paramString))
          {
            paramString = new Intent();
            com.tencent.mm.bq.d.b(getContext(), "wallet", ".balance.ui.lqt.WalletLqtPlanHomeUI", paramString);
            i = 1;
            continue;
          }
          if ("open_lqt_auto_planadd_view".equals(paramString))
          {
            paramString = new Intent(this, WalletLqtPlanAddUI.class);
            paramString.putExtra("key_mode", 1);
            startActivity(paramString);
            i = 1;
            continue;
          }
          if ("open_wcpay_lqt_save".equals(paramString))
          {
            com.tencent.mm.plugin.wallet.balance.a.a.ab.aeP((String)this.uBw.get("trace_info"));
            paramString = (String)this.uBw.get("operate_id");
            localObject1 = com.tencent.mm.wallet_core.ui.g.c(getContext(), false, null);
            new l().adl().b(new WalletOpenViewProxyUI.1(this, (Dialog)localObject1, paramString));
            i = 0;
            continue;
          }
          if ("open_wcpay_grouppay_introview".equals(paramString))
          {
            localObject2 = (String)this.uBw.get("amount");
            localObject1 = (String)this.uBw.get("title");
            Intent localIntent = new Intent();
            localIntent.putExtra("amount", (String)localObject2);
            paramString = (String)localObject1;
            if (!bo.isNullOrNil((String)localObject1))
            {
              paramString = URLDecoder.decode((String)localObject1);
              localIntent.putExtra("title", paramString);
            }
            localIntent.putExtra("enter_scene", 5);
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "view open grouppay, amount: %s, title: %s", new Object[] { localObject2, paramString });
            com.tencent.mm.bq.d.b(this, "aa", ".ui.AAEntranceUI", localIntent);
            i = 1;
            continue;
          }
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] invalid target view : ".concat(String.valueOf(paramString)));
        }
        i = 1;
        continue;
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] packageExt null or nil");
        i = 1;
      }
    }
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48306);
    if (paramInt1 == 563)
    {
      if (paramInt2 == -1)
      {
        String str3 = paramIntent.getStringExtra("Select_Conv_User");
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "select chatroom：%s", new Object[] { str3 });
        String str4 = (String)this.uBw.get("amount");
        String str2 = (String)this.uBw.get("title");
        Intent localIntent = new Intent();
        localIntent.putExtra("amount", str4);
        String str1 = str2;
        if (!bo.isNullOrNil(str2))
        {
          str1 = URLDecoder.decode(str2);
          localIntent.putExtra("title", str1);
        }
        if (!bo.isNullOrNil(str3)) {
          localIntent.putExtra("chatroom_name", str3);
        }
        localIntent.putExtra("enter_scene", 5);
        com.tencent.mm.bq.d.b(getContext(), "aa", ".ui.LaunchAAUI", localIntent);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "view open grouppay, amount: %s, title: %s", new Object[] { str4, str1 });
      }
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(48306);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48302);
    super.onCreate(paramBundle);
    setContentViewVisibility(8);
    paramBundle = getIntent().getStringExtra("packageExt");
    this.uBw = new HashMap();
    if (!bo.isNullOrNil(paramBundle))
    {
      paramBundle = paramBundle.split("&");
      if ((paramBundle != null) && (paramBundle.length > 0))
      {
        int i = 0;
        while (i < paramBundle.length)
        {
          if (!bo.isNullOrNil(paramBundle[i]))
          {
            localObject = paramBundle[i].split("=");
            if ((localObject.length == 2) && (!bo.isNullOrNil(localObject[0]))) {
              this.uBw.put(localObject[0], localObject[1]);
            }
          }
          i += 1;
        }
      }
    }
    paramBundle = (String)this.uBw.get("trace_info");
    if (!bo.isNullOrNil(paramBundle)) {
      com.tencent.mm.plugin.wallet.balance.a.a.ab.aeP(paramBundle);
    }
    addSceneEndListener(2996);
    addSceneEndListener(580);
    addSceneEndListener(385);
    if (getIntent() == null)
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "func[doCheckPayNetscene] intent null");
      setResult(0);
      finish();
      AppMethodBeat.o(48302);
      return;
    }
    paramBundle = (String)this.uBw.get("openview");
    Object localObject = getIntent().getStringExtra("appId");
    String str1 = getIntent().getStringExtra("timeStamp");
    String str2 = getIntent().getStringExtra("nonceStr");
    String str3 = getIntent().getStringExtra("packageExt");
    String str4 = getIntent().getStringExtra("paySignature");
    if ("open_wcpay_f2f_receive_detail".equals(paramBundle))
    {
      doSceneForceProgress(new x((String)localObject, str1, str2, str3, str4));
      AppMethodBeat.o(48302);
      return;
    }
    if ("open_wcpay_grouppay_detail".equals(paramBundle))
    {
      afT(str3);
      AppMethodBeat.o(48302);
      return;
    }
    if ("open_wcpay_lqt_detail".equals(paramBundle))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "open lqt detail ui");
      if (this.uBw != null)
      {
        new Intent().putExtra("key_account_type", 1);
        localObject = (String)this.uBw.get("ecardtype");
        str1 = (String)this.uBw.get("extradata");
        paramBundle = (String)this.uBw.get("need_open_lqb");
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "open lqt detail ui, ecardtype: %s, extradata: %s, need_open_lqb: %s", new Object[] { localObject, str1, paramBundle });
        if (bo.getInt(paramBundle, 0) == 1)
        {
          paramBundle = (Bundle)localObject;
          if (bo.isNullOrNil((String)localObject)) {
            paramBundle = "WEB_DEBIT";
          }
          doSceneForceProgress(new ad(paramBundle, str1));
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(663L, 18L, 1L, false);
        AppMethodBeat.o(48302);
        return;
        com.tencent.mm.bq.d.H(getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
        setResult(-1);
        finish();
        continue;
        com.tencent.mm.bq.d.H(getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
        setResult(-1);
        finish();
      }
    }
    if ("redenvelopes_getshowresouces_and_move_to_root".equals(paramBundle))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "receive envelope");
      ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.luckymoney.a.a.class)).bME();
      setResult(-1);
      finish();
      AppMethodBeat.o(48302);
      return;
    }
    doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.d((String)localObject, str1, str2, str3, getIntent().getStringExtra("signtype"), str4, getIntent().getStringExtra("url"), 4, "openWCPaySpecificView", getIntent().getIntExtra("pay_channel", 0)));
    AppMethodBeat.o(48302);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(48304);
    super.onDestroy();
    removeSceneEndListener(580);
    removeSceneEndListener(385);
    removeSceneEndListener(2996);
    AppMethodBeat.o(48304);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48303);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.d))
      {
        com.tencent.mm.pluginsdk.wallet.g.ana(((com.tencent.mm.plugin.wallet_core.c.d)paramm).cSW());
        afT(getIntent().getStringExtra("packageExt"));
        AppMethodBeat.o(48303);
        return true;
      }
      if ((paramm instanceof x))
      {
        afT(getIntent().getStringExtra("packageExt"));
        AppMethodBeat.o(48303);
        return true;
      }
      if ((paramm instanceof ad))
      {
        paramString = ((ad)paramm).tNB;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "on open lqb account scene end, retcode: %s, regmsg: %s", new Object[] { Integer.valueOf(paramString.koj), paramString.kok });
        if (paramString.koj == 0)
        {
          paramString = new Intent();
          paramString.putExtra("key_account_type", 2);
          com.tencent.mm.bq.d.b(getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramString);
          setResult(-1);
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(48303);
          return true;
          Toast.makeText(this, paramString.kok, 1).show();
          setResult(0);
        }
      }
    }
    else
    {
      setResult(0);
      finish();
      AppMethodBeat.o(48303);
      return true;
    }
    AppMethodBeat.o(48303);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletOpenViewProxyUI
 * JD-Core Version:    0.7.0.1
 */