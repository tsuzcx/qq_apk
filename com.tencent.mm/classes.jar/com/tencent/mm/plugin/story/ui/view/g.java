package com.tencent.mm.plugin.story.ui.view;

import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/ViewClickHelper;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "clickDelay", "", "clickRecord", "", "endRecordRunnable", "Ljava/lang/Runnable;", "isRecording", "", "onClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onDoubleClickListener", "getOnDoubleClickListener", "setOnDoubleClickListener", "onTripleClickListener", "getOnTripleClickListener", "setOnTripleClickListener", "checkDispatch", "dispatchClickEvent", "recordClick", "plugin-story_release"})
public final class g
{
  b<? super View, z> Bcb;
  public b<? super View, z> Bcc;
  b<? super View, z> Bcd;
  int Bce;
  final long Bcf;
  Runnable Bcg;
  boolean htg;
  private final View view;
  
  public g(View paramView)
  {
    AppMethodBeat.i(120316);
    this.view = paramView;
    this.Bcf = ViewConfiguration.getDoubleTapTimeout();
    this.Bcg = ((Runnable)new a(this));
    AppMethodBeat.o(120316);
  }
  
  final void emb()
  {
    AppMethodBeat.i(120315);
    switch (this.Bce)
    {
    }
    for (;;)
    {
      this.Bce = 0;
      this.htg = false;
      AppMethodBeat.o(120315);
      return;
      b localb = this.Bcb;
      if (localb != null)
      {
        localb.invoke(this.view);
        continue;
        localb = this.Bcc;
        if (localb != null)
        {
          localb.invoke(this.view);
          continue;
          localb = this.Bcd;
          if (localb != null) {
            localb.invoke(this.view);
          }
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(120314);
      this.Bch.emb();
      AppMethodBeat.o(120314);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.g
 * JD-Core Version:    0.7.0.1
 */