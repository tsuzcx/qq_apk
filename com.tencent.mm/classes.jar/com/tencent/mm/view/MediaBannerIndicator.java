package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/MediaBannerIndicator;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "count", "getCount", "()I", "setCount", "(I)V", "currentIndex", "getCurrentIndex", "setCurrentIndex", "indicatorMargin", "getIndicatorMargin", "setIndicatorMargin", "indicatorWidth", "getIndicatorWidth", "setIndicatorWidth", "isShowOnlyOneIndicator", "", "()Z", "setShowOnlyOneIndicator", "(Z)V", "selectDrawable", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getSelectDrawable", "()Landroid/graphics/drawable/Drawable;", "setSelectDrawable", "(Landroid/graphics/drawable/Drawable;)V", "unSelectDrawable", "getUnSelectDrawable", "setUnSelectDrawable", "Companion", "libmmui_release"})
public final class MediaBannerIndicator
  extends LinearLayout
{
  public static final a Lpa;
  private int LoV;
  private int LoW;
  private Drawable LoX;
  private Drawable LoY;
  private boolean LoZ;
  private int count;
  private int currentIndex;
  
  static
  {
    AppMethodBeat.i(164560);
    Lpa = new a((byte)0);
    AppMethodBeat.o(164560);
  }
  
  public MediaBannerIndicator(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164557);
    this.LoV = ((int)getResources().getDimension(2131166431));
    this.LoW = ((int)getResources().getDimension(2131165274));
    setOrientation(0);
    setGravity(17);
    this.LoX = getContext().getDrawable(2131233932);
    this.LoY = getContext().getDrawable(2131232605);
    AppMethodBeat.o(164557);
  }
  
  public MediaBannerIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164558);
    this.LoV = ((int)getResources().getDimension(2131166431));
    this.LoW = ((int)getResources().getDimension(2131165274));
    setOrientation(0);
    setGravity(17);
    this.LoX = getContext().getDrawable(2131233932);
    this.LoY = getContext().getDrawable(2131232605);
    AppMethodBeat.o(164558);
  }
  
  public MediaBannerIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164559);
    this.LoV = ((int)getResources().getDimension(2131166431));
    this.LoW = ((int)getResources().getDimension(2131165274));
    setOrientation(0);
    setGravity(17);
    this.LoX = getContext().getDrawable(2131233932);
    this.LoY = getContext().getDrawable(2131232605);
    AppMethodBeat.o(164559);
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  public final int getCurrentIndex()
  {
    return this.currentIndex;
  }
  
  public final int getIndicatorMargin()
  {
    return this.LoW;
  }
  
  public final int getIndicatorWidth()
  {
    return this.LoV;
  }
  
  public final Drawable getSelectDrawable()
  {
    return this.LoX;
  }
  
  public final Drawable getUnSelectDrawable()
  {
    return this.LoY;
  }
  
  public final void setCount(int paramInt)
  {
    AppMethodBeat.i(164555);
    removeAllViews();
    this.count = paramInt;
    if ((paramInt > 1) || ((paramInt > 0) && (this.LoZ)))
    {
      setVisibility(0);
      int i = 0;
      if (i < paramInt)
      {
        ImageView localImageView = new ImageView(getContext());
        localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (this.currentIndex == i) {
          localImageView.setImageDrawable(this.LoX);
        }
        for (;;)
        {
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.LoV, this.LoV);
          localLayoutParams.leftMargin = this.LoW;
          localLayoutParams.rightMargin = this.LoW;
          localLayoutParams.gravity = 17;
          addView((View)localImageView, (ViewGroup.LayoutParams)localLayoutParams);
          i += 1;
          break;
          localImageView.setImageDrawable(this.LoY);
        }
      }
      setCurrentIndex(0);
      ad.i("MicroMsg.MediaBannerIndicator", "[MediaBannerIndicator] count=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(164555);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(164555);
  }
  
  public final void setCurrentIndex(int paramInt)
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
      ((ImageView)localObject).setImageDrawable(this.LoY);
      localView = getChildAt(paramInt);
      localObject = localView;
      if (!(localView instanceof ImageView)) {
        localObject = null;
      }
      localObject = (ImageView)localObject;
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(this.LoX);
      }
    }
    this.currentIndex = paramInt;
    AppMethodBeat.o(164556);
  }
  
  public final void setIndicatorMargin(int paramInt)
  {
    this.LoW = paramInt;
  }
  
  public final void setIndicatorWidth(int paramInt)
  {
    this.LoV = paramInt;
  }
  
  public final void setSelectDrawable(Drawable paramDrawable)
  {
    this.LoX = paramDrawable;
  }
  
  public final void setShowOnlyOneIndicator(boolean paramBoolean)
  {
    this.LoZ = paramBoolean;
  }
  
  public final void setUnSelectDrawable(Drawable paramDrawable)
  {
    this.LoY = paramDrawable;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/MediaBannerIndicator$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.MediaBannerIndicator
 * JD-Core Version:    0.7.0.1
 */