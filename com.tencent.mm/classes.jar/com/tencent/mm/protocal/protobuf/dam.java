package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dam
  extends com.tencent.mm.bv.a
{
  public int scene;
  public String ygS;
  public int ygT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96341);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ygS != null) {
        paramVarArgs.e(1, this.ygS);
      }
      paramVarArgs.aO(2, this.scene);
      paramVarArgs.aO(3, this.ygT);
      AppMethodBeat.o(96341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ygS == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = e.a.a.b.b.a.f(1, this.ygS) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.scene);
      int j = e.a.a.b.b.a.bl(3, this.ygT);
      AppMethodBeat.o(96341);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96341);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        dam localdam = (dam)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96341);
          return -1;
        case 1: 
          localdam.ygS = locala.CLY.readString();
          AppMethodBeat.o(96341);
          return 0;
        case 2: 
          localdam.scene = locala.CLY.sl();
          AppMethodBeat.o(96341);
          return 0;
        }
        localdam.ygT = locala.CLY.sl();
        AppMethodBeat.o(96341);
        return 0;
      }
      AppMethodBeat.o(96341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dam
 * JD-Core Version:    0.7.0.1
 */