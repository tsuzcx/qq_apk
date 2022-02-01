package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.UnknownFormatConversionException;

public class e
  implements Closeable
{
  static final char[] a = { 127, 69, 76, 70, 0 };
  final char[] b;
  boolean c;
  j[] d;
  e.l[] e;
  byte[] f;
  private final c g;
  private final a h;
  private final k[] i;
  private byte[] j;
  
  public e(File paramFile)
  {
    AppMethodBeat.i(53940);
    this.b = new char[16];
    c localc = new c(paramFile);
    this.g = localc;
    localc.a(this.b);
    if (!a())
    {
      paramFile = new UnknownFormatConversionException("Invalid elf magic: ".concat(String.valueOf(paramFile)));
      AppMethodBeat.o(53940);
      throw paramFile;
    }
    localc.a(e());
    boolean bool = d();
    int k;
    label240:
    Object localObject;
    if (bool)
    {
      paramFile = new f();
      paramFile.a = localc.a();
      paramFile.b = localc.a();
      paramFile.c = localc.b();
      paramFile.k = localc.c();
      paramFile.l = localc.c();
      paramFile.m = localc.c();
      this.h = paramFile;
      paramFile = this.h;
      paramFile.d = localc.b();
      paramFile.e = localc.a();
      paramFile.f = localc.a();
      paramFile.g = localc.a();
      paramFile.h = localc.a();
      paramFile.i = localc.a();
      paramFile.j = localc.a();
      this.i = new k[paramFile.i];
      k = 0;
      if (k >= paramFile.i) {
        break label583;
      }
      localc.a(paramFile.a() + paramFile.h * k);
      if (!bool) {
        break label463;
      }
      localObject = new h();
      ((h)localObject).g = localc.b();
      ((h)localObject).h = localc.b();
      ((h)localObject).a = localc.c();
      ((h)localObject).b = localc.c();
      ((h)localObject).c = localc.c();
      ((h)localObject).d = localc.c();
      ((h)localObject).i = localc.b();
      ((h)localObject).j = localc.b();
      ((h)localObject).e = localc.c();
      ((h)localObject).f = localc.c();
      this.i[k] = localObject;
    }
    for (;;)
    {
      k += 1;
      break label240;
      paramFile = new b();
      paramFile.a = localc.a();
      paramFile.b = localc.a();
      paramFile.c = localc.b();
      paramFile.k = localc.b();
      paramFile.l = localc.b();
      paramFile.m = localc.b();
      this.h = paramFile;
      break;
      label463:
      localObject = new d();
      ((d)localObject).g = localc.b();
      ((d)localObject).h = localc.b();
      ((d)localObject).a = localc.b();
      ((d)localObject).b = localc.b();
      ((d)localObject).c = localc.b();
      ((d)localObject).d = localc.b();
      ((d)localObject).i = localc.b();
      ((d)localObject).j = localc.b();
      ((d)localObject).e = localc.b();
      ((d)localObject).f = localc.b();
      this.i[k] = localObject;
    }
    label583:
    if ((paramFile.j >= 0) && (paramFile.j < this.i.length))
    {
      localObject = this.i[paramFile.j];
      if (((k)localObject).h == 3)
      {
        this.j = new byte[((k)localObject).a()];
        localc.a(((k)localObject).b());
        localc.a(this.j);
        if (this.c) {
          f();
        }
        AppMethodBeat.o(53940);
        return;
      }
      paramFile = new UnknownFormatConversionException("Wrong string section e_shstrndx=" + paramFile.j);
      AppMethodBeat.o(53940);
      throw paramFile;
    }
    paramFile = new UnknownFormatConversionException("Invalid e_shstrndx=" + paramFile.j);
    AppMethodBeat.o(53940);
    throw paramFile;
  }
  
  public static boolean a(File paramFile)
  {
    AppMethodBeat.i(53945);
    try
    {
      paramFile = new RandomAccessFile(paramFile, "r");
      long l = paramFile.readInt();
      paramFile.close();
      if (l != 2135247942L) {}
    }
    finally
    {
      AppMethodBeat.o(53945);
      return false;
    }
    AppMethodBeat.o(53945);
    return false;
  }
  
  /* Error */
  public static boolean b(File paramFile)
  {
    // Byte code:
    //   0: ldc 255
    //   2: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 257	com/tencent/smtt/utils/e:g	()Z
    //   8: ifeq +19 -> 27
    //   11: aload_0
    //   12: invokestatic 259	com/tencent/smtt/utils/e:a	(Ljava/io/File;)Z
    //   15: ifeq +12 -> 27
    //   18: new 2	com/tencent/smtt/utils/e
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 260	com/tencent/smtt/utils/e:<init>	(Ljava/io/File;)V
    //   26: pop
    //   27: ldc 255
    //   29: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: iconst_1
    //   33: ireturn
    //   34: astore_0
    //   35: new 222	java/lang/StringBuilder
    //   38: dup
    //   39: ldc_w 262
    //   42: invokespecial 225	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   45: aload_0
    //   46: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: ldc 255
    //   52: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iconst_0
    //   56: ireturn
    //   57: astore_0
    //   58: new 222	java/lang/StringBuilder
    //   61: dup
    //   62: ldc_w 267
    //   65: invokespecial 225	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   68: aload_0
    //   69: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: goto -46 -> 27
    //   76: astore_0
    //   77: new 222	java/lang/StringBuilder
    //   80: dup
    //   81: ldc_w 269
    //   84: invokespecial 225	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   87: aload_0
    //   88: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: goto -65 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramFile	File
    // Exception table:
    //   from	to	target	type
    //   18	27	34	java/io/IOException
    //   18	27	57	java/util/UnknownFormatConversionException
    //   18	27	76	finally
  }
  
  private void f()
  {
    AppMethodBeat.i(53941);
    a locala = this.h;
    c localc = this.g;
    boolean bool = d();
    Object localObject1 = a(".dynsym");
    if (localObject1 != null)
    {
      localc.a(((k)localObject1).b());
      int m = ((k)localObject1).a();
      char[] arrayOfChar;
      label79:
      Object localObject2;
      if (bool)
      {
        k = 24;
        m /= k;
        this.e = new e.l[m];
        arrayOfChar = new char[1];
        k = 0;
        if (k >= m) {
          break label286;
        }
        if (!bool) {
          break label192;
        }
        localObject2 = new e.i();
        ((e.i)localObject2).c = localc.b();
        localc.a(arrayOfChar);
        ((e.i)localObject2).d = arrayOfChar[0];
        localc.a(arrayOfChar);
        ((e.i)localObject2).e = arrayOfChar[0];
        ((e.i)localObject2).a = localc.c();
        ((e.i)localObject2).b = localc.c();
        ((e.i)localObject2).f = localc.a();
        this.e[k] = localObject2;
      }
      for (;;)
      {
        k += 1;
        break label79;
        k = 16;
        break;
        label192:
        localObject2 = new e.e();
        ((e.e)localObject2).c = localc.b();
        ((e.e)localObject2).a = localc.b();
        ((e.e)localObject2).b = localc.b();
        localc.a(arrayOfChar);
        ((e.e)localObject2).d = arrayOfChar[0];
        localc.a(arrayOfChar);
        ((e.e)localObject2).e = arrayOfChar[0];
        ((e.e)localObject2).f = localc.a();
        this.e[k] = localObject2;
      }
      label286:
      localObject1 = this.i[localObject1.i];
      localc.a(((k)localObject1).b());
      this.f = new byte[((k)localObject1).a()];
      localc.a(this.f);
    }
    this.d = new j[locala.g];
    int k = 0;
    if (k < locala.g)
    {
      localc.a(locala.b() + locala.f * k);
      if (bool)
      {
        localObject1 = new g();
        ((g)localObject1).g = localc.b();
        ((g)localObject1).h = localc.b();
        ((g)localObject1).a = localc.c();
        ((g)localObject1).b = localc.c();
        ((g)localObject1).c = localc.c();
        ((g)localObject1).d = localc.c();
        ((g)localObject1).e = localc.c();
        ((g)localObject1).f = localc.c();
        this.d[k] = localObject1;
      }
      for (;;)
      {
        k += 1;
        break;
        localObject1 = new c();
        ((c)localObject1).g = localc.b();
        ((c)localObject1).h = localc.b();
        ((c)localObject1).a = localc.b();
        ((c)localObject1).b = localc.b();
        ((c)localObject1).c = localc.b();
        ((c)localObject1).d = localc.b();
        ((c)localObject1).e = localc.b();
        ((c)localObject1).f = localc.b();
        this.d[k] = localObject1;
      }
    }
    AppMethodBeat.o(53941);
  }
  
  private static boolean g()
  {
    AppMethodBeat.i(53947);
    String str = System.getProperty("java.vm.version");
    if ((str != null) && (str.startsWith("2")))
    {
      AppMethodBeat.o(53947);
      return true;
    }
    AppMethodBeat.o(53947);
    return false;
  }
  
  public final k a(String paramString)
  {
    AppMethodBeat.i(53942);
    k[] arrayOfk = this.i;
    int m = arrayOfk.length;
    int k = 0;
    while (k < m)
    {
      k localk = arrayOfk[k];
      if (paramString.equals(a(localk.g)))
      {
        AppMethodBeat.o(53942);
        return localk;
      }
      k += 1;
    }
    AppMethodBeat.o(53942);
    return null;
  }
  
  public final String a(int paramInt)
  {
    AppMethodBeat.i(53943);
    if (paramInt == 0)
    {
      AppMethodBeat.o(53943);
      return "SHN_UNDEF";
    }
    int k = paramInt;
    while (this.j[k] != 0) {
      k += 1;
    }
    String str = new String(this.j, paramInt, k - paramInt);
    AppMethodBeat.o(53943);
    return str;
  }
  
  final boolean a()
  {
    boolean bool = false;
    if (this.b[0] == a[0]) {
      bool = true;
    }
    return bool;
  }
  
  final char b()
  {
    return this.b[4];
  }
  
  final char c()
  {
    return this.b[5];
  }
  
  public void close()
  {
    AppMethodBeat.i(53944);
    this.g.close();
    AppMethodBeat.o(53944);
  }
  
  public final boolean d()
  {
    AppMethodBeat.i(53938);
    if (b() == '\002')
    {
      AppMethodBeat.o(53938);
      return true;
    }
    AppMethodBeat.o(53938);
    return false;
  }
  
  public final boolean e()
  {
    AppMethodBeat.i(53939);
    if (c() == '\001')
    {
      AppMethodBeat.o(53939);
      return true;
    }
    AppMethodBeat.o(53939);
    return false;
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
  
  static class b
    extends e.a
  {
    int k;
    int l;
    int m;
    
    long a()
    {
      return this.m;
    }
    
    long b()
    {
      return this.l;
    }
  }
  
  static class c
    extends e.j
  {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
  }
  
  static class d
    extends e.k
  {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    
    public int a()
    {
      return this.d;
    }
    
    public long b()
    {
      return this.c;
    }
  }
  
  static class f
    extends e.a
  {
    long k;
    long l;
    long m;
    
    long a()
    {
      return this.m;
    }
    
    long b()
    {
      return this.l;
    }
  }
  
  static class g
    extends e.j
  {
    long a;
    long b;
    long c;
    long d;
    long e;
    long f;
  }
  
  static class h
    extends e.k
  {
    long a;
    long b;
    long c;
    long d;
    long e;
    long f;
    
    public int a()
    {
      return (int)this.d;
    }
    
    public long b()
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
 * Qualified Name:     com.tencent.smtt.utils.e
 * JD-Core Version:    0.7.0.1
 */