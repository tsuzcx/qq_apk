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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bodyColor", "bodyPaint", "Landroid/graphics/Paint;", "deleteColor", "deletePaint", "endColor", "endPaint", "prepareDelete", "", "subFinish", "subProgress", "Ljava/util/ArrayList;", "", "getDrawBodyRect", "Landroid/graphics/RectF;", "index", "getDrawEndRect", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "delete", "removeCurrentProgress", "verify", "(Ljava/lang/Integer;)V", "reset", "updateProgress", "Companion", "plugin-recordvideo_release"})
public final class HorizontalSubProgressBar
  extends View
{
  public static final HorizontalSubProgressBar.a xGJ;
  private final int endColor;
  private boolean vUC;
  private final int vUo;
  private Paint vUr;
  ArrayList<Float> vUy;
  private int xGF;
  private Paint xGG;
  private Paint xGH;
  boolean xGI;
  
  static
  {
    AppMethodBeat.i(200388);
    xGJ = new HorizontalSubProgressBar.a((byte)0);
    AppMethodBeat.o(200388);
  }
  
  public HorizontalSubProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200386);
    this.xGF = Color.parseColor("#FA9D3B");
    this.endColor = Color.parseColor("#ffffff");
    this.vUo = Color.parseColor("#FA5151");
    this.xGG = new Paint();
    this.xGH = new Paint();
    this.vUr = new Paint();
    this.vUy = new ArrayList();
    this.xGG.setStyle(Paint.Style.FILL);
    this.xGG.setColor(this.xGF);
    this.xGG.setAntiAlias(true);
    this.xGH.setStyle(Paint.Style.FILL);
    this.xGH.setColor(this.endColor);
    this.xGH.setAntiAlias(true);
    this.vUr.setStyle(Paint.Style.FILL);
    this.vUr.setColor(this.vUo);
    this.vUr.setAntiAlias(true);
    AppMethodBeat.o(200386);
  }
  
  public HorizontalSubProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200387);
    this.xGF = Color.parseColor("#FA9D3B");
    this.endColor = Color.parseColor("#ffffff");
    this.vUo = Color.parseColor("#FA5151");
    this.xGG = new Paint();
    this.xGH = new Paint();
    this.vUr = new Paint();
    this.vUy = new ArrayList();
    this.xGG.setStyle(Paint.Style.FILL);
    this.xGG.setColor(this.xGF);
    this.xGG.setAntiAlias(true);
    this.xGH.setStyle(Paint.Style.FILL);
    this.xGH.setColor(this.endColor);
    this.xGH.setAntiAlias(true);
    this.vUr.setStyle(Paint.Style.FILL);
    this.vUr.setColor(this.vUo);
    this.vUr.setAntiAlias(true);
    AppMethodBeat.o(200387);
  }
  
  private final RectF NK(int paramInt)
  {
    AppMethodBeat.i(200385);
    Object localObject = this.vUy.get(paramInt);
    p.g(localObject, "subProgress[index]");
    float f2 = ((Number)localObject).floatValue() * getWidth() / 100.0F;
    float f3 = getHeight();
    if (paramInt == 0) {}
    for (float f1 = 0.0F;; f1 = ((Number)this.vUy.get(paramInt - 1)).floatValue() * getWidth() / 100.0F)
    {
      localObject = new RectF(f1, 0.0F, f2, f3);
      AppMethodBeat.o(200385);
      return localObject;
    }
  }
  
  public final void ar(ArrayList<Float> paramArrayList)
  {
    AppMethodBeat.i(200380);
    p.h(paramArrayList, "subProgress");
    this.vUy.clear();
    this.vUy.addAll((Collection)paramArrayList);
    this.xGI = false;
    this.vUC = false;
    postInvalidate();
    AppMethodBeat.o(200380);
  }
  
  public final void dGI()
  {
    AppMethodBeat.i(200381);
    this.xGI = true;
    postInvalidate();
    AppMethodBeat.o(200381);
  }
  
  public final void l(Integer paramInteger)
  {
    AppMethodBeat.i(200383);
    this.vUC = false;
    if (paramInteger != null)
    {
      i = this.vUy.size();
      if (paramInteger.intValue() == i)
      {
        AppMethodBeat.o(200383);
        return;
      }
    }
    if (!((Collection)this.vUy).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.vUy.remove(this.vUy.size() - 1);
      }
      invalidate();
      AppMethodBeat.o(200383);
      return;
    }
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(200384);
    Object localObject1 = (Iterable)this.vUy;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.gfB();
      }
      ((Number)localObject2).floatValue();
      if ((i == this.vUy.size() - 1) && (this.vUC)) {
        if (paramCanvas != null) {
          paramCanvas.drawRect(NK(i), this.vUr);
        }
      }
      for (;;)
      {
        if (((i == this.vUy.size() - 1) && (!this.xGI)) || (paramCanvas == null)) {
          break label230;
        }
        localObject2 = this.vUy.get(i);
        p.g(localObject2, "subProgress[index]");
        float f1 = ((Number)localObject2).floatValue() * getWidth() / 100.0F;
        float f2 = getHeight();
        paramCanvas.drawRect(new RectF(f1 - getWidth() * 0.0053F, 0.0F, f1, f2), this.xGH);
        i = j;
        break;
        if (paramCanvas != null) {
          paramCanvas.drawRect(NK(i), this.xGG);
        }
      }
      label230:
      i = j;
    }
    AppMethodBeat.o(200384);
  }
  
  public final void oy(boolean paramBoolean)
  {
    AppMethodBeat.i(200382);
    this.vUC = paramBoolean;
    invalidate();
    AppMethodBeat.o(200382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.progress.HorizontalSubProgressBar
 * JD-Core Version:    0.7.0.1
 */