package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class auh
  extends com.tencent.mm.bv.a
{
  public String jJD;
  public String wsq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10189);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wsq != null) {
        paramVarArgs.e(1, this.wsq);
      }
      if (this.jJD != null) {
        paramVarArgs.e(2, this.jJD);
      }
      AppMethodBeat.o(10189);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wsq == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = e.a.a.b.b.a.f(1, this.wsq) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jJD != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.jJD);
      }
      AppMethodBeat.o(10189);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(10189);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        auh localauh = (auh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(10189);
          return -1;
        case 1: 
          localauh.wsq = locala.CLY.readString();
          AppMethodBeat.o(10189);
          return 0;
        }
        localauh.jJD = locala.CLY.readString();
        AppMethodBeat.o(10189);
        return 0;
      }
      AppMethodBeat.o(10189);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auh
 * JD-Core Version:    0.7.0.1
 */