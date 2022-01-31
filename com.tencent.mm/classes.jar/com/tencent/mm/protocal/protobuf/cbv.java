package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbv
  extends com.tencent.mm.bv.a
{
  public String cHn;
  public int kpN;
  public int wAo;
  public long xyE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89141);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cHn != null) {
        paramVarArgs.e(1, this.cHn);
      }
      paramVarArgs.aO(2, this.kpN);
      paramVarArgs.aO(3, this.wAo);
      paramVarArgs.am(4, this.xyE);
      AppMethodBeat.o(89141);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cHn == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = e.a.a.b.b.a.f(1, this.cHn) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.kpN);
      int j = e.a.a.b.b.a.bl(3, this.wAo);
      int k = e.a.a.b.b.a.p(4, this.xyE);
      AppMethodBeat.o(89141);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89141);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cbv localcbv = (cbv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(89141);
          return -1;
        case 1: 
          localcbv.cHn = locala.CLY.readString();
          AppMethodBeat.o(89141);
          return 0;
        case 2: 
          localcbv.kpN = locala.CLY.sl();
          AppMethodBeat.o(89141);
          return 0;
        case 3: 
          localcbv.wAo = locala.CLY.sl();
          AppMethodBeat.o(89141);
          return 0;
        }
        localcbv.xyE = locala.CLY.sm();
        AppMethodBeat.o(89141);
        return 0;
      }
      AppMethodBeat.o(89141);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbv
 * JD-Core Version:    0.7.0.1
 */