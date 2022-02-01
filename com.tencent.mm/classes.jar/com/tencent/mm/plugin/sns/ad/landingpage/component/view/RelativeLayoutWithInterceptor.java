package com.tencent.mm.plugin.sns.ad.landingpage.component.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RelativeLayoutWithInterceptor
  extends RelativeLayout
{
  private a DtW;
  
  public RelativeLayoutWithInterceptor(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RelativeLayoutWithInterceptor(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(202000);
    if (this.DtW != null)
    {
      boolean bool = this.DtW.eXh();
      AppMethodBeat.o(202000);
      return bool;
    }
    AppMethodBeat.o(202000);
    return true;
  }
  
  public void setEventInterceptor(a parama)
  {
    this.DtW = parama;
  }
  
  public static abstract interface a
  {
    public abstract boolean eXh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.view.RelativeLayoutWithInterceptor
 * JD-Core Version:    0.7.0.1
 */