package com.tencent.mm.plugin.mv.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.csp;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/MusicMv;", "", "()V", "commentCount", "", "getCommentCount", "()I", "setCommentCount", "(I)V", "coverUrl", "", "getCoverUrl", "()Ljava/lang/String;", "setCoverUrl", "(Ljava/lang/String;)V", "forwardCount", "getForwardCount", "setForwardCount", "isDelete", "", "()Z", "setDelete", "(Z)V", "isFullScreen", "setFullScreen", "isLike", "setLike", "likeCount", "getLikeCount", "setLikeCount", "localCoverPath", "getLocalCoverPath", "setLocalCoverPath", "localId", "", "getLocalId", "()Ljava/lang/Long;", "setLocalId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "mvMakerInfo", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getMvMakerInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setMvMakerInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "mvMakerNickName", "getMvMakerNickName", "setMvMakerNickName", "mvObjectId", "getMvObjectId", "setMvObjectId", "mvObjectNonceId", "getMvObjectNonceId", "setMvObjectNonceId", "mvPostStatus", "getMvPostStatus", "setMvPostStatus", "normalMvObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getNormalMvObj", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setNormalMvObj", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "originalInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVOriginalInfo;", "getOriginalInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVOriginalInfo;", "setOriginalInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVOriginalInfo;)V", "playMvTime", "getPlayMvTime", "()J", "setPlayMvTime", "(J)V", "postSuccessMvObj", "getPostSuccessMvObj", "setPostSuccessMvObj", "postSuccessRefObjList", "Ljava/util/LinkedList;", "getPostSuccessRefObjList", "()Ljava/util/LinkedList;", "setPostSuccessRefObjList", "(Ljava/util/LinkedList;)V", "refVideoList", "getRefVideoList", "setRefVideoList", "showQQMusic", "getShowQQMusic", "setShowQQMusic", "snapshotCover", "Landroid/graphics/Bitmap;", "getSnapshotCover", "()Landroid/graphics/Bitmap;", "setSnapshotCover", "(Landroid/graphics/Bitmap;)V", "startMvTimeStamp", "getStartMvTimeStamp", "setStartMvTimeStamp", "trackDataList", "Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "getTrackDataList", "setTrackDataList", "Companion", "plugin-mv_release"})
public final class e
{
  public static final a ApR;
  public Long ApB;
  public Bitmap ApC;
  public String ApD;
  public Long ApE;
  public String ApF;
  public String ApG;
  public LinkedList<axz> ApH;
  public axx ApI;
  public FinderContact ApJ;
  public boolean ApK;
  public LinkedList<FinderObject> ApL;
  public int ApM;
  public FinderObject ApN;
  public boolean ApO;
  public FinderObject ApP;
  public LinkedList<FinderObject> ApQ;
  public long Uqs;
  public long Uqt;
  public int commentCount;
  public String coverUrl;
  public int forwardCount;
  public int likeCount;
  public boolean onr;
  public boolean tav;
  
  static
  {
    AppMethodBeat.i(256787);
    ApR = new a((byte)0);
    AppMethodBeat.o(256787);
  }
  
  public e()
  {
    AppMethodBeat.i(256786);
    this.ApG = "";
    this.ApH = new LinkedList();
    this.ApL = new LinkedList();
    this.ApM = 1;
    this.ApQ = new LinkedList();
    AppMethodBeat.o(256786);
  }
  
  public final void aIm(String paramString)
  {
    AppMethodBeat.i(256784);
    p.h(paramString, "<set-?>");
    this.ApG = paramString;
    AppMethodBeat.o(256784);
  }
  
