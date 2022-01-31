package com.tencent.voip.mars.comm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WakerLock
{
  private static final String TAG = "MicroMsg.WakerLock";
  private Handler mHandler;
  private Runnable mReleaser;
  private PowerManager.WakeLock wakeLock;
  
  @SuppressLint({"InvalidWakeLockTag"})
  public WakerLock(Context paramContext)
  {
    AppMethodBeat.i(92751);
    this.wakeLock = null;
    this.mHandler = null;
    this.mReleaser = new WakerLock.1(this);
    this.wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "MicroMsg.WakerLock");
    this.wakeLock.setReferenceCounted(false);
    this.mHandler = new Handler(paramContext.getMainLooper());
    AppMethodBeat.o(92751);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(92752);
    unLock();
    AppMethodBeat.o(92752);
  }
  
  public boolean isLocking()
  {
    AppMethodBeat.i(92756);
    try
    {
      boolean bool = this.wakeLock.isHeld();
      AppMethodBeat.o(92756);
      return bool;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(92756);
    }
    return false;
  }
  
  public void lock()
  {
    AppMethodBeat.i(92754);
    try
    {
      this.mHandler.removeCallbacks(this.mReleaser);
      this.wakeLock.acquire();
      AppMethodBeat.o(92754);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(92754);
    }
  }
  
  public void lock(long paramLong)
  {
    AppMethodBeat.i(92753);
    try
    {
      lock();
      this.mHandler.postDelayed(this.mReleaser, paramLong);
      AppMethodBeat.o(92753);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(92753);
    }
  }
  
  public void unLock()
  {
    AppMethodBeat.i(92755);
    try
    {
      this.mHandler.removeCallbacks(this.mReleaser);
      if (this.wakeLock.isHeld()) {
        this.wakeLock.release();
      }
      AppMethodBeat.o(92755);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(92755);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.voip.mars.comm.WakerLock
 * JD-Core Version:    0.7.0.1
 */