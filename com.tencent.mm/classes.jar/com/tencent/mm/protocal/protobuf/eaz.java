package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eaz
  extends com.tencent.mm.bx.a
{
  public int LzK;
  public String Lzi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202523);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Lzi != null) {
        paramVarArgs.d(1, this.Lzi);
      }
      paramVarArgs.aR(2, this.LzK);
      AppMethodBeat.o(202523);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lzi == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.Lzi) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.LzK);
      AppMethodBeat.o(202523);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(202523);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eaz localeaz = (eaz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(202523);
          return -1;
        case 1: 
          localeaz.Lzi = locala.KhF.readString();
          AppMethodBeat.o(202523);
          return 0;
        }
        localeaz.LzK = locala.KhF.xS();
        AppMethodBeat.o(202523);
        return 0;
      }
      AppMethodBeat.o(202523);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaz
 * JD-Core Version:    0.7.0.1
 */