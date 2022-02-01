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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.recordvideo.b.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBoundaryColor", "mMaskColor", "mPaint", "Landroid/graphics/Paint;", "mPath", "Landroid/graphics/Path;", "mPosition", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFramePosition;", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setMaskColor", "maskColor", "setPosition", "position", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EditorFrameView
  extends View
{
  private c NVA;
  private int NVy;
  private int NVz;
  private Path cja;
  private Paint mPaint;
  
  public EditorFrameView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(75980);
    this.NVy = -1;
    this.NVz = -1;
    this.NVA = c.NVt;
    this.mPaint = new Paint();
    this.cja = new Path();
    init();
    AppMethodBeat.o(75980);
  }
  
  public EditorFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75981);
    this.NVy = -1;
    this.NVz = -1;
    this.NVA = c.NVt;
    this.mPaint = new Paint();
    this.cja = new Path();
    init();
    AppMethodBeat.o(75981);
  }
  
  public EditorFrameView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(75982);
    this.NVy = -1;
    this.NVz = -1;
    this.NVA = c.NVt;
    this.mPaint = new Paint();
    this.cja = new Path();
    init();
    AppMethodBeat.o(75982);
  }
  
  private final void init()
  {
    AppMethodBeat.i(75977);
    this.NVy = getContext().getResources().getColor(b.b.story_editor_frame_mask_color);
    int i = a.fromDPToPix(getContext(), 1);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStrokeWidth(2.0F * i);
    this.mPaint.setColor(this.NVz);
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
      paramCanvas.drawColor(this.NVy);
    }
    c localc = this.NVA;
    switch (a.$EnumSwitchMapping$0[localc.ordinal()])
    {
    }
    for (;;)
    {
      if (paramCanvas != null) {
        paramCanvas.restore();
      }
      AppMethodBeat.o(75979);
      return;
      this.cja.moveTo(getWidth(), 0.0F);
      this.cja.lineTo(getWidth(), getHeight());
      if (paramCanvas != null)
      {
        paramCanvas.drawPath(this.cja, this.mPaint);
        continue;
        this.cja.moveTo(0.0F, getHeight());
        this.cja.lineTo(getWidth(), getHeight());
        if (paramCanvas != null)
        {
          paramCanvas.drawPath(this.cja, this.mPaint);
          continue;
          this.cja.moveTo(0.0F, 0.0F);
          this.cja.lineTo(0.0F, getHeight());
          if (paramCanvas != null)
          {
            paramCanvas.drawPath(this.cja, this.mPaint);
            continue;
            this.cja.moveTo(0.0F, 0.0F);
            this.cja.lineTo(getWidth(), 0.0F);
            if (paramCanvas != null) {
              paramCanvas.drawPath(this.cja, this.mPaint);
            }
          }
        }
      }
    }
  }
  
  public final void setMaskColor(int paramInt)
  {
    this.NVy = paramInt;
  }
  
  public final void setPosition(c paramc)
  {
    AppMethodBeat.i(75978);
    s.u(paramc, "position");
    this.NVA = paramc;
    AppMethodBeat.o(75978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorFrameView
 * JD-Core Version:    0.7.0.1
 */