package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.n;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.o;
import com.tencent.mm.plugin.scanner.a.j;
import com.tencent.mm.plugin.scanner.util.o.a;
import com.tencent.mm.plugin.scanner.util.o.a.a;
import com.tencent.mm.plugin.scanner.util.o.a.a.a;
import com.tencent.mm.plugin.scanner.util.o.a.a.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductFurtherInfoUI
  extends MMPreference
{
  private ViewPager FK;
  protected f hcp;
  private MMPageControlView nJN;
  private o.a.a nJO;
  private String nJP;
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public final int axE()
  {
    return R.i.product_further_info_header;
  }
  
  protected final int getLayoutId()
  {
    return R.i.product_further_info;
  }
  
  protected final void initView()
  {
    int j = 0;
    setMMTitle(getIntent().getStringExtra("key_title"));
    setBackBtn(new ProductFurtherInfoUI.1(this));
    addIconOptionMenu(0, R.g.mm_title_btn_menu, new ProductFurtherInfoUI.2(this));
    this.hcp = this.vdd;
    Object localObject1 = new ArrayList();
    Object localObject2 = this.nJO.nPT.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(((o.a.a.a)((Iterator)localObject2).next()).eAl);
    }
    this.FK = ((ViewPager)findViewById(R.h.pager));
    this.nJN = ((MMPageControlView)findViewById(R.h.indicator));
    this.nJN.setIndicatorLayoutRes(R.i.page_control_image);
    this.nJN.setVisibility(0);
    this.FK.setOnTouchListener(new ProductFurtherInfoUI.3(this));
    this.FK.setOnPageChangeListener(new ProductFurtherInfoUI.4(this));
    localObject2 = new ProductFurtherInfoUI.a(this, this);
    this.FK.setAdapter((n)localObject2);
    int i = j;
    if (((List)localObject1).size() > 0)
    {
      ((ProductFurtherInfoUI.a)localObject2).nJS = ((List)localObject1);
      ((ProductFurtherInfoUI.a)localObject2).nJQ.nJN.fr(((List)localObject1).size(), 0);
      ((ProductFurtherInfoUI.a)localObject2).notifyDataSetChanged();
      this.FK.setVisibility(0);
      i = j;
    }
    while (i < this.nJO.nPU.size())
    {
      localObject1 = (o.a.a.b)this.nJO.nPU.get(i);
      localObject2 = new Preference(this);
      ((Preference)localObject2).setKey(String.valueOf(i));
      ((Preference)localObject2).setLayoutResource(R.i.multiline_text_preference);
      ((Preference)localObject2).setTitle(((o.a.a.b)localObject1).title);
      ((Preference)localObject2).setSummary(((o.a.a.b)localObject1).desc);
      this.hcp.a((Preference)localObject2);
      i += 1;
    }
    this.hcp.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = j.cm(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
    if ((paramBundle == null) || (paramBundle.nPS == null))
    {
      y.e("MicroMsg.ProductFurtherInfoUI", "initView(), product or product field detail null -> finish");
      finish();
      return;
    }
    this.nJO = paramBundle.nPS;
    this.nJP = paramBundle.field_feedbackurl;
    initView();
  }
  
  public final int xj()
  {
    return R.o.product_further_info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI
 * JD-Core Version:    0.7.0.1
 */