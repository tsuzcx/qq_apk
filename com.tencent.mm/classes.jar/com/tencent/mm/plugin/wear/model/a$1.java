package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f.c;

final class a$1
  extends c
{
  a$1(a parama) {}
  
  public final String getName()
  {
    return "PhoneStartTask";
  }
  
  protected final void send()
  {
    r.b(20001, null, false);
    r.b(20008, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a.1
 * JD-Core Version:    0.7.0.1
 */