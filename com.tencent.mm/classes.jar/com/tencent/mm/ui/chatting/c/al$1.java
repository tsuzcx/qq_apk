package com.tencent.mm.ui.chatting.c;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import java.util.List;

final class al$1
  implements MenuItem.OnMenuItemClickListener
{
  al$1(al paramal) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    long l = 1L;
    AppMethodBeat.i(31720);
    if (System.currentTimeMillis() - al.a(this.zIt) <= al.b(this.zIt))
    {
      ab.i("MicroMsg.StoryStateComponent", "onclick pass $clickTime now: %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(31720);
      return true;
    }
    al.a(this.zIt, System.currentTimeMillis());
    ab.i("MicroMsg.StoryStateComponent", "menuItemClickListener clickTime %s storyUserList size %s", new Object[] { Long.valueOf(al.a(this.zIt)), Integer.valueOf(al.c(this.zIt).size()) });
    if (al.c(this.zIt).size() > 0)
    {
      paramMenuItem = (String)al.c(this.zIt).get(0);
      ab.i("MicroMsg.StoryStateComponent", "menuItemClickListener click go %s", new Object[] { paramMenuItem });
      n.bj(1, paramMenuItem);
      n.enterGallery(al.d(this.zIt));
      n.acB(paramMenuItem);
      paramMenuItem = i.sFa;
      i.cDo().gp(al.e(this.zIt));
      if (al.f(this.zIt))
      {
        paramMenuItem = i.sFa;
        i.cDo().cVa = 4L;
        n.a(this.zIt.caz.zJz.getContext(), al.c(this.zIt), this.zIt.caz.getTalkerUserName(), al.e(this.zIt));
        paramMenuItem = i.sFa;
        paramMenuItem = i.cDo();
        if (!al.g(this.zIt)) {
          break label339;
        }
      }
      label339:
      for (l = 1L;; l = 0L)
      {
        paramMenuItem.cVb = l;
        AppMethodBeat.o(31720);
        return true;
        paramMenuItem = i.sFa;
        i.cDo().cVa = 5L;
        n.aS(this.zIt.caz.zJz.getContext(), (String)al.c(this.zIt).get(0));
        break;
      }
    }
    if ((al.h(this.zIt)) && (al.f(this.zIt)))
    {
      paramMenuItem = i.sFa;
      paramMenuItem = i.cDo();
      if (al.g(this.zIt)) {}
      for (;;)
      {
        paramMenuItem.cVb = l;
        n.a(this.zIt.caz.zJz.getContext(), al.c(this.zIt), this.zIt.caz.getTalkerUserName(), al.e(this.zIt));
        paramMenuItem = i.sFa;
        i.cDo().cVa = 4L;
        AppMethodBeat.o(31720);
        return true;
        l = 0L;
      }
    }
    AppMethodBeat.o(31720);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.al.1
 * JD-Core Version:    0.7.0.1
 */