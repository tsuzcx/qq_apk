package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/upload/UploadUtil;", "", "()V", "markStoryError", "", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "errType", "", "errMsg", "", "block", "Lkotlin/Function0;", "plugin-story_release"})
public final class f
{
  public static final f yjB;
  
  static
  {
    AppMethodBeat.i(119139);
    yjB = new f();
    AppMethodBeat.o(119139);
  }
  
  public static void a(com.tencent.mm.plugin.story.i.j paramj, int paramInt, String paramString, d.g.a.a<y> parama)
  {
    AppMethodBeat.i(119138);
    d.g.b.k.h(paramj, "storyInfo");
    d.g.b.k.h(paramString, "errMsg");
    d.g.b.k.h(parama, "block");
    ad.i("MicroMsg.StoryPostTask", "processError localId " + (int)paramj.systemRowid + " processError " + paramInt + " errMsg: " + paramString);
    ad.d("MicroMsg.StoryPostTask", "post error ".concat(String.valueOf(paramInt)));
    paramj.dyb();
    paramString = com.tencent.mm.plugin.story.f.j.yfh;
    j.b.dHd().a((int)paramj.systemRowid, paramj);
    paramj = com.tencent.mm.plugin.story.i.a.yor;
    if (paramInt == com.tencent.mm.plugin.story.i.a.dJZ()) {
      ad.e("MicroMsg.StoryPostTask", "upload find timeLine is null delete this item");
    }
    for (;;)
    {
      parama.invoke();
      AppMethodBeat.o(119138);
      return;
      paramj = com.tencent.mm.plugin.story.i.a.yor;
      if (paramInt == com.tencent.mm.plugin.story.i.a.dKa())
      {
        ad.e("MicroMsg.StoryPostTask", "parser protobuf error");
      }
      else
      {
        paramj = com.tencent.mm.plugin.story.i.a.yor;
        if (paramInt == com.tencent.mm.plugin.story.i.a.dKb())
        {
          ad.e("MicroMsg.StoryPostTask", "local id is not in db");
        }
        else
        {
          paramj = com.tencent.mm.plugin.story.i.a.yor;
          if (paramInt == com.tencent.mm.plugin.story.i.a.dKc())
          {
            ad.e("MicroMsg.StoryPostTask", "arg is error");
          }
          else
          {
            paramj = com.tencent.mm.plugin.story.i.a.yor;
            if (paramInt == com.tencent.mm.plugin.story.i.a.dKd())
            {
              ad.e("MicroMsg.StoryPostTask", "pullTimeLineXml  error");
            }
            else
            {
              paramj = com.tencent.mm.plugin.story.i.a.yor;
              if (paramInt == com.tencent.mm.plugin.story.i.a.dKe()) {
                ad.e("MicroMsg.StoryPostTask", "errtle  error");
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.f
 * JD-Core Version:    0.7.0.1
 */