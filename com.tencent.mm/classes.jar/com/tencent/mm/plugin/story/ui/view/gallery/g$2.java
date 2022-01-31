package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.aj;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class g$2
  implements Runnable
{
  g$2(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(110739);
    int i = a.fromDPToPix(g.d(this.sSA).getContext(), 112);
    View localView = LayoutInflater.from(g.d(this.sSA).getContext()).inflate(2130970971, (ViewGroup)g.d(this.sSA), false);
    g.a(this.sSA, localView);
    Object localObject = localView.findViewById(2131828452);
    j.p(localObject, "layout.findViewById(R.id…tory_scroll_up_hint_icon)");
    ((ImageView)localObject).setImageDrawable(aj.g(g.d(this.sSA).getContext(), 2131231147, -1));
    localObject = new RelativeLayout.LayoutParams(-1, i);
    ((RelativeLayout.LayoutParams)localObject).addRule(12, 1);
    g.d(this.sSA).addView(localView, (ViewGroup.LayoutParams)localObject);
    j.p(localView, "layout");
    localView.setAlpha(0.0F);
    localView.animate().alpha(1.0F).start();
    g.b(this.sSA).bP(i);
    g.h(this.sSA);
    AppMethodBeat.o(110739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.g.2
 * JD-Core Version:    0.7.0.1
 */