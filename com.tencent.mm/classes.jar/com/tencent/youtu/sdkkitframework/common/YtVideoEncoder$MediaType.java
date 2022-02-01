package com.tencent.youtu.sdkkitframework.common;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum YtVideoEncoder$MediaType
{
  static
  {
    AppMethodBeat.i(256670);
    VideoType = new MediaType("VideoType", 0);
    AudioType = new MediaType("AudioType", 1);
    $VALUES = new MediaType[] { VideoType, AudioType };
    AppMethodBeat.o(256670);
  }
  
  private YtVideoEncoder$MediaType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtVideoEncoder.MediaType
 * JD-Core Version:    0.7.0.1
 */