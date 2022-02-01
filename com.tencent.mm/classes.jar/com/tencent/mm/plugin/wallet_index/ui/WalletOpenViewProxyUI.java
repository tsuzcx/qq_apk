package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.km;
import com.tencent.mm.g.a.yc;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ae;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ag;
import com.tencent.mm.plugin.wallet.balance.model.lqt.o;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.cfv;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(7)
public class WalletOpenViewProxyUI
  extends WalletBaseUI
{
  private Map<String, String> Drr;
  
  public WalletOpenViewProxyUI()
  {
    AppMethodBeat.i(71942);
    this.Drr = new HashMap();
    AppMethodBeat.o(71942);
  }
  
  private void aFf(final String paramString)
  {
    AppMethodBeat.i(71946);
    int i;
    if (!bt.isNullOrNil(paramString))
    {
      paramString = (String)this.Drr.get("openview");
      if ("open_wcpay_biz_view".equals(paramString))
      {
        ad.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_index_ui");
        com.tencent.mm.pluginsdk.wallet.f.hF(getContext());
        i = 1;
      }
    }
    for (;;)
    {
      paramString = new Intent();
      paramString.putExtra("closeWebView", (String)this.Drr.get("closeWebView"));
      setResult(-1, paramString);
      if (i != 0) {
        finish();
      }
      AppMethodBeat.o(71946);
      return;
      if ("open_wcpay_balance_view".equals(paramString))
      {
        ad.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open wallet_balance_manager_ui");
        com.tencent.mm.pluginsdk.wallet.f.aw(getContext(), 0);
        i = 1;
      }
      else if ("open_wcpay_order_detail_view".equals(paramString))
      {
        ad.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_order_transaction_info_ui");
        paramString = new Intent();
        paramString.putExtra("trans_id", (String)this.Drr.get("trans_id"));
        paramString.putExtra("scene", 1);
        if (this.Drr.containsKey("bill_id")) {
          paramString.putExtra("bill_id", (String)this.Drr.get("bill_id"));
        }
        com.tencent.mm.bs.d.b(getContext(), "order", ".ui.MallOrderTransactionInfoUI", paramString);
        i = 1;
      }
      else if ("open_wcpay_f2f_receive_detail".equals(paramString))
      {
        ad.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_f2f_receive_detail");
        paramString = new Intent();
        paramString.putExtra("key_timestamp", bt.getLong((String)this.Drr.get("fromtimestamp"), 0L));
        paramString.putExtra("key_from_scene", 1);
        com.tencent.mm.bs.d.b(getContext(), "collect", ".ui.CollectBillUI", paramString);
        com.tencent.mm.plugin.report.service.g.yhR.f(13944, new Object[] { Integer.valueOf(2) });
        i = 1;
      }
      else if ("open_wcpay_grouppay_detail".equals(paramString))
      {
        ad.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_grouppay_detail");
        paramString = new Intent();
        paramString.putExtra("bill_no", (String)this.Drr.get("billno"));
        paramString.putExtra("chatroom", (String)this.Drr.get("groupid"));
        paramString.putExtra("key_sign", (String)this.Drr.get("sign"));
        paramString.putExtra("key_ver", (String)this.Drr.get("ver"));
        paramString.putExtra("enter_scene", 5);
        com.tencent.mm.bs.d.b(getContext(), "aa", ".ui.PaylistAAUI", paramString);
        i = 1;
      }
      else if ("open_wcpay_t2bc_detail".equals(paramString))
      {
        ad.d("MicroMsg.WalletOpenViewProxyUI", "do open_wcpay_t2bc_detail");
        paramString = new Intent();
        paramString.putExtra("key_transfer_bill_id", (String)this.Drr.get("transfer_bill_id"));
        paramString.putExtra("key_enter_scene", 1);
        com.tencent.mm.bs.d.b(getContext(), "remittance", ".bankcard.ui.BankRemitDetailUI", paramString);
        i = 1;
      }
      else if ("open_honey_pay_home".equals(paramString))
      {
        ad.d("MicroMsg.WalletOpenViewProxyUI", "do open honey pay view");
        paramString = new Intent();
        com.tencent.mm.bs.d.b(getContext(), "honey_pay", ".ui.HoneyPayMainUI", paramString);
        i = 1;
      }
      else if ("open_wcpay_t2bc_view".equals(paramString))
      {
        ad.d("MicroMsg.WalletOpenViewProxyUI", "do open VIEW_OPEN_T2BC_UI");
        paramString = new Intent();
        com.tencent.mm.bs.d.b(getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI", paramString);
        i = 1;
      }
      else if ("open_wcpay_fetch_balance_view".equals(paramString))
      {
        ad.d("MicroMsg.WalletOpenViewProxyUI", "do open VIEW_OPEN_FETCH_BALANCE_UI");
        paramString = new yc();
        paramString.dMs.context = getContext();
        com.tencent.mm.sdk.b.a.IbL.l(paramString);
        i = 1;
      }
      else if ("open_wcpay_wallet_lock_view".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("wallet_lock_jsapi_scene", (String)this.Drr.get("entry_scene"));
        ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).e(this, paramString);
        i = 1;
      }
      else if ("open_wcpay_security_setting_view".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("wallet_lock_jsapi_scene", (String)this.Drr.get("entry_scene"));
        com.tencent.mm.bs.d.b(this, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramString);
        i = 1;
      }
      else
      {
        Object localObject1;
        Object localObject2;
        if ("open_wcpay_c2c_message_view".equals(paramString))
        {
          if (this.Drr != null)
          {
            i = bt.getInt((String)this.Drr.get("bizType"), -1);
            if (i == 1)
            {
              paramString = (String)this.Drr.get("bizId");
              localObject1 = (String)this.Drr.get("username");
              long l = bt.getLong((String)this.Drr.get("createTime"), -1L);
              ad.i("MicroMsg.WalletOpenViewProxyUI", "view open c2c message view, bizType: %s, bizId: %s, username: %s, createTime: %s", new Object[] { Integer.valueOf(i), paramString, localObject1, Long.valueOf(l) });
              localObject2 = new km();
              ((km)localObject2).dxu.dxv = paramString;
              ((km)localObject2).dxu.username = ((String)localObject1);
              ((km)localObject2).dxu.dxw = Long.valueOf(l);
              com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
            }
            i = 1;
          }
        }
        else
        {
          if ("open_lqt_auto_planindex_view".equals(paramString))
          {
            paramString = new Intent();
            com.tencent.mm.bs.d.b(getContext(), "wallet", ".balance.ui.lqt.WalletLqtPlanBeforeHomeUI", paramString);
            i = 1;
            continue;
          }
          if ("open_wcpay_hk_f2f".equals(paramString))
          {
            paramString = new Intent();
            paramString.putExtra("key_from_scene", 1);
            com.tencent.mm.bs.d.b(getContext(), "collect", ".ui.CollectHKMainUI", paramString);
            i = 1;
            continue;
          }
          if ("open_lqt_auto_planadd_view".equals(paramString))
          {
            paramString = new Intent(this, WalletLqtPlanAddUI.class);
            paramString.putExtra("key_mode", 1);
            paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/wallet_index/ui/WalletOpenViewProxyUI", "handleOpenView", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramString.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_index/ui/WalletOpenViewProxyUI", "handleOpenView", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            i = 1;
            continue;
          }
          if ("open_wcpay_lqt_save".equals(paramString))
          {
            ae.aDQ((String)this.Drr.get("trace_info"));
            paramString = (String)this.Drr.get("operate_id");
            localObject1 = com.tencent.mm.wallet_core.ui.g.c(getContext(), false, null);
            new o().aED().b(new com.tencent.mm.vending.c.a() {});
            i = 0;
            continue;
          }
          if ("open_wcpay_grouppay_introview".equals(paramString))
          {
            localObject2 = (String)this.Drr.get("amount");
            localObject1 = (String)this.Drr.get("title");
            Intent localIntent = new Intent();
            localIntent.putExtra("amount", (String)localObject2);
            paramString = (String)localObject1;
            if (!bt.isNullOrNil((String)localObject1))
            {
              paramString = URLDecoder.decode((String)localObject1);
              localIntent.putExtra("title", paramString);
            }
            localIntent.putExtra("enter_scene", 5);
            ad.i("MicroMsg.WalletOpenViewProxyUI", "view open grouppay, amount: %s, title: %s", new Object[] { localObject2, paramString });
            com.tencent.mm.bs.d.b(this, "aa", ".ui.AAEntranceUI", localIntent);
            i = 1;
            continue;
          }
          ad.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] invalid target view : ".concat(String.valueOf(paramString)));
        }
        i = 1;
        continue;
        ad.w("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] packageExt null or nil");
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
        ad.i("MicroMsg.WalletOpenViewProxyUI", "select chatroom：%s", new Object[] { str3 });
        String str4 = (String)this.Drr.get("amount");
        String str2 = (String)this.Drr.get("title");
        Intent localIntent = new Intent();
        localIntent.putExtra("amount", str4);
        String str1 = str2;
        if (!bt.isNullOrNil(str2))
        {
          str1 = URLDecoder.decode(str2);
          localIntent.putExtra("title", str1);
        }
        if (!bt.isNullOrNil(str3)) {
          localIntent.putExtra("chatroom_name", str3);
        }
        localIntent.putExtra("enter_scene", 5);
        com.tencent.mm.bs.d.b(getContext(), "aa", ".ui.LaunchAAUI", localIntent);
        ad.i("MicroMsg.WalletOpenViewProxyUI", "view open grouppay, amount: %s, title: %s", new Object[] { str4, str1 });
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
    paramBundle = getIntent().getStringExtra("packageExt");
    this.Drr = new HashMap();
    int i;
    if (!bt.isNullOrNil(paramBundle))
    {
      paramBundle = paramBundle.split("&");
      if ((paramBundle != null) && (paramBundle.length > 0))
      {
        i = 0;
        while (i < paramBundle.length)
        {
          if (!bt.isNullOrNil(paramBundle[i]))
          {
            localObject = paramBundle[i].split("=");
            if ((localObject.length == 2) && (!bt.isNullOrNil(localObject[0]))) {
              this.Drr.put(localObject[0], localObject[1]);
            }
          }
          i += 1;
        }
      }
    }
    paramBundle = (String)this.Drr.get("trace_info");
    if (!bt.isNullOrNil(paramBundle)) {
      ae.aDQ(paramBundle);
    }
    addSceneEndListener(2996);
    addSceneEndListener(580);
    addSceneEndListener(385);
    if (getIntent() == null)
    {
      ad.d("MicroMsg.WalletOpenViewProxyUI", "func[doCheckPayNetscene] intent null");
      setResult(0);
      finish();
      AppMethodBeat.o(71943);
      return;
    }
    paramBundle = (String)this.Drr.get("openview");
    Object localObject = getIntent().getStringExtra("appId");
    String str1 = getIntent().getStringExtra("timeStamp");
    String str2 = getIntent().getStringExtra("nonceStr");
    String str3 = getIntent().getStringExtra("packageExt");
    String str4 = getIntent().getStringExtra("paySignature");
    if ("open_wcpay_f2f_receive_detail".equals(paramBundle))
    {
      doSceneForceProgress(new z((String)localObject, str1, str2, str3, str4));
      AppMethodBeat.o(71943);
      return;
    }
    if (("open_wcpay_grouppay_detail".equals(paramBundle)) || ("open_wcpay_hk_f2f".equals(paramBundle)))
    {
      aFf(str3);
      AppMethodBeat.o(71943);
      return;
    }
    if ("open_wcpay_lqt_detail".equals(paramBundle))
    {
      ad.i("MicroMsg.WalletOpenViewProxyUI", "open lqt detail ui");
      if (this.Drr != null)
      {
        new Intent().putExtra("key_account_type", 1);
        localObject = (String)this.Drr.get("ecardtype");
        str1 = (String)this.Drr.get("extradata");
        paramBundle = (String)this.Drr.get("need_open_lqb");
        ad.i("MicroMsg.WalletOpenViewProxyUI", "open lqt detail ui, ecardtype: %s, extradata: %s, need_open_lqb: %s", new Object[] { localObject, str1, paramBundle });
        if (bt.getInt(paramBundle, 0) == 1)
        {
          paramBundle = (Bundle)localObject;
          if (bt.isNullOrNil((String)localObject)) {
            paramBundle = "WEB_DEBIT";
          }
          doSceneForceProgress(new ag(paramBundle, str1));
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(663L, 18L, 1L, false);
        AppMethodBeat.o(71943);
        return;
        i = bt.getInt((String)this.Drr.get("auto_jump_charge_setting"), 0);
        int j = bt.getInt((String)this.Drr.get("show_open_toast"), 0);
        paramBundle = new Intent();
        if (i == 1)
        {
          paramBundle.putExtra("show_open_toast", j);
          com.tencent.mm.bs.d.b(getContext(), "wallet", ".balance.ui.lqt.WalletLqtBalanceAutoTransferUI", paramBundle);
        }
        for (;;)
        {
          setResult(-1);
          finish();
          break;
          com.tencent.mm.bs.d.b(getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramBundle);
        }
        com.tencent.mm.bs.d.Q(getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
        setResult(-1);
        finish();
      }
    }
    if ("redenvelopes_getshowresouces_and_move_to_root".equals(paramBundle))
    {
      ad.i("MicroMsg.WalletOpenViewProxyUI", "receive envelope");
      ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).U(true, true);
      setResult(-1);
      finish();
      AppMethodBeat.o(71943);
      return;
    }
    doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.d((String)localObject, str1, str2, str3, getIntent().getStringExtra("signtype"), str4, getIntent().getStringExtra("url"), 4, "openWCPaySpecificView", getIntent().getIntExtra("pay_channel", 0)));
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71944);
    ad.i("MicroMsg.WalletOpenViewProxyUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.d))
      {
        e.aNP(((com.tencent.mm.plugin.wallet_core.c.d)paramn).eEF());
        aFf(getIntent().getStringExtra("packageExt"));
        AppMethodBeat.o(71944);
        return true;
      }
      if ((paramn instanceof z))
      {
        aFf(getIntent().getStringExtra("packageExt"));
        AppMethodBeat.o(71944);
        return true;
      }
      if ((paramn instanceof ag))
      {
        paramString = ((ag)paramn).Cyx;
        ad.i("MicroMsg.WalletOpenViewProxyUI", "on open lqb account scene end, retcode: %s, regmsg: %s", new Object[] { Integer.valueOf(paramString.ozR), paramString.ozS });
        if (paramString.ozR == 0)
        {
          paramString = new Intent();
          paramString.putExtra("key_account_type", 2);
          com.tencent.mm.bs.d.b(getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramString);
          setResult(-1);
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(71944);
          return true;
          Toast.makeText(this, paramString.ozS, 1).show();
          setResult(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletOpenViewProxyUI
 * JD-Core Version:    0.7.0.1
 */