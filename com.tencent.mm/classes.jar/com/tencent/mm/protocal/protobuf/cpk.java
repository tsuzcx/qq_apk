package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cpk
  extends com.tencent.mm.bv.a
{
  public String jJA;
  public String wOV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28693);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJA != null) {
        paramVarArgs.e(1, this.jJA);
      }
      if (this.wOV != null) {
        paramVarArgs.e(2, this.wOV);
      }
      AppMethodBeat.o(28693);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = e.a.a.b.b.a.f(1, this.jJA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wOV != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wOV);
      }
      AppMethodBeat.o(28693);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28693);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cpk localcpk = (cpk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28693);
          return -1;
        case 1: 
          localcpk.jJA = locala.CLY.readString();
          AppMethodBeat.o(28693);
          return 0;
        }
        localcpk.wOV = locala.CLY.readString();
        AppMethodBeat.o(28693);
        return 0;
      }
      AppMethodBeat.o(28693);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpk
 * JD-Core Version:    0.7.0.1
 */