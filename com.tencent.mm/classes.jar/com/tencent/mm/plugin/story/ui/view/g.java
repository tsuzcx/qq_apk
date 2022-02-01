package com.tencent.mm.plugin.story.ui.view;

import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/ViewClickHelper;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "clickDelay", "", "clickRecord", "", "endRecordRunnable", "Ljava/lang/Runnable;", "isRecording", "", "onClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onDoubleClickListener", "getOnDoubleClickListener", "setOnDoubleClickListener", "onTripleClickListener", "getOnTripleClickListener", "setOnTripleClickListener", "checkDispatch", "dispatchClickEvent", "recordClick", "plugin-story_release"})
public final class g
{
  b<? super View, x> DzT;
  public b<? super View, x> LYo;
  b<? super View, x> LYp;
  int LYq;
  final long LYr;
  Runnable LYs;
  boolean leA;
  private final View view;
  
  public g(View paramView)
  {
    AppMethodBeat.i(120316);
    this.view = paramView;
    this.LYr = ViewConfiguration.getDoubleTapTimeout();
    this.LYs = ((Runnable)new a(this));
    AppMethodBeat.o(120316);
  }
  
  final void ggI()
  {
    AppMethodBeat.i(120315);
    switch (this.LYq)
    {
    }
    for (;;)
    {
      this.LYq = 0;
      this.leA = false;
      AppMethodBeat.o(120315);
      return;
      b localb = this.DzT;
      if (localb != null)
      {
        localb.invoke(this.view);
        continue;
        localb = this.LYo;
        if (localb != null)
        {
          localb.invoke(this.view);
          continue;
          localb = this.LYp;
          if (localb != null) {
            localb.invoke(this.view);
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(120314);
      this.LYt.ggI();
      AppMethodBeat.o(120314);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.g
 * JD-Core Version:    0.7.0.1
 */