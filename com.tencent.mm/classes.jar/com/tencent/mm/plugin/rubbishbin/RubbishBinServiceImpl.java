package com.tencent.mm.plugin.rubbishbin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.rubbishbin.a.a;
import com.tencent.mm.plugin.rubbishbin.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public class RubbishBinServiceImpl
  extends RubbishBinService
{
  private List<b> DNv;
  
  public RubbishBinServiceImpl()
  {
    AppMethodBeat.i(262076);
    this.DNv = new ArrayList();
    AppMethodBeat.o(262076);
  }
  
  public final void aUB(String paramString)
  {
    AppMethodBeat.i(262085);
    Log.e("MicroMsg.RubbishBinServiceImpl", "RubbishBinServiceImpl.main() execute start = ".concat(String.valueOf(paramString)));
    int i = 0;
    if (i < this.DNv.size())
    {
      b localb = (b)this.DNv.get(i);
      if ((localb.gPj() == null) || (paramString == null))
      {
        Log.e("MicroMsg.RubbishBinServiceImpl", "RubbishBinServiceImpl main() return, task.getExecuteTag() = " + localb.gPj() + ", executeTag = " + paramString);
        AppMethodBeat.o(262085);
        return;
      }
      if (!localb.gPj().equals(paramString)) {
        Log.e("MicroMsg.RubbishBinServiceImpl", "task.getExecuteTag() =  " + localb.gPj() + ", executeTag = " + paramString + ", does not equals");
      }
      for (;;)
      {
        i += 1;
        break;
        localb.execute();
      }
    }
    Log.e("MicroMsg.RubbishBinServiceImpl", "RubbishBinServiceImpl.main() execute end = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(262085);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(262079);
    super.onCreate();
    this.DNv.add(new a());
    AppMethodBeat.o(262079);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.rubbishbin.RubbishBinServiceImpl
 * JD-Core Version:    0.7.0.1
 */