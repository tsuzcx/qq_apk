package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ag
  extends com.tencent.mm.bw.a
{
  public String FJC;
  public int FJD;
  public int FJE;
  public int FJF;
  public int FJG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143961);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FJC != null) {
        paramVarArgs.d(1, this.FJC);
      }
      paramVarArgs.aS(2, this.FJD);
      paramVarArgs.aS(3, this.FJE);
      paramVarArgs.aS(4, this.FJF);
      paramVarArgs.aS(5, this.FJG);
      AppMethodBeat.o(143961);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FJC == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = f.a.a.b.b.a.e(1, this.FJC) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.FJD);
      int j = f.a.a.b.b.a.bz(3, this.FJE);
      int k = f.a.a.b.b.a.bz(4, this.FJF);
      int m = f.a.a.b.b.a.bz(5, this.FJG);
      AppMethodBeat.o(143961);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(143961);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ag localag = (ag)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(143961);
          return -1;
        case 1: 
          localag.FJC = locala.OmT.readString();
          AppMethodBeat.o(143961);
          return 0;
        case 2: 
          localag.FJD = locala.OmT.zc();
          AppMethodBeat.o(143961);
          return 0;
        case 3: 
          localag.FJE = locala.OmT.zc();
          AppMethodBeat.o(143961);
          return 0;
        case 4: 
          localag.FJF = locala.OmT.zc();
          AppMethodBeat.o(143961);
          return 0;
        }
        localag.FJG = locala.OmT.zc();
        AppMethodBeat.o(143961);
        return 0;
      }
      AppMethodBeat.o(143961);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ag
 * JD-Core Version:    0.7.0.1
 */