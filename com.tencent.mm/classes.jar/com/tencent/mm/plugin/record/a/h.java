package com.tencent.mm.plugin.record.a;

import com.tencent.mm.sdk.storage.IAutoStorage;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.List;

public abstract interface h
  extends IAutoStorage<k>, IStorage
{
  public static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(k.info, "RecordMessageInfo") };
  
  public abstract void agq(int paramInt);
  
  public abstract k agr(int paramInt);
  
  public abstract List<k> gGf();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.a.h
 * JD-Core Version:    0.7.0.1
 */