package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.b.j;
import a.l;
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

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorFrameView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBoundaryColor", "mMaskColor", "mPaint", "Landroid/graphics/Paint;", "mPath", "Landroid/graphics/Path;", "mPosition", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorFramePosition;", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setMaskColor", "maskColor", "setPosition", "position", "plugin-story_release"})
public final class EditorFrameView
  extends View
{
  private Paint mPaint;
  private Path ou;
  private int sOP;
  private int sOQ;
  private a sOR;
  
  public EditorFrameView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(110547);
    this.sOP = -1;
    this.sOQ = -1;
    this.sOR = a.sOK;
    this.mPaint = new Paint();
    this.ou = new Path();
    init();
    AppMethodBeat.o(110547);
  }
  
  public EditorFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(110548);
    this.sOP = -1;
    this.sOQ = -1;
    this.sOR = a.sOK;
    this.mPaint = new Paint();
    this.ou = new Path();
    init();
    AppMethodBeat.o(110548);
  }
  
  public EditorFrameView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110549);
    this.sOP = -1;
    this.sOQ = -1;
    this.sOR = a.sOK;
    this.mPaint = new Paint();
    this.ou = new Path();
    init();
    AppMethodBeat.o(110549);
  }
  
  private final void init()
  {
    AppMethodBeat.i(110544);
    Context localContext = getContext();
    j.p(localContext, "context");
    this.sOP = localContext.getResources().getColor(2131690535);
    int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 1);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStrokeWidth(2.0F * i);
    this.mPaint.setColor(this.sOQ);
    this.mPaint.setPathEffect((PathEffect)new DashPathEffect(new float[] { i * 4.0F, i * 4.0F }, 0.0F));
    AppMethodBeat.o(110544);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(110546);
    super.onDraw(paramCanvas);
    if (paramCanvas != null) {
      paramCanvas.save();
    }
    if (paramCanvas != null) {
      paramCanvas.drawColor(this.sOP);
    }
    a locala = this.sOR;
    switch (b.bLo[locala.ordinal()])
    {
    }
    while (paramCanvas != null)
    {
      paramCanvas.restore();
      AppMethodBeat.o(110546);
      return;
      this.ou.moveTo(getWidth(), 0.0F);
      this.ou.lineTo(getWidth(), getHeight());
      if (paramCanvas != null)
      {
        paramCanvas.drawPath(this.ou, this.mPaint);
        continue;
        this.ou.moveTo(0.0F, getHeight());
        this.ou.lineTo(getWidth(), getHeight());
        if (paramCanvas != null)
        {
          paramCanvas.drawPath(this.ou, this.mPaint);
          continue;
          this.ou.moveTo(0.0F, 0.0F);
          this.ou.lineTo(0.0F, getHeight());
          if (paramCanvas != null)
          {
            paramCanvas.drawPath(this.ou, this.mPaint);
            continue;
            this.ou.moveTo(0.0F, 0.0F);
            this.ou.lineTo(getWidth(), 0.0F);
            if (paramCanvas != null) {
              paramCanvas.drawPath(this.ou, this.mPaint);
            }
          }
        }
      }
    }
    AppMethodBeat.o(110546);
  }
  
  public final void setMaskColor(int paramInt)
  {
    this.sOP = paramInt;
  }
  
  public final void setPosition(a parama)
  {
    AppMethodBeat.i(110545);
    j.q(parama, "position");
    this.sOR = parama;
    AppMethodBeat.o(110545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorFrameView
 * JD-Core Version:    0.7.0.1
 */