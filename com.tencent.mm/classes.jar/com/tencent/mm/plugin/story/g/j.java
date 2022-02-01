package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.i.a.d;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.nio.charset.Charset;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.n.d;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/presenter/StoryDataProtoUtil;", "", "()V", "TAG", "", "signStoryDataMix", "", "localId", "", "mixVideoPath", "mixThumbPath", "signStoryDataMixEnable", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "signStoryDataMixError", "", "signStoryDataMixTime", "plugin-story_release"})
public final class j
{
  public static final j FsI;
  
  static
  {
    AppMethodBeat.i(119325);
    FsI = new j();
    AppMethodBeat.o(119325);
  }
  
  public static void aaQ(int paramInt)
  {
    AppMethodBeat.i(119324);
    Log.i("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMixError ".concat(String.valueOf(paramInt)));
    Object localObject = com.tencent.mm.plugin.story.f.j.Fmy;
    localObject = j.b.foc().aba(paramInt);
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.story.i.j)localObject).setItemDie();
      j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.foc().a(paramInt, (com.tencent.mm.plugin.story.i.j)localObject);
    }
    AppMethodBeat.o(119324);
  }
  
  public static void e(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(119323);
    p.h(paramString1, "mixVideoPath");
    p.h(paramString2, "mixThumbPath");
    Log.d("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMix localId:" + paramLong + " mixVideoPath:" + paramString1 + " mixThumbPath:" + paramString2);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
    localObject1 = j.b.foc().aba((int)paramLong);
    if (localObject1 != null)
    {
      int i = ((com.tencent.mm.plugin.story.i.j)localObject1).field_localFlag;
      Object localObject2 = a.d.FvM;
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_localFlag = (i & (a.d.fro() ^ 0xFFFFFFFF));
      ((com.tencent.mm.plugin.story.i.j)localObject1).setPostWaiting();
      localObject2 = q.FmO;
      localObject2 = new edt();
      Object localObject3 = new StringBuilder();
      Object localObject4 = com.tencent.mm.plugin.story.e.b.FlA;
      localObject3 = ((StringBuilder)localObject3).append(com.tencent.mm.plugin.story.e.b.fnB());
      localObject4 = cl.aWz() + '-' + Util.currentTicks();
      Object localObject5 = d.UTF_8;
      if (localObject4 == null)
      {
        paramString1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(119323);
        throw paramString1;
      }
      localObject4 = ((String)localObject4).getBytes((Charset)localObject5);
      p.g(localObject4, "(this as java.lang.String).getBytes(charset)");
      ((edt)localObject2).Id = com.tencent.mm.b.g.getMessageDigest((byte[])localObject4);
      localObject3 = com.tencent.mm.plugin.story.f.l.FmK;
      localObject3 = com.tencent.mm.plugin.story.f.l.aRW(((edt)localObject2).Id);
      localObject4 = com.tencent.mm.plugin.story.f.l.FmK;
      localObject4 = com.tencent.mm.plugin.story.f.l.aRV(((edt)localObject2).Id);
      localObject5 = com.tencent.mm.plugin.story.f.l.FmK;
      com.tencent.mm.plugin.story.f.l.aLP((String)localObject3);
      localObject5 = com.tencent.mm.plugin.story.f.l.FmK;
      com.tencent.mm.plugin.story.f.l.aLP((String)localObject4);
      localObject5 = com.tencent.mm.plugin.story.f.l.FmK;
      com.tencent.mm.plugin.story.f.l.aRX((String)localObject3);
      localObject5 = com.tencent.mm.plugin.story.f.l.FmK;
      com.tencent.mm.plugin.story.f.l.aRX((String)localObject4);
      long l1 = s.nw(paramString1, (String)localObject3);
      long l2 = s.nw(paramString2, (String)localObject4);
      Log.i("MicroMsg.Media.StoryDataProtoUtil", "copy video from " + paramString1 + " to " + (String)localObject3 + ", ret:" + l1);
      Log.i("MicroMsg.Media.StoryDataProtoUtil", "copy thumb from " + paramString2 + " to " + (String)localObject4 + ", ret:" + l2);
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZl, true);
      if ((bool) && (l1 >= 0L))
      {
        localObject5 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
        com.tencent.mm.plugin.recordvideo.e.c.aLG(paramString1);
      }
      if ((bool) && (l2 >= 0L))
      {
        paramString1 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
        com.tencent.mm.plugin.recordvideo.e.c.aLG(paramString2);
      }
      paramString1 = e.aNx((String)localObject3);
      float f;
      if (paramString1 != null)
      {
        f = paramString1.videoDuration / 1000.0F;
        ((edt)localObject2).Ned = f;
        paramString1 = ((com.tencent.mm.plugin.story.i.j)localObject1).frG();
        if (paramString1.NeB.LoV.size() != 0) {
          break label621;
        }
        paramString1.NeB.LoV.add(localObject2);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.story.i.j)localObject1).b(paramString1);
        paramString1 = com.tencent.mm.plugin.story.f.j.Fmy;
        i = j.b.foc().a((int)paramLong, (com.tencent.mm.plugin.story.i.j)localObject1);
        Log.i("MicroMsg.Media.StoryDataProtoUtil", "update mix storyInfo " + paramLong + " newVideoPath:" + (String)localObject3 + "  newThumbPath:" + (String)localObject4 + " ret:" + i);
        paramString1 = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.foi().checkPost();
        AppMethodBeat.o(119323);
        return;
        f = 0.0F;
        break;
        label621:
        paramString1.NeB.LoV.set(0, localObject2);
      }
    }
    AppMethodBeat.o(119323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.j
 * JD-Core Version:    0.7.0.1
 */