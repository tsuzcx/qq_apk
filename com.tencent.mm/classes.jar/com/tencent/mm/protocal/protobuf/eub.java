package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eub
  extends com.tencent.mm.bw.a
{
  public int HiN;
  public String Ngz;
  public int Nrv;
  public int gap;
  public int port;
  public int timeout;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115896);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ngz != null) {
        paramVarArgs.e(1, this.Ngz);
      }
      paramVarArgs.aM(2, this.port);
      paramVarArgs.aM(3, this.HiN);
      paramVarArgs.aM(4, this.gap);
      paramVarArgs.aM(5, this.timeout);
      paramVarArgs.aM(6, this.Nrv);
      AppMethodBeat.o(115896);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ngz == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = g.a.a.b.b.a.f(1, this.Ngz) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.port);
      int j = g.a.a.b.b.a.bu(3, this.HiN);
      int k = g.a.a.b.b.a.bu(4, this.gap);
      int m = g.a.a.b.b.a.bu(5, this.timeout);
      int n = g.a.a.b.b.a.bu(6, this.Nrv);
      AppMethodBeat.o(115896);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(115896);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eub localeub = (eub)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115896);
          return -1;
        case 1: 
          localeub.Ngz = locala.UbS.readString();
          AppMethodBeat.o(115896);
          return 0;
        case 2: 
          localeub.port = locala.UbS.zi();
          AppMethodBeat.o(115896);
          return 0;
        case 3: 
          localeub.HiN = locala.UbS.zi();
          AppMethodBeat.o(115896);
          return 0;
        case 4: 
          localeub.gap = locala.UbS.zi();
          AppMethodBeat.o(115896);
          return 0;
        case 5: 
          localeub.timeout = locala.UbS.zi();
          AppMethodBeat.o(115896);
          return 0;
        }
        localeub.Nrv = locala.UbS.zi();
        AppMethodBeat.o(115896);
        return 0;
      }
      AppMethodBeat.o(115896);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eub
 * JD-Core Version:    0.7.0.1
 */