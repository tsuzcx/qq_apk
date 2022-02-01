package com.tencent.mm.plugin.story.ui.view;

import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/ViewClickHelper;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "clickDelay", "", "clickRecord", "", "endRecordRunnable", "Ljava/lang/Runnable;", "isRecording", "", "onClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onDoubleClickListener", "getOnDoubleClickListener", "setOnDoubleClickListener", "onTripleClickListener", "getOnTripleClickListener", "setOnTripleClickListener", "checkDispatch", "dispatchClickEvent", "recordClick", "plugin-story_release"})
public final class g
{
  b<? super View, x> FEm;
  public b<? super View, x> FEn;
  b<? super View, x> FEo;
  int FEp;
  final long FEq;
  Runnable FEr;
  boolean ipv;
  private final View view;
  
  public g(View paramView)
  {
    AppMethodBeat.i(120316);
    this.view = paramView;
    this.FEq = ViewConfiguration.getDoubleTapTimeout();
    this.FEr = ((Runnable)new a(this));
    AppMethodBeat.o(120316);
  }
  
  final void fsj()
  {
    AppMethodBeat.i(120315);
    switch (this.FEp)
    {
    }
    for (;;)
    {
      this.FEp = 0;
      this.ipv = false;
      AppMethodBeat.o(120315);
      return;
      b localb = this.FEm;
      if (localb != null)
      {
        localb.invoke(this.view);
        continue;
        localb = this.FEn;
        if (localb != null)
        {
          localb.invoke(this.view);
          continue;
          localb = this.FEo;
          if (localb != null) {
            localb.invoke(this.view);
          }
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(120314);
      this.FEs.fsj();
      AppMethodBeat.o(120314);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.g
 * JD-Core Version:    0.7.0.1
 */