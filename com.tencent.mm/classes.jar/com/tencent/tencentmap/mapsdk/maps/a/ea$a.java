package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

class ea$a
  implements ec
{
  private final fe<?> a;
  private final boolean b;
  private final Class<?> c;
  private final dx<?> d;
  private final dp<?> e;
  
  private ea$a(Object paramObject, fe<?> paramfe, boolean paramBoolean, Class<?> paramClass)
  {
    AppMethodBeat.i(147521);
    dx localdx;
    if ((paramObject instanceof dx))
    {
      localdx = (dx)paramObject;
      this.d = localdx;
      if (!(paramObject instanceof dp)) {
        break label95;
      }
      paramObject = (dp)paramObject;
      label40:
      this.e = paramObject;
      if ((this.d == null) && (this.e == null)) {
        break label100;
      }
    }
    label95:
    label100:
    for (boolean bool = true;; bool = false)
    {
      eh.a(bool);
      this.a = paramfe;
      this.b = paramBoolean;
      this.c = paramClass;
      AppMethodBeat.o(147521);
      return;
      localdx = null;
      break;
      paramObject = null;
      break label40;
    }
  }
  
  public <T> eb<T> a(dk paramdk, fe<T> paramfe)
  {
    AppMethodBeat.i(147522);
    boolean bool;
    if (this.a != null) {
      if ((this.a.equals(paramfe)) || ((this.b) && (this.a.b() == paramfe.a()))) {
        bool = true;
      }
    }
    while (bool)
    {
      paramdk = new ea(this.d, this.e, paramdk, paramfe, this, null);
      AppMethodBeat.o(147522);
      return paramdk;
      bool = false;
      continue;
      bool = this.c.isAssignableFrom(paramfe.a());
    }
    AppMethodBeat.o(147522);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ea.a
 * JD-Core Version:    0.7.0.1
 */