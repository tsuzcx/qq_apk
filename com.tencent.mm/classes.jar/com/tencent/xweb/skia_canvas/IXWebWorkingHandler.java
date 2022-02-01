package com.tencent.xweb.skia_canvas;

public abstract interface IXWebWorkingHandler
{
  public abstract boolean isRunOnWorkingThread();
  
  public abstract void post(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.IXWebWorkingHandler
 * JD-Core Version:    0.7.0.1
 */