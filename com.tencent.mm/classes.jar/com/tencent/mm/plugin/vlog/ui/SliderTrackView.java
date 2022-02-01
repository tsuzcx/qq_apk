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
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/SliderTrackView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;)V", "pointCount", "pointSize", "selectIndex", "startOffset", "thumbDrawable", "Landroid/graphics/drawable/Drawable;", "thumbHeight", "thumbRect", "Landroid/graphics/Rect;", "thumbWidth", "thumbX", "", "thumbY", "touchDownX", "touchDownY", "touchDrag", "", "touchMoved", "touchSlop", "touchX", "touchY", "trackPaint", "Landroid/graphics/Paint;", "trackPoint", "Ljava/util/LinkedList;", "Landroid/graphics/PointF;", "clampThumbPoint", "x", "findThumbPoint", "", "getTrackPoint", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setPointCount", "setSelection", "index", "setStartOffset", "offset", "setThumbDrawable", "drawable", "setTrackColor", "color", "setTrackLineWidth", "lineWidth", "updateThumb", "updateTrackPoint", "plugin-vlog_release"})
public final class SliderTrackView
  extends View
{
  private final Rect COM;
  private LabelSlider.a GDu;
  private boolean GFC;
  private final Paint GFD;
  private int GFE;
  private final LinkedList<PointF> GFF;
  private float GFG;
  private float GFH;
  private final String TAG;
  private boolean gZU;
  private float gZX;
  private float gZY;
  private float gZZ;
  private float haa;
  private Drawable oyT;
  private int pointCount;
  private final int rZ;
  private int startOffset;
  private int thumbHeight;
  private int thumbWidth;
  private int whv;
  
  public SliderTrackView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(191128);
    AppMethodBeat.o(191128);
  }
  
  public SliderTrackView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(191127);
    AppMethodBeat.o(191127);
  }
  
  public SliderTrackView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(191126);
    this.TAG = "MicroMsg.LabelSlider";
    this.GFD = new Paint();
    this.pointCount = 5;
    this.startOffset = a.aG(paramContext, 2131165306);
    this.GFE = a.aG(paramContext, 2131165314);
    this.GFF = new LinkedList();
    this.COM = new Rect();
    this.thumbWidth = 48;
    this.thumbHeight = 48;
    this.GFD.setStyle(Paint.Style.STROKE);
    this.GFD.setColor(-855638017);
    this.GFD.setStrokeWidth(a.getDensity(paramContext));
    paramContext = ViewConfiguration.get(paramContext);
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.rZ = paramContext.getScaledTouchSlop();
    AppMethodBeat.o(191126);
  }
  
  private final void cg(float paramFloat)
  {
    AppMethodBeat.i(191124);
    if (this.GFF.size() < 2)
    {
      AppMethodBeat.o(191124);
      return;
    }
    float f1 = getWidth();
    int j = -1;
    int i = 0;
    int k = ((Collection)this.GFF).size();
    if (i < k)
    {
      float f2 = Math.abs(paramFloat - ((PointF)this.GFF.get(i)).x);
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
        this.whv = j;
        fCL();
        LabelSlider.a locala = this.GDu;
        if (locala != null)
        {
          locala.Ir(this.whv);
          AppMethodBeat.o(191124);
          return;
        }
      }
      AppMethodBeat.o(191124);
      return;
    }
  }
  
  private final void fCK()
  {
    AppMethodBeat.i(191123);
    int j = (getWidth() - this.startOffset * 2) / (this.pointCount - 1);
    float f1 = this.startOffset;
    float f2 = getHeight() / 2.0F;
    this.GFF.clear();
    this.GFF.add(new PointF(f1, f2));
    int i = 0;
    int k = this.pointCount;
    while (i < k - 1)
    {
      float f3 = j * i;
      float f4 = j;
      this.GFF.add(new PointF(f3 + f1 + f4, f2));
      i += 1;
    }
    this.GFH = f2;
    fCL();
    postInvalidate();
    AppMethodBeat.o(191123);
  }
  
  private final void fCL()
  {
    AppMethodBeat.i(191125);
    this.COM.top = ((int)(this.GFH - this.thumbHeight / 2));
    this.COM.bottom = ((int)(this.GFH + this.thumbHeight / 2));
    this.GFG = ((PointF)this.GFF.get(this.whv)).x;
    this.COM.left = ((int)(this.GFG - this.thumbWidth / 2));
    this.COM.right = ((int)(this.GFG + this.thumbWidth / 2));
    AppMethodBeat.o(191125);
  }
  
  public final LabelSlider.a getCallback()
  {
    return this.GDu;
  }
  
  public final List<Float> getTrackPoint()
  {
    AppMethodBeat.i(191119);
    Object localObject2 = (Iterable)this.GFF;
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(Float.valueOf(((PointF)((Iterator)localObject2).next()).x));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(191119);
    return localObject1;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(191121);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    if (this.GFF.size() < 2)
    {
      AppMethodBeat.o(191121);
      return;
    }
    float f1 = getHeight() / 2.0F;
    float f2 = f1 - this.GFE / 2;
    float f3 = f1 + this.GFE / 2;
    paramCanvas.drawLine(((PointF)this.GFF.get(0)).x, f2, ((PointF)this.GFF.get(0)).x, f3, this.GFD);
    int j = this.pointCount;
    int i = 0;
    while (i < j - 1)
    {
      paramCanvas.drawLine(((PointF)this.GFF.get(i)).x, f1, ((PointF)this.GFF.get(i + 1)).x, f1, this.GFD);
      paramCanvas.drawLine(((PointF)this.GFF.get(i + 1)).x, f2, ((PointF)this.GFF.get(i + 1)).x, f3, this.GFD);
      i += 1;
    }
    Drawable localDrawable = this.oyT;
    if (localDrawable != null) {
      localDrawable.setBounds(this.COM);
    }
    localDrawable = this.oyT;
    if (localDrawable != null)
    {
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(191121);
      return;
    }
    AppMethodBeat.o(191121);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(191122);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    fCK();
    AppMethodBeat.o(191122);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(191120);
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(191120);
      return true;
      this.gZX = paramMotionEvent.getX();
      this.gZY = paramMotionEvent.getY();
      this.gZZ = paramMotionEvent.getX();
      this.haa = paramMotionEvent.getY();
      this.GFC = this.COM.contains((int)this.gZX, (int)this.gZY);
      continue;
      this.gZZ = paramMotionEvent.getX();
      this.haa = paramMotionEvent.getY();
      if ((!this.gZU) && ((Math.abs(this.gZZ - this.gZX) > this.rZ) || (Math.abs(this.haa - this.gZY) > this.rZ))) {
        this.gZU = true;
      }
      if (this.GFC)
      {
        float f = this.gZZ;
        Object localObject = (Iterable)this.GFF;
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
          this.GFG = f;
          this.COM.left = ((int)(this.GFG - this.thumbWidth / 2));
          this.COM.right = ((int)(this.GFG + this.thumbWidth / 2));
          postInvalidate();
          break;
          f = Math.max(paramMotionEvent.floatValue(), Math.min(((Float)localObject).floatValue(), f));
        }
        this.gZZ = paramMotionEvent.getX();
        this.haa = paramMotionEvent.getY();
        if ((!this.gZU) || (this.GFC))
        {
          cg(this.gZZ);
          postInvalidate();
        }
        this.GFC = false;
        this.gZU = false;
      }
    }
  }
  
  public final void setCallback(LabelSlider.a parama)
  {
    this.GDu = parama;
  }
  
  public final void setPointCount(int paramInt)
  {
    AppMethodBeat.i(191113);
    if (paramInt < 2)
    {
      Log.e(this.TAG, "invalid pointCount ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(191113);
      return;
    }
    this.pointCount = paramInt;
    fCK();
    if (this.whv >= paramInt)
    {
      this.whv = (paramInt - 1);
      LabelSlider.a locala = this.GDu;
      if (locala != null)
      {
        locala.Ir(this.whv);
        AppMethodBeat.o(191113);
        return;
      }
    }
    AppMethodBeat.o(191113);
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(191114);
    this.whv = paramInt;
    fCL();
    invalidate();
    AppMethodBeat.o(191114);
  }
  
  public final void setStartOffset(int paramInt)
  {
    AppMethodBeat.i(191117);
    this.startOffset = paramInt;
    fCK();
    AppMethodBeat.o(191117);
  }
  
  public final void setThumbDrawable(Drawable paramDrawable)
  {
    int j = 0;
    AppMethodBeat.i(191118);
    this.oyT = paramDrawable;
    paramDrawable = this.oyT;
    if (paramDrawable != null) {}
    for (int i = paramDrawable.getIntrinsicWidth();; i = 0)
    {
      this.thumbWidth = i;
      paramDrawable = this.oyT;
      i = j;
      if (paramDrawable != null) {
        i = paramDrawable.getIntrinsicHeight();
      }
      this.thumbHeight = i;
      AppMethodBeat.o(191118);
      return;
    }
  }
  
  public final void setTrackColor(int paramInt)
  {
    AppMethodBeat.i(191115);
    this.GFD.setColor(paramInt);
    postInvalidate();
    AppMethodBeat.o(191115);
  }
  
  public final void setTrackLineWidth(float paramFloat)
  {
    AppMethodBeat.i(191116);
    this.GFD.setStrokeWidth(paramFloat);
    postInvalidate();
    AppMethodBeat.o(191116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.SliderTrackView
 * JD-Core Version:    0.7.0.1
 */