package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public abstract interface n
{
  public static final n ajML = new n()
  {
    public final List<InetAddress> bKj(String paramAnonymousString)
    {
      AppMethodBeat.i(186592);
      if (paramAnonymousString == null)
      {
        paramAnonymousString = new UnknownHostException("hostname == null");
        AppMethodBeat.o(186592);
        throw paramAnonymousString;
      }
      try
      {
        List localList = Arrays.asList(InetAddress.getAllByName(paramAnonymousString));
        AppMethodBeat.o(186592);
        return localList;
      }
      catch (NullPointerException localNullPointerException)
      {
        paramAnonymousString = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(String.valueOf(paramAnonymousString)));
        paramAnonymousString.initCause(localNullPointerException);
        AppMethodBeat.o(186592);
        throw paramAnonymousString;
      }
    }
  };
  
  public abstract List<InetAddress> bKj(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     okhttp3.n
 * JD-Core Version:    0.7.0.1
 */