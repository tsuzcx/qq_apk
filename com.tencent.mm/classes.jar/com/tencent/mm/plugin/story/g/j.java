package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.story.f.g.c;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.i.a.d;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.n.d;
import d.v;
import java.nio.charset.Charset;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/presenter/StoryDataProtoUtil;", "", "()V", "TAG", "", "signStoryDataMix", "", "localId", "", "mixVideoPath", "mixThumbPath", "signStoryDataMixEnable", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "signStoryDataMixError", "", "signStoryDataMixTime", "plugin-story_release"})
public final class j
{
  public static final j ylv;
  
  static
  {
    AppMethodBeat.i(119325);
    ylv = new j();
    AppMethodBeat.o(119325);
  }
  
  public static void Oy(int paramInt)
  {
    AppMethodBeat.i(119324);
    ad.i("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMixError ".concat(String.valueOf(paramInt)));
    Object localObject = com.tencent.mm.plugin.story.f.j.yfh;
    localObject = j.b.dHd().OI(paramInt);
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.story.i.j)localObject).dyb();
      j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
      j.b.dHd().a(paramInt, (com.tencent.mm.plugin.story.i.j)localObject);
    }
    AppMethodBeat.o(119324);
  }
  
  public static void d(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(119323);
    d.g.b.k.h(paramString1, "mixVideoPath");
    d.g.b.k.h(paramString2, "mixThumbPath");
    ad.d("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMix localId:" + paramLong + " mixVideoPath:" + paramString1 + " mixThumbPath:" + paramString2);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
    localObject1 = j.b.dHd().OI((int)paramLong);
    if (localObject1 != null)
    {
      int i = ((com.tencent.mm.plugin.story.i.j)localObject1).field_localFlag;
      Object localObject2 = a.d.yoA;
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_localFlag = (i & (a.d.dKp() ^ 0xFFFFFFFF));
      ((com.tencent.mm.plugin.story.i.j)localObject1).setPostWaiting();
      localObject2 = q.yfy;
      localObject2 = new cym();
      Object localObject3 = new StringBuilder();
      Object localObject4 = com.tencent.mm.plugin.story.e.b.yej;
      localObject3 = ((StringBuilder)localObject3).append(com.tencent.mm.plugin.story.e.b.dGC());
      localObject4 = ce.asR() + '-' + bt.GC();
      Object localObject5 = d.UTF_8;
      if (localObject4 == null)
      {
        paramString1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(119323);
        throw paramString1;
      }
      localObject4 = ((String)localObject4).getBytes((Charset)localObject5);
      d.g.b.k.g(localObject4, "(this as java.lang.String).getBytes(charset)");
      ((cym)localObject2).Id = com.tencent.mm.b.g.getMessageDigest((byte[])localObject4);
      localObject3 = com.tencent.mm.plugin.story.f.l.yfu;
      localObject3 = com.tencent.mm.plugin.story.f.l.art(((cym)localObject2).Id);
      localObject4 = com.tencent.mm.plugin.story.f.l.yfu;
      localObject4 = com.tencent.mm.plugin.story.f.l.ars(((cym)localObject2).Id);
      localObject5 = com.tencent.mm.plugin.story.f.l.yfu;
      com.tencent.mm.plugin.story.f.l.alY((String)localObject3);
      localObject5 = com.tencent.mm.plugin.story.f.l.yfu;
      com.tencent.mm.plugin.story.f.l.alY((String)localObject4);
      localObject5 = com.tencent.mm.plugin.story.f.l.yfu;
      com.tencent.mm.plugin.story.f.l.aru((String)localObject3);
      localObject5 = com.tencent.mm.plugin.story.f.l.yfu;
      com.tencent.mm.plugin.story.f.l.aru((String)localObject4);
      long l1 = i.lC(paramString1, (String)localObject3);
      long l2 = i.lC(paramString2, (String)localObject4);
      ad.i("MicroMsg.Media.StoryDataProtoUtil", "copy video from " + paramString1 + " to " + (String)localObject3 + ", ret:" + l1);
      ad.i("MicroMsg.Media.StoryDataProtoUtil", "copy thumb from " + paramString2 + " to " + (String)localObject4 + ", ret:" + l2);
      boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqz, true);
      if ((bool) && (l1 >= 0L))
      {
        localObject5 = com.tencent.mm.plugin.recordvideo.e.b.vtE;
        com.tencent.mm.plugin.recordvideo.e.b.alS(paramString1);
      }
      if ((bool) && (l2 >= 0L))
      {
        paramString1 = com.tencent.mm.plugin.recordvideo.e.b.vtE;
        com.tencent.mm.plugin.recordvideo.e.b.alS(paramString2);
      }
      paramString1 = e.ano((String)localObject3);
      float f;
      if (paramString1 != null)
      {
        f = paramString1.videoDuration / 1000.0F;
        ((cym)localObject2).EqD = f;
        paramString1 = ((com.tencent.mm.plugin.story.i.j)localObject1).dKH();
        if (paramString1.Era.DaC.size() != 0) {
          break label621;
        }
        paramString1.Era.DaC.add(localObject2);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.story.i.j)localObject1).b(paramString1);
        paramString1 = com.tencent.mm.plugin.story.f.j.yfh;
        i = j.b.dHd().a((int)paramLong, (com.tencent.mm.plugin.story.i.j)localObject1);
        ad.i("MicroMsg.Media.StoryDataProtoUtil", "update mix storyInfo " + paramLong + " newVideoPath:" + (String)localObject3 + "  newThumbPath:" + (String)localObject4 + " ret:" + i);
        paramString1 = com.tencent.mm.plugin.story.f.j.yfh;
        j.b.dHj().checkPost();
        AppMethodBeat.o(119323);
        return;
        f = 0.0F;
        break;
        label621:
        paramString1.Era.DaC.set(0, localObject2);
      }
    }
    AppMethodBeat.o(119323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.j
 * JD-Core Version:    0.7.0.1
 */