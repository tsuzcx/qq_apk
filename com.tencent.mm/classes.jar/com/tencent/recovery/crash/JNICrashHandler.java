package com.tencent.recovery.crash;

import com.tencent.recovery.Recovery;
import com.tencent.recovery.log.RecoveryLog;

public class JNICrashHandler
{
  private static final String TAG = "Recovery.JNICrashHandler";
  
  private static void onCrash()
  {
    RecoveryLog.i("Recovery.JNICrashHandler", "onCrash", new Object[0]);
    Recovery.dUi();
  }
  
  public static native void testSignal(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.crash.JNICrashHandler
 * JD-Core Version:    0.7.0.1
 */