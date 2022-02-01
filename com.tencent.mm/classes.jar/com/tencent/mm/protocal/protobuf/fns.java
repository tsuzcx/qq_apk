package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fns
  extends com.tencent.mm.bx.a
{
  public String AtM = "";
  public int cHb = 0;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122553);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.AtM != null) {
        paramVarArgs.g(1, this.AtM);
      }
      paramVarArgs.bS(2, this.cHb);
      paramVarArgs.bv(3, this.timestamp);
      AppMethodBeat.o(122553);
      return 0;
    }
    if (paramInt == 1) {
      if (this.AtM == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.AtM) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.cHb);
      int j = i.a.a.b.b.a.q(3, this.timestamp);
      AppMethodBeat.o(122553);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122553);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fns localfns = (fns)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122553);
          return -1;
        case 1: 
          localfns.AtM = locala.ajGk.readString();
          AppMethodBeat.o(122553);
          return 0;
        case 2: 
          localfns.cHb = locala.ajGk.aar();
          AppMethodBeat.o(122553);
          return 0;
        }
        localfns.timestamp = locala.ajGk.aaw();
        AppMethodBeat.o(122553);
        return 0;
      }
      AppMethodBeat.o(122553);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fns
 * JD-Core Version:    0.7.0.1
 */