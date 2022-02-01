package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.gu;
import com.tencent.mm.plugin.remittance.model.r;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.List;

@a(3)
public class RemittanceResultUI
  extends WalletBaseUI
{
  private Orders Ivh;
  
  private void bq(Class<?> paramClass)
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
  
  protected boolean fBc()
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
    if (fBc())
    {
      setContentViewVisibility(4);
      getWindow().setBackgroundDrawableResource(a.c.transparent);
      this.Ivh = ((Orders)getInput().getParcelable("key_orders"));
      localPayInfo = (PayInfo)getInput().getParcelable("key_pay_info");
      if (localPayInfo == null) {
        break label699;
      }
    }
    label640:
    label653:
    label662:
    label675:
    label699:
    for (int i = localPayInfo.fOY;; i = 0)
    {
      boolean bool1;
      boolean bool2;
      label97:
      Object localObject1;
      if ((i == 31) || (i == 5))
      {
        bool1 = false;
        if (this.Ivh != null) {
          break label634;
        }
        bool2 = true;
        Log.i("MicroMsg.RemittanceResultUI", "orders==null:%s, paysScene: %s, needFetchF2fData: %s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), Boolean.valueOf(bool1) });
        if (this.Ivh == null) {
          break label662;
        }
        Log.i("MicroMsg.RemittanceResultUI", "is_use_new_paid_succ_page: %s", new Object[] { Integer.valueOf(this.Ivh.ORn) });
        if (this.Ivh.ORn != 1) {
          break label653;
        }
        if (!bool1) {
          break label662;
        }
        Object localObject2 = this.Ivh;
        if ((localPayInfo == null) || (localPayInfo.lfu == null)) {
          break label640;
        }
        Log.i("MicroMsg.RemittanceResultUI", "fetch f2f data");
        String str1 = localPayInfo.lfu.getString("extinfo_key_11");
        localObject1 = "";
        paramBundle = (Bundle)localObject1;
        if (localObject2 != null)
        {
          paramBundle = (Bundle)localObject1;
          if (((Orders)localObject2).ORd.size() > 0) {
            paramBundle = ((Orders.Commodity)((Orders)localObject2).ORd.get(0)).fww;
          }
        }
        i = localPayInfo.lfu.getInt("extinfo_key_15", 0);
        String str2 = localPayInfo.lfu.getString("extinfo_key_7");
        String str3 = localPayInfo.lfu.getString("extinfo_key_3");
        int j = localPayInfo.lfu.getInt("extinfo_key_12", 0);
        String str4 = localPayInfo.lfu.getString("extinfo_key_13");
        String str5 = localPayInfo.lfu.getString("extinfo_key_14");
        localObject2 = localPayInfo.lfu.getString("extinfo_key_16");
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2)) {
          localObject1 = paramBundle;
        }
        Log.i("MicroMsg.RemittanceResultUI", "fetchF2fData, f2fid: %s, transid: %s, amount: %s, payerDesc: %s, recvDesc: %s, scanScene: %s, paySuccSign: %s, paySuccExtend: %s, channel: %s, payscene: %s", new Object[] { str1, localObject1, Integer.valueOf(i), str2, str3, Integer.valueOf(j), str4, str5, Integer.valueOf(localPayInfo.channel), Integer.valueOf(localPayInfo.fOY) });
        addSceneEndListener(2773);
        doSceneProgress(new r(str1, (String)localObject1, i, str2, str3, localPayInfo.channel, j, str4, str5));
        label480:
        i = 0;
        paramBundle = (PayInfo)getInput().getParcelable("key_pay_info");
        if (paramBundle != null) {
          i = paramBundle.fOY;
        }
        if ((i == 33) || (i == 32) || (i == 48) || (i == 31))
        {
          localObject1 = new gu();
          ((gu)localObject1).fDj.fwv = paramBundle.fwv;
          if (i != 31) {
            break label675;
          }
        }
      }
      for (((gu)localObject1).fDj.type = 0;; ((gu)localObject1).fDj.type = 1) {
        label634:
        do
        {
          if ((this.Ivh != null) && (!this.Ivh.ORd.isEmpty())) {
            ((gu)localObject1).fDj.fww = ((Orders.Commodity)this.Ivh.ORd.get(0)).fww;
          }
          EventCenter.instance.publish((IEvent)localObject1);
          AppMethodBeat.o(68314);
          return;
          bool1 = true;
          break;
          bool2 = false;
          break label97;
          bq(RemittanceResultNewUI.class);
          finish();
          break label480;
          bq(RemittanceResultOldUI.class);
          break label480;
          bq(RemittanceResultNewUI.class);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(68316);
    if ((paramq instanceof r))
    {
      Log.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (r)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.IlP;
        Log.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, retcode: %s, retmsg: %s, exposesureInfo: %s", new Object[] { Integer.valueOf(paramString.fwx), paramString.tVo, paramString.OSs });
        if (paramString.fwx != 0) {}
      }
      for (;;)
      {
        try
        {
          getInput().putByteArray("key_succpage_resp", paramString.toByteArray());
          bq(RemittanceResultNewUI.class);
          finish();
          AppMethodBeat.o(68316);
          return true;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.RemittanceResultUI", paramString, "pass succ page resp error: %s", new Object[] { paramString.getMessage() });
          continue;
        }
        Toast.makeText(this, paramString.tVo, 1).show();
        bq(RemittanceResultNewUI.class);
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