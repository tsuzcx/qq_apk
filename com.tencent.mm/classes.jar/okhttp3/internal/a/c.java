package okhttp3.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Date;
import okhttp3.internal.c.e;
import okhttp3.q;
import okhttp3.x;
import okhttp3.z;

public final class c
{
  public final z ajNT;
  public final x ajOC;
  
  c(x paramx, z paramz)
  {
    this.ajOC = paramx;
    this.ajNT = paramz;
  }
  
  public static boolean a(z paramz, x paramx)
  {
    AppMethodBeat.i(187046);
    switch (paramz.code)
    {
    default: 
    case 302: 
    case 307: 
      do
      {
        AppMethodBeat.o(187046);
        return false;
      } while ((paramz.bKv("Expires") == null) && (paramz.kHg().ajJB == -1) && (!paramz.kHg().ajJD) && (!paramz.kHg().Gdb));
    }
    if ((!paramz.kHg().ajJA) && (!paramx.kHg().ajJA))
    {
      AppMethodBeat.o(187046);
      return true;
    }
    AppMethodBeat.o(187046);
    return false;
  }
  
  public static final class a
  {
    Date afyo;
    long ajJv;
    long ajJw;
    final x ajNQ;
    final z ajNT;
    final long ajOD;
    Date ajOE;
    String ajOF;
    Date ajOG;
    String ajOH;
    String ajOI;
    int ajOJ;
    
    public a(long paramLong, x paramx, z paramz)
    {
      AppMethodBeat.i(187042);
      this.ajOJ = -1;
      this.ajOD = paramLong;
      this.ajNQ = paramx;
      this.ajNT = paramz;
      if (paramz != null)
      {
        this.ajJv = paramz.ajNV;
        this.ajJw = paramz.ajNW;
        paramx = paramz.cnu;
        int i = 0;
        int j = paramx.ajMS.length / 2;
        if (i < j)
        {
          paramz = paramx.aMS(i);
          String str = paramx.aMT(i);
          if ("Date".equalsIgnoreCase(paramz))
          {
            this.ajOE = okhttp3.internal.c.d.abt(str);
            this.ajOF = str;
          }
          for (;;)
          {
            i += 1;
            break;
            if ("Expires".equalsIgnoreCase(paramz))
            {
              this.afyo = okhttp3.internal.c.d.abt(str);
            }
            else if ("Last-Modified".equalsIgnoreCase(paramz))
            {
              this.ajOG = okhttp3.internal.c.d.abt(str);
              this.ajOH = str;
            }
            else if ("ETag".equalsIgnoreCase(paramz))
            {
              this.ajOI = str;
            }
            else if ("Age".equalsIgnoreCase(paramz))
            {
              this.ajOJ = e.jY(str, -1);
            }
          }
        }
      }
      AppMethodBeat.o(187042);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.a.c
 * JD-Core Version:    0.7.0.1
 */