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
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/view/MediaBannerIndicator;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "count", "getCount", "()I", "setCount", "(I)V", "currentIndex", "getCurrentIndex", "setCurrentIndex", "indicatorMargin", "getIndicatorMargin", "setIndicatorMargin", "indicatorWidth", "getIndicatorWidth", "setIndicatorWidth", "isShowOnlyOneIndicator", "", "()Z", "setShowOnlyOneIndicator", "(Z)V", "selectDrawable", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getSelectDrawable", "()Landroid/graphics/drawable/Drawable;", "setSelectDrawable", "(Landroid/graphics/drawable/Drawable;)V", "unSelectDrawable", "getUnSelectDrawable", "setUnSelectDrawable", "Companion", "libmmui_release"})
public final class MediaBannerIndicator
  extends LinearLayout
{
  public static final MediaBannerIndicator.a LLL;
  private int LLG;
  private int LLH;
  private Drawable LLI;
  private Drawable LLJ;
  private boolean LLK;
  private int count;
  private int currentIndex;
  
  static
  {
    AppMethodBeat.i(164560);
    LLL = new MediaBannerIndicator.a((byte)0);
    AppMethodBeat.o(164560);
  }
  
  public MediaBannerIndicator(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164557);
    this.LLG = ((int)getResources().getDimension(2131166431));
    this.LLH = ((int)getResources().getDimension(2131165274));
    setOrientation(0);
    setGravity(17);
    this.LLI = getContext().getDrawable(2131233932);
    this.LLJ = getContext().getDrawable(2131232605);
    AppMethodBeat.o(164557);
  }
  
  public MediaBannerIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164558);
    this.LLG = ((int)getResources().getDimension(2131166431));
    this.LLH = ((int)getResources().getDimension(2131165274));
    setOrientation(0);
    setGravity(17);
    this.LLI = getContext().getDrawable(2131233932);
    this.LLJ = getContext().getDrawable(2131232605);
    AppMethodBeat.o(164558);
  }
  
  public MediaBannerIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164559);
    this.LLG = ((int)getResources().getDimension(2131166431));
    this.LLH = ((int)getResources().getDimension(2131165274));
    setOrientation(0);
    setGravity(17);
    this.LLI = getContext().getDrawable(2131233932);
    this.LLJ = getContext().getDrawable(2131232605);
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
    return this.LLH;
  }
  
  public final int getIndicatorWidth()
  {
    return this.LLG;
  }
  
  public final Drawable getSelectDrawable()
  {
    return this.LLI;
  }
  
  public final Drawable getUnSelectDrawable()
  {
    return this.LLJ;
  }
  
  public final void setCount(int paramInt)
  {
    AppMethodBeat.i(164555);
    removeAllViews();
    this.count = paramInt;
    if ((paramInt > 1) || ((paramInt > 0) && (this.LLK)))
    {
      setVisibility(0);
      int i = 0;
      if (i < paramInt)
      {
        ImageView localImageView = new ImageView(getContext());
        localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (this.currentIndex == i) {
          localImageView.setImageDrawable(this.LLI);
        }
        for (;;)
        {
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.LLG, this.LLG);
          localLayoutParams.leftMargin = this.LLH;
          localLayoutParams.rightMargin = this.LLH;
          localLayoutParams.gravity = 17;
          addView((View)localImageView, (ViewGroup.LayoutParams)localLayoutParams);
          i += 1;
          break;
          localImageView.setImageDrawable(this.LLJ);
        }
      }
      setCurrentIndex(0);
      ae.i("MicroMsg.MediaBannerIndicator", "[MediaBannerIndicator] count=".concat(String.valueOf(paramInt)));
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
      ((ImageView)localObject).setImageDrawable(this.LLJ);
      localView = getChildAt(paramInt);
      localObject = localView;
      if (!(localView instanceof ImageView)) {
        localObject = null;
      }
      localObject = (ImageView)localObject;
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(this.LLI);
      }
    }
    this.currentIndex = paramInt;
    AppMethodBeat.o(164556);
  }
  
  public final void setIndicatorMargin(int paramInt)
  {
    this.LLH = paramInt;
  }
  
  public final void setIndicatorWidth(int paramInt)
  {
    this.LLG = paramInt;
  }
  
  public final void setSelectDrawable(Drawable paramDrawable)
  {
    this.LLI = paramDrawable;
  }
  
  public final void setShowOnlyOneIndicator(boolean paramBoolean)
  {
    this.LLK = paramBoolean;
  }
  
  public final void setUnSelectDrawable(Drawable paramDrawable)
  {
    this.LLJ = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.MediaBannerIndicator
 * JD-Core Version:    0.7.0.1
 */