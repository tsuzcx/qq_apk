package com.tencent.mm.plugin.story.ui.sns;

import a.f.a.m;
import a.f.b.j;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryEntranceUI$c$c$1
  implements View.OnClickListener
{
  StoryEntranceUI$c$c$1(StoryEntranceUI.c.c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110250);
    int i = this.sKC.jN();
    paramView = this.sKC.sKA.sKy.get(i);
    j.p(paramView, "userList[position]");
    paramView = (StoryEntranceUI.b)paramView;
    m localm = this.sKC.sKA.sHB;
    if (localm != null)
    {
      localm.h(Integer.valueOf(i), paramView);
      AppMethodBeat.o(110250);
      return;
    }
    AppMethodBeat.o(110250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI.c.c.1
 * JD-Core Version:    0.7.0.1
 */