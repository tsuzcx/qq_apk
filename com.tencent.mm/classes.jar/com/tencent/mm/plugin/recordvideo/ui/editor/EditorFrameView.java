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
import com.tencent.mm.cb.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBoundaryColor", "mMaskColor", "mPaint", "Landroid/graphics/Paint;", "mPath", "Landroid/graphics/Path;", "mPosition", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFramePosition;", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setMaskColor", "maskColor", "setPosition", "position", "plugin-recordvideo_release"})
public final class EditorFrameView
  extends View
{
  private int CcE;
  private int CcF;
  private c CcG;
  private Paint mPaint;
  private Path xT;
  
  public EditorFrameView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(75980);
    this.CcE = -1;
    this.CcF = -1;
    this.CcG = c.Ccz;
    this.mPaint = new Paint();
    this.xT = new Path();
    init();
    AppMethodBeat.o(75980);
  }
  
  public EditorFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75981);
    this.CcE = -1;
    this.CcF = -1;
    this.CcG = c.Ccz;
    this.mPaint = new Paint();
    this.xT = new Path();
    init();
    AppMethodBeat.o(75981);
  }
  
  public EditorFrameView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(75982);
    this.CcE = -1;
    this.CcF = -1;
    this.CcG = c.Ccz;
    this.mPaint = new Paint();
    this.xT = new Path();
    init();
    AppMethodBeat.o(75982);
  }
  
  private final void init()
  {
    AppMethodBeat.i(75977);
    Context localContext = getContext();
    p.g(localContext, "context");
    this.CcE = localContext.getResources().getColor(2131101197);
    int i = a.fromDPToPix(getContext(), 1);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStrokeWidth(2.0F * i);
    this.mPaint.setColor(this.CcF);
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
      paramCanvas.drawColor(this.CcE);
    }
    c localc = this.CcG;
    switch (d.$EnumSwitchMapping$0[localc.ordinal()])
    {
    }
    while (paramCanvas != null)
    {
      paramCanvas.restore();
      AppMethodBeat.o(75979);
      return;
      this.xT.moveTo(getWidth(), 0.0F);
      this.xT.lineTo(getWidth(), getHeight());
      if (paramCanvas != null)
      {
        paramCanvas.drawPath(this.xT, this.mPaint);
        continue;
        this.xT.moveTo(0.0F, getHeight());
        this.xT.lineTo(getWidth(), getHeight());
        if (paramCanvas != null)
        {
          paramCanvas.drawPath(this.xT, this.mPaint);
          continue;
          this.xT.moveTo(0.0F, 0.0F);
          this.xT.lineTo(0.0F, getHeight());
          if (paramCanvas != null)
          {
            paramCanvas.drawPath(this.xT, this.mPaint);
            continue;
            this.xT.moveTo(0.0F, 0.0F);
            this.xT.lineTo(getWidth(), 0.0F);
            if (paramCanvas != null) {
              paramCanvas.drawPath(this.xT, this.mPaint);
            }
          }
        }
      }
    }
    AppMethodBeat.o(75979);
  }
  
  public final void setMaskColor(int paramInt)
  {
    this.CcE = paramInt;
  }
  
  public final void setPosition(c paramc)
  {
    AppMethodBeat.i(75978);
    p.h(paramc, "position");
    this.CcG = paramc;
    AppMethodBeat.o(75978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorFrameView
 * JD-Core Version:    0.7.0.1
 */