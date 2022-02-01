package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eja
  extends com.tencent.mm.bw.a
{
  public String HeF;
  public int Hew;
  public String Imk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123706);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HeF != null) {
        paramVarArgs.d(1, this.HeF);
      }
      paramVarArgs.aS(2, this.Hew);
      if (this.Imk != null) {
        paramVarArgs.d(3, this.Imk);
      }
      AppMethodBeat.o(123706);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HeF == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.HeF) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hew);
      paramInt = i;
      if (this.Imk != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Imk);
      }
      AppMethodBeat.o(123706);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123706);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eja localeja = (eja)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123706);
          return -1;
        case 1: 
          localeja.HeF = locala.OmT.readString();
          AppMethodBeat.o(123706);
          return 0;
        case 2: 
          localeja.Hew = locala.OmT.zc();
          AppMethodBeat.o(123706);
          return 0;
        }
        localeja.Imk = locala.OmT.readString();
        AppMethodBeat.o(123706);
        return 0;
      }
      AppMethodBeat.o(123706);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eja
 * JD-Core Version:    0.7.0.1
 */