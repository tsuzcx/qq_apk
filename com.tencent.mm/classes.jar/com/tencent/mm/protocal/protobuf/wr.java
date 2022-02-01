package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class wr
  extends com.tencent.mm.bx.a
{
  public String CAc;
  public int CYM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124477);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CAc != null) {
        paramVarArgs.d(1, this.CAc);
      }
      paramVarArgs.aR(2, this.CYM);
      AppMethodBeat.o(124477);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CAc == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.CAc) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.CYM);
      AppMethodBeat.o(124477);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124477);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        wr localwr = (wr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124477);
          return -1;
        case 1: 
          localwr.CAc = locala.KhF.readString();
          AppMethodBeat.o(124477);
          return 0;
        }
        localwr.CYM = locala.KhF.xS();
        AppMethodBeat.o(124477);
        return 0;
      }
      AppMethodBeat.o(124477);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wr
 * JD-Core Version:    0.7.0.1
 */