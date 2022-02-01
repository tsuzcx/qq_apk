package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ar;
import d.g.a.b;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "discardKeyboard", "", "getDiscardKeyboard", "()Z", "setDiscardKeyboard", "(Z)V", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "libmmui_release"})
public class InsectRelativeLayout
  extends RelativeLayout
{
  private Rect KQk;
  private int[] KQs;
  private b<? super Integer, Boolean> KQt;
  private boolean KQw;
  private final String TAG;
  
  public InsectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(186630);
    AppMethodBeat.o(186630);
  }
  
  public InsectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(186629);
    this.TAG = "MicroMsg.InsectLayout";
    this.KQk = new Rect();
    this.KQs = new int[2];
    AppMethodBeat.o(186629);
  }
  
  public boolean Cy(int paramInt)
  {
    return false;
  }
  
  public final boolean getDiscardKeyboard()
  {
    return this.KQw;
  }
  
  public final b<Integer, Boolean> getInsectCallback()
  {
    return this.KQt;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(186628);
    ad.i(this.TAG, "InsectRelativeLayout onLayout");
    getWindowVisibleDisplayFrame(this.KQk);
    getLocationOnScreen(this.KQs);
    final int j = paramInt4 - paramInt2 + this.KQs[1] - this.KQk.bottom;
    boolean bool2 = Cy(j);
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
        bool1 = ((Boolean)localb.invoke(Integer.valueOf(j))).booleanValue();
      }
    }
    if (j > ar.ej(getContext()) * 3)
    {
      i = 1;
      if ((!bool1) && ((i == 0) || (!this.KQw))) {
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
      AppMethodBeat.o(186628);
      return;
      i = 0;
      break;
    }
  }
  
  public final void setDiscardKeyboard(boolean paramBoolean)
  {
    this.KQw = paramBoolean;
  }
  
  public final void setInsectCallback(b<? super Integer, Boolean> paramb)
  {
    this.KQt = paramb;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(InsectRelativeLayout paramInsectRelativeLayout, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(186627);
      this.KQy.setPadding(this.KQy.getPaddingLeft(), this.KQy.getPaddingTop(), this.KQy.getPaddingRight(), j);
      this.KQy.requestLayout();
      AppMethodBeat.o(186627);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InsectRelativeLayout
 * JD-Core Version:    0.7.0.1
 */