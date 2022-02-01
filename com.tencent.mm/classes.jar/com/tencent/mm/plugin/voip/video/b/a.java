package com.tencent.mm.plugin.voip.video.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData;", "", "width", "", "height", "fbType", "mBuffer", "Ljava/nio/ByteBuffer;", "dataType", "(IIILjava/nio/ByteBuffer;I)V", "reset", "", "type", "Companion", "IFaceBeautyData", "plugin-voip_release"})
public final class a
{
  public static final a ObS;
  public int ObR;
  public int dataType;
  public int height;
  public ByteBuffer luM;
  public int width;
  
  static
  {
    AppMethodBeat.i(115962);
    ObS = new a((byte)0);
    AppMethodBeat.o(115962);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3, ByteBuffer paramByteBuffer)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.ObR = paramInt3;
    this.luM = paramByteBuffer;
    this.dataType = 0;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, ByteBuffer paramByteBuffer, int paramInt4)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.luM = paramByteBuffer;
    this.ObR = paramInt3;
    this.dataType = paramInt4;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData$Companion;", "", "()V", "FB_NONE", "", "FB_ONLYSTFitler", "FB_SELF_STUDY", "FB_YT", "TYPE_DEFAULT", "TYPE_HW", "TYPE_SOFT", "plugin-voip_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.a
 * JD-Core Version:    0.7.0.1
 */