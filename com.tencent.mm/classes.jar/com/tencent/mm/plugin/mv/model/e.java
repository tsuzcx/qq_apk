package com.tencent.mm.plugin.mv.model;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.gallery.ui.h;
import com.tencent.mm.plugin.gallery.ui.h.a;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "backItem", "getBackItem", "()Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "setBackItem", "(Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;)V", "durationMs", "", "getDurationMs", "()I", "endMs", "getEndMs", "setEndMs", "(I)V", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "getLyricObj", "()Lcom/tencent/mm/plugin/music/model/LyricObj;", "setLyricObj", "(Lcom/tencent/mm/plugin/music/model/LyricObj;)V", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "startMs", "getStartMs", "setStartMs", "syncMusic", "getSyncMusic", "setSyncMusic", "thumbData", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "getThumbData", "()Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "setThumbData", "(Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;)V", "type", "getType", "setType", "videoData", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "getVideoData", "()Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "setVideoData", "(Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;)V", "getFeedId", "", "getFinderUin", "getItemId", "", "getItemType", "getLyricLine", "currentPos", "isNull", "CaptureThumbData", "Companion", "DefaultThumbData", "FinderThumbData", "FinderVideoData", "GalleryThumbData", "IThumbData", "IVideoData", "LocalVideoData", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements a
{
  public static final e.b LWT;
  private static final Object LXa;
  public boolean Bvd;
  com.tencent.mm.plugin.music.model.e LOA;
  public int LWU;
  public int LWV;
  public boolean LWW;
  public e.g LWX;
  public h LWY;
  public e LWZ;
  public int type;
  
  static
  {
    AppMethodBeat.i(286074);
    LWT = new e.b((byte)0);
    LXa = new Object();
    AppMethodBeat.o(286074);
  }
  
  public e()
  {
    AppMethodBeat.i(286056);
    Object localObject1 = b.LWQ;
    Object localObject2 = b.a.gpv();
    this.LWX = ((e.g)new c((b)localObject2));
    localObject1 = new e.i(((b)localObject2).getFilePath(), ((b)localObject2).getFilePath(), ((b)localObject2).durationMs);
    ((e.i)localObject1).videoWidth = ((b)localObject2).width;
    ((e.i)localObject1).videoHeight = ((b)localObject2).height;
    ((e.i)localObject1).oBZ = true;
    localObject2 = ah.aiuX;
    this.LWY = ((h)localObject1);
    AppMethodBeat.o(286056);
  }
  
  public final String adQ(int paramInt)
  {
    AppMethodBeat.i(286090);
    Object localObject = this.LOA;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.music.model.e)localObject).adz(((com.tencent.mm.plugin.music.model.e)localObject).sC(paramInt));
      if (localObject == null)
      {
        AppMethodBeat.o(286090);
        return null;
      }
      localObject = ((e.a)localObject).content;
      AppMethodBeat.o(286090);
      return localObject;
    }
    AppMethodBeat.o(286090);
    return null;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(286100);
    long l = hashCode();
    AppMethodBeat.o(286100);
    return l;
  }
  
  public final int bZB()
  {
    return 4;
  }
  
  public final int getDurationMs()
  {
    return this.LWV - this.LWU;
  }
  
  public final String gpw()
  {
    long l = 0L;
    AppMethodBeat.i(286114);
    Object localObject = this.LWY;
    if (localObject == null) {}
    for (;;)
    {
      localObject = Util.getUnsignedLongString(l);
      s.s(localObject, "getUnsignedLongString(vi…getFinderObj()?.id ?: 0L)");
      AppMethodBeat.o(286114);
      return localObject;
      localObject = ((h)localObject).gpC();
      if (localObject != null) {
        l = ((FinderObject)localObject).id;
      }
    }
  }
  
  public final String gpx()
  {
    String str = null;
    AppMethodBeat.i(286120);
    Object localObject = this.LWY;
    if (localObject == null) {}
    for (;;)
    {
      localObject = str;
      if (str == null) {
        localObject = z.bAM();
      }
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(286120);
      return "";
      localObject = ((h)localObject).gpC();
      if (localObject != null) {
        str = ((FinderObject)localObject).username;
      }
    }
    AppMethodBeat.o(286120);
    return localObject;
  }
  
  public final long gpy()
  {
    e locale = this.LWZ;
    if ((locale != null) && (locale.type == 0)) {}
    for (int i = 1; i != 0; i = 0) {
      return 1L;
    }
    return 0L;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$DefaultThumbData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "videoInfo", "Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo;", "(Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo;)V", "attachThumb", "", "thumbView", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/gallery/ui/ThumbDrawable$AttachThumbCallback;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements e.g
  {
    private final b LXb;
    
    public c(b paramb)
    {
      AppMethodBeat.i(286156);
      this.LXb = paramb;
      AppMethodBeat.o(286156);
    }
    
    public final void a(ImageView paramImageView, h.a parama)
    {
      AppMethodBeat.i(286160);
      s.u(paramImageView, "thumbView");
      h.a(paramImageView, 2, this.LXb.thumbPath, this.LXb.getFilePath(), this.LXb.hashCode(), parama, 0L);
      AppMethodBeat.o(286160);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "", "durationMs", "", "getDurationMs", "()J", "setDurationMs", "(J)V", "isLocal", "", "()Z", "startMs", "getStartMs", "setStartMs", "getFinderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getTpMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface h
  {
    public abstract boolean eDB();
    
    public abstract long getDurationMs();
    
    public abstract long gpA();
    
    public abstract com.tencent.mm.plugin.thumbplayer.a.b gpB();
    
    public abstract FinderObject gpC();
    
    public abstract void sE(long paramLong);
    
    public abstract void sF(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.e
 * JD-Core Version:    0.7.0.1
 */