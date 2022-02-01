package com.tencent.mm.plugin.record.a;

import com.tencent.mm.sdk.storage.IAutoStorage;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.List;

public abstract interface e
  extends IAutoStorage<j>, IStorage
{
  public static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(j.info, "RecordCDNInfo") };
  
  public abstract void a(d paramd);
  
  public abstract boolean a(j paramj);
  
  public abstract boolean a(j paramj, String... paramVarArgs);
  
  public abstract j aVy(String paramString);
  
  public abstract List<j> acb(int paramInt);
  
  public abstract void b(d paramd);
  
  public abstract boolean b(j paramj);
  
  public abstract boolean b(j paramj, String... paramVarArgs);
  
  public abstract List<j> fup();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.a.e
 * JD-Core Version:    0.7.0.1
 */