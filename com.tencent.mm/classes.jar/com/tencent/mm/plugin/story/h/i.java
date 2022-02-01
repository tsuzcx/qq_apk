package com.tencent.mm.plugin.story.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/report/StoryReporterUtil;", "", "()V", "Companion", "plugin-story_release"})
public final class i
{
  public static final a FuI;
  
  static
  {
    AppMethodBeat.i(119467);
    FuI = new a((byte)0);
    AppMethodBeat.o(119467);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/report/StoryReporterUtil$Companion;", "", "()V", "getContactType", "", "userName", "", "getEnterScene", "", "pageType", "plugin-story_release"})
  public static final class a
  {
    public static int aSq(String paramString)
    {
      AppMethodBeat.i(119465);
      p.h(paramString, "userName");
      if (TextUtils.isEmpty((CharSequence)paramString))
      {
        AppMethodBeat.o(119465);
        return 0;
      }
      j.b localb = j.Fmy;
      if (p.j(j.b.fau(), paramString))
      {
        AppMethodBeat.o(119465);
        return 1;
      }
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
      p.g(paramString, "ct");
      if (paramString.arA())
      {
        AppMethodBeat.o(119465);
        return 3;
      }
      if (paramString.arv())
      {
        AppMethodBeat.o(119465);
        return 4;
      }
      AppMethodBeat.o(119465);
      return 5;
    }
    
    public static long aaX(int paramInt)
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
      h localh = h.FuH;
      long l = h.fqi().ahw();
      AppMethodBeat.o(119466);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.i
 * JD-Core Version:    0.7.0.1
 */