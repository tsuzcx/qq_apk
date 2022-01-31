package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class hn
  extends com.tencent.mm.bv.a
{
  public int cCy;
  public String eAx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48779);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.eAx == null)
      {
        paramVarArgs = new b("Not all required fields were included: uuid");
        AppMethodBeat.o(48779);
        throw paramVarArgs;
      }
      if (this.eAx != null) {
        paramVarArgs.e(1, this.eAx);
      }
      paramVarArgs.aO(2, this.cCy);
      AppMethodBeat.o(48779);
      return 0;
    }
    if (paramInt == 1) {
      if (this.eAx == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = e.a.a.b.b.a.f(1, this.eAx) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.cCy);
      AppMethodBeat.o(48779);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.eAx == null)
        {
          paramVarArgs = new b("Not all required fields were included: uuid");
          AppMethodBeat.o(48779);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48779);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        hn localhn = (hn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(48779);
          return -1;
        case 1: 
          localhn.eAx = locala.CLY.readString();
          AppMethodBeat.o(48779);
          return 0;
        }
        localhn.cCy = locala.CLY.sl();
        AppMethodBeat.o(48779);
        return 0;
      }
      AppMethodBeat.o(48779);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hn
 * JD-Core Version:    0.7.0.1
 */