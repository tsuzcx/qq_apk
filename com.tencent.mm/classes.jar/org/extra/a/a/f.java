package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class f
  implements Closeable, c
{
  private final int ajYj;
  private final FileChannel ajYk;
  
  public f(File paramFile)
  {
    AppMethodBeat.i(187264);
    this.ajYj = 1179403647;
    if ((paramFile == null) || (!paramFile.exists()))
    {
      paramFile = new IllegalArgumentException("File is null or does not exist");
      AppMethodBeat.o(187264);
      throw paramFile;
    }
    this.ajYk = new FileInputStream(paramFile).getChannel();
    AppMethodBeat.o(187264);
  }
  
  private static long a(c.b paramb, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(187274);
    for (long l = 0L; l < paramLong1; l += 1L)
    {
      c.c localc = paramb.Co(l);
      if ((localc.beV == 1L) && (localc.ajYf <= paramLong2) && (paramLong2 <= localc.ajYf + localc.ajYg))
      {
        paramLong1 = localc.ajYf;
        l = localc.offset;
        AppMethodBeat.o(187274);
        return paramLong2 - paramLong1 + l;
      }
    }
    paramb = new IllegalStateException("Could not map vma to file offset!");
    AppMethodBeat.o(187274);
    throw paramb;
  }
  
  private void a(ByteBuffer paramByteBuffer, long paramLong, int paramInt)
  {
    AppMethodBeat.i(187297);
    paramByteBuffer.position(0);
    paramByteBuffer.limit(paramInt);
    int i;
    for (long l = 0L; l < paramInt; l += i)
    {
      i = this.ajYk.read(paramByteBuffer, paramLong + l);
      if (i == -1)
      {
        paramByteBuffer = new EOFException();
        AppMethodBeat.o(187297);
        throw paramByteBuffer;
      }
    }
    paramByteBuffer.position(0);
    AppMethodBeat.o(187297);
  }
  
  private String d(ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(187281);
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = h(paramByteBuffer, paramLong);
      if (i == 0) {
        break;
      }
      localStringBuilder.append((char)i);
      paramLong = 1L + paramLong;
    }
    paramByteBuffer = localStringBuilder.toString();
    AppMethodBeat.o(187281);
    return paramByteBuffer;
  }
  
  private short h(ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(187289);
    a(paramByteBuffer, paramLong, 1);
    short s = (short)(paramByteBuffer.get() & 0xFF);
    AppMethodBeat.o(187289);
    return s;
  }
  
  public final void close()
  {
    AppMethodBeat.i(187314);
    this.ajYk.close();
    AppMethodBeat.o(187314);
  }
  
  protected final long e(ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(187322);
    a(paramByteBuffer, paramLong, 8);
    paramLong = paramByteBuffer.getLong();
    AppMethodBeat.o(187322);
    return paramLong;
  }
  
  protected final long f(ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(187332);
    a(paramByteBuffer, paramLong, 4);
    paramLong = paramByteBuffer.getInt();
    AppMethodBeat.o(187332);
    return paramLong & 0xFFFFFFFF;
  }
  
  protected final int g(ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(187337);
    a(paramByteBuffer, paramLong, 2);
    int i = paramByteBuffer.getShort();
    AppMethodBeat.o(187337);
    return i & 0xFFFF;
  }
  
  public final List<String> kJA()
  {
    AppMethodBeat.i(187308);
    this.ajYk.position(0L);
    ArrayList localArrayList = new ArrayList();
    this.ajYk.position(0L);
    Object localObject1 = ByteBuffer.allocate(8);
    ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
    if (f((ByteBuffer)localObject1, 0L) != 1179403647L)
    {
      localObject1 = new IllegalArgumentException("Invalid ELF Magic!");
      AppMethodBeat.o(187308);
      throw ((Throwable)localObject1);
    }
    int i = h((ByteBuffer)localObject1, 4L);
    boolean bool;
    label122:
    ByteBuffer localByteBuffer;
    Object localObject2;
    label142:
    long l1;
    if (h((ByteBuffer)localObject1, 5L) == 2)
    {
      bool = true;
      if (i != 1) {
        break label244;
      }
      localObject1 = new d(bool, this);
      localByteBuffer = ByteBuffer.allocate(8);
      if (!((c.b)localObject1).ajXX) {
        break label282;
      }
      localObject2 = ByteOrder.BIG_ENDIAN;
      localByteBuffer.order((ByteOrder)localObject2);
      l2 = ((c.b)localObject1).ajYb;
      l1 = l2;
      if (l2 == 65535L) {
        l1 = ((c.b)localObject1).kJz().ajYh;
      }
      l2 = 0L;
      label182:
      if (l2 >= l1) {
        break label491;
      }
      localObject2 = ((c.b)localObject1).Co(l2);
      if (((c.c)localObject2).beV != 2L) {
        break label290;
      }
    }
    label282:
    label290:
    label423:
    label491:
    for (long l2 = ((c.c)localObject2).offset;; l2 = 0L)
    {
      if (l2 == 0L)
      {
        localObject1 = Collections.unmodifiableList(localArrayList);
        AppMethodBeat.o(187308);
        return localObject1;
        bool = false;
        break;
        label244:
        if (i == 2)
        {
          localObject1 = new e(bool, this);
          break label122;
        }
        localObject1 = new IllegalStateException("Invalid class type!");
        AppMethodBeat.o(187308);
        throw ((Throwable)localObject1);
        localObject2 = ByteOrder.LITTLE_ENDIAN;
        break label142;
        l2 += 1L;
        break label182;
      }
      i = 0;
      localObject2 = new ArrayList();
      long l3 = 0L;
      c.a locala = ((c.b)localObject1).aW(l2, i);
      long l4;
      if (locala.tag == 1L)
      {
        ((List)localObject2).add(Long.valueOf(locala.ajXW));
        l4 = l3;
      }
      for (;;)
      {
        i += 1;
        l3 = l4;
        if (locala.tag != 0L) {
          break;
        }
        if (l4 != 0L) {
          break label423;
        }
        localObject1 = new IllegalStateException("String table offset not found!");
        AppMethodBeat.o(187308);
        throw ((Throwable)localObject1);
        l4 = l3;
        if (locala.tag == 5L) {
          l4 = locala.ajXW;
        }
      }
      l1 = a((c.b)localObject1, l1, l4);
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList.add(d(localByteBuffer, ((Long)((Iterator)localObject1).next()).longValue() + l1));
      }
      AppMethodBeat.o(187308);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     org.extra.a.a.f
 * JD-Core Version:    0.7.0.1
 */