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
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SnsDrawGestureView
  extends ImageView
{
  private a AUP;
  private int AUQ;
  private Paint AUR;
  private Paint AUS;
  private List<PointF> points;
  
  public SnsDrawGestureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public SnsDrawGestureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100540);
    this.points = new ArrayList();
    this.AUQ = -1;
    this.AUR = new Paint();
    this.AUS = new Paint();
    this.AUR.setColor(this.AUQ);
    this.AUR.setStyle(Paint.Style.STROKE);
    this.AUR.setStrokeWidth(a.fromDPToPix(getContext(), 8));
    this.AUR.setPathEffect(new CornerPathEffect(a.fromDPToPix(getContext(), 4)));
    this.AUR.setAntiAlias(true);
    this.AUS.setColor(this.AUQ);
    this.AUS.setStyle(Paint.Style.FILL);
    this.AUS.setAntiAlias(true);
    if (d.lB(21)) {
      setLayerType(1, null);
    }
    AppMethodBeat.o(100540);
  }
  
  private List<PointF> eiJ()
  {
    AppMethodBeat.i(100543);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.points.iterator();
    while (localIterator.hasNext())
    {
      PointF localPointF = (PointF)localIterator.next();
      localArrayList.add(new PointF(localPointF.x, localPointF.y));
    }
    AppMethodBeat.o(100543);
    return localArrayList;
  }
  
  public final void eiK()
  {
    AppMethodBeat.i(100545);
    this.points.clear();
    postInvalidate();
    AppMethodBeat.o(100545);
  }
  
  public a getOnGestureListener()
  {
    return this.AUP;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(100542);
    super.onDraw(paramCanvas);
    if (this.points.size() > 0)
    {
      Path localPath = new Path();
      localPath.moveTo(((PointF)this.points.get(0)).x, ((PointF)this.points.get(0)).y);
      paramCanvas.drawCircle(((PointF)this.points.get(0)).x, ((PointF)this.points.get(0)).y, a.fromDPToPix(getContext(), 8) / 2.0F, this.AUS);
      int i = 1;
      while (i < this.points.size())
      {
        localPath.lineTo(((PointF)this.points.get(i)).x, ((PointF)this.points.get(i)).y);
        i += 1;
      }
      paramCanvas.drawPath(localPath, this.AUR);
      paramCanvas.drawCircle(((PointF)this.points.get(this.points.size() - 1)).x, ((PointF)this.points.get(this.points.size() - 1)).y, a.fromDPToPix(getContext(), 8) / 2.0F, this.AUS);
    }
    AppMethodBeat.o(100542);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(100541);
    if (paramMotionEvent.getActionMasked() == 0)
    {
      if (this.AUP != null) {
        this.AUP.ehK();
      }
      this.points.clear();
      paramMotionEvent = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
      this.points.add(paramMotionEvent);
    }
    for (;;)
    {
      AppMethodBeat.o(100541);
      return true;
      if (paramMotionEvent.getActionMasked() == 2)
      {
        paramMotionEvent = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
        this.points.add(paramMotionEvent);
        postInvalidate();
      }
      else if (paramMotionEvent.getActionMasked() == 1)
      {
        ae.i("MicroMsg.SnsDrawGestureViewView", "point count %d", new Object[] { Integer.valueOf(this.points.size()) });
        if (this.points.size() < 6)
        {
          this.points.clear();
          if (this.AUP != null) {
            this.AUP.onClick();
          }
        }
        else if (this.AUP != null)
        {
          this.AUP.gl(eiJ());
        }
      }
      else if (this.AUP != null)
      {
        this.AUP.gl(eiJ());
      }
    }
  }
  
  public void setOnGestureListener(a parama)
  {
    this.AUP = parama;
  }
  
  public void setPaintColor(int paramInt)
  {
    AppMethodBeat.i(100544);
    this.AUQ = paramInt;
    this.AUR.setColor(this.AUQ);
    this.AUS.setColor(this.AUQ);
    AppMethodBeat.o(100544);
  }
  
  public static abstract interface a
  {
    public abstract void ehK();
    
    public abstract void gl(List<PointF> paramList);
    
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView
 * JD-Core Version:    0.7.0.1
 */