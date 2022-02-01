package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/PostCompactView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "postCompactHelper", "Lcom/tencent/mm/ui/widget/PostCompactHelper;", "onAttachedToWindow", "", "onDetachedFromWindow", "post", "", "action", "Ljava/lang/Runnable;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PostCompactView
  extends View
{
  private final j afTB;
  
  public PostCompactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
    AppMethodBeat.i(251522);
    AppMethodBeat.o(251522);
  }
  
  public PostCompactView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(251520);
    this.afTB = new j((View)this);
    AppMethodBeat.o(251520);
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(251524);
    super.onAttachedToWindow();
    this.afTB.onAttachedToWindow();
    AppMethodBeat.o(251524);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(251528);
    super.onDetachedFromWindow();
    this.afTB.afUA = false;
    AppMethodBeat.o(251528);
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(251532);
    if (this.afTB.post(paramRunnable))
    {
      AppMethodBeat.o(251532);
      return true;
    }
    boolean bool = super.post(paramRunnable);
    AppMethodBeat.o(251532);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.PostCompactView
 * JD-Core Version:    0.7.0.1
 */