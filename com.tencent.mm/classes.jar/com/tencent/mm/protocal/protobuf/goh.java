package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class goh
  extends com.tencent.mm.bx.a
{
  public String ProductID;
  public int YIq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104802);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ProductID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductID");
        AppMethodBeat.o(104802);
        throw paramVarArgs;
      }
      if (this.ProductID != null) {
        paramVarArgs.g(1, this.ProductID);
      }
      paramVarArgs.bS(2, this.YIq);
      AppMethodBeat.o(104802);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.ProductID) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.YIq);
      AppMethodBeat.o(104802);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        goh localgoh = (goh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104802);
          return -1;
        case 1: 
          localgoh.ProductID = locala.ajGk.readString();
          AppMethodBeat.o(104802);
          return 0;
        }
        localgoh.YIq = locala.ajGk.aar();
        AppMethodBeat.o(104802);
        return 0;
      }
      AppMethodBeat.o(104802);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.goh
 * JD-Core Version:    0.7.0.1
 */