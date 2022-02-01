package com.tencent.tbs.one.impl.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.util.UnknownFormatConversionException;

public final class d
  implements Closeable
{
  static final char[] a = { 127, 69, 76, 70, 0 };
  final char[] b;
  boolean c;
  j[] d;
  d.l[] e;
  byte[] f;
  private final a g;
  private final a h;
  private final k[] i;
  private byte[] j;
  
  public d(File paramFile)
  {
    AppMethodBeat.i(173813);
    this.b = new char[16];
    a locala = new a(paramFile);
    this.g = locala;
    locala.a(this.b);
    if (this.b[0] == a[0]) {}
    for (int k = 1; k == 0; k = 0)
    {
      paramFile = new UnknownFormatConversionException("Invalid elf magic: ".concat(String.valueOf(paramFile)));
      AppMethodBeat.o(173813);
      throw paramFile;
    }
    label192:
    Object localObject;
    if (this.b[5] == '\001')
    {
      locala.a = bool;
      bool = a();
      if (!bool) {
        break label433;
      }
      paramFile = new f();
      paramFile.a = locala.a();
      paramFile.b = locala.a();
      paramFile.c = locala.b();
      paramFile.k = locala.c();
      paramFile.l = locala.c();
      paramFile.m = locala.c();
      this.h = paramFile;
      paramFile = this.h;
      paramFile.d = locala.b();
      paramFile.e = locala.a();
      paramFile.f = locala.a();
      paramFile.g = locala.a();
      paramFile.h = locala.a();
      paramFile.i = locala.a();
      paramFile.j = locala.a();
      this.i = new k[paramFile.i];
      k = m;
      label273:
      if (k >= paramFile.i) {
        break label623;
      }
      locala.a(paramFile.a() + paramFile.h * k);
      if (!bool) {
        break label503;
      }
      localObject = new h();
      ((h)localObject).g = locala.b();
      ((h)localObject).h = locala.b();
      ((h)localObject).a = locala.c();
      ((h)localObject).b = locala.c();
      ((h)localObject).c = locala.c();
      ((h)localObject).d = locala.c();
      ((h)localObject).i = locala.b();
      ((h)localObject).j = locala.b();
      ((h)localObject).e = locala.c();
      ((h)localObject).f = locala.c();
      this.i[k] = localObject;
    }
    for (;;)
    {
      k += 1;
      break label273;
      bool = false;
      break;
      label433:
      paramFile = new b();
      paramFile.a = locala.a();
      paramFile.b = locala.a();
      paramFile.c = locala.b();
      paramFile.k = locala.b();
      paramFile.l = locala.b();
      paramFile.m = locala.b();
      this.h = paramFile;
      break label192;
      label503:
      localObject = new d();
      ((d)localObject).g = locala.b();
      ((d)localObject).h = locala.b();
      ((d)localObject).a = locala.b();
      ((d)localObject).b = locala.b();
      ((d)localObject).c = locala.b();
      ((d)localObject).d = locala.b();
      ((d)localObject).i = locala.b();
      ((d)localObject).j = locala.b();
      ((d)localObject).e = locala.b();
      ((d)localObject).f = locala.b();
      this.i[k] = localObject;
    }
    label623:
    if ((paramFile.j >= 0) && (paramFile.j < this.i.length))
    {
      localObject = this.i[paramFile.j];
      if (((k)localObject).h == 3)
      {
        this.j = new byte[((k)localObject).a()];
        locala.a(((k)localObject).b());
        locala.a(this.j);
        if (this.c) {
          b();
        }
        AppMethodBeat.o(173813);
        return;
      }
      paramFile = new UnknownFormatConversionException("Wrong string section e_shstrndx=" + paramFile.j);
      AppMethodBeat.o(173813);
      throw paramFile;
    }
    paramFile = new UnknownFormatConversionException("Invalid e_shstrndx=" + paramFile.j);
    AppMethodBeat.o(173813);
    throw paramFile;
  }
  
  private boolean a()
  {
    return this.b[4] == '\002';
  }
  
  /* Error */
  public static boolean a(File paramFile)
  {
    // Byte code:
    //   0: ldc 232
    //   2: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 234	java/io/RandomAccessFile
    //   8: dup
    //   9: aload_0
    //   10: ldc 236
    //   12: invokespecial 239	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: invokevirtual 242	java/io/RandomAccessFile:readInt	()I
    //   22: istore_1
    //   23: iload_1
    //   24: i2l
    //   25: lstore_2
    //   26: aload 4
    //   28: invokestatic 247	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   31: lload_2
    //   32: ldc2_w 248
    //   35: lcmp
    //   36: ifne +59 -> 95
    //   39: ldc 232
    //   41: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: iconst_1
    //   45: ireturn
    //   46: astore 5
    //   48: aconst_null
    //   49: astore 4
    //   51: ldc 251
    //   53: iconst_2
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload_0
    //   60: invokevirtual 256	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: aload 5
    //   68: aastore
    //   69: invokestatic 261	com/tencent/tbs/one/impl/a/f:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload 4
    //   74: invokestatic 247	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   77: lconst_0
    //   78: lstore_2
    //   79: goto -48 -> 31
    //   82: astore_0
    //   83: aload 4
    //   85: invokestatic 247	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   88: ldc 232
    //   90: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_0
    //   94: athrow
    //   95: ldc 232
    //   97: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: iconst_0
    //   101: ireturn
    //   102: astore 5
    //   104: goto -53 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramFile	File
    //   22	2	1	k	int
    //   25	54	2	l	long
    //   15	69	4	localRandomAccessFile	java.io.RandomAccessFile
    //   46	21	5	localObject1	Object
    //   102	1	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	17	46	finally
    //   51	72	82	finally
    //   17	23	102	finally
  }
  
  private void b()
  {
    AppMethodBeat.i(173814);
    a locala = this.h;
    a locala1 = this.g;
    boolean bool = a();
    Object localObject2 = this.i;
    int i1 = localObject2.length;
    int k = 0;
    char[] arrayOfChar;
    int n;
    label64:
    label79:
    int m;
    if (k < i1)
    {
      arrayOfChar = localObject2[k];
      n = arrayOfChar.g;
      if (n == 0)
      {
        localObject1 = "SHN_UNDEF";
        if (!".dynsym".equals(localObject1)) {
          break label273;
        }
        localObject1 = arrayOfChar;
        if (localObject1 == null) {
          break label429;
        }
        locala1.a(((k)localObject1).b());
        m = ((k)localObject1).a();
        if (!bool) {
          break label286;
        }
        k = 24;
        label108:
        m /= k;
        this.e = new d.l[m];
        arrayOfChar = new char[1];
        k = 0;
        label127:
        if (k >= m) {
          break label386;
        }
        if (!bool) {
          break label292;
        }
        localObject2 = new d.i();
        ((d.i)localObject2).c = locala1.b();
        locala1.a(arrayOfChar);
        ((d.i)localObject2).d = arrayOfChar[0];
        locala1.a(arrayOfChar);
        ((d.i)localObject2).e = arrayOfChar[0];
        ((d.i)localObject2).a = locala1.c();
        ((d.i)localObject2).b = locala1.c();
        ((d.i)localObject2).f = locala1.a();
        this.e[k] = localObject2;
      }
    }
    for (;;)
    {
      k += 1;
      break label127;
      m = n;
      while (this.j[m] != 0) {
        m += 1;
      }
      localObject1 = new String(this.j, n, m - n);
      break label64;
      label273:
      k += 1;
      break;
      localObject1 = null;
      break label79;
      label286:
      k = 16;
      break label108;
      label292:
      localObject2 = new d.e();
      ((d.e)localObject2).c = locala1.b();
      ((d.e)localObject2).a = locala1.b();
      ((d.e)localObject2).b = locala1.b();
      locala1.a(arrayOfChar);
      ((d.e)localObject2).d = arrayOfChar[0];
      locala1.a(arrayOfChar);
      ((d.e)localObject2).e = arrayOfChar[0];
      ((d.e)localObject2).f = locala1.a();
      this.e[k] = localObject2;
    }
    label386:
    Object localObject1 = this.i[localObject1.i];
    locala1.a(((k)localObject1).b());
    this.f = new byte[((k)localObject1).a()];
    locala1.a(this.f);
    label429:
    this.d = new j[locala.g];
    k = 0;
    if (k < locala.g)
    {
      locala1.a(locala.b() + locala.f * k);
      if (bool)
      {
        localObject1 = new g();
        ((g)localObject1).g = locala1.b();
        ((g)localObject1).h = locala1.b();
        ((g)localObject1).a = locala1.c();
        ((g)localObject1).b = locala1.c();
        ((g)localObject1).c = locala1.c();
        ((g)localObject1).d = locala1.c();
        ((g)localObject1).e = locala1.c();
        ((g)localObject1).f = locala1.c();
        this.d[k] = localObject1;
      }
      for (;;)
      {
        k += 1;
        break;
        localObject1 = new c();
        ((c)localObject1).g = locala1.b();
        ((c)localObject1).h = locala1.b();
        ((c)localObject1).a = locala1.b();
        ((c)localObject1).b = locala1.b();
        ((c)localObject1).c = locala1.b();
        ((c)localObject1).d = locala1.b();
        ((c)localObject1).e = locala1.b();
        ((c)localObject1).f = locala1.b();
        this.d[k] = localObject1;
      }
    }
    AppMethodBeat.o(173814);
  }
  
  public final void close()
  {
    AppMethodBeat.i(173815);
    this.g.close();
    AppMethodBeat.o(173815);
  }
  
  public static abstract class a
  {
    short a;
    short b;
    int c;
    int d;
    short e;
    short f;
    short g;
    short h;
    short i;
    short j;
    
    abstract long a();
    
    abstract long b();
  }
  
  static final class b
    extends d.a
  {
    int k;
    int l;
    int m;
    
    final long a()
    {
      return this.m;
    }
    
    final long b()
    {
      return this.l;
    }
  }
  
  static final class c
    extends d.j
  {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
  }
  
  static final class d
    extends d.k
  {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    
    public final int a()
    {
      return this.d;
    }
    
    public final long b()
    {
      return this.c;
    }
  }
  
  static final class f
    extends d.a
  {
    long k;
    long l;
    long m;
    
    final long a()
    {
      return this.m;
    }
    
    final long b()
    {
      return this.l;
    }
  }
  
  static final class g
    extends d.j
  {
    long a;
    long b;
    long c;
    long d;
    long e;
    long f;
  }
  
  static final class h
    extends d.k
  {
    long a;
    long b;
    long c;
    long d;
    long e;
    long f;
    
    public final int a()
    {
      return (int)this.d;
    }
    
    public final long b()
    {
      return this.c;
    }
  }
  
  static abstract class j
  {
    int g;
    int h;
  }
  
  public static abstract class k
  {
    int g;
    int h;
    int i;
    int j;
    
    public abstract int a();
    
    public abstract long b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.a.d
 * JD-Core Version:    0.7.0.1
 */