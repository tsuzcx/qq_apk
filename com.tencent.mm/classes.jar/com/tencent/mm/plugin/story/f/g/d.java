package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.g.b.a.fp;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.story.e.a.a;
import com.tencent.mm.plugin.story.e.b;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.m;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.i.a.d;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djk;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.protocal.protobuf.djm;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.v;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/upload/UploadPackHelper;", "", "()V", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyObj", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "timelineInfo", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "checkToCreateDir", "", "newVideoPath", "", "commit", "", "createStory", "", "taskId", "thumbPath", "path", "videoMd5", "setBlackUserList", "blackList", "", "setEditorData", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "setFavorite", "favorite", "setGroupUserList", "groupList", "setImageVideo", "isImageVideo", "setLocation", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setPublishObjId", "publishObjId", "setScope", "scope", "setSightExtInfo", "Companion", "plugin-story_release"})
public final class d
{
  public static final d.a AOr;
  private static final String TAG = "MicroMsg.StoryUploadPackHelper";
  private static final Pattern jrU;
  private com.tencent.mm.plugin.story.i.j ANZ;
  private djm AOo;
  private dkc AOp;
  private djs AOq;
  private bxm zSY;
  
  static
  {
    AppMethodBeat.i(119130);
    AOr = new d.a((byte)0);
    TAG = "MicroMsg.StoryUploadPackHelper";
    jrU = Pattern.compile("(\n){3,}");
    AppMethodBeat.o(119130);
  }
  
  public d()
  {
    AppMethodBeat.i(119129);
    this.ANZ = new com.tencent.mm.plugin.story.i.j();
    this.AOq = new djs();
    this.ANZ.setPostWaiting();
    Object localObject1 = this.ANZ;
    Object localObject2 = com.tencent.mm.plugin.story.i.a.ATp;
    int i = com.tencent.mm.plugin.story.i.a.ekx();
    localObject2 = com.tencent.mm.plugin.story.i.a.ATp;
    ((com.tencent.mm.plugin.story.i.j)localObject1).QJ(i | com.tencent.mm.plugin.story.i.a.ekz());
    localObject1 = this.ANZ;
    localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
    ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = j.b.dTJ();
    this.ANZ.field_createTime = cf.aCN();
    this.AOo = new djm();
    this.zSY = new bxm();
    localObject1 = this.AOo;
    localObject2 = new StringBuilder();
    Object localObject3 = com.tencent.mm.plugin.story.f.j.AKb;
    localObject2 = j.b.dTJ() + bt.HI() + cf.aCL();
    localObject3 = d.n.d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119129);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
    p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
    ((djm)localObject1).hCW = g.getMessageDigest((byte[])localObject2);
    localObject1 = q.AKs;
    this.AOp = q.a.ein();
    localObject1 = this.AOp;
    localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
    ((dkc)localObject1).nDo = j.b.dTJ();
    this.AOp.CreateTime = this.ANZ.field_createTime;
    this.AOq.Hyy = new SKBuiltinBuffer_t();
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
    localObject2 = com.tencent.mm.plugin.recordvideo.d.c.dGL().To();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    p.h(localObject1, "publishObjId");
    this.AOp.HyO = ((String)localObject1);
    ad.d(TAG, "storyInfo.createTime=%s timelineInfo.CreateTime=%s", new Object[] { Integer.valueOf(this.ANZ.field_createTime), Integer.valueOf(this.AOp.CreateTime) });
    AppMethodBeat.o(119129);
  }
  
  private static void azt(String paramString)
  {
    AppMethodBeat.i(119121);
    com.tencent.mm.vfs.i.aYg(com.tencent.mm.vfs.i.aYr(paramString));
    AppMethodBeat.o(119121);
  }
  
  public final void Sg(int paramInt)
  {
    this.AOp.HyP = paramInt;
  }
  
  public final void a(bxm parambxm)
  {
    AppMethodBeat.i(119125);
    p.h(parambxm, "extInfo");
    this.zSY = parambxm;
    AppMethodBeat.o(119125);
  }
  
  public final void a(djk paramdjk)
  {
    AppMethodBeat.i(119126);
    p.h(paramdjk, "editorInfo");
    this.AOo.Hys = paramdjk;
    AppMethodBeat.o(119126);
  }
  
  public final boolean aK(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(119127);
    p.h(paramString1, "path");
    p.h(paramString2, "thumbPath");
    p.h(paramString3, "videoMd5");
    paramString3 = q.AKs;
    paramString3 = new djl();
    Object localObject1 = new StringBuilder();
    Object localObject2 = b.AJd;
    localObject1 = ((StringBuilder)localObject1).append(b.ehs());
    localObject2 = cf.aCL() + '-' + bt.HI();
    Object localObject3 = d.n.d.UTF_8;
    if (localObject2 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119127);
      throw paramString1;
    }
    localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
    p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
    paramString3.Id = g.getMessageDigest((byte[])localObject2);
    localObject1 = com.tencent.mm.plugin.story.f.l.AKo;
    localObject1 = com.tencent.mm.plugin.story.f.l.aBH(paramString3.Id);
    localObject2 = com.tencent.mm.plugin.story.f.l.AKo;
    localObject2 = com.tencent.mm.plugin.story.f.l.aBG(paramString3.Id);
    localObject3 = com.tencent.mm.plugin.story.f.l.AKo;
    com.tencent.mm.plugin.story.f.l.awb((String)localObject1);
    localObject3 = com.tencent.mm.plugin.story.f.l.AKo;
    com.tencent.mm.plugin.story.f.l.awb((String)localObject2);
    azt((String)localObject1);
    azt((String)localObject2);
    com.tencent.mm.vfs.i.mz(paramString1, (String)localObject1);
    com.tencent.mm.vfs.i.mz(paramString2, (String)localObject2);
    paramString3.Hyq = (e.axx((String)localObject1).videoDuration / 1000.0F);
    this.AOp.HyN.GaQ.add(paramString3);
    AppMethodBeat.o(119127);
    return true;
  }
  
  public final d b(csd paramcsd)
  {
    if (paramcsd != null) {
      this.AOp.HyM = paramcsd;
    }
    return this;
  }
  
  public final int commit()
  {
    AppMethodBeat.i(119122);
    try
    {
      this.AOo.GTk = cf.aCN();
      this.AOo.hfV = 0;
      Object localObject1 = this.ANZ;
      Object localObject2 = this.AOo.toByteArray();
      p.g(localObject2, "postInfo.toByteArray()");
      ((com.tencent.mm.plugin.story.i.j)localObject1).bK((byte[])localObject2);
      this.ANZ.field_attrBuf = this.AOq.toByteArray();
      this.ANZ.b(this.AOp);
      localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
      int i = j.b.ehT().f(this.ANZ);
      localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
      localObject1 = j.b.ehZ();
      com.tencent.mm.ad.c.g((d.g.a.a)new c.e((c)localObject1, i));
      ((c)localObject1).checkPost();
      localObject1 = m.AKp;
      localObject1 = this.ANZ;
      p.h(localObject1, "storyInfo");
      if (i != -1)
      {
        localObject2 = com.tencent.mm.plugin.story.e.a.AIZ;
        String str = a.a.m(Integer.valueOf(((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime));
        ad.d(m.access$getTAG$cp(), "insertByLocalStory date=".concat(String.valueOf(str)));
        localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
        localObject2 = j.b.ehY().aCk(str);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new h();
        }
        p.h(str, "value");
        ((h)localObject1).field_date = str;
        ((h)localObject1).field_count += 1;
        ad.d(m.access$getTAG$cp(), "storyHistory.count=" + ((h)localObject1).field_count);
        localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
        j.b.ehY().a((h)localObject1);
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
  
  public final void gn(List<String> paramList)
  {
    AppMethodBeat.i(119123);
    p.h(paramList, "groupList");
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
          cwt localcwt = new cwt();
          localcwt.aPy(str);
          localLinkedList.add(localcwt);
          continue;
          i = 0;
          break;
        }
      }
      this.AOq.GroupUser.addAll((Collection)localLinkedList);
      this.AOq.GroupUserCount = localLinkedList.size();
    }
    AppMethodBeat.o(119123);
  }
  
  public final void go(List<String> paramList)
  {
    AppMethodBeat.i(119124);
    p.h(paramList, "blackList");
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
          cwt localcwt = new cwt();
          localcwt.aPy(str);
          localLinkedList.add(localcwt);
          continue;
          i = 0;
          break;
        }
      }
      this.AOq.BlackList.addAll((Collection)localLinkedList);
      this.AOq.BlackListCount = localLinkedList.size();
    }
    AppMethodBeat.o(119124);
  }
  
  public final boolean ke(String paramString1, String paramString2)
  {
    AppMethodBeat.i(119128);
    p.h(paramString1, "taskId");
    p.h(paramString2, "thumbPath");
    Object localObject1 = q.AKs;
    localObject1 = new djl();
    Object localObject2 = new StringBuilder();
    Object localObject3 = b.AJd;
    localObject2 = ((StringBuilder)localObject2).append(b.ehs());
    localObject3 = cf.aCL() + '-' + bt.HI();
    Charset localCharset = d.n.d.UTF_8;
    if (localObject3 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119128);
      throw paramString1;
    }
    localObject3 = ((String)localObject3).getBytes(localCharset);
    p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
    ((djl)localObject1).Id = g.getMessageDigest((byte[])localObject3);
    localObject2 = com.tencent.mm.plugin.story.f.l.AKo;
    localObject2 = com.tencent.mm.plugin.story.f.l.aBG(((djl)localObject1).Id);
    azt((String)localObject2);
    com.tencent.mm.vfs.i.mz(paramString2, (String)localObject2);
    ((djl)localObject1).taskId = paramString1;
    this.AOp.HyN.GaQ.add(localObject1);
    paramString1 = this.ANZ;
    int i = paramString1.field_localFlag;
    paramString2 = a.d.ATy;
    paramString1.field_localFlag = (i | a.d.elf());
    paramString1 = this.ANZ;
    i = paramString1.field_localFlag;
    paramString2 = a.d.ATy;
    paramString1.field_localFlag = (i & (a.d.eld() ^ 0xFFFFFFFF));
    AppMethodBeat.o(119128);
    return true;
  }
  
  public final void sm(boolean paramBoolean)
  {
    this.AOo.Hyu = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.d
 * JD-Core Version:    0.7.0.1
 */