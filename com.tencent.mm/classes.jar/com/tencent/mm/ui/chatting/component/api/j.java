package com.tencent.mm.ui.chatting.component.api;

import com.tencent.mm.ui.chatting.ag;
import com.tencent.mm.ui.chatting.component.aj;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/api/IChattingFooterLifecycleObserver;", "Lcom/tencent/mm/ui/chatting/component/IChattingComponent;", "onBottomPanelVisible", "", "visible", "", "onPanelShow", "panelType", "isVoiceInputPanelShow", "", "register", "listener", "Lcom/tencent/mm/ui/chatting/IChattingFooterLifecycle;", "unregister", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface j
  extends aj
{
  public abstract void a(ag paramag);
  
  public abstract void aBR(int paramInt);
  
  public abstract void b(ag paramag);
  
  public abstract void cG(int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.api.j
 * JD-Core Version:    0.7.0.1
 */