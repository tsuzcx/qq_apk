package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eqv
  extends com.tencent.mm.bw.a
{
  public String KSu;
  public int KSv;
  public int KSw;
  public int KSx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212314);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KSu != null) {
        paramVarArgs.e(1, this.KSu);
      }
      paramVarArgs.aM(2, this.KSv);
      paramVarArgs.aM(3, this.KSw);
      paramVarArgs.aM(4, this.KSx);
      AppMethodBeat.o(212314);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KSu == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = g.a.a.b.b.a.f(1, this.KSu) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.KSv);
      int j = g.a.a.b.b.a.bu(3, this.KSw);
      int k = g.a.a.b.b.a.bu(4, this.KSx);
      AppMethodBeat.o(212314);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212314);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eqv localeqv = (eqv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212314);
          return -1;
        case 1: 
          localeqv.KSu = locala.UbS.readString();
          AppMethodBeat.o(212314);
          return 0;
        case 2: 
          localeqv.KSv = locala.UbS.zi();
          AppMethodBeat.o(212314);
          return 0;
        case 3: 
          localeqv.KSw = locala.UbS.zi();
          AppMethodBeat.o(212314);
          return 0;
        }
        localeqv.KSx = locala.UbS.zi();
        AppMethodBeat.o(212314);
        return 0;
      }
      AppMethodBeat.o(212314);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqv
 * JD-Core Version:    0.7.0.1
 */