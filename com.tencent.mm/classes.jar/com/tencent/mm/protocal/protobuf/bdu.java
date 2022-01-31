package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bdu
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String xtI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28552);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xtI != null) {
        paramVarArgs.e(1, this.xtI);
      }
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      AppMethodBeat.o(28552);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xtI == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = e.a.a.b.b.a.f(1, this.xtI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Desc != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.Desc);
      }
      AppMethodBeat.o(28552);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28552);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bdu localbdu = (bdu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28552);
          return -1;
        case 1: 
          localbdu.xtI = locala.CLY.readString();
          AppMethodBeat.o(28552);
          return 0;
        }
        localbdu.Desc = locala.CLY.readString();
        AppMethodBeat.o(28552);
        return 0;
      }
      AppMethodBeat.o(28552);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdu
 * JD-Core Version:    0.7.0.1
 */