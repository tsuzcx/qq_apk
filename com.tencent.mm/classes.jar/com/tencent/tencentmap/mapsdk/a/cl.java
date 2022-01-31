package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ka;

public final class cl
{
  public static ck a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(149993);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(149993);
      return null;
    }
    paramBitmap = ka.a(paramBitmap);
    bj localbj = new bj(7);
    localbj.a(paramBitmap);
    paramBitmap = new ck(localbj);
    AppMethodBeat.o(149993);
    return paramBitmap;
  }
  
  public static ck a(View paramView)
  {
    AppMethodBeat.i(149994);
    if (paramView == null)
    {
      AppMethodBeat.o(149994);
      return null;
    }
    try
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
      paramView.buildDrawingCache();
      Bitmap localBitmap = paramView.getDrawingCache();
      ck localck = a(localBitmap);
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      paramView.destroyDrawingCache();
      AppMethodBeat.o(149994);
      return localck;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(149994);
    }
    return null;
  }
  
  public static ck a(String paramString)
  {
    AppMethodBeat.i(149992);
    bj localbj = new bj(2);
    localbj.a(paramString);
    paramString = new ck(localbj);
    AppMethodBeat.o(149992);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cl
 * JD-Core Version:    0.7.0.1
 */