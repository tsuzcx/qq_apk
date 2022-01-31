package com.tencent.mm.plugin.remittance.ui;

import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.fv;
import com.tencent.mm.plugin.remittance.model.o;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.mu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class RemittanceResultUI
  extends WalletBaseUI
{
  private Orders nEh;
  
  private void R(Class<?> paramClass)
  {
    if (cNj() == null)
    {
      a(paramClass, getIntent());
      return;
    }
    cNj().b(this, paramClass, this.BX);
  }
  
  protected boolean bwM()
  {
    return true;
  }
  
  public boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof o))
    {
      y.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (o)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.nys;
        y.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, retcode: %s, retmsg: %s, exposesureInfo: %s", new Object[] { Integer.valueOf(paramString.iHq), paramString.iHr, paramString.qxJ });
        if (paramString.iHq != 0) {}
      }
      for (;;)
      {
        try
        {
          this.BX.putByteArray("key_succpage_resp", paramString.toByteArray());
          R(RemittanceResultNewUI.class);
          finish();
          return true;
        }
        catch (Exception paramString)
        {
          y.printErrStackTrace("MicroMsg.RemittanceResultUI", paramString, "pass succ page resp error: %s", new Object[] { paramString.getMessage() });
          continue;
        }
        Toast.makeText(this, paramString.iHr, 1).show();
        R(RemittanceResultNewUI.class);
      }
    }
    return false;
  }
  
  protected int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    PayInfo localPayInfo;
    if (bwM())
    {
      vN(4);
      getWindow().setBackgroundDrawableResource(a.c.transparent);
      this.nEh = ((Orders)this.BX.getParcelable("key_orders"));
      localPayInfo = (PayInfo)this.BX.getParcelable("key_pay_info");
      if (localPayInfo == null) {
        break label703;
      }
    }
    label643:
    label656:
    label666:
    label679:
    label703:
    for (int i = localPayInfo.bUV;; i = 0)
    {
      boolean bool1;
      boolean bool2;
      label92:
      Object localObject1;
      if ((i == 31) || (i == 5))
      {
        bool1 = false;
        if (this.nEh != null) {
          break label637;
        }
        bool2 = true;
        y.i("MicroMsg.RemittanceResultUI", "orders==null:%s, paysScene: %s, needFetchF2fData: %s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), Boolean.valueOf(bool1) });
        if (this.nEh == null) {
          break label666;
        }
        y.i("MicroMsg.RemittanceResultUI", "is_use_new_paid_succ_page: %s", new Object[] { Integer.valueOf(this.nEh.qwX) });
        if (this.nEh.qwX != 1) {
          break label656;
        }
        if (!bool1) {
          break label666;
        }
        Object localObject2 = this.nEh;
        if ((localPayInfo == null) || (localPayInfo.snX == null)) {
          break label643;
        }
        y.i("MicroMsg.RemittanceResultUI", "fetch f2f data");
        String str1 = localPayInfo.snX.getString("extinfo_key_11");
        localObject1 = "";
        paramBundle = (Bundle)localObject1;
        if (localObject2 != null)
        {
          paramBundle = (Bundle)localObject1;
          if (((Orders)localObject2).qwN.size() > 0) {
            paramBundle = ((Orders.Commodity)((Orders)localObject2).qwN.get(0)).bMY;
          }
        }
        i = localPayInfo.snX.getInt("extinfo_key_15", 0);
        String str2 = localPayInfo.snX.getString("extinfo_key_7");
        String str3 = localPayInfo.snX.getString("extinfo_key_3");
        int j = localPayInfo.snX.getInt("extinfo_key_12", 0);
        String str4 = localPayInfo.snX.getString("extinfo_key_13");
        String str5 = localPayInfo.snX.getString("extinfo_key_14");
        localObject2 = localPayInfo.snX.getString("extinfo_key_16");
        localObject1 = localObject2;
        if (bk.bl((String)localObject2)) {
          localObject1 = paramBundle;
        }
        y.i("MicroMsg.RemittanceResultUI", "fetchF2fData, f2fid: %s, transid: %s, amount: %s, payerDesc: %s, recvDesc: %s, scanScene: %s, paySuccSign: %s, paySuccExtend: %s, channel: %s, payscene: %s", new Object[] { str1, localObject1, Integer.valueOf(i), str2, str3, Integer.valueOf(j), str4, str5, Integer.valueOf(localPayInfo.bUR), Integer.valueOf(localPayInfo.bUV) });
        kh(2773);
        int k = localPayInfo.bUR;
        int m = localPayInfo.bUV;
        a(new o(str1, (String)localObject1, i, str2, str3, k, j, str4, str5), true, true);
        label488:
        i = 0;
        paramBundle = (PayInfo)this.BX.getParcelable("key_pay_info");
        if (paramBundle != null) {
          i = paramBundle.bUV;
        }
        if ((i == 33) || (i == 32) || (i == 48) || (i == 31))
        {
          localObject1 = new fv();
          ((fv)localObject1).bMW.bMX = paramBundle.bMX;
          if (i != 31) {
            break label679;
          }
        }
      }
      for (((fv)localObject1).bMW.type = 0;; ((fv)localObject1).bMW.type = 1) {
        label637:
        do
        {
          if ((this.nEh != null) && (!this.nEh.qwN.isEmpty())) {
            ((fv)localObject1).bMW.bMY = ((Orders.Commodity)this.nEh.qwN.get(0)).bMY;
          }
          com.tencent.mm.sdk.b.a.udP.m((b)localObject1);
          return;
          bool1 = true;
          break;
          bool2 = false;
          break label92;
          R(RemittanceResultNewUI.class);
          finish();
          break label488;
          R(RemittanceResultOldUI.class);
          break label488;
          R(RemittanceResultNewUI.class);
          finish();
          break label488;
        } while ((i != 32) && (i != 33));
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(2773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultUI
 * JD-Core Version:    0.7.0.1
 */