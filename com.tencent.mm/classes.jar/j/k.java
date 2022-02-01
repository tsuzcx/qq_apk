package j;

import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/ForwardingSource;", "Lokio/Source;", "delegate", "(Lokio/Source;)V", "()Lokio/Source;", "close", "", "-deprecated_delegate", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "toString", "", "okio"}, k=1, mv={1, 4, 1})
public abstract class k
  implements aa
{
  private final aa ajTh;
  
  public k(aa paramaa)
  {
    this.ajTh = paramaa;
  }
  
  public long a(f paramf, long paramLong)
  {
    s.u(paramf, "sink");
    return this.ajTh.a(paramf, paramLong);
  }
  
  public void close()
  {
    this.ajTh.close();
  }
  
  public final ab kHm()
  {
    return this.ajTh.kHm();
  }
  
  public final aa kIP()
  {
    return this.ajTh;
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + '(' + this.ajTh + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.k
 * JD-Core Version:    0.7.0.1
 */