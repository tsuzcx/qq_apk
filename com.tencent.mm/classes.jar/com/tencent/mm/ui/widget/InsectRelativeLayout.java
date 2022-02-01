package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.ar;
import d.g.a.b;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "discardKeyboard", "", "getDiscardKeyboard", "()Z", "setDiscardKeyboard", "(Z)V", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "libmmui_release"})
public class InsectRelativeLayout
  extends RelativeLayout
{
  private Rect LmI;
  private int[] LmQ;
  private b<? super Integer, Boolean> LmR;
  private boolean LmU;
  private final String TAG;
  
  public InsectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(193887);
    AppMethodBeat.o(193887);
  }
  
  public InsectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(193886);
    this.TAG = "MicroMsg.InsectLayout";
    this.LmI = new Rect();
    this.LmQ = new int[2];
    AppMethodBeat.o(193886);
  }
  
  public boolean CK(int paramInt)
  {
    return false;
  }
  
  public final boolean getDiscardKeyboard()
  {
    return this.LmU;
  }
  
  public final b<Integer, Boolean> getInsectCallback()
  {
    return this.LmR;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(193885);
    ae.i(this.TAG, "InsectRelativeLayout onLayout");
    getWindowVisibleDisplayFrame(this.LmI);
    getLocationOnScreen(this.LmQ);
    final int j = paramInt4 - paramInt2 + this.LmQ[1] - this.LmI.bottom;
    boolean bool2 = CK(j);
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
        bool1 = ((Boolean)localb.invoke(Integer.valueOf(j))).booleanValue();
      }
    }
    if (j > ar.en(getContext()) * 3)
    {
      i = 1;
      if ((!bool1) && ((i == 0) || (!this.LmU))) {
        break label205;
      }
    }
    label205:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (getPaddingBottom() != j)) {
        post((Runnable)new a(this, j));
      }
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(193885);
      return;
      i = 0;
      break;
    }
  }
  
  public final void setDiscardKeyboard(boolean paramBoolean)
  {
    this.LmU = paramBoolean;
  }
  
  public final void setInsectCallback(b<? super Integer, Boolean> paramb)
  {
    this.LmR = paramb;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(InsectRelativeLayout paramInsectRelativeLayout, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(193884);
      this.LmW.setPadding(this.LmW.getPaddingLeft(), this.LmW.getPaddingTop(), this.LmW.getPaddingRight(), j);
      this.LmW.requestLayout();
      AppMethodBeat.o(193884);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InsectRelativeLayout
 * JD-Core Version:    0.7.0.1
 */