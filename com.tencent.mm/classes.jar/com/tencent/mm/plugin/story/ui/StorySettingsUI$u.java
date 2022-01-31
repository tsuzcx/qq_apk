package com.tencent.mm.plugin.story.ui;

import a.f.b.j;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.t;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
public final class StorySettingsUI$u
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110065);
    paramView = g.RL();
    j.p(paramView, "MMKernel.storage()");
    paramView.Ru().set(ac.a.yLE, Boolean.TRUE);
    paramView = g.RL();
    j.p(paramView, "MMKernel.storage()");
    paramView.Ru().set(ac.a.yLG, Boolean.TRUE);
    paramView = g.RL();
    j.p(paramView, "MMKernel.storage()");
    paramView.Ru().set(ac.a.yLF, Boolean.TRUE);
    paramView = g.RL();
    j.p(paramView, "MMKernel.storage()");
    paramView.Ru().set(ac.a.yLv, Boolean.FALSE);
    paramView = g.RL();
    j.p(paramView, "MMKernel.storage()");
    paramView.Ru().set(ac.a.yLu, Integer.valueOf(0));
    paramView = g.RL();
    j.p(paramView, "MMKernel.storage()");
    paramView.Ru().set(ac.a.yLw, Boolean.FALSE);
    paramView = g.RL();
    j.p(paramView, "MMKernel.storage()");
    paramView.Ru().set(ac.a.yLx, Boolean.FALSE);
    paramView = g.RL();
    j.p(paramView, "MMKernel.storage()");
    paramView.Ru().set(ac.a.yLy, Boolean.FALSE);
    paramView = g.RL();
    j.p(paramView, "MMKernel.storage()");
    paramView.Ru().set(ac.a.yLH, Boolean.TRUE);
    paramView = g.RL();
    j.p(paramView, "MMKernel.storage()");
    paramView.Ru().set(ac.a.yLI, Integer.valueOf(0));
    paramView = g.RL();
    j.p(paramView, "MMKernel.storage()");
    paramView.Ru().set(ac.a.yLO, Boolean.TRUE);
    paramView = g.RL();
    j.p(paramView, "MMKernel.storage()");
    paramView.Ru().set(ac.a.yLz, Boolean.TRUE);
    paramView = g.RL();
    j.p(paramView, "MMKernel.storage()");
    paramView.Ru().set(ac.a.yLA, Boolean.TRUE);
    t.makeText(ah.getContext(), (CharSequence)"好了", 1).show();
    AppMethodBeat.o(110065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.u
 * JD-Core Version:    0.7.0.1
 */