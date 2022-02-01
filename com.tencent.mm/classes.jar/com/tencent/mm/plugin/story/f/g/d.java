package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.g.b.a.jf;
import com.tencent.mm.model.cl;
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
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/upload/UploadPackHelper;", "", "()V", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyObj", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "timelineInfo", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "checkToCreateDir", "", "newVideoPath", "", "commit", "", "createStory", "", "taskId", "thumbPath", "path", "videoMd5", "setBlackUserList", "blackList", "", "setEditorData", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "setFavorite", "favorite", "setGroupUserList", "groupList", "setImageVideo", "isImageVideo", "setLocation", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setPublishObjId", "publishObjId", "setScope", "scope", "setSightExtInfo", "setSrcMd5List", "srcMd5List", "Companion", "plugin-story_release"})
public final class d
{
  public static final a FqJ;
  private static final Pattern PATTERN;
  private static final String TAG = "MicroMsg.StoryUploadPackHelper";
  private cly EsS;
  private edu FqG;
  private eek FqH;
  private eea FqI;
  private com.tencent.mm.plugin.story.i.j Fqr;
  
  static
  {
    AppMethodBeat.i(119130);
    FqJ = new a((byte)0);
    TAG = "MicroMsg.StoryUploadPackHelper";
    PATTERN = Pattern.compile("(\n){3,}");
    AppMethodBeat.o(119130);
  }
  
