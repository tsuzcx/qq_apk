package com.tencent.mm.plugin.story.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.oo;
import com.tencent.mm.b.g;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.plugin.story.e.a.a;
import com.tencent.mm.plugin.story.h.a.d;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.h.i;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.l;
import com.tencent.mm.plugin.story.model.p;
import com.tencent.mm.plugin.story.model.p.a;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.enw;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fij;
import com.tencent.mm.protocal.protobuf.fir;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.protocal.protobuf.fit;
import com.tencent.mm.protocal.protobuf.fiz;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/upload/UploadPackHelper;", "", "()V", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyObj", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "timelineInfo", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "checkToCreateDir", "", "newVideoPath", "", "commit", "", "createStory", "", "taskId", "thumbPath", "path", "videoMd5", "setBlackUserList", "blackList", "", "setEditorData", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "setFavorite", "favorite", "setGroupUserList", "groupList", "setImageVideo", "isImageVideo", "setLocation", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setPublishObjId", "publishObjId", "setScope", "scope", "setSightExtInfo", "setSrcMd5List", "srcMd5List", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private static final Pattern PATTERN;
  public static final d.a Soa;
  private static final String TAG;
  private dmb RfP;
  private j SnL;
  private fit Sob;
  private fjj Soc;
  private fiz Sod;
  
  static
  {
    AppMethodBeat.i(119130);
    Soa = new d.a((byte)0);
    TAG = "MicroMsg.StoryUploadPackHelper";
    PATTERN = Pattern.compile("(\n){3,}");
    AppMethodBeat.o(119130);
  }
  
  public d()
  {
    AppMethodBeat.i(119129);
    this.SnL = new j();
    this.Sod = new fiz();
    this.SnL.setPostWaiting();
    Object localObject1 = this.SnL;
    Object localObject2 = com.tencent.mm.plugin.story.h.a.Sry;
    int i = com.tencent.mm.plugin.story.h.a.hyu();
    localObject2 = com.tencent.mm.plugin.story.h.a.Sry;
    ((j)localObject1).addSourceFlag(i | com.tencent.mm.plugin.story.h.a.hyw());
    localObject1 = this.SnL;
    localObject2 = StoryCore.SjP;
    ((j)localObject1).field_userName = StoryCore.b.hgg();
    this.SnL.field_createTime = cn.getSyncServerTimeSecond();
    this.Sob = new fit();
    this.RfP = new dmb();
    localObject1 = this.Sob;
    localObject2 = new StringBuilder();
    Object localObject3 = StoryCore.SjP;
    localObject2 = StoryCore.b.hgg() + Util.currentTicks() + cn.bDv();
    localObject3 = kotlin.n.d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119129);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
    s.s(localObject2, "(this as java.lang.String).getBytes(charset)");
    ((fit)localObject1).nUv = g.getMessageDigest((byte[])localObject2);
    localObject1 = p.Sku;
    this.Soc = p.a.hwl();
    localObject1 = this.Soc;
    localObject2 = StoryCore.SjP;
    ((fjj)localObject1).UserName = StoryCore.b.hgg();
    this.Soc.CreateTime = this.SnL.field_createTime;
    this.Sod.abJK = new gol();
    localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    localObject2 = com.tencent.mm.plugin.recordvideo.f.c.gJf().jju;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    s.u(localObject1, "publishObjId");
    this.Soc.abKa = ((String)localObject1);
    Log.d(TAG, "storyInfo.createTime=%s timelineInfo.CreateTime=%s", new Object[] { Integer.valueOf(this.SnL.field_createTime), Integer.valueOf(this.Soc.CreateTime) });
    AppMethodBeat.o(119129);
  }
  
  private static void aYW(String paramString)
  {
    AppMethodBeat.i(119121);
    y.bDX(y.bEo(paramString));
    AppMethodBeat.o(119121);
  }
  
  public final void EI(boolean paramBoolean)
  {
    this.Sob.abJF = paramBoolean;
  }
  
  public final int FW()
  {
    AppMethodBeat.i(119122);
    try
    {
      this.Sob.aaTL = cn.getSyncServerTimeSecond();
      this.Sob.nrQ = 0;
      Object localObject1 = this.SnL;
      Object localObject2 = this.Sob.toByteArray();
      s.s(localObject2, "postInfo.toByteArray()");
      ((j)localObject1).setPostBuf((byte[])localObject2);
      this.SnL.field_attrBuf = this.Sod.toByteArray();
      this.SnL.b(this.Soc);
      localObject1 = StoryCore.SjP;
      int i = StoryCore.b.hvR().f(this.SnL);
      localObject1 = StoryCore.SjP;
      localObject1 = StoryCore.b.hvX();
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c.e((c)localObject1, i));
      ((c)localObject1).checkPost();
      localObject1 = l.Skr;
      localObject1 = this.SnL;
      s.u(localObject1, "storyInfo");
      if (i != -1)
      {
        localObject2 = com.tencent.mm.plugin.story.e.a.Sjk;
        String str = a.a.C(Integer.valueOf(((j)localObject1).field_createTime));
        Log.d(l.access$getTAG$cp(), s.X("insertByLocalStory date=", str));
        localObject1 = StoryCore.SjP;
        localObject2 = StoryCore.b.hvW().bco(str);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new h();
        }
        s.u(str, "value");
        ((h)localObject1).field_date = str;
        ((h)localObject1).field_count += 1;
        Log.d(l.access$getTAG$cp(), s.X("storyHistory.count=", Integer.valueOf(((h)localObject1).field_count)));
        localObject2 = StoryCore.SjP;
        StoryCore.b.hvW().a((h)localObject1);
      }
      Log.d(TAG, s.X("save story to db: ", Integer.valueOf(i)));
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
  
  public final void a(dmb paramdmb)
  {
    AppMethodBeat.i(119125);
    s.u(paramdmb, "extInfo");
    this.RfP = paramdmb;
    AppMethodBeat.o(119125);
  }
  
  public final void a(fir paramfir)
  {
    AppMethodBeat.i(119126);
    s.u(paramfir, "editorInfo");
    this.Sob.abJD = paramfir;
    AppMethodBeat.o(119126);
  }
  
  public final void ane(int paramInt)
  {
    this.Soc.abKb = paramInt;
  }
  
  public final d b(enw paramenw)
  {
    if (paramenw != null) {
      this.Soc.abJY = paramenw;
    }
    return this;
  }
  
  public final boolean bh(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(119127);
    s.u(paramString1, "path");
    s.u(paramString2, "thumbPath");
    s.u(paramString3, "videoMd5");
    paramString3 = p.Sku;
    paramString3 = new fis();
    Object localObject1 = com.tencent.mm.plugin.story.e.b.Sjl;
    localObject1 = com.tencent.mm.plugin.story.e.b.hvm();
    Object localObject2 = cn.bDv() + '-' + Util.currentTicks();
    Object localObject3 = kotlin.n.d.UTF_8;
    if (localObject2 == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119127);
      throw paramString1;
    }
    localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
    s.s(localObject2, "(this as java.lang.String).getBytes(charset)");
    paramString3.Id = s.X((String)localObject1, g.getMessageDigest((byte[])localObject2));
    localObject1 = com.tencent.mm.plugin.story.model.k.Skq;
    localObject1 = com.tencent.mm.plugin.story.model.k.bbN(paramString3.Id);
    localObject2 = com.tencent.mm.plugin.story.model.k.Skq;
    localObject2 = com.tencent.mm.plugin.story.model.k.bbM(paramString3.Id);
    localObject3 = com.tencent.mm.plugin.story.model.k.Skq;
    com.tencent.mm.plugin.story.model.k.aTB((String)localObject1);
    localObject3 = com.tencent.mm.plugin.story.model.k.Skq;
    com.tencent.mm.plugin.story.model.k.aTB((String)localObject2);
    aYW((String)localObject1);
    aYW((String)localObject2);
    y.O(paramString1, (String)localObject1, false);
    y.O(paramString2, (String)localObject2, false);
    paramString3.abJB = (f.aVX((String)localObject1).videoDuration / 1000.0F);
    this.Soc.abJZ.Zpr.add(paramString3);
    AppMethodBeat.o(119127);
    return true;
  }
  
  public final void lg(List<String> paramList)
  {
    AppMethodBeat.i(119123);
    s.u(paramList, "groupList");
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
          etl localetl = new etl();
          localetl.btH(str);
          localLinkedList.add(localetl);
          continue;
          i = 0;
          break;
        }
      }
      this.Sod.GroupUser.addAll((Collection)localLinkedList);
      this.Sod.GroupUserCount = localLinkedList.size();
    }
    AppMethodBeat.o(119123);
  }
  
  public final void lh(List<String> paramList)
  {
    AppMethodBeat.i(119124);
    s.u(paramList, "blackList");
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
          etl localetl = new etl();
          localetl.btH(str);
          localLinkedList.add(localetl);
          continue;
          i = 0;
          break;
        }
      }
      this.Sod.BlackList.addAll((Collection)localLinkedList);
      this.Sod.BlackListCount = localLinkedList.size();
    }
    AppMethodBeat.o(119124);
  }
  
  public final void li(List<String> paramList)
  {
    AppMethodBeat.i(367197);
    s.u(paramList, "srcMd5List");
    if (((Collection)paramList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.Sob.abJG.addAll((Collection)paramList);
      }
      AppMethodBeat.o(367197);
      return;
    }
  }
  
  public final boolean ne(String paramString1, String paramString2)
  {
    AppMethodBeat.i(119128);
    s.u(paramString1, "taskId");
    s.u(paramString2, "thumbPath");
    Object localObject1 = p.Sku;
    localObject1 = new fis();
    Object localObject2 = com.tencent.mm.plugin.story.e.b.Sjl;
    localObject2 = com.tencent.mm.plugin.story.e.b.hvm();
    Object localObject3 = cn.bDv() + '-' + Util.currentTicks();
    Charset localCharset = kotlin.n.d.UTF_8;
    if (localObject3 == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119128);
      throw paramString1;
    }
    localObject3 = ((String)localObject3).getBytes(localCharset);
    s.s(localObject3, "(this as java.lang.String).getBytes(charset)");
    ((fis)localObject1).Id = s.X((String)localObject2, g.getMessageDigest((byte[])localObject3));
    localObject2 = com.tencent.mm.plugin.story.model.k.Skq;
    localObject2 = com.tencent.mm.plugin.story.model.k.bbM(((fis)localObject1).Id);
    aYW((String)localObject2);
    y.O(paramString2, (String)localObject2, false);
    ((fis)localObject1).taskId = paramString1;
    this.Soc.abJZ.Zpr.add(localObject1);
    paramString1 = this.SnL;
    int i = paramString1.field_localFlag;
    paramString2 = a.d.Ssx;
    paramString1.field_localFlag = (i | a.d.hzc());
    paramString1 = this.SnL;
    i = paramString1.field_localFlag;
    paramString2 = a.d.Ssx;
    paramString1.field_localFlag = (i & (a.d.hza() ^ 0xFFFFFFFF));
    AppMethodBeat.o(119128);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.f.d
 * JD-Core Version:    0.7.0.1
 */