package io.flutter.a.c;

import android.content.Context;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$b
  extends ViewGroup
{
  private final Rect Jct;
  private final Rect bOx;
  
  public h$b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(9894);
    this.bOx = new Rect();
    this.Jct = new Rect();
    AppMethodBeat.o(9894);
  }
  
  private static int adH(int paramInt)
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
      this.bOx.set(paramInt1, paramInt2, paramInt3, paramInt4);
      Gravity.apply(localLayoutParams.gravity, localView.getMeasuredWidth(), localView.getMeasuredHeight(), this.bOx, localLayoutParams.x, localLayoutParams.y, this.Jct);
      localView.layout(this.Jct.left, this.Jct.top, this.Jct.right, this.Jct.bottom);
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
      getChildAt(i).measure(adH(paramInt1), adH(paramInt2));
      i += 1;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(9896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.flutter.a.c.h.b
 * JD-Core Version:    0.7.0.1
 */