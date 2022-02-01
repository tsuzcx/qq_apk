package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.d;

public final class a<O extends b>
{
  private final f<?, O> Jc;
  private final m<?, O> Jd;
  private final k<?> Je;
  private final n<?> Jf;
  private final String mName;
  
  public <C extends j> a(String paramString, f<C, O> paramf, k<C> paramk)
  {
    d.g(paramf, "Cannot construct an Api with a null ClientBuilder");
    d.g(paramk, "Cannot construct an Api with a null ClientKey");
    this.mName = paramString;
    this.Jc = paramf;
    this.Jd = null;
    this.Je = paramk;
    this.Jf = null;
  }
  
  public final f<?, O> gA()
  {
    if (this.Jc != null) {}
    for (boolean bool = true;; bool = false)
    {
      d.a(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
      return this.Jc;
    }
  }
  
  public final h<?> gB()
  {
    if (this.Je != null) {
      return this.Je;
    }
    throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
  }
  
  public final String getName()
  {
    return this.mName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.a
 * JD-Core Version:    0.7.0.1
 */