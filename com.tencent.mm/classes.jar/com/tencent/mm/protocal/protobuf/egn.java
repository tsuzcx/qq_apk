package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class egn
  extends com.tencent.mm.bx.a
{
  public b FGF;
  public String GNH;
  public String duW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123700);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GNH != null) {
        paramVarArgs.d(1, this.GNH);
      }
      if (this.FGF != null) {
        paramVarArgs.c(2, this.FGF);
      }
      if (this.duW != null) {
        paramVarArgs.d(3, this.duW);
      }
      AppMethodBeat.o(123700);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GNH == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.GNH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FGF != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.FGF);
      }
      i = paramInt;
      if (this.duW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.duW);
      }
      AppMethodBeat.o(123700);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123700);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        egn localegn = (egn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123700);
          return -1;
        case 1: 
          localegn.GNH = locala.NPN.readString();
          AppMethodBeat.o(123700);
          return 0;
        case 2: 
          localegn.FGF = locala.NPN.gxI();
          AppMethodBeat.o(123700);
          return 0;
        }
        localegn.duW = locala.NPN.readString();
        AppMethodBeat.o(123700);
        return 0;
      }
      AppMethodBeat.o(123700);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egn
 * JD-Core Version:    0.7.0.1
 */