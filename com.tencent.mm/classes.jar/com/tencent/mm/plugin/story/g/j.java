package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.story.f.g.c;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.i.a.d;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.n.d;
import d.v;
import java.nio.charset.Charset;
import java.util.LinkedList;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/presenter/StoryDataProtoUtil;", "", "()V", "TAG", "", "signStoryDataMix", "", "localId", "", "mixVideoPath", "mixThumbPath", "signStoryDataMixEnable", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "signStoryDataMixError", "", "signStoryDataMixTime", "plugin-story_release"})
public final class j
{
  public static final j BhR;
  
  static
  {
    AppMethodBeat.i(119325);
    BhR = new j();
    AppMethodBeat.o(119325);
  }
  
  public static void SU(int paramInt)
  {
    AppMethodBeat.i(119324);
    ae.i("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMixError ".concat(String.valueOf(paramInt)));
    Object localObject = com.tencent.mm.plugin.story.f.j.BbE;
    localObject = j.b.elB().Te(paramInt);
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.story.i.j)localObject).ecs();
      j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
      j.b.elB().a(paramInt, (com.tencent.mm.plugin.story.i.j)localObject);
    }
    AppMethodBeat.o(119324);
  }
  
  public static void e(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(119323);
    p.h(paramString1, "mixVideoPath");
    p.h(paramString2, "mixThumbPath");
    ae.d("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMix localId:" + paramLong + " mixVideoPath:" + paramString1 + " mixThumbPath:" + paramString2);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
    localObject1 = j.b.elB().Te((int)paramLong);
    if (localObject1 != null)
    {
      int i = ((com.tencent.mm.plugin.story.i.j)localObject1).field_localFlag;
      Object localObject2 = a.d.BkW;
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_localFlag = (i & (a.d.eoO() ^ 0xFFFFFFFF));
      ((com.tencent.mm.plugin.story.i.j)localObject1).setPostWaiting();
      localObject2 = q.BbV;
      localObject2 = new dkg();
      Object localObject3 = new StringBuilder();
      Object localObject4 = com.tencent.mm.plugin.story.e.b.BaG;
      localObject3 = ((StringBuilder)localObject3).append(com.tencent.mm.plugin.story.e.b.ela());
      localObject4 = ch.aDb() + '-' + bu.HQ();
      Object localObject5 = d.UTF_8;
      if (localObject4 == null)
      {
        paramString1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(119323);
        throw paramString1;
      }
      localObject4 = ((String)localObject4).getBytes((Charset)localObject5);
      p.g(localObject4, "(this as java.lang.String).getBytes(charset)");
      ((dkg)localObject2).Id = com.tencent.mm.b.g.getMessageDigest((byte[])localObject4);
      localObject3 = com.tencent.mm.plugin.story.f.l.BbR;
      localObject3 = com.tencent.mm.plugin.story.f.l.aDa(((dkg)localObject2).Id);
      localObject4 = com.tencent.mm.plugin.story.f.l.BbR;
      localObject4 = com.tencent.mm.plugin.story.f.l.aCZ(((dkg)localObject2).Id);
      localObject5 = com.tencent.mm.plugin.story.f.l.BbR;
      com.tencent.mm.plugin.story.f.l.axq((String)localObject3);
      localObject5 = com.tencent.mm.plugin.story.f.l.BbR;
      com.tencent.mm.plugin.story.f.l.axq((String)localObject4);
      localObject5 = com.tencent.mm.plugin.story.f.l.BbR;
      com.tencent.mm.plugin.story.f.l.aDb((String)localObject3);
      localObject5 = com.tencent.mm.plugin.story.f.l.BbR;
      com.tencent.mm.plugin.story.f.l.aDb((String)localObject4);
      long l1 = o.mF(paramString1, (String)localObject3);
      long l2 = o.mF(paramString2, (String)localObject4);
      ae.i("MicroMsg.Media.StoryDataProtoUtil", "copy video from " + paramString1 + " to " + (String)localObject3 + ", ret:" + l1);
      ae.i("MicroMsg.Media.StoryDataProtoUtil", "copy thumb from " + paramString2 + " to " + (String)localObject4 + ", ret:" + l2);
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFY, true);
      if ((bool) && (l1 >= 0L))
      {
        localObject5 = com.tencent.mm.plugin.recordvideo.e.b.yhe;
        com.tencent.mm.plugin.recordvideo.e.b.axi(paramString1);
      }
      if ((bool) && (l2 >= 0L))
      {
        paramString1 = com.tencent.mm.plugin.recordvideo.e.b.yhe;
        com.tencent.mm.plugin.recordvideo.e.b.axi(paramString2);
      }
      paramString1 = e.ayN((String)localObject3);
      float f;
      if (paramString1 != null)
      {
        f = paramString1.videoDuration / 1000.0F;
        ((dkg)localObject2).HSb = f;
        paramString1 = ((com.tencent.mm.plugin.story.i.j)localObject1).epg();
        if (paramString1.HSy.Gtx.size() != 0) {
          break label621;
        }
        paramString1.HSy.Gtx.add(localObject2);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.story.i.j)localObject1).b(paramString1);
        paramString1 = com.tencent.mm.plugin.story.f.j.BbE;
        i = j.b.elB().a((int)paramLong, (com.tencent.mm.plugin.story.i.j)localObject1);
        ae.i("MicroMsg.Media.StoryDataProtoUtil", "update mix storyInfo " + paramLong + " newVideoPath:" + (String)localObject3 + "  newThumbPath:" + (String)localObject4 + " ret:" + i);
        paramString1 = com.tencent.mm.plugin.story.f.j.BbE;
        j.b.elH().checkPost();
        AppMethodBeat.o(119323);
        return;
        f = 0.0F;
        break;
        label621:
        paramString1.HSy.Gtx.set(0, localObject2);
      }
    }
    AppMethodBeat.o(119323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.j
 * JD-Core Version:    0.7.0.1
 */