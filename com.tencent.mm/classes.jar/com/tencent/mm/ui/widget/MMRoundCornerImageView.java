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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "postCompactHelper", "Lcom/tencent/mm/ui/widget/PostCompactHelper;", "radius", "onAttachedToWindow", "", "onDetachedFromWindow", "post", "", "action", "Ljava/lang/Runnable;", "setRadius", "RoundCornerOutlineProvider", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMRoundCornerImageView
  extends AppCompatImageView
{
  private final j afTB;
  private int radius;
  
  public MMRoundCornerImageView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(251544);
    AppMethodBeat.o(251544);
  }
  
  public MMRoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(251547);
    AppMethodBeat.o(251547);
  }
  
  public MMRoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(251541);
    this.afTB = new j((View)this);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.MMRoundCornerImageView);
      s.s(paramContext, "context.obtainStyledAttr…e.MMRoundCornerImageView)");
      this.radius = paramContext.getDimensionPixelSize(a.m.MMRoundCornerImageView_radius, 0);
      paramContext.recycle();
    }
    setClipToOutline(true);
    setOutlineProvider((ViewOutlineProvider)new a(this.radius));
    AppMethodBeat.o(251541);
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(251551);
    super.onAttachedToWindow();
    this.afTB.onAttachedToWindow();
    AppMethodBeat.o(251551);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(251553);
    super.onDetachedFromWindow();
    this.afTB.afUA = false;
    AppMethodBeat.o(251553);
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(251557);
    if (this.afTB.post(paramRunnable))
    {
      AppMethodBeat.o(251557);
      return true;
    }
    boolean bool = super.post(paramRunnable);
    AppMethodBeat.o(251557);
    return bool;
  }
  
  public final void setRadius(int paramInt)
  {
    AppMethodBeat.i(251562);
    this.radius = paramInt;
    setClipToOutline(true);
    setOutlineProvider((ViewOutlineProvider)new a(paramInt));
    AppMethodBeat.o(251562);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/MMRoundCornerImageView$RoundCornerOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "radius", "", "(I)V", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
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
      AppMethodBeat.i(251577);
      int i;
      if (paramView == null)
      {
        i = 0;
        if (paramView != null) {
          break label59;
        }
      }
      label59:
      for (int j = 0;; j = paramView.getMeasuredHeight())
      {
        paramView = new Rect(0, 0, i, j);
        if (paramOutline != null) {
          paramOutline.setRoundRect(paramView, this.radius);
        }
        AppMethodBeat.o(251577);
        return;
        i = paramView.getMeasuredWidth();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMRoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */