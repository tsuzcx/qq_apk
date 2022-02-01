package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.e.a;

abstract class bd$a
  extends c
{
  protected bd.h KgZ;
  
  public String b(a parama, bu parambu)
  {
    return parama.getTalkerUserName();
  }
  
  public boolean fHh()
  {
    return false;
  }
  
  protected final bd.h o(a parama)
  {
    if (this.KgZ == null) {
      this.KgZ = new bd.h(parama);
    }
    return this.KgZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bd.a
 * JD-Core Version:    0.7.0.1
 */