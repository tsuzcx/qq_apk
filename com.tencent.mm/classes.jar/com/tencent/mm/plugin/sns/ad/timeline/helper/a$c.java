package com.tencent.mm.plugin.sns.ad.timeline.helper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$VideoResult;", "", "mediaId", "", "filePath", "state", "Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$ResultState;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$ResultState;)V", "getFilePath", "()Ljava/lang/String;", "getMediaId", "getState", "()Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$ResultState;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$c
{
  public final a.a Qah;
  public final String filePath;
  private final String mediaId;
  
  public a$c(String paramString1, String paramString2, a.a parama)
  {
    AppMethodBeat.i(311111);
    this.mediaId = paramString1;
    this.filePath = paramString2;
    this.Qah = parama;
    AppMethodBeat.o(311111);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(311135);
    if (this == paramObject)
    {
      AppMethodBeat.o(311135);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(311135);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.mediaId, paramObject.mediaId))
    {
      AppMethodBeat.o(311135);
      return false;
    }
    if (!s.p(this.filePath, paramObject.filePath))
    {
      AppMethodBeat.o(311135);
      return false;
    }
    if (this.Qah != paramObject.Qah)
    {
      AppMethodBeat.o(311135);
      return false;
    }
    AppMethodBeat.o(311135);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(311130);
    int j = this.mediaId.hashCode();
    if (this.filePath == null) {}
    for (int i = 0;; i = this.filePath.hashCode())
    {
      int k = this.Qah.hashCode();
      AppMethodBeat.o(311130);
      return (i + j * 31) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(311118);
    String str = "VideoResult(mediaId=" + this.mediaId + ", filePath=" + this.filePath + ", state=" + this.Qah + ')';
    AppMethodBeat.o(311118);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.helper.a.c
 * JD-Core Version:    0.7.0.1
 */