package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class dyw
  extends com.tencent.mm.bw.a
{
  public String ProductID;
  public int xuA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104838);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ProductID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductID");
        AppMethodBeat.o(104838);
        throw paramVarArgs;
      }
      if (this.ProductID != null) {
        paramVarArgs.e(1, this.ProductID);
      }
      paramVarArgs.aM(2, this.xuA);
      AppMethodBeat.o(104838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.f(1, this.ProductID) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.xuA);
      AppMethodBeat.o(104838);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.ProductID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductID");
          AppMethodBeat.o(104838);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104838);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dyw localdyw = (dyw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104838);
          return -1;
        case 1: 
          localdyw.ProductID = locala.UbS.readString();
          AppMethodBeat.o(104838);
          return 0;
        }
        localdyw.xuA = locala.UbS.zi();
        AppMethodBeat.o(104838);
        return 0;
      }
      AppMethodBeat.o(104838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyw
 * JD-Core Version:    0.7.0.1
 */