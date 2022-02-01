package com.tencent.mm.plugin.story.api;

import java.util.ArrayList;
import java.util.List;

public abstract interface l
{
  public abstract void a(a parama);
  
  public abstract void destroy();
  
  public abstract void pause();
  
  public abstract void resume();
  
  public abstract void start();
  
  public static abstract interface a
  {
    public abstract void a(List<String> paramList, ArrayList<String> paramArrayList);
    
    public abstract void aE(boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void cG(String paramString, boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void fZr();
  }
  
  public static final class d
  {
    public int fNO = 0;
    public String username = null;
    
    public d(String paramString, int paramInt)
    {
      this.username = paramString;
      this.fNO = paramInt;
    }
    
    public final boolean gbI()
    {
      return this.fNO == 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.l
 * JD-Core Version:    0.7.0.1
 */