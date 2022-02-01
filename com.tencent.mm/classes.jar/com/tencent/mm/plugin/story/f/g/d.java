package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.f.b.a.lo;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.plugin.story.e.a.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.m;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.i.a.d;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.i;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.enl;
import com.tencent.mm.protocal.protobuf.ent;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.protocal.protobuf.env;
import com.tencent.mm.protocal.protobuf.eob;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/upload/UploadPackHelper;", "", "()V", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyObj", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "timelineInfo", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "checkToCreateDir", "", "newVideoPath", "", "commit", "", "createStory", "", "taskId", "thumbPath", "path", "videoMd5", "setBlackUserList", "blackList", "", "setEditorData", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "setFavorite", "favorite", "setGroupUserList", "groupList", "setImageVideo", "isImageVideo", "setLocation", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setPublishObjId", "publishObjId", "setScope", "scope", "setSightExtInfo", "setSrcMd5List", "srcMd5List", "Companion", "plugin-story_release"})
public final class d
{
  public static final a LKM;
  private static final Pattern PATTERN;
  private static final String TAG = "MicroMsg.StoryUploadPackHelper";
  private cuv KGp;
  private env LKJ;
  private eol LKK;
  private eob LKL;
  private com.tencent.mm.plugin.story.i.j LKu;
  
  static
  {
    AppMethodBeat.i(119130);
    LKM = new a((byte)0);
    TAG = "MicroMsg.StoryUploadPackHelper";
    PATTERN = Pattern.compile("(\n){3,}");
    AppMethodBeat.o(119130);
  }
  
