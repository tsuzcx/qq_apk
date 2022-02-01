package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.story.e.a.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.m;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.i.a.d;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.v;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/upload/UploadPackHelper;", "", "()V", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyObj", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "timelineInfo", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "checkToCreateDir", "", "newVideoPath", "", "commit", "", "createStory", "", "taskId", "thumbPath", "path", "videoMd5", "setBlackUserList", "blackList", "", "setEditorData", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "setFavorite", "favorite", "setGroupUserList", "groupList", "setImageVideo", "isImageVideo", "setLocation", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setPublishObjId", "publishObjId", "setScope", "scope", "setSightExtInfo", "Companion", "plugin-story_release"})
public final class d
{
  private static final String TAG = "MicroMsg.StoryUploadPackHelper";
  private static final Pattern iyI;
  public static final a yjw;
  private boj xoN;
  private com.tencent.mm.plugin.story.i.j yje;
  private cyn yjt;
  private czd yju;
  private cyt yjv;
  
  static
  {
    AppMethodBeat.i(119130);
    yjw = new a((byte)0);
    TAG = "MicroMsg.StoryUploadPackHelper";
    iyI = Pattern.compile("(\n){3,}");
    AppMethodBeat.o(119130);
  }
  
  public d()
  {
    AppMethodBeat.i(119129);
    this.yje = new com.tencent.mm.plugin.story.i.j();
    this.yjv = new cyt();
    this.yje.setPostWaiting();
    Object localObject1 = this.yje;
    Object localObject2 = com.tencent.mm.plugin.story.i.a.yor;
    int i = com.tencent.mm.plugin.story.i.a.dJH();
    localObject2 = com.tencent.mm.plugin.story.i.a.yor;
    ((com.tencent.mm.plugin.story.i.j)localObject1).MY(i | com.tencent.mm.plugin.story.i.a.dJJ());
    localObject1 = this.yje;
    localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
    ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = j.b.dta();
    this.yje.field_createTime = ce.asT();
    this.yjt = new cyn();
    this.xoN = new boj();
    localObject1 = this.yjt;
    localObject2 = new StringBuilder();
    Object localObject3 = com.tencent.mm.plugin.story.f.j.yfh;
    localObject2 = j.b.dta() + bt.GC() + ce.asR();
    localObject3 = d.n.d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119129);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
    d.g.b.k.g(localObject2, "(this as java.lang.String).getBytes(charset)");
    ((cyn)localObject1).gKn = g.getMessageDigest((byte[])localObject2);
    localObject1 = q.yfy;
    this.yju = q.a.dHx();
    localObject1 = this.yju;
    localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
    ((czd)localObject1).mAQ = j.b.dta();
    this.yju.CreateTime = this.yje.field_createTime;
    this.yjv.EqL = new SKBuiltinBuffer_t();
    localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    localObject2 = com.tencent.mm.plugin.recordvideo.d.b.diy().QF();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    d.g.b.k.h(localObject1, "publishObjId");
    this.yju.Erb = ((String)localObject1);
    ad.d(TAG, "storyInfo.createTime=%s timelineInfo.CreateTime=%s", new Object[] { Integer.valueOf(this.yje.field_createTime), Integer.valueOf(this.yju.CreateTime) });
    AppMethodBeat.o(119129);
  }
  
  private static void apc(String paramString)
  {
    AppMethodBeat.i(119121);
    com.tencent.mm.vfs.i.aMF(com.tencent.mm.vfs.i.aMQ(paramString));
    AppMethodBeat.o(119121);
  }
  
  public final void Or(int paramInt)
  {
    this.yju.Erc = paramInt;
  }
  
  public final void a(boj paramboj)
  {
    AppMethodBeat.i(119125);
    d.g.b.k.h(paramboj, "extInfo");
    this.xoN = paramboj;
    AppMethodBeat.o(119125);
  }
  
  public final void a(cyl paramcyl)
  {
    AppMethodBeat.i(119126);
    d.g.b.k.h(paramcyl, "editorInfo");
    this.yjt.EqF = paramcyl;
    AppMethodBeat.o(119126);
  }
  
  public final boolean aB(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(119127);
    d.g.b.k.h(paramString1, "path");
    d.g.b.k.h(paramString2, "thumbPath");
    d.g.b.k.h(paramString3, "videoMd5");
    paramString3 = q.yfy;
    paramString3 = new cym();
    Object localObject1 = new StringBuilder();
    Object localObject2 = com.tencent.mm.plugin.story.e.b.yej;
    localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.story.e.b.dGC());
    localObject2 = ce.asR() + '-' + bt.GC();
    Object localObject3 = d.n.d.UTF_8;
    if (localObject2 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119127);
      throw paramString1;
    }
    localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
    d.g.b.k.g(localObject2, "(this as java.lang.String).getBytes(charset)");
    paramString3.Id = g.getMessageDigest((byte[])localObject2);
    localObject1 = com.tencent.mm.plugin.story.f.l.yfu;
    localObject1 = com.tencent.mm.plugin.story.f.l.art(paramString3.Id);
    localObject2 = com.tencent.mm.plugin.story.f.l.yfu;
    localObject2 = com.tencent.mm.plugin.story.f.l.ars(paramString3.Id);
    localObject3 = com.tencent.mm.plugin.story.f.l.yfu;
    com.tencent.mm.plugin.story.f.l.alY((String)localObject1);
    localObject3 = com.tencent.mm.plugin.story.f.l.yfu;
    com.tencent.mm.plugin.story.f.l.alY((String)localObject2);
    apc((String)localObject1);
    apc((String)localObject2);
    com.tencent.mm.vfs.i.lC(paramString1, (String)localObject1);
    com.tencent.mm.vfs.i.lC(paramString2, (String)localObject2);
    paramString3.EqD = (e.ano((String)localObject1).videoDuration / 1000.0F);
    this.yju.Era.DaC.add(paramString3);
    AppMethodBeat.o(119127);
    return true;
  }
  
  public final d b(chx paramchx)
  {
    if (paramchx != null) {
      this.yju.EqZ = paramchx;
    }
    return this;
  }
  
  public final int commit()
  {
    AppMethodBeat.i(119122);
    try
    {
      this.yjt.DNs = ce.asT();
      this.yjt.gll = 0;
      Object localObject1 = this.yje;
      Object localObject2 = this.yjt.toByteArray();
      d.g.b.k.g(localObject2, "postInfo.toByteArray()");
      ((com.tencent.mm.plugin.story.i.j)localObject1).bE((byte[])localObject2);
      this.yje.field_attrBuf = this.yjv.toByteArray();
      this.yje.b(this.yju);
      localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
      int i = j.b.dHd().f(this.yje);
      localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
      localObject1 = j.b.dHj();
      com.tencent.mm.ad.c.g((d.g.a.a)new c.e((c)localObject1, i));
      ((c)localObject1).checkPost();
      localObject1 = m.yfv;
      localObject1 = this.yje;
      d.g.b.k.h(localObject1, "storyInfo");
      if (i != -1)
      {
        localObject2 = com.tencent.mm.plugin.story.e.a.yef;
        String str = a.a.k(Integer.valueOf(((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime));
        ad.d(m.access$getTAG$cp(), "insertByLocalStory date=".concat(String.valueOf(str)));
        localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
        localObject2 = j.b.dHi().arX(str);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new h();
        }
        d.g.b.k.h(str, "value");
        ((h)localObject1).field_date = str;
        ((h)localObject1).field_count += 1;
        ad.d(m.access$getTAG$cp(), "storyHistory.count=" + ((h)localObject1).field_count);
        localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
        j.b.dHi().a((h)localObject1);
      }
      ad.d(TAG, "save story to db: ".concat(String.valueOf(i)));
      AppMethodBeat.o(119122);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
      }
    }
  }
  
  public final void fU(List<String> paramList)
  {
    AppMethodBeat.i(119123);
    d.g.b.k.h(paramList, "groupList");
    int i;
    if (((Collection)paramList).isEmpty()) {
      i = 1;
    }
    while (i == 0)
    {
      LinkedList localLinkedList = new LinkedList();
      paramList = ((Iterable)paramList).iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          String str = (String)paramList.next();
          cmf localcmf = new cmf();
          localcmf.aEE(str);
          localLinkedList.add(localcmf);
          continue;
          i = 0;
          break;
        }
      }
      this.yjv.GroupUser.addAll((Collection)localLinkedList);
      this.yjv.GroupUserCount = localLinkedList.size();
    }
    AppMethodBeat.o(119123);
  }
  
  public final void fV(List<String> paramList)
  {
    AppMethodBeat.i(119124);
    d.g.b.k.h(paramList, "blackList");
    int i;
    if (((Collection)paramList).isEmpty()) {
      i = 1;
    }
    while (i == 0)
    {
      LinkedList localLinkedList = new LinkedList();
      paramList = ((Iterable)paramList).iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          String str = (String)paramList.next();
          cmf localcmf = new cmf();
          localcmf.aEE(str);
          localLinkedList.add(localcmf);
          continue;
          i = 0;
          break;
        }
      }
      this.yjv.BlackList.addAll((Collection)localLinkedList);
      this.yjv.BlackListCount = localLinkedList.size();
    }
    AppMethodBeat.o(119124);
  }
  
  public final boolean jr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(119128);
    d.g.b.k.h(paramString1, "taskId");
    d.g.b.k.h(paramString2, "thumbPath");
    Object localObject1 = q.yfy;
    localObject1 = new cym();
    Object localObject2 = new StringBuilder();
    Object localObject3 = com.tencent.mm.plugin.story.e.b.yej;
    localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.story.e.b.dGC());
    localObject3 = ce.asR() + '-' + bt.GC();
    Charset localCharset = d.n.d.UTF_8;
    if (localObject3 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119128);
      throw paramString1;
    }
    localObject3 = ((String)localObject3).getBytes(localCharset);
    d.g.b.k.g(localObject3, "(this as java.lang.String).getBytes(charset)");
    ((cym)localObject1).Id = g.getMessageDigest((byte[])localObject3);
    localObject2 = com.tencent.mm.plugin.story.f.l.yfu;
    localObject2 = com.tencent.mm.plugin.story.f.l.ars(((cym)localObject1).Id);
    apc((String)localObject2);
    com.tencent.mm.vfs.i.lC(paramString2, (String)localObject2);
    ((cym)localObject1).taskId = paramString1;
    this.yju.Era.DaC.add(localObject1);
    paramString1 = this.yje;
    int i = paramString1.field_localFlag;
    paramString2 = a.d.yoA;
    paramString1.field_localFlag = (i | a.d.dKp());
    paramString1 = this.yje;
    i = paramString1.field_localFlag;
    paramString2 = a.d.yoA;
    paramString1.field_localFlag = (i & (a.d.dKn() ^ 0xFFFFFFFF));
    AppMethodBeat.o(119128);
    return true;
  }
  
  public final void qI(boolean paramBoolean)
  {
    this.yjt.EqH = paramBoolean;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/upload/UploadPackHelper$Companion;", "", "()V", "PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getPATTERN", "()Ljava/util/regex/Pattern;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.d
 * JD-Core Version:    0.7.0.1
 */