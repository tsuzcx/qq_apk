package com.tencent.mm.plugin.story.model.g;

import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/upload/UploadUtil;", "", "()V", "markStoryError", "", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "errType", "", "errMsg", "", "block", "Lkotlin/Function0;", "plugin-story_release"})
public final class f
{
  public static final f sAp;
  
  static
  {
    AppMethodBeat.i(109484);
    sAp = new f();
    AppMethodBeat.o(109484);
  }
  
  public static void a(com.tencent.mm.plugin.story.h.j paramj, int paramInt, String paramString, a.f.a.a<y> parama)
  {
    AppMethodBeat.i(109483);
    a.f.b.j.q(paramj, "storyInfo");
    a.f.b.j.q(paramString, "errMsg");
    a.f.b.j.q(parama, "block");
    ab.i("MicroMsg.StoryPostTask", "processError localId " + (int)paramj.systemRowid + " processError " + paramInt + " errMsg: " + paramString);
    ab.d("MicroMsg.StoryPostTask", "post error ".concat(String.valueOf(paramInt)));
    paramj.csL();
    paramString = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAB().a((int)paramj.systemRowid, paramj);
    paramj = com.tencent.mm.plugin.story.h.a.sFV;
    if (paramInt == com.tencent.mm.plugin.story.h.a.cEg()) {
      ab.e("MicroMsg.StoryPostTask", "upload find timeLine is null delete this item");
    }
    for (;;)
    {
      parama.invoke();
      AppMethodBeat.o(109483);
      return;
      paramj = com.tencent.mm.plugin.story.h.a.sFV;
      if (paramInt == com.tencent.mm.plugin.story.h.a.cEh())
      {
        ab.e("MicroMsg.StoryPostTask", "parser protobuf error");
      }
      else
      {
        paramj = com.tencent.mm.plugin.story.h.a.sFV;
        if (paramInt == com.tencent.mm.plugin.story.h.a.cEi())
        {
          ab.e("MicroMsg.StoryPostTask", "local id is not in db");
        }
        else
        {
          paramj = com.tencent.mm.plugin.story.h.a.sFV;
          if (paramInt == com.tencent.mm.plugin.story.h.a.cEj())
          {
            ab.e("MicroMsg.StoryPostTask", "arg is error");
          }
          else
          {
            paramj = com.tencent.mm.plugin.story.h.a.sFV;
            if (paramInt == com.tencent.mm.plugin.story.h.a.cEk())
            {
              ab.e("MicroMsg.StoryPostTask", "pullTimeLineXml  error");
            }
            else
            {
              paramj = com.tencent.mm.plugin.story.h.a.sFV;
              if (paramInt == com.tencent.mm.plugin.story.h.a.cEl()) {
                ab.e("MicroMsg.StoryPostTask", "errtle  error");
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.g.f
 * JD-Core Version:    0.7.0.1
 */