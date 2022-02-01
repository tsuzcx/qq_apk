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
  private List<b> IAy;
  
  public RubbishBinServiceImpl()
  {
    AppMethodBeat.i(205387);
    this.IAy = new ArrayList();
    AppMethodBeat.o(205387);
  }
  
  public final void aXa(String paramString)
  {
    AppMethodBeat.i(205389);
    Log.e("MicroMsg.RubbishBinServiceImpl", "RubbishBinServiceImpl.main() execute start = ".concat(String.valueOf(paramString)));
    int i = 0;
    if (i < this.IAy.size())
    {
      b localb = (b)this.IAy.get(i);
      localb.fBG();
      if (paramString == null)
      {
        Log.e("MicroMsg.RubbishBinServiceImpl", "RubbishBinServiceImpl main() return, task.getExecuteTag() = " + localb.fBG() + ", executeTag = " + paramString);
        AppMethodBeat.o(205389);
        return;
      }
      if (!localb.fBG().equals(paramString)) {
        Log.e("MicroMsg.RubbishBinServiceImpl", "task.getExecuteTag() =  " + localb.fBG() + ", executeTag = " + paramString + ", does not equals");
      }
      for (;;)
      {
        i += 1;
        break;
        localb.execute();
      }
    }
    Log.e("MicroMsg.RubbishBinServiceImpl", "RubbishBinServiceImpl.main() execute end = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(205389);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(205388);
    super.onCreate();
    this.IAy.add(new a());
    AppMethodBeat.o(205388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.rubbishbin.RubbishBinServiceImpl
 * JD-Core Version:    0.7.0.1
 */