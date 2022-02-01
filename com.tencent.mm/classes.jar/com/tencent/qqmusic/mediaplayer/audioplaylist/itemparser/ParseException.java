package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ParseException
  extends Exception
{
  public int curline = 0;
  
  public ParseException(String paramString, Exception paramException, int paramInt)
  {
    super(paramString, paramException);
    this.curline = paramInt;
  }
  
  public String getMessage()
  {
    AppMethodBeat.i(76604);
    String str = super.getMessage() + " line: " + this.curline;
    AppMethodBeat.o(76604);
    return str;
  }
  
  public String toString()
  {
    AppMethodBeat.i(76605);
    String str = "ParseException{message = " + getMessage() + "}";
    AppMethodBeat.o(76605);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser.ParseException
 * JD-Core Version:    0.7.0.1
 */