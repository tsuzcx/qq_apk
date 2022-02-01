package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/InsectLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "discardKeyboard", "", "getDiscardKeyboard", "()Z", "setDiscardKeyboard", "(Z)V", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "libmmui_release"})
public class InsectLinearLayout
  extends LinearLayout
{
  private int[] QBW;
  private b<? super Integer, Boolean> QBX;
  private boolean QCa;
  private final String TAG;
  private Rect vPN;
  
  public InsectLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(204868);
    AppMethodBeat.o(204868);
  }
  
  public InsectLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204867);
    this.TAG = "MicroMsg.InsectLayout";
    this.vPN = new Rect();
    this.QBW = new int[2];
    AppMethodBeat.o(204867);
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
    int k = 0;
    AppMethodBeat.i(204866);
    Log.i(this.TAG, "InsectRelativeLayout onLayout");
    getWindowVisibleDisplayFrame(this.vPN);
    getLocationOnScreen(this.QBW);
    final int m = paramInt4 - paramInt2 + this.QBW[1] - this.vPN.bottom;
    b localb;
    if (this.QBX != null)
    {
      localb = this.QBX;
      if (localb == null) {
        p.hyc();
      }
    }
    for (boolean bool = ((Boolean)localb.invoke(Integer.valueOf(m))).booleanValue();; bool = false)
    {
      if (m > au.aD(getContext()) * 3) {}
      for (int i = 1;; i = 0)
      {
        int j;
        if (!bool)
        {
          j = k;
          if (i != 0)
          {
            j = k;
            if (!this.QCa) {}
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
        AppMethodBeat.o(204866);
        return;
      }
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
    a(InsectLinearLayout paramInsectLinearLayout, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(204865);
      this.QCb.setPadding(this.QCb.getPaddingLeft(), this.QCb.getPaddingTop(), this.QCb.getPaddingRight(), m);
      this.QCb.requestLayout();
      AppMethodBeat.o(204865);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InsectLinearLayout
 * JD-Core Version:    0.7.0.1
 */