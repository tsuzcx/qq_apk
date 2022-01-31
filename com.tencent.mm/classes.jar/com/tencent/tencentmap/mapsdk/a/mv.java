package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.ImageView;

public class mv
  extends ImageView
{
  public mv(Context paramContext)
  {
    super(paramContext);
    setClickable(true);
  }
  
  public void a()
  {
    setClickable(false);
    Drawable localDrawable = getBackground();
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    setBackgroundDrawable(null);
  }
  
  public void a(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    paramBitmap1 = new BitmapDrawable(paramContext.getResources(), paramBitmap1);
    paramContext = new BitmapDrawable(paramContext.getResources(), paramBitmap2);
    localStateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, paramContext);
    localStateListDrawable.addState(View.ENABLED_STATE_SET, paramBitmap1);
    setBackgroundDrawable(localStateListDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.mv
 * JD-Core Version:    0.7.0.1
 */