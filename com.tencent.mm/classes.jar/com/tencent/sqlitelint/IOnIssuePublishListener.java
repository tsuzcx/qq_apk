package com.tencent.sqlitelint;

import java.util.List;

public abstract interface IOnIssuePublishListener
{
  public abstract void onPublish(List<SQLiteLintIssue> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.sqlitelint.IOnIssuePublishListener
 * JD-Core Version:    0.7.0.1
 */