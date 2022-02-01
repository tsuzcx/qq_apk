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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bodyColor", "bodyPaint", "Landroid/graphics/Paint;", "deleteColor", "deletePaint", "endColor", "endPaint", "prepareDelete", "", "subFinish", "subProgress", "Ljava/util/ArrayList;", "", "getDrawBodyRect", "Landroid/graphics/RectF;", "index", "getDrawEndRect", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "delete", "removeCurrentProgress", "verify", "(Ljava/lang/Integer;)V", "reset", "updateProgress", "Companion", "plugin-recordvideo_release"})
public final class HorizontalSubProgressBar
  extends View
{
  public static final a HUd;
  private final int FfN;
  private Paint FfQ;
  public ArrayList<Float> FfX;
  public boolean Fgb;
  private int HTZ;
  private Paint HUa;
  private Paint HUb;
  public boolean HUc;
  private final int endColor;
  
  static
  {
    AppMethodBeat.i(220187);
    HUd = new a((byte)0);
    AppMethodBeat.o(220187);
  }
  
  public HorizontalSubProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(220177);
    this.HTZ = Color.parseColor("#FA9D3B");
    this.endColor = Color.parseColor("#ffffff");
    this.FfN = Color.parseColor("#FA5151");
    this.HUa = new Paint();
    this.HUb = new Paint();
    this.FfQ = new Paint();
    this.FfX = new ArrayList();
    this.HUa.setStyle(Paint.Style.FILL);
    this.HUa.setColor(this.HTZ);
    this.HUa.setAntiAlias(true);
    this.HUb.setStyle(Paint.Style.FILL);
    this.HUb.setColor(this.endColor);
    this.HUb.setAntiAlias(true);
    this.FfQ.setStyle(Paint.Style.FILL);
    this.FfQ.setColor(this.FfN);
    this.FfQ.setAntiAlias(true);
    AppMethodBeat.o(220177);
  }
  
  public HorizontalSubProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220184);
    this.HTZ = Color.parseColor("#FA9D3B");
    this.endColor = Color.parseColor("#ffffff");
    this.FfN = Color.parseColor("#FA5151");
    this.HUa = new Paint();
    this.HUb = new Paint();
    this.FfQ = new Paint();
    this.FfX = new ArrayList();
    this.HUa.setStyle(Paint.Style.FILL);
    this.HUa.setColor(this.HTZ);
    this.HUa.setAntiAlias(true);
    this.HUb.setStyle(Paint.Style.FILL);
    this.HUb.setColor(this.endColor);
    this.HUb.setAntiAlias(true);
    this.FfQ.setStyle(Paint.Style.FILL);
    this.FfQ.setColor(this.FfN);
    this.FfQ.setAntiAlias(true);
    AppMethodBeat.o(220184);
  }
  
  private final RectF aco(int paramInt)
  {
    AppMethodBeat.i(220164);
    Object localObject = this.FfX.get(paramInt);
    p.j(localObject, "subProgress[index]");
    float f2 = ((Number)localObject).floatValue() * getWidth() / 100.0F;
    float f3 = getHeight();
    if (paramInt == 0) {}
    for (float f1 = 0.0F;; f1 = ((Number)this.FfX.get(paramInt - 1)).floatValue() * getWidth() / 100.0F)
    {
      localObject = new RectF(f1, 0.0F, f2, f3);
      AppMethodBeat.o(220164);
      return localObject;
    }
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(220161);
    Object localObject1 = (Iterable)this.FfX;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.iBO();
      }
      ((Number)localObject2).floatValue();
      if ((i == this.FfX.size() - 1) && (this.Fgb)) {
        if (paramCanvas != null) {
          paramCanvas.drawRect(aco(i), this.FfQ);
        }
      }
      for (;;)
      {
        if (((i == this.FfX.size() - 1) && (!this.HUc)) || (paramCanvas == null)) {
          break label230;
        }
        localObject2 = this.FfX.get(i);
        p.j(localObject2, "subProgress[index]");
        float f1 = ((Number)localObject2).floatValue() * getWidth() / 100.0F;
        float f2 = getHeight();
        paramCanvas.drawRect(new RectF(f1 - getWidth() * 0.0053F, 0.0F, f1, f2), this.HUb);
        i = j;
        break;
        if (paramCanvas != null) {
          paramCanvas.drawRect(aco(i), this.HUa);
        }
      }
      label230:
      i = j;
    }
    AppMethodBeat.o(220161);
  }
  
  public final void u(Integer paramInteger)
  {
    AppMethodBeat.i(220150);
    this.Fgb = false;
    if (paramInteger != null)
    {
      i = this.FfX.size();
      if (paramInteger.intValue() == i)
      {
        AppMethodBeat.o(220150);
        return;
      }
    }
    if (!((Collection)this.FfX).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.FfX.remove(this.FfX.size() - 1);
      }
      invalidate();
      AppMethodBeat.o(220150);
      return;
    }
  }
  
  public final void up(boolean paramBoolean)
  {
    AppMethodBeat.i(220145);
    this.Fgb = paramBoolean;
    invalidate();
    AppMethodBeat.o(220145);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar$Companion;", "", "()V", "END_POINT", "", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.progress.HorizontalSubProgressBar
 * JD-Core Version:    0.7.0.1
 */