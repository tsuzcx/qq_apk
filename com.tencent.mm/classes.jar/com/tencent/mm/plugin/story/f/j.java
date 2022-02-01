package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.story.h.a.d;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.p;
import com.tencent.mm.protocal.protobuf.fij;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.nio.charset.Charset;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/presenter/StoryDataProtoUtil;", "", "()V", "TAG", "", "signStoryDataMix", "", "localId", "", "mixVideoPath", "mixThumbPath", "signStoryDataMixEnable", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "signStoryDataMixError", "", "signStoryDataMixTime", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j SpD;
  
  static
  {
    AppMethodBeat.i(119325);
    SpD = new j();
    AppMethodBeat.o(119325);
  }
  
  public static void anl(int paramInt)
  {
    AppMethodBeat.i(119324);
    Log.i("MicroMsg.Media.StoryDataProtoUtil", s.X("signStoryDataMixError ", Integer.valueOf(paramInt)));
    Object localObject = StoryCore.SjP;
    localObject = StoryCore.b.hvR().anv(paramInt);
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.story.h.j)localObject).setItemDie();
      StoryCore.b localb = StoryCore.SjP;
      StoryCore.b.hvR().a(paramInt, (com.tencent.mm.plugin.story.h.j)localObject);
    }
    AppMethodBeat.o(119324);
  }
  
  public static void h(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(119323);
    s.u(paramString1, "mixVideoPath");
    s.u(paramString2, "mixThumbPath");
    Log.d("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMix localId:" + paramLong + " mixVideoPath:" + paramString1 + " mixThumbPath:" + paramString2);
    Object localObject1 = StoryCore.SjP;
    localObject1 = StoryCore.b.hvR().anv((int)paramLong);
    int i;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    float f;
    if (localObject1 != null)
    {
      i = ((com.tencent.mm.plugin.story.h.j)localObject1).field_localFlag;
      localObject2 = a.d.Ssx;
      ((com.tencent.mm.plugin.story.h.j)localObject1).field_localFlag = (i & (a.d.hzc() ^ 0xFFFFFFFF));
      ((com.tencent.mm.plugin.story.h.j)localObject1).setPostWaiting();
      localObject2 = p.Sku;
      localObject2 = new fis();
      localObject3 = com.tencent.mm.plugin.story.e.b.Sjl;
      localObject3 = com.tencent.mm.plugin.story.e.b.hvm();
      localObject4 = cn.bDv() + '-' + Util.currentTicks();
      Object localObject5 = d.UTF_8;
      if (localObject4 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(119323);
        throw paramString1;
      }
      localObject4 = ((String)localObject4).getBytes((Charset)localObject5);
      s.s(localObject4, "(this as java.lang.String).getBytes(charset)");
      ((fis)localObject2).Id = s.X((String)localObject3, g.getMessageDigest((byte[])localObject4));
      localObject3 = com.tencent.mm.plugin.story.model.k.Skq;
      localObject3 = com.tencent.mm.plugin.story.model.k.bbN(((fis)localObject2).Id);
      localObject4 = com.tencent.mm.plugin.story.model.k.Skq;
      localObject4 = com.tencent.mm.plugin.story.model.k.bbM(((fis)localObject2).Id);
      localObject5 = com.tencent.mm.plugin.story.model.k.Skq;
      com.tencent.mm.plugin.story.model.k.aTB((String)localObject3);
      localObject5 = com.tencent.mm.plugin.story.model.k.Skq;
      com.tencent.mm.plugin.story.model.k.aTB((String)localObject4);
      localObject5 = com.tencent.mm.plugin.story.model.k.Skq;
      com.tencent.mm.plugin.story.model.k.bbO((String)localObject3);
      localObject5 = com.tencent.mm.plugin.story.model.k.Skq;
      com.tencent.mm.plugin.story.model.k.bbO((String)localObject4);
      long l1 = y.O(paramString1, (String)localObject3, false);
      long l2 = y.O(paramString2, (String)localObject4, false);
      Log.i("MicroMsg.Media.StoryDataProtoUtil", "copy video from " + paramString1 + " to " + (String)localObject3 + ", ret:" + l1);
      Log.i("MicroMsg.Media.StoryDataProtoUtil", "copy thumb from " + paramString2 + " to " + (String)localObject4 + ", ret:" + l2);
      boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVR, true);
      if ((bool) && (l1 >= 0L))
      {
        localObject5 = com.tencent.mm.plugin.recordvideo.util.f.Obq;
        com.tencent.mm.plugin.recordvideo.util.f.aTt(paramString1);
      }
      if ((bool) && (l2 >= 0L))
      {
        paramString1 = com.tencent.mm.plugin.recordvideo.util.f.Obq;
        com.tencent.mm.plugin.recordvideo.util.f.aTt(paramString2);
      }
      paramString1 = com.tencent.mm.plugin.sight.base.f.aVX((String)localObject3);
      if (paramString1 != null) {
        break label592;
      }
      f = 0.0F;
      ((fis)localObject2).abJB = f;
      paramString1 = ((com.tencent.mm.plugin.story.h.j)localObject1).hzt();
      if (paramString1.abJZ.Zpr.size() != 0) {
        break label606;
      }
      paramString1.abJZ.Zpr.add(localObject2);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.story.h.j)localObject1).b(paramString1);
      paramString1 = StoryCore.SjP;
      i = StoryCore.b.hvR().a((int)paramLong, (com.tencent.mm.plugin.story.h.j)localObject1);
      Log.i("MicroMsg.Media.StoryDataProtoUtil", "update mix storyInfo " + paramLong + " newVideoPath:" + (String)localObject3 + "  newThumbPath:" + (String)localObject4 + " ret:" + i);
      paramString1 = StoryCore.SjP;
      StoryCore.b.hvX().checkPost();
      AppMethodBeat.o(119323);
      return;
      label592:
      f = paramString1.videoDuration / 1000.0F;
      break;
      label606:
      paramString1.abJZ.Zpr.set(0, localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.j
 * JD-Core Version:    0.7.0.1
 */