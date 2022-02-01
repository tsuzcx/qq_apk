package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "discardKeyboard", "", "getDiscardKeyboard", "()Z", "setDiscardKeyboard", "(Z)V", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "libmmui_release"})
public class InsectRelativeLayout
  extends RelativeLayout
{
  private int[] QBW;
  private b<? super Integer, Boolean> QBX;
  private boolean QCa;
  private final String TAG;
  private Rect vPN;
  
  public InsectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(204872);
    AppMethodBeat.o(204872);
  }
  
  public InsectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204871);
    this.TAG = "MicroMsg.InsectLayout";
    this.vPN = new Rect();
    this.QBW = new int[2];
    AppMethodBeat.o(204871);
  }
  
  public boolean Gv(int paramInt)
  {
    return false;
  }
  
  public final boolean getDiscardKeyboard()
  {
    return this.QCa;
  }
  
  public final b<Integer, Boolean> getInsectCallback()
  {
    return this.QBX;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(204870);
    Log.i(this.TAG, "InsectRelativeLayout onLayout");
    getWindowVisibleDisplayFrame(this.vPN);
    getLocationOnScreen(this.QBW);
    final int j = paramInt4 - paramInt2 + this.QBW[1] - this.vPN.bottom;
    boolean bool2 = Gv(j);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (this.QBX != null)
      {
        b localb = this.QBX;
        if (localb == null) {
          p.hyc();
        }
        bool1 = ((Boolean)localb.invoke(Integer.valueOf(j))).booleanValue();
      }
    }
    if (j > au.aD(getContext()) * 3)
    {
      i = 1;
      if ((!bool1) && ((i == 0) || (!this.QCa))) {
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
      AppMethodBeat.o(204870);
      return;
      i = 0;
      break;
    }
  }
  
  public final void setDiscardKeyboard(boolean paramBoolean)
  {
    this.QCa = paramBoolean;
  }
  
  public final void setInsectCallback(b<? super Integer, Boolean> paramb)
  {
    this.QBX = paramb;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(InsectRelativeLayout paramInsectRelativeLayout, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(204869);
      this.QCc.setPadding(this.QCc.getPaddingLeft(), this.QCc.getPaddingTop(), this.QCc.getPaddingRight(), j);
      this.QCc.requestLayout();
      AppMethodBeat.o(204869);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InsectRelativeLayout
 * JD-Core Version:    0.7.0.1
 */