package j;

import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/ForwardingSink;", "Lokio/Sink;", "delegate", "(Lokio/Sink;)V", "()Lokio/Sink;", "close", "", "-deprecated_delegate", "flush", "timeout", "Lokio/Timeout;", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 4, 1})
public abstract class j
  implements y
{
  private final y ajTg;
  
  public j(y paramy)
  {
    this.ajTg = paramy;
  }
  
  public void b(f paramf, long paramLong)
  {
    s.u(paramf, "source");
    this.ajTg.b(paramf, paramLong);
  }
  
  public void close()
  {
    this.ajTg.close();
  }
  
  public void flush()
  {
    this.ajTg.flush();
  }
  
  public final ab kHm()
  {
    return this.ajTg.kHm();
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + '(' + this.ajTg + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.j
 * JD-Core Version:    0.7.0.1
 */