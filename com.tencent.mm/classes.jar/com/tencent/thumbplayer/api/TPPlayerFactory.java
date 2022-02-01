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
    AppMethodBeat.i(189021);
    paramContext = new com.tencent.thumbplayer.g.b(paramContext);
    AppMethodBeat.o(189021);
    return paramContext;
  }
  
  public static ITPPlayer createTPPlayer(Context paramContext, Looper paramLooper)
  {
    AppMethodBeat.i(189023);
    paramContext = new com.tencent.thumbplayer.g.b(paramContext, paramLooper);
    AppMethodBeat.o(189023);
    return paramContext;
  }
  
  public static ITPPlayer createTPPlayer(Context paramContext, Looper paramLooper1, Looper paramLooper2)
  {
    AppMethodBeat.i(189024);
    paramContext = new com.tencent.thumbplayer.g.b(paramContext, paramLooper1, paramLooper2);
    AppMethodBeat.o(189024);
    return paramContext;
  }
  
  public static ITPPlayer createTPPlayer(Context paramContext, Looper paramLooper1, Looper paramLooper2, com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(189025);
    paramContext = new com.tencent.thumbplayer.g.b(paramContext, paramLooper1, paramLooper2, paramb);
    AppMethodBeat.o(189025);
    return paramContext;
  }
  
  public static ITPPlayer createTPPlayer(Context paramContext, com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(189022);
    paramContext = new com.tencent.thumbplayer.g.b(paramContext, null, null, paramb);
    AppMethodBeat.o(189022);
    return paramContext;
  }
  
  public static ITPSurface createTPSurface(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(189026);
    paramSurfaceTexture = new e(paramSurfaceTexture);
    AppMethodBeat.o(189026);
    return paramSurfaceTexture;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPPlayerFactory
 * JD-Core Version:    0.7.0.1
 */