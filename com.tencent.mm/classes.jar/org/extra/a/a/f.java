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
  private final int NVS;
  private final FileChannel NVT;
  
  public f(File paramFile)
  {
    AppMethodBeat.i(220081);
    this.NVS = 1179403647;
    if ((paramFile == null) || (!paramFile.exists()))
    {
      paramFile = new IllegalArgumentException("File is null or does not exist");
      AppMethodBeat.o(220081);
      throw paramFile;
    }
    this.NVT = new FileInputStream(paramFile).getChannel();
    AppMethodBeat.o(220081);
  }
  
  private static long a(c.b paramb, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(220083);
    for (long l = 0L; l < paramLong1; l += 1L)
    {
      c.c localc = paramb.FN(l);
      if ((localc.dle == 1L) && (localc.NVO <= paramLong2) && (paramLong2 <= localc.NVO + localc.NVP))
      {
        paramLong1 = localc.NVO;
        l = localc.offset;
        AppMethodBeat.o(220083);
        return paramLong2 - paramLong1 + l;
      }
    }
    paramb = new IllegalStateException("Could not map vma to file offset!");
    AppMethodBeat.o(220083);
    throw paramb;
  }
  
  private void a(ByteBuffer paramByteBuffer, long paramLong, int paramInt)
  {
    AppMethodBeat.i(220090);
    paramByteBuffer.position(0);
    paramByteBuffer.limit(paramInt);
    int i;
    for (long l = 0L; l < paramInt; l += i)
    {
      i = this.NVT.read(paramByteBuffer, paramLong + l);
      if (i == -1)
      {
        paramByteBuffer = new EOFException();
        AppMethodBeat.o(220090);
        throw paramByteBuffer;
      }
    }
    paramByteBuffer.position(0);
    AppMethodBeat.o(220090);
  }
  
  private String c(ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(220085);
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = g(paramByteBuffer, paramLong);
      if (i == 0) {
        break;
      }
      localStringBuilder.append((char)i);
      paramLong = 1L + paramLong;
    }
    paramByteBuffer = localStringBuilder.toString();
    AppMethodBeat.o(220085);
    return paramByteBuffer;
  }
  
  private short g(ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(220089);
    a(paramByteBuffer, paramLong, 1);
    short s = (short)(paramByteBuffer.get() & 0xFF);
    AppMethodBeat.o(220089);
    return s;
  }
  
  public final void close()
  {
    AppMethodBeat.i(220084);
    this.NVT.close();
    AppMethodBeat.o(220084);
  }
  
  protected final long d(ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(220086);
    a(paramByteBuffer, paramLong, 8);
    paramLong = paramByteBuffer.getLong();
    AppMethodBeat.o(220086);
    return paramLong;
  }
  
  protected final long e(ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(220087);
    a(paramByteBuffer, paramLong, 4);
    paramLong = paramByteBuffer.getInt();
    AppMethodBeat.o(220087);
    return paramLong & 0xFFFFFFFF;
  }
  
  protected final int f(ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(220088);
    a(paramByteBuffer, paramLong, 2);
    int i = paramByteBuffer.getShort();
    AppMethodBeat.o(220088);
    return i & 0xFFFF;
  }
  
  public final List<String> gyn()
  {
    AppMethodBeat.i(220082);
    this.NVT.position(0L);
    ArrayList localArrayList = new ArrayList();
    this.NVT.position(0L);
    Object localObject1 = ByteBuffer.allocate(8);
    ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
    if (e((ByteBuffer)localObject1, 0L) != 1179403647L)
    {
      localObject1 = new IllegalArgumentException("Invalid ELF Magic!");
      AppMethodBeat.o(220082);
      throw ((Throwable)localObject1);
    }
    int i = g((ByteBuffer)localObject1, 4L);
    boolean bool;
    label122:
    ByteBuffer localByteBuffer;
    Object localObject2;
    label142:
    long l1;
    if (g((ByteBuffer)localObject1, 5L) == 2)
    {
      bool = true;
      if (i != 1) {
        break label244;
      }
      localObject1 = new d(bool, this);
      localByteBuffer = ByteBuffer.allocate(8);
      if (!((c.b)localObject1).NVG) {
        break label282;
      }
      localObject2 = ByteOrder.BIG_ENDIAN;
      localByteBuffer.order((ByteOrder)localObject2);
      l2 = ((c.b)localObject1).NVK;
      l1 = l2;
      if (l2 == 65535L) {
        l1 = ((c.b)localObject1).gym().NVQ;
      }
      l2 = 0L;
      label182:
      if (l2 >= l1) {
        break label491;
      }
      localObject2 = ((c.b)localObject1).FN(l2);
      if (((c.c)localObject2).dle != 2L) {
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
        AppMethodBeat.o(220082);
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
        AppMethodBeat.o(220082);
        throw ((Throwable)localObject1);
        localObject2 = ByteOrder.LITTLE_ENDIAN;
        break label142;
        l2 += 1L;
        break label182;
      }
      i = 0;
      localObject2 = new ArrayList();
      long l3 = 0L;
      c.a locala = ((c.b)localObject1).as(l2, i);
      long l4;
      if (locala.NVE == 1L)
      {
        ((List)localObject2).add(Long.valueOf(locala.NVF));
        l4 = l3;
      }
      for (;;)
      {
        i += 1;
        l3 = l4;
        if (locala.NVE != 0L) {
          break;
        }
        if (l4 != 0L) {
          break label423;
        }
        localObject1 = new IllegalStateException("String table offset not found!");
        AppMethodBeat.o(220082);
        throw ((Throwable)localObject1);
        l4 = l3;
        if (locala.NVE == 5L) {
          l4 = locala.NVF;
        }
      }
      l1 = a((c.b)localObject1, l1, l4);
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList.add(c(localByteBuffer, ((Long)((Iterator)localObject1).next()).longValue() + l1));
      }
      AppMethodBeat.o(220082);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.a.a.f
 * JD-Core Version:    0.7.0.1
 */