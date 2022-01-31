package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ado
  extends com.tencent.mm.bv.a
{
  public int jJS;
  public String wJF;
  public int wJL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51425);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wJF != null) {
        paramVarArgs.e(1, this.wJF);
      }
      paramVarArgs.aO(2, this.wJL);
      paramVarArgs.aO(3, this.jJS);
      AppMethodBeat.o(51425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wJF == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = e.a.a.b.b.a.f(1, this.wJF) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.wJL);
      int j = e.a.a.b.b.a.bl(3, this.jJS);
      AppMethodBeat.o(51425);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(51425);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ado localado = (ado)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(51425);
          return -1;
        case 1: 
          localado.wJF = locala.CLY.readString();
          AppMethodBeat.o(51425);
          return 0;
        case 2: 
          localado.wJL = locala.CLY.sl();
          AppMethodBeat.o(51425);
          return 0;
        }
        localado.jJS = locala.CLY.sl();
        AppMethodBeat.o(51425);
        return 0;
      }
      AppMethodBeat.o(51425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ado
 * JD-Core Version:    0.7.0.1
 */