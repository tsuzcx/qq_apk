package com.tencent.mm.plugin.story.ui.view;

import a.f.a.b;
import a.l;
import a.y;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/ViewClickHelper;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "clickDelay", "", "clickRecord", "", "endRecordRunnable", "Ljava/lang/Runnable;", "isRecording", "", "onClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onDoubleClickListener", "getOnDoubleClickListener", "setOnDoubleClickListener", "onTripleClickListener", "getOnTripleClickListener", "setOnTripleClickListener", "checkDispatch", "dispatchClickEvent", "recordClick", "plugin-story_release"})
public final class h
{
  boolean isRecording;
  b<? super View, y> sNB;
  public b<? super View, y> sNC;
  b<? super View, y> sND;
  int sNE;
  final long sNF;
  Runnable sNG;
  private final View view;
  
  public h(View paramView)
  {
    AppMethodBeat.i(110474);
    this.view = paramView;
    this.sNF = ViewConfiguration.getDoubleTapTimeout();
    this.sNG = ((Runnable)new a(this));
    AppMethodBeat.o(110474);
  }
  
  final void cFz()
  {
    AppMethodBeat.i(110473);
    switch (this.sNE)
    {
    }
    for (;;)
    {
      this.sNE = 0;
      this.isRecording = false;
      AppMethodBeat.o(110473);
      return;
      b localb = this.sNB;
      if (localb != null)
      {
        localb.S(this.view);
        continue;
        localb = this.sNC;
        if (localb != null)
        {
          localb.S(this.view);
          continue;
          localb = this.sND;
          if (localb != null) {
            localb.S(this.view);
          }
        }
      }
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(110472);
      this.sNH.cFz();
      AppMethodBeat.o(110472);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.h
 * JD-Core Version:    0.7.0.1
 */