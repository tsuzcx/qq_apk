package com.tencent.mm.ui.chatting.c.b;

import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.c.ab;

public abstract interface q
  extends ab
{
  public abstract boolean aE(bo parambo);
  
  public abstract boolean al(ai paramai);
  
  public abstract ChatFooter fne();
  
  public abstract ChatFooterCustom fnf();
  
  public abstract String fnh();
  
  public abstract void fni();
  
  public abstract void fnk();
  
  public abstract void fnm();
  
  public abstract void fnn();
  
  public abstract void fno();
  
  public abstract void setVoiceInputShowCallback(ChatFooter.d paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.b.q
 * JD-Core Version:    0.7.0.1
 */