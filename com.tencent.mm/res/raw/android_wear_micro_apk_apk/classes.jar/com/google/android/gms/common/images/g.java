package com.google.android.gms.common.images;

import com.google.android.gms.common.internal.b;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public final class g
  extends e
{
  private WeakReference<a> IS;
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof g)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (g)paramObject;
    a locala1 = (a)this.IS.get();
    a locala2 = (a)paramObject.IS.get();
    return (locala2 != null) && (locala1 != null) && (b.b(locala2, locala1)) && (b.b(paramObject.IQ, this.IQ));
  }
  
  protected final void gT()
  {
    this.IS.get();
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.IQ });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.images.g
 * JD-Core Version:    0.7.0.1
 */