  public d()
  {
    AppMethodBeat.i(119129);
    this.LKu = new com.tencent.mm.plugin.story.i.j();
    this.LKL = new eob();
    this.LKu.setPostWaiting();
    Object localObject1 = this.LKu;
    Object localObject2 = com.tencent.mm.plugin.story.i.a.LPG;
    int i = com.tencent.mm.plugin.story.i.a.gfc();
    localObject2 = com.tencent.mm.plugin.story.i.a.LPG;
    ((com.tencent.mm.plugin.story.i.j)localObject1).addSourceFlag(i | com.tencent.mm.plugin.story.i.a.gfe());
    localObject1 = this.LKu;
    localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
    ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = j.b.fOo();
    this.LKu.field_createTime = cm.bfF();
    this.LKJ = new env();
    this.KGp = new cuv();
    localObject1 = this.LKJ;
    localObject2 = new StringBuilder();
    Object localObject3 = com.tencent.mm.plugin.story.f.j.LGA;
    localObject2 = j.b.fOo() + Util.currentTicks() + cm.bfD();
    localObject3 = kotlin.n.d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119129);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
    p.j(localObject2, "(this as java.lang.String).getBytes(charset)");
    ((env)localObject1).lps = g.getMessageDigest((byte[])localObject2);
    localObject1 = q.LGQ;
    this.LKK = q.a.gcR();
    localObject1 = this.LKK;
    localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
    ((eol)localObject1).UserName = j.b.fOo();
    this.LKK.CreateTime = this.LKu.field_createTime;
    this.LKL.UqL = new eae();
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
    localObject2 = com.tencent.mm.plugin.recordvideo.d.c.fxq().amF();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    p.k(localObject1, "publishObjId");
    this.LKK.Urb = ((String)localObject1);
    Log.d(TAG, "storyInfo.createTime=%s timelineInfo.CreateTime=%s", new Object[] { Integer.valueOf(this.LKu.field_createTime), Integer.valueOf(this.LKK.CreateTime) });
    AppMethodBeat.o(119129);
  }
  
  private static void baC(String paramString)
  {
    AppMethodBeat.i(119121);
    u.bBD(u.bBT(paramString));
    AppMethodBeat.o(119121);
  }
  
  public final void a(cuv paramcuv)
  {
    AppMethodBeat.i(119125);
    p.k(paramcuv, "extInfo");
    this.KGp = paramcuv;
    AppMethodBeat.o(119125);
  }
  
  public final void a(ent parament)
  {
    AppMethodBeat.i(119126);
    p.k(parament, "editorInfo");
    this.LKJ.UqE = parament;
    AppMethodBeat.o(119126);
  }
  
  public final boolean aP(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(119127);
    p.k(paramString1, "path");
    p.k(paramString2, "thumbPath");
    p.k(paramString3, "videoMd5");
    paramString3 = q.LGQ;
    paramString3 = new enu();
    Object localObject1 = new StringBuilder();
    Object localObject2 = com.tencent.mm.plugin.story.e.b.LFC;
    localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.story.e.b.gbV());
    localObject2 = cm.bfD() + '-' + Util.currentTicks();
    Object localObject3 = kotlin.n.d.UTF_8;
    if (localObject2 == null)
    {
      paramString1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119127);
      throw paramString1;
    }
    localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
    p.j(localObject2, "(this as java.lang.String).getBytes(charset)");
    paramString3.Id = g.getMessageDigest((byte[])localObject2);
    localObject1 = com.tencent.mm.plugin.story.f.l.LGM;
    localObject1 = com.tencent.mm.plugin.story.f.l.bda(paramString3.Id);
    localObject2 = com.tencent.mm.plugin.story.f.l.LGM;
    localObject2 = com.tencent.mm.plugin.story.f.l.bcZ(paramString3.Id);
    localObject3 = com.tencent.mm.plugin.story.f.l.LGM;
    com.tencent.mm.plugin.story.f.l.aWs((String)localObject1);
    localObject3 = com.tencent.mm.plugin.story.f.l.LGM;
    com.tencent.mm.plugin.story.f.l.aWs((String)localObject2);
    baC((String)localObject1);
    baC((String)localObject2);
    u.on(paramString1, (String)localObject1);
    u.on(paramString2, (String)localObject2);
    paramString3.UqC = (f.aYg((String)localObject1).videoDuration / 1000.0F);
    this.LKK.Ura.Sqr.add(paramString3);
    AppMethodBeat.o(119127);
    return true;
  }
  
  public final void aie(int paramInt)
  {
    this.LKK.Urc = paramInt;
  }
  
  public final d b(duy paramduy)
  {
    if (paramduy != null) {
      this.LKK.UqZ = paramduy;
    }
    return this;
  }
  
  public final void ib(List<String> paramList)
  {
    AppMethodBeat.i(119123);
    p.k(paramList, "groupList");
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
          eaf localeaf = new eaf();
          localeaf.btQ(str);
          localLinkedList.add(localeaf);
          continue;
          i = 0;
          break;
        }
      }
      this.LKL.GroupUser.addAll((Collection)localLinkedList);
      this.LKL.GroupUserCount = localLinkedList.size();
    }
    AppMethodBeat.o(119123);
  }
  
  public final void ic(List<String> paramList)
  {
    AppMethodBeat.i(119124);
    p.k(paramList, "blackList");
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
          eaf localeaf = new eaf();
          localeaf.btQ(str);
          localLinkedList.add(localeaf);
          continue;
          i = 0;
          break;
        }
      }
      this.LKL.BlackList.addAll((Collection)localLinkedList);
      this.LKL.BlackListCount = localLinkedList.size();
    }
    AppMethodBeat.o(119124);
  }
  
  public final void id(List<String> paramList)
  {
    AppMethodBeat.i(213630);
    p.k(paramList, "srcMd5List");
    if (((Collection)paramList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.LKJ.UqH.addAll((Collection)paramList);
      }
      AppMethodBeat.o(213630);
      return;
    }
  }
  
  public final int in()
  {
    AppMethodBeat.i(119122);
    try
    {
      this.LKJ.TEf = cm.bfF();
      this.LKJ.kQn = 0;
      Object localObject1 = this.LKu;
      Object localObject2 = this.LKJ.toByteArray();
      p.j(localObject2, "postInfo.toByteArray()");
      ((com.tencent.mm.plugin.story.i.j)localObject1).setPostBuf((byte[])localObject2);
      this.LKu.field_attrBuf = this.LKL.toByteArray();
      this.LKu.b(this.LKK);
      localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
      int i = j.b.gcw().f(this.LKu);
      localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
      localObject1 = j.b.gcC();
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c.e((c)localObject1, i));
      ((c)localObject1).checkPost();
      localObject1 = m.LGN;
      localObject1 = this.LKu;
      p.k(localObject1, "storyInfo");
      if (i != -1)
      {
        localObject2 = com.tencent.mm.plugin.story.e.a.LFy;
        String str = a.a.v(Integer.valueOf(((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime));
        Log.d(m.access$getTAG$cp(), "insertByLocalStory date=".concat(String.valueOf(str)));
        localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
        localObject2 = j.b.gcB().bdC(str);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new h();
        }
        p.k(str, "value");
        ((h)localObject1).field_date = str;
        ((h)localObject1).field_count += 1;
        Log.d(m.access$getTAG$cp(), "storyHistory.count=" + ((h)localObject1).field_count);
        localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
        j.b.gcB().a((h)localObject1);
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
  
  public final boolean lw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(119128);
    p.k(paramString1, "taskId");
    p.k(paramString2, "thumbPath");
    Object localObject1 = q.LGQ;
    localObject1 = new enu();
    Object localObject2 = new StringBuilder();
    Object localObject3 = com.tencent.mm.plugin.story.e.b.LFC;
    localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.story.e.b.gbV());
    localObject3 = cm.bfD() + '-' + Util.currentTicks();
    Charset localCharset = kotlin.n.d.UTF_8;
    if (localObject3 == null)
    {
      paramString1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119128);
      throw paramString1;
    }
    localObject3 = ((String)localObject3).getBytes(localCharset);
    p.j(localObject3, "(this as java.lang.String).getBytes(charset)");
    ((enu)localObject1).Id = g.getMessageDigest((byte[])localObject3);
    localObject2 = com.tencent.mm.plugin.story.f.l.LGM;
    localObject2 = com.tencent.mm.plugin.story.f.l.bcZ(((enu)localObject1).Id);
    baC((String)localObject2);
    u.on(paramString2, (String)localObject2);
    ((enu)localObject1).taskId = paramString1;
    this.LKK.Ura.Sqr.add(localObject1);
    paramString1 = this.LKu;
    int i = paramString1.field_localFlag;
    paramString2 = a.d.LPP;
    paramString1.field_localFlag = (i | a.d.gfK());
    paramString1 = this.LKu;
    i = paramString1.field_localFlag;
    paramString2 = a.d.LPP;
    paramString1.field_localFlag = (i & (a.d.gfI() ^ 0xFFFFFFFF));
    AppMethodBeat.o(119128);
    return true;
  }
  
  public final void zs(boolean paramBoolean)
  {
    this.LKJ.UqG = paramBoolean;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/upload/UploadPackHelper$Companion;", "", "()V", "PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getPATTERN", "()Ljava/util/regex/Pattern;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.d
 * JD-Core Version:    0.7.0.1
 */