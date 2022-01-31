package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UnknownFormatConversionException;

public class j
  implements Closeable
{
  static final char[] a = { 127, 69, 76, 70, 0 };
  final char[] b;
  boolean c;
  j[] d;
  l[] e;
  byte[] f;
  private final c g;
  private final a h;
  private final j.k[] i;
  private byte[] j;
  
  public j(File paramFile)
  {
    AppMethodBeat.i(65211);
    this.b = new char[16];
    c localc = new c(paramFile);
    this.g = localc;
    localc.a(this.b);
    if (!a())
    {
      paramFile = new UnknownFormatConversionException("Invalid elf magic: ".concat(String.valueOf(paramFile)));
      AppMethodBeat.o(65211);
      throw paramFile;
    }
    localc.a(e());
    boolean bool = d();
    int k;
    label240:
    Object localObject;
    if (bool)
    {
      paramFile = new j.f();
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
      this.i = new j.k[paramFile.i];
      k = 0;
      if (k >= paramFile.i) {
        break label583;
      }
      localc.a(paramFile.a() + paramFile.h * k);
      if (!bool) {
        break label463;
      }
      localObject = new j.h();
      ((j.h)localObject).g = localc.b();
      ((j.h)localObject).h = localc.b();
      ((j.h)localObject).a = localc.c();
      ((j.h)localObject).b = localc.c();
      ((j.h)localObject).c = localc.c();
      ((j.h)localObject).d = localc.c();
      ((j.h)localObject).i = localc.b();
      ((j.h)localObject).j = localc.b();
      ((j.h)localObject).e = localc.c();
      ((j.h)localObject).f = localc.c();
      this.i[k] = localObject;
    }
    for (;;)
    {
      k += 1;
      break label240;
      paramFile = new j.b();
      paramFile.a = localc.a();
      paramFile.b = localc.a();
      paramFile.c = localc.b();
      paramFile.k = localc.b();
      paramFile.l = localc.b();
      paramFile.m = localc.b();
      this.h = paramFile;
      break;
      label463:
      localObject = new j.d();
      ((j.d)localObject).g = localc.b();
      ((j.d)localObject).h = localc.b();
      ((j.d)localObject).a = localc.b();
      ((j.d)localObject).b = localc.b();
      ((j.d)localObject).c = localc.b();
      ((j.d)localObject).d = localc.b();
      ((j.d)localObject).i = localc.b();
      ((j.d)localObject).j = localc.b();
      ((j.d)localObject).e = localc.b();
      ((j.d)localObject).f = localc.b();
      this.i[k] = localObject;
    }
    label583:
    if ((paramFile.j >= 0) && (paramFile.j < this.i.length))
    {
      localObject = this.i[paramFile.j];
      if (((j.k)localObject).h == 3)
      {
        this.j = new byte[((j.k)localObject).a()];
        localc.a(((j.k)localObject).b());
        localc.a(this.j);
        if (this.c) {
          f();
        }
        AppMethodBeat.o(65211);
        return;
      }
      paramFile = new UnknownFormatConversionException("Wrong string section e_shstrndx=" + paramFile.j);
      AppMethodBeat.o(65211);
      throw paramFile;
    }
    paramFile = new UnknownFormatConversionException("Invalid e_shstrndx=" + paramFile.j);
    AppMethodBeat.o(65211);
    throw paramFile;
  }
  
  public static boolean a(File paramFile)
  {
    AppMethodBeat.i(65216);
    try
    {
      paramFile = new RandomAccessFile(paramFile, "r");
      long l = paramFile.readInt();
      paramFile.close();
      if (l == 2135247942L)
      {
        AppMethodBeat.o(65216);
        return true;
      }
    }
    catch (Throwable paramFile)
    {
      AppMethodBeat.o(65216);
      return false;
    }
    AppMethodBeat.o(65216);
    return false;
  }
  
  public static boolean b(File paramFile)
  {
    AppMethodBeat.i(65217);
    if ((g()) && (a(paramFile))) {}
    try
    {
      new j(paramFile);
      AppMethodBeat.o(65217);
      return true;
    }
    catch (IOException paramFile)
    {
      new StringBuilder("checkElfFile IOException: ").append(paramFile);
      AppMethodBeat.o(65217);
      return false;
    }
    catch (UnknownFormatConversionException paramFile)
    {
      for (;;)
      {
        new StringBuilder("checkElfFile UnknownFormatConversionException: ").append(paramFile);
      }
    }
    catch (Throwable paramFile)
    {
      for (;;)
      {
        new StringBuilder("checkElfFile Throwable: ").append(paramFile);
      }
    }
  }
  
  private void f()
  {
    AppMethodBeat.i(65212);
    a locala = this.h;
    c localc = this.g;
    boolean bool = d();
    Object localObject1 = a(".dynsym");
    if (localObject1 != null)
    {
      localc.a(((j.k)localObject1).b());
      int m = ((j.k)localObject1).a();
      char[] arrayOfChar;
      label79:
      Object localObject2;
      if (bool)
      {
        k = 24;
        m /= k;
        this.e = new l[m];
        arrayOfChar = new char[1];
        k = 0;
        if (k >= m) {
          break label286;
        }
        if (!bool) {
          break label192;
        }
        localObject2 = new i();
        ((i)localObject2).c = localc.b();
        localc.a(arrayOfChar);
        ((i)localObject2).d = arrayOfChar[0];
        localc.a(arrayOfChar);
        ((i)localObject2).e = arrayOfChar[0];
        ((i)localObject2).a = localc.c();
        ((i)localObject2).b = localc.c();
        ((i)localObject2).f = localc.a();
        this.e[k] = localObject2;
      }
      for (;;)
      {
        k += 1;
        break label79;
        k = 16;
        break;
        label192:
        localObject2 = new j.e();
        ((j.e)localObject2).c = localc.b();
        ((j.e)localObject2).a = localc.b();
        ((j.e)localObject2).b = localc.b();
        localc.a(arrayOfChar);
        ((j.e)localObject2).d = arrayOfChar[0];
        localc.a(arrayOfChar);
        ((j.e)localObject2).e = arrayOfChar[0];
        ((j.e)localObject2).f = localc.a();
        this.e[k] = localObject2;
      }
      label286:
      localObject1 = this.i[localObject1.i];
      localc.a(((j.k)localObject1).b());
      this.f = new byte[((j.k)localObject1).a()];
      localc.a(this.f);
    }
    this.d = new j[locala.g];
    int k = 0;
    if (k < locala.g)
    {
      localc.a(locala.b() + locala.f * k);
      if (bool)
      {
        localObject1 = new j.g();
        ((j.g)localObject1).g = localc.b();
        ((j.g)localObject1).h = localc.b();
        ((j.g)localObject1).a = localc.c();
        ((j.g)localObject1).b = localc.c();
        ((j.g)localObject1).c = localc.c();
        ((j.g)localObject1).d = localc.c();
        ((j.g)localObject1).e = localc.c();
        ((j.g)localObject1).f = localc.c();
        this.d[k] = localObject1;
      }
      for (;;)
      {
        k += 1;
        break;
        localObject1 = new j.c();
        ((j.c)localObject1).g = localc.b();
        ((j.c)localObject1).h = localc.b();
        ((j.c)localObject1).a = localc.b();
        ((j.c)localObject1).b = localc.b();
        ((j.c)localObject1).c = localc.b();
        ((j.c)localObject1).d = localc.b();
        ((j.c)localObject1).e = localc.b();
        ((j.c)localObject1).f = localc.b();
        this.d[k] = localObject1;
      }
    }
    AppMethodBeat.o(65212);
  }
  
  private static boolean g()
  {
    AppMethodBeat.i(65218);
    String str = System.getProperty("java.vm.version");
    if ((str != null) && (str.startsWith("2")))
    {
      AppMethodBeat.o(65218);
      return true;
    }
    AppMethodBeat.o(65218);
    return false;
  }
  
  public final j.k a(String paramString)
  {
    AppMethodBeat.i(65213);
    j.k[] arrayOfk = this.i;
    int m = arrayOfk.length;
    int k = 0;
    while (k < m)
    {
      j.k localk = arrayOfk[k];
      if (paramString.equals(a(localk.g)))
      {
        AppMethodBeat.o(65213);
        return localk;
      }
      k += 1;
    }
    AppMethodBeat.o(65213);
    return null;
  }
  
  public final String a(int paramInt)
  {
    AppMethodBeat.i(65214);
    if (paramInt == 0)
    {
      AppMethodBeat.o(65214);
      return "SHN_UNDEF";
    }
    int k = paramInt;
    while (this.j[k] != 0) {
      k += 1;
    }
    String str = new String(this.j, paramInt, k - paramInt);
    AppMethodBeat.o(65214);
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
    AppMethodBeat.i(65215);
    this.g.close();
    AppMethodBeat.o(65215);
  }
  
  public final boolean d()
  {
    AppMethodBeat.i(65209);
    if (b() == '\002')
    {
      AppMethodBeat.o(65209);
      return true;
    }
    AppMethodBeat.o(65209);
    return false;
  }
  
  public final boolean e()
  {
    AppMethodBeat.i(65210);
    if (c() == '\001')
    {
      AppMethodBeat.o(65210);
      return true;
    }
    AppMethodBeat.o(65210);
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
  
  static class i
    extends j.l
  {
    long a;
    long b;
  }
  
  static abstract class j
  {
    int g;
    int h;
  }
  
  static abstract class l
  {
    int c;
    char d;
    char e;
    short f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.j
 * JD-Core Version:    0.7.0.1
 */