package com.tencent.mm.plugin.record.a;

import com.tencent.mm.sdk.e.d;
import java.util.List;

public abstract interface g
  extends d<j>, com.tencent.mm.sdk.e.g
{
  public static final String[] SQL_CREATE = { com.tencent.mm.sdk.e.j.getCreateSQLs(j.info, "RecordMessageInfo") };
  
  public abstract void Cl(int paramInt);
  
  public abstract j Cm(int paramInt);
  
  public abstract List<j> cfN();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.record.a.g
 * JD-Core Version:    0.7.0.1
 */