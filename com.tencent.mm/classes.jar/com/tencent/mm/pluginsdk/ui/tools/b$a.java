package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class b$a
{
  List<String> qIG;
  
  private b$a()
  {
    AppMethodBeat.i(79908);
    this.qIG = new ArrayList();
    AppMethodBeat.o(79908);
  }
  
  final void Yy(String paramString)
  {
    AppMethodBeat.i(79910);
    this.qIG = new ArrayList();
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(79910);
      return;
    }
    paramString = paramString.split(";");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      this.qIG.add(localObject);
      i += 1;
    }
    AppMethodBeat.o(79910);
  }
  
  final String dpu()
  {
    AppMethodBeat.i(79909);
    if ((this.qIG == null) || (this.qIG.size() == 0))
    {
      AppMethodBeat.o(79909);
      return "";
    }
    Object localObject = new StringBuffer();
    Iterator localIterator = this.qIG.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuffer)localObject).append((String)localIterator.next());
      ((StringBuffer)localObject).append(";");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(79909);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.b.a
 * JD-Core Version:    0.7.0.1
 */