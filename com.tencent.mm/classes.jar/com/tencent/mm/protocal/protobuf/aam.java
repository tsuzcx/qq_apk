package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aam
  extends com.tencent.mm.bw.a
{
  public String FQc;
  public int FQe;
  public int FZN;
  public int GrJ;
  public String GrK;
  public int GrL;
  public int GrM;
  public int GrN;
  public int GrO;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103206);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.d(1, this.content);
      }
      if (this.FQc != null) {
        paramVarArgs.d(3, this.FQc);
      }
      paramVarArgs.aS(4, this.FZN);
      paramVarArgs.aS(5, this.FQe);
      paramVarArgs.aS(6, this.GrJ);
      if (this.GrK != null) {
        paramVarArgs.d(7, this.GrK);
      }
      paramVarArgs.aS(8, this.GrL);
      paramVarArgs.aS(9, this.GrM);
      paramVarArgs.aS(10, this.GrN);
      paramVarArgs.aS(11, this.GrO);
      AppMethodBeat.o(103206);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = f.a.a.b.b.a.e(1, this.content) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FQc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FQc);
      }
      i = i + f.a.a.b.b.a.bz(4, this.FZN) + f.a.a.b.b.a.bz(5, this.FQe) + f.a.a.b.b.a.bz(6, this.GrJ);
      paramInt = i;
      if (this.GrK != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GrK);
      }
      i = f.a.a.b.b.a.bz(8, this.GrL);
      int j = f.a.a.b.b.a.bz(9, this.GrM);
      int k = f.a.a.b.b.a.bz(10, this.GrN);
      int m = f.a.a.b.b.a.bz(11, this.GrO);
      AppMethodBeat.o(103206);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(103206);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aam localaam = (aam)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 2: 
        default: 
          AppMethodBeat.o(103206);
          return -1;
        case 1: 
          localaam.content = locala.OmT.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 3: 
          localaam.FQc = locala.OmT.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 4: 
          localaam.FZN = locala.OmT.zc();
          AppMethodBeat.o(103206);
          return 0;
        case 5: 
          localaam.FQe = locala.OmT.zc();
          AppMethodBeat.o(103206);
          return 0;
        case 6: 
          localaam.GrJ = locala.OmT.zc();
          AppMethodBeat.o(103206);
          return 0;
        case 7: 
          localaam.GrK = locala.OmT.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 8: 
          localaam.GrL = locala.OmT.zc();
          AppMethodBeat.o(103206);
          return 0;
        case 9: 
          localaam.GrM = locala.OmT.zc();
          AppMethodBeat.o(103206);
          return 0;
        case 10: 
          localaam.GrN = locala.OmT.zc();
          AppMethodBeat.o(103206);
          return 0;
        }
        localaam.GrO = locala.OmT.zc();
        AppMethodBeat.o(103206);
        return 0;
      }
      AppMethodBeat.o(103206);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aam
 * JD-Core Version:    0.7.0.1
 */