package com.tencent.mm.ui.chatting.d.b;

import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.d.af;

public abstract interface u
  extends af
{
  public abstract boolean aT(ca paramca);
  
  public abstract boolean au(as paramas);
  
  public abstract ChatFooter gPO();
  
  public abstract ChatFooterCustom gPP();
  
  public abstract String gPR();
  
  public abstract void gPS();
  
  public abstract void gPU();
  
  public abstract void gPW();
  
  public abstract void gPX();
  
  public abstract void gPY();
  
  public abstract void setVoiceInputShowCallback(ChatFooter.d paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.b.u
 * JD-Core Version:    0.7.0.1
 */