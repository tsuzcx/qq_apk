package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class na
  implements nb
{
  private Context a;
  private TextView b;
  private lh.a c;
  
  public na(Context paramContext)
  {
    AppMethodBeat.i(149363);
    this.a = paramContext;
    this.b = new TextView(this.a);
    AppMethodBeat.o(149363);
  }
  
  private Bitmap b()
  {
    AppMethodBeat.i(149365);
    this.b.setTextSize(18.0F);
    this.b.setTextColor(-16777216);
    this.b.setText("鉴权失败,请检查你的key");
    Bitmap localBitmap = jr.a(this.b);
    AppMethodBeat.o(149365);
    return localBitmap;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(lh.a parama)
  {
    this.c = parama;
  }
  
  public boolean a(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(149364);
    if ((paramViewGroup == null) || (this.b == null))
    {
      AppMethodBeat.o(149364);
      return false;
    }
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int i = paramViewGroup.getMeasuredWidth();
    int j = paramViewGroup.getMeasuredHeight();
    localObject = b();
    paramViewGroup.addView(this.b);
    if (this.c != null) {
      this.c.a((Bitmap)localObject, i, j);
    }
    AppMethodBeat.o(149364);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.na
 * JD-Core Version:    0.7.0.1
 */