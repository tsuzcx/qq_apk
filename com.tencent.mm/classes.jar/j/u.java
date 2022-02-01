package j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "source", "Lokio/Source;", "(Lokio/Source;)V", "buffer", "Lokio/Buffer;", "getBuffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", "close", "", "exhausted", "indexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "peek", "rangeEquals", "offset", "bytesOffset", "", "byteCount", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "skip", "timeout", "Lokio/Timeout;", "toString", "okio"}, k=1, mv={1, 4, 1})
public final class u
  implements h
{
  public final f ajTt;
  public final aa ajTu;
  public boolean closed;
  
  public u(aa paramaa)
  {
    AppMethodBeat.i(186297);
    this.ajTu = paramaa;
    this.ajTt = new f();
    AppMethodBeat.o(186297);
  }
  
  private long a(byte paramByte, long paramLong)
  {
    int j = 1;
    long l1 = 0L;
    AppMethodBeat.i(186292);
    if (!this.closed) {}
    Throwable localThrowable;
    for (int i = 1; i == 0; i = 0)
    {
      localThrowable = (Throwable)new IllegalStateException("closed".toString());
      AppMethodBeat.o(186292);
      throw localThrowable;
    }
    if (0L > 0L) {}
    for (i = 0;; i = j)
    {
      if (i != 0) {
        break label132;
      }
      localThrowable = (Throwable)new IllegalArgumentException(("fromIndex=0 toIndex=" + paramLong).toString());
      AppMethodBeat.o(186292);
      throw localThrowable;
      if (paramLong < 0L) {
        break;
      }
    }
    label132:
    long l2;
    do
    {
      Object localObject;
      l1 = Math.max(l1, localObject);
      if (l1 >= paramLong) {
        break;
      }
      l2 = this.ajTt.a(paramByte, l1, paramLong);
      if (l2 != -1L)
      {
        AppMethodBeat.o(186292);
        return l2;
      }
      l2 = this.ajTt.size;
    } while ((l2 < paramLong) && (this.ajTu.a(this.ajTt, 8192L) != -1L));
    AppMethodBeat.o(186292);
    return -1L;
    AppMethodBeat.o(186292);
    return -1L;
  }
  
  public final void Cc(long paramLong)
  {
    AppMethodBeat.i(186315);
    if (!Cd(paramLong))
    {
      Throwable localThrowable = (Throwable)new EOFException();
      AppMethodBeat.o(186315);
      throw localThrowable;
    }
    AppMethodBeat.o(186315);
  }
  
  public final boolean Cd(long paramLong)
  {
    AppMethodBeat.i(186318);
    if (paramLong >= 0L) {}
    Throwable localThrowable;
    for (int i = 1; i == 0; i = 0)
    {
      localThrowable = (Throwable)new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)).toString());
      AppMethodBeat.o(186318);
      throw localThrowable;
    }
    if (!this.closed) {}
    for (i = 1; i == 0; i = 0)
    {
      localThrowable = (Throwable)new IllegalStateException("closed".toString());
      AppMethodBeat.o(186318);
      throw localThrowable;
    }
    while (this.ajTt.size < paramLong) {
      if (this.ajTu.a(this.ajTt, 8192L) == -1L)
      {
        AppMethodBeat.o(186318);
        return false;
      }
    }
    AppMethodBeat.o(186318);
    return true;
  }
  
  public final i Ce(long paramLong)
  {
    AppMethodBeat.i(186324);
    Cc(paramLong);
    i locali = this.ajTt.Ce(paramLong);
    AppMethodBeat.o(186324);
    return locali;
  }
  
  public final String Cg(long paramLong)
  {
    AppMethodBeat.i(186351);
    if (paramLong >= 0L) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalArgumentException("limit < 0: ".concat(String.valueOf(paramLong)).toString());
      AppMethodBeat.o(186351);
      throw ((Throwable)localObject);
    }
    if (paramLong == 9223372036854775807L) {}
    for (long l1 = 9223372036854775807L;; l1 = 1L + paramLong)
    {
      long l2 = a((byte)10, l1);
      if (l2 == -1L) {
        break;
      }
      localObject = j.a.a.d(this.ajTt, l2);
      AppMethodBeat.o(186351);
      return localObject;
    }
    if ((l1 < 9223372036854775807L) && (Cd(l1)) && (this.ajTt.de(l1 - 1L) == 13) && (Cd(1L + l1)) && (this.ajTt.de(l1) == 10))
    {
      localObject = j.a.a.d(this.ajTt, l1);
      AppMethodBeat.o(186351);
      return localObject;
    }
    Object localObject = new f();
    this.ajTt.a((f)localObject, 0L, Math.min(32L, this.ajTt.size));
    localObject = (Throwable)new EOFException("\\n not found: limit=" + Math.min(this.ajTt.size, paramLong) + " content=" + ((f)localObject).kHM().kIL() + "…");
    AppMethodBeat.o(186351);
    throw ((Throwable)localObject);
  }
  
  public final byte[] Ch(long paramLong)
  {
    AppMethodBeat.i(186330);
    Cc(paramLong);
    byte[] arrayOfByte = this.ajTt.Ch(paramLong);
    AppMethodBeat.o(186330);
    return arrayOfByte;
  }
  
  public final void Ci(long paramLong)
  {
    AppMethodBeat.i(186371);
    if (!this.closed) {}
    for (int i = 1; i == 0; i = 0)
    {
      localThrowable = (Throwable)new IllegalStateException("closed".toString());
      AppMethodBeat.o(186371);
      throw localThrowable;
    }
    do
    {
      long l = Math.min(paramLong, this.ajTt.size);
      this.ajTt.Ci(l);
      paramLong -= l;
      if (paramLong <= 0L) {
        break;
      }
    } while ((this.ajTt.size != 0L) || (this.ajTu.a(this.ajTt, 8192L) != -1L));
    Throwable localThrowable = (Throwable)new EOFException();
    AppMethodBeat.o(186371);
    throw localThrowable;
    AppMethodBeat.o(186371);
  }
  
  public final byte[] Ml()
  {
    AppMethodBeat.i(186327);
    this.ajTt.a(this.ajTu);
    byte[] arrayOfByte = this.ajTt.Ml();
    AppMethodBeat.o(186327);
    return arrayOfByte;
  }
  
  public final long a(f paramf, long paramLong)
  {
    int j = 1;
    AppMethodBeat.i(186307);
    kotlin.g.b.s.u(paramf, "sink");
    if (paramLong >= 0L) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramf = (Throwable)new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)).toString());
      AppMethodBeat.o(186307);
      throw paramf;
    }
    if (!this.closed) {}
    for (i = j; i == 0; i = 0)
    {
      paramf = (Throwable)new IllegalStateException("closed".toString());
      AppMethodBeat.o(186307);
      throw paramf;
    }
    if ((this.ajTt.size == 0L) && (this.ajTu.a(this.ajTt, 8192L) == -1L))
    {
      AppMethodBeat.o(186307);
      return -1L;
    }
    paramLong = Math.min(paramLong, this.ajTt.size);
    paramLong = this.ajTt.a(paramf, paramLong);
    AppMethodBeat.o(186307);
    return paramLong;
  }
  
  public final long a(y paramy)
  {
    AppMethodBeat.i(186343);
    kotlin.g.b.s.u(paramy, "sink");
    long l1 = 0L;
    while (this.ajTu.a(this.ajTt, 8192L) != -1L)
    {
      l2 = this.ajTt.kIB();
      if (l2 > 0L)
      {
        l1 += l2;
        paramy.b(this.ajTt, l2);
      }
    }
    long l2 = l1;
    if (this.ajTt.size > 0L)
    {
      l2 = l1 + this.ajTt.size;
      paramy.b(this.ajTt, this.ajTt.size);
    }
    AppMethodBeat.o(186343);
    return l2;
  }
  
  public final void close()
  {
    AppMethodBeat.i(186383);
    if (!this.closed)
    {
      this.closed = true;
      this.ajTu.close();
      this.ajTt.clear();
    }
    AppMethodBeat.o(186383);
  }
  
  public final boolean isOpen()
  {
    return !this.closed;
  }
  
  public final ab kHm()
  {
    AppMethodBeat.i(186387);
    ab localab = this.ajTu.kHm();
    AppMethodBeat.o(186387);
    return localab;
  }
  
  public final InputStream kIA()
  {
    AppMethodBeat.i(186379);
    InputStream localInputStream = (InputStream)new a(this);
    AppMethodBeat.o(186379);
    return localInputStream;
  }
  
  public final int kID()
  {
    AppMethodBeat.i(186355);
    Cc(4L);
    int i = this.ajTt.kID();
    AppMethodBeat.o(186355);
    return i;
  }
  
  public final long kIE()
  {
    AppMethodBeat.i(186363);
    Cc(1L);
    for (long l = 0L; Cd(l + 1L); l += 1L)
    {
      int i = this.ajTt.de(l);
      if (((i < 48) || (i > 57)) && ((l != 0L) || (i != 45)))
      {
        if (l != 0L) {
          break;
        }
        Object localObject = new StringBuilder("Expected leading [0-9] or '-' character but was 0x");
        String str = Integer.toString(i, kotlin.n.a.aMy(kotlin.n.a.aMy(16)));
        kotlin.g.b.s.s(str, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        localObject = (Throwable)new NumberFormatException(str);
        AppMethodBeat.o(186363);
        throw ((Throwable)localObject);
      }
    }
    l = this.ajTt.kIE();
    AppMethodBeat.o(186363);
    return l;
  }
  
  public final long kIF()
  {
    AppMethodBeat.i(186365);
    Cc(1L);
    int i = 0;
    while (Cd(i + 1))
    {
      int j = this.ajTt.de(i);
      if (((j < 48) || (j > 57)) && ((j < 97) || (j > 102)) && ((j < 65) || (j > 70)))
      {
        if (i != 0) {
          break;
        }
        Object localObject = new StringBuilder("Expected leading [0-9a-fA-F] character but was 0x");
        String str = Integer.toString(j, kotlin.n.a.aMy(kotlin.n.a.aMy(16)));
        kotlin.g.b.s.s(str, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        localObject = (Throwable)new NumberFormatException(str);
        AppMethodBeat.o(186365);
        throw ((Throwable)localObject);
      }
      i += 1;
    }
    long l = this.ajTt.kIF();
    AppMethodBeat.o(186365);
    return l;
  }
  
  public final String kIH()
  {
    AppMethodBeat.i(186348);
    String str = Cg(9223372036854775807L);
    AppMethodBeat.o(186348);
    return str;
  }
  
  public final long kIY()
  {
    AppMethodBeat.i(186374);
    long l = a((byte)0, 9223372036854775807L);
    AppMethodBeat.o(186374);
    return l;
  }
  
  public final f kIv()
  {
    return this.ajTt;
  }
  
  public final f kIw()
  {
    return this.ajTt;
  }
  
  public final boolean kIy()
  {
    AppMethodBeat.i(186311);
    if (!this.closed) {}
    for (int i = 1; i == 0; i = 0)
    {
      Throwable localThrowable = (Throwable)new IllegalStateException("closed".toString());
      AppMethodBeat.o(186311);
      throw localThrowable;
    }
    if ((this.ajTt.kIy()) && (this.ajTu.a(this.ajTt, 8192L) == -1L))
    {
      AppMethodBeat.o(186311);
      return true;
    }
    AppMethodBeat.o(186311);
    return false;
  }
  
  public final h kIz()
  {
    AppMethodBeat.i(186377);
    h localh = q.b((aa)new s((h)this));
    AppMethodBeat.o(186377);
    return localh;
  }
  
  public final int read(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(186339);
    kotlin.g.b.s.u(paramByteBuffer, "sink");
    if ((this.ajTt.size == 0L) && (this.ajTu.a(this.ajTt, 8192L) == -1L))
    {
      AppMethodBeat.o(186339);
      return -1;
    }
    int i = this.ajTt.read(paramByteBuffer);
    AppMethodBeat.o(186339);
    return i;
  }
  
  public final byte readByte()
  {
    AppMethodBeat.i(186322);
    Cc(1L);
    byte b = this.ajTt.readByte();
    AppMethodBeat.o(186322);
    return b;
  }
  
  public final void readFully(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186335);
    kotlin.g.b.s.u(paramArrayOfByte, "sink");
    try
    {
      Cc(paramArrayOfByte.length);
      this.ajTt.readFully(paramArrayOfByte);
      AppMethodBeat.o(186335);
      return;
    }
    catch (EOFException localEOFException)
    {
      int i = 0;
      while (this.ajTt.size > 0L)
      {
        int j = this.ajTt.read(paramArrayOfByte, i, (int)this.ajTt.size);
        if (j == -1)
        {
          paramArrayOfByte = (Throwable)new AssertionError();
          AppMethodBeat.o(186335);
          throw paramArrayOfByte;
        }
        i += j;
      }
      paramArrayOfByte = (Throwable)localEOFException;
      AppMethodBeat.o(186335);
      throw paramArrayOfByte;
    }
  }
  
  public final int readInt()
  {
    AppMethodBeat.i(186353);
    Cc(4L);
    int i = this.ajTt.readInt();
    AppMethodBeat.o(186353);
    return i;
  }
  
  public final short readShort()
  {
    AppMethodBeat.i(186352);
    Cc(2L);
    short s = this.ajTt.readShort();
    AppMethodBeat.o(186352);
    return s;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186417);
    String str = "buffer(" + this.ajTu + ')';
    AppMethodBeat.o(186417);
    return str;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"okio/RealBufferedSource$inputStream$1", "Ljava/io/InputStream;", "available", "", "close", "", "read", "data", "", "offset", "byteCount", "toString", "", "okio"}, k=1, mv={1, 4, 1})
  public static final class a
    extends InputStream
  {
    public final int available()
    {
      AppMethodBeat.i(186459);
      if (this.ajTv.closed)
      {
        Throwable localThrowable = (Throwable)new IOException("closed");
        AppMethodBeat.o(186459);
        throw localThrowable;
      }
      int i = (int)Math.min(this.ajTv.ajTt.size, 2147483647L);
      AppMethodBeat.o(186459);
      return i;
    }
    
    public final void close()
    {
      AppMethodBeat.i(186462);
      this.ajTv.close();
      AppMethodBeat.o(186462);
    }
    
    public final int read()
    {
      AppMethodBeat.i(186453);
      if (this.ajTv.closed)
      {
        Throwable localThrowable = (Throwable)new IOException("closed");
        AppMethodBeat.o(186453);
        throw localThrowable;
      }
      if ((this.ajTv.ajTt.size == 0L) && (this.ajTv.ajTu.a(this.ajTv.ajTt, 8192L) == -1L))
      {
        AppMethodBeat.o(186453);
        return -1;
      }
      int i = this.ajTv.ajTt.readByte();
      AppMethodBeat.o(186453);
      return i & 0xFF;
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(186457);
      kotlin.g.b.s.u(paramArrayOfByte, "data");
      if (this.ajTv.closed)
      {
        paramArrayOfByte = (Throwable)new IOException("closed");
        AppMethodBeat.o(186457);
        throw paramArrayOfByte;
      }
      c.C(paramArrayOfByte.length, paramInt1, paramInt2);
      if ((this.ajTv.ajTt.size == 0L) && (this.ajTv.ajTu.a(this.ajTv.ajTt, 8192L) == -1L))
      {
        AppMethodBeat.o(186457);
        return -1;
      }
      paramInt1 = this.ajTv.ajTt.read(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(186457);
      return paramInt1;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(186465);
      String str = this.ajTv + ".inputStream()";
      AppMethodBeat.o(186465);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.u
 * JD-Core Version:    0.7.0.1
 */