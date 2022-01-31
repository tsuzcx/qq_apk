package com.tencent.mm.plugin.story.g;

import a.l;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/report/StoryReporterUtil$Companion;", "", "()V", "getContactType", "", "userName", "", "getEnterScene", "", "pageType", "plugin-story_release"})
public final class j$a
{
  public static long FY(int paramInt)
  {
    AppMethodBeat.i(109849);
    switch (paramInt)
    {
    case 1: 
    case 2: 
    case 3: 
    default: 
      AppMethodBeat.o(109849);
      return 0L;
    case 0: 
      AppMethodBeat.o(109849);
      return 7L;
    case 4: 
      AppMethodBeat.o(109849);
      return 8L;
    case 6: 
      AppMethodBeat.o(109849);
      return 9L;
    }
    i locali = i.sFa;
    long l = i.cDo().FF();
    AppMethodBeat.o(109849);
    return l;
  }
  
  public static int adw(String paramString)
  {
    AppMethodBeat.i(109848);
    a.f.b.j.q(paramString, "userName");
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(109848);
      return 0;
    }
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    if (a.f.b.j.e(j.b.coK(), paramString))
    {
      AppMethodBeat.o(109848);
      return 1;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramString);
    a.f.b.j.p(paramString, "ct");
    if (paramString.NY())
    {
      AppMethodBeat.o(109848);
      return 3;
    }
    if (paramString.NT())
    {
      AppMethodBeat.o(109848);
      return 4;
    }
    AppMethodBeat.o(109848);
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.j.a
 * JD-Core Version:    0.7.0.1
 */