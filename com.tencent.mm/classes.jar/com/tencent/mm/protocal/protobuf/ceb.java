package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ceb
  extends com.tencent.mm.bv.a
{
  public String crs;
  public String ojA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94577);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ojA != null) {
        paramVarArgs.e(1, this.ojA);
      }
      if (this.crs != null) {
        paramVarArgs.e(2, this.crs);
      }
      AppMethodBeat.o(94577);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ojA == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.ojA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.crs != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.crs);
      }
      AppMethodBeat.o(94577);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94577);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ceb localceb = (ceb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(94577);
          return -1;
        case 1: 
          localceb.ojA = locala.CLY.readString();
          AppMethodBeat.o(94577);
          return 0;
        }
        localceb.crs = locala.CLY.readString();
        AppMethodBeat.o(94577);
        return 0;
      }
      AppMethodBeat.o(94577);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceb
 * JD-Core Version:    0.7.0.1
 */