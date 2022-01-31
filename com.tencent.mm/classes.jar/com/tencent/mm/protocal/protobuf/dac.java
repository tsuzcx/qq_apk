package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class dac
  extends com.tencent.mm.bv.a
{
  public b wxN;
  public String xTl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96337);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xTl != null) {
        paramVarArgs.e(1, this.xTl);
      }
      if (this.wxN != null) {
        paramVarArgs.c(2, this.wxN);
      }
      AppMethodBeat.o(96337);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xTl == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.xTl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wxN != null) {
        i = paramInt + e.a.a.b.b.a.b(2, this.wxN);
      }
      AppMethodBeat.o(96337);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96337);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        dac localdac = (dac)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96337);
          return -1;
        case 1: 
          localdac.xTl = locala.CLY.readString();
          AppMethodBeat.o(96337);
          return 0;
        }
        localdac.wxN = locala.CLY.eqS();
        AppMethodBeat.o(96337);
        return 0;
      }
      AppMethodBeat.o(96337);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dac
 * JD-Core Version:    0.7.0.1
 */