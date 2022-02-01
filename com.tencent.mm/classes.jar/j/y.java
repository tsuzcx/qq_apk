package j;

import java.io.Closeable;
import java.io.Flushable;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/Sink;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "close", "", "flush", "timeout", "Lokio/Timeout;", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 4, 1})
public abstract interface y
  extends Closeable, Flushable
{
  public abstract void b(f paramf, long paramLong);
  
  public abstract void close();
  
  public abstract void flush();
  
  public abstract ab kHm();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.y
 * JD-Core Version:    0.7.0.1
 */