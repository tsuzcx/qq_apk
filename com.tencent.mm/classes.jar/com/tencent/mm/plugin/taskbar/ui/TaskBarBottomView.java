package com.tencent.mm.plugin.taskbar.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.taskbar.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarBottomView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "drawColor", "leftArcRectF", "Landroid/graphics/RectF;", "mContext", "mPaint", "Landroid/graphics/Paint;", "mPath", "Landroid/graphics/Path;", "radii", "", "radius", "", "rightArcRectF", "computeRadius", "", "dp", "init", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setDrawColor", "color", "setTopRoundRadius", "topRadius", "Companion", "plugin-taskbar_release"})
public final class TaskBarBottomView
  extends View
{
  public static final a MoE;
  private int MoA;
  private float[] MoB;
  private RectF MoC;
  private RectF MoD;
  private Path auD;
  private Context mContext;
  private Paint mPaint;
  private float radius;
  
  static
  {
    AppMethodBeat.i(214971);
    MoE = new a((byte)0);
    AppMethodBeat.o(214971);
  }
  
  public TaskBarBottomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(214965);
    this.mPaint = new Paint();
    this.auD = new Path();
    this.MoB = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    this.MoC = new RectF();
    this.MoD = new RectF();
    init(paramContext);
    AppMethodBeat.o(214965);
  }
  
  public TaskBarBottomView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(214969);
    this.mPaint = new Paint();
    this.auD = new Path();
    this.MoB = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    this.MoC = new RectF();
    this.MoD = new RectF();
    init(paramContext);
    AppMethodBeat.o(214969);
  }
  
  private final void aiT(int paramInt)
  {
    AppMethodBeat.i(214959);
    this.radius = a.fromDPToPix(getContext(), paramInt);
    this.MoB[0] = this.radius;
    this.MoB[1] = this.radius;
    this.MoB[2] = this.radius;
    this.MoB[3] = this.radius;
    Log.i("Mp.AppBrandDesktopBottomView", "alvinluo computeRadius radius: %f", new Object[] { Float.valueOf(this.radius) });
    AppMethodBeat.o(214959);
  }
  
  private final void init(Context paramContext)
  {
    AppMethodBeat.i(214957);
    this.mContext = paramContext;
    this.MoA = getResources().getColor(d.a.app_brand_desktop_bottom_action_bar_color);
    aiT(8);
    AppMethodBeat.o(214957);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(214964);
    super.onDraw(paramCanvas);
    this.mPaint.setColor(this.MoA);
    this.mPaint.setStyle(Paint.Style.FILL);
    if (d.qX(20))
    {
      this.auD.addRoundRect(getLeft(), getTop(), getRight(), getBottom(), this.MoB, Path.Direction.CCW);
      if (paramCanvas != null) {
        paramCanvas.drawPath(this.auD, this.mPaint);
      }
      this.auD.reset();
      AppMethodBeat.o(214964);
      return;
    }
    this.MoC.set(getLeft(), getTop(), getLeft() + this.radius * 2.0F, getTop() + this.radius * 2.0F);
    this.MoD.set(getRight() - this.radius * 2.0F, getTop(), getRight(), getTop() + this.radius * 2.0F);
    if (paramCanvas != null) {
      paramCanvas.drawArc(this.MoC, 180.0F, 90.0F, true, this.mPaint);
    }
    if (paramCanvas != null) {
      paramCanvas.drawArc(this.MoD, 270.0F, 90.0F, true, this.mPaint);
    }
    float f1;
    if (paramCanvas != null)
    {
      f1 = getLeft();
      paramCanvas.drawRect(this.radius + f1, getTop(), getRight() - this.radius, this.radius, this.mPaint);
    }
    if (paramCanvas != null)
    {
      f1 = getLeft();
      float f2 = getTop();
      paramCanvas.drawRect(f1, this.radius + f2, getRight(), getBottom(), this.mPaint);
      AppMethodBeat.o(214964);
      return;
    }
    AppMethodBeat.o(214964);
  }
  
  public final void setDrawColor(int paramInt)
  {
    AppMethodBeat.i(214962);
    this.MoA = paramInt;
    invalidate();
    AppMethodBeat.o(214962);
  }
  
  public final void setTopRoundRadius(int paramInt)
  {
    AppMethodBeat.i(214960);
    aiT(paramInt);
    AppMethodBeat.o(214960);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarBottomView$Companion;", "", "()V", "DEFAULT_RADIUS_IN_DP", "", "TAG", "", "plugin-taskbar_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.TaskBarBottomView
 * JD-Core Version:    0.7.0.1
 */