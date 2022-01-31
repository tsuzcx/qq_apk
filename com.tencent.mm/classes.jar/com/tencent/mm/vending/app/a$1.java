package com.tencent.mm.vending.app;

import java.util.Map;

final class a$1
  extends com.tencent.mm.vending.base.a<Object>
{
  a$1(a parama) {}
  
  protected final Object af(Class<?> paramClass)
  {
    a.a locala = (a.a)this.wsR.c.get(paramClass);
    Object localObject;
    if (locala != null)
    {
      locala.c = true;
      localObject = locala.Vw();
      locala.c = false;
      if (locala.b) {
        locala.wsS = defer(paramClass);
      }
    }
    else
    {
      return null;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.vending.app.a.1
 * JD-Core Version:    0.7.0.1
 */