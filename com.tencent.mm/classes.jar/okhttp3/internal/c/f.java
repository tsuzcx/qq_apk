package okhttp3.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public static boolean bKG(String paramString)
  {
    AppMethodBeat.i(186794);
    if ((paramString.equals("POST")) || (paramString.equals("PATCH")) || (paramString.equals("PUT")) || (paramString.equals("DELETE")) || (paramString.equals("MOVE")))
    {
      AppMethodBeat.o(186794);
      return true;
    }
    AppMethodBeat.o(186794);
    return false;
  }
  
  public static boolean bKH(String paramString)
  {
    AppMethodBeat.i(186804);
    if ((paramString.equals("POST")) || (paramString.equals("PUT")) || (paramString.equals("PATCH")) || (paramString.equals("PROPPATCH")) || (paramString.equals("REPORT")))
    {
      AppMethodBeat.o(186804);
      return true;
    }
    AppMethodBeat.o(186804);
    return false;
  }
  
  public static boolean bKI(String paramString)
  {
    AppMethodBeat.i(186813);
    if ((!paramString.equals("GET")) && (!paramString.equals("HEAD")))
    {
      AppMethodBeat.o(186813);
      return true;
    }
    AppMethodBeat.o(186813);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.c.f
 * JD-Core Version:    0.7.0.1
 */