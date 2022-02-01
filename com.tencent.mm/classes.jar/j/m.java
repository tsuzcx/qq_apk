package j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/GzipSource;", "Lokio/Source;", "source", "(Lokio/Source;)V", "crc", "Ljava/util/zip/CRC32;", "inflater", "Ljava/util/zip/Inflater;", "inflaterSource", "Lokio/InflaterSource;", "section", "", "Lokio/RealBufferedSource;", "checkEqual", "", "name", "", "expected", "", "actual", "close", "consumeHeader", "consumeTrailer", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "updateCrc", "buffer", "offset", "okio"}, k=1, mv={1, 4, 1})
public final class m
  implements aa
{
  private byte ajTj;
  private final u ajTk;
  private final Inflater ajTl;
  private final n ajTm;
  private final CRC32 crc;
  
  public m(aa paramaa)
  {
    AppMethodBeat.i(186257);
    this.ajTk = new u(paramaa);
    this.ajTl = new Inflater(true);
    this.ajTm = new n((h)this.ajTk, this.ajTl);
    this.crc = new CRC32();
    AppMethodBeat.o(186257);
  }
  
  private final void b(f paramf, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(186241);
    paramf = paramf.ajTb;
    s.checkNotNull(paramf);
    Object localObject;
    long l1;
    long l2;
    for (;;)
    {
      localObject = paramf;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 < paramf.limit - paramf.pos) {
        break;
      }
      paramLong1 -= paramf.limit - paramf.pos;
      paramf = paramf.ajTx;
      s.checkNotNull(paramf);
    }
    while (l2 > 0L)
    {
      int i = (int)(((v)localObject).pos + l1);
      int j = (int)Math.min(((v)localObject).limit - i, l2);
      this.crc.update(((v)localObject).data, i, j);
      l2 -= j;
      localObject = ((v)localObject).ajTx;
      s.checkNotNull(localObject);
      l1 = 0L;
    }
    AppMethodBeat.o(186241);
  }
  
  private static void bC(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186250);
    if (paramInt2 != paramInt1)
    {
      paramString = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }, 3));
      s.s(paramString, "java.lang.String.format(this, *args)");
      paramString = (Throwable)new IOException(paramString);
      AppMethodBeat.o(186250);
      throw paramString;
    }
    AppMethodBeat.o(186250);
  }
  
  public final long a(f paramf, long paramLong)
  {
    AppMethodBeat.i(186356);
    s.u(paramf, "sink");
    if (paramLong >= 0L) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramf = (Throwable)new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)).toString());
      AppMethodBeat.o(186356);
      throw paramf;
    }
    if (paramLong == 0L)
    {
      AppMethodBeat.o(186356);
      return 0L;
    }
    label177:
    long l;
    if (this.ajTj == 0)
    {
      this.ajTk.Cc(10L);
      int k = this.ajTk.ajTt.de(3L);
      int j;
      if ((k >> 1 & 0x1) == 1)
      {
        i = 1;
        if (i != 0) {
          b(this.ajTk.ajTt, 0L, 10L);
        }
        bC("ID1ID2", 8075, this.ajTk.readShort());
        this.ajTk.Ci(8L);
        if ((k >> 2 & 0x1) != 1) {
          break label322;
        }
        j = 1;
        if (j != 0)
        {
          this.ajTk.Cc(2L);
          if (i != 0) {
            b(this.ajTk.ajTt, 0L, 2L);
          }
          l = this.ajTk.ajTt.kIC();
          this.ajTk.Cc(l);
          if (i != 0) {
            b(this.ajTk.ajTt, 0L, l);
          }
          this.ajTk.Ci(l);
        }
        if ((k >> 3 & 0x1) != 1) {
          break label328;
        }
        j = 1;
      }
      for (;;)
      {
        if (j != 0)
        {
          l = this.ajTk.kIY();
          if (l == -1L)
          {
            paramf = (Throwable)new EOFException();
            AppMethodBeat.o(186356);
            throw paramf;
            i = 0;
            break;
            label322:
            j = 0;
            break label177;
            label328:
            j = 0;
            continue;
          }
          if (i != 0) {
            b(this.ajTk.ajTt, 0L, 1L + l);
          }
          this.ajTk.Ci(1L + l);
        }
      }
      if ((k >> 4 & 0x1) == 1) {
        j = 1;
      }
      while (j != 0)
      {
        l = this.ajTk.kIY();
        if (l == -1L)
        {
          paramf = (Throwable)new EOFException();
          AppMethodBeat.o(186356);
          throw paramf;
          j = 0;
        }
        else
        {
          if (i != 0) {
            b(this.ajTk.ajTt, 0L, 1L + l);
          }
          this.ajTk.Ci(1L + l);
        }
      }
      if (i != 0)
      {
        u localu = this.ajTk;
        localu.Cc(2L);
        bC("FHCRC", localu.ajTt.kIC(), (short)(int)this.crc.getValue());
        this.crc.reset();
      }
      this.ajTj = 1;
    }
    if (this.ajTj == 1)
    {
      l = paramf.size;
      paramLong = this.ajTm.a(paramf, paramLong);
      if (paramLong != -1L)
      {
        b(paramf, l, paramLong);
        AppMethodBeat.o(186356);
        return paramLong;
      }
      this.ajTj = 2;
    }
    if (this.ajTj == 2)
    {
      bC("CRC", this.ajTk.kID(), (int)this.crc.getValue());
      bC("ISIZE", this.ajTk.kID(), (int)this.ajTl.getBytesWritten());
      this.ajTj = 3;
      if (!this.ajTk.kIy())
      {
        paramf = (Throwable)new IOException("gzip finished without exhausting source");
        AppMethodBeat.o(186356);
        throw paramf;
      }
    }
    AppMethodBeat.o(186356);
    return -1L;
  }
  
  public final void close()
  {
    AppMethodBeat.i(186362);
    this.ajTm.close();
    AppMethodBeat.o(186362);
  }
  
  public final ab kHm()
  {
    AppMethodBeat.i(186358);
    ab localab = this.ajTk.kHm();
    AppMethodBeat.o(186358);
    return localab;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.m
 * JD-Core Version:    0.7.0.1
 */