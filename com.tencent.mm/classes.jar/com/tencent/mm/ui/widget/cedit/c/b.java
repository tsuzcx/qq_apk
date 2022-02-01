package com.tencent.mm.ui.widget.cedit.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.BreakIterator;
import java.util.Locale;

public class b
{
  private CharSequence YkJ;
  public final BreakIterator YkK;
  private int tH;
  private int tI;
  
  public b()
  {
    this(Locale.getDefault());
    AppMethodBeat.i(190550);
    AppMethodBeat.o(190550);
  }
  
  public b(Locale paramLocale)
  {
    AppMethodBeat.i(190552);
    this.YkK = BreakIterator.getWordInstance(paramLocale);
    AppMethodBeat.o(190552);
  }
  
  private static boolean axS(int paramInt)
  {
    AppMethodBeat.i(190582);
    paramInt = Character.getType(paramInt);
    if ((paramInt == 23) || (paramInt == 20) || (paramInt == 22) || (paramInt == 30) || (paramInt == 29) || (paramInt == 24) || (paramInt == 21))
    {
      AppMethodBeat.o(190582);
      return true;
    }
    AppMethodBeat.o(190582);
    return false;
  }
  
  private boolean axT(int paramInt)
  {
    AppMethodBeat.i(190586);
    if ((this.tH < paramInt) && (paramInt <= this.tI) && (Character.isLetterOrDigit(Character.codePointBefore(this.YkJ, paramInt))))
    {
      AppMethodBeat.o(190586);
      return true;
    }
    AppMethodBeat.o(190586);
    return false;
  }
  
  private boolean axU(int paramInt)
  {
    AppMethodBeat.i(190588);
    if ((this.tH <= paramInt) && (paramInt < this.tI) && (Character.isLetterOrDigit(Character.codePointAt(this.YkJ, paramInt))))
    {
      AppMethodBeat.o(190588);
      return true;
    }
    AppMethodBeat.o(190588);
    return false;
  }
  
  public final int axO(int paramInt)
  {
    AppMethodBeat.i(190559);
    axV(paramInt);
    paramInt = this.YkK.following(paramInt);
    AppMethodBeat.o(190559);
    return paramInt;
  }
  
  public final int axP(int paramInt)
  {
    AppMethodBeat.i(190561);
    axV(paramInt);
    paramInt = this.YkK.preceding(paramInt);
    AppMethodBeat.o(190561);
    return paramInt;
  }
  
  public final boolean axQ(int paramInt)
  {
    AppMethodBeat.i(190577);
    if ((this.tH < paramInt) && (paramInt <= this.tI))
    {
      boolean bool = axS(Character.codePointBefore(this.YkJ, paramInt));
      AppMethodBeat.o(190577);
      return bool;
    }
    AppMethodBeat.o(190577);
    return false;
  }
  
  public final boolean axR(int paramInt)
  {
    AppMethodBeat.i(190581);
    if ((this.tH <= paramInt) && (paramInt < this.tI))
    {
      boolean bool = axS(Character.codePointAt(this.YkJ, paramInt));
      AppMethodBeat.o(190581);
      return bool;
    }
    AppMethodBeat.o(190581);
    return false;
  }
  
  public final void axV(int paramInt)
  {
    AppMethodBeat.i(190591);
    if ((this.tH > paramInt) || (paramInt > this.tI))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Invalid offset: " + paramInt + ". Valid range is [" + this.tH + ", " + this.tI + "]");
      AppMethodBeat.o(190591);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(190591);
  }
  
  public final int ce(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(190568);
    axV(paramInt);
    try
    {
      if (axU(paramInt))
      {
        if (this.YkK.isBoundary(paramInt))
        {
          boolean bool = axT(paramInt);
          if ((!bool) || (!paramBoolean))
          {
            AppMethodBeat.o(190568);
            return paramInt;
          }
        }
        paramInt = this.YkK.preceding(paramInt);
        AppMethodBeat.o(190568);
        return paramInt;
      }
      if (axT(paramInt))
      {
        paramInt = this.YkK.preceding(paramInt);
        AppMethodBeat.o(190568);
        return paramInt;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(190568);
    }
    return -1;
  }
  
  public final int cf(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(190575);
    axV(paramInt);
    if (axT(paramInt))
    {
      if ((this.YkK.isBoundary(paramInt)) && ((!axU(paramInt)) || (!paramBoolean)))
      {
        AppMethodBeat.o(190575);
        return paramInt;
      }
      paramInt = this.YkK.following(paramInt);
      AppMethodBeat.o(190575);
      return paramInt;
    }
    if (axU(paramInt))
    {
      paramInt = this.YkK.following(paramInt);
      AppMethodBeat.o(190575);
      return paramInt;
    }
    AppMethodBeat.o(190575);
    return -1;
  }
  
  public final void i(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190557);
    if ((paramInt1 >= 0) && (paramInt2 <= paramCharSequence.length()))
    {
      this.YkJ = paramCharSequence;
      this.tH = Math.max(0, paramInt1 - 50);
      this.tI = Math.min(paramCharSequence.length(), paramInt2 + 50);
      this.YkK.setText(new a(paramCharSequence, this.tH, this.tI));
      AppMethodBeat.o(190557);
      return;
    }
    paramCharSequence = new IndexOutOfBoundsException("input indexes are outside the CharSequence");
    AppMethodBeat.o(190557);
    throw paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.c.b
 * JD-Core Version:    0.7.0.1
 */