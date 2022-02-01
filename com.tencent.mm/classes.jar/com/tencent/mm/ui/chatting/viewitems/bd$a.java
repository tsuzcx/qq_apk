package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.e.a;

abstract class bd$a
  extends c
{
  protected bd.h KDu;
  
  public String b(a parama, bv parambv)
  {
    return parama.getTalkerUserName();
  }
  
  public boolean fLz()
  {
    return false;
  }
  
  protected final bd.h o(a parama)
  {
    if (this.KDu == null) {
      this.KDu = new bd.h(parama);
    }
    return this.KDu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bd.a
 * JD-Core Version:    0.7.0.1
 */