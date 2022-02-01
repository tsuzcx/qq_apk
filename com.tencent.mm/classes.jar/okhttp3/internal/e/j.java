package okhttp3.internal.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.f;
import j.g;
import j.i;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class j
  implements Closeable
{
  private static final Logger logger;
  private final g ajPn;
  private final boolean ajQR;
  private final f ajRV;
  final d.b ajRW;
  private boolean closed;
  int dkq;
  
  static
  {
    AppMethodBeat.i(186924);
    logger = Logger.getLogger(e.class.getName());
    AppMethodBeat.o(186924);
  }
  
  j(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(186873);
    this.ajPn = paramg;
    this.ajQR = paramBoolean;
    this.ajRV = new f();
    this.ajRW = new d.b(this.ajRV);
    this.dkq = 16384;
    AppMethodBeat.o(186873);
  }
  
  private void a(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    AppMethodBeat.i(186878);
    if (logger.isLoggable(Level.FINE)) {
      logger.fine(e.a(false, paramInt1, paramInt2, paramByte1, paramByte2));
    }
    IllegalArgumentException localIllegalArgumentException;
    if (paramInt2 > this.dkq)
    {
      localIllegalArgumentException = e.t("FRAME_SIZE_ERROR length > %d: %d", new Object[] { Integer.valueOf(this.dkq), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(186878);
      throw localIllegalArgumentException;
    }
    if ((0x80000000 & paramInt1) != 0)
    {
      localIllegalArgumentException = e.t("reserved bit set: %s", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(186878);
      throw localIllegalArgumentException;
    }
    a(this.ajPn, paramInt2);
    this.ajPn.aNh(paramByte1 & 0xFF);
    this.ajPn.aNh(paramByte2 & 0xFF);
    this.ajPn.aNl(0x7FFFFFFF & paramInt1);
    AppMethodBeat.o(186878);
  }
  
  private static void a(g paramg, int paramInt)
  {
    AppMethodBeat.i(186908);
    paramg.aNh(paramInt >>> 16 & 0xFF);
    paramg.aNh(paramInt >>> 8 & 0xFF);
    paramg.aNh(paramInt & 0xFF);
    AppMethodBeat.o(186908);
  }
  
  private void by(int paramInt, long paramLong)
  {
    AppMethodBeat.i(186920);
    if (paramLong > 0L)
    {
      int i = (int)Math.min(this.dkq, paramLong);
      paramLong -= i;
      if (paramLong == 0L) {}
      for (byte b = 4;; b = 0)
      {
        a(paramInt, i, (byte)9, b);
        this.ajPn.b(this.ajRV, i);
        break;
      }
    }
    AppMethodBeat.o(186920);
  }
  
  public final void a(int paramInt, b paramb, byte[] paramArrayOfByte)
  {
    try
    {
      AppMethodBeat.i(187012);
      if (this.closed)
      {
        paramb = new IOException("closed");
        AppMethodBeat.o(187012);
        throw paramb;
      }
    }
    finally {}
    if (paramb.ajQj == -1)
    {
      paramb = e.t("errorCode.httpCode == -1", new Object[0]);
      AppMethodBeat.o(187012);
      throw paramb;
    }
    a(0, paramArrayOfByte.length + 8, (byte)7, (byte)0);
    this.ajPn.aNl(paramInt);
    this.ajPn.aNl(paramb.ajQj);
    if (paramArrayOfByte.length > 0) {
      this.ajPn.ee(paramArrayOfByte);
    }
    this.ajPn.flush();
    AppMethodBeat.o(187012);
  }
  
  public final void a(boolean paramBoolean, int paramInt1, f paramf, int paramInt2)
  {
    byte b = 0;
    try
    {
      AppMethodBeat.i(186979);
      if (this.closed)
      {
        paramf = new IOException("closed");
        AppMethodBeat.o(186979);
        throw paramf;
      }
    }
    finally {}
    if (paramBoolean) {
      b = 1;
    }
    a(paramInt1, paramInt2, (byte)0, b);
    if (paramInt2 > 0) {
      this.ajPn.b(paramf, paramInt2);
    }
    AppMethodBeat.o(186979);
  }
  
  public final void b(m paramm)
  {
    try
    {
      AppMethodBeat.i(186943);
      if (this.closed)
      {
        paramm = new IOException("closed");
        AppMethodBeat.o(186943);
        throw paramm;
      }
    }
    finally {}
    int i = this.dkq;
    if ((paramm.ajSe & 0x20) != 0) {
      i = paramm.aql[5];
    }
    this.dkq = i;
    if (paramm.kIg() != -1) {
      this.ajRW.aNb(paramm.kIg());
    }
    a(0, 0, (byte)4, (byte)1);
    this.ajPn.flush();
    AppMethodBeat.o(186943);
  }
  
  public final void b(boolean paramBoolean, int paramInt, List<c> paramList)
  {
    try
    {
      AppMethodBeat.i(186960);
      if (this.closed)
      {
        paramList = new IOException("closed");
        AppMethodBeat.o(186960);
        throw paramList;
      }
    }
    finally {}
    if (this.closed)
    {
      paramList = new IOException("closed");
      AppMethodBeat.o(186960);
      throw paramList;
    }
    this.ajRW.pl(paramList);
    long l = this.ajRV.size;
    int i = (int)Math.min(this.dkq, l);
    byte b1;
    if (l == i) {
      b1 = 4;
    }
    for (;;)
    {
      a(paramInt, i, (byte)1, b2);
      this.ajPn.b(this.ajRV, i);
      if (l > i) {
        by(paramInt, l - i);
      }
      AppMethodBeat.o(186960);
      return;
      b1 = 0;
      byte b2 = b1;
      if (paramBoolean) {
        b2 = (byte)(b1 | 0x1);
      }
    }
  }
  
  public final void bx(int paramInt, long paramLong)
  {
    try
    {
      AppMethodBeat.i(187024);
      if (this.closed)
      {
        IOException localIOException = new IOException("closed");
        AppMethodBeat.o(187024);
        throw localIOException;
      }
    }
    finally {}
    if ((paramLong == 0L) || (paramLong > 2147483647L))
    {
      IllegalArgumentException localIllegalArgumentException = e.t("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(187024);
      throw localIllegalArgumentException;
    }
    a(paramInt, 4, (byte)8, (byte)0);
    this.ajPn.aNl((int)paramLong);
    this.ajPn.flush();
    AppMethodBeat.o(187024);
  }
  
  public final void c(int paramInt, b paramb)
  {
    try
    {
      AppMethodBeat.i(186969);
      if (this.closed)
      {
        paramb = new IOException("closed");
        AppMethodBeat.o(186969);
        throw paramb;
      }
    }
    finally {}
    if (paramb.ajQj == -1)
    {
      paramb = new IllegalArgumentException();
      AppMethodBeat.o(186969);
      throw paramb;
    }
    a(paramInt, 4, (byte)3, (byte)0);
    this.ajPn.aNl(paramb.ajQj);
    this.ajPn.flush();
    AppMethodBeat.o(186969);
  }
  
  public final void c(m paramm)
  {
    int i = 0;
    try
    {
      AppMethodBeat.i(186993);
      if (this.closed)
      {
        paramm = new IOException("closed");
        AppMethodBeat.o(186993);
        throw paramm;
      }
    }
    finally {}
    a(0, Integer.bitCount(paramm.ajSe) * 6, (byte)4, (byte)0);
    int j;
    if (i < 10)
    {
      if (!paramm.hT(i)) {
        break label128;
      }
      if (i != 4) {
        break label135;
      }
      j = 3;
    }
    for (;;)
    {
      label76:
      this.ajPn.aNj(j);
      this.ajPn.aNl(paramm.aql[i]);
      break label128;
      this.ajPn.flush();
      AppMethodBeat.o(186993);
      return;
      label128:
      label135:
      do
      {
        j = i;
        break label76;
        i += 1;
        break;
      } while (i != 7);
      j = 4;
    }
  }
  
  public final void close()
  {
    try
    {
      AppMethodBeat.i(187028);
      this.closed = true;
      this.ajPn.close();
      AppMethodBeat.o(187028);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void flush()
  {
    try
    {
      AppMethodBeat.i(186949);
      if (this.closed)
      {
        IOException localIOException = new IOException("closed");
        AppMethodBeat.o(186949);
        throw localIOException;
      }
    }
    finally {}
    this.ajPn.flush();
    AppMethodBeat.o(186949);
  }
  
  public final void kIb()
  {
    try
    {
      AppMethodBeat.i(186933);
      if (this.closed)
      {
        IOException localIOException = new IOException("closed");
        AppMethodBeat.o(186933);
        throw localIOException;
      }
    }
    finally {}
    if (!this.ajQR) {
      AppMethodBeat.o(186933);
    }
    for (;;)
    {
      return;
      if (logger.isLoggable(Level.FINE)) {
        logger.fine(okhttp3.internal.c.format(">> CONNECTION %s", new Object[] { e.ajQG.kIL() }));
      }
      this.ajPn.ee(e.ajQG.toByteArray());
      this.ajPn.flush();
      AppMethodBeat.o(186933);
    }
  }
  
  public final void x(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    byte b = 0;
    try
    {
      AppMethodBeat.i(187000);
      if (this.closed)
      {
        IOException localIOException = new IOException("closed");
        AppMethodBeat.o(187000);
        throw localIOException;
      }
    }
    finally {}
    if (paramBoolean) {
      b = 1;
    }
    a(0, 8, (byte)6, b);
    this.ajPn.aNl(paramInt1);
    this.ajPn.aNl(paramInt2);
    this.ajPn.flush();
    AppMethodBeat.o(187000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.e.j
 * JD-Core Version:    0.7.0.1
 */