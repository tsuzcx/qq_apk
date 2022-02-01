package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.remittance.bankcard.b.h;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.cfa;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.wallet_core.model.r;
import com.tencent.mm.wallet_core.model.r.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class BankRemitSelectBankUI
  extends BankRemitBaseUI
{
  private BankRemitSortView OeZ;
  
  public int getLayoutId()
  {
    return a.g.bank_remit_select_bank_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67581);
    this.OeZ = ((BankRemitSortView)findViewById(a.f.brsb_sort_view));
    this.OeZ.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67576);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitSelectBankUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = (jr)((d)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt)).cpt;
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
    paramBundle.r(this);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(67582);
    if ((paramp instanceof h))
    {
      paramString = (h)paramp;
      paramString.a(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(67579);
          paramAnonymousp = new ArrayList();
          Object localObject2 = paramString.Och.aaoL;
          paramAnonymousString = paramString.Och.aaoK;
          Object localObject1 = new com.tencent.mm.plugin.remittance.bankcard.model.b();
          Object localObject3;
          if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
          {
            Log.i("MicroMsg.BankRemitSelectBankUI", "freq card count: %s", new Object[] { Integer.valueOf(paramAnonymousString.size()) });
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (jr)((Iterator)localObject2).next();
              d locald = new d();
              locald.aeaK = "☆";
              locald.cpt = localObject3;
              paramAnonymousp.add(locald);
            }
          }
          if ((paramAnonymousString != null) && (!paramAnonymousString.isEmpty()))
          {
            Log.i("MicroMsg.BankRemitSelectBankUI", "card count: %s", new Object[] { Integer.valueOf(paramAnonymousString.size()) });
            Collections.sort(paramAnonymousString, (Comparator)localObject1);
            localObject1 = paramAnonymousString.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (jr)((Iterator)localObject1).next();
              if (!Util.isNullOrNil(((jr)localObject2).JFk))
              {
                if (!Util.isNullOrNil(((jr)localObject2).YLX)) {
                  Log.i("MicroMsg.BankRemitSelectBankUI", "use sort pingyin: %s", new Object[] { ((jr)localObject2).YLX });
                }
                for (paramAnonymousString = ((jr)localObject2).YLX.toUpperCase().charAt(0);; paramAnonymousString = com.tencent.mm.plugin.remittance.bankcard.model.a.aTM(((jr)localObject2).JFk))
                {
                  localObject3 = new d();
                  ((d)localObject3).aeaK = paramAnonymousString;
                  ((d)localObject3).cpt = localObject2;
                  paramAnonymousp.add(localObject3);
                  break;
                }
              }
            }
          }
          BankRemitSelectBankUI.a(BankRemitSelectBankUI.this).lG(paramAnonymousp);
          AppMethodBeat.o(67579);
        }
      }).b(new BankRemitSelectBankUI.3(this, paramString)).c(new BankRemitSelectBankUI.2(this, paramString));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectBankUI
 * JD-Core Version:    0.7.0.1
 */