package com.tencent.mm.plugin.story.model.g;

import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.e.b.a;
import com.tencent.mm.plugin.story.h.a.a;
import com.tencent.mm.plugin.story.h.a.d;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.m;
import com.tencent.mm.plugin.story.model.q;
import com.tencent.mm.plugin.story.model.q.a;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.regex.Pattern;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/upload/UploadPackHelper;", "", "()V", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "timelineInfo", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "checkToCreateDir", "", "newVideoPath", "", "commit", "", "createStory", "", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "thumbPath", "path", "videoMd5", "setEditorData", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "setFavorite", "favorite", "setImageVideo", "isImageVideo", "setLocation", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "setPublishObjId", "publishObjId", "setScope", "scope", "setSightExtInfo", "Companion", "plugin-story_release"})
public final class d
{
  private static final String TAG = "MicroMsg.StoryUploadPackHelper";
  private static final Pattern gKY;
  public static final d.a sAk;
  private bby rIz;
  private chm sAi;
  private cic sAj;
  private com.tencent.mm.plugin.story.h.j szQ;
  
  static
  {
    AppMethodBeat.i(109475);
    sAk = new d.a((byte)0);
    TAG = "MicroMsg.StoryUploadPackHelper";
    gKY = Pattern.compile("(\n){3,}");
    AppMethodBeat.o(109475);
  }
  
  public d()
  {
    AppMethodBeat.i(109474);
    this.szQ = new com.tencent.mm.plugin.story.h.j();
    this.szQ.cEZ();
    Object localObject1 = this.szQ;
    Object localObject2 = com.tencent.mm.plugin.story.h.a.sFV;
    int i = com.tencent.mm.plugin.story.h.a.cDO();
    localObject2 = com.tencent.mm.plugin.story.h.a.sFV;
    ((com.tencent.mm.plugin.story.h.j)localObject1).Eu(i | com.tencent.mm.plugin.story.h.a.cDQ());
    localObject1 = this.szQ;
    localObject2 = com.tencent.mm.plugin.story.model.j.svi;
    ((com.tencent.mm.plugin.story.h.j)localObject1).field_userName = j.b.coK();
    this.szQ.field_createTime = cb.abr();
    this.sAi = new chm();
    this.rIz = new bby();
    localObject1 = this.sAi;
    localObject2 = new StringBuilder();
    Object localObject3 = com.tencent.mm.plugin.story.model.j.svi;
    localObject2 = j.b.coK() + bo.yB() + cb.abq();
    localObject3 = a.l.d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(109474);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
    a.f.b.j.p(localObject2, "(this as java.lang.String).getBytes(charset)");
    ((chm)localObject1).pIw = g.w((byte[])localObject2);
    localObject1 = q.svz;
    this.sAj = q.a.cAY();
    localObject1 = this.sAj;
    localObject2 = com.tencent.mm.plugin.story.model.j.svi;
    ((cic)localObject1).jJA = j.b.coK();
    this.sAj.CreateTime = this.szQ.field_createTime;
    localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
    localObject2 = com.tencent.mm.plugin.story.g.i.cDi().Fr();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    a.f.b.j.q(localObject1, "publishObjId");
    this.sAj.xSL = ((String)localObject1);
    ab.d(TAG, "storyInfo.createTime=%s timelineInfo.CreateTime=%s", new Object[] { Integer.valueOf(this.szQ.field_createTime), Integer.valueOf(this.sAj.CreateTime) });
    AppMethodBeat.o(109474);
  }
  
  private static void aaV(String paramString)
  {
    AppMethodBeat.i(109468);
    e.um(e.avK(paramString));
    AppMethodBeat.o(109468);
  }
  
  public final void FJ(int paramInt)
  {
    this.sAj.xSM = paramInt;
  }
  