  public final void bf(LinkedList<FinderObject> paramLinkedList)
  {
    AppMethodBeat.i(256785);
    p.h(paramLinkedList, "<set-?>");
    this.ApL = paramLinkedList;
    AppMethodBeat.o(256785);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/MusicMv$Companion;", "", "()V", "MODE_COMMENT_MAX", "", "MODE_COMMENT_MIN", "copyToNew", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "mv", "newMv", "createFromMusicMvData", "data", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "deleteMv", "", "fillMvByFinderObject", "obj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMvObj", "musicMv", "hasMv", "", "resetMv", "plugin-mv_release"})
  public static final class a
  {
    public static FinderObject a(e parame)
    {
      int j = 1;
      AppMethodBeat.i(256782);
      p.h(parame, "musicMv");
      FinderObject localFinderObject1 = parame.ApN;
      if (localFinderObject1 != null)
      {
        if (localFinderObject1.id != 0L)
        {
          i = 1;
          if (i == 0) {
            break label80;
          }
          label37:
          localFinderObject2 = localFinderObject1;
          if (localFinderObject1 != null) {
            break label100;
          }
        }
      }
      else
      {
        parame = parame.ApP;
        if (parame == null) {
          break label97;
        }
        if (parame.id == 0L) {
          break label85;
        }
      }
      label80:
      label85:
      for (int i = j;; i = 0)
      {
        if (i == 0) {
          break label90;
        }
        AppMethodBeat.o(256782);
        return parame;
        i = 0;
        break;
        localFinderObject1 = null;
        break label37;
      }
      label90:
      AppMethodBeat.o(256782);
      return null;
      label97:
      FinderObject localFinderObject2 = null;
      label100:
      AppMethodBeat.o(256782);
      return localFinderObject2;
    }
    
    public static void a(FinderObject paramFinderObject, e parame)
    {
      AppMethodBeat.i(256780);
      p.h(paramFinderObject, "obj");
      p.h(parame, "mv");
      parame.ApE = Long.valueOf(paramFinderObject.id);
      parame.ApF = paramFinderObject.objectNonceId;
      Object localObject = paramFinderObject.contact;
      if (localObject != null)
      {
        String str = ((FinderContact)localObject).nickname;
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      parame.aIm((String)localObject);
      parame.ApJ = paramFinderObject.contact;
      localObject = (CharSequence)parame.coverUrl;
      int i;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        i = 1;
        if (i != 0)
        {
          localObject = paramFinderObject.objectDesc;
          if (localObject != null)
          {
            localObject = ((FinderObjectDesc)localObject).media;
            if (localObject != null)
            {
              localObject = (FinderMedia)j.kt((List)localObject);
              if (localObject != null) {
                parame.coverUrl = (((FinderMedia)localObject).thumbUrl + ((FinderMedia)localObject).thumb_url_token);
              }
            }
          }
        }
        localObject = paramFinderObject.objectDesc;
        if (localObject != null)
        {
          localObject = ((FinderObjectDesc)localObject).mvInfo;
          if (localObject != null)
          {
            parame.ApI = ((axw)localObject).ApI;
            localObject = ((axw)localObject).LId;
            p.g(localObject, "mvInfo.orderedTrackList");
            p.h(localObject, "<set-?>");
            parame.ApH = ((LinkedList)localObject);
          }
        }
        parame.likeCount = paramFinderObject.likeCount;
        parame.forwardCount = paramFinderObject.forwardCount;
        parame.commentCount = paramFinderObject.commentCount;
        if (paramFinderObject.likeFlag == 0) {
          break label295;
        }
      }
      label295:
      for (boolean bool = true;; bool = false)
      {
        parame.ApK = bool;
        parame.ApN = paramFinderObject;
        AppMethodBeat.o(256780);
        return;
        i = 0;
        break;
      }
    }
    
    public static e b(csp paramcsp)
    {
      Object localObject2 = null;
      AppMethodBeat.i(256781);
      p.h(paramcsp, "data");
      e locale = new e();
      locale.ApB = Long.valueOf(paramcsp.localId);
      locale.ApD = paramcsp.MxF;
      Object localObject1 = paramcsp.MxE;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).contact;
        if (localObject1 != null)
        {
          localObject3 = ((FinderContact)localObject1).nickname;
          localObject1 = localObject3;
          if (localObject3 != null) {
            break label75;
          }
        }
      }
      localObject1 = "";
      label75:
      locale.aIm((String)localObject1);
      localObject1 = paramcsp.LDi;
      p.g(localObject1, "data.refObjectList");
      locale.bf((LinkedList)localObject1);
      localObject1 = paramcsp.MxE;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
          if (localObject1 != null)
          {
            localObject1 = ((axw)localObject1).LId;
            if (localObject1 != null) {
              locale.ApH.addAll((Collection)localObject1);
            }
          }
        }
      }
      localObject1 = paramcsp.MxE;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
          if (localObject1 == null) {}
        }
      }
      for (localObject1 = ((axw)localObject1).ApI;; localObject1 = null)
      {
        locale.ApI = ((axx)localObject1);
        localObject3 = paramcsp.MxE;
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((FinderObject)localObject3).contact;
        }
        locale.ApJ = ((FinderContact)localObject1);
        locale.ApN = paramcsp.MxE;
        AppMethodBeat.o(256781);
        return locale;
      }
    }
    
    public static boolean b(e parame)
    {
      AppMethodBeat.i(256783);
      p.h(parame, "musicMv");
      if (a(parame) != null)
      {
        AppMethodBeat.o(256783);
        return true;
      }
      AppMethodBeat.o(256783);
      return false;
    }
    
    public static void e(e parame)
    {
      AppMethodBeat.i(258835);
      p.h(parame, "mv");
      parame.tav = true;
      parame.ApJ = null;
      parame.ApI = null;
      Iterator localIterator = ((Iterable)parame.ApH).iterator();
      while (localIterator.hasNext())
      {
        axz localaxz = (axz)localIterator.next();
        localaxz.LIm = "";
        localaxz.refObjectId = 0L;
        localaxz.LIn = 0;
        localaxz.UtY = 0;
      }
      parame.likeCount = 0;
      parame.forwardCount = 0;
      parame.commentCount = 0;
      parame.ApK = false;
      parame.ApN = null;
      parame.ApP = null;
      parame.ApQ.clear();
      parame.onr = false;
      AppMethodBeat.o(258835);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.e
 * JD-Core Version:    0.7.0.1
 */