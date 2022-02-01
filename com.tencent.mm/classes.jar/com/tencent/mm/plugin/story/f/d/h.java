package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.edf;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyTImeline", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;)V", "TAG", "", "comment", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getComment", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyId", "", "getStoryId", "()J", "getStoryItemScene", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "getStoryTImeline", "()Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "convertFromFakeDB", "", "videoEditData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "convertFromStoryInfo", "equals", "other", "toString", "Companion", "plugin-story_release"})
public final class h
{
  public static final a FoY;
  public final j FoT;
  public final g FoU;
  public final com.tencent.mm.plugin.story.i.j FoV;
  private final eek FoW;
  public final i FoX;
  private final String TAG;
  public final long edx;
  public String userName;
  
  static
  {
    AppMethodBeat.i(118932);
    FoY = new a((byte)0);
    AppMethodBeat.o(118932);
  }
  
  public h(com.tencent.mm.plugin.story.i.j paramj, eek parameek, i parami)
  {
    AppMethodBeat.i(118930);
    this.FoV = paramj;
    this.FoW = parameek;
    this.FoX = parami;
    this.TAG = "MicroMsg.StoryGalleryItem";
    this.edx = this.FoV.field_storyID;
    int i = (int)this.FoV.systemRowid;
    long l = this.FoV.field_storyID;
    int j = this.FoV.field_createTime;
    parameek = this.FoV.field_userName;
    paramj = parameek;
    if (parameek == null) {
      paramj = "";
    }
    paramj = new j(i, l, j, paramj);
    parameek = this.FoW;
    if (parameek.NeB.LoV.size() > 0)
    {
      parami = parameek.NeB.LoV.get(0);
      p.g(parami, "timeline.ContentObj.MediaObjList[0]");
      parami = (edt)parami;
      p.h(parami, "<set-?>");
      paramj.Fpd = parami;
    }
    paramj.BKf = parameek.NeA;
    this.FoT = paramj;
    this.FoU = new g();
    a(this.FoV);
    AppMethodBeat.o(118930);
  }
  
