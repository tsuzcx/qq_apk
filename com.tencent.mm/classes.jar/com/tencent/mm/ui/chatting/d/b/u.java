package com.tencent.mm.ui.chatting.d.b;

import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.d.ag;

public abstract interface u
  extends ag
{
  public abstract boolean aA(as paramas);
  
  public abstract boolean bm(ca paramca);
  
  public abstract ChatFooter hPj();
  
  public abstract ChatFooterCustom hPk();
  
  public abstract String hPm();
  
  public abstract void hPn();
  
  public abstract void hPp();
  
  public abstract void hPr();
  
  public abstract void hPs();
  
  public abstract void hPt();
  
  public abstract void setVoiceInputShowCallback(ChatFooter.d paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.b.u
 * JD-Core Version:    0.7.0.1
 */