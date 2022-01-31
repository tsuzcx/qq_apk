package com.tencent.mm.plugin.story.ui.sns;

import a.f.a.m;
import a.f.b.j;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$c$c$1
  implements View.OnClickListener
{
  c$c$c$1(c.c.c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110272);
    int i = this.sKV.jN();
    paramView = this.sKV.sKQ.sKy.get(i);
    j.p(paramView, "userList[position]");
    paramView = (c.b)paramView;
    m localm = this.sKV.sKQ.sHB;
    if (localm != null)
    {
      localm.h(Integer.valueOf(i), paramView);
      AppMethodBeat.o(110272);
      return;
    }
    AppMethodBeat.o(110272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.c.c.c.1
 * JD-Core Version:    0.7.0.1
 */