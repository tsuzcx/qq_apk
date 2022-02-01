package com.tencent.threadpool.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;

public abstract interface a
{
  public abstract void dispatchMessage(Message paramMessage);
  
  public abstract void dump(Printer paramPrinter, String paramString);
  
  public abstract boolean executeOrSendMessage(Message paramMessage);
  
  public abstract Looper getLooper();
  
  public abstract String getMessageName(Message paramMessage);
  
  public abstract Handler getSelf();
  
  public abstract com.tencent.threadpool.j.a getSerial();
  
  public abstract String getSerialTag();
  
  public abstract boolean hasMessages(int paramInt);
  
  public abstract boolean hasMessages(int paramInt, Object paramObject);
  
  public abstract boolean isQuit();
  
  public abstract Message obtainMessage();
  
  public abstract Message obtainMessage(int paramInt);
  
  public abstract Message obtainMessage(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract Message obtainMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
  
  public abstract Message obtainMessage(int paramInt, Object paramObject);
  
  public abstract boolean post(Runnable paramRunnable);
  
  public abstract boolean postAtFrontOfQueue(Runnable paramRunnable);
  
  public abstract boolean postAtTime(Runnable paramRunnable, long paramLong);
  
  public abstract boolean postAtTime(Runnable paramRunnable, Object paramObject, long paramLong);
  
  public abstract boolean postDelayed(Runnable paramRunnable, long paramLong);
  
  public abstract boolean postDelayed(Runnable paramRunnable, Object paramObject, long paramLong);
  
  public abstract boolean quit();
  
  public abstract void removeCallbacks(Runnable paramRunnable);
  
  public abstract void removeCallbacks(Runnable paramRunnable, Object paramObject);
  
  public abstract void removeCallbacksAndMessages(Object paramObject);
  
  public abstract void removeMessages(int paramInt);
  
  public abstract void removeMessages(int paramInt, Object paramObject);
  
  public abstract boolean sendEmptyMessage(int paramInt);
  
  public abstract boolean sendEmptyMessageAtTime(int paramInt, long paramLong);
  
  public abstract boolean sendEmptyMessageDelayed(int paramInt, long paramLong);
  
  public abstract boolean sendMessage(Message paramMessage);
  
  public abstract boolean sendMessageAtFrontOfQueue(Message paramMessage);
  
  public abstract boolean sendMessageAtTime(Message paramMessage, long paramLong);
  
  public abstract boolean sendMessageDelayed(Message paramMessage, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.d.a
 * JD-Core Version:    0.7.0.1
 */