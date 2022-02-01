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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/SliderTrackView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;)V", "pointCount", "pointSize", "selectIndex", "startOffset", "thumbDrawable", "Landroid/graphics/drawable/Drawable;", "thumbHeight", "thumbRect", "Landroid/graphics/Rect;", "thumbWidth", "thumbX", "", "thumbY", "touchDownX", "touchDownY", "touchDrag", "", "touchMoved", "touchSlop", "touchX", "touchY", "trackPaint", "Landroid/graphics/Paint;", "trackPoint", "Ljava/util/LinkedList;", "Landroid/graphics/PointF;", "clampThumbPoint", "x", "findThumbPoint", "", "getTrackPoint", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setPointCount", "setSelection", "index", "setStartOffset", "offset", "setThumbDrawable", "drawable", "setTrackColor", "color", "setTrackLineWidth", "lineWidth", "updateThumb", "updateTrackPoint", "plugin-vlog_release"})
public final class SliderTrackView
  extends View
{
  private LabelSlider.a BKe;
  private boolean BLN;
  private final Paint BLO;
  private int BLP;
  private final LinkedList<PointF> BLQ;
  private float BLR;
  private float BLS;
  private final String TAG;
  private boolean gmF;
  private float gmI;
  private float gmJ;
  private float gmK;
  private float gmL;
  private Drawable nke;
  private int pointCount;
  private final int rW;
  private int sQX;
  private int startOffset;
  private int thumbHeight;
  private int thumbWidth;
  private final Rect yuZ;
  
  public SliderTrackView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(196093);
    AppMethodBeat.o(196093);
  }
  
  public SliderTrackView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(196092);
    AppMethodBeat.o(196092);
  }
  
  public SliderTrackView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(196091);
    this.TAG = "MicroMsg.LabelSlider";
    this.BLO = new Paint();
    this.pointCount = 5;
    this.startOffset = a.ax(paramContext, 2131165296);
    this.BLP = a.ax(paramContext, 2131165303);
    this.BLQ = new LinkedList();
    this.yuZ = new Rect();
    this.thumbWidth = 48;
    this.thumbHeight = 48;
    this.BLO.setStyle(Paint.Style.STROKE);
    this.BLO.setColor(-855638017);
    this.BLO.setStrokeWidth(a.getDensity(paramContext));
    paramContext = ViewConfiguration.get(paramContext);
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.rW = paramContext.getScaledTouchSlop();
    AppMethodBeat.o(196091);
  }
  
  private final void bL(float paramFloat)
  {
    AppMethodBeat.i(196089);
    if (this.BLQ.size() < 2)
    {
      AppMethodBeat.o(196089);
      return;
    }
    float f1 = getWidth();
    int j = -1;
    int i = 0;
    int k = ((Collection)this.BLQ).size();
    if (i < k)
    {
      float f2 = Math.abs(paramFloat - ((PointF)this.BLQ.get(i)).x);
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
        this.sQX = j;
        esY();
        LabelSlider.a locala = this.BKe;
        if (locala != null)
        {
          locala.HI(this.sQX);
          AppMethodBeat.o(196089);
          return;
        }
      }
      AppMethodBeat.o(196089);
      return;
    }
  }
  
  private final void esX()
  {
    AppMethodBeat.i(196088);
    int j = (getWidth() - this.startOffset * 2) / (this.pointCount - 1);
    float f1 = this.startOffset;
    float f2 = getHeight() / 2.0F;
    this.BLQ.clear();
    this.BLQ.add(new PointF(f1, f2));
    int i = 0;
    int k = this.pointCount;
    while (i < k - 1)
    {
      float f3 = j * i;
      float f4 = j;
      this.BLQ.add(new PointF(f3 + f1 + f4, f2));
      i += 1;
    }
    this.BLS = f2;
    esY();
    postInvalidate();
    AppMethodBeat.o(196088);
  }
  
  private final void esY()
  {
    AppMethodBeat.i(196090);
    this.yuZ.top = ((int)(this.BLS - this.thumbHeight / 2));
    this.yuZ.bottom = ((int)(this.BLS + this.thumbHeight / 2));
    this.BLR = ((PointF)this.BLQ.get(this.sQX)).x;
    this.yuZ.left = ((int)(this.BLR - this.thumbWidth / 2));
    this.yuZ.right = ((int)(this.BLR + this.thumbWidth / 2));
    AppMethodBeat.o(196090);
  }
  
  public final LabelSlider.a getCallback()
  {
    return this.BKe;
  }
  
  public final List<Float> getTrackPoint()
  {
    AppMethodBeat.i(196084);
    Object localObject2 = (Iterable)this.BLQ;
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(Float.valueOf(((PointF)((Iterator)localObject2).next()).x));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(196084);
    return localObject1;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(196086);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    if (this.BLQ.size() < 2)
    {
      AppMethodBeat.o(196086);
      return;
    }
    float f1 = getHeight() / 2.0F;
    float f2 = f1 - this.BLP / 2;
    float f3 = f1 + this.BLP / 2;
    paramCanvas.drawLine(((PointF)this.BLQ.get(0)).x, f2, ((PointF)this.BLQ.get(0)).x, f3, this.BLO);
    int j = this.pointCount;
    int i = 0;
    while (i < j - 1)
    {
      paramCanvas.drawLine(((PointF)this.BLQ.get(i)).x, f1, ((PointF)this.BLQ.get(i + 1)).x, f1, this.BLO);
      paramCanvas.drawLine(((PointF)this.BLQ.get(i + 1)).x, f2, ((PointF)this.BLQ.get(i + 1)).x, f3, this.BLO);
      i += 1;
    }
    Drawable localDrawable = this.nke;
    if (localDrawable != null) {
      localDrawable.setBounds(this.yuZ);
    }
    localDrawable = this.nke;
    if (localDrawable != null)
    {
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(196086);
      return;
    }
    AppMethodBeat.o(196086);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(196087);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    esX();
    AppMethodBeat.o(196087);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(196085);
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196085);
      return true;
      this.gmI = paramMotionEvent.getX();
      this.gmJ = paramMotionEvent.getY();
      this.gmK = paramMotionEvent.getX();
      this.gmL = paramMotionEvent.getY();
      this.BLN = this.yuZ.contains((int)this.gmI, (int)this.gmJ);
      continue;
      this.gmK = paramMotionEvent.getX();
      this.gmL = paramMotionEvent.getY();
      if ((!this.gmF) && ((Math.abs(this.gmK - this.gmI) > this.rW) || (Math.abs(this.gmL - this.gmJ) > this.rW))) {
        this.gmF = true;
      }
      if (this.BLN)
      {
        float f = this.gmK;
        Object localObject = (Iterable)this.BLQ;
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
          this.BLR = f;
          this.yuZ.left = ((int)(this.BLR - this.thumbWidth / 2));
          this.yuZ.right = ((int)(this.BLR + this.thumbWidth / 2));
          postInvalidate();
          break;
          f = Math.max(paramMotionEvent.floatValue(), Math.min(((Float)localObject).floatValue(), f));
        }
        this.gmK = paramMotionEvent.getX();
        this.gmL = paramMotionEvent.getY();
        if ((!this.gmF) || (this.BLN))
        {
          bL(this.gmK);
          postInvalidate();
        }
        this.BLN = false;
        this.gmF = false;
      }
    }
  }
  
  public final void setCallback(LabelSlider.a parama)
  {
    this.BKe = parama;
  }
  
  public final void setPointCount(int paramInt)
  {
    AppMethodBeat.i(196078);
    if (paramInt < 2)
    {
      ad.e(this.TAG, "invalid pointCount ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(196078);
      return;
    }
    this.pointCount = paramInt;
    esX();
    if (this.sQX >= paramInt)
    {
      this.sQX = (paramInt - 1);
      LabelSlider.a locala = this.BKe;
      if (locala != null)
      {
        locala.HI(this.sQX);
        AppMethodBeat.o(196078);
        return;
      }
    }
    AppMethodBeat.o(196078);
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(196079);
    this.sQX = paramInt;
    esY();
    invalidate();
    AppMethodBeat.o(196079);
  }
  
  public final void setStartOffset(int paramInt)
  {
    AppMethodBeat.i(196082);
    this.startOffset = paramInt;
    esX();
    AppMethodBeat.o(196082);
  }
  
  public final void setThumbDrawable(Drawable paramDrawable)
  {
    int j = 0;
    AppMethodBeat.i(196083);
    this.nke = paramDrawable;
    paramDrawable = this.nke;
    if (paramDrawable != null) {}
    for (int i = paramDrawable.getIntrinsicWidth();; i = 0)
    {
      this.thumbWidth = i;
      paramDrawable = this.nke;
      i = j;
      if (paramDrawable != null) {
        i = paramDrawable.getIntrinsicHeight();
      }
      this.thumbHeight = i;
      AppMethodBeat.o(196083);
      return;
    }
  }
  
  public final void setTrackColor(int paramInt)
  {
    AppMethodBeat.i(196080);
    this.BLO.setColor(paramInt);
    postInvalidate();
    AppMethodBeat.o(196080);
  }
  
  public final void setTrackLineWidth(float paramFloat)
  {
    AppMethodBeat.i(196081);
    this.BLO.setStrokeWidth(paramFloat);
    postInvalidate();
    AppMethodBeat.o(196081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.SliderTrackView
 * JD-Core Version:    0.7.0.1
 */