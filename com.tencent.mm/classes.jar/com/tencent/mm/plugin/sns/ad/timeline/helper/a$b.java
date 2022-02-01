package com.tencent.mm.plugin.sns.ad.timeline.helper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.m;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$ThumbResult;", "", "mediaId", "", "bitmap", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/memory/ReleasableBitmap;", "state", "Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$ResultState;", "(Ljava/lang/String;Ljava/lang/ref/WeakReference;Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$ResultState;)V", "getBitmap", "()Ljava/lang/ref/WeakReference;", "getMediaId", "()Ljava/lang/String;", "getState", "()Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$ResultState;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
{
  public final a.a Qah;
  public final WeakReference<m> clY;
  private final String mediaId;
  
  public a$b(String paramString, WeakReference<m> paramWeakReference, a.a parama)
  {
    AppMethodBeat.i(311110);
    this.mediaId = paramString;
    this.clY = paramWeakReference;
    this.Qah = parama;
    AppMethodBeat.o(311110);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(311132);
    if (this == paramObject)
    {
      AppMethodBeat.o(311132);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(311132);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.mediaId, paramObject.mediaId))
    {
      AppMethodBeat.o(311132);
      return false;
    }
    if (!s.p(this.clY, paramObject.clY))
    {
      AppMethodBeat.o(311132);
      return false;
    }
    if (this.Qah != paramObject.Qah)
    {
      AppMethodBeat.o(311132);
      return false;
    }
    AppMethodBeat.o(311132);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(311125);
    int j = this.mediaId.hashCode();
    if (this.clY == null) {}
    for (int i = 0;; i = this.clY.hashCode())
    {
      int k = this.Qah.hashCode();
      AppMethodBeat.o(311125);
      return (i + j * 31) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(311116);
    String str = "ThumbResult(mediaId=" + this.mediaId + ", bitmap=" + this.clY + ", state=" + this.Qah + ')';
    AppMethodBeat.o(311116);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.helper.a.b
 * JD-Core Version:    0.7.0.1
 */