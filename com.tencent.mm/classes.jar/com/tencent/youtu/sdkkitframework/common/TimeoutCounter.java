package com.tencent.youtu.sdkkitframework.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import java.util.HashMap;

public class TimeoutCounter
{
  private static final String TAG;
  private long elaspeTimeMs = 0L;
  private String name = "timeout counter";
  private boolean needShowTimer = true;
  private boolean needTimer = false;
  private long targetTimeoutMs = 0L;
  
  static
  {
    AppMethodBeat.i(218328);
    TAG = TimeoutCounter.class.getSimpleName();
    AppMethodBeat.o(218328);
  }
  
  public TimeoutCounter(String paramString)
  {
    this.name = paramString;
  }
  
  public void cancel()
  {
    AppMethodBeat.i(218395);
    YtLogger.i(TAG, this.name + " cancel");
    this.needTimer = false;
    AppMethodBeat.o(218395);
  }
  
  public boolean checkTimeout()
  {
    AppMethodBeat.i(218389);
    if (this.needTimer)
    {
      if ((this.targetTimeoutMs > 0L) && (System.currentTimeMillis() - this.elaspeTimeMs > this.targetTimeoutMs))
      {
        AppMethodBeat.o(218389);
        return true;
      }
      AppMethodBeat.o(218389);
      return false;
    }
    AppMethodBeat.o(218389);
    return false;
  }
  
  public void init(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(218347);
    this.targetTimeoutMs = paramLong;
    this.needShowTimer = paramBoolean;
    YtLogger.i(TAG, this.name + " init with " + this.targetTimeoutMs);
    AppMethodBeat.o(218347);
  }
  
  public boolean isRunning()
  {
    return (this.needTimer) && (this.targetTimeoutMs > 0L);
  }
  
  public void reset()
  {
    AppMethodBeat.i(218377);
    YtLogger.i(TAG, this.name + " reset");
    this.needTimer = true;
    if ((this.targetTimeoutMs > 0L) && (this.needShowTimer)) {
      YtFSM.getInstance().sendFSMEvent(new HashMap() {});
    }
    this.elaspeTimeMs = System.currentTimeMillis();
    AppMethodBeat.o(218377);
  }
  
  public void start()
  {
    AppMethodBeat.i(218360);
    reset();
    AppMethodBeat.o(218360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.TimeoutCounter
 * JD-Core Version:    0.7.0.1
 */