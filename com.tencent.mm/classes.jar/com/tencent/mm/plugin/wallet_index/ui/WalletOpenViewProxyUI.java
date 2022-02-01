package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.a.acq;
import com.tencent.mm.autogen.a.mz;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ai;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ak;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI;
import com.tencent.mm.plugin.wallet_core.c.aa;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.dyn;
import com.tencent.mm.protocal.protobuf.ekd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.l;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(7)
public class WalletOpenViewProxyUI
  extends WalletBaseUI
{
  private com.tencent.mm.plugin.wallet.balance.ui.lqt.a VZV;
  private Map<String, String> WbY;
  
  public WalletOpenViewProxyUI()
  {
    AppMethodBeat.i(71942);
    this.WbY = new HashMap();
    AppMethodBeat.o(71942);
  }
  
  private void bht(final String paramString)
  {
    AppMethodBeat.i(71946);
    int i;
    if (!Util.isNullOrNil(paramString))
    {
      paramString = (String)this.WbY.get("openview");
      if ("open_wcpay_biz_view".equals(paramString))
      {
        Log.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_index_ui");
        com.tencent.mm.pluginsdk.wallet.f.lH(getContext());
        i = 1;
      }
    }
    for (;;)
    {
      paramString = new Intent();
      paramString.putExtra("closeWebView", (String)this.WbY.get("closeWebView"));
      setResult(-1, paramString);
      if (i != 0) {
        finish();
      }
      AppMethodBeat.o(71946);
      return;
      if ("open_wallet_delay_transfer_setting_ui".equals(paramString))
      {
        Log.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open wallet_delay_transfer_setting_ui");
        paramString = new Intent();
        paramString.putExtra("key_scene", 1);
        c.b(getContext(), "wallet", ".pwd.ui.WalletDelayTransferSettingUI", paramString);
        i = 1;
      }
      else if ("open_wcpay_balance_view".equals(paramString))
      {
        Log.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open wallet_balance_manager_ui");
        com.tencent.mm.pluginsdk.wallet.f.bq(getContext(), 0);
        i = 1;
      }
      else if ("open_wcpay_order_detail_view".equals(paramString))
      {
        Log.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_order_transaction_info_ui");
        paramString = new Intent();
        paramString.putExtra("trans_id", (String)this.WbY.get("trans_id"));
        paramString.putExtra("scene", 1);
        if (this.WbY.containsKey("bill_id")) {
          paramString.putExtra("bill_id", (String)this.WbY.get("bill_id"));
        }
        c.b(getContext(), "order", ".ui.MallOrderTransactionInfoUI", paramString);
        i = 1;
      }
      else if ("open_wcpay_f2f_receive_detail".equals(paramString))
      {
        Log.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_f2f_receive_detail");
        paramString = new Intent();
        paramString.putExtra("key_timestamp", Util.getLong((String)this.WbY.get("fromtimestamp"), 0L));
        paramString.putExtra("key_from_scene", 1);
        c.b(getContext(), "collect", ".ui.CollectBillUI", paramString);
        com.tencent.mm.plugin.report.service.h.OAn.b(13944, new Object[] { Integer.valueOf(2) });
        i = 1;
      }
      else if ("open_wcpay_grouppay_detail".equals(paramString))
      {
        Log.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_grouppay_detail");
        paramString = new Intent();
        paramString.putExtra("bill_no", (String)this.WbY.get("billno"));
        paramString.putExtra("chatroom", (String)this.WbY.get("groupid"));
        paramString.putExtra("key_sign", (String)this.WbY.get("sign"));
        paramString.putExtra("key_ver", (String)this.WbY.get("ver"));
        paramString.putExtra("enter_scene", 5);
        c.b(getContext(), "aa", ".ui.PaylistAAUI", paramString);
        i = 1;
      }
      else if ("open_wcpay_t2bc_detail".equals(paramString))
      {
        Log.d("MicroMsg.WalletOpenViewProxyUI", "do open_wcpay_t2bc_detail");
        paramString = new Intent();
        paramString.putExtra("key_transfer_bill_id", (String)this.WbY.get("transfer_bill_id"));
        paramString.putExtra("key_enter_scene", 1);
        c.b(getContext(), "remittance", ".bankcard.ui.BankRemitDetailUI", paramString);
        i = 1;
      }
      else if ("open_honey_pay_home".equals(paramString))
      {
        Log.d("MicroMsg.WalletOpenViewProxyUI", "do open honey pay view");
        paramString = new Intent();
        c.b(getContext(), "honey_pay", ".ui.HoneyPayMainUI", paramString);
        i = 1;
      }
      else if ("open_wcpay_t2bc_view".equals(paramString))
      {
        Log.d("MicroMsg.WalletOpenViewProxyUI", "do open VIEW_OPEN_T2BC_UI");
        paramString = new Intent();
        c.b(getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI", paramString);
        i = 1;
      }
      else if ("open_wcpay_fetch_balance_view".equals(paramString))
      {
        Log.d("MicroMsg.WalletOpenViewProxyUI", "do open VIEW_OPEN_FETCH_BALANCE_UI");
        paramString = new acq();
        paramString.iga.context = getContext();
        paramString.publish();
        i = 1;
      }
      else if ("open_wcpay_wallet_lock_view".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("wallet_lock_jsapi_scene", (String)this.WbY.get("entry_scene"));
        ((b)com.tencent.mm.kernel.h.ax(b.class)).t(this, paramString);
        i = 1;
      }
      else if ("open_wcpay_security_setting_view".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("wallet_lock_jsapi_scene", (String)this.WbY.get("entry_scene"));
        c.b(this, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramString);
        i = 1;
      }
      else
      {
        Object localObject1;
        Object localObject2;
        if ("open_wcpay_c2c_message_view".equals(paramString))
        {
          if (this.WbY != null)
          {
            i = Util.getInt((String)this.WbY.get("bizType"), -1);
            if (i == 1)
            {
              paramString = (String)this.WbY.get("bizId");
              localObject1 = (String)this.WbY.get("username");
              long l = Util.getLong((String)this.WbY.get("createTime"), -1L);
              Log.i("MicroMsg.WalletOpenViewProxyUI", "view open c2c message view, bizType: %s, bizId: %s, username: %s, createTime: %s", new Object[] { Integer.valueOf(i), paramString, localObject1, Long.valueOf(l) });
              localObject2 = new mz();
              ((mz)localObject2).hPi.hPj = paramString;
              ((mz)localObject2).hPi.username = ((String)localObject1);
              ((mz)localObject2).hPi.hPk = Long.valueOf(l);
              ((mz)localObject2).publish();
            }
            i = 1;
          }
        }
        else
        {
          if ("open_lqt_auto_planindex_view".equals(paramString))
          {
            paramString = new Intent();
            c.b(getContext(), "wallet", ".balance.ui.lqt.WalletLqtPlanBeforeHomeUI", paramString);
            i = 1;
            continue;
          }
          if ("open_wcpay_hk_f2f".equals(paramString))
          {
            paramString = new Intent();
            paramString.putExtra("key_from_scene", 1);
            c.b(getContext(), "collect", ".ui.CollectHKMainUI", paramString);
            i = 1;
            continue;
          }
          if ("open_lqt_auto_planadd_view".equals(paramString))
          {
            paramString = new Intent(this, WalletLqtPlanAddUI.class);
            paramString.putExtra("key_mode", 1);
            paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
            com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/wallet_index/ui/WalletOpenViewProxyUI", "handleOpenView", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramString.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/wallet_index/ui/WalletOpenViewProxyUI", "handleOpenView", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            i = 1;
            continue;
          }
          if ("open_wcpay_lqt_save".equals(paramString))
          {
            ai.bfU((String)this.WbY.get("trace_info"));
            paramString = (String)this.WbY.get("operate_id");
            localObject1 = l.c(getContext(), false, null);
            new com.tencent.mm.plugin.wallet.balance.model.lqt.p().bFJ().b(new com.tencent.mm.vending.c.a() {});
            i = 0;
            continue;
          }
          if ("open_wcpay_grouppay_introview".equals(paramString))
          {
            localObject2 = (String)this.WbY.get("amount");
            localObject1 = (String)this.WbY.get("title");
            Intent localIntent = new Intent();
            localIntent.putExtra("amount", (String)localObject2);
            paramString = (String)localObject1;
            if (!Util.isNullOrNil((String)localObject1))
            {
              paramString = URLDecoder.decode((String)localObject1);
              localIntent.putExtra("title", paramString);
            }
            localIntent.putExtra("enter_scene", 5);
            Log.i("MicroMsg.WalletOpenViewProxyUI", "view open grouppay, amount: %s, title: %s", new Object[] { localObject2, paramString });
            c.b(this, "aa", ".ui.AAEntranceUI", localIntent);
            i = 1;
            continue;
          }
          Log.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] invalid target view : ".concat(String.valueOf(paramString)));
        }
        i = 1;
        continue;
        Log.w("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] packageExt null or nil");
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
    AppMethodBeat.i(71947);
    if (paramInt1 == 563)
    {
      if (paramInt2 == -1)
      {
        String str3 = paramIntent.getStringExtra("Select_Conv_User");
        Log.i("MicroMsg.WalletOpenViewProxyUI", "select chatroom：%s", new Object[] { str3 });
        String str4 = (String)this.WbY.get("amount");
        String str2 = (String)this.WbY.get("title");
        Intent localIntent = new Intent();
        localIntent.putExtra("amount", str4);
        String str1 = str2;
        if (!Util.isNullOrNil(str2))
        {
          str1 = URLDecoder.decode(str2);
          localIntent.putExtra("title", str1);
        }
        if (!Util.isNullOrNil(str3)) {
          localIntent.putExtra("chatroom_name", str3);
        }
        localIntent.putExtra("enter_scene", 5);
        c.b(getContext(), "aa", ".ui.LaunchAAUI", localIntent);
        Log.i("MicroMsg.WalletOpenViewProxyUI", "view open grouppay, amount: %s, title: %s", new Object[] { str4, str1 });
      }
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(71947);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71943);
    super.onCreate(paramBundle);
    setContentViewVisibility(8);
    this.VZV = new com.tencent.mm.plugin.wallet.balance.ui.lqt.a(this);
    paramBundle = getIntent().getStringExtra("packageExt");
    this.WbY = new HashMap();
    int i;
    if (!Util.isNullOrNil(paramBundle))
    {
      paramBundle = paramBundle.split("&");
      if ((paramBundle != null) && (paramBundle.length > 0))
      {
        i = 0;
        while (i < paramBundle.length)
        {
          if (!Util.isNullOrNil(paramBundle[i]))
          {
            localObject = paramBundle[i].split("=");
            if ((localObject.length == 2) && (!Util.isNullOrNil(localObject[0]))) {
              this.WbY.put(localObject[0], localObject[1]);
            }
          }
          i += 1;
        }
      }
    }
    paramBundle = (String)this.WbY.get("trace_info");
    if (!Util.isNullOrNil(paramBundle)) {
      ai.bfU(paramBundle);
    }
    addSceneEndListener(2996);
    addSceneEndListener(580);
    addSceneEndListener(385);
    if (getIntent() == null)
    {
      Log.d("MicroMsg.WalletOpenViewProxyUI", "func[doCheckPayNetscene] intent null");
      setResult(0);
      finish();
      AppMethodBeat.o(71943);
      return;
    }
    paramBundle = (String)this.WbY.get("openview");
    Object localObject = getIntent().getStringExtra("appId");
    String str1 = getIntent().getStringExtra("timeStamp");
    String str2 = getIntent().getStringExtra("nonceStr");
    String str3 = getIntent().getStringExtra("packageExt");
    String str4 = getIntent().getStringExtra("paySignature");
    if ("open_wcpay_f2f_receive_detail".equals(paramBundle))
    {
      doSceneForceProgress(new aa((String)localObject, str1, str2, str3, str4));
      AppMethodBeat.o(71943);
      return;
    }
    if (("open_wcpay_grouppay_detail".equals(paramBundle)) || ("open_wcpay_hk_f2f".equals(paramBundle)) || ("open_wallet_delay_transfer_setting_ui".equals(paramBundle)))
    {
      bht(str3);
      AppMethodBeat.o(71943);
      return;
    }
    if ("open_wcpay_lqt_detail".equals(paramBundle))
    {
      Log.i("MicroMsg.WalletOpenViewProxyUI", "open lqt detail ui");
      if (this.WbY != null)
      {
        new Intent().putExtra("key_account_type", 1);
        localObject = (String)this.WbY.get("ecardtype");
        str1 = (String)this.WbY.get("extradata");
        paramBundle = (String)this.WbY.get("need_open_lqb");
        Log.i("MicroMsg.WalletOpenViewProxyUI", "open lqt detail ui, ecardtype: %s, extradata: %s, need_open_lqb: %s", new Object[] { localObject, str1, paramBundle });
        if (Util.getInt(paramBundle, 0) == 1)
        {
          paramBundle = (Bundle)localObject;
          if (Util.isNullOrNil((String)localObject)) {
            paramBundle = "WEB_DEBIT";
          }
          doSceneForceProgress(new ak(paramBundle, str1));
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(663L, 18L, 1L, false);
        AppMethodBeat.o(71943);
        return;
        i = Util.getInt((String)this.WbY.get("auto_jump_charge_setting"), 0);
        int j = Util.getInt((String)this.WbY.get("show_open_toast"), 0);
        paramBundle = new Intent();
        if (i == 1)
        {
          paramBundle.putExtra("show_open_toast", j);
          c.b(getContext(), "wallet", ".balance.ui.lqt.WalletLqtBalanceAutoTransferUI", paramBundle);
        }
        for (;;)
        {
          setResult(-1);
          finish();
          break;
          c.b(getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramBundle);
        }
        c.ai(getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
        setResult(-1);
        finish();
      }
    }
    if ("redenvelopes_getshowresouces_and_move_to_root".equals(paramBundle))
    {
      Log.i("MicroMsg.WalletOpenViewProxyUI", "receive envelope");
      ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.luckymoney.a.a.class)).ay(true, true);
      setResult(-1);
      finish();
      AppMethodBeat.o(71943);
      return;
    }
    doSceneForceProgress(new d((String)localObject, str1, str2, str3, getIntent().getStringExtra("signtype"), str4, getIntent().getStringExtra("url"), 4, "openWCPaySpecificView", getIntent().getIntExtra("pay_channel", 0)));
    AppMethodBeat.o(71943);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71945);
    super.onDestroy();
    removeSceneEndListener(580);
    removeSceneEndListener(385);
    removeSceneEndListener(2996);
    AppMethodBeat.o(71945);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(71944);
    Log.i("MicroMsg.WalletOpenViewProxyUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramp });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof d))
      {
        e.brZ(((d)paramp).ihJ());
        bht(getIntent().getStringExtra("packageExt"));
        AppMethodBeat.o(71944);
        return true;
      }
      if ((paramp instanceof aa))
      {
        bht(getIntent().getStringExtra("packageExt"));
        AppMethodBeat.o(71944);
        return true;
      }
      if ((paramp instanceof ak))
      {
        paramString = ((ak)paramp).Vbo;
        Log.i("MicroMsg.WalletOpenViewProxyUI", "on open lqb account scene end, retcode: %s, regmsg: %s", new Object[] { Integer.valueOf(paramString.wuz), paramString.wuA });
        if (paramString.ifY != null) {
          this.VZV.a(paramString.ifY, null);
        }
        if (paramString.wuz == 0)
        {
          paramString = new Intent();
          paramString.putExtra("key_account_type", 2);
          c.b(getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramString);
          setResult(-1);
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(71944);
          return true;
          if (paramString.ifY == null)
          {
            Toast.makeText(this, paramString.wuA, 1).show();
            setResult(0);
          }
        }
      }
    }
    else
    {
      setResult(0);
      finish();
      AppMethodBeat.o(71944);
      return true;
    }
    AppMethodBeat.o(71944);
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