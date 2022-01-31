package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class he
  extends com.tencent.mm.bv.a
{
  public String nLq;
  public String poq;
  public String qfY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145225);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nLq != null) {
        paramVarArgs.e(1, this.nLq);
      }
      if (this.qfY != null) {
        paramVarArgs.e(2, this.qfY);
      }
      if (this.poq != null) {
        paramVarArgs.e(3, this.poq);
      }
      AppMethodBeat.o(145225);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nLq == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.nLq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qfY != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.qfY);
      }
      i = paramInt;
      if (this.poq != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.poq);
      }
      AppMethodBeat.o(145225);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(145225);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        he localhe = (he)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(145225);
          return -1;
        case 1: 
          localhe.nLq = locala.CLY.readString();
          AppMethodBeat.o(145225);
          return 0;
        case 2: 
          localhe.qfY = locala.CLY.readString();
          AppMethodBeat.o(145225);
          return 0;
        }
        localhe.poq = locala.CLY.readString();
        AppMethodBeat.o(145225);
        return 0;
      }
      AppMethodBeat.o(145225);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.he
 * JD-Core Version:    0.7.0.1
 */