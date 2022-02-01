package com.tencent.thumbplayer.api.proxy;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.e.e;

public class TPP2PProxyFactory
{
  public static ITPPreloadProxy createPreloadManager(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(189085);
    paramContext = new e(paramContext, paramInt);
    AppMethodBeat.o(189085);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.thumbplayer.api.proxy.TPP2PProxyFactory
 * JD-Core Version:    0.7.0.1
 */