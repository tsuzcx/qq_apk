package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dci
  extends com.tencent.mm.bw.a
{
  public int HKP;
  public int HKQ;
  public int HKR;
  public int HKS;
  public int HKT;
  public int HKU;
  public int HKV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124550);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HKP);
      paramVarArgs.aS(2, this.HKQ);
      paramVarArgs.aS(3, this.HKR);
      paramVarArgs.aS(4, this.HKS);
      paramVarArgs.aS(5, this.HKT);
      paramVarArgs.aS(6, this.HKU);
      paramVarArgs.aS(7, this.HKV);
      AppMethodBeat.o(124550);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HKP);
      int i = f.a.a.b.b.a.bz(2, this.HKQ);
      int j = f.a.a.b.b.a.bz(3, this.HKR);
      int k = f.a.a.b.b.a.bz(4, this.HKS);
      int m = f.a.a.b.b.a.bz(5, this.HKT);
      int n = f.a.a.b.b.a.bz(6, this.HKU);
      int i1 = f.a.a.b.b.a.bz(7, this.HKV);
      AppMethodBeat.o(124550);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(124550);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dci localdci = (dci)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124550);
        return -1;
      case 1: 
        localdci.HKP = locala.OmT.zc();
        AppMethodBeat.o(124550);
        return 0;
      case 2: 
        localdci.HKQ = locala.OmT.zc();
        AppMethodBeat.o(124550);
        return 0;
      case 3: 
        localdci.HKR = locala.OmT.zc();
        AppMethodBeat.o(124550);
        return 0;
      case 4: 
        localdci.HKS = locala.OmT.zc();
        AppMethodBeat.o(124550);
        return 0;
      case 5: 
        localdci.HKT = locala.OmT.zc();
        AppMethodBeat.o(124550);
        return 0;
      case 6: 
        localdci.HKU = locala.OmT.zc();
        AppMethodBeat.o(124550);
        return 0;
      }
      localdci.HKV = locala.OmT.zc();
      AppMethodBeat.o(124550);
      return 0;
    }
    AppMethodBeat.o(124550);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dci
 * JD-Core Version:    0.7.0.1
 */