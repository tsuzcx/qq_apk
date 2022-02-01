package com.tencent.mm.plugin.story.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/report/StoryReporterUtil;", "", "()V", "Companion", "plugin-story_release"})
public final class i
{
  public static final a ASu;
  
  static
  {
    AppMethodBeat.i(119467);
    ASu = new a((byte)0);
    AppMethodBeat.o(119467);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/report/StoryReporterUtil$Companion;", "", "()V", "getContactType", "", "userName", "", "getEnterScene", "", "pageType", "plugin-story_release"})
  public static final class a
  {
    public static long Su(int paramInt)
    {
      AppMethodBeat.i(119466);
      switch (paramInt)
      {
      case 1: 
      case 2: 
      case 3: 
      default: 
        AppMethodBeat.o(119466);
        return 0L;
      case 0: 
        AppMethodBeat.o(119466);
        return 7L;
      case 4: 
        AppMethodBeat.o(119466);
        return 8L;
      case 6: 
        AppMethodBeat.o(119466);
        return 9L;
      }
      h localh = h.ASt;
      long l = h.ejZ().TB();
      AppMethodBeat.o(119466);
      return l;
    }
    
    public static int aCc(String paramString)
    {
      AppMethodBeat.i(119465);
      p.h(paramString, "userName");
      if (TextUtils.isEmpty((CharSequence)paramString))
      {
        AppMethodBeat.o(119465);
        return 0;
      }
      j.b localb = j.AKb;
      if (p.i(j.b.dTJ(), paramString))
      {
        AppMethodBeat.o(119465);
        return 1;
      }
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramString);
      p.g(paramString, "ct");
      if (paramString.adm())
      {
        AppMethodBeat.o(119465);
        return 3;
      }
      if (paramString.adh())
      {
        AppMethodBeat.o(119465);
        return 4;
      }
      AppMethodBeat.o(119465);
      return 5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.i
 * JD-Core Version:    0.7.0.1
 */