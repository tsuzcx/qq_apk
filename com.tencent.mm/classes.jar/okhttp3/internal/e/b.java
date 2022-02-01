package okhttp3.internal.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public final int ajQj;
  
  static
  {
    AppMethodBeat.i(186942);
    ajPY = new b("NO_ERROR", 0, 0);
    ajPZ = new b("PROTOCOL_ERROR", 1, 1);
    ajQa = new b("INTERNAL_ERROR", 2, 2);
    ajQb = new b("FLOW_CONTROL_ERROR", 3, 3);
    ajQc = new b("REFUSED_STREAM", 4, 7);
    ajQd = new b("CANCEL", 5, 8);
    ajQe = new b("COMPRESSION_ERROR", 6, 9);
    ajQf = new b("CONNECT_ERROR", 7, 10);
    ajQg = new b("ENHANCE_YOUR_CALM", 8, 11);
    ajQh = new b("INADEQUATE_SECURITY", 9, 12);
    ajQi = new b("HTTP_1_1_REQUIRED", 10, 13);
    ajQk = new b[] { ajPY, ajPZ, ajQa, ajQb, ajQc, ajQd, ajQe, ajQf, ajQg, ajQh, ajQi };
    AppMethodBeat.o(186942);
  }
  
  private b(int paramInt)
  {
    this.ajQj = paramInt;
  }
  
  public static b aMW(int paramInt)
  {
    AppMethodBeat.i(186928);
    b[] arrayOfb = values();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      if (localb.ajQj == paramInt)
      {
        AppMethodBeat.o(186928);
        return localb;
      }
      i += 1;
    }
    AppMethodBeat.o(186928);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.e.b
 * JD-Core Version:    0.7.0.1
 */