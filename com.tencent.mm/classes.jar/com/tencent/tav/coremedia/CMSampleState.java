package com.tencent.tav.coremedia;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CMSampleState
{
  private int exportCode;
  private boolean isNewFrame;
  private String msg;
  private long stateCode;
  private Throwable throwable;
  private final CMTime time;
  
  public CMSampleState()
  {
    this(CMTime.CMTimeInvalid);
  }
  
  public CMSampleState(long paramLong, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(202916);
    this.isNewFrame = true;
    this.stateCode = 0L;
    this.exportCode = 0;
    this.time = new CMTime(paramLong);
    this.stateCode = paramLong;
    this.msg = paramString;
    this.throwable = paramThrowable;
    AppMethodBeat.o(202916);
  }
  
  public CMSampleState(CMTime paramCMTime)
  {
    AppMethodBeat.i(202915);
    this.isNewFrame = true;
    this.stateCode = 0L;
    this.exportCode = 0;
    this.time = paramCMTime;
    if (paramCMTime.value < 0L) {
      this.stateCode = paramCMTime.value;
    }
    AppMethodBeat.o(202915);
  }
  
  public static CMSampleState fromError(long paramLong)
  {
    AppMethodBeat.i(202909);
    CMSampleState localCMSampleState = fromError(paramLong, "state:".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(202909);
    return localCMSampleState;
  }
  
  public static CMSampleState fromError(long paramLong, String paramString)
  {
    AppMethodBeat.i(202910);
    paramString = fromError(paramLong, paramString, new RuntimeException(paramString));
    AppMethodBeat.o(202910);
    return paramString;
  }
  
  public static CMSampleState fromError(long paramLong, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(202911);
    paramString = new CMSampleState(paramLong, paramString, paramThrowable);
    AppMethodBeat.o(202911);
    return paramString;
  }
  
  public static CMSampleState fromExportError(long paramLong, int paramInt, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(202912);
    paramString = new CMSampleState(paramLong, paramString, paramThrowable);
    paramString.exportCode = paramInt;
    AppMethodBeat.o(202912);
    return paramString;
  }
  
  public int getExportCode()
  {
    return this.exportCode;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public long getStateCode()
  {
    return this.stateCode;
  }
  
  public Throwable getThrowable()
  {
    return this.throwable;
  }
  
  public CMTime getTime()
  {
    return this.time;
  }
  
  public boolean isInvalid()
  {
    return this.time == CMTime.CMTimeInvalid;
  }
  
  public boolean isNewFrame()
  {
    return this.isNewFrame;
  }
  
  public void setNewFrame(boolean paramBoolean)
  {
    this.isNewFrame = paramBoolean;
  }
  
  public boolean stateMatchingTo(long... paramVarArgs)
  {
    boolean bool2 = false;
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        long l = paramVarArgs[i];
        if (this.stateCode == l) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(202921);
    String str = "CMSampleState{time=" + this.time + ", isNewFrame=" + this.isNewFrame + ", stateCode=" + this.stateCode + ", throwable=" + this.throwable + ", msg='" + this.msg + '\'' + '}';
    AppMethodBeat.o(202921);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMSampleState
 * JD-Core Version:    0.7.0.1
 */