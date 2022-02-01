package com.tencent.mm.plugin.story.g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.ox;
import com.tencent.mm.contact.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/report/StoryReporterUtil;", "", "()V", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final a Srx;
  
  static
  {
    AppMethodBeat.i(119467);
    Srx = new a((byte)0);
    AppMethodBeat.o(119467);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/report/StoryReporterUtil$Companion;", "", "()V", "getContactType", "", "userName", "", "getEnterScene", "", "pageType", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static long ans(int paramInt)
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
      h localh = h.SqZ;
      long l = h.hxW().jjn;
      AppMethodBeat.o(119466);
      return l;
    }
    
    public static int bch(String paramString)
    {
      AppMethodBeat.i(119465);
      s.u(paramString, "userName");
      if (TextUtils.isEmpty((CharSequence)paramString))
      {
        AppMethodBeat.o(119465);
        return 0;
      }
      StoryCore.b localb = StoryCore.SjP;
      if (s.p(StoryCore.b.hgg(), paramString))
      {
        AppMethodBeat.o(119465);
        return 1;
      }
      paramString = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString);
      if (paramString.aSK())
      {
        AppMethodBeat.o(119465);
        return 3;
      }
      if (d.rs(paramString.field_type))
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
 * Qualified Name:     com.tencent.mm.plugin.story.g.i
 * JD-Core Version:    0.7.0.1
 */