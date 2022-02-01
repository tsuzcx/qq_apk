package com.tencent.mm.plugin.wenote.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.c.i;
import com.tencent.mm.plugin.ball.model.BallInfo;
import java.util.Iterator;
import java.util.List;

final class c$1$1
  implements i
{
  c$1$1(c.1 param1, long paramLong) {}
  
  public final void bG(List<BallInfo> paramList)
  {
    AppMethodBeat.i(30290);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if ((localBallInfo.type == 3) && (localBallInfo.mab.getInt("eventType") == 1) && (localBallInfo.key != null) && (localBallInfo.key.startsWith(this.val$id)))
        {
          ((b)h.ae(b.class)).l(localBallInfo);
          AppMethodBeat.o(30290);
          return;
        }
      }
    }
    AppMethodBeat.o(30290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.c.1.1
 * JD-Core Version:    0.7.0.1
 */