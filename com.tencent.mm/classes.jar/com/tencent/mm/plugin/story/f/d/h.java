package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.protocal.protobuf.djm;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyTImeline", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;)V", "TAG", "", "comment", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getComment", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyId", "", "getStoryId", "()J", "getStoryItemScene", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "getStoryTImeline", "()Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "convertFromFakeDB", "", "videoEditData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "convertFromStoryInfo", "equals", "other", "toString", "Companion", "plugin-story_release"})
public final class h
{
  public static final a AMF;
  public final j AMA;
  public final g AMB;
  public final com.tencent.mm.plugin.story.i.j AMC;
  private final dkc AMD;
  public final i AME;
  private final String TAG;
  public final long dKt;
  public String userName;
  
  static
  {
    AppMethodBeat.i(118932);
    AMF = new a((byte)0);
    AppMethodBeat.o(118932);
  }
  
  public h(com.tencent.mm.plugin.story.i.j paramj, dkc paramdkc, i parami)
  {
    AppMethodBeat.i(118930);
    this.AMC = paramj;
    this.AMD = paramdkc;
    this.AME = parami;
    this.TAG = "MicroMsg.StoryGalleryItem";
    this.dKt = this.AMC.field_storyID;
    int i = (int)this.AMC.systemRowid;
    long l = this.AMC.field_storyID;
    int j = this.AMC.field_createTime;
    paramdkc = this.AMC.field_userName;
    paramj = paramdkc;
    if (paramdkc == null) {
      paramj = "";
    }
    paramj = new j(i, l, j, paramj);
    paramdkc = this.AMD;
    if (paramdkc.HyN.GaQ.size() > 0)
    {
      parami = paramdkc.HyN.GaQ.get(0);
      p.g(parami, "timeline.ContentObj.MediaObjList[0]");
      parami = (djl)parami;
      p.h(parami, "<set-?>");
      paramj.AMK = parami;
    }
    paramj.xue = paramdkc.HyM;
    this.AMA = paramj;
    this.AMB = new g();
    a(this.AMC);
    AppMethodBeat.o(118930);
  }
  
