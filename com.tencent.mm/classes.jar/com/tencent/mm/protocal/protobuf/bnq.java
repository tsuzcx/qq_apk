package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bnq
  extends com.tencent.mm.bx.a
{
  public b FCe;
  public b FCg;
  public int gsV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124514);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FCg != null) {
        paramVarArgs.c(1, this.FCg);
      }
      if (this.FCe != null) {
        paramVarArgs.c(2, this.FCe);
      }
      paramVarArgs.aS(3, this.gsV);
      AppMethodBeat.o(124514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FCg == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.b(1, this.FCg) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FCe != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.FCe);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.gsV);
      AppMethodBeat.o(124514);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124514);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bnq localbnq = (bnq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124514);
          return -1;
        case 1: 
          localbnq.FCg = locala.NPN.gxI();
          AppMethodBeat.o(124514);
          return 0;
        case 2: 
          localbnq.FCe = locala.NPN.gxI();
          AppMethodBeat.o(124514);
          return 0;
        }
        localbnq.gsV = locala.NPN.zc();
        AppMethodBeat.o(124514);
        return 0;
      }
      AppMethodBeat.o(124514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnq
 * JD-Core Version:    0.7.0.1
 */