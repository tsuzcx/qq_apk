package com.tencent.mm.plugin.voip.video.render;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender$RenderInfo;", "", "outW", "", "outH", "dataType", "presentationTime", "", "(IIIJ)V", "getDataType", "()I", "getOutH", "getOutW", "getPresentationTime", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$b
{
  final int URX;
  final int URY;
  final long URZ;
  final int dataType;
  
  public c$b(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.URX = paramInt1;
    this.URY = paramInt2;
    this.dataType = paramInt3;
    this.URZ = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
      if (this.URX != paramObject.URX) {
        return false;
      }
      if (this.URY != paramObject.URY) {
        return false;
      }
      if (this.dataType != paramObject.dataType) {
        return false;
      }
    } while (this.URZ == paramObject.URZ);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(293204);
    int i = this.URX;
    int j = this.URY;
    int k = this.dataType;
    int m = q.a..ExternalSyntheticBackport0.m(this.URZ);
    AppMethodBeat.o(293204);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(293200);
    String str = "RenderInfo(outW=" + this.URX + ", outH=" + this.URY + ", dataType=" + this.dataType + ", presentationTime=" + this.URZ + ')';
    AppMethodBeat.o(293200);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.c.b
 * JD-Core Version:    0.7.0.1
 */