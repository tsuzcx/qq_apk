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
  public final LinkedHashMap<String, d> b = new LinkedHashMap();
  public String c;
  public File d;
  public RandomAccessFile e;
  public d f = null;
  
  public e(File paramFile, String paramString)
  {
    this.c = paramString;
    this.a = paramFile.getPath();
    this.d = null;
    this.e = new RandomAccessFile(this.a, "r");
    long l2 = this.e.length() - 22L;
    long l1 = 0L;
    if (l2 >= 0L)
    {
      long l3 = l2 - 65536L;
      if (l3 >= 0L) {
        l1 = l3;
      }
      do
      {
        this.e.seek(l2);
        if (Integer.reverseBytes(this.e.readInt()) == 101010256)
        {
          paramFile = new byte[18];
          this.e.readFully(paramFile);
          int j = paramFile.length;
          paramString = ByteOrder.LITTLE_ENDIAN;
          int i = 0;
          paramFile = a.a(paramFile, 0, j, paramString);
          int k = paramFile.b();
          int m = paramFile.b();
          j = paramFile.b();
          int n = paramFile.b();
          paramFile.d += 4;
          int i1 = paramFile.a();
          if ((j == n) && (k == 0) && (m == 0))
          {
            paramFile = new BufferedInputStream(new e.a(this.e, i1), 4096);
            paramString = new byte[46];
            while (i < j)
            {
              d locald = new d(paramString, paramFile);
              this.b.put(locald.a, locald);
              if (locald.a.equals(this.c))
              {
                this.f = locald;
                return;
              }
              locald.a.contains("lib");
              i += 1;
            }
            return;
          }
          throw new ZipException("spanned archives not supported");
        }
        l2 -= 1L;
      } while (l2 >= l1);
      throw new ZipException("EOCD not found; not a Zip archive?");
    }
    paramFile = new ZipException("too short to be Zip");
    for (;;)
    {
      throw paramFile;
    }
  }
  
  public InputStream a(d paramd)
  {
    Object localObject2 = paramd.a;
    if (this.e != null)
    {
      if (localObject2 != null)
      {
        ??? = (d)this.b.get(localObject2);
        paramd = (d)???;
        if (??? == null)
        {
          paramd = this.b;
          ??? = new StringBuilder();
          ((StringBuilder)???).append((String)localObject2);
          ((StringBuilder)???).append("/");
          paramd = (d)paramd.get(((StringBuilder)???).toString());
        }
        if (paramd == null) {
          return null;
        }
        ??? = paramd.a;
        if ((??? != null) && ((((String)???).contains("../")) || (((String)???).contains("..\\")))) {
          throw new f();
        }
        synchronized (this.e)
        {
          localObject2 = new e.a((RandomAccessFile)???, paramd.g + 28L);
          DataInputStream localDataInputStream = new DataInputStream((InputStream)localObject2);
          int i = Short.reverseBytes(localDataInputStream.readShort());
          localDataInputStream.close();
          ((e.a)localObject2).skip(paramd.f + i);
          ((e.a)localObject2).c = (((e.a)localObject2).b + paramd.b);
          if (paramd.d == 8)
          {
            i = Math.max(1024, (int)Math.min(paramd.c, 65535L));
            paramd = new e.b((InputStream)localObject2, new Inflater(true), i, paramd);
            return paramd;
          }
          return localObject2;
        }
      }
      throw new NullPointerException();
    }
    throw new IllegalStateException("Zip file closed");
  }
  
  public void a()
  {
    Object localObject1 = this.e;
    if (localObject1 != null) {
      try
      {
        this.e = null;
        ((RandomAccessFile)localObject1).close();
        localObject1 = this.d;
        if (localObject1 != null)
        {
          ((File)localObject1).delete();
          this.d = null;
          return;
        }
      }
      finally {}
    }
  }
  
  public void finalize()
  {
    try
    {
      super.finalize();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     a.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */