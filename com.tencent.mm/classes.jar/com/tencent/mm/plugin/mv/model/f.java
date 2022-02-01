package com.tencent.mm.plugin.mv.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.thumbplayer.e.e;
import com.tencent.mm.plugin.thumbplayer.e.e.a;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.videocomposition.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/MusicMv;", "", "()V", "commentCount", "", "getCommentCount", "()I", "setCommentCount", "(I)V", "coverUrl", "", "getCoverUrl", "()Ljava/lang/String;", "setCoverUrl", "(Ljava/lang/String;)V", "flexClipDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "getFlexClipDataList", "()Ljava/util/LinkedList;", "setFlexClipDataList", "(Ljava/util/LinkedList;)V", "forwardCount", "getForwardCount", "setForwardCount", "isDelete", "", "()Z", "setDelete", "(Z)V", "isLike", "setLike", "likeCount", "getLikeCount", "setLikeCount", "localCoverPath", "getLocalCoverPath", "setLocalCoverPath", "localId", "", "getLocalId", "()Ljava/lang/Long;", "setLocalId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "mvMakerInfo", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getMvMakerInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setMvMakerInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "mvMakerNickName", "getMvMakerNickName", "setMvMakerNickName", "mvObjectId", "getMvObjectId", "setMvObjectId", "mvObjectNonceId", "getMvObjectNonceId", "setMvObjectNonceId", "mvPostStatus", "getMvPostStatus", "setMvPostStatus", "mvType", "getMvType", "setMvType", "normalMvObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getNormalMvObj", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setNormalMvObj", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "originalInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVOriginalInfo;", "getOriginalInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVOriginalInfo;", "setOriginalInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVOriginalInfo;)V", "pauseTimes", "getPauseTimes", "()J", "setPauseTimes", "(J)V", "playMvTime", "getPlayMvTime", "setPlayMvTime", "postSuccessMvObj", "getPostSuccessMvObj", "setPostSuccessMvObj", "postSuccessRefObjList", "getPostSuccessRefObjList", "setPostSuccessRefObjList", "refVideoList", "getRefVideoList", "setRefVideoList", "showQQMusic", "getShowQQMusic", "setShowQQMusic", "snapshotCover", "Landroid/graphics/Bitmap;", "getSnapshotCover", "()Landroid/graphics/Bitmap;", "setSnapshotCover", "(Landroid/graphics/Bitmap;)V", "startMvTimeStamp", "getStartMvTimeStamp", "setStartMvTimeStamp", "trackDataList", "getTrackDataList", "setTrackDataList", "toTpMediaInfoList", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaSEInfo;", "Companion", "plugin-mv_release"})
public final class f
{
  public static final a GbD;
  public long GbA;
  public long GbB;
  int GbC;
  public Long Gbi;
  public Bitmap Gbj;
  public String Gbk;
  public Long Gbl;
  public String Gbm;
  public String Gbn;
  public LinkedList<bdt> Gbo;
  LinkedList<bdt> Gbp;
  public bdr Gbq;
  public FinderContact Gbr;
  public boolean Gbs;
  public LinkedList<FinderObject> Gbt;
  public int Gbu;
  public FinderObject Gbv;
  public boolean Gbw;
  public FinderObject Gbx;
  public LinkedList<FinderObject> Gby;
  public long Gbz;
  public int commentCount;
  public String coverUrl;
  public int forwardCount;
  public int likeCount;
  public boolean wGy;
  
  static
  {
    AppMethodBeat.i(229685);
    GbD = new a((byte)0);
    AppMethodBeat.o(229685);
  }
  
  public f()
  {
    AppMethodBeat.i(229683);
    this.Gbn = "";
    this.Gbo = new LinkedList();
    this.Gbp = new LinkedList();
    this.Gbt = new LinkedList();
    this.Gbu = 1;
    this.Gby = new LinkedList();
    AppMethodBeat.o(229683);
  }
  
