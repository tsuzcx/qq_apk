package com.tencent.recovery.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.recovery.Recovery;

public class RecoveryMessageHandler
  extends Handler
{
  public RecoveryMessageHandler()
  {
    super(Looper.getMainLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      Recovery.cOs();
      return;
    case 2: 
      Recovery.Jh(1);
      return;
    }
    Recovery.Jh(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.handler.RecoveryMessageHandler
 * JD-Core Version:    0.7.0.1
 */