package org.xwalk.core;

public abstract interface XWalkUpdater$XWalkBackgroundUpdateListener
{
  public abstract void onXWalkUpdateCancelled();
  
  public abstract void onXWalkUpdateCompleted();
  
  public abstract void onXWalkUpdateFailed(int paramInt);
  
  public abstract void onXWalkUpdateProgress(int paramInt);
  
  public abstract void onXWalkUpdateStarted();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener
 * JD-Core Version:    0.7.0.1
 */