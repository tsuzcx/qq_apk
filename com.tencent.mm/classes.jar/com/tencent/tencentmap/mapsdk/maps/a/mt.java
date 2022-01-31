package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class mt<T extends ms>
{
  private final mr<T> a;
  private final mr<T> b;
  private Float c;
  private final Float d;
  
  public mt(List<T> paramList1, List<T> paramList2)
  {
    AppMethodBeat.i(149332);
    this.c = null;
    this.a = new mr(paramList1);
    this.b = new mr(paramList2);
    this.d = Float.valueOf(this.a.b().a().h() + this.b.b().a().h());
    AppMethodBeat.o(149332);
  }
  
  public final mr<T> a()
  {
    return this.a;
  }
  
  public final mr<T> b()
  {
    return this.b;
  }
  
  public final float c()
  {
    AppMethodBeat.i(149333);
    if (this.c == null) {
      this.c = Float.valueOf(this.a.b().a().g() + this.b.b().a().g());
    }
    float f = this.c.floatValue();
    AppMethodBeat.o(149333);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mt
 * JD-Core Version:    0.7.0.1
 */