package com.tencent.wcdb;

import java.util.ArrayList;

public abstract class Observable<T>
{
  protected final ArrayList<T> mObservers = new ArrayList();
  
  public void registerObserver(T paramT)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    synchronized (this.mObservers)
    {
      if (this.mObservers.contains(paramT)) {
        throw new IllegalStateException("Observer " + paramT + " is already registered.");
      }
    }
    this.mObservers.add(paramT);
  }
  
  public void unregisterAll()
  {
    synchronized (this.mObservers)
    {
      this.mObservers.clear();
      return;
    }
  }
  
  public void unregisterObserver(T paramT)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    int i;
    synchronized (this.mObservers)
    {
      i = this.mObservers.indexOf(paramT);
      if (i == -1) {
        throw new IllegalStateException("Observer " + paramT + " was not registered.");
      }
    }
    this.mObservers.remove(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.Observable
 * JD-Core Version:    0.7.0.1
 */