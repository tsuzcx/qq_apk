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
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/view/MediaBannerIndicator;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "count", "getCount", "()I", "setCount", "(I)V", "currentIndex", "getCurrentIndex", "setCurrentIndex", "indicatorMargin", "getIndicatorMargin", "setIndicatorMargin", "indicatorWidth", "getIndicatorWidth", "setIndicatorWidth", "isShowOnlyOneIndicator", "", "()Z", "setShowOnlyOneIndicator", "(Z)V", "selectDrawable", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getSelectDrawable", "()Landroid/graphics/drawable/Drawable;", "setSelectDrawable", "(Landroid/graphics/drawable/Drawable;)V", "unSelectDrawable", "getUnSelectDrawable", "setUnSelectDrawable", "Companion", "libmmui_release"})
public final class MediaBannerIndicator
  extends LinearLayout
{
  public static final MediaBannerIndicator.a JvY;
  private int JvT;
  private int JvU;
  private Drawable JvV;
  private Drawable JvW;
  private boolean JvX;
  private int count;
  private int currentIndex;
  
  static
  {
    AppMethodBeat.i(164560);
    JvY = new MediaBannerIndicator.a((byte)0);
    AppMethodBeat.o(164560);
  }
  
  public MediaBannerIndicator(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164557);
    this.JvT = ((int)getResources().getDimension(2131166431));
    this.JvU = ((int)getResources().getDimension(2131165274));
    setOrientation(0);
    setGravity(17);
    this.JvV = getContext().getDrawable(2131233932);
    this.JvW = getContext().getDrawable(2131232605);
    AppMethodBeat.o(164557);
  }
  
  public MediaBannerIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164558);
    this.JvT = ((int)getResources().getDimension(2131166431));
    this.JvU = ((int)getResources().getDimension(2131165274));
    setOrientation(0);
    setGravity(17);
    this.JvV = getContext().getDrawable(2131233932);
    this.JvW = getContext().getDrawable(2131232605);
    AppMethodBeat.o(164558);
  }
  
  public MediaBannerIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164559);
    this.JvT = ((int)getResources().getDimension(2131166431));
    this.JvU = ((int)getResources().getDimension(2131165274));
    setOrientation(0);
    setGravity(17);
    this.JvV = getContext().getDrawable(2131233932);
    this.JvW = getContext().getDrawable(2131232605);
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
    return this.JvU;
  }
  
  public final int getIndicatorWidth()
  {
    return this.JvT;
  }
  
  public final Drawable getSelectDrawable()
  {
    return this.JvV;
  }
  
  public final Drawable getUnSelectDrawable()
  {
    return this.JvW;
  }
  
  public final void setCount(int paramInt)
  {
    AppMethodBeat.i(164555);
    removeAllViews();
    this.count = paramInt;
    if ((paramInt > 1) || ((paramInt > 0) && (this.JvX)))
    {
      setVisibility(0);
      int i = 0;
      if (i < paramInt)
      {
        ImageView localImageView = new ImageView(getContext());
        localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (this.currentIndex == i) {
          localImageView.setImageDrawable(this.JvV);
        }
        for (;;)
        {
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.JvT, this.JvT);
          localLayoutParams.leftMargin = this.JvU;
          localLayoutParams.rightMargin = this.JvU;
          localLayoutParams.gravity = 17;
          addView((View)localImageView, (ViewGroup.LayoutParams)localLayoutParams);
          i += 1;
          break;
          localImageView.setImageDrawable(this.JvW);
        }
      }
      setCurrentIndex(0);
      ac.i("MicroMsg.MediaBannerIndicator", "[MediaBannerIndicator] count=".concat(String.valueOf(paramInt)));
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
      ((ImageView)localObject).setImageDrawable(this.JvW);
      localView = getChildAt(paramInt);
      localObject = localView;
      if (!(localView instanceof ImageView)) {
        localObject = null;
      }
      localObject = (ImageView)localObject;
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(this.JvV);
      }
    }
    this.currentIndex = paramInt;
    AppMethodBeat.o(164556);
  }
  
  public final void setIndicatorMargin(int paramInt)
  {
    this.JvU = paramInt;
  }
  
  public final void setIndicatorWidth(int paramInt)
  {
    this.JvT = paramInt;
  }
  
  public final void setSelectDrawable(Drawable paramDrawable)
  {
    this.JvV = paramDrawable;
  }
  
  public final void setShowOnlyOneIndicator(boolean paramBoolean)
  {
    this.JvX = paramBoolean;
  }
  
  public final void setUnSelectDrawable(Drawable paramDrawable)
  {
    this.JvW = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.MediaBannerIndicator
 * JD-Core Version:    0.7.0.1
 */