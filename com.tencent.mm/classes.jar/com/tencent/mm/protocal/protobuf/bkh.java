package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkh
  extends com.tencent.mm.bv.a
{
  public String action;
  public String className;
  public String dataPath;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152451);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.className != null) {
        paramVarArgs.e(1, this.className);
      }
      if (this.dataPath != null) {
        paramVarArgs.e(2, this.dataPath);
      }
      if (this.action != null) {
        paramVarArgs.e(3, this.action);
      }
      AppMethodBeat.o(152451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.className == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.className) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dataPath != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.dataPath);
      }
      i = paramInt;
      if (this.action != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.action);
      }
      AppMethodBeat.o(152451);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(152451);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bkh localbkh = (bkh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152451);
          return -1;
        case 1: 
          localbkh.className = locala.CLY.readString();
          AppMethodBeat.o(152451);
          return 0;
        case 2: 
          localbkh.dataPath = locala.CLY.readString();
          AppMethodBeat.o(152451);
          return 0;
        }
        localbkh.action = locala.CLY.readString();
        AppMethodBeat.o(152451);
        return 0;
      }
      AppMethodBeat.o(152451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkh
 * JD-Core Version:    0.7.0.1
 */