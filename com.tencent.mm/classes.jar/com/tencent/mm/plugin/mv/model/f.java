package com.tencent.mm.plugin.mv.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/MusicMv;", "", "()V", "commentCount", "", "getCommentCount", "()I", "setCommentCount", "(I)V", "coverUrl", "", "getCoverUrl", "()Ljava/lang/String;", "setCoverUrl", "(Ljava/lang/String;)V", "flexClipDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "getFlexClipDataList", "()Ljava/util/LinkedList;", "setFlexClipDataList", "(Ljava/util/LinkedList;)V", "forwardCount", "getForwardCount", "setForwardCount", "isDelete", "", "()Z", "setDelete", "(Z)V", "isLike", "setLike", "likeCount", "getLikeCount", "setLikeCount", "localCoverPath", "getLocalCoverPath", "setLocalCoverPath", "localId", "", "getLocalId", "()Ljava/lang/Long;", "setLocalId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "mvMakerInfo", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getMvMakerInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setMvMakerInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "mvMakerNickName", "getMvMakerNickName", "setMvMakerNickName", "mvObjectId", "getMvObjectId", "setMvObjectId", "mvObjectNonceId", "getMvObjectNonceId", "setMvObjectNonceId", "mvPostStatus", "getMvPostStatus", "setMvPostStatus", "mvType", "getMvType", "setMvType", "normalMvObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getNormalMvObj", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setNormalMvObj", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "originalInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVOriginalInfo;", "getOriginalInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVOriginalInfo;", "setOriginalInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVOriginalInfo;)V", "pauseTimes", "getPauseTimes", "()J", "setPauseTimes", "(J)V", "playMvTime", "getPlayMvTime", "setPlayMvTime", "postSuccessMvObj", "getPostSuccessMvObj", "setPostSuccessMvObj", "postSuccessRefObjList", "getPostSuccessRefObjList", "setPostSuccessRefObjList", "refVideoList", "getRefVideoList", "setRefVideoList", "showQQMusic", "getShowQQMusic", "setShowQQMusic", "snapshotCover", "Landroid/graphics/Bitmap;", "getSnapshotCover", "()Landroid/graphics/Bitmap;", "setSnapshotCover", "(Landroid/graphics/Bitmap;)V", "startMvTimeStamp", "getStartMvTimeStamp", "setStartMvTimeStamp", "trackDataList", "getTrackDataList", "setTrackDataList", "toTpMediaInfoList", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaSEInfo;", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final a LXf;
  public boolean AcH;
  int LXA;
  public Long LXg;
  public Bitmap LXh;
  public String LXi;
  public Long LXj;
  public String LXk;
  public String LXl;
  public LinkedList<boq> LXm;
  LinkedList<boq> LXn;
  public bon LXo;
  public FinderContact LXp;
  public boolean LXq;
  public LinkedList<FinderObject> LXr;
  public int LXs;
  public FinderObject LXt;
  public boolean LXu;
  public FinderObject LXv;
  public LinkedList<FinderObject> LXw;
  public long LXx;
  public long LXy;
  public long LXz;
  public int commentCount;
  public String coverUrl;
  public int forwardCount;
  public int likeCount;
  
  static
  {
    AppMethodBeat.i(286069);
    LXf = new a((byte)0);
    AppMethodBeat.o(286069);
  }
  
  public f()
  {
    AppMethodBeat.i(286063);
    this.LXl = "";
    this.LXm = new LinkedList();
    this.LXn = new LinkedList();
    this.LXr = new LinkedList();
    this.LXs = 1;
    this.LXw = new LinkedList();
    AppMethodBeat.o(286063);
  }
  
  public final void aPx(String paramString)
  {
    AppMethodBeat.i(286077);
    s.u(paramString, "<set-?>");
    this.LXl = paramString;
    AppMethodBeat.o(286077);
  }
  
  public final void bH(LinkedList<FinderObject> paramLinkedList)
  {
    AppMethodBeat.i(286086);
    s.u(paramLinkedList, "<set-?>");
    this.LXr = paramLinkedList;
    AppMethodBeat.o(286086);
  }
  
  public final LinkedList<com.tencent.mm.plugin.thumbplayer.d.d> gpD()
  {
    AppMethodBeat.i(286122);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1;
    int k;
    boq localboq;
    Object localObject3;
    Object localObject2;
    int i;
    label160:
    int j;
    if (this.LXA == 1)
    {
      localObject1 = this.LXn;
      Iterator localIterator = ((Iterable)localObject1).iterator();
      k = 0;
      if (!localIterator.hasNext()) {
        break label1527;
      }
      localObject1 = localIterator.next();
      if (k < 0) {
        p.kkW();
      }
      localboq = (boq)localObject1;
      if (localboq.refObjectId == 0L) {
        break label1552;
      }
      localObject1 = ((Iterable)((f)this).LXr).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (FinderObject)((Iterator)localObject1).next();
          localObject2 = com.tencent.mm.plugin.thumbplayer.d.d.TEU;
          if (((FinderObject)localObject3).id == localboq.refObjectId)
          {
            localObject1 = ((FinderObject)localObject3).objectDesc;
            if (localObject1 == null)
            {
              localObject1 = null;
              i = 0;
              j = i;
              if (localObject1 == null)
              {
                Log.i("MicroMsg.MusicMv", "not find ref object media " + k + ' ' + localboq.refObjectId + ' ' + localboq.ZWZ);
                localObject1 = ah.aiuX;
                j = i;
              }
              label222:
              localObject1 = ah.aiuX;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        Log.i("MicroMsg.MusicMv", s.X("not find ref obj Id:", Long.valueOf(localboq.refObjectId)));
        localObject2 = localboq.ZWZ;
        if (localObject2 == null) {
          break label1541;
        }
        if (((CharSequence)localObject2).length() > 0)
        {
          i = 1;
          label277:
          if (i == 0) {
            break label1114;
          }
        }
        for (;;)
        {
          label281:
          if (localObject2 != null)
          {
            Object localObject4 = ((Iterable)this.LXr).iterator();
            localObject1 = null;
            for (;;)
            {
              if (((Iterator)localObject4).hasNext())
              {
                Object localObject5 = (FinderObject)((Iterator)localObject4).next();
                if (!s.p(localObject2, ((FinderObject)localObject5).objectNonceId)) {
                  break label1538;
                }
                localObject3 = ((FinderObject)localObject5).objectDesc;
                if (localObject3 == null) {
                  break label1538;
                }
                localObject3 = ((FinderObjectDesc)localObject3).media;
                if (localObject3 == null) {
                  break label1538;
                }
                Object localObject6 = (FinderMedia)p.oL((List)localObject3);
                if (localObject6 == null) {
                  break label1538;
                }
                String str = s.X("video_", ((FinderObject)localObject5).objectNonceId);
                localObject3 = ((FinderMedia)localObject6).url;
                localObject1 = localObject3;
                if (localObject3 == null) {
                  localObject1 = "";
                }
                localObject1 = new com.tencent.mm.plugin.thumbplayer.d.d(str, (String)localObject1, "", kotlin.h.a.eH(((FinderMedia)localObject6).width), kotlin.h.a.eH(((FinderMedia)localObject6).height));
                ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).vYw = (((FinderMedia)localObject6).videoDuration * 1000L);
                localObject3 = ah.aiuX;
                ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).hJv = true;
                ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBP = localObject5;
                localObject3 = ah.aiuX;
                localObject3 = ah.aiuX;
                label487:
                continue;
                localObject1 = this.LXm;
                break;
                localObject1 = ((FinderObjectDesc)localObject1).media;
                if (localObject1 == null)
                {
                  localObject1 = null;
                  i = 0;
                  break label160;
                }
                localObject5 = (FinderMedia)p.oL((List)localObject1);
                if (localObject5 == null)
                {
                  localObject1 = null;
                  i = 0;
                  break label160;
                }
                localObject4 = "video_" + ((FinderObject)localObject3).id + '_' + localLinkedList.size();
                localObject1 = com.tencent.mm.plugin.mv.ui.a.Maz;
                localObject6 = com.tencent.mm.plugin.mv.ui.a.aPC((String)localObject4);
                localObject2 = ((FinderMedia)localObject5).url;
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = "";
                }
                localObject4 = new com.tencent.mm.plugin.thumbplayer.d.d((String)localObject4, (String)localObject6, (String)localObject1, kotlin.h.a.eH(((FinderMedia)localObject5).width), kotlin.h.a.eH(((FinderMedia)localObject5).height));
                ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).TBJ = 2;
                ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).hVy = "xV2";
                localObject2 = ((FinderMedia)localObject5).url_token;
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = "";
                }
                ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).msf = ((String)localObject1);
                ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).decodeKey = ((FinderMedia)localObject5).decodeKey;
                localObject2 = ((FinderMedia)localObject5).thumbUrl;
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = "";
                }
                ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).thumbUrl = ((String)localObject1);
                localObject2 = ((FinderMedia)localObject5).thumb_url_token;
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = "";
                }
                ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).msh = ((String)localObject1);
                ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).TBN = localboq.ZWY;
                ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).TBM = localboq.TBM;
                ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).TBO = localboq.TBO;
                localObject1 = ((FinderObject)localObject3).objectDesc;
                long l;
                if (localObject1 == null) {
                  l = 0L;
                }
                for (;;)
                {
                  ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).vYw = (l * 1000L);
                  ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).nDl = 2;
                  ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).hJv = false;
                  ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).TBP = localObject3;
                  ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).TEV = localboq.ZXd;
                  ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).TEY.addAll((Collection)localboq.ZXf);
                  ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).TEZ = localboq.ZXg;
                  localObject1 = a.LWK;
                  localObject1 = (a)((Map)a.gpt()).get(localboq.ZXe);
                  if (localObject1 != null)
                  {
                    ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).TEW = ((a)localObject1).id;
                    ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).TEX = ((a)localObject1).LWN;
                    localObject1 = ah.aiuX;
                    localObject1 = ah.aiuX;
                  }
                  localLinkedList.add(localObject4);
                  Log.i("MicroMsg.MusicMv", "add mediaTrack network id:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).mediaId + " path:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).path + " width:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).width + " height:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).height + " timeOffsetInClipMs:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).TBO + " timeOffsetInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).TBM + " timeLengthInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).TBN);
                  localObject1 = ah.aiuX;
                  localObject1 = ah.aiuX;
                  i = 1;
                  break;
                  localObject1 = ((FinderObjectDesc)localObject1).media;
                  if (localObject1 == null)
                  {
                    l = 0L;
                  }
                  else
                  {
                    localObject1 = (FinderMedia)p.oK((List)localObject1);
                    if (localObject1 == null) {
                      l = 0L;
                    } else {
                      l = ((FinderMedia)localObject1).videoDuration;
                    }
                  }
                }
                i = 0;
                break label277;
                label1114:
                localObject2 = null;
                break label281;
              }
            }
            localObject2 = ah.aiuX;
            localObject2 = ah.aiuX;
          }
        }
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          localObject1 = b.LWQ;
          localObject2 = b.a.gpv();
          localObject1 = new com.tencent.mm.plugin.thumbplayer.d.d(s.X("video_", ((b)localObject2).name), ((b)localObject2).getFilePath(), "", ((b)localObject2).width, ((b)localObject2).height);
          ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).vYw = ((b)localObject2).durationMs;
          ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).loop = true;
          ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBL = true;
          localObject2 = ah.aiuX;
          ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).hJv = true;
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TEV = localboq.ZXd;
          ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TEZ = localboq.ZXg;
          ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TEY.addAll((Collection)localboq.ZXf);
          localObject2 = a.LWK;
          localObject2 = (a)((Map)a.gpt()).get(localboq.ZXe);
          if (localObject2 != null)
          {
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TEW = ((a)localObject2).id;
            ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TEX = ((a)localObject2).LWN;
            localObject2 = ah.aiuX;
            localObject2 = ah.aiuX;
          }
          ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBN = localboq.ZWY;
          ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBM = localboq.TBM;
          ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBO = localboq.TBO;
          ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).hJv = true;
          ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).nDl = 2;
          ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).mediaId = (((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).mediaId + '_' + localLinkedList.size());
          localLinkedList.add(localObject1);
          Log.i("MicroMsg.MusicMv", "add mediaTrack local id:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).mediaId + " path:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).path + " width:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).width + " height:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).height + " timeOffsetInClipMs:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBO + " timeOffsetInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBM + " timeLengthInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.d.d)localObject1).TBN);
          localObject1 = ah.aiuX;
          localObject1 = ah.aiuX;
          k += 1;
          break;
          label1527:
          AppMethodBeat.o(286122);
          return localLinkedList;
        }
        label1538:
        break label487;
        label1541:
        localObject1 = null;
      }
      j = 0;
      break label222;
      label1552:
      j = 0;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/MusicMv$Companion;", "", "()V", "TAG", "", "copyToNew", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "mv", "newMv", "createFromMusicMvData", "data", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "deleteMv", "", "fillMvByFinderObject", "obj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "generateThumb", "trackData", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "getMvObj", "musicMv", "hasMv", "resetMv", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(f paramf)
    {
      AppMethodBeat.i(286076);
      s.u(paramf, "mv");
      paramf.AcH = true;
      paramf.LXp = null;
      paramf.LXo = null;
      Iterator localIterator = ((Iterable)paramf.LXm).iterator();
      while (localIterator.hasNext())
      {
        boq localboq = (boq)localIterator.next();
        localboq.ZWZ = "";
        localboq.refObjectId = 0L;
        localboq.fillMode = 0;
        localboq.ZXa = 0;
      }
      paramf.likeCount = 0;
      paramf.forwardCount = 0;
      paramf.commentCount = 0;
      paramf.LXq = false;
      paramf.LXt = null;
      paramf.LXv = null;
      paramf.LXw.clear();
      AppMethodBeat.o(286076);
    }
    
    public static void a(FinderObject paramFinderObject, f paramf)
    {
      int m = 1;
      int k = 0;
      AppMethodBeat.i(286057);
      s.u(paramFinderObject, "obj");
      s.u(paramf, "mv");
      paramf.LXj = Long.valueOf(paramFinderObject.id);
      paramf.LXk = paramFinderObject.objectNonceId;
      Object localObject1 = paramFinderObject.contact;
      int i;
      label97:
      Object localObject2;
      boolean bool;
      if (localObject1 == null)
      {
        localObject1 = "";
        paramf.aPx((String)localObject1);
        paramf.LXp = paramFinderObject.contact;
        localObject1 = (CharSequence)paramf.coverUrl;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label604;
        }
        i = 1;
        if (i != 0)
        {
          localObject1 = paramFinderObject.objectDesc;
          if (localObject1 != null)
          {
            localObject1 = ((FinderObjectDesc)localObject1).media;
            if (localObject1 != null)
            {
              localObject1 = (FinderMedia)p.oL((List)localObject1);
              if (localObject1 != null) {
                paramf.coverUrl = s.X(((FinderMedia)localObject1).thumbUrl, ((FinderMedia)localObject1).thumb_url_token);
              }
            }
          }
        }
        localObject1 = paramFinderObject.objectDesc;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
          if (localObject1 != null)
          {
            paramf.LXo = ((bol)localObject1).LXo;
            localObject2 = ((bol)localObject1).ZWI;
            s.s(localObject2, "mvInfo.orderedTrackList");
            s.u(localObject2, "<set-?>");
            paramf.LXm = ((LinkedList)localObject2);
            localObject2 = ((bol)localObject1).ZWL;
            s.s(localObject2, "mvInfo.ordered_track_list_flex_clip");
            s.u(localObject2, "<set-?>");
            paramf.LXn = ((LinkedList)localObject2);
            paramf.LXA = ((bol)localObject1).ZWM;
          }
        }
        paramf.likeCount = paramFinderObject.likeCount;
        paramf.forwardCount = paramFinderObject.forwardCount;
        paramf.commentCount = paramFinderObject.commentCount;
        if (paramFinderObject.likeFlag == 0) {
          break label609;
        }
        bool = true;
        label288:
        paramf.LXq = bool;
        paramf.LXt = paramFinderObject;
        if (paramf.LXA != 1) {
          break label627;
        }
        paramFinderObject = ((Iterable)paramf.LXn).iterator();
        i = 0;
      }
      for (;;)
      {
        int j = m;
        if (paramFinderObject.hasNext())
        {
          localObject1 = paramFinderObject.next();
          if (i < 0) {
            p.kkW();
          }
          localObject1 = (boq)localObject1;
          localObject2 = com.tencent.mm.plugin.thumbplayer.d.d.TEU;
          localObject1 = ((boq)localObject1).ZXf;
          s.s(localObject1, "finderMVTrack.feature_list");
          localObject2 = (List)localObject1;
          s.u(localObject2, "featureList");
          localObject1 = ar.setOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
          localObject2 = ((Iterable)localObject2).iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
          } while (((Set)localObject1).contains(Integer.valueOf(((Number)((Iterator)localObject2).next()).intValue())));
        }
        for (j = 0;; j = 1)
        {
          if (j != 0) {
            break label620;
          }
          j = 0;
          if (j != 0) {
            break label627;
          }
          paramFinderObject = ((Iterable)paramf.LXn).iterator();
          i = k;
          while (paramFinderObject.hasNext())
          {
            localObject1 = paramFinderObject.next();
            if (i < 0) {
              p.kkW();
            }
            localObject1 = (boq)localObject1;
            localObject2 = new boq();
            ((boq)localObject2).ZWY = ((boq)localObject1).ZWY;
            ((boq)localObject2).TBM = ((boq)localObject1).TBM;
            ((boq)localObject2).TBO = 0L;
            paramf.LXn.set(i, localObject2);
            i += 1;
          }
          localObject2 = ((FinderContact)localObject1).nickname;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject1 = "";
          break;
          label604:
          i = 0;
          break label97;
          label609:
          bool = false;
          break label288;
        }
        label620:
        i += 1;
      }
      label627:
      AppMethodBeat.o(286057);
    }
    
    private static final void a(dtf paramdtf, String paramString, kotlin.g.a.b paramb, boolean paramBoolean, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(286125);
      s.u(paramdtf, "$trackData");
      s.u(paramString, "$coverPath");
      s.u(paramb, "$callback");
      if (paramBoolean) {
        paramdtf.aaYL = paramString;
      }
      paramb.invoke(Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(286125);
    }
    
    public static void a(dtf paramdtf, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      AppMethodBeat.i(286116);
      s.u(paramdtf, "trackData");
      s.u(paramb, "callback");
      Object localObject1 = paramdtf.aaYK;
      Object localObject3;
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject3 = paramdtf.ZJp;
        if ((localObject1 == null) || (((bol)localObject1).ZWM != 1)) {
          break label376;
        }
        i = 1;
        label56:
        if (i == 0) {
          break label427;
        }
        localObject1 = paramdtf.aaYK;
        if (localObject1 != null) {
          break label381;
        }
        localObject1 = null;
      }
      boolean bool;
      for (;;)
      {
        localObject1 = (List)localObject1;
        if (localObject1 != null) {
          break label497;
        }
        localObject2 = null;
        if (localObject2 == null) {
          break label829;
        }
        s.s(localObject3, "refList");
        localObject3 = ((Iterable)localObject3).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label634;
        }
        localObject1 = ((Iterator)localObject3).next();
        localObject4 = (FinderObject)localObject1;
        if (((boq)localObject2).refObjectId == 0L) {
          break label617;
        }
        if (((boq)localObject2).refObjectId != ((FinderObject)localObject4).id) {
          break label612;
        }
        bool = true;
        label166:
        if (!bool) {
          break label632;
        }
        label170:
        localObject1 = (FinderObject)localObject1;
        if (localObject1 != null) {
          break label640;
        }
        localObject1 = null;
        label185:
        if (localObject1 == null) {
          break label812;
        }
        localObject3 = bm.GlZ;
        localObject4 = bm.aCh("music_mv_cover_" + paramdtf.localId + '_' + MD5Util.getMD5String(String.valueOf(Util.currentTicks())));
        if (y.ZC(paramdtf.aaYL))
        {
          y.O(paramdtf.aaYL, (String)localObject4, false);
          paramdtf.aaYL = ((String)localObject4);
        }
        if (((boq)localObject2).refObjectId == 0L) {
          break label692;
        }
        localObject1 = s.X(((FinderMedia)localObject1).thumbUrl, ((FinderMedia)localObject1).thumb_url_token);
        localObject2 = new c.a();
        ((c.a)localObject2).fullPath = ((String)localObject4);
        ((c.a)localObject2).oKp = true;
        ((c.a)localObject2).oKn = false;
        r.bKe().a((String)localObject1, ((c.a)localObject2).bKx(), new f.a..ExternalSyntheticLambda0(paramdtf, (String)localObject4, paramb));
        AppMethodBeat.o(286116);
        return;
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
        break;
        label376:
        i = 0;
        break label56;
        label381:
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 == null)
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = ((bol)localObject1).ZWL;
          }
        }
      }
      label427:
      localObject1 = paramdtf.aaYK;
      if (localObject1 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        localObject1 = (List)localObject1;
        break;
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 == null)
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = ((bol)localObject1).ZWI;
          }
        }
      }
      label497:
      Object localObject4 = ((Iterable)localObject1).iterator();
      if (!((Iterator)localObject4).hasNext()) {
        localObject1 = null;
      }
      label522:
      do
      {
        localObject2 = (boq)localObject1;
        break;
        localObject1 = ((Iterator)localObject4).next();
      } while (!((Iterator)localObject4).hasNext());
      long l1 = ((boq)localObject1).TBM;
      label564:
      Object localObject2 = ((Iterator)localObject4).next();
      long l2 = ((boq)localObject2).TBM;
      if (l1 > l2)
      {
        l1 = l2;
        localObject1 = localObject2;
      }
      for (;;)
      {
        if (!((Iterator)localObject4).hasNext())
        {
          break label522;
          label612:
          bool = false;
          break label166;
          label617:
          bool = s.p(((boq)localObject2).ZWZ, ((FinderObject)localObject4).objectNonceId);
          break label166;
          label632:
          break;
          label634:
          localObject1 = null;
          break label170;
          label640:
          localObject1 = ((FinderObject)localObject1).objectDesc;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label185;
          }
          localObject1 = ((FinderObjectDesc)localObject1).media;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label185;
          }
          localObject1 = (FinderMedia)p.oL((List)localObject1);
          break label185;
          label692:
          localObject3 = y.n(((FinderMedia)localObject1).url, false);
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          if (((FinderMedia)localObject1).mediaType == 2) {}
          for (i = 1;; i = 2)
          {
            localObject1 = new com.tencent.mm.videocomposition.b((String)localObject2, i);
            localObject2 = com.tencent.mm.videocomposition.a.agDr;
            localObject1 = a.a.d((com.tencent.mm.videocomposition.b)localObject1);
            localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
            i = com.tencent.mm.plugin.finder.storage.d.eQn();
            localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
            ((com.tencent.mm.videocomposition.a)localObject1).setSize(i, com.tencent.mm.plugin.finder.storage.d.eQn());
            ((com.tencent.mm.videocomposition.a)localObject1).b(p.listOf(Long.valueOf(0L)), (m)new f.a.a((String)localObject4, paramdtf, paramb));
            AppMethodBeat.o(286116);
            return;
          }
          label812:
          paramb.invoke(Boolean.FALSE);
          AppMethodBeat.o(286116);
          return;
          label829:
          paramb.invoke(Boolean.FALSE);
          AppMethodBeat.o(286116);
          return;
        }
        break label564;
      }
    }
    
    public static f b(dtf paramdtf)
    {
      Object localObject3 = null;
      AppMethodBeat.i(286066);
      s.u(paramdtf, "data");
      f localf = new f();
      localf.LXg = Long.valueOf(paramdtf.localId);
      localf.LXi = paramdtf.aaYL;
      Object localObject1 = paramdtf.aaYK;
      label93:
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = "";
        localf.aPx((String)localObject1);
        localObject1 = paramdtf.ZJp;
        s.s(localObject1, "data.refObjectList");
        localf.bH((LinkedList)localObject1);
        localObject1 = paramdtf.aaYK;
        if (localObject1 != null) {
          break label237;
        }
        localObject1 = null;
        if (localObject1 != null)
        {
          localObject2 = ((bol)localObject1).ZWI;
          if (localObject2 != null) {
            localf.LXm.addAll((Collection)localObject2);
          }
        }
        if (localObject1 != null)
        {
          localObject2 = ((bol)localObject1).ZWL;
          if (localObject2 != null) {
            localf.LXn.addAll((Collection)localObject2);
          }
        }
        if (localObject1 != null) {
          break label259;
        }
        localObject2 = null;
        label151:
        localf.LXo = ((bon)localObject2);
        localObject2 = paramdtf.aaYK;
        if (localObject2 != null) {
          break label267;
        }
        localObject2 = localObject3;
        label169:
        localf.LXp = ((FinderContact)localObject2);
        localf.LXt = paramdtf.aaYK;
        if (localObject1 != null) {
          break label275;
        }
      }
      label259:
      label267:
      label275:
      for (int i = 0;; i = ((bol)localObject1).ZWM)
      {
        localf.LXA = i;
        AppMethodBeat.o(286066);
        return localf;
        localObject1 = ((FinderObject)localObject1).contact;
        if (localObject1 == null)
        {
          localObject1 = "";
          break;
        }
        localObject2 = ((FinderContact)localObject1).nickname;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject1 = "";
        break;
        label237:
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label93;
        }
        localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
        break label93;
        localObject2 = ((bol)localObject1).LXo;
        break label151;
        localObject2 = ((FinderObject)localObject2).contact;
        break label169;
      }
    }
    
    public static FinderObject b(f paramf)
    {
      int j = 1;
      AppMethodBeat.i(286088);
      s.u(paramf, "musicMv");
      FinderObject localFinderObject = paramf.LXt;
      int i;
      if (localFinderObject != null) {
        if (localFinderObject.id != 0L)
        {
          i = 1;
          if (i == 0) {
            break label65;
          }
        }
      }
      for (;;)
      {
        if (localFinderObject == null)
        {
          paramf = paramf.LXv;
          if (paramf == null)
          {
            AppMethodBeat.o(286088);
            return null;
            i = 0;
            break;
            label65:
            localFinderObject = null;
            continue;
          }
          if (paramf.id != 0L) {}
          for (i = j; i != 0; i = 0)
          {
            AppMethodBeat.o(286088);
            return paramf;
          }
          AppMethodBeat.o(286088);
          return null;
        }
      }
      AppMethodBeat.o(286088);
      return localFinderObject;
    }
    
    public static boolean c(f paramf)
    {
      AppMethodBeat.i(286095);
      s.u(paramf, "musicMv");
      if (b(paramf) == null) {}
      for (paramf = null; paramf == null; paramf = Boolean.TRUE)
      {
        AppMethodBeat.o(286095);
        return false;
      }
      boolean bool = paramf.booleanValue();
      AppMethodBeat.o(286095);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.f
 * JD-Core Version:    0.7.0.1
 */