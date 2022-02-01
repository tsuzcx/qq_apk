package com.tencent.mm.plugin.remittance.ui;

import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.hf;
import com.tencent.mm.plugin.remittance.model.s;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.xn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.List;

@a(3)
public class RemittanceResultUI
  extends WalletBaseUI
{
  private Orders OsJ;
  
  private void ca(Class<?> paramClass)
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
  
  protected boolean gNb()
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
    if (gNb())
    {
      setContentViewVisibility(4);
      getWindow().setBackgroundDrawableResource(a.c.transparent);
      this.OsJ = ((Orders)getInput().getParcelable("key_orders"));
      localPayInfo = (PayInfo)getInput().getParcelable("key_pay_info");
      if (localPayInfo == null) {
        break label696;
      }
    }
    label650:
    label659:
    label672:
    label696:
    for (int i = localPayInfo.hUR;; i = 0)
    {
      boolean bool1;
      boolean bool2;
      label97:
      Object localObject1;
      if ((i == 31) || (i == 5))
      {
        bool1 = false;
        if (this.OsJ != null) {
          break label631;
        }
        bool2 = true;
        Log.i("MicroMsg.RemittanceResultUI", "orders==null:%s, paysScene: %s, needFetchF2fData: %s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), Boolean.valueOf(bool1) });
        if (this.OsJ == null) {
          break label659;
        }
        Log.i("MicroMsg.RemittanceResultUI", "is_use_new_paid_succ_page: %s", new Object[] { Integer.valueOf(this.OsJ.VHh) });
        if (this.OsJ.VHh != 1) {
          break label650;
        }
        if (!bool1) {
          break label659;
        }
        Object localObject2 = this.OsJ;
        if ((localPayInfo == null) || (localPayInfo.nKf == null)) {
          break label637;
        }
        Log.i("MicroMsg.RemittanceResultUI", "fetch f2f data");
        String str1 = localPayInfo.nKf.getString("extinfo_key_11");
        localObject1 = "";
        paramBundle = (Bundle)localObject1;
        if (localObject2 != null)
        {
          paramBundle = (Bundle)localObject1;
          if (((Orders)localObject2).VGX.size() > 0) {
            paramBundle = ((Orders.Commodity)((Orders)localObject2).VGX.get(0)).hAU;
          }
        }
        i = localPayInfo.nKf.getInt("extinfo_key_15", 0);
        String str2 = localPayInfo.nKf.getString("extinfo_key_7");
        String str3 = localPayInfo.nKf.getString("extinfo_key_3");
        int j = localPayInfo.nKf.getInt("extinfo_key_12", 0);
        String str4 = localPayInfo.nKf.getString("extinfo_key_13");
        String str5 = localPayInfo.nKf.getString("extinfo_key_14");
        localObject2 = localPayInfo.nKf.getString("extinfo_key_16");
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2)) {
          localObject1 = paramBundle;
        }
        Log.i("MicroMsg.RemittanceResultUI", "fetchF2fData, f2fid: %s, transid: %s, amount: %s, payerDesc: %s, recvDesc: %s, scanScene: %s, paySuccSign: %s, paySuccExtend: %s, channel: %s, payscene: %s", new Object[] { str1, localObject1, Integer.valueOf(i), str2, str3, Integer.valueOf(j), str4, str5, Integer.valueOf(localPayInfo.channel), Integer.valueOf(localPayInfo.hUR) });
        addSceneEndListener(2773);
        doSceneProgress(new s(str1, (String)localObject1, i, str2, str3, localPayInfo.channel, j, str4, str5));
        label480:
        i = 0;
        paramBundle = (PayInfo)getInput().getParcelable("key_pay_info");
        if (paramBundle != null) {
          i = paramBundle.hUR;
        }
        if ((i == 33) || (i == 32) || (i == 48) || (i == 31))
        {
          localObject1 = new hf();
          ((hf)localObject1).hHZ.hAT = paramBundle.hAT;
          if (i != 31) {
            break label672;
          }
        }
      }
      for (((hf)localObject1).hHZ.type = 0;; ((hf)localObject1).hHZ.type = 1) {
        label631:
        label637:
        do
        {
          if ((this.OsJ != null) && (!this.OsJ.VGX.isEmpty())) {
            ((hf)localObject1).hHZ.hAU = ((Orders.Commodity)this.OsJ.VGX.get(0)).hAU;
          }
          ((hf)localObject1).publish();
          AppMethodBeat.o(68314);
          return;
          bool1 = true;
          break;
          bool2 = false;
          break label97;
          ca(RemittanceResultNewUI.class);
          finish();
          break label480;
          ca(RemittanceResultOldUI.class);
          break label480;
          ca(RemittanceResultNewUI.class);
          finish();
          break label480;
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(68316);
    if ((paramp instanceof s))
    {
      Log.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (s)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.Ojg;
        Log.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, retcode: %s, retmsg: %s, exposesureInfo: %s", new Object[] { Integer.valueOf(paramString.hAV), paramString.wYI, paramString.VIz });
        if (paramString.hAV != 0) {}
      }
      for (;;)
      {
        try
        {
          getInput().putByteArray("key_succpage_resp", paramString.toByteArray());
          ca(RemittanceResultNewUI.class);
          finish();
          AppMethodBeat.o(68316);
          return true;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.RemittanceResultUI", paramString, "pass succ page resp error: %s", new Object[] { paramString.getMessage() });
          continue;
        }
        Toast.makeText(this, paramString.wYI, 1).show();
        ca(RemittanceResultNewUI.class);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultUI
 * JD-Core Version:    0.7.0.1
 */