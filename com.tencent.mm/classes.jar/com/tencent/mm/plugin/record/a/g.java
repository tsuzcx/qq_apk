package com.tencent.mm.plugin.record.a;

import com.tencent.mm.sdk.e.d;
import java.util.List;

public abstract interface g
  extends d<j>, com.tencent.mm.sdk.e.g
{
  public static final String[] SQL_CREATE = { com.tencent.mm.sdk.e.j.getCreateSQLs(j.info, "RecordMessageInfo") };
  
  public abstract void Kb(int paramInt);
  
  public abstract j Kc(int paramInt);
  
  public abstract List<j> dgd();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.record.a.g
 * JD-Core Version:    0.7.0.1
 */