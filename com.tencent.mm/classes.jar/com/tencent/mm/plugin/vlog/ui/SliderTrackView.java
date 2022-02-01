package com.tencent.mm.plugin.vlog.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/SliderTrackView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;)V", "pointCount", "pointSize", "selectIndex", "startOffset", "thumbDrawable", "Landroid/graphics/drawable/Drawable;", "thumbHeight", "thumbRect", "Landroid/graphics/Rect;", "thumbWidth", "thumbX", "", "thumbY", "touchDownX", "touchDownY", "touchDrag", "", "touchMoved", "touchSlop", "touchX", "touchY", "trackPaint", "Landroid/graphics/Paint;", "trackPoint", "Ljava/util/LinkedList;", "Landroid/graphics/PointF;", "clampThumbPoint", "x", "findThumbPoint", "", "getTrackPoint", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setPointCount", "setSelection", "index", "setStartOffset", "offset", "setThumbDrawable", "drawable", "setTrackColor", "color", "setTrackLineWidth", "lineWidth", "updateThumb", "updateTrackPoint", "plugin-vlog_release"})
public final class SliderTrackView
  extends View
{
  private LabelSlider.a CbD;
  private boolean Cdm;
  private final Paint Cdn;
  private int Cdo;
  private final LinkedList<PointF> Cdp;
  private float Cdq;
  private float Cdr;
  private final String TAG;
  private boolean gpb;
  private float gpe;
  private float gpf;
  private float gpg;
  private float gph;
  private Drawable npm;
  private int pointCount;
  private final int rW;
  private int startOffset;
  private int tci;
  private int thumbHeight;
  private int thumbWidth;
  private final Rect yKZ;
  
  public SliderTrackView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(191552);
    AppMethodBeat.o(191552);
  }
  
  public SliderTrackView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(191551);
    AppMethodBeat.o(191551);
  }
  
  public SliderTrackView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(191550);
    this.TAG = "MicroMsg.LabelSlider";
    this.Cdn = new Paint();
    this.pointCount = 5;
    this.startOffset = a.ax(paramContext, 2131165296);
    this.Cdo = a.ax(paramContext, 2131165303);
    this.Cdp = new LinkedList();
    this.yKZ = new Rect();
    this.thumbWidth = 48;
    this.thumbHeight = 48;
    this.Cdn.setStyle(Paint.Style.STROKE);
    this.Cdn.setColor(-855638017);
    this.Cdn.setStrokeWidth(a.getDensity(paramContext));
    paramContext = ViewConfiguration.get(paramContext);
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.rW = paramContext.getScaledTouchSlop();
    AppMethodBeat.o(191550);
  }
  
  private final void bJ(float paramFloat)
  {
    AppMethodBeat.i(191548);
    if (this.Cdp.size() < 2)
    {
      AppMethodBeat.o(191548);
      return;
    }
    float f1 = getWidth();
    int j = -1;
    int i = 0;
    int k = ((Collection)this.Cdp).size();
    if (i < k)
    {
      float f2 = Math.abs(paramFloat - ((PointF)this.Cdp.get(i)).x);
      if (f2 >= f1) {
        break label146;
      }
      j = i;
      f1 = f2;
    }
    label146:
    for (;;)
    {
      i += 1;
      break;
      if (j >= 0)
      {
        this.tci = j;
        ewF();
        LabelSlider.a locala = this.CbD;
        if (locala != null)
        {
          locala.If(this.tci);
          AppMethodBeat.o(191548);
          return;
        }
      }
      AppMethodBeat.o(191548);
      return;
    }
  }
  
  private final void ewE()
  {
    AppMethodBeat.i(191547);
    int j = (getWidth() - this.startOffset * 2) / (this.pointCount - 1);
    float f1 = this.startOffset;
    float f2 = getHeight() / 2.0F;
    this.Cdp.clear();
    this.Cdp.add(new PointF(f1, f2));
    int i = 0;
    int k = this.pointCount;
    while (i < k - 1)
    {
      float f3 = j * i;
      float f4 = j;
      this.Cdp.add(new PointF(f3 + f1 + f4, f2));
      i += 1;
    }
    this.Cdr = f2;
    ewF();
    postInvalidate();
    AppMethodBeat.o(191547);
  }
  
  private final void ewF()
  {
    AppMethodBeat.i(191549);
    this.yKZ.top = ((int)(this.Cdr - this.thumbHeight / 2));
    this.yKZ.bottom = ((int)(this.Cdr + this.thumbHeight / 2));
    this.Cdq = ((PointF)this.Cdp.get(this.tci)).x;
    this.yKZ.left = ((int)(this.Cdq - this.thumbWidth / 2));
    this.yKZ.right = ((int)(this.Cdq + this.thumbWidth / 2));
    AppMethodBeat.o(191549);
  }
  
  public final LabelSlider.a getCallback()
  {
    return this.CbD;
  }
  
  public final List<Float> getTrackPoint()
  {
    AppMethodBeat.i(191543);
    Object localObject2 = (Iterable)this.Cdp;
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(Float.valueOf(((PointF)((Iterator)localObject2).next()).x));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(191543);
    return localObject1;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(191545);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    if (this.Cdp.size() < 2)
    {
      AppMethodBeat.o(191545);
      return;
    }
    float f1 = getHeight() / 2.0F;
    float f2 = f1 - this.Cdo / 2;
    float f3 = f1 + this.Cdo / 2;
    paramCanvas.drawLine(((PointF)this.Cdp.get(0)).x, f2, ((PointF)this.Cdp.get(0)).x, f3, this.Cdn);
    int j = this.pointCount;
    int i = 0;
    while (i < j - 1)
    {
      paramCanvas.drawLine(((PointF)this.Cdp.get(i)).x, f1, ((PointF)this.Cdp.get(i + 1)).x, f1, this.Cdn);
      paramCanvas.drawLine(((PointF)this.Cdp.get(i + 1)).x, f2, ((PointF)this.Cdp.get(i + 1)).x, f3, this.Cdn);
      i += 1;
    }
    Drawable localDrawable = this.npm;
    if (localDrawable != null) {
      localDrawable.setBounds(this.yKZ);
    }
    localDrawable = this.npm;
    if (localDrawable != null)
    {
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(191545);
      return;
    }
    AppMethodBeat.o(191545);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(191546);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ewE();
    AppMethodBeat.o(191546);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(191544);
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(191544);
      return true;
      this.gpe = paramMotionEvent.getX();
      this.gpf = paramMotionEvent.getY();
      this.gpg = paramMotionEvent.getX();
      this.gph = paramMotionEvent.getY();
      this.Cdm = this.yKZ.contains((int)this.gpe, (int)this.gpf);
      continue;
      this.gpg = paramMotionEvent.getX();
      this.gph = paramMotionEvent.getY();
      if ((!this.gpb) && ((Math.abs(this.gpg - this.gpe) > this.rW) || (Math.abs(this.gph - this.gpf) > this.rW))) {
        this.gpb = true;
      }
      if (this.Cdm)
      {
        float f = this.gpg;
        Object localObject = (Iterable)this.Cdp;
        paramMotionEvent = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramMotionEvent.add(Float.valueOf(((PointF)((Iterator)localObject).next()).x));
        }
        localObject = (List)paramMotionEvent;
        paramMotionEvent = j.t((Iterable)localObject);
        localObject = j.r((Iterable)localObject);
        if ((paramMotionEvent == null) || (localObject == null)) {}
        for (;;)
        {
          this.Cdq = f;
          this.yKZ.left = ((int)(this.Cdq - this.thumbWidth / 2));
          this.yKZ.right = ((int)(this.Cdq + this.thumbWidth / 2));
          postInvalidate();
          break;
          f = Math.max(paramMotionEvent.floatValue(), Math.min(((Float)localObject).floatValue(), f));
        }
        this.gpg = paramMotionEvent.getX();
        this.gph = paramMotionEvent.getY();
        if ((!this.gpb) || (this.Cdm))
        {
          bJ(this.gpg);
          postInvalidate();
        }
        this.Cdm = false;
        this.gpb = false;
      }
    }
  }
  
  public final void setCallback(LabelSlider.a parama)
  {
    this.CbD = parama;
  }
  
  public final void setPointCount(int paramInt)
  {
    AppMethodBeat.i(191537);
    if (paramInt < 2)
    {
      ae.e(this.TAG, "invalid pointCount ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(191537);
      return;
    }
    this.pointCount = paramInt;
    ewE();
    if (this.tci >= paramInt)
    {
      this.tci = (paramInt - 1);
      LabelSlider.a locala = this.CbD;
      if (locala != null)
      {
        locala.If(this.tci);
        AppMethodBeat.o(191537);
        return;
      }
    }
    AppMethodBeat.o(191537);
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(191538);
    this.tci = paramInt;
    ewF();
    invalidate();
    AppMethodBeat.o(191538);
  }
  
  public final void setStartOffset(int paramInt)
  {
    AppMethodBeat.i(191541);
    this.startOffset = paramInt;
    ewE();
    AppMethodBeat.o(191541);
  }
  
  public final void setThumbDrawable(Drawable paramDrawable)
  {
    int j = 0;
    AppMethodBeat.i(191542);
    this.npm = paramDrawable;
    paramDrawable = this.npm;
    if (paramDrawable != null) {}
    for (int i = paramDrawable.getIntrinsicWidth();; i = 0)
    {
      this.thumbWidth = i;
      paramDrawable = this.npm;
      i = j;
      if (paramDrawable != null) {
        i = paramDrawable.getIntrinsicHeight();
      }
      this.thumbHeight = i;
      AppMethodBeat.o(191542);
      return;
    }
  }
  
  public final void setTrackColor(int paramInt)
  {
    AppMethodBeat.i(191539);
    this.Cdn.setColor(paramInt);
    postInvalidate();
    AppMethodBeat.o(191539);
  }
  
  public final void setTrackLineWidth(float paramFloat)
  {
    AppMethodBeat.i(191540);
    this.Cdn.setStrokeWidth(paramFloat);
    postInvalidate();
    AppMethodBeat.o(191540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.SliderTrackView
 * JD-Core Version:    0.7.0.1
 */