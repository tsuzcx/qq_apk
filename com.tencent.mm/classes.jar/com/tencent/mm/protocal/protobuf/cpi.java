package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cpi
  extends com.tencent.mm.bw.a
{
  public int Cyb;
  public String KGO;
  public int Mvf;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101826);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KGO != null) {
        paramVarArgs.e(1, this.KGO);
      }
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      paramVarArgs.aM(3, this.Mvf);
      paramVarArgs.aM(4, this.Cyb);
      AppMethodBeat.o(101826);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KGO == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = g.a.a.b.b.a.f(1, this.KGO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.UserName);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.Mvf);
      int j = g.a.a.b.b.a.bu(4, this.Cyb);
      AppMethodBeat.o(101826);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(101826);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cpi localcpi = (cpi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(101826);
          return -1;
        case 1: 
          localcpi.KGO = locala.UbS.readString();
          AppMethodBeat.o(101826);
          return 0;
        case 2: 
          localcpi.UserName = locala.UbS.readString();
          AppMethodBeat.o(101826);
          return 0;
        case 3: 
          localcpi.Mvf = locala.UbS.zi();
          AppMethodBeat.o(101826);
          return 0;
        }
        localcpi.Cyb = locala.UbS.zi();
        AppMethodBeat.o(101826);
        return 0;
      }
      AppMethodBeat.o(101826);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpi
 * JD-Core Version:    0.7.0.1
 */