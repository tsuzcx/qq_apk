package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bww
  extends com.tencent.mm.bv.a
{
  public int density;
  public String xJZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(2546);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xJZ != null) {
        paramVarArgs.e(1, this.xJZ);
      }
      paramVarArgs.aO(2, this.density);
      AppMethodBeat.o(2546);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xJZ == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = e.a.a.b.b.a.f(1, this.xJZ) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.density);
      AppMethodBeat.o(2546);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(2546);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bww localbww = (bww)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(2546);
          return -1;
        case 1: 
          localbww.xJZ = locala.CLY.readString();
          AppMethodBeat.o(2546);
          return 0;
        }
        localbww.density = locala.CLY.sl();
        AppMethodBeat.o(2546);
        return 0;
      }
      AppMethodBeat.o(2546);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bww
 * JD-Core Version:    0.7.0.1
 */