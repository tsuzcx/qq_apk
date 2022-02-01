package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.b;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "libmmui_release"})
public class InsectFrameLayout
  extends FrameLayout
{
  private final String TAG;
  private Rect fWY;
  private int[] fWZ;
  private b<? super Integer, Boolean> fXa;
  
  public InsectFrameLayout(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(197306);
    AppMethodBeat.o(197306);
  }
  
  public InsectFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(197305);
    AppMethodBeat.o(197305);
  }
  
  public InsectFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(197304);
    this.TAG = "MicroMsg.InsectLayout";
    this.fWY = new Rect();
    this.fWZ = new int[2];
    AppMethodBeat.o(197304);
  }
  
  public boolean cEv()
  {
    return false;
  }
  
  public final b<Integer, Boolean> getInsectCallback()
  {
    return this.fXa;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(197303);
    getWindowVisibleDisplayFrame(this.fWY);
    getLocationOnScreen(this.fWZ);
    final int i = paramInt4 - paramInt2 + this.fWZ[1] - this.fWY.bottom;
    boolean bool2 = cEv();
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (this.fXa != null)
      {
        b localb = this.fXa;
        if (localb == null) {
          k.fOy();
        }
        bool1 = ((Boolean)localb.ay(Integer.valueOf(i))).booleanValue();
      }
    }
    ac.d(this.TAG, "InsectFrameLayout onLayout. handled=" + bool1 + " bottom=" + paramInt4);
    if ((!bool1) && (getPaddingBottom() != i)) {
      post((Runnable)new a(this, i));
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(197303);
  }
  
  public final void setInsectCallback(b<? super Integer, Boolean> paramb)
  {
    this.fXa = paramb;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(InsectFrameLayout paramInsectFrameLayout, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(197302);
      ac.i(InsectFrameLayout.a(this.IZm), "InsectFrameLayout onLayout. bottomInsect=" + i);
      this.IZm.setPadding(this.IZm.getPaddingLeft(), this.IZm.getPaddingTop(), this.IZm.getPaddingRight(), i);
      this.IZm.requestLayout();
      AppMethodBeat.o(197302);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InsectFrameLayout
 * JD-Core Version:    0.7.0.1
 */