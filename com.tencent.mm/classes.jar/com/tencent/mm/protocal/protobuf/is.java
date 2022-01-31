package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class is
  extends com.tencent.mm.bv.a
{
  public String wuT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10154);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wuT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Mac");
        AppMethodBeat.o(10154);
        throw paramVarArgs;
      }
      if (this.wuT != null) {
        paramVarArgs.e(1, this.wuT);
      }
      AppMethodBeat.o(10154);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wuT == null) {
        break label268;
      }
    }
    label268:
    for (paramInt = e.a.a.b.b.a.f(1, this.wuT) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(10154);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wuT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Mac");
          AppMethodBeat.o(10154);
          throw paramVarArgs;
        }
        AppMethodBeat.o(10154);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        is localis = (is)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(10154);
          return -1;
        }
        localis.wuT = locala.CLY.readString();
        AppMethodBeat.o(10154);
        return 0;
      }
      AppMethodBeat.o(10154);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.is
 * JD-Core Version:    0.7.0.1
 */