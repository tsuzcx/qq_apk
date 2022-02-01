package com.tencent.mm.plugin.voip.video.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData;", "", "width", "", "height", "fbType", "mBuffer", "Ljava/nio/ByteBuffer;", "dataType", "(IIILjava/nio/ByteBuffer;I)V", "reset", "", "type", "Companion", "IFaceBeautyData", "plugin-voip_release"})
public final class a
{
  public static final a.a Hld;
  public int Hlc;
  public int dataType;
  public int height;
  public ByteBuffer iEK;
  public int width;
  
  static
  {
    AppMethodBeat.i(115962);
    Hld = new a.a((byte)0);
    AppMethodBeat.o(115962);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3, ByteBuffer paramByteBuffer)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.Hlc = paramInt3;
    this.iEK = paramByteBuffer;
    this.dataType = 0;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, ByteBuffer paramByteBuffer, int paramInt4)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.iEK = paramByteBuffer;
    this.Hlc = paramInt3;
    this.dataType = paramInt4;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData$IFaceBeautyData;", "", "getFaceBeautyData", "", "faceBeautyData", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData;", "plugin-voip_release"})
  public static abstract interface b
  {
    public abstract void a(a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.a
 * JD-Core Version:    0.7.0.1
 */