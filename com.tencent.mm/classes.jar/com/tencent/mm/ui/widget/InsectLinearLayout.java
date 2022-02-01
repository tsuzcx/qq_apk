package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ax;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/InsectLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "discardKeyboard", "", "getDiscardKeyboard", "()Z", "setDiscardKeyboard", "(Z)V", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "libmmui_release"})
public class InsectLinearLayout
  extends LinearLayout
{
  private Rect FLS;
  private final String TAG;
  private int[] Yav;
  private b<? super Integer, Boolean> Yaw;
  private boolean Yaz;
  
  public InsectLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(223589);
    AppMethodBeat.o(223589);
  }
  
  public InsectLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(223588);
    this.TAG = "MicroMsg.InsectLayout";
    this.FLS = new Rect();
    this.Yav = new int[2];
    AppMethodBeat.o(223588);
  }
  
  public final boolean getDiscardKeyboard()
  {
    return this.Yaz;
  }
  
  public final b<Integer, Boolean> getInsectCallback()
  {
    return this.Yaw;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = 0;
    AppMethodBeat.i(223585);
    Log.i(this.TAG, "InsectRelativeLayout onLayout");
    getWindowVisibleDisplayFrame(this.FLS);
    getLocationOnScreen(this.Yav);
    final int m = paramInt4 - paramInt2 + this.Yav[1] - this.FLS.bottom;
    b localb;
    if (this.Yaw != null)
    {
      localb = this.Yaw;
      if (localb == null) {
        p.iCn();
      }
    }
    for (boolean bool = ((Boolean)localb.invoke(Integer.valueOf(m))).booleanValue();; bool = false)
    {
      if (m > ax.aB(getContext()) * 3) {}
      for (int i = 1;; i = 0)
      {
        int j;
        if (!bool)
        {
          j = k;
          if (i != 0)
          {
            j = k;
            if (!this.Yaz) {}
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
        AppMethodBeat.o(223585);
        return;
      }
    }
  }
  
  public final void setDiscardKeyboard(boolean paramBoolean)
  {
    this.Yaz = paramBoolean;
  }
  
  public final void setInsectCallback(b<? super Integer, Boolean> paramb)
  {
    this.Yaw = paramb;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(InsectLinearLayout paramInsectLinearLayout, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(189583);
      this.YaA.setPadding(this.YaA.getPaddingLeft(), this.YaA.getPaddingTop(), this.YaA.getPaddingRight(), m);
      this.YaA.requestLayout();
      AppMethodBeat.o(189583);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InsectLinearLayout
 * JD-Core Version:    0.7.0.1
 */