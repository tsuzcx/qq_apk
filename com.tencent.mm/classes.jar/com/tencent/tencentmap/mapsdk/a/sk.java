package com.tencent.tencentmap.mapsdk.a;

import java.net.URL;

public abstract class sk
  implements sj
{
  public final sh a(int paramInt1, int paramInt2, int paramInt3, ue.a parama, Object... paramVarArgs)
  {
    parama = a(paramInt1, paramInt2, paramInt3, paramVarArgs);
    if (parama == null) {
      return null;
    }
    return new sh(paramInt1, paramInt2, paramInt3, up.a(parama));
  }
  
  public abstract URL a(int paramInt1, int paramInt2, int paramInt3, Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.sk
 * JD-Core Version:    0.7.0.1
 */