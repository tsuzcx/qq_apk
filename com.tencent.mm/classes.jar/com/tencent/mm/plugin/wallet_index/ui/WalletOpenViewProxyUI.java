package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.ir;
import com.tencent.mm.h.a.te;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.balance.a.a.q;
import com.tencent.mm.plugin.wallet_core.c.u;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.bca;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(7)
public class WalletOpenViewProxyUI
  extends WalletBaseUI
{
  private Map<String, String> qMp = new HashMap();
  
  private void QV(String paramString)
  {
    if (!bk.bl(paramString))
    {
      paramString = (String)this.qMp.get("openview");
      if ("open_wcpay_biz_view".equals(paramString))
      {
        y.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_index_ui");
        d.x(this.mController.uMN, "mall", ".ui.MallIndexUI");
      }
    }
    for (;;)
    {
      paramString = new Intent();
      paramString.putExtra("closeWebView", (String)this.qMp.get("closeWebView"));
      setResult(-1, paramString);
      finish();
      return;
      if ("open_wcpay_balance_view".equals(paramString))
      {
        y.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open wallet_balance_manager_ui");
        com.tencent.mm.pluginsdk.wallet.h.Z(this.mController.uMN, 0);
      }
      else if ("open_wcpay_order_detail_view".equals(paramString))
      {
        y.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_order_transaction_info_ui");
        paramString = new Intent();
        paramString.putExtra("trans_id", (String)this.qMp.get("trans_id"));
        paramString.putExtra("scene", 1);
        if (this.qMp.containsKey("bill_id")) {
          paramString.putExtra("bill_id", (String)this.qMp.get("bill_id"));
        }
        d.b(this.mController.uMN, "order", ".ui.MallOrderTransactionInfoUI", paramString);
      }
      else if ("open_wcpay_f2f_receive_detail".equals(paramString))
      {
        y.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_f2f_receive_detail");
        paramString = new Intent();
        paramString.putExtra("key_timestamp", bk.getLong((String)this.qMp.get("fromtimestamp"), 0L));
        paramString.putExtra("key_from_scene", 1);
        d.b(this.mController.uMN, "collect", ".ui.CollectBillUI", paramString);
        com.tencent.mm.plugin.report.service.h.nFQ.f(13944, new Object[] { Integer.valueOf(2) });
      }
      else if ("open_wcpay_grouppay_detail".equals(paramString))
      {
        y.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_grouppay_detail");
        paramString = new Intent();
        paramString.putExtra("bill_no", (String)this.qMp.get("billno"));
        paramString.putExtra("chatroom", (String)this.qMp.get("groupid"));
        paramString.putExtra("key_sign", (String)this.qMp.get("sign"));
        paramString.putExtra("key_ver", (String)this.qMp.get("ver"));
        paramString.putExtra("enter_scene", 5);
        d.b(this.mController.uMN, "aa", ".ui.PaylistAAUI", paramString);
      }
      else if ("open_wcpay_t2bc_detail".equals(paramString))
      {
        y.d("MicroMsg.WalletOpenViewProxyUI", "do open_wcpay_t2bc_detail");
        paramString = new Intent();
        paramString.putExtra("key_transfer_bill_id", (String)this.qMp.get("transfer_bill_id"));
        paramString.putExtra("key_enter_scene", 1);
        d.b(this.mController.uMN, "remittance", ".bankcard.ui.BankRemitDetailUI", paramString);
      }
      else if ("open_honey_pay_home".equals(paramString))
      {
        y.d("MicroMsg.WalletOpenViewProxyUI", "do open honey pay view");
        paramString = new Intent();
        d.b(this.mController.uMN, "honey_pay", ".ui.HoneyPayMainUI", paramString);
      }
      else if ("open_wcpay_t2bc_view".equals(paramString))
      {
        y.d("MicroMsg.WalletOpenViewProxyUI", "do open VIEW_OPEN_T2BC_UI");
        new te().ccN.context = this.mController.uMN;
      }
      else if ("open_wcpay_fetch_balance_view".equals(paramString))
      {
        y.d("MicroMsg.WalletOpenViewProxyUI", "do open VIEW_OPEN_FETCH_BALANCE_UI");
        paramString = new Intent();
        d.b(this.mController.uMN, "remittance", ".bankcard.ui.BankRemitBankcardInputUI", paramString);
      }
      else if ("open_wcpay_wallet_lock_view".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("wallet_lock_jsapi_scene", (String)this.qMp.get("entry_scene"));
        ((b)g.r(b.class)).a(this, paramString);
      }
      else if ("open_wcpay_security_setting_view".equals(paramString))
      {
        paramString = new Intent();
        paramString.putExtra("wallet_lock_jsapi_scene", (String)this.qMp.get("entry_scene"));
        d.b(this, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramString);
      }
      else if ("open_wcpay_c2c_message_view".equals(paramString))
      {
        if (this.qMp != null)
        {
          int i = bk.getInt((String)this.qMp.get("bizType"), -1);
          if (i == 1)
          {
            paramString = (String)this.qMp.get("bizId");
            String str = (String)this.qMp.get("username");
            long l = bk.getLong((String)this.qMp.get("createTime"), -1L);
            y.i("MicroMsg.WalletOpenViewProxyUI", "view open c2c message view, bizType: %s, bizId: %s, username: %s, createTime: %s", new Object[] { Integer.valueOf(i), paramString, str, Long.valueOf(l) });
            ir localir = new ir();
            localir.bQQ.bQR = paramString;
            localir.bQQ.username = str;
            localir.bQQ.bQS = Long.valueOf(l);
            com.tencent.mm.sdk.b.a.udP.m(localir);
          }
        }
      }
      else
      {
        y.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] invalid target view : " + paramString);
        continue;
        y.w("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] packageExt null or nil");
      }
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.WalletOpenViewProxyUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.a))
      {
        f.Xf(((com.tencent.mm.plugin.wallet_core.c.a)paramm).bUH());
        QV(getIntent().getStringExtra("packageExt"));
        return true;
      }
      if ((paramm instanceof u))
      {
        QV(getIntent().getStringExtra("packageExt"));
        return true;
      }
      if ((paramm instanceof q))
      {
        paramString = ((q)paramm).qgm;
        y.i("MicroMsg.WalletOpenViewProxyUI", "on open lqb account scene end, retcode: %s, regmsg: %s", new Object[] { Integer.valueOf(paramString.ino), paramString.inp });
        if (paramString.ino == 0)
        {
          paramString = new Intent();
          paramString.putExtra("key_account_type", 2);
          d.b(this.mController.uMN, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramString);
          setResult(-1);
        }
        for (;;)
        {
          finish();
          return true;
          Toast.makeText(this, paramString.inp, 1).show();
          setResult(0);
        }
      }
    }
    else
    {
      setResult(0);
      finish();
      return true;
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    vN(8);
    paramBundle = getIntent().getStringExtra("packageExt");
    this.qMp = new HashMap();
    if (!bk.bl(paramBundle))
    {
      paramBundle = paramBundle.split("&");
      if ((paramBundle != null) && (paramBundle.length > 0))
      {
        int i = 0;
        while (i < paramBundle.length)
        {
          if (!bk.bl(paramBundle[i]))
          {
            localObject = paramBundle[i].split("=");
            if ((localObject.length == 2) && (!bk.bl(localObject[0]))) {
              this.qMp.put(localObject[0], localObject[1]);
            }
          }
          i += 1;
        }
      }
    }
    kh(2996);
    kh(580);
    kh(385);
    if (getIntent() == null)
    {
      y.d("MicroMsg.WalletOpenViewProxyUI", "func[doCheckPayNetscene] intent null");
      setResult(0);
      finish();
      return;
    }
    paramBundle = (String)this.qMp.get("openview");
    Object localObject = getIntent().getStringExtra("appId");
    String str1 = getIntent().getStringExtra("timeStamp");
    String str2 = getIntent().getStringExtra("nonceStr");
    String str3 = getIntent().getStringExtra("packageExt");
    String str4 = getIntent().getStringExtra("paySignature");
    if ("open_wcpay_f2f_receive_detail".equals(paramBundle))
    {
      a(new u((String)localObject, str1, str2, str3, str4), true, false);
      return;
    }
    if ("open_wcpay_grouppay_detail".equals(paramBundle))
    {
      QV(str3);
      return;
    }
    if ("open_wcpay_lqt_detail".equals(paramBundle))
    {
      y.i("MicroMsg.WalletOpenViewProxyUI", "open lqt detail ui");
      if (this.qMp != null)
      {
        new Intent().putExtra("key_account_type", 1);
        localObject = (String)this.qMp.get("ecardtype");
        str1 = (String)this.qMp.get("extradata");
        paramBundle = (String)this.qMp.get("need_open_lqb");
        y.i("MicroMsg.WalletOpenViewProxyUI", "open lqt detail ui, ecardtype: %s, extradata: %s, need_open_lqb: %s", new Object[] { localObject, str1, paramBundle });
        if (bk.getInt(paramBundle, 0) == 1)
        {
          paramBundle = (Bundle)localObject;
          if (bk.bl((String)localObject)) {
            paramBundle = "WEB_DEBIT";
          }
          a(new q(paramBundle, str1), true, false);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(663L, 18L, 1L, false);
        return;
        d.x(this.mController.uMN, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
        setResult(-1);
        finish();
        continue;
        d.x(this.mController.uMN, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
        setResult(-1);
        finish();
      }
    }
    a(new com.tencent.mm.plugin.wallet_core.c.a((String)localObject, str1, str2, str3, getIntent().getStringExtra("signtype"), str4, getIntent().getStringExtra("url"), 4, "openWCPaySpecificView", getIntent().getIntExtra("pay_channel", 0)), true, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(580);
    ki(385);
    ki(2996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletOpenViewProxyUI
 * JD-Core Version:    0.7.0.1
 */