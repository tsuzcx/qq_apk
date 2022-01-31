package com.google.android.gms.common.data;

import java.util.Iterator;

public abstract class a<T>
  implements b<T>
{
  protected final DataHolder Ia;
  
  protected a(DataHolder paramDataHolder)
  {
    this.Ia = paramDataHolder;
  }
  
  @Deprecated
  public final void close()
  {
    release();
  }
  
  public int getCount()
  {
    if (this.Ia == null) {
      return 0;
    }
    return this.Ia.Ik;
  }
  
  public Iterator<T> iterator()
  {
    return new f(this);
  }
  
  public final void release()
  {
    if (this.Ia != null) {
      this.Ia.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.data.a
 * JD-Core Version:    0.7.0.1
 */