package com.tencent.mm.ui.widget.cedit.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.CharacterIterator;

public final class a
  implements CharacterIterator
{
  private final CharSequence agcH;
  private final int baK;
  private final int baL;
  private int mIndex;
  
  public a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252165);
    this.agcH = paramCharSequence;
    this.mIndex = paramInt1;
    this.baK = paramInt1;
    this.baL = paramInt2;
    AppMethodBeat.o(252165);
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(252237);
    try
    {
      Object localObject = super.clone();
      AppMethodBeat.o(252237);
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      InternalError localInternalError = new InternalError();
      AppMethodBeat.o(252237);
      throw localInternalError;
    }
  }
  
  public final char current()
  {
    AppMethodBeat.i(252191);
    if (this.mIndex == this.baL)
    {
      AppMethodBeat.o(252191);
      return 65535;
    }
    char c = this.agcH.charAt(this.mIndex);
    AppMethodBeat.o(252191);
    return c;
  }
  
  public final char first()
  {
    AppMethodBeat.i(252174);
    this.mIndex = this.baK;
    char c = current();
    AppMethodBeat.o(252174);
    return c;
  }
  
  public final int getBeginIndex()
  {
    return this.baK;
  }
  
  public final int getEndIndex()
  {
    return this.baL;
  }
  
  public final int getIndex()
  {
    return this.mIndex;
  }
  
  public final char last()
  {
    AppMethodBeat.i(252183);
    if (this.baK == this.baL)
    {
      this.mIndex = this.baL;
      AppMethodBeat.o(252183);
      return 65535;
    }
    this.mIndex = (this.baL - 1);
    char c = this.agcH.charAt(this.mIndex);
    AppMethodBeat.o(252183);
    return c;
  }
  
  public final char next()
  {
    AppMethodBeat.i(252205);
    this.mIndex += 1;
    if (this.mIndex >= this.baL)
    {
      this.mIndex = this.baL;
      AppMethodBeat.o(252205);
      return 65535;
    }
    char c = this.agcH.charAt(this.mIndex);
    AppMethodBeat.o(252205);
    return c;
  }
  
  public final char previous()
  {
    AppMethodBeat.i(252211);
    if (this.mIndex <= this.baK)
    {
      AppMethodBeat.o(252211);
      return 65535;
    }
    this.mIndex -= 1;
    char c = this.agcH.charAt(this.mIndex);
    AppMethodBeat.o(252211);
    return c;
  }
  
  public final char setIndex(int paramInt)
  {
    AppMethodBeat.i(252219);
    if ((this.baK <= paramInt) && (paramInt <= this.baL))
    {
      this.mIndex = paramInt;
      c = current();
      AppMethodBeat.o(252219);
      return c;
    }
    char c = current();
    AppMethodBeat.o(252219);
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.c.a
 * JD-Core Version:    0.7.0.1
 */