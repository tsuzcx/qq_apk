package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bno
  extends com.tencent.mm.bx.a
{
  public b FCe;
  public b FCg;
  public b GHO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32321);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FCg != null) {
        paramVarArgs.c(1, this.FCg);
      }
      if (this.FCe != null) {
        paramVarArgs.c(2, this.FCe);
      }
      if (this.GHO != null) {
        paramVarArgs.c(3, this.GHO);
      }
      AppMethodBeat.o(32321);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FCg == null) {
        break label343;
      }
    }
    label343:
    for (int i = f.a.a.b.b.a.b(1, this.FCg) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FCe != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.FCe);
      }
      i = paramInt;
      if (this.GHO != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.GHO);
      }
      AppMethodBeat.o(32321);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32321);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bno localbno = (bno)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32321);
          return -1;
        case 1: 
          localbno.FCg = locala.NPN.gxI();
          AppMethodBeat.o(32321);
          return 0;
        case 2: 
          localbno.FCe = locala.NPN.gxI();
          AppMethodBeat.o(32321);
          return 0;
        }
        localbno.GHO = locala.NPN.gxI();
        AppMethodBeat.o(32321);
        return 0;
      }
      AppMethodBeat.o(32321);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bno
 * JD-Core Version:    0.7.0.1
 */