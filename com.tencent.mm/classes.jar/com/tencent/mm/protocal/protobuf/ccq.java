package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccq
  extends com.tencent.mm.bv.a
{
  public String xNe;
  public String xNf;
  public String xNg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28657);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xNe != null) {
        paramVarArgs.e(1, this.xNe);
      }
      if (this.xNf != null) {
        paramVarArgs.e(2, this.xNf);
      }
      if (this.xNg != null) {
        paramVarArgs.e(3, this.xNg);
      }
      AppMethodBeat.o(28657);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xNe == null) {
        break label343;
      }
    }
    label343:
    for (int i = e.a.a.b.b.a.f(1, this.xNe) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xNf != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xNf);
      }
      i = paramInt;
      if (this.xNg != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xNg);
      }
      AppMethodBeat.o(28657);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28657);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ccq localccq = (ccq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28657);
          return -1;
        case 1: 
          localccq.xNe = locala.CLY.readString();
          AppMethodBeat.o(28657);
          return 0;
        case 2: 
          localccq.xNf = locala.CLY.readString();
          AppMethodBeat.o(28657);
          return 0;
        }
        localccq.xNg = locala.CLY.readString();
        AppMethodBeat.o(28657);
        return 0;
      }
      AppMethodBeat.o(28657);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccq
 * JD-Core Version:    0.7.0.1
 */