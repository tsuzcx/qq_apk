package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public class DrawnCallBackLinearLayout
  extends LinearLayout
{
  public final boolean DEBUG = true;
  public final String TAG = "MicroMsg.TestTimeForChatting";
  private DrawnCallBackLinearLayout.a afSd;
  private b afSe;
  
  public DrawnCallBackLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public DrawnCallBackLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DrawnCallBackLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143316);
    super.dispatchDraw(paramCanvas);
    if (this.afSd != null)
    {
      this.afSd.jtE();
      this.afSd = null;
    }
    AppMethodBeat.o(143316);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143314);
    if (this.afSe != null) {
      this.afSe = null;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143314);
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143315);
    long l = System.currentTimeMillis();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d("MicroMsg.TestTimeForChatting", "[onLayout] " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(143315);
  }
  
  public void setListener(DrawnCallBackLinearLayout.a parama)
  {
    this.afSd = parama;
  }
  
  public void setTouchedCallback(b paramb)
  {
    this.afSe = paramb;
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.DrawnCallBackLinearLayout
 * JD-Core Version:    0.7.0.1
 */