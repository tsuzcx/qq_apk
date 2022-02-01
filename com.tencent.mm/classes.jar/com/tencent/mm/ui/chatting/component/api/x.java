package com.tencent.mm.ui.chatting.component.api;

import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.component.aj;

public abstract interface x
  extends aj
{
  public abstract boolean aG(au paramau);
  
  public abstract boolean bC(cc paramcc);
  
  public abstract ChatFooter jsd();
  
  public abstract ChatFooterCustom jse();
  
  public abstract String jsg();
  
  public abstract void jsh();
  
  public abstract void jsj();
  
  public abstract void jsl();
  
  public abstract void jsm();
  
  public abstract void jsn();
  
  public abstract void setVoiceInputShowCallback(ChatFooter.d paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.api.x
 * JD-Core Version:    0.7.0.1
 */