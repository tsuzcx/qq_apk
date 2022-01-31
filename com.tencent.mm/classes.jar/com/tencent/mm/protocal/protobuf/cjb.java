package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjb
  extends com.tencent.mm.bv.a
{
  public String xTl;
  public int xTm;
  public int xTn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114990);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xTl != null) {
        paramVarArgs.e(1, this.xTl);
      }
      paramVarArgs.aO(2, this.xTm);
      paramVarArgs.aO(3, this.xTn);
      AppMethodBeat.o(114990);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xTl == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = e.a.a.b.b.a.f(1, this.xTl) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.xTm);
      int j = e.a.a.b.b.a.bl(3, this.xTn);
      AppMethodBeat.o(114990);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(114990);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cjb localcjb = (cjb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114990);
          return -1;
        case 1: 
          localcjb.xTl = locala.CLY.readString();
          AppMethodBeat.o(114990);
          return 0;
        case 2: 
          localcjb.xTm = locala.CLY.sl();
          AppMethodBeat.o(114990);
          return 0;
        }
        localcjb.xTn = locala.CLY.sl();
        AppMethodBeat.o(114990);
        return 0;
      }
      AppMethodBeat.o(114990);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjb
 * JD-Core Version:    0.7.0.1
 */