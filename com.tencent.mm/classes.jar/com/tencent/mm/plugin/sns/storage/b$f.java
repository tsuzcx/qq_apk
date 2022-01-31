package com.tencent.mm.plugin.sns.storage;

import java.util.ArrayList;

public final class b$f
{
  public String oBR = "";
  public ArrayList<b.g> oBS = new ArrayList();
  
  public b$f(b paramb) {}
  
  public final String xZ(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.oBS.size())) {
      return ((b.g)this.oBS.get(paramInt)).oBV;
    }
    return "";
  }
  
  public final String ya(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.oBS.size())) {
      return ((b.g)this.oBS.get(paramInt)).title;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.b.f
 * JD-Core Version:    0.7.0.1
 */