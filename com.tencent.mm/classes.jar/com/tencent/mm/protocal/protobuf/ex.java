package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ex
  extends com.tencent.mm.bv.a
{
  public String npZ;
  public String nrU;
  public int wrd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80018);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.npZ != null) {
        paramVarArgs.e(1, this.npZ);
      }
      paramVarArgs.aO(2, this.wrd);
      if (this.nrU != null) {
        paramVarArgs.e(3, this.nrU);
      }
      AppMethodBeat.o(80018);
      return 0;
    }
    if (paramInt == 1) {
      if (this.npZ == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.npZ) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wrd);
      paramInt = i;
      if (this.nrU != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.nrU);
      }
      AppMethodBeat.o(80018);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80018);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ex localex = (ex)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(80018);
          return -1;
        case 1: 
          localex.npZ = locala.CLY.readString();
          AppMethodBeat.o(80018);
          return 0;
        case 2: 
          localex.wrd = locala.CLY.sl();
          AppMethodBeat.o(80018);
          return 0;
        }
        localex.nrU = locala.CLY.readString();
        AppMethodBeat.o(80018);
        return 0;
      }
      AppMethodBeat.o(80018);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ex
 * JD-Core Version:    0.7.0.1
 */