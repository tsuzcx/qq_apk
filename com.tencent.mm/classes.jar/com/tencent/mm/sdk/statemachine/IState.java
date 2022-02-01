package com.tencent.mm.sdk.statemachine;

import android.os.Message;

public abstract interface IState
{
  public static final boolean HANDLED = true;
  public static final boolean NOT_HANDLED = false;
  
  public abstract void enter();
  
  public abstract void exit();
  
  public abstract String getName();
  
  public abstract boolean processMessage(Message paramMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.statemachine.IState
 * JD-Core Version:    0.7.0.1
 */