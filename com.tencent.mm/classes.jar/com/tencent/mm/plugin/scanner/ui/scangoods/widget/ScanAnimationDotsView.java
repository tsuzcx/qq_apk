package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ae;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationType", "controller", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanDotsAnimationController;", "viewHeight", "viewWidth", "addAnimationDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "init", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshView", "release", "setDuration", "duration", "", "show", "visible", "", "startAnimation", "stopAnimation", "Companion", "plugin-scan_release"})
public final class ScanAnimationDotsView
  extends View
  implements d
{
  public static final ScanAnimationDotsView.a CPJ;
  private int CIp;
  private e CPI;
  private int gRD;
  private int gRE;
  
  static
  {
    AppMethodBeat.i(52285);
    CPJ = new ScanAnimationDotsView.a((byte)0);
    AppMethodBeat.o(52285);
  }
  
  public ScanAnimationDotsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(52283);
    AppMethodBeat.o(52283);
  }
  
  public ScanAnimationDotsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(52284);
    this.CIp = 1;
    this.CPI = i.a(this.CIp, paramContext, (d)this);
    AppMethodBeat.o(52284);
  }
  
  public final void b(ae paramae)
  {
    AppMethodBeat.i(52280);
    p.h(paramae, "pointsResult");
    Log.v("MicroMsg.ScanAnimationDotsView", "alvinluo addAnimationDots size: %d", new Object[] { Integer.valueOf(paramae.pointCount) });
    e locale = this.CPI;
    if (locale != null)
    {
      locale.b(paramae);
      AppMethodBeat.o(52280);
      return;
    }
    AppMethodBeat.o(52280);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(52275);
    super.onDraw(paramCanvas);
    e locale = this.CPI;
    if (locale != null)
    {
      locale.draw(paramCanvas);
      AppMethodBeat.o(52275);
      return;
    }
    AppMethodBeat.o(52275);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52276);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.gRD != getMeasuredWidth()) || (this.gRE != getMeasuredHeight()))
    {
      this.gRD = getMeasuredWidth();
      this.gRE = getMeasuredHeight();
      e locale = this.CPI;
      if (locale != null)
      {
        locale.ih(this.gRD, this.gRE);
        AppMethodBeat.o(52276);
        return;
      }
    }
    AppMethodBeat.o(52276);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(52278);
    e locale = this.CPI;
    if (locale != null) {
      locale.refreshView();
    }
    invalidate();
    AppMethodBeat.o(52278);
  }
  
  public final void release()
  {
    AppMethodBeat.i(52282);
    e locale = this.CPI;
    if (locale != null)
    {
      locale.release();
      AppMethodBeat.o(52282);
      return;
    }
    AppMethodBeat.o(52282);
  }
  
  public final void setDuration(long paramLong)
  {
    AppMethodBeat.i(52277);
    e locale = this.CPI;
    if (locale != null)
    {
      locale.setDuration(paramLong);
      AppMethodBeat.o(52277);
      return;
    }
    AppMethodBeat.o(52277);
  }
  
  public final void startAnimation()
  {
    AppMethodBeat.i(52279);
    Log.v("MicroMsg.ScanAnimationDotsView", "alvinluo startAnimation type: %d", new Object[] { Integer.valueOf(this.CIp) });
    e locale = this.CPI;
    if (locale != null)
    {
      locale.startAnimation();
      AppMethodBeat.o(52279);
      return;
    }
    AppMethodBeat.o(52279);
  }
  
  public final void stopAnimation()
  {
    AppMethodBeat.i(52281);
    Log.v("MicroMsg.ScanAnimationDotsView", "alvinluo stopAnimation");
    e locale = this.CPI;
    if (locale != null)
    {
      locale.stopAnimation();
      AppMethodBeat.o(52281);
      return;
    }
    AppMethodBeat.o(52281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanAnimationDotsView
 * JD-Core Version:    0.7.0.1
 */