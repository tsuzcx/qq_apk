package com.tencent.mm.plugin.voip.video.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData;", "", "width", "", "height", "fbType", "mBuffer", "Ljava/nio/ByteBuffer;", "dataType", "(IIILjava/nio/ByteBuffer;I)V", "reset", "", "type", "Companion", "IFaceBeautyData", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a UPR;
  public ByteBuffer OQ;
  public int UPS;
  public int dataType;
  public int height;
  public int width;
  
  static
  {
    AppMethodBeat.i(115962);
    UPR = new a.a((byte)0);
    AppMethodBeat.o(115962);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.UPS = paramInt3;
    this.OQ = null;
    this.dataType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.a
 * JD-Core Version:    0.7.0.1
 */