package com.tencent.mm.plugin.story.ui.view;

import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/ViewClickHelper;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "clickDelay", "", "clickRecord", "", "endRecordRunnable", "Ljava/lang/Runnable;", "isRecording", "", "onClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onDoubleClickListener", "getOnDoubleClickListener", "setOnDoubleClickListener", "onTripleClickListener", "getOnTripleClickListener", "setOnTripleClickListener", "checkDispatch", "dispatchClickEvent", "recordClick", "plugin-story_release"})
public final class g
{
  public b<? super View, z> BtA;
  b<? super View, z> BtB;
  int BtC;
  final long BtD;
  Runnable BtE;
  b<? super View, z> Btz;
  boolean hvU;
  private final View view;
  
  public g(View paramView)
  {
    AppMethodBeat.i(120316);
    this.view = paramView;
    this.BtD = ViewConfiguration.getDoubleTapTimeout();
    this.BtE = ((Runnable)new a(this));
    AppMethodBeat.o(120316);
  }
  
  final void epK()
  {
    AppMethodBeat.i(120315);
    switch (this.BtC)
    {
    }
    for (;;)
    {
      this.BtC = 0;
      this.hvU = false;
      AppMethodBeat.o(120315);
      return;
      b localb = this.Btz;
      if (localb != null)
      {
        localb.invoke(this.view);
        continue;
        localb = this.BtA;
        if (localb != null)
        {
          localb.invoke(this.view);
          continue;
          localb = this.BtB;
          if (localb != null) {
            localb.invoke(this.view);
          }
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(120314);
      this.BtF.epK();
      AppMethodBeat.o(120314);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.g
 * JD-Core Version:    0.7.0.1
 */