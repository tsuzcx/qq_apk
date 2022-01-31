package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cl
  extends com.tencent.mm.bv.a
{
  public String woM;
  public int woN;
  public String woO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51018);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.woM != null) {
        paramVarArgs.e(1, this.woM);
      }
      paramVarArgs.aO(2, this.woN);
      if (this.woO != null) {
        paramVarArgs.e(3, this.woO);
      }
      AppMethodBeat.o(51018);
      return 0;
    }
    if (paramInt == 1) {
      if (this.woM == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.woM) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.woN);
      paramInt = i;
      if (this.woO != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.woO);
      }
      AppMethodBeat.o(51018);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(51018);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cl localcl = (cl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(51018);
          return -1;
        case 1: 
          localcl.woM = locala.CLY.readString();
          AppMethodBeat.o(51018);
          return 0;
        case 2: 
          localcl.woN = locala.CLY.sl();
          AppMethodBeat.o(51018);
          return 0;
        }
        localcl.woO = locala.CLY.readString();
        AppMethodBeat.o(51018);
        return 0;
      }
      AppMethodBeat.o(51018);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cl
 * JD-Core Version:    0.7.0.1
 */