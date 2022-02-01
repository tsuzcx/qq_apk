package com.tencent.mm.sdk.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ThreadTaskInfo
{
  public long addedTime;
  public long costTime;
  public String name;
  public long startTime;
  public State state;
  
  public ThreadTaskInfo(String paramString)
  {
    this.name = paramString;
  }
  
  public String toString()
  {
    AppMethodBeat.i(158159);
    String str = this.name + " " + this.state + " " + this.addedTime + " " + this.startTime + " " + this.costTime;
    AppMethodBeat.o(158159);
    return str;
  }
  
  public static enum State
  {
    static
    {
      AppMethodBeat.i(158158);
      WAITING = new State("WAITING", 0);
      RUNNING = new State("RUNNING", 1);
      FINISH = new State("FINISH", 2);
      $VALUES = new State[] { WAITING, RUNNING, FINISH };
      AppMethodBeat.o(158158);
    }
    
    private State() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.thread.ThreadTaskInfo
 * JD-Core Version:    0.7.0.1
 */