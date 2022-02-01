package com.tencent.mm.plugin.record.a;

import com.tencent.mm.sdk.e.d;
import com.tencent.mm.sdk.e.g;
import com.tencent.mm.sdk.e.j;
import java.util.List;

public abstract interface h
  extends d<k>, g
{
  public static final String[] SQL_CREATE = { j.getCreateSQLs(k.info, "RecordMessageInfo") };
  
  public abstract k NA(int paramInt);
  
  public abstract void Nz(int paramInt);
  
  public abstract List<k> dEh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.a.h
 * JD-Core Version:    0.7.0.1
 */