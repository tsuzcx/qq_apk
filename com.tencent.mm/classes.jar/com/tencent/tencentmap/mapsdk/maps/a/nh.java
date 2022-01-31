package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class nh
  extends ImageView
{
  public nh(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(149467);
    setClickable(true);
    AppMethodBeat.o(149467);
  }
  
  public void a()
  {
    AppMethodBeat.i(149469);
    setClickable(false);
    Drawable localDrawable = getBackground();
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    setBackgroundDrawable(null);
    AppMethodBeat.o(149469);
  }
  
  public void a(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    AppMethodBeat.i(149468);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    paramBitmap1 = new BitmapDrawable(paramContext.getResources(), paramBitmap1);
    paramContext = new BitmapDrawable(paramContext.getResources(), paramBitmap2);
    localStateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, paramContext);
    localStateListDrawable.addState(View.ENABLED_STATE_SET, paramBitmap1);
    setBackgroundDrawable(localStateListDrawable);
    AppMethodBeat.o(149468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nh
 * JD-Core Version:    0.7.0.1
 */