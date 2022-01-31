package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cn
{
  public cz a;
  public final float b;
  public final float c;
  public final float d;
  
  cn(int paramInt, cz paramcz, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.a = paramcz;
    this.b = paramFloat1;
    this.c = paramFloat2;
    this.d = paramFloat3;
  }
  
  public cn(cz paramcz, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(1, paramcz, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static a a()
  {
    AppMethodBeat.i(149996);
    a locala = new a();
    AppMethodBeat.o(149996);
    return locala;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(149997);
    if (this == paramObject)
    {
      AppMethodBeat.o(149997);
      return true;
    }
    if (!(paramObject instanceof cn))
    {
      AppMethodBeat.o(149997);
      return false;
    }
    paramObject = (cn)paramObject;
    if ((this.a.equals(paramObject.a)) && (Float.floatToIntBits(this.b) == Float.floatToIntBits(paramObject.b)) && (Float.floatToIntBits(this.c) == Float.floatToIntBits(paramObject.c)) && (Float.floatToIntBits(this.d) == Float.floatToIntBits(paramObject.d)))
    {
      AppMethodBeat.o(149997);
      return true;
    }
    AppMethodBeat.o(149997);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149998);
    String str = "latlng:" + this.a.a + "," + this.a.b + ",zoom:" + this.b + ",tilt=" + this.c + ",bearing:" + this.d;
    AppMethodBeat.o(149998);
    return str;
  }
  
  public static final class a
  {
    private cz a;
    private float b;
    private float c = 1.4E-45F;
    private float d = 1.4E-45F;
    
    public final a a(float paramFloat)
    {
      this.b = paramFloat;
      return this;
    }
    
    public final a a(cz paramcz)
    {
      this.a = paramcz;
      return this;
    }
    
    public final cn a()
    {
      AppMethodBeat.i(149995);
      cn localcn = new cn(this.a, this.b, this.c, this.d);
      AppMethodBeat.o(149995);
      return localcn;
    }
    
    public final a b(float paramFloat)
    {
      this.c = paramFloat;
      return this;
    }
    
    public final a c(float paramFloat)
    {
      this.d = paramFloat;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cn
 * JD-Core Version:    0.7.0.1
 */