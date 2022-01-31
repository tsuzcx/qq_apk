package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.sdk.platformtools.bo;

public class MallProductReceiptUI
  extends MallBaseUI
{
  private c pvR;
  private d pwh = null;
  private AutoCompleteTextView pwi = null;
  private h pwj = null;
  
  public int getLayoutId()
  {
    return 2130970451;
  }
  
  public void initView()
  {
    AppMethodBeat.i(44094);
    setMMTitle(2131301477);
    addTextOptionMenu(0, getString(2131296964), new MallProductReceiptUI.1(this));
    this.pwi = ((AutoCompleteTextView)findViewById(2131826798));
    bse localbse = this.pvR.cbb();
    if ((localbse != null) && (!bo.isNullOrNil(localbse.nqY))) {
      this.pwi.setText(localbse.nqY);
    }
    this.pwi.setSelection(this.pwi.getText().length());
    this.pwj = new h(this);
    this.pwi.setAdapter(this.pwj);
    this.pwi.setOnItemClickListener(new MallProductReceiptUI.2(this));
    View.inflate(getContext(), 2130970447, null).setOnClickListener(new MallProductReceiptUI.3(this));
    AppMethodBeat.o(44094);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(44093);
    super.onCreate(paramBundle);
    this.pwh = a.caT().caV();
    a.caT();
    this.pvR = a.caU();
    initView();
    AppMethodBeat.o(44093);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductReceiptUI
 * JD-Core Version:    0.7.0.1
 */