package com.tencent.mm.plugin.story.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/upload/UploadUtil;", "", "()V", "markStoryError", "", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "errType", "", "errMsg", "", "block", "Lkotlin/Function0;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f Soi;
  
  static
  {
    AppMethodBeat.i(119139);
    Soi = new f();
    AppMethodBeat.o(119139);
  }
  
  public static void a(j paramj, int paramInt, String paramString, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(119138);
    s.u(paramj, "storyInfo");
    s.u(paramString, "errMsg");
    s.u(parama, "block");
    Log.i("MicroMsg.StoryPostTask", "processError localId " + (int)paramj.systemRowid + " processError " + paramInt + " errMsg: " + paramString);
    Log.d("MicroMsg.StoryPostTask", s.X("post error ", Integer.valueOf(paramInt)));
    paramj.setItemDie();
    paramString = StoryCore.SjP;
    StoryCore.b.hvR().a((int)paramj.systemRowid, paramj);
    paramj = com.tencent.mm.plugin.story.h.a.Sry;
    if (paramInt == com.tencent.mm.plugin.story.h.a.hyM()) {
      Log.e("MicroMsg.StoryPostTask", "upload find timeLine is null delete this item");
    }
    for (;;)
    {
      parama.invoke();
      AppMethodBeat.o(119138);
      return;
      paramj = com.tencent.mm.plugin.story.h.a.Sry;
      if (paramInt == com.tencent.mm.plugin.story.h.a.hyN())
      {
        Log.e("MicroMsg.StoryPostTask", "parser protobuf error");
      }
      else
      {
        paramj = com.tencent.mm.plugin.story.h.a.Sry;
        if (paramInt == com.tencent.mm.plugin.story.h.a.hyO())
        {
          Log.e("MicroMsg.StoryPostTask", "local id is not in db");
        }
        else
        {
          paramj = com.tencent.mm.plugin.story.h.a.Sry;
          if (paramInt == com.tencent.mm.plugin.story.h.a.hyP())
          {
            Log.e("MicroMsg.StoryPostTask", "arg is error");
          }
          else
          {
            paramj = com.tencent.mm.plugin.story.h.a.Sry;
            if (paramInt == com.tencent.mm.plugin.story.h.a.hyQ())
            {
              Log.e("MicroMsg.StoryPostTask", "pullTimeLineXml  error");
            }
            else
            {
              paramj = com.tencent.mm.plugin.story.h.a.Sry;
              if (paramInt == com.tencent.mm.plugin.story.h.a.hyR()) {
                Log.e("MicroMsg.StoryPostTask", "errtle  error");
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.f.f
 * JD-Core Version:    0.7.0.1
 */