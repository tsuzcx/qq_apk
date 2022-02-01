package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dd
  extends com.tencent.mm.bw.a
{
  public String KHi;
  public int KHj;
  public String KHk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149137);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KHi != null) {
        paramVarArgs.e(1, this.KHi);
      }
      paramVarArgs.aM(2, this.KHj);
      if (this.KHk != null) {
        paramVarArgs.e(3, this.KHk);
      }
      AppMethodBeat.o(149137);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KHi == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.KHi) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KHj);
      paramInt = i;
      if (this.KHk != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KHk);
      }
      AppMethodBeat.o(149137);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(149137);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dd localdd = (dd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149137);
          return -1;
        case 1: 
          localdd.KHi = locala.UbS.readString();
          AppMethodBeat.o(149137);
          return 0;
        case 2: 
          localdd.KHj = locala.UbS.zi();
          AppMethodBeat.o(149137);
          return 0;
        }
        localdd.KHk = locala.UbS.readString();
        AppMethodBeat.o(149137);
        return 0;
      }
      AppMethodBeat.o(149137);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dd
 * JD-Core Version:    0.7.0.1
 */