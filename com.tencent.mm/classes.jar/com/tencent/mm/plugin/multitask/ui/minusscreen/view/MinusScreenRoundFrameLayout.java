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
import com.tencent.mm.ui.bd;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttomOffset", "getButtomOffset", "()I", "gradientButtomDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getGradientButtomDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "setGradientButtomDrawable", "(Landroid/graphics/drawable/GradientDrawable;)V", "gradientTopDrawable", "getGradientTopDrawable", "setGradientTopDrawable", "topOffset", "getTopOffset", "setTopOffset", "(I)V", "useButtomGradient", "", "getUseButtomGradient", "()Z", "setUseButtomGradient", "(Z)V", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "setUseBottomGradient", "bottomGradient", "updateGradientTopOffset", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MinusScreenRoundFrameLayout
  extends FrameLayout
{
  private GradientDrawable LGj;
  private GradientDrawable LGk;
  private final int LGl;
  private boolean LGm;
  private int LGn;
  
  public MinusScreenRoundFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(304361);
    this.LGl = bd.fromDPToPix(MMApplicationContext.getContext(), 40);
    int i = Color.argb(166, 0, 0, 0);
    int j = Color.argb(51, 0, 0, 0);
    int k = Color.argb(0, 0, 0, 0);
    int m = Color.argb(0, 0, 0, 0);
    this.LGj = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, j, k, m });
    paramContext = this.LGj;
    if (paramContext != null) {
      paramContext.setGradientType(0);
    }
    paramContext = this.LGj;
    if (paramContext != null) {
      paramContext.setGradientCenter(0.5F, 0.4F);
    }
    i = Color.argb(128, 0, 0, 0);
    j = Color.argb(0, 0, 0, 0);
    k = Color.argb(0, 0, 0, 0);
    this.LGk = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { i, j, k });
    paramContext = this.LGk;
    if (paramContext != null) {
      paramContext.setGradientType(0);
    }
    AppMethodBeat.o(304361);
  }
  
  public MinusScreenRoundFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(304369);
    this.LGl = bd.fromDPToPix(MMApplicationContext.getContext(), 40);
    paramInt = Color.argb(166, 0, 0, 0);
    int i = Color.argb(51, 0, 0, 0);
    int j = Color.argb(0, 0, 0, 0);
    int k = Color.argb(0, 0, 0, 0);
    this.LGj = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt, i, j, k });
    paramContext = this.LGj;
    if (paramContext != null) {
      paramContext.setGradientType(0);
    }
    paramContext = this.LGj;
    if (paramContext != null) {
      paramContext.setGradientCenter(0.5F, 0.4F);
    }
    paramInt = Color.argb(128, 0, 0, 0);
    i = Color.argb(0, 0, 0, 0);
    j = Color.argb(0, 0, 0, 0);
    this.LGk = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt, i, j });
    paramContext = this.LGk;
    if (paramContext != null) {
      paramContext.setGradientType(0);
    }
    AppMethodBeat.o(304369);
  }
  
  public final void acw(int paramInt)
  {
    AppMethodBeat.i(304435);
    this.LGn = paramInt;
    invalidate();
    AppMethodBeat.o(304435);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(304442);
    super.dispatchDraw(paramCanvas);
    if (paramCanvas != null)
    {
      GradientDrawable localGradientDrawable = getGradientTopDrawable();
      if (localGradientDrawable != null) {
        localGradientDrawable.setBounds(0, getTopOffset(), getWidth(), getHeight());
      }
      localGradientDrawable = getGradientTopDrawable();
      if (localGradientDrawable != null) {
        localGradientDrawable.draw(paramCanvas);
      }
      if (getUseButtomGradient())
      {
        localGradientDrawable = getGradientButtomDrawable();
        if (localGradientDrawable != null) {
          localGradientDrawable.setBounds(0, getHeight() - getButtomOffset(), getWidth(), getHeight());
        }
        localGradientDrawable = getGradientButtomDrawable();
        if (localGradientDrawable != null) {
          localGradientDrawable.draw(paramCanvas);
        }
      }
    }
    AppMethodBeat.o(304442);
  }
  
  public final int getButtomOffset()
  {
    return this.LGl;
  }
  
  public final GradientDrawable getGradientButtomDrawable()
  {
    return this.LGk;
  }
  
  public final GradientDrawable getGradientTopDrawable()
  {
    return this.LGj;
  }
  
  public final int getTopOffset()
  {
    return this.LGn;
  }
  
  public final boolean getUseButtomGradient()
  {
    return this.LGm;
  }
  
  public final void setGradientButtomDrawable(GradientDrawable paramGradientDrawable)
  {
    this.LGk = paramGradientDrawable;
  }
  
  public final void setGradientTopDrawable(GradientDrawable paramGradientDrawable)
  {
    this.LGj = paramGradientDrawable;
  }
  
  public final void setTopOffset(int paramInt)
  {
    this.LGn = paramInt;
  }
  
  public final void setUseBottomGradient(boolean paramBoolean)
  {
    this.LGm = paramBoolean;
  }
  
  public final void setUseButtomGradient(boolean paramBoolean)
  {
    this.LGm = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.view.MinusScreenRoundFrameLayout
 * JD-Core Version:    0.7.0.1
 */