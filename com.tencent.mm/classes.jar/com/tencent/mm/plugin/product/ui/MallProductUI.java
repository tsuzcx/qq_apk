package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextPaint;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.h.a.mp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class MallProductUI
  extends MallBaseUI
  implements x.a
{
  private Button frP;
  private TextView iIV;
  protected com.tencent.mm.plugin.product.b.c mTL;
  private HtmlTextView mTr;
  private ListView mUU;
  private a mUV;
  private LinearLayout mUX;
  private LinearLayout mUY;
  private ImageView mUZ;
  private TextView mUo;
  private f mUu;
  private TextView mVa;
  private HtmlTextView mVb;
  private RelativeLayout mVc;
  private ListView mVd;
  private k mVe = null;
  private Button mVf;
  
  protected final void aZ()
  {
    Object localObject = this.mTL.mRP;
    if (localObject == null)
    {
      showOptionMenu(false);
      return;
    }
    showOptionMenu(true);
    vN(0);
    this.mUX.setVisibility(0);
    this.mUY.setVisibility(8);
    if (((m)localObject).mSu != null)
    {
      this.iIV.setText(((m)localObject).mSu.name);
      this.mUo.setText(com.tencent.mm.plugin.product.b.b.p(((m)localObject).mSu.mSG, ((m)localObject).mSu.mSH, ((m)localObject).mSu.mOZ));
      this.mVa.setText(com.tencent.mm.plugin.product.b.b.c(((m)localObject).mSu.mSF, ((m)localObject).mSu.mOZ));
    }
    if (this.mTL.brZ() <= 0)
    {
      this.frP.setEnabled(false);
      this.frP.setText(a.i.mall_product_sold_out);
      label150:
      if ((((m)localObject).mSu == null) || (((m)localObject).mSu.mSP == null) || (((m)localObject).mSu.mSP.size() <= 0)) {
        break label417;
      }
      this.mUU.setVisibility(0);
      this.mUV.bW(((m)localObject).mSu.mSP);
      this.mUV.notifyDataSetChanged();
      label209:
      if ((((m)localObject).mSu == null) || (bk.bl(((m)localObject).mSu.detail))) {
        break label429;
      }
      this.mVc.setVisibility(0);
      this.mTr.setVisibility(0);
      this.mTr.setText(((m)localObject).mSu.detail);
      label259:
      if (bk.bl(((m)localObject).mSA)) {
        break label450;
      }
      this.mVb.setVisibility(0);
      this.mVb.setText(((m)localObject).mSA);
    }
    for (;;)
    {
      showOptionMenu(true);
      if (bk.bl(this.mTL.mRX)) {
        break;
      }
      localObject = x.a(new c(this.mTL.mRX));
      this.mUZ.setImageBitmap((Bitmap)localObject);
      x.a(this);
      return;
      if (this.mTL.mRP.mSt <= 0)
      {
        this.frP.setEnabled(false);
        this.frP.setText(a.i.mall_product_sold_limit);
        break label150;
      }
      this.frP.setEnabled(true);
      if (!bk.bl(((m)localObject).mSz))
      {
        this.frP.setText(((m)localObject).mSz);
        break label150;
      }
      this.frP.setText(a.i.mall_product_go_sku_list);
      break label150;
      label417:
      this.mUU.setVisibility(8);
      break label209;
      label429:
      this.mVc.setVisibility(8);
      this.mTr.setVisibility(8);
      break label259;
      label450:
      this.mVb.setVisibility(8);
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.product_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.mall_product_title);
    setBackBtn(new MallProductUI.2(this));
    this.mUX = ((LinearLayout)findViewById(a.f.mall_product_normal_ll));
    this.mUY = ((LinearLayout)findViewById(a.f.mall_product_sold_out_ll));
    this.mUZ = ((ImageView)findViewById(a.f.mall_product_img));
    this.iIV = ((TextView)findViewById(a.f.mall_product_desc));
    this.mUo = ((TextView)findViewById(a.f.mall_product_price));
    this.mVa = ((TextView)findViewById(a.f.mall_product_org_price));
    this.mVa.getPaint().setFlags(16);
    this.mVc = ((RelativeLayout)findViewById(a.f.mall_product_detail_rl));
    this.mTr = ((HtmlTextView)findViewById(a.f.mall_product_detail));
    this.mVb = ((HtmlTextView)findViewById(a.f.mall_product_oss_info));
    this.mUU = ((ListView)findViewById(a.f.mall_product_actions_lv));
    this.mUV = new a(this);
    this.mUU.setAdapter(this.mUV);
    this.mUU.setOnItemClickListener(new MallProductUI.3(this));
    this.mVf = ((Button)findViewById(a.f.mall_product_seller_btn));
    this.mVf.setOnClickListener(new MallProductUI.4(this));
    this.mVd = ((ListView)findViewById(a.f.mall_product_sold_out_lv));
    this.mVe = new k(this);
    this.mVe.mUx = new MallProductUI.5(this);
    this.mVd.setAdapter(this.mVe);
    this.frP = ((Button)findViewById(a.f.mall_product_go_sku_list));
    this.frP.setOnClickListener(new MallProductUI.6(this));
    addIconOptionMenu(0, a.e.mm_title_btn_menu, new MallProductUI.7(this));
    showOptionMenu(false);
    this.mUZ.setFocusable(true);
    this.mUZ.setFocusableInTouchMode(true);
    this.mUZ.requestFocus();
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    if ((paramString != null) && (paramString.equals(this.mTL.mRX))) {
      this.mUZ.post(new MallProductUI.8(this, paramBitmap));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    vN(8);
    boolean bool = getIntent().getBooleanExtra("key_go_finish", false);
    setResult(-1);
    if (bool)
    {
      finish();
      return;
    }
    initView();
    com.tencent.mm.plugin.product.a.a.brN();
    this.mTL = com.tencent.mm.plugin.product.a.a.brO();
    this.mUu = new f(this.mController.uMN, new MallProductUI.1(this));
    paramBundle = this.mUu;
    Object localObject = getIntent();
    m localm = new m();
    g.DS().a(new f.1(paramBundle, (Intent)localObject, localm));
    paramBundle.mTJ = true;
    localObject = new mp();
    ((mp)localObject).bWa.errCode = -1;
    ((mp)localObject).bFJ = new f.2(paramBundle, (mp)localObject);
    com.tencent.mm.sdk.b.a.udP.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    y.v("MicroMsg.MallProductUI", "onNewIntent");
    setIntent(paramIntent);
  }
  
  protected void onPause()
  {
    this.mUu.onStop();
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.mUu.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI
 * JD-Core Version:    0.7.0.1
 */