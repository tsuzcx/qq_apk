package com.tencent.mm.plugin.profile.ui.tab.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView;", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOnScrollToTopListener", "Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView$OnScrollToTopListener;", "getMOnScrollToTopListener", "()Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView$OnScrollToTopListener;", "setMOnScrollToTopListener", "(Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView$OnScrollToTopListener;)V", "scrollToPosition", "", "position", "setOnScrollToTopListener", "listener", "smoothScrollToPosition", "OnScrollToTopListener", "app_release"})
public final class BizProfileRecyclerView
  extends LoadMoreRecyclerView
{
  private a Hii;
  
  public BizProfileRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(290143);
    AppMethodBeat.o(290143);
  }
  
  public BizProfileRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(290144);
    AppMethodBeat.o(290144);
  }
  
  public final a getMOnScrollToTopListener()
  {
    return this.Hii;
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(290140);
    super.scrollToPosition(paramInt);
    Log.d("BizProfileRecyclerView", "scrollToPosition:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(290140);
  }
  
  public final void setMOnScrollToTopListener(a parama)
  {
    this.Hii = parama;
  }
  
  public final void setOnScrollToTopListener(a parama)
  {
    AppMethodBeat.i(290142);
    p.k(parama, "listener");
    this.Hii = parama;
    AppMethodBeat.o(290142);
  }
  
  public final void smoothScrollToPosition(int paramInt)
  {
    AppMethodBeat.i(290141);
    super.smoothScrollToPosition(paramInt);
    if (paramInt == 0)
    {
      a locala = this.Hii;
      if (locala != null) {
        locala.dlA();
      }
    }
    Log.d("BizProfileRecyclerView", "smoothScrollToPosition:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(290141);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView$OnScrollToTopListener;", "", "onScrollToTop", "", "app_release"})
  public static abstract interface a
  {
    public abstract void dlA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.view.BizProfileRecyclerView
 * JD-Core Version:    0.7.0.1
 */