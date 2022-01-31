package com.tencent.recovery.config;

import java.util.ArrayList;
import java.util.List;

public class Express
{
  public List<List<ExpressItem>> wKJ = new ArrayList();
  
  public final void ew(List<ExpressItem> paramList)
  {
    this.wKJ.add(paramList);
  }
  
  public String toString()
  {
    return this.wKJ.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.config.Express
 * JD-Core Version:    0.7.0.1
 */