package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dv
  extends com.tencent.mm.bv.a
{
  public String wpM;
  public String wpN;
  public String wpO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94508);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wpM != null) {
        paramVarArgs.e(1, this.wpM);
      }
      if (this.wpN != null) {
        paramVarArgs.e(2, this.wpN);
      }
      if (this.wpO != null) {
        paramVarArgs.e(3, this.wpO);
      }
      AppMethodBeat.o(94508);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wpM == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.wpM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wpN != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wpN);
      }
      i = paramInt;
      if (this.wpO != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wpO);
      }
      AppMethodBeat.o(94508);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94508);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        dv localdv = (dv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(94508);
          return -1;
        case 1: 
          localdv.wpM = locala.CLY.readString();
          AppMethodBeat.o(94508);
          return 0;
        case 2: 
          localdv.wpN = locala.CLY.readString();
          AppMethodBeat.o(94508);
          return 0;
        }
        localdv.wpO = locala.CLY.readString();
        AppMethodBeat.o(94508);
        return 0;
      }
      AppMethodBeat.o(94508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dv
 * JD-Core Version:    0.7.0.1
 */