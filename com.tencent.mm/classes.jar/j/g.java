package j;

import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/BufferedSink;", "Lokio/Sink;", "Ljava/nio/channels/WritableByteChannel;", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "emit", "emitCompleteSegments", "flush", "", "outputStream", "Ljava/io/OutputStream;", "write", "source", "", "offset", "", "byteCount", "byteString", "Lokio/ByteString;", "Lokio/Source;", "", "writeAll", "writeByte", "b", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "", "charset", "Ljava/nio/charset/Charset;", "beginIndex", "endIndex", "writeUtf8", "writeUtf8CodePoint", "codePoint", "okio"}, k=1, mv={1, 4, 1})
public abstract interface g
  extends y, WritableByteChannel
{
  public abstract g Ck(long paramLong);
  
  public abstract g Cm(long paramLong);
  
  public abstract g aNh(int paramInt);
  
  public abstract g aNj(int paramInt);
  
  public abstract g aNl(int paramInt);
  
  public abstract g aj(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract g bKR(String paramString);
  
  public abstract g ee(byte[] paramArrayOfByte);
  
  public abstract void flush();
  
  public abstract f kIv();
  
  public abstract g kIx();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.g
 * JD-Core Version:    0.7.0.1
 */