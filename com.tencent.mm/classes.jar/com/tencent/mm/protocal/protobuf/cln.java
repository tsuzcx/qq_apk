package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cln
  extends com.tencent.mm.bw.a
{
  public String pqv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169922);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.pqv != null) {
        paramVarArgs.e(1, this.pqv);
      }
      AppMethodBeat.o(169922);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pqv == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.f(1, this.pqv) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(169922);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169922);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cln localcln = (cln)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169922);
          return -1;
        }
        localcln.pqv = locala.UbS.readString();
        AppMethodBeat.o(169922);
        return 0;
      }
      AppMethodBeat.o(169922);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cln
 * JD-Core Version:    0.7.0.1
 */