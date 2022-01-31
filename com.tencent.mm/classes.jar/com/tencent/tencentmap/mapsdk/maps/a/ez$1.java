package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

class ez$1
  extends ez.b
{
  final eb<?> a;
  
  ez$1(ez paramez, String paramString, boolean paramBoolean1, boolean paramBoolean2, dk paramdk, fe paramfe, Field paramField, boolean paramBoolean3)
  {
    super(paramString, paramBoolean1, paramBoolean2);
    AppMethodBeat.i(147716);
    this.a = this.b.a(this.c);
    AppMethodBeat.o(147716);
  }
  
  void a(ff paramff, Object paramObject)
  {
    AppMethodBeat.i(147718);
    paramff = this.a.b(paramff);
    if ((paramff != null) || (!this.e)) {
      this.d.set(paramObject, paramff);
    }
    AppMethodBeat.o(147718);
  }
  
  void a(fh paramfh, Object paramObject)
  {
    AppMethodBeat.i(147717);
    paramObject = this.d.get(paramObject);
    new fc(this.b, this.a, this.c.b()).a(paramfh, paramObject);
    AppMethodBeat.o(147717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ez.1
 * JD-Core Version:    0.7.0.1
 */