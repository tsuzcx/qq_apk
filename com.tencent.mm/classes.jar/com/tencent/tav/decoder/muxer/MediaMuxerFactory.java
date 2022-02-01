package com.tencent.tav.decoder.muxer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class MediaMuxerFactory
{
  private static DefaultMediaMuxerCreator defaultMuxerCreator;
  private static MediaMuxerCreator muxerCreator;
  
  static
  {
    AppMethodBeat.i(216390);
    defaultMuxerCreator = new DefaultMediaMuxerCreator(null);
    muxerCreator = null;
    AppMethodBeat.o(216390);
  }
  
  public static IMediaMuxer createMediaMuxer(String paramString, int paramInt)
  {
    AppMethodBeat.i(216380);
    if (muxerCreator == null)
    {
      paramString = defaultMuxerCreator.createMediaMuxer(paramString, paramInt);
      AppMethodBeat.o(216380);
      return paramString;
    }
    paramString = muxerCreator.createMediaMuxer(paramString, paramInt);
    AppMethodBeat.o(216380);
    return paramString;
  }
  
  public static int parallelMux(List<IMediaMuxer> paramList)
  {
    AppMethodBeat.i(216384);
    if (muxerCreator == null)
    {
      i = defaultMuxerCreator.parallelMux(paramList);
      AppMethodBeat.o(216384);
      return i;
    }
    int i = muxerCreator.parallelMux(paramList);
    AppMethodBeat.o(216384);
    return i;
  }
  
  public static void setMuxerCreator(MediaMuxerCreator paramMediaMuxerCreator)
  {
    muxerCreator = paramMediaMuxerCreator;
  }
  
  static class DefaultMediaMuxerCreator
    implements MediaMuxerFactory.MediaMuxerCreator
  {
    public IMediaMuxer createMediaMuxer(String paramString, int paramInt)
    {
      AppMethodBeat.i(216388);
      paramString = new DefaultMediaMuxer(paramString, paramInt);
      AppMethodBeat.o(216388);
      return paramString;
    }
    
    public int parallelMux(List<IMediaMuxer> paramList)
    {
      return 0;
    }
  }
  
  public static abstract interface MediaMuxerCreator
  {
    public abstract IMediaMuxer createMediaMuxer(String paramString, int paramInt);
    
    public abstract int parallelMux(List<IMediaMuxer> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.muxer.MediaMuxerFactory
 * JD-Core Version:    0.7.0.1
 */