  private final boolean a(com.tencent.mm.plugin.story.i.j paramj)
  {
    int k = 0;
    AppMethodBeat.i(118926);
    Object localObject3 = new eea();
    try
    {
      ((eea)localObject3).parseFrom(paramj.field_attrBuf);
      Object localObject4 = this.FoU;
      Object localObject2 = paramj.field_userName;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
        localObject1 = j.b.fau();
      }
      p.h(localObject1, "<set-?>");
      ((g)localObject4).Foa = ((String)localObject1);
      this.FoU.edx = paramj.field_storyID;
      this.FoU.EBD = 0;
      this.FoU.FoP = paramj.frF();
      localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
      localObject1 = j.b.fof().Kw(paramj.field_storyID);
      if ((localObject1 == null) || (((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime == 0)) {}
      boolean bool1;
      Object localObject5;
      j.b localb;
      for (int j = 1;; j = 0)
      {
        localObject2 = ((eea)localObject3).Nen.iterator();
        bool1 = false;
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (edf)((Iterator)localObject2).next();
          p.g(localObject4, "commentDetail");
          localObject4 = new com.tencent.mm.plugin.story.f.b.a((edf)localObject4);
          if ((localObject1 == null) || (((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.f.b.a)localObject4).iXu <= ((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime)) {
            break label1217;
          }
          localObject5 = ((com.tencent.mm.plugin.story.f.b.a)localObject4).dRL;
          localb = com.tencent.mm.plugin.story.f.j.Fmy;
          if (Util.isEqual((String)localObject5, j.b.fau())) {
            break label1217;
          }
          ((com.tencent.mm.plugin.story.f.b.a)localObject4).FnW = true;
          bool1 = true;
          this.FoU.commentList.add(localObject4);
          this.FoU.FoQ.add(localObject4);
          ((com.tencent.mm.plugin.story.f.b.a)localObject4).aSd(this.FoU.Foa);
          ((com.tencent.mm.plugin.story.f.b.a)localObject4).Foc = paramj.frL();
        }
      }
      localObject2 = ((eea)localObject3).Nep.iterator();
      int i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (edf)((Iterator)localObject2).next();
        p.g(localObject4, "bubleDetail");
        localObject4 = new com.tencent.mm.plugin.story.f.b.a((edf)localObject4);
        if ((localObject1 == null) || (((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.f.b.a)localObject4).iXu <= ((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime)) {
          break label1214;
        }
        localObject5 = ((com.tencent.mm.plugin.story.f.b.a)localObject4).dRL;
        localb = com.tencent.mm.plugin.story.f.j.Fmy;
        if (Util.isEqual((String)localObject5, j.b.fau())) {
          break label1214;
        }
        ((com.tencent.mm.plugin.story.f.b.a)localObject4).FnW = true;
        i = 1;
        this.FoU.commentList.add(localObject4);
        this.FoU.FoR.add(localObject4);
        ((com.tencent.mm.plugin.story.f.b.a)localObject4).aSd(this.FoU.Foa);
        ((com.tencent.mm.plugin.story.f.b.a)localObject4).Foc = paramj.frL();
      }
      localObject2 = ((eea)localObject3).Net.iterator();
      boolean bool2 = false;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (edf)((Iterator)localObject2).next();
        p.g(localObject3, "visitorDetail");
        localObject3 = new com.tencent.mm.plugin.story.f.b.a((edf)localObject3);
        if ((localObject1 == null) || (((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.f.b.a)localObject3).iXu <= ((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime)) {
          break label1211;
        }
        localObject4 = ((com.tencent.mm.plugin.story.f.b.a)localObject3).dRL;
        localObject5 = com.tencent.mm.plugin.story.f.j.Fmy;
        if (Util.isEqual((String)localObject4, j.b.fau())) {
          break label1211;
        }
        ((com.tencent.mm.plugin.story.f.b.a)localObject3).FnW = true;
        bool2 = true;
        this.FoU.FoS.add(localObject3);
        ((com.tencent.mm.plugin.story.f.b.a)localObject3).aSd(this.FoU.Foa);
        ((com.tencent.mm.plugin.story.f.b.a)localObject3).Foc = paramj.frL();
      }
      localObject1 = (List)this.FoU.commentList;
      if (((List)localObject1).size() > 1) {
        kotlin.a.j.a((List)localObject1, (Comparator)new b());
      }
      localObject1 = (List)this.FoU.FoQ;
      if (((List)localObject1).size() > 1) {
        kotlin.a.j.a((List)localObject1, (Comparator)new c());
      }
      localObject1 = (List)this.FoU.FoR;
      if (((List)localObject1).size() > 1) {
        kotlin.a.j.a((List)localObject1, (Comparator)new d());
      }
      localObject1 = (List)this.FoU.FoS;
      if (((List)localObject1).size() > 1) {
        kotlin.a.j.a((List)localObject1, (Comparator)new e());
      }
      if ((j != 0) && (this.FoU.commentList.size() > 0))
      {
        localObject1 = com.tencent.mm.plugin.story.f.b.b.Fom;
        long l = this.edx;
        localObject1 = this.FoU.commentList.get(0);
        p.g(localObject1, "comment.commentList[0]");
        com.tencent.mm.plugin.story.f.b.b.a(l, (com.tencent.mm.plugin.story.f.b.a)localObject1);
      }
      localObject1 = this.FoU;
      boolean bool3;
      if ((i != 0) || (bool1))
      {
        bool3 = true;
        ((g)localObject1).FnW = bool3;
        this.FoU.FoN = bool2;
        this.FoU.FoO = bool1;
        if (paramj == null) {
          break label1195;
        }
        localObject1 = paramj.field_userName;
        label874:
        this.userName = ((String)localObject1);
        localObject1 = com.tencent.mm.plugin.story.f.s.Fny;
        localObject3 = this.FoT.Fpd;
        localObject2 = paramj.field_userName;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        if (!com.tencent.mm.vfs.s.YS(com.tencent.mm.plugin.story.f.s.a((edt)localObject3, (String)localObject1)))
        {
          localObject1 = com.tencent.mm.plugin.story.f.s.Fny;
          if (!com.tencent.mm.vfs.s.YS(com.tencent.mm.plugin.story.f.s.a(this.FoT.Fpd))) {
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
          localObject1 = (CharSequence)this.FoT.Fpd.taskId;
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
            localObject1 = com.tencent.mm.plugin.story.f.e.a.Fpl;
            localObject2 = com.tencent.mm.plugin.story.f.e.a.aaI((int)paramj.systemRowid);
            if (localObject2 != null)
            {
              localObject3 = this.TAG;
              localObject4 = new StringBuilder("find fake video ").append(this.FoT).append(" media ");
              paramj = com.tencent.mm.plugin.story.e.b.FlA;
              paramj = this.FoT.Fpd;
              if (paramj != null)
              {
                localObject1 = "Media localId " + paramj.ecf + " url " + paramj.Url + " thumb " + paramj.Msz + " duration " + paramj.Ned + " taskId " + paramj.taskId;
                paramj = (com.tencent.mm.plugin.story.i.j)localObject1;
                if (localObject1 != null) {}
              }
              else
              {
                paramj = "";
              }
              Log.i((String)localObject3, paramj);
              c((com.tencent.mm.plugin.recordvideo.background.c)localObject2);
            }
          }
        }
        Log.i(this.TAG, "LogStory: ".concat(String.valueOf(this)));
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
    Object localObject1 = (com.tencent.mm.bw.a)new aio();
    Object localObject3 = paramc.field_baseItemData;
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (aio)localObject1;
      if (localObject1 != null)
      {
        localObject3 = this.FoT;
        Object localObject4 = k.Fpg;
        p.h(localObject4, "<set-?>");
        ((j)localObject3).Fpc = ((k)localObject4);
        localObject3 = this.FoT;
        localObject4 = paramc.bjl();
        p.h(localObject4, "<set-?>");
        ((j)localObject3).taskId = ((String)localObject4);
        this.FoT.Fpd.Msz = ((aio)localObject1).thumbPath;
        this.FoT.Fpd.Id = ("fake_" + ((aio)localObject1).timeStamp);
        this.FoT.BKf = ((aio)localObject1).BPU;
        if ((!com.tencent.mm.vfs.s.YS(((aio)localObject1).videoPath)) && (((aio)localObject1).Lsc.size() == 0) && (((aio)localObject1).Lsd == null))
        {
          localObject1 = com.tencent.mm.plugin.story.f.e.a.Fpl;
          com.tencent.mm.plugin.story.f.e.a.aLh(paramc.bjl());
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
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        localObject2 = null;
      }
      if (((aio)localObject2).Lsc.size() > 0)
      {
        localObject2 = ((aio)localObject2).Lsc.iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (!com.tencent.mm.vfs.s.YS((String)((Iterator)localObject2).next()))
          {
            localObject2 = com.tencent.mm.plugin.story.f.e.a.Fpl;
            com.tencent.mm.plugin.story.f.e.a.aLh(paramc.bjl());
            AppMethodBeat.o(118927);
            return false;
          }
        }
      }
      this.FoT.Fpe = paramc;
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
    if ((this.edx == ((h)paramObject).edx) && (p.j(this.FoT, ((h)paramObject).FoT)) && (p.j(this.FoU, ((h)paramObject).FoU)) && (this.FoV.frI().ibG == ((h)paramObject).FoV.frI().ibG))
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
    String str = "StoryGalleryItem(videoItem=" + this.FoT + ", comment=" + this.FoU + ')';
    AppMethodBeat.o(118928);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem$Companion;", "", "()V", "createStoryGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "extInfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "createStoryGalleryItemForSns", "plugin-story_release"})
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
      Object localObject1 = q.FmO;
      localObject1 = q.a.fox();
      ((eek)localObject1).UserName = paramf.getUserName();
      ((eek)localObject1).CreateTime = paramf.field_storyPostTime;
      Object localObject2 = q.FmO;
      localObject2 = new edt();
      ((edt)localObject2).Id = ("empty_" + cl.aWz());
      ((edt)localObject2).Msz = paramf.aBE();
      ((edt)localObject2).Url = paramf.frx();
      if (paramf.field_duration > 0L) {}
      for (float f = (float)(paramf.field_duration / 1000.0D);; f = 0.0F)
      {
        ((edt)localObject2).Ned = f;
        ((eek)localObject1).NeB.LoV.add(localObject2);
        localj.c((eek)localObject1);
        paramf = new h(localj, (eek)localObject1);
        AppMethodBeat.o(118921);
        return paramf;
      }
    }
    
    public static h a(com.tencent.mm.plugin.story.i.j paramj, i parami)
    {
      AppMethodBeat.i(118919);
      p.h(paramj, "story");
      p.h(parami, "storyItemScene");
      paramj = new h(paramj, paramj.frG(), parami);
      AppMethodBeat.o(118919);
      return paramj;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118922);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).iXu), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).iXu));
      AppMethodBeat.o(118922);
      return i;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118923);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).iXu), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).iXu));
      AppMethodBeat.o(118923);
      return i;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class d<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118924);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).iXu), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).iXu));
      AppMethodBeat.o(118924);
      return i;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class e<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118925);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).iXu), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).iXu));
      AppMethodBeat.o(118925);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.h
 * JD-Core Version:    0.7.0.1
 */