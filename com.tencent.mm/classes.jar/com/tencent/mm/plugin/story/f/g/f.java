package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/upload/UploadUtil;", "", "()V", "markStoryError", "", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "errType", "", "errMsg", "", "block", "Lkotlin/Function0;", "plugin-story_release"})
public final class f
{
  public static final f zwA;
  
  static
  {
    AppMethodBeat.i(119139);
    zwA = new f();
    AppMethodBeat.o(119139);
  }
  
  public static void a(com.tencent.mm.plugin.story.i.j paramj, int paramInt, String paramString, d.g.a.a<y> parama)
  {
    AppMethodBeat.i(119138);
    d.g.b.k.h(paramj, "storyInfo");
    d.g.b.k.h(paramString, "errMsg");
    d.g.b.k.h(parama, "block");
    ac.i("MicroMsg.StoryPostTask", "processError localId " + (int)paramj.systemRowid + " processError " + paramInt + " errMsg: " + paramString);
    ac.d("MicroMsg.StoryPostTask", "post error ".concat(String.valueOf(paramInt)));
    paramj.dMy();
    paramString = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dVE().a((int)paramj.systemRowid, paramj);
    paramj = com.tencent.mm.plugin.story.i.a.zBQ;
    if (paramInt == com.tencent.mm.plugin.story.i.a.dYA()) {
      ac.e("MicroMsg.StoryPostTask", "upload find timeLine is null delete this item");
    }
    for (;;)
    {
      parama.invoke();
      AppMethodBeat.o(119138);
      return;
      paramj = com.tencent.mm.plugin.story.i.a.zBQ;
      if (paramInt == com.tencent.mm.plugin.story.i.a.dYB())
      {
        ac.e("MicroMsg.StoryPostTask", "parser protobuf error");
      }
      else
      {
        paramj = com.tencent.mm.plugin.story.i.a.zBQ;
        if (paramInt == com.tencent.mm.plugin.story.i.a.dYC())
        {
          ac.e("MicroMsg.StoryPostTask", "local id is not in db");
        }
        else
        {
          paramj = com.tencent.mm.plugin.story.i.a.zBQ;
          if (paramInt == com.tencent.mm.plugin.story.i.a.dYD())
          {
            ac.e("MicroMsg.StoryPostTask", "arg is error");
          }
          else
          {
            paramj = com.tencent.mm.plugin.story.i.a.zBQ;
            if (paramInt == com.tencent.mm.plugin.story.i.a.dYE())
            {
              ac.e("MicroMsg.StoryPostTask", "pullTimeLineXml  error");
            }
            else
            {
              paramj = com.tencent.mm.plugin.story.i.a.zBQ;
              if (paramInt == com.tencent.mm.plugin.story.i.a.dYF()) {
                ac.e("MicroMsg.StoryPostTask", "errtle  error");
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.f
 * JD-Core Version:    0.7.0.1
 */