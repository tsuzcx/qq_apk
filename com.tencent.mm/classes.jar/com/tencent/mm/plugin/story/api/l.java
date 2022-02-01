package com.tencent.mm.plugin.story.api;

public abstract interface l
{
  public abstract void a(l.a parama);
  
  public abstract void destroy();
  
  public abstract void pause();
  
  public abstract void resume();
  
  public abstract void start();
  
  public static final class d
  {
    public int dBr = 0;
    public String username = null;
    
    public d(String paramString, int paramInt)
    {
      this.username = paramString;
      this.dBr = paramInt;
    }
    
    public final boolean ehg()
    {
      return this.dBr == 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.l
 * JD-Core Version:    0.7.0.1
 */