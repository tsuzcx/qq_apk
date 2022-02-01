package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.t;
import java.util.List;

public class MallProductReceiptUI
  extends MallBaseUI
{
  private d wNP = null;
  private AutoCompleteTextView wNQ = null;
  private h wNR = null;
  private c wNz;
  
  public int getLayoutId()
  {
    return 2131495124;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67000);
    setMMTitle(2131761124);
    addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        int i = 0;
        AppMethodBeat.i(66996);
        paramAnonymousMenuItem = MallProductReceiptUI.a(MallProductReceiptUI.this).getText().toString();
        if (!bt.isNullOrNil(paramAnonymousMenuItem))
        {
          c localc = MallProductReceiptUI.b(MallProductReceiptUI.this);
          localc.wLO = new crm();
          crm localcrm = localc.wLO;
          if (bt.isNullOrNil(paramAnonymousMenuItem))
          {
            localcrm.HjU = i;
            localc.wLO.ugo = paramAnonymousMenuItem;
            MallProductReceiptUI.this.finish();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(66996);
          return true;
          i = 1;
          break;
          t.makeText(MallProductReceiptUI.this, 2131761123, 0).show();
        }
      }
    });
    this.wNQ = ((AutoCompleteTextView)findViewById(2131302096));
    crm localcrm = this.wNz.dzA();
    if ((localcrm != null) && (!bt.isNullOrNil(localcrm.ugo))) {
      this.wNQ.setText(localcrm.ugo);
    }
    this.wNQ.setSelection(this.wNQ.getText().length());
    this.wNR = new h(this);
    this.wNQ.setAdapter(this.wNR);
    this.wNQ.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66997);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductReceiptUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousAdapterView = MallProductReceiptUI.c(MallProductReceiptUI.this);
        if ((paramAnonymousAdapterView.wLZ != null) && (paramAnonymousInt < paramAnonymousAdapterView.wLZ.size())) {}
        for (paramAnonymousAdapterView = (String)paramAnonymousAdapterView.wLZ.get(paramAnonymousInt);; paramAnonymousAdapterView = null)
        {
          ad.d("MicroMsg.MallProductReceiptUI", "onItemClick receipt = ".concat(String.valueOf(paramAnonymousAdapterView)));
          if (!bt.isNullOrNil(paramAnonymousAdapterView)) {
            MallProductReceiptUI.a(MallProductReceiptUI.this).setText(paramAnonymousAdapterView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductReceiptUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(66997);
          return;
        }
      }
    });
    View.inflate(getContext(), 2131495120, null).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66998);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductReceiptUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = MallProductReceiptUI.c(MallProductReceiptUI.this);
        paramAnonymousView.wLZ.clear();
        paramAnonymousView.dzN();
        MallProductReceiptUI.d(MallProductReceiptUI.this).notifyDataSetChanged();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductReceiptUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(66998);
      }
    });
    AppMethodBeat.o(67000);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66999);
    super.onCreate(paramBundle);
    this.wNP = com.tencent.mm.plugin.product.a.a.dzs().dzu();
    com.tencent.mm.plugin.product.a.a.dzs();
    this.wNz = com.tencent.mm.plugin.product.a.a.dzt();
    initView();
    AppMethodBeat.o(66999);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductReceiptUI
 * JD-Core Version:    0.7.0.1
 */