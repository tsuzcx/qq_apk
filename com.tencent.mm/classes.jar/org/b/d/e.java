package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.b.g.c;

public final class e
{
  public final List<d> Kny;
  
  public e()
  {
    AppMethodBeat.i(40530);
    this.Kny = new ArrayList();
    AppMethodBeat.o(40530);
  }
  
  public e(List<d> paramList)
  {
    AppMethodBeat.i(40531);
    this.Kny = new ArrayList(paramList);
    AppMethodBeat.o(40531);
  }
  
  public e(Map<String, String> paramMap)
  {
    this();
    AppMethodBeat.i(40532);
    paramMap = paramMap.entrySet().iterator();
    for (;;)
    {
      if (!paramMap.hasNext())
      {
        AppMethodBeat.o(40532);
        return;
      }
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      this.Kny.add(new d((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(40534);
    this.Kny.addAll(parame.Kny);
    AppMethodBeat.o(40534);
  }
  
  public final void aRF(String paramString)
  {
    AppMethodBeat.i(40535);
    String[] arrayOfString;
    int i;
    if ((paramString != null) && (paramString.length() > 0))
    {
      arrayOfString = paramString.split("&");
      int j = arrayOfString.length;
      i = 0;
      if (i < j) {}
    }
    else
    {
      AppMethodBeat.o(40535);
      return;
    }
    paramString = arrayOfString[i].split("=");
    String str = c.decode(paramString[0]);
    if (paramString.length > 1) {}
    for (paramString = c.decode(paramString[1]);; paramString = "")
    {
      this.Kny.add(new d(str, paramString));
      i += 1;
      break;
    }
  }
  
  public final String fNj()
  {
    AppMethodBeat.i(40533);
    if (this.Kny.size() == 0)
    {
      AppMethodBeat.o(40533);
      return "";
    }
    Object localObject = new StringBuilder();
    Iterator localIterator = this.Kny.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        localObject = ((StringBuilder)localObject).toString().substring(1);
        AppMethodBeat.o(40533);
        return localObject;
      }
      d locald = (d)localIterator.next();
      ((StringBuilder)localObject).append('&').append(locald.fNi());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.b.d.e
 * JD-Core Version:    0.7.0.1
 */