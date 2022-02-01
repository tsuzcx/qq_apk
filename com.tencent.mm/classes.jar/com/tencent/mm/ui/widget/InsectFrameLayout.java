package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.b;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "libmmui_release"})
public class InsectFrameLayout
  extends FrameLayout
{
  private Rect KQk;
  private int[] KQs;
  private b<? super Integer, Boolean> KQt;
  private final String TAG;
  
  public InsectFrameLayout(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(186622);
    AppMethodBeat.o(186622);
  }
  
  public InsectFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(186621);
    AppMethodBeat.o(186621);
  }
  
  public InsectFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(186620);
    this.TAG = "MicroMsg.InsectLayout";
    this.KQk = new Rect();
    this.KQs = new int[2];
    AppMethodBeat.o(186620);
  }
  
  public boolean Cy(int paramInt)
  {
    return false;
  }
  
  public final b<Integer, Boolean> getInsectCallback()
  {
    return this.KQt;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(186619);
    getWindowVisibleDisplayFrame(this.KQk);
    getLocationOnScreen(this.KQs);
    final int i = paramInt4 - paramInt2 + this.KQs[1] - this.KQk.bottom;
    boolean bool2 = Cy(i);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (this.KQt != null)
      {
        b localb = this.KQt;
        if (localb == null) {
          p.gfZ();
        }
        bool1 = ((Boolean)localb.invoke(Integer.valueOf(i))).booleanValue();
      }
    }
    ad.d(this.TAG, "InsectFrameLayout onLayout. handled=" + bool1 + " bottom=" + paramInt4);
    if ((!bool1) && (getPaddingBottom() != i)) {
      post((Runnable)new a(this, i));
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(186619);
  }
  
  public final void setInsectCallback(b<? super Integer, Boolean> paramb)
  {
    this.KQt = paramb;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(InsectFrameLayout paramInsectFrameLayout, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(186618);
      ad.i(InsectFrameLayout.a(this.KQu), "InsectFrameLayout onLayout. bottomInsect=" + i);
      this.KQu.setPadding(this.KQu.getPaddingLeft(), this.KQu.getPaddingTop(), this.KQu.getPaddingRight(), i);
      this.KQu.requestLayout();
      AppMethodBeat.o(186618);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InsectFrameLayout
 * JD-Core Version:    0.7.0.1
 */