package com.tencent.sqlitelint.behaviour.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.behaviour.BaseBehaviour;
import java.util.List;

public class IssueReportBehaviour
  extends BaseBehaviour
{
  private final IReportDelegate mReportDelegate;
  
  public IssueReportBehaviour(IReportDelegate paramIReportDelegate)
  {
    this.mReportDelegate = paramIReportDelegate;
  }
  
  public void onPublish(List<SQLiteLintIssue> paramList)
  {
    AppMethodBeat.i(94094);
    if (this.mReportDelegate != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        this.mReportDelegate.report((SQLiteLintIssue)paramList.get(i));
        i += 1;
      }
    }
    AppMethodBeat.o(94094);
  }
  
  public static abstract interface IReportDelegate
  {
    public abstract void report(SQLiteLintIssue paramSQLiteLintIssue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.report.IssueReportBehaviour
 * JD-Core Version:    0.7.0.1
 */