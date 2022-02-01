package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "discardKeyboard", "", "getDiscardKeyboard", "()Z", "setDiscardKeyboard", "(Z)V", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class InsectRelativeLayout
  extends RelativeLayout
{
  private Rect LGX;
  private final String TAG;
  private int[] afSq;
  private b<? super Integer, Boolean> afSr;
  private boolean afSs;
  
  public InsectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(251724);
    AppMethodBeat.o(251724);
  }
  
  public InsectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(251720);
    this.TAG = "MicroMsg.InsectLayout";
    this.LGX = new Rect();
    this.afSq = new int[2];
    AppMethodBeat.o(251720);
  }
  
  private static final void a(InsectRelativeLayout paramInsectRelativeLayout, int paramInt)
  {
    AppMethodBeat.i(251726);
    s.u(paramInsectRelativeLayout, "this$0");
    paramInsectRelativeLayout.setPadding(paramInsectRelativeLayout.getPaddingLeft(), paramInsectRelativeLayout.getPaddingTop(), paramInsectRelativeLayout.getPaddingRight(), paramInt);
    paramInsectRelativeLayout.requestLayout();
    AppMethodBeat.o(251726);
  }
  
  public boolean La(int paramInt)
  {
    return false;
  }
  
  public final boolean getDiscardKeyboard()
  {
    return this.afSs;
  }
  
  public final b<Integer, Boolean> getInsectCallback()
  {
    return this.afSr;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(251733);
    Log.i(this.TAG, "InsectRelativeLayout onLayout");
    getWindowVisibleDisplayFrame(this.LGX);
    getLocationOnScreen(this.afSq);
    int j = paramInt4 - paramInt2 + this.afSq[1] - this.LGX.bottom;
    boolean bool2 = La(j);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (this.afSr != null)
      {
        b localb = this.afSr;
        s.checkNotNull(localb);
        bool1 = ((Boolean)localb.invoke(Integer.valueOf(j))).booleanValue();
      }
    }
    if (j > bf.bk(getContext()) * 3)
    {
      i = 1;
      if ((!bool1) && ((i == 0) || (!this.afSs))) {
        break label199;
      }
    }
    label199:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (getPaddingBottom() != j)) {
        post(new InsectRelativeLayout..ExternalSyntheticLambda0(this, j));
      }
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(251733);
      return;
      i = 0;
      break;
    }
  }
  
  public final void setDiscardKeyboard(boolean paramBoolean)
  {
    this.afSs = paramBoolean;
  }
  
  public final void setInsectCallback(b<? super Integer, Boolean> paramb)
  {
    this.afSr = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InsectRelativeLayout
 * JD-Core Version:    0.7.0.1
 */