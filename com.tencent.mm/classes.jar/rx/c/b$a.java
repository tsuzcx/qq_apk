package rx.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$a
{
  Object[] Niz;
  int size;
  
  public final void add(Object paramObject)
  {
    AppMethodBeat.i(90427);
    int i = this.size;
    Object localObject = this.Niz;
    if (localObject == null)
    {
      localObject = new Object[16];
      this.Niz = ((Object[])localObject);
    }
    for (;;)
    {
      localObject[i] = paramObject;
      this.size = (i + 1);
      AppMethodBeat.o(90427);
      return;
      if (i == localObject.length)
      {
        Object[] arrayOfObject = new Object[(i >> 2) + i];
        System.arraycopy(localObject, 0, arrayOfObject, 0, i);
        this.Niz = arrayOfObject;
        localObject = arrayOfObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.c.b.a
 * JD-Core Version:    0.7.0.1
 */