package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

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
    return super.getMessage() + " line: " + this.curline;
  }
  
  public String toString()
  {
    return "ParseException{message = " + getMessage() + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser.ParseException
 * JD-Core Version:    0.7.0.1
 */