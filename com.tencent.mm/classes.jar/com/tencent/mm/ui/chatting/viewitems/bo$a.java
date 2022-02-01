package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.e.a;

abstract class bo$a
  extends c
{
  protected bo.h Xmm;
  
  public String a(a parama, ca paramca)
  {
    return parama.getTalkerUserName();
  }
  
  public boolean hTD()
  {
    return false;
  }
  
  protected final bo.h o(a parama)
  {
    if (this.Xmm == null) {
      this.Xmm = new bo.h(parama);
    }
    return this.Xmm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bo.a
 * JD-Core Version:    0.7.0.1
 */