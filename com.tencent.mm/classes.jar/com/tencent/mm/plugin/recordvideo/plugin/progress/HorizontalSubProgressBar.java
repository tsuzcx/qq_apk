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
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bodyColor", "bodyPaint", "Landroid/graphics/Paint;", "deleteColor", "deletePaint", "endColor", "endPaint", "prepareDelete", "", "subFinish", "subProgress", "Ljava/util/ArrayList;", "", "getDrawBodyRect", "Landroid/graphics/RectF;", "index", "getDrawEndRect", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "delete", "removeCurrentProgress", "verify", "(Ljava/lang/Integer;)V", "reset", "updateProgress", "Companion", "plugin-recordvideo_release"})
public final class HorizontalSubProgressBar
  extends View
{
  public static final a wxP;
  private final int endColor;
  private final int uRe;
  private Paint uRh;
  ArrayList<Float> uRo;
  private boolean uRs;
  private int wxL;
  private Paint wxM;
  private Paint wxN;
  boolean wxO;
  
  static
  {
    AppMethodBeat.i(199347);
    wxP = new a((byte)0);
    AppMethodBeat.o(199347);
  }
  
  public HorizontalSubProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(199345);
    this.wxL = Color.parseColor("#FA9D3B");
    this.endColor = Color.parseColor("#ffffff");
    this.uRe = Color.parseColor("#FA5151");
    this.wxM = new Paint();
    this.wxN = new Paint();
    this.uRh = new Paint();
    this.uRo = new ArrayList();
    this.wxM.setStyle(Paint.Style.FILL);
    this.wxM.setColor(this.wxL);
    this.wxM.setAntiAlias(true);
    this.wxN.setStyle(Paint.Style.FILL);
    this.wxN.setColor(this.endColor);
    this.wxN.setAntiAlias(true);
    this.uRh.setStyle(Paint.Style.FILL);
    this.uRh.setColor(this.uRe);
    this.uRh.setAntiAlias(true);
    AppMethodBeat.o(199345);
  }
  
  public HorizontalSubProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(199346);
    this.wxL = Color.parseColor("#FA9D3B");
    this.endColor = Color.parseColor("#ffffff");
    this.uRe = Color.parseColor("#FA5151");
    this.wxM = new Paint();
    this.wxN = new Paint();
    this.uRh = new Paint();
    this.uRo = new ArrayList();
    this.wxM.setStyle(Paint.Style.FILL);
    this.wxM.setColor(this.wxL);
    this.wxM.setAntiAlias(true);
    this.wxN.setStyle(Paint.Style.FILL);
    this.wxN.setColor(this.endColor);
    this.wxN.setAntiAlias(true);
    this.uRh.setStyle(Paint.Style.FILL);
    this.uRh.setColor(this.uRe);
    this.uRh.setAntiAlias(true);
    AppMethodBeat.o(199346);
  }
  
  private final RectF Ml(int paramInt)
  {
    AppMethodBeat.i(199344);
    Object localObject = this.uRo.get(paramInt);
    k.g(localObject, "subProgress[index]");
    float f2 = ((Number)localObject).floatValue() * getWidth() / 100.0F;
    float f3 = getHeight();
    if (paramInt == 0) {}
    for (float f1 = 0.0F;; f1 = ((Number)this.uRo.get(paramInt - 1)).floatValue() * getWidth() / 100.0F)
    {
      localObject = new RectF(f1, 0.0F, f2, f3);
      AppMethodBeat.o(199344);
      return localObject;
    }
  }
  
  public final void at(ArrayList<Float> paramArrayList)
  {
    AppMethodBeat.i(199339);
    k.h(paramArrayList, "subProgress");
    this.uRo.clear();
    this.uRo.addAll((Collection)paramArrayList);
    this.wxO = false;
    this.uRs = false;
    postInvalidate();
    AppMethodBeat.o(199339);
  }
  
  public final void dwo()
  {
    AppMethodBeat.i(199340);
    this.wxO = true;
    postInvalidate();
    AppMethodBeat.o(199340);
  }
  
  public final void k(Integer paramInteger)
  {
    AppMethodBeat.i(199342);
    this.uRs = false;
    if (paramInteger != null)
    {
      i = this.uRo.size();
      if (paramInteger.intValue() == i)
      {
        AppMethodBeat.o(199342);
        return;
      }
    }
    if (!((Collection)this.uRo).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.uRo.remove(this.uRo.size() - 1);
      }
      invalidate();
      AppMethodBeat.o(199342);
      return;
    }
  }
  
  public final void oe(boolean paramBoolean)
  {
    AppMethodBeat.i(199341);
    this.uRs = paramBoolean;
    invalidate();
    AppMethodBeat.o(199341);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(199343);
    Object localObject1 = (Iterable)this.uRo;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.fOc();
      }
      ((Number)localObject2).floatValue();
      if ((i == this.uRo.size() - 1) && (this.uRs)) {
        if (paramCanvas != null) {
          paramCanvas.drawRect(Ml(i), this.uRh);
        }
      }
      for (;;)
      {
        if (((i == this.uRo.size() - 1) && (!this.wxO)) || (paramCanvas == null)) {
          break label230;
        }
        localObject2 = this.uRo.get(i);
        k.g(localObject2, "subProgress[index]");
        float f1 = ((Number)localObject2).floatValue() * getWidth() / 100.0F;
        float f2 = getHeight();
        paramCanvas.drawRect(new RectF(f1 - getWidth() * 0.0053F, 0.0F, f1, f2), this.wxN);
        i = j;
        break;
        if (paramCanvas != null) {
          paramCanvas.drawRect(Ml(i), this.wxM);
        }
      }
      label230:
      i = j;
    }
    AppMethodBeat.o(199343);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar$Companion;", "", "()V", "END_POINT", "", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.progress.HorizontalSubProgressBar
 * JD-Core Version:    0.7.0.1
 */