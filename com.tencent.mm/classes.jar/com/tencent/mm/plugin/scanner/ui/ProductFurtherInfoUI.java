package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.k;
import com.tencent.mm.plugin.scanner.util.q.a;
import com.tencent.mm.plugin.scanner.util.q.a.a;
import com.tencent.mm.plugin.scanner.util.q.a.a.a;
import com.tencent.mm.plugin.scanner.util.q.a.a.b;
import com.tencent.mm.sdk.platformtools.ab;
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
  private ViewPager Gr;
  protected f iLA;
  private MMPageControlView qxp;
  private q.a.a qxq;
  private String qxr;
  
  public int getHeaderResourceId()
  {
    return 2130970441;
  }
  
  public int getLayoutId()
  {
    return 2130970440;
  }
  
  public int getResourceId()
  {
    return 2131165259;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(81057);
    setMMTitle(getIntent().getStringExtra("key_title"));
    setBackBtn(new ProductFurtherInfoUI.1(this));
    addIconOptionMenu(0, 2130839668, new ProductFurtherInfoUI.2(this));
    this.iLA = getPreferenceScreen();
    Object localObject1 = new ArrayList();
    Object localObject2 = this.qxq.qDM.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(((q.a.a.a)((Iterator)localObject2).next()).link);
    }
    this.Gr = ((ViewPager)findViewById(2131823945));
    this.qxp = ((MMPageControlView)findViewById(2131821429));
    this.qxp.setIndicatorLayoutRes(2130970398);
    this.qxp.setVisibility(0);
    this.Gr.setOnTouchListener(new ProductFurtherInfoUI.3(this));
    this.Gr.setOnPageChangeListener(new ProductFurtherInfoUI.4(this));
    localObject2 = new ProductFurtherInfoUI.a(this, this);
    this.Gr.setAdapter((q)localObject2);
    int i = j;
    if (((List)localObject1).size() > 0)
    {
      ((ProductFurtherInfoUI.a)localObject2).qxu = ((List)localObject1);
      ((ProductFurtherInfoUI.a)localObject2).qxs.qxp.hy(((List)localObject1).size(), 0);
      ((ProductFurtherInfoUI.a)localObject2).notifyDataSetChanged();
      this.Gr.setVisibility(0);
      i = j;
    }
    while (i < this.qxq.qDN.size())
    {
      localObject1 = (q.a.a.b)this.qxq.qDN.get(i);
      localObject2 = new Preference(this);
      ((Preference)localObject2).setKey(String.valueOf(i));
      ((Preference)localObject2).setLayoutResource(2130970319);
      ((Preference)localObject2).setTitle(((q.a.a.b)localObject1).title);
      ((Preference)localObject2).setSummary(((q.a.a.b)localObject1).desc);
      this.iLA.b((Preference)localObject2);
      i += 1;
    }
    this.iLA.notifyDataSetChanged();
    AppMethodBeat.o(81057);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(81056);
    super.onCreate(paramBundle);
    paramBundle = k.dg(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
    if ((paramBundle == null) || (paramBundle.qDL == null))
    {
      ab.e("MicroMsg.ProductFurtherInfoUI", "initView(), product or product field detail null -> finish");
      finish();
      AppMethodBeat.o(81056);
      return;
    }
    this.qxq = paramBundle.qDL;
    this.qxr = paramBundle.field_feedbackurl;
    initView();
    AppMethodBeat.o(81056);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI
 * JD-Core Version:    0.7.0.1
 */