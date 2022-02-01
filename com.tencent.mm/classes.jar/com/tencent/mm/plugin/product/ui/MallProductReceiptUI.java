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
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import java.util.List;

public class MallProductReceiptUI
  extends MallBaseUI
{
  private c BaP;
  private d Bbf = null;
  private AutoCompleteTextView Bbg = null;
  private h Bbh = null;
  
  public int getLayoutId()
  {
    return 2131495967;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67000);
    setMMTitle(2131762911);
    addTextOptionMenu(0, getString(2131755858), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        int i = 0;
        AppMethodBeat.i(66996);
        paramAnonymousMenuItem = MallProductReceiptUI.a(MallProductReceiptUI.this).getText().toString();
        if (!Util.isNullOrNil(paramAnonymousMenuItem))
        {
          c localc = MallProductReceiptUI.b(MallProductReceiptUI.this);
          localc.AZe = new dki();
          dki localdki = localc.AZe;
          if (Util.isNullOrNil(paramAnonymousMenuItem))
          {
            localdki.MOm = i;
            localc.AZe.xKd = paramAnonymousMenuItem;
            MallProductReceiptUI.this.finish();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(66996);
          return true;
          i = 1;
          break;
          u.makeText(MallProductReceiptUI.this, 2131762910, 0).show();
        }
      }
    });
    this.Bbg = ((AutoCompleteTextView)findViewById(2131304435));
    dki localdki = this.BaP.eDj();
    if ((localdki != null) && (!Util.isNullOrNil(localdki.xKd))) {
      this.Bbg.setText(localdki.xKd);
    }
    this.Bbg.setSelection(this.Bbg.getText().length());
    this.Bbh = new h(this);
    this.Bbg.setAdapter(this.Bbh);
    this.Bbg.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66997);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductReceiptUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousAdapterView = MallProductReceiptUI.c(MallProductReceiptUI.this);
        if ((paramAnonymousAdapterView.AZp != null) && (paramAnonymousInt < paramAnonymousAdapterView.AZp.size())) {}
        for (paramAnonymousAdapterView = (String)paramAnonymousAdapterView.AZp.get(paramAnonymousInt);; paramAnonymousAdapterView = null)
        {
          Log.d("MicroMsg.MallProductReceiptUI", "onItemClick receipt = ".concat(String.valueOf(paramAnonymousAdapterView)));
          if (!Util.isNullOrNil(paramAnonymousAdapterView)) {
            MallProductReceiptUI.a(MallProductReceiptUI.this).setText(paramAnonymousAdapterView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductReceiptUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(66997);
          return;
        }
      }
    });
    View.inflate(getContext(), 2131495963, null).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66998);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductReceiptUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = MallProductReceiptUI.c(MallProductReceiptUI.this);
        paramAnonymousView.AZp.clear();
        paramAnonymousView.eDw();
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
    this.Bbf = com.tencent.mm.plugin.product.a.a.eDb().eDd();
    com.tencent.mm.plugin.product.a.a.eDb();
    this.BaP = com.tencent.mm.plugin.product.a.a.eDc();
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