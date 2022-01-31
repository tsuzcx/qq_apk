package org.xwalk.core.util;

public class WebAddress$ParseException
  extends RuntimeException
{
  public String response;
  
  WebAddress$ParseException(String paramString)
  {
    this.response = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.xwalk.core.util.WebAddress.ParseException
 * JD-Core Version:    0.7.0.1
 */