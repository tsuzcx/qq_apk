package com.tencent.mm.plugin.mv.model.flex;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "Lcom/tencent/mm/plugin/mvvmlist/BaseMvvmListItem;", "id", "", "type", "", "timeStamp", "", "fragmentType", "(Ljava/lang/String;IJI)V", "albumItem", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem$AlbumItem;", "getAlbumItem", "()Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem$AlbumItem;", "setAlbumItem", "(Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem$AlbumItem;)V", "backgroundRes", "getBackgroundRes", "()I", "setBackgroundRes", "(I)V", "finderItem", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem$FinderItem;", "getFinderItem", "()Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem$FinderItem;", "setFinderItem", "(Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem$FinderItem;)V", "getFragmentType", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getTimeStamp", "()J", "getType", "videoDuration", "getVideoDuration", "setVideoDuration", "compareTo", "other", "getItemType", "getUniqueId", "isSameContent", "", "AlbumItem", "Companion", "FinderItem", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.mvvmlist.a<a>
{
  public static final a.b LYp;
  public final int LYq;
  public a LYr;
  public c LYs;
  public int LYt;
  public String id;
  private final long timeStamp;
  public final int type;
  public int videoDuration;
  
  static
  {
    AppMethodBeat.i(286240);
    LYp = new a.b((byte)0);
    AppMethodBeat.o(286240);
  }
  
  public a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(286236);
    this.id = paramString;
    this.type = paramInt1;
    this.timeStamp = paramLong;
    this.LYq = paramInt2;
    this.LYt = -1;
    AppMethodBeat.o(286236);
  }
  
  public final int bZB()
  {
    return this.type;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(286251);
    Object localObject = super.clone();
    AppMethodBeat.o(286251);
    return localObject;
  }
  
  public final String fcs()
  {
    return this.id;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem$AlbumItem;", "", "origId", "", "modifyDate", "thumbPath", "", "mediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "width", "", "height", "(JJLjava/lang/String;Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;II)V", "getHeight", "()I", "setHeight", "(I)V", "getMediaItem", "()Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "setMediaItem", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)V", "getModifyDate", "()J", "setModifyDate", "(J)V", "getOrigId", "setOrigId", "getThumbPath", "()Ljava/lang/String;", "setThumbPath", "(Ljava/lang/String;)V", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public GalleryItem.MediaItem HHB = null;
    public long HHJ = 0L;
    public long LYu = 0L;
    public int height = 0;
    public String thumbPath = null;
    public int width = 0;
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(286263);
      if (this == paramObject)
      {
        AppMethodBeat.o(286263);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(286263);
        return false;
      }
      paramObject = (a)paramObject;
      if (this.HHJ != paramObject.HHJ)
      {
        AppMethodBeat.o(286263);
        return false;
      }
      if (this.LYu != paramObject.LYu)
      {
        AppMethodBeat.o(286263);
        return false;
      }
      if (!s.p(this.thumbPath, paramObject.thumbPath))
      {
        AppMethodBeat.o(286263);
        return false;
      }
      if (!s.p(this.HHB, paramObject.HHB))
      {
        AppMethodBeat.o(286263);
        return false;
      }
      if (this.width != paramObject.width)
      {
        AppMethodBeat.o(286263);
        return false;
      }
      if (this.height != paramObject.height)
      {
        AppMethodBeat.o(286263);
        return false;
      }
      AppMethodBeat.o(286263);
      return true;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(286257);
      int k = q.a..ExternalSyntheticBackport0.m(this.HHJ);
      int m = q.a..ExternalSyntheticBackport0.m(this.LYu);
      int i;
      if (this.thumbPath == null)
      {
        i = 0;
        if (this.HHB != null) {
          break label98;
        }
      }
      for (;;)
      {
        int n = this.width;
        int i1 = this.height;
        AppMethodBeat.o(286257);
        return (((i + (k * 31 + m) * 31) * 31 + j) * 31 + n) * 31 + i1;
        i = this.thumbPath.hashCode();
        break;
        label98:
        j = this.HHB.hashCode();
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(286254);
      String str = "AlbumItem(origId=" + this.HHJ + ", modifyDate=" + this.LYu + ", thumbPath=" + this.thumbPath + ", mediaItem=" + this.HHB + ", width=" + this.width + ", height=" + this.height + ')';
      AppMethodBeat.o(286254);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem$FinderItem;", "", "thumbUrl", "", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getFinderObj", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFinderObj", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getThumbUrl", "()Ljava/lang/String;", "setThumbUrl", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public FinderObject EDa = null;
    public String thumbUrl = null;
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(286252);
      if (this == paramObject)
      {
        AppMethodBeat.o(286252);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(286252);
        return false;
      }
      paramObject = (c)paramObject;
      if (!s.p(this.thumbUrl, paramObject.thumbUrl))
      {
        AppMethodBeat.o(286252);
        return false;
      }
      if (!s.p(this.EDa, paramObject.EDa))
      {
        AppMethodBeat.o(286252);
        return false;
      }
      AppMethodBeat.o(286252);
      return true;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(286248);
      int i;
      if (this.thumbUrl == null)
      {
        i = 0;
        if (this.EDa != null) {
          break label46;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(286248);
        return i * 31 + j;
        i = this.thumbUrl.hashCode();
        break;
        label46:
        j = this.EDa.hashCode();
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(286244);
      String str = "FinderItem(thumbUrl=" + this.thumbUrl + ", finderObj=" + this.EDa + ')';
      AppMethodBeat.o(286244);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.flex.a
 * JD-Core Version:    0.7.0.1
 */