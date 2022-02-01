package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class axj
  extends com.tencent.mm.cd.a
{
  public String SJW;
  public int SJX;
  public long SJY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230713);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SJW != null) {
        paramVarArgs.f(1, this.SJW);
      }
      paramVarArgs.aY(101, this.SJX);
      paramVarArgs.bm(102, this.SJY);
      AppMethodBeat.o(230713);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SJW == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.SJW) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(101, this.SJX);
      int j = g.a.a.b.b.a.p(102, this.SJY);
      AppMethodBeat.o(230713);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230713);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        axj localaxj = (axj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(230713);
          return -1;
        case 1: 
          localaxj.SJW = locala.abFh.readString();
          AppMethodBeat.o(230713);
          return 0;
        case 101: 
          localaxj.SJX = locala.abFh.AK();
          AppMethodBeat.o(230713);
          return 0;
        }
        localaxj.SJY = locala.abFh.AN();
        AppMethodBeat.o(230713);
        return 0;
      }
      AppMethodBeat.o(230713);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axj
 * JD-Core Version:    0.7.0.1
 */