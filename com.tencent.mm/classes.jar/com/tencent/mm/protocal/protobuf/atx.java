package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class atx
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int FJk;
  public String FND;
  public String FNF;
  public String GKK;
  public int GKL;
  public int GKM;
  public int GKN;
  public String hFS;
  public String nIJ;
  public String uvT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149139);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FND != null) {
        paramVarArgs.d(1, this.FND);
      }
      paramVarArgs.aS(2, this.FJk);
      paramVarArgs.aS(3, this.CreateTime);
      if (this.FNF != null) {
        paramVarArgs.d(4, this.FNF);
      }
      if (this.uvT != null) {
        paramVarArgs.d(5, this.uvT);
      }
      if (this.GKK != null) {
        paramVarArgs.d(6, this.GKK);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(7, this.nIJ);
      }
      paramVarArgs.aS(8, this.GKL);
      if (this.hFS != null) {
        paramVarArgs.d(9, this.hFS);
      }
      paramVarArgs.aS(10, this.GKM);
      paramVarArgs.aS(11, this.GKN);
      AppMethodBeat.o(149139);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FND == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = f.a.a.b.b.a.e(1, this.FND) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FJk) + f.a.a.b.b.a.bz(3, this.CreateTime);
      paramInt = i;
      if (this.FNF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FNF);
      }
      i = paramInt;
      if (this.uvT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uvT);
      }
      paramInt = i;
      if (this.GKK != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GKK);
      }
      i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.nIJ);
      }
      i += f.a.a.b.b.a.bz(8, this.GKL);
      paramInt = i;
      if (this.hFS != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.hFS);
      }
      i = f.a.a.b.b.a.bz(10, this.GKM);
      int j = f.a.a.b.b.a.bz(11, this.GKN);
      AppMethodBeat.o(149139);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(149139);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        atx localatx = (atx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149139);
          return -1;
        case 1: 
          localatx.FND = locala.OmT.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 2: 
          localatx.FJk = locala.OmT.zc();
          AppMethodBeat.o(149139);
          return 0;
        case 3: 
          localatx.CreateTime = locala.OmT.zc();
          AppMethodBeat.o(149139);
          return 0;
        case 4: 
          localatx.FNF = locala.OmT.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 5: 
          localatx.uvT = locala.OmT.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 6: 
          localatx.GKK = locala.OmT.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 7: 
          localatx.nIJ = locala.OmT.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 8: 
          localatx.GKL = locala.OmT.zc();
          AppMethodBeat.o(149139);
          return 0;
        case 9: 
          localatx.hFS = locala.OmT.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 10: 
          localatx.GKM = locala.OmT.zc();
          AppMethodBeat.o(149139);
          return 0;
        }
        localatx.GKN = locala.OmT.zc();
        AppMethodBeat.o(149139);
        return 0;
      }
      AppMethodBeat.o(149139);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atx
 * JD-Core Version:    0.7.0.1
 */