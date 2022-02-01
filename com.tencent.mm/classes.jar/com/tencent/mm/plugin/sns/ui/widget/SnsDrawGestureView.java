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
import com.tencent.mm.cd.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SnsDrawGestureView
  extends ImageView
{
  private Paint LGK;
  private a RXs;
  private int RXt;
  private Paint RXu;
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
    this.RXt = -1;
    this.LGK = new Paint();
    this.RXu = new Paint();
    this.LGK.setColor(this.RXt);
    this.LGK.setStyle(Paint.Style.STROKE);
    this.LGK.setStrokeWidth(a.fromDPToPix(getContext(), 8));
    this.LGK.setPathEffect(new CornerPathEffect(a.fromDPToPix(getContext(), 4)));
    this.LGK.setAntiAlias(true);
    this.RXu.setColor(this.RXt);
    this.RXu.setStyle(Paint.Style.FILL);
    this.RXu.setAntiAlias(true);
    if (d.rc(21)) {
      setLayerType(1, null);
    }
    AppMethodBeat.o(100540);
  }
  
  private List<PointF> hsV()
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
  
  public a getOnGestureListener()
  {
    return this.RXs;
  }
  
  public final void hsW()
  {
    AppMethodBeat.i(100545);
    this.points.clear();
    postInvalidate();
    AppMethodBeat.o(100545);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(100542);
    super.onDraw(paramCanvas);
    if (this.points.size() > 0)
    {
      Path localPath = new Path();
      localPath.moveTo(((PointF)this.points.get(0)).x, ((PointF)this.points.get(0)).y);
      paramCanvas.drawCircle(((PointF)this.points.get(0)).x, ((PointF)this.points.get(0)).y, a.fromDPToPix(getContext(), 8) / 2.0F, this.RXu);
      int i = 1;
      while (i < this.points.size())
      {
        localPath.lineTo(((PointF)this.points.get(i)).x, ((PointF)this.points.get(i)).y);
        i += 1;
      }
      paramCanvas.drawPath(localPath, this.LGK);
      paramCanvas.drawCircle(((PointF)this.points.get(this.points.size() - 1)).x, ((PointF)this.points.get(this.points.size() - 1)).y, a.fromDPToPix(getContext(), 8) / 2.0F, this.RXu);
    }
    AppMethodBeat.o(100542);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(100541);
    if (paramMotionEvent.getActionMasked() == 0)
    {
      if (this.RXs != null) {
        this.RXs.hrc();
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
        Log.i("MicroMsg.SnsDrawGestureViewView", "point count %d", new Object[] { Integer.valueOf(this.points.size()) });
        if (this.points.size() < 6)
        {
          this.points.clear();
          if (this.RXs != null) {
            this.RXs.onClick();
          }
        }
        else if (this.RXs != null)
        {
          this.RXs.kS(hsV());
        }
      }
      else if (this.RXs != null)
      {
        this.RXs.kS(hsV());
      }
    }
  }
  
  public void setOnGestureListener(a parama)
  {
    this.RXs = parama;
  }
  
  public void setPaintColor(int paramInt)
  {
    AppMethodBeat.i(100544);
    this.RXt = paramInt;
    this.LGK.setColor(this.RXt);
    this.RXu.setColor(this.RXt);
    AppMethodBeat.o(100544);
  }
  
  public static abstract interface a
  {
    public abstract void hrc();
    
    public abstract void kS(List<PointF> paramList);
    
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView
 * JD-Core Version:    0.7.0.1
 */