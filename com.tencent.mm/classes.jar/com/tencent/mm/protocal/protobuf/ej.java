package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ej
  extends com.tencent.mm.bw.a
{
  public int FOE;
  public String FOF;
  public String ikm;
  public int nJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123539);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ikm != null) {
        paramVarArgs.d(1, this.ikm);
      }
      paramVarArgs.aS(2, this.nJA);
      paramVarArgs.aS(3, this.FOE);
      if (this.FOF != null) {
        paramVarArgs.d(4, this.FOF);
      }
      AppMethodBeat.o(123539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ikm == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = f.a.a.b.b.a.e(1, this.ikm) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nJA) + f.a.a.b.b.a.bz(3, this.FOE);
      paramInt = i;
      if (this.FOF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FOF);
      }
      AppMethodBeat.o(123539);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123539);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ej localej = (ej)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123539);
          return -1;
        case 1: 
          localej.ikm = locala.OmT.readString();
          AppMethodBeat.o(123539);
          return 0;
        case 2: 
          localej.nJA = locala.OmT.zc();
          AppMethodBeat.o(123539);
          return 0;
        case 3: 
          localej.FOE = locala.OmT.zc();
          AppMethodBeat.o(123539);
          return 0;
        }
        localej.FOF = locala.OmT.readString();
        AppMethodBeat.o(123539);
        return 0;
      }
      AppMethodBeat.o(123539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ej
 * JD-Core Version:    0.7.0.1
 */