package com.tencent.mm.plugin.mv.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.ui.h.a;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment.f;
import com.tencent.mm.plugin.thumbplayer.e.d;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "backItem", "getBackItem", "()Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "setBackItem", "(Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;)V", "durationMs", "", "getDurationMs", "()I", "endMs", "getEndMs", "setEndMs", "(I)V", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "getLyricObj", "()Lcom/tencent/mm/plugin/music/model/LyricObj;", "setLyricObj", "(Lcom/tencent/mm/plugin/music/model/LyricObj;)V", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "startMs", "getStartMs", "setStartMs", "syncMusic", "getSyncMusic", "setSyncMusic", "thumbData", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "getThumbData", "()Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "setThumbData", "(Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;)V", "type", "getType", "setType", "videoData", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "getVideoData", "()Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "setVideoData", "(Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;)V", "getFeedId", "", "getFinderUin", "getItemId", "", "getItemType", "getLyricLine", "currentPos", "isNull", "CaptureThumbData", "Companion", "DefaultThumbData", "FinderThumbData", "FinderVideoData", "GalleryThumbData", "IThumbData", "IVideoData", "LocalVideoData", "plugin-mv_release"})
public final class e
  implements com.tencent.mm.view.recyclerview.a
{
  private static final Object GaZ;
  public static final b Gba;
  com.tencent.mm.plugin.music.model.e FTB;
  public int GaT;
  public int GaU;
  public boolean GaV;
  public g GaW;
  public h GaX;
  public e GaY;
  public int type;
  public boolean xUg;
  
  static
  {
    AppMethodBeat.i(230102);
    Gba = new b((byte)0);
    GaZ = new Object();
    AppMethodBeat.o(230102);
  }
  
  public e()
  {
    AppMethodBeat.i(230100);
    Object localObject = b.GaR;
    localObject = b.a.ffS();
    this.GaW = ((g)new c((b)localObject));
    i locali = new i(((b)localObject).getFilePath(), ((b)localObject).getFilePath(), ((b)localObject).durationMs);
    locali.videoWidth = ((b)localObject).width;
    locali.videoHeight = ((b)localObject).height;
    locali.lJx = true;
    this.GaX = ((h)locali);
    AppMethodBeat.o(230100);
  }
  
  public final String ZD(int paramInt)
  {
    AppMethodBeat.i(230090);
    Object localObject = this.FTB;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.music.model.e)localObject).Zm(((com.tencent.mm.plugin.music.model.e)localObject).OF(paramInt));
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.music.model.e.a)localObject).content;
        AppMethodBeat.o(230090);
        return localObject;
      }
      AppMethodBeat.o(230090);
      return null;
    }
    AppMethodBeat.o(230090);
    return null;
  }
  
  public final String ahZ()
  {
    AppMethodBeat.i(230097);
    Object localObject = this.GaX;
    if (localObject != null)
    {
      localObject = ((h)localObject).ffY();
      if (localObject == null) {}
    }
    for (long l = ((FinderObject)localObject).id;; l = 0L)
    {
      localObject = Util.getUnsignedLongString(l);
      p.j(localObject, "Util.getUnsignedLongStri…getFinderObj()?.id ?: 0L)");
      AppMethodBeat.o(230097);
      return localObject;
    }
  }
  
  public final int bAQ()
  {
    return 4;
  }
  
  public final String ffT()
  {
    AppMethodBeat.i(230098);
    Object localObject1 = this.GaX;
    if (localObject1 != null)
    {
      localObject1 = ((h)localObject1).ffY();
      if (localObject1 != null)
      {
        localObject2 = ((FinderObject)localObject1).username;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label40;
        }
      }
    }
    localObject1 = z.bcZ();
    label40:
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    AppMethodBeat.o(230098);
    return localObject2;
  }
  
  public final long ffU()
  {
    e locale = this.GaY;
    if ((locale != null) && (locale.type == 0)) {
      return 1L;
    }
    return 0L;
  }
  
  public final int getDurationMs()
  {
    return this.GaU - this.GaT;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(230095);
    long l = hashCode();
    AppMethodBeat.o(230095);
    return l;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$CaptureThumbData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "thumbPath", "", "videoPath", "(Ljava/lang/String;Ljava/lang/String;)V", "getThumbPath", "()Ljava/lang/String;", "getVideoPath", "attachThumb", "", "thumbView", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/gallery/ui/ThumbDrawable$AttachThumbCallback;", "plugin-mv_release"})
  public static final class a
    implements e.g
  {
    private final String thumbPath;
    private final String videoPath;
    
    public a(String paramString1, String paramString2)
    {
      AppMethodBeat.i(241203);
      this.thumbPath = paramString1;
      this.videoPath = paramString2;
      AppMethodBeat.o(241203);
    }
    
    public final void a(ImageView paramImageView, h.a parama)
    {
      AppMethodBeat.i(241199);
      p.k(paramImageView, "thumbView");
      com.tencent.mm.plugin.gallery.ui.h.a(paramImageView, 2, this.thumbPath, this.videoPath, this.videoPath.hashCode(), parama, 0L);
      AppMethodBeat.o(241199);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$Companion;", "", "()V", "DATA_TYPE_ALBUM", "", "DATA_TYPE_CAPTURE", "DATA_TYPE_FINDER", "DATA_TYPE_UNKNOWN", "PayloadSelection", "getPayloadSelection", "()Ljava/lang/Object;", "convertFromFinderItem", "", "data", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "convertFromGalleryItem", "mediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "videoItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "convertFromMusicInfo", "Lkotlin/Pair;", "", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "convertMvTrack", "mvTrack", "Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "refObjectList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "copyBasicInfo", "newItem", "plugin-mv_release"})
  public static final class b
  {
    public static e a(bdt parambdt, com.tencent.mm.plugin.music.model.e parame, List<? extends FinderObject> paramList)
    {
      AppMethodBeat.i(228953);
      e locale = new e();
      if ((parame != null) && (parame.feO() > 1)) {
        locale.FTB = parame;
      }
      locale.GaT = ((int)parambdt.MSE);
      locale.GaU = ((int)(parambdt.MSE + parambdt.SOR));
      Iterator localIterator = ((Iterable)paramList).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (FinderObject)localIterator.next();
        if (p.h(((FinderObject)localObject).objectNonceId, parambdt.SOS))
        {
          parame = ((FinderObject)localObject).objectDesc;
          if (parame != null)
          {
            parame = parame.media;
            if (parame != null)
            {
              FinderMedia localFinderMedia = (FinderMedia)j.M((List)parame, 0);
              if (localFinderMedia != null)
              {
                if (parambdt.refObjectId != 0L)
                {
                  locale.GaW = ((e.g)new e.d((FinderObject)localObject));
                  locale.GaX = ((e.h)new e.e((FinderObject)localObject));
                }
                for (locale.type = 2;; locale.type = 1)
                {
                  parame = locale.GaX;
                  if (parame == null) {
                    break;
                  }
                  parame.OH(parambdt.MSG);
                  break;
                  paramList = localFinderMedia.url;
                  parame = paramList;
                  if (paramList == null) {
                    parame = "";
                  }
                  locale.GaW = ((e.g)new e.a("", parame));
                  localObject = ((FinderObject)localObject).objectNonceId;
                  if (localObject == null) {
                    p.iCn();
                  }
                  p.j(localObject, "it.objectNonceId!!");
                  paramList = localFinderMedia.url;
                  parame = paramList;
                  if (paramList == null) {
                    parame = "";
                  }
                  locale.GaX = ((e.h)new e.i((String)localObject, parame, localFinderMedia.videoDuration * 1000, (int)localFinderMedia.width, (int)localFinderMedia.height));
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(228953);
      return locale;
    }
    
    public static void a(e parame1, e parame2)
    {
      AppMethodBeat.i(228957);
      p.k(parame1, "item");
      p.k(parame2, "newItem");
      parame2.FTB = parame1.FTB;
      parame2.GaT = parame1.GaT;
      parame2.GaU = parame1.GaU;
      parame2.xUg = parame1.xUg;
      parame2.GaV = parame1.GaV;
      AppMethodBeat.o(228957);
    }
    
    public static void a(MusicMvTabFragment.f paramf, e parame)
    {
      AppMethodBeat.i(228959);
      p.k(paramf, "data");
      p.k(parame, "item");
      parame.type = 2;
      FinderObject localFinderObject = paramf.feedObject;
      if (localFinderObject == null) {
        p.iCn();
      }
      parame.GaW = ((e.g)new e.d(localFinderObject));
      paramf = paramf.feedObject;
      if (paramf == null) {
        p.iCn();
      }
      parame.GaX = ((e.h)new e.e(paramf));
      AppMethodBeat.o(228959);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$DefaultThumbData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "videoInfo", "Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo;", "(Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo;)V", "attachThumb", "", "thumbView", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/gallery/ui/ThumbDrawable$AttachThumbCallback;", "plugin-mv_release"})
  public static final class c
    implements e.g
  {
    private final b Gbb;
    
    public c(b paramb)
    {
      AppMethodBeat.i(231793);
      this.Gbb = paramb;
      AppMethodBeat.o(231793);
    }
    
    public final void a(ImageView paramImageView, h.a parama)
    {
      AppMethodBeat.i(231790);
      p.k(paramImageView, "thumbView");
      com.tencent.mm.plugin.gallery.ui.h.a(paramImageView, 2, this.Gbb.thumbPath, this.Gbb.getFilePath(), this.Gbb.hashCode(), parama, 0L);
      AppMethodBeat.o(231790);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$FinderThumbData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "attachThumb", "", "thumbView", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/gallery/ui/ThumbDrawable$AttachThumbCallback;", "plugin-mv_release"})
  public static final class d
    implements e.g
  {
    private final FinderObject Gbc;
    
    public d(FinderObject paramFinderObject)
    {
      AppMethodBeat.i(226011);
      this.Gbc = paramFinderObject;
      AppMethodBeat.o(226011);
    }
    
    public final void a(final ImageView paramImageView, final h.a parama)
    {
      AppMethodBeat.i(226009);
      p.k(paramImageView, "thumbView");
      Object localObject1 = this.Gbc.objectDesc;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).media;
        if (localObject1 != null)
        {
          Object localObject2 = (FinderMedia)j.lp((List)localObject1);
          if (localObject2 != null)
          {
            localObject1 = new c.a();
            g localg = g.FRy;
            ((c.a)localObject1).Wq(g.aSf("thumb_" + this.Gbc.id));
            ((c.a)localObject1).bmF();
            ((c.a)localObject1).gs(true);
            localObject2 = ((FinderMedia)localObject2).thumbUrl + ((FinderMedia)localObject2).thumb_url_token;
            q.bml().a((String)localObject2, paramImageView, ((c.a)localObject1).bmL(), (com.tencent.mm.ay.a.c.h)new a(this, paramImageView, parama));
            AppMethodBeat.o(226009);
            return;
          }
        }
      }
      AppMethodBeat.o(226009);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$FinderThumbData$attachThumb$1$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"})
    public static final class a
      implements com.tencent.mm.ay.a.c.h
    {
      a(e.d paramd, ImageView paramImageView, h.a parama) {}
      
      public final Bitmap a(String paramString, View paramView, com.tencent.mm.ay.a.d.b paramb)
      {
        AppMethodBeat.i(229247);
        if (paramb == null) {
          p.iCn();
        }
        paramString = paramb.bitmap;
        p.j(paramString, "imageData!!.bitmap");
        AppMethodBeat.o(229247);
        return paramString;
      }
      
      public final void b(String paramString, View paramView) {}
      
      public final void b(String paramString, View paramView, com.tencent.mm.ay.a.d.b paramb)
      {
        AppMethodBeat.i(229250);
        paramString = parama;
        if (paramString != null)
        {
          paramString.euT();
          AppMethodBeat.o(229250);
          return;
        }
        AppMethodBeat.o(229250);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$FinderVideoData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "durationMs", "", "getDurationMs", "()J", "setDurationMs", "(J)V", "isLocal", "", "()Z", "startMs", "getStartMs", "setStartMs", "getFinderObj", "getTpMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "plugin-mv_release"})
  public static final class e
    implements e.h
  {
    private final FinderObject Gbc;
    private long durationMs;
    private final boolean fEF;
    private long gcH;
    
    public e(FinderObject paramFinderObject)
    {
      AppMethodBeat.i(242884);
      this.Gbc = paramFinderObject;
      paramFinderObject = this.Gbc.objectDesc;
      if (paramFinderObject != null)
      {
        paramFinderObject = paramFinderObject.media;
        if (paramFinderObject != null)
        {
          paramFinderObject = (FinderMedia)j.lp((List)paramFinderObject);
          if (paramFinderObject == null) {}
        }
      }
      for (int i = paramFinderObject.videoDuration;; i = 0)
      {
        this.durationMs = (i * 1000L);
        AppMethodBeat.o(242884);
        return;
      }
    }
    
    public final void OG(long paramLong)
    {
      this.durationMs = paramLong;
    }
    
    public final void OH(long paramLong)
    {
      this.gcH = paramLong;
    }
    
    public final boolean dKS()
    {
      return this.fEF;
    }
    
    public final long ffW()
    {
      return this.gcH;
    }
    
    public final d ffX()
    {
      AppMethodBeat.i(242883);
      Object localObject1 = this.Gbc.objectDesc;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).media;
        if (localObject1 != null)
        {
          FinderMedia localFinderMedia = (FinderMedia)j.lp((List)localObject1);
          if (localFinderMedia != null)
          {
            Object localObject2 = "video_" + this.Gbc.id;
            localObject1 = g.FRy;
            String str2 = g.aSg((String)localObject2);
            localObject1 = com.tencent.mm.plugin.thumbplayer.b.MPi;
            localObject1 = MMApplicationContext.getContext();
            p.j(localObject1, "MMApplicationContext.getContext()");
            localObject1 = com.tencent.mm.plugin.thumbplayer.b.l((Context)localObject1, (int)localFinderMedia.width, (int)localFinderMedia.height);
            ((Bundle)localObject1).getInt("width", 0);
            ((Bundle)localObject1).getInt("height", 0);
            String str1 = localFinderMedia.url;
            localObject1 = str1;
            if (str1 == null) {
              localObject1 = "";
            }
            localObject2 = new d((String)localObject2, str2, (String)localObject1, (int)localFinderMedia.width, (int)localFinderMedia.height);
            ((d)localObject2).MSA = Integer.valueOf(2);
            ((d)localObject2).fPD = "xV2";
            str1 = localFinderMedia.url_token;
            localObject1 = str1;
            if (str1 == null) {
              localObject1 = "";
            }
            ((d)localObject2).beR((String)localObject1);
            ((d)localObject2).decodeKey = localFinderMedia.decodeKey;
            ((d)localObject2).sTg = (localFinderMedia.videoDuration * 1000L);
            ((d)localObject2).Oc(localFinderMedia.thumbUrl + localFinderMedia.thumb_url_token);
            localObject1 = g.FRy;
            ((d)localObject2).ON(g.aSf("thumb_" + this.Gbc.id));
            AppMethodBeat.o(242883);
            return localObject2;
          }
        }
      }
      AppMethodBeat.o(242883);
      return null;
    }
    
    public final FinderObject ffY()
    {
      return this.Gbc;
    }
    
    public final long getDurationMs()
    {
      return this.durationMs;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$GalleryThumbData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "mediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)V", "attachThumb", "", "thumbView", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/gallery/ui/ThumbDrawable$AttachThumbCallback;", "plugin-mv_release"})
  public static final class f
    implements e.g
  {
    private final GalleryItem.MediaItem BVd;
    
    public f(GalleryItem.MediaItem paramMediaItem)
    {
      AppMethodBeat.i(231003);
      this.BVd = paramMediaItem;
      AppMethodBeat.o(231003);
    }
    
    public final void a(ImageView paramImageView, h.a parama)
    {
      AppMethodBeat.i(231002);
      p.k(paramImageView, "thumbView");
      com.tencent.mm.plugin.gallery.ui.h.a(paramImageView, this.BVd.getType(), this.BVd.aZe(), this.BVd.etI(), this.BVd.BVl, parama, this.BVd.BVm);
      AppMethodBeat.o(231002);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "", "attachThumb", "", "thumbView", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/gallery/ui/ThumbDrawable$AttachThumbCallback;", "plugin-mv_release"})
  public static abstract interface g
  {
    public abstract void a(ImageView paramImageView, h.a parama);
    
    @l(iBK={1, 1, 16})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "", "durationMs", "", "getDurationMs", "()J", "setDurationMs", "(J)V", "isLocal", "", "()Z", "startMs", "getStartMs", "setStartMs", "getFinderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getTpMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "plugin-mv_release"})
  public static abstract interface h
  {
    public abstract void OG(long paramLong);
    
    public abstract void OH(long paramLong);
    
    public abstract boolean dKS();
    
    public abstract long ffW();
    
    public abstract d ffX();
    
    public abstract FinderObject ffY();
    
    public abstract long getDurationMs();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$LocalVideoData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "mediaId", "", "videoPath", "durationMs", "", "videoWidth", "", "videoHeight", "(Ljava/lang/String;Ljava/lang/String;JII)V", "getDurationMs", "()J", "setDurationMs", "(J)V", "isDefault", "", "()Z", "setDefault", "(Z)V", "isLocal", "localFinderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMediaId", "()Ljava/lang/String;", "startMs", "getStartMs", "setStartMs", "getVideoHeight", "()I", "setVideoHeight", "(I)V", "getVideoPath", "getVideoWidth", "setVideoWidth", "getFinderObj", "getTpMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "Companion", "plugin-mv_release"})
  public static final class i
    implements e.h
  {
    public static final e.i.a Gbh;
    private static long maN;
    private final FinderObject Gbg;
    private long durationMs;
    private final boolean fEF;
    private long gcH;
    public boolean lJx;
    private final String mediaId;
    public int videoHeight;
    public final String videoPath;
    public int videoWidth;
    
    static
    {
      AppMethodBeat.i(235807);
      Gbh = new e.i.a((byte)0);
      AppMethodBeat.o(235807);
    }
    
    public i(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(235804);
      this.mediaId = paramString1;
      this.videoPath = paramString2;
      this.durationMs = paramLong;
      this.videoWidth = paramInt1;
      this.videoHeight = paramInt2;
      this.fEF = true;
      this.Gbg = new FinderObject();
      paramLong = cm.bfC();
      if (maN == paramLong) {}
      for (maN += 1L;; maN = paramLong)
      {
        paramString2 = "local_" + maN;
        paramString1 = new FinderMedia();
        paramString1.url = this.videoPath;
        this.Gbg.objectNonceId = paramString2;
        paramString2 = this.Gbg;
        FinderObjectDesc localFinderObjectDesc = new FinderObjectDesc();
        localFinderObjectDesc.media.add(paramString1);
        paramString2.objectDesc = localFinderObjectDesc;
        AppMethodBeat.o(235804);
        return;
      }
    }
    
    public final void OG(long paramLong)
    {
      this.durationMs = paramLong;
    }
    
    public final void OH(long paramLong)
    {
      this.gcH = paramLong;
    }
    
    public final boolean dKS()
    {
      return this.fEF;
    }
    
    public final long ffW()
    {
      return this.gcH;
    }
    
    public final d ffX()
    {
      AppMethodBeat.i(235796);
      d locald = new d(this.mediaId, this.videoPath, "", this.videoWidth, this.videoHeight);
      locald.MSA = Integer.valueOf(2);
      locald.fPD = "xV2";
      locald.fEF = true;
      MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.NmA.cO(this.videoPath, true);
      long l;
      if (locala != null)
      {
        l = locala.duration;
        locald.sTg = l;
        if (locala == null) {
          break label114;
        }
      }
      label114:
      for (int i = locala.fSM;; i = 0)
      {
        locald.fSM = i;
        AppMethodBeat.o(235796);
        return locald;
        l = 0L;
        break;
      }
    }
    
    public final FinderObject ffY()
    {
      AppMethodBeat.i(235799);
      if (this.lJx)
      {
        AppMethodBeat.o(235799);
        return null;
      }
      Object localObject = this.Gbg.objectDesc;
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
      localObject = this.Gbg.objectDesc;
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
      localObject = this.Gbg.objectDesc;
      if (localObject != null)
      {
        localObject = ((FinderObjectDesc)localObject).media;
        if (localObject != null)
        {
          localObject = (FinderMedia)((LinkedList)localObject).get(0);
          if (localObject != null) {
            ((FinderMedia)localObject).videoDuration = kotlin.h.a.dm((float)this.durationMs / 1000.0F);
          }
        }
      }
      localObject = this.Gbg;
      AppMethodBeat.o(235799);
      return localObject;
    }
    
    public final long getDurationMs()
    {
      return this.durationMs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.e
 * JD-Core Version:    0.7.0.1
 */