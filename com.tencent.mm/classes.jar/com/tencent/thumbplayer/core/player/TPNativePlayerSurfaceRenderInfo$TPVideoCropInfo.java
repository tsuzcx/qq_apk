package com.tencent.thumbplayer.core.player;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TPNativePlayerSurfaceRenderInfo$TPVideoCropInfo
{
  public int cropBottom = -1;
  public int cropLeft = -1;
  public int cropRight = -1;
  public int cropTop = -1;
  public int height = -1;
  public int width = -1;
  
  public String toString()
  {
    AppMethodBeat.i(189992);
    String str = "width:" + this.width + ", height:" + this.height + ", cropLeft:" + this.cropLeft + ", cropRight:" + this.cropRight + ", cropTop:" + this.cropTop + ", cropBottom:" + this.cropBottom;
    AppMethodBeat.o(189992);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.player.TPNativePlayerSurfaceRenderInfo.TPVideoCropInfo
 * JD-Core Version:    0.7.0.1
 */