package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static boolean aHL(String paramString)
  {
    AppMethodBeat.i(152380);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.AppNewIconUtil", "markNew fail, appId is empty");
      AppMethodBeat.o(152380);
      return false;
    }
    ae localae = g.agR().agA();
    if (localae == null)
    {
      ac.e("MicroMsg.AppNewIconUtil", "markNew fail, cfgStg is null");
      AppMethodBeat.o(152380);
      return false;
    }
    a locala = new a((byte)0);
    locala.arK((String)localae.get(69121, null));
    if (!locala.xsD.contains(paramString)) {
      locala.xsD.add(paramString);
    }
    localae.set(69121, locala.ePX());
    AppMethodBeat.o(152380);
    return true;
  }
  
  public static boolean aHM(String paramString)
  {
    AppMethodBeat.i(152381);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, appId is empty");
      AppMethodBeat.o(152381);
      return false;
    }
    ae localae = g.agR().agA();
    if (localae == null)
    {
      ac.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, cfgStg is null");
      AppMethodBeat.o(152381);
      return false;
    }
    a locala = new a((byte)0);
    locala.arK((String)localae.get(69121, null));
    if (locala.xsD.contains(paramString)) {
      locala.xsD.remove(paramString);
    }
    localae.set(69121, locala.ePX());
    AppMethodBeat.o(152381);
    return true;
  }
  
  static final class a
  {
    List<String> xsD;
    
    private a()
    {
      AppMethodBeat.i(152377);
      this.xsD = new ArrayList();
      AppMethodBeat.o(152377);
    }
    
    final void arK(String paramString)
    {
      AppMethodBeat.i(152379);
      this.xsD = new ArrayList();
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
        this.xsD.add(localObject);
        i += 1;
      }
      AppMethodBeat.o(152379);
    }
    
    final String ePX()
    {
      AppMethodBeat.i(152378);
      if ((this.xsD == null) || (this.xsD.size() == 0))
      {
        AppMethodBeat.o(152378);
        return "";
      }
      Object localObject = new StringBuffer();
      Iterator localIterator = this.xsD.iterator();
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