  public final void FK(int paramInt)
  {
    AppMethodBeat.i(138797);
    this.sAj.xSN = paramInt;
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.story.h.j localj = this.szQ;
      a.a locala = com.tencent.mm.plugin.story.h.a.sFV;
      localj.FZ(com.tencent.mm.plugin.story.h.a.cEq());
    }
    AppMethodBeat.o(138797);
  }
  
  public final d a(chj paramchj)
  {
    if (paramchj != null) {
      this.sAj.xSJ = paramchj;
    }
    return this;
  }
  
  public final void a(bby parambby)
  {
    AppMethodBeat.i(109470);
    a.f.b.j.q(parambby, "extInfo");
    this.rIz = parambby;
    AppMethodBeat.o(109470);
  }
  
  public final void a(chk paramchk)
  {
    AppMethodBeat.i(109471);
    a.f.b.j.q(paramchk, "editorInfo");
    this.sAi.xSr = paramchk;
    AppMethodBeat.o(109471);
  }
  
  public final boolean a(com.tencent.mm.plugin.story.h.d paramd, String paramString)
  {
    AppMethodBeat.i(109473);
    a.f.b.j.q(paramd, "storyEditorData");
    a.f.b.j.q(paramString, "thumbPath");
    Object localObject1 = q.svz;
    localObject1 = new chl();
    Object localObject2 = new StringBuilder();
    Object localObject3 = com.tencent.mm.plugin.story.e.c.ssB;
    localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.story.e.c.czO());
    localObject3 = cb.abq() + '-' + bo.yB();
    Charset localCharset = a.l.d.UTF_8;
    if (localObject3 == null)
    {
      paramd = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(109473);
      throw paramd;
    }
    localObject3 = ((String)localObject3).getBytes(localCharset);
    a.f.b.j.p(localObject3, "(this as java.lang.String).getBytes(charset)");
    ((chl)localObject1).Id = g.w((byte[])localObject3);
    localObject2 = com.tencent.mm.plugin.story.model.l.svv;
    localObject2 = com.tencent.mm.plugin.story.model.l.acX(((chl)localObject1).Id);
    aaV((String)localObject2);
    e.C(paramString, (String)localObject2);
    ((chl)localObject1).cIp = ((int)paramd.systemRowid);
    this.sAj.xSK.wOa.add(localObject1);
    paramd = this.szQ;
    int i = paramd.field_localFlag;
    paramString = a.d.sGd;
    paramd.field_localFlag = (i | a.d.cEA());
    paramd = this.szQ;
    i = paramd.field_localFlag;
    paramString = a.d.sGd;
    paramd.field_localFlag = (i & (a.d.cEy() ^ 0xFFFFFFFF));
    AppMethodBeat.o(109473);
    return true;
  }
  
  public final boolean aq(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(109472);
    a.f.b.j.q(paramString1, "path");
    a.f.b.j.q(paramString2, "thumbPath");
    a.f.b.j.q(paramString3, "videoMd5");
    paramString3 = q.svz;
    paramString3 = new chl();
    Object localObject1 = new StringBuilder();
    Object localObject2 = com.tencent.mm.plugin.story.e.c.ssB;
    localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.story.e.c.czO());
    localObject2 = cb.abq() + '-' + bo.yB();
    Object localObject3 = a.l.d.UTF_8;
    if (localObject2 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(109472);
      throw paramString1;
    }
    localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
    a.f.b.j.p(localObject2, "(this as java.lang.String).getBytes(charset)");
    paramString3.Id = g.w((byte[])localObject2);
    localObject1 = com.tencent.mm.plugin.story.model.l.svv;
    localObject1 = com.tencent.mm.plugin.story.model.l.acY(paramString3.Id);
    localObject2 = com.tencent.mm.plugin.story.model.l.svv;
    localObject2 = com.tencent.mm.plugin.story.model.l.acX(paramString3.Id);
    localObject3 = com.tencent.mm.plugin.story.model.l.svv;
    com.tencent.mm.plugin.story.model.l.adc((String)localObject1);
    localObject3 = com.tencent.mm.plugin.story.model.l.svv;
    com.tencent.mm.plugin.story.model.l.adc((String)localObject2);
    aaV((String)localObject1);
    aaV((String)localObject2);
    e.C(paramString1, (String)localObject1);
    e.C(paramString2, (String)localObject2);
    paramString3.duration = (com.tencent.mm.plugin.sight.base.d.Zo((String)localObject1).eVA / 1000.0F);
    this.sAj.xSK.wOa.add(paramString3);
    AppMethodBeat.o(109472);
    return true;
  }
  
  public final int commit()
  {
    AppMethodBeat.i(109469);
    try
    {
      this.sAi.xst = cb.abr();
      this.sAi.ePG = 0;
      Object localObject1 = this.szQ;
      Object localObject2 = this.sAi.toByteArray();
      a.f.b.j.p(localObject2, "postInfo.toByteArray()");
      ((com.tencent.mm.plugin.story.h.j)localObject1).bl((byte[])localObject2);
      this.szQ.b(this.sAj);
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      int i = j.b.cAB().e(this.szQ);
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      localObject1 = j.b.cAI();
      com.tencent.mm.ab.b.b((a.f.a.a)new c.e((c)localObject1, i));
      ((c)localObject1).checkPost();
      localObject1 = m.svw;
      localObject1 = this.szQ;
      a.f.b.j.q(localObject1, "storyInfo");
      if (i != -1)
      {
        localObject2 = com.tencent.mm.plugin.story.e.b.ssx;
        String str = b.a.i(Integer.valueOf(((com.tencent.mm.plugin.story.h.j)localObject1).field_createTime));
        ab.d(m.access$getTAG$cp(), "insertByLocalStory date=".concat(String.valueOf(str)));
        localObject1 = com.tencent.mm.plugin.story.model.j.svi;
        localObject2 = j.b.cAH().adE(str);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new h();
        }
        a.f.b.j.q(str, "value");
        ((h)localObject1).field_date = str;
        ((h)localObject1).field_count += 1;
        ab.d(m.access$getTAG$cp(), "storyHistory.count=" + ((h)localObject1).field_count);
        localObject2 = com.tencent.mm.plugin.story.model.j.svi;
        j.b.cAH().a((h)localObject1);
      }
      ab.d(TAG, "save story to db: ".concat(String.valueOf(i)));
      AppMethodBeat.o(109469);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
      }
    }
  }
  
  public final void lV(boolean paramBoolean)
  {
    this.sAi.xSt = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.g.d
 * JD-Core Version:    0.7.0.1
 */