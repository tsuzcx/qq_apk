package com.tencent.mm.pluginsdk.ui.tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class b$a
{
  List<String> nUB = new ArrayList();
  
  final void LX(String paramString)
  {
    this.nUB = new ArrayList();
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        this.nUB.add(localObject);
        i += 1;
      }
    }
  }
  
  final String cof()
  {
    if ((this.nUB == null) || (this.nUB.size() == 0)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.nUB.iterator();
    while (localIterator.hasNext())
    {
      localStringBuffer.append((String)localIterator.next());
      localStringBuffer.append(";");
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.b.a
 * JD-Core Version:    0.7.0.1
 */