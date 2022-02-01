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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/MediaBannerIndicator;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/view/IMediaBannerIndicator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "count", "currentIndex", "indicatorMargin", "getIndicatorMargin", "()I", "setIndicatorMargin", "(I)V", "indicatorWidth", "getIndicatorWidth", "setIndicatorWidth", "isShowOnlyOneIndicator", "", "listener", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "selectDrawable", "Landroid/graphics/drawable/Drawable;", "getSelectDrawable", "()Landroid/graphics/drawable/Drawable;", "setSelectDrawable", "(Landroid/graphics/drawable/Drawable;)V", "unSelectDrawable", "getUnSelectDrawable", "setUnSelectDrawable", "getCount", "getCurrentIndex", "getOnSelectedPageListener", "getView", "Landroid/view/View;", "init", "", "initAttribute", "defStyle", "setCount", "value", "setCurrentIndex", "setOnSelectedPageListener", "setShowOnlyOneIndicator", "isShow", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class MediaBannerIndicator
  extends LinearLayout
  implements i
{
  public static final MediaBannerIndicator.a agHn;
  private boolean GHn;
  private Drawable agHo;
  private Drawable agHp;
  private i.a agHq;
  private int count;
  private int currentIndex;
  private int indicatorMargin;
  private int indicatorWidth;
  
  static
  {
    AppMethodBeat.i(164560);
    agHn = new MediaBannerIndicator.a((byte)0);
    AppMethodBeat.o(164560);
  }
  
  public MediaBannerIndicator(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164557);
    this.indicatorWidth = ((int)getResources().getDimension(a.e.indicatorSize));
    this.indicatorMargin = ((int)getResources().getDimension(a.e.Edge_0_5_A));
    this.agHo = getContext().getDrawable(a.f.selected_radius);
    this.agHp = getContext().getDrawable(a.f.gray_radius);
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
    this.agHo = getContext().getDrawable(a.f.selected_radius);
    this.agHp = getContext().getDrawable(a.f.gray_radius);
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
    this.agHo = getContext().getDrawable(a.f.selected_radius);
    this.agHp = getContext().getDrawable(a.f.gray_radius);
    setOrientation(0);
    setGravity(17);
    b(paramAttributeSet, paramInt);
    AppMethodBeat.o(164559);
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(234616);
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.m.MediaBannerIndicator, paramInt, 0);
    s.s(paramAttributeSet, "context.obtainStyledAttr…erIndicator, defStyle, 0)");
    setIndicatorMargin((int)paramAttributeSet.getDimension(a.m.MediaBannerIndicator_indicatorMargin, getResources().getDimension(a.e.Edge_0_5_A)));
    setIndicatorWidth((int)paramAttributeSet.getDimension(a.m.MediaBannerIndicator_indicatorWidth, getResources().getDimension(a.e.indicatorSize)));
    if (paramAttributeSet.hasValue(a.m.MediaBannerIndicator_indicatorSelectedDrawable)) {
      setSelectDrawable(paramAttributeSet.getDrawable(a.m.MediaBannerIndicator_indicatorSelectedDrawable));
    }
    if (paramAttributeSet.hasValue(a.m.MediaBannerIndicator_indicatorUnSelectedDrawable)) {
      setUnSelectDrawable(paramAttributeSet.getDrawable(a.m.MediaBannerIndicator_indicatorUnSelectedDrawable));
    }
    paramAttributeSet.recycle();
    AppMethodBeat.o(234616);
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
  
  public i.a getOnSelectedPageListener()
  {
    return this.agHq;
  }
  
  public Drawable getSelectDrawable()
  {
    return this.agHo;
  }
  
  public Drawable getUnSelectDrawable()
  {
    return this.agHp;
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
    if ((paramInt > 1) || ((paramInt > 0) && (this.GHn)))
    {
      setVisibility(0);
      this.currentIndex = 0;
      if (paramInt <= 0) {
        break label173;
      }
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
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
        if (j < paramInt) {
          break;
        }
        AppMethodBeat.o(164555);
        return;
        localImageView.setImageDrawable(getUnSelectDrawable());
      }
      setVisibility(8);
      label173:
      AppMethodBeat.o(164555);
      return;
    }
  }
  
  public void setCurrentIndex(int paramInt)
  {
    AppMethodBeat.i(164556);
    Object localObject = getChildAt(this.currentIndex);
    if ((localObject instanceof ImageView))
    {
      localObject = (ImageView)localObject;
      if (localObject != null)
      {
        ((ImageView)localObject).setImageDrawable(getUnSelectDrawable());
        localObject = getChildAt(paramInt);
        if (!(localObject instanceof ImageView)) {
          break label86;
        }
      }
    }
    label86:
    for (localObject = (ImageView)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(getSelectDrawable());
      }
      this.currentIndex = paramInt;
      AppMethodBeat.o(164556);
      return;
      localObject = null;
      break;
    }
  }
  
  public void setIndicatorMargin(int paramInt)
  {
    this.indicatorMargin = paramInt;
  }
  
  public void setIndicatorWidth(int paramInt)
  {
    this.indicatorWidth = paramInt;
  }
  
  public void setOnSelectedPageListener(i.a parama)
  {
    AppMethodBeat.i(234672);
    s.u(parama, "listener");
    this.agHq = parama;
    AppMethodBeat.o(234672);
  }
  
  public void setSelectDrawable(Drawable paramDrawable)
  {
    this.agHo = paramDrawable;
  }
  
  public void setShowOnlyOneIndicator(boolean paramBoolean)
  {
    this.GHn = paramBoolean;
  }
  
  public void setUnSelectDrawable(Drawable paramDrawable)
  {
    this.agHp = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.MediaBannerIndicator
 * JD-Core Version:    0.7.0.1
 */