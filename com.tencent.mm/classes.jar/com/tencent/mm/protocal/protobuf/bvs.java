package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvs
  extends com.tencent.mm.bv.a
{
  public String cAV;
  public String gfK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80171);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.gfK != null) {
        paramVarArgs.e(1, this.gfK);
      }
      if (this.cAV != null) {
        paramVarArgs.e(2, this.cAV);
      }
      AppMethodBeat.o(80171);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gfK == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.gfK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.cAV != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.cAV);
      }
      AppMethodBeat.o(80171);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80171);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bvs localbvs = (bvs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(80171);
          return -1;
        case 1: 
          localbvs.gfK = locala.CLY.readString();
          AppMethodBeat.o(80171);
          return 0;
        }
        localbvs.cAV = locala.CLY.readString();
        AppMethodBeat.o(80171);
        return 0;
      }
      AppMethodBeat.o(80171);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvs
 * JD-Core Version:    0.7.0.1
 */