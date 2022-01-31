package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class atr
  extends com.tencent.mm.bv.a
{
  public String nLv;
  public String wPi;
  public int wPj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102381);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wPi != null) {
        paramVarArgs.e(1, this.wPi);
      }
      paramVarArgs.aO(2, this.wPj);
      if (this.nLv != null) {
        paramVarArgs.e(3, this.nLv);
      }
      AppMethodBeat.o(102381);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wPi == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.wPi) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wPj);
      paramInt = i;
      if (this.nLv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.nLv);
      }
      AppMethodBeat.o(102381);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(102381);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        atr localatr = (atr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(102381);
          return -1;
        case 1: 
          localatr.wPi = locala.CLY.readString();
          AppMethodBeat.o(102381);
          return 0;
        case 2: 
          localatr.wPj = locala.CLY.sl();
          AppMethodBeat.o(102381);
          return 0;
        }
        localatr.nLv = locala.CLY.readString();
        AppMethodBeat.o(102381);
        return 0;
      }
      AppMethodBeat.o(102381);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atr
 * JD-Core Version:    0.7.0.1
 */