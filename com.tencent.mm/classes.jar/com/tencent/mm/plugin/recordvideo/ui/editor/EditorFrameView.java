package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBoundaryColor", "mMaskColor", "mPaint", "Landroid/graphics/Paint;", "mPath", "Landroid/graphics/Path;", "mPosition", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFramePosition;", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setMaskColor", "maskColor", "setPosition", "position", "plugin-recordvideo_release"})
public final class EditorFrameView
  extends View
{
  private Paint mPaint;
  private int xLI;
  private int xLJ;
  private c xLK;
  private Path xN;
  
  public EditorFrameView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(75980);
    this.xLI = -1;
    this.xLJ = -1;
    this.xLK = c.xLD;
    this.mPaint = new Paint();
    this.xN = new Path();
    init();
    AppMethodBeat.o(75980);
  }
  
  public EditorFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75981);
    this.xLI = -1;
    this.xLJ = -1;
    this.xLK = c.xLD;
    this.mPaint = new Paint();
    this.xN = new Path();
    init();
    AppMethodBeat.o(75981);
  }
  
  public EditorFrameView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(75982);
    this.xLI = -1;
    this.xLJ = -1;
    this.xLK = c.xLD;
    this.mPaint = new Paint();
    this.xN = new Path();
    init();
    AppMethodBeat.o(75982);
  }
  
  private final void init()
  {
    AppMethodBeat.i(75977);
    Context localContext = getContext();
    p.g(localContext, "context");
    this.xLI = localContext.getResources().getColor(2131100969);
    int i = a.fromDPToPix(getContext(), 1);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStrokeWidth(2.0F * i);
    this.mPaint.setColor(this.xLJ);
    this.mPaint.setPathEffect((PathEffect)new DashPathEffect(new float[] { i * 4.0F, i * 4.0F }, 0.0F));
    AppMethodBeat.o(75977);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(75979);
    super.onDraw(paramCanvas);
    if (paramCanvas != null) {
      paramCanvas.save();
    }
    if (paramCanvas != null) {
      paramCanvas.drawColor(this.xLI);
    }
    c localc = this.xLK;
    switch (d.cpQ[localc.ordinal()])
    {
    }
    while (paramCanvas != null)
    {
      paramCanvas.restore();
      AppMethodBeat.o(75979);
      return;
      this.xN.moveTo(getWidth(), 0.0F);
      this.xN.lineTo(getWidth(), getHeight());
      if (paramCanvas != null)
      {
        paramCanvas.drawPath(this.xN, this.mPaint);
        continue;
        this.xN.moveTo(0.0F, getHeight());
        this.xN.lineTo(getWidth(), getHeight());
        if (paramCanvas != null)
        {
          paramCanvas.drawPath(this.xN, this.mPaint);
          continue;
          this.xN.moveTo(0.0F, 0.0F);
          this.xN.lineTo(0.0F, getHeight());
          if (paramCanvas != null)
          {
            paramCanvas.drawPath(this.xN, this.mPaint);
            continue;
            this.xN.moveTo(0.0F, 0.0F);
            this.xN.lineTo(getWidth(), 0.0F);
            if (paramCanvas != null) {
              paramCanvas.drawPath(this.xN, this.mPaint);
            }
          }
        }
      }
    }
    AppMethodBeat.o(75979);
  }
  
  public final void setMaskColor(int paramInt)
  {
    this.xLI = paramInt;
  }
  
  public final void setPosition(c paramc)
  {
    AppMethodBeat.i(75978);
    p.h(paramc, "position");
    this.xLK = paramc;
    AppMethodBeat.o(75978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorFrameView
 * JD-Core Version:    0.7.0.1
 */