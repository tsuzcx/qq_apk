package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/InsectLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "discardKeyboard", "", "getDiscardKeyboard", "()Z", "setDiscardKeyboard", "(Z)V", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class InsectLinearLayout
  extends LinearLayout
{
  private Rect LGX;
  private final String TAG;
  private int[] afSq;
  private b<? super Integer, Boolean> afSr;
  private boolean afSs;
  
  public InsectLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(251743);
    AppMethodBeat.o(251743);
  }
  
  public InsectLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(251741);
    this.TAG = "MicroMsg.InsectLayout";
    this.LGX = new Rect();
    this.afSq = new int[2];
    AppMethodBeat.o(251741);
  }
  
  private static final void a(InsectLinearLayout paramInsectLinearLayout, int paramInt)
  {
    AppMethodBeat.i(251744);
    s.u(paramInsectLinearLayout, "this$0");
    paramInsectLinearLayout.setPadding(paramInsectLinearLayout.getPaddingLeft(), paramInsectLinearLayout.getPaddingTop(), paramInsectLinearLayout.getPaddingRight(), paramInt);
    paramInsectLinearLayout.requestLayout();
    AppMethodBeat.o(251744);
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
    int k = 0;
    AppMethodBeat.i(251754);
    Log.i(this.TAG, "InsectRelativeLayout onLayout");
    getWindowVisibleDisplayFrame(this.LGX);
    getLocationOnScreen(this.afSq);
    int m = paramInt4 - paramInt2 + this.afSq[1] - this.LGX.bottom;
    b localb;
    if (this.afSr != null)
    {
      localb = this.afSr;
      s.checkNotNull(localb);
    }
    for (boolean bool = ((Boolean)localb.invoke(Integer.valueOf(m))).booleanValue();; bool = false)
    {
      if (m > bf.bk(getContext()) * 3) {}
      for (int i = 1;; i = 0)
      {
        int j;
        if (!bool)
        {
          j = k;
          if (i != 0)
          {
            j = k;
            if (!this.afSs) {}
          }
        }
        else
        {
          j = 1;
        }
        if ((j == 0) && (getPaddingBottom() != m)) {
          post(new InsectLinearLayout..ExternalSyntheticLambda0(this, m));
        }
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        AppMethodBeat.o(251754);
        return;
      }
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
 * Qualified Name:     com.tencent.mm.ui.widget.InsectLinearLayout
 * JD-Core Version:    0.7.0.1
 */