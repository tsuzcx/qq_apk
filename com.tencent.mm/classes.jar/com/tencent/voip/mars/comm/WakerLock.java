package com.tencent.voip.mars.comm;

import android.content.Context;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class WakerLock
{
  private static final String TAG = "MicroMsg.WakerLock";
  private Handler mHandler = null;
  private Runnable mReleaser = new WakerLock.1(this);
  private PowerManager.WakeLock wakeLock = null;
  
  public WakerLock(Context paramContext)
  {
    this.wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "MicroMsg.WakerLock");
    this.wakeLock.setReferenceCounted(false);
    this.mHandler = new Handler(paramContext.getMainLooper());
  }
  
  protected void finalize()
  {
    unLock();
  }
  
  public boolean isLocking()
  {
    try
    {
      boolean bool = this.wakeLock.isHeld();
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public void lock()
  {
    try
    {
      this.mHandler.removeCallbacks(this.mReleaser);
      this.wakeLock.acquire();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void lock(long paramLong)
  {
    try
    {
      lock();
      this.mHandler.postDelayed(this.mReleaser, paramLong);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void unLock()
  {
    try
    {
      this.mHandler.removeCallbacks(this.mReleaser);
      if (this.wakeLock.isHeld()) {
        this.wakeLock.release();
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.voip.mars.comm.WakerLock
 * JD-Core Version:    0.7.0.1
 */