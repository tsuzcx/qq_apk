package com.tencent.mm.ui.chatting.d.b;

import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.d.ad;

public abstract interface s
  extends ad
{
  public abstract boolean aH(bu parambu);
  
  public abstract boolean al(am paramam);
  
  public abstract ChatFooter fDC();
  
  public abstract ChatFooterCustom fDD();
  
  public abstract String fDF();
  
  public abstract void fDG();
  
  public abstract void fDI();
  
  public abstract void fDK();
  
  public abstract void fDL();
  
  public abstract void fDM();
  
  public abstract void setVoiceInputShowCallback(ChatFooter.d paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.b.s
 * JD-Core Version:    0.7.0.1
 */