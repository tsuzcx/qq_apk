package com.tencent.mm.ui.contact;

import java.util.List;

public abstract class p
  extends o
{
  protected boolean AdB;
  protected List<String> ejc;
  
  public p(m paramm, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramm, paramList, paramBoolean1, paramBoolean2, 0);
  }
  
  public p(m paramm, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this(paramm, paramList, paramBoolean1, paramBoolean2, paramInt, false);
  }
  
  private p(m paramm, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    super(paramm, paramBoolean2, paramInt, paramBoolean3);
    this.ejc = paramList;
    this.AdB = paramBoolean1;
  }
  
  public p(m paramm, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(paramm, paramList, paramBoolean1, paramBoolean2, 0, paramBoolean3);
  }
  
  public int aux(String paramString)
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.p
 * JD-Core Version:    0.7.0.1
 */