package okhttp3.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import okhttp3.internal.c;

public final class d
{
  private static final ThreadLocal<DateFormat> ajPJ;
  private static final String[] ajPK;
  private static final DateFormat[] ajPL;
  
  static
  {
    AppMethodBeat.i(186809);
    ajPJ = new ThreadLocal() {};
    ajPK = new String[] { "EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z" };
    ajPL = new DateFormat[15];
    AppMethodBeat.o(186809);
  }
  
  public static Date abt(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(186790);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(186790);
      return null;
    }
    ParsePosition localParsePosition = new ParsePosition(0);
    Object localObject = ((DateFormat)ajPJ.get()).parse(paramString, localParsePosition);
    if (localParsePosition.getIndex() == paramString.length())
    {
      AppMethodBeat.o(186790);
      return localObject;
    }
    synchronized (ajPK)
    {
      int j = ajPK.length;
      while (i < j)
      {
        DateFormat localDateFormat = ajPL[i];
        localObject = localDateFormat;
        if (localDateFormat == null)
        {
          localObject = new SimpleDateFormat(ajPK[i], Locale.US);
          ((DateFormat)localObject).setTimeZone(c.ajOt);
          ajPL[i] = localObject;
        }
        localParsePosition.setIndex(0);
        localObject = ((DateFormat)localObject).parse(paramString, localParsePosition);
        if (localParsePosition.getIndex() != 0)
        {
          AppMethodBeat.o(186790);
          return localObject;
        }
        i += 1;
      }
      AppMethodBeat.o(186790);
      return null;
    }
  }
  
  public static String d(Date paramDate)
  {
    AppMethodBeat.i(186797);
    paramDate = ((DateFormat)ajPJ.get()).format(paramDate);
    AppMethodBeat.o(186797);
    return paramDate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     okhttp3.internal.c.d
 * JD-Core Version:    0.7.0.1
 */