  public d()
  {
    AppMethodBeat.i(119129);
    this.Fqr = new com.tencent.mm.plugin.story.i.j();
    this.FqI = new eea();
    this.Fqr.setPostWaiting();
    Object localObject1 = this.Fqr;
    Object localObject2 = com.tencent.mm.plugin.story.i.a.FvD;
    int i = com.tencent.mm.plugin.story.i.a.fqG();
    localObject2 = com.tencent.mm.plugin.story.i.a.FvD;
    ((com.tencent.mm.plugin.story.i.j)localObject1).addSourceFlag(i | com.tencent.mm.plugin.story.i.a.fqI());
    localObject1 = this.Fqr;
    localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
    ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = j.b.fau();
    this.Fqr.field_createTime = cl.aWB();
    this.FqG = new edu();
    this.EsS = new cly();
    localObject1 = this.FqG;
    localObject2 = new StringBuilder();
    Object localObject3 = com.tencent.mm.plugin.story.f.j.Fmy;
    localObject2 = j.b.fau() + Util.currentTicks() + cl.aWz();
    localObject3 = kotlin.n.d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119129);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
    p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
    ((edu)localObject1).izX = g.getMessageDigest((byte[])localObject2);
    localObject1 = q.FmO;
    this.FqH = q.a.fox();
    localObject1 = this.FqH;
    localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
    ((eek)localObject1).UserName = j.b.fau();
    this.FqH.CreateTime = this.Fqr.field_createTime;
    this.FqI.Nem = new SKBuiltinBuffer_t();
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    localObject2 = com.tencent.mm.plugin.recordvideo.d.c.eKX().ahj();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    p.h(localObject1, "publishObjId");
    this.FqH.NeC = ((String)localObject1);
    Log.d(TAG, "storyInfo.createTime=%s timelineInfo.CreateTime=%s", new Object[] { Integer.valueOf(this.Fqr.field_createTime), Integer.valueOf(this.FqH.CreateTime) });
    AppMethodBeat.o(119129);
  }
  
  private static void aPG(String paramString)
  {
    AppMethodBeat.i(119121);
    s.boN(s.boZ(paramString));
    AppMethodBeat.o(119121);
  }
  
  public final void a(cly paramcly)
  {
    AppMethodBeat.i(119125);
    p.h(paramcly, "extInfo");
    this.EsS = paramcly;
    AppMethodBeat.o(119125);
  }
  
  public final void a(eds parameds)
  {
    AppMethodBeat.i(119126);
    p.h(parameds, "editorInfo");
    this.FqG.Nef = parameds;
    AppMethodBeat.o(119126);
  }
  
  public final boolean aV(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(119127);
    p.h(paramString1, "path");
    p.h(paramString2, "thumbPath");
    p.h(paramString3, "videoMd5");
    paramString3 = q.FmO;
    paramString3 = new edt();
    Object localObject1 = new StringBuilder();
    Object localObject2 = b.FlA;
    localObject1 = ((StringBuilder)localObject1).append(b.fnB());
    localObject2 = cl.aWz() + '-' + Util.currentTicks();
    Object localObject3 = kotlin.n.d.UTF_8;
    if (localObject2 == null)
    {
      paramString1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119127);
      throw paramString1;
    }
    localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
    p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
    paramString3.Id = g.getMessageDigest((byte[])localObject2);
    localObject1 = com.tencent.mm.plugin.story.f.l.FmK;
    localObject1 = com.tencent.mm.plugin.story.f.l.aRW(paramString3.Id);
    localObject2 = com.tencent.mm.plugin.story.f.l.FmK;
    localObject2 = com.tencent.mm.plugin.story.f.l.aRV(paramString3.Id);
    localObject3 = com.tencent.mm.plugin.story.f.l.FmK;
    com.tencent.mm.plugin.story.f.l.aLP((String)localObject1);
    localObject3 = com.tencent.mm.plugin.story.f.l.FmK;
    com.tencent.mm.plugin.story.f.l.aLP((String)localObject2);
    aPG((String)localObject1);
    aPG((String)localObject2);
    s.nw(paramString1, (String)localObject1);
    s.nw(paramString2, (String)localObject2);
    paramString3.Ned = (e.aNx((String)localObject1).videoDuration / 1000.0F);
    this.FqH.NeB.LoV.add(paramString3);
    AppMethodBeat.o(119127);
    return true;
  }
  
  public final void aaJ(int paramInt)
  {
    this.FqH.NeD = paramInt;
  }
  
  public final d b(dlg paramdlg)
  {
    if (paramdlg != null) {
      this.FqH.NeA = paramdlg;
    }
    return this;
  }
  
  public final int commit()
  {
    AppMethodBeat.i(119122);
    try
    {
      this.FqG.MsZ = cl.aWB();
      this.FqG.ibG = 0;
      Object localObject1 = this.Fqr;
      Object localObject2 = this.FqG.toByteArray();
      p.g(localObject2, "postInfo.toByteArray()");
      ((com.tencent.mm.plugin.story.i.j)localObject1).setPostBuf((byte[])localObject2);
      this.Fqr.field_attrBuf = this.FqI.toByteArray();
      this.Fqr.b(this.FqH);
      localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
      int i = j.b.foc().f(this.Fqr);
      localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
      localObject1 = j.b.foi();
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new c.e((c)localObject1, i));
      ((c)localObject1).checkPost();
      localObject1 = m.FmL;
      localObject1 = this.Fqr;
      p.h(localObject1, "storyInfo");
      if (i != -1)
      {
        localObject2 = com.tencent.mm.plugin.story.e.a.Flw;
        String str = a.a.n(Integer.valueOf(((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime));
        Log.d(m.access$getTAG$cp(), "insertByLocalStory date=".concat(String.valueOf(str)));
        localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
        localObject2 = j.b.foh().aSy(str);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new h();
        }
        p.h(str, "value");
        ((h)localObject1).field_date = str;
        ((h)localObject1).field_count += 1;
        Log.d(m.access$getTAG$cp(), "storyHistory.count=" + ((h)localObject1).field_count);
        localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.foh().a((h)localObject1);
      }
      Log.d(TAG, "save story to db: ".concat(String.valueOf(i)));
      AppMethodBeat.o(119122);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
      }
    }
  }
  
  public final void hs(List<String> paramList)
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
          dqi localdqi = new dqi();
          localdqi.bhy(str);
          localLinkedList.add(localdqi);
          continue;
          i = 0;
          break;
        }
      }
      this.FqI.GroupUser.addAll((Collection)localLinkedList);
      this.FqI.GroupUserCount = localLinkedList.size();
    }
    AppMethodBeat.o(119123);
  }
  
  public final void ht(List<String> paramList)
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
          dqi localdqi = new dqi();
          localdqi.bhy(str);
          localLinkedList.add(localdqi);
          continue;
          i = 0;
          break;
        }
      }
      this.FqI.BlackList.addAll((Collection)localLinkedList);
      this.FqI.BlackListCount = localLinkedList.size();
    }
    AppMethodBeat.o(119124);
  }
  
  public final void hu(List<String> paramList)
  {
    AppMethodBeat.i(222912);
    p.h(paramList, "srcMd5List");
    if (((Collection)paramList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.FqG.Nei.addAll((Collection)paramList);
      }
      AppMethodBeat.o(222912);
      return;
    }
  }
  
  public final boolean kZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(119128);
    p.h(paramString1, "taskId");
    p.h(paramString2, "thumbPath");
    Object localObject1 = q.FmO;
    localObject1 = new edt();
    Object localObject2 = new StringBuilder();
    Object localObject3 = b.FlA;
    localObject2 = ((StringBuilder)localObject2).append(b.fnB());
    localObject3 = cl.aWz() + '-' + Util.currentTicks();
    Charset localCharset = kotlin.n.d.UTF_8;
    if (localObject3 == null)
    {
      paramString1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119128);
      throw paramString1;
    }
    localObject3 = ((String)localObject3).getBytes(localCharset);
    p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
    ((edt)localObject1).Id = g.getMessageDigest((byte[])localObject3);
    localObject2 = com.tencent.mm.plugin.story.f.l.FmK;
    localObject2 = com.tencent.mm.plugin.story.f.l.aRV(((edt)localObject1).Id);
    aPG((String)localObject2);
    s.nw(paramString2, (String)localObject2);
    ((edt)localObject1).taskId = paramString1;
    this.FqH.NeB.LoV.add(localObject1);
    paramString1 = this.Fqr;
    int i = paramString1.field_localFlag;
    paramString2 = a.d.FvM;
    paramString1.field_localFlag = (i | a.d.fro());
    paramString1 = this.Fqr;
    i = paramString1.field_localFlag;
    paramString2 = a.d.FvM;
    paramString1.field_localFlag = (i & (a.d.frm() ^ 0xFFFFFFFF));
    AppMethodBeat.o(119128);
    return true;
  }
  
  public final void vO(boolean paramBoolean)
  {
    this.FqG.Neh = paramBoolean;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/upload/UploadPackHelper$Companion;", "", "()V", "PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getPATTERN", "()Ljava/util/regex/Pattern;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.d
 * JD-Core Version:    0.7.0.1
 */