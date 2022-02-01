package com.tencent.soter.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.f;
import java.util.HashMap;

public final class a
{
  private static HashMap<Class, a> ahxN;
  
  static
  {
    AppMethodBeat.i(15);
    ahxN = new HashMap();
    AppMethodBeat.o(15);
  }
  
  public static boolean a(Class paramClass, f paramf)
  {
    AppMethodBeat.i(14);
    if (paramf.isSuccess())
    {
      AppMethodBeat.o(14);
      return false;
    }
    a locala = (a)ahxN.get(paramClass);
    if (locala == null)
    {
      locala = new a((byte)0);
      locala.a(paramf);
      ahxN.put(paramClass, locala);
      paramClass = locala;
    }
    for (;;)
    {
      d.d("Soter.RemoveASKStrategy", "error counter: %s", new Object[] { Integer.valueOf(paramClass.evg) });
      AppMethodBeat.o(14);
      return false;
      if ((paramf.errCode == locala.errCode) && (paramf.errMsg.equals(locala.errMsg)))
      {
        locala.evg += 1;
        paramClass = locala;
        if (locala.evg >= 2)
        {
          AppMethodBeat.o(14);
          return true;
        }
      }
      else
      {
        locala.a(paramf);
        paramClass = locala;
      }
    }
  }
  
  static final class a
  {
    int errCode;
    String errMsg;
    int evg;
    
    public final void a(f paramf)
    {
      this.errCode = paramf.errCode;
      this.errMsg = paramf.errMsg;
      this.evg = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.soter.a.c.a
 * JD-Core Version:    0.7.0.1
 */