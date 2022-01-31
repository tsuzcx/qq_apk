package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bwh
  extends com.tencent.mm.bv.a
{
  public int jJu;
  public String xBY;
  public String xBZ;
  public String xec;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56962);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xec != null) {
        paramVarArgs.e(1, this.xec);
      }
      if (this.xBZ != null) {
        paramVarArgs.e(2, this.xBZ);
      }
      paramVarArgs.aO(3, this.jJu);
      if (this.xBY != null) {
        paramVarArgs.e(4, this.xBY);
      }
      AppMethodBeat.o(56962);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xec == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = e.a.a.b.b.a.f(1, this.xec) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xBZ != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xBZ);
      }
      i += e.a.a.b.b.a.bl(3, this.jJu);
      paramInt = i;
      if (this.xBY != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xBY);
      }
      AppMethodBeat.o(56962);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56962);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bwh localbwh = (bwh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56962);
          return -1;
        case 1: 
          localbwh.xec = locala.CLY.readString();
          AppMethodBeat.o(56962);
          return 0;
        case 2: 
          localbwh.xBZ = locala.CLY.readString();
          AppMethodBeat.o(56962);
          return 0;
        case 3: 
          localbwh.jJu = locala.CLY.sl();
          AppMethodBeat.o(56962);
          return 0;
        }
        localbwh.xBY = locala.CLY.readString();
        AppMethodBeat.o(56962);
        return 0;
      }
      AppMethodBeat.o(56962);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwh
 * JD-Core Version:    0.7.0.1
 */