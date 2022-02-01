package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ado
  extends com.tencent.mm.bw.a
{
  public String pLq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117863);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.pLq != null) {
        paramVarArgs.e(4, this.pLq);
      }
      AppMethodBeat.o(117863);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pLq == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.f(4, this.pLq) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(117863);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117863);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ado localado = (ado)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117863);
          return -1;
        }
        localado.pLq = locala.UbS.readString();
        AppMethodBeat.o(117863);
        return 0;
      }
      AppMethodBeat.o(117863);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ado
 * JD-Core Version:    0.7.0.1
 */