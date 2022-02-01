package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/upload/UploadUtil;", "", "()V", "markStoryError", "", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "errType", "", "errMsg", "", "block", "Lkotlin/Function0;", "plugin-story_release"})
public final class f
{
  public static final f FqO;
  
  static
  {
    AppMethodBeat.i(119139);
    FqO = new f();
    AppMethodBeat.o(119139);
  }
  
  public static void a(com.tencent.mm.plugin.story.i.j paramj, int paramInt, String paramString, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(119138);
    p.h(paramj, "storyInfo");
    p.h(paramString, "errMsg");
    p.h(parama, "block");
    Log.i("MicroMsg.StoryPostTask", "processError localId " + (int)paramj.systemRowid + " processError " + paramInt + " errMsg: " + paramString);
    Log.d("MicroMsg.StoryPostTask", "post error ".concat(String.valueOf(paramInt)));
    paramj.setItemDie();
    paramString = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.foc().a((int)paramj.systemRowid, paramj);
    paramj = com.tencent.mm.plugin.story.i.a.FvD;
    if (paramInt == com.tencent.mm.plugin.story.i.a.fqY()) {
      Log.e("MicroMsg.StoryPostTask", "upload find timeLine is null delete this item");
    }
    for (;;)
    {
      parama.invoke();
      AppMethodBeat.o(119138);
      return;
      paramj = com.tencent.mm.plugin.story.i.a.FvD;
      if (paramInt == com.tencent.mm.plugin.story.i.a.fqZ())
      {
        Log.e("MicroMsg.StoryPostTask", "parser protobuf error");
      }
      else
      {
        paramj = com.tencent.mm.plugin.story.i.a.FvD;
        if (paramInt == com.tencent.mm.plugin.story.i.a.fra())
        {
          Log.e("MicroMsg.StoryPostTask", "local id is not in db");
        }
        else
        {
          paramj = com.tencent.mm.plugin.story.i.a.FvD;
          if (paramInt == com.tencent.mm.plugin.story.i.a.frb())
          {
            Log.e("MicroMsg.StoryPostTask", "arg is error");
          }
          else
          {
            paramj = com.tencent.mm.plugin.story.i.a.FvD;
            if (paramInt == com.tencent.mm.plugin.story.i.a.frc())
            {
              Log.e("MicroMsg.StoryPostTask", "pullTimeLineXml  error");
            }
            else
            {
              paramj = com.tencent.mm.plugin.story.i.a.FvD;
              if (paramInt == com.tencent.mm.plugin.story.i.a.frd()) {
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