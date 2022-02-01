package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvt
  extends com.tencent.mm.bx.a
{
  public String HnQ;
  public int HnR;
  public int HnS;
  public int guN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91673);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HnQ != null) {
        paramVarArgs.d(1, this.HnQ);
      }
      paramVarArgs.aS(2, this.guN);
      paramVarArgs.aS(3, this.HnR);
      paramVarArgs.aS(4, this.HnS);
      AppMethodBeat.o(91673);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HnQ == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = f.a.a.b.b.a.e(1, this.HnQ) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.guN);
      int j = f.a.a.b.b.a.bz(3, this.HnR);
      int k = f.a.a.b.b.a.bz(4, this.HnS);
      AppMethodBeat.o(91673);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91673);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cvt localcvt = (cvt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91673);
          return -1;
        case 1: 
          localcvt.HnQ = locala.NPN.readString();
          AppMethodBeat.o(91673);
          return 0;
        case 2: 
          localcvt.guN = locala.NPN.zc();
          AppMethodBeat.o(91673);
          return 0;
        case 3: 
          localcvt.HnR = locala.NPN.zc();
          AppMethodBeat.o(91673);
          return 0;
        }
        localcvt.HnS = locala.NPN.zc();
        AppMethodBeat.o(91673);
        return 0;
      }
      AppMethodBeat.o(91673);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvt
 * JD-Core Version:    0.7.0.1
 */