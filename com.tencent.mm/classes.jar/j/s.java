package j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/PeekSource;", "Lokio/Source;", "upstream", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "buffer", "Lokio/Buffer;", "closed", "", "expectedPos", "", "expectedSegment", "Lokio/Segment;", "pos", "", "close", "", "read", "sink", "byteCount", "timeout", "Lokio/Timeout;", "okio"}, k=1, mv={1, 4, 1})
public final class s
  implements aa
{
  private final f ajTp;
  private v ajTq;
  private int ajTr;
  private final h ajTs;
  private boolean closed;
  private long dJh;
  
  public s(h paramh)
  {
    AppMethodBeat.i(186272);
    this.ajTs = paramh;
    this.ajTp = this.ajTs.kIw();
    this.ajTq = this.ajTp.ajTb;
    paramh = this.ajTp.ajTb;
    if (paramh != null) {}
    for (int i = paramh.pos;; i = -1)
    {
      this.ajTr = i;
      AppMethodBeat.o(186272);
      return;
    }
  }
  
  public final long a(f paramf, long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(186357);
    kotlin.g.b.s.u(paramf, "sink");
    if (paramLong >= 0L) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramf = (Throwable)new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)).toString());
      AppMethodBeat.o(186357);
      throw paramf;
    }
    if (!this.closed) {}
    for (i = 1; i == 0; i = 0)
    {
      paramf = (Throwable)new IllegalStateException("closed".toString());
      AppMethodBeat.o(186357);
      throw paramf;
    }
    v localv;
    if (this.ajTq != null)
    {
      i = j;
      if (this.ajTq == this.ajTp.ajTb)
      {
        int k = this.ajTr;
        localv = this.ajTp.ajTb;
        kotlin.g.b.s.checkNotNull(localv);
        i = j;
        if (k != localv.pos) {}
      }
    }
    else
    {
      i = 1;
    }
    if (i == 0)
    {
      paramf = (Throwable)new IllegalStateException("Peek source is invalid because upstream source was used".toString());
      AppMethodBeat.o(186357);
      throw paramf;
    }
    if (paramLong == 0L)
    {
      AppMethodBeat.o(186357);
      return 0L;
    }
    if (!this.ajTs.Cd(this.dJh + 1L))
    {
      AppMethodBeat.o(186357);
      return -1L;
    }
    if ((this.ajTq == null) && (this.ajTp.ajTb != null))
    {
      this.ajTq = this.ajTp.ajTb;
      localv = this.ajTp.ajTb;
      kotlin.g.b.s.checkNotNull(localv);
      this.ajTr = localv.pos;
    }
    paramLong = Math.min(paramLong, this.ajTp.size - this.dJh);
    this.ajTp.a(paramf, this.dJh, paramLong);
    this.dJh += paramLong;
    AppMethodBeat.o(186357);
    return paramLong;
  }
  
  public final void close()
  {
    this.closed = true;
  }
  
  public final ab kHm()
  {
    AppMethodBeat.i(186359);
    ab localab = this.ajTs.kHm();
    AppMethodBeat.o(186359);
    return localab;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.s
 * JD-Core Version:    0.7.0.1
 */