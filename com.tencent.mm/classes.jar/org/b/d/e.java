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
  public final List<d> CRJ;
  
  public e()
  {
    AppMethodBeat.i(77261);
    this.CRJ = new ArrayList();
    AppMethodBeat.o(77261);
  }
  
  public e(List<d> paramList)
  {
    AppMethodBeat.i(77262);
    this.CRJ = new ArrayList(paramList);
    AppMethodBeat.o(77262);
  }
  
  public e(Map<String, String> paramMap)
  {
    this();
    AppMethodBeat.i(77263);
    paramMap = paramMap.entrySet().iterator();
    for (;;)
    {
      if (!paramMap.hasNext())
      {
        AppMethodBeat.o(77263);
        return;
      }
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      this.CRJ.add(new d((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(77265);
    this.CRJ.addAll(parame.CRJ);
    AppMethodBeat.o(77265);
  }
  
  public final void azU(String paramString)
  {
    AppMethodBeat.i(77266);
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
      AppMethodBeat.o(77266);
      return;
    }
    paramString = arrayOfString[i].split("=");
    String str = c.decode(paramString[0]);
    if (paramString.length > 1) {}
    for (paramString = c.decode(paramString[1]);; paramString = "")
    {
      this.CRJ.add(new d(str, paramString));
      i += 1;
      break;
    }
  }
  
  public final String erH()
  {
    AppMethodBeat.i(77264);
    if (this.CRJ.size() == 0)
    {
      AppMethodBeat.o(77264);
      return "";
    }
    Object localObject = new StringBuilder();
    Iterator localIterator = this.CRJ.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        localObject = ((StringBuilder)localObject).toString().substring(1);
        AppMethodBeat.o(77264);
        return localObject;
      }
      d locald = (d)localIterator.next();
      ((StringBuilder)localObject).append('&').append(locald.erG());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.b.d.e
 * JD-Core Version:    0.7.0.1
 */