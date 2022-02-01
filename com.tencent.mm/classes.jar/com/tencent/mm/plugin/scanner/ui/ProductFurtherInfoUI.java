package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.q;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.scanner.model.o;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.plugin.scanner.util.k.a.a;
import com.tencent.mm.plugin.scanner.util.k.a.a.a;
import com.tencent.mm.plugin.scanner.util.k.a.a.b;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductFurtherInfoUI
  extends MMPreference
{
  private ViewPager Qd;
  protected f mzx;
  private MMPageControlView yqW;
  private k.a.a yqX;
  private String yqY;
  
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
    this.mzx = getPreferenceScreen();
    Object localObject1 = new ArrayList();
    Object localObject2 = this.yqX.yAo.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(((k.a.a.a)((Iterator)localObject2).next()).link);
    }
    this.Qd = ((ViewPager)findViewById(2131303135));
    this.yqW = ((MMPageControlView)findViewById(2131301001));
    this.yqW.setIndicatorLayoutRes(2131495062);
    this.yqW.setVisibility(0);
    this.Qd.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(51818);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/scanner/ui/ProductFurtherInfoUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if ((paramAnonymousView != null) && (paramAnonymousView.getParent() != null)) {
          paramAnonymousView.getParent().requestDisallowInterceptTouchEvent(true);
        }
        a.a(false, this, "com/tencent/mm/plugin/scanner/ui/ProductFurtherInfoUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(51818);
        return false;
      }
    });
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
    localObject2 = new a(this);
    this.Qd.setAdapter((q)localObject2);
    int i = j;
    if (((List)localObject1).size() > 0)
    {
      ((a)localObject2).yrb = ((List)localObject1);
      ((a)localObject2).yqZ.yqW.jK(((List)localObject1).size(), 0);
      ((a)localObject2).notifyDataSetChanged();
      this.Qd.setVisibility(0);
      i = j;
    }
    while (i < this.yqX.yAp.size())
    {
      localObject1 = (k.a.a.b)this.yqX.yAp.get(i);
      localObject2 = new Preference(this);
      ((Preference)localObject2).setKey(String.valueOf(i));
      ((Preference)localObject2).setLayoutResource(2131494969);
      ((Preference)localObject2).setTitle(((k.a.a.b)localObject1).title);
      ((Preference)localObject2).setSummary(((k.a.a.b)localObject1).desc);
      this.mzx.b((Preference)localObject2);
      i += 1;
    }
    this.mzx.notifyDataSetChanged();
    AppMethodBeat.o(51828);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51827);
    super.onCreate(paramBundle);
    paramBundle = o.eN(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
    if ((paramBundle == null) || (paramBundle.yAn == null))
    {
      ad.e("MicroMsg.ProductFurtherInfoUI", "initView(), product or product field detail null -> finish");
      finish();
      AppMethodBeat.o(51827);
      return;
    }
    this.yqX = paramBundle.yAn;
    this.yqY = paramBundle.field_feedbackurl;
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
  
  final class a
    extends q
    implements u.a
  {
    private Context mContext;
    List<String> yrb;
    private Map<String, ImageView> yrc;
    private int yrd;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(51821);
      this.yrb = new ArrayList();
      this.yrc = new HashMap();
      this.mContext = paramContext;
      u.a(this);
      this.yrd = this.mContext.getResources().getColor(2131100491);
      AppMethodBeat.o(51821);
    }
    
    private ImageView awO(String paramString)
    {
      AppMethodBeat.i(51822);
      if (this.yrc.containsKey(paramString))
      {
        paramString = (ImageView)this.yrc.get(paramString);
        AppMethodBeat.o(51822);
        return paramString;
      }
      ImageView localImageView = new ImageView(this.mContext);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.yrc.put(paramString, localImageView);
      AppMethodBeat.o(51822);
      return localImageView;
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(51824);
      paramViewGroup.removeView((ImageView)paramObject);
      paramViewGroup = (String)this.yrb.get(paramInt);
      if (this.yrc.containsKey(paramViewGroup)) {
        this.yrc.remove(paramViewGroup);
      }
      AppMethodBeat.o(51824);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(51825);
      int i = this.yrb.size();
      AppMethodBeat.o(51825);
      return i;
    }
    
    public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(51823);
      Object localObject = (String)this.yrb.get(paramInt);
      ImageView localImageView = awO((String)localObject);
      localObject = u.a(new n((String)localObject));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        localImageView.setImageBitmap((Bitmap)localObject);
        localImageView.setBackgroundColor(0);
      }
      try
      {
        for (;;)
        {
          paramViewGroup.addView(localImageView);
          AppMethodBeat.o(51823);
          return localImageView;
          localImageView.setImageBitmap(null);
          localImageView.setBackgroundColor(this.yrd);
        }
      }
      catch (Exception paramViewGroup)
      {
        for (;;)
        {
          ad.e("MicroMsg.ProductFurtherInfoUI", "Add view failed: " + paramViewGroup.getMessage());
        }
      }
    }
    
    public final boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public final void k(final String paramString, final Bitmap paramBitmap)
    {
      AppMethodBeat.i(51826);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!bt.isNullOrNil(paramString)))
      {
        paramString = awO(paramString);
        if (paramString != null) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(51820);
              paramString.setImageBitmap(paramBitmap);
              paramString.setBackgroundColor(0);
              AppMethodBeat.o(51820);
            }
          });
        }
      }
      AppMethodBeat.o(51826);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI
 * JD-Core Version:    0.7.0.1
 */