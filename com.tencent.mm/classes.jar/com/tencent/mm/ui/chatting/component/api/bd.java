package com.tencent.mm.ui.chatting.component.api;

import com.tencent.mm.ui.anim.content.c;
import com.tencent.mm.ui.chatting.component.aj;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/api/ITranslateWhileWriteComponent;", "Lcom/tencent/mm/ui/chatting/component/IChattingComponent;", "getSizeAnimController", "Lcom/tencent/mm/ui/anim/content/SizeAnimController;", "isTranslating", "", "needInteruptChatFooterDown", "onEdtContentChange", "", "text", "", "onEdtContentSend", "onKeyboardHeightChange", "height", "", "setIOnChattingEndCallback", "callback", "Lcom/tencent/mm/ui/chatting/component/api/ITranslateWhileWriteComponent$IOnChattingEndCallback;", "setIfTipNeedShowCallback", "Lcom/tencent/mm/ui/chatting/component/api/ITranslateWhileWriteComponent$TipNeedShowCallback;", "setOnTranslateResCallback", "Lcom/tencent/mm/ui/chatting/component/api/ITranslateWhileWriteComponent$IOnTranslateResCallback;", "setTranslating", "enable", "tryHideWithoutDataChange", "tryShowWithoutDataChange", "IOnChattingEndCallback", "IOnTranslateResCallback", "TipNeedShowCallback", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface bd
  extends aj
{
  public abstract void Md(boolean paramBoolean);
  
  public abstract void a(a parama);
  
  public abstract void a(b paramb);
  
  public abstract void a(c paramc);
  
  public abstract void aCq(int paramInt);
  
  public abstract void bAW(String paramString);
  
  public abstract void bAX(String paramString);
  
  public abstract c getSizeAnimController();
  
  public abstract boolean jsr();
  
  public abstract void jul();
  
  public abstract void jum();
  
  public abstract boolean jup();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/api/ITranslateWhileWriteComponent$IOnChattingEndCallback;", "", "callback", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void callback();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/api/ITranslateWhileWriteComponent$IOnTranslateResCallback;", "", "callback", "", "text", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void aal(String paramString);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/api/ITranslateWhileWriteComponent$TipNeedShowCallback;", "", "callback", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void callback();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.api.bd
 * JD-Core Version:    0.7.0.1
 */