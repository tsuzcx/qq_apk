package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.g.b.a.fr;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.story.e.a.a;
import com.tencent.mm.plugin.story.e.b;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.m;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.i.a.d;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.i;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.dkf;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.dkn;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.v;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/upload/UploadPackHelper;", "", "()V", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyObj", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "timelineInfo", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "checkToCreateDir", "", "newVideoPath", "", "commit", "", "createStory", "", "taskId", "thumbPath", "path", "videoMd5", "setBlackUserList", "blackList", "", "setEditorData", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "setFavorite", "favorite", "setGroupUserList", "groupList", "setImageVideo", "isImageVideo", "setLocation", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setPublishObjId", "publishObjId", "setScope", "scope", "setSightExtInfo", "Companion", "plugin-story_release"})
public final class d
{
  public static final d.a BfS;
  private static final String TAG = "MicroMsg.StoryUploadPackHelper";
  private static final Pattern juN;
  private byg Akf;
  private com.tencent.mm.plugin.story.i.j BfA;
  private dkh BfP;
  private dkx BfQ;
  private dkn BfR;
  
  static
  {
    AppMethodBeat.i(119130);
    BfS = new d.a((byte)0);
    TAG = "MicroMsg.StoryUploadPackHelper";
    juN = Pattern.compile("(\n){3,}");
    AppMethodBeat.o(119130);
  }
  
