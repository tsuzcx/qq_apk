package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.downloader.i;
import com.tencent.mm.storage.cc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryVideoTPHandler$VideoItem;", "", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "downloader", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;", "(ILcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;)V", "getDownloader", "()Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;", "getMsg", "()Lcom/tencent/mm/storage/MsgInfo;", "getPosition", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q$b
{
  private final i RgU;
  final cc hzO;
  final int position;
  
  private q$b(int paramInt, cc paramcc)
  {
    AppMethodBeat.i(254718);
    this.position = paramInt;
    this.hzO = paramcc;
    this.RgU = null;
    AppMethodBeat.o(254718);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(254738);
    if (this == paramObject)
    {
      AppMethodBeat.o(254738);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(254738);
      return false;
    }
    paramObject = (b)paramObject;
    if (this.position != paramObject.position)
    {
      AppMethodBeat.o(254738);
      return false;
    }
    if (!s.p(this.hzO, paramObject.hzO))
    {
      AppMethodBeat.o(254738);
      return false;
    }
    if (!s.p(this.RgU, paramObject.RgU))
    {
      AppMethodBeat.o(254738);
      return false;
    }
    AppMethodBeat.o(254738);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(254735);
    int j = this.position;
    int k = this.hzO.hashCode();
    if (this.RgU == null) {}
    for (int i = 0;; i = this.RgU.hashCode())
    {
      AppMethodBeat.o(254735);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(254730);
    String str = "VideoItem(position=" + this.position + ", msg=" + this.hzO + ", downloader=" + this.RgU + ')';
    AppMethodBeat.o(254730);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.q.b
 * JD-Core Version:    0.7.0.1
 */