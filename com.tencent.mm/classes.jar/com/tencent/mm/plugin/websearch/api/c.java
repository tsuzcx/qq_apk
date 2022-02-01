package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.kernel.b.a;
import java.util.List;

public abstract interface c
  extends a
{
  public abstract String getExposedWord(String paramString);
  
  public abstract List<String> getNeedReuseBrands();
  
  public abstract List<String> getNeedReuseItems();
  
  public abstract int getSosLimitLength();
  
  public abstract boolean isOpenImageSearch();
  
  public abstract boolean isOpenInlineC2CTag();
  
  public abstract boolean isOpenInlineSnsTag();
  
  public abstract void startImageSearch(o paramo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.c
 * JD-Core Version:    0.7.0.1
 */