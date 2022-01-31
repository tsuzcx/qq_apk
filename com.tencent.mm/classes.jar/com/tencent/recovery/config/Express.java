package com.tencent.recovery.config;

import java.util.ArrayList;
import java.util.List;

public class Express
{
  public List<List<ExpressItem>> Bik = new ArrayList();
  
  public final void fI(List<ExpressItem> paramList)
  {
    this.Bik.add(paramList);
  }
  
  public String toString()
  {
    return this.Bik.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.config.Express
 * JD-Core Version:    0.7.0.1
 */