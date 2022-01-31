package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccn
  extends com.tencent.mm.bv.a
{
  public String username;
  public int wwX;
  public int xmQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114988);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      paramVarArgs.aO(2, this.xmQ);
      paramVarArgs.aO(3, this.wwX);
      AppMethodBeat.o(114988);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = e.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.xmQ);
      int j = e.a.a.b.b.a.bl(3, this.wwX);
      AppMethodBeat.o(114988);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(114988);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ccn localccn = (ccn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114988);
          return -1;
        case 1: 
          localccn.username = locala.CLY.readString();
          AppMethodBeat.o(114988);
          return 0;
        case 2: 
          localccn.xmQ = locala.CLY.sl();
          AppMethodBeat.o(114988);
          return 0;
        }
        localccn.wwX = locala.CLY.sl();
        AppMethodBeat.o(114988);
        return 0;
      }
      AppMethodBeat.o(114988);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccn
 * JD-Core Version:    0.7.0.1
 */