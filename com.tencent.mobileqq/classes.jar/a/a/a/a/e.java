package a.a.a.a;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

public class e
  implements c
{
  public final String a;
  public String b;
  public RandomAccessFile c;
  public d d = null;
  public final LinkedHashMap<String, d> e = new LinkedHashMap();
  
  public e(File paramFile, String paramString)
  {
    this.b = paramString;
    this.a = paramFile.getPath();
    this.c = new RandomAccessFile(this.a, "r");
    long l1 = this.c.length() - 22L;
    long l3;
    if (l1 >= 0L)
    {
      l3 = l1 - 65536L;
      if (l3 >= 0L) {
        break label343;
      }
    }
    for (;;)
    {
      this.c.seek(l1);
      if (Integer.reverseBytes(this.c.readInt()) == 101010256)
      {
        paramFile = new byte[18];
        this.c.readFully(paramFile);
        paramFile = a.a(paramFile, 0, paramFile.length, ByteOrder.LITTLE_ENDIAN);
        int i = paramFile.b();
        int k = paramFile.b();
        int j = paramFile.b();
        int m = paramFile.b();
        paramFile.d += 4;
        int n = paramFile.a();
        if ((j == m) && (i == 0) && (k == 0))
        {
          paramFile = new BufferedInputStream(new e.a(this.c, n), 4096);
          paramString = new byte[46];
          i = 0;
          for (;;)
          {
            d locald;
            if (i < j)
            {
              locald = new d(paramString, paramFile);
              this.e.put(locald.a, locald);
              if (locald.a.equals(this.b)) {
                this.d = locald;
              }
            }
            else
            {
              return;
            }
            locald.a.contains("lib");
            i += 1;
          }
        }
        throw new ZipException("spanned archives not supported");
      }
      l3 = l1 - 1L;
      l1 = l3;
      if (l3 < l2)
      {
        throw new ZipException("EOCD not found; not a Zip archive?");
        throw new ZipException("too short to be Zip");
        label343:
        l2 = l3;
      }
    }
  }
  
  public InputStream a(d paramd)
  {
    ??? = paramd.a;
    if (this.c != null) {
      if (??? != null)
      {
        paramd = (d)this.e.get(???);
        if (paramd != null) {
          break label260;
        }
        paramd = (d)this.e.get((String)??? + "/");
      }
    }
    label260:
    for (;;)
    {
      if (paramd == null) {
        return null;
      }
      ??? = paramd.a;
      e.a locala;
      if ((??? == null) || ((!((String)???).contains("../")) && (!((String)???).contains("..\\")))) {
        synchronized (this.c)
        {
          locala = new e.a((RandomAccessFile)???, paramd.g + 28L);
          DataInputStream localDataInputStream = new DataInputStream(locala);
          int i = Short.reverseBytes(localDataInputStream.readShort());
          localDataInputStream.close();
          locala.skip(paramd.f + i);
          locala.c = (locala.b + paramd.b);
          if (paramd.d != 8) {
            break label237;
          }
          i = Math.max(1024, (int)Math.min(paramd.c, 65535L));
          paramd = new e.b(locala, new Inflater(true), i, paramd);
          return paramd;
        }
      }
      throw new f();
      label237:
      return locala;
      throw new NullPointerException();
      throw new IllegalStateException("Zip file closed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     a.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */