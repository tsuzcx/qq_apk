package com.tencent.mm.plugin.teenmode.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.teenmode.a.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/ui/RoundCornerScrollView;", "Landroid/widget/ScrollView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "radiusF", "", "rect", "Landroid/graphics/RectF;", "TeenModeOutlineProvider", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RoundCornerScrollView
  extends ScrollView
{
  private final float Tan;
  private final RectF ekW;
  private final Path path;
  
  public RoundCornerScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(279040);
    AppMethodBeat.o(279040);
  }
  
  public RoundCornerScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(279054);
    this.Tan = a.fromDPToPix(MMApplicationContext.getContext(), 8);
    this.path = new Path();
    this.ekW = new RectF();
    setClipToOutline(true);
    setOutlineProvider((ViewOutlineProvider)new a(this.Tan));
    setBackground(getContext().getResources().getDrawable(a.c.SVd));
    AppMethodBeat.o(279054);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/ui/RoundCornerScrollView$TeenModeOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "radius", "", "(F)V", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends ViewOutlineProvider
  {
    private float radius;
    
    public a(float paramFloat)
    {
      this.radius = paramFloat;
    }
    
    public final void getOutline(View paramView, Outline paramOutline)
    {
      AppMethodBeat.i(279162);
      Rect localRect = new Rect();
      if (paramView != null) {
        paramView.getDrawingRect(localRect);
      }
      paramView = new Rect(0, 0, localRect.right - localRect.left + 0, localRect.bottom - localRect.top + 0);
      if (paramOutline != null) {
        paramOutline.setRoundRect(paramView, this.radius);
      }
      AppMethodBeat.o(279162);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.RoundCornerScrollView
 * JD-Core Version:    0.7.0.1
 */