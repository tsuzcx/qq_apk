package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.ar;
import d.g.a.b;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/widget/InsectLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "discardKeyboard", "", "getDiscardKeyboard", "()Z", "setDiscardKeyboard", "(Z)V", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "libmmui_release"})
public class InsectLinearLayout
  extends LinearLayout
{
  private Rect LmI;
  private int[] LmQ;
  private b<? super Integer, Boolean> LmR;
  private boolean LmU;
  private final String TAG;
  
  public InsectLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(193883);
    AppMethodBeat.o(193883);
  }
  
  public InsectLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(193882);
    this.TAG = "MicroMsg.InsectLayout";
    this.LmI = new Rect();
    this.LmQ = new int[2];
    AppMethodBeat.o(193882);
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
    int k = 0;
    AppMethodBeat.i(193881);
    ae.i(this.TAG, "InsectRelativeLayout onLayout");
    getWindowVisibleDisplayFrame(this.LmI);
    getLocationOnScreen(this.LmQ);
    final int m = paramInt4 - paramInt2 + this.LmQ[1] - this.LmI.bottom;
    b localb;
    if (this.LmR != null)
    {
      localb = this.LmR;
      if (localb == null) {
        p.gkB();
      }
    }
    for (boolean bool = ((Boolean)localb.invoke(Integer.valueOf(m))).booleanValue();; bool = false)
    {
      if (m > ar.en(getContext()) * 3) {}
      for (int i = 1;; i = 0)
      {
        int j;
        if (!bool)
        {
          j = k;
          if (i != 0)
          {
            j = k;
            if (!this.LmU) {}
          }
        }
        else
        {
          j = 1;
        }
        if ((j == 0) && (getPaddingBottom() != m)) {
          post((Runnable)new a(this, m));
        }
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        AppMethodBeat.o(193881);
        return;
      }
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
    a(InsectLinearLayout paramInsectLinearLayout, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(193880);
      this.LmV.setPadding(this.LmV.getPaddingLeft(), this.LmV.getPaddingTop(), this.LmV.getPaddingRight(), m);
      this.LmV.requestLayout();
      AppMethodBeat.o(193880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InsectLinearLayout
 * JD-Core Version:    0.7.0.1
 */