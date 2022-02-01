package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class t
{
  private static final Pattern ajNc;
  private static final Pattern ajNd;
  private final String ajNe;
  private final String charset;
  private final String nBd;
  private final String type;
  
  static
  {
    AppMethodBeat.i(186664);
    ajNc = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    ajNd = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    AppMethodBeat.o(186664);
  }
  
  private t(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.nBd = paramString1;
    this.type = paramString2;
    this.ajNe = paramString3;
    this.charset = paramString4;
  }
  
  public static t bKt(String paramString)
  {
    AppMethodBeat.i(186661);
    Object localObject1;
    try
    {
      localObject1 = ajNc.matcher(paramString);
      if (!((Matcher)localObject1).lookingAt())
      {
        paramString = new IllegalArgumentException("No subtype found for: \"" + paramString + '"');
        AppMethodBeat.o(186661);
        throw paramString;
      }
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(186661);
      return null;
    }
    String str1 = ((Matcher)localObject1).group(1).toLowerCase(Locale.US);
    String str2 = ((Matcher)localObject1).group(2).toLowerCase(Locale.US);
    Matcher localMatcher = ajNd.matcher(paramString);
    int i = ((Matcher)localObject1).end();
    Object localObject2 = null;
    Object localObject3;
    if (i < paramString.length())
    {
      localMatcher.region(i, paramString.length());
      if (!localMatcher.lookingAt())
      {
        paramString = new IllegalArgumentException("Parameter is not formatted correctly: \"" + paramString.substring(i) + "\" for: \"" + paramString + '"');
        AppMethodBeat.o(186661);
        throw paramString;
      }
      localObject1 = localMatcher.group(1);
      if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase("charset"))) {
        break label382;
      }
      localObject3 = localMatcher.group(2);
      if (localObject3 != null)
      {
        localObject1 = localObject3;
        if (((String)localObject3).startsWith("'"))
        {
          localObject1 = localObject3;
          if (((String)localObject3).endsWith("'"))
          {
            localObject1 = localObject3;
            if (((String)localObject3).length() <= 2) {}
          }
        }
      }
      for (localObject1 = ((String)localObject3).substring(1, ((String)localObject3).length() - 1);; localObject1 = localMatcher.group(3))
      {
        localObject3 = localObject1;
        if (localObject2 == null) {
          break;
        }
        localObject3 = localObject1;
        if (((String)localObject1).equalsIgnoreCase((String)localObject2)) {
          break;
        }
        paramString = new IllegalArgumentException("Multiple charsets defined: \"" + (String)localObject2 + "\" and: \"" + (String)localObject1 + "\" for: \"" + paramString + '"');
        AppMethodBeat.o(186661);
        throw paramString;
      }
    }
    for (;;)
    {
      i = localMatcher.end();
      localObject2 = localObject3;
      break;
      paramString = new t(paramString, str1, str2, (String)localObject2);
      AppMethodBeat.o(186661);
      return paramString;
      label382:
      localObject3 = localObject2;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(186670);
    if (((paramObject instanceof t)) && (((t)paramObject).nBd.equals(this.nBd)))
    {
      AppMethodBeat.o(186670);
      return true;
    }
    AppMethodBeat.o(186670);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(186675);
    int i = this.nBd.hashCode();
    AppMethodBeat.o(186675);
    return i;
  }
  
  public final String toString()
  {
    return this.nBd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     okhttp3.t
 * JD-Core Version:    0.7.0.1
 */