package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aza
  extends com.tencent.mm.bv.a
{
  public String qsu;
  public String xox;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28537);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.qsu != null) {
        paramVarArgs.e(1, this.qsu);
      }
      if (this.xox != null) {
        paramVarArgs.e(2, this.xox);
      }
      AppMethodBeat.o(28537);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qsu == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = e.a.a.b.b.a.f(1, this.qsu) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xox != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xox);
      }
      AppMethodBeat.o(28537);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28537);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        aza localaza = (aza)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28537);
          return -1;
        case 1: 
          localaza.qsu = locala.CLY.readString();
          AppMethodBeat.o(28537);
          return 0;
        }
        localaza.xox = locala.CLY.readString();
        AppMethodBeat.o(28537);
        return 0;
      }
      AppMethodBeat.o(28537);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aza
 * JD-Core Version:    0.7.0.1
 */