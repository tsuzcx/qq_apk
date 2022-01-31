package com.tencent.mm.ui.contact;

import java.util.List;

public abstract class o
  extends n
{
  public List<String> dru;
  public boolean vLZ;
  
  public o(l paraml, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paraml, paramList, paramBoolean1, paramBoolean2, 0);
  }
  
  public o(l paraml, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this(paraml, paramList, paramBoolean1, paramBoolean2, paramInt, false);
  }
  
  private o(l paraml, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    super(paraml, paramBoolean2, paramInt, paramBoolean3);
    this.dru = paramList;
    this.vLZ = paramBoolean1;
  }
  
  public o(l paraml, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(paraml, paramList, paramBoolean1, paramBoolean2, 0, paramBoolean3);
  }
  
  public int adP(String paramString)
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.o
 * JD-Core Version:    0.7.0.1
 */