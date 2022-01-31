package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.o.a;
import java.util.HashMap;

public final class n$a
  implements o.a
{
  public final void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(85375);
    n.a(paramContext, paramHashMap);
    AppMethodBeat.o(85375);
  }
  
  public final boolean isBusy()
  {
    AppMethodBeat.i(85376);
    boolean bool = n.isBusy();
    AppMethodBeat.o(85376);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.n.a
 * JD-Core Version:    0.7.0.1
 */