  private final boolean a(com.tencent.mm.plugin.story.i.j paramj)
  {
    int k = 0;
    AppMethodBeat.i(118926);
    Object localObject3 = new djs();
    try
    {
      ((djs)localObject3).parseFrom(paramj.field_attrBuf);
      Object localObject4 = this.AMB;
      Object localObject2 = paramj.field_userName;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
        localObject1 = j.b.dTJ();
      }
      p.h(localObject1, "<set-?>");
      ((g)localObject4).ALG = ((String)localObject1);
      this.AMB.dKt = paramj.field_storyID;
      this.AMB.Abl = 0;
      this.AMB.AMw = paramj.elw();
      localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
      localObject1 = j.b.ehW().AT(paramj.field_storyID);
      if ((localObject1 == null) || (((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime == 0)) {}
      boolean bool1;
      Object localObject5;
      j.b localb;
      for (int j = 1;; j = 0)
      {
        localObject2 = ((djs)localObject3).Hyz.iterator();
        bool1 = false;
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (dix)((Iterator)localObject2).next();
          p.g(localObject4, "commentDetail");
          localObject4 = new com.tencent.mm.plugin.story.f.b.a((dix)localObject4);
          if ((localObject1 == null) || (((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.f.b.a)localObject4).hZE <= ((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime)) {
            break label1217;
          }
          localObject5 = ((com.tencent.mm.plugin.story.f.b.a)localObject4).dyU;
          localb = com.tencent.mm.plugin.story.f.j.AKb;
          if (bt.lQ((String)localObject5, j.b.dTJ())) {
            break label1217;
          }
          ((com.tencent.mm.plugin.story.f.b.a)localObject4).ALC = true;
          bool1 = true;
          this.AMB.commentList.add(localObject4);
          this.AMB.AMx.add(localObject4);
          ((com.tencent.mm.plugin.story.f.b.a)localObject4).aBP(this.AMB.ALG);
          ((com.tencent.mm.plugin.story.f.b.a)localObject4).ALI = paramj.elC();
        }
      }
      localObject2 = ((djs)localObject3).HyB.iterator();
      int i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (dix)((Iterator)localObject2).next();
        p.g(localObject4, "bubleDetail");
        localObject4 = new com.tencent.mm.plugin.story.f.b.a((dix)localObject4);
        if ((localObject1 == null) || (((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.f.b.a)localObject4).hZE <= ((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime)) {
          break label1214;
        }
        localObject5 = ((com.tencent.mm.plugin.story.f.b.a)localObject4).dyU;
        localb = com.tencent.mm.plugin.story.f.j.AKb;
        if (bt.lQ((String)localObject5, j.b.dTJ())) {
          break label1214;
        }
        ((com.tencent.mm.plugin.story.f.b.a)localObject4).ALC = true;
        i = 1;
        this.AMB.commentList.add(localObject4);
        this.AMB.AMy.add(localObject4);
        ((com.tencent.mm.plugin.story.f.b.a)localObject4).aBP(this.AMB.ALG);
        ((com.tencent.mm.plugin.story.f.b.a)localObject4).ALI = paramj.elC();
      }
      localObject2 = ((djs)localObject3).HyF.iterator();
      boolean bool2 = false;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (dix)((Iterator)localObject2).next();
        p.g(localObject3, "visitorDetail");
        localObject3 = new com.tencent.mm.plugin.story.f.b.a((dix)localObject3);
        if ((localObject1 == null) || (((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.f.b.a)localObject3).hZE <= ((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime)) {
          break label1211;
        }
        localObject4 = ((com.tencent.mm.plugin.story.f.b.a)localObject3).dyU;
        localObject5 = com.tencent.mm.plugin.story.f.j.AKb;
        if (bt.lQ((String)localObject4, j.b.dTJ())) {
          break label1211;
        }
        ((com.tencent.mm.plugin.story.f.b.a)localObject3).ALC = true;
        bool2 = true;
        this.AMB.AMz.add(localObject3);
        ((com.tencent.mm.plugin.story.f.b.a)localObject3).aBP(this.AMB.ALG);
        ((com.tencent.mm.plugin.story.f.b.a)localObject3).ALI = paramj.elC();
      }
      localObject1 = (List)this.AMB.commentList;
      if (((List)localObject1).size() > 1) {
        d.a.j.a((List)localObject1, (Comparator)new b());
      }
      localObject1 = (List)this.AMB.AMx;
      if (((List)localObject1).size() > 1) {
        d.a.j.a((List)localObject1, (Comparator)new c());
      }
      localObject1 = (List)this.AMB.AMy;
      if (((List)localObject1).size() > 1) {
        d.a.j.a((List)localObject1, (Comparator)new d());
      }
      localObject1 = (List)this.AMB.AMz;
      if (((List)localObject1).size() > 1) {
        d.a.j.a((List)localObject1, (Comparator)new e());
      }
      if ((j != 0) && (this.AMB.commentList.size() > 0))
      {
        localObject1 = com.tencent.mm.plugin.story.f.b.b.ALT;
        long l = this.dKt;
        localObject1 = this.AMB.commentList.get(0);
        p.g(localObject1, "comment.commentList[0]");
        com.tencent.mm.plugin.story.f.b.b.a(l, (com.tencent.mm.plugin.story.f.b.a)localObject1);
      }
      localObject1 = this.AMB;
      boolean bool3;
      if ((i != 0) || (bool1))
      {
        bool3 = true;
        ((g)localObject1).ALC = bool3;
        this.AMB.AMu = bool2;
        this.AMB.AMv = bool1;
        if (paramj == null) {
          break label1195;
        }
        localObject1 = paramj.field_userName;
        label874:
        this.userName = ((String)localObject1);
        localObject1 = s.ALd;
        localObject3 = this.AMA.AMK;
        localObject2 = paramj.field_userName;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        if (!com.tencent.mm.vfs.i.fv(s.a((djl)localObject3, (String)localObject1)))
        {
          localObject1 = s.ALd;
          if (!com.tencent.mm.vfs.i.fv(s.a(this.AMA.AMK))) {
            break label1201;
          }
        }
      }
      label1195:
      label1201:
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject1 = (CharSequence)this.AMA.AMK.taskId;
          if (localObject1 != null)
          {
            i = k;
            if (((CharSequence)localObject1).length() != 0) {}
          }
          else
          {
            i = 1;
          }
          if (i == 0)
          {
            localObject1 = com.tencent.mm.plugin.story.f.e.a.AMT;
            localObject2 = com.tencent.mm.plugin.story.f.e.a.Sf((int)paramj.systemRowid);
            if (localObject2 != null)
            {
              localObject3 = this.TAG;
              localObject4 = new StringBuilder("find fake video ").append(this.AMA).append(" media ");
              paramj = com.tencent.mm.plugin.story.e.b.AJd;
              paramj = this.AMA.AMK;
              if (paramj != null)
              {
                localObject1 = "Media localId " + paramj.dJd + " url " + paramj.Url + " thumb " + paramj.GSI + " duration " + paramj.Hyq + " taskId " + paramj.taskId;
                paramj = (com.tencent.mm.plugin.story.i.j)localObject1;
                if (localObject1 != null) {}
              }
              else
              {
                paramj = "";
              }
              ad.i((String)localObject3, paramj);
              c((com.tencent.mm.plugin.recordvideo.background.c)localObject2);
            }
          }
        }
        ad.i(this.TAG, "LogStory: ".concat(String.valueOf(this)));
        AppMethodBeat.o(118926);
        return true;
        bool3 = false;
        break;
        localObject1 = null;
        break label874;
      }
    }
    catch (Exception localException)
    {
      label1211:
      label1214:
      label1217:
      for (;;)
      {
        continue;
        continue;
      }
    }
  }
  
  private final boolean c(com.tencent.mm.plugin.recordvideo.background.c paramc)
  {
    AppMethodBeat.i(118927);
    Object localObject1 = (com.tencent.mm.bx.a)new afy();
    Object localObject3 = paramc.field_baseItemData;
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (afy)localObject1;
      if (localObject1 != null)
      {
        localObject3 = this.AMA;
        Object localObject4 = k.AMN;
        p.h(localObject4, "<set-?>");
        ((j)localObject3).AMJ = ((k)localObject4);
        localObject3 = this.AMA;
        localObject4 = paramc.aOC();
        p.h(localObject4, "<set-?>");
        ((j)localObject3).taskId = ((String)localObject4);
        this.AMA.AMK.GSI = ((afy)localObject1).thumbPath;
        this.AMA.AMK.Id = ("fake_" + ((afy)localObject1).timeStamp);
        this.AMA.xue = ((afy)localObject1).xzV;
        if ((!com.tencent.mm.vfs.i.fv(((afy)localObject1).videoPath)) && (((afy)localObject1).GdP.size() == 0) && (((afy)localObject1).GdQ == null))
        {
          localObject1 = com.tencent.mm.plugin.story.f.e.a.AMT;
          com.tencent.mm.plugin.story.f.e.a.avA(paramc.aOC());
          AppMethodBeat.o(118927);
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;)
      {
        ad.l("safeParser", "", new Object[] { localException });
        localObject2 = null;
      }
      if (((afy)localObject2).GdP.size() > 0)
      {
        localObject2 = ((afy)localObject2).GdP.iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (!com.tencent.mm.vfs.i.fv((String)((Iterator)localObject2).next()))
          {
            localObject2 = com.tencent.mm.plugin.story.f.e.a.AMT;
            com.tencent.mm.plugin.story.f.e.a.avA(paramc.aOC());
            AppMethodBeat.o(118927);
            return false;
          }
        }
      }
      this.AMA.AML = paramc;
      AppMethodBeat.o(118927);
      return true;
    }
    AppMethodBeat.o(118927);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(118929);
    if (!(paramObject instanceof h))
    {
      AppMethodBeat.o(118929);
      return false;
    }
    if ((h)this == paramObject)
    {
      AppMethodBeat.o(118929);
      return true;
    }
    if ((this.dKt == ((h)paramObject).dKt) && (p.i(this.AMA, ((h)paramObject).AMA)) && (p.i(this.AMB, ((h)paramObject).AMB)) && (this.AMC.elz().hfV == ((h)paramObject).AMC.elz().hfV))
    {
      AppMethodBeat.o(118929);
      return true;
    }
    AppMethodBeat.o(118929);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118928);
    String str = "StoryGalleryItem(videoItem=" + this.AMA + ", comment=" + this.AMB + ')';
    AppMethodBeat.o(118928);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem$Companion;", "", "()V", "createStoryGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "extInfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "createStoryGalleryItemForSns", "plugin-story_release"})
  public static final class a
  {
    public static h a(f paramf)
    {
      AppMethodBeat.i(118921);
      p.h(paramf, "extInfo");
      com.tencent.mm.plugin.story.i.j localj = new com.tencent.mm.plugin.story.i.j();
      localj.field_storyID = paramf.field_syncId;
      localj.field_createTime = paramf.field_storyPostTime;
      localj.field_userName = paramf.getUserName();
      Object localObject1 = q.AKs;
      localObject1 = q.a.ein();
      ((dkc)localObject1).nDo = paramf.getUserName();
      ((dkc)localObject1).CreateTime = paramf.field_storyPostTime;
      Object localObject2 = q.AKs;
      localObject2 = new djl();
      ((djl)localObject2).Id = ("empty_" + cf.aCL());
      ((djl)localObject2).GSI = paramf.akW();
      ((djl)localObject2).Url = paramf.elo();
      if (paramf.field_duration > 0L) {}
      for (float f = (float)(paramf.field_duration / 1000.0D);; f = 0.0F)
      {
        ((djl)localObject2).Hyq = f;
        ((dkc)localObject1).HyN.GaQ.add(localObject2);
        localj.c((dkc)localObject1);
        paramf = new h(localj, (dkc)localObject1);
        AppMethodBeat.o(118921);
        return paramf;
      }
    }
    
    public static h a(com.tencent.mm.plugin.story.i.j paramj, i parami)
    {
      AppMethodBeat.i(118919);
      p.h(paramj, "story");
      p.h(parami, "storyItemScene");
      paramj = new h(paramj, paramj.elx(), parami);
      AppMethodBeat.o(118919);
      return paramj;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118922);
      int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).hZE), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).hZE));
      AppMethodBeat.o(118922);
      return i;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118923);
      int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).hZE), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).hZE));
      AppMethodBeat.o(118923);
      return i;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class d<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118924);
      int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).hZE), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).hZE));
      AppMethodBeat.o(118924);
      return i;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class e<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118925);
      int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).hZE), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).hZE));
      AppMethodBeat.o(118925);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.h
 * JD-Core Version:    0.7.0.1
 */