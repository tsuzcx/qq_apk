package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fwc
  extends com.tencent.mm.bx.a
{
  public String aaIK;
  public int abUe;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82486);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaIK != null) {
        paramVarArgs.g(1, this.aaIK);
      }
      paramVarArgs.bS(2, this.state);
      paramVarArgs.bS(3, this.abUe);
      AppMethodBeat.o(82486);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaIK == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaIK) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.state);
      int j = i.a.a.b.b.a.cJ(3, this.abUe);
      AppMethodBeat.o(82486);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82486);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fwc localfwc = (fwc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82486);
          return -1;
        case 1: 
          localfwc.aaIK = locala.ajGk.readString();
          AppMethodBeat.o(82486);
          return 0;
        case 2: 
          localfwc.state = locala.ajGk.aar();
          AppMethodBeat.o(82486);
          return 0;
        }
        localfwc.abUe = locala.ajGk.aar();
        AppMethodBeat.o(82486);
        return 0;
      }
      AppMethodBeat.o(82486);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fwc
 * JD-Core Version:    0.7.0.1
 */