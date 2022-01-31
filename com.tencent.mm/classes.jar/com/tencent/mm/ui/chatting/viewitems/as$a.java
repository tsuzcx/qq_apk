package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.d.a;

abstract class as$a
  extends c
{
  protected as.h zYl;
  
  public String b(a parama, bi parambi)
  {
    return parama.getTalkerUserName();
  }
  
  public boolean dLp()
  {
    return false;
  }
  
  protected final as.h o(a parama)
  {
    if (this.zYl == null) {
      this.zYl = new as.h(parama);
    }
    return this.zYl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.as.a
 * JD-Core Version:    0.7.0.1
 */