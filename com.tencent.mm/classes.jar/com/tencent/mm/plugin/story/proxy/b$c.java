package com.tencent.mm.plugin.story.proxy;

import a.f.b.j;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "Landroid/view/View$OnClickListener;", "lastClick", "", "onClick", "", "view", "Landroid/view/View;", "plugin-story_release"})
public final class b$c
  implements View.OnClickListener
{
  private long qGX;
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(109725);
    j.q(paramView, "view");
    long l = bo.aoy();
    b.c(this.sDp).removeMessages(b.a(this.sDp));
    b.c(this.sDp).sendMessageDelayed(b.c(this.sDp).obtainMessage(b.a(this.sDp), paramView), ViewConfiguration.getDoubleTapTimeout());
    ab.d(b.access$getTAG$cp(), "onClick lastClick=%s now=%s", new Object[] { Long.valueOf(this.qGX), Long.valueOf(l) });
    if (l - this.qGX < ViewConfiguration.getDoubleTapTimeout())
    {
      b.c(this.sDp).removeMessages(b.a(this.sDp));
      b.d(this.sDp);
      AppMethodBeat.o(109725);
      return;
    }
    this.qGX = l;
    AppMethodBeat.o(109725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.b.c
 * JD-Core Version:    0.7.0.1
 */