package org.c.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.c.g.c;

public final class e
{
  public final List<d> xux;
  
  public e()
  {
    this.xux = new ArrayList();
  }
  
  public e(List<d> paramList)
  {
    this.xux = new ArrayList(paramList);
  }
  
  public e(Map<String, String> paramMap)
  {
    this();
    paramMap = paramMap.entrySet().iterator();
    for (;;)
    {
      if (!paramMap.hasNext()) {
        return;
      }
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      this.xux.add(new d((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
  }
  
  public final void a(e parame)
  {
    this.xux.addAll(parame.xux);
  }
  
  public final void ahA(String paramString)
  {
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
      return;
    }
    paramString = arrayOfString[i].split("=");
    String str = c.decode(paramString[0]);
    if (paramString.length > 1) {}
    for (paramString = c.decode(paramString[1]);; paramString = "")
    {
      this.xux.add(new d(str, paramString));
      i += 1;
      break;
    }
  }
  
  public final String cVb()
  {
    if (this.xux.size() == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.xux.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localStringBuilder.toString().substring(1);
      }
      d locald = (d)localIterator.next();
      localStringBuilder.append('&').append(c.encode(locald.key).concat("=").concat(c.encode(locald.value)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.c.d.e
 * JD-Core Version:    0.7.0.1
 */