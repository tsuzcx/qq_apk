package org.c.g;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public final class e
{
  public static String K(InputStream paramInputStream)
  {
    d.l(paramInputStream, "Cannot get String from a null object");
    try
    {
      char[] arrayOfChar = new char[65536];
      StringBuilder localStringBuilder = new StringBuilder();
      paramInputStream = new InputStreamReader(paramInputStream, "UTF-8");
      int i;
      do
      {
        i = paramInputStream.read(arrayOfChar, 0, 65536);
        if (i > 0) {
          localStringBuilder.append(arrayOfChar, 0, i);
        }
      } while (i >= 0);
      paramInputStream.close();
      paramInputStream = localStringBuilder.toString();
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      throw new IllegalStateException("Error while reading response body", paramInputStream);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.c.g.e
 * JD-Core Version:    0.7.0.1
 */