package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.support.v4.view.q;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.SoftReference;

final class WebViewSmileyViewPager$b
  extends q
{
  SparseArray<SoftReference<View>> jqk;
  private boolean jql;
  c vtC;
  
  WebViewSmileyViewPager$b()
  {
    AppMethodBeat.i(10120);
    this.jqk = new SparseArray();
    this.jql = false;
    AppMethodBeat.o(10120);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(10124);
    paramViewGroup.removeView((View)paramObject);
    AppMethodBeat.o(10124);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(10123);
    int i = this.vtC.dhd().getPageCount();
    AppMethodBeat.o(10123);
    return i;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(10121);
    if (this.jql)
    {
      AppMethodBeat.o(10121);
      return -2;
    }
    int i = super.getItemPosition(paramObject);
    AppMethodBeat.o(10121);
    return i;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(10125);
    View localView = null;
    if (this.jqk.get(paramInt) != null) {
      localView = (View)((SoftReference)this.jqk.get(paramInt)).get();
    }
    if (localView == null)
    {
      localView = this.vtC.dhd().qE(paramInt);
      if (localView != null)
      {
        paramViewGroup.addView(localView, 0);
        this.jqk.put(paramInt, new SoftReference(localView));
      }
      for (;;)
      {
        AppMethodBeat.o(10125);
        return localView;
        ab.e("MicroMsg.WebViewSmileyViewPagerAdapter", "contentView == null!");
      }
    }
    if (localView.getParent() != null) {
      ((ViewGroup)localView.getParent()).removeView(localView);
    }
    paramViewGroup.addView(localView, 0);
    AppMethodBeat.o(10125);
    return localView;
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(10122);
    this.jql = true;
    super.notifyDataSetChanged();
    this.jql = false;
    AppMethodBeat.o(10122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyViewPager.b
 * JD-Core Version:    0.7.0.1
 */