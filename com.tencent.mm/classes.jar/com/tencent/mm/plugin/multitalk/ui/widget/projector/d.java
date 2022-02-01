package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenBlackBoardProjector;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getBackgroundView", "Landroid/view/View;", "getCurrentFileMd5", "", "getLayoutId", "", "initView", "", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends k
{
  public static final a LxM;
  
  static
  {
    AppMethodBeat.i(285631);
    LxM = new a((byte)0);
    AppMethodBeat.o(285631);
  }
  
  public final View getBackgroundView()
  {
    AppMethodBeat.i(285645);
    View localView = (View)getMEditLayout();
    AppMethodBeat.o(285645);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenBlackBoardProjector$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.d
 * JD-Core Version:    0.7.0.1
 */