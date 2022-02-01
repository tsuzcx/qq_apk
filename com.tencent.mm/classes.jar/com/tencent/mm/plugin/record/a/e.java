package com.tencent.mm.plugin.record.a;

import com.tencent.mm.sdk.e.g;
import java.util.List;

public abstract interface e
  extends com.tencent.mm.sdk.e.d<j>, g
{
  public static final String[] SQL_CREATE = { com.tencent.mm.sdk.e.j.getCreateSQLs(j.info, "RecordCDNInfo") };
  
  public abstract List<j> Ny(int paramInt);
  
  public abstract void a(d paramd);
  
  public abstract boolean a(j paramj);
  
  public abstract boolean a(j paramj, String... paramVarArgs);
  
  public abstract j avq(String paramString);
  
  public abstract void b(d paramd);
  
  public abstract boolean b(j paramj);
  
  public abstract boolean b(j paramj, String... paramVarArgs);
  
  public abstract List<j> dEg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.a.e
 * JD-Core Version:    0.7.0.1
 */