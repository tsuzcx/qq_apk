package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/upload/UploadUtil;", "", "()V", "markStoryError", "", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "errType", "", "errMsg", "", "block", "Lkotlin/Function0;", "plugin-story_release"})
public final class f
{
  public static final f AOw;
  
  static
  {
    AppMethodBeat.i(119139);
    AOw = new f();
    AppMethodBeat.o(119139);
  }
  
  public static void a(com.tencent.mm.plugin.story.i.j paramj, int paramInt, String paramString, d.g.a.a<z> parama)
  {
    AppMethodBeat.i(119138);
    p.h(paramj, "storyInfo");
    p.h(paramString, "errMsg");
    p.h(parama, "block");
    ad.i("MicroMsg.StoryPostTask", "processError localId " + (int)paramj.systemRowid + " processError " + paramInt + " errMsg: " + paramString);
    ad.d("MicroMsg.StoryPostTask", "post error ".concat(String.valueOf(paramInt)));
    paramj.dYO();
    paramString = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.ehT().a((int)paramj.systemRowid, paramj);
    paramj = com.tencent.mm.plugin.story.i.a.ATp;
    if (paramInt == com.tencent.mm.plugin.story.i.a.ekP()) {
      ad.e("MicroMsg.StoryPostTask", "upload find timeLine is null delete this item");
    }
    for (;;)
    {
      parama.invoke();
      AppMethodBeat.o(119138);
      return;
      paramj = com.tencent.mm.plugin.story.i.a.ATp;
      if (paramInt == com.tencent.mm.plugin.story.i.a.ekQ())
      {
        ad.e("MicroMsg.StoryPostTask", "parser protobuf error");
      }
      else
      {
        paramj = com.tencent.mm.plugin.story.i.a.ATp;
        if (paramInt == com.tencent.mm.plugin.story.i.a.ekR())
        {
          ad.e("MicroMsg.StoryPostTask", "local id is not in db");
        }
        else
        {
          paramj = com.tencent.mm.plugin.story.i.a.ATp;
          if (paramInt == com.tencent.mm.plugin.story.i.a.ekS())
          {
            ad.e("MicroMsg.StoryPostTask", "arg is error");
          }
          else
          {
            paramj = com.tencent.mm.plugin.story.i.a.ATp;
            if (paramInt == com.tencent.mm.plugin.story.i.a.ekT())
            {
              ad.e("MicroMsg.StoryPostTask", "pullTimeLineXml  error");
            }
            else
            {
              paramj = com.tencent.mm.plugin.story.i.a.ATp;
              if (paramInt == com.tencent.mm.plugin.story.i.a.ekU()) {
                ad.e("MicroMsg.StoryPostTask", "errtle  error");
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