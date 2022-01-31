package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.h.o;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.s;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.Set;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoTaskCallTask;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "()V", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
final class p$e
  implements g.a
{
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(110879);
    if ((paramd != null) && (paramd.field_retCode == -21112))
    {
      ab.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreload, mediaId:" + paramString + ", video source change!");
      paramc = p.sUH;
      p.adJ(paramString);
      AppMethodBeat.o(110879);
      return 0;
    }
    Object localObject1;
    int i;
    if ((paramc != null) && (paramc.field_toltalLength > 0))
    {
      paramd = p.sUH;
      localObject1 = (i)p.cGm().get(paramString);
      paramd = p.sUH;
      paramBoolean = a.a.j.a((Iterable)p.cGn(), paramString);
      int j = (int)(paramc.field_finishedLength / paramc.field_toltalLength * 100.0F);
      paramd = p.sUH;
      paramd = (Integer)p.cGo().get(paramString);
      if (paramd == null) {
        break label561;
      }
      i = paramd.intValue();
      paramd = hashCode() + " onPreload, mediaId:" + paramString + ", startRet:" + paramInt + ", preloadOffset:" + paramc.field_finishedLength + ", totalLength: " + paramc.field_toltalLength + " desiredPreloadPercent:" + i + ", preloadPercent:" + j + " isFinish:" + paramBoolean;
      paramInt = 0;
      if ((i <= 0) || (j < i)) {
        break label573;
      }
      paramd = paramd + " exceed:true ";
      paramInt = 1;
    }
    label561:
    label573:
    for (;;)
    {
      if (localObject1 != null)
      {
        Object localObject2 = s.swk;
        localObject2 = s.a((i)localObject1);
        ((n)localObject2).field_cacheSize = paramc.field_finishedLength;
        ((n)localObject2).field_totalSize = paramc.field_toltalLength;
        paramc = com.tencent.mm.plugin.story.model.j.svi;
        j.b.cAF().b((n)localObject2);
        paramc = com.tencent.mm.plugin.story.model.j.svi;
        f localf = j.b.cAC().acU(((i)localObject1).username);
        paramc = paramd;
        if (localf.field_syncId == ((i)localObject1).cJA)
        {
          paramc = paramd;
          if (localf.isValid())
          {
            long l = ((i)localObject1).cJA;
            localObject1 = ((i)localObject1).syB.Id;
            a.f.b.j.p(localObject1, "videoItem.media.Id");
            paramc = paramd;
            if (localf.c(l, (String)localObject1, ((n)localObject2).field_cacheSize))
            {
              paramc = paramd + " * ext pre update * ";
              paramd = com.tencent.mm.plugin.story.model.j.svi;
              j.b.cAC().a((int)localf.systemRowid, localf);
            }
          }
        }
        if ((paramInt != 0) && (paramString != null))
        {
          paramd = p.sUH;
          p.cGn().add(paramString);
        }
      }
      for (paramString = paramc + "update cacheSize done";; paramString = paramd)
      {
        paramString = new StringBuilder().append(paramString).append(", currentSpeed:");
        paramc = p.sUH;
        ab.i("MicroMsg.StoryVideoPreloadMgr", p.cGl());
        AppMethodBeat.o(110879);
        return 0;
        i = 0;
        break;
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.p.e
 * JD-Core Version:    0.7.0.1
 */