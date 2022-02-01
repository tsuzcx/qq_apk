package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajt
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public String CNj;
  public String Suh;
  public int Sui;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104767);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CMP != null) {
        paramVarArgs.f(1, this.CMP);
      }
      if (this.CNj != null) {
        paramVarArgs.f(2, this.CNj);
      }
      if (this.Suh != null) {
        paramVarArgs.f(3, this.Suh);
      }
      paramVarArgs.aY(4, this.Sui);
      AppMethodBeat.o(104767);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CMP == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.g(1, this.CMP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CNj != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CNj);
      }
      i = paramInt;
      if (this.Suh != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Suh);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.Sui);
      AppMethodBeat.o(104767);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104767);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ajt localajt = (ajt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104767);
          return -1;
        case 1: 
          localajt.CMP = locala.abFh.readString();
          AppMethodBeat.o(104767);
          return 0;
        case 2: 
          localajt.CNj = locala.abFh.readString();
          AppMethodBeat.o(104767);
          return 0;
        case 3: 
          localajt.Suh = locala.abFh.readString();
          AppMethodBeat.o(104767);
          return 0;
        }
        localajt.Sui = locala.abFh.AK();
        AppMethodBeat.o(104767);
        return 0;
      }
      AppMethodBeat.o(104767);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajt
 * JD-Core Version:    0.7.0.1
 */