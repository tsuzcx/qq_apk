package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bjj
  extends com.tencent.mm.bv.a
{
  public String cHn;
  public String knW;
  public int xxP;
  public int xxQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89113);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cHn != null) {
        paramVarArgs.e(1, this.cHn);
      }
      if (this.knW != null) {
        paramVarArgs.e(2, this.knW);
      }
      paramVarArgs.aO(3, this.xxP);
      paramVarArgs.aO(4, this.xxQ);
      AppMethodBeat.o(89113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cHn == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = e.a.a.b.b.a.f(1, this.cHn) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.knW != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.knW);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.xxP);
      int j = e.a.a.b.b.a.bl(4, this.xxQ);
      AppMethodBeat.o(89113);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89113);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bjj localbjj = (bjj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(89113);
          return -1;
        case 1: 
          localbjj.cHn = locala.CLY.readString();
          AppMethodBeat.o(89113);
          return 0;
        case 2: 
          localbjj.knW = locala.CLY.readString();
          AppMethodBeat.o(89113);
          return 0;
        case 3: 
          localbjj.xxP = locala.CLY.sl();
          AppMethodBeat.o(89113);
          return 0;
        }
        localbjj.xxQ = locala.CLY.sl();
        AppMethodBeat.o(89113);
        return 0;
      }
      AppMethodBeat.o(89113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjj
 * JD-Core Version:    0.7.0.1
 */