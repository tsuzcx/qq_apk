package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import androidx.viewpager.widget.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.MMAutoHeightViewPager;
import com.tencent.mm.ui.base.MMPageControlView;
import java.util.ArrayList;

public class WalletPayUOpenIntroView
  extends LinearLayout
{
  private MMAutoHeightViewPager Wdf;
  private MMPageControlView Wdg;
  private a Wdh;
  private d[] Wdi;
  private ArrayList<View> cbM;
  private Context mContext;
  
  public WalletPayUOpenIntroView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletPayUOpenIntroView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72033);
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(a.g.payu_view_open_intro, this, true);
    this.Wdf = ((MMAutoHeightViewPager)paramContext.findViewById(a.f.pager));
    this.Wdg = ((MMPageControlView)paramContext.findViewById(a.f.controller));
    this.Wdg.setVisibility(0);
    this.Wdf.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public final void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(72029);
        if (WalletPayUOpenIntroView.a(WalletPayUOpenIntroView.this).getParent() != null) {
          WalletPayUOpenIntroView.a(WalletPayUOpenIntroView.this).getParent().requestDisallowInterceptTouchEvent(true);
        }
        WalletPayUOpenIntroView.b(WalletPayUOpenIntroView.this).setPage(paramAnonymousInt);
        AppMethodBeat.o(72029);
      }
    });
    AppMethodBeat.o(72033);
  }
  
  public void setPagerData(d[] paramArrayOfd)
  {
    AppMethodBeat.i(72034);
    this.Wdi = paramArrayOfd;
    this.cbM = new ArrayList();
    if (this.Wdi != null)
    {
      i = 0;
      while (i < this.Wdi.length)
      {
        paramArrayOfd = LayoutInflater.from(this.mContext).inflate(a.g.payu_view_open_intro_item, null);
        this.cbM.add(paramArrayOfd);
        i += 1;
      }
    }
    this.Wdh = new a((byte)0);
    this.Wdf.setAdapter(this.Wdh);
    paramArrayOfd = this.Wdg;
    if (this.Wdi == null) {}
    for (int i = 0;; i = this.Wdi.length)
    {
      paramArrayOfd.oj(i, 0);
      AppMethodBeat.o(72034);
      return;
    }
  }
  
  final class a
    extends a
  {
    private a() {}
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(72032);
      paramViewGroup.removeView((View)WalletPayUOpenIntroView.d(WalletPayUOpenIntroView.this).get(paramInt));
      AppMethodBeat.o(72032);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(72030);
      if (WalletPayUOpenIntroView.c(WalletPayUOpenIntroView.this) == null)
      {
        AppMethodBeat.o(72030);
        return 0;
      }
      int i = WalletPayUOpenIntroView.c(WalletPayUOpenIntroView.this).length;
      AppMethodBeat.o(72030);
      return i;
    }
    
    public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(72031);
      View localView = (View)WalletPayUOpenIntroView.d(WalletPayUOpenIntroView.this).get(paramInt);
      paramViewGroup.addView(localView);
      paramViewGroup = WalletPayUOpenIntroView.c(WalletPayUOpenIntroView.this)[paramInt];
      ImageView localImageView = (ImageView)localView.findViewById(a.f.logo);
      TextView localTextView1 = (TextView)localView.findViewById(a.f.tip);
      TextView localTextView2 = (TextView)localView.findViewById(a.f.hint);
      localImageView.setImageResource(paramViewGroup.Wdc);
      localTextView1.setText(paramViewGroup.Wdd);
      localTextView2.setText(paramViewGroup.Wde);
      AppMethodBeat.o(72031);
      return localView;
    }
    
    public final boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUOpenIntroView
 * JD-Core Version:    0.7.0.1
 */