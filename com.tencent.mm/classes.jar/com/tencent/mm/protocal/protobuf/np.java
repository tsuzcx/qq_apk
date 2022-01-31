package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class np
  extends com.tencent.mm.bv.a
{
  public String cEg;
  public String uKD;
  public String wCG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48786);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wCG != null) {
        paramVarArgs.e(1, this.wCG);
      }
      if (this.uKD != null) {
        paramVarArgs.e(2, this.uKD);
      }
      if (this.cEg != null) {
        paramVarArgs.e(3, this.cEg);
      }
      AppMethodBeat.o(48786);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wCG == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.wCG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uKD != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.uKD);
      }
      i = paramInt;
      if (this.cEg != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cEg);
      }
      AppMethodBeat.o(48786);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48786);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        np localnp = (np)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(48786);
          return -1;
        case 1: 
          localnp.wCG = locala.CLY.readString();
          AppMethodBeat.o(48786);
          return 0;
        case 2: 
          localnp.uKD = locala.CLY.readString();
          AppMethodBeat.o(48786);
          return 0;
        }
        localnp.cEg = locala.CLY.readString();
        AppMethodBeat.o(48786);
        return 0;
      }
      AppMethodBeat.o(48786);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.np
 * JD-Core Version:    0.7.0.1
 */