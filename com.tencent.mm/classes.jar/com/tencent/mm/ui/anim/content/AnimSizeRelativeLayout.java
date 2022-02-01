package com.tencent.mm.ui.anim.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/anim/content/AnimSizeRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "sizeAnimController", "Lcom/tencent/mm/ui/anim/content/SizeAnimController;", "getSizeAnimController", "()Lcom/tencent/mm/ui/anim/content/SizeAnimController;", "onLayout", "", "changed", "", "left", "", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "requestGone", "requestVisible", "Companion", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AnimSizeRelativeLayout
  extends RelativeLayout
{
  public static final AnimSizeRelativeLayout.a adMq;
  private final c adMp;
  
  static
  {
    AppMethodBeat.i(251241);
    adMq = new AnimSizeRelativeLayout.a((byte)0);
    AppMethodBeat.o(251241);
  }
  
  public AnimSizeRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(251237);
    paramContext = new c((View)this);
    paramContext.adMw = true;
    paramAttributeSet = ah.aiuX;
    this.adMp = paramContext;
    AppMethodBeat.o(251237);
  }
  
  public final c getSizeAnimController()
  {
    return this.adMp;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(251264);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.adMp.ob(paramInt2, paramInt4);
    AppMethodBeat.o(251264);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251255);
    r localr = this.adMp.jlB();
    if (localr != null)
    {
      super.onMeasure(paramInt1, paramInt2);
      setMeasuredDimension(((Number)localr.bsC).intValue(), ((Number)localr.bsD).intValue());
      AppMethodBeat.o(251255);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    localr = this.adMp.jlC();
    if (localr != null) {
      setMeasuredDimension(((Number)localr.bsC).intValue(), ((Number)localr.bsD).intValue());
    }
    AppMethodBeat.o(251255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.anim.content.AnimSizeRelativeLayout
 * JD-Core Version:    0.7.0.1
 */