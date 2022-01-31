package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckk
  extends com.tencent.mm.bv.a
{
  public String wXS;
  public boolean xUq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14758);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wXS != null) {
        paramVarArgs.e(1, this.wXS);
      }
      paramVarArgs.aS(2, this.xUq);
      AppMethodBeat.o(14758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wXS == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = e.a.a.b.b.a.f(1, this.wXS) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.eW(2);
      AppMethodBeat.o(14758);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(14758);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ckk localckk = (ckk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(14758);
          return -1;
        case 1: 
          localckk.wXS = locala.CLY.readString();
          AppMethodBeat.o(14758);
          return 0;
        }
        localckk.xUq = locala.CLY.emu();
        AppMethodBeat.o(14758);
        return 0;
      }
      AppMethodBeat.o(14758);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckk
 * JD-Core Version:    0.7.0.1
 */