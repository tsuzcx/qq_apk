package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "Landroid/support/v7/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "radius", "setRadius", "", "RoundCornerOutlineProvider", "libmmui_release"})
public final class MMRoundCornerImageView
  extends AppCompatImageView
{
  private int radius;
  
  public MMRoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(204876);
    AppMethodBeat.o(204876);
  }
  
  public MMRoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204875);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMRoundCornerImageView);
      p.g(paramContext, "context.obtainStyledAttr…e.MMRoundCornerImageView)");
      this.radius = paramContext.getDimensionPixelSize(0, 0);
      paramContext.recycle();
    }
    setClipToOutline(true);
    setOutlineProvider((ViewOutlineProvider)new MMRoundCornerImageView.a(this.radius));
    AppMethodBeat.o(204875);
  }
  
  public final void setRadius(int paramInt)
  {
    AppMethodBeat.i(204874);
    this.radius = paramInt;
    setClipToOutline(true);
    setOutlineProvider((ViewOutlineProvider)new MMRoundCornerImageView.a(paramInt));
    AppMethodBeat.o(204874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMRoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */