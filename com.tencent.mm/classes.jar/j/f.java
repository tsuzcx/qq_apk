package j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.a.a;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.n.d;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "()V", "buffer", "getBuffer", "()Lokio/Buffer;", "head", "Lokio/Segment;", "<set-?>", "", "size", "()J", "setSize$okio", "(J)V", "clear", "", "clone", "close", "completeSegmentByteCount", "copy", "copyTo", "out", "Ljava/io/OutputStream;", "offset", "byteCount", "digest", "Lokio/ByteString;", "algorithm", "", "emit", "emitCompleteSegments", "equals", "", "other", "", "exhausted", "flush", "get", "", "pos", "getByte", "index", "-deprecated_getByte", "hashCode", "", "hmac", "key", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "md5", "outputStream", "peek", "rangeEquals", "bytesOffset", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readAndWriteUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFrom", "input", "forever", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "charset", "Ljava/nio/charset/Charset;", "readUnsafe", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "sha1", "sha256", "sha512", "-deprecated_size", "skip", "snapshot", "timeout", "Lokio/Timeout;", "toString", "writableSegment", "minimumCapacity", "writableSegment$okio", "write", "source", "byteString", "Lokio/Source;", "writeAll", "writeByte", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "beginIndex", "endIndex", "writeTo", "writeUtf8", "writeUtf8CodePoint", "codePoint", "UnsafeCursor", "okio"}, k=1, mv={1, 4, 1})
public final class f
  implements g, h, Cloneable, ByteChannel
{
  public v ajTb;
  public long size;
  
  private String a(long paramLong, Charset paramCharset)
  {
    AppMethodBeat.i(186366);
    kotlin.g.b.s.u(paramCharset, "charset");
    if ((paramLong >= 0L) && (paramLong <= 2147483647L)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramCharset = (Throwable)new IllegalArgumentException("byteCount: ".concat(String.valueOf(paramLong)).toString());
      AppMethodBeat.o(186366);
      throw paramCharset;
    }
    if (this.size < paramLong)
    {
      paramCharset = (Throwable)new EOFException();
      AppMethodBeat.o(186366);
      throw paramCharset;
    }
    if (paramLong == 0L)
    {
      AppMethodBeat.o(186366);
      return "";
    }
    v localv = this.ajTb;
    kotlin.g.b.s.checkNotNull(localv);
    if (localv.pos + paramLong > localv.limit)
    {
      paramCharset = new String(Ch(paramLong), paramCharset);
      AppMethodBeat.o(186366);
      return paramCharset;
    }
    paramCharset = new String(localv.data, localv.pos, (int)paramLong, paramCharset);
    localv.pos += (int)paramLong;
    this.size -= paramLong;
    if (localv.pos == localv.limit)
    {
      this.ajTb = localv.kJa();
      w.b(localv);
    }
    AppMethodBeat.o(186366);
    return paramCharset;
  }
  
  private i aNn(int paramInt)
  {
    AppMethodBeat.i(186372);
    if (paramInt == 0)
    {
      localObject = i.ajTe;
      AppMethodBeat.o(186372);
      return localObject;
    }
    c.C(this.size, 0L, paramInt);
    Object localObject = this.ajTb;
    int i = 0;
    int j = 0;
    while (j < paramInt)
    {
      kotlin.g.b.s.checkNotNull(localObject);
      if (((v)localObject).limit == ((v)localObject).pos)
      {
        localObject = (Throwable)new AssertionError("s.limit == s.pos");
        AppMethodBeat.o(186372);
        throw ((Throwable)localObject);
      }
      j += ((v)localObject).limit - ((v)localObject).pos;
      localObject = ((v)localObject).ajTx;
      i += 1;
    }
    byte[][] arrayOfByte = new byte[i][];
    int[] arrayOfInt = new int[i * 2];
    localObject = this.ajTb;
    i = 0;
    j = 0;
    while (j < paramInt)
    {
      kotlin.g.b.s.checkNotNull(localObject);
      arrayOfByte[i] = ((v)localObject).data;
      j += ((v)localObject).limit - ((v)localObject).pos;
      arrayOfInt[i] = Math.min(j, paramInt);
      arrayOfInt[(((Object[])arrayOfByte).length + i)] = ((v)localObject).pos;
      ((v)localObject).ajwa = true;
      i += 1;
      localObject = ((v)localObject).ajTx;
    }
    localObject = (i)new x((byte[][])arrayOfByte, arrayOfInt);
    AppMethodBeat.o(186372);
    return localObject;
  }
  
  public final void Cc(long paramLong)
  {
    AppMethodBeat.i(186385);
    if (this.size < paramLong)
    {
      Throwable localThrowable = (Throwable)new EOFException();
      AppMethodBeat.o(186385);
      throw localThrowable;
    }
    AppMethodBeat.o(186385);
  }
  
  public final boolean Cd(long paramLong)
  {
    return this.size >= paramLong;
  }
  
  public final i Ce(long paramLong)
  {
    AppMethodBeat.i(186460);
    if ((paramLong >= 0L) && (paramLong <= 2147483647L)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalArgumentException("byteCount: ".concat(String.valueOf(paramLong)).toString());
      AppMethodBeat.o(186460);
      throw ((Throwable)localObject);
    }
    if (this.size < paramLong)
    {
      localObject = (Throwable)new EOFException();
      AppMethodBeat.o(186460);
      throw ((Throwable)localObject);
    }
    if (paramLong >= 4096L)
    {
      localObject = aNn((int)paramLong);
      Ci(paramLong);
      AppMethodBeat.o(186460);
      return localObject;
    }
    Object localObject = new i(Ch(paramLong));
    AppMethodBeat.o(186460);
    return localObject;
  }
  
  public final String Cf(long paramLong)
  {
    AppMethodBeat.i(186467);
    String str = a(paramLong, d.UTF_8);
    AppMethodBeat.o(186467);
    return str;
  }
  
  public final String Cg(long paramLong)
  {
    AppMethodBeat.i(186470);
    if (paramLong >= 0L) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalArgumentException("limit < 0: ".concat(String.valueOf(paramLong)).toString());
      AppMethodBeat.o(186470);
      throw ((Throwable)localObject);
    }
    if (paramLong == 9223372036854775807L) {}
    for (long l1 = 9223372036854775807L;; l1 = paramLong + 1L)
    {
      long l2 = a((byte)10, 0L, l1);
      if (l2 == -1L) {
        break;
      }
      localObject = a.d(this, l2);
      AppMethodBeat.o(186470);
      return localObject;
    }
    if ((l1 < this.size) && (de(l1 - 1L) == 13) && (de(l1) == 10))
    {
      localObject = a.d(this, l1);
      AppMethodBeat.o(186470);
      return localObject;
    }
    Object localObject = new f();
    a((f)localObject, 0L, Math.min(32L, this.size));
    localObject = (Throwable)new EOFException("\\n not found: limit=" + Math.min(this.size, paramLong) + " content=" + ((f)localObject).kHM().kIL() + '…');
    AppMethodBeat.o(186470);
    throw ((Throwable)localObject);
  }
  
  public final byte[] Ch(long paramLong)
  {
    AppMethodBeat.i(186474);
    if ((paramLong >= 0L) && (paramLong <= 2147483647L)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalArgumentException("byteCount: ".concat(String.valueOf(paramLong)).toString());
      AppMethodBeat.o(186474);
      throw ((Throwable)localObject);
    }
    if (this.size < paramLong)
    {
      localObject = (Throwable)new EOFException();
      AppMethodBeat.o(186474);
      throw ((Throwable)localObject);
    }
    Object localObject = new byte[(int)paramLong];
    readFully((byte[])localObject);
    AppMethodBeat.o(186474);
    return localObject;
  }
  
  public final void Ci(long paramLong)
  {
    AppMethodBeat.i(186479);
    while (paramLong > 0L)
    {
      Object localObject = this.ajTb;
      if (localObject == null)
      {
        localObject = (Throwable)new EOFException();
        AppMethodBeat.o(186479);
        throw ((Throwable)localObject);
      }
      int i = (int)Math.min(paramLong, ((v)localObject).limit - ((v)localObject).pos);
      this.size -= i;
      long l = paramLong - i;
      ((v)localObject).pos = (i + ((v)localObject).pos);
      paramLong = l;
      if (((v)localObject).pos == ((v)localObject).limit)
      {
        this.ajTb = ((v)localObject).kJa();
        w.b((v)localObject);
        paramLong = l;
      }
    }
    AppMethodBeat.o(186479);
  }
  
  public final f Cj(long paramLong)
  {
    AppMethodBeat.i(186520);
    Object localObject;
    if (paramLong == 0L)
    {
      localObject = aNg(48);
      AppMethodBeat.o(186520);
      return localObject;
    }
    if (paramLong < 0L)
    {
      paramLong = -paramLong;
      if (paramLong < 0L)
      {
        localObject = bKQ("-9223372036854775808");
        AppMethodBeat.o(186520);
        return localObject;
      }
    }
    for (int j = 1;; j = 0)
    {
      int i;
      if (paramLong < 100000000L) {
        if (paramLong < 10000L) {
          if (paramLong < 100L) {
            if (paramLong < 10L) {
              i = 1;
            }
          }
        }
      }
      int k;
      byte[] arrayOfByte;
      for (;;)
      {
        k = i;
        if (j != 0) {
          k = i + 1;
        }
        localObject = aNm(k);
        arrayOfByte = ((v)localObject).data;
        i = ((v)localObject).limit + k;
        while (paramLong != 0L)
        {
          int m = (int)(paramLong % 10L);
          i -= 1;
          arrayOfByte[i] = a.kJe()[m];
          paramLong /= 10L;
        }
        i = 2;
        continue;
        if (paramLong < 1000L)
        {
          i = 3;
        }
        else
        {
          i = 4;
          continue;
          if (paramLong < 1000000L)
          {
            if (paramLong < 100000L) {
              i = 5;
            } else {
              i = 6;
            }
          }
          else if (paramLong < 10000000L)
          {
            i = 7;
          }
          else
          {
            i = 8;
            continue;
            if (paramLong < 1000000000000L)
            {
              if (paramLong < 10000000000L)
              {
                if (paramLong < 1000000000L) {
                  i = 9;
                } else {
                  i = 10;
                }
              }
              else if (paramLong < 100000000000L) {
                i = 11;
              } else {
                i = 12;
              }
            }
            else if (paramLong < 1000000000000000L)
            {
              if (paramLong < 10000000000000L) {
                i = 13;
              } else if (paramLong < 100000000000000L) {
                i = 14;
              } else {
                i = 15;
              }
            }
            else if (paramLong < 100000000000000000L)
            {
              if (paramLong < 10000000000000000L) {
                i = 16;
              } else {
                i = 17;
              }
            }
            else if (paramLong < 1000000000000000000L) {
              i = 18;
            } else {
              i = 19;
            }
          }
        }
      }
      if (j != 0) {
        arrayOfByte[(i - 1)] = 45;
      }
      ((v)localObject).limit += k;
      paramLong = this.size;
      this.size = (k + paramLong);
      AppMethodBeat.o(186520);
      return this;
    }
  }
  
  public final f Cl(long paramLong)
  {
    AppMethodBeat.i(186523);
    if (paramLong == 0L)
    {
      localObject = aNg(48);
      AppMethodBeat.o(186523);
      return localObject;
    }
    long l = paramLong >>> 1 | paramLong;
    l |= l >>> 2;
    l |= l >>> 4;
    l |= l >>> 8;
    l |= l >>> 16;
    l |= l >>> 32;
    l -= (l >>> 1 & 0x55555555);
    l = (l & 0x33333333) + (l >>> 2 & 0x33333333);
    l = l + (l >>> 4) & 0xF0F0F0F;
    l += (l >>> 8);
    l += (l >>> 16);
    int j = (int)(((l >>> 32 & 0x3F) + (0x3F & l) + 3L) / 4L);
    Object localObject = aNm(j);
    byte[] arrayOfByte = ((v)localObject).data;
    int i = ((v)localObject).limit + j - 1;
    int k = ((v)localObject).limit;
    while (i >= k)
    {
      arrayOfByte[i] = a.kJe()[((int)(0xF & paramLong))];
      paramLong >>>= 4;
      i -= 1;
    }
    ((v)localObject).limit += j;
    paramLong = this.size;
    this.size = (j + paramLong);
    AppMethodBeat.o(186523);
    return this;
  }
  
  public final byte[] Ml()
  {
    AppMethodBeat.i(186473);
    byte[] arrayOfByte = Ch(this.size);
    AppMethodBeat.o(186473);
    return arrayOfByte;
  }
  
  public final long a(byte paramByte, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(186528);
    if (0L > paramLong1) {}
    Object localObject;
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        break label98;
      }
      localObject = (Throwable)new IllegalArgumentException(("size=" + this.size + " fromIndex=" + paramLong1 + " toIndex=" + paramLong2).toString());
      AppMethodBeat.o(186528);
      throw ((Throwable)localObject);
      if (paramLong2 < paramLong1) {
        break;
      }
    }
    label98:
    long l1 = paramLong2;
    if (paramLong2 > this.size) {
      l1 = this.size;
    }
    if (paramLong1 != l1)
    {
      localObject = this.ajTb;
      if (localObject != null) {
        break label146;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(186528);
      return -1L;
      label146:
      byte[] arrayOfByte;
      int j;
      if (this.size - paramLong1 < paramLong1)
      {
        for (paramLong2 = this.size; paramLong2 > paramLong1; paramLong2 -= ((v)localObject).limit - ((v)localObject).pos)
        {
          localObject = ((v)localObject).ajTy;
          kotlin.g.b.s.checkNotNull(localObject);
        }
        if (localObject != null)
        {
          while (paramLong2 < l1)
          {
            arrayOfByte = ((v)localObject).data;
            j = (int)Math.min(((v)localObject).limit, ((v)localObject).pos + l1 - paramLong2);
            i = (int)(((v)localObject).pos + paramLong1 - paramLong2);
            while (i < j)
            {
              if (arrayOfByte[i] == paramByte)
              {
                paramLong1 = i - ((v)localObject).pos;
                AppMethodBeat.o(186528);
                return paramLong2 + paramLong1;
              }
              i += 1;
            }
            paramLong1 = ((v)localObject).limit - ((v)localObject).pos + paramLong2;
            localObject = ((v)localObject).ajTx;
            kotlin.g.b.s.checkNotNull(localObject);
            paramLong2 = paramLong1;
          }
          AppMethodBeat.o(186528);
          return -1L;
        }
      }
      else
      {
        long l2;
        for (paramLong2 = 0L;; paramLong2 = l2)
        {
          l2 = ((v)localObject).limit - ((v)localObject).pos + paramLong2;
          if (l2 > paramLong1) {
            break;
          }
          localObject = ((v)localObject).ajTx;
          kotlin.g.b.s.checkNotNull(localObject);
        }
        if (localObject != null) {
          while (paramLong2 < l1)
          {
            arrayOfByte = ((v)localObject).data;
            j = (int)Math.min(((v)localObject).limit, ((v)localObject).pos + l1 - paramLong2);
            i = (int)(((v)localObject).pos + paramLong1 - paramLong2);
            while (i < j)
            {
              if (arrayOfByte[i] == paramByte)
              {
                paramLong1 = i - ((v)localObject).pos;
                AppMethodBeat.o(186528);
                return paramLong2 + paramLong1;
              }
              i += 1;
            }
            paramLong1 = ((v)localObject).limit - ((v)localObject).pos + paramLong2;
            localObject = ((v)localObject).ajTx;
            kotlin.g.b.s.checkNotNull(localObject);
            paramLong2 = paramLong1;
          }
        }
      }
    }
  }
  
  public final long a(aa paramaa)
  {
    AppMethodBeat.i(186500);
    kotlin.g.b.s.u(paramaa, "source");
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = paramaa.a(this, 8192L);
      if (l2 == -1L) {
        break;
      }
    }
    AppMethodBeat.o(186500);
    return l1;
  }
  
  public final long a(f paramf, long paramLong)
  {
    AppMethodBeat.i(186527);
    kotlin.g.b.s.u(paramf, "sink");
    if (paramLong >= 0L) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramf = (Throwable)new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)).toString());
      AppMethodBeat.o(186527);
      throw paramf;
    }
    if (this.size == 0L)
    {
      AppMethodBeat.o(186527);
      return -1L;
    }
    long l = paramLong;
    if (paramLong > this.size) {
      l = this.size;
    }
    paramf.b(this, l);
    AppMethodBeat.o(186527);
    return l;
  }
  
  public final long a(y paramy)
  {
    AppMethodBeat.i(186464);
    kotlin.g.b.s.u(paramy, "sink");
    long l = this.size;
    if (l > 0L) {
      paramy.b(this, l);
    }
    AppMethodBeat.o(186464);
    return l;
  }
  
  public final f a(f paramf, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(186403);
    kotlin.g.b.s.u(paramf, "out");
    c.C(this.size, paramLong1, paramLong2);
    if (paramLong2 != 0L)
    {
      paramf.size += paramLong2;
      v localv2;
      long l1;
      long l2;
      for (v localv1 = this.ajTb;; localv1 = localv1.ajTx)
      {
        kotlin.g.b.s.checkNotNull(localv1);
        localv2 = localv1;
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramLong1 < localv1.limit - localv1.pos) {
          break;
        }
        paramLong1 -= localv1.limit - localv1.pos;
      }
      if (l2 > 0L)
      {
        kotlin.g.b.s.checkNotNull(localv2);
        localv1 = localv2.kIZ();
        localv1.pos += (int)l1;
        localv1.limit = Math.min(localv1.pos + (int)l2, localv1.limit);
        if (paramf.ajTb == null)
        {
          localv1.ajTy = localv1;
          localv1.ajTx = localv1.ajTy;
          paramf.ajTb = localv1.ajTx;
        }
        for (;;)
        {
          l2 -= localv1.limit - localv1.pos;
          localv2 = localv2.ajTx;
          l1 = 0L;
          break;
          v localv3 = paramf.ajTb;
          kotlin.g.b.s.checkNotNull(localv3);
          localv3 = localv3.ajTy;
          kotlin.g.b.s.checkNotNull(localv3);
          localv3.a(localv1);
        }
      }
    }
    AppMethodBeat.o(186403);
    return this;
  }
  
  public final f aNf(int paramInt)
  {
    AppMethodBeat.i(186484);
    if (paramInt < 128) {
      aNg(paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(186484);
      return this;
      if (paramInt < 2048)
      {
        localObject = aNm(2);
        ((v)localObject).data[localObject.limit] = ((byte)(paramInt >> 6 | 0xC0));
        ((v)localObject).data[(localObject.limit + 1)] = ((byte)(paramInt & 0x3F | 0x80));
        ((v)localObject).limit += 2;
        this.size += 2L;
      }
      else
      {
        if (55296 > paramInt) {}
        for (;;)
        {
          if (paramInt < 65536)
          {
            localObject = aNm(3);
            ((v)localObject).data[localObject.limit] = ((byte)(paramInt >> 12 | 0xE0));
            ((v)localObject).data[(localObject.limit + 1)] = ((byte)(paramInt >> 6 & 0x3F | 0x80));
            ((v)localObject).data[(localObject.limit + 2)] = ((byte)(paramInt & 0x3F | 0x80));
            ((v)localObject).limit += 3;
            this.size += 3L;
            break;
            if (57343 >= paramInt)
            {
              aNg(63);
              break;
            }
          }
        }
        if (paramInt > 1114111) {
          break;
        }
        localObject = aNm(4);
        ((v)localObject).data[localObject.limit] = ((byte)(paramInt >> 18 | 0xF0));
        ((v)localObject).data[(localObject.limit + 1)] = ((byte)(paramInt >> 12 & 0x3F | 0x80));
        ((v)localObject).data[(localObject.limit + 2)] = ((byte)(paramInt >> 6 & 0x3F | 0x80));
        ((v)localObject).data[(localObject.limit + 3)] = ((byte)(paramInt & 0x3F | 0x80));
        ((v)localObject).limit += 4;
        this.size += 4L;
      }
    }
    Object localObject = (Throwable)new IllegalArgumentException("Unexpected code point: 0x" + c.Lx(paramInt));
    AppMethodBeat.o(186484);
    throw ((Throwable)localObject);
  }
  
  public final f aNg(int paramInt)
  {
    AppMethodBeat.i(186501);
    v localv = aNm(1);
    byte[] arrayOfByte = localv.data;
    int i = localv.limit;
    localv.limit = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    this.size += 1L;
    AppMethodBeat.o(186501);
    return this;
  }
  
  public final f aNi(int paramInt)
  {
    AppMethodBeat.i(186505);
    v localv = aNm(2);
    byte[] arrayOfByte = localv.data;
    int i = localv.limit;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    localv.limit = (j + 1);
    this.size += 2L;
    AppMethodBeat.o(186505);
    return this;
  }
  
  public final f aNk(int paramInt)
  {
    AppMethodBeat.i(186515);
    v localv = aNm(4);
    byte[] arrayOfByte = localv.data;
    int j = localv.limit;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    localv.limit = (i + 1);
    this.size += 4L;
    AppMethodBeat.o(186515);
    return this;
  }
  
  public final v aNm(int paramInt)
  {
    AppMethodBeat.i(186525);
    if ((paramInt > 0) && (paramInt <= 8192)) {}
    Object localObject;
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalArgumentException("unexpected capacity".toString());
      AppMethodBeat.o(186525);
      throw ((Throwable)localObject);
    }
    if (this.ajTb == null)
    {
      localObject = w.kJb();
      this.ajTb = ((v)localObject);
      ((v)localObject).ajTy = ((v)localObject);
      ((v)localObject).ajTx = ((v)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(186525);
      return localObject;
      localObject = this.ajTb;
      kotlin.g.b.s.checkNotNull(localObject);
      v localv = ((v)localObject).ajTy;
      kotlin.g.b.s.checkNotNull(localv);
      if (localv.limit + paramInt <= 8192)
      {
        localObject = localv;
        if (localv.ajTw) {}
      }
      else
      {
        localObject = localv.a(w.kJb());
      }
    }
  }
  
  public final f ai(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186487);
    kotlin.g.b.s.u(paramArrayOfByte, "source");
    c.C(paramArrayOfByte.length, paramInt1, paramInt2);
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      v localv = aNm(1);
      int j = Math.min(i - paramInt1, 8192 - localv.limit);
      k.a(paramArrayOfByte, localv.data, localv.limit, paramInt1, paramInt1 + j);
      paramInt1 += j;
      localv.limit = (j + localv.limit);
    }
    this.size += paramInt2;
    AppMethodBeat.o(186487);
    return this;
  }
  
  public final void b(f paramf, long paramLong)
  {
    AppMethodBeat.i(186526);
    kotlin.g.b.s.u(paramf, "source");
    if (paramf != this) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramf = (Throwable)new IllegalArgumentException("source == this".toString());
      AppMethodBeat.o(186526);
      throw paramf;
    }
    c.C(paramf.size, 0L, paramLong);
    if (paramLong > 0L)
    {
      v localv1 = paramf.ajTb;
      kotlin.g.b.s.checkNotNull(localv1);
      i = localv1.limit;
      localv1 = paramf.ajTb;
      kotlin.g.b.s.checkNotNull(localv1);
      long l;
      v localv2;
      label240:
      label250:
      int j;
      if (paramLong < i - localv1.pos)
      {
        if (this.ajTb != null)
        {
          localv1 = this.ajTb;
          kotlin.g.b.s.checkNotNull(localv1);
          localv1 = localv1.ajTy;
          if ((localv1 == null) || (!localv1.ajTw)) {
            break label250;
          }
          l = localv1.limit;
          if (!localv1.ajwa) {
            break label240;
          }
        }
        for (i = 0;; i = localv1.pos)
        {
          if (l + paramLong - i > 8192L) {
            break label250;
          }
          localv2 = paramf.ajTb;
          kotlin.g.b.s.checkNotNull(localv2);
          localv2.a(localv1, (int)paramLong);
          paramf.size -= paramLong;
          this.size += paramLong;
          AppMethodBeat.o(186526);
          return;
          localv1 = null;
          break;
        }
        localv2 = paramf.ajTb;
        kotlin.g.b.s.checkNotNull(localv2);
        j = (int)paramLong;
        if ((j > 0) && (j <= localv2.limit - localv2.pos)) {}
        for (i = 1; i == 0; i = 0)
        {
          paramf = (Throwable)new IllegalArgumentException("byteCount out of range".toString());
          AppMethodBeat.o(186526);
          throw paramf;
        }
        if (j >= 1024)
        {
          localv1 = localv2.kIZ();
          label340:
          localv1.limit = (localv1.pos + j);
          localv2.pos = (j + localv2.pos);
          localv2 = localv2.ajTy;
          kotlin.g.b.s.checkNotNull(localv2);
          localv2.a(localv1);
          paramf.ajTb = localv1;
        }
      }
      else
      {
        localv1 = paramf.ajTb;
        kotlin.g.b.s.checkNotNull(localv1);
        l = localv1.limit - localv1.pos;
        paramf.ajTb = localv1.kJa();
        if (this.ajTb != null) {
          break label521;
        }
        this.ajTb = localv1;
        localv1.ajTy = localv1;
        localv1.ajTx = localv1.ajTy;
      }
      label521:
      label749:
      for (;;)
      {
        paramf.size -= l;
        this.size += l;
        paramLong -= l;
        break;
        localv1 = w.kJb();
        k.b(localv2.data, localv1.data, localv2.pos, localv2.pos + j);
        break label340;
        localv2 = this.ajTb;
        kotlin.g.b.s.checkNotNull(localv2);
        localv2 = localv2.ajTy;
        kotlin.g.b.s.checkNotNull(localv2);
        localv1 = localv2.a(localv1);
        if (localv1.ajTy != (v)localv1) {}
        for (i = 1; i == 0; i = 0)
        {
          paramf = (Throwable)new IllegalStateException("cannot compact".toString());
          AppMethodBeat.o(186526);
          throw paramf;
        }
        localv2 = localv1.ajTy;
        kotlin.g.b.s.checkNotNull(localv2);
        if (localv2.ajTw)
        {
          j = localv1.limit - localv1.pos;
          localv2 = localv1.ajTy;
          kotlin.g.b.s.checkNotNull(localv2);
          int k = localv2.limit;
          localv2 = localv1.ajTy;
          kotlin.g.b.s.checkNotNull(localv2);
          if (localv2.ajwa) {}
          for (i = 0;; i = localv2.pos)
          {
            if (j > i + (8192 - k)) {
              break label749;
            }
            localv2 = localv1.ajTy;
            kotlin.g.b.s.checkNotNull(localv2);
            localv1.a(localv2, j);
            localv1.kJa();
            w.b(localv1);
            break;
            localv2 = localv1.ajTy;
            kotlin.g.b.s.checkNotNull(localv2);
          }
        }
      }
    }
    AppMethodBeat.o(186526);
  }
  
  public final f bB(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186483);
    kotlin.g.b.s.u(paramString, "string");
    if (paramInt1 >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString = (Throwable)new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(paramInt1)).toString());
      AppMethodBeat.o(186483);
      throw paramString;
    }
    if (paramInt2 >= paramInt1) {}
    for (i = 1; i == 0; i = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("endIndex < beginIndex: " + paramInt2 + " < " + paramInt1).toString());
      AppMethodBeat.o(186483);
      throw paramString;
    }
    if (paramInt2 <= paramString.length()) {
      i = 1;
    }
    int k;
    v localv;
    while (i == 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("endIndex > string.length: " + paramInt2 + " > " + paramString.length()).toString());
      AppMethodBeat.o(186483);
      throw paramString;
      i = 0;
      continue;
      i = paramInt1 + k - localv.limit;
      localv.limit += i;
      this.size += i;
    }
    for (;;)
    {
      if (paramInt1 >= paramInt2) {
        break label783;
      }
      int j = paramString.charAt(paramInt1);
      if (j < 128)
      {
        localv = aNm(1);
        byte[] arrayOfByte = localv.data;
        k = localv.limit - paramInt1;
        int m = Math.min(paramInt2, 8192 - k);
        i = paramInt1 + 1;
        arrayOfByte[(k + paramInt1)] = ((byte)j);
        paramInt1 = i;
        for (;;)
        {
          if (paramInt1 >= m) {
            break label351;
          }
          i = paramString.charAt(paramInt1);
          if (i >= 128) {
            break;
          }
          arrayOfByte[(paramInt1 + k)] = ((byte)i);
          paramInt1 += 1;
        }
        label351:
        break;
      }
      if (j < 2048)
      {
        localv = aNm(2);
        localv.data[localv.limit] = ((byte)(j >> 6 | 0xC0));
        localv.data[(localv.limit + 1)] = ((byte)(j & 0x3F | 0x80));
        localv.limit += 2;
        this.size += 2L;
        paramInt1 += 1;
      }
      else if ((j < 55296) || (j > 57343))
      {
        localv = aNm(3);
        localv.data[localv.limit] = ((byte)(j >> 12 | 0xE0));
        localv.data[(localv.limit + 1)] = ((byte)(j >> 6 & 0x3F | 0x80));
        localv.data[(localv.limit + 2)] = ((byte)(j & 0x3F | 0x80));
        localv.limit += 3;
        this.size += 3L;
        paramInt1 += 1;
      }
      else
      {
        if (paramInt1 + 1 < paramInt2) {}
        for (i = paramString.charAt(paramInt1 + 1);; i = 0)
        {
          if ((j <= 56319) && (56320 <= i) && (57343 >= i)) {
            break label627;
          }
          aNg(63);
          paramInt1 += 1;
          break;
        }
        label627:
        i = (i & 0x3FF | (j & 0x3FF) << 10) + 65536;
        localv = aNm(4);
        localv.data[localv.limit] = ((byte)(i >> 18 | 0xF0));
        localv.data[(localv.limit + 1)] = ((byte)(i >> 12 & 0x3F | 0x80));
        localv.data[(localv.limit + 2)] = ((byte)(i >> 6 & 0x3F | 0x80));
        localv.data[(localv.limit + 3)] = ((byte)(i & 0x3F | 0x80));
        localv.limit += 4;
        this.size += 4L;
        paramInt1 += 2;
      }
    }
    label783:
    AppMethodBeat.o(186483);
    return this;
  }
  
  public final f bKQ(String paramString)
  {
    AppMethodBeat.i(186481);
    kotlin.g.b.s.u(paramString, "string");
    paramString = bB(paramString, 0, paramString.length());
    AppMethodBeat.o(186481);
    return paramString;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(186478);
    Ci(this.size);
    AppMethodBeat.o(186478);
  }
  
  public final void close() {}
  
  public final f d(i parami)
  {
    AppMethodBeat.i(186480);
    kotlin.g.b.s.u(parami, "byteString");
    parami.a(this, parami.kIN());
    AppMethodBeat.o(186480);
    return this;
  }
  
  public final byte de(long paramLong)
  {
    AppMethodBeat.i(186418);
    c.C(this.size, paramLong, 1L);
    v localv = this.ajTb;
    if (localv == null)
    {
      kotlin.g.b.s.checkNotNull(null);
      throw new NullPointerException();
    }
    if (this.size - paramLong < paramLong)
    {
      for (l1 = this.size; l1 > paramLong; l1 -= localv.limit - localv.pos)
      {
        localv = localv.ajTy;
        kotlin.g.b.s.checkNotNull(localv);
      }
      kotlin.g.b.s.checkNotNull(localv);
      b = localv.data[((int)(localv.pos + paramLong - l1))];
      AppMethodBeat.o(186418);
      return b;
    }
    long l2;
    for (long l1 = 0L;; l1 = l2)
    {
      l2 = localv.limit - localv.pos + l1;
      if (l2 > paramLong) {
        break;
      }
      localv = localv.ajTx;
      kotlin.g.b.s.checkNotNull(localv);
    }
    kotlin.g.b.s.checkNotNull(localv);
    byte b = localv.data[((int)(localv.pos + paramLong - l1))];
    AppMethodBeat.o(186418);
    return b;
  }
  
  public final f ed(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186485);
    kotlin.g.b.s.u(paramArrayOfByte, "source");
    paramArrayOfByte = ai(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(186485);
    return paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(186530);
    if (this != paramObject)
    {
      if (!(paramObject instanceof f))
      {
        AppMethodBeat.o(186530);
        return false;
      }
      if (this.size != ((f)paramObject).size)
      {
        AppMethodBeat.o(186530);
        return false;
      }
      if (this.size != 0L)
      {
        Object localObject2 = this.ajTb;
        kotlin.g.b.s.checkNotNull(localObject2);
        paramObject = ((f)paramObject).ajTb;
        kotlin.g.b.s.checkNotNull(paramObject);
        int j = ((v)localObject2).pos;
        int i = paramObject.pos;
        long l1 = 0L;
        while (l1 < this.size)
        {
          long l3 = Math.min(((v)localObject2).limit - j, paramObject.limit - i);
          long l2 = 0L;
          int k = j;
          while (l2 < l3)
          {
            if (localObject2.data[k] != paramObject.data[i])
            {
              AppMethodBeat.o(186530);
              return false;
            }
            l2 += 1L;
            i += 1;
            k += 1;
          }
          j = k;
          Object localObject1 = localObject2;
          if (k == ((v)localObject2).limit)
          {
            localObject1 = ((v)localObject2).ajTx;
            kotlin.g.b.s.checkNotNull(localObject1);
            j = ((v)localObject1).pos;
          }
          k = i;
          Object localObject3 = paramObject;
          if (i == paramObject.limit)
          {
            localObject3 = paramObject.ajTx;
            kotlin.g.b.s.checkNotNull(localObject3);
            k = ((v)localObject3).pos;
          }
          l1 += l3;
          i = k;
          localObject2 = localObject1;
          paramObject = localObject3;
        }
      }
    }
    AppMethodBeat.o(186530);
    return true;
  }
  
  public final void flush() {}
  
  public final int hashCode()
  {
    AppMethodBeat.i(186531);
    Object localObject = this.ajTb;
    if (localObject == null)
    {
      AppMethodBeat.o(186531);
      return 0;
    }
    int i = 1;
    int j;
    v localv;
    do
    {
      int k = ((v)localObject).pos;
      int m = ((v)localObject).limit;
      j = i;
      while (k < m)
      {
        j = j * 31 + localObject.data[k];
        k += 1;
      }
      localv = ((v)localObject).ajTx;
      kotlin.g.b.s.checkNotNull(localv);
      i = j;
      localObject = localv;
    } while (localv != this.ajTb);
    AppMethodBeat.o(186531);
    return j;
  }
  
  public final boolean isOpen()
  {
    return true;
  }
  
  public final i kHM()
  {
    AppMethodBeat.i(186458);
    i locali = Ce(this.size);
    AppMethodBeat.o(186458);
    return locali;
  }
  
  public final ab kHm()
  {
    return ab.ajTJ;
  }
  
  public final InputStream kIA()
  {
    AppMethodBeat.i(186396);
    InputStream localInputStream = (InputStream)new a(this);
    AppMethodBeat.o(186396);
    return localInputStream;
  }
  
  public final long kIB()
  {
    AppMethodBeat.i(186408);
    long l2 = this.size;
    if (l2 == 0L)
    {
      AppMethodBeat.o(186408);
      return 0L;
    }
    v localv = this.ajTb;
    kotlin.g.b.s.checkNotNull(localv);
    localv = localv.ajTy;
    kotlin.g.b.s.checkNotNull(localv);
    long l1 = l2;
    if (localv.limit < 8192)
    {
      l1 = l2;
      if (localv.ajTw) {
        l1 = l2 - (localv.limit - localv.pos);
      }
    }
    AppMethodBeat.o(186408);
    return l1;
  }
  
  public final short kIC()
  {
    AppMethodBeat.i(186443);
    int i = readShort() & 0xFFFF;
    short s = (short)((i & 0xFF) << 8 | (0xFF00 & i) >>> 8);
    AppMethodBeat.o(186443);
    return s;
  }
  
  public final int kID()
  {
    AppMethodBeat.i(186445);
    int i = readInt();
    AppMethodBeat.o(186445);
    return (i & 0xFF) << 24 | (0xFF000000 & i) >>> 24 | (0xFF0000 & i) >>> 8 | (0xFF00 & i) << 8;
  }
  
  public final long kIE()
  {
    AppMethodBeat.i(186451);
    if (this.size == 0L)
    {
      localObject = (Throwable)new EOFException();
      AppMethodBeat.o(186451);
      throw ((Throwable)localObject);
    }
    long l2 = 0L;
    int n = 0;
    int i1 = 0;
    int i = 0;
    long l3 = -7L;
    Object localObject = this.ajTb;
    kotlin.g.b.s.checkNotNull(localObject);
    byte[] arrayOfByte = ((v)localObject).data;
    int m = ((v)localObject).pos;
    int i2 = ((v)localObject).limit;
    long l1 = l2;
    int j = n;
    int k = i1;
    l2 = l3;
    n = i;
    if (m < i2)
    {
      byte b = arrayOfByte[m];
      if ((b >= 48) && (b <= 57))
      {
        n = 48 - b;
        if ((l1 < -922337203685477580L) || ((l1 == -922337203685477580L) && (n < l2)))
        {
          localObject = new f().Cj(l1).aNg(b);
          if (k == 0) {
            ((f)localObject).readByte();
          }
          localObject = (Throwable)new NumberFormatException("Number too large: " + ((f)localObject).kIG());
          AppMethodBeat.o(186451);
          throw ((Throwable)localObject);
        }
        l1 = l1 * 10L + n;
      }
      for (;;)
      {
        m += 1;
        j += 1;
        break;
        if ((b != 45) || (j != 0)) {
          break label278;
        }
        k = 1;
        l2 -= 1L;
      }
      label278:
      if (j == 0)
      {
        localObject = (Throwable)new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + c.s(b));
        AppMethodBeat.o(186451);
        throw ((Throwable)localObject);
      }
      n = 1;
    }
    if (m == i2)
    {
      this.ajTb = ((v)localObject).kJa();
      w.b((v)localObject);
    }
    for (;;)
    {
      if (n == 0)
      {
        l3 = l2;
        i = n;
        i1 = k;
        n = j;
        l2 = l1;
        if (this.ajTb != null) {
          break;
        }
      }
      this.size -= j;
      if (k == 0) {
        break label412;
      }
      AppMethodBeat.o(186451);
      return l1;
      ((v)localObject).pos = m;
    }
    label412:
    l1 = -l1;
    AppMethodBeat.o(186451);
    return l1;
  }
  
  public final long kIF()
  {
    AppMethodBeat.i(186456);
    Object localObject;
    if (this.size == 0L)
    {
      localObject = (Throwable)new EOFException();
      AppMethodBeat.o(186456);
      throw ((Throwable)localObject);
    }
    int k = 0;
    int i = 0;
    long l = 0L;
    for (;;)
    {
      localObject = this.ajTb;
      kotlin.g.b.s.checkNotNull(localObject);
      byte[] arrayOfByte = ((v)localObject).data;
      int m = ((v)localObject).pos;
      int n = ((v)localObject).limit;
      int j = k;
      if (m < n)
      {
        byte b = arrayOfByte[m];
        if ((b >= 48) && (b <= 57)) {
          j = b - 48;
        }
        for (;;)
        {
          if ((0x0 & l) == 0L) {
            break label325;
          }
          localObject = new f().Cl(l).aNg(b);
          localObject = (Throwable)new NumberFormatException("Number too large: " + ((f)localObject).kIG());
          AppMethodBeat.o(186456);
          throw ((Throwable)localObject);
          if ((b >= 97) && (b <= 102))
          {
            j = b - 97 + 10;
          }
          else
          {
            if ((b < 65) || (b > 70)) {
              break;
            }
            j = b - 65 + 10;
          }
        }
        if (i == 0)
        {
          localObject = (Throwable)new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + c.s(b));
          AppMethodBeat.o(186456);
          throw ((Throwable)localObject);
        }
        j = 1;
      }
      if (m == n)
      {
        this.ajTb = ((v)localObject).kJa();
        w.b((v)localObject);
      }
      for (;;)
      {
        if ((j == 0) && (this.ajTb != null)) {
          break label357;
        }
        this.size -= i;
        AppMethodBeat.o(186456);
        return l;
        label325:
        l = l << 4 | j;
        i += 1;
        m += 1;
        break;
        ((v)localObject).pos = m;
      }
      label357:
      k = j;
    }
  }
  
  public final String kIG()
  {
    AppMethodBeat.i(186466);
    String str = a(this.size, d.UTF_8);
    AppMethodBeat.o(186466);
    return str;
  }
  
  public final String kIH()
  {
    AppMethodBeat.i(186468);
    String str = Cg(9223372036854775807L);
    AppMethodBeat.o(186468);
    return str;
  }
  
  public final f kIv()
  {
    return this;
  }
  
  public final f kIw()
  {
    return this;
  }
  
  public final boolean kIy()
  {
    return this.size == 0L;
  }
  
  public final h kIz()
  {
    AppMethodBeat.i(186392);
    h localh = q.b((aa)new s((h)this));
    AppMethodBeat.o(186392);
    return localh;
  }
  
  public final int read(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(186477);
    kotlin.g.b.s.u(paramByteBuffer, "sink");
    v localv = this.ajTb;
    if (localv == null)
    {
      AppMethodBeat.o(186477);
      return -1;
    }
    int i = Math.min(paramByteBuffer.remaining(), localv.limit - localv.pos);
    paramByteBuffer.put(localv.data, localv.pos, i);
    localv.pos += i;
    this.size -= i;
    if (localv.pos == localv.limit)
    {
      this.ajTb = localv.kJa();
      w.b(localv);
    }
    AppMethodBeat.o(186477);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186476);
    kotlin.g.b.s.u(paramArrayOfByte, "sink");
    c.C(paramArrayOfByte.length, paramInt1, paramInt2);
    v localv = this.ajTb;
    if (localv == null)
    {
      AppMethodBeat.o(186476);
      return -1;
    }
    paramInt2 = Math.min(paramInt2, localv.limit - localv.pos);
    k.a(localv.data, paramArrayOfByte, paramInt1, localv.pos, localv.pos + paramInt2);
    localv.pos += paramInt2;
    this.size -= paramInt2;
    if (localv.pos == localv.limit)
    {
      this.ajTb = localv.kJa();
      w.b(localv);
    }
    AppMethodBeat.o(186476);
    return paramInt2;
  }
  
  public final byte readByte()
  {
    AppMethodBeat.i(186412);
    if (this.size == 0L)
    {
      localObject = (Throwable)new EOFException();
      AppMethodBeat.o(186412);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ajTb;
    kotlin.g.b.s.checkNotNull(localObject);
    int i = ((v)localObject).pos;
    int j = ((v)localObject).limit;
    byte[] arrayOfByte = ((v)localObject).data;
    int k = i + 1;
    byte b = arrayOfByte[i];
    this.size -= 1L;
    if (k == j)
    {
      this.ajTb = ((v)localObject).kJa();
      w.b((v)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(186412);
      return b;
      ((v)localObject).pos = k;
    }
  }
  
  public final void readFully(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186475);
    kotlin.g.b.s.u(paramArrayOfByte, "sink");
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = read(paramArrayOfByte, i, paramArrayOfByte.length - i);
      if (j == -1)
      {
        paramArrayOfByte = (Throwable)new EOFException();
        AppMethodBeat.o(186475);
        throw paramArrayOfByte;
      }
      i += j;
    }
    AppMethodBeat.o(186475);
  }
  
  public final int readInt()
  {
    AppMethodBeat.i(186435);
    if (this.size < 4L)
    {
      localObject = (Throwable)new EOFException();
      AppMethodBeat.o(186435);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ajTb;
    kotlin.g.b.s.checkNotNull(localObject);
    int j = ((v)localObject).pos;
    int i = ((v)localObject).limit;
    if (i - j < 4L)
    {
      i = readByte();
      j = readByte();
      k = readByte();
      m = readByte();
      AppMethodBeat.o(186435);
      return (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8 | m & 0xFF;
    }
    byte[] arrayOfByte = ((v)localObject).data;
    int k = j + 1;
    j = arrayOfByte[j];
    int n = k + 1;
    k = arrayOfByte[k];
    int m = n + 1;
    n = arrayOfByte[n];
    int i1 = m + 1;
    m = arrayOfByte[m];
    this.size -= 4L;
    if (i1 == i)
    {
      this.ajTb = ((v)localObject).kJa();
      w.b((v)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(186435);
      return (j & 0xFF) << 24 | (k & 0xFF) << 16 | (n & 0xFF) << 8 | m & 0xFF;
      ((v)localObject).pos = i1;
    }
  }
  
  public final short readShort()
  {
    AppMethodBeat.i(186422);
    if (this.size < 2L)
    {
      localObject = (Throwable)new EOFException();
      AppMethodBeat.o(186422);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ajTb;
    kotlin.g.b.s.checkNotNull(localObject);
    int k = ((v)localObject).pos;
    int i = ((v)localObject).limit;
    short s;
    if (i - k < 2)
    {
      s = (short)((readByte() & 0xFF) << 8 | readByte() & 0xFF);
      AppMethodBeat.o(186422);
      return s;
    }
    byte[] arrayOfByte = ((v)localObject).data;
    int j = k + 1;
    k = arrayOfByte[k];
    int m = j + 1;
    j = arrayOfByte[j];
    this.size -= 2L;
    if (m == i)
    {
      this.ajTb = ((v)localObject).kJa();
      w.b((v)localObject);
    }
    for (;;)
    {
      s = (short)((k & 0xFF) << 8 | j & 0xFF);
      AppMethodBeat.o(186422);
      return s;
      ((v)localObject).pos = m;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186532);
    if (this.size <= 2147483647L) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException(("size > Int.MAX_VALUE: " + this.size).toString());
      AppMethodBeat.o(186532);
      throw ((Throwable)localObject);
    }
    Object localObject = aNn((int)this.size).toString();
    AppMethodBeat.o(186532);
    return localObject;
  }
  
  public final int write(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(186495);
    kotlin.g.b.s.u(paramByteBuffer, "source");
    int j = paramByteBuffer.remaining();
    int i = j;
    while (i > 0)
    {
      v localv = aNm(1);
      int k = Math.min(i, 8192 - localv.limit);
      paramByteBuffer.get(localv.data, localv.limit, k);
      i -= k;
      localv.limit = (k + localv.limit);
    }
    this.size += j;
    AppMethodBeat.o(186495);
    return j;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"okio/Buffer$inputStream$1", "Ljava/io/InputStream;", "available", "", "close", "", "read", "sink", "", "offset", "byteCount", "toString", "", "okio"}, k=1, mv={1, 4, 1})
  public static final class a
    extends InputStream
  {
    public final int available()
    {
      AppMethodBeat.i(186444);
      int i = (int)Math.min(this.ajTc.size, 2147483647L);
      AppMethodBeat.o(186444);
      return i;
    }
    
    public final void close() {}
    
    public final int read()
    {
      AppMethodBeat.i(186437);
      if (this.ajTc.size > 0L)
      {
        int i = this.ajTc.readByte();
        AppMethodBeat.o(186437);
        return i & 0xFF;
      }
      AppMethodBeat.o(186437);
      return -1;
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(186441);
      kotlin.g.b.s.u(paramArrayOfByte, "sink");
      paramInt1 = this.ajTc.read(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(186441);
      return paramInt1;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(186449);
      String str = this.ajTc + ".inputStream()";
      AppMethodBeat.o(186449);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.f
 * JD-Core Version:    0.7.0.1
 */