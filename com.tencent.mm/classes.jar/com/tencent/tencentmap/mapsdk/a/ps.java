package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.MeasureSpec;

public final class ps
{
  public static pr a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    paramBitmap = lq.a(paramBitmap);
    oq localoq = new oq(7);
    localoq.a(paramBitmap);
    return new pr(localoq);
  }
  
  public static pr a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    try
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
      paramView.buildDrawingCache();
      Bitmap localBitmap = paramView.getDrawingCache();
      pr localpr = a(localBitmap);
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      paramView.destroyDrawingCache();
      return localpr;
    }
    catch (Exception paramView) {}
    return null;
  }
  
  public static pr a(String paramString)
  {
    oq localoq = new oq(2);
    localoq.a(paramString);
    return new pr(localoq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ps
 * JD-Core Version:    0.7.0.1
 */