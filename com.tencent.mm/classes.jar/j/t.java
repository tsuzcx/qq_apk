package j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/RealBufferedSink;", "Lokio/BufferedSink;", "sink", "Lokio/Sink;", "(Lokio/Sink;)V", "buffer", "Lokio/Buffer;", "getBuffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", "close", "", "emit", "emitCompleteSegments", "flush", "isOpen", "outputStream", "Ljava/io/OutputStream;", "timeout", "Lokio/Timeout;", "toString", "", "write", "", "source", "Ljava/nio/ByteBuffer;", "", "offset", "byteCount", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "writeAll", "writeByte", "b", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "charset", "Ljava/nio/charset/Charset;", "beginIndex", "endIndex", "writeUtf8", "writeUtf8CodePoint", "codePoint", "okio"}, k=1, mv={1, 4, 1})
public final class t
  implements g
{
  public final f ajTt;
  public boolean closed;
  public final y cnn;
  
  public t(y paramy)
  {
    AppMethodBeat.i(186282);
    this.cnn = paramy;
    this.ajTt = new f();
    AppMethodBeat.o(186282);
  }
  
  public final g Ck(long paramLong)
  {
    AppMethodBeat.i(186328);
    if (!this.closed) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("closed".toString());
      AppMethodBeat.o(186328);
      throw ((Throwable)localObject);
    }
    this.ajTt.Cj(paramLong);
    Object localObject = kIx();
    AppMethodBeat.o(186328);
    return localObject;
  }
  
  public final g Cm(long paramLong)
  {
    AppMethodBeat.i(186332);
    if (!this.closed) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("closed".toString());
      AppMethodBeat.o(186332);
      throw ((Throwable)localObject);
    }
    this.ajTt.Cl(paramLong);
    Object localObject = kIx();
    AppMethodBeat.o(186332);
    return localObject;
  }
  
  public final g aNh(int paramInt)
  {
    AppMethodBeat.i(186316);
    if (!this.closed) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("closed".toString());
      AppMethodBeat.o(186316);
      throw ((Throwable)localObject);
    }
    this.ajTt.aNg(paramInt);
    Object localObject = kIx();
    AppMethodBeat.o(186316);
    return localObject;
  }
  
  public final g aNj(int paramInt)
  {
    AppMethodBeat.i(186321);
    if (!this.closed) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("closed".toString());
      AppMethodBeat.o(186321);
      throw ((Throwable)localObject);
    }
    this.ajTt.aNi(paramInt);
    Object localObject = kIx();
    AppMethodBeat.o(186321);
    return localObject;
  }
  
  public final g aNl(int paramInt)
  {
    AppMethodBeat.i(186325);
    if (!this.closed) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("closed".toString());
      AppMethodBeat.o(186325);
      throw ((Throwable)localObject);
    }
    this.ajTt.aNk(paramInt);
    Object localObject = kIx();
    AppMethodBeat.o(186325);
    return localObject;
  }
  
  public final g aj(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186309);
    s.u(paramArrayOfByte, "source");
    if (!this.closed) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramArrayOfByte = (Throwable)new IllegalStateException("closed".toString());
      AppMethodBeat.o(186309);
      throw paramArrayOfByte;
    }
    this.ajTt.ai(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = kIx();
    AppMethodBeat.o(186309);
    return paramArrayOfByte;
  }
  
  public final void b(f paramf, long paramLong)
  {
    AppMethodBeat.i(186289);
    s.u(paramf, "source");
    if (!this.closed) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramf = (Throwable)new IllegalStateException("closed".toString());
      AppMethodBeat.o(186289);
      throw paramf;
    }
    this.ajTt.b(paramf, paramLong);
    kIx();
    AppMethodBeat.o(186289);
  }
  
  public final g bKR(String paramString)
  {
    AppMethodBeat.i(186296);
    s.u(paramString, "string");
    if (!this.closed) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString = (Throwable)new IllegalStateException("closed".toString());
      AppMethodBeat.o(186296);
      throw paramString;
    }
    this.ajTt.bKQ(paramString);
    paramString = kIx();
    AppMethodBeat.o(186296);
    return paramString;
  }
  
  public final void close()
  {
    AppMethodBeat.i(186349);
    Object localObject3;
    Object localObject1;
    if (!this.closed)
    {
      localObject3 = null;
      localObject1 = localObject3;
      for (;;)
      {
        try
        {
          if (this.ajTt.size > 0L)
          {
            this.cnn.b(this.ajTt, this.ajTt.size);
            localObject1 = localObject3;
          }
        }
        finally
        {
          continue;
        }
        try
        {
          this.cnn.close();
          localObject3 = localObject1;
        }
        finally
        {
          localObject3 = localObject1;
          if (localObject1 != null) {
            continue;
          }
          localObject3 = localObject4;
        }
      }
      this.closed = true;
      if (localObject3 != null)
      {
        AppMethodBeat.o(186349);
        throw localObject3;
      }
    }
    AppMethodBeat.o(186349);
  }
  
  public final g ee(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186302);
    s.u(paramArrayOfByte, "source");
    if (!this.closed) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramArrayOfByte = (Throwable)new IllegalStateException("closed".toString());
      AppMethodBeat.o(186302);
      throw paramArrayOfByte;
    }
    this.ajTt.ed(paramArrayOfByte);
    paramArrayOfByte = kIx();
    AppMethodBeat.o(186302);
    return paramArrayOfByte;
  }
  
  public final void flush()
  {
    AppMethodBeat.i(186342);
    if (!this.closed) {}
    for (int i = 1; i == 0; i = 0)
    {
      Throwable localThrowable = (Throwable)new IllegalStateException("closed".toString());
      AppMethodBeat.o(186342);
      throw localThrowable;
    }
    if (this.ajTt.size > 0L) {
      this.cnn.b(this.ajTt, this.ajTt.size);
    }
    this.cnn.flush();
    AppMethodBeat.o(186342);
  }
  
  public final boolean isOpen()
  {
    return !this.closed;
  }
  
  public final ab kHm()
  {
    AppMethodBeat.i(186491);
    ab localab = this.cnn.kHm();
    AppMethodBeat.o(186491);
    return localab;
  }
  
  public final f kIv()
  {
    return this.ajTt;
  }
  
  public final g kIx()
  {
    AppMethodBeat.i(186338);
    if (!this.closed) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("closed".toString());
      AppMethodBeat.o(186338);
      throw ((Throwable)localObject);
    }
    long l = this.ajTt.kIB();
    if (l > 0L) {
      this.cnn.b(this.ajTt, l);
    }
    Object localObject = (g)this;
    AppMethodBeat.o(186338);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186497);
    String str = "buffer(" + this.cnn + ')';
    AppMethodBeat.o(186497);
    return str;
  }
  
  public final int write(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(186313);
    s.u(paramByteBuffer, "source");
    if (!this.closed) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramByteBuffer = (Throwable)new IllegalStateException("closed".toString());
      AppMethodBeat.o(186313);
      throw paramByteBuffer;
    }
    i = this.ajTt.write(paramByteBuffer);
    kIx();
    AppMethodBeat.o(186313);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.t
 * JD-Core Version:    0.7.0.1
 */