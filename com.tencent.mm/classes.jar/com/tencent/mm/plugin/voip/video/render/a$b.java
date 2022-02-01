package com.tencent.mm.plugin.voip.video.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender$RenderInfo;", "", "outW", "", "outH", "dataType", "presentationTime", "", "(IIIJ)V", "getDataType", "()I", "getOutH", "getOutW", "getPresentationTime", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-voip_release"})
public final class a$b
{
  final int HmX;
  final int HmY;
  final long HmZ;
  final int dataType;
  
  public a$b(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.HmX = paramInt1;
    this.HmY = paramInt2;
    this.dataType = paramInt3;
    this.HmZ = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.HmX != paramObject.HmX) || (this.HmY != paramObject.HmY) || (this.dataType != paramObject.dataType) || (this.HmZ != paramObject.HmZ)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    int i = this.HmX;
    int j = this.HmY;
    int k = this.dataType;
    long l = this.HmZ;
    return ((i * 31 + j) * 31 + k) * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(236186);
    String str = "RenderInfo(outW=" + this.HmX + ", outH=" + this.HmY + ", dataType=" + this.dataType + ", presentationTime=" + this.HmZ + ")";
    AppMethodBeat.o(236186);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.a.b
 * JD-Core Version:    0.7.0.1
 */