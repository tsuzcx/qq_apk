package com.tencent.mm.plugin.multitask.animation.a;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "setDefaultDstRect", "", "dstRect", "Landroid/graphics/Rect;", "setDstRect", "setMaskAlpha", "maskAlpha", "", "setMaskRect", "left", "", "top", "right", "buttom", "setRectConnerRadius", "radll", "radlt", "radtl", "radtt", "radrl", "radrt", "radbl", "radbt", "setViewSize", "width", "height", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  extends View
{
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public void ef(int paramInt1, int paramInt2) {}
  
  public void r(float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public void r(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void setDefaultDstRect(Rect paramRect)
  {
    AppMethodBeat.i(303951);
    s.u(paramRect, "dstRect");
    AppMethodBeat.o(303951);
  }
  
  public void setDstRect(Rect paramRect)
  {
    AppMethodBeat.i(303937);
    s.u(paramRect, "dstRect");
    AppMethodBeat.o(303937);
  }
  
  public void setMaskAlpha(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.a.a
 * JD-Core Version:    0.7.0.1
 */