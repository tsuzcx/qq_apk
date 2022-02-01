package com.tencent.mm.ui.widget.cedit.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.CharacterIterator;

public final class a
  implements CharacterIterator
{
  private final int QLQ;
  private final CharSequence QLR;
  private int mIndex;
  private final int rnu;
  
  public a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206135);
    this.QLR = paramCharSequence;
    this.mIndex = paramInt1;
    this.QLQ = paramInt1;
    this.rnu = paramInt2;
    AppMethodBeat.o(206135);
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(206142);
    try
    {
      Object localObject = super.clone();
      AppMethodBeat.o(206142);
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      InternalError localInternalError = new InternalError();
      AppMethodBeat.o(206142);
      throw localInternalError;
    }
  }
  
  public final char current()
  {
    AppMethodBeat.i(206138);
    if (this.mIndex == this.rnu)
    {
      AppMethodBeat.o(206138);
      return 65535;
    }
    char c = this.QLR.charAt(this.mIndex);
    AppMethodBeat.o(206138);
    return c;
  }
  
  public final char first()
  {
    AppMethodBeat.i(206136);
    this.mIndex = this.QLQ;
    char c = current();
    AppMethodBeat.o(206136);
    return c;
  }
  
  public final int getBeginIndex()
  {
    return this.QLQ;
  }
  
  public final int getEndIndex()
  {
    return this.rnu;
  }
  
  public final int getIndex()
  {
    return this.mIndex;
  }
  
  public final char last()
  {
    AppMethodBeat.i(206137);
    if (this.QLQ == this.rnu)
    {
      this.mIndex = this.rnu;
      AppMethodBeat.o(206137);
      return 65535;
    }
    this.mIndex = (this.rnu - 1);
    char c = this.QLR.charAt(this.mIndex);
    AppMethodBeat.o(206137);
    return c;
  }
  
  public final char next()
  {
    AppMethodBeat.i(206139);
    this.mIndex += 1;
    if (this.mIndex >= this.rnu)
    {
      this.mIndex = this.rnu;
      AppMethodBeat.o(206139);
      return 65535;
    }
    char c = this.QLR.charAt(this.mIndex);
    AppMethodBeat.o(206139);
    return c;
  }
  
  public final char previous()
  {
    AppMethodBeat.i(206140);
    if (this.mIndex <= this.QLQ)
    {
      AppMethodBeat.o(206140);
      return 65535;
    }
    this.mIndex -= 1;
    char c = this.QLR.charAt(this.mIndex);
    AppMethodBeat.o(206140);
    return c;
  }
  
  public final char setIndex(int paramInt)
  {
    AppMethodBeat.i(206141);
    if ((this.QLQ <= paramInt) && (paramInt <= this.rnu))
    {
      this.mIndex = paramInt;
      c = current();
      AppMethodBeat.o(206141);
      return c;
    }
    char c = current();
    AppMethodBeat.o(206141);
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.c.a
 * JD-Core Version:    0.7.0.1
 */