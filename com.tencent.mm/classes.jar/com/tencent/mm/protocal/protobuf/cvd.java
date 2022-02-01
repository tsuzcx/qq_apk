package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvd
  extends com.tencent.mm.bw.a
{
  public int FileSize;
  public int KXP;
  public int Llx;
  public int MAA;
  public int MAB;
  public String MAC;
  public int MAD;
  public String MAE;
  public String xuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32360);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xuz != null) {
        paramVarArgs.e(1, this.xuz);
      }
      paramVarArgs.aM(2, this.MAA);
      paramVarArgs.aM(3, this.MAB);
      paramVarArgs.aM(4, this.KXP);
      if (this.MAC != null) {
        paramVarArgs.e(5, this.MAC);
      }
      paramVarArgs.aM(6, this.FileSize);
      paramVarArgs.aM(7, this.MAD);
      paramVarArgs.aM(8, this.Llx);
      if (this.MAE != null) {
        paramVarArgs.e(9, this.MAE);
      }
      AppMethodBeat.o(32360);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xuz == null) {
        break label613;
      }
    }
    label613:
    for (paramInt = g.a.a.b.b.a.f(1, this.xuz) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MAA) + g.a.a.b.b.a.bu(3, this.MAB) + g.a.a.b.b.a.bu(4, this.KXP);
      paramInt = i;
      if (this.MAC != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MAC);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.FileSize) + g.a.a.b.b.a.bu(7, this.MAD) + g.a.a.b.b.a.bu(8, this.Llx);
      paramInt = i;
      if (this.MAE != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MAE);
      }
      AppMethodBeat.o(32360);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32360);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cvd localcvd = (cvd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32360);
          return -1;
        case 1: 
          localcvd.xuz = locala.UbS.readString();
          AppMethodBeat.o(32360);
          return 0;
        case 2: 
          localcvd.MAA = locala.UbS.zi();
          AppMethodBeat.o(32360);
          return 0;
        case 3: 
          localcvd.MAB = locala.UbS.zi();
          AppMethodBeat.o(32360);
          return 0;
        case 4: 
          localcvd.KXP = locala.UbS.zi();
          AppMethodBeat.o(32360);
          return 0;
        case 5: 
          localcvd.MAC = locala.UbS.readString();
          AppMethodBeat.o(32360);
          return 0;
        case 6: 
          localcvd.FileSize = locala.UbS.zi();
          AppMethodBeat.o(32360);
          return 0;
        case 7: 
          localcvd.MAD = locala.UbS.zi();
          AppMethodBeat.o(32360);
          return 0;
        case 8: 
          localcvd.Llx = locala.UbS.zi();
          AppMethodBeat.o(32360);
          return 0;
        }
        localcvd.MAE = locala.UbS.readString();
        AppMethodBeat.o(32360);
        return 0;
      }
      AppMethodBeat.o(32360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvd
 * JD-Core Version:    0.7.0.1
 */