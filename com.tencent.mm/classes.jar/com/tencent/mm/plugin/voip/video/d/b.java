package com.tencent.mm.plugin.voip.video.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/videoprocessing/SpatioTemporalFilterData;", "", "width", "", "height", "SpatioTemporalFilterData", "Ljava/nio/ByteBuffer;", "dataType", "(IILjava/nio/ByteBuffer;I)V", "reset", "", "mBuffer", "type", "Companion", "ISpatioTemporalFilterData", "plugin-voip_release"})
public final class b
{
  public static final b.a HpE;
  public ByteBuffer HpD;
  public int dataType;
  public int height;
  public int width;
  
  static
  {
    AppMethodBeat.i(236376);
    HpE = new b.a((byte)0);
    AppMethodBeat.o(236376);
  }
  
  public b(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.HpD = paramByteBuffer;
    this.dataType = 0;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/videoprocessing/SpatioTemporalFilterData$ISpatioTemporalFilterData;", "", "getSpatioTemporalFilterData", "", "SpatioTemporalFilterData", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/SpatioTemporalFilterData;", "plugin-voip_release"})
  public static abstract interface b
  {
    public abstract void a(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.d.b
 * JD-Core Version:    0.7.0.1
 */