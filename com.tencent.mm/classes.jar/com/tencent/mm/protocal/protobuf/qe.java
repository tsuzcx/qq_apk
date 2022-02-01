package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qe
  extends com.tencent.mm.bw.a
{
  public String iAc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124462);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.iAc != null) {
        paramVarArgs.e(1, this.iAc);
      }
      AppMethodBeat.o(124462);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iAc == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.f(1, this.iAc) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(124462);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124462);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        qe localqe = (qe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124462);
          return -1;
        }
        localqe.iAc = locala.UbS.readString();
        AppMethodBeat.o(124462);
        return 0;
      }
      AppMethodBeat.o(124462);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qe
 * JD-Core Version:    0.7.0.1
 */