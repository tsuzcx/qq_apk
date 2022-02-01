package com.tencent.mm.plugin.record.a;

import com.tencent.mm.sdk.storage.IAutoStorage;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.List;

public abstract interface h
  extends IAutoStorage<k>, IStorage
{
  public static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(k.info, "RecordMessageInfo") };
  
  public abstract void acc(int paramInt);
  
  public abstract k acd(int paramInt);
  
  public abstract List<k> fuq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.a.h
 * JD-Core Version:    0.7.0.1
 */