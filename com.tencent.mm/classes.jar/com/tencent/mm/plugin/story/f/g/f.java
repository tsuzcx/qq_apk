package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/upload/UploadUtil;", "", "()V", "markStoryError", "", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "errType", "", "errMsg", "", "block", "Lkotlin/Function0;", "plugin-story_release"})
public final class f
{
  public static final f LKR;
  
  static
  {
    AppMethodBeat.i(119139);
    LKR = new f();
    AppMethodBeat.o(119139);
  }
  
  public static void a(com.tencent.mm.plugin.story.i.j paramj, int paramInt, String paramString, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(119138);
    p.k(paramj, "storyInfo");
    p.k(paramString, "errMsg");
    p.k(parama, "block");
    Log.i("MicroMsg.StoryPostTask", "processError localId " + (int)paramj.systemRowid + " processError " + paramInt + " errMsg: " + paramString);
    Log.d("MicroMsg.StoryPostTask", "post error ".concat(String.valueOf(paramInt)));
    paramj.setItemDie();
    paramString = com.tencent.mm.plugin.story.f.j.LGA;
    j.b.gcw().a((int)paramj.systemRowid, paramj);
    paramj = com.tencent.mm.plugin.story.i.a.LPG;
    if (paramInt == com.tencent.mm.plugin.story.i.a.gfu()) {
      Log.e("MicroMsg.StoryPostTask", "upload find timeLine is null delete this item");
    }
    for (;;)
    {
      parama.invoke();
      AppMethodBeat.o(119138);
      return;
      paramj = com.tencent.mm.plugin.story.i.a.LPG;
      if (paramInt == com.tencent.mm.plugin.story.i.a.gfv())
      {
        Log.e("MicroMsg.StoryPostTask", "parser protobuf error");
      }
      else
      {
        paramj = com.tencent.mm.plugin.story.i.a.LPG;
        if (paramInt == com.tencent.mm.plugin.story.i.a.gfw())
        {
          Log.e("MicroMsg.StoryPostTask", "local id is not in db");
        }
        else
        {
          paramj = com.tencent.mm.plugin.story.i.a.LPG;
          if (paramInt == com.tencent.mm.plugin.story.i.a.gfx())
          {
            Log.e("MicroMsg.StoryPostTask", "arg is error");
          }
          else
          {
            paramj = com.tencent.mm.plugin.story.i.a.LPG;
            if (paramInt == com.tencent.mm.plugin.story.i.a.gfy())
            {
              Log.e("MicroMsg.StoryPostTask", "pullTimeLineXml  error");
            }
            else
            {
              paramj = com.tencent.mm.plugin.story.i.a.LPG;
              if (paramInt == com.tencent.mm.plugin.story.i.a.gfz()) {
                Log.e("MicroMsg.StoryPostTask", "errtle  error");
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