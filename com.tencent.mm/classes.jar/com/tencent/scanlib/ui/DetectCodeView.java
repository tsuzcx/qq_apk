package com.tencent.scanlib.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.scanlib.model.DetectCode;
import java.util.Iterator;
import java.util.List;

public class DetectCodeView
  extends View
{
  private List<DetectCode> JVx;
  private Paint paint;
  
  public DetectCodeView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(3567);
    this.paint = new Paint();
    AppMethodBeat.o(3567);
  }
  
  public DetectCodeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(3568);
    this.paint = new Paint();
    AppMethodBeat.o(3568);
  }
  
  public DetectCodeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(3569);
    this.paint = new Paint();
    AppMethodBeat.o(3569);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(3571);
    super.onDraw(paramCanvas);
    if ((this.JVx != null) && (!this.JVx.isEmpty()))
    {
      Iterator localIterator = this.JVx.iterator();
      while (localIterator.hasNext())
      {
        DetectCode localDetectCode = (DetectCode)localIterator.next();
        if (localDetectCode.points.size() == 4) {
          paramCanvas.drawRect(new Rect(((Point)localDetectCode.points.get(0)).x, ((Point)localDetectCode.points.get(0)).y, ((Point)localDetectCode.points.get(2)).x, ((Point)localDetectCode.points.get(2)).y), this.paint);
        }
      }
    }
    AppMethodBeat.o(3571);
  }
  
  public void setDetectedCodes(List<DetectCode> paramList)
  {
    AppMethodBeat.i(3570);
    this.JVx = paramList;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.paint.reset();
      this.paint.setColor(-65536);
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setAntiAlias(true);
      this.paint.setStrokeWidth(getResources().getDimension(2131166763));
    }
    postInvalidate();
    AppMethodBeat.o(3570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.scanlib.ui.DetectCodeView
 * JD-Core Version:    0.7.0.1
 */