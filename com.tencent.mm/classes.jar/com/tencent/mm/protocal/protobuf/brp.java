package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class brp
  extends com.tencent.mm.bx.a
{
  public String ZZR;
  public int hGE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260178);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZZR != null) {
        paramVarArgs.g(1, this.ZZR);
      }
      paramVarArgs.bS(2, this.hGE);
      AppMethodBeat.o(260178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZZR == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZZR) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.hGE);
      AppMethodBeat.o(260178);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260178);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        brp localbrp = (brp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260178);
          return -1;
        case 1: 
          localbrp.ZZR = locala.ajGk.readString();
          AppMethodBeat.o(260178);
          return 0;
        }
        localbrp.hGE = locala.ajGk.aar();
        AppMethodBeat.o(260178);
        return 0;
      }
      AppMethodBeat.o(260178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brp
 * JD-Core Version:    0.7.0.1
 */