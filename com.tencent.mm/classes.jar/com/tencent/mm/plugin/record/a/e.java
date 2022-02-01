package com.tencent.mm.plugin.record.a;

import com.tencent.mm.sdk.e.g;
import com.tencent.mm.sdk.e.j;
import java.util.List;

public abstract interface e
  extends com.tencent.mm.sdk.e.d<i>, g
{
  public static final String[] SQL_CREATE = { j.getCreateSQLs(i.info, "RecordCDNInfo") };
  
  public abstract List<i> Ka(int paramInt);
  
  public abstract void a(d paramd);
  
  public abstract boolean a(i parami);
  
  public abstract boolean a(i parami, String... paramVarArgs);
  
  public abstract i als(String paramString);
  
  public abstract void b(d paramd);
  
  public abstract boolean b(i parami);
  
  public abstract boolean b(i parami, String... paramVarArgs);
  
  public abstract List<i> dgc();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.a.e
 * JD-Core Version:    0.7.0.1
 */