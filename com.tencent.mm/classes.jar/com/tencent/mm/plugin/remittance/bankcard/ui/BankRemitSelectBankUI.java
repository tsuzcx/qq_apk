package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.iv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class BankRemitSelectBankUI
  extends BankRemitBaseUI
{
  private BankRemitSortView Iio;
  
  public int getLayoutId()
  {
    return a.g.bank_remit_select_bank_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67581);
    this.Iio = ((BankRemitSortView)findViewById(a.f.brsb_sort_view));
    this.Iio.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67576);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitSelectBankUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        paramAnonymousAdapterView = (iv)((d)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt)).bnW;
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousAdapterView = new BankcardElemParcel(paramAnonymousAdapterView);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_bank_card_elem_parcel", paramAnonymousAdapterView);
          BankRemitSelectBankUI.this.setResult(-1, paramAnonymousView);
          BankRemitSelectBankUI.this.finish();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitSelectBankUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(67576);
          return;
          Log.w("MicroMsg.BankRemitSelectBankUI", "bankcardelem is null, : %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        }
      }
    });
    AppMethodBeat.o(67581);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67580);
    super.onCreate(paramBundle);
    setMMTitle(a.i.bank_remit_select_bank_title);
    addSceneEndListener(1399);
    initView();
    Log.i("MicroMsg.BankRemitSelectBankUI", "do fetch data");
    paramBundle = new h();
    paramBundle.u(this);
    doSceneProgress(paramBundle);
    AppMethodBeat.o(67580);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67583);
    super.onDestroy();
    removeSceneEndListener(1399);
    AppMethodBeat.o(67583);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(67582);
    if ((paramq instanceof h))
    {
      paramString = (h)paramq;
      paramString.a(new r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67579);
          paramAnonymousq = new ArrayList();
          Object localObject2 = paramString.IfI.Tbz;
          paramAnonymousString = paramString.IfI.Tby;
          Object localObject1 = new com.tencent.mm.plugin.remittance.bankcard.model.b();
          Object localObject3;
          if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
          {
            Log.i("MicroMsg.BankRemitSelectBankUI", "freq card count: %s", new Object[] { Integer.valueOf(paramAnonymousString.size()) });
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (iv)((Iterator)localObject2).next();
              d locald = new d();
              locald.Wtr = "☆";
              locald.bnW = localObject3;
              paramAnonymousq.add(locald);
            }
          }
          if ((paramAnonymousString != null) && (!paramAnonymousString.isEmpty()))
          {
            Log.i("MicroMsg.BankRemitSelectBankUI", "card count: %s", new Object[] { Integer.valueOf(paramAnonymousString.size()) });
            Collections.sort(paramAnonymousString, (Comparator)localObject1);
            localObject1 = paramAnonymousString.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (iv)((Iterator)localObject1).next();
              if (!Util.isNullOrNil(((iv)localObject2).DNV))
              {
                if (!Util.isNullOrNil(((iv)localObject2).ROJ)) {
                  Log.i("MicroMsg.BankRemitSelectBankUI", "use sort pingyin: %s", new Object[] { ((iv)localObject2).ROJ });
                }
                for (paramAnonymousString = ((iv)localObject2).ROJ.toUpperCase().charAt(0);; paramAnonymousString = com.tencent.mm.plugin.remittance.bankcard.model.a.aWy(((iv)localObject2).DNV))
                {
                  localObject3 = new d();
                  ((d)localObject3).Wtr = paramAnonymousString;
                  ((d)localObject3).bnW = localObject2;
                  paramAnonymousq.add(localObject3);
                  break;
                }
              }
            }
          }
          BankRemitSelectBankUI.a(BankRemitSelectBankUI.this).ig(paramAnonymousq);
          AppMethodBeat.o(67579);
        }
      }).b(new r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67578);
          Log.e("MicroMsg.BankRemitSelectBankUI", "response error: %s, %s", new Object[] { Integer.valueOf(paramString.IfI.fwx), paramString.IfI.tVo });
          if (!Util.isNullOrNil(paramString.IfI.tVo)) {
            Toast.makeText(BankRemitSelectBankUI.this, paramString.IfI.tVo, 1).show();
          }
          AppMethodBeat.o(67578);
        }
      }).c(new r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67577);
          Log.e("MicroMsg.BankRemitSelectBankUI", "net error: %s", new Object[] { paramString });
          AppMethodBeat.o(67577);
        }
      });
    }
    AppMethodBeat.o(67582);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectBankUI
 * JD-Core Version:    0.7.0.1
 */