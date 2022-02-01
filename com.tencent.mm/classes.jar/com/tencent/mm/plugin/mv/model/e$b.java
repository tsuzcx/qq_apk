package com.tencent.mm.plugin.mv.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment.f;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.boq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$Companion;", "", "()V", "DATA_TYPE_ALBUM", "", "DATA_TYPE_CAPTURE", "DATA_TYPE_FINDER", "DATA_TYPE_UNKNOWN", "PayloadSelection", "getPayloadSelection", "()Ljava/lang/Object;", "convertFromFinderItem", "", "data", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "convertFromGalleryItem", "mediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "videoItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "convertFromMusicInfo", "Lkotlin/Pair;", "", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "convertMvTrack", "mvTrack", "Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "refObjectList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "copyBasicInfo", "newItem", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$b
{
  public static e a(boq paramboq, com.tencent.mm.plugin.music.model.e parame, List<? extends FinderObject> paramList)
  {
    AppMethodBeat.i(286174);
    e locale = new e();
    if ((parame != null) && (parame.LMm.size() > 1)) {
      locale.LOA = parame;
    }
    locale.LWU = ((int)paramboq.TBM);
    locale.LWV = ((int)(paramboq.TBM + paramboq.ZWY));
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (FinderObject)localIterator.next();
      if (s.p(((FinderObject)localObject).objectNonceId, paramboq.ZWZ))
      {
        parame = ((FinderObject)localObject).objectDesc;
        if (parame != null)
        {
          parame = parame.media;
          if (parame != null)
          {
            FinderMedia localFinderMedia = (FinderMedia)p.ae((List)parame, 0);
            if (localFinderMedia != null)
            {
              if (paramboq.refObjectId != 0L)
              {
                locale.LWX = ((e.g)new e.d((FinderObject)localObject));
                locale.LWY = ((e.h)new e.e((FinderObject)localObject));
              }
              for (locale.type = 2;; locale.type = 1)
              {
                parame = locale.LWY;
                if (parame == null) {
                  break;
                }
                parame.sF(paramboq.TBO);
                break;
                paramList = localFinderMedia.url;
                parame = paramList;
                if (paramList == null) {
                  parame = "";
                }
                locale.LWX = ((e.g)new e.a("", parame));
                localObject = ((FinderObject)localObject).objectNonceId;
                s.checkNotNull(localObject);
                s.s(localObject, "it.objectNonceId!!");
                paramList = localFinderMedia.url;
                parame = paramList;
                if (paramList == null) {
                  parame = "";
                }
                locale.LWY = ((e.h)new e.i((String)localObject, parame, localFinderMedia.videoDuration * 1000, (int)localFinderMedia.width, (int)localFinderMedia.height));
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(286174);
    return locale;
  }
  
  public static void a(e parame1, e parame2)
  {
    AppMethodBeat.i(286178);
    s.u(parame1, "item");
    s.u(parame2, "newItem");
    parame2.LOA = parame1.LOA;
    parame2.LWU = parame1.LWU;
    parame2.LWV = parame1.LWV;
    parame2.Bvd = parame1.Bvd;
    parame2.LWW = parame1.LWW;
    AppMethodBeat.o(286178);
  }
  
  public static void a(MusicMvTabFragment.f paramf, e parame)
  {
    AppMethodBeat.i(286188);
    s.u(paramf, "data");
    s.u(parame, "item");
    parame.type = 2;
    FinderObject localFinderObject = paramf.feedObject;
    s.checkNotNull(localFinderObject);
    parame.LWX = ((e.g)new e.d(localFinderObject));
    paramf = paramf.feedObject;
    s.checkNotNull(paramf);
    parame.LWY = ((e.h)new e.e(paramf));
    AppMethodBeat.o(286188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.e.b
 * JD-Core Version:    0.7.0.1
 */