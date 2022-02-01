package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.story.e.a.a;
import com.tencent.mm.plugin.story.e.b;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.m;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.i.a.d;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.ddp;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.protocal.protobuf.def;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.v;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/upload/UploadPackHelper;", "", "()V", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyObj", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "timelineInfo", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "checkToCreateDir", "", "newVideoPath", "", "commit", "", "createStory", "", "taskId", "thumbPath", "path", "videoMd5", "setBlackUserList", "blackList", "", "setEditorData", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "setFavorite", "favorite", "setGroupUserList", "groupList", "setImageVideo", "isImageVideo", "setLocation", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setPublishObjId", "publishObjId", "setScope", "scope", "setSightExtInfo", "Companion", "plugin-story_release"})
public final class d
{
  private static final String TAG = "MicroMsg.StoryUploadPackHelper";
  private static final Pattern iYL;
  public static final d.a zwv;
  private bsz yBE;
  private com.tencent.mm.plugin.story.i.j zwd;
  private ddz zws;
  private dep zwt;
  private def zwu;
  
  static
  {
    AppMethodBeat.i(119130);
    zwv = new d.a((byte)0);
    TAG = "MicroMsg.StoryUploadPackHelper";
    iYL = Pattern.compile("(\n){3,}");
    AppMethodBeat.o(119130);
  }
  
