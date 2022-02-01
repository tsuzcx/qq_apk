package com.tencent.mm.plugin.voip.video.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender$RenderInfo;", "", "outW", "", "outH", "dataType", "presentationTime", "", "(IIIJ)V", "getDataType", "()I", "getOutH", "getOutW", "getPresentationTime", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-voip_release"})
public final class EncoderSurfaceRender$b
{
  final int Crp;
  final int Crq;
  final long Crr;
  final int dataType;
  
  public EncoderSurfaceRender$b(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.Crp = paramInt1;
    this.Crq = paramInt2;
    this.dataType = paramInt3;
    this.Crr = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.Crp != paramObject.Crp) || (this.Crq != paramObject.Crq) || (this.dataType != paramObject.dataType) || (this.Crr != paramObject.Crr)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    int i = this.Crp;
    int j = this.Crq;
    int k = this.dataType;
    long l = this.Crr;
    return ((i * 31 + j) * 31 + k) * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(216084);
    String str = "RenderInfo(outW=" + this.Crp + ", outH=" + this.Crq + ", dataType=" + this.dataType + ", presentationTime=" + this.Crr + ")";
    AppMethodBeat.o(216084);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.EncoderSurfaceRender.b
 * JD-Core Version:    0.7.0.1
 */