package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.d.a;

abstract class bp$a
  extends c
{
  protected bp.h aeXp;
  
  public String a(a parama, cc paramcc)
  {
    return parama.getTalkerUserName();
  }
  
  public boolean fXn()
  {
    return false;
  }
  
  protected final bp.h p(a parama)
  {
    if (this.aeXp == null) {
      this.aeXp = new bp.h(parama);
    }
    return this.aeXp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bp.a
 * JD-Core Version:    0.7.0.1
 */