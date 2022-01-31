package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
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
  private DrawnCallBackLinearLayout.a ABY;
  private DrawnCallBackLinearLayout.b ABZ;
  public final boolean DEBUG = true;
  public final String TAG = "MicroMsg.TestTimeForChatting";
  
  public DrawnCallBackLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public DrawnCallBackLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public DrawnCallBackLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(107845);
    super.dispatchDraw(paramCanvas);
    if (this.ABY != null)
    {
      this.ABY.dJg();
      this.ABY = null;
    }
    AppMethodBeat.o(107845);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(107843);
    if (this.ABZ != null) {
      this.ABZ = null;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(107843);
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(107844);
    long l = System.currentTimeMillis();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i("MicroMsg.TestTimeForChatting", "[onLayout] " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(107844);
  }
  
  public void setListener(DrawnCallBackLinearLayout.a parama)
  {
    this.ABY = parama;
  }
  
  public void setTouchedCallback(DrawnCallBackLinearLayout.b paramb)
  {
    this.ABZ = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.DrawnCallBackLinearLayout
 * JD-Core Version:    0.7.0.1
 */