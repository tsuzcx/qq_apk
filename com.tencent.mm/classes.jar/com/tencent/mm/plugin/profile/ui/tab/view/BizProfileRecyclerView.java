package com.tencent.mm.plugin.profile.ui.tab.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView;", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOnScrollToTopListener", "Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView$OnScrollToTopListener;", "getMOnScrollToTopListener", "()Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView$OnScrollToTopListener;", "setMOnScrollToTopListener", "(Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView$OnScrollToTopListener;)V", "scrollToPosition", "", "position", "setOnScrollToTopListener", "listener", "smoothScrollToPosition", "OnScrollToTopListener", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizProfileRecyclerView
  extends LoadMoreRecyclerView
{
  private a NfW;
  
  public BizProfileRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(305957);
    AppMethodBeat.o(305957);
  }
  
  public BizProfileRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(305963);
    AppMethodBeat.o(305963);
  }
  
  public final a getMOnScrollToTopListener()
  {
    return this.NfW;
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(305969);
    super.scrollToPosition(paramInt);
    Log.d("BizProfileRecyclerView", s.X("scrollToPosition:", Integer.valueOf(paramInt)));
    AppMethodBeat.o(305969);
  }
  
  public final void setMOnScrollToTopListener(a parama)
  {
    this.NfW = parama;
  }
  
  public final void setOnScrollToTopListener(a parama)
  {
    AppMethodBeat.i(305992);
    s.u(parama, "listener");
    this.NfW = parama;
    AppMethodBeat.o(305992);
  }
  
  public final void smoothScrollToPosition(int paramInt)
  {
    AppMethodBeat.i(305975);
    super.smoothScrollToPosition(paramInt);
    if (paramInt == 0)
    {
      a locala = this.NfW;
      if (locala != null) {
        locala.dSq();
      }
    }
    Log.d("BizProfileRecyclerView", s.X("smoothScrollToPosition:", Integer.valueOf(paramInt)));
    AppMethodBeat.o(305975);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileRecyclerView$OnScrollToTopListener;", "", "onScrollToTop", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void dSq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.view.BizProfileRecyclerView
 * JD-Core Version:    0.7.0.1
 */