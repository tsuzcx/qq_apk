package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.c;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.ddk;
import com.tencent.mm.protocal.protobuf.ddp;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.protocal.protobuf.def;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.l;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyTImeline", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;)V", "TAG", "", "comment", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getComment", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyId", "", "getStoryId", "()J", "getStoryItemScene", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "getStoryTImeline", "()Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "convertFromFakeDB", "", "videoEditData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "convertFromStoryInfo", "equals", "other", "toString", "Companion", "plugin-story_release"})
public final class h
{
  public static final a zuK;
  private final String TAG;
  public final long dyg;
  public String userName;
  public final j zuF;
  public final g zuG;
  public final com.tencent.mm.plugin.story.i.j zuH;
  private final dep zuI;
  public final i zuJ;
  
  static
  {
    AppMethodBeat.i(118932);
    zuK = new a((byte)0);
    AppMethodBeat.o(118932);
  }
  
  public h(com.tencent.mm.plugin.story.i.j paramj, dep paramdep, i parami)
  {
    AppMethodBeat.i(118930);
    this.zuH = paramj;
    this.zuI = paramdep;
    this.zuJ = parami;
    this.TAG = "MicroMsg.StoryGalleryItem";
    this.dyg = this.zuH.field_storyID;
    int i = (int)this.zuH.systemRowid;
    long l = this.zuH.field_storyID;
    int j = this.zuH.field_createTime;
    paramdep = this.zuH.field_userName;
    paramj = paramdep;
    if (paramdep == null) {
      paramj = "";
    }
    paramj = new j(i, l, j, paramj);
    paramdep = this.zuI;
    if (paramdep.FOc.Etz.size() > 0)
    {
      parami = paramdep.FOc.Etz.get(0);
      d.g.b.k.g(parami, "timeline.ContentObj.MediaObjList[0]");
      parami = (ddy)parami;
      d.g.b.k.h(parami, "<set-?>");
      paramj.zuP = parami;
    }
    paramj.wmo = paramdep.FOb;
    this.zuF = paramj;
    this.zuG = new g();
    a(this.zuH);
    AppMethodBeat.o(118930);
  }
  
