package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class ack
  extends com.tencent.mm.bx.a
{
  public b GbV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152526);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbV != null) {
        paramVarArgs.c(1, this.GbV);
      }
      AppMethodBeat.o(152526);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GbV == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.b(1, this.GbV) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(152526);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152526);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ack localack = (ack)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152526);
          return -1;
        }
        localack.GbV = locala.NPN.gxI();
        AppMethodBeat.o(152526);
        return 0;
      }
      AppMethodBeat.o(152526);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ack
 * JD-Core Version:    0.7.0.1
 */