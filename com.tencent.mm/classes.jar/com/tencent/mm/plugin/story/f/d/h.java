package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.protocal.protobuf.eng;
import com.tencent.mm.protocal.protobuf.enl;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.protocal.protobuf.env;
import com.tencent.mm.protocal.protobuf.eob;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyTImeline", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;)V", "TAG", "", "comment", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getComment", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyId", "", "getStoryId", "()J", "getStoryItemScene", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "getStoryTImeline", "()Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "convertFromFakeDB", "", "videoEditData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "convertFromStoryInfo", "equals", "other", "toString", "Companion", "plugin-story_release"})
public final class h
{
  public static final a LJa;
  public final j LIV;
  public final g LIW;
  public final com.tencent.mm.plugin.story.i.j LIX;
  private final eol LIY;
  public final i LIZ;
  private final String TAG;
  public final long fXG;
  public String userName;
  
  static
  {
    AppMethodBeat.i(118932);
    LJa = new a((byte)0);
    AppMethodBeat.o(118932);
  }
  
  public h(com.tencent.mm.plugin.story.i.j paramj, eol parameol, i parami)
  {
    AppMethodBeat.i(118930);
    this.LIX = paramj;
    this.LIY = parameol;
    this.LIZ = parami;
    this.TAG = "MicroMsg.StoryGalleryItem";
    this.fXG = this.LIX.field_storyID;
    int i = (int)this.LIX.systemRowid;
    long l = this.LIX.field_storyID;
    int j = this.LIX.field_createTime;
    parameol = this.LIX.field_userName;
    paramj = parameol;
    if (parameol == null) {
      paramj = "";
    }
    paramj = new j(i, l, j, paramj);
    parameol = this.LIY;
    if (parameol.Ura.Sqr.size() > 0)
    {
      parami = parameol.Ura.Sqr.get(0);
      p.j(parami, "timeline.ContentObj.MediaObjList[0]");
      parami = (enu)parami;
      p.k(parami, "<set-?>");
      paramj.LJf = parami;
    }
    paramj.HGp = parameol.UqZ;
    this.LIV = paramj;
    this.LIW = new g();
    a(this.LIX);
    AppMethodBeat.o(118930);
  }
  
  private final boolean a(com.tencent.mm.plugin.story.i.j paramj)
  {
    int k = 0;
    AppMethodBeat.i(118926);
    Object localObject3 = new eob();
    try
    {
      ((eob)localObject3).parseFrom(paramj.field_attrBuf);
      Object localObject4 = this.LIW;
      Object localObject2 = paramj.field_userName;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
        localObject1 = j.b.fOo();
      }
      p.k(localObject1, "<set-?>");
      ((g)localObject4).LIb = ((String)localObject1);
      this.LIW.fXG = paramj.field_storyID;
      this.LIW.KPv = 0;
      this.LIW.LIR = paramj.ggb();
      localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
      localObject1 = j.b.gcz().RQ(paramj.field_storyID);
      if ((localObject1 == null) || (((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime == 0)) {}
      boolean bool1;
      Object localObject5;
      j.b localb;
      for (int j = 1;; j = 0)
      {
        localObject2 = ((eob)localObject3).UqM.iterator();
        bool1 = false;
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (eng)((Iterator)localObject2).next();
          p.j(localObject4, "commentDetail");
          localObject4 = new com.tencent.mm.plugin.story.f.b.a((eng)localObject4);
          if ((localObject1 == null) || (((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.f.b.a)localObject4).createTime <= ((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime)) {
            break label1217;
          }
          localObject5 = ((com.tencent.mm.plugin.story.f.b.a)localObject4).fLi;
          localb = com.tencent.mm.plugin.story.f.j.LGA;
          if (Util.isEqual((String)localObject5, j.b.fOo())) {
            break label1217;
          }
          ((com.tencent.mm.plugin.story.f.b.a)localObject4).LHX = true;
          bool1 = true;
          this.LIW.commentList.add(localObject4);
          this.LIW.LIS.add(localObject4);
          ((com.tencent.mm.plugin.story.f.b.a)localObject4).bdh(this.LIW.LIb);
          ((com.tencent.mm.plugin.story.f.b.a)localObject4).LId = paramj.ggh();
        }
      }
      localObject2 = ((eob)localObject3).UqO.iterator();
      int i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (eng)((Iterator)localObject2).next();
        p.j(localObject4, "bubleDetail");
        localObject4 = new com.tencent.mm.plugin.story.f.b.a((eng)localObject4);
        if ((localObject1 == null) || (((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.f.b.a)localObject4).createTime <= ((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime)) {
          break label1214;
        }
        localObject5 = ((com.tencent.mm.plugin.story.f.b.a)localObject4).fLi;
        localb = com.tencent.mm.plugin.story.f.j.LGA;
        if (Util.isEqual((String)localObject5, j.b.fOo())) {
          break label1214;
        }
        ((com.tencent.mm.plugin.story.f.b.a)localObject4).LHX = true;
        i = 1;
        this.LIW.commentList.add(localObject4);
        this.LIW.LIT.add(localObject4);
        ((com.tencent.mm.plugin.story.f.b.a)localObject4).bdh(this.LIW.LIb);
        ((com.tencent.mm.plugin.story.f.b.a)localObject4).LId = paramj.ggh();
      }
      localObject2 = ((eob)localObject3).UqS.iterator();
      boolean bool2 = false;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (eng)((Iterator)localObject2).next();
        p.j(localObject3, "visitorDetail");
        localObject3 = new com.tencent.mm.plugin.story.f.b.a((eng)localObject3);
        if ((localObject1 == null) || (((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.f.b.a)localObject3).createTime <= ((com.tencent.mm.plugin.story.i.c)localObject1).field_readCommentTime)) {
          break label1211;
        }
        localObject4 = ((com.tencent.mm.plugin.story.f.b.a)localObject3).fLi;
        localObject5 = com.tencent.mm.plugin.story.f.j.LGA;
        if (Util.isEqual((String)localObject4, j.b.fOo())) {
          break label1211;
        }
        ((com.tencent.mm.plugin.story.f.b.a)localObject3).LHX = true;
        bool2 = true;
        this.LIW.LIU.add(localObject3);
        ((com.tencent.mm.plugin.story.f.b.a)localObject3).bdh(this.LIW.LIb);
        ((com.tencent.mm.plugin.story.f.b.a)localObject3).LId = paramj.ggh();
      }
      localObject1 = (List)this.LIW.commentList;
      if (((List)localObject1).size() > 1) {
        kotlin.a.j.a((List)localObject1, (Comparator)new b());
      }
      localObject1 = (List)this.LIW.LIS;
      if (((List)localObject1).size() > 1) {
        kotlin.a.j.a((List)localObject1, (Comparator)new c());
      }
      localObject1 = (List)this.LIW.LIT;
      if (((List)localObject1).size() > 1) {
        kotlin.a.j.a((List)localObject1, (Comparator)new d());
      }
      localObject1 = (List)this.LIW.LIU;
      if (((List)localObject1).size() > 1) {
        kotlin.a.j.a((List)localObject1, (Comparator)new e());
      }
      if ((j != 0) && (this.LIW.commentList.size() > 0))
      {
        localObject1 = com.tencent.mm.plugin.story.f.b.b.LIo;
        long l = this.fXG;
        localObject1 = this.LIW.commentList.get(0);
        p.j(localObject1, "comment.commentList[0]");
        com.tencent.mm.plugin.story.f.b.b.a(l, (com.tencent.mm.plugin.story.f.b.a)localObject1);
      }
      localObject1 = this.LIW;
      boolean bool3;
      if ((i != 0) || (bool1))
      {
        bool3 = true;
        ((g)localObject1).LHX = bool3;
        this.LIW.LIP = bool2;
        this.LIW.LIQ = bool1;
        if (paramj == null) {
          break label1195;
        }
        localObject1 = paramj.field_userName;
        label874:
        this.userName = ((String)localObject1);
        localObject1 = s.LHA;
        localObject3 = this.LIV.LJf;
        localObject2 = paramj.field_userName;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        if (!u.agG(s.a((enu)localObject3, (String)localObject1)))
        {
          localObject1 = s.LHA;
          if (!u.agG(s.a(this.LIV.LJf))) {
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
          localObject1 = (CharSequence)this.LIV.LJf.taskId;
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
            localObject1 = com.tencent.mm.plugin.story.f.e.a.LJn;
            localObject2 = com.tencent.mm.plugin.story.f.e.a.aid((int)paramj.systemRowid);
            if (localObject2 != null)
            {
              localObject3 = this.TAG;
              localObject4 = new StringBuilder("find fake video ").append(this.LIV).append(" media ");
              paramj = com.tencent.mm.plugin.story.e.b.LFC;
              paramj = this.LIV.LJf;
              if (paramj != null)
              {
                localObject1 = "Media localId " + paramj.fWh + " url " + paramj.Url + " thumb " + paramj.TDF + " duration " + paramj.UqC + " taskId " + paramj.taskId;
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
    Object localObject1 = (com.tencent.mm.cd.a)new ajd();
    Object localObject3 = paramc.field_baseItemData;
    try
    {
      ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (ajd)localObject1;
      if (localObject1 != null)
      {
        localObject3 = this.LIV;
        Object localObject4 = k.LJi;
        p.k(localObject4, "<set-?>");
        ((j)localObject3).LJe = ((k)localObject4);
        localObject3 = this.LIV;
        localObject4 = paramc.bsL();
        p.k(localObject4, "<set-?>");
        ((j)localObject3).taskId = ((String)localObject4);
        this.LIV.LJf.TDF = ((ajd)localObject1).thumbPath;
        this.LIV.LJf.Id = ("fake_" + ((ajd)localObject1).timeStamp);
        this.LIV.HGp = ((ajd)localObject1).HMI;
        if ((!u.agG(((ajd)localObject1).videoPath)) && (((ajd)localObject1).StE.size() == 0) && (((ajd)localObject1).StF == null))
        {
          localObject1 = com.tencent.mm.plugin.story.f.e.a.LJn;
          com.tencent.mm.plugin.story.f.e.a.aVJ(paramc.bsL());
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
      if (((ajd)localObject2).StE.size() > 0)
      {
        localObject2 = ((ajd)localObject2).StE.iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (!u.agG((String)((Iterator)localObject2).next()))
          {
            localObject2 = com.tencent.mm.plugin.story.f.e.a.LJn;
            com.tencent.mm.plugin.story.f.e.a.aVJ(paramc.bsL());
            AppMethodBeat.o(118927);
            return false;
          }
        }
      }
      this.LIV.LJg = paramc;
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
    if ((this.fXG == ((h)paramObject).fXG) && (p.h(this.LIV, ((h)paramObject).LIV)) && (p.h(this.LIW, ((h)paramObject).LIW)) && (this.LIX.gge().kQn == ((h)paramObject).LIX.gge().kQn))
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
    String str = "StoryGalleryItem(videoItem=" + this.LIV + ", comment=" + this.LIW + ')';
    AppMethodBeat.o(118928);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem$Companion;", "", "()V", "createStoryGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "extInfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "createStoryGalleryItemForSns", "plugin-story_release"})
  public static final class a
  {
    public static h a(f paramf)
    {
      AppMethodBeat.i(118921);
      p.k(paramf, "extInfo");
      com.tencent.mm.plugin.story.i.j localj = new com.tencent.mm.plugin.story.i.j();
      localj.field_storyID = paramf.field_syncId;
      localj.field_createTime = paramf.field_storyPostTime;
      localj.field_userName = paramf.getUserName();
      Object localObject1 = q.LGQ;
      localObject1 = q.a.gcR();
      ((eol)localObject1).UserName = paramf.getUserName();
      ((eol)localObject1).CreateTime = paramf.field_storyPostTime;
      Object localObject2 = q.LGQ;
      localObject2 = new enu();
      ((enu)localObject2).Id = ("empty_" + cm.bfD());
      ((enu)localObject2).TDF = paramf.aJi();
      ((enu)localObject2).Url = paramf.gfT();
      if (paramf.field_duration > 0L) {}
      for (float f = (float)(paramf.field_duration / 1000.0D);; f = 0.0F)
      {
        ((enu)localObject2).UqC = f;
        ((eol)localObject1).Ura.Sqr.add(localObject2);
        localj.c((eol)localObject1);
        paramf = new h(localj, (eol)localObject1);
        AppMethodBeat.o(118921);
        return paramf;
      }
    }
    
    public static h a(com.tencent.mm.plugin.story.i.j paramj, i parami)
    {
      AppMethodBeat.i(118919);
      p.k(paramj, "story");
      p.k(parami, "storyItemScene");
      paramj = new h(paramj, paramj.ggc(), parami);
      AppMethodBeat.o(118919);
      return paramj;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118922);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).createTime), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).createTime));
      AppMethodBeat.o(118922);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118923);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).createTime), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).createTime));
      AppMethodBeat.o(118923);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class d<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118924);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).createTime), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).createTime));
      AppMethodBeat.o(118924);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class e<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118925);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT1).createTime), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.f.b.a)paramT2).createTime));
      AppMethodBeat.o(118925);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.h
 * JD-Core Version:    0.7.0.1
 */