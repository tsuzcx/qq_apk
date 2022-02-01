package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bd
  extends com.tencent.mm.bx.a
{
  public String ToG;
  public boolean ToL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289901);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ToG != null) {
        paramVarArgs.g(1, this.ToG);
      }
      paramVarArgs.di(2, this.ToL);
      AppMethodBeat.o(289901);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ToG == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.ToG) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.ko(2);
      AppMethodBeat.o(289901);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(289901);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bd localbd = (bd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(289901);
          return -1;
        case 1: 
          localbd.ToG = locala.ajGk.readString();
          AppMethodBeat.o(289901);
          return 0;
        }
        localbd.ToL = locala.ajGk.aai();
        AppMethodBeat.o(289901);
        return 0;
      }
      AppMethodBeat.o(289901);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.bd
 * JD-Core Version:    0.7.0.1
 */