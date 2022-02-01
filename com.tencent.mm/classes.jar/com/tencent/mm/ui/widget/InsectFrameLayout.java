package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.b;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "libmmui_release"})
public class InsectFrameLayout
  extends FrameLayout
{
  private Rect LmI;
  private int[] LmQ;
  private b<? super Integer, Boolean> LmR;
  private final String TAG;
  
  public InsectFrameLayout(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(193879);
    AppMethodBeat.o(193879);
  }
  
  public InsectFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(193878);
    AppMethodBeat.o(193878);
  }
  
  public InsectFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(193877);
    this.TAG = "MicroMsg.InsectLayout";
    this.LmI = new Rect();
    this.LmQ = new int[2];
    AppMethodBeat.o(193877);
  }
  
  public boolean CK(int paramInt)
  {
    return false;
  }
  
  public final b<Integer, Boolean> getInsectCallback()
  {
    return this.LmR;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(193876);
    getWindowVisibleDisplayFrame(this.LmI);
    getLocationOnScreen(this.LmQ);
    final int i = paramInt4 - paramInt2 + this.LmQ[1] - this.LmI.bottom;
    boolean bool2 = CK(i);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (this.LmR != null)
      {
        b localb = this.LmR;
        if (localb == null) {
          p.gkB();
        }
        bool1 = ((Boolean)localb.invoke(Integer.valueOf(i))).booleanValue();
      }
    }
    ae.d(this.TAG, "InsectFrameLayout onLayout. handled=" + bool1 + " bottom=" + paramInt4);
    if ((!bool1) && (getPaddingBottom() != i)) {
      post((Runnable)new a(this, i));
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(193876);
  }
  
  public final void setInsectCallback(b<? super Integer, Boolean> paramb)
  {
    this.LmR = paramb;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(InsectFrameLayout paramInsectFrameLayout, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(193875);
      ae.i(InsectFrameLayout.a(this.LmS), "InsectFrameLayout onLayout. bottomInsect=" + i);
      this.LmS.setPadding(this.LmS.getPaddingLeft(), this.LmS.getPaddingTop(), this.LmS.getPaddingRight(), i);
      this.LmS.requestLayout();
      AppMethodBeat.o(193875);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InsectFrameLayout
 * JD-Core Version:    0.7.0.1
 */