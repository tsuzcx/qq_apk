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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bodyColor", "bodyPaint", "Landroid/graphics/Paint;", "deleteColor", "deletePaint", "endColor", "endPaint", "prepareDelete", "", "subFinish", "subProgress", "Ljava/util/ArrayList;", "", "getDrawBodyRect", "Landroid/graphics/RectF;", "index", "getDrawEndRect", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "delete", "removeCurrentProgress", "verify", "(Ljava/lang/Integer;)V", "reset", "updateProgress", "Companion", "plugin-recordvideo_release"})
public final class HorizontalSubProgressBar
  extends View
{
  public static final HorizontalSubProgressBar.a BXp;
  private int BXl;
  private Paint BXm;
  private Paint BXn;
  boolean BXo;
  private final int endColor;
  private final int zAS;
  private Paint zAV;
  ArrayList<Float> zBc;
  private boolean zBg;
  
  static
  {
    AppMethodBeat.i(237424);
    BXp = new HorizontalSubProgressBar.a((byte)0);
    AppMethodBeat.o(237424);
  }
  
  public HorizontalSubProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(237422);
    this.BXl = Color.parseColor("#FA9D3B");
    this.endColor = Color.parseColor("#ffffff");
    this.zAS = Color.parseColor("#FA5151");
    this.BXm = new Paint();
    this.BXn = new Paint();
    this.zAV = new Paint();
    this.zBc = new ArrayList();
    this.BXm.setStyle(Paint.Style.FILL);
    this.BXm.setColor(this.BXl);
    this.BXm.setAntiAlias(true);
    this.BXn.setStyle(Paint.Style.FILL);
    this.BXn.setColor(this.endColor);
    this.BXn.setAntiAlias(true);
    this.zAV.setStyle(Paint.Style.FILL);
    this.zAV.setColor(this.zAS);
    this.zAV.setAntiAlias(true);
    AppMethodBeat.o(237422);
  }
  
  public HorizontalSubProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(237423);
    this.BXl = Color.parseColor("#FA9D3B");
    this.endColor = Color.parseColor("#ffffff");
    this.zAS = Color.parseColor("#FA5151");
    this.BXm = new Paint();
    this.BXn = new Paint();
    this.zAV = new Paint();
    this.zBc = new ArrayList();
    this.BXm.setStyle(Paint.Style.FILL);
    this.BXm.setColor(this.BXl);
    this.BXm.setAntiAlias(true);
    this.BXn.setStyle(Paint.Style.FILL);
    this.BXn.setColor(this.endColor);
    this.BXn.setAntiAlias(true);
    this.zAV.setStyle(Paint.Style.FILL);
    this.zAV.setColor(this.zAS);
    this.zAV.setAntiAlias(true);
    AppMethodBeat.o(237423);
  }
  
  private final RectF VF(int paramInt)
  {
    AppMethodBeat.i(237421);
    Object localObject = this.zBc.get(paramInt);
    p.g(localObject, "subProgress[index]");
    float f2 = ((Number)localObject).floatValue() * getWidth() / 100.0F;
    float f3 = getHeight();
    if (paramInt == 0) {}
    for (float f1 = 0.0F;; f1 = ((Number)this.zBc.get(paramInt - 1)).floatValue() * getWidth() / 100.0F)
    {
      localObject = new RectF(f1, 0.0F, f2, f3);
      AppMethodBeat.o(237421);
      return localObject;
    }
  }
  
  public final void aJ(ArrayList<Float> paramArrayList)
  {
    AppMethodBeat.i(237416);
    p.h(paramArrayList, "subProgress");
    this.zBc.clear();
    this.zBc.addAll((Collection)paramArrayList);
    this.BXo = false;
    this.zBg = false;
    postInvalidate();
    AppMethodBeat.o(237416);
  }
  
  public final void eKU()
  {
    AppMethodBeat.i(237417);
    this.BXo = true;
    postInvalidate();
    AppMethodBeat.o(237417);
  }
  
  public final void m(Integer paramInteger)
  {
    AppMethodBeat.i(237419);
    this.zBg = false;
    if (paramInteger != null)
    {
      i = this.zBc.size();
      if (paramInteger.intValue() == i)
      {
        AppMethodBeat.o(237419);
        return;
      }
    }
    if (!((Collection)this.zBc).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.zBc.remove(this.zBc.size() - 1);
      }
      invalidate();
      AppMethodBeat.o(237419);
      return;
    }
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(237420);
    Object localObject1 = (Iterable)this.zBc;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.hxH();
      }
      ((Number)localObject2).floatValue();
      if ((i == this.zBc.size() - 1) && (this.zBg)) {
        if (paramCanvas != null) {
          paramCanvas.drawRect(VF(i), this.zAV);
        }
      }
      for (;;)
      {
        if (((i == this.zBc.size() - 1) && (!this.BXo)) || (paramCanvas == null)) {
          break label230;
        }
        localObject2 = this.zBc.get(i);
        p.g(localObject2, "subProgress[index]");
        float f1 = ((Number)localObject2).floatValue() * getWidth() / 100.0F;
        float f2 = getHeight();
        paramCanvas.drawRect(new RectF(f1 - getWidth() * 0.0053F, 0.0F, f1, f2), this.BXn);
        i = j;
        break;
        if (paramCanvas != null) {
          paramCanvas.drawRect(VF(i), this.BXm);
        }
      }
      label230:
      i = j;
    }
    AppMethodBeat.o(237420);
  }
  
  public final void rl(boolean paramBoolean)
  {
    AppMethodBeat.i(237418);
    this.zBg = paramBoolean;
    invalidate();
    AppMethodBeat.o(237418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.progress.HorizontalSubProgressBar
 * JD-Core Version:    0.7.0.1
 */