package com.tencent.mm.plugin.product.ui;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bjm;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class MallProductReceiptUI
  extends MallBaseUI
{
  private c mTL;
  private d mUb = null;
  private AutoCompleteTextView mUc = null;
  private h mUd = null;
  
  protected final int getLayoutId()
  {
    return a.g.product_receipt_ui;
  }
  
  public final void initView()
  {
    setMMTitle(a.i.mall_product_receipt_title);
    addTextOptionMenu(0, getString(a.i.app_finish), new MallProductReceiptUI.1(this));
    this.mUc = ((AutoCompleteTextView)findViewById(a.f.mall_product_receipt_actv));
    bjm localbjm = this.mTL.brV();
    if ((localbjm != null) && (!bk.bl(localbjm.kSY))) {
      this.mUc.setText(localbjm.kSY);
    }
    this.mUc.setSelection(this.mUc.getText().length());
    this.mUd = new h(this);
    this.mUc.setAdapter(this.mUd);
    this.mUc.setOnItemClickListener(new MallProductReceiptUI.2(this));
    View.inflate(this.mController.uMN, a.g.product_input_history_last_item, null).setOnClickListener(new MallProductReceiptUI.3(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mUb = a.brN().brP();
    a.brN();
    this.mTL = a.brO();
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductReceiptUI
 * JD-Core Version:    0.7.0.1
 */