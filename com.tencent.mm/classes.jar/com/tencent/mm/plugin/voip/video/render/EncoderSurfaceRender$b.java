package com.tencent.mm.plugin.voip.video.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender$RenderInfo;", "", "outW", "", "outH", "dataType", "presentationTime", "", "(IIIJ)V", "getDataType", "()I", "getOutH", "getOutW", "getPresentationTime", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-voip_release"})
public final class EncoderSurfaceRender$b
{
  final int CIT;
  final int CIU;
  final long CIV;
  final int dataType;
  
  public EncoderSurfaceRender$b(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.CIT = paramInt1;
    this.CIU = paramInt2;
    this.dataType = paramInt3;
    this.CIV = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.CIT != paramObject.CIT) || (this.CIU != paramObject.CIU) || (this.dataType != paramObject.dataType) || (this.CIV != paramObject.CIV)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    int i = this.CIT;
    int j = this.CIU;
    int k = this.dataType;
    long l = this.CIV;
    return ((i * 31 + j) * 31 + k) * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(210505);
    String str = "RenderInfo(outW=" + this.CIT + ", outH=" + this.CIU + ", dataType=" + this.dataType + ", presentationTime=" + this.CIV + ")";
    AppMethodBeat.o(210505);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.EncoderSurfaceRender.b
 * JD-Core Version:    0.7.0.1
 */