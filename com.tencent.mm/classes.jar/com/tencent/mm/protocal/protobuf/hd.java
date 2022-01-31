package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hd
  extends com.tencent.mm.bv.a
{
  public String nLq;
  public String poq;
  public String ppo;
  public String wtS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56709);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wtS != null) {
        paramVarArgs.e(1, this.wtS);
      }
      if (this.poq != null) {
        paramVarArgs.e(2, this.poq);
      }
      if (this.nLq != null) {
        paramVarArgs.e(3, this.nLq);
      }
      if (this.ppo != null) {
        paramVarArgs.e(4, this.ppo);
      }
      AppMethodBeat.o(56709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wtS == null) {
        break label394;
      }
    }
    label394:
    for (int i = e.a.a.b.b.a.f(1, this.wtS) + 0;; i = 0)
    {
      paramInt = i;
      if (this.poq != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.poq);
      }
      i = paramInt;
      if (this.nLq != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nLq);
      }
      paramInt = i;
      if (this.ppo != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ppo);
      }
      AppMethodBeat.o(56709);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56709);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        hd localhd = (hd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56709);
          return -1;
        case 1: 
          localhd.wtS = locala.CLY.readString();
          AppMethodBeat.o(56709);
          return 0;
        case 2: 
          localhd.poq = locala.CLY.readString();
          AppMethodBeat.o(56709);
          return 0;
        case 3: 
          localhd.nLq = locala.CLY.readString();
          AppMethodBeat.o(56709);
          return 0;
        }
        localhd.ppo = locala.CLY.readString();
        AppMethodBeat.o(56709);
        return 0;
      }
      AppMethodBeat.o(56709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hd
 * JD-Core Version:    0.7.0.1
 */