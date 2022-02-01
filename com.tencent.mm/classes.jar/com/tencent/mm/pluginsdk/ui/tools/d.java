package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static boolean aOK(String paramString)
  {
    AppMethodBeat.i(152380);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.AppNewIconUtil", "markNew fail, appId is empty");
      AppMethodBeat.o(152380);
      return false;
    }
    aj localaj = g.ajR().ajA();
    if (localaj == null)
    {
      ae.e("MicroMsg.AppNewIconUtil", "markNew fail, cfgStg is null");
      AppMethodBeat.o(152380);
      return false;
    }
    a locala = new a((byte)0);
    locala.aya((String)localaj.get(69121, null));
    if (!locala.yXw.contains(paramString)) {
      locala.yXw.add(paramString);
    }
    localaj.set(69121, locala.fiP());
    AppMethodBeat.o(152380);
    return true;
  }
  
  public static boolean aOL(String paramString)
  {
    AppMethodBeat.i(152381);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, appId is empty");
      AppMethodBeat.o(152381);
      return false;
    }
    aj localaj = g.ajR().ajA();
    if (localaj == null)
    {
      ae.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, cfgStg is null");
      AppMethodBeat.o(152381);
      return false;
    }
    a locala = new a((byte)0);
    locala.aya((String)localaj.get(69121, null));
    if (locala.yXw.contains(paramString)) {
      locala.yXw.remove(paramString);
    }
    localaj.set(69121, locala.fiP());
    AppMethodBeat.o(152381);
    return true;
  }
  
  static final class a
  {
    List<String> yXw;
    
    private a()
    {
      AppMethodBeat.i(152377);
      this.yXw = new ArrayList();
      AppMethodBeat.o(152377);
    }
    
    final void aya(String paramString)
    {
      AppMethodBeat.i(152379);
      this.yXw = new ArrayList();
      if ((paramString == null) || (paramString.length() == 0))
      {
        AppMethodBeat.o(152379);
        return;
      }
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        this.yXw.add(localObject);
        i += 1;
      }
      AppMethodBeat.o(152379);
    }
    
    final String fiP()
    {
      AppMethodBeat.i(152378);
      if ((this.yXw == null) || (this.yXw.size() == 0))
      {
        AppMethodBeat.o(152378);
        return "";
      }
      Object localObject = new StringBuffer();
      Iterator localIterator = this.yXw.iterator();
      while (localIterator.hasNext())
      {
        ((StringBuffer)localObject).append((String)localIterator.next());
        ((StringBuffer)localObject).append(";");
      }
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(152378);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.d
 * JD-Core Version:    0.7.0.1
 */