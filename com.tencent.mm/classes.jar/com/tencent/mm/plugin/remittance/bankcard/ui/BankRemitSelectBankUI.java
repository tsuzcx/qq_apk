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
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.protocal.protobuf.it;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private BankRemitSortView ykv;
  
  public int getLayoutId()
  {
    return 2131493162;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67581);
    this.ykv = ((BankRemitSortView)findViewById(2131297565));
    this.ykv.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67576);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitSelectBankUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        paramAnonymousAdapterView = (it)((d)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt)).data;
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
          ae.w("MicroMsg.BankRemitSelectBankUI", "bankcardelem is null, : %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        }
      }
    });
    AppMethodBeat.o(67581);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67580);
    super.onCreate(paramBundle);
    setMMTitle(2131756397);
    addSceneEndListener(1399);
    initView();
    ae.i("MicroMsg.BankRemitSelectBankUI", "do fetch data");
    paramBundle = new h();
    paramBundle.t(this);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(67582);
    if ((paramn instanceof h))
    {
      paramString = (h)paramn;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67579);
          paramAnonymousn = new ArrayList();
          Object localObject2 = paramString.yhO.GOK;
          paramAnonymousString = paramString.yhO.GOJ;
          Object localObject1 = new com.tencent.mm.plugin.remittance.bankcard.model.b();
          Object localObject3;
          if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
          {
            ae.i("MicroMsg.BankRemitSelectBankUI", "freq card count: %s", new Object[] { Integer.valueOf(paramAnonymousString.size()) });
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (it)((Iterator)localObject2).next();
              d locald = new d();
              locald.JOY = "☆";
              locald.data = localObject3;
              paramAnonymousn.add(locald);
            }
          }
          if ((paramAnonymousString != null) && (!paramAnonymousString.isEmpty()))
          {
            ae.i("MicroMsg.BankRemitSelectBankUI", "card count: %s", new Object[] { Integer.valueOf(paramAnonymousString.size()) });
            Collections.sort(paramAnonymousString, (Comparator)localObject1);
            localObject1 = paramAnonymousString.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (it)((Iterator)localObject1).next();
              if (!bu.isNullOrNil(((it)localObject2).uVs))
              {
                if (!bu.isNullOrNil(((it)localObject2).FUg)) {
                  ae.i("MicroMsg.BankRemitSelectBankUI", "use sort pingyin: %s", new Object[] { ((it)localObject2).FUg });
                }
                for (paramAnonymousString = ((it)localObject2).FUg.toUpperCase().charAt(0);; paramAnonymousString = com.tencent.mm.plugin.remittance.bankcard.model.a.axu(((it)localObject2).uVs))
                {
                  localObject3 = new d();
                  ((d)localObject3).JOY = paramAnonymousString;
                  ((d)localObject3).data = localObject2;
                  paramAnonymousn.add(localObject3);
                  break;
                }
              }
            }
          }
          BankRemitSelectBankUI.a(BankRemitSelectBankUI.this).gB(paramAnonymousn);
          AppMethodBeat.o(67579);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67578);
          ae.e("MicroMsg.BankRemitSelectBankUI", "response error: %s, %s", new Object[] { Integer.valueOf(paramString.yhO.dmy), paramString.yhO.phe });
          if (!bu.isNullOrNil(paramString.yhO.phe)) {
            Toast.makeText(BankRemitSelectBankUI.this, paramString.yhO.phe, 1).show();
          }
          AppMethodBeat.o(67578);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67577);
          ae.e("MicroMsg.BankRemitSelectBankUI", "net error: %s", new Object[] { paramString });
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