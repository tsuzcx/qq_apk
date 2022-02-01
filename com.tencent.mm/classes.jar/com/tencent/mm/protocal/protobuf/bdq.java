package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bdq
  extends com.tencent.mm.bw.a
{
  public String LNs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169064);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LNs != null) {
        paramVarArgs.e(1, this.LNs);
      }
      AppMethodBeat.o(169064);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LNs == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.f(1, this.LNs) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(169064);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169064);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bdq localbdq = (bdq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169064);
          return -1;
        }
        localbdq.LNs = locala.UbS.readString();
        AppMethodBeat.o(169064);
        return 0;
      }
      AppMethodBeat.o(169064);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdq
 * JD-Core Version:    0.7.0.1
 */