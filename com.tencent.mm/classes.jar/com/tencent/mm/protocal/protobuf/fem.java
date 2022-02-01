package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fem
  extends com.tencent.mm.cd.a
{
  public int NZB;
  public int UEr;
  public int UEs;
  public String Utd;
  public int port;
  public int timeout;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115896);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Utd != null) {
        paramVarArgs.f(1, this.Utd);
      }
      paramVarArgs.aY(2, this.port);
      paramVarArgs.aY(3, this.NZB);
      paramVarArgs.aY(4, this.UEr);
      paramVarArgs.aY(5, this.timeout);
      paramVarArgs.aY(6, this.UEs);
      AppMethodBeat.o(115896);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Utd == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = g.a.a.b.b.a.g(1, this.Utd) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.port);
      int j = g.a.a.b.b.a.bM(3, this.NZB);
      int k = g.a.a.b.b.a.bM(4, this.UEr);
      int m = g.a.a.b.b.a.bM(5, this.timeout);
      int n = g.a.a.b.b.a.bM(6, this.UEs);
      AppMethodBeat.o(115896);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(115896);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fem localfem = (fem)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115896);
          return -1;
        case 1: 
          localfem.Utd = locala.abFh.readString();
          AppMethodBeat.o(115896);
          return 0;
        case 2: 
          localfem.port = locala.abFh.AK();
          AppMethodBeat.o(115896);
          return 0;
        case 3: 
          localfem.NZB = locala.abFh.AK();
          AppMethodBeat.o(115896);
          return 0;
        case 4: 
          localfem.UEr = locala.abFh.AK();
          AppMethodBeat.o(115896);
          return 0;
        case 5: 
          localfem.timeout = locala.abFh.AK();
          AppMethodBeat.o(115896);
          return 0;
        }
        localfem.UEs = locala.abFh.AK();
        AppMethodBeat.o(115896);
        return 0;
      }
      AppMethodBeat.o(115896);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fem
 * JD-Core Version:    0.7.0.1
 */