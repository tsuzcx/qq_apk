package com.tencent.mm.plugin.multitask.animation.a;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "setDefaultDstRect", "", "dstRect", "Landroid/graphics/Rect;", "setDstRect", "setMaskAlpha", "maskAlpha", "", "setMaskRect", "left", "", "top", "right", "buttom", "setRectConnerRadius", "radll", "radlt", "radtl", "radtt", "radrl", "radrt", "radbl", "radbt", "setViewSize", "width", "height", "plugin-multitask_release"})
public class a
  extends View
{
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public void ip(int paramInt1, int paramInt2) {}
  
  public void n(float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public void n(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void setDefaultDstRect(Rect paramRect)
  {
    AppMethodBeat.i(247796);
    p.k(paramRect, "dstRect");
    AppMethodBeat.o(247796);
  }
  
  public void setDstRect(Rect paramRect)
  {
    AppMethodBeat.i(247795);
    p.k(paramRect, "dstRect");
    AppMethodBeat.o(247795);
  }
  
  public void setMaskAlpha(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.a.a
 * JD-Core Version:    0.7.0.1
 */