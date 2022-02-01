package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.d.a;

abstract class bb$a
  extends c
{
  protected bb.h GQw;
  
  public String b(a parama, bl parambl)
  {
    return parama.getTalkerUserName();
  }
  
  public boolean faE()
  {
    return false;
  }
  
  protected final bb.h o(a parama)
  {
    if (this.GQw == null) {
      this.GQw = new bb.h(parama);
    }
    return this.GQw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bb.a
 * JD-Core Version:    0.7.0.1
 */