  public final void aSD(String paramString)
  {
    AppMethodBeat.i(229669);
    p.k(paramString, "<set-?>");
    this.Gbn = paramString;
    AppMethodBeat.o(229669);
  }
  
  public final void by(LinkedList<FinderObject> paramLinkedList)
  {
    AppMethodBeat.i(229671);
    p.k(paramLinkedList, "<set-?>");
    this.Gbt = paramLinkedList;
    AppMethodBeat.o(229671);
  }
  
  public final LinkedList<e> ffZ()
  {
    AppMethodBeat.i(229680);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1;
    int i;
    int j;
    bdt localbdt;
    Object localObject3;
    Object localObject2;
    Object localObject5;
    Object localObject4;
    Object localObject6;
    long l;
    if (this.GbC == 1)
    {
      localObject1 = this.Gbp;
      localObject1 = (Iterable)localObject1;
      i = 0;
      Iterator localIterator = ((Iterable)localObject1).iterator();
      if (!localIterator.hasNext()) {
        break label1553;
      }
      localObject1 = localIterator.next();
      j = i + 1;
      if (i < 0) {
        j.iBO();
      }
      localbdt = (bdt)localObject1;
      if (localbdt.refObjectId == 0L) {
        break label1569;
      }
      localObject1 = ((Iterable)((f)this).Gbt).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (FinderObject)((Iterator)localObject1).next();
          localObject2 = e.MSN;
          if (((FinderObject)localObject3).id == localbdt.refObjectId)
          {
            localObject1 = ((FinderObject)localObject3).objectDesc;
            if (localObject1 != null)
            {
              localObject1 = ((FinderObjectDesc)localObject1).media;
              if (localObject1 != null)
              {
                localObject5 = (FinderMedia)j.lp((List)localObject1);
                if (localObject5 != null)
                {
                  localObject4 = "video_" + ((FinderObject)localObject3).id + '_' + localLinkedList.size();
                  localObject1 = com.tencent.mm.plugin.mv.ui.a.Gfi;
                  localObject6 = com.tencent.mm.plugin.mv.ui.a.aSI((String)localObject4);
                  localObject2 = ((FinderMedia)localObject5).url;
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = "";
                  }
                  localObject4 = new e((String)localObject4, (String)localObject6, (String)localObject1, kotlin.h.a.dm(((FinderMedia)localObject5).width), kotlin.h.a.dm(((FinderMedia)localObject5).height));
                  ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).MSA = Integer.valueOf(2);
                  ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).fPD = "xV2";
                  localObject2 = ((FinderMedia)localObject5).url_token;
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = "";
                  }
                  ((e)localObject4).beR((String)localObject1);
                  ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).decodeKey = ((FinderMedia)localObject5).decodeKey;
                  localObject2 = ((FinderMedia)localObject5).thumbUrl;
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = "";
                  }
                  ((e)localObject4).Oc((String)localObject1);
                  localObject2 = ((FinderMedia)localObject5).thumb_url_token;
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = "";
                  }
                  ((e)localObject4).beS((String)localObject1);
                  ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).MSF = localbdt.SOR;
                  ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).MSE = localbdt.MSE;
                  ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).MSG = localbdt.MSG;
                  localObject1 = ((FinderObject)localObject3).objectDesc;
                  if (localObject1 != null)
                  {
                    localObject1 = ((FinderObjectDesc)localObject1).media;
                    if (localObject1 != null)
                    {
                      localObject1 = (FinderMedia)j.lo((List)localObject1);
                      if (localObject1 != null)
                      {
                        l = ((FinderMedia)localObject1).videoDuration;
                        label480:
                        ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).sTg = (l * 1000L);
                        localObject1 = MMThumbPlayerTextureView.MUw;
                        ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).kYn = MMThumbPlayerTextureView.gpa();
                        ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).fEF = false;
                        ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).MSH = localObject3;
                        ((e)localObject4).MSI = localbdt.SOW;
                        ((e)localObject4).MSL.addAll((Collection)localbdt.SOY);
                        ((e)localObject4).MSM = localbdt.SOZ;
                        localObject1 = a.GaP;
                        localObject1 = (a)((Map)a.ffQ()).get(localbdt.SOX);
                        if (localObject1 != null)
                        {
                          ((e)localObject4).MSJ = ((a)localObject1).id;
                          ((e)localObject4).MSK = ((a)localObject1).GaM;
                          localObject1 = x.aazN;
                        }
                        localLinkedList.add(localObject4);
                        Log.i("MicroMsg.MusicMv", "add mediaTrack network id:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).mediaId + " path:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).path + " width:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).width + " height:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).height + " timeOffsetInClipMs:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).MSG + " timeOffsetInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).MSE + " timeLengthInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).MSF);
                        localObject1 = x.aazN;
                        i = 1;
                        label735:
                        localObject1 = x.aazN;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        Log.i("MicroMsg.MusicMv", "not find ref obj Id:" + localbdt.refObjectId);
        localObject2 = localbdt.SOS;
        if (localObject2 != null)
        {
          p.j(localObject2, "it");
          if (((CharSequence)localObject2).length() > 0)
          {
            i = 1;
            label806:
            if (i == 0) {
              break label1102;
            }
          }
          for (;;)
          {
            label810:
            if (localObject2 != null)
            {
              localObject4 = ((Iterable)this.Gbt).iterator();
              localObject1 = null;
              for (;;)
              {
                if (((Iterator)localObject4).hasNext())
                {
                  localObject5 = (FinderObject)((Iterator)localObject4).next();
                  if (p.h(localObject2, ((FinderObject)localObject5).objectNonceId))
                  {
                    localObject3 = ((FinderObject)localObject5).objectDesc;
                    if (localObject3 != null)
                    {
                      localObject3 = ((FinderObjectDesc)localObject3).media;
                      if (localObject3 != null)
                      {
                        localObject6 = (FinderMedia)j.lp((List)localObject3);
                        if (localObject6 != null)
                        {
                          String str = "video_" + ((FinderObject)localObject5).objectNonceId;
                          localObject3 = ((FinderMedia)localObject6).url;
                          localObject1 = localObject3;
                          if (localObject3 == null) {
                            localObject1 = "";
                          }
                          localObject1 = new e(str, (String)localObject1, "", kotlin.h.a.dm(((FinderMedia)localObject6).width), kotlin.h.a.dm(((FinderMedia)localObject6).height));
                          ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).sTg = (((FinderMedia)localObject6).videoDuration * 1000L);
                          localObject3 = x.aazN;
                          ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).fEF = true;
                          ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSH = localObject5;
                          localObject3 = x.aazN;
                          continue;
                          localObject1 = this.Gbo;
                          break;
                          l = 0L;
                          break label480;
                          Log.i("MicroMsg.MusicMv", "not find ref object media " + i + ' ' + localbdt.refObjectId + ' ' + localbdt.SOS);
                          localObject1 = x.aazN;
                          i = 0;
                          break label735;
                          i = 0;
                          break label806;
                          label1102:
                          localObject2 = null;
                          break label810;
                        }
                      }
                    }
                  }
                }
              }
              localObject2 = x.aazN;
              label1113:
              if (localObject1 != null) {
                break label1561;
              }
              localObject1 = b.GaR;
              localObject2 = b.a.ffS();
              localObject1 = new e("video_" + ((b)localObject2).name, ((b)localObject2).getFilePath(), "", ((b)localObject2).width, ((b)localObject2).height);
              ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).sTg = ((b)localObject2).durationMs;
              ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).loop = true;
              ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSD = true;
              localObject2 = x.aazN;
              ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).fEF = true;
            }
          }
        }
      }
      label1553:
      label1561:
      for (;;)
      {
        if (localObject1 != null)
        {
          ((e)localObject1).MSI = localbdt.SOW;
          ((e)localObject1).MSM = localbdt.SOZ;
          ((e)localObject1).MSL.addAll((Collection)localbdt.SOY);
          localObject2 = a.GaP;
          localObject2 = (a)((Map)a.ffQ()).get(localbdt.SOX);
          if (localObject2 != null)
          {
            if (localObject1 != null) {
              ((e)localObject1).MSJ = ((a)localObject2).id;
            }
            if (localObject1 != null) {
              ((e)localObject1).MSK = ((a)localObject2).GaM;
            }
            localObject2 = x.aazN;
          }
          ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSF = localbdt.SOR;
          ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSE = localbdt.MSE;
          ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSG = localbdt.MSG;
          ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).fEF = true;
          localObject2 = MMThumbPlayerTextureView.MUw;
          ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).kYn = MMThumbPlayerTextureView.gpa();
          localObject2 = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).mediaId + '_' + localLinkedList.size();
          p.k(localObject2, "<set-?>");
          ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).mediaId = ((String)localObject2);
          localLinkedList.add(localObject1);
          Log.i("MicroMsg.MusicMv", "add mediaTrack local id:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).mediaId + " path:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).path + " width:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).width + " height:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).height + " timeOffsetInClipMs:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSG + " timeOffsetInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSE + " timeLengthInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSF);
          localObject1 = x.aazN;
          i = j;
          break;
          localObject1 = null;
          break label1113;
        }
        i = j;
        break;
        AppMethodBeat.o(229680);
        return localLinkedList;
      }
      i = 0;
      break label735;
      label1569:
      i = 0;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/MusicMv$Companion;", "", "()V", "TAG", "", "copyToNew", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "mv", "newMv", "createFromMusicMvData", "data", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "deleteMv", "", "fillMvByFinderObject", "obj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "generateThumb", "trackData", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "getMvObj", "musicMv", "hasMv", "resetMv", "plugin-mv_release"})
  public static final class a
  {
    public static void a(f paramf)
    {
      AppMethodBeat.i(229294);
      p.k(paramf, "mv");
      paramf.wGy = true;
      paramf.Gbr = null;
      paramf.Gbq = null;
      Iterator localIterator = ((Iterable)paramf.Gbo).iterator();
      while (localIterator.hasNext())
      {
        bdt localbdt = (bdt)localIterator.next();
        localbdt.SOS = "";
        localbdt.refObjectId = 0L;
        localbdt.fillMode = 0;
        localbdt.SOT = 0;
      }
      paramf.likeCount = 0;
      paramf.forwardCount = 0;
      paramf.commentCount = 0;
      paramf.Gbs = false;
      paramf.Gbv = null;
      paramf.Gbx = null;
      paramf.Gby.clear();
      AppMethodBeat.o(229294);
    }
    
    public static void a(FinderObject paramFinderObject, f paramf)
    {
      int m = 1;
      int k = 0;
      AppMethodBeat.i(229276);
      p.k(paramFinderObject, "obj");
      p.k(paramf, "mv");
      paramf.Gbl = Long.valueOf(paramFinderObject.id);
      paramf.Gbm = paramFinderObject.objectNonceId;
      Object localObject1 = paramFinderObject.contact;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((FinderContact)localObject1).nickname;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      paramf.aSD((String)localObject1);
      paramf.Gbr = paramFinderObject.contact;
      localObject1 = (CharSequence)paramf.coverUrl;
      int i;
      boolean bool;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
      {
        i = 1;
        if (i != 0)
        {
          localObject1 = paramFinderObject.objectDesc;
          if (localObject1 != null)
          {
            localObject1 = ((FinderObjectDesc)localObject1).media;
            if (localObject1 != null)
            {
              localObject1 = (FinderMedia)j.lp((List)localObject1);
              if (localObject1 != null) {
                paramf.coverUrl = (((FinderMedia)localObject1).thumbUrl + ((FinderMedia)localObject1).thumb_url_token);
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
            paramf.Gbq = ((bdp)localObject1).Gbq;
            localObject2 = ((bdp)localObject1).SOB;
            p.j(localObject2, "mvInfo.orderedTrackList");
            p.k(localObject2, "<set-?>");
            paramf.Gbo = ((LinkedList)localObject2);
            localObject2 = ((bdp)localObject1).SOE;
            p.j(localObject2, "mvInfo.ordered_track_list_flex_clip");
            p.k(localObject2, "<set-?>");
            paramf.Gbp = ((LinkedList)localObject2);
            paramf.GbC = ((bdp)localObject1).SOF;
          }
        }
        paramf.likeCount = paramFinderObject.likeCount;
        paramf.forwardCount = paramFinderObject.forwardCount;
        paramf.commentCount = paramFinderObject.commentCount;
        if (paramFinderObject.likeFlag == 0) {
          break label527;
        }
        bool = true;
        label317:
        paramf.Gbs = bool;
        paramf.Gbv = paramFinderObject;
        if (paramf.GbC != 1) {
          break label540;
        }
        paramFinderObject = ((Iterable)paramf.Gbp).iterator();
        i = 0;
      }
      for (;;)
      {
        int j = m;
        if (paramFinderObject.hasNext())
        {
          localObject1 = paramFinderObject.next();
          if (i < 0) {
            j.iBO();
          }
          localObject1 = (bdt)localObject1;
          localObject2 = e.MSN;
          localObject1 = ((bdt)localObject1).SOY;
          p.j(localObject1, "finderMVTrack.feature_list");
          if (!e.a.ix((List)localObject1)) {
            j = 0;
          }
        }
        else
        {
          if (j != 0) {
            break label540;
          }
          paramFinderObject = ((Iterable)paramf.Gbp).iterator();
          i = k;
          while (paramFinderObject.hasNext())
          {
            localObject1 = paramFinderObject.next();
            if (i < 0) {
              j.iBO();
            }
            localObject1 = (bdt)localObject1;
            localObject2 = new bdt();
            ((bdt)localObject2).SOR = ((bdt)localObject1).SOR;
            ((bdt)localObject2).MSE = ((bdt)localObject1).MSE;
            ((bdt)localObject2).MSG = 0L;
            paramf.Gbp.set(i, localObject2);
            i += 1;
          }
          i = 0;
          break;
          label527:
          bool = false;
          break label317;
        }
        i += 1;
      }
      label540:
      AppMethodBeat.o(229276);
    }
    
    public static void a(final dbo paramdbo, final kotlin.g.a.b<? super Boolean, x> paramb)
    {
      AppMethodBeat.i(229331);
      p.k(paramdbo, "trackData");
      p.k(paramb, "callback");
      Object localObject1 = paramdbo.TIV;
      Object localObject3;
      label112:
      Object localObject4;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
          localObject3 = paramdbo.SGC;
          if ((localObject1 == null) || (((bdp)localObject1).SOF != 1)) {
            break label478;
          }
          localObject1 = paramdbo.TIV;
          if (localObject1 == null) {
            break label472;
          }
          localObject1 = ((FinderObject)localObject1).objectDesc;
          if (localObject1 == null) {
            break label472;
          }
          localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
          if (localObject1 == null) {
            break label472;
          }
          localObject1 = ((bdp)localObject1).SOE;
          localObject1 = (List)localObject1;
          if (localObject1 == null) {
            break label616;
          }
          localObject4 = ((Iterable)localObject1).iterator();
          if (((Iterator)localObject4).hasNext()) {
            break label536;
          }
          localObject1 = null;
        }
      }
      label156:
      label181:
      boolean bool;
      label233:
      label237:
      do
      {
        localObject1 = (bdt)localObject1;
        if (localObject1 == null) {
          break label801;
        }
        p.j(localObject3, "refList");
        localObject3 = ((Iterable)localObject3).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label644;
        }
        localObject2 = ((Iterator)localObject3).next();
        localObject4 = (FinderObject)localObject2;
        if (((bdt)localObject1).refObjectId == 0L) {
          break label627;
        }
        if (((bdt)localObject1).refObjectId != ((FinderObject)localObject4).id) {
          break label622;
        }
        bool = true;
        if (!bool) {
          break label642;
        }
        localObject2 = (FinderObject)localObject2;
        if (localObject2 == null) {
          break label650;
        }
        localObject2 = ((FinderObject)localObject2).objectDesc;
        if (localObject2 == null) {
          break label650;
        }
        localObject2 = ((FinderObjectDesc)localObject2).media;
        if (localObject2 == null) {
          break label650;
        }
        localObject2 = (FinderMedia)j.lp((List)localObject2);
        if (localObject2 == null) {
          break label784;
        }
        localObject3 = av.AJz;
        localObject4 = av.aGe("music_mv_cover_" + paramdbo.localId + '_' + MD5Util.getMD5String(String.valueOf(Util.currentTicks())));
        if (u.agG(paramdbo.TIW))
        {
          u.on(paramdbo.TIW, (String)localObject4);
          paramdbo.TIW = ((String)localObject4);
        }
        if (((bdt)localObject1).refObjectId == 0L) {
          break label656;
        }
        localObject1 = ((FinderMedia)localObject2).thumbUrl + ((FinderMedia)localObject2).thumb_url_token;
        localObject2 = new c.a();
        ((c.a)localObject2).Wq((String)localObject4);
        ((c.a)localObject2).bmF();
        ((c.a)localObject2).gs(false);
        com.tencent.mm.ay.q.bml().a((String)localObject1, ((c.a)localObject2).bmL(), (com.tencent.mm.ay.a.c.d)new a(paramdbo, (String)localObject4, paramb));
        AppMethodBeat.o(229331);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label112;
        localObject1 = paramdbo.TIV;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObject)localObject1).objectDesc;
          if (localObject1 != null)
          {
            localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
            if (localObject1 == null) {}
          }
        }
        for (localObject1 = ((bdp)localObject1).SOB;; localObject1 = null)
        {
          localObject1 = (List)localObject1;
          break;
        }
        localObject1 = ((Iterator)localObject4).next();
      } while (!((Iterator)localObject4).hasNext());
      label286:
      label472:
      label478:
      long l1 = ((bdt)localObject1).MSE;
      label536:
      label568:
      Object localObject2 = ((Iterator)localObject4).next();
      long l2 = ((bdt)localObject2).MSE;
      if (l1 > l2)
      {
        l1 = l2;
        localObject1 = localObject2;
      }
      for (;;)
      {
        if (!((Iterator)localObject4).hasNext())
        {
          break;
          label616:
          localObject1 = null;
          break label156;
          label622:
          bool = false;
          break label233;
          label627:
          bool = p.h(((bdt)localObject1).SOS, ((FinderObject)localObject4).objectNonceId);
          break label233;
          label642:
          break label181;
          label644:
          localObject2 = null;
          break label237;
          label650:
          localObject2 = null;
          break label286;
          label656:
          localObject3 = u.n(((FinderMedia)localObject2).url, false);
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          p.j(localObject1, "VFSFileOp.exportExternal…stMedia.url, false) ?: \"\"");
          if (((FinderMedia)localObject2).mediaType == 2) {}
          for (int i = 1;; i = 2)
          {
            localObject1 = new com.tencent.mm.videocomposition.b((String)localObject1, i);
            localObject2 = com.tencent.mm.videocomposition.a.YHM;
            localObject1 = a.a.d((com.tencent.mm.videocomposition.b)localObject1);
            localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
            i = com.tencent.mm.plugin.finder.storage.d.dSa();
            localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
            ((com.tencent.mm.videocomposition.a)localObject1).setSize(i, com.tencent.mm.plugin.finder.storage.d.dSa());
            ((com.tencent.mm.videocomposition.a)localObject1).b(j.listOf(Long.valueOf(0L)), (m)new b((String)localObject4, paramdbo, paramb));
            AppMethodBeat.o(229331);
            return;
          }
          label784:
          paramb.invoke(Boolean.FALSE);
          AppMethodBeat.o(229331);
          return;
          label801:
          paramb.invoke(Boolean.FALSE);
          AppMethodBeat.o(229331);
          return;
        }
        break label568;
      }
    }
    
    public static f b(dbo paramdbo)
    {
      Object localObject3 = null;
      AppMethodBeat.i(229288);
      p.k(paramdbo, "data");
      f localf = new f();
      localf.Gbi = Long.valueOf(paramdbo.localId);
      localf.Gbk = paramdbo.TIW;
      Object localObject1 = paramdbo.TIV;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).contact;
        if (localObject1 != null)
        {
          localObject2 = ((FinderContact)localObject1).nickname;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label78;
          }
        }
      }
      localObject1 = "";
      label78:
      localf.aSD((String)localObject1);
      localObject1 = paramdbo.SGC;
      p.j(localObject1, "data.refObjectList");
      localf.by((LinkedList)localObject1);
      localObject1 = paramdbo.TIV;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
          if (localObject1 != null)
          {
            localObject2 = ((bdp)localObject1).SOB;
            if (localObject2 != null) {
              localf.Gbo.addAll((Collection)localObject2);
            }
          }
          if (localObject1 != null)
          {
            localObject2 = ((bdp)localObject1).SOE;
            if (localObject2 != null) {
              localf.Gbp.addAll((Collection)localObject2);
            }
          }
          if (localObject1 == null) {
            break label256;
          }
          localObject2 = ((bdp)localObject1).Gbq;
          label186:
          localf.Gbq = ((bdr)localObject2);
          FinderObject localFinderObject = paramdbo.TIV;
          localObject2 = localObject3;
          if (localFinderObject != null) {
            localObject2 = localFinderObject.contact;
          }
          localf.Gbr = ((FinderContact)localObject2);
          localf.Gbv = paramdbo.TIV;
          if (localObject1 == null) {
            break label261;
          }
        }
      }
      label256:
      label261:
      for (int i = ((bdp)localObject1).SOF;; i = 0)
      {
        localf.GbC = i;
        AppMethodBeat.o(229288);
        return localf;
        localObject1 = null;
        break;
        localObject2 = null;
        break label186;
      }
    }
    
    public static FinderObject b(f paramf)
    {
      int j = 1;
      AppMethodBeat.i(229296);
      p.k(paramf, "musicMv");
      FinderObject localFinderObject1 = paramf.Gbv;
      if (localFinderObject1 != null)
      {
        if (localFinderObject1.id != 0L)
        {
          i = 1;
          if (i == 0) {
            break label83;
          }
          label39:
          localFinderObject2 = localFinderObject1;
          if (localFinderObject1 != null) {
            break label104;
          }
        }
      }
      else
      {
        paramf = paramf.Gbx;
        if (paramf == null) {
          break label101;
        }
        if (paramf.id == 0L) {
          break label88;
        }
      }
      label83:
      label88:
      for (int i = j;; i = 0)
      {
        if (i == 0) {
          break label93;
        }
        AppMethodBeat.o(229296);
        return paramf;
        i = 0;
        break;
        localFinderObject1 = null;
        break label39;
      }
      label93:
      AppMethodBeat.o(229296);
      return null;
      label101:
      FinderObject localFinderObject2 = null;
      label104:
      AppMethodBeat.o(229296);
      return localFinderObject2;
    }
    
    public static boolean c(f paramf)
    {
      AppMethodBeat.i(229297);
      p.k(paramf, "musicMv");
      if (b(paramf) != null)
      {
        AppMethodBeat.o(229297);
        return true;
      }
      AppMethodBeat.o(229297);
      return false;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "<anonymous parameter 1>", "", "", "kotlin.jvm.PlatformType", "onImageDownload", "(Z[Ljava/lang/Object;)V"})
    static final class a
      implements com.tencent.mm.ay.a.c.d
    {
      a(dbo paramdbo, String paramString, kotlin.g.a.b paramb) {}
      
      public final void a(boolean paramBoolean, Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(240755);
        if (paramBoolean) {
          this.GbE.TIW = this.GbF;
        }
        paramb.invoke(Boolean.valueOf(paramBoolean));
        AppMethodBeat.o(240755);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "time", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements m<Long, Bitmap, x>
    {
      b(String paramString, dbo paramdbo, kotlin.g.a.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.f
 * JD-Core Version:    0.7.0.1
 */