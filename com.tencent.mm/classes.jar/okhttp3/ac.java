package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum ac
{
  final String ajMe;
  
  static
  {
    AppMethodBeat.i(186591);
    ajOb = new ac("TLS_1_3", 0, "TLSv1.3");
    ajOc = new ac("TLS_1_2", 1, "TLSv1.2");
    ajOd = new ac("TLS_1_1", 2, "TLSv1.1");
    ajOe = new ac("TLS_1_0", 3, "TLSv1");
    ajOf = new ac("SSL_3_0", 4, "SSLv3");
    ajOg = new ac[] { ajOb, ajOc, ajOd, ajOe, ajOf };
    AppMethodBeat.o(186591);
  }
  
  private ac(String paramString)
  {
    this.ajMe = paramString;
  }
  
  static List<ac> aq(String... paramVarArgs)
  {
    AppMethodBeat.i(186582);
    ArrayList localArrayList = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(bKx(paramVarArgs[i]));
      i += 1;
    }
    paramVarArgs = Collections.unmodifiableList(localArrayList);
    AppMethodBeat.o(186582);
    return paramVarArgs;
  }
  
  public static ac bKx(String paramString)
  {
    AppMethodBeat.i(186572);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramString = new IllegalArgumentException("Unexpected TLS version: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(186572);
        throw paramString;
        if (paramString.equals("TLSv1.3"))
        {
          i = 0;
          continue;
          if (paramString.equals("TLSv1.2"))
          {
            i = 1;
            continue;
            if (paramString.equals("TLSv1.1"))
            {
              i = 2;
              continue;
              if (paramString.equals("TLSv1"))
              {
                i = 3;
                continue;
                if (paramString.equals("SSLv3")) {
                  i = 4;
                }
              }
            }
          }
        }
        break;
      }
    }
    paramString = ajOb;
    AppMethodBeat.o(186572);
    return paramString;
    paramString = ajOc;
    AppMethodBeat.o(186572);
    return paramString;
    paramString = ajOd;
    AppMethodBeat.o(186572);
    return paramString;
    paramString = ajOe;
    AppMethodBeat.o(186572);
    return paramString;
    paramString = ajOf;
    AppMethodBeat.o(186572);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.ac
 * JD-Core Version:    0.7.0.1
 */