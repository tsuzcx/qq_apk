package com.tencent.thumbplayer.api.composition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.c.a;
import com.tencent.thumbplayer.c.b;
import com.tencent.thumbplayer.c.d;
import com.tencent.thumbplayer.c.e;
import com.tencent.thumbplayer.c.g;
import java.util.Iterator;
import java.util.List;

public class TPMediaCompositionFactory
{
  public static ITPMediaTrackClip createEmptyTrackClip(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(228449);
    a locala = new a(paramInt);
    locala.setCutTimeRange(paramLong1, paramLong2);
    AppMethodBeat.o(228449);
    return locala;
  }
  
  public static ITPMediaComposition createMediaComposition()
  {
    AppMethodBeat.i(228445);
    b localb = new b();
    AppMethodBeat.o(228445);
    return localb;
  }
  
  public static ITPMediaDRMAsset createMediaDRMAsset(int paramInt, String paramString)
  {
    AppMethodBeat.i(228458);
    paramString = new g(paramInt, paramString);
    AppMethodBeat.o(228458);
    return paramString;
  }
  
  public static ITPMediaTrack createMediaTrack(int paramInt)
  {
    AppMethodBeat.i(228446);
    d locald = new d(paramInt);
    AppMethodBeat.o(228446);
    return locald;
  }
  
  public static ITPMediaTrack createMediaTrack(int paramInt, List<ITPMediaTrackClip> paramList)
  {
    AppMethodBeat.i(228448);
    d locald = new d(paramInt);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      locald.addTrackClip((ITPMediaTrackClip)paramList.next());
    }
    AppMethodBeat.o(228448);
    return locald;
  }
  
  public static ITPMediaTrack createMediaTrack(int paramInt, ITPMediaTrackClip... paramVarArgs)
  {
    AppMethodBeat.i(228447);
    d locald = new d(paramInt);
    int i = paramVarArgs.length;
    paramInt = 0;
    while (paramInt < i)
    {
      locald.addTrackClip(paramVarArgs[paramInt]);
      paramInt += 1;
    }
    AppMethodBeat.o(228447);
    return locald;
  }
  
  public static ITPMediaTrackClip createMediaTrackClip(String paramString, int paramInt)
  {
    AppMethodBeat.i(228451);
    paramString = new e(paramString, paramInt);
    AppMethodBeat.o(228451);
    return paramString;
  }
  
  public static ITPMediaTrackClip createMediaTrackClip(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(228453);
    paramString = new e(paramString, paramInt, paramLong1, paramLong2);
    AppMethodBeat.o(228453);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.api.composition.TPMediaCompositionFactory
 * JD-Core Version:    0.7.0.1
 */