package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttomOffset", "getButtomOffset", "()I", "gradientButtomDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getGradientButtomDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "setGradientButtomDrawable", "(Landroid/graphics/drawable/GradientDrawable;)V", "gradientTopDrawable", "getGradientTopDrawable", "setGradientTopDrawable", "topOffset", "getTopOffset", "setTopOffset", "(I)V", "useButtomGradient", "", "getUseButtomGradient", "()Z", "setUseButtomGradient", "(Z)V", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "setUseBottomGradient", "bottomGradient", "updateGradientTopOffset", "ui-multitask_release"})
public final class MinusScreenRoundFrameLayout
  extends FrameLayout
{
  private GradientDrawable AeA;
  private GradientDrawable AeB;
  private final int AeC;
  private boolean AeD;
  private int topOffset;
  
  public MinusScreenRoundFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(236530);
    this.AeC = at.fromDPToPix(MMApplicationContext.getContext(), 40);
    int i = Color.argb(166, 0, 0, 0);
    int j = Color.argb(51, 0, 0, 0);
    int k = Color.argb(0, 0, 0, 0);
    int m = Color.argb(0, 0, 0, 0);
    this.AeA = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, j, k, m });
    paramContext = this.AeA;
    if (paramContext != null) {
      paramContext.setGradientType(0);
    }
    paramContext = this.AeA;
    if (paramContext != null) {
      paramContext.setGradientCenter(0.5F, 0.4F);
    }
    i = Color.argb(128, 0, 0, 0);
    j = Color.argb(0, 0, 0, 0);
    k = Color.argb(0, 0, 0, 0);
    this.AeB = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { i, j, k });
    paramContext = this.AeB;
    if (paramContext != null)
    {
      paramContext.setGradientType(0);
      AppMethodBeat.o(236530);
      return;
    }
    AppMethodBeat.o(236530);
  }
  
  public MinusScreenRoundFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(236531);
    this.AeC = at.fromDPToPix(MMApplicationContext.getContext(), 40);
    paramInt = Color.argb(166, 0, 0, 0);
    int i = Color.argb(51, 0, 0, 0);
    int j = Color.argb(0, 0, 0, 0);
    int k = Color.argb(0, 0, 0, 0);
    this.AeA = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt, i, j, k });
    paramContext = this.AeA;
    if (paramContext != null) {
      paramContext.setGradientType(0);
    }
    paramContext = this.AeA;
    if (paramContext != null) {
      paramContext.setGradientCenter(0.5F, 0.4F);
    }
    paramInt = Color.argb(128, 0, 0, 0);
    i = Color.argb(0, 0, 0, 0);
    j = Color.argb(0, 0, 0, 0);
    this.AeB = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt, i, j });
    paramContext = this.AeB;
    if (paramContext != null)
    {
      paramContext.setGradientType(0);
      AppMethodBeat.o(236531);
      return;
    }
    AppMethodBeat.o(236531);
  }
  
  public final void RS(int paramInt)
  {
    AppMethodBeat.i(236528);
    this.topOffset = paramInt;
    invalidate();
    AppMethodBeat.o(236528);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(236529);
    super.dispatchDraw(paramCanvas);
    if (paramCanvas != null)
    {
      GradientDrawable localGradientDrawable = this.AeA;
      if (localGradientDrawable != null) {
        localGradientDrawable.setBounds(0, this.topOffset, getWidth(), getHeight());
      }
      localGradientDrawable = this.AeA;
      if (localGradientDrawable != null) {
        localGradientDrawable.draw(paramCanvas);
      }
      if (this.AeD)
      {
        localGradientDrawable = this.AeB;
        if (localGradientDrawable != null) {
          localGradientDrawable.setBounds(0, getHeight() - this.AeC, getWidth(), getHeight());
        }
        localGradientDrawable = this.AeB;
        if (localGradientDrawable != null)
        {
          localGradientDrawable.draw(paramCanvas);
          AppMethodBeat.o(236529);
          return;
        }
      }
    }
    AppMethodBeat.o(236529);
  }
  
  public final int getButtomOffset()
  {
    return this.AeC;
  }
  
  public final GradientDrawable getGradientButtomDrawable()
  {
    return this.AeB;
  }
  
  public final GradientDrawable getGradientTopDrawable()
  {
    return this.AeA;
  }
  
  public final int getTopOffset()
  {
    return this.topOffset;
  }
  
  public final boolean getUseButtomGradient()
  {
    return this.AeD;
  }
  
  public final void setGradientButtomDrawable(GradientDrawable paramGradientDrawable)
  {
    this.AeB = paramGradientDrawable;
  }
  
  public final void setGradientTopDrawable(GradientDrawable paramGradientDrawable)
  {
    this.AeA = paramGradientDrawable;
  }
  
  public final void setTopOffset(int paramInt)
  {
    this.topOffset = paramInt;
  }
  
  public final void setUseBottomGradient(boolean paramBoolean)
  {
    this.AeD = paramBoolean;
  }
  
  public final void setUseButtomGradient(boolean paramBoolean)
  {
    this.AeD = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.MinusScreenRoundFrameLayout
 * JD-Core Version:    0.7.0.1
 */