package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

final class ae
  extends cv
{
  private final WeakReference<aa> Px;
  
  ae(aa paramaa)
  {
    this.Px = new WeakReference(paramaa);
  }
  
  public final void a(final zzbaw paramzzbaw)
  {
    final aa localaa = (aa)this.Px.get();
    if (localaa == null) {
      return;
    }
    aa.d(localaa).a(new an(localaa)
    {
      public final void iC()
      {
        aa.a(localaa, paramzzbaw);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ae
 * JD-Core Version:    0.7.0.1
 */