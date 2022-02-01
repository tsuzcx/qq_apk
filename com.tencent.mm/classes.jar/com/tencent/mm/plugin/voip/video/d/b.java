package com.tencent.mm.plugin.voip.video.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/videoprocessing/SpatioTemporalFilterData;", "", "width", "", "height", "SpatioTemporalFilterData", "Ljava/nio/ByteBuffer;", "dataType", "(IILjava/nio/ByteBuffer;I)V", "reset", "", "mBuffer", "type", "Companion", "ISpatioTemporalFilterData", "plugin-voip_release"})
public final class b
{
  public static final a Ogx;
  public ByteBuffer Ogw;
  public int dataType;
  public int height;
  public int width;
  
  static
  {
    AppMethodBeat.i(236393);
    Ogx = new a((byte)0);
    AppMethodBeat.o(236393);
  }
  
  public b(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.Ogw = paramByteBuffer;
    this.dataType = 0;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/videoprocessing/SpatioTemporalFilterData$Companion;", "", "()V", "STFILTER_NOSCREENOUT", "", "STFILTER_NOUSE", "STFILTER_SCREENOUT", "STFILTER_USE", "TYPE_DEFAULT", "plugin-voip_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.d.b
 * JD-Core Version:    0.7.0.1
 */