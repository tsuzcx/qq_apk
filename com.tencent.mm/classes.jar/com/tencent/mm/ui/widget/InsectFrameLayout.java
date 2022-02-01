package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "libmmui_release"})
public class InsectFrameLayout
  extends FrameLayout
{
  private int[] QBW;
  private b<? super Integer, Boolean> QBX;
  private final String TAG;
  private Rect vPN;
  
  public InsectFrameLayout(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(204864);
    AppMethodBeat.o(204864);
  }
  
  public InsectFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(204863);
    AppMethodBeat.o(204863);
  }
  
  public InsectFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204862);
    this.TAG = "MicroMsg.InsectLayout";
    this.vPN = new Rect();
    this.QBW = new int[2];
    AppMethodBeat.o(204862);
  }
  
  public boolean Gv(int paramInt)
  {
    return false;
  }
  
  public final b<Integer, Boolean> getInsectCallback()
  {
    return this.QBX;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(204861);
    getWindowVisibleDisplayFrame(this.vPN);
    getLocationOnScreen(this.QBW);
    final int i = paramInt4 - paramInt2 + this.QBW[1] - this.vPN.bottom;
    boolean bool2 = Gv(i);
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
        bool1 = ((Boolean)localb.invoke(Integer.valueOf(i))).booleanValue();
      }
    }
    Log.d(this.TAG, "InsectFrameLayout onLayout. handled=" + bool1 + " bottom=" + paramInt4);
    if ((!bool1) && (getPaddingBottom() != i)) {
      post((Runnable)new a(this, i));
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(204861);
  }
  
  public final void setInsectCallback(b<? super Integer, Boolean> paramb)
  {
    this.QBX = paramb;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(InsectFrameLayout paramInsectFrameLayout, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(204860);
      Log.i(InsectFrameLayout.a(this.QBY), "InsectFrameLayout onLayout. bottomInsect=" + i);
      this.QBY.setPadding(this.QBY.getPaddingLeft(), this.QBY.getPaddingTop(), this.QBY.getPaddingRight(), i);
      this.QBY.requestLayout();
      AppMethodBeat.o(204860);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InsectFrameLayout
 * JD-Core Version:    0.7.0.1
 */