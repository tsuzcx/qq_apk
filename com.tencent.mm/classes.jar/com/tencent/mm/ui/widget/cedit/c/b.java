package com.tencent.mm.ui.widget.cedit.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.BreakIterator;
import java.util.Locale;

public class b
{
  private CharSequence agcH;
  public final BreakIterator agcI;
  private int uG;
  private int uH;
  
  public b()
  {
    this(Locale.getDefault());
    AppMethodBeat.i(252166);
    AppMethodBeat.o(252166);
  }
  
  public b(Locale paramLocale)
  {
    AppMethodBeat.i(252175);
    this.agcI = BreakIterator.getWordInstance(paramLocale);
    AppMethodBeat.o(252175);
  }
  
  private static boolean aEB(int paramInt)
  {
    AppMethodBeat.i(252185);
    paramInt = Character.getType(paramInt);
    if ((paramInt == 23) || (paramInt == 20) || (paramInt == 22) || (paramInt == 30) || (paramInt == 29) || (paramInt == 24) || (paramInt == 21))
    {
      AppMethodBeat.o(252185);
      return true;
    }
    AppMethodBeat.o(252185);
    return false;
  }
  
  private boolean aEC(int paramInt)
  {
    AppMethodBeat.i(252195);
    if ((this.uG < paramInt) && (paramInt <= this.uH) && (Character.isLetterOrDigit(Character.codePointBefore(this.agcH, paramInt))))
    {
      AppMethodBeat.o(252195);
      return true;
    }
    AppMethodBeat.o(252195);
    return false;
  }
  
  private boolean aED(int paramInt)
  {
    AppMethodBeat.i(252201);
    if ((this.uG <= paramInt) && (paramInt < this.uH) && (Character.isLetterOrDigit(Character.codePointAt(this.agcH, paramInt))))
    {
      AppMethodBeat.o(252201);
      return true;
    }
    AppMethodBeat.o(252201);
    return false;
  }
  
  public final boolean aEA(int paramInt)
  {
    AppMethodBeat.i(252248);
    if ((this.uG <= paramInt) && (paramInt < this.uH))
    {
      boolean bool = aEB(Character.codePointAt(this.agcH, paramInt));
      AppMethodBeat.o(252248);
      return bool;
    }
    AppMethodBeat.o(252248);
    return false;
  }
  
  public final void aEE(int paramInt)
  {
    AppMethodBeat.i(252253);
    if ((this.uG > paramInt) || (paramInt > this.uH))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid offset: " + paramInt + ". Valid range is [" + this.uG + ", " + this.uH + "]");
      AppMethodBeat.o(252253);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(252253);
  }
  
  public final int aEx(int paramInt)
  {
    AppMethodBeat.i(252218);
    aEE(paramInt);
    paramInt = this.agcI.following(paramInt);
    AppMethodBeat.o(252218);
    return paramInt;
  }
  
  public final int aEy(int paramInt)
  {
    AppMethodBeat.i(252223);
    aEE(paramInt);
    paramInt = this.agcI.preceding(paramInt);
    AppMethodBeat.o(252223);
    return paramInt;
  }
  
  public final boolean aEz(int paramInt)
  {
    AppMethodBeat.i(252241);
    if ((this.uG < paramInt) && (paramInt <= this.uH))
    {
      boolean bool = aEB(Character.codePointBefore(this.agcH, paramInt));
      AppMethodBeat.o(252241);
      return bool;
    }
    AppMethodBeat.o(252241);
    return false;
  }
  
  public final int cV(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(252228);
    aEE(paramInt);
    try
    {
      if (aED(paramInt))
      {
        if (this.agcI.isBoundary(paramInt))
        {
          boolean bool = aEC(paramInt);
          if ((!bool) || (!paramBoolean)) {
            return paramInt;
          }
        }
        paramInt = this.agcI.preceding(paramInt);
        return paramInt;
      }
      if (aEC(paramInt))
      {
        paramInt = this.agcI.preceding(paramInt);
        return paramInt;
      }
    }
    finally
    {
      AppMethodBeat.o(252228);
    }
    return -1;
  }
  
  public final int cW(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(252233);
    aEE(paramInt);
    if (aEC(paramInt))
    {
      if ((this.agcI.isBoundary(paramInt)) && ((!aED(paramInt)) || (!paramBoolean)))
      {
        AppMethodBeat.o(252233);
        return paramInt;
      }
      paramInt = this.agcI.following(paramInt);
      AppMethodBeat.o(252233);
      return paramInt;
    }
    if (aED(paramInt))
    {
      paramInt = this.agcI.following(paramInt);
      AppMethodBeat.o(252233);
      return paramInt;
    }
    AppMethodBeat.o(252233);
    return -1;
  }
  
  public final void g(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252212);
    if ((paramInt1 >= 0) && (paramInt2 <= paramCharSequence.length()))
    {
      this.agcH = paramCharSequence;
      this.uG = Math.max(0, paramInt1 - 50);
      this.uH = Math.min(paramCharSequence.length(), paramInt2 + 50);
      this.agcI.setText(new a(paramCharSequence, this.uG, this.uH));
      AppMethodBeat.o(252212);
      return;
    }
    paramCharSequence = new IndexOutOfBoundsException("input indexes are outside the CharSequence");
    AppMethodBeat.o(252212);
    throw paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.c.b
 * JD-Core Version:    0.7.0.1
 */