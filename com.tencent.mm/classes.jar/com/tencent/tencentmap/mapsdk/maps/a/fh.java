package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class fh
  implements Closeable, Flushable
{
  private static final String[] a;
  private static final String[] b;
  private final Writer c;
  private int[] d;
  private int e;
  private String f;
  private String g;
  private boolean h;
  private boolean i;
  private String j;
  private boolean k;
  
  static
  {
    AppMethodBeat.i(147934);
    a = new String[''];
    int m = 0;
    while (m <= 31)
    {
      a[m] = String.format("\\u%04x", new Object[] { Integer.valueOf(m) });
      m += 1;
    }
    a[34] = "\\\"";
    a[92] = "\\\\";
    a[9] = "\\t";
    a[8] = "\\b";
    a[10] = "\\n";
    a[13] = "\\r";
    a[12] = "\\f";
    String[] arrayOfString = (String[])a.clone();
    b = arrayOfString;
    arrayOfString[60] = "\\u003c";
    b[62] = "\\u003e";
    b[38] = "\\u0026";
    b[61] = "\\u003d";
    b[39] = "\\u0027";
    AppMethodBeat.o(147934);
  }
  
  public fh(Writer paramWriter)
  {
    AppMethodBeat.i(147912);
    this.d = new int[32];
    this.e = 0;
    a(6);
    this.g = ":";
    this.k = true;
    if (paramWriter == null)
    {
      paramWriter = new NullPointerException("out == null");
      AppMethodBeat.o(147912);
      throw paramWriter;
    }
    this.c = paramWriter;
    AppMethodBeat.o(147912);
  }
  
  private int a()
  {
    AppMethodBeat.i(147920);
    if (this.e == 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("JsonWriter is closed.");
      AppMethodBeat.o(147920);
      throw localIllegalStateException;
    }
    int m = this.d[(this.e - 1)];
    AppMethodBeat.o(147920);
    return m;
  }
  
  private fh a(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(147918);
    int m = a();
    if ((m != paramInt2) && (m != paramInt1))
    {
      paramString = new IllegalStateException("Nesting problem.");
      AppMethodBeat.o(147918);
      throw paramString;
    }
    if (this.j != null)
    {
      paramString = new IllegalStateException("Dangling name: " + this.j);
      AppMethodBeat.o(147918);
      throw paramString;
    }
    this.e -= 1;
    if (m == paramInt2) {
      j();
    }
    this.c.write(paramString);
    AppMethodBeat.o(147918);
    return this;
  }
  
  private fh a(int paramInt, String paramString)
  {
    AppMethodBeat.i(147917);
    c(true);
    a(paramInt);
    this.c.write(paramString);
    AppMethodBeat.o(147917);
    return this;
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(147919);
    if (this.e == this.d.length)
    {
      arrayOfInt = new int[this.e * 2];
      System.arraycopy(this.d, 0, arrayOfInt, 0, this.e);
      this.d = arrayOfInt;
    }
    int[] arrayOfInt = this.d;
    int m = this.e;
    this.e = (m + 1);
    arrayOfInt[m] = paramInt;
    AppMethodBeat.o(147919);
  }
  
  private void b(int paramInt)
  {
    this.d[(this.e - 1)] = paramInt;
  }
  
  private void c(String paramString)
  {
    AppMethodBeat.i(147930);
    if (this.i) {}
    int i2;
    int m;
    int n;
    int i3;
    int i1;
    for (String[] arrayOfString = b;; arrayOfString = a)
    {
      this.c.write("\"");
      i2 = paramString.length();
      m = 0;
      for (n = 0;; n = i1)
      {
        if (m >= i2) {
          break label158;
        }
        i3 = paramString.charAt(m);
        if (i3 >= 128) {
          break;
        }
        String str2 = arrayOfString[i3];
        str1 = str2;
        if (str2 != null) {
          break label106;
        }
        i1 = n;
        m += 1;
      }
    }
    if (i3 == 8232) {}
    for (String str1 = "\\u2028";; str1 = "\\u2029")
    {
      label106:
      if (n < m) {
        this.c.write(paramString, n, m - n);
      }
      this.c.write(str1);
      i1 = m + 1;
      break;
      i1 = n;
      if (i3 != 8233) {
        break;
      }
    }
    label158:
    if (n < i2) {
      this.c.write(paramString, n, i2 - n);
    }
    this.c.write("\"");
    AppMethodBeat.o(147930);
  }
  
  private void c(boolean paramBoolean)
  {
    AppMethodBeat.i(147933);
    IllegalStateException localIllegalStateException;
    switch (a())
    {
    case 3: 
    case 5: 
    default: 
      localIllegalStateException = new IllegalStateException("Nesting problem.");
      AppMethodBeat.o(147933);
      throw localIllegalStateException;
    case 7: 
      if (!this.h)
      {
        localIllegalStateException = new IllegalStateException("JSON must have only one top-level value.");
        AppMethodBeat.o(147933);
        throw localIllegalStateException;
      }
    case 6: 
      if ((!this.h) && (!paramBoolean))
      {
        localIllegalStateException = new IllegalStateException("JSON must start with an array or an object.");
        AppMethodBeat.o(147933);
        throw localIllegalStateException;
      }
      b(7);
      AppMethodBeat.o(147933);
      return;
    case 1: 
      b(2);
      j();
      AppMethodBeat.o(147933);
      return;
    case 2: 
      this.c.append(',');
      j();
      AppMethodBeat.o(147933);
      return;
    }
    this.c.append(this.g);
    b(5);
    AppMethodBeat.o(147933);
  }
  
  private void i()
  {
    AppMethodBeat.i(147922);
    if (this.j != null)
    {
      k();
      c(this.j);
      this.j = null;
    }
    AppMethodBeat.o(147922);
  }
  
  private void j()
  {
    AppMethodBeat.i(147931);
    if (this.f == null)
    {
      AppMethodBeat.o(147931);
      return;
    }
    this.c.write("\n");
    int m = 1;
    int n = this.e;
    while (m < n)
    {
      this.c.write(this.f);
      m += 1;
    }
    AppMethodBeat.o(147931);
  }
  
  private void k()
  {
    AppMethodBeat.i(147932);
    int m = a();
    if (m == 5) {
      this.c.write(44);
    }
    while (m == 3)
    {
      j();
      b(4);
      AppMethodBeat.o(147932);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("Nesting problem.");
    AppMethodBeat.o(147932);
    throw localIllegalStateException;
  }
  
  public fh a(long paramLong)
  {
    AppMethodBeat.i(147926);
    i();
    c(false);
    this.c.write(Long.toString(paramLong));
    AppMethodBeat.o(147926);
    return this;
  }
  
  public fh a(Number paramNumber)
  {
    AppMethodBeat.i(147927);
    if (paramNumber == null)
    {
      paramNumber = f();
      AppMethodBeat.o(147927);
      return paramNumber;
    }
    i();
    String str = paramNumber.toString();
    if ((!this.h) && ((str.equals("-Infinity")) || (str.equals("Infinity")) || (str.equals("NaN"))))
    {
      paramNumber = new IllegalArgumentException("Numeric values must be finite, but was ".concat(String.valueOf(paramNumber)));
      AppMethodBeat.o(147927);
      throw paramNumber;
    }
    c(false);
    this.c.append(str);
    AppMethodBeat.o(147927);
    return this;
  }
  
  public fh a(String paramString)
  {
    AppMethodBeat.i(147921);
    if (paramString == null)
    {
      paramString = new NullPointerException("name == null");
      AppMethodBeat.o(147921);
      throw paramString;
    }
    if (this.j != null)
    {
      paramString = new IllegalStateException();
      AppMethodBeat.o(147921);
      throw paramString;
    }
    if (this.e == 0)
    {
      paramString = new IllegalStateException("JsonWriter is closed.");
      AppMethodBeat.o(147921);
      throw paramString;
    }
    this.j = paramString;
    AppMethodBeat.o(147921);
    return this;
  }
  
  public fh a(boolean paramBoolean)
  {
    AppMethodBeat.i(147925);
    i();
    c(false);
    Writer localWriter = this.c;
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      localWriter.write(str);
      AppMethodBeat.o(147925);
      return this;
    }
  }
  
  public fh b()
  {
    AppMethodBeat.i(147913);
    i();
    fh localfh = a(1, "[");
    AppMethodBeat.o(147913);
    return localfh;
  }
  
  public fh b(String paramString)
  {
    AppMethodBeat.i(147923);
    if (paramString == null)
    {
      paramString = f();
      AppMethodBeat.o(147923);
      return paramString;
    }
    i();
    c(false);
    c(paramString);
    AppMethodBeat.o(147923);
    return this;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public fh c()
  {
    AppMethodBeat.i(147914);
    fh localfh = a(1, 2, "]");
    AppMethodBeat.o(147914);
    return localfh;
  }
  
  public void close()
  {
    AppMethodBeat.i(147929);
    this.c.close();
    int m = this.e;
    if ((m > 1) || ((m == 1) && (this.d[(m - 1)] != 7)))
    {
      IOException localIOException = new IOException("Incomplete document");
      AppMethodBeat.o(147929);
      throw localIOException;
    }
    this.e = 0;
    AppMethodBeat.o(147929);
  }
  
  public fh d()
  {
    AppMethodBeat.i(147915);
    i();
    fh localfh = a(3, "{");
    AppMethodBeat.o(147915);
    return localfh;
  }
  
  public fh e()
  {
    AppMethodBeat.i(147916);
    fh localfh = a(3, 5, "}");
    AppMethodBeat.o(147916);
    return localfh;
  }
  
  public fh f()
  {
    AppMethodBeat.i(147924);
    if (this.j != null)
    {
      if (this.k) {
        i();
      }
    }
    else
    {
      c(false);
      this.c.write("null");
      AppMethodBeat.o(147924);
      return this;
    }
    this.j = null;
    AppMethodBeat.o(147924);
    return this;
  }
  
  public void flush()
  {
    AppMethodBeat.i(147928);
    if (this.e == 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("JsonWriter is closed.");
      AppMethodBeat.o(147928);
      throw localIllegalStateException;
    }
    this.c.flush();
    AppMethodBeat.o(147928);
  }
  
  public boolean g()
  {
    return this.h;
  }
  
  public final boolean h()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fh
 * JD-Core Version:    0.7.0.1
 */