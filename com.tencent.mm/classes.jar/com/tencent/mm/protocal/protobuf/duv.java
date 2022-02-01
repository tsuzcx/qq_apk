package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class duv
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b MWa;
  public com.tencent.mm.bw.b MlG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117924);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MWa == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Name");
        AppMethodBeat.o(117924);
        throw paramVarArgs;
      }
      if (this.MlG == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Value");
        AppMethodBeat.o(117924);
        throw paramVarArgs;
      }
      if (this.MWa != null) {
        paramVarArgs.c(1, this.MWa);
      }
      if (this.MlG != null) {
        paramVarArgs.c(2, this.MlG);
      }
      AppMethodBeat.o(117924);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MWa == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.b.b.a.b(1, this.MWa) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MlG != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.MlG);
      }
      AppMethodBeat.o(117924);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MWa == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Name");
          AppMethodBeat.o(117924);
          throw paramVarArgs;
        }
        if (this.MlG == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Value");
          AppMethodBeat.o(117924);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117924);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        duv localduv = (duv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117924);
          return -1;
        case 1: 
          localduv.MWa = locala.UbS.hPo();
          AppMethodBeat.o(117924);
          return 0;
        }
        localduv.MlG = locala.UbS.hPo();
        AppMethodBeat.o(117924);
        return 0;
      }
      AppMethodBeat.o(117924);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duv
 * JD-Core Version:    0.7.0.1
 */