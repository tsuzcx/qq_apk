package com.tencent.mm.plugin.story.ui.view;

import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/ViewClickHelper;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "clickDelay", "", "clickRecord", "", "endRecordRunnable", "Ljava/lang/Runnable;", "isRecording", "", "onClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onDoubleClickListener", "getOnDoubleClickListener", "setOnDoubleClickListener", "onTripleClickListener", "getOnTripleClickListener", "setOnTripleClickListener", "checkDispatch", "dispatchClickEvent", "recordClick", "plugin-story_release"})
public final class g
{
  boolean gAF;
  private final View view;
  b<? super View, y> yxl;
  public b<? super View, y> yxm;
  b<? super View, y> yxn;
  int yxo;
  final long yxp;
  Runnable yxq;
  
  public g(View paramView)
  {
    AppMethodBeat.i(120316);
    this.view = paramView;
    this.yxp = ViewConfiguration.getDoubleTapTimeout();
    this.yxq = ((Runnable)new a(this));
    AppMethodBeat.o(120316);
  }
  
  final void dLm()
  {
    AppMethodBeat.i(120315);
    switch (this.yxo)
    {
    }
    for (;;)
    {
      this.yxo = 0;
      this.gAF = false;
      AppMethodBeat.o(120315);
      return;
      b localb = this.yxl;
      if (localb != null)
      {
        localb.aA(this.view);
        continue;
        localb = this.yxm;
        if (localb != null)
        {
          localb.aA(this.view);
          continue;
          localb = this.yxn;
          if (localb != null) {
            localb.aA(this.view);
          }
        }
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(120314);
      this.yxr.dLm();
      AppMethodBeat.o(120314);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.g
 * JD-Core Version:    0.7.0.1
 */