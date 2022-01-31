package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.fy;
import com.tencent.mm.plugin.remittance.model.o;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class RemittanceResultUI
  extends WalletBaseUI
{
  private Orders qrf;
  
  private void ao(Class<?> paramClass)
  {
    AppMethodBeat.i(45157);
    if (getProcess() == null)
    {
      startActivity(paramClass, getIntent());
      AppMethodBeat.o(45157);
      return;
    }
    getProcess().b(this, paramClass, getInput());
    AppMethodBeat.o(45157);
  }
  
  protected boolean chF()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45156);
    super.onCreate(paramBundle);
    PayInfo localPayInfo;
    if (chF())
    {
      setContentViewVisibility(4);
      getWindow().setBackgroundDrawableResource(2131690605);
      this.qrf = ((Orders)getInput().getParcelable("key_orders"));
      localPayInfo = (PayInfo)getInput().getParcelable("key_pay_info");
      if (localPayInfo == null) {
        break label698;
      }
    }
    label652:
    label661:
    label674:
    label698:
    for (int i = localPayInfo.cCD;; i = 0)
    {
      boolean bool1;
      boolean bool2;
      label96:
      Object localObject1;
      if ((i == 31) || (i == 5))
      {
        bool1 = false;
        if (this.qrf != null) {
          break label633;
        }
        bool2 = true;
        ab.i("MicroMsg.RemittanceResultUI", "orders==null:%s, paysScene: %s, needFetchF2fData: %s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), Boolean.valueOf(bool1) });
        if (this.qrf == null) {
          break label661;
        }
        ab.i("MicroMsg.RemittanceResultUI", "is_use_new_paid_succ_page: %s", new Object[] { Integer.valueOf(this.qrf.ujv) });
        if (this.qrf.ujv != 1) {
          break label652;
        }
        if (!bool1) {
          break label661;
        }
        Object localObject2 = this.qrf;
        if ((localPayInfo == null) || (localPayInfo.wgv == null)) {
          break label639;
        }
        ab.i("MicroMsg.RemittanceResultUI", "fetch f2f data");
        String str1 = localPayInfo.wgv.getString("extinfo_key_11");
        localObject1 = "";
        paramBundle = (Bundle)localObject1;
        if (localObject2 != null)
        {
          paramBundle = (Bundle)localObject1;
          if (((Orders)localObject2).ujl.size() > 0) {
            paramBundle = ((Orders.Commodity)((Orders)localObject2).ujl.get(0)).cnJ;
          }
        }
        i = localPayInfo.wgv.getInt("extinfo_key_15", 0);
        String str2 = localPayInfo.wgv.getString("extinfo_key_7");
        String str3 = localPayInfo.wgv.getString("extinfo_key_3");
        int j = localPayInfo.wgv.getInt("extinfo_key_12", 0);
        String str4 = localPayInfo.wgv.getString("extinfo_key_13");
        String str5 = localPayInfo.wgv.getString("extinfo_key_14");
        localObject2 = localPayInfo.wgv.getString("extinfo_key_16");
        localObject1 = localObject2;
        if (bo.isNullOrNil((String)localObject2)) {
          localObject1 = paramBundle;
        }
        ab.i("MicroMsg.RemittanceResultUI", "fetchF2fData, f2fid: %s, transid: %s, amount: %s, payerDesc: %s, recvDesc: %s, scanScene: %s, paySuccSign: %s, paySuccExtend: %s, channel: %s, payscene: %s", new Object[] { str1, localObject1, Integer.valueOf(i), str2, str3, Integer.valueOf(j), str4, str5, Integer.valueOf(localPayInfo.cCy), Integer.valueOf(localPayInfo.cCD) });
        addSceneEndListener(2773);
        doSceneProgress(new o(str1, (String)localObject1, i, str2, str3, localPayInfo.cCy, j, str4, str5));
        label479:
        i = 0;
        paramBundle = (PayInfo)getInput().getParcelable("key_pay_info");
        if (paramBundle != null) {
          i = paramBundle.cCD;
        }
        if ((i == 33) || (i == 32) || (i == 48) || (i == 31))
        {
          localObject1 = new fy();
          ((fy)localObject1).cuq.cnI = paramBundle.cnI;
          if (i != 31) {
            break label674;
          }
        }
      }
      for (((fy)localObject1).cuq.type = 0;; ((fy)localObject1).cuq.type = 1) {
        label633:
        label639:
        do
        {
          if ((this.qrf != null) && (!this.qrf.ujl.isEmpty())) {
            ((fy)localObject1).cuq.cnJ = ((Orders.Commodity)this.qrf.ujl.get(0)).cnJ;
          }
          com.tencent.mm.sdk.b.a.ymk.l((b)localObject1);
          AppMethodBeat.o(45156);
          return;
          bool1 = true;
          break;
          bool2 = false;
          break label96;
          ao(RemittanceResultNewUI.class);
          finish();
          break label479;
          ao(RemittanceResultOldUI.class);
          break label479;
          ao(RemittanceResultNewUI.class);
          finish();
          break label479;
        } while ((i != 32) && (i != 33));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45159);
    super.onDestroy();
    removeSceneEndListener(2773);
    AppMethodBeat.o(45159);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45158);
    if ((paramm instanceof o))
    {
      ab.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (o)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.qjs;
        ab.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, retcode: %s, retmsg: %s, exposesureInfo: %s", new Object[] { Integer.valueOf(paramString.cnK), paramString.kNv, paramString.ukr });
        if (paramString.cnK != 0) {}
      }
      for (;;)
      {
        try
        {
          getInput().putByteArray("key_succpage_resp", paramString.toByteArray());
          ao(RemittanceResultNewUI.class);
          finish();
          AppMethodBeat.o(45158);
          return true;
        }
        catch (Exception paramString)
        {
          ab.printErrStackTrace("MicroMsg.RemittanceResultUI", paramString, "pass succ page resp error: %s", new Object[] { paramString.getMessage() });
          continue;
        }
        Toast.makeText(this, paramString.kNv, 1).show();
        ao(RemittanceResultNewUI.class);
      }
    }
    AppMethodBeat.o(45158);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultUI
 * JD-Core Version:    0.7.0.1
 */