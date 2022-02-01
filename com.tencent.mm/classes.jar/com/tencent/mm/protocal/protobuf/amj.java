package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amj
  extends com.tencent.mm.bw.a
{
  public int GEE;
  public int GEF;
  public int GEG;
  public String country;
  public int eQV;
  public String eRf;
  public String eRg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168946);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.country != null) {
        paramVarArgs.d(1, this.country);
      }
      if (this.eRf != null) {
        paramVarArgs.d(2, this.eRf);
      }
      if (this.eRg != null) {
        paramVarArgs.d(3, this.eRg);
      }
      paramVarArgs.aS(4, this.eQV);
      paramVarArgs.aS(5, this.GEE);
      paramVarArgs.aS(6, this.GEF);
      paramVarArgs.aS(7, this.GEG);
      AppMethodBeat.o(168946);
      return 0;
    }
    if (paramInt == 1) {
      if (this.country == null) {
        break label522;
      }
    }
    label522:
    for (int i = f.a.a.b.b.a.e(1, this.country) + 0;; i = 0)
    {
      paramInt = i;
      if (this.eRf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.eRf);
      }
      i = paramInt;
      if (this.eRg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.eRg);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.eQV);
      int j = f.a.a.b.b.a.bz(5, this.GEE);
      int k = f.a.a.b.b.a.bz(6, this.GEF);
      int m = f.a.a.b.b.a.bz(7, this.GEG);
      AppMethodBeat.o(168946);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168946);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        amj localamj = (amj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(168946);
          return -1;
        case 1: 
          localamj.country = locala.OmT.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 2: 
          localamj.eRf = locala.OmT.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 3: 
          localamj.eRg = locala.OmT.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 4: 
          localamj.eQV = locala.OmT.zc();
          AppMethodBeat.o(168946);
          return 0;
        case 5: 
          localamj.GEE = locala.OmT.zc();
          AppMethodBeat.o(168946);
          return 0;
        case 6: 
          localamj.GEF = locala.OmT.zc();
          AppMethodBeat.o(168946);
          return 0;
        }
        localamj.GEG = locala.OmT.zc();
        AppMethodBeat.o(168946);
        return 0;
      }
      AppMethodBeat.o(168946);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amj
 * JD-Core Version:    0.7.0.1
 */