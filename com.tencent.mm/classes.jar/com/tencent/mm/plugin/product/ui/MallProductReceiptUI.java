package com.tencent.mm.plugin.product.ui;

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
import com.tencent.mm.plugin.product.model.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.ems;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import java.util.List;

public class MallProductReceiptUI
  extends MallBaseUI
{
  private c MSF = null;
  private AutoCompleteTextView MSG = null;
  private h MSH = null;
  private com.tencent.mm.plugin.product.model.b MSp;
  
  public int getLayoutId()
  {
    return a.g.product_receipt_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67000);
    setMMTitle(a.i.mall_product_receipt_title);
    addTextOptionMenu(0, getString(a.i.app_finish), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        int i = 0;
        AppMethodBeat.i(66996);
        paramAnonymousMenuItem = MallProductReceiptUI.a(MallProductReceiptUI.this).getText().toString();
        if (!Util.isNullOrNil(paramAnonymousMenuItem))
        {
          com.tencent.mm.plugin.product.model.b localb = MallProductReceiptUI.b(MallProductReceiptUI.this);
          localb.MQG = new ems();
          ems localems = localb.MQG;
          if (Util.isNullOrNil(paramAnonymousMenuItem))
          {
            localems.abrc = i;
            localb.MQG.IIu = paramAnonymousMenuItem;
            MallProductReceiptUI.this.finish();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(66996);
          return true;
          i = 1;
          break;
          aa.makeText(MallProductReceiptUI.this, a.i.mall_product_receipt_empty_tips, 0).show();
        }
      }
    });
    this.MSG = ((AutoCompleteTextView)findViewById(a.f.mall_product_receipt_actv));
    ems localems = this.MSp.gAg();
    if ((localems != null) && (!Util.isNullOrNil(localems.IIu))) {
      this.MSG.setText(localems.IIu);
    }
    this.MSG.setSelection(this.MSG.getText().length());
    this.MSH = new h(this);
    this.MSG.setAdapter(this.MSH);
    this.MSG.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66997);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductReceiptUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = MallProductReceiptUI.c(MallProductReceiptUI.this);
        if ((paramAnonymousAdapterView.MQR != null) && (paramAnonymousInt < paramAnonymousAdapterView.MQR.size())) {}
        for (paramAnonymousAdapterView = (String)paramAnonymousAdapterView.MQR.get(paramAnonymousInt);; paramAnonymousAdapterView = null)
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
    View.inflate(getContext(), a.g.product_input_history_last_item, null).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66998);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductReceiptUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = MallProductReceiptUI.c(MallProductReceiptUI.this);
        paramAnonymousView.MQR.clear();
        paramAnonymousView.gAt();
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
    this.MSF = com.tencent.mm.plugin.product.a.a.gzY().gAa();
    com.tencent.mm.plugin.product.a.a.gzY();
    this.MSp = com.tencent.mm.plugin.product.a.a.gzZ();
    initView();
    AppMethodBeat.o(66999);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductReceiptUI
 * JD-Core Version:    0.7.0.1
 */