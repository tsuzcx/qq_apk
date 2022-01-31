package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class ada
  extends com.tencent.mm.bv.a
{
  public int bpY;
  public String smP;
  public String wVl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51416);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.smP == null)
      {
        paramVarArgs = new b("Not all required fields were included: tagName");
        AppMethodBeat.o(51416);
        throw paramVarArgs;
      }
      if (this.wVl == null)
      {
        paramVarArgs = new b("Not all required fields were included: tagPinYin");
        AppMethodBeat.o(51416);
        throw paramVarArgs;
      }
      if (this.smP != null) {
        paramVarArgs.e(1, this.smP);
      }
      if (this.wVl != null) {
        paramVarArgs.e(2, this.wVl);
      }
      paramVarArgs.aO(3, this.bpY);
      AppMethodBeat.o(51416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.smP == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = e.a.a.b.b.a.f(1, this.smP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wVl != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wVl);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.bpY);
      AppMethodBeat.o(51416);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.smP == null)
        {
          paramVarArgs = new b("Not all required fields were included: tagName");
          AppMethodBeat.o(51416);
          throw paramVarArgs;
        }
        if (this.wVl == null)
        {
          paramVarArgs = new b("Not all required fields were included: tagPinYin");
          AppMethodBeat.o(51416);
          throw paramVarArgs;
        }
        AppMethodBeat.o(51416);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ada localada = (ada)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(51416);
          return -1;
        case 1: 
          localada.smP = locala.CLY.readString();
          AppMethodBeat.o(51416);
          return 0;
        case 2: 
          localada.wVl = locala.CLY.readString();
          AppMethodBeat.o(51416);
          return 0;
        }
        localada.bpY = locala.CLY.sl();
        AppMethodBeat.o(51416);
        return 0;
      }
      AppMethodBeat.o(51416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ada
 * JD-Core Version:    0.7.0.1
 */