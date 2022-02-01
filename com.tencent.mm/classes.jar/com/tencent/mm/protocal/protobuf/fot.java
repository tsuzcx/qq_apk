package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fot
  extends com.tencent.mm.cd.a
{
  public int SEl;
  public String TuC;
  public String UMQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123706);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TuC != null) {
        paramVarArgs.f(1, this.TuC);
      }
      paramVarArgs.aY(2, this.SEl);
      if (this.UMQ != null) {
        paramVarArgs.f(3, this.UMQ);
      }
      AppMethodBeat.o(123706);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TuC == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.TuC) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.SEl);
      paramInt = i;
      if (this.UMQ != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.UMQ);
      }
      AppMethodBeat.o(123706);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123706);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fot localfot = (fot)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123706);
          return -1;
        case 1: 
          localfot.TuC = locala.abFh.readString();
          AppMethodBeat.o(123706);
          return 0;
        case 2: 
          localfot.SEl = locala.abFh.AK();
          AppMethodBeat.o(123706);
          return 0;
        }
        localfot.UMQ = locala.abFh.readString();
        AppMethodBeat.o(123706);
        return 0;
      }
      AppMethodBeat.o(123706);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fot
 * JD-Core Version:    0.7.0.1
 */