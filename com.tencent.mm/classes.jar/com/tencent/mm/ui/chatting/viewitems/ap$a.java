package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a;

abstract class ap$a
  extends c
{
  protected ap.h vGP;
  
  public String b(a parama, bi parambi)
  {
    return parama.getTalkerUserName();
  }
  
  public boolean bfO()
  {
    return false;
  }
  
  protected final ap.h k(a parama)
  {
    if (this.vGP == null) {
      this.vGP = new ap.h(parama);
    }
    return this.vGP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap.a
 * JD-Core Version:    0.7.0.1
 */