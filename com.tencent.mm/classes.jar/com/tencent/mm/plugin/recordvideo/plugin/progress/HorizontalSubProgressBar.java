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
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bodyColor", "bodyPaint", "Landroid/graphics/Paint;", "deleteColor", "deletePaint", "endColor", "endPaint", "prepareDelete", "", "subFinish", "subProgress", "Ljava/util/ArrayList;", "", "getDrawBodyRect", "Landroid/graphics/RectF;", "index", "getDrawEndRect", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "delete", "removeCurrentProgress", "verify", "(Ljava/lang/Integer;)V", "reset", "updateProgress", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HorizontalSubProgressBar
  extends View
{
  public static final HorizontalSubProgressBar.a NQK;
  public boolean LbB;
  private final int Lbn;
  private Paint Lbq;
  public ArrayList<Float> Lbx;
  private int NQL;
  private Paint NQM;
  private Paint NQN;
  public boolean NQO;
  private final int endColor;
  
  static
  {
    AppMethodBeat.i(280540);
    NQK = new HorizontalSubProgressBar.a((byte)0);
    AppMethodBeat.o(280540);
  }
  
  public HorizontalSubProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(280522);
    this.NQL = Color.parseColor("#FA9D3B");
    this.endColor = Color.parseColor("#ffffff");
    this.Lbn = Color.parseColor("#FA5151");
    this.NQM = new Paint();
    this.NQN = new Paint();
    this.Lbq = new Paint();
    this.Lbx = new ArrayList();
    this.NQM.setStyle(Paint.Style.FILL);
    this.NQM.setColor(this.NQL);
    this.NQM.setAntiAlias(true);
    this.NQN.setStyle(Paint.Style.FILL);
    this.NQN.setColor(this.endColor);
    this.NQN.setAntiAlias(true);
    this.Lbq.setStyle(Paint.Style.FILL);
    this.Lbq.setColor(this.Lbn);
    this.Lbq.setAntiAlias(true);
    AppMethodBeat.o(280522);
  }
  
  public HorizontalSubProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(280526);
    this.NQL = Color.parseColor("#FA9D3B");
    this.endColor = Color.parseColor("#ffffff");
    this.Lbn = Color.parseColor("#FA5151");
    this.NQM = new Paint();
    this.NQN = new Paint();
    this.Lbq = new Paint();
    this.Lbx = new ArrayList();
    this.NQM.setStyle(Paint.Style.FILL);
    this.NQM.setColor(this.NQL);
    this.NQM.setAntiAlias(true);
    this.NQN.setStyle(Paint.Style.FILL);
    this.NQN.setColor(this.endColor);
    this.NQN.setAntiAlias(true);
    this.Lbq.setStyle(Paint.Style.FILL);
    this.Lbq.setColor(this.Lbn);
    this.Lbq.setAntiAlias(true);
    AppMethodBeat.o(280526);
  }
  
  private final RectF agE(int paramInt)
  {
    AppMethodBeat.i(280533);
    Object localObject = this.Lbx.get(paramInt);
    s.s(localObject, "subProgress[index]");
    float f2 = ((Number)localObject).floatValue() * getWidth() / 100.0F;
    float f3 = getHeight();
    if (paramInt == 0) {}
    for (float f1 = 0.0F;; f1 = ((Number)this.Lbx.get(paramInt - 1)).floatValue() * getWidth() / 100.0F)
    {
      localObject = new RectF(f1, 0.0F, f2, f3);
      AppMethodBeat.o(280533);
      return localObject;
    }
  }
  
  public final void B(Integer paramInteger)
  {
    AppMethodBeat.i(280555);
    this.LbB = false;
    if (paramInteger != null)
    {
      i = this.Lbx.size();
      if (paramInteger.intValue() == i)
      {
        AppMethodBeat.o(280555);
        return;
      }
    }
    if (!((Collection)this.Lbx).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.Lbx.remove(this.Lbx.size() - 1);
      }
      invalidate();
      AppMethodBeat.o(280555);
      return;
    }
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(280566);
    Object localObject1 = (Iterable)this.Lbx;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
      }
      ((Number)localObject2).floatValue();
      if ((i == this.Lbx.size() - 1) && (this.LbB)) {
        if (paramCanvas != null) {
          paramCanvas.drawRect(agE(i), this.Lbq);
        }
      }
      for (;;)
      {
        if (((i != this.Lbx.size() - 1) || (this.NQO)) && (paramCanvas != null))
        {
          localObject2 = this.Lbx.get(i);
          s.s(localObject2, "subProgress[index]");
          float f1 = ((Number)localObject2).floatValue() * getWidth() / 100.0F;
          float f2 = getHeight();
          paramCanvas.drawRect(new RectF(f1 - getWidth() * 0.0053F, 0.0F, f1, f2), this.NQN);
        }
        i += 1;
        break;
        if (paramCanvas != null) {
          paramCanvas.drawRect(agE(i), this.NQM);
        }
      }
    }
    AppMethodBeat.o(280566);
  }
  
  public final void yC(boolean paramBoolean)
  {
    AppMethodBeat.i(280545);
    this.LbB = paramBoolean;
    invalidate();
    AppMethodBeat.o(280545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.progress.HorizontalSubProgressBar
 * JD-Core Version:    0.7.0.1
 */