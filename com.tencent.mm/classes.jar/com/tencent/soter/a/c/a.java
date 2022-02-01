package com.tencent.soter.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.f;
import java.util.HashMap;

public final class a
{
  private static HashMap<Class, a> MnX;
  
  static
  {
    AppMethodBeat.i(15);
    MnX = new HashMap();
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
    a locala = (a)MnX.get(paramClass);
    if (locala == null)
    {
      locala = new a((byte)0);
      locala.a(paramf);
      MnX.put(paramClass, locala);
      paramClass = locala;
    }
    for (;;)
    {
      d.d("Soter.RemoveASKStrategy", "error counter: %s", new Object[] { Integer.valueOf(paramClass.cpF) });
      AppMethodBeat.o(14);
      return false;
      if ((paramf.errCode == locala.errCode) && (paramf.errMsg.equals(locala.errMsg)))
      {
        locala.cpF += 1;
        paramClass = locala;
        if (locala.cpF >= 2)
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
    int cpF;
    int errCode;
    String errMsg;
    
    public final void a(f paramf)
    {
      this.errCode = paramf.errCode;
      this.errMsg = paramf.errMsg;
      this.cpF = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.a.c.a
 * JD-Core Version:    0.7.0.1
 */