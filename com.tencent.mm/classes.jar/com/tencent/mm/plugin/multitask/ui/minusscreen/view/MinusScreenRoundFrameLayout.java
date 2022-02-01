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
import com.tencent.mm.ui.aw;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttomOffset", "getButtomOffset", "()I", "gradientButtomDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getGradientButtomDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "setGradientButtomDrawable", "(Landroid/graphics/drawable/GradientDrawable;)V", "gradientTopDrawable", "getGradientTopDrawable", "setGradientTopDrawable", "topOffset", "getTopOffset", "setTopOffset", "(I)V", "useButtomGradient", "", "getUseButtomGradient", "()Z", "setUseButtomGradient", "(Z)V", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "setUseBottomGradient", "bottomGradient", "updateGradientTopOffset", "ui-multitask_release"})
public final class MinusScreenRoundFrameLayout
  extends FrameLayout
{
  private GradientDrawable FLc;
  private GradientDrawable FLd;
  private final int FLe;
  private boolean FLf;
  private int FLg;
  
  public MinusScreenRoundFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(196225);
    this.FLe = aw.fromDPToPix(MMApplicationContext.getContext(), 40);
    int i = Color.argb(166, 0, 0, 0);
    int j = Color.argb(51, 0, 0, 0);
    int k = Color.argb(0, 0, 0, 0);
    int m = Color.argb(0, 0, 0, 0);
    this.FLc = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, j, k, m });
    paramContext = this.FLc;
    if (paramContext != null) {
      paramContext.setGradientType(0);
    }
    paramContext = this.FLc;
    if (paramContext != null) {
      paramContext.setGradientCenter(0.5F, 0.4F);
    }
    i = Color.argb(128, 0, 0, 0);
    j = Color.argb(0, 0, 0, 0);
    k = Color.argb(0, 0, 0, 0);
    this.FLd = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { i, j, k });
    paramContext = this.FLd;
    if (paramContext != null)
    {
      paramContext.setGradientType(0);
      AppMethodBeat.o(196225);
      return;
    }
    AppMethodBeat.o(196225);
  }
  
  public MinusScreenRoundFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(196229);
    this.FLe = aw.fromDPToPix(MMApplicationContext.getContext(), 40);
    paramInt = Color.argb(166, 0, 0, 0);
    int i = Color.argb(51, 0, 0, 0);
    int j = Color.argb(0, 0, 0, 0);
    int k = Color.argb(0, 0, 0, 0);
    this.FLc = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt, i, j, k });
    paramContext = this.FLc;
    if (paramContext != null) {
      paramContext.setGradientType(0);
    }
    paramContext = this.FLc;
    if (paramContext != null) {
      paramContext.setGradientCenter(0.5F, 0.4F);
    }
    paramInt = Color.argb(128, 0, 0, 0);
    i = Color.argb(0, 0, 0, 0);
    j = Color.argb(0, 0, 0, 0);
    this.FLd = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt, i, j });
    paramContext = this.FLd;
    if (paramContext != null)
    {
      paramContext.setGradientType(0);
      AppMethodBeat.o(196229);
      return;
    }
    AppMethodBeat.o(196229);
  }
  
  public final void Yk(int paramInt)
  {
    AppMethodBeat.i(196215);
    this.FLg = paramInt;
    invalidate();
    AppMethodBeat.o(196215);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(196219);
    super.dispatchDraw(paramCanvas);
    if (paramCanvas != null)
    {
      GradientDrawable localGradientDrawable = this.FLc;
      if (localGradientDrawable != null) {
        localGradientDrawable.setBounds(0, this.FLg, getWidth(), getHeight());
      }
      localGradientDrawable = this.FLc;
      if (localGradientDrawable != null) {
        localGradientDrawable.draw(paramCanvas);
      }
      if (this.FLf)
      {
        localGradientDrawable = this.FLd;
        if (localGradientDrawable != null) {
          localGradientDrawable.setBounds(0, getHeight() - this.FLe, getWidth(), getHeight());
        }
        localGradientDrawable = this.FLd;
        if (localGradientDrawable != null)
        {
          localGradientDrawable.draw(paramCanvas);
          AppMethodBeat.o(196219);
          return;
        }
      }
    }
    AppMethodBeat.o(196219);
  }
  
  public final int getButtomOffset()
  {
    return this.FLe;
  }
  
  public final GradientDrawable getGradientButtomDrawable()
  {
    return this.FLd;
  }
  
  public final GradientDrawable getGradientTopDrawable()
  {
    return this.FLc;
  }
  
  public final int getTopOffset()
  {
    return this.FLg;
  }
  
  public final boolean getUseButtomGradient()
  {
    return this.FLf;
  }
  
  public final void setGradientButtomDrawable(GradientDrawable paramGradientDrawable)
  {
    this.FLd = paramGradientDrawable;
  }
  
  public final void setGradientTopDrawable(GradientDrawable paramGradientDrawable)
  {
    this.FLc = paramGradientDrawable;
  }
  
  public final void setTopOffset(int paramInt)
  {
    this.FLg = paramInt;
  }
  
  public final void setUseBottomGradient(boolean paramBoolean)
  {
    this.FLf = paramBoolean;
  }
  
  public final void setUseButtomGradient(boolean paramBoolean)
  {
    this.FLf = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.MinusScreenRoundFrameLayout
 * JD-Core Version:    0.7.0.1
 */