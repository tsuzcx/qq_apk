package okhttp3.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import okhttp3.aa;
import okhttp3.t;

public final class h
  extends aa
{
  private final String ajPR;
  private final j.h cnO;
  private final long contentLength;
  
  public h(String paramString, long paramLong, j.h paramh)
  {
    this.ajPR = paramString;
    this.contentLength = paramLong;
    this.cnO = paramh;
  }
  
  public final long kGA()
  {
    return this.contentLength;
  }
  
  public final j.h kGB()
  {
    return this.cnO;
  }
  
  public final t kGz()
  {
    AppMethodBeat.i(186780);
    if (this.ajPR != null)
    {
      t localt = t.bKt(this.ajPR);
      AppMethodBeat.o(186780);
      return localt;
    }
    AppMethodBeat.o(186780);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.c.h
 * JD-Core Version:    0.7.0.1
 */