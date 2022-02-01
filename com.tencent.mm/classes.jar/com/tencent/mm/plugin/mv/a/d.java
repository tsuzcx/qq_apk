package com.tencent.mm.plugin.mv.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.av.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.ui.h.a;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.j.c;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "backItem", "getBackItem", "()Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "setBackItem", "(Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;)V", "durationMs", "", "getDurationMs", "()I", "endMs", "getEndMs", "setEndMs", "(I)V", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "getLyricObj", "()Lcom/tencent/mm/plugin/music/model/LyricObj;", "setLyricObj", "(Lcom/tencent/mm/plugin/music/model/LyricObj;)V", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "startMs", "getStartMs", "setStartMs", "syncMusic", "getSyncMusic", "setSyncMusic", "thumbData", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "getThumbData", "()Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "setThumbData", "(Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;)V", "type", "getType", "setType", "videoData", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "getVideoData", "()Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "setVideoData", "(Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;)V", "getFeedId", "", "getFinderUin", "getItemId", "", "getItemType", "getLyricLine", "currentPos", "isNull", "CaptureThumbData", "Companion", "DefaultThumbData", "FinderThumbData", "FinderVideoData", "GalleryThumbData", "IThumbData", "IVideoData", "LocalVideoData", "plugin-mv_release"})
public final class d
  implements com.tencent.mm.view.recyclerview.a
{
  private static final Object Apr;
  public static final b Aps;
  e Amv;
  public int Apl;
  public int Apm;
  public boolean Apn;
  public g Apo;
  public h App;
  public d Apq;
  public int type;
  public boolean uOQ;
  
  static
  {
    AppMethodBeat.i(256779);
    Aps = new b((byte)0);
    Apr = new Object();
    AppMethodBeat.o(256779);
  }
  
  public d()
  {
    AppMethodBeat.i(256778);
    Object localObject = a.Apj;
    int i = kotlin.k.j.a(kotlin.a.j.r((Collection)a.evw()), (c)c.SYP);
    if (i == a.evx()) {
      a.Ti((i + 1) % a.evw().size());
    }
    for (;;)
    {
      localObject = (a)a.evw().get(a.evx());
      this.Apo = ((g)new c((a)localObject));
      i locali = new i(((a)localObject).getFilePath(), ((a)localObject).getFilePath(), ((a)localObject).durationMs);
      locali.videoWidth = ((a)localObject).width;
      locali.videoHeight = ((a)localObject).height;
      locali.isDefault = true;
      this.App = ((h)locali);
      AppMethodBeat.o(256778);
      return;
      a.Ti(i);
    }
  }
  
  public final String Tj(int paramInt)
  {
    AppMethodBeat.i(256775);
    Object localObject = this.Amv;
    if (localObject != null)
    {
      localObject = ((e)localObject).SQ(((e)localObject).Hp(paramInt));
      if (localObject != null)
      {
        localObject = ((e.a)localObject).content;
        AppMethodBeat.o(256775);
        return localObject;
      }
      AppMethodBeat.o(256775);
      return null;
    }
    AppMethodBeat.o(256775);
    return null;
  }
  
  public final String adk()
  {
    AppMethodBeat.i(258833);
    Object localObject = this.App;
    if (localObject != null)
    {
      localObject = ((h)localObject).evB();
      if (localObject != null)
      {
        String str = ((FinderObject)localObject).objectNonceId;
        localObject = str;
        if (str != null) {
          break label41;
        }
      }
    }
    localObject = "";
    label41:
    AppMethodBeat.o(258833);
    return localObject;
  }
  
  public final int cxn()
  {
    return 4;
  }
  
  public final String gFb()
  {
    AppMethodBeat.i(258834);
    Object localObject1 = this.App;
    if (localObject1 != null)
    {
      localObject1 = ((h)localObject1).evB();
      if (localObject1 != null)
      {
        localObject2 = ((FinderObject)localObject1).username;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label41;
        }
      }
    }
    localObject1 = z.aTY();
    label41:
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    AppMethodBeat.o(258834);
    return localObject2;
  }
  
  public final long gFc()
  {
    d locald = this.Apq;
    if ((locald != null) && (locald.type == 0)) {
      return 1L;
    }
    return 0L;
  }
  
  public final int getDurationMs()
  {
    return this.Apm - this.Apl;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(256777);
    long l = hashCode();
    AppMethodBeat.o(256777);
    return l;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$CaptureThumbData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "thumbPath", "", "videoPath", "(Ljava/lang/String;Ljava/lang/String;)V", "getThumbPath", "()Ljava/lang/String;", "getVideoPath", "attachThumb", "", "thumbView", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/gallery/ui/ThumbDrawable$AttachThumbCallback;", "plugin-mv_release"})
  public static final class a
    implements d.g
  {
    private final String thumbPath;
    private final String videoPath;
    
    public a(String paramString1, String paramString2)
    {
      AppMethodBeat.i(256756);
      this.thumbPath = paramString1;
      this.videoPath = paramString2;
      AppMethodBeat.o(256756);
    }
    
    public final void a(ImageView paramImageView, h.a parama)
    {
      AppMethodBeat.i(256755);
      p.h(paramImageView, "thumbView");
      com.tencent.mm.plugin.gallery.ui.h.a(paramImageView, 2, this.thumbPath, this.videoPath, this.videoPath.hashCode(), parama, 0L);
      AppMethodBeat.o(256755);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$Companion;", "", "()V", "DATA_TYPE_ALBUM", "", "DATA_TYPE_CAPTURE", "DATA_TYPE_FINDER", "DATA_TYPE_UNKNOWN", "PayloadSelection", "getPayloadSelection", "()Ljava/lang/Object;", "convertFromFinderItem", "", "data", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "convertFromGalleryItem", "videoItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "convertFromMusicInfo", "", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "convertMvTrack", "mvTrack", "Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "refObjectList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "copyBasicInfo", "newItem", "plugin-mv_release"})
  public static final class b
  {
    public static d a(axz paramaxz, e parame, List<? extends FinderObject> paramList)
    {
      AppMethodBeat.i(256757);
      d locald = new d();
      locald.Amv = parame;
      locald.Apl = ((int)paramaxz.Ghu);
      locald.Apm = ((int)(paramaxz.Ghu + paramaxz.LIl));
      Iterator localIterator = ((Iterable)paramList).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (FinderObject)localIterator.next();
        if (p.j(((FinderObject)localObject).objectNonceId, paramaxz.LIm))
        {
          parame = ((FinderObject)localObject).objectDesc;
          if (parame != null)
          {
            parame = parame.media;
            if (parame != null)
            {
              FinderMedia localFinderMedia = (FinderMedia)kotlin.a.j.L((List)parame, 0);
              if (localFinderMedia != null) {
                if (paramaxz.refObjectId != 0L)
                {
                  locald.Apo = ((d.g)new d.d((FinderObject)localObject));
                  locald.App = ((d.h)new d.e((FinderObject)localObject));
                  locald.type = 2;
                }
                else
                {
                  paramList = localFinderMedia.url;
                  parame = paramList;
                  if (paramList == null) {
                    parame = "";
                  }
                  locald.Apo = ((d.g)new d.a("", parame));
                  localObject = ((FinderObject)localObject).objectNonceId;
                  if (localObject == null) {
                    p.hyc();
                  }
                  p.g(localObject, "it.objectNonceId!!");
                  paramList = localFinderMedia.url;
                  parame = paramList;
                  if (paramList == null) {
                    parame = "";
                  }
                  locald.App = ((d.h)new d.i((String)localObject, parame, localFinderMedia.videoDuration * 1000, (int)localFinderMedia.width, (int)localFinderMedia.height));
                  locald.type = 1;
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(256757);
      return locald;
    }
    
    public static void a(d paramd1, d paramd2)
    {
      AppMethodBeat.i(256758);
      p.h(paramd1, "item");
      p.h(paramd2, "newItem");
      paramd2.Amv = paramd1.Amv;
      paramd2.Apl = paramd1.Apl;
      paramd2.Apm = paramd1.Apm;
      paramd2.uOQ = paramd1.uOQ;
      paramd2.Apn = paramd1.Apn;
      AppMethodBeat.o(256758);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$DefaultThumbData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "videoInfo", "Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo;", "(Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo;)V", "attachThumb", "", "thumbView", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/gallery/ui/ThumbDrawable$AttachThumbCallback;", "plugin-mv_release"})
  public static final class c
    implements d.g
  {
    private final a Apt;
    
    public c(a parama)
    {
      AppMethodBeat.i(256760);
      this.Apt = parama;
      AppMethodBeat.o(256760);
    }
    
    public final void a(ImageView paramImageView, h.a parama)
    {
      AppMethodBeat.i(256759);
      p.h(paramImageView, "thumbView");
      com.tencent.mm.plugin.gallery.ui.h.a(paramImageView, 2, this.Apt.thumbPath, this.Apt.getFilePath(), this.Apt.hashCode(), parama, 0L);
      AppMethodBeat.o(256759);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$FinderThumbData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "attachThumb", "", "thumbView", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/gallery/ui/ThumbDrawable$AttachThumbCallback;", "plugin-mv_release"})
  public static final class d
    implements d.g
  {
    private final FinderObject Apu;
    
    public d(FinderObject paramFinderObject)
    {
      AppMethodBeat.i(256764);
      this.Apu = paramFinderObject;
      AppMethodBeat.o(256764);
    }
    
    public final void a(final ImageView paramImageView, final h.a parama)
    {
      AppMethodBeat.i(256763);
      p.h(paramImageView, "thumbView");
      Object localObject1 = this.Apu.objectDesc;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).media;
        if (localObject1 != null)
        {
          Object localObject2 = (FinderMedia)kotlin.a.j.kt((List)localObject1);
          if (localObject2 != null)
          {
            localObject1 = new c.a();
            g localg = g.Aku;
            ((c.a)localObject1).OS(g.aHP("thumb_" + this.Apu.id));
            ((c.a)localObject1).bdp();
            ((c.a)localObject1).bdo();
            localObject2 = ((FinderMedia)localObject2).thumbUrl + ((FinderMedia)localObject2).thumb_url_token;
            q.bcV().a((String)localObject2, paramImageView, ((c.a)localObject1).bdv(), (com.tencent.mm.av.a.c.h)new a(this, paramImageView, parama));
            AppMethodBeat.o(256763);
            return;
          }
        }
      }
      AppMethodBeat.o(256763);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$FinderThumbData$attachThumb$1$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"})
    public static final class a
      implements com.tencent.mm.av.a.c.h
    {
      a(d.d paramd, ImageView paramImageView, h.a parama) {}
      
      public final Bitmap a(String paramString, View paramView, b paramb)
      {
        AppMethodBeat.i(256761);
        if (paramb == null) {
          p.hyc();
        }
        paramString = paramb.bitmap;
        p.g(paramString, "imageData!!.bitmap");
        AppMethodBeat.o(256761);
        return paramString;
      }
      
      public final void b(String paramString, View paramView) {}
      
      public final void b(String paramString, View paramView, b paramb)
      {
        AppMethodBeat.i(256762);
        paramString = parama;
        if (paramString != null)
        {
          paramString.dSs();
          AppMethodBeat.o(256762);
          return;
        }
        AppMethodBeat.o(256762);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$FinderVideoData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "durationMs", "", "getDurationMs", "()J", "isLocal", "", "()Z", "startMs", "getStartMs", "setStartMs", "(J)V", "getFinderObj", "getTpMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "plugin-mv_release"})
  public static final class e
    implements d.h
  {
    private final FinderObject Apu;
    private final boolean dLQ;
    private long eiq;
    
    public e(FinderObject paramFinderObject)
    {
      AppMethodBeat.i(256767);
      this.Apu = paramFinderObject;
      AppMethodBeat.o(256767);
    }
    
    public final void Hr(long paramLong)
    {
      this.eiq = paramLong;
    }
    
    public final boolean dkS()
    {
      return this.dLQ;
    }
    
    public final com.tencent.mm.plugin.thumbplayer.d.a evA()
    {
      AppMethodBeat.i(256766);
      Object localObject1 = this.Apu.objectDesc;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).media;
        if (localObject1 != null)
        {
          FinderMedia localFinderMedia = (FinderMedia)kotlin.a.j.kt((List)localObject1);
          if (localFinderMedia != null)
          {
            Object localObject2 = "video_" + this.Apu.id;
            localObject1 = g.Aku;
            String str2 = g.aHQ((String)localObject2);
            localObject1 = com.tencent.mm.plugin.thumbplayer.a.Ggt;
            localObject1 = MMApplicationContext.getContext();
            p.g(localObject1, "MMApplicationContext.getContext()");
            localObject1 = com.tencent.mm.plugin.thumbplayer.a.k((Context)localObject1, (int)localFinderMedia.width, (int)localFinderMedia.height);
            ((Bundle)localObject1).getInt("width", 0);
            ((Bundle)localObject1).getInt("height", 0);
            String str1 = localFinderMedia.url;
            localObject1 = str1;
            if (str1 == null) {
              localObject1 = "";
            }
            localObject2 = new com.tencent.mm.plugin.thumbplayer.d.a((String)localObject2, str2, (String)localObject1, (int)localFinderMedia.width, (int)localFinderMedia.height);
            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghr = Integer.valueOf(2);
            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).dVY = "xV2";
            str1 = localFinderMedia.url_token;
            localObject1 = str1;
            if (str1 == null) {
              localObject1 = "";
            }
            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).aTt((String)localObject1);
            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).decodeKey = localFinderMedia.decodeKey;
            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).pLQ = (localFinderMedia.videoDuration * 1000L);
            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).GR(localFinderMedia.thumbUrl + localFinderMedia.thumb_url_token);
            localObject1 = g.Aku;
            localObject1 = g.aHP("thumb_" + this.Apu.id);
            p.h(localObject1, "<set-?>");
            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).thumbPath = ((String)localObject1);
            AppMethodBeat.o(256766);
            return localObject2;
          }
        }
      }
      AppMethodBeat.o(256766);
      return null;
    }
    
    public final FinderObject evB()
    {
      return this.Apu;
    }
    
    public final long evz()
    {
      return this.eiq;
    }
    
    public final long getDurationMs()
    {
      AppMethodBeat.i(256765);
      Object localObject = this.Apu.objectDesc;
      if (localObject != null)
      {
        localObject = ((FinderObjectDesc)localObject).media;
        if (localObject != null)
        {
          localObject = (FinderMedia)kotlin.a.j.kt((List)localObject);
          if (localObject == null) {}
        }
      }
      for (int i = ((FinderMedia)localObject).videoDuration;; i = 0)
      {
        long l = i;
        AppMethodBeat.o(256765);
        return l * 1000L;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$GalleryThumbData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "videoItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;)V", "attachThumb", "", "thumbView", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/gallery/ui/ThumbDrawable$AttachThumbCallback;", "plugin-mv_release"})
  public static final class f
    implements d.g
  {
    private final GalleryItem.VideoMediaItem Apy;
    
    public f(GalleryItem.VideoMediaItem paramVideoMediaItem)
    {
      AppMethodBeat.i(256769);
      this.Apy = paramVideoMediaItem;
      AppMethodBeat.o(256769);
    }
    
    public final void a(ImageView paramImageView, h.a parama)
    {
      AppMethodBeat.i(256768);
      p.h(paramImageView, "thumbView");
      com.tencent.mm.plugin.gallery.ui.h.a(paramImageView, this.Apy.getType(), this.Apy.aQn(), this.Apy.dRh(), this.Apy.xiZ, parama, this.Apy.xja);
      AppMethodBeat.o(256768);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "", "attachThumb", "", "thumbView", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/gallery/ui/ThumbDrawable$AttachThumbCallback;", "plugin-mv_release"})
  public static abstract interface g
  {
    public abstract void a(ImageView paramImageView, h.a parama);
    
    @l(hxD={1, 1, 16})
    public static final class a {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "", "durationMs", "", "getDurationMs", "()J", "isLocal", "", "()Z", "startMs", "getStartMs", "setStartMs", "(J)V", "getFinderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getTpMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "plugin-mv_release"})
  public static abstract interface h
  {
    public abstract void Hr(long paramLong);
    
    public abstract boolean dkS();
    
    public abstract com.tencent.mm.plugin.thumbplayer.d.a evA();
    
    public abstract FinderObject evB();
    
    public abstract long evz();
    
    public abstract long getDurationMs();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$LocalVideoData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "mediaId", "", "videoPath", "durationMs", "", "videoWidth", "", "videoHeight", "(Ljava/lang/String;Ljava/lang/String;JII)V", "getDurationMs", "()J", "isDefault", "", "()Z", "setDefault", "(Z)V", "isLocal", "localFinderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMediaId", "()Ljava/lang/String;", "startMs", "getStartMs", "setStartMs", "(J)V", "getVideoHeight", "()I", "setVideoHeight", "(I)V", "getVideoPath", "getVideoWidth", "setVideoWidth", "getFinderObj", "getTpMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "Companion", "plugin-mv_release"})
  public static final class i
    implements d.h
  {
    public static final a ApA;
    private static long jkM;
    private final FinderObject Apz;
    private final boolean dLQ;
    public final long durationMs;
    private long eiq;
    public boolean isDefault;
    private final String mediaId;
    public int videoHeight;
    public final String videoPath;
    public int videoWidth;
    
    static
    {
      AppMethodBeat.i(256774);
      ApA = new a((byte)0);
      AppMethodBeat.o(256774);
    }
    
    public i(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(256773);
      this.mediaId = paramString1;
      this.videoPath = paramString2;
      this.durationMs = paramLong;
      this.videoWidth = paramInt1;
      this.videoHeight = paramInt2;
      this.dLQ = true;
      this.Apz = new FinderObject();
      paramLong = cl.aWy();
      if (jkM == paramLong) {}
      for (jkM += 1L;; jkM = paramLong)
      {
        paramString2 = "local_" + jkM;
        paramString1 = new FinderMedia();
        paramString1.url = this.videoPath;
        this.Apz.objectNonceId = paramString2;
        paramString2 = this.Apz;
        FinderObjectDesc localFinderObjectDesc = new FinderObjectDesc();
        localFinderObjectDesc.media.add(paramString1);
        paramString2.objectDesc = localFinderObjectDesc;
        AppMethodBeat.o(256773);
        return;
      }
    }
    
    public final void Hr(long paramLong)
    {
      this.eiq = paramLong;
    }
    
    public final boolean dkS()
    {
      return this.dLQ;
    }
    
    public final com.tencent.mm.plugin.thumbplayer.d.a evA()
    {
      AppMethodBeat.i(256771);
      com.tencent.mm.plugin.thumbplayer.d.a locala = new com.tencent.mm.plugin.thumbplayer.d.a(this.mediaId, this.videoPath, "", this.videoWidth, this.videoHeight);
      locala.Ghr = Integer.valueOf(2);
      locala.dVY = "xV2";
      locala.dLQ = true;
      MultiMediaVideoChecker.a locala1 = MultiMediaVideoChecker.GyY.cA(this.videoPath, true);
      long l;
      if (locala1 != null)
      {
        l = locala1.duration;
        locala.pLQ = l;
        if (locala1 == null) {
          break label114;
        }
      }
      label114:
      for (int i = locala1.dYT;; i = 0)
      {
        locala.dYT = i;
        AppMethodBeat.o(256771);
        return locala;
        l = 0L;
        break;
      }
    }
    
    public final FinderObject evB()
    {
      AppMethodBeat.i(256772);
      if (this.isDefault)
      {
        AppMethodBeat.o(256772);
        return null;
      }
      Object localObject = this.Apz.objectDesc;
      if (localObject != null)
      {
        localObject = ((FinderObjectDesc)localObject).media;
        if (localObject != null)
        {
          localObject = (FinderMedia)((LinkedList)localObject).get(0);
          if (localObject != null) {
            ((FinderMedia)localObject).width = this.videoWidth;
          }
        }
      }
      localObject = this.Apz.objectDesc;
      if (localObject != null)
      {
        localObject = ((FinderObjectDesc)localObject).media;
        if (localObject != null)
        {
          localObject = (FinderMedia)((LinkedList)localObject).get(0);
          if (localObject != null) {
            ((FinderMedia)localObject).height = this.videoHeight;
          }
        }
      }
      localObject = this.Apz.objectDesc;
      if (localObject != null)
      {
        localObject = ((FinderObjectDesc)localObject).media;
        if (localObject != null)
        {
          localObject = (FinderMedia)((LinkedList)localObject).get(0);
          if (localObject != null) {
            ((FinderMedia)localObject).videoDuration = kotlin.h.a.cR((float)this.durationMs / 1000.0F);
          }
        }
      }
      localObject = this.Apz;
      AppMethodBeat.o(256772);
      return localObject;
    }
    
    public final long evz()
    {
      return this.eiq;
    }
    
    public final long getDurationMs()
    {
      return this.durationMs;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$LocalVideoData$Companion;", "", "()V", "lastTick", "", "plugin-mv_release"})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.d
 * JD-Core Version:    0.7.0.1
 */