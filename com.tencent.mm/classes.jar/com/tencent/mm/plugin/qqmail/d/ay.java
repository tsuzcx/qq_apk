package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ay
  extends com.tencent.mm.cd.a
{
  public long HnF;
  public String HnG;
  public String HnH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(249940);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.HnF);
      if (this.HnG != null) {
        paramVarArgs.f(2, this.HnG);
      }
      if (this.HnH != null) {
        paramVarArgs.f(3, this.HnH);
      }
      AppMethodBeat.o(249940);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.HnF) + 0;
      paramInt = i;
      if (this.HnG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.HnG);
      }
      i = paramInt;
      if (this.HnH != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.HnH);
      }
      AppMethodBeat.o(249940);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(249940);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ay localay = (ay)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(249940);
        return -1;
      case 1: 
        localay.HnF = locala.abFh.AN();
        AppMethodBeat.o(249940);
        return 0;
      case 2: 
        localay.HnG = locala.abFh.readString();
        AppMethodBeat.o(249940);
        return 0;
      }
      localay.HnH = locala.abFh.readString();
      AppMethodBeat.o(249940);
      return 0;
    }
    AppMethodBeat.o(249940);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ay
 * JD-Core Version:    0.7.0.1
 */