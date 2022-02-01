package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.story.f.g.c;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.i.a.d;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.n.d;
import d.v;
import java.nio.charset.Charset;
import java.util.LinkedList;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/presenter/StoryDataProtoUtil;", "", "()V", "TAG", "", "signStoryDataMix", "", "localId", "", "mixVideoPath", "mixThumbPath", "signStoryDataMixEnable", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "signStoryDataMixError", "", "signStoryDataMixTime", "plugin-story_release"})
public final class j
{
  public static final j AQt;
  
  static
  {
    AppMethodBeat.i(119325);
    AQt = new j();
    AppMethodBeat.o(119325);
  }
  
  public static void Sn(int paramInt)
  {
    AppMethodBeat.i(119324);
    ad.i("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMixError ".concat(String.valueOf(paramInt)));
    Object localObject = com.tencent.mm.plugin.story.f.j.AKb;
    localObject = j.b.ehT().Sx(paramInt);
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.story.i.j)localObject).dYO();
      j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.ehT().a(paramInt, (com.tencent.mm.plugin.story.i.j)localObject);
    }
    AppMethodBeat.o(119324);
  }
  
  public static void e(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(119323);
    p.h(paramString1, "mixVideoPath");
    p.h(paramString2, "mixThumbPath");
    ad.d("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMix localId:" + paramLong + " mixVideoPath:" + paramString1 + " mixThumbPath:" + paramString2);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
    localObject1 = j.b.ehT().Sx((int)paramLong);
    if (localObject1 != null)
    {
      int i = ((com.tencent.mm.plugin.story.i.j)localObject1).field_localFlag;
      Object localObject2 = a.d.ATy;
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_localFlag = (i & (a.d.elf() ^ 0xFFFFFFFF));
      ((com.tencent.mm.plugin.story.i.j)localObject1).setPostWaiting();
      localObject2 = q.AKs;
      localObject2 = new djl();
      Object localObject3 = new StringBuilder();
      Object localObject4 = com.tencent.mm.plugin.story.e.b.AJd;
      localObject3 = ((StringBuilder)localObject3).append(com.tencent.mm.plugin.story.e.b.ehs());
      localObject4 = cf.aCL() + '-' + bt.HI();
      Object localObject5 = d.UTF_8;
      if (localObject4 == null)
      {
        paramString1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(119323);
        throw paramString1;
      }
      localObject4 = ((String)localObject4).getBytes((Charset)localObject5);
      p.g(localObject4, "(this as java.lang.String).getBytes(charset)");
      ((djl)localObject2).Id = com.tencent.mm.b.g.getMessageDigest((byte[])localObject4);
      localObject3 = com.tencent.mm.plugin.story.f.l.AKo;
      localObject3 = com.tencent.mm.plugin.story.f.l.aBH(((djl)localObject2).Id);
      localObject4 = com.tencent.mm.plugin.story.f.l.AKo;
      localObject4 = com.tencent.mm.plugin.story.f.l.aBG(((djl)localObject2).Id);
      localObject5 = com.tencent.mm.plugin.story.f.l.AKo;
      com.tencent.mm.plugin.story.f.l.awb((String)localObject3);
      localObject5 = com.tencent.mm.plugin.story.f.l.AKo;
      com.tencent.mm.plugin.story.f.l.awb((String)localObject4);
      localObject5 = com.tencent.mm.plugin.story.f.l.AKo;
      com.tencent.mm.plugin.story.f.l.aBI((String)localObject3);
      localObject5 = com.tencent.mm.plugin.story.f.l.AKo;
      com.tencent.mm.plugin.story.f.l.aBI((String)localObject4);
      long l1 = i.mz(paramString1, (String)localObject3);
      long l2 = i.mz(paramString2, (String)localObject4);
      ad.i("MicroMsg.Media.StoryDataProtoUtil", "copy video from " + paramString1 + " to " + (String)localObject3 + ", ret:" + l1);
      ad.i("MicroMsg.Media.StoryDataProtoUtil", "copy thumb from " + paramString2 + " to " + (String)localObject4 + ", ret:" + l2);
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyS, true);
      if ((bool) && (l1 >= 0L))
      {
        localObject5 = com.tencent.mm.plugin.recordvideo.e.b.xRl;
        com.tencent.mm.plugin.recordvideo.e.b.avT(paramString1);
      }
      if ((bool) && (l2 >= 0L))
      {
        paramString1 = com.tencent.mm.plugin.recordvideo.e.b.xRl;
        com.tencent.mm.plugin.recordvideo.e.b.avT(paramString2);
      }
      paramString1 = e.axx((String)localObject3);
      float f;
      if (paramString1 != null)
      {
        f = paramString1.videoDuration / 1000.0F;
        ((djl)localObject2).Hyq = f;
        paramString1 = ((com.tencent.mm.plugin.story.i.j)localObject1).elx();
        if (paramString1.HyN.GaQ.size() != 0) {
          break label621;
        }
        paramString1.HyN.GaQ.add(localObject2);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.story.i.j)localObject1).b(paramString1);
        paramString1 = com.tencent.mm.plugin.story.f.j.AKb;
        i = j.b.ehT().a((int)paramLong, (com.tencent.mm.plugin.story.i.j)localObject1);
        ad.i("MicroMsg.Media.StoryDataProtoUtil", "update mix storyInfo " + paramLong + " newVideoPath:" + (String)localObject3 + "  newThumbPath:" + (String)localObject4 + " ret:" + i);
        paramString1 = com.tencent.mm.plugin.story.f.j.AKb;
        j.b.ehZ().checkPost();
        AppMethodBeat.o(119323);
        return;
        f = 0.0F;
        break;
        label621:
        paramString1.HyN.GaQ.set(0, localObject2);
      }
    }
    AppMethodBeat.o(119323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.j
 * JD-Core Version:    0.7.0.1
 */