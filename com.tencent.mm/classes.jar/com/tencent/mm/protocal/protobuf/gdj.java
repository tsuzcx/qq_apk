package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gdj
  extends com.tencent.mm.bx.a
{
  public String acbl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32509);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acbl != null) {
        paramVarArgs.g(1, this.acbl);
      }
      AppMethodBeat.o(32509);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acbl == null) {
        break label216;
      }
    }
    label216:
    for (paramInt = i.a.a.b.b.a.h(1, this.acbl) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(32509);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32509);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gdj localgdj = (gdj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32509);
          return -1;
        }
        localgdj.acbl = locala.ajGk.readString();
        AppMethodBeat.o(32509);
        return 0;
      }
      AppMethodBeat.o(32509);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gdj
 * JD-Core Version:    0.7.0.1
 */