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
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.t;
import java.util.List;

public class MallProductReceiptUI
  extends MallBaseUI
{
  private d xdD = null;
  private AutoCompleteTextView xdE = null;
  private h xdF = null;
  private c xdn;
  
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
        if (!bu.isNullOrNil(paramAnonymousMenuItem))
        {
          c localc = MallProductReceiptUI.b(MallProductReceiptUI.this);
          localc.xbC = new csg();
          csg localcsg = localc.xbC;
          if (bu.isNullOrNil(paramAnonymousMenuItem))
          {
            localcsg.HDu = i;
            localc.xbC.urL = paramAnonymousMenuItem;
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
    this.xdE = ((AutoCompleteTextView)findViewById(2131302096));
    csg localcsg = this.xdn.dCR();
    if ((localcsg != null) && (!bu.isNullOrNil(localcsg.urL))) {
      this.xdE.setText(localcsg.urL);
    }
    this.xdE.setSelection(this.xdE.getText().length());
    this.xdF = new h(this);
    this.xdE.setAdapter(this.xdF);
    this.xdE.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66997);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductReceiptUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        paramAnonymousAdapterView = MallProductReceiptUI.c(MallProductReceiptUI.this);
        if ((paramAnonymousAdapterView.xbN != null) && (paramAnonymousInt < paramAnonymousAdapterView.xbN.size())) {}
        for (paramAnonymousAdapterView = (String)paramAnonymousAdapterView.xbN.get(paramAnonymousInt);; paramAnonymousAdapterView = null)
        {
          ae.d("MicroMsg.MallProductReceiptUI", "onItemClick receipt = ".concat(String.valueOf(paramAnonymousAdapterView)));
          if (!bu.isNullOrNil(paramAnonymousAdapterView)) {
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductReceiptUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = MallProductReceiptUI.c(MallProductReceiptUI.this);
        paramAnonymousView.xbN.clear();
        paramAnonymousView.dDe();
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
    this.xdD = com.tencent.mm.plugin.product.a.a.dCJ().dCL();
    com.tencent.mm.plugin.product.a.a.dCJ();
    this.xdn = com.tencent.mm.plugin.product.a.a.dCK();
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