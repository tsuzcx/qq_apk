package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import androidx.viewpager.widget.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.scanner.l.c;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.l.h;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.l.k;
import com.tencent.mm.plugin.scanner.model.x;
import com.tencent.mm.plugin.scanner.util.q.a;
import com.tencent.mm.plugin.scanner.util.q.a.a;
import com.tencent.mm.plugin.scanner.util.q.a.a.a;
import com.tencent.mm.plugin.scanner.util.q.a.a.b;
import com.tencent.mm.plugin.scanner.util.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.e;
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
  private MMPageControlView OZh;
  private q.a.a OZi;
  private String OZj;
  private ViewPager cjS;
  protected f pkD;
  
  public int getHeaderResourceId()
  {
    return l.g.OKq;
  }
  
  public int getLayoutId()
  {
    return l.g.OKp;
  }
  
  public int getResourceId()
  {
    return l.k.OKp;
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
    addIconOptionMenu(0, l.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(51817);
        paramAnonymousMenuItem = new LinkedList();
        LinkedList localLinkedList = new LinkedList();
        paramAnonymousMenuItem.add(ProductFurtherInfoUI.this.getString(l.i.OLr));
        localLinkedList.add(Integer.valueOf(0));
        k.b(ProductFurtherInfoUI.this.getContext(), "", paramAnonymousMenuItem, localLinkedList, "", new k.e()
        {
          public final void onClick(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(51816);
            switch (paramAnonymous2Int2)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(51816);
              return;
              if (!Util.isNullOrNil(ProductFurtherInfoUI.a(ProductFurtherInfoUI.this)))
              {
                Intent localIntent = new Intent();
                localIntent.putExtra("rawUrl", ProductFurtherInfoUI.a(ProductFurtherInfoUI.this));
                c.b(ProductFurtherInfoUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
              }
            }
          }
        });
        AppMethodBeat.o(51817);
        return true;
      }
    });
    this.pkD = getPreferenceScreen();
    Object localObject1 = new ArrayList();
    Object localObject2 = this.OZi.PjL.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(((q.a.a.a)((Iterator)localObject2).next()).link);
    }
    this.cjS = ((ViewPager)findViewById(l.f.pager));
    this.OZh = ((MMPageControlView)findViewById(l.f.LSR));
    this.OZh.setIndicatorLayoutRes(l.g.page_control_image);
    this.OZh.setVisibility(0);
    this.cjS.setOnTouchListener(new View.OnTouchListener()
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
    this.cjS.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
    this.cjS.setAdapter((a)localObject2);
    int i = j;
    if (((List)localObject1).size() > 0)
    {
      ((a)localObject2).OZm = ((List)localObject1);
      ((a)localObject2).OZk.OZh.oj(((List)localObject1).size(), 0);
      ((a)localObject2).notifyDataSetChanged();
      this.cjS.setVisibility(0);
      i = j;
    }
    while (i < this.OZi.PjM.size())
    {
      localObject1 = (q.a.a.b)this.OZi.PjM.get(i);
      localObject2 = new Preference(this);
      ((Preference)localObject2).setKey(String.valueOf(i));
      ((Preference)localObject2).setLayoutResource(l.g.OKk);
      ((Preference)localObject2).setTitle(((q.a.a.b)localObject1).title);
      ((Preference)localObject2).aS(((q.a.a.b)localObject1).desc);
      this.pkD.c((Preference)localObject2);
      i += 1;
    }
    this.pkD.notifyDataSetChanged();
    AppMethodBeat.o(51828);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51827);
    super.onCreate(paramBundle);
    paramBundle = x.gI(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
    if ((paramBundle == null) || (paramBundle.PjK == null))
    {
      Log.e("MicroMsg.ProductFurtherInfoUI", "initView(), product or product field detail null -> finish");
      finish();
      AppMethodBeat.o(51827);
      return;
    }
    this.OZi = paramBundle.PjK;
    this.OZj = paramBundle.field_feedbackurl;
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
    extends a
    implements r.a
  {
    List<String> OZm;
    private Map<String, ImageView> OZn;
    private int OZo;
    private Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(51821);
      this.OZm = new ArrayList();
      this.OZn = new HashMap();
      this.mContext = paramContext;
      r.a(this);
      this.OZo = this.mContext.getResources().getColor(l.c.hint_text_color_dark_bg);
      AppMethodBeat.o(51821);
    }
    
    private ImageView aUX(String paramString)
    {
      AppMethodBeat.i(51822);
      if (this.OZn.containsKey(paramString))
      {
        paramString = (ImageView)this.OZn.get(paramString);
        AppMethodBeat.o(51822);
        return paramString;
      }
      ImageView localImageView = new ImageView(this.mContext);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.OZn.put(paramString, localImageView);
      AppMethodBeat.o(51822);
      return localImageView;
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(51824);
      paramViewGroup.removeView((ImageView)paramObject);
      paramViewGroup = (String)this.OZm.get(paramInt);
      if (this.OZn.containsKey(paramViewGroup)) {
        this.OZn.remove(paramViewGroup);
      }
      AppMethodBeat.o(51824);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(51825);
      int i = this.OZm.size();
      AppMethodBeat.o(51825);
      return i;
    }
    
    public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(51823);
      Object localObject = (String)this.OZm.get(paramInt);
      ImageView localImageView = aUX((String)localObject);
      localObject = r.a(new s((String)localObject));
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
          localImageView.setBackgroundColor(this.OZo);
        }
      }
      catch (Exception paramViewGroup)
      {
        for (;;)
        {
          Log.e("MicroMsg.ProductFurtherInfoUI", "Add view failed: " + paramViewGroup.getMessage());
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
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!Util.isNullOrNil(paramString)))
      {
        paramString = aUX(paramString);
        if (paramString != null) {
          MMHandlerThread.postToMainThread(new Runnable()
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