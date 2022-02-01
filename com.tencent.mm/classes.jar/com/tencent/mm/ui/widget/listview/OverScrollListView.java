package com.tencent.mm.ui.widget.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ap;

public class OverScrollListView
  extends ListView
{
  private int KZs;
  private float y1;
  private float y2;
  
  public OverScrollListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OverScrollListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(192642);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(192642);
      return bool;
      this.y1 = paramMotionEvent.getY(0);
      continue;
      this.y2 = paramMotionEvent.getY(0);
      this.KZs = ((int)Math.abs(this.y2 - this.y1));
    }
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(192643);
    ap.d("OverScrollListView", "dancy test maxOverScrollYDis: %s", new Object[] { Integer.valueOf(this.KZs) });
    paramBoolean = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, this.KZs / 2, paramBoolean);
    AppMethodBeat.o(192643);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.OverScrollListView
 * JD-Core Version:    0.7.0.1
 */