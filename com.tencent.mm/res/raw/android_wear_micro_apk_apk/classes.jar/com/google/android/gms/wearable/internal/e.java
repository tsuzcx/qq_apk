package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.api.t;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.h;
import com.google.android.gms.wearable.i;

public final class e
  implements com.google.android.gms.wearable.e
{
  public final t<i> a(p paramp, final Asset paramAsset)
  {
    if (paramAsset == null) {
      throw new IllegalArgumentException("asset is null");
    }
    if (paramAsset.ky() == null) {
      throw new IllegalArgumentException("invalid asset");
    }
    if (paramAsset.getData() != null) {
      throw new IllegalArgumentException("invalid asset");
    }
    paramp.a(new ci(paramp) {});
  }
  
  public final t<f> a(p paramp, final PutDataRequest paramPutDataRequest)
  {
    paramp.a(new ci(paramp) {});
  }
  
  public final t<h> b(p paramp, final Uri paramUri)
  {
    if (paramUri != null) {}
    for (boolean bool = true;; bool = false)
    {
      d.b(bool, "uri must not be null");
      d.b(true, "invalid filter type");
      paramp.a(new ci(paramp) {});
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.e
 * JD-Core Version:    0.7.0.1
 */