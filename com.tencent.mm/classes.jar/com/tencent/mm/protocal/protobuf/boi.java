package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class boi
  extends com.tencent.mm.bw.a
{
  public b FUB;
  public b FUz;
  public int gvx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124514);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FUB != null) {
        paramVarArgs.c(1, this.FUB);
      }
      if (this.FUz != null) {
        paramVarArgs.c(2, this.FUz);
      }
      paramVarArgs.aS(3, this.gvx);
      AppMethodBeat.o(124514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FUB == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.b(1, this.FUB) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FUz != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.FUz);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.gvx);
      AppMethodBeat.o(124514);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124514);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        boi localboi = (boi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124514);
          return -1;
        case 1: 
          localboi.FUB = locala.OmT.gCk();
          AppMethodBeat.o(124514);
          return 0;
        case 2: 
          localboi.FUz = locala.OmT.gCk();
          AppMethodBeat.o(124514);
          return 0;
        }
        localboi.gvx = locala.OmT.zc();
        AppMethodBeat.o(124514);
        return 0;
      }
      AppMethodBeat.o(124514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boi
 * JD-Core Version:    0.7.0.1
 */