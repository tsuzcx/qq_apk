package com.tencent.mm.plugin.recordvideo.plugin.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bodyColor", "bodyPaint", "Landroid/graphics/Paint;", "deleteColor", "deletePaint", "endColor", "endPaint", "prepareDelete", "", "subFinish", "subProgress", "Ljava/util/ArrayList;", "", "getDrawBodyRect", "Landroid/graphics/RectF;", "index", "getDrawEndRect", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "delete", "removeCurrentProgress", "verify", "(Ljava/lang/Integer;)V", "reset", "updateProgress", "Companion", "plugin-recordvideo_release"})
public final class HorizontalSubProgressBar
  extends View
{
  public static final HorizontalSubProgressBar.a xWE;
  private final int endColor;
  ArrayList<Float> wgC;
  private boolean wgG;
  private final int wgs;
  private Paint wgv;
  private int xWA;
  private Paint xWB;
  private Paint xWC;
  boolean xWD;
  
  static
  {
    AppMethodBeat.i(206649);
    xWE = new HorizontalSubProgressBar.a((byte)0);
    AppMethodBeat.o(206649);
  }
  
  public HorizontalSubProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(206647);
    this.xWA = Color.parseColor("#FA9D3B");
    this.endColor = Color.parseColor("#ffffff");
    this.wgs = Color.parseColor("#FA5151");
    this.xWB = new Paint();
    this.xWC = new Paint();
    this.wgv = new Paint();
    this.wgC = new ArrayList();
    this.xWB.setStyle(Paint.Style.FILL);
    this.xWB.setColor(this.xWA);
    this.xWB.setAntiAlias(true);
    this.xWC.setStyle(Paint.Style.FILL);
    this.xWC.setColor(this.endColor);
    this.xWC.setAntiAlias(true);
    this.wgv.setStyle(Paint.Style.FILL);
    this.wgv.setColor(this.wgs);
    this.wgv.setAntiAlias(true);
    AppMethodBeat.o(206647);
  }
  
  public HorizontalSubProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(206648);
    this.xWA = Color.parseColor("#FA9D3B");
    this.endColor = Color.parseColor("#ffffff");
    this.wgs = Color.parseColor("#FA5151");
    this.xWB = new Paint();
    this.xWC = new Paint();
    this.wgv = new Paint();
    this.wgC = new ArrayList();
    this.xWB.setStyle(Paint.Style.FILL);
    this.xWB.setColor(this.xWA);
    this.xWB.setAntiAlias(true);
    this.xWC.setStyle(Paint.Style.FILL);
    this.xWC.setColor(this.endColor);
    this.xWC.setAntiAlias(true);
    this.wgv.setStyle(Paint.Style.FILL);
    this.wgv.setColor(this.wgs);
    this.wgv.setAntiAlias(true);
    AppMethodBeat.o(206648);
  }
  
  private final RectF Oq(int paramInt)
  {
    AppMethodBeat.i(206646);
    Object localObject = this.wgC.get(paramInt);
    p.g(localObject, "subProgress[index]");
    float f2 = ((Number)localObject).floatValue() * getWidth() / 100.0F;
    float f3 = getHeight();
    if (paramInt == 0) {}
    for (float f1 = 0.0F;; f1 = ((Number)this.wgC.get(paramInt - 1)).floatValue() * getWidth() / 100.0F)
    {
      localObject = new RectF(f1, 0.0F, f2, f3);
      AppMethodBeat.o(206646);
      return localObject;
    }
  }
  
  public final void as(ArrayList<Float> paramArrayList)
  {
    AppMethodBeat.i(206641);
    p.h(paramArrayList, "subProgress");
    this.wgC.clear();
    this.wgC.addAll((Collection)paramArrayList);
    this.xWD = false;
    this.wgG = false;
    postInvalidate();
    AppMethodBeat.o(206641);
  }
  
  public final void dJZ()
  {
    AppMethodBeat.i(206642);
    this.xWD = true;
    postInvalidate();
    AppMethodBeat.o(206642);
  }
  
  public final void m(Integer paramInteger)
  {
    AppMethodBeat.i(206644);
    this.wgG = false;
    if (paramInteger != null)
    {
      i = this.wgC.size();
      if (paramInteger.intValue() == i)
      {
        AppMethodBeat.o(206644);
        return;
      }
    }
    if (!((Collection)this.wgC).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.wgC.remove(this.wgC.size() - 1);
      }
      invalidate();
      AppMethodBeat.o(206644);
      return;
    }
  }
  
  public final void oD(boolean paramBoolean)
  {
    AppMethodBeat.i(206643);
    this.wgG = paramBoolean;
    invalidate();
    AppMethodBeat.o(206643);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(206645);
    Object localObject1 = (Iterable)this.wgC;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.gkd();
      }
      ((Number)localObject2).floatValue();
      if ((i == this.wgC.size() - 1) && (this.wgG)) {
        if (paramCanvas != null) {
          paramCanvas.drawRect(Oq(i), this.wgv);
        }
      }
      for (;;)
      {
        if (((i == this.wgC.size() - 1) && (!this.xWD)) || (paramCanvas == null)) {
          break label230;
        }
        localObject2 = this.wgC.get(i);
        p.g(localObject2, "subProgress[index]");
        float f1 = ((Number)localObject2).floatValue() * getWidth() / 100.0F;
        float f2 = getHeight();
        paramCanvas.drawRect(new RectF(f1 - getWidth() * 0.0053F, 0.0F, f1, f2), this.xWC);
        i = j;
        break;
        if (paramCanvas != null) {
          paramCanvas.drawRect(Oq(i), this.xWB);
        }
      }
      label230:
      i = j;
    }
    AppMethodBeat.o(206645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.progress.HorizontalSubProgressBar
 * JD-Core Version:    0.7.0.1
 */