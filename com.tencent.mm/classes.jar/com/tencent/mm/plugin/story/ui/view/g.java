package com.tencent.mm.plugin.story.ui.view;

import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/ViewClickHelper;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "clickDelay", "", "clickRecord", "", "endRecordRunnable", "Ljava/lang/Runnable;", "isRecording", "", "onClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onDoubleClickListener", "getOnDoubleClickListener", "setOnDoubleClickListener", "onTripleClickListener", "getOnTripleClickListener", "setOnTripleClickListener", "checkDispatch", "dispatchClickEvent", "recordClick", "plugin-story_release"})
public final class g
{
  boolean hba;
  private final View view;
  b<? super View, y> zKA;
  public b<? super View, y> zKB;
  b<? super View, y> zKC;
  int zKD;
  final long zKE;
  Runnable zKF;
  
  public g(View paramView)
  {
    AppMethodBeat.i(120316);
    this.view = paramView;
    this.zKE = ViewConfiguration.getDoubleTapTimeout();
    this.zKF = ((Runnable)new a(this));
    AppMethodBeat.o(120316);
  }
  
  final void dZM()
  {
    AppMethodBeat.i(120315);
    switch (this.zKD)
    {
    }
    for (;;)
    {
      this.zKD = 0;
      this.hba = false;
      AppMethodBeat.o(120315);
      return;
      b localb = this.zKA;
      if (localb != null)
      {
        localb.ay(this.view);
        continue;
        localb = this.zKB;
        if (localb != null)
        {
          localb.ay(this.view);
          continue;
          localb = this.zKC;
          if (localb != null) {
            localb.ay(this.view);
          }
        }
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(120314);
      this.zKG.dZM();
      AppMethodBeat.o(120314);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.g
 * JD-Core Version:    0.7.0.1
 */