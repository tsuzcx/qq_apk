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
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarBottomView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "drawColor", "leftArcRectF", "Landroid/graphics/RectF;", "mContext", "mPaint", "Landroid/graphics/Paint;", "mPath", "Landroid/graphics/Path;", "radii", "", "radius", "", "rightArcRectF", "computeRadius", "", "dp", "init", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setDrawColor", "color", "setTopRoundRadius", "topRadius", "Companion", "plugin-taskbar_release"})
public final class TaskBarBottomView
  extends View
{
  public static final a FTD;
  private float[] FTA;
  private RectF FTB;
  private RectF FTC;
  private int FTz;
  private Context mContext;
  private Paint mPaint;
  private float radius;
  private Path xT;
  
  static
  {
    AppMethodBeat.i(238447);
    FTD = new a((byte)0);
    AppMethodBeat.o(238447);
  }
  
  public TaskBarBottomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(238445);
    this.mPaint = new Paint();
    this.xT = new Path();
    this.FTA = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    this.FTB = new RectF();
    this.FTC = new RectF();
    init(paramContext);
    AppMethodBeat.o(238445);
  }
  
  public TaskBarBottomView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(238446);
    this.mPaint = new Paint();
    this.xT = new Path();
    this.FTA = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    this.FTB = new RectF();
    this.FTC = new RectF();
    init(paramContext);
    AppMethodBeat.o(238446);
  }
  
  private final void abz(int paramInt)
  {
    AppMethodBeat.i(238441);
    this.radius = a.fromDPToPix(getContext(), paramInt);
    this.FTA[0] = this.radius;
    this.FTA[1] = this.radius;
    this.FTA[2] = this.radius;
    this.FTA[3] = this.radius;
    Log.i("Mp.AppBrandDesktopBottomView", "alvinluo computeRadius radius: %f", new Object[] { Float.valueOf(this.radius) });
    AppMethodBeat.o(238441);
  }
  
  private final void init(Context paramContext)
  {
    AppMethodBeat.i(238440);
    this.mContext = paramContext;
    this.FTz = getResources().getColor(2131099949);
    abz(8);
    AppMethodBeat.o(238440);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(238444);
    super.onDraw(paramCanvas);
    this.mPaint.setColor(this.FTz);
    this.mPaint.setStyle(Paint.Style.FILL);
    if (d.oF(20))
    {
      this.xT.addRoundRect(getLeft(), getTop(), getRight(), getBottom(), this.FTA, Path.Direction.CCW);
      if (paramCanvas != null) {
        paramCanvas.drawPath(this.xT, this.mPaint);
      }
      this.xT.reset();
      AppMethodBeat.o(238444);
      return;
    }
    this.FTB.set(getLeft(), getTop(), getLeft() + this.radius * 2.0F, getTop() + this.radius * 2.0F);
    this.FTC.set(getRight() - this.radius * 2.0F, getTop(), getRight(), getTop() + this.radius * 2.0F);
    if (paramCanvas != null) {
      paramCanvas.drawArc(this.FTB, 180.0F, 90.0F, true, this.mPaint);
    }
    if (paramCanvas != null) {
      paramCanvas.drawArc(this.FTC, 270.0F, 90.0F, true, this.mPaint);
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
      AppMethodBeat.o(238444);
      return;
    }
    AppMethodBeat.o(238444);
  }
  
  public final void setDrawColor(int paramInt)
  {
    AppMethodBeat.i(238443);
    this.FTz = paramInt;
    invalidate();
    AppMethodBeat.o(238443);
  }
  
  public final void setTopRoundRadius(int paramInt)
  {
    AppMethodBeat.i(238442);
    abz(paramInt);
    AppMethodBeat.o(238442);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarBottomView$Companion;", "", "()V", "DEFAULT_RADIUS_IN_DP", "", "TAG", "", "plugin-taskbar_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.TaskBarBottomView
 * JD-Core Version:    0.7.0.1
 */