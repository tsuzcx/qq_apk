package io.flutter.plugin.platform;

import android.content.Context;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SingleViewPresentation$b
  extends ViewGroup
{
  private final Rect MGQ;
  private final Rect bWs;
  
  public SingleViewPresentation$b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(9894);
    this.bWs = new Rect();
    this.MGQ = new Rect();
    AppMethodBeat.o(9894);
  }
  
  private static int ajd(int paramInt)
  {
    AppMethodBeat.i(9897);
    paramInt = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt), -2147483648);
    AppMethodBeat.o(9897);
    return paramInt;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9895);
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)localView.getLayoutParams();
      this.bWs.set(paramInt1, paramInt2, paramInt3, paramInt4);
      Gravity.apply(localLayoutParams.gravity, localView.getMeasuredWidth(), localView.getMeasuredHeight(), this.bWs, localLayoutParams.x, localLayoutParams.y, this.MGQ);
      localView.layout(this.MGQ.left, this.MGQ.top, this.MGQ.right, this.MGQ.bottom);
      i += 1;
    }
    AppMethodBeat.o(9895);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9896);
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).measure(ajd(paramInt1), ajd(paramInt2));
      i += 1;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(9896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.b
 * JD-Core Version:    0.7.0.1
 */