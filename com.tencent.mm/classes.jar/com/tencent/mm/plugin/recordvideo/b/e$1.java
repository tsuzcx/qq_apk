package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class e$1
  implements Runnable
{
  public static final 1 HJN;
  
  static
  {
    AppMethodBeat.i(218221);
    HJN = new 1();
    AppMethodBeat.o(218221);
  }
  
  public final void run()
  {
    AppMethodBeat.i(218218);
    Object localObject1 = q.auU();
    Object localObject2 = e.HJM;
    localObject2 = (String)((Map)localObject1).get("hardware");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    e.aVS((String)localObject1);
    localObject1 = e.HJM;
    localObject1 = e.fvA();
    localObject2 = new StringBuilder("get cpu name:");
    e locale = e.HJM;
    Log.i((String)localObject1, e.fvy());
    AppMethodBeat.o(218218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.e.1
 * JD-Core Version:    0.7.0.1
 */