package j;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/BufferedSource;", "Lokio/Source;", "Ljava/nio/channels/ReadableByteChannel;", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "exhausted", "", "indexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "peek", "rangeEquals", "offset", "bytesOffset", "", "byteCount", "read", "sink", "", "readAll", "Lokio/Sink;", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFully", "", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "skip", "okio"}, k=1, mv={1, 4, 1})
public abstract interface h
  extends aa, ReadableByteChannel
{
  public abstract void Cc(long paramLong);
  
  public abstract boolean Cd(long paramLong);
  
  public abstract i Ce(long paramLong);
  
  public abstract String Cg(long paramLong);
  
  public abstract byte[] Ch(long paramLong);
  
  public abstract void Ci(long paramLong);
  
  public abstract byte[] Ml();
  
  public abstract long a(y paramy);
  
  public abstract InputStream kIA();
  
  public abstract long kIE();
  
  public abstract long kIF();
  
  public abstract String kIH();
  
  public abstract f kIv();
  
  public abstract f kIw();
  
  public abstract boolean kIy();
  
  public abstract h kIz();
  
  public abstract byte readByte();
  
  public abstract void readFully(byte[] paramArrayOfByte);
  
  public abstract int readInt();
  
  public abstract short readShort();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.h
 * JD-Core Version:    0.7.0.1
 */