package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.CustomViewPager;
import java.lang.ref.SoftReference;

public class WebViewSmileyViewPager
  extends CustomViewPager
{
  private c EsP;
  private a EsY;
  private int niw;
  private int nix;
  
  public WebViewSmileyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82362);
    this.niw = 0;
    this.nix = 0;
    if (d.ly(9)) {
      setOverScrollMode(2);
    }
    AppMethodBeat.o(82362);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82363);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.EsP != null) && (((paramInt1 > 0) && (paramInt3 != paramInt1)) || ((paramInt2 > 0) && (paramInt4 != paramInt2) && (((paramInt2 > 0) && (paramInt2 != this.niw)) || ((paramInt1 > 0) && (paramInt1 != this.nix))))))
    {
      this.EsP.nit = paramInt2;
      this.EsP.niu = paramInt1;
      if (this.EsY != null) {
        this.EsY.bFb();
      }
    }
    if (paramInt2 > 0) {
      this.niw = paramInt2;
    }
    if (paramInt1 > 0) {
      this.nix = paramInt1;
    }
    AppMethodBeat.o(82363);
  }
  
  public void setOnSizeChangedListener(a parama)
  {
    this.EsY = parama;
  }
  
  public void setPanelManager(c paramc)
  {
    this.EsP = paramc;
  }
  
  public static abstract interface a
  {
    public abstract void bFb();
  }
  
  static final class b
    extends q
  {
    c EsP;
    private boolean niA;
    SparseArray<SoftReference<View>> niz;
    
    b()
    {
      AppMethodBeat.i(82356);
      this.niz = new SparseArray();
      this.niA = false;
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
      int i = this.EsP.eVO().getPageCount();
      AppMethodBeat.o(82359);
      return i;
    }
    
    public final int getItemPosition(Object paramObject)
    {
      AppMethodBeat.i(82357);
      if (this.niA)
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
      if (this.niz.get(paramInt) != null) {
        localView = (View)((SoftReference)this.niz.get(paramInt)).get();
      }
      if (localView == null)
      {
        localView = this.EsP.eVO().wC(paramInt);
        if (localView != null)
        {
          paramViewGroup.addView(localView, 0);
          this.niz.put(paramInt, new SoftReference(localView));
        }
        for (;;)
        {
          AppMethodBeat.o(82361);
          return localView;
          ad.e("MicroMsg.WebViewSmileyViewPagerAdapter", "contentView == null!");
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
      this.niA = true;
      super.notifyDataSetChanged();
      this.niA = false;
      AppMethodBeat.o(82358);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyViewPager
 * JD-Core Version:    0.7.0.1
 */