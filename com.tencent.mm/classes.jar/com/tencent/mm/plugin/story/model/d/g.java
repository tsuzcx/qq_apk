package com.tencent.mm.plugin.story.model.d;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.plugin.story.h.d;
import com.tencent.mm.plugin.story.model.b.a;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.s;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyTImeline", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;)V", "TAG", "", "comment", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getComment", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyId", "", "getStoryId", "()J", "getStoryItemScene", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "getStoryTImeline", "()Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "convertFromFakeDB", "", "timeStamp", "convertFromStoryInfo", "equals", "other", "toString", "Companion", "plugin-story_release"})
public final class g
{
  public static final g.a syw;
  private final String TAG;
  public final long cJA;
  public final i syr;
  public final f sys;
  public final com.tencent.mm.plugin.story.h.j syt;
  private final cic syu;
  public final h syv;
  public String userName;
  
  static
  {
    AppMethodBeat.i(109319);
    syw = new g.a((byte)0);
    AppMethodBeat.o(109319);
  }
  
  public g(com.tencent.mm.plugin.story.h.j paramj, cic paramcic, h paramh)
  {
    AppMethodBeat.i(138773);
    this.syt = paramj;
    this.syu = paramcic;
    this.syv = paramh;
    this.TAG = "MicroMsg.StoryGalleryItem";
    this.cJA = this.syt.field_storyID;
    int i = (int)this.syt.systemRowid;
    long l = this.syt.field_storyID;
    int j = this.syt.field_createTime;
    paramcic = this.syt.field_userName;
    paramj = paramcic;
    if (paramcic == null) {
      paramj = "";
    }
    paramj = new i(i, l, j, paramj);
    paramcic = this.syu;
    if (paramcic.xSK.wOa.size() > 0)
    {
      paramh = paramcic.xSK.wOa.get(0);
      a.f.b.j.p(paramh, "timeline.ContentObj.MediaObjList[0]");
      paramh = (chl)paramh;
      a.f.b.j.q(paramh, "<set-?>");
      paramj.syB = paramh;
    }
    paramj.syC = paramcic.xSJ;
    this.syr = paramj;
    this.sys = new f();
    a(this.syt);
    AppMethodBeat.o(138773);
  }
  
