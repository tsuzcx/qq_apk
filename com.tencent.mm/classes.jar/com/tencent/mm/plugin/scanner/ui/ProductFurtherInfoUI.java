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
import com.tencent.mm.br.d;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.scanner.model.m;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.plugin.scanner.util.k.a.a;
import com.tencent.mm.plugin.scanner.util.k.a.a.a;
import com.tencent.mm.plugin.scanner.util.k.a.a.b;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private ViewPager Om;
  protected f lZC;
  private MMPageControlView xcU;
  private k.a.a xcV;
  private String xcW;
  
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
          public final void ct(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(51816);
            switch (paramAnonymous2Int2)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(51816);
              return;
              if (!bs.isNullOrNil(ProductFurtherInfoUI.a(ProductFurtherInfoUI.this)))
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
    this.lZC = getPreferenceScreen();
    Object localObject1 = new ArrayList();
    Object localObject2 = this.xcV.xmn.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(((k.a.a.a)((Iterator)localObject2).next()).link);
    }
    this.Om = ((ViewPager)findViewById(2131303135));
    this.xcU = ((MMPageControlView)findViewById(2131301001));
    this.xcU.setIndicatorLayoutRes(2131495062);
    this.xcU.setVisibility(0);
    this.Om.setOnTouchListener(new View.OnTouchListener()
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
    this.Om.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
    this.Om.setAdapter((q)localObject2);
    int i = j;
    if (((List)localObject1).size() > 0)
    {
      ((a)localObject2).xcZ = ((List)localObject1);
      ((a)localObject2).xcX.xcU.jy(((List)localObject1).size(), 0);
      ((a)localObject2).notifyDataSetChanged();
      this.Om.setVisibility(0);
      i = j;
    }
    while (i < this.xcV.xmo.size())
    {
      localObject1 = (k.a.a.b)this.xcV.xmo.get(i);
      localObject2 = new Preference(this);
      ((Preference)localObject2).setKey(String.valueOf(i));
      ((Preference)localObject2).setLayoutResource(2131494969);
      ((Preference)localObject2).setTitle(((k.a.a.b)localObject1).title);
      ((Preference)localObject2).setSummary(((k.a.a.b)localObject1).desc);
      this.lZC.b((Preference)localObject2);
      i += 1;
    }
    this.lZC.notifyDataSetChanged();
    AppMethodBeat.o(51828);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51827);
    super.onCreate(paramBundle);
    paramBundle = m.ev(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
    if ((paramBundle == null) || (paramBundle.xmm == null))
    {
      ac.e("MicroMsg.ProductFurtherInfoUI", "initView(), product or product field detail null -> finish");
      finish();
      AppMethodBeat.o(51827);
      return;
    }
    this.xcV = paramBundle.xmm;
    this.xcW = paramBundle.field_feedbackurl;
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
    List<String> xcZ;
    private Map<String, ImageView> xda;
    private int xdb;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(51821);
      this.xcZ = new ArrayList();
      this.xda = new HashMap();
      this.mContext = paramContext;
      u.a(this);
      this.xdb = this.mContext.getResources().getColor(2131100491);
      AppMethodBeat.o(51821);
    }
    
    private ImageView arN(String paramString)
    {
      AppMethodBeat.i(51822);
      if (this.xda.containsKey(paramString))
      {
        paramString = (ImageView)this.xda.get(paramString);
        AppMethodBeat.o(51822);
        return paramString;
      }
      ImageView localImageView = new ImageView(this.mContext);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.xda.put(paramString, localImageView);
      AppMethodBeat.o(51822);
      return localImageView;
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(51824);
      paramViewGroup.removeView((ImageView)paramObject);
      paramViewGroup = (String)this.xcZ.get(paramInt);
      if (this.xda.containsKey(paramViewGroup)) {
        this.xda.remove(paramViewGroup);
      }
      AppMethodBeat.o(51824);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(51825);
      int i = this.xcZ.size();
      AppMethodBeat.o(51825);
      return i;
    }
    
    public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(51823);
      Object localObject = (String)this.xcZ.get(paramInt);
      ImageView localImageView = arN((String)localObject);
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
          localImageView.setBackgroundColor(this.xdb);
        }
      }
      catch (Exception paramViewGroup)
      {
        for (;;)
        {
          ac.e("MicroMsg.ProductFurtherInfoUI", "Add view failed: " + paramViewGroup.getMessage());
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
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!bs.isNullOrNil(paramString)))
      {
        paramString = arN(paramString);
        if (paramString != null) {
          ap.f(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI
 * JD-Core Version:    0.7.0.1
 */