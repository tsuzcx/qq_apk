package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.ui.base.MMAutoHeightViewPager;
import com.tencent.mm.ui.base.MMPageControlView;
import java.util.ArrayList;

public class WalletPayUOpenIntroView
  extends LinearLayout
{
  private MMAutoHeightViewPager DJS;
  private MMPageControlView DJT;
  private a DJU;
  private d[] DJV;
  private ArrayList<View> axs;
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
    paramContext = LayoutInflater.from(this.mContext).inflate(2131495077, this, true);
    this.DJS = ((MMAutoHeightViewPager)paramContext.findViewById(2131303135));
    this.DJT = ((MMPageControlView)paramContext.findViewById(2131298788));
    this.DJT.setVisibility(0);
    this.DJS.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
    this.DJV = paramArrayOfd;
    this.axs = new ArrayList();
    if (this.DJV != null)
    {
      i = 0;
      while (i < this.DJV.length)
      {
        paramArrayOfd = LayoutInflater.from(this.mContext).inflate(2131495078, null);
        this.axs.add(paramArrayOfd);
        i += 1;
      }
    }
    this.DJU = new a((byte)0);
    this.DJS.setAdapter(this.DJU);
    paramArrayOfd = this.DJT;
    if (this.DJV == null) {}
    for (int i = 0;; i = this.DJV.length)
    {
      paramArrayOfd.jO(i, 0);
      AppMethodBeat.o(72034);
      return;
    }
  }
  
  final class a
    extends q
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
      ImageView localImageView = (ImageView)localView.findViewById(2131301584);
      TextView localTextView1 = (TextView)localView.findViewById(2131305860);
      TextView localTextView2 = (TextView)localView.findViewById(2131300741);
      localImageView.setImageResource(paramViewGroup.DJQ);
      localTextView1.setText(paramViewGroup.titleRes);
      localTextView2.setText(paramViewGroup.DJR);
      AppMethodBeat.o(72031);
      return localView;
    }
    
    public final boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUOpenIntroView
 * JD-Core Version:    0.7.0.1
 */