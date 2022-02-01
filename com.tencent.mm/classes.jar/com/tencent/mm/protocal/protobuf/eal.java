package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eal
  extends com.tencent.mm.bx.a
{
  public int HNy;
  public String HpQ;
  public String jdl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32507);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HpQ != null) {
        paramVarArgs.d(1, this.HpQ);
      }
      if (this.jdl != null) {
        paramVarArgs.d(2, this.jdl);
      }
      paramVarArgs.aS(3, this.HNy);
      AppMethodBeat.o(32507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HpQ == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = f.a.a.b.b.a.e(1, this.HpQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jdl != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.jdl);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HNy);
      AppMethodBeat.o(32507);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32507);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eal localeal = (eal)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32507);
          return -1;
        case 1: 
          localeal.HpQ = locala.NPN.readString();
          AppMethodBeat.o(32507);
          return 0;
        case 2: 
          localeal.jdl = locala.NPN.readString();
          AppMethodBeat.o(32507);
          return 0;
        }
        localeal.HNy = locala.NPN.zc();
        AppMethodBeat.o(32507);
        return 0;
      }
      AppMethodBeat.o(32507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eal
 * JD-Core Version:    0.7.0.1
 */