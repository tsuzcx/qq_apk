package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.recordvideo.background.d;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.c;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.cxy;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyTImeline", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;)V", "TAG", "", "comment", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getComment", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyId", "", "getStoryId", "()J", "getStoryItemScene", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "getStoryTImeline", "()Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "convertFromFakeDB", "", "videoEditData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "convertFromStoryInfo", "equals", "other", "toString", "Companion", "plugin-story_release"})
public final class h
{
  public static final a yhK;
  private final String TAG;
  public final long dAu;
  public String userName;
  public final j yhF;
  public final g yhG;
  public final com.tencent.mm.plugin.story.i.j yhH;
  private final czd yhI;
  public final i yhJ;
  
  static
  {
    AppMethodBeat.i(118932);
    yhK = new a((byte)0);
    AppMethodBeat.o(118932);
  }
  
  public h(com.tencent.mm.plugin.story.i.j paramj, czd paramczd, i parami)
  {
    AppMethodBeat.i(118930);
    this.yhH = paramj;
    this.yhI = paramczd;
    this.yhJ = parami;
    this.TAG = "MicroMsg.StoryGalleryItem";
    this.dAu = this.yhH.field_storyID;
    int i = (int)this.yhH.systemRowid;
    long l = this.yhH.field_storyID;
    int j = this.yhH.field_createTime;
    paramczd = this.yhH.field_userName;
    paramj = paramczd;
    if (paramczd == null) {
      paramj = "";
    }
    paramj = new j(i, l, j, paramj);
    paramczd = this.yhI;
    if (paramczd.Era.DaC.size() > 0)
    {
      parami = paramczd.Era.DaC.get(0);
      d.g.b.k.g(parami, "timeline.ContentObj.MediaObjList[0]");
      parami = (cym)parami;
      d.g.b.k.h(parami, "<set-?>");
      paramj.yhP = parami;
    }
    paramj.vdy = paramczd.EqZ;
    this.yhF = paramj;
    this.yhG = new g();
    a(this.yhH);
    AppMethodBeat.o(118930);
  }
  
