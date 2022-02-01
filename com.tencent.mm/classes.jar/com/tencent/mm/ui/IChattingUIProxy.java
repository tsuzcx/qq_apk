package com.tencent.mm.ui;

public abstract interface IChattingUIProxy
{
  public abstract void onEnterBegin();
  
  public abstract void onEnterEnd();
  
  public abstract void onExitBegin();
  
  public abstract void onExitEnd();
  
  public abstract void onInit(int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.IChattingUIProxy
 * JD-Core Version:    0.7.0.1
 */