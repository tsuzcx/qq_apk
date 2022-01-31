package com.tencent.mm.plugin.report.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class d
{
  public String bIW;
  public long nFu;
  public long nFv;
  public String nFw;
  public boolean nFx;
  public String value;
  
  public d() {}
  
  public d(long paramLong1, String paramString, long paramLong2, boolean paramBoolean)
  {
    this.nFu = paramLong1;
    this.value = paramString;
    this.nFv = paramLong2;
    this.nFx = paramBoolean;
    this.nFw = new SimpleDateFormat("[yy-MM-dd HH:mm:ss:SSS]").format(new Date(paramLong2));
  }
  
  public final String toString()
  {
    return this.nFw + ":" + this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.d
 * JD-Core Version:    0.7.0.1
 */