package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.CustomViewPager;
import java.lang.ref.SoftReference;

public class WebViewSmileyViewPager
  extends CustomViewPager
{
  private c COP;
  private a COY;
  private int mHY;
  private int mHZ;
  
  public WebViewSmileyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82362);
    this.mHY = 0;
    this.mHZ = 0;
    if (d.kZ(9)) {
      setOverScrollMode(2);
    }
    AppMethodBeat.o(82362);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82363);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.COP != null) && (((paramInt1 > 0) && (paramInt3 != paramInt1)) || ((paramInt2 > 0) && (paramInt4 != paramInt2) && (((paramInt2 > 0) && (paramInt2 != this.mHY)) || ((paramInt1 > 0) && (paramInt1 != this.mHZ))))))
    {
      this.COP.mHV = paramInt2;
      this.COP.mHW = paramInt1;
      if (this.COY != null) {
        this.COY.bAZ();
      }
    }
    if (paramInt2 > 0) {
      this.mHY = paramInt2;
    }
    if (paramInt1 > 0) {
      this.mHZ = paramInt1;
    }
    AppMethodBeat.o(82363);
  }
  
  public void setOnSizeChangedListener(a parama)
  {
    this.COY = parama;
  }
  
  public void setPanelManager(c paramc)
  {
    this.COP = paramc;
  }
  
  public static abstract interface a
  {
    public abstract void bAZ();
  }
  
  static final class b
    extends q
  {
    c COP;
    SparseArray<SoftReference<View>> mIb;
    private boolean mIc;
    
    b()
    {
      AppMethodBeat.i(82356);
      this.mIb = new SparseArray();
      this.mIc = false;
      AppMethodBeat.o(82356);
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(82360);
      paramViewGroup.removeView((View)paramObject);
      AppMethodBeat.o(82360);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(82359);
      int i = this.COP.eGO().getPageCount();
      AppMethodBeat.o(82359);
      return i;
    }
    
    public final int getItemPosition(Object paramObject)
    {
      AppMethodBeat.i(82357);
      if (this.mIc)
      {
        AppMethodBeat.o(82357);
        return -2;
      }
      int i = super.getItemPosition(paramObject);
      AppMethodBeat.o(82357);
      return i;
    }
    
    public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(82361);
      View localView = null;
      if (this.mIb.get(paramInt) != null) {
        localView = (View)((SoftReference)this.mIb.get(paramInt)).get();
      }
      if (localView == null)
      {
        localView = this.COP.eGO().vX(paramInt);
        if (localView != null)
        {
          paramViewGroup.addView(localView, 0);
          this.mIb.put(paramInt, new SoftReference(localView));
        }
        for (;;)
        {
          AppMethodBeat.o(82361);
          return localView;
          ac.e("MicroMsg.WebViewSmileyViewPagerAdapter", "contentView == null!");
        }
      }
      if (localView.getParent() != null) {
        ((ViewGroup)localView.getParent()).removeView(localView);
      }
      paramViewGroup.addView(localView, 0);
      AppMethodBeat.o(82361);
      return localView;
    }
    
    public final boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(82358);
      this.mIc = true;
      super.notifyDataSetChanged();
      this.mIc = false;
      AppMethodBeat.o(82358);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyViewPager
 * JD-Core Version:    0.7.0.1
 */