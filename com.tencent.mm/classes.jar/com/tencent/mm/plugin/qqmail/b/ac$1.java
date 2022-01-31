package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class ac$1
  implements Runnable
{
  ac$1(ac paramac) {}
  
  public final void run()
  {
    AppMethodBeat.i(68059);
    if (!g.RG())
    {
      AppMethodBeat.o(68059);
      return;
    }
    long l = System.currentTimeMillis();
    y localy = new y();
    if (localy.pJV.oBk.size() > 0)
    {
      int i = 0;
      while (i < localy.pJV.oBk.size())
      {
        y.Xw(((w)localy.pJV.oBk.get(i)).pIO);
        i += 1;
      }
      localy.pJV.oBk.clear();
      localy.save();
    }
    ab.i("SubCoreQQMail", "summeranrt onAccountPostReset notifyAllFail take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(68059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ac.1
 * JD-Core Version:    0.7.0.1
 */