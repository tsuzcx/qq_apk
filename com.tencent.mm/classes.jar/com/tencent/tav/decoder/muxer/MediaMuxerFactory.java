package com.tencent.tav.decoder.muxer;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MediaMuxerFactory
{
  private static DefaultMediaMuxerCreator defaultMuxerCreator;
  private static MediaMuxerCreator muxerCreator;
  
  static
  {
    AppMethodBeat.i(218476);
    defaultMuxerCreator = new DefaultMediaMuxerCreator(null);
    muxerCreator = null;
    AppMethodBeat.o(218476);
  }
  
  public static IMediaMuxer createMediaMuxer(String paramString, int paramInt)
  {
    AppMethodBeat.i(218475);
    if (muxerCreator == null)
    {
      paramString = defaultMuxerCreator.createMediaMuxer(paramString, paramInt);
      AppMethodBeat.o(218475);
      return paramString;
    }
    paramString = muxerCreator.createMediaMuxer(paramString, paramInt);
    AppMethodBeat.o(218475);
    return paramString;
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
      AppMethodBeat.i(218474);
      paramString = new DefaultMediaMuxer(paramString, paramInt);
      AppMethodBeat.o(218474);
      return paramString;
    }
  }
  
  public static abstract interface MediaMuxerCreator
  {
    public abstract IMediaMuxer createMediaMuxer(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.decoder.muxer.MediaMuxerFactory
 * JD-Core Version:    0.7.0.1
 */