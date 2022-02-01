package com.tencent.mm.plugin.trafficmonitor;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

final class TrafficClickFlowReceiver$2
  implements Runnable
{
  TrafficClickFlowReceiver$2(TrafficClickFlowReceiver paramTrafficClickFlowReceiver, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(194289);
    Object localObject2 = this.val$intent.getStringExtra("ui");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    localObject2 = localObject1;
    if (((String)localObject1).contains(".")) {
      localObject2 = ((String)localObject1).substring(((String)localObject1).lastIndexOf(".") + 1);
    }
    int i = this.val$intent.getIntExtra("opCode", 0);
    if (i == 10)
    {
      localObject1 = new TrafficClickFlowReceiver.a();
      ((TrafficClickFlowReceiver.a)localObject1).GsN = ((String)localObject2);
      ((TrafficClickFlowReceiver.a)localObject1).time = System.currentTimeMillis();
      TrafficClickFlowReceiver.bwK().add(localObject1);
      Log.i("MicroMsg.TrafficClickFlow", "onReceive Click : %s", new Object[] { localObject2 });
      AppMethodBeat.o(194289);
      return;
    }
    TrafficClickFlowReceiver.fR((String)localObject2, i);
    TrafficClickFlowReceiver.a(this.GsM, i);
    AppMethodBeat.o(194289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver.2
 * JD-Core Version:    0.7.0.1
 */