package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnk
  extends com.tencent.mm.bw.a
{
  public String GuT;
  public int GuU;
  public String uVx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147769);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GuT != null) {
        paramVarArgs.d(1, this.GuT);
      }
      paramVarArgs.aS(2, this.GuU);
      if (this.uVx != null) {
        paramVarArgs.d(3, this.uVx);
      }
      AppMethodBeat.o(147769);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GuT == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.GuT) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GuU);
      paramInt = i;
      if (this.uVx != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.uVx);
      }
      AppMethodBeat.o(147769);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(147769);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bnk localbnk = (bnk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147769);
          return -1;
        case 1: 
          localbnk.GuT = locala.OmT.readString();
          AppMethodBeat.o(147769);
          return 0;
        case 2: 
          localbnk.GuU = locala.OmT.zc();
          AppMethodBeat.o(147769);
          return 0;
        }
        localbnk.uVx = locala.OmT.readString();
        AppMethodBeat.o(147769);
        return 0;
      }
      AppMethodBeat.o(147769);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnk
 * JD-Core Version:    0.7.0.1
 */