  private final boolean a(com.tencent.mm.plugin.story.i.j paramj)
  {
    int k = 0;
    AppMethodBeat.i(118926);
    Object localObject3 = new def();
    try
    {
      ((def)localObject3).parseFrom(paramj.field_attrBuf);
      Object localObject4 = this.zuG;
      Object localObject2 = paramj.field_userName;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
        localObject1 = j.b.dHx();
      }
      d.g.b.k.h(localObject1, "<set-?>");
      ((g)localObject4).ztM = ((String)localObject1);
      this.zuG.dyg = paramj.field_storyID;
      this.zuG.yJR = 0;
      this.zuG.zuB = paramj.dZh();
      localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
      localObject1 = j.b.dVH().yv(paramj.field_storyID);
      if ((localObject1 == null) || (((c)localObject1).field_readCommentTime == 0)) {}
      boolean bool1;
      Object localObject5;
      j.b localb;
      for (int j = 1;; j = 0)
      {
        localObject2 = ((def)localObject3).FNO.iterator();
        bool1 = false;
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (ddk)((Iterator)localObject2).next();
          d.g.b.k.g(localObject4, "commentDetail");
          localObject4 = new com.tencent.mm.plugin.story.f.b.a((ddk)localObject4);
          if ((localObject1 == null) || (((c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.f.b.a)localObject4).hGU <= ((c)localObject1).field_readCommentTime)) {
            break label1217;
          }
          localObject5 = ((com.tencent.mm.plugin.story.f.b.a)localObject4).dng;
          localb = com.tencent.mm.plugin.story.f.j.zsh;
          if (bs.lr((String)localObject5, j.b.dHx())) {
            break label1217;
          }
          ((com.tencent.mm.plugin.story.f.b.a)localObject4).ztI = true;
          bool1 = true;
          this.zuG.commentList.add(localObject4);
          this.zuG.zuC.add(localObject4);
          ((com.tencent.mm.plugin.story.f.b.a)localObject4).awL(this.zuG.ztM);
          ((com.tencent.mm.plugin.story.f.b.a)localObject4).ztO = paramj.dZn();
        }
      }
      localObject2 = ((def)localObject3).FNQ.iterator();
      int i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (ddk)((Iterator)localObject2).next();
        d.g.b.k.g(localObject4, "bubleDetail");
        localObject4 = new com.tencent.mm.plugin.story.f.b.a((ddk)localObject4);
        if ((localObject1 == null) || (((c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.f.b.a)localObject4).hGU <= ((c)localObject1).field_readCommentTime)) {
          break label1214;
        }
        localObject5 = ((com.tencent.mm.plugin.story.f.b.a)localObject4).dng;
        localb = com.tencent.mm.plugin.story.f.j.zsh;
        if (bs.lr((String)localObject5, j.b.dHx())) {
          break label1214;
        }
        ((com.tencent.mm.plugin.story.f.b.a)localObject4).ztI = true;
        i = 1;
        this.zuG.commentList.add(localObject4);
        this.zuG.zuD.add(localObject4);
        ((com.tencent.mm.plugin.story.f.b.a)localObject4).awL(this.zuG.ztM);
        ((com.tencent.mm.plugin.story.f.b.a)localObject4).ztO = paramj.dZn();
      }
      localObject2 = ((def)localObject3).FNU.iterator();
      boolean bool2 = false;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ddk)((Iterator)localObject2).next();
        d.g.b.k.g(localObject3, "visitorDetail");
        localObject3 = new com.tencent.mm.plugin.story.f.b.a((ddk)localObject3);
        if ((localObject1 == null) || (((c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.f.b.a)localObject3).hGU <= ((c)localObject1).field_readCommentTime)) {
          break label1211;
        }
        localObject4 = ((com.tencent.mm.plugin.story.f.b.a)localObject3).dng;
        localObject5 = com.tencent.mm.plugin.story.f.j.zsh;
        if (bs.lr((String)localObject4, j.b.dHx())) {
          break label1211;
        }
        ((com.tencent.mm.plugin.story.f.b.a)localObject3).ztI = true;
        bool2 = true;
        this.zuG.zuE.add(localObject3);
        ((com.tencent.mm.plugin.story.f.b.a)localObject3).awL(this.zuG.ztM);
        ((com.tencent.mm.plugin.story.f.b.a)localObject3).ztO = paramj.dZn();
      }
      localObject1 = (List)this.zuG.commentList;
      if (((List)localObject1).size() > 1) {
        d.a.j.a((List)localObject1, (Comparator)new b());
      }
      localObject1 = (List)this.zuG.zuC;
      if (((List)localObject1).size() > 1) {
        d.a.j.a((List)localObject1, (Comparator)new c());
      }
      localObject1 = (List)this.zuG.zuD;
      if (((List)localObject1).size() > 1) {
        d.a.j.a((List)localObject1, (Comparator)new d());
      }
      localObject1 = (List)this.zuG.zuE;
      if (((List)localObject1).size() > 1) {
        d.a.j.a((List)localObject1, (Comparator)new e());
      }
      if ((j != 0) && (this.zuG.commentList.size() > 0))
      {
        localObject1 = com.tencent.mm.plugin.story.f.b.b.ztY;
        long l = this.dyg;
        localObject1 = this.zuG.commentList.get(0);
        d.g.b.k.g(localObject1, "comment.commentList[0]");
        com.tencent.mm.plugin.story.f.b.b.a(l, (com.tencent.mm.plugin.story.f.b.a)localObject1);
      }
      localObject1 = this.zuG;
      boolean bool3;
      if ((i != 0) || (bool1))
      {
        bool3 = true;
        ((g)localObject1).ztI = bool3;
        this.zuG.zuz = bool2;
        this.zuG.zuA = bool1;
        if (paramj == null) {
          break label1195;
        }
        localObject1 = paramj.field_userName;
        label874:
        this.userName = ((String)localObject1);
        localObject1 = s.ztj;
        localObject3 = this.zuF.zuP;
        localObject2 = paramj.field_userName;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        if (!com.tencent.mm.vfs.i.eA(s.a((ddy)localObject3, (String)localObject1)))
        {
          localObject1 = s.ztj;
          if (!com.tencent.mm.vfs.i.eA(s.a(this.zuF.zuP))) {
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
          localObject1 = (CharSequence)this.zuF.zuP.taskId;
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
            localObject1 = com.tencent.mm.plugin.story.f.e.a.zuX;
            localObject2 = com.tencent.mm.plugin.story.f.e.a.Qw((int)paramj.systemRowid);
            if (localObject2 != null)
            {
              localObject3 = this.TAG;
              localObject4 = new StringBuilder("find fake video ").append(this.zuF).append(" media ");
              paramj = com.tencent.mm.plugin.story.e.b.zrj;
              paramj = this.zuF.zuP;
              if (paramj != null)
              {
                localObject1 = "Media localId " + paramj.dwR + " url " + paramj.Url + " thumb " + paramj.Fjh + " duration " + paramj.FNF + " taskId " + paramj.taskId;
                paramj = (com.tencent.mm.plugin.story.i.j)localObject1;
                if (localObject1 != null) {}
              }
              else
              {
                paramj = "";
              }
              ac.i((String)localObject3, paramj);
              c((e)localObject2);
            }
          }
        }
        ac.i(this.TAG, "LogStory: ".concat(String.valueOf(this)));
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
  
  private final boolean c(e parame)
  {
    AppMethodBeat.i(118927);
    Object localObject1 = (com.tencent.mm.bw.a)new adp();
    Object localObject3 = parame.field_baseItemData;
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (adp)localObject1;
      if (localObject1 != null)
      {
        localObject3 = this.zuF;
        Object localObject4 = k.zuS;
        d.g.b.k.h(localObject4, "<set-?>");
        ((j)localObject3).zuO = ((k)localObject4);
        localObject3 = this.zuF;
        localObject4 = parame.aLs();
        d.g.b.k.h(localObject4, "<set-?>");
        ((j)localObject3).taskId = ((String)localObject4);
        this.zuF.zuP.Fjh = ((adp)localObject1).thumbPath;
        this.zuF.zuP.Id = ("fake_" + ((adp)localObject1).timeStamp);
        this.zuF.wmo = ((adp)localObject1).wse;
        if ((!com.tencent.mm.vfs.i.eA(((adp)localObject1).videoPath)) && (((adp)localObject1).Ewp.size() == 0) && (((adp)localObject1).Ewq == null))
        {
          localObject1 = com.tencent.mm.plugin.story.f.e.a.zuX;
          com.tencent.mm.plugin.story.f.e.a.aqA(parame.aLs());
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
        ac.l("safeParser", "", new Object[] { localException });
        localObject2 = null;
      }
      if (((adp)localObject2).Ewp.size() > 0)
      {
        localObject2 = ((adp)localObject2).Ewp.iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (!com.tencent.mm.vfs.i.eA((String)((Iterator)localObject2).next()))
          {
            localObject2 = com.tencent.mm.plugin.story.f.e.a.zuX;
            com.tencent.mm.plugin.story.f.e.a.aqA(parame.aLs());
            AppMethodBeat.o(118927);
            return false;
          }
        }
      }
      this.zuF.zuQ = parame;
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
    if ((this.dyg == ((h)paramObject).dyg) && (d.g.b.k.g(this.zuF, ((h)paramObject).zuF)) && (d.g.b.k.g(this.zuG, ((h)paramObject).zuG)) && (this.zuH.dZk().gLY == ((h)paramObject).zuH.dZk().gLY))
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
    String str = "StoryGalleryItem(videoItem=" + this.zuF + ", comment=" + this.zuG + ')';
    AppMethodBeat.o(118928);
    return str;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem$Companion;", "", "()V", "createStoryGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "extInfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "createStoryGalleryItemForSns", "plugin-story_release"})
  public static final class a
  {
    public static h a(f paramf)
    {
      AppMethodBeat.i(118921);
      d.g.b.k.h(paramf, "extInfo");
      com.tencent.mm.plugin.story.i.j localj = new com.tencent.mm.plugin.story.i.j();
      localj.field_storyID = paramf.field_syncId;
      localj.field_createTime = paramf.field_storyPostTime;
      localj.field_userName = paramf.getUserName();
      Object localObject1 = q.zsy;
      localObject1 = q.a.dVY();
      ((dep)localObject1).ncR = paramf.getUserName();
      ((dep)localObject1).CreateTime = paramf.field_storyPostTime;
      Object localObject2 = q.zsy;
      localObject2 = new ddy();
      ((ddy)localObject2).Id = ("empty_" + ce.azI());
      ((ddy)localObject2).Fjh = paramf.aik();
      ((ddy)localObject2).Url = paramf.dYZ();
      if (paramf.field_duration > 0L) {}
      for (float f = (float)(paramf.field_duration / 1000.0D);; f = 0.0F)
      {
        ((ddy)localObject2).FNF = f;
        ((dep)localObject1).FOc.Etz.add(localObject2);
        localj.c((dep)localObject1);
        paramf = new h(localj, (dep)localObject1);
        AppMethodBeat.o(118921);
        return paramf;
      }
    }
    
    public static h a(com.tencent.mm.plugin.story.i.j paramj, i parami)
    {
      AppMethodBeat.i(118919);
      d.g.b.k.h(paramj, "story");
      d.g.b.k.h(parami, "storyItemScene");
      paramj = new h(paramj, paramj.dZi(), parami);
      AppMethodBeat.o(118919);
      return paramj;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118922);
      int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).hGU), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).hGU));
      AppMethodBeat.o(118922);
      return i;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118923);
      int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).hGU), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).hGU));
      AppMethodBeat.o(118923);
      return i;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class d<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118924);
      int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).hGU), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).hGU));
      AppMethodBeat.o(118924);
      return i;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class e<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118925);
      int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).hGU), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).hGU));
      AppMethodBeat.o(118925);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.h
 * JD-Core Version:    0.7.0.1
 */