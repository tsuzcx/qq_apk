package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.e.a;

abstract class bj$a
  extends c
{
  protected bj.h PQk;
  
  public String a(a parama, ca paramca)
  {
    return parama.getTalkerUserName();
  }
  
  public boolean gTT()
  {
    return false;
  }
  
  protected final bj.h o(a parama)
  {
    if (this.PQk == null) {
      this.PQk = new bj.h(parama);
    }
    return this.PQk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bj.a
 * JD-Core Version:    0.7.0.1
 */