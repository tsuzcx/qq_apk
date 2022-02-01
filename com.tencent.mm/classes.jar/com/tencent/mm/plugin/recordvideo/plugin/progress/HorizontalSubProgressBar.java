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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bodyColor", "bodyPaint", "Landroid/graphics/Paint;", "deleteColor", "deletePaint", "endColor", "endPaint", "prepareDelete", "", "subFinish", "subProgress", "Ljava/util/ArrayList;", "", "getDrawBodyRect", "Landroid/graphics/RectF;", "index", "getDrawEndRect", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "delete", "removeCurrentProgress", "verify", "(Ljava/lang/Integer;)V", "reset", "updateProgress", "Companion", "plugin-recordvideo_release"})
public final class HorizontalSubProgressBar
  extends View
{
  public static final a LoK;
  private final int LmM;
  private Paint LmO;
  ArrayList<Float> LmQ;
  private boolean LmU;
  private int LoG;
  private Paint LoH;
  private Paint LoI;
  boolean LoJ;
  private final int endColor;
  
  static
  {
    AppMethodBeat.i(204228);
    LoK = new a((byte)0);
    AppMethodBeat.o(204228);
  }
  
  public HorizontalSubProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204226);
    this.LoG = Color.parseColor("#FA9D3B");
    this.endColor = Color.parseColor("#ffffff");
    this.LmM = Color.parseColor("#FA5151");
    this.LoH = new Paint();
    this.LoI = new Paint();
    this.LmO = new Paint();
    this.LmQ = new ArrayList();
    this.LoH.setStyle(Paint.Style.FILL);
    this.LoH.setColor(this.LoG);
    this.LoH.setAntiAlias(true);
    this.LoI.setStyle(Paint.Style.FILL);
    this.LoI.setColor(this.endColor);
    this.LoI.setAntiAlias(true);
    this.LmO.setStyle(Paint.Style.FILL);
    this.LmO.setColor(this.LmM);
    this.LmO.setAntiAlias(true);
    AppMethodBeat.o(204226);
  }
  
  public HorizontalSubProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204227);
    this.LoG = Color.parseColor("#FA9D3B");
    this.endColor = Color.parseColor("#ffffff");
    this.LmM = Color.parseColor("#FA5151");
    this.LoH = new Paint();
    this.LoI = new Paint();
    this.LmO = new Paint();
    this.LmQ = new ArrayList();
    this.LoH.setStyle(Paint.Style.FILL);
    this.LoH.setColor(this.LoG);
    this.LoH.setAntiAlias(true);
    this.LoI.setStyle(Paint.Style.FILL);
    this.LoI.setColor(this.endColor);
    this.LoI.setAntiAlias(true);
    this.LmO.setStyle(Paint.Style.FILL);
    this.LmO.setColor(this.LmM);
    this.LmO.setAntiAlias(true);
    AppMethodBeat.o(204227);
  }
  
  private final RectF aie(int paramInt)
  {
    AppMethodBeat.i(204225);
    Object localObject = this.LmQ.get(paramInt);
    k.g(localObject, "subProgress[index]");
    float f2 = ((Number)localObject).floatValue() * getWidth() / 100.0F;
    float f3 = getHeight();
    if (paramInt == 0) {}
    for (float f1 = 0.0F;; f1 = ((Number)this.LmQ.get(paramInt - 1)).floatValue() * getWidth() / 100.0F)
    {
      localObject = new RectF(f1, 0.0F, f2, f3);
      AppMethodBeat.o(204225);
      return localObject;
    }
  }
  
  public final void bb(ArrayList<Float> paramArrayList)
  {
    AppMethodBeat.i(204220);
    k.h(paramArrayList, "subProgress");
    this.LmQ.clear();
    this.LmQ.addAll((Collection)paramArrayList);
    this.LoJ = false;
    this.LmU = false;
    postInvalidate();
    AppMethodBeat.o(204220);
  }
  
  public final void fYp()
  {
    AppMethodBeat.i(204221);
    this.LoJ = true;
    postInvalidate();
    AppMethodBeat.o(204221);
  }
  
  public final void o(Integer paramInteger)
  {
    AppMethodBeat.i(204223);
    this.LmU = false;
    if (paramInteger != null)
    {
      i = this.LmQ.size();
      if (paramInteger.intValue() == i)
      {
        AppMethodBeat.o(204223);
        return;
      }
    }
    if (!((Collection)this.LmQ).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.LmQ.remove(this.LmQ.size() - 1);
      }
      invalidate();
      AppMethodBeat.o(204223);
      return;
    }
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(204224);
    Object localObject1 = (Iterable)this.LmQ;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.fvx();
      }
      ((Number)localObject2).floatValue();
      if ((i == this.LmQ.size() - 1) && (this.LmU)) {
        if (paramCanvas != null) {
          paramCanvas.drawRect(aie(i), this.LmO);
        }
      }
      for (;;)
      {
        if (((i == this.LmQ.size() - 1) && (!this.LoJ)) || (paramCanvas == null)) {
          break label230;
        }
        localObject2 = this.LmQ.get(i);
        k.g(localObject2, "subProgress[index]");
        float f1 = ((Number)localObject2).floatValue() * getWidth() / 100.0F;
        float f2 = getHeight();
        paramCanvas.drawRect(new RectF(f1 - getWidth() * 0.0053F, 0.0F, f1, f2), this.LoI);
        i = j;
        break;
        if (paramCanvas != null) {
          paramCanvas.drawRect(aie(i), this.LoH);
        }
      }
      label230:
      i = j;
    }
    AppMethodBeat.o(204224);
  }
  
  public final void yY(boolean paramBoolean)
  {
    AppMethodBeat.i(204222);
    this.LmU = paramBoolean;
    invalidate();
    AppMethodBeat.o(204222);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar$Companion;", "", "()V", "END_POINT", "", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.progress.HorizontalSubProgressBar
 * JD-Core Version:    0.7.0.1
 */