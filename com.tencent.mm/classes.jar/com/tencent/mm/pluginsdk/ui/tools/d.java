package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static boolean brI(String paramString)
  {
    AppMethodBeat.i(152380);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppNewIconUtil", "markNew fail, appId is empty");
      AppMethodBeat.o(152380);
      return false;
    }
    ao localao = h.aHG().aHp();
    if (localao == null)
    {
      Log.e("MicroMsg.AppNewIconUtil", "markNew fail, cfgStg is null");
      AppMethodBeat.o(152380);
      return false;
    }
    a locala = new a((byte)0);
    locala.aXl((String)localao.b(69121, null));
    if (!locala.JhO.contains(paramString)) {
      locala.JhO.add(paramString);
    }
    localao.i(69121, locala.hnc());
    AppMethodBeat.o(152380);
    return true;
  }
  
  public static boolean brJ(String paramString)
  {
    AppMethodBeat.i(152381);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, appId is empty");
      AppMethodBeat.o(152381);
      return false;
    }
    ao localao = h.aHG().aHp();
    if (localao == null)
    {
      Log.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, cfgStg is null");
      AppMethodBeat.o(152381);
      return false;
    }
    a locala = new a((byte)0);
    locala.aXl((String)localao.b(69121, null));
    if (locala.JhO.contains(paramString)) {
      locala.JhO.remove(paramString);
    }
    localao.i(69121, locala.hnc());
    AppMethodBeat.o(152381);
    return true;
  }
  
  static final class a
  {
    List<String> JhO;
    
    private a()
    {
      AppMethodBeat.i(152377);
      this.JhO = new ArrayList();
      AppMethodBeat.o(152377);
    }
    
    final void aXl(String paramString)
    {
      AppMethodBeat.i(152379);
      this.JhO = new ArrayList();
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
        this.JhO.add(localObject);
        i += 1;
      }
      AppMethodBeat.o(152379);
    }
    
    final String hnc()
    {
      AppMethodBeat.i(152378);
      if ((this.JhO == null) || (this.JhO.size() == 0))
      {
        AppMethodBeat.o(152378);
        return "";
      }
      Object localObject = new StringBuffer();
      Iterator localIterator = this.JhO.iterator();
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