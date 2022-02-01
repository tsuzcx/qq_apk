package com.tencent.mm.ui.widget.cedit.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.BreakIterator;
import java.util.Locale;

public final class b
{
  private int Pc;
  private CharSequence QLR;
  public final BreakIterator QLS;
  private int avh;
  
  public b()
  {
    this(Locale.getDefault());
    AppMethodBeat.i(206143);
    AppMethodBeat.o(206143);
  }
  
  public b(Locale paramLocale)
  {
    AppMethodBeat.i(206144);
    this.QLS = BreakIterator.getWordInstance(paramLocale);
    AppMethodBeat.o(206144);
  }
  
  private static boolean aoH(int paramInt)
  {
    AppMethodBeat.i(206152);
    paramInt = Character.getType(paramInt);
    if ((paramInt == 23) || (paramInt == 20) || (paramInt == 22) || (paramInt == 30) || (paramInt == 29) || (paramInt == 24) || (paramInt == 21))
    {
      AppMethodBeat.o(206152);
      return true;
    }
    AppMethodBeat.o(206152);
    return false;
  }
  
  private boolean aoI(int paramInt)
  {
    AppMethodBeat.i(206153);
    if ((this.avh < paramInt) && (paramInt <= this.Pc) && (Character.isLetterOrDigit(Character.codePointBefore(this.QLR, paramInt))))
    {
      AppMethodBeat.o(206153);
      return true;
    }
    AppMethodBeat.o(206153);
    return false;
  }
  
  private boolean aoJ(int paramInt)
  {
    AppMethodBeat.i(206154);
    if ((this.avh <= paramInt) && (paramInt < this.Pc) && (Character.isLetterOrDigit(Character.codePointAt(this.QLR, paramInt))))
    {
      AppMethodBeat.o(206154);
      return true;
    }
    AppMethodBeat.o(206154);
    return false;
  }
  
  public final int aoD(int paramInt)
  {
    AppMethodBeat.i(206146);
    aoK(paramInt);
    paramInt = this.QLS.following(paramInt);
    AppMethodBeat.o(206146);
    return paramInt;
  }
  
  public final int aoE(int paramInt)
  {
    AppMethodBeat.i(206147);
    aoK(paramInt);
    paramInt = this.QLS.preceding(paramInt);
    AppMethodBeat.o(206147);
    return paramInt;
  }
  
  public final boolean aoF(int paramInt)
  {
    AppMethodBeat.i(206150);
    if ((this.avh < paramInt) && (paramInt <= this.Pc))
    {
      boolean bool = aoH(Character.codePointBefore(this.QLR, paramInt));
      AppMethodBeat.o(206150);
      return bool;
    }
    AppMethodBeat.o(206150);
    return false;
  }
  
  public final boolean aoG(int paramInt)
  {
    AppMethodBeat.i(206151);
    if ((this.avh <= paramInt) && (paramInt < this.Pc))
    {
      boolean bool = aoH(Character.codePointAt(this.QLR, paramInt));
      AppMethodBeat.o(206151);
      return bool;
    }
    AppMethodBeat.o(206151);
    return false;
  }
  
  public final void aoK(int paramInt)
  {
    AppMethodBeat.i(206155);
    if ((this.avh > paramInt) || (paramInt > this.Pc))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid offset: " + paramInt + ". Valid range is [" + this.avh + ", " + this.Pc + "]");
      AppMethodBeat.o(206155);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(206155);
  }
  
  public final int bR(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(206148);
    aoK(paramInt);
    try
    {
      if (aoJ(paramInt))
      {
        if (this.QLS.isBoundary(paramInt))
        {
          boolean bool = aoI(paramInt);
          if ((!bool) || (!paramBoolean))
          {
            AppMethodBeat.o(206148);
            return paramInt;
          }
        }
        paramInt = this.QLS.preceding(paramInt);
        AppMethodBeat.o(206148);
        return paramInt;
      }
      if (aoI(paramInt))
      {
        paramInt = this.QLS.preceding(paramInt);
        AppMethodBeat.o(206148);
        return paramInt;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(206148);
    }
    return -1;
  }
  
  public final int bS(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(206149);
    aoK(paramInt);
    if (aoI(paramInt))
    {
      if ((this.QLS.isBoundary(paramInt)) && ((!aoJ(paramInt)) || (!paramBoolean)))
      {
        AppMethodBeat.o(206149);
        return paramInt;
      }
      paramInt = this.QLS.following(paramInt);
      AppMethodBeat.o(206149);
      return paramInt;
    }
    if (aoJ(paramInt))
    {
      paramInt = this.QLS.following(paramInt);
      AppMethodBeat.o(206149);
      return paramInt;
    }
    AppMethodBeat.o(206149);
    return -1;
  }
  
  public final void i(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206145);
    if ((paramInt1 >= 0) && (paramInt2 <= paramCharSequence.length()))
    {
      this.QLR = paramCharSequence;
      this.avh = Math.max(0, paramInt1 - 50);
      this.Pc = Math.min(paramCharSequence.length(), paramInt2 + 50);
      this.QLS.setText(new a(paramCharSequence, this.avh, this.Pc));
      AppMethodBeat.o(206145);
      return;
    }
    paramCharSequence = new IndexOutOfBoundsException("input indexes are outside the CharSequence");
    AppMethodBeat.o(206145);
    throw paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.c.b
 * JD-Core Version:    0.7.0.1
 */