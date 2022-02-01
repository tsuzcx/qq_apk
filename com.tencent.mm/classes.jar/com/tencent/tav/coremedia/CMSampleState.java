package com.tencent.tav.coremedia;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CMSampleState
{
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
    AppMethodBeat.i(200204);
    this.isNewFrame = true;
    this.stateCode = 0L;
    this.time = new CMTime(paramLong);
    this.stateCode = paramLong;
    this.msg = paramString;
    this.throwable = paramThrowable;
    AppMethodBeat.o(200204);
  }
  
  public CMSampleState(CMTime paramCMTime)
  {
    AppMethodBeat.i(200203);
    this.isNewFrame = true;
    this.stateCode = 0L;
    this.time = paramCMTime;
    if (paramCMTime.value < 0L) {
      this.stateCode = paramCMTime.value;
    }
    AppMethodBeat.o(200203);
  }
  
  public static CMSampleState fromError(long paramLong)
  {
    AppMethodBeat.i(200200);
    CMSampleState localCMSampleState = fromError(paramLong, "state:".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(200200);
    return localCMSampleState;
  }
  
  public static CMSampleState fromError(long paramLong, String paramString)
  {
    AppMethodBeat.i(200201);
    paramString = fromError(paramLong, paramString, new RuntimeException(paramString));
    AppMethodBeat.o(200201);
    return paramString;
  }
  
  public static CMSampleState fromError(long paramLong, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(200202);
    paramString = new CMSampleState(paramLong, paramString, paramThrowable);
    AppMethodBeat.o(200202);
    return paramString;
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
    AppMethodBeat.i(200205);
    String str = "CMSampleState{time=" + this.time + ", isNewFrame=" + this.isNewFrame + ", stateCode=" + this.stateCode + ", throwable=" + this.throwable + ", msg='" + this.msg + '\'' + '}';
    AppMethodBeat.o(200205);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMSampleState
 * JD-Core Version:    0.7.0.1
 */