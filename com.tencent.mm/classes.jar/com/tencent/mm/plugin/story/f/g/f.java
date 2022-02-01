package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/upload/UploadUtil;", "", "()V", "markStoryError", "", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "errType", "", "errMsg", "", "block", "Lkotlin/Function0;", "plugin-story_release"})
public final class f
{
  public static final f BfX;
  
  static
  {
    AppMethodBeat.i(119139);
    BfX = new f();
    AppMethodBeat.o(119139);
  }
  
  public static void a(com.tencent.mm.plugin.story.i.j paramj, int paramInt, String paramString, d.g.a.a<z> parama)
  {
    AppMethodBeat.i(119138);
    p.h(paramj, "storyInfo");
    p.h(paramString, "errMsg");
    p.h(parama, "block");
    ae.i("MicroMsg.StoryPostTask", "processError localId " + (int)paramj.systemRowid + " processError " + paramInt + " errMsg: " + paramString);
    ae.d("MicroMsg.StoryPostTask", "post error ".concat(String.valueOf(paramInt)));
    paramj.ecs();
    paramString = com.tencent.mm.plugin.story.f.j.BbE;
    j.b.elB().a((int)paramj.systemRowid, paramj);
    paramj = com.tencent.mm.plugin.story.i.a.BkN;
    if (paramInt == com.tencent.mm.plugin.story.i.a.eoy()) {
      ae.e("MicroMsg.StoryPostTask", "upload find timeLine is null delete this item");
    }
    for (;;)
    {
      parama.invoke();
      AppMethodBeat.o(119138);
      return;
      paramj = com.tencent.mm.plugin.story.i.a.BkN;
      if (paramInt == com.tencent.mm.plugin.story.i.a.eoz())
      {
        ae.e("MicroMsg.StoryPostTask", "parser protobuf error");
      }
      else
      {
        paramj = com.tencent.mm.plugin.story.i.a.BkN;
        if (paramInt == com.tencent.mm.plugin.story.i.a.eoA())
        {
          ae.e("MicroMsg.StoryPostTask", "local id is not in db");
        }
        else
        {
          paramj = com.tencent.mm.plugin.story.i.a.BkN;
          if (paramInt == com.tencent.mm.plugin.story.i.a.eoB())
          {
            ae.e("MicroMsg.StoryPostTask", "arg is error");
          }
          else
          {
            paramj = com.tencent.mm.plugin.story.i.a.BkN;
            if (paramInt == com.tencent.mm.plugin.story.i.a.eoC())
            {
              ae.e("MicroMsg.StoryPostTask", "pullTimeLineXml  error");
            }
            else
            {
              paramj = com.tencent.mm.plugin.story.i.a.BkN;
              if (paramInt == com.tencent.mm.plugin.story.i.a.eoD()) {
                ae.e("MicroMsg.StoryPostTask", "errtle  error");
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.f
 * JD-Core Version:    0.7.0.1
 */