package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aed
  extends com.tencent.mm.bw.a
{
  public int code;
  public String ykZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72468);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ykZ != null) {
        paramVarArgs.d(1, this.ykZ);
      }
      paramVarArgs.aS(2, this.code);
      AppMethodBeat.o(72468);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ykZ == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.ykZ) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.code);
      AppMethodBeat.o(72468);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72468);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aed localaed = (aed)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72468);
          return -1;
        case 1: 
          localaed.ykZ = locala.OmT.readString();
          AppMethodBeat.o(72468);
          return 0;
        }
        localaed.code = locala.OmT.zc();
        AppMethodBeat.o(72468);
        return 0;
      }
      AppMethodBeat.o(72468);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aed
 * JD-Core Version:    0.7.0.1
 */