package com.tencent.mm.plugin.voip.video.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.nio.ByteBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData;", "", "width", "", "height", "fbType", "mBuffer", "Ljava/nio/ByteBuffer;", "(IIILjava/nio/ByteBuffer;)V", "reset", "", "Companion", "IFaceBeautyData", "plugin-voip_release"})
public final class a
{
  public static final a.a AQd;
  public int AQc;
  public int height;
  public ByteBuffer hoQ;
  public int width;
  
  static
  {
    AppMethodBeat.i(115962);
    AQd = new a.a((byte)0);
    AppMethodBeat.o(115962);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3, ByteBuffer paramByteBuffer)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.AQc = paramInt3;
    this.hoQ = paramByteBuffer;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, ByteBuffer paramByteBuffer)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.hoQ = paramByteBuffer;
    this.AQc = paramInt3;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData$IFaceBeautyData;", "", "getFaceBeautyData", "", "faceBeautyData", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData;", "plugin-voip_release"})
  public static abstract interface b
  {
    public abstract void a(a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.a
 * JD-Core Version:    0.7.0.1
 */