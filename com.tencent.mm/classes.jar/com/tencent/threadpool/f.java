package com.tencent.threadpool;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f
{
  public int value;
  
  static
  {
    AppMethodBeat.i(183140);
    ahAr = new f("THROW", 0, -3);
    ahAs = new f("ERROR", 1, -2);
    ahAt = new f("CANCEL", 2, -1);
    ahAu = new f("CREATED", 3, 0);
    ahAv = new f("WAITING", 4, 1);
    ahAw = new f("RUNNING", 5, 2);
    ahAx = new f("COMPLETE", 6, 3);
    ahAy = new f[] { ahAr, ahAs, ahAt, ahAu, ahAv, ahAw, ahAx };
    AppMethodBeat.o(183140);
  }
  
  private f(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.f
 * JD-Core Version:    0.7.0.1
 */