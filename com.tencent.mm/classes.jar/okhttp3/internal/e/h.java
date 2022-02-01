package okhttp3.internal.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.aa;
import j.ab;
import j.f;
import j.i;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class h
  implements Closeable
{
  static final Logger logger;
  final boolean ajQR;
  private final a ajRE;
  final d.a ajRF;
  final j.h cnO;
  
  static
  {
    AppMethodBeat.i(186935);
    logger = Logger.getLogger(e.class.getName());
    AppMethodBeat.o(186935);
  }
  
  h(j.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(186902);
    this.cnO = paramh;
    this.ajQR = paramBoolean;
    this.ajRE = new a(this.cnO);
    this.ajRF = new d.a(this.ajRE);
    AppMethodBeat.o(186902);
  }
  
  private static int a(int paramInt, byte paramByte, short paramShort)
  {
    AppMethodBeat.i(186930);
    short s = paramInt;
    if ((paramByte & 0x8) != 0) {
      s = paramInt - 1;
    }
    if (paramShort > s)
    {
      IOException localIOException = e.u("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] { Short.valueOf(paramShort), Integer.valueOf(s) });
      AppMethodBeat.o(186930);
      throw localIOException;
    }
    paramInt = (short)(s - paramShort);
    AppMethodBeat.o(186930);
    return paramInt;
  }
  
  private List<c> a(int paramInt1, short paramShort, byte paramByte, int paramInt2)
  {
    AppMethodBeat.i(186907);
    Object localObject = this.ajRE;
    this.ajRE.left = paramInt1;
    ((a)localObject).length = paramInt1;
    this.ajRE.ajRH = paramShort;
    this.ajRE.ajRG = paramByte;
    this.ajRE.streamId = paramInt2;
    this.ajRF.kHJ();
    localObject = this.ajRF.kHK();
    AppMethodBeat.o(186907);
    return localObject;
  }
  
  static int d(j.h paramh)
  {
    AppMethodBeat.i(186923);
    int i = paramh.readByte();
    int j = paramh.readByte();
    int k = paramh.readByte();
    AppMethodBeat.o(186923);
    return (i & 0xFF) << 16 | (j & 0xFF) << 8 | k & 0xFF;
  }
  
  private void kHS()
  {
    AppMethodBeat.i(186915);
    this.cnO.readInt();
    this.cnO.readByte();
    AppMethodBeat.o(186915);
  }
  
  public final boolean a(boolean paramBoolean, b paramb)
  {
    short s2 = 0;
    boolean bool = false;
    short s1 = 0;
    AppMethodBeat.i(187014);
    int k;
    try
    {
      this.cnO.Cc(9L);
      k = d(this.cnO);
      if ((k < 0) || (k > 16384))
      {
        paramb = e.u("FRAME_SIZE_ERROR: %s", new Object[] { Integer.valueOf(k) });
        AppMethodBeat.o(187014);
        throw paramb;
      }
    }
    catch (IOException paramb)
    {
      AppMethodBeat.o(187014);
      return false;
    }
    byte b1 = (byte)(this.cnO.readByte() & 0xFF);
    if ((paramBoolean) && (b1 != 4))
    {
      paramb = e.u("Expected a SETTINGS frame but was %s", new Object[] { Byte.valueOf(b1) });
      AppMethodBeat.o(187014);
      throw paramb;
    }
    byte b2 = (byte)(this.cnO.readByte() & 0xFF);
    int j = this.cnO.readInt() & 0x7FFFFFFF;
    if (logger.isLoggable(Level.FINE)) {
      logger.fine(e.a(true, j, k, b1, b2));
    }
    switch (b1)
    {
    default: 
      this.cnO.Ci(k);
    case 0: 
      for (;;)
      {
        AppMethodBeat.o(187014);
        return true;
        if (j == 0)
        {
          paramb = e.u("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
          AppMethodBeat.o(187014);
          throw paramb;
        }
        if ((b2 & 0x1) != 0)
        {
          paramBoolean = true;
          if ((b2 & 0x20) == 0) {
            break label328;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label334;
          }
          paramb = e.u("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
          AppMethodBeat.o(187014);
          throw paramb;
          paramBoolean = false;
          break;
        }
        if ((b2 & 0x8) != 0) {
          s1 = (short)(this.cnO.readByte() & 0xFF);
        }
        i = a(k, b2, s1);
        paramb.a(paramBoolean, j, this.cnO, i);
        this.cnO.Ci(s1);
      }
    case 1: 
      label328:
      label334:
      if (j == 0)
      {
        paramb = e.u("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        AppMethodBeat.o(187014);
        throw paramb;
      }
      if ((b2 & 0x1) != 0)
      {
        paramBoolean = true;
        label430:
        if ((b2 & 0x8) == 0) {
          break label508;
        }
        s1 = (short)(this.cnO.readByte() & 0xFF);
        label454:
        if ((b2 & 0x20) == 0) {
          break label1447;
        }
        kHS();
      }
      break;
    }
    label1447:
    for (int i = k - 5;; i = k)
    {
      paramb.a(paramBoolean, j, a(a(i, b2, s1), s1, b2, j));
      break;
      paramBoolean = false;
      break label430;
      label508:
      s1 = 0;
      break label454;
      if (k != 5)
      {
        paramb = e.u("TYPE_PRIORITY length: %d != 5", new Object[] { Integer.valueOf(k) });
        AppMethodBeat.o(187014);
        throw paramb;
      }
      if (j == 0)
      {
        paramb = e.u("TYPE_PRIORITY streamId == 0", new Object[0]);
        AppMethodBeat.o(187014);
        throw paramb;
      }
      kHS();
      break;
      if (k != 4)
      {
        paramb = e.u("TYPE_RST_STREAM length: %d != 4", new Object[] { Integer.valueOf(k) });
        AppMethodBeat.o(187014);
        throw paramb;
      }
      if (j == 0)
      {
        paramb = e.u("TYPE_RST_STREAM streamId == 0", new Object[0]);
        AppMethodBeat.o(187014);
        throw paramb;
      }
      i = this.cnO.readInt();
      Object localObject = b.aMW(i);
      if (localObject == null)
      {
        paramb = e.u("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(187014);
        throw paramb;
      }
      paramb.c(j, (b)localObject);
      break;
      if (j != 0)
      {
        paramb = e.u("TYPE_SETTINGS streamId != 0", new Object[0]);
        AppMethodBeat.o(187014);
        throw paramb;
      }
      if ((b2 & 0x1) != 0)
      {
        if (k == 0) {
          break;
        }
        paramb = e.u("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        AppMethodBeat.o(187014);
        throw paramb;
      }
      if (k % 6 != 0)
      {
        paramb = e.u("TYPE_SETTINGS length %% 6 != 0: %s", new Object[] { Integer.valueOf(k) });
        AppMethodBeat.o(187014);
        throw paramb;
      }
      localObject = new m();
      j = 0;
      if (j < k)
      {
        int m = this.cnO.readShort() & 0xFFFF;
        int n = this.cnO.readInt();
        i = m;
        switch (m)
        {
        default: 
          i = m;
        }
        do
        {
          do
          {
            for (;;)
            {
              ((m)localObject).qG(i, n);
              j += 6;
              break;
              i = m;
              if (n != 0)
              {
                i = m;
                if (n != 1)
                {
                  paramb = e.u("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                  AppMethodBeat.o(187014);
                  throw paramb;
                  i = 4;
                }
              }
            }
            i = 7;
          } while (n >= 0);
          paramb = e.u("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
          AppMethodBeat.o(187014);
          throw paramb;
          if (n < 16384) {
            break label967;
          }
          i = m;
        } while (n <= 16777215);
        label967:
        paramb = e.u("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] { Integer.valueOf(n) });
        AppMethodBeat.o(187014);
        throw paramb;
      }
      paramb.a((m)localObject);
      break;
      if (j == 0)
      {
        paramb = e.u("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        AppMethodBeat.o(187014);
        throw paramb;
      }
      s1 = s2;
      if ((b2 & 0x8) != 0) {
        s1 = (short)(this.cnO.readByte() & 0xFF);
      }
      paramb.Y(this.cnO.readInt() & 0x7FFFFFFF, a(a(k - 4, b2, s1), s1, b2, j));
      break;
      if (k != 8)
      {
        paramb = e.u("TYPE_PING length != 8: %s", new Object[] { Integer.valueOf(k) });
        AppMethodBeat.o(187014);
        throw paramb;
      }
      if (j != 0)
      {
        paramb = e.u("TYPE_PING streamId != 0", new Object[0]);
        AppMethodBeat.o(187014);
        throw paramb;
      }
      i = this.cnO.readInt();
      j = this.cnO.readInt();
      paramBoolean = bool;
      if ((b2 & 0x1) != 0) {
        paramBoolean = true;
      }
      paramb.x(paramBoolean, i, j);
      break;
      if (k < 8)
      {
        paramb = e.u("TYPE_GOAWAY length < 8: %s", new Object[] { Integer.valueOf(k) });
        AppMethodBeat.o(187014);
        throw paramb;
      }
      if (j != 0)
      {
        paramb = e.u("TYPE_GOAWAY streamId != 0", new Object[0]);
        AppMethodBeat.o(187014);
        throw paramb;
      }
      i = this.cnO.readInt();
      j = this.cnO.readInt();
      k -= 8;
      if (b.aMW(j) == null)
      {
        paramb = e.u("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(j) });
        AppMethodBeat.o(187014);
        throw paramb;
      }
      localObject = i.ajTe;
      if (k > 0) {
        localObject = this.cnO.Ce(k);
      }
      paramb.a(i, (i)localObject);
      break;
      if (k != 4)
      {
        paramb = e.u("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] { Integer.valueOf(k) });
        AppMethodBeat.o(187014);
        throw paramb;
      }
      long l = this.cnO.readInt() & 0x7FFFFFFF;
      if (l == 0L)
      {
        paramb = e.u("windowSizeIncrement was 0", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(187014);
        throw paramb;
      }
      paramb.bx(j, l);
      break;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(187018);
    this.cnO.close();
    AppMethodBeat.o(187018);
  }
  
  static final class a
    implements aa
  {
    byte ajRG;
    short ajRH;
    private final j.h cnO;
    int left;
    int length;
    int streamId;
    
    a(j.h paramh)
    {
      this.cnO = paramh;
    }
    
    public final long a(f paramf, long paramLong)
    {
      AppMethodBeat.i(186970);
      while (this.left == 0)
      {
        this.cnO.Ci(this.ajRH);
        this.ajRH = 0;
        if ((this.ajRG & 0x4) != 0)
        {
          AppMethodBeat.o(186970);
          return -1L;
        }
        int i = this.streamId;
        int j = h.d(this.cnO);
        this.left = j;
        this.length = j;
        byte b = (byte)(this.cnO.readByte() & 0xFF);
        this.ajRG = ((byte)(this.cnO.readByte() & 0xFF));
        if (h.logger.isLoggable(Level.FINE)) {
          h.logger.fine(e.a(true, this.streamId, this.length, b, this.ajRG));
        }
        this.streamId = (this.cnO.readInt() & 0x7FFFFFFF);
        if (b != 9)
        {
          paramf = e.u("%s != TYPE_CONTINUATION", new Object[] { Byte.valueOf(b) });
          AppMethodBeat.o(186970);
          throw paramf;
        }
        if (this.streamId != i)
        {
          paramf = e.u("TYPE_CONTINUATION streamId changed", new Object[0]);
          AppMethodBeat.o(186970);
          throw paramf;
        }
      }
      paramLong = this.cnO.a(paramf, Math.min(paramLong, this.left));
      if (paramLong == -1L)
      {
        AppMethodBeat.o(186970);
        return -1L;
      }
      this.left = ((int)(this.left - paramLong));
      AppMethodBeat.o(186970);
      return paramLong;
    }
    
    public final void close() {}
    
    public final ab kHm()
    {
      AppMethodBeat.i(186976);
      ab localab = this.cnO.kHm();
      AppMethodBeat.o(186976);
      return localab;
    }
  }
  
  static abstract interface b
  {
    public abstract void Y(int paramInt, List<c> paramList);
    
    public abstract void a(int paramInt, i parami);
    
    public abstract void a(m paramm);
    
    public abstract void a(boolean paramBoolean, int paramInt1, j.h paramh, int paramInt2);
    
    public abstract void a(boolean paramBoolean, int paramInt, List<c> paramList);
    
    public abstract void bx(int paramInt, long paramLong);
    
    public abstract void c(int paramInt, b paramb);
    
    public abstract void x(boolean paramBoolean, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.e.h
 * JD-Core Version:    0.7.0.1
 */