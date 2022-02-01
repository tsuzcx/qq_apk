package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pf
  extends com.tencent.mm.bx.a
{
  public String hDa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124462);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hDa != null) {
        paramVarArgs.d(1, this.hDa);
      }
      AppMethodBeat.o(124462);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hDa == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.hDa) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(124462);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124462);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        pf localpf = (pf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124462);
          return -1;
        }
        localpf.hDa = locala.NPN.readString();
        AppMethodBeat.o(124462);
        return 0;
      }
      AppMethodBeat.o(124462);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pf
 * JD-Core Version:    0.7.0.1
 */