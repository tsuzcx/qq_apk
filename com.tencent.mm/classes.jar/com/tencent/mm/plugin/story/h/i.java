package com.tencent.mm.plugin.story.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/report/StoryReporterUtil;", "", "()V", "Companion", "plugin-story_release"})
public final class i
{
  public static final a BjS;
  
  static
  {
    AppMethodBeat.i(119467);
    BjS = new a((byte)0);
    AppMethodBeat.o(119467);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/report/StoryReporterUtil$Companion;", "", "()V", "getContactType", "", "userName", "", "getEnterScene", "", "pageType", "plugin-story_release"})
  public static final class a
  {
    public static long Tb(int paramInt)
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
      h localh = h.BjR;
      long l = h.enI().TH();
      AppMethodBeat.o(119466);
      return l;
    }
    
    public static int aDv(String paramString)
    {
      AppMethodBeat.i(119465);
      p.h(paramString, "userName");
      if (TextUtils.isEmpty((CharSequence)paramString))
      {
        AppMethodBeat.o(119465);
        return 0;
      }
      j.b localb = j.BbE;
      if (p.i(j.b.dXj(), paramString))
      {
        AppMethodBeat.o(119465);
        return 1;
      }
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString);
      p.g(paramString, "ct");
      if (paramString.adx())
      {
        AppMethodBeat.o(119465);
        return 3;
      }
      if (paramString.ads())
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