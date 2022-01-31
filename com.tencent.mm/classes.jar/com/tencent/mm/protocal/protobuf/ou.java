package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ou
  extends com.tencent.mm.bv.a
{
  public String uaL;
  public String ugl;
  public int urD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89035);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ugl != null) {
        paramVarArgs.e(1, this.ugl);
      }
      if (this.uaL != null) {
        paramVarArgs.e(2, this.uaL);
      }
      paramVarArgs.aO(3, this.urD);
      AppMethodBeat.o(89035);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ugl == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.ugl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uaL != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.uaL);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.urD);
      AppMethodBeat.o(89035);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89035);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ou localou = (ou)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(89035);
          return -1;
        case 1: 
          localou.ugl = locala.CLY.readString();
          AppMethodBeat.o(89035);
          return 0;
        case 2: 
          localou.uaL = locala.CLY.readString();
          AppMethodBeat.o(89035);
          return 0;
        }
        localou.urD = locala.CLY.sl();
        AppMethodBeat.o(89035);
        return 0;
      }
      AppMethodBeat.o(89035);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ou
 * JD-Core Version:    0.7.0.1
 */