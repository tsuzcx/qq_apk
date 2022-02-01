package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ar;
import d.g.a.b;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/widget/InsectLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "discardKeyboard", "", "getDiscardKeyboard", "()Z", "setDiscardKeyboard", "(Z)V", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "libmmui_release"})
public class InsectLinearLayout
  extends LinearLayout
{
  private Rect KQk;
  private int[] KQs;
  private b<? super Integer, Boolean> KQt;
  private boolean KQw;
  private final String TAG;
  
  public InsectLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(186626);
    AppMethodBeat.o(186626);
  }
  
  public InsectLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(186625);
    this.TAG = "MicroMsg.InsectLayout";
    this.KQk = new Rect();
    this.KQs = new int[2];
    AppMethodBeat.o(186625);
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
    int k = 0;
    AppMethodBeat.i(186624);
    ad.i(this.TAG, "InsectRelativeLayout onLayout");
    getWindowVisibleDisplayFrame(this.KQk);
    getLocationOnScreen(this.KQs);
    final int m = paramInt4 - paramInt2 + this.KQs[1] - this.KQk.bottom;
    b localb;
    if (this.KQt != null)
    {
      localb = this.KQt;
      if (localb == null) {
        p.gfZ();
      }
    }
    for (boolean bool = ((Boolean)localb.invoke(Integer.valueOf(m))).booleanValue();; bool = false)
    {
      if (m > ar.ej(getContext()) * 3) {}
      for (int i = 1;; i = 0)
      {
        int j;
        if (!bool)
        {
          j = k;
          if (i != 0)
          {
            j = k;
            if (!this.KQw) {}
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
        AppMethodBeat.o(186624);
        return;
      }
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
    a(InsectLinearLayout paramInsectLinearLayout, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(186623);
      this.KQx.setPadding(this.KQx.getPaddingLeft(), this.KQx.getPaddingTop(), this.KQx.getPaddingRight(), m);
      this.KQx.requestLayout();
      AppMethodBeat.o(186623);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InsectLinearLayout
 * JD-Core Version:    0.7.0.1
 */