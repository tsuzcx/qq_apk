package com.tencent.mm.plugin.vlog.remux;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.c.e;
import com.tencent.mm.media.e.a;
import com.tencent.mm.plugin.vlog.model.z;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$VideoDecoder;", "", "index", "", "material", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "decoder", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "startTime", "", "endTime", "(ILcom/tencent/mm/plugin/vlog/model/VideoMaterial;Lcom/tencent/mm/media/decoder/IAudioDecoder;Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;JJ)V", "getDecoder", "()Lcom/tencent/mm/media/decoder/IAudioDecoder;", "getEndTime", "()J", "getIndex", "()I", "getMaterial", "()Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "getMediaExtractor", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "getStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"})
public final class a$d
{
  final z ArH;
  final e ArI;
  private final long endTime;
  final a gTA;
  final int index;
  private final long startTime;
  
  public a$d(int paramInt, z paramz, e parame, a parama, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(111007);
    this.index = paramInt;
    this.ArH = paramz;
    this.ArI = parame;
    this.gTA = parama;
    this.startTime = paramLong1;
    this.endTime = paramLong2;
    AppMethodBeat.o(111007);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(111010);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((this.index != paramObject.index) || (!k.g(this.ArH, paramObject.ArH)) || (!k.g(this.ArI, paramObject.ArI)) || (!k.g(this.gTA, paramObject.gTA)) || (this.startTime != paramObject.startTime) || (this.endTime != paramObject.endTime)) {}
      }
    }
    else
    {
      AppMethodBeat.o(111010);
      return true;
    }
    AppMethodBeat.o(111010);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(111009);
    int m = this.index;
    Object localObject = this.ArH;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.ArI;
      if (localObject == null) {
        break label138;
      }
    }
    label138:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.gTA;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      long l = this.startTime;
      int n = (int)(l ^ l >>> 32);
      l = this.endTime;
      int i1 = (int)(l ^ l >>> 32);
      AppMethodBeat.o(111009);
      return (((j + (i + m * 31) * 31) * 31 + k) * 31 + n) * 31 + i1;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(111008);
    String str = "VideoDecoder(index=" + this.index + ", material=" + this.ArH + ", decoder=" + this.ArI + ", mediaExtractor=" + this.gTA + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ")";
    AppMethodBeat.o(111008);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.a.d
 * JD-Core Version:    0.7.0.1
 */