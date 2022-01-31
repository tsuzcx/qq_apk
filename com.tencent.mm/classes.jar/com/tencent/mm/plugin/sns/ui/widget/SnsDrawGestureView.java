package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SnsDrawGestureView
  extends ImageView
{
  private List<PointF> points;
  private SnsDrawGestureView.a snh;
  private int sni;
  private Paint snj;
  private Paint snk;
  
  public SnsDrawGestureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public SnsDrawGestureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(40506);
    this.points = new ArrayList();
    this.sni = -1;
    this.snj = new Paint();
    this.snk = new Paint();
    this.snj.setColor(this.sni);
    this.snj.setStyle(Paint.Style.STROKE);
    this.snj.setStrokeWidth(a.fromDPToPix(getContext(), 8));
    this.snj.setPathEffect(new CornerPathEffect(a.fromDPToPix(getContext(), 4)));
    this.snj.setAntiAlias(true);
    this.snk.setColor(this.sni);
    this.snk.setStyle(Paint.Style.FILL);
    this.snk.setAntiAlias(true);
    if (d.fw(21)) {
      setLayerType(1, null);
    }
    AppMethodBeat.o(40506);
  }
  
  private List<PointF> cxL()
  {
    AppMethodBeat.i(40509);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.points.iterator();
    while (localIterator.hasNext())
    {
      PointF localPointF = (PointF)localIterator.next();
      localArrayList.add(new PointF(localPointF.x, localPointF.y));
    }
    AppMethodBeat.o(40509);
    return localArrayList;
  }
  
  public final void cxM()
  {
    AppMethodBeat.i(40511);
    this.points.clear();
    postInvalidate();
    AppMethodBeat.o(40511);
  }
  
  public SnsDrawGestureView.a getOnGestureListener()
  {
    return this.snh;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(40508);
    super.onDraw(paramCanvas);
    if (this.points.size() > 0)
    {
      Path localPath = new Path();
      localPath.moveTo(((PointF)this.points.get(0)).x, ((PointF)this.points.get(0)).y);
      paramCanvas.drawCircle(((PointF)this.points.get(0)).x, ((PointF)this.points.get(0)).y, a.fromDPToPix(getContext(), 8) / 2.0F, this.snk);
      int i = 1;
      while (i < this.points.size())
      {
        localPath.lineTo(((PointF)this.points.get(i)).x, ((PointF)this.points.get(i)).y);
        i += 1;
      }
      paramCanvas.drawPath(localPath, this.snj);
      paramCanvas.drawCircle(((PointF)this.points.get(this.points.size() - 1)).x, ((PointF)this.points.get(this.points.size() - 1)).y, a.fromDPToPix(getContext(), 8) / 2.0F, this.snk);
    }
    AppMethodBeat.o(40508);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(40507);
    if (paramMotionEvent.getActionMasked() == 0)
    {
      if (this.snh != null) {
        this.snh.cwT();
      }
      this.points.clear();
      paramMotionEvent = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
      this.points.add(paramMotionEvent);
    }
    for (;;)
    {
      AppMethodBeat.o(40507);
      return true;
      if (paramMotionEvent.getActionMasked() == 2)
      {
        paramMotionEvent = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
        this.points.add(paramMotionEvent);
        postInvalidate();
      }
      else if (paramMotionEvent.getActionMasked() == 1)
      {
        ab.i("MicroMsg.SnsDrawGestureViewView", "point count %d", new Object[] { Integer.valueOf(this.points.size()) });
        if (this.points.size() < 6)
        {
          this.points.clear();
          if (this.snh != null) {
            this.snh.onClick();
          }
        }
        else if (this.snh != null)
        {
          this.snh.dr(cxL());
        }
      }
      else if (this.snh != null)
      {
        this.snh.dr(cxL());
      }
    }
  }
  
  public void setOnGestureListener(SnsDrawGestureView.a parama)
  {
    this.snh = parama;
  }
  
  public void setPaintColor(int paramInt)
  {
    AppMethodBeat.i(40510);
    this.sni = paramInt;
    this.snj.setColor(this.sni);
    this.snk.setColor(this.sni);
    AppMethodBeat.o(40510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView
 * JD-Core Version:    0.7.0.1
 */