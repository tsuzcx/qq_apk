package com.tencent.mm.ui.widget.cedit.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.CharacterIterator;

public final class a
  implements CharacterIterator
{
  private final int YkI;
  private final CharSequence YkJ;
  private int mIndex;
  private final int uQJ;
  
  public a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223003);
    this.YkJ = paramCharSequence;
    this.mIndex = paramInt1;
    this.YkI = paramInt1;
    this.uQJ = paramInt2;
    AppMethodBeat.o(223003);
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(223027);
    try
    {
      Object localObject = super.clone();
      AppMethodBeat.o(223027);
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      InternalError localInternalError = new InternalError();
      AppMethodBeat.o(223027);
      throw localInternalError;
    }
  }
  
  public final char current()
  {
    AppMethodBeat.i(223010);
    if (this.mIndex == this.uQJ)
    {
      AppMethodBeat.o(223010);
      return 65535;
    }
    char c = this.YkJ.charAt(this.mIndex);
    AppMethodBeat.o(223010);
    return c;
  }
  
  public final char first()
  {
    AppMethodBeat.i(223005);
    this.mIndex = this.YkI;
    char c = current();
    AppMethodBeat.o(223005);
    return c;
  }
  
  public final int getBeginIndex()
  {
    return this.YkI;
  }
  
  public final int getEndIndex()
  {
    return this.uQJ;
  }
  
  public final int getIndex()
  {
    return this.mIndex;
  }
  
  public final char last()
  {
    AppMethodBeat.i(223009);
    if (this.YkI == this.uQJ)
    {
      this.mIndex = this.uQJ;
      AppMethodBeat.o(223009);
      return 65535;
    }
    this.mIndex = (this.uQJ - 1);
    char c = this.YkJ.charAt(this.mIndex);
    AppMethodBeat.o(223009);
    return c;
  }
  
  public final char next()
  {
    AppMethodBeat.i(223012);
    this.mIndex += 1;
    if (this.mIndex >= this.uQJ)
    {
      this.mIndex = this.uQJ;
      AppMethodBeat.o(223012);
      return 65535;
    }
    char c = this.YkJ.charAt(this.mIndex);
    AppMethodBeat.o(223012);
    return c;
  }
  
  public final char previous()
  {
    AppMethodBeat.i(223018);
    if (this.mIndex <= this.YkI)
    {
      AppMethodBeat.o(223018);
      return 65535;
    }
    this.mIndex -= 1;
    char c = this.YkJ.charAt(this.mIndex);
    AppMethodBeat.o(223018);
    return c;
  }
  
  public final char setIndex(int paramInt)
  {
    AppMethodBeat.i(223021);
    if ((this.YkI <= paramInt) && (paramInt <= this.uQJ))
    {
      this.mIndex = paramInt;
      c = current();
      AppMethodBeat.o(223021);
      return c;
    }
    char c = current();
    AppMethodBeat.o(223021);
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.c.a
 * JD-Core Version:    0.7.0.1
 */