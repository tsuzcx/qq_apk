package com.tencent.sqlitelint.behaviour.persistence;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.behaviour.BaseBehaviour;
import java.util.List;

public class PersistenceBehaviour
  extends BaseBehaviour
{
  public void onPublish(List<SQLiteLintIssue> paramList)
  {
    AppMethodBeat.i(52922);
    IssueStorage.saveIssues(paramList);
    AppMethodBeat.o(52922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.persistence.PersistenceBehaviour
 * JD-Core Version:    0.7.0.1
 */