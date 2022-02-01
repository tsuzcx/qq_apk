package j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/InflaterSource;", "Lokio/Source;", "source", "inflater", "Ljava/util/zip/Inflater;", "(Lokio/Source;Ljava/util/zip/Inflater;)V", "Lokio/BufferedSource;", "(Lokio/BufferedSource;Ljava/util/zip/Inflater;)V", "bufferBytesHeldByInflater", "", "closed", "", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "readOrInflate", "refill", "releaseBytesAfterInflate", "timeout", "Lokio/Timeout;", "okio"}, k=1, mv={1, 4, 1})
public final class n
  implements aa
{
  private final Inflater ajTl;
  private int ajTn;
  private boolean closed;
  private final h cnO;
  
  public n(h paramh, Inflater paramInflater)
  {
    AppMethodBeat.i(186386);
    this.cnO = paramh;
    this.ajTl = paramInflater;
    AppMethodBeat.o(186386);
  }
  
  private long c(f paramf, long paramLong)
  {
    int j = 1;
    AppMethodBeat.i(186382);
    s.u(paramf, "sink");
    if (paramLong >= 0L) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramf = (Throwable)new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)).toString());
      AppMethodBeat.o(186382);
      throw paramf;
    }
    if (!this.closed) {}
    for (i = j; i == 0; i = 0)
    {
      paramf = (Throwable)new IllegalStateException("closed".toString());
      AppMethodBeat.o(186382);
      throw paramf;
    }
    if (paramLong == 0L)
    {
      AppMethodBeat.o(186382);
      return 0L;
    }
    v localv1;
    try
    {
      localv1 = paramf.aNm(1);
      i = (int)Math.min(paramLong, 8192 - localv1.limit);
      if ((this.ajTl.needsInput()) && (!this.cnO.kIy()))
      {
        v localv2 = this.cnO.kIw().ajTb;
        s.checkNotNull(localv2);
        this.ajTn = (localv2.limit - localv2.pos);
        this.ajTl.setInput(localv2.data, localv2.pos, this.ajTn);
      }
      i = this.ajTl.inflate(localv1.data, localv1.limit, i);
      if (this.ajTn != 0)
      {
        j = this.ajTn - this.ajTl.getRemaining();
        this.ajTn -= j;
        this.cnO.Ci(j);
      }
      if (i > 0)
      {
        localv1.limit += i;
        paramf.size += i;
        paramLong = i;
        AppMethodBeat.o(186382);
        return paramLong;
      }
    }
    catch (DataFormatException paramf)
    {
      paramf = (Throwable)new IOException((Throwable)paramf);
      AppMethodBeat.o(186382);
      throw paramf;
    }
    if (localv1.pos == localv1.limit)
    {
      paramf.ajTb = localv1.kJa();
      w.b(localv1);
    }
    AppMethodBeat.o(186382);
    return 0L;
  }
  
  public final long a(f paramf, long paramLong)
  {
    AppMethodBeat.i(186391);
    s.u(paramf, "sink");
    do
    {
      long l = c(paramf, paramLong);
      if (l > 0L)
      {
        AppMethodBeat.o(186391);
        return l;
      }
      if ((this.ajTl.finished()) || (this.ajTl.needsDictionary()))
      {
        AppMethodBeat.o(186391);
        return -1L;
      }
    } while (!this.cnO.kIy());
    paramf = (Throwable)new EOFException("source exhausted prematurely");
    AppMethodBeat.o(186391);
    throw paramf;
  }
  
  public final void close()
  {
    AppMethodBeat.i(186400);
    if (this.closed)
    {
      AppMethodBeat.o(186400);
      return;
    }
    this.ajTl.end();
    this.closed = true;
    this.cnO.close();
    AppMethodBeat.o(186400);
  }
  
  public final ab kHm()
  {
    AppMethodBeat.i(186397);
    ab localab = this.cnO.kHm();
    AppMethodBeat.o(186397);
    return localab;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.n
 * JD-Core Version:    0.7.0.1
 */