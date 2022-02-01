package com.tencent.mm.plugin.mv.model.flex;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.livelist.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "Lcom/tencent/mm/plugin/livelist/BaseMMLiveListItem;", "id", "", "type", "", "timeStamp", "", "fragmentType", "(Ljava/lang/String;IJI)V", "albumItem", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem$AlbumItem;", "getAlbumItem", "()Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem$AlbumItem;", "setAlbumItem", "(Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem$AlbumItem;)V", "backgroundRes", "getBackgroundRes", "()I", "setBackgroundRes", "(I)V", "finderItem", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem$FinderItem;", "getFinderItem", "()Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem$FinderItem;", "setFinderItem", "(Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem$FinderItem;)V", "getFragmentType", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getTimeStamp", "()J", "getType", "videoDuration", "getVideoDuration", "setVideoDuration", "clone", "Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "compareTo", "other", "getItemType", "getUniqueId", "isSameContent", "", "AlbumItem", "Companion", "FinderItem", "plugin-mv_release"})
public final class a
  extends com.tencent.mm.plugin.livelist.a
{
  public static final a.b GcK;
  public a GcG;
  public c GcH;
  public int GcI;
  public final int GcJ;
  public String id;
  private final long timeStamp;
  public final int type;
  public int videoDuration;
  
  static
  {
    AppMethodBeat.i(230594);
    GcK = new a.b((byte)0);
    AppMethodBeat.o(230594);
  }
  
  public a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(230593);
    this.id = paramString;
    this.type = paramInt1;
    this.timeStamp = paramLong;
    this.GcJ = paramInt2;
    this.GcI = -1;
    AppMethodBeat.o(230593);
  }
  
  public final int bAQ()
  {
    return this.type;
  }
  
  public final boolean c(b paramb)
  {
    AppMethodBeat.i(230588);
    p.k(paramb, "other");
    if ((paramb instanceof a))
    {
      if ((this.GcI == ((a)paramb).GcI) && (p.h(this.GcH, ((a)paramb).GcH)) && (p.h(this.GcG, ((a)paramb).GcG)) && (this.videoDuration == ((a)paramb).videoDuration))
      {
        AppMethodBeat.o(230588);
        return true;
      }
      AppMethodBeat.o(230588);
      return false;
    }
    AppMethodBeat.o(230588);
    return false;
  }
  
  public final b eLO()
  {
    AppMethodBeat.i(230591);
    Object localObject = new a(this.id, this.type, this.timeStamp, this.GcJ);
    ((a)localObject).GcG = this.GcG;
    ((a)localObject).GcH = this.GcH;
    ((a)localObject).videoDuration = this.videoDuration;
    ((a)localObject).GcI = this.GcI;
    localObject = (b)localObject;
    AppMethodBeat.o(230591);
    return localObject;
  }
  
  public final String eLP()
  {
    return this.id;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem$AlbumItem;", "", "origId", "", "modifyDate", "thumbPath", "", "mediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "width", "", "height", "(JJLjava/lang/String;Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;II)V", "getHeight", "()I", "setHeight", "(I)V", "getMediaItem", "()Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "setMediaItem", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)V", "getModifyDate", "()J", "setModifyDate", "(J)V", "getOrigId", "setOrigId", "getThumbPath", "()Ljava/lang/String;", "setThumbPath", "(Ljava/lang/String;)V", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "plugin-mv_release"})
  public static final class a
  {
    public GalleryItem.MediaItem BVd = null;
    public long BVl = 0L;
    public long GcL = 0L;
    public int height = 0;
    public String thumbPath = null;
    public int width = 0;
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(241088);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.BVl != paramObject.BVl) || (this.GcL != paramObject.GcL) || (!p.h(this.thumbPath, paramObject.thumbPath)) || (!p.h(this.BVd, paramObject.BVd)) || (this.width != paramObject.width) || (this.height != paramObject.height)) {}
        }
      }
      else
      {
        AppMethodBeat.o(241088);
        return true;
      }
      AppMethodBeat.o(241088);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(241087);
      long l = this.BVl;
      int k = (int)(l ^ l >>> 32);
      l = this.GcL;
      int m = (int)(l ^ l >>> 32);
      Object localObject = this.thumbPath;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.BVd;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        int n = this.width;
        int i1 = this.height;
        AppMethodBeat.o(241087);
        return (((i + (k * 31 + m) * 31) * 31 + j) * 31 + n) * 31 + i1;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(241086);
      String str = "AlbumItem(origId=" + this.BVl + ", modifyDate=" + this.GcL + ", thumbPath=" + this.thumbPath + ", mediaItem=" + this.BVd + ", width=" + this.width + ", height=" + this.height + ")";
      AppMethodBeat.o(241086);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem$FinderItem;", "", "thumbUrl", "", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getFinderObj", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFinderObj", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getThumbUrl", "()Ljava/lang/String;", "setThumbUrl", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-mv_release"})
  public static final class c
  {
    public FinderObject Gbc = null;
    public String thumbUrl = null;
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(228127);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((!p.h(this.thumbUrl, paramObject.thumbUrl)) || (!p.h(this.Gbc, paramObject.Gbc))) {}
        }
      }
      else
      {
        AppMethodBeat.o(228127);
        return true;
      }
      AppMethodBeat.o(228127);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(228124);
      Object localObject = this.thumbUrl;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.Gbc;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(228124);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(228122);
      String str = "FinderItem(thumbUrl=" + this.thumbUrl + ", finderObj=" + this.Gbc + ")";
      AppMethodBeat.o(228122);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.flex.a
 * JD-Core Version:    0.7.0.1
 */