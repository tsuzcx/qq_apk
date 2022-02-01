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
import com.tencent.mm.cd.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.taskbar.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarBottomView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "drawColor", "leftArcRectF", "Landroid/graphics/RectF;", "mContext", "mPaint", "Landroid/graphics/Paint;", "mPath", "Landroid/graphics/Path;", "radii", "", "radius", "", "rightArcRectF", "computeRadius", "", "dp", "init", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setDrawColor", "color", "setTopRoundRadius", "topRadius", "Companion", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TaskBarBottomView
  extends View
{
  public static final TaskBarBottomView.a SRU;
  private int SRV;
  private RectF SRW;
  private RectF SRX;
  private float[] avP;
  private Path cja;
  private Context mContext;
  private Paint mPaint;
  private float radius;
  
  static
  {
    AppMethodBeat.i(264084);
    SRU = new TaskBarBottomView.a((byte)0);
    AppMethodBeat.o(264084);
  }
  
  public TaskBarBottomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(264059);
    this.mPaint = new Paint();
    this.cja = new Path();
    this.avP = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    this.SRW = new RectF();
    this.SRX = new RectF();
    init(paramContext);
    AppMethodBeat.o(264059);
  }
  
  public TaskBarBottomView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(264066);
    this.mPaint = new Paint();
    this.cja = new Path();
    this.avP = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    this.SRW = new RectF();
    this.SRX = new RectF();
    init(paramContext);
    AppMethodBeat.o(264066);
  }
  
  private final void anV(int paramInt)
  {
    AppMethodBeat.i(264078);
    this.radius = a.fromDPToPix(getContext(), paramInt);
    this.avP[0] = this.radius;
    this.avP[1] = this.radius;
    this.avP[2] = this.radius;
    this.avP[3] = this.radius;
    Log.i("Mp.AppBrandDesktopBottomView", "alvinluo computeRadius radius: %f", new Object[] { Float.valueOf(this.radius) });
    AppMethodBeat.o(264078);
  }
  
  private final void init(Context paramContext)
  {
    AppMethodBeat.i(264072);
    this.mContext = paramContext;
    this.SRV = getResources().getColor(d.a.app_brand_desktop_bottom_action_bar_color);
    anV(8);
    AppMethodBeat.o(264072);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(264109);
    super.onDraw(paramCanvas);
    this.mPaint.setColor(this.SRV);
    this.mPaint.setStyle(Paint.Style.FILL);
    if (d.rd(20))
    {
      this.cja.addRoundRect(getLeft(), getTop(), getRight(), getBottom(), this.avP, Path.Direction.CCW);
      if (paramCanvas != null) {
        paramCanvas.drawPath(this.cja, this.mPaint);
      }
      this.cja.reset();
      AppMethodBeat.o(264109);
      return;
    }
    this.SRW.set(getLeft(), getTop(), getLeft() + this.radius * 2.0F, getTop() + this.radius * 2.0F);
    this.SRX.set(getRight() - this.radius * 2.0F, getTop(), getRight(), getTop() + this.radius * 2.0F);
    if (paramCanvas != null) {
      paramCanvas.drawArc(this.SRW, 180.0F, 90.0F, true, this.mPaint);
    }
    if (paramCanvas != null) {
      paramCanvas.drawArc(this.SRX, 270.0F, 90.0F, true, this.mPaint);
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
    }
    AppMethodBeat.o(264109);
  }
  
  public final void setDrawColor(int paramInt)
  {
    AppMethodBeat.i(264101);
    this.SRV = paramInt;
    invalidate();
    AppMethodBeat.o(264101);
  }
  
  public final void setTopRoundRadius(int paramInt)
  {
    AppMethodBeat.i(264093);
    anV(paramInt);
    AppMethodBeat.o(264093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.TaskBarBottomView
 * JD-Core Version:    0.7.0.1
 */