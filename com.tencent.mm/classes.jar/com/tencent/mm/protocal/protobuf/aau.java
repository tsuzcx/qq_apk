package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aau
  extends com.tencent.mm.bw.a
{
  public String KJV;
  public int Lmc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124477);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KJV != null) {
        paramVarArgs.e(1, this.KJV);
      }
      paramVarArgs.aM(2, this.Lmc);
      AppMethodBeat.o(124477);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KJV == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = g.a.a.b.b.a.f(1, this.KJV) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.Lmc);
      AppMethodBeat.o(124477);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124477);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aau localaau = (aau)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124477);
          return -1;
        case 1: 
          localaau.KJV = locala.UbS.readString();
          AppMethodBeat.o(124477);
          return 0;
        }
        localaau.Lmc = locala.UbS.zi();
        AppMethodBeat.o(124477);
        return 0;
      }
      AppMethodBeat.o(124477);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aau
 * JD-Core Version:    0.7.0.1
 */