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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.vlog.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/SliderTrackView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;)V", "pointCount", "pointSize", "selectIndex", "startOffset", "thumbDrawable", "Landroid/graphics/drawable/Drawable;", "thumbHeight", "thumbRect", "Landroid/graphics/Rect;", "thumbWidth", "thumbX", "", "thumbY", "touchDownX", "touchDownY", "touchDrag", "", "touchMoved", "touchSlop", "touchX", "touchY", "trackPaint", "Landroid/graphics/Paint;", "trackPoint", "Ljava/util/LinkedList;", "Landroid/graphics/PointF;", "clampThumbPoint", "x", "findThumbPoint", "", "getTrackPoint", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setPointCount", "setSelection", "index", "setStartOffset", "offset", "setThumbDrawable", "drawable", "setTrackColor", "color", "setTrackLineWidth", "lineWidth", "updateThumb", "updateTrackPoint", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SliderTrackView
  extends View
{
  private int Fjh;
  private final Rect Pdg;
  private final String TAG;
  private LabelSlider.a UeQ;
  private boolean UgN;
  private final Paint UgO;
  private int UgP;
  private final LinkedList<PointF> UgQ;
  private float UgR;
  private float UgS;
  private final int doK;
  private boolean mkh;
  private float mkk;
  private float mkl;
  private float mkm;
  private float mkn;
  private int oHY;
  private int pointCount;
  private int thumbHeight;
  private int thumbWidth;
  private Drawable uMP;
  
  public SliderTrackView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(281437);
    AppMethodBeat.o(281437);
  }
  
  public SliderTrackView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(281434);
    AppMethodBeat.o(281434);
  }
  
  public SliderTrackView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(281431);
    this.TAG = "MicroMsg.LabelSlider";
    this.UgO = new Paint();
    this.pointCount = 5;
    this.oHY = a.br(paramContext, a.d.Edge_5A);
    this.UgP = a.br(paramContext, a.d.Edge_A);
    this.UgQ = new LinkedList();
    this.Pdg = new Rect();
    this.thumbWidth = 48;
    this.thumbHeight = 48;
    this.UgO.setStyle(Paint.Style.STROKE);
    this.UgO.setColor(-855638017);
    this.UgO.setStrokeWidth(a.getDensity(paramContext));
    this.doK = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(281431);
  }
  
  private final void dB(float paramFloat)
  {
    AppMethodBeat.i(281447);
    if (this.UgQ.size() < 2)
    {
      AppMethodBeat.o(281447);
      return;
    }
    float f1 = getWidth();
    int m = this.UgQ.size() - 1;
    int i;
    int j;
    int k;
    if (m >= 0)
    {
      i = 0;
      j = -1;
      k = i + 1;
      float f2 = Math.abs(paramFloat - ((PointF)this.UgQ.get(i)).x);
      if (f2 < f1)
      {
        f1 = f2;
        label85:
        if (k <= m) {}
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        this.Fjh = i;
        hSz();
        LabelSlider.a locala = this.UeQ;
        if (locala != null) {
          locala.Ng(this.Fjh);
        }
      }
      AppMethodBeat.o(281447);
      return;
      j = k;
      k = i;
      i = j;
      j = k;
      break;
      i = j;
      break label85;
      i = -1;
    }
  }
  
  private final void hSy()
  {
    AppMethodBeat.i(281441);
    int k = (getWidth() - this.oHY * 2) / (this.pointCount - 1);
    float f1 = this.oHY;
    float f2 = getHeight() / 2.0F;
    this.UgQ.clear();
    this.UgQ.add(new PointF(f1, f2));
    int i = 0;
    int m = this.pointCount - 1;
    if (m > 0) {}
    for (;;)
    {
      int j = i + 1;
      float f3 = i * k;
      float f4 = k;
      this.UgQ.add(new PointF(f3 + f1 + f4, f2));
      if (j >= m)
      {
        this.UgS = f2;
        hSz();
        postInvalidate();
        AppMethodBeat.o(281441);
        return;
      }
      i = j;
    }
  }
  
  private final void hSz()
  {
    AppMethodBeat.i(281454);
    this.Pdg.top = ((int)(this.UgS - this.thumbHeight / 2));
    this.Pdg.bottom = ((int)(this.UgS + this.thumbHeight / 2));
    this.UgR = ((PointF)this.UgQ.get(this.Fjh)).x;
    this.Pdg.left = ((int)(this.UgR - this.thumbWidth / 2));
    this.Pdg.right = ((int)(this.UgR + this.thumbWidth / 2));
    AppMethodBeat.o(281454);
  }
  
  public final LabelSlider.a getCallback()
  {
    return this.UeQ;
  }
  
  public final List<Float> getTrackPoint()
  {
    AppMethodBeat.i(281500);
    Object localObject2 = (Iterable)this.UgQ;
    Object localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(Float.valueOf(((PointF)((Iterator)localObject2).next()).x));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(281500);
    return localObject1;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(281521);
    s.u(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    if (this.UgQ.size() < 2)
    {
      AppMethodBeat.o(281521);
      return;
    }
    float f1 = getHeight() / 2.0F;
    float f2 = f1 - this.UgP / 2;
    float f3 = f1 + this.UgP / 2;
    paramCanvas.drawLine(((PointF)this.UgQ.get(0)).x, f2, ((PointF)this.UgQ.get(0)).x, f3, this.UgO);
    int k = this.pointCount - 1;
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      paramCanvas.drawLine(((PointF)this.UgQ.get(i)).x, f1, ((PointF)this.UgQ.get(i + 1)).x, f1, this.UgO);
      paramCanvas.drawLine(((PointF)this.UgQ.get(i + 1)).x, f2, ((PointF)this.UgQ.get(i + 1)).x, f3, this.UgO);
      if (j >= k)
      {
        Drawable localDrawable = this.uMP;
        if (localDrawable != null) {
          localDrawable.setBounds(this.Pdg);
        }
        localDrawable = this.uMP;
        if (localDrawable != null) {
          localDrawable.draw(paramCanvas);
        }
        AppMethodBeat.o(281521);
        return;
      }
    }
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(281525);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    hSy();
    AppMethodBeat.o(281525);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(281511);
    s.u(paramMotionEvent, "event");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(281511);
      return true;
      this.mkk = paramMotionEvent.getX();
      this.mkl = paramMotionEvent.getY();
      this.mkm = paramMotionEvent.getX();
      this.mkn = paramMotionEvent.getY();
      this.UgN = this.Pdg.contains((int)this.mkk, (int)this.mkl);
      continue;
      this.mkm = paramMotionEvent.getX();
      this.mkn = paramMotionEvent.getY();
      if ((!this.mkh) && ((Math.abs(this.mkm - this.mkk) > this.doK) || (Math.abs(this.mkn - this.mkl) > this.doK))) {
        this.mkh = true;
      }
      if (this.UgN)
      {
        float f = this.mkm;
        Object localObject = (Iterable)this.UgQ;
        paramMotionEvent = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramMotionEvent.add(Float.valueOf(((PointF)((Iterator)localObject).next()).x));
        }
        localObject = (List)paramMotionEvent;
        paramMotionEvent = p.y((Iterable)localObject);
        localObject = p.w((Iterable)localObject);
        if ((paramMotionEvent == null) || (localObject == null)) {}
        for (;;)
        {
          this.UgR = f;
          this.Pdg.left = ((int)(this.UgR - this.thumbWidth / 2));
          this.Pdg.right = ((int)(this.UgR + this.thumbWidth / 2));
          postInvalidate();
          break;
          f = Math.max(paramMotionEvent.floatValue(), Math.min(((Float)localObject).floatValue(), f));
        }
        this.mkm = paramMotionEvent.getX();
        this.mkn = paramMotionEvent.getY();
        if ((!this.mkh) || (this.UgN))
        {
          dB(this.mkm);
          postInvalidate();
        }
        this.UgN = false;
        this.mkh = false;
      }
    }
  }
  
  public final void setCallback(LabelSlider.a parama)
  {
    this.UeQ = parama;
  }
  
  public final void setPointCount(int paramInt)
  {
    AppMethodBeat.i(281466);
    if (paramInt < 2)
    {
      Log.e(this.TAG, s.X("invalid pointCount ", Integer.valueOf(paramInt)));
      AppMethodBeat.o(281466);
      return;
    }
    this.pointCount = paramInt;
    hSy();
    if (this.Fjh >= paramInt)
    {
      this.Fjh = (paramInt - 1);
      LabelSlider.a locala = this.UeQ;
      if (locala != null) {
        locala.Ng(this.Fjh);
      }
    }
    AppMethodBeat.o(281466);
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(281470);
    this.Fjh = paramInt;
    hSz();
    invalidate();
    AppMethodBeat.o(281470);
  }
  
  public final void setStartOffset(int paramInt)
  {
    AppMethodBeat.i(281485);
    this.oHY = paramInt;
    hSy();
    AppMethodBeat.o(281485);
  }
  
  public final void setThumbDrawable(Drawable paramDrawable)
  {
    int j = 0;
    AppMethodBeat.i(281492);
    this.uMP = paramDrawable;
    paramDrawable = this.uMP;
    if (paramDrawable == null)
    {
      i = 0;
      this.thumbWidth = i;
      paramDrawable = this.uMP;
      if (paramDrawable != null) {
        break label60;
      }
    }
    label60:
    for (int i = j;; i = paramDrawable.getIntrinsicHeight())
    {
      this.thumbHeight = i;
      AppMethodBeat.o(281492);
      return;
      i = paramDrawable.getIntrinsicWidth();
      break;
    }
  }
  
  public final void setTrackColor(int paramInt)
  {
    AppMethodBeat.i(281475);
    this.UgO.setColor(paramInt);
    postInvalidate();
    AppMethodBeat.o(281475);
  }
  
  public final void setTrackLineWidth(float paramFloat)
  {
    AppMethodBeat.i(281480);
    this.UgO.setStrokeWidth(paramFloat);
    postInvalidate();
    AppMethodBeat.o(281480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.SliderTrackView
 * JD-Core Version:    0.7.0.1
 */