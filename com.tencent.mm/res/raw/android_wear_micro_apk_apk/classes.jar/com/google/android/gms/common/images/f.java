package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.b;
import java.util.Arrays;

final class f
{
  public final Uri uri;
  
  public f(Uri paramUri)
  {
    this.uri = paramUri;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof f)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    return b.b(((f)paramObject).uri, this.uri);
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.uri });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.images.f
 * JD-Core Version:    0.7.0.1
 */