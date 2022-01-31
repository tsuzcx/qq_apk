package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.b.b;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class MallProductSelectSkuUI
  extends MallBaseUI
  implements x.a
{
  private TextView haW;
  private m mRP;
  private e mSe;
  private com.tencent.mm.plugin.product.b.c mTL;
  private ImageView mUn;
  private TextView mUo;
  private TextView mUp;
  private Button mUq;
  private ListView mUr;
  private MallProductSelectAmountView mUs = null;
  private i mUt = null;
  private f mUu;
  
  private void aZ()
  {
    if (this.mRP != null)
    {
      if ((this.mSe == null) || (this.mRP.mSu == null)) {
        break label210;
      }
      this.mUo.setText(b.p(this.mSe.mSi, this.mSe.mSj, this.mRP.mSu.mOZ));
      if (this.mRP.mSu != null) {
        this.haW.setText(this.mRP.mSu.name);
      }
    }
    if (!bk.bl(this.mTL.brR()))
    {
      localObject = x.a(new c(this.mTL.brR()));
      this.mUn.setImageBitmap((Bitmap)localObject);
      x.a(this);
    }
    this.mUp.setVisibility(8);
    Object localObject = this.mUs;
    int i = this.mTL.brZ();
    int j = this.mTL.mRP.mSt;
    if (i > j) {
      ((MallProductSelectAmountView)localObject).mUi = 3;
    }
    for (((MallProductSelectAmountView)localObject).mUh = j;; ((MallProductSelectAmountView)localObject).mUh = i)
    {
      ((MallProductSelectAmountView)localObject).bsp();
      if (((MallProductSelectAmountView)localObject).mUl != null) {
        ((MallProductSelectAmountView)localObject).mUl.ex(((MallProductSelectAmountView)localObject).mUk);
      }
      this.mUt.notifyDataSetChanged();
      return;
      label210:
      this.mUo.setText(b.p(this.mRP.mSu.mSG, this.mRP.mSu.mSH, this.mRP.mSu.mOZ));
      break;
      ((MallProductSelectAmountView)localObject).mUi = 1;
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.product_select_sku_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.mall_product_select_sku_title);
    this.mUn = ((ImageView)findViewById(a.f.mall_product_select_sku_img_iv));
    this.haW = ((TextView)findViewById(a.f.mall_product_select_sku_title_tv));
    this.mUo = ((TextView)findViewById(a.f.mall_product_select_sku_price_tv));
    this.mUp = ((TextView)findViewById(a.f.mall_product_select_sku_err));
    this.mUq = ((Button)findViewById(a.f.mall_product_select_sku_pre_submit));
    this.mUr = ((ListView)findViewById(a.f.mall_product_sku_lv));
    this.mUs = ((MallProductSelectAmountView)findViewById(a.f.select_amount));
    this.mUs.setAmount(this.mTL.mCount);
    this.mUt = new i(this);
    if ((this.mRP != null) && (this.mRP.mSu != null) && (this.mRP.mSu.mSO != null)) {
      this.mUt.mUw = this.mRP.mSu.mSO;
    }
    for (;;)
    {
      this.mUt.mUx = new MallProductSelectSkuUI.2(this);
      this.mUr.setAdapter(this.mUt);
      this.mUs.setOnAmountChangeListener(new MallProductSelectSkuUI.3(this));
      this.mUq.setOnClickListener(new MallProductSelectSkuUI.4(this));
      this.mUn.setFocusable(true);
      this.mUn.setFocusableInTouchMode(true);
      this.mUn.requestFocus();
      return;
      y.e("MicroMsg.MallProductSelectSkuUI", "Illage mProductInfo.base_attr.sku_table");
    }
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    paramString = new StringBuilder().append(paramString).append(", bitmap = ");
    if (paramBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.MallProductSelectSkuUI", bool);
      if (!bk.bl(this.mTL.brR())) {
        break;
      }
      return;
    }
    this.mUn.post(new MallProductSelectSkuUI.5(this, paramBitmap));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.mUu.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mUu = new f(this.mController.uMN, new MallProductSelectSkuUI.1(this));
    a.brN();
    this.mTL = a.brO();
    this.mRP = this.mTL.mRP;
    initView();
    aZ();
  }
  
  public void onStart()
  {
    this.mUu.onStart();
    super.onStart();
  }
  
  protected void onStop()
  {
    this.mUu.onStop();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI
 * JD-Core Version:    0.7.0.1
 */