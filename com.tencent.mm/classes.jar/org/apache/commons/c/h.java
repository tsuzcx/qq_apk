package org.apache.commons.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;
import org.apache.commons.c.b.d;
import org.apache.commons.c.c.a;

public final class h
{
  private static final String ajVG = "\"";
  private static final char[] ajVH = { 44, 34, 13, 10 };
  
  private static String Q(char paramChar)
  {
    AppMethodBeat.i(40740);
    String str = Integer.toHexString(paramChar).toUpperCase(Locale.ENGLISH);
    AppMethodBeat.o(40740);
    return str;
  }
  
  private static void a(Writer paramWriter, String paramString)
  {
    AppMethodBeat.i(40739);
    if (paramString == null)
    {
      AppMethodBeat.o(40739);
      return;
    }
    int k = paramString.length();
    int j = 0;
    if (j < k)
    {
      int i = paramString.charAt(j);
      if (i > 4095) {
        paramWriter.write("\\u" + Q(i));
      }
      for (;;)
      {
        j += 1;
        break;
        if (i > 255) {
          paramWriter.write("\\u0" + Q(i));
        } else if (i > 127) {
          paramWriter.write("\\u00" + Q(i));
        } else if (i < 32) {
          switch (i)
          {
          case 11: 
          default: 
            if (i > 15) {
              paramWriter.write("\\u00" + Q(i));
            }
            break;
          case 8: 
            paramWriter.write(92);
            paramWriter.write(98);
            break;
          case 10: 
            paramWriter.write(92);
            paramWriter.write(110);
            break;
          case 9: 
            paramWriter.write(92);
            paramWriter.write(116);
            break;
          case 12: 
            paramWriter.write(92);
            paramWriter.write(102);
            break;
          case 13: 
            paramWriter.write(92);
            paramWriter.write(114);
            continue;
            paramWriter.write("\\u000" + Q(i));
            break;
          }
        } else {
          switch (i)
          {
          default: 
            paramWriter.write(i);
            break;
          case 39: 
            paramWriter.write(92);
            paramWriter.write(39);
            break;
          case 34: 
            paramWriter.write(92);
            paramWriter.write(34);
            break;
          case 92: 
            paramWriter.write(92);
            paramWriter.write(92);
            break;
          case 47: 
            paramWriter.write(92);
            paramWriter.write(47);
          }
        }
      }
    }
    AppMethodBeat.o(40739);
  }
  
  private static void b(Writer paramWriter, String paramString)
  {
    AppMethodBeat.i(40742);
    if (paramString == null)
    {
      AppMethodBeat.o(40742);
      return;
    }
    int m = paramString.length();
    a locala = new a(4);
    int k = 0;
    int j = 0;
    int i = 0;
    if (k < m)
    {
      char c = paramString.charAt(k);
      if (j != 0)
      {
        locala.R(c);
        if (locala.length() != 4) {}
      }
      for (;;)
      {
        try
        {
          paramWriter.write((char)Integer.parseInt(locala.toString(), 16));
          locala.kJw();
          j = 0;
          i = 0;
          k += 1;
        }
        catch (NumberFormatException paramWriter)
        {
          paramWriter = new d("Unable to parse unicode value: ".concat(String.valueOf(locala)), paramWriter);
          AppMethodBeat.o(40742);
          throw paramWriter;
        }
        if (i != 0) {
          switch (c)
          {
          default: 
            paramWriter.write(c);
            i = 0;
            break;
          case '\\': 
            paramWriter.write(92);
            i = 0;
            break;
          case '\'': 
            paramWriter.write(39);
            i = 0;
            break;
          case '"': 
            paramWriter.write(34);
            i = 0;
            break;
          case 'r': 
            paramWriter.write(13);
            i = 0;
            break;
          case 'f': 
            paramWriter.write(12);
            i = 0;
            break;
          case 't': 
            paramWriter.write(9);
            i = 0;
            break;
          case 'n': 
            paramWriter.write(10);
            i = 0;
            break;
          case 'b': 
            paramWriter.write(8);
            i = 0;
            break;
          case 'u': 
            j = 1;
            i = 0;
            break;
          }
        } else if (c == '\\') {
          i = 1;
        } else {
          paramWriter.write(c);
        }
      }
    }
    if (i != 0) {
      paramWriter.write(92);
    }
    AppMethodBeat.o(40742);
  }
  
  public static String bLc(String paramString)
  {
    AppMethodBeat.i(40737);
    paramString = bLd(paramString);
    AppMethodBeat.o(40737);
    return paramString;
  }
  
  private static String bLd(String paramString)
  {
    AppMethodBeat.i(40738);
    if (paramString == null)
    {
      AppMethodBeat.o(40738);
      return null;
    }
    try
    {
      StringWriter localStringWriter = new StringWriter(paramString.length() * 2);
      a(localStringWriter, paramString);
      paramString = localStringWriter.toString();
      AppMethodBeat.o(40738);
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString = new k(paramString);
      AppMethodBeat.o(40738);
      throw paramString;
    }
  }
  
  private static String bLe(String paramString)
  {
    AppMethodBeat.i(40741);
    if (paramString == null)
    {
      AppMethodBeat.o(40741);
      return null;
    }
    try
    {
      StringWriter localStringWriter = new StringWriter(paramString.length());
      b(localStringWriter, paramString);
      paramString = localStringWriter.toString();
      AppMethodBeat.o(40741);
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString = new k(paramString);
      AppMethodBeat.o(40741);
      throw paramString;
    }
  }
  
  public static String bLf(String paramString)
  {
    AppMethodBeat.i(40743);
    paramString = bLe(paramString);
    AppMethodBeat.o(40743);
    return paramString;
  }
  
  public static String bLg(String paramString)
  {
    AppMethodBeat.i(40744);
    if (paramString == null)
    {
      AppMethodBeat.o(40744);
      return null;
    }
    paramString = c.ajVw.unescape(paramString);
    AppMethodBeat.o(40744);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.apache.commons.c.h
 * JD-Core Version:    0.7.0.1
 */