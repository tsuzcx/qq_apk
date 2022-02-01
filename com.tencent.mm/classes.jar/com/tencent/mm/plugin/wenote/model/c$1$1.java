package com.tencent.mm.plugin.wenote.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.ball.c.h;
import com.tencent.mm.plugin.ball.model.BallInfo;
import java.util.Iterator;
import java.util.List;

final class c$1$1
  implements h
{
  c$1$1(c.1 param1, long paramLong) {}
  
  public final void bo(List<BallInfo> paramList)
  {
    AppMethodBeat.i(30290);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if ((localBallInfo.type == 3) && (localBallInfo.ime.getInt("eventType") == 1) && (localBallInfo.key != null) && (localBallInfo.key.startsWith(this.plZ)))
        {
          ((c)g.ab(c.class)).m(localBallInfo);
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