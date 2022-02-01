package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.bk.a;
import com.tencent.mm.sdk.platformtools.Log;

final class o$a
  implements bk.a
{
  public final void a(long paramLong1, boolean paramBoolean, int paramInt, long paramLong2)
  {
    AppMethodBeat.i(309964);
    Log.i("FinderAdPreloadHelper", "preloadVideo onSuccessfully, feedId is " + paramLong1 + ", isAllCompleted is " + paramBoolean + ", percent is " + paramInt + ", receivedSize is " + paramLong2);
    AppMethodBeat.o(309964);
  }
  
  public final void rl(long paramLong)
  {
    AppMethodBeat.i(309957);
    Log.i("FinderAdPreloadHelper", "preloadVideo onStart, feedId is ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(309957);
  }
  
  public final void rm(long paramLong)
  {
    AppMethodBeat.i(309970);
    Log.e("FinderAdPreloadHelper", "preloadVideo onFailure, feedId is ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(309970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.o.a
 * JD-Core Version:    0.7.0.1
 */