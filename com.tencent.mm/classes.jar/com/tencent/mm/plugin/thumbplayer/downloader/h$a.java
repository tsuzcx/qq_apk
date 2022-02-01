package com.tencent.mm.plugin.thumbplayer.downloader;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoDownloadTask$Stat;", "", "progress", "", "totalLength", "moovOffset", "moovLength", "(JJJJ)V", "getMoovLength", "()J", "getMoovOffset", "getProgress", "getTotalLength", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h$a
{
  final long TCx;
  final long TCy;
  final long hQO;
  final long qHg;
  
  public h$a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.hQO = paramLong1;
    this.qHg = paramLong2;
    this.TCx = paramLong3;
    this.TCy = paramLong4;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.hQO != paramObject.hQO) {
        return false;
      }
      if (this.qHg != paramObject.qHg) {
        return false;
      }
      if (this.TCx != paramObject.TCx) {
        return false;
      }
    } while (this.TCy == paramObject.TCy);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(272145);
    int i = q.a..ExternalSyntheticBackport0.m(this.hQO);
    int j = q.a..ExternalSyntheticBackport0.m(this.qHg);
    int k = q.a..ExternalSyntheticBackport0.m(this.TCx);
    int m = q.a..ExternalSyntheticBackport0.m(this.TCy);
    AppMethodBeat.o(272145);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(272134);
    String str = "Stat(progress=" + this.hQO + ", totalLength=" + this.qHg + ", moovOffset=" + this.TCx + ", moovLength=" + this.TCy + ')';
    AppMethodBeat.o(272134);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.downloader.h.a
 * JD-Core Version:    0.7.0.1
 */