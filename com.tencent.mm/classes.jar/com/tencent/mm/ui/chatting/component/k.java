package com.tencent.mm.ui.chatting.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.ag;
import com.tencent.mm.ui.chatting.component.api.j;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/ChattingFooterLifecycleObserver;", "Lcom/tencent/mm/ui/chatting/component/api/IChattingFooterLifecycleObserver;", "()V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/ui/chatting/IChattingFooterLifecycle;", "Lkotlin/collections/HashSet;", "onBottomPanelVisible", "", "visible", "", "onPanelShow", "panelType", "isVoiceInputPanelShow", "", "register", "listener", "unregister", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  implements j
{
  private final HashSet<ag> listeners;
  
  public k()
  {
    AppMethodBeat.i(256176);
    this.listeners = new HashSet();
    AppMethodBeat.o(256176);
  }
  
  public final void a(ag paramag)
  {
    AppMethodBeat.i(256181);
    s.u(paramag, "listener");
    this.listeners.add(paramag);
    AppMethodBeat.o(256181);
  }
  
  public final void aBR(int paramInt)
  {
    AppMethodBeat.i(256190);
    Iterator localIterator = ((Iterable)this.listeners).iterator();
    while (localIterator.hasNext()) {
      ((ag)localIterator.next()).aBR(paramInt);
    }
    AppMethodBeat.o(256190);
  }
  
  public final void b(ag paramag)
  {
    AppMethodBeat.i(256187);
    s.u(paramag, "listener");
    this.listeners.remove(paramag);
    AppMethodBeat.o(256187);
  }
  
  public final void cG(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(256195);
    Iterator localIterator = ((Iterable)this.listeners).iterator();
    while (localIterator.hasNext()) {
      ((ag)localIterator.next()).cG(paramInt, paramBoolean);
    }
    AppMethodBeat.o(256195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.k
 * JD-Core Version:    0.7.0.1
 */