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
import com.tencent.mm.ae.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/MediaBannerIndicator;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/view/IMediaBannerIndicator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "count", "currentIndex", "indicatorMargin", "getIndicatorMargin", "()I", "setIndicatorMargin", "(I)V", "indicatorWidth", "getIndicatorWidth", "setIndicatorWidth", "isShowOnlyOneIndicator", "", "listener", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "selectDrawable", "Landroid/graphics/drawable/Drawable;", "getSelectDrawable", "()Landroid/graphics/drawable/Drawable;", "setSelectDrawable", "(Landroid/graphics/drawable/Drawable;)V", "unSelectDrawable", "getUnSelectDrawable", "setUnSelectDrawable", "getCount", "getCurrentIndex", "getOnSelectedPageListener", "getView", "Landroid/view/View;", "init", "", "initAttribute", "defStyle", "setCount", "value", "setCurrentIndex", "setOnSelectedPageListener", "setShowOnlyOneIndicator", "isShow", "Companion", "libmmui_release"})
public class MediaBannerIndicator
  extends LinearLayout
  implements h
{
  public static final a RjZ;
  private int RjU;
  private int RjV;
  private Drawable RjW;
  private Drawable RjX;
  private h.a RjY;
  private int count;
  private int currentIndex;
  private boolean wsp;
  
  static
  {
    AppMethodBeat.i(164560);
    RjZ = new a((byte)0);
    AppMethodBeat.o(164560);
  }
  
  public MediaBannerIndicator(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164557);
    this.RjU = ((int)getResources().getDimension(2131166524));
    this.RjV = ((int)getResources().getDimension(2131165277));
    this.RjW = getContext().getDrawable(2131234768);
    this.RjX = getContext().getDrawable(2131233001);
    setOrientation(0);
    setGravity(17);
    AppMethodBeat.o(164557);
  }
  
  public MediaBannerIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164558);
    this.RjU = ((int)getResources().getDimension(2131166524));
    this.RjV = ((int)getResources().getDimension(2131165277));
    this.RjW = getContext().getDrawable(2131234768);
    this.RjX = getContext().getDrawable(2131233001);
    setOrientation(0);
    setGravity(17);
    b(paramAttributeSet, 0);
    AppMethodBeat.o(164558);
  }
  
  public MediaBannerIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164559);
    this.RjU = ((int)getResources().getDimension(2131166524));
    this.RjV = ((int)getResources().getDimension(2131165277));
    this.RjW = getContext().getDrawable(2131234768);
    this.RjX = getContext().getDrawable(2131233001);
    setOrientation(0);
    setGravity(17);
    b(paramAttributeSet, paramInt);
    AppMethodBeat.o(164559);
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(204979);
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.a.MediaBannerIndicator, paramInt, 0);
    setIndicatorMargin((int)paramAttributeSet.getDimension(0, getResources().getDimension(2131165277)));
    setIndicatorWidth((int)paramAttributeSet.getDimension(3, getResources().getDimension(2131166524)));
    if (paramAttributeSet.hasValue(1)) {
      setSelectDrawable(paramAttributeSet.getDrawable(1));
    }
    if (paramAttributeSet.hasValue(2)) {
      setUnSelectDrawable(paramAttributeSet.getDrawable(2));
    }
    paramAttributeSet.recycle();
    AppMethodBeat.o(204979);
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
    return this.RjV;
  }
  
  public int getIndicatorWidth()
  {
    return this.RjU;
  }
  
  public h.a getOnSelectedPageListener()
  {
    return this.RjY;
  }
  
  public Drawable getSelectDrawable()
  {
    return this.RjW;
  }
  
  public Drawable getUnSelectDrawable()
  {
    return this.RjX;
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
    if ((paramInt > 1) || ((paramInt > 0) && (this.wsp)))
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
    this.RjV = paramInt;
  }
  
  public void setIndicatorWidth(int paramInt)
  {
    this.RjU = paramInt;
  }
  
  public void setOnSelectedPageListener(h.a parama)
  {
    AppMethodBeat.i(204980);
    p.h(parama, "listener");
    this.RjY = parama;
    AppMethodBeat.o(204980);
  }
  
  public void setSelectDrawable(Drawable paramDrawable)
  {
    this.RjW = paramDrawable;
  }
  
  public void setShowOnlyOneIndicator(boolean paramBoolean)
  {
    this.wsp = paramBoolean;
  }
  
  public void setUnSelectDrawable(Drawable paramDrawable)
  {
    this.RjX = paramDrawable;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/MediaBannerIndicator$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.MediaBannerIndicator
 * JD-Core Version:    0.7.0.1
 */