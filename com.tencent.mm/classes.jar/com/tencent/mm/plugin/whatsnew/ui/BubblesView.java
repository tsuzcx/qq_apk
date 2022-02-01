package com.tencent.mm.plugin.whatsnew.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.j.c.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/whatsnew/ui/BubblesView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addInterval", "", "bubbles", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/whatsnew/ui/Bubble;", "config", "Lcom/tencent/mm/plugin/whatsnew/ui/Config;", "lastAddTs", "", "lastDrawTs", "paint", "Landroid/graphics/Paint;", "dp", "getDp", "(D)D", "", "(I)F", "addBubble", "", "isStart", "", "drawBubbles", "canvas", "Landroid/graphics/Canvas;", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "parseColor", "str", "", "random", "start", "end", "resume", "withAlpha", "alpha", "Companion", "app_release"})
public final class BubblesView
  extends View
{
  public static final a JOD;
  private long JOA;
  private double JOB;
  private b JOC;
  private final LinkedList<a> JOy;
  long JOz;
  private final Paint paint;
  
  static
  {
    AppMethodBeat.i(230944);
    JOD = new a((byte)0);
    AppMethodBeat.o(230944);
  }
  
  public BubblesView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public BubblesView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(230943);
    this.JOy = new LinkedList();
    this.paint = new Paint(1);
    this.JOA = SystemClock.uptimeMillis();
    paramContext = c.JOX;
    this.JOC = ((b)e.a(c.gkZ(), (kotlin.j.c)kotlin.j.c.SYP));
    this.paint.setStyle(Paint.Style.FILL);
    if (ahs(this.JOC.jbm) > 0.0F) {
      this.paint.setMaskFilter((MaskFilter)new BlurMaskFilter(ahs(this.JOC.jbm), BlurMaskFilter.Blur.NORMAL));
    }
    paramContext = GradientDrawable.Orientation.TL_BR;
    paramAttributeSet = this.JOC.JOR;
    Collection localCollection = (Collection)new ArrayList(paramAttributeSet.length);
    int i = paramAttributeSet.length;
    paramInt = 0;
    while (paramInt < i)
    {
      localCollection.add(Integer.valueOf(parseColor(paramAttributeSet[paramInt])));
      paramInt += 1;
    }
    setBackground((Drawable)new GradientDrawable(paramContext, j.u((Collection)localCollection)));
    AppMethodBeat.o(230943);
  }
  
  private final double A(double paramDouble)
  {
    AppMethodBeat.i(230941);
    float f = (float)paramDouble;
    Resources localResources = getResources();
    p.g(localResources, "resources");
    paramDouble = TypedValue.applyDimension(1, f, localResources.getDisplayMetrics());
    AppMethodBeat.o(230941);
    return paramDouble;
  }
  
  private final float ahs(int paramInt)
  {
    AppMethodBeat.i(230940);
    float f = paramInt;
    Resources localResources = getResources();
    p.g(localResources, "resources");
    f = TypedValue.applyDimension(1, f, localResources.getDisplayMetrics());
    AppMethodBeat.o(230940);
    return f;
  }
  
  private static double ku(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230939);
    double d1 = paramInt1;
    c.b localb = kotlin.j.c.SYP;
    double d2 = kotlin.j.c.hyi().nextDouble();
    double d3 = paramInt2 - paramInt1;
    AppMethodBeat.o(230939);
    return d1 + d2 * d3;
  }
  
  private static int kv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230942);
    if (paramInt2 < 0) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        break label53;
      }
      Throwable localThrowable = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(230942);
      throw localThrowable;
      if (255 < paramInt2) {
        break;
      }
    }
    label53:
    AppMethodBeat.o(230942);
    return 0xFFFFFF & paramInt1 | paramInt2 << 24;
  }
  
  private static int parseColor(String paramString)
  {
    AppMethodBeat.i(230937);
    try
    {
      i = Color.parseColor(paramString);
      AppMethodBeat.o(230937);
      return i;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i = -65536;
      }
    }
  }
  
  private final void zF(boolean paramBoolean)
  {
    AppMethodBeat.i(230936);
    long l = SystemClock.uptimeMillis();
    if ((!paramBoolean) && (l - this.JOA < this.JOB))
    {
      AppMethodBeat.o(230936);
      return;
    }
    this.JOA = l;
    double d3 = A(ku(this.JOC.JOJ, this.JOC.JOK));
    Object localObject;
    double d1;
    if (paramBoolean)
    {
      localObject = kotlin.j.c.SYP;
      d1 = kotlin.j.c.hyi().nextDouble() * (getWidth() + 2.0D * d3) - d3;
      if (!paramBoolean) {
        break label333;
      }
      localObject = kotlin.j.c.SYP;
    }
    label333:
    for (double d2 = kotlin.j.c.hyi().nextDouble() * (getHeight() + 2.0D * d3) + d3;; d2 = getHeight() + d3)
    {
      double d4 = Math.toRadians(ku(this.JOC.JOO, this.JOC.JOP));
      int i = kv(parseColor((String)e.a(this.JOC.JOQ, (kotlin.j.c)kotlin.j.c.SYP)), kotlin.h.a.K(255.0D * this.JOC.JOL));
      double d5 = A(ku(this.JOC.JOM, this.JOC.JON)) / 1000.0D;
      localObject = this.JOy;
      a locala = new a(d1, d2, d3, d4, d5, i);
      new StringBuilder("add ").append(locala);
      ((LinkedList)localObject).add(locala);
      this.JOB = (this.JOC.vPo / d5);
      AppMethodBeat.o(230936);
      return;
      localObject = kotlin.j.c.SYP;
      d1 = kotlin.j.c.hyi().nextDouble() * (getWidth() * 2 + 2.0D * d3) - getWidth() - d3;
      break;
    }
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(230938);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    long l = SystemClock.uptimeMillis();
    int i = 0;
    Object localObject = ((Iterable)this.JOy).iterator();
    int j;
    if (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      this.paint.setColor(locala.color);
      double d = (l - this.JOz) * locala.dxQ;
      locala.x += Math.cos(locala.JOx) * d;
      locala.y -= d * Math.sin(locala.JOx);
      paramCanvas.drawCircle((float)locala.x, (float)locala.y, (float)locala.radius, this.paint);
      j = getWidth();
      int k = getHeight();
      if ((locala.x >= -locala.radius) && (locala.x <= j + locala.radius) && (locala.y >= -locala.radius) && (locala.y <= k + locala.radius))
      {
        j = 1;
        label238:
        if (j == 0) {
          break label414;
        }
        i += 1;
      }
    }
    label408:
    label414:
    for (;;)
    {
      break;
      j = 0;
      break label238;
      this.JOz = l;
      paramCanvas = this.JOy.iterator();
      p.g(paramCanvas, "bubbles.iterator()");
      if (paramCanvas.hasNext())
      {
        localObject = paramCanvas.next();
        p.g(localObject, "iterator.next()");
        localObject = (a)localObject;
        j = getWidth();
        if ((((a)localObject).y >= -((a)localObject).radius) && (((a)localObject).x <= j + ((a)localObject).radius)) {
          break label408;
        }
      }
      for (j = 1;; j = 0)
      {
        if (j != 0)
        {
          new StringBuilder("remove ").append(localObject);
          paramCanvas.remove();
        }
        if (i < this.JOC.JOI) {
          zF(false);
        }
        invalidate();
        AppMethodBeat.o(230938);
        return;
      }
    }
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(230935);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.JOz = SystemClock.uptimeMillis();
    paramInt2 = this.JOC.initCount;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      zF(true);
      paramInt1 += 1;
    }
    AppMethodBeat.o(230935);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/whatsnew/ui/BubblesView$Companion;", "", "()V", "TAG", "", "app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.whatsnew.ui.BubblesView
 * JD-Core Version:    0.7.0.1
 */