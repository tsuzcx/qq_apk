package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.f;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenBlackBoardProjector;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getBackgroundView", "Landroid/view/View;", "getCurrentFileMd5", "", "getLayoutId", "", "initView", "", "Companion", "plugin-multitalk_release"})
public final class d
  extends l
{
  public static final a FBM;
  
  static
  {
    AppMethodBeat.i(202615);
    FBM = new a((byte)0);
    AppMethodBeat.o(202615);
  }
  
  public final View getBackgroundView()
  {
    AppMethodBeat.i(202612);
    View localView = (View)getMEditLayout();
    AppMethodBeat.o(202612);
    return localView;
  }
  
  public final String getCurrentFileMd5()
  {
    return null;
  }
  
  public final int getLayoutId()
  {
    return a.f.multitalk_screen_project_black_board;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenBlackBoardProjector$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.d
 * JD-Core Version:    0.7.0.1
 */