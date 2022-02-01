package com.tencent.mm.ui.chatting.d.b;

import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.d.ad;

public abstract interface s
  extends ad
{
  public abstract boolean aG(bv parambv);
  
  public abstract boolean as(an paraman);
  
  public abstract ChatFooter fHF();
  
  public abstract ChatFooterCustom fHG();
  
  public abstract String fHI();
  
  public abstract void fHJ();
  
  public abstract void fHL();
  
  public abstract void fHN();
  
  public abstract void fHO();
  
  public abstract void fHP();
  
  public abstract void setVoiceInputShowCallback(ChatFooter.d paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.b.s
 * JD-Core Version:    0.7.0.1
 */