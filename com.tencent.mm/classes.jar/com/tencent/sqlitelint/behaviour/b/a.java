package com.tencent.sqlitelint.behaviour.b;

import com.tencent.sqlitelint.SQLiteLintIssue;
import java.util.List;

public final class a
  extends com.tencent.sqlitelint.behaviour.a
{
  private final a wRG;
  
  public a(a parama)
  {
    this.wRG = parama;
  }
  
  public final void ey(List<SQLiteLintIssue> paramList)
  {
    if (this.wRG != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        this.wRG.a((SQLiteLintIssue)paramList.get(i));
        i += 1;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(SQLiteLintIssue paramSQLiteLintIssue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.b.a
 * JD-Core Version:    0.7.0.1
 */