  public d()
  {
    AppMethodBeat.i(119129);
    this.zwd = new com.tencent.mm.plugin.story.i.j();
    this.zwu = new def();
    this.zwd.setPostWaiting();
    Object localObject1 = this.zwd;
    Object localObject2 = com.tencent.mm.plugin.story.i.a.zBQ;
    int i = com.tencent.mm.plugin.story.i.a.dYi();
    localObject2 = com.tencent.mm.plugin.story.i.a.zBQ;
    ((com.tencent.mm.plugin.story.i.j)localObject1).Pb(i | com.tencent.mm.plugin.story.i.a.dYk());
    localObject1 = this.zwd;
    localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
    ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = j.b.dHx();
    this.zwd.field_createTime = ce.azK();
    this.zws = new ddz();
    this.yBE = new bsz();
    localObject1 = this.zws;
    localObject2 = new StringBuilder();
    Object localObject3 = com.tencent.mm.plugin.story.f.j.zsh;
    localObject2 = j.b.dHx() + bs.Gn() + ce.azI();
    localObject3 = d.n.d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119129);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
    d.g.b.k.g(localObject2, "(this as java.lang.String).getBytes(charset)");
    ((ddz)localObject1).hkN = g.getMessageDigest((byte[])localObject2);
    localObject1 = q.zsy;
    this.zwt = q.a.dVY();
    localObject1 = this.zwt;
    localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
    ((dep)localObject1).ncR = j.b.dHx();
    this.zwt.CreateTime = this.zwd.field_createTime;
    this.zwu.FNN = new SKBuiltinBuffer_t();
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
    localObject2 = com.tencent.mm.plugin.recordvideo.d.c.dwr().Rh();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    d.g.b.k.h(localObject1, "publishObjId");
    this.zwt.FOd = ((String)localObject1);
    ac.d(TAG, "storyInfo.createTime=%s timelineInfo.CreateTime=%s", new Object[] { Integer.valueOf(this.zwd.field_createTime), Integer.valueOf(this.zwt.CreateTime) });
    AppMethodBeat.o(119129);
  }
  
  private static void auo(String paramString)
  {
    AppMethodBeat.i(119121);
    com.tencent.mm.vfs.i.aSh(com.tencent.mm.vfs.i.aSs(paramString));
    AppMethodBeat.o(119121);
  }
  
  public final void Qx(int paramInt)
  {
    this.zwt.FOe = paramInt;
  }
  
  public final void a(bsz parambsz)
  {
    AppMethodBeat.i(119125);
    d.g.b.k.h(parambsz, "extInfo");
    this.yBE = parambsz;
    AppMethodBeat.o(119125);
  }
  
  public final void a(ddx paramddx)
  {
    AppMethodBeat.i(119126);
    d.g.b.k.h(paramddx, "editorInfo");
    this.zws.FNH = paramddx;
    AppMethodBeat.o(119126);
  }
  
  public final boolean aD(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(119127);
    d.g.b.k.h(paramString1, "path");
    d.g.b.k.h(paramString2, "thumbPath");
    d.g.b.k.h(paramString3, "videoMd5");
    paramString3 = q.zsy;
    paramString3 = new ddy();
    Object localObject1 = new StringBuilder();
    Object localObject2 = b.zrj;
    localObject1 = ((StringBuilder)localObject1).append(b.dVd());
    localObject2 = ce.azI() + '-' + bs.Gn();
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
    localObject1 = com.tencent.mm.plugin.story.f.l.zsu;
    localObject1 = com.tencent.mm.plugin.story.f.l.awC(paramString3.Id);
    localObject2 = com.tencent.mm.plugin.story.f.l.zsu;
    localObject2 = com.tencent.mm.plugin.story.f.l.awB(paramString3.Id);
    localObject3 = com.tencent.mm.plugin.story.f.l.zsu;
    com.tencent.mm.plugin.story.f.l.arb((String)localObject1);
    localObject3 = com.tencent.mm.plugin.story.f.l.zsu;
    com.tencent.mm.plugin.story.f.l.arb((String)localObject2);
    auo((String)localObject1);
    auo((String)localObject2);
    com.tencent.mm.vfs.i.lZ(paramString1, (String)localObject1);
    com.tencent.mm.vfs.i.lZ(paramString2, (String)localObject2);
    paramString3.FNF = (e.asx((String)localObject1).videoDuration / 1000.0F);
    this.zwt.FOc.Etz.add(paramString3);
    AppMethodBeat.o(119127);
    return true;
  }
  
  public final d b(cna paramcna)
  {
    if (paramcna != null) {
      this.zwt.FOb = paramcna;
    }
    return this;
  }
  
  public final int commit()
  {
    AppMethodBeat.i(119122);
    try
    {
      this.zws.FjJ = ce.azK();
      this.zws.gLY = 0;
      Object localObject1 = this.zwd;
      Object localObject2 = this.zws.toByteArray();
      d.g.b.k.g(localObject2, "postInfo.toByteArray()");
      ((com.tencent.mm.plugin.story.i.j)localObject1).bD((byte[])localObject2);
      this.zwd.field_attrBuf = this.zwu.toByteArray();
      this.zwd.b(this.zwt);
      localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
      int i = j.b.dVE().f(this.zwd);
      localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
      localObject1 = j.b.dVK();
      com.tencent.mm.ac.c.g((d.g.a.a)new c.e((c)localObject1, i));
      ((c)localObject1).checkPost();
      localObject1 = m.zsv;
      localObject1 = this.zwd;
      d.g.b.k.h(localObject1, "storyInfo");
      if (i != -1)
      {
        localObject2 = com.tencent.mm.plugin.story.e.a.zrf;
        String str = a.a.l(Integer.valueOf(((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime));
        ac.d(m.access$getTAG$cp(), "insertByLocalStory date=".concat(String.valueOf(str)));
        localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
        localObject2 = j.b.dVJ().axg(str);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new h();
        }
        d.g.b.k.h(str, "value");
        ((h)localObject1).field_date = str;
        ((h)localObject1).field_count += 1;
        ac.d(m.access$getTAG$cp(), "storyHistory.count=" + ((h)localObject1).field_count);
        localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
        j.b.dVJ().a((h)localObject1);
      }
      ac.d(TAG, "save story to db: ".concat(String.valueOf(i)));
      AppMethodBeat.o(119122);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
      }
    }
  }
  
  public final void gc(List<String> paramList)
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
          crm localcrm = new crm();
          localcrm.aJV(str);
          localLinkedList.add(localcrm);
          continue;
          i = 0;
          break;
        }
      }
      this.zwu.GroupUser.addAll((Collection)localLinkedList);
      this.zwu.GroupUserCount = localLinkedList.size();
    }
    AppMethodBeat.o(119123);
  }
  
  public final void gd(List<String> paramList)
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
          crm localcrm = new crm();
          localcrm.aJV(str);
          localLinkedList.add(localcrm);
          continue;
          i = 0;
          break;
        }
      }
      this.zwu.BlackList.addAll((Collection)localLinkedList);
      this.zwu.BlackListCount = localLinkedList.size();
    }
    AppMethodBeat.o(119124);
  }
  
  public final boolean jP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(119128);
    d.g.b.k.h(paramString1, "taskId");
    d.g.b.k.h(paramString2, "thumbPath");
    Object localObject1 = q.zsy;
    localObject1 = new ddy();
    Object localObject2 = new StringBuilder();
    Object localObject3 = b.zrj;
    localObject2 = ((StringBuilder)localObject2).append(b.dVd());
    localObject3 = ce.azI() + '-' + bs.Gn();
    Charset localCharset = d.n.d.UTF_8;
    if (localObject3 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119128);
      throw paramString1;
    }
    localObject3 = ((String)localObject3).getBytes(localCharset);
    d.g.b.k.g(localObject3, "(this as java.lang.String).getBytes(charset)");
    ((ddy)localObject1).Id = g.getMessageDigest((byte[])localObject3);
    localObject2 = com.tencent.mm.plugin.story.f.l.zsu;
    localObject2 = com.tencent.mm.plugin.story.f.l.awB(((ddy)localObject1).Id);
    auo((String)localObject2);
    com.tencent.mm.vfs.i.lZ(paramString2, (String)localObject2);
    ((ddy)localObject1).taskId = paramString1;
    this.zwt.FOc.Etz.add(localObject1);
    paramString1 = this.zwd;
    int i = paramString1.field_localFlag;
    paramString2 = a.d.zBZ;
    paramString1.field_localFlag = (i | a.d.dYQ());
    paramString1 = this.zwd;
    i = paramString1.field_localFlag;
    paramString2 = a.d.zBZ;
    paramString1.field_localFlag = (i & (a.d.dYO() ^ 0xFFFFFFFF));
    AppMethodBeat.o(119128);
    return true;
  }
  
  public final void rG(boolean paramBoolean)
  {
    this.zws.FNJ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.d
 * JD-Core Version:    0.7.0.1
 */