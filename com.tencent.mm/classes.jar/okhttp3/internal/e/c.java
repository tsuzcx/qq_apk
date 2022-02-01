package okhttp3.internal.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.i;

public final class c
{
  public static final i ajQl;
  public static final i ajQm;
  public static final i ajQn;
  public static final i ajQo;
  public static final i ajQp;
  public static final i ajQq;
  public final i ajQr;
  public final i ajQs;
  final int ajQt;
  
  static
  {
    AppMethodBeat.i(186937);
    ajQl = i.bKT(":");
    ajQm = i.bKT(":status");
    ajQn = i.bKT(":method");
    ajQo = i.bKT(":path");
    ajQp = i.bKT(":scheme");
    ajQq = i.bKT(":authority");
    AppMethodBeat.o(186937);
  }
  
  public c(i parami1, i parami2)
  {
    AppMethodBeat.i(186931);
    this.ajQr = parami1;
    this.ajQs = parami2;
    this.ajQt = (parami1.kIN() + 32 + parami2.kIN());
    AppMethodBeat.o(186931);
  }
  
  public c(i parami, String paramString)
  {
    this(parami, i.bKT(paramString));
    AppMethodBeat.i(186925);
    AppMethodBeat.o(186925);
  }
  
  public c(String paramString1, String paramString2)
  {
    this(i.bKT(paramString1), i.bKT(paramString2));
    AppMethodBeat.i(186918);
    AppMethodBeat.o(186918);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(186946);
    if ((paramObject instanceof c))
    {
      paramObject = (c)paramObject;
      if ((this.ajQr.equals(paramObject.ajQr)) && (this.ajQs.equals(paramObject.ajQs)))
      {
        AppMethodBeat.o(186946);
        return true;
      }
      AppMethodBeat.o(186946);
      return false;
    }
    AppMethodBeat.o(186946);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(186954);
    int i = this.ajQr.hashCode();
    int j = this.ajQs.hashCode();
    AppMethodBeat.o(186954);
    return (i + 527) * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186961);
    String str = okhttp3.internal.c.format("%s: %s", new Object[] { this.ajQr.kIJ(), this.ajQs.kIJ() });
    AppMethodBeat.o(186961);
    return str;
  }
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.e.c
 * JD-Core Version:    0.7.0.1
 */