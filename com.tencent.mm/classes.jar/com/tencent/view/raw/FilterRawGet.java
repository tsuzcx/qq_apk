package com.tencent.view.raw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public class FilterRawGet
{
  private static GetInputStream mGetInputStream;
  
  public static void setGetInputStream(GetInputStream paramGetInputStream)
  {
    mGetInputStream = paramGetInputStream;
  }
  
  public InputStream getInpuStream(String paramString)
  {
    AppMethodBeat.i(86638);
    try
    {
      if (mGetInputStream != null) {}
      for (paramString = mGetInputStream.getInputStream(paramString);; paramString = getClass().getResourceAsStream(paramString))
      {
        AppMethodBeat.o(86638);
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(86638);
    }
  }
  
  public static abstract interface GetInputStream
  {
    public abstract InputStream getInputStream(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.view.raw.FilterRawGet
 * JD-Core Version:    0.7.0.1
 */