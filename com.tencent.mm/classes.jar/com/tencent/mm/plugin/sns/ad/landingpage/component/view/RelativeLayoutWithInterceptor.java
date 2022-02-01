package com.tencent.mm.plugin.sns.ad.landingpage.component.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RelativeLayoutWithInterceptor
  extends RelativeLayout
{
  private a PTb;
  
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
    AppMethodBeat.i(310656);
    if (this.PTb != null)
    {
      boolean bool = this.PTb.haK();
      AppMethodBeat.o(310656);
      return bool;
    }
    AppMethodBeat.o(310656);
    return true;
  }
  
  public void setEventInterceptor(a parama)
  {
    this.PTb = parama;
  }
  
  public static abstract interface a
  {
    public abstract boolean haK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.view.RelativeLayoutWithInterceptor
 * JD-Core Version:    0.7.0.1
 */