  private final boolean a(com.tencent.mm.plugin.story.i.j paramj)
  {
    int k = 0;
    AppMethodBeat.i(118926);
    Object localObject3 = new cyt();
    try
    {
      ((cyt)localObject3).parseFrom(paramj.field_attrBuf);
      Object localObject4 = this.yhG;
      Object localObject2 = paramj.field_userName;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
        localObject1 = j.b.dta();
      }
      d.g.b.k.h(localObject1, "<set-?>");
      ((g)localObject4).ygM = ((String)localObject1);
      this.yhG.dAu = paramj.field_storyID;
      this.yhG.xxb = 0;
      this.yhG.yhB = paramj.dKG();
      localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
      localObject1 = j.b.dHg().tS(paramj.field_storyID);
      if ((localObject1 == null) || (((c)localObject1).field_readCommentTime == 0)) {}
      boolean bool1;
      Object localObject5;
      j.b localb;
      for (int j = 1;; j = 0)
      {
        localObject2 = ((cyt)localObject3).EqM.iterator();
        bool1 = false;
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (cxy)((Iterator)localObject2).next();
          d.g.b.k.g(localObject4, "commentDetail");
          localObject4 = new com.tencent.mm.plugin.story.f.b.a((cxy)localObject4);
          if ((localObject1 == null) || (((c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.f.b.a)localObject4).hgr <= ((c)localObject1).field_readCommentTime)) {
            break label1217;
          }
          localObject5 = ((com.tencent.mm.plugin.story.f.b.a)localObject4).dpv;
          localb = com.tencent.mm.plugin.story.f.j.yfh;
          if (bt.kU((String)localObject5, j.b.dta())) {
            break label1217;
          }
          ((com.tencent.mm.plugin.story.f.b.a)localObject4).ygI = true;
          bool1 = true;
          this.yhG.commentList.add(localObject4);
          this.yhG.yhC.add(localObject4);
          ((com.tencent.mm.plugin.story.f.b.a)localObject4).arC(this.yhG.ygM);
          ((com.tencent.mm.plugin.story.f.b.a)localObject4).ygO = paramj.dKM();
        }
      }
      localObject2 = ((cyt)localObject3).EqO.iterator();
      int i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (cxy)((Iterator)localObject2).next();
        d.g.b.k.g(localObject4, "bubleDetail");
        localObject4 = new com.tencent.mm.plugin.story.f.b.a((cxy)localObject4);
        if ((localObject1 == null) || (((c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.f.b.a)localObject4).hgr <= ((c)localObject1).field_readCommentTime)) {
          break label1214;
        }
        localObject5 = ((com.tencent.mm.plugin.story.f.b.a)localObject4).dpv;
        localb = com.tencent.mm.plugin.story.f.j.yfh;
        if (bt.kU((String)localObject5, j.b.dta())) {
          break label1214;
        }
        ((com.tencent.mm.plugin.story.f.b.a)localObject4).ygI = true;
        i = 1;
        this.yhG.commentList.add(localObject4);
        this.yhG.yhD.add(localObject4);
        ((com.tencent.mm.plugin.story.f.b.a)localObject4).arC(this.yhG.ygM);
        ((com.tencent.mm.plugin.story.f.b.a)localObject4).ygO = paramj.dKM();
      }
      localObject2 = ((cyt)localObject3).EqS.iterator();
      boolean bool2 = false;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (cxy)((Iterator)localObject2).next();
        d.g.b.k.g(localObject3, "visitorDetail");
        localObject3 = new com.tencent.mm.plugin.story.f.b.a((cxy)localObject3);
        if ((localObject1 == null) || (((c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.f.b.a)localObject3).hgr <= ((c)localObject1).field_readCommentTime)) {
          break label1211;
        }
        localObject4 = ((com.tencent.mm.plugin.story.f.b.a)localObject3).dpv;
        localObject5 = com.tencent.mm.plugin.story.f.j.yfh;
        if (bt.kU((String)localObject4, j.b.dta())) {
          break label1211;
        }
        ((com.tencent.mm.plugin.story.f.b.a)localObject3).ygI = true;
        bool2 = true;
        this.yhG.yhE.add(localObject3);
        ((com.tencent.mm.plugin.story.f.b.a)localObject3).arC(this.yhG.ygM);
        ((com.tencent.mm.plugin.story.f.b.a)localObject3).ygO = paramj.dKM();
      }
      localObject1 = (List)this.yhG.commentList;
      if (((List)localObject1).size() > 1) {
        d.a.j.a((List)localObject1, (Comparator)new b());
      }
      localObject1 = (List)this.yhG.yhC;
      if (((List)localObject1).size() > 1) {
        d.a.j.a((List)localObject1, (Comparator)new c());
      }
      localObject1 = (List)this.yhG.yhD;
      if (((List)localObject1).size() > 1) {
        d.a.j.a((List)localObject1, (Comparator)new d());
      }
      localObject1 = (List)this.yhG.yhE;
      if (((List)localObject1).size() > 1) {
        d.a.j.a((List)localObject1, (Comparator)new e());
      }
      if ((j != 0) && (this.yhG.commentList.size() > 0))
      {
        localObject1 = com.tencent.mm.plugin.story.f.b.b.ygY;
        long l = this.dAu;
        localObject1 = this.yhG.commentList.get(0);
        d.g.b.k.g(localObject1, "comment.commentList[0]");
        com.tencent.mm.plugin.story.f.b.b.a(l, (com.tencent.mm.plugin.story.f.b.a)localObject1);
      }
      localObject1 = this.yhG;
      boolean bool3;
      if ((i != 0) || (bool1))
      {
        bool3 = true;
        ((g)localObject1).ygI = bool3;
        this.yhG.yhz = bool2;
        this.yhG.yhA = bool1;
        if (paramj == null) {
          break label1195;
        }
        localObject1 = paramj.field_userName;
        label874:
        this.userName = ((String)localObject1);
        localObject1 = s.ygj;
        localObject3 = this.yhF.yhP;
        localObject2 = paramj.field_userName;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        if (!com.tencent.mm.vfs.i.eK(s.a((cym)localObject3, (String)localObject1)))
        {
          localObject1 = s.ygj;
          if (!com.tencent.mm.vfs.i.eK(s.a(this.yhF.yhP))) {
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
          localObject1 = (CharSequence)this.yhF.yhP.taskId;
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
            localObject1 = com.tencent.mm.plugin.story.f.e.a.yhX;
            localObject2 = com.tencent.mm.plugin.story.f.e.a.Oq((int)paramj.systemRowid);
            if (localObject2 != null)
            {
              localObject3 = this.TAG;
              localObject4 = new StringBuilder("find fake video ").append(this.yhF).append(" media ");
              paramj = com.tencent.mm.plugin.story.e.b.yej;
              paramj = this.yhF.yhP;
              if (paramj != null)
              {
                localObject1 = "Media localId " + paramj.dzf + " url " + paramj.Url + " thumb " + paramj.DMQ + " duration " + paramj.EqD + " taskId " + paramj.taskId;
                paramj = (com.tencent.mm.plugin.story.i.j)localObject1;
                if (localObject1 != null) {}
              }
              else
              {
                paramj = "";
              }
              ad.i((String)localObject3, paramj);
              c((d)localObject2);
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
  
  private final boolean c(d paramd)
  {
    AppMethodBeat.i(118927);
    Object localObject1 = (com.tencent.mm.bx.a)new acq();
    Object localObject3 = paramd.field_baseItemData;
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (acq)localObject1;
      if (localObject1 != null)
      {
        localObject3 = this.yhF;
        Object localObject4 = k.yhS;
        d.g.b.k.h(localObject4, "<set-?>");
        ((j)localObject3).yhO = ((k)localObject4);
        localObject3 = this.yhF;
        localObject4 = paramd.aEB();
        d.g.b.k.h(localObject4, "<set-?>");
        ((j)localObject3).taskId = ((String)localObject4);
        this.yhF.yhP.DMQ = ((acq)localObject1).thumbPath;
        this.yhF.yhP.Id = ("fake_" + ((acq)localObject1).timeStamp);
        this.yhF.vdy = ((acq)localObject1).vjt;
        if ((!com.tencent.mm.vfs.i.eK(((acq)localObject1).videoPath)) && (((acq)localObject1).Ddj.size() == 0) && (((acq)localObject1).Ddk == null))
        {
          localObject1 = com.tencent.mm.plugin.story.f.e.a.yhX;
          com.tencent.mm.plugin.story.f.e.a.alB(paramd.aEB());
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
      if (((acq)localObject2).Ddj.size() > 0)
      {
        localObject2 = ((acq)localObject2).Ddj.iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (!com.tencent.mm.vfs.i.eK((String)((Iterator)localObject2).next()))
          {
            localObject2 = com.tencent.mm.plugin.story.f.e.a.yhX;
            com.tencent.mm.plugin.story.f.e.a.alB(paramd.aEB());
            AppMethodBeat.o(118927);
            return false;
          }
        }
      }
      this.yhF.yhQ = paramd;
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
    if ((this.dAu == ((h)paramObject).dAu) && (d.g.b.k.g(this.yhF, ((h)paramObject).yhF)) && (d.g.b.k.g(this.yhG, ((h)paramObject).yhG)) && (this.yhH.dKJ().gll == ((h)paramObject).yhH.dKJ().gll))
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
    String str = "StoryGalleryItem(videoItem=" + this.yhF + ", comment=" + this.yhG + ')';
    AppMethodBeat.o(118928);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem$Companion;", "", "()V", "createStoryGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "extInfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "createStoryGalleryItemForSns", "plugin-story_release"})
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
      Object localObject1 = q.yfy;
      localObject1 = q.a.dHx();
      ((czd)localObject1).mAQ = paramf.getUserName();
      ((czd)localObject1).CreateTime = paramf.field_storyPostTime;
      Object localObject2 = q.yfy;
      localObject2 = new cym();
      ((cym)localObject2).Id = ("empty_" + ce.asR());
      ((cym)localObject2).DMQ = paramf.cmT();
      ((cym)localObject2).Url = paramf.dKy();
      if (paramf.field_duration > 0L) {}
      for (float f = (float)(paramf.field_duration / 1000.0D);; f = 0.0F)
      {
        ((cym)localObject2).EqD = f;
        ((czd)localObject1).Era.DaC.add(localObject2);
        localj.c((czd)localObject1);
        paramf = new h(localj, (czd)localObject1);
        AppMethodBeat.o(118921);
        return paramf;
      }
    }
    
    public static h a(com.tencent.mm.plugin.story.i.j paramj, i parami)
    {
      AppMethodBeat.i(118919);
      d.g.b.k.h(paramj, "story");
      d.g.b.k.h(parami, "storyItemScene");
      paramj = new h(paramj, paramj.dKH(), parami);
      AppMethodBeat.o(118919);
      return paramj;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118922);
      int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).hgr), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).hgr));
      AppMethodBeat.o(118922);
      return i;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118923);
      int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).hgr), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).hgr));
      AppMethodBeat.o(118923);
      return i;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class d<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118924);
      int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).hgr), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).hgr));
      AppMethodBeat.o(118924);
      return i;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class e<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118925);
      int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).hgr), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).hgr));
      AppMethodBeat.o(118925);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.h
 * JD-Core Version:    0.7.0.1
 */