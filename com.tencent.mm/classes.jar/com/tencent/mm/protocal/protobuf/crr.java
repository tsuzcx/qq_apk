package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class crr
  extends com.tencent.mm.bv.a
{
  public int xCi;
  public String xpV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(135442);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xpV == null)
      {
        paramVarArgs = new b("Not all required fields were included: Ip");
        AppMethodBeat.o(135442);
        throw paramVarArgs;
      }
      if (this.xpV != null) {
        paramVarArgs.e(1, this.xpV);
      }
      paramVarArgs.aO(2, this.xCi);
      AppMethodBeat.o(135442);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xpV == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = e.a.a.b.b.a.f(1, this.xpV) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.xCi);
      AppMethodBeat.o(135442);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xpV == null)
        {
          paramVarArgs = new b("Not all required fields were included: Ip");
          AppMethodBeat.o(135442);
          throw paramVarArgs;
        }
        AppMethodBeat.o(135442);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        crr localcrr = (crr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(135442);
          return -1;
        case 1: 
          localcrr.xpV = locala.CLY.readString();
          AppMethodBeat.o(135442);
          return 0;
        }
        localcrr.xCi = locala.CLY.sl();
        AppMethodBeat.o(135442);
        return 0;
      }
      AppMethodBeat.o(135442);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crr
 * JD-Core Version:    0.7.0.1
 */