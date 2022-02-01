package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.plugin.story.f.g.c;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.i.a.d;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.enl;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.nio.charset.Charset;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/presenter/StoryDataProtoUtil;", "", "()V", "TAG", "", "signStoryDataMix", "", "localId", "", "mixVideoPath", "mixThumbPath", "signStoryDataMixEnable", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "signStoryDataMixError", "", "signStoryDataMixTime", "plugin-story_release"})
public final class j
{
  public static final j LML;
  
  static
  {
    AppMethodBeat.i(119325);
    LML = new j();
    AppMethodBeat.o(119325);
  }
  
  public static void ail(int paramInt)
  {
    AppMethodBeat.i(119324);
    Log.i("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMixError ".concat(String.valueOf(paramInt)));
    Object localObject = com.tencent.mm.plugin.story.f.j.LGA;
    localObject = j.b.gcw().aiv(paramInt);
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.story.i.j)localObject).setItemDie();
      j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.gcw().a(paramInt, (com.tencent.mm.plugin.story.i.j)localObject);
    }
    AppMethodBeat.o(119324);
  }
  
  public static void g(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(119323);
    p.k(paramString1, "mixVideoPath");
    p.k(paramString2, "mixThumbPath");
    Log.d("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMix localId:" + paramLong + " mixVideoPath:" + paramString1 + " mixThumbPath:" + paramString2);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
    localObject1 = j.b.gcw().aiv((int)paramLong);
    if (localObject1 != null)
    {
      int i = ((com.tencent.mm.plugin.story.i.j)localObject1).field_localFlag;
      Object localObject2 = a.d.LPP;
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_localFlag = (i & (a.d.gfK() ^ 0xFFFFFFFF));
      ((com.tencent.mm.plugin.story.i.j)localObject1).setPostWaiting();
      localObject2 = q.LGQ;
      localObject2 = new enu();
      Object localObject3 = new StringBuilder();
      Object localObject4 = com.tencent.mm.plugin.story.e.b.LFC;
      localObject3 = ((StringBuilder)localObject3).append(com.tencent.mm.plugin.story.e.b.gbV());
      localObject4 = cm.bfD() + '-' + Util.currentTicks();
      Object localObject5 = kotlin.n.d.UTF_8;
      if (localObject4 == null)
      {
        paramString1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(119323);
        throw paramString1;
      }
      localObject4 = ((String)localObject4).getBytes((Charset)localObject5);
      p.j(localObject4, "(this as java.lang.String).getBytes(charset)");
      ((enu)localObject2).Id = g.getMessageDigest((byte[])localObject4);
      localObject3 = com.tencent.mm.plugin.story.f.l.LGM;
      localObject3 = com.tencent.mm.plugin.story.f.l.bda(((enu)localObject2).Id);
      localObject4 = com.tencent.mm.plugin.story.f.l.LGM;
      localObject4 = com.tencent.mm.plugin.story.f.l.bcZ(((enu)localObject2).Id);
      localObject5 = com.tencent.mm.plugin.story.f.l.LGM;
      com.tencent.mm.plugin.story.f.l.aWs((String)localObject3);
      localObject5 = com.tencent.mm.plugin.story.f.l.LGM;
      com.tencent.mm.plugin.story.f.l.aWs((String)localObject4);
      localObject5 = com.tencent.mm.plugin.story.f.l.LGM;
      com.tencent.mm.plugin.story.f.l.bdb((String)localObject3);
      localObject5 = com.tencent.mm.plugin.story.f.l.LGM;
      com.tencent.mm.plugin.story.f.l.bdb((String)localObject4);
      long l1 = u.on(paramString1, (String)localObject3);
      long l2 = u.on(paramString2, (String)localObject4);
      Log.i("MicroMsg.Media.StoryDataProtoUtil", "copy video from " + paramString1 + " to " + (String)localObject3 + ", ret:" + l1);
      Log.i("MicroMsg.Media.StoryDataProtoUtil", "copy thumb from " + paramString2 + " to " + (String)localObject4 + ", ret:" + l2);
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGj, true);
      if ((bool) && (l1 >= 0L))
      {
        localObject5 = com.tencent.mm.plugin.recordvideo.e.d.IeU;
        com.tencent.mm.plugin.recordvideo.e.d.aWk(paramString1);
      }
      if ((bool) && (l2 >= 0L))
      {
        paramString1 = com.tencent.mm.plugin.recordvideo.e.d.IeU;
        com.tencent.mm.plugin.recordvideo.e.d.aWk(paramString2);
      }
      paramString1 = f.aYg((String)localObject3);
      float f;
      if (paramString1 != null)
      {
        f = paramString1.videoDuration / 1000.0F;
        ((enu)localObject2).UqC = f;
        paramString1 = ((com.tencent.mm.plugin.story.i.j)localObject1).ggc();
        if (paramString1.Ura.Sqr.size() != 0) {
          break label621;
        }
        paramString1.Ura.Sqr.add(localObject2);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.story.i.j)localObject1).b(paramString1);
        paramString1 = com.tencent.mm.plugin.story.f.j.LGA;
        i = j.b.gcw().a((int)paramLong, (com.tencent.mm.plugin.story.i.j)localObject1);
        Log.i("MicroMsg.Media.StoryDataProtoUtil", "update mix storyInfo " + paramLong + " newVideoPath:" + (String)localObject3 + "  newThumbPath:" + (String)localObject4 + " ret:" + i);
        paramString1 = com.tencent.mm.plugin.story.f.j.LGA;
        j.b.gcC().checkPost();
        AppMethodBeat.o(119323);
        return;
        f = 0.0F;
        break;
        label621:
        paramString1.Ura.Sqr.set(0, localObject2);
      }
    }
    AppMethodBeat.o(119323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.j
 * JD-Core Version:    0.7.0.1
 */