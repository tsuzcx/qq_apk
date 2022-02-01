package com.tencent.mm.plugin.story.api;

public abstract interface l
{
  public abstract void a(l.a parama);
  
  public abstract boolean ard(String paramString);
  
  public abstract void destroy();
  
  public abstract void pause();
  
  public abstract void resume();
  
  public abstract void start();
  
  public static final class d
  {
    public int drT = 0;
    public String username = null;
    
    public d(String paramString, int paramInt)
    {
      this.username = paramString;
      this.drT = paramInt;
    }
    
    public final boolean dGq()
    {
      return this.drT == 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.l
 * JD-Core Version:    0.7.0.1
 */