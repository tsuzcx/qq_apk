package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.q;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.scanner.model.p;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.plugin.scanner.util.k.a.a;
import com.tencent.mm.plugin.scanner.util.k.a.a.a;
import com.tencent.mm.plugin.scanner.util.k.a.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
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
  private ViewPager Qd;
  protected f mEx;
  private MMPageControlView yGW;
  private k.a.a yGX;
  private String yGY;
  
  public int getHeaderResourceId()
  {
    return 2131495114;
  }
  
  public int getLayoutId()
  {
    return 2131495113;
  }
  
  public int getResourceId()
  {
    return 2131951702;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(51828);
    setMMTitle(getIntent().getStringExtra("key_title"));
    setBackBtn(new ProductFurtherInfoUI.1(this));
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(51817);
        paramAnonymousMenuItem = new LinkedList();
        LinkedList localLinkedList = new LinkedList();
        paramAnonymousMenuItem.add(ProductFurtherInfoUI.this.getString(2131762865));
        localLinkedList.add(Integer.valueOf(0));
        h.b(ProductFurtherInfoUI.this.getContext(), "", paramAnonymousMenuItem, localLinkedList, "", new h.d()
        {
          public final void cv(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(51816);
            switch (paramAnonymous2Int2)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(51816);
              return;
              if (!bu.isNullOrNil(ProductFurtherInfoUI.a(ProductFurtherInfoUI.this)))
              {
                Intent localIntent = new Intent();
                localIntent.putExtra("rawUrl", ProductFurtherInfoUI.a(ProductFurtherInfoUI.this));
                d.b(ProductFurtherInfoUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
              }
            }
          }
        });
        AppMethodBeat.o(51817);
        return true;
      }
    });
    this.mEx = getPreferenceScreen();
    Object localObject1 = new ArrayList();
    Object localObject2 = this.yGX.yQo.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(((k.a.a.a)((Iterator)localObject2).next()).link);
    }
    this.Qd = ((ViewPager)findViewById(2131303135));
    this.yGW = ((MMPageControlView)findViewById(2131301001));
    this.yGW.setIndicatorLayoutRes(2131495062);
    this.yGW.setVisibility(0);
    this.Qd.setOnTouchListener(new ProductFurtherInfoUI.3(this));
    this.Qd.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public final void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(51819);
        if (ProductFurtherInfoUI.b(ProductFurtherInfoUI.this).getParent() != null) {
          ProductFurtherInfoUI.b(ProductFurtherInfoUI.this).getParent().requestDisallowInterceptTouchEvent(true);
        }
        ProductFurtherInfoUI.c(ProductFurtherInfoUI.this).setPage(paramAnonymousInt);
        AppMethodBeat.o(51819);
      }
    });
    localObject2 = new ProductFurtherInfoUI.a(this, this);
    this.Qd.setAdapter((q)localObject2);
    int i = j;
    if (((List)localObject1).size() > 0)
    {
      ((ProductFurtherInfoUI.a)localObject2).yHb = ((List)localObject1);
      ((ProductFurtherInfoUI.a)localObject2).yGZ.yGW.jO(((List)localObject1).size(), 0);
      ((ProductFurtherInfoUI.a)localObject2).notifyDataSetChanged();
      this.Qd.setVisibility(0);
      i = j;
    }
    while (i < this.yGX.yQp.size())
    {
      localObject1 = (k.a.a.b)this.yGX.yQp.get(i);
      localObject2 = new Preference(this);
      ((Preference)localObject2).setKey(String.valueOf(i));
      ((Preference)localObject2).setLayoutResource(2131494969);
      ((Preference)localObject2).setTitle(((k.a.a.b)localObject1).title);
      ((Preference)localObject2).setSummary(((k.a.a.b)localObject1).desc);
      this.mEx.b((Preference)localObject2);
      i += 1;
    }
    this.mEx.notifyDataSetChanged();
    AppMethodBeat.o(51828);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51827);
    super.onCreate(paramBundle);
    paramBundle = p.eV(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
    if ((paramBundle == null) || (paramBundle.yQn == null))
    {
      ae.e("MicroMsg.ProductFurtherInfoUI", "initView(), product or product field detail null -> finish");
      finish();
      AppMethodBeat.o(51827);
      return;
    }
    this.yGX = paramBundle.yQn;
    this.yGY = paramBundle.field_feedbackurl;
    initView();
    AppMethodBeat.o(51827);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI
 * JD-Core Version:    0.7.0.1
 */