  private final boolean a(com.tencent.mm.plugin.story.h.j paramj)
  {
    int j = 0;
    AppMethodBeat.i(109315);
    Object localObject3 = new chs();
    try
    {
      ((chs)localObject3).parseFrom(paramj.field_attrBuf);
      Object localObject4 = this.sys;
      Object localObject2 = paramj.field_userName;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = com.tencent.mm.plugin.story.model.j.svi;
        localObject1 = j.b.coK();
      }
      a.f.b.j.q(localObject1, "<set-?>");
      ((f)localObject4).sxC = ((String)localObject1);
      this.sys.cJA = paramj.field_storyID;
      this.sys.rPd = 0;
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      localObject1 = j.b.cAE().mP(paramj.field_storyID);
      if ((localObject1 == null) || (((com.tencent.mm.plugin.story.h.c)localObject1).field_readCommentTime == 0)) {}
      boolean bool;
      Object localObject5;
      for (int i = 1;; i = 0)
      {
        localObject2 = ((chs)localObject3).xSy.iterator();
        bool = false;
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (cgw)((Iterator)localObject2).next();
          a.f.b.j.p(localObject4, "commentDetail");
          localObject4 = new a((cgw)localObject4);
          if ((localObject1 == null) || (((com.tencent.mm.plugin.story.h.c)localObject1).field_readCommentTime <= 0) || (((a)localObject4).fDT <= ((com.tencent.mm.plugin.story.h.c)localObject1).field_readCommentTime)) {
            break label837;
          }
          localObject5 = ((a)localObject4).czp;
          j.b localb = com.tencent.mm.plugin.story.model.j.svi;
          if (bo.isEqual((String)localObject5, j.b.coK())) {
            break label837;
          }
          ((a)localObject4).sxy = true;
          bool = true;
          this.sys.rPQ.add(localObject4);
          ((a)localObject4).adk(this.sys.sxC);
          ((a)localObject4).sxE = paramj.cFe();
        }
      }
      localObject2 = ((chs)localObject3).xSA.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (cgw)((Iterator)localObject2).next();
        a.f.b.j.p(localObject3, "bubleDetail");
        localObject3 = new a((cgw)localObject3);
        if ((localObject1 == null) || (((com.tencent.mm.plugin.story.h.c)localObject1).field_readCommentTime <= 0) || (((a)localObject3).fDT <= ((com.tencent.mm.plugin.story.h.c)localObject1).field_readCommentTime)) {
          break label834;
        }
        localObject4 = ((a)localObject3).czp;
        localObject5 = com.tencent.mm.plugin.story.model.j.svi;
        if (bo.isEqual((String)localObject4, j.b.coK())) {
          break label834;
        }
        ((a)localObject3).sxy = true;
        bool = true;
        this.sys.rPQ.add(localObject3);
        ((a)localObject3).adk(this.sys.sxC);
        ((a)localObject3).sxE = paramj.cFe();
      }
      localObject1 = (List)this.sys.rPQ;
      if (((List)localObject1).size() > 1) {
        a.a.j.a((List)localObject1, (Comparator)new g.b());
      }
      if ((i != 0) && (this.sys.rPQ.size() > 0))
      {
        localObject1 = com.tencent.mm.plugin.story.model.b.b.sxN;
        long l = this.cJA;
        localObject1 = this.sys.rPQ.get(0);
        a.f.b.j.p(localObject1, "comment.commentList[0]");
        com.tencent.mm.plugin.story.model.b.b.a(l, (a)localObject1);
      }
      this.sys.sxy = bool;
      if (paramj != null) {}
      for (localObject1 = paramj.field_userName;; localObject1 = null)
      {
        this.userName = ((String)localObject1);
        localObject1 = s.swk;
        localObject2 = this.syr.syB;
        localObject1 = paramj.field_userName;
        paramj = (com.tencent.mm.plugin.story.h.j)localObject1;
        if (localObject1 == null) {
          paramj = "";
        }
        if (!com.tencent.mm.vfs.e.cN(s.a((chl)localObject2, paramj)))
        {
          paramj = s.swk;
          i = j;
          if (!com.tencent.mm.vfs.e.cN(s.a(this.syr.syB))) {}
        }
        else
        {
          i = 1;
        }
        if ((i == 0) && (this.syr.syB.cIp >= 0))
        {
          paramj = com.tencent.mm.plugin.story.model.j.svi;
          localObject2 = j.b.cAG().mQ(this.syr.syB.cIp);
          if (localObject2 != null)
          {
            localObject3 = this.TAG;
            localObject4 = new StringBuilder("find fake video ").append(this.syr).append(" media ");
            paramj = com.tencent.mm.plugin.story.e.c.ssB;
            paramj = this.syr.syB;
            if (paramj != null)
            {
              localObject1 = "Media localId " + paramj.cIp + " url " + paramj.Url + " thumb " + paramj.xrS + " duration " + paramj.duration;
              paramj = (com.tencent.mm.plugin.story.h.j)localObject1;
              if (localObject1 != null) {}
            }
            else
            {
              paramj = "";
            }
            ab.i((String)localObject3, paramj);
            mA(((d)localObject2).field_timeStamp);
          }
        }
        ab.i(this.TAG, "LogStory: ".concat(String.valueOf(this)));
        AppMethodBeat.o(109315);
        return true;
      }
    }
    catch (Exception localException)
    {
      label834:
      label837:
      for (;;)
      {
        continue;
      }
    }
  }
  
  private boolean mA(long paramLong)
  {
    AppMethodBeat.i(151074);
    Object localObject1 = k.sCp;
    localObject1 = k.mE(paramLong);
    if (localObject1 != null)
    {
      Object localObject2 = this.syr;
      Object localObject3 = j.syF;
      a.f.b.j.q(localObject3, "<set-?>");
      ((i)localObject2).syA = ((j)localObject3);
      this.syr.timeStamp = ((chf)localObject1).timeStamp;
      this.syr.syB.xrS = ((chf)localObject1).thumbPath;
      this.syr.syB.Id = ("fake_" + ((chf)localObject1).timeStamp);
      this.syr.syC = ((chf)localObject1).sPS;
      if ((!com.tencent.mm.vfs.e.cN(((chf)localObject1).videoPath)) && (((chf)localObject1).xSi.size() == 0))
      {
        localObject2 = k.sCp;
        k.mF(((chf)localObject1).timeStamp);
        AppMethodBeat.o(151074);
        return false;
      }
      if (((chf)localObject1).xSi.size() > 0)
      {
        localObject2 = ((chf)localObject1).xSi.iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (!com.tencent.mm.vfs.e.cN((String)((Iterator)localObject2).next()))
          {
            localObject2 = k.sCp;
            k.mF(((chf)localObject1).timeStamp);
            AppMethodBeat.o(151074);
            return false;
          }
        }
      }
      localObject2 = this.syr;
      localObject3 = k.sCp;
      ((i)localObject2).syD = k.mE(((chf)localObject1).timeStamp);
      AppMethodBeat.o(151074);
      return true;
    }
    AppMethodBeat.o(151074);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(109317);
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(109317);
      return false;
    }
    if ((g)this == paramObject)
    {
      AppMethodBeat.o(109317);
      return true;
    }
    if ((this.cJA == ((g)paramObject).cJA) && (a.f.b.j.e(this.syr, ((g)paramObject).syr)) && (a.f.b.j.e(this.sys, ((g)paramObject).sys)) && (this.syt.cFb().ePG == ((g)paramObject).syt.cFb().ePG))
    {
      AppMethodBeat.o(109317);
      return true;
    }
    AppMethodBeat.o(109317);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(109316);
    String str = "StoryGalleryItem(videoItem=" + this.syr + ", comment=" + this.sys + ')';
    AppMethodBeat.o(109316);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.d.g
 * JD-Core Version:    0.7.0.1
 */