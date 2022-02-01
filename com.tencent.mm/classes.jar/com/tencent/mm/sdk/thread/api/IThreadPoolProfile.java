package com.tencent.mm.sdk.thread.api;

import com.tencent.mm.sdk.thread.ThreadTaskInfo;
import java.util.List;

public abstract interface IThreadPoolProfile
{
  public abstract long getTaskTimeout();
  
  public abstract void onBusy(int paramInt, List<ThreadTaskInfo> paramList1, List<ThreadTaskInfo> paramList2);
  
  public abstract void onException(Object paramObject, Throwable paramThrowable);
  
  public abstract void onLog(Runnable paramRunnable, String paramString, long paramLong1, long paramLong2);
  
  public abstract void onRelax(long paramLong);
  
  public abstract void onTaskAdded(ThreadTaskInfo paramThreadTaskInfo);
  
  public abstract void onTaskAfterExecuted(ThreadTaskInfo paramThreadTaskInfo);
  
  public abstract void onTaskBeforeExecute(ThreadTaskInfo paramThreadTaskInfo);
  
  public abstract void onTaskRemove(ThreadTaskInfo paramThreadTaskInfo);
  
  public abstract void onTaskTimeout(ThreadTaskInfo paramThreadTaskInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.thread.api.IThreadPoolProfile
 * JD-Core Version:    0.7.0.1
 */