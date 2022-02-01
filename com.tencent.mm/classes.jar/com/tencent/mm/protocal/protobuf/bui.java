package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class bui
  extends com.tencent.mm.cd.a
{
  public String ProductID;
  public int RLe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104802);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ProductID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductID");
        AppMethodBeat.o(104802);
        throw paramVarArgs;
      }
      if (this.ProductID != null) {
        paramVarArgs.f(1, this.ProductID);
      }
      paramVarArgs.aY(2, this.RLe);
      AppMethodBeat.o(104802);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.ProductID) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.RLe);
      AppMethodBeat.o(104802);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.ProductID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductID");
          AppMethodBeat.o(104802);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104802);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bui localbui = (bui)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104802);
          return -1;
        case 1: 
          localbui.ProductID = locala.abFh.readString();
          AppMethodBeat.o(104802);
          return 0;
        }
        localbui.RLe = locala.abFh.AK();
        AppMethodBeat.o(104802);
        return 0;
      }
      AppMethodBeat.o(104802);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bui
 * JD-Core Version:    0.7.0.1
 */