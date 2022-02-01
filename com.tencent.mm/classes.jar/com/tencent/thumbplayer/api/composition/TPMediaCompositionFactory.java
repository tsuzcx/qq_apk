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
    AppMethodBeat.i(219970);
    a locala = new a(paramInt);
    locala.setCutTimeRange(paramLong1, paramLong2);
    AppMethodBeat.o(219970);
    return locala;
  }
  
  public static ITPMediaComposition createMediaComposition()
  {
    AppMethodBeat.i(219966);
    b localb = new b();
    AppMethodBeat.o(219966);
    return localb;
  }
  
  public static ITPMediaDRMAsset createMediaDRMAsset(int paramInt, String paramString)
  {
    AppMethodBeat.i(219973);
    paramString = new g(paramInt, paramString);
    AppMethodBeat.o(219973);
    return paramString;
  }
  
  public static ITPMediaTrack createMediaTrack(int paramInt)
  {
    AppMethodBeat.i(219967);
    d locald = new d(paramInt);
    AppMethodBeat.o(219967);
    return locald;
  }
  
  public static ITPMediaTrack createMediaTrack(int paramInt, List<ITPMediaTrackClip> paramList)
  {
    AppMethodBeat.i(219969);
    d locald = new d(paramInt);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      locald.addTrackClip((ITPMediaTrackClip)paramList.next());
    }
    AppMethodBeat.o(219969);
    return locald;
  }
  
  public static ITPMediaTrack createMediaTrack(int paramInt, ITPMediaTrackClip... paramVarArgs)
  {
    AppMethodBeat.i(219968);
    d locald = new d(paramInt);
    int i = paramVarArgs.length;
    paramInt = 0;
    while (paramInt < i)
    {
      locald.addTrackClip(paramVarArgs[paramInt]);
      paramInt += 1;
    }
    AppMethodBeat.o(219968);
    return locald;
  }
  
  public static ITPMediaTrackClip createMediaTrackClip(String paramString, int paramInt)
  {
    AppMethodBeat.i(219971);
    paramString = new e(paramString, paramInt);
    AppMethodBeat.o(219971);
    return paramString;
  }
  
  public static ITPMediaTrackClip createMediaTrackClip(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(219972);
    paramString = new e(paramString, paramInt, paramLong1, paramLong2);
    AppMethodBeat.o(219972);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.api.composition.TPMediaCompositionFactory
 * JD-Core Version:    0.7.0.1
 */