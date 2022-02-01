package com.tencent.tav.coremedia;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class CMSampleState
{
  private int exportCode;
  private boolean isNewFrame;
  private String msg;
  public CMPerformance performance;
  private long stateCode;
  private Throwable throwable;
  private final CMTime time;
  
  public CMSampleState()
  {
    this(CMTime.CMTimeInvalid);
  }
  
  public CMSampleState(long paramLong, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(215746);
    this.performance = new CMPerformance();
    this.isNewFrame = true;
    this.stateCode = 0L;
    this.exportCode = 0;
    this.time = new CMTime(paramLong);
    this.stateCode = paramLong;
    this.msg = paramString;
    this.throwable = paramThrowable;
    AppMethodBeat.o(215746);
  }
  
  public CMSampleState(CMTime paramCMTime)
  {
    AppMethodBeat.i(215734);
    this.performance = new CMPerformance();
    this.isNewFrame = true;
    this.stateCode = 0L;
    this.exportCode = 0;
    this.time = paramCMTime;
    if (paramCMTime.value < 0L) {
      this.stateCode = paramCMTime.value;
    }
    AppMethodBeat.o(215734);
  }
  
  public CMSampleState(CMTime paramCMTime, CMPerformance paramCMPerformance)
  {
    this(paramCMTime);
    this.performance = paramCMPerformance;
  }
  
  public static CMSampleState fromError(long paramLong)
  {
    AppMethodBeat.i(215698);
    CMSampleState localCMSampleState = fromError(paramLong, "state:".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(215698);
    return localCMSampleState;
  }
  
  public static CMSampleState fromError(long paramLong, String paramString)
  {
    AppMethodBeat.i(215703);
    paramString = fromError(paramLong, paramString, new RuntimeException(paramString));
    AppMethodBeat.o(215703);
    return paramString;
  }
  
  public static CMSampleState fromError(long paramLong, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(215709);
    paramString = new CMSampleState(paramLong, paramString, paramThrowable);
    AppMethodBeat.o(215709);
    return paramString;
  }
  
  public static CMSampleState fromExportError(long paramLong, int paramInt, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(215715);
    paramString = new CMSampleState(paramLong, paramString, paramThrowable);
    paramString.exportCode = paramInt;
    AppMethodBeat.o(215715);
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
  
  public CMSampleState inherit(CMSampleState paramCMSampleState)
  {
    this.performance = paramCMSampleState.performance;
    paramCMSampleState.performance = null;
    return this;
  }
  
  public boolean isInvalid()
  {
    return this.time == CMTime.CMTimeInvalid;
  }
  
  public boolean isNewFrame()
  {
    return this.isNewFrame;
  }
  
  public void joinNode(CMSampleState paramCMSampleState)
  {
    AppMethodBeat.i(215753);
    if (paramCMSampleState.performance != null)
    {
      this.performance.preNodes.add(paramCMSampleState.performance);
      paramCMSampleState.performance = null;
    }
    AppMethodBeat.o(215753);
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
    AppMethodBeat.i(215829);
    String str = "CMSampleState{time=" + this.time + ", isNewFrame=" + this.isNewFrame + ", stateCode=" + this.stateCode + ", throwable=" + this.throwable + ", msg='" + this.msg + '\'' + '}';
    AppMethodBeat.o(215829);
    return str;
  }
  
  public void updatePerformance()
  {
    AppMethodBeat.i(215762);
    while (this.performance.getNextNode() != null) {
      this.performance = this.performance.getNextNode();
    }
    AppMethodBeat.o(215762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMSampleState
 * JD-Core Version:    0.7.0.1
 */