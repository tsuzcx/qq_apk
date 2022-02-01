package com.tencent.thumbplayer.api;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.g.e;

public class TPPlayerFactory
{
  public static ITPPlayer createTPPlayer(Context paramContext)
  {
    AppMethodBeat.i(228405);
    paramContext = new com.tencent.thumbplayer.g.b(paramContext);
    AppMethodBeat.o(228405);
    return paramContext;
  }
  
  public static ITPPlayer createTPPlayer(Context paramContext, Looper paramLooper)
  {
    AppMethodBeat.i(228417);
    paramContext = new com.tencent.thumbplayer.g.b(paramContext, paramLooper);
    AppMethodBeat.o(228417);
    return paramContext;
  }
  
  public static ITPPlayer createTPPlayer(Context paramContext, Looper paramLooper1, Looper paramLooper2)
  {
    AppMethodBeat.i(228423);
    paramContext = new com.tencent.thumbplayer.g.b(paramContext, paramLooper1, paramLooper2);
    AppMethodBeat.o(228423);
    return paramContext;
  }
  
  public static ITPPlayer createTPPlayer(Context paramContext, Looper paramLooper1, Looper paramLooper2, com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(228426);
    paramContext = new com.tencent.thumbplayer.g.b(paramContext, paramLooper1, paramLooper2, paramb);
    AppMethodBeat.o(228426);
    return paramContext;
  }
  
  public static ITPPlayer createTPPlayer(Context paramContext, com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(228411);
    paramContext = new com.tencent.thumbplayer.g.b(paramContext, null, null, paramb);
    AppMethodBeat.o(228411);
    return paramContext;
  }
  
  public static ITPSurface createTPSurface(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(228431);
    paramSurfaceTexture = new e(paramSurfaceTexture);
    AppMethodBeat.o(228431);
    return paramSurfaceTexture;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPPlayerFactory
 * JD-Core Version:    0.7.0.1
 */