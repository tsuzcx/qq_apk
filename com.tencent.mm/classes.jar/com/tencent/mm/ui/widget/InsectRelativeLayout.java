package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ax;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "discardKeyboard", "", "getDiscardKeyboard", "()Z", "setDiscardKeyboard", "(Z)V", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "libmmui_release"})
public class InsectRelativeLayout
  extends RelativeLayout
{
  private Rect FLS;
  private final String TAG;
  private int[] Yav;
  private b<? super Integer, Boolean> Yaw;
  private boolean Yaz;
  
  public InsectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(203597);
    AppMethodBeat.o(203597);
  }
  
  public InsectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(203595);
    this.TAG = "MicroMsg.InsectLayout";
    this.FLS = new Rect();
    this.Yav = new int[2];
    AppMethodBeat.o(203595);
  }
  
  public boolean Kc(int paramInt)
  {
    return false;
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
    AppMethodBeat.i(203594);
    Log.i(this.TAG, "InsectRelativeLayout onLayout");
    getWindowVisibleDisplayFrame(this.FLS);
    getLocationOnScreen(this.Yav);
    final int j = paramInt4 - paramInt2 + this.Yav[1] - this.FLS.bottom;
    boolean bool2 = Kc(j);
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
        bool1 = ((Boolean)localb.invoke(Integer.valueOf(j))).booleanValue();
      }
    }
    if (j > ax.aB(getContext()) * 3)
    {
      i = 1;
      if ((!bool1) && ((i == 0) || (!this.Yaz))) {
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
      AppMethodBeat.o(203594);
      return;
      i = 0;
      break;
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
    a(InsectRelativeLayout paramInsectRelativeLayout, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(223438);
      this.YaB.setPadding(this.YaB.getPaddingLeft(), this.YaB.getPaddingTop(), this.YaB.getPaddingRight(), j);
      this.YaB.requestLayout();
      AppMethodBeat.o(223438);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InsectRelativeLayout
 * JD-Core Version:    0.7.0.1
 */