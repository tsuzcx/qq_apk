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
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.protocal.protobuf.cml;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.t;
import java.util.List;

public class MallProductReceiptUI
  extends MallBaseUI
{
  private d vGI = null;
  private AutoCompleteTextView vGJ = null;
  private h vGK = null;
  private c vGs;
  
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
        if (!bs.isNullOrNil(paramAnonymousMenuItem))
        {
          c localc = MallProductReceiptUI.b(MallProductReceiptUI.this);
          localc.vEI = new cml();
          cml localcml = localc.vEI;
          if (bs.isNullOrNil(paramAnonymousMenuItem))
          {
            localcml.FzM = i;
            localc.vEI.tiv = paramAnonymousMenuItem;
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
    this.vGJ = ((AutoCompleteTextView)findViewById(2131302096));
    cml localcml = this.vGs.doY();
    if ((localcml != null) && (!bs.isNullOrNil(localcml.tiv))) {
      this.vGJ.setText(localcml.tiv);
    }
    this.vGJ.setSelection(this.vGJ.getText().length());
    this.vGK = new h(this);
    this.vGJ.setAdapter(this.vGK);
    this.vGJ.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66997);
        paramAnonymousAdapterView = MallProductReceiptUI.c(MallProductReceiptUI.this);
        if ((paramAnonymousAdapterView.vET != null) && (paramAnonymousInt < paramAnonymousAdapterView.vET.size())) {}
        for (paramAnonymousAdapterView = (String)paramAnonymousAdapterView.vET.get(paramAnonymousInt);; paramAnonymousAdapterView = null)
        {
          ac.d("MicroMsg.MallProductReceiptUI", "onItemClick receipt = ".concat(String.valueOf(paramAnonymousAdapterView)));
          if (!bs.isNullOrNil(paramAnonymousAdapterView)) {
            MallProductReceiptUI.a(MallProductReceiptUI.this).setText(paramAnonymousAdapterView);
          }
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
        paramAnonymousView = MallProductReceiptUI.c(MallProductReceiptUI.this);
        paramAnonymousView.vET.clear();
        paramAnonymousView.dpl();
        MallProductReceiptUI.d(MallProductReceiptUI.this).notifyDataSetChanged();
        AppMethodBeat.o(66998);
      }
    });
    AppMethodBeat.o(67000);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66999);
    super.onCreate(paramBundle);
    this.vGI = a.doQ().doS();
    a.doQ();
    this.vGs = a.doR();
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