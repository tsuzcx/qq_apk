package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ayn
  extends com.tencent.mm.bv.a
{
  public String xoi;
  public String xoj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96271);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xoi != null) {
        paramVarArgs.e(1, this.xoi);
      }
      if (this.xoj != null) {
        paramVarArgs.e(2, this.xoj);
      }
      AppMethodBeat.o(96271);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xoi == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.xoi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xoj != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xoj);
      }
      AppMethodBeat.o(96271);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96271);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ayn localayn = (ayn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96271);
          return -1;
        case 1: 
          localayn.xoi = locala.CLY.readString();
          AppMethodBeat.o(96271);
          return 0;
        }
        localayn.xoj = locala.CLY.readString();
        AppMethodBeat.o(96271);
        return 0;
      }
      AppMethodBeat.o(96271);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayn
 * JD-Core Version:    0.7.0.1
 */