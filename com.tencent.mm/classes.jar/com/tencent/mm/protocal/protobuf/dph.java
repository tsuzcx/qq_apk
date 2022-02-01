package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dph
  extends com.tencent.mm.bw.a
{
  public String MSC;
  public int MSD;
  public int MSE;
  public int gTn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91673);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MSC != null) {
        paramVarArgs.e(1, this.MSC);
      }
      paramVarArgs.aM(2, this.gTn);
      paramVarArgs.aM(3, this.MSD);
      paramVarArgs.aM(4, this.MSE);
      AppMethodBeat.o(91673);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MSC == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = g.a.a.b.b.a.f(1, this.MSC) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.gTn);
      int j = g.a.a.b.b.a.bu(3, this.MSD);
      int k = g.a.a.b.b.a.bu(4, this.MSE);
      AppMethodBeat.o(91673);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91673);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dph localdph = (dph)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91673);
          return -1;
        case 1: 
          localdph.MSC = locala.UbS.readString();
          AppMethodBeat.o(91673);
          return 0;
        case 2: 
          localdph.gTn = locala.UbS.zi();
          AppMethodBeat.o(91673);
          return 0;
        case 3: 
          localdph.MSD = locala.UbS.zi();
          AppMethodBeat.o(91673);
          return 0;
        }
        localdph.MSE = locala.UbS.zi();
        AppMethodBeat.o(91673);
        return 0;
      }
      AppMethodBeat.o(91673);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dph
 * JD-Core Version:    0.7.0.1
 */