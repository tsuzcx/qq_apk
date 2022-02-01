package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class InsectFrameLayout
  extends FrameLayout
{
  private Rect LGX;
  private final String TAG;
  private int[] afSq;
  private b<? super Integer, Boolean> afSr;
  
  public InsectFrameLayout(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(251698);
    AppMethodBeat.o(251698);
  }
  
  public InsectFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(251695);
    AppMethodBeat.o(251695);
  }
  
  public InsectFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(251691);
    this.TAG = "MicroMsg.InsectLayout";
    this.LGX = new Rect();
    this.afSq = new int[2];
    AppMethodBeat.o(251691);
  }
  
  private static final void a(InsectFrameLayout paramInsectFrameLayout, int paramInt)
  {
    AppMethodBeat.i(251700);
    s.u(paramInsectFrameLayout, "this$0");
    Log.i(paramInsectFrameLayout.TAG, s.X("InsectFrameLayout onLayout. bottomInsect=", Integer.valueOf(paramInt)));
    paramInsectFrameLayout.setPadding(paramInsectFrameLayout.getPaddingLeft(), paramInsectFrameLayout.getPaddingTop(), paramInsectFrameLayout.getPaddingRight(), paramInt);
    paramInsectFrameLayout.requestLayout();
    AppMethodBeat.o(251700);
  }
  
  public boolean La(int paramInt)
  {
    return false;
  }
  
  public final b<Integer, Boolean> getInsectCallback()
  {
    return this.afSr;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(251708);
    getWindowVisibleDisplayFrame(this.LGX);
    getLocationOnScreen(this.afSq);
    int i = paramInt4 - paramInt2 + this.afSq[1] - this.LGX.bottom;
    boolean bool2 = La(i);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (this.afSr != null)
      {
        b localb = this.afSr;
        s.checkNotNull(localb);
        bool1 = ((Boolean)localb.invoke(Integer.valueOf(i))).booleanValue();
      }
    }
    Log.d(this.TAG, "InsectFrameLayout onLayout. handled=" + bool1 + " bottom=" + paramInt4);
    if ((!bool1) && (getPaddingBottom() != i)) {
      post(new InsectFrameLayout..ExternalSyntheticLambda0(this, i));
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(251708);
  }
  
  public final void setInsectCallback(b<? super Integer, Boolean> paramb)
  {
    this.afSr = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.InsectFrameLayout
 * JD-Core Version:    0.7.0.1
 */