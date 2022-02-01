package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static boolean brx(String paramString)
  {
    AppMethodBeat.i(152380);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppNewIconUtil", "markNew fail, appId is empty");
      AppMethodBeat.o(152380);
      return false;
    }
    aq localaq = h.baE().ban();
    if (localaq == null)
    {
      Log.e("MicroMsg.AppNewIconUtil", "markNew fail, cfgStg is null");
      AppMethodBeat.o(152380);
      return false;
    }
    a locala = new a((byte)0);
    locala.aUQ((String)localaq.d(69121, null));
    if (!locala.PtA.contains(paramString)) {
      locala.PtA.add(paramString);
    }
    localaq.B(69121, locala.iNS());
    AppMethodBeat.o(152380);
    return true;
  }
  
  public static boolean bry(String paramString)
  {
    AppMethodBeat.i(152381);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, appId is empty");
      AppMethodBeat.o(152381);
      return false;
    }
    aq localaq = h.baE().ban();
    if (localaq == null)
    {
      Log.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, cfgStg is null");
      AppMethodBeat.o(152381);
      return false;
    }
    a locala = new a((byte)0);
    locala.aUQ((String)localaq.d(69121, null));
    if (locala.PtA.contains(paramString)) {
      locala.PtA.remove(paramString);
    }
    localaq.B(69121, locala.iNS());
    AppMethodBeat.o(152381);
    return true;
  }
  
  static final class a
  {
    List<String> PtA;
    
    private a()
    {
      AppMethodBeat.i(152377);
      this.PtA = new ArrayList();
      AppMethodBeat.o(152377);
    }
    
    final void aUQ(String paramString)
    {
      AppMethodBeat.i(152379);
      this.PtA = new ArrayList();
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
        this.PtA.add(localObject);
        i += 1;
      }
      AppMethodBeat.o(152379);
    }
    
    final String iNS()
    {
      AppMethodBeat.i(152378);
      if ((this.PtA == null) || (this.PtA.size() == 0))
      {
        AppMethodBeat.o(152378);
        return "";
      }
      Object localObject = new StringBuffer();
      Iterator localIterator = this.PtA.iterator();
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