package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.m;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/MediaBannerIndicator;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/view/IMediaBannerIndicator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "count", "currentIndex", "indicatorMargin", "getIndicatorMargin", "()I", "setIndicatorMargin", "(I)V", "indicatorWidth", "getIndicatorWidth", "setIndicatorWidth", "isShowOnlyOneIndicator", "", "listener", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "selectDrawable", "Landroid/graphics/drawable/Drawable;", "getSelectDrawable", "()Landroid/graphics/drawable/Drawable;", "setSelectDrawable", "(Landroid/graphics/drawable/Drawable;)V", "unSelectDrawable", "getUnSelectDrawable", "setUnSelectDrawable", "getCount", "getCurrentIndex", "getOnSelectedPageListener", "getView", "Landroid/view/View;", "init", "", "initAttribute", "defStyle", "setCount", "value", "setCurrentIndex", "setOnSelectedPageListener", "setShowOnlyOneIndicator", "isShow", "Companion", "libmmui_release"})
public class MediaBannerIndicator
  extends LinearLayout
  implements h
{
  public static final a YLE;
  private boolean BeH;
  private Drawable YLB;
  private Drawable YLC;
  private h.a YLD;
  private int count;
  private int currentIndex;
  private int indicatorMargin;
  private int indicatorWidth;
  
  static
  {
    AppMethodBeat.i(164560);
    YLE = new a((byte)0);
    AppMethodBeat.o(164560);
  }
  
  public MediaBannerIndicator(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164557);
    this.indicatorWidth = ((int)getResources().getDimension(a.e.indicatorSize));
    this.indicatorMargin = ((int)getResources().getDimension(a.e.Edge_0_5_A));
    this.YLB = getContext().getDrawable(a.f.selected_radius);
    this.YLC = getContext().getDrawable(a.f.gray_radius);
    setOrientation(0);
    setGravity(17);
    AppMethodBeat.o(164557);
  }
  
  public MediaBannerIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164558);
    this.indicatorWidth = ((int)getResources().getDimension(a.e.indicatorSize));
    this.indicatorMargin = ((int)getResources().getDimension(a.e.Edge_0_5_A));
    this.YLB = getContext().getDrawable(a.f.selected_radius);
    this.YLC = getContext().getDrawable(a.f.gray_radius);
    setOrientation(0);
    setGravity(17);
    b(paramAttributeSet, 0);
    AppMethodBeat.o(164558);
  }
  
  public MediaBannerIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164559);
    this.indicatorWidth = ((int)getResources().getDimension(a.e.indicatorSize));
    this.indicatorMargin = ((int)getResources().getDimension(a.e.Edge_0_5_A));
    this.YLB = getContext().getDrawable(a.f.selected_radius);
    this.YLC = getContext().getDrawable(a.f.gray_radius);
    setOrientation(0);
    setGravity(17);
    b(paramAttributeSet, paramInt);
    AppMethodBeat.o(164559);
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(212426);
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.m.MediaBannerIndicator, paramInt, 0);
    setIndicatorMargin((int)paramAttributeSet.getDimension(a.m.MediaBannerIndicator_indicatorMargin, getResources().getDimension(a.e.Edge_0_5_A)));
    setIndicatorWidth((int)paramAttributeSet.getDimension(a.m.MediaBannerIndicator_indicatorWidth, getResources().getDimension(a.e.indicatorSize)));
    if (paramAttributeSet.hasValue(a.m.MediaBannerIndicator_indicatorSelectedDrawable)) {
      setSelectDrawable(paramAttributeSet.getDrawable(a.m.MediaBannerIndicator_indicatorSelectedDrawable));
    }
    if (paramAttributeSet.hasValue(a.m.MediaBannerIndicator_indicatorUnSelectedDrawable)) {
      setUnSelectDrawable(paramAttributeSet.getDrawable(a.m.MediaBannerIndicator_indicatorUnSelectedDrawable));
    }
    paramAttributeSet.recycle();
    AppMethodBeat.o(212426);
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public int getCurrentIndex()
  {
    return this.currentIndex;
  }
  
  public int getIndicatorMargin()
  {
    return this.indicatorMargin;
  }
  
  public int getIndicatorWidth()
  {
    return this.indicatorWidth;
  }
  
  public h.a getOnSelectedPageListener()
  {
    return this.YLD;
  }
  
  public Drawable getSelectDrawable()
  {
    return this.YLB;
  }
  
  public Drawable getUnSelectDrawable()
  {
    return this.YLC;
  }
  
  public View getView()
  {
    return (View)this;
  }
  
  public void setCount(int paramInt)
  {
    AppMethodBeat.i(164555);
    removeAllViews();
    this.count = paramInt;
    if ((paramInt > 1) || ((paramInt > 0) && (this.BeH)))
    {
      setVisibility(0);
      this.currentIndex = 0;
      int i = 0;
      if (i < paramInt)
      {
        ImageView localImageView = new ImageView(getContext());
        localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (this.currentIndex == i) {
          localImageView.setImageDrawable(getSelectDrawable());
        }
        for (;;)
        {
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(getIndicatorWidth(), getIndicatorWidth());
          localLayoutParams.leftMargin = getIndicatorMargin();
          localLayoutParams.rightMargin = getIndicatorMargin();
          localLayoutParams.gravity = 17;
          addView((View)localImageView, (ViewGroup.LayoutParams)localLayoutParams);
          i += 1;
          break;
          localImageView.setImageDrawable(getUnSelectDrawable());
        }
      }
    }
    else
    {
      setVisibility(8);
    }
    AppMethodBeat.o(164555);
  }
  
  public void setCurrentIndex(int paramInt)
  {
    AppMethodBeat.i(164556);
    View localView = getChildAt(this.currentIndex);
    Object localObject = localView;
    if (!(localView instanceof ImageView)) {
      localObject = null;
    }
    localObject = (ImageView)localObject;
    if (localObject != null)
    {
      ((ImageView)localObject).setImageDrawable(getUnSelectDrawable());
      localView = getChildAt(paramInt);
      localObject = localView;
      if (!(localView instanceof ImageView)) {
        localObject = null;
      }
      localObject = (ImageView)localObject;
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(getSelectDrawable());
      }
    }
    this.currentIndex = paramInt;
    AppMethodBeat.o(164556);
  }
  
  public void setIndicatorMargin(int paramInt)
  {
    this.indicatorMargin = paramInt;
  }
  
  public void setIndicatorWidth(int paramInt)
  {
    this.indicatorWidth = paramInt;
  }
  
  public void setOnSelectedPageListener(h.a parama)
  {
    AppMethodBeat.i(212433);
    p.k(parama, "listener");
    this.YLD = parama;
    AppMethodBeat.o(212433);
  }
  
  public void setSelectDrawable(Drawable paramDrawable)
  {
    this.YLB = paramDrawable;
  }
  
  public void setShowOnlyOneIndicator(boolean paramBoolean)
  {
    this.BeH = paramBoolean;
  }
  
  public void setUnSelectDrawable(Drawable paramDrawable)
  {
    this.YLC = paramDrawable;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/MediaBannerIndicator$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.MediaBannerIndicator
 * JD-Core Version:    0.7.0.1
 */