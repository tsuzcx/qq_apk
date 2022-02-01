package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/base/MMHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onScrollListener", "Lcom/tencent/mm/ui/base/OnHorizontalScrollListener;", "getOnScrollListener", "()Lcom/tencent/mm/ui/base/OnHorizontalScrollListener;", "setOnScrollListener", "(Lcom/tencent/mm/ui/base/OnHorizontalScrollListener;)V", "onScrollChanged", "", "l", "t", "oldl", "oldt", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMHorizontalScrollView
  extends HorizontalScrollView
{
  private ac adRL;
  
  public MMHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final ac getOnScrollListener()
  {
    return this.adRL;
  }
  
  protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(251339);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(251339);
  }
  
  public final void setOnScrollListener(ac paramac)
  {
    this.adRL = paramac;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMHorizontalScrollView
 * JD-Core Version:    0.7.0.1
 */