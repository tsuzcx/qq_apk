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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.vlog.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/SliderTrackView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;)V", "pointCount", "pointSize", "selectIndex", "startOffset", "thumbDrawable", "Landroid/graphics/drawable/Drawable;", "thumbHeight", "thumbRect", "Landroid/graphics/Rect;", "thumbWidth", "thumbX", "", "thumbY", "touchDownX", "touchDownY", "touchDrag", "", "touchMoved", "touchSlop", "touchX", "touchY", "trackPaint", "Landroid/graphics/Paint;", "trackPoint", "Ljava/util/LinkedList;", "Landroid/graphics/PointF;", "clampThumbPoint", "x", "findThumbPoint", "", "getTrackPoint", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setPointCount", "setSelection", "index", "setStartOffset", "offset", "setThumbDrawable", "drawable", "setTrackColor", "color", "setTrackLineWidth", "lineWidth", "updateThumb", "updateTrackPoint", "plugin-vlog_release"})
public final class SliderTrackView
  extends View
{
  private int ARl;
  private final Rect IUo;
  private LabelSlider.a Nrg;
  private boolean Ntt;
  private final Paint Ntu;
  private int Ntv;
  private final LinkedList<PointF> Ntw;
  private float Ntx;
  private float Nty;
  private final String TAG;
  private final int bvH;
  private boolean jKV;
  private float jKY;
  private float jKZ;
  private float jLa;
  private float jLb;
  private int lPo;
  private int pointCount;
  private Drawable rBA;
  private int thumbHeight;
  private int thumbWidth;
  
  public SliderTrackView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(225264);
    AppMethodBeat.o(225264);
  }
  
  public SliderTrackView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(225263);
    AppMethodBeat.o(225263);
  }
  
  public SliderTrackView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(225261);
    this.TAG = "MicroMsg.LabelSlider";
    this.Ntu = new Paint();
    this.pointCount = 5;
    this.lPo = a.aY(paramContext, a.d.Edge_5A);
    this.Ntv = a.aY(paramContext, a.d.Edge_A);
    this.Ntw = new LinkedList();
    this.IUo = new Rect();
    this.thumbWidth = 48;
    this.thumbHeight = 48;
    this.Ntu.setStyle(Paint.Style.STROKE);
    this.Ntu.setColor(-855638017);
    this.Ntu.setStrokeWidth(a.getDensity(paramContext));
    paramContext = ViewConfiguration.get(paramContext);
    p.j(paramContext, "ViewConfiguration.get(context)");
    this.bvH = paramContext.getScaledTouchSlop();
    AppMethodBeat.o(225261);
  }
  
  private final void cp(float paramFloat)
  {
    AppMethodBeat.i(225255);
    if (this.Ntw.size() < 2)
    {
      AppMethodBeat.o(225255);
      return;
    }
    float f1 = getWidth();
    int j = -1;
    int i = 0;
    int k = ((Collection)this.Ntw).size();
    if (i < k)
    {
      float f2 = Math.abs(paramFloat - ((PointF)this.Ntw.get(i)).x);
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
        this.ARl = j;
        guK();
        LabelSlider.a locala = this.Nrg;
        if (locala != null)
        {
          locala.Mc(this.ARl);
          AppMethodBeat.o(225255);
          return;
        }
      }
      AppMethodBeat.o(225255);
      return;
    }
  }
  
  private final void guJ()
  {
    AppMethodBeat.i(225253);
    int j = (getWidth() - this.lPo * 2) / (this.pointCount - 1);
    float f1 = this.lPo;
    float f2 = getHeight() / 2.0F;
    this.Ntw.clear();
    this.Ntw.add(new PointF(f1, f2));
    int i = 0;
    int k = this.pointCount;
    while (i < k - 1)
    {
      float f3 = j * i;
      float f4 = j;
      this.Ntw.add(new PointF(f3 + f1 + f4, f2));
      i += 1;
    }
    this.Nty = f2;
    guK();
    postInvalidate();
    AppMethodBeat.o(225253);
  }
  
  private final void guK()
  {
    AppMethodBeat.i(225259);
    this.IUo.top = ((int)(this.Nty - this.thumbHeight / 2));
    this.IUo.bottom = ((int)(this.Nty + this.thumbHeight / 2));
    this.Ntx = ((PointF)this.Ntw.get(this.ARl)).x;
    this.IUo.left = ((int)(this.Ntx - this.thumbWidth / 2));
    this.IUo.right = ((int)(this.Ntx + this.thumbWidth / 2));
    AppMethodBeat.o(225259);
  }
  
  public final LabelSlider.a getCallback()
  {
    return this.Nrg;
  }
  
  public final List<Float> getTrackPoint()
  {
    AppMethodBeat.i(225217);
    Object localObject2 = (Iterable)this.Ntw;
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(Float.valueOf(((PointF)((Iterator)localObject2).next()).x));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(225217);
    return localObject1;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(225239);
    p.k(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    if (this.Ntw.size() < 2)
    {
      AppMethodBeat.o(225239);
      return;
    }
    float f1 = getHeight() / 2.0F;
    float f2 = f1 - this.Ntv / 2;
    float f3 = f1 + this.Ntv / 2;
    paramCanvas.drawLine(((PointF)this.Ntw.get(0)).x, f2, ((PointF)this.Ntw.get(0)).x, f3, this.Ntu);
    int j = this.pointCount;
    int i = 0;
    while (i < j - 1)
    {
      paramCanvas.drawLine(((PointF)this.Ntw.get(i)).x, f1, ((PointF)this.Ntw.get(i + 1)).x, f1, this.Ntu);
      paramCanvas.drawLine(((PointF)this.Ntw.get(i + 1)).x, f2, ((PointF)this.Ntw.get(i + 1)).x, f3, this.Ntu);
      i += 1;
    }
    Drawable localDrawable = this.rBA;
    if (localDrawable != null) {
      localDrawable.setBounds(this.IUo);
    }
    localDrawable = this.rBA;
    if (localDrawable != null)
    {
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(225239);
      return;
    }
    AppMethodBeat.o(225239);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(225243);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    guJ();
    AppMethodBeat.o(225243);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(225233);
    p.k(paramMotionEvent, "event");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(225233);
      return true;
      this.jKY = paramMotionEvent.getX();
      this.jKZ = paramMotionEvent.getY();
      this.jLa = paramMotionEvent.getX();
      this.jLb = paramMotionEvent.getY();
      this.Ntt = this.IUo.contains((int)this.jKY, (int)this.jKZ);
      continue;
      this.jLa = paramMotionEvent.getX();
      this.jLb = paramMotionEvent.getY();
      if ((!this.jKV) && ((Math.abs(this.jLa - this.jKY) > this.bvH) || (Math.abs(this.jLb - this.jKZ) > this.bvH))) {
        this.jKV = true;
      }
      if (this.Ntt)
      {
        float f = this.jLa;
        Object localObject = (Iterable)this.Ntw;
        paramMotionEvent = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramMotionEvent.add(Float.valueOf(((PointF)((Iterator)localObject).next()).x));
        }
        localObject = (List)paramMotionEvent;
        paramMotionEvent = j.x((Iterable)localObject);
        localObject = j.v((Iterable)localObject);
        if ((paramMotionEvent == null) || (localObject == null)) {}
        for (;;)
        {
          this.Ntx = f;
          this.IUo.left = ((int)(this.Ntx - this.thumbWidth / 2));
          this.IUo.right = ((int)(this.Ntx + this.thumbWidth / 2));
          postInvalidate();
          break;
          f = Math.max(paramMotionEvent.floatValue(), Math.min(((Float)localObject).floatValue(), f));
        }
        this.jLa = paramMotionEvent.getX();
        this.jLb = paramMotionEvent.getY();
        if ((!this.jKV) || (this.Ntt))
        {
          cp(this.jLa);
          postInvalidate();
        }
        this.Ntt = false;
        this.jKV = false;
      }
    }
  }
  
  public final void setCallback(LabelSlider.a parama)
  {
    this.Nrg = parama;
  }
  
  public final void setPointCount(int paramInt)
  {
    AppMethodBeat.i(225201);
    if (paramInt < 2)
    {
      Log.e(this.TAG, "invalid pointCount ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(225201);
      return;
    }
    this.pointCount = paramInt;
    guJ();
    if (this.ARl >= paramInt)
    {
      this.ARl = (paramInt - 1);
      LabelSlider.a locala = this.Nrg;
      if (locala != null)
      {
        locala.Mc(this.ARl);
        AppMethodBeat.o(225201);
        return;
      }
    }
    AppMethodBeat.o(225201);
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(225203);
    this.ARl = paramInt;
    guK();
    invalidate();
    AppMethodBeat.o(225203);
  }
  
  public final void setStartOffset(int paramInt)
  {
    AppMethodBeat.i(225208);
    this.lPo = paramInt;
    guJ();
    AppMethodBeat.o(225208);
  }
  
  public final void setThumbDrawable(Drawable paramDrawable)
  {
    int j = 0;
    AppMethodBeat.i(225213);
    this.rBA = paramDrawable;
    paramDrawable = this.rBA;
    if (paramDrawable != null) {}
    for (int i = paramDrawable.getIntrinsicWidth();; i = 0)
    {
      this.thumbWidth = i;
      paramDrawable = this.rBA;
      i = j;
      if (paramDrawable != null) {
        i = paramDrawable.getIntrinsicHeight();
      }
      this.thumbHeight = i;
      AppMethodBeat.o(225213);
      return;
    }
  }
  
  public final void setTrackColor(int paramInt)
  {
    AppMethodBeat.i(225204);
    this.Ntu.setColor(paramInt);
    postInvalidate();
    AppMethodBeat.o(225204);
  }
  
  public final void setTrackLineWidth(float paramFloat)
  {
    AppMethodBeat.i(225206);
    this.Ntu.setStrokeWidth(paramFloat);
    postInvalidate();
    AppMethodBeat.o(225206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.SliderTrackView
 * JD-Core Version:    0.7.0.1
 */