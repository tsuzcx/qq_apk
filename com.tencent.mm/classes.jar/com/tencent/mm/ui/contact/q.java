package com.tencent.mm.ui.contact;

import java.util.List;

public abstract class q
  extends p
{
  protected boolean GWl;
  protected List<String> fvP;
  
  public q(n paramn, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramn, paramList, paramBoolean1, paramBoolean2, 0);
  }
  
  public q(n paramn, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this(paramn, paramList, paramBoolean1, paramBoolean2, paramInt, false);
  }
  
  private q(n paramn, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    super(paramn, paramBoolean2, paramInt, paramBoolean3);
    this.fvP = paramList;
    this.GWl = paramBoolean1;
  }
  
  public q(n paramn, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(paramn, paramList, paramBoolean1, paramBoolean2, 0, paramBoolean3);
  }
  
  public void VP() {}
  
  public int aLn(String paramString)
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.q
 * JD-Core Version:    0.7.0.1
 */