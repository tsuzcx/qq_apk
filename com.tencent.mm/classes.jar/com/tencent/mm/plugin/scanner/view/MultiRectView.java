package com.tencent.mm.plugin.scanner.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;

public class MultiRectView
  extends View
{
  private Paint PaM;
  private List<Rect> Pks;
  private List<Rect> Pkt;
  private final String TAG;
  private Paint paint;
  
  public MultiRectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(314028);
    this.TAG = "MicroMsg.MultiRectView";
    this.Pkt = new ArrayList();
    this.paint = new Paint();
    this.PaM = new Paint();
    init();
    AppMethodBeat.o(314028);
  }
  
  public MultiRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(314032);
    this.TAG = "MicroMsg.MultiRectView";
    this.Pkt = new ArrayList();
    this.paint = new Paint();
    this.PaM = new Paint();
    init();
    AppMethodBeat.o(314032);
  }
  
  public MultiRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(314037);
    this.TAG = "MicroMsg.MultiRectView";
    this.Pkt = new ArrayList();
    this.paint = new Paint();
    this.PaM = new Paint();
    init();
    AppMethodBeat.o(314037);
  }
  
  private void init()
  {
    AppMethodBeat.i(314042);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setStrokeWidth(8.0F);
    this.paint.setColor(-65536);
    this.paint.setAntiAlias(true);
    this.PaM.setAntiAlias(true);
    AppMethodBeat.o(314042);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(314051);
    super.onDraw(paramCanvas);
    if ((this.Pks != null) && (!this.Pks.isEmpty()))
    {
      Iterator localIterator = this.Pks.iterator();
      while (localIterator.hasNext())
      {
        Rect localRect = (Rect)localIterator.next();
        if (localRect != null)
        {
          paramCanvas.save();
          paramCanvas.clipRect(localRect, Region.Op.DIFFERENCE);
          paramCanvas.drawRect(localRect, this.paint);
          paramCanvas.restore();
        }
      }
    }
    AppMethodBeat.o(314051);
  }
  
  public void setRect(List<Rect> paramList)
  {
    AppMethodBeat.i(314048);
    this.Pks = paramList;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      setVisibility(8);
      Log.e("MicroMsg.MultiRectView", "setRect:".concat(String.valueOf(paramList)));
      AppMethodBeat.o(314048);
      return;
    }
    Log.i("MicroMsg.MultiRectView", "setRect:" + paramList.size());
    setVisibility(0);
    invalidate();
    AppMethodBeat.o(314048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.MultiRectView
 * JD-Core Version:    0.7.0.1
 */