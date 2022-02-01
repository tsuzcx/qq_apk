package com.tencent.mm.plugin.sns.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class a
{
  private static HashMap<Integer, a> QCW;
  
  static
  {
    AppMethodBeat.i(306335);
    QCW = new HashMap();
    AppMethodBeat.o(306335);
  }
  
  public static void P(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(306329);
    QCW.put(Integer.valueOf(paramInt1), new a(paramInt2, paramString));
    AppMethodBeat.o(306329);
  }
  
  public static a akV(int paramInt)
  {
    AppMethodBeat.i(306331);
    a locala = (a)QCW.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(306331);
    return locala;
  }
  
  public static void akW(int paramInt)
  {
    AppMethodBeat.i(306334);
    QCW.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(306334);
  }
  
  public static final class a
  {
    public String QCX;
    public int eQp;
    
    public a(int paramInt, String paramString)
    {
      this.eQp = paramInt;
      this.QCX = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.l.a
 * JD-Core Version:    0.7.0.1
 */