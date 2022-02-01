package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.d.a;

abstract class bc$a
  extends c
{
  protected bc.h Iqx;
  
  public String b(a parama, bo parambo)
  {
    return parama.getTalkerUserName();
  }
  
  public boolean fqu()
  {
    return false;
  }
  
  protected final bc.h o(a parama)
  {
    if (this.Iqx == null) {
      this.Iqx = new bc.h(parama);
    }
    return this.Iqx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bc.a
 * JD-Core Version:    0.7.0.1
 */