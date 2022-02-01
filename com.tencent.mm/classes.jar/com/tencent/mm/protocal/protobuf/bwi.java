package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bwi
  extends com.tencent.mm.bw.a
{
  public String Hjm;
  public int end;
  public int start;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(213432);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hjm != null) {
        paramVarArgs.d(1, this.Hjm);
      }
      paramVarArgs.aS(2, this.start);
      paramVarArgs.aS(3, this.end);
      AppMethodBeat.o(213432);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hjm == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hjm) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.start);
      int j = f.a.a.b.b.a.bz(3, this.end);
      AppMethodBeat.o(213432);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(213432);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bwi localbwi = (bwi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(213432);
          return -1;
        case 1: 
          localbwi.Hjm = locala.OmT.readString();
          AppMethodBeat.o(213432);
          return 0;
        case 2: 
          localbwi.start = locala.OmT.zc();
          AppMethodBeat.o(213432);
          return 0;
        }
        localbwi.end = locala.OmT.zc();
        AppMethodBeat.o(213432);
        return 0;
      }
      AppMethodBeat.o(213432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwi
 * JD-Core Version:    0.7.0.1
 */