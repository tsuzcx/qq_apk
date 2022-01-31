package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.sdk.platformtools.ah;

public abstract class l$b
{
  public l.a nYU;
  protected boolean nYV = false;
  protected long nYW = l.nYQ;
  private ah nYX = new ah(new l.b.1(this));
  
  public l$b(l.a parama)
  {
    this.nYU = parama;
  }
  
  public void bzH()
  {
    reset();
    this.nYU = null;
  }
  
  public abstract void init();
  
  public abstract void pause();
  
  public abstract void reset();
  
  public abstract void resume();
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.l.b
 * JD-Core Version:    0.7.0.1
 */