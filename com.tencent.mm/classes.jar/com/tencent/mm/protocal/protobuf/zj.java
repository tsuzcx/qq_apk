package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class zj
  extends com.tencent.mm.bv.a
{
  public String wxW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62525);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wxW == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(62525);
        throw paramVarArgs;
      }
      if (this.wxW != null) {
        paramVarArgs.e(1, this.wxW);
      }
      AppMethodBeat.o(62525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wxW == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = e.a.a.b.b.a.f(1, this.wxW) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(62525);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wxW == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(62525);
          throw paramVarArgs;
        }
        AppMethodBeat.o(62525);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        zj localzj = (zj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(62525);
          return -1;
        }
        localzj.wxW = locala.CLY.readString();
        AppMethodBeat.o(62525);
        return 0;
      }
      AppMethodBeat.o(62525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zj
 * JD-Core Version:    0.7.0.1
 */