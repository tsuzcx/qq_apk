package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cu
  extends com.tencent.mm.bw.a
{
  public String FND;
  public int FNE;
  public String FNF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149137);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FND != null) {
        paramVarArgs.d(1, this.FND);
      }
      paramVarArgs.aS(2, this.FNE);
      if (this.FNF != null) {
        paramVarArgs.d(3, this.FNF);
      }
      AppMethodBeat.o(149137);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FND == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.FND) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FNE);
      paramInt = i;
      if (this.FNF != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FNF);
      }
      AppMethodBeat.o(149137);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(149137);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cu localcu = (cu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149137);
          return -1;
        case 1: 
          localcu.FND = locala.OmT.readString();
          AppMethodBeat.o(149137);
          return 0;
        case 2: 
          localcu.FNE = locala.OmT.zc();
          AppMethodBeat.o(149137);
          return 0;
        }
        localcu.FNF = locala.OmT.readString();
        AppMethodBeat.o(149137);
        return 0;
      }
      AppMethodBeat.o(149137);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cu
 * JD-Core Version:    0.7.0.1
 */