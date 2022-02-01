package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.dkn;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyTImeline", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;)V", "TAG", "", "comment", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getComment", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyId", "", "getStoryId", "()J", "getStoryItemScene", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "getStoryTImeline", "()Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "convertFromFakeDB", "", "videoEditData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "convertFromStoryInfo", "equals", "other", "toString", "Companion", "plugin-story_release"})
public final class h
{
  public static final a Beh;
  public final j Bec;
  public final g Bed;
  public final com.tencent.mm.plugin.story.i.j Bee;
  private final dkx Bef;
  public final i Beg;
  private final String TAG;
  public final long dLI;
  public String userName;
  
  static
  {
    AppMethodBeat.i(118932);
    Beh = new a((byte)0);
    AppMethodBeat.o(118932);
  }
  
  public h(com.tencent.mm.plugin.story.i.j paramj, dkx paramdkx, i parami)
  {
    AppMethodBeat.i(118930);
    this.Bee = paramj;
    this.Bef = paramdkx;
    this.Beg = parami;
    this.TAG = "MicroMsg.StoryGalleryItem";
    this.dLI = this.Bee.field_storyID;
    int i = (int)this.Bee.systemRowid;
    long l = this.Bee.field_storyID;
    int j = this.Bee.field_createTime;
    paramdkx = this.Bee.field_userName;
    paramj = paramdkx;
    if (paramdkx == null) {
      paramj = "";
    }
    paramj = new j(i, l, j, paramj);
    paramdkx = this.Bef;
    if (paramdkx.HSy.Gtx.size() > 0)
    {
      parami = paramdkx.HSy.Gtx.get(0);
      p.g(parami, "timeline.ContentObj.MediaObjList[0]");
      parami = (dkg)parami;
      p.h(parami, "<set-?>");
      paramj.Bem = parami;
    }
    paramj.xKb = paramdkx.HSx;
    this.Bec = paramj;
    this.Bed = new g();
    a(this.Bee);
    AppMethodBeat.o(118930);
  }
  
  private final boolean a(com.tencent.mm.plugin.story.i.j paramj)
  {
    int k = 0;
    AppMethodBeat.i(118926);
    Object localObject3 = new dkn();
    try
    {
      ((dkn)localObject3).parseFrom(paramj.field_attrBuf);
      Object localObject4 = this.Bed;
      Object localObject2 = paramj.field_userName;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
        localObject1 = j.b.dXj();
      }
      p.h(localObject1, "<set-?>");
      ((g)localObject4).Bdj = ((String)localObject1);
      this.Bed.dLI = paramj.field_storyID;
      this.Bed.Asy = 0;
      this.Bed.BdY = paramj.epf();
      localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
      localObject1 = j.b.elE().Br(paramj.field_storyID);
      if ((localObject1 == null) || (((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime == 0)) {}
      boolean bool1;
      Object localObject5;
      j.b localb;
      for (int j = 1;; j = 0)
      {
        localObject2 = ((dkn)localObject3).HSk.iterator();
        bool1 = false;
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (djs)((Iterator)localObject2).next();
          p.g(localObject4, "commentDetail");
          localObject4 = new com.tencent.mm.plugin.story.f.b.a((djs)localObject4);
          if ((localObject1 == null) || (((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.f.b.a)localObject4).icw <= ((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime)) {
            break label1217;
          }
          localObject5 = ((com.tencent.mm.plugin.story.f.b.a)localObject4).dzZ;
          localb = com.tencent.mm.plugin.story.f.j.BbE;
          if (bu.lX((String)localObject5, j.b.dXj())) {
            break label1217;
          }
          ((com.tencent.mm.plugin.story.f.b.a)localObject4).Bdf = true;
          bool1 = true;
          this.Bed.commentList.add(localObject4);
          this.Bed.BdZ.add(localObject4);
          ((com.tencent.mm.plugin.story.f.b.a)localObject4).aDi(this.Bed.Bdj);
          ((com.tencent.mm.plugin.story.f.b.a)localObject4).Bdl = paramj.epl();
        }
      }
      localObject2 = ((dkn)localObject3).HSm.iterator();
      int i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (djs)((Iterator)localObject2).next();
        p.g(localObject4, "bubleDetail");
        localObject4 = new com.tencent.mm.plugin.story.f.b.a((djs)localObject4);
        if ((localObject1 == null) || (((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.f.b.a)localObject4).icw <= ((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime)) {
          break label1214;
        }
        localObject5 = ((com.tencent.mm.plugin.story.f.b.a)localObject4).dzZ;
        localb = com.tencent.mm.plugin.story.f.j.BbE;
        if (bu.lX((String)localObject5, j.b.dXj())) {
          break label1214;
        }
        ((com.tencent.mm.plugin.story.f.b.a)localObject4).Bdf = true;
        i = 1;
        this.Bed.commentList.add(localObject4);
        this.Bed.Bea.add(localObject4);
        ((com.tencent.mm.plugin.story.f.b.a)localObject4).aDi(this.Bed.Bdj);
        ((com.tencent.mm.plugin.story.f.b.a)localObject4).Bdl = paramj.epl();
      }
      localObject2 = ((dkn)localObject3).HSq.iterator();
      boolean bool2 = false;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (djs)((Iterator)localObject2).next();
        p.g(localObject3, "visitorDetail");
        localObject3 = new com.tencent.mm.plugin.story.f.b.a((djs)localObject3);
        if ((localObject1 == null) || (((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.f.b.a)localObject3).icw <= ((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime)) {
          break label1211;
        }
        localObject4 = ((com.tencent.mm.plugin.story.f.b.a)localObject3).dzZ;
        localObject5 = com.tencent.mm.plugin.story.f.j.BbE;
        if (bu.lX((String)localObject4, j.b.dXj())) {
          break label1211;
        }
        ((com.tencent.mm.plugin.story.f.b.a)localObject3).Bdf = true;
        bool2 = true;
        this.Bed.Beb.add(localObject3);
        ((com.tencent.mm.plugin.story.f.b.a)localObject3).aDi(this.Bed.Bdj);
        ((com.tencent.mm.plugin.story.f.b.a)localObject3).Bdl = paramj.epl();
      }
      localObject1 = (List)this.Bed.commentList;
      if (((List)localObject1).size() > 1) {
        d.a.j.a((List)localObject1, (Comparator)new b());
      }
      localObject1 = (List)this.Bed.BdZ;
      if (((List)localObject1).size() > 1) {
        d.a.j.a((List)localObject1, (Comparator)new c());
      }
      localObject1 = (List)this.Bed.Bea;
      if (((List)localObject1).size() > 1) {
        d.a.j.a((List)localObject1, (Comparator)new d());
      }
      localObject1 = (List)this.Bed.Beb;
      if (((List)localObject1).size() > 1) {
        d.a.j.a((List)localObject1, (Comparator)new e());
      }
      if ((j != 0) && (this.Bed.commentList.size() > 0))
      {
        localObject1 = com.tencent.mm.plugin.story.f.b.b.Bdv;
        long l = this.dLI;
        localObject1 = this.Bed.commentList.get(0);
        p.g(localObject1, "comment.commentList[0]");
        com.tencent.mm.plugin.story.f.b.b.a(l, (com.tencent.mm.plugin.story.f.b.a)localObject1);
      }
      localObject1 = this.Bed;
      boolean bool3;
      if ((i != 0) || (bool1))
      {
        bool3 = true;
        ((g)localObject1).Bdf = bool3;
        this.Bed.BdW = bool2;
        this.Bed.BdX = bool1;
        if (paramj == null) {
          break label1195;
        }
        localObject1 = paramj.field_userName;
        label874:
        this.userName = ((String)localObject1);
        localObject1 = s.BcG;
        localObject3 = this.Bec.Bem;
        localObject2 = paramj.field_userName;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        if (!o.fB(s.a((dkg)localObject3, (String)localObject1)))
        {
          localObject1 = s.BcG;
          if (!o.fB(s.a(this.Bec.Bem))) {
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
          localObject1 = (CharSequence)this.Bec.Bem.taskId;
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
            localObject1 = com.tencent.mm.plugin.story.f.e.a.Beu;
            localObject2 = com.tencent.mm.plugin.story.f.e.a.SM((int)paramj.systemRowid);
            if (localObject2 != null)
            {
              localObject3 = this.TAG;
              localObject4 = new StringBuilder("find fake video ").append(this.Bec).append(" media ");
              paramj = com.tencent.mm.plugin.story.e.b.BaG;
              paramj = this.Bec.Bem;
              if (paramj != null)
              {
                localObject1 = "Media localId " + paramj.dKr + " url " + paramj.Url + " thumb " + paramj.Hmj + " duration " + paramj.HSb + " taskId " + paramj.taskId;
                paramj = (com.tencent.mm.plugin.story.i.j)localObject1;
                if (localObject1 != null) {}
              }
              else
              {
                paramj = "";
              }
              ae.i((String)localObject3, paramj);
              c((com.tencent.mm.plugin.recordvideo.background.c)localObject2);
            }
          }
        }
        ae.i(this.TAG, "LogStory: ".concat(String.valueOf(this)));
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
    Object localObject1 = (com.tencent.mm.bw.a)new agh();
    Object localObject3 = paramc.field_baseItemData;
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (agh)localObject1;
      if (localObject1 != null)
      {
        localObject3 = this.Bec;
        Object localObject4 = k.Bep;
        p.h(localObject4, "<set-?>");
        ((j)localObject3).Bel = ((k)localObject4);
        localObject3 = this.Bec;
        localObject4 = paramc.aOZ();
        p.h(localObject4, "<set-?>");
        ((j)localObject3).taskId = ((String)localObject4);
        this.Bec.Bem.Hmj = ((agh)localObject1).thumbPath;
        this.Bec.Bem.Id = ("fake_" + ((agh)localObject1).timeStamp);
        this.Bec.xKb = ((agh)localObject1).xPR;
        if ((!o.fB(((agh)localObject1).videoPath)) && (((agh)localObject1).Gww.size() == 0) && (((agh)localObject1).Gwx == null))
        {
          localObject1 = com.tencent.mm.plugin.story.f.e.a.Beu;
          com.tencent.mm.plugin.story.f.e.a.awP(paramc.aOZ());
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
        ae.l("safeParser", "", new Object[] { localException });
        localObject2 = null;
      }
      if (((agh)localObject2).Gww.size() > 0)
      {
        localObject2 = ((agh)localObject2).Gww.iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (!o.fB((String)((Iterator)localObject2).next()))
          {
            localObject2 = com.tencent.mm.plugin.story.f.e.a.Beu;
            com.tencent.mm.plugin.story.f.e.a.awP(paramc.aOZ());
            AppMethodBeat.o(118927);
            return false;
          }
        }
      }
      this.Bec.Ben = paramc;
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
    if ((this.dLI == ((h)paramObject).dLI) && (p.i(this.Bec, ((h)paramObject).Bec)) && (p.i(this.Bed, ((h)paramObject).Bed)) && (this.Bee.epi().hiJ == ((h)paramObject).Bee.epi().hiJ))
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
    String str = "StoryGalleryItem(videoItem=" + this.Bec + ", comment=" + this.Bed + ')';
    AppMethodBeat.o(118928);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem$Companion;", "", "()V", "createStoryGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "extInfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "createStoryGalleryItemForSns", "plugin-story_release"})
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
      Object localObject1 = q.BbV;
      localObject1 = q.a.elV();
      ((dkx)localObject1).nIJ = paramf.getUserName();
      ((dkx)localObject1).CreateTime = paramf.field_storyPostTime;
      Object localObject2 = q.BbV;
      localObject2 = new dkg();
      ((dkg)localObject2).Id = ("empty_" + ch.aDb());
      ((dkg)localObject2).Hmj = paramf.all();
      ((dkg)localObject2).Url = paramf.eoX();
      if (paramf.field_duration > 0L) {}
      for (float f = (float)(paramf.field_duration / 1000.0D);; f = 0.0F)
      {
        ((dkg)localObject2).HSb = f;
        ((dkx)localObject1).HSy.Gtx.add(localObject2);
        localj.c((dkx)localObject1);
        paramf = new h(localj, (dkx)localObject1);
        AppMethodBeat.o(118921);
        return paramf;
      }
    }
    
    public static h a(com.tencent.mm.plugin.story.i.j paramj, i parami)
    {
      AppMethodBeat.i(118919);
      p.h(paramj, "story");
      p.h(parami, "storyItemScene");
      paramj = new h(paramj, paramj.epg(), parami);
      AppMethodBeat.o(118919);
      return paramj;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118922);
      int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).icw), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).icw));
      AppMethodBeat.o(118922);
      return i;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118923);
      int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).icw), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).icw));
      AppMethodBeat.o(118923);
      return i;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class d<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118924);
      int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).icw), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).icw));
      AppMethodBeat.o(118924);
      return i;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class e<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118925);
      int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).icw), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).icw));
      AppMethodBeat.o(118925);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.h
 * JD-Core Version:    0.7.0.1
 */