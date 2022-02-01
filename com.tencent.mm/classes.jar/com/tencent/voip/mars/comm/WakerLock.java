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
    AppMethodBeat.i(55588);
    this.wakeLock = null;
    this.mHandler = null;
    this.mReleaser = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(55582);
        WakerLock.this.unLock();
        AppMethodBeat.o(55582);
      }
    };
    this.wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "MicroMsg.WakerLock");
    this.wakeLock.setReferenceCounted(false);
    this.mHandler = new Handler(paramContext.getMainLooper());
    AppMethodBeat.o(55588);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(55589);
    unLock();
    AppMethodBeat.o(55589);
  }
  
  public boolean isLocking()
  {
    AppMethodBeat.i(55593);
    try
    {
      boolean bool = this.wakeLock.isHeld();
      AppMethodBeat.o(55593);
      return bool;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(55593);
    }
    return false;
  }
  
  public void lock()
  {
    AppMethodBeat.i(55591);
    try
    {
      this.mHandler.removeCallbacks(this.mReleaser);
      this.wakeLock.acquire();
      AppMethodBeat.o(55591);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(55591);
    }
  }
  
  public void lock(long paramLong)
  {
    AppMethodBeat.i(55590);
    try
    {
      lock();
      this.mHandler.postDelayed(this.mReleaser, paramLong);
      AppMethodBeat.o(55590);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(55590);
    }
  }
  
  public void unLock()
  {
    AppMethodBeat.i(55592);
    try
    {
      this.mHandler.removeCallbacks(this.mReleaser);
      if (this.wakeLock.isHeld()) {
        this.wakeLock.release();
      }
      AppMethodBeat.o(55592);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(55592);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.voip.mars.comm.WakerLock
 * JD-Core Version:    0.7.0.1
 */