package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cac
  extends com.tencent.mm.bv.a
{
  public int action;
  public String className;
  public String dataPath;
  public String xLy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152461);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.className != null) {
        paramVarArgs.e(1, this.className);
      }
      if (this.dataPath != null) {
        paramVarArgs.e(2, this.dataPath);
      }
      if (this.xLy != null) {
        paramVarArgs.e(3, this.xLy);
      }
      paramVarArgs.aO(4, this.action);
      AppMethodBeat.o(152461);
      return 0;
    }
    if (paramInt == 1) {
      if (this.className == null) {
        break label378;
      }
    }
    label378:
    for (int i = e.a.a.b.b.a.f(1, this.className) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dataPath != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.dataPath);
      }
      i = paramInt;
      if (this.xLy != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xLy);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.action);
      AppMethodBeat.o(152461);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(152461);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cac localcac = (cac)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152461);
          return -1;
        case 1: 
          localcac.className = locala.CLY.readString();
          AppMethodBeat.o(152461);
          return 0;
        case 2: 
          localcac.dataPath = locala.CLY.readString();
          AppMethodBeat.o(152461);
          return 0;
        case 3: 
          localcac.xLy = locala.CLY.readString();
          AppMethodBeat.o(152461);
          return 0;
        }
        localcac.action = locala.CLY.sl();
        AppMethodBeat.o(152461);
        return 0;
      }
      AppMethodBeat.o(152461);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cac
 * JD-Core Version:    0.7.0.1
 */