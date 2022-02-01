package com.tencent.mm.plugin.story.ui.view;

import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/ViewClickHelper;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "clickDelay", "", "clickRecord", "", "endRecordRunnable", "Ljava/lang/Runnable;", "isRecording", "", "onClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onDoubleClickListener", "getOnDoubleClickListener", "setOnDoubleClickListener", "onTripleClickListener", "getOnTripleClickListener", "setOnTripleClickListener", "checkDispatch", "dispatchClickEvent", "recordClick", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  b<? super View, ah> Hop;
  public b<? super View, ah> SzP;
  b<? super View, ah> SzQ;
  int SzR;
  final long SzS;
  Runnable SzT;
  boolean nJm;
  private final View view;
  
  public f(View paramView)
  {
    AppMethodBeat.i(120316);
    this.view = paramView;
    this.SzS = ViewConfiguration.getDoubleTapTimeout();
    this.SzT = new f..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(120316);
  }
  
  private static final void a(f paramf)
  {
    AppMethodBeat.i(367585);
    s.u(paramf, "this$0");
    paramf.hAb();
    AppMethodBeat.o(367585);
  }
  
  final void hAb()
  {
    AppMethodBeat.i(120315);
    switch (this.SzR)
    {
    }
    for (;;)
    {
      this.SzR = 0;
      this.nJm = false;
      AppMethodBeat.o(120315);
      return;
      b localb = this.Hop;
      if (localb != null)
      {
        localb.invoke(this.view);
        continue;
        localb = this.SzP;
        if (localb != null)
        {
          localb.invoke(this.view);
          continue;
          localb = this.SzQ;
          if (localb != null) {
            localb.invoke(this.view);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.f
 * JD-Core Version:    0.7.0.1
 */