package android.support.v4.a.a;

import android.graphics.drawable.Drawable;

class c
  extends b
{
  public final boolean a(Drawable paramDrawable)
  {
    return paramDrawable.isAutoMirrored();
  }
  
  public Drawable b(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (!(paramDrawable instanceof n)) {
      localObject = new j(paramDrawable);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.a.a.c
 * JD-Core Version:    0.7.0.1
 */