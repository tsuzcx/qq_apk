package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.h;
import java.lang.ref.WeakReference;
import java.util.Map;

final class au<T>
  extends bn<Status>
{
  private WeakReference<Map<T, bz<T>>> Vp;
  private WeakReference<T> Vq;
  
  au(Map<T, bz<T>> paramMap, T paramT, h<Status> paramh)
  {
    super(paramh);
    this.Vp = new WeakReference(paramMap);
    this.Vq = new WeakReference(paramT);
  }
  
  public final void j(Status paramStatus)
  {
    Map localMap = (Map)this.Vp.get();
    Object localObject = this.Vq.get();
    if ((paramStatus.gM().getStatusCode() == 4002) && (localMap != null) && (localObject != null)) {}
    try
    {
      localObject = (bz)localMap.remove(localObject);
      if (localObject != null) {
        ((bz)localObject).clear();
      }
      K(paramStatus);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.au
 * JD-Core Version:    0.7.0.1
 */