package com.tencent.mm.plugin.story.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.p.a;
import com.tencent.mm.plugin.story.model.r;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.fie;
import com.tencent.mm.protocal.protobuf.fij;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.protocal.protobuf.fit;
import com.tencent.mm.protocal.protobuf.fiz;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyTImeline", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;)V", "TAG", "", "comment", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getComment", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyId", "", "getStoryId", "()J", "getStoryItemScene", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "getStoryTImeline", "()Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "convertFromFakeDB", "", "videoEditData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "convertFromStoryInfo", "equals", "other", "toString", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final a Smn;
  public final com.tencent.mm.plugin.story.h.j Smo;
  private final fjj Smp;
  public final i Smq;
  public final j Smr;
  public final g Sms;
  private final String TAG;
  public final long idH;
  public String userName;
  
  static
  {
    AppMethodBeat.i(118932);
    Smn = new a((byte)0);
    AppMethodBeat.o(118932);
  }
  
  public h(com.tencent.mm.plugin.story.h.j paramj, fjj paramfjj, i parami)
  {
    AppMethodBeat.i(118930);
    this.Smo = paramj;
    this.Smp = paramfjj;
    this.Smq = parami;
    this.TAG = "MicroMsg.StoryGalleryItem";
    this.idH = this.Smo.field_storyID;
    int i = (int)this.Smo.systemRowid;
    long l = this.Smo.field_storyID;
    int j = this.Smo.field_createTime;
    paramfjj = this.Smo.field_userName;
    paramj = paramfjj;
    if (paramfjj == null) {
      paramj = "";
    }
    paramj = new j(i, l, j, paramj);
    paramfjj = this.Smp;
    if (paramfjj.abJZ.Zpr.size() > 0)
    {
      parami = paramfjj.abJZ.Zpr.get(0);
      s.s(parami, "timeline.ContentObj.MediaObjList[0]");
      parami = (fis)parami;
      s.u(parami, "<set-?>");
      paramj.Smx = parami;
    }
    paramj.NDO = paramfjj.abJY;
    paramfjj = ah.aiuX;
    this.Smr = paramj;
    this.Sms = new g();
    a(this.Smo);
    AppMethodBeat.o(118930);
  }
  
  private final boolean a(com.tencent.mm.plugin.story.h.j paramj)
  {
    int k = 0;
    AppMethodBeat.i(118926);
    Object localObject3 = new fiz();
    try
    {
      ((fiz)localObject3).parseFrom(paramj.field_attrBuf);
      Object localObject4 = this.Sms;
      Object localObject2 = paramj.field_userName;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = StoryCore.SjP;
        localObject1 = StoryCore.b.hgg();
      }
      s.u(localObject1, "<set-?>");
      ((g)localObject4).SlC = ((String)localObject1);
      this.Sms.idH = paramj.field_storyID;
      this.Sms.Rph = 0;
      this.Sms.Smk = paramj.hzs();
      localObject1 = StoryCore.SjP;
      localObject1 = StoryCore.b.hvU().vZ(paramj.field_storyID);
      if ((localObject1 == null) || (((com.tencent.mm.plugin.story.h.c)localObject1).field_readCommentTime == 0)) {}
      boolean bool1;
      Object localObject5;
      StoryCore.b localb;
      for (int j = 1;; j = 0)
      {
        localObject2 = ((fiz)localObject3).abJL.iterator();
        bool1 = false;
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (fie)((Iterator)localObject2).next();
          s.s(localObject4, "commentDetail");
          localObject4 = new com.tencent.mm.plugin.story.model.b.a((fie)localObject4);
          if ((localObject1 == null) || (((com.tencent.mm.plugin.story.h.c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.model.b.a)localObject4).createTime <= ((com.tencent.mm.plugin.story.h.c)localObject1).field_readCommentTime)) {
            break label1220;
          }
          localObject5 = ((com.tencent.mm.plugin.story.model.b.a)localObject4).hQQ;
          localb = StoryCore.SjP;
          if (Util.isEqual((String)localObject5, StoryCore.b.hgg())) {
            break label1220;
          }
          ((com.tencent.mm.plugin.story.model.b.a)localObject4).Sly = true;
          bool1 = true;
          this.Sms.commentList.add(localObject4);
          this.Sms.PmC.add(localObject4);
          ((com.tencent.mm.plugin.story.model.b.a)localObject4).bbU(this.Sms.SlC);
          ((com.tencent.mm.plugin.story.model.b.a)localObject4).SlE = paramj.hzy();
        }
      }
      localObject2 = ((fiz)localObject3).abJN.iterator();
      int i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (fie)((Iterator)localObject2).next();
        s.s(localObject4, "bubleDetail");
        localObject4 = new com.tencent.mm.plugin.story.model.b.a((fie)localObject4);
        if ((localObject1 == null) || (((com.tencent.mm.plugin.story.h.c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.model.b.a)localObject4).createTime <= ((com.tencent.mm.plugin.story.h.c)localObject1).field_readCommentTime)) {
          break label1217;
        }
        localObject5 = ((com.tencent.mm.plugin.story.model.b.a)localObject4).hQQ;
        localb = StoryCore.SjP;
        if (Util.isEqual((String)localObject5, StoryCore.b.hgg())) {
          break label1217;
        }
        ((com.tencent.mm.plugin.story.model.b.a)localObject4).Sly = true;
        i = 1;
        this.Sms.commentList.add(localObject4);
        this.Sms.Sml.add(localObject4);
        ((com.tencent.mm.plugin.story.model.b.a)localObject4).bbU(this.Sms.SlC);
        ((com.tencent.mm.plugin.story.model.b.a)localObject4).SlE = paramj.hzy();
      }
      localObject2 = ((fiz)localObject3).abJR.iterator();
      boolean bool2 = false;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (fie)((Iterator)localObject2).next();
        s.s(localObject3, "visitorDetail");
        localObject3 = new com.tencent.mm.plugin.story.model.b.a((fie)localObject3);
        if ((localObject1 == null) || (((com.tencent.mm.plugin.story.h.c)localObject1).field_readCommentTime <= 0) || (((com.tencent.mm.plugin.story.model.b.a)localObject3).createTime <= ((com.tencent.mm.plugin.story.h.c)localObject1).field_readCommentTime)) {
          break label1214;
        }
        localObject4 = ((com.tencent.mm.plugin.story.model.b.a)localObject3).hQQ;
        localObject5 = StoryCore.SjP;
        if (Util.isEqual((String)localObject4, StoryCore.b.hgg())) {
          break label1214;
        }
        ((com.tencent.mm.plugin.story.model.b.a)localObject3).Sly = true;
        bool2 = true;
        this.Sms.Smm.add(localObject3);
        ((com.tencent.mm.plugin.story.model.b.a)localObject3).bbU(this.Sms.SlC);
        ((com.tencent.mm.plugin.story.model.b.a)localObject3).SlE = paramj.hzy();
      }
      localObject1 = (List)this.Sms.commentList;
      if (((List)localObject1).size() > 1) {
        kotlin.a.p.a((List)localObject1, (Comparator)new b());
      }
      localObject1 = (List)this.Sms.PmC;
      if (((List)localObject1).size() > 1) {
        kotlin.a.p.a((List)localObject1, (Comparator)new c());
      }
      localObject1 = (List)this.Sms.Sml;
      if (((List)localObject1).size() > 1) {
        kotlin.a.p.a((List)localObject1, (Comparator)new d());
      }
      localObject1 = (List)this.Sms.Smm;
      if (((List)localObject1).size() > 1) {
        kotlin.a.p.a((List)localObject1, (Comparator)new e());
      }
      if ((j != 0) && (this.Sms.commentList.size() > 0))
      {
        localObject1 = com.tencent.mm.plugin.story.model.b.b.SlF;
        long l = this.idH;
        localObject1 = this.Sms.commentList.get(0);
        s.s(localObject1, "comment.commentList[0]");
        com.tencent.mm.plugin.story.model.b.b.a(l, (com.tencent.mm.plugin.story.model.b.a)localObject1);
      }
      localObject1 = this.Sms;
      boolean bool3;
      if ((i != 0) || (bool1))
      {
        bool3 = true;
        ((g)localObject1).Sly = bool3;
        this.Sms.Smi = bool2;
        this.Sms.Smj = bool1;
        if (paramj != null) {
          break label1107;
        }
        localObject1 = null;
        label871:
        this.userName = ((String)localObject1);
        localObject1 = r.Slb;
        localObject3 = this.Smr.Smx;
        localObject2 = paramj.field_userName;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        if (!y.ZC(r.a((fis)localObject3, (String)localObject1)))
        {
          localObject1 = r.Slb;
          if (!y.ZC(r.a(this.Smr.Smx))) {
            break label1116;
          }
        }
        i = 1;
        label946:
        if (i == 0)
        {
          localObject1 = (CharSequence)this.Smr.Smx.taskId;
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
            localObject1 = com.tencent.mm.plugin.story.model.e.a.SmE;
            localObject2 = com.tencent.mm.plugin.story.model.e.a.and((int)paramj.systemRowid);
            if (localObject2 != null)
            {
              localObject3 = this.TAG;
              localObject4 = new StringBuilder("find fake video ").append(this.Smr).append(" media ");
              paramj = com.tencent.mm.plugin.story.e.b.Sjl;
              paramj = this.Smr.Smx;
              if (paramj != null) {
                break label1121;
              }
              paramj = "";
            }
          }
        }
      }
      for (;;)
      {
        Log.i((String)localObject3, paramj);
        c((com.tencent.mm.plugin.recordvideo.background.c)localObject2);
        Log.i(this.TAG, s.X("LogStory: ", this));
        AppMethodBeat.o(118926);
        return true;
        bool3 = false;
        break;
        label1107:
        localObject1 = paramj.field_userName;
        break label871;
        label1116:
        i = 0;
        break label946;
        label1121:
        localObject1 = "Media localId " + paramj.icg + " url " + paramj.Url + " thumb " + paramj.aaTl + " duration " + paramj.abJB + " taskId " + paramj.taskId;
        paramj = (com.tencent.mm.plugin.story.h.j)localObject1;
        if (localObject1 == null) {
          paramj = "";
        }
      }
    }
    catch (Exception localException)
    {
      label1214:
      label1217:
      label1220:
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
    Object localObject1 = (com.tencent.mm.bx.a)new ami();
    Object localObject3 = paramc.field_baseItemData;
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (ami)localObject1;
      if (localObject1 != null)
      {
        localObject3 = this.Smr;
        Object localObject4 = k.SmA;
        s.u(localObject4, "<set-?>");
        ((j)localObject3).Smw = ((k)localObject4);
        localObject3 = this.Smr;
        localObject4 = paramc.bQs();
        s.u(localObject4, "<set-?>");
        ((j)localObject3).taskId = ((String)localObject4);
        this.Smr.Smx.aaTl = ((ami)localObject1).thumbPath;
        this.Smr.Smx.Id = s.X("fake_", Long.valueOf(((ami)localObject1).timeStamp));
        this.Smr.NDO = ((ami)localObject1).NJF;
        if ((!y.ZC(((ami)localObject1).videoPath)) && (((ami)localObject1).Zto.size() == 0) && (((ami)localObject1).Ztp == null))
        {
          localObject1 = com.tencent.mm.plugin.story.model.e.a.SmE;
          com.tencent.mm.plugin.story.model.e.a.aSR(paramc.bQs());
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
      if (((ami)localObject2).Zto.size() > 0)
      {
        localObject2 = ((ami)localObject2).Zto.iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (!y.ZC((String)((Iterator)localObject2).next()))
          {
            localObject2 = com.tencent.mm.plugin.story.model.e.a.SmE;
            com.tencent.mm.plugin.story.model.e.a.aSR(paramc.bQs());
            AppMethodBeat.o(118927);
            return false;
          }
        }
      }
      this.Smr.Smy = paramc;
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
    if (this == paramObject)
    {
      AppMethodBeat.o(118929);
      return true;
    }
    if ((this.idH == ((h)paramObject).idH) && (s.p(this.Smr, ((h)paramObject).Smr)) && (s.p(this.Sms, ((h)paramObject).Sms)) && (this.Smo.hzv().nrQ == ((h)paramObject).Smo.hzv().nrQ))
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
    String str = "StoryGalleryItem(videoItem=" + this.Smr + ", comment=" + this.Sms + ')';
    AppMethodBeat.o(118928);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem$Companion;", "", "()V", "createStoryGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "extInfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "createStoryGalleryItemForSns", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static h a(f paramf)
    {
      AppMethodBeat.i(118921);
      s.u(paramf, "extInfo");
      com.tencent.mm.plugin.story.h.j localj = new com.tencent.mm.plugin.story.h.j();
      localj.field_storyID = paramf.field_syncId;
      localj.field_createTime = paramf.field_storyPostTime;
      localj.field_userName = paramf.getUserName();
      Object localObject1 = com.tencent.mm.plugin.story.model.p.Sku;
      localObject1 = p.a.hwl();
      ((fjj)localObject1).UserName = paramf.getUserName();
      ((fjj)localObject1).CreateTime = paramf.field_storyPostTime;
      Object localObject2 = com.tencent.mm.plugin.story.model.p.Sku;
      localObject2 = new fis();
      ((fis)localObject2).Id = s.X("empty_", Long.valueOf(cn.bDv()));
      ((fis)localObject2).aaTl = paramf.eCi();
      ((fis)localObject2).Url = paramf.hzk();
      if (paramf.field_duration > 0L) {}
      for (float f = (float)(paramf.field_duration / 1000.0D);; f = 0.0F)
      {
        ((fis)localObject2).abJB = f;
        ((fjj)localObject1).abJZ.Zpr.add(localObject2);
        localj.c((fjj)localObject1);
        paramf = new h(localj, (fjj)localObject1);
        AppMethodBeat.o(118921);
        return paramf;
      }
    }
    
    public static h a(com.tencent.mm.plugin.story.h.j paramj, i parami)
    {
      AppMethodBeat.i(118919);
      s.u(paramj, "story");
      s.u(parami, "storyItemScene");
      paramj = new h(paramj, paramj.hzt(), parami);
      AppMethodBeat.o(118919);
      return paramj;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 5, 1})
  public static final class b<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118922);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.model.b.a)paramT1).createTime), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.model.b.a)paramT2).createTime));
      AppMethodBeat.o(118922);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 5, 1})
  public static final class c<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118923);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.model.b.a)paramT1).createTime), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.model.b.a)paramT2).createTime));
      AppMethodBeat.o(118923);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 5, 1})
  public static final class d<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118924);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.model.b.a)paramT1).createTime), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.model.b.a)paramT2).createTime));
      AppMethodBeat.o(118924);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 5, 1})
  public static final class e<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118925);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.model.b.a)paramT1).createTime), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.model.b.a)paramT2).createTime));
      AppMethodBeat.o(118925);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.d.h
 * JD-Core Version:    0.7.0.1
 */