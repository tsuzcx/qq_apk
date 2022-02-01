package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ecu
  extends com.tencent.mm.bw.a
{
  public int Ndg;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152701);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      paramVarArgs.aM(2, this.Ndg);
      AppMethodBeat.o(152701);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = g.a.a.b.b.a.f(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.Ndg);
      AppMethodBeat.o(152701);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152701);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ecu localecu = (ecu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152701);
          return -1;
        case 1: 
          localecu.UserName = locala.UbS.readString();
          AppMethodBeat.o(152701);
          return 0;
        }
        localecu.Ndg = locala.UbS.zi();
        AppMethodBeat.o(152701);
        return 0;
      }
      AppMethodBeat.o(152701);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecu
 * JD-Core Version:    0.7.0.1
 */