  public d()
  {
    AppMethodBeat.i(119129);
    this.BfA = new com.tencent.mm.plugin.story.i.j();
    this.BfR = new dkn();
    this.BfA.setPostWaiting();
    Object localObject1 = this.BfA;
    Object localObject2 = com.tencent.mm.plugin.story.i.a.BkN;
    int i = com.tencent.mm.plugin.story.i.a.eog();
    localObject2 = com.tencent.mm.plugin.story.i.a.BkN;
    ((com.tencent.mm.plugin.story.i.j)localObject1).Rq(i | com.tencent.mm.plugin.story.i.a.eoi());
    localObject1 = this.BfA;
    localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
    ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = j.b.dXj();
    this.BfA.field_createTime = ch.aDd();
    this.BfP = new dkh();
    this.Akf = new byg();
    localObject1 = this.BfP;
    localObject2 = new StringBuilder();
    Object localObject3 = com.tencent.mm.plugin.story.f.j.BbE;
    localObject2 = j.b.dXj() + bu.HQ() + ch.aDb();
    localObject3 = d.n.d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119129);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
    p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
    ((dkh)localObject1).hFO = g.getMessageDigest((byte[])localObject2);
    localObject1 = q.BbV;
    this.BfQ = q.a.elV();
    localObject1 = this.BfQ;
    localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
    ((dkx)localObject1).nIJ = j.b.dXj();
    this.BfQ.CreateTime = this.BfA.field_createTime;
    this.BfR.HSj = new SKBuiltinBuffer_t();
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
    localObject2 = com.tencent.mm.plugin.recordvideo.d.c.dKc().Tu();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    p.h(localObject1, "publishObjId");
    this.BfQ.HSz = ((String)localObject1);
    ae.d(TAG, "storyInfo.createTime=%s timelineInfo.CreateTime=%s", new Object[] { Integer.valueOf(this.BfA.field_createTime), Integer.valueOf(this.BfQ.CreateTime) });
    AppMethodBeat.o(119129);
  }
  
  private static void aAK(String paramString)
  {
    AppMethodBeat.i(119121);
    o.aZI(o.aZU(paramString));
    AppMethodBeat.o(119121);
  }
  
  public final void SN(int paramInt)
  {
    this.BfQ.HSA = paramInt;
  }
  
  public final void a(byg parambyg)
  {
    AppMethodBeat.i(119125);
    p.h(parambyg, "extInfo");
    this.Akf = parambyg;
    AppMethodBeat.o(119125);
  }
  
  public final void a(dkf paramdkf)
  {
    AppMethodBeat.i(119126);
    p.h(paramdkf, "editorInfo");
    this.BfP.HSd = paramdkf;
    AppMethodBeat.o(119126);
  }
  
  public final boolean aK(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(119127);
    p.h(paramString1, "path");
    p.h(paramString2, "thumbPath");
    p.h(paramString3, "videoMd5");
    paramString3 = q.BbV;
    paramString3 = new dkg();
    Object localObject1 = new StringBuilder();
    Object localObject2 = b.BaG;
    localObject1 = ((StringBuilder)localObject1).append(b.ela());
    localObject2 = ch.aDb() + '-' + bu.HQ();
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
    localObject1 = com.tencent.mm.plugin.story.f.l.BbR;
    localObject1 = com.tencent.mm.plugin.story.f.l.aDa(paramString3.Id);
    localObject2 = com.tencent.mm.plugin.story.f.l.BbR;
    localObject2 = com.tencent.mm.plugin.story.f.l.aCZ(paramString3.Id);
    localObject3 = com.tencent.mm.plugin.story.f.l.BbR;
    com.tencent.mm.plugin.story.f.l.axq((String)localObject1);
    localObject3 = com.tencent.mm.plugin.story.f.l.BbR;
    com.tencent.mm.plugin.story.f.l.axq((String)localObject2);
    aAK((String)localObject1);
    aAK((String)localObject2);
    o.mF(paramString1, (String)localObject1);
    o.mF(paramString2, (String)localObject2);
    paramString3.HSb = (e.ayN((String)localObject1).videoDuration / 1000.0F);
    this.BfQ.HSy.Gtx.add(paramString3);
    AppMethodBeat.o(119127);
    return true;
  }
  
  public final d b(csx paramcsx)
  {
    if (paramcsx != null) {
      this.BfQ.HSx = paramcsx;
    }
    return this;
  }
  
  public final int commit()
  {
    AppMethodBeat.i(119122);
    try
    {
      this.BfP.HmL = ch.aDd();
      this.BfP.hiJ = 0;
      Object localObject1 = this.BfA;
      Object localObject2 = this.BfP.toByteArray();
      p.g(localObject2, "postInfo.toByteArray()");
      ((com.tencent.mm.plugin.story.i.j)localObject1).bN((byte[])localObject2);
      this.BfA.field_attrBuf = this.BfR.toByteArray();
      this.BfA.b(this.BfQ);
      localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
      int i = j.b.elB().f(this.BfA);
      localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
      localObject1 = j.b.elH();
      com.tencent.mm.ac.c.h((d.g.a.a)new c.e((c)localObject1, i));
      ((c)localObject1).checkPost();
      localObject1 = m.BbS;
      localObject1 = this.BfA;
      p.h(localObject1, "storyInfo");
      if (i != -1)
      {
        localObject2 = com.tencent.mm.plugin.story.e.a.BaC;
        String str = a.a.n(Integer.valueOf(((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime));
        ae.d(m.access$getTAG$cp(), "insertByLocalStory date=".concat(String.valueOf(str)));
        localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
        localObject2 = j.b.elG().aDD(str);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new h();
        }
        p.h(str, "value");
        ((h)localObject1).field_date = str;
        ((h)localObject1).field_count += 1;
        ae.d(m.access$getTAG$cp(), "storyHistory.count=" + ((h)localObject1).field_count);
        localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
        j.b.elG().a((h)localObject1);
      }
      ae.d(TAG, "save story to db: ".concat(String.valueOf(i)));
      AppMethodBeat.o(119122);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
      }
    }
  }
  
  public final void gw(List<String> paramList)
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
          cxn localcxn = new cxn();
          localcxn.aQV(str);
          localLinkedList.add(localcxn);
          continue;
          i = 0;
          break;
        }
      }
      this.BfR.GroupUser.addAll((Collection)localLinkedList);
      this.BfR.GroupUserCount = localLinkedList.size();
    }
    AppMethodBeat.o(119123);
  }
  
  public final void gx(List<String> paramList)
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
          cxn localcxn = new cxn();
          localcxn.aQV(str);
          localLinkedList.add(localcxn);
          continue;
          i = 0;
          break;
        }
      }
      this.BfR.BlackList.addAll((Collection)localLinkedList);
      this.BfR.BlackListCount = localLinkedList.size();
    }
    AppMethodBeat.o(119124);
  }
  
  public final boolean kl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(119128);
    p.h(paramString1, "taskId");
    p.h(paramString2, "thumbPath");
    Object localObject1 = q.BbV;
    localObject1 = new dkg();
    Object localObject2 = new StringBuilder();
    Object localObject3 = b.BaG;
    localObject2 = ((StringBuilder)localObject2).append(b.ela());
    localObject3 = ch.aDb() + '-' + bu.HQ();
    Charset localCharset = d.n.d.UTF_8;
    if (localObject3 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119128);
      throw paramString1;
    }
    localObject3 = ((String)localObject3).getBytes(localCharset);
    p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
    ((dkg)localObject1).Id = g.getMessageDigest((byte[])localObject3);
    localObject2 = com.tencent.mm.plugin.story.f.l.BbR;
    localObject2 = com.tencent.mm.plugin.story.f.l.aCZ(((dkg)localObject1).Id);
    aAK((String)localObject2);
    o.mF(paramString2, (String)localObject2);
    ((dkg)localObject1).taskId = paramString1;
    this.BfQ.HSy.Gtx.add(localObject1);
    paramString1 = this.BfA;
    int i = paramString1.field_localFlag;
    paramString2 = a.d.BkW;
    paramString1.field_localFlag = (i | a.d.eoO());
    paramString1 = this.BfA;
    i = paramString1.field_localFlag;
    paramString2 = a.d.BkW;
    paramString1.field_localFlag = (i & (a.d.eoM() ^ 0xFFFFFFFF));
    AppMethodBeat.o(119128);
    return true;
  }
  
  public final void st(boolean paramBoolean)
  {
    this.BfP.HSf = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.d
 * JD-Core Version:    0.7.0.1
 */