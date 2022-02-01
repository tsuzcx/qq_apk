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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "libmmui_release"})
public class InsectFrameLayout
  extends FrameLayout
{
  private Rect FLS;
  private final String TAG;
  private int[] Yav;
  private b<? super Integer, Boolean> Yaw;
  
  public InsectFrameLayout(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(204173);
    AppMethodBeat.o(204173);
  }
  
  public InsectFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(204172);
    AppMethodBeat.o(204172);
  }
  
  public InsectFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204171);
    this.TAG = "MicroMsg.InsectLayout";
    this.FLS = new Rect();
    this.Yav = new int[2];
    AppMethodBeat.o(204171);
  }
  
  public boolean Kc(int paramInt)
  {
    return false;
  }
  
  public final b<Integer, Boolean> getInsectCallback()
  {
    return this.Yaw;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(204170);
    getWindowVisibleDisplayFrame(this.FLS);
    getLocationOnScreen(this.Yav);
    final int i = paramInt4 - paramInt2 + this.Yav[1] - this.FLS.bottom;
    boolean bool2 = Kc(i);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (this.Yaw != null)
      {
        b localb = this.Yaw;
        if (localb == null) {
          p.iCn();
        }
        bool1 = ((Boolean)localb.invoke(Integer.valueOf(i))).booleanValue();
      }
    }
    Log.d(this.TAG, "InsectFrameLayout onLayout. handled=" + bool1 + " bottom=" + paramInt4);
    if ((!bool1) && (getPaddingBottom() != i)) {
      post((Runnable)new a(this, i));
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(204170);
  }
  
  public final void setInsectCallback(b<? super Integer, Boolean> paramb)
  {
    this.Yaw = paramb;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(InsectFrameLayout paramInsectFrameLayout, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(187324);
      Log.i(InsectFrameLayout.a(this.Yax), "InsectFrameLayout onLayout. bottomInsect=" + i);
      this.Yax.setPadding(this.Yax.getPaddingLeft(), this.Yax.getPaddingTop(), this.Yax.getPaddingRight(), i);
      this.Yax.requestLayout();
      AppMethodBeat.o(187324);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InsectFrameLayout
 * JD-Core Version:    0.7.0.1
 */