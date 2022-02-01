package com.tencent.mm.plugin.voip.video.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData;", "", "width", "", "height", "mFaceBeautyData", "", "fbType", "(II[BI)V", "reset", "", "Companion", "IFaceBeautyData", "plugin-voip_release"})
public final class a
{
  public static final a.a zxl;
  public int height;
  public int width;
  public byte[] zxj;
  public int zxk;
  
  static
  {
    AppMethodBeat.i(115962);
    zxl = new a.a((byte)0);
    AppMethodBeat.o(115962);
  }
  
  public a(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.zxj = paramArrayOfByte;
    this.zxk = paramInt3;
  }
  
  public final void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
  {
    AppMethodBeat.i(192372);
    k.h(paramArrayOfByte, "mFaceBeautyData");
    this.width = paramInt1;
    this.height = paramInt2;
    this.zxj = paramArrayOfByte;
    this.zxk = paramInt3;
    AppMethodBeat.o(192372);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData$IFaceBeautyData;", "", "getFaceBeautyData", "", "faceBeautyData", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData;", "plugin-voip_release"})
  public static abstract interface b
  {
    public abstract void a(a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.a
 * JD-Core Version:    0.7.0.1
 */