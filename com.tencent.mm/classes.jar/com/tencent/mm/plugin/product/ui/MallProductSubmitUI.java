package com.tencent.mm.plugin.product.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.product.b.b;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bjm;
import com.tencent.mm.protocal.c.cm;
import com.tencent.mm.protocal.c.wi;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MallProductSubmitUI
  extends MallBaseUI
  implements x.a
{
  private Button frP;
  private TextView haW;
  private com.tencent.mm.plugin.product.b.e mSe;
  private com.tencent.mm.plugin.product.b.c mTL;
  private RelativeLayout mUL;
  private TextView mUM;
  private TextView mUN;
  private MallProductItemView mUO;
  private MallProductItemView mUP;
  private TextView mUQ;
  private TextView mUR;
  private TextView mUS;
  private TextView mUT;
  private ListView mUU;
  private a mUV;
  private ImageView mUn;
  private TextView mUo;
  private f mUu;
  
  private void aZ()
  {
    m localm = this.mTL.mRP;
    Object localObject1;
    label182:
    String str;
    if (this.mSe != null)
    {
      this.mUo.setText(b.p(this.mSe.mSi, this.mSe.mSi, localm.mSu.mOZ) + " x " + this.mTL.mCount);
      if (!bk.bl(this.mTL.brR()))
      {
        localObject1 = x.a(new c(this.mTL.brR()));
        this.mUn.setImageBitmap((Bitmap)localObject1);
        x.a(this);
      }
      this.haW.setText(localm.mSu.name);
      this.mUQ.setText(this.mTL.brS());
      localObject1 = this.mTL.brV();
      if ((localObject1 == null) || (bk.bl(((bjm)localObject1).kSY))) {
        break label585;
      }
      this.mUP.setSummary(((bjm)localObject1).kSY);
      str = "";
      localObject1 = str;
      if (!this.mTL.brQ().bsm())
      {
        localObject1 = this.mTL.mRU;
        if (localObject1 == null) {
          break label597;
        }
        this.mUO.setEnabled(true);
        this.mUO.setClickable(true);
        this.mUO.setSummary(b.a(this, (wi)localObject1));
        localObject1 = getString(a.i.mall_product_submit_price_express, new Object[] { b.c(((wi)localObject1).sFS, ((wi)localObject1).sSo) });
        this.mUN.setVisibility(8);
      }
      label276:
      str = "";
      int i = this.mTL.brU();
      if (i > 0)
      {
        bk.bl((String)localObject1);
        str = getString(a.i.mall_product_submit_price_discount, new Object[] { b.c(i, localm.mSu.mOZ) });
      }
      Object localObject2 = this.mTL.I(this);
      if (((LinkedList)localObject2).size() <= 0) {
        break label640;
      }
      this.mUU.setVisibility(0);
      this.mUV.bW((List)localObject2);
      this.mUV.notifyDataSetChanged();
      label366:
      localObject2 = this.mTL.mRV;
      if (localObject2 != null) {
        this.mUM.setText(Html.fromHtml(String.format("%s %s<br><br>%s %s %s", new Object[] { ((cm)localObject2).hPY, ((cm)localObject2).svW, ((cm)localObject2).ffi, ((cm)localObject2).ffj, ((cm)localObject2).kSY })));
      }
      localObject1 = (String)localObject1 + str;
      if (bk.bl((String)localObject1)) {
        break label652;
      }
      localObject1 = getString(a.i.mall_product_submit_price_desc_more, new Object[] { localObject1 });
      this.mUR.setText((CharSequence)localObject1);
      this.mUS.setVisibility(8);
      this.mUR.setVisibility(0);
    }
    for (;;)
    {
      this.mUT.setText(b.c(this.mTL.brT(), localm.mSu.mOZ));
      this.frP.setEnabled(this.mTL.bsc());
      return;
      this.mUo.setText(b.p(localm.mSu.mSG, localm.mSu.mSH, localm.mSu.mOZ));
      break;
      label585:
      this.mUP.setSummary("");
      break label182;
      label597:
      this.mUO.setEnabled(false);
      this.mUO.setClickable(false);
      this.mUO.setSummary(getString(a.i.mall_product_submit_price_express_err));
      this.mUN.setVisibility(0);
      localObject1 = str;
      break label276;
      label640:
      this.mUU.setVisibility(8);
      break label366;
      label652:
      this.mUS.setVisibility(0);
      this.mUR.setVisibility(8);
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.product_submit_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.mall_product_submit_title);
    this.mUL = ((RelativeLayout)findViewById(a.f.mall_product_submit_address_rl));
    this.mUM = ((TextView)findViewById(a.f.mall_product_submit_address_summary_tv));
    this.mUN = ((TextView)findViewById(a.f.mall_product_submit_address_summary_err_tv));
    this.mUO = ((MallProductItemView)findViewById(a.f.mall_product_submit_express));
    this.mUP = ((MallProductItemView)findViewById(a.f.mall_product_submit_invoice));
    this.mUn = ((ImageView)findViewById(a.f.mall_product_submit_img_iv));
    this.haW = ((TextView)findViewById(a.f.mall_product_submit_title_tv));
    this.mUQ = ((TextView)findViewById(a.f.mall_product_submit_list_tv));
    this.mUo = ((TextView)findViewById(a.f.mall_product_submit_price_tv));
    this.mUR = ((TextView)findViewById(a.f.mall_product_submit_price_desc_tv));
    this.mUS = ((TextView)findViewById(a.f.mall_product_submit_price_desc_left_tv));
    this.mUT = ((TextView)findViewById(a.f.mall_product_submit_total_price_tv));
    this.mUU = ((ListView)findViewById(a.f.mall_product_submit_preferential_lv));
    this.mUV = new a(this);
    this.mUU.setAdapter(this.mUV);
    this.mUU.setOnItemClickListener(new MallProductSubmitUI.2(this));
    this.frP = ((Button)findViewById(a.f.mall_product_submit_submit));
    this.frP.setOnClickListener(new MallProductSubmitUI.3(this));
    this.mUL.setOnClickListener(new MallProductSubmitUI.4(this));
    this.mUO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        MallProductSubmitUI.this.showDialog(1);
      }
    });
    this.mUP.setOnClickListener(new MallProductSubmitUI.6(this));
    MallProductItemView localMallProductItemView = this.mUP;
    boolean bool;
    if ((this.mTL.brQ().mTI & 0x2) > 0)
    {
      bool = true;
      y.d("MicroMsg.MallProductConfig", "hasReceipt, ret = " + bool);
      if (!bool) {
        break label406;
      }
    }
    label406:
    for (int i = 0;; i = 8)
    {
      localMallProductItemView.setVisibility(i);
      if (this.mTL.brQ().bsm())
      {
        this.mUO.setEnabled(false);
        this.mUO.setClickable(false);
        this.mUO.setSummary(getString(a.i.mall_product_submit_price_express_free));
      }
      return;
      bool = false;
      break;
    }
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    paramString = new StringBuilder().append(paramString).append(", bitmap = ");
    if (paramBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.MallProductSubmitUI", bool);
      if (!bk.bl(this.mTL.brR())) {
        break;
      }
      return;
    }
    this.mUn.post(new MallProductSubmitUI.7(this, paramBitmap));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.mUu.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mUu = new f(this.mController.uMN, new MallProductSubmitUI.1(this));
    com.tencent.mm.plugin.product.a.a.brN();
    this.mTL = com.tencent.mm.plugin.product.a.a.brO();
    this.mSe = this.mTL.mSe;
    initView();
    aZ();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return super.onCreateDialog(paramInt);
      localObject2 = this.mTL.mSc;
    } while (localObject2 == null);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(b.a(this, (wi)((Iterator)localObject2).next()));
    }
    localObject2 = getString(a.i.mall_product_submit_express);
    MallProductSubmitUI.8 local8 = new MallProductSubmitUI.8(this);
    d.a locala = new d.a(this);
    ListViewInScrollView localListViewInScrollView = (ListViewInScrollView)View.inflate(this, a.g.mm_list, null);
    localListViewInScrollView.setOnItemClickListener(new d.1(local8, locala));
    locala.mTC = ((List)localObject1);
    locala.mTD = 0;
    localListViewInScrollView.setAdapter(locala);
    localObject1 = new c.a(this);
    ((c.a)localObject1).aez((String)localObject2);
    ((c.a)localObject1).ei(localListViewInScrollView);
    ((c.a)localObject1).e(null);
    localObject1 = ((c.a)localObject1).aoP();
    ((com.tencent.mm.ui.widget.a.c)localObject1).show();
    return localObject1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI
 * JD-Core Version:    0.7.0.1
 */