package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.m;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "radius", "setRadius", "", "RoundCornerOutlineProvider", "libmmui_release"})
public final class MMRoundCornerImageView
  extends AppCompatImageView
{
  private int radius;
  
  public MMRoundCornerImageView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(207958);
    AppMethodBeat.o(207958);
  }
  
  public MMRoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(207960);
    AppMethodBeat.o(207960);
  }
  
  public MMRoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(207955);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.MMRoundCornerImageView);
      p.j(paramContext, "context.obtainStyledAttr…e.MMRoundCornerImageView)");
      this.radius = paramContext.getDimensionPixelSize(a.m.MMRoundCornerImageView_radius, 0);
      paramContext.recycle();
    }
    setClipToOutline(true);
    setOutlineProvider((ViewOutlineProvider)new a(this.radius));
    AppMethodBeat.o(207955);
  }
  
  public final void setRadius(int paramInt)
  {
    AppMethodBeat.i(207953);
    this.radius = paramInt;
    setClipToOutline(true);
    setOutlineProvider((ViewOutlineProvider)new a(paramInt));
    AppMethodBeat.o(207953);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/MMRoundCornerImageView$RoundCornerOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "radius", "", "(I)V", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "libmmui_release"})
  public static final class a
    extends ViewOutlineProvider
  {
    private int radius;
    
    public a(int paramInt)
    {
      this.radius = paramInt;
    }
    
    public final void getOutline(View paramView, Outline paramOutline)
    {
      AppMethodBeat.i(205969);
      int i;
      if (paramView != null)
      {
        i = paramView.getMeasuredWidth();
        if (paramView == null) {
          break label62;
        }
      }
      label62:
      for (int j = paramView.getMeasuredHeight();; j = 0)
      {
        paramView = new Rect(0, 0, i, j);
        if (paramOutline == null) {
          break label68;
        }
        paramOutline.setRoundRect(paramView, this.radius);
        AppMethodBeat.o(205969);
        return;
        i = 0;
        break;
      }
      label68:
      AppMethodBeat.o(205969);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMRoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */