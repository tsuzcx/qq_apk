package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.gj;
import com.tencent.mm.plugin.remittance.model.p;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.uk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class RemittanceResultUI
  extends WalletBaseUI
{
  private Orders ygb;
  
  private void aT(Class<?> paramClass)
  {
    AppMethodBeat.i(68315);
    if (getProcess() == null)
    {
      startActivity(paramClass, getIntent());
      AppMethodBeat.o(68315);
      return;
    }
    getProcess().b(this, paramClass, getInput());
    AppMethodBeat.o(68315);
  }
  
  protected boolean dJV()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68314);
    super.onCreate(paramBundle);
    PayInfo localPayInfo;
    if (dJV())
    {
      setContentViewVisibility(4);
      getWindow().setBackgroundDrawableResource(2131101053);
      this.ygb = ((Orders)getInput().getParcelable("key_orders"));
      localPayInfo = (PayInfo)getInput().getParcelable("key_pay_info");
      if (localPayInfo == null) {
        break label698;
      }
    }
    label652:
    label661:
    label674:
    label698:
    for (int i = localPayInfo.dCC;; i = 0)
    {
      boolean bool1;
      boolean bool2;
      label96:
      Object localObject1;
      if ((i == 31) || (i == 5))
      {
        bool1 = false;
        if (this.ygb != null) {
          break label633;
        }
        bool2 = true;
        ad.i("MicroMsg.RemittanceResultUI", "orders==null:%s, paysScene: %s, needFetchF2fData: %s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), Boolean.valueOf(bool1) });
        if (this.ygb == null) {
          break label661;
        }
        ad.i("MicroMsg.RemittanceResultUI", "is_use_new_paid_succ_page: %s", new Object[] { Integer.valueOf(this.ygb.CYu) });
        if (this.ygb.CYu != 1) {
          break label652;
        }
        if (!bool1) {
          break label661;
        }
        Object localObject2 = this.ygb;
        if ((localPayInfo == null) || (localPayInfo.htZ == null)) {
          break label639;
        }
        ad.i("MicroMsg.RemittanceResultUI", "fetch f2f data");
        String str1 = localPayInfo.htZ.getString("extinfo_key_11");
        localObject1 = "";
        paramBundle = (Bundle)localObject1;
        if (localObject2 != null)
        {
          paramBundle = (Bundle)localObject1;
          if (((Orders)localObject2).CYk.size() > 0) {
            paramBundle = ((Orders.Commodity)((Orders)localObject2).CYk.get(0)).dlv;
          }
        }
        i = localPayInfo.htZ.getInt("extinfo_key_15", 0);
        String str2 = localPayInfo.htZ.getString("extinfo_key_7");
        String str3 = localPayInfo.htZ.getString("extinfo_key_3");
        int j = localPayInfo.htZ.getInt("extinfo_key_12", 0);
        String str4 = localPayInfo.htZ.getString("extinfo_key_13");
        String str5 = localPayInfo.htZ.getString("extinfo_key_14");
        localObject2 = localPayInfo.htZ.getString("extinfo_key_16");
        localObject1 = localObject2;
        if (bt.isNullOrNil((String)localObject2)) {
          localObject1 = paramBundle;
        }
        ad.i("MicroMsg.RemittanceResultUI", "fetchF2fData, f2fid: %s, transid: %s, amount: %s, payerDesc: %s, recvDesc: %s, scanScene: %s, paySuccSign: %s, paySuccExtend: %s, channel: %s, payscene: %s", new Object[] { str1, localObject1, Integer.valueOf(i), str2, str3, Integer.valueOf(j), str4, str5, Integer.valueOf(localPayInfo.channel), Integer.valueOf(localPayInfo.dCC) });
        addSceneEndListener(2773);
        doSceneProgress(new p(str1, (String)localObject1, i, str2, str3, localPayInfo.channel, j, str4, str5));
        label479:
        i = 0;
        paramBundle = (PayInfo)getInput().getParcelable("key_pay_info");
        if (paramBundle != null) {
          i = paramBundle.dCC;
        }
        if ((i == 33) || (i == 32) || (i == 48) || (i == 31))
        {
          localObject1 = new gj();
          ((gj)localObject1).dse.dlu = paramBundle.dlu;
          if (i != 31) {
            break label674;
          }
        }
      }
      for (((gj)localObject1).dse.type = 0;; ((gj)localObject1).dse.type = 1) {
        label633:
        label639:
        do
        {
          if ((this.ygb != null) && (!this.ygb.CYk.isEmpty())) {
            ((gj)localObject1).dse.dlv = ((Orders.Commodity)this.ygb.CYk.get(0)).dlv;
          }
          com.tencent.mm.sdk.b.a.IbL.l((b)localObject1);
          AppMethodBeat.o(68314);
          return;
          bool1 = true;
          break;
          bool2 = false;
          break label96;
          aT(RemittanceResultNewUI.class);
          finish();
          break label479;
          aT(RemittanceResultOldUI.class);
          break label479;
          aT(RemittanceResultNewUI.class);
          finish();
          break label479;
        } while ((i != 32) && (i != 33));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68317);
    super.onDestroy();
    removeSceneEndListener(2773);
    AppMethodBeat.o(68317);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(68316);
    if ((paramn instanceof p))
    {
      ad.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (p)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.xYf;
        ad.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, retcode: %s, retmsg: %s, exposesureInfo: %s", new Object[] { Integer.valueOf(paramString.dlw), paramString.paA, paramString.CZq });
        if (paramString.dlw != 0) {}
      }
      for (;;)
      {
        try
        {
          getInput().putByteArray("key_succpage_resp", paramString.toByteArray());
          aT(RemittanceResultNewUI.class);
          finish();
          AppMethodBeat.o(68316);
          return true;
        }
        catch (Exception paramString)
        {
          ad.printErrStackTrace("MicroMsg.RemittanceResultUI", paramString, "pass succ page resp error: %s", new Object[] { paramString.getMessage() });
          continue;
        }
        Toast.makeText(this, paramString.paA, 1).show();
        aT(RemittanceResultNewUI.class);
      }
    }
    AppMethodBeat.o(68316);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultUI
 * JD-Core Version:    0.7.0.1
 */