package com.tencent.mm.ui.contact;

import java.util.List;

public abstract class r
  extends q
{
  private boolean afeW;
  private List<String> lMF;
  
  public r(o paramo, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramo, paramList, paramBoolean1, paramBoolean2, 0);
  }
  
  public r(o paramo, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this(paramo, paramList, paramBoolean1, paramBoolean2, paramInt, false);
  }
  
  private r(o paramo, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    super(paramo, paramBoolean2, paramInt, paramBoolean3);
    this.lMF = paramList;
    this.afeW = paramBoolean1;
  }
  
  public r(o paramo, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(paramo, paramList, paramBoolean1, paramBoolean2, 0, paramBoolean3);
  }
  
  public int aJM(String paramString)
  {
    return -1;
  }
  
  public void aNm() {}
  
  protected final List<String> cVa()
  {
    return this.lMF;
  }
  
  protected final boolean jyS()
  {
    return this.afeW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.r
 * JD-Core Version:    0.7.0.1
 */