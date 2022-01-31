package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.d;

public final class a<O extends b>
{
  private final f<?, O> Hn;
  private final m<?, O> Ho;
  private final k<?> Hp;
  private final n<?> Hq;
  private final String mName;
  
  public <C extends j> a(String paramString, f<C, O> paramf, k<C> paramk)
  {
    d.e(paramf, "Cannot construct an Api with a null ClientBuilder");
    d.e(paramk, "Cannot construct an Api with a null ClientKey");
    this.mName = paramString;
    this.Hn = paramf;
    this.Ho = null;
    this.Hp = paramk;
    this.Hq = null;
  }
  
  public final String getName()
  {
    return this.mName;
  }
  
  public final f<?, O> gq()
  {
    if (this.Hn != null) {}
    for (boolean bool = true;; bool = false)
    {
      d.a(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
      return this.Hn;
    }
  }
  
  public final h<?> gr()
  {
    if (this.Hp != null) {
      return this.Hp;
    }
    throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.a
 * JD-Core Version:    0.7.0.1
 */