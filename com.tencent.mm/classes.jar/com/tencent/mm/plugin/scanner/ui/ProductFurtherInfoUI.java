package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.q;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.scanner.model.m;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.plugin.scanner.util.k.a.a;
import com.tencent.mm.plugin.scanner.util.k.a.a.a;
import com.tencent.mm.plugin.scanner.util.k.a.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private ViewPager Nr;
  protected f lxI;
  private MMPageControlView vSj;
  private k.a.a vSk;
  private String vSl;
  
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
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(51815);
        ProductFurtherInfoUI.this.finish();
        AppMethodBeat.o(51815);
        return false;
      }
    });
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
              if (!bt.isNullOrNil(ProductFurtherInfoUI.a(ProductFurtherInfoUI.this)))
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
    this.lxI = getPreferenceScreen();
    Object localObject1 = new ArrayList();
    Object localObject2 = this.vSk.wbh.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(((k.a.a.a)((Iterator)localObject2).next()).link);
    }
    this.Nr = ((ViewPager)findViewById(2131303135));
    this.vSj = ((MMPageControlView)findViewById(2131301001));
    this.vSj.setIndicatorLayoutRes(2131495062);
    this.vSj.setVisibility(0);
    this.Nr.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(51818);
        if ((paramAnonymousView != null) && (paramAnonymousView.getParent() != null)) {
          paramAnonymousView.getParent().requestDisallowInterceptTouchEvent(true);
        }
        AppMethodBeat.o(51818);
        return false;
      }
    });
    this.Nr.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
    this.Nr.setAdapter((q)localObject2);
    int i = j;
    if (((List)localObject1).size() > 0)
    {
      ((ProductFurtherInfoUI.a)localObject2).vSo = ((List)localObject1);
      ((ProductFurtherInfoUI.a)localObject2).vSm.vSj.jl(((List)localObject1).size(), 0);
      ((ProductFurtherInfoUI.a)localObject2).notifyDataSetChanged();
      this.Nr.setVisibility(0);
      i = j;
    }
    while (i < this.vSk.wbi.size())
    {
      localObject1 = (k.a.a.b)this.vSk.wbi.get(i);
      localObject2 = new Preference(this);
      ((Preference)localObject2).setKey(String.valueOf(i));
      ((Preference)localObject2).setLayoutResource(2131494969);
      ((Preference)localObject2).setTitle(((k.a.a.b)localObject1).title);
      ((Preference)localObject2).setSummary(((k.a.a.b)localObject1).desc);
      this.lxI.b((Preference)localObject2);
      i += 1;
    }
    this.lxI.notifyDataSetChanged();
    AppMethodBeat.o(51828);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51827);
    super.onCreate(paramBundle);
    paramBundle = m.en(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
    if ((paramBundle == null) || (paramBundle.wbg == null))
    {
      ad.e("MicroMsg.ProductFurtherInfoUI", "initView(), product or product field detail null -> finish");
      finish();
      AppMethodBeat.o(51827);
      return;
    }
    this.vSk = paramBundle.wbg;
    this.vSl = paramBundle.field_feedbackurl;
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