package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccl
  extends com.tencent.mm.bx.a
{
  public String FDt;
  public int GKD;
  public String GWg;
  public String GaD;
  public int Gfa;
  public String nDo;
  public String nEt;
  public int qdX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155445);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.qdX);
      if (this.nEt != null) {
        paramVarArgs.d(2, this.nEt);
      }
      if (this.FDt != null) {
        paramVarArgs.d(3, this.FDt);
      }
      if (this.GaD != null) {
        paramVarArgs.d(4, this.GaD);
      }
      if (this.nDo != null) {
        paramVarArgs.d(5, this.nDo);
      }
      paramVarArgs.aS(6, this.GKD);
      paramVarArgs.aS(7, this.Gfa);
      if (this.GWg != null) {
        paramVarArgs.d(8, this.GWg);
      }
      AppMethodBeat.o(155445);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.qdX) + 0;
      paramInt = i;
      if (this.nEt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nEt);
      }
      i = paramInt;
      if (this.FDt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FDt);
      }
      paramInt = i;
      if (this.GaD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GaD);
      }
      i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nDo);
      }
      i = i + f.a.a.b.b.a.bz(6, this.GKD) + f.a.a.b.b.a.bz(7, this.Gfa);
      paramInt = i;
      if (this.GWg != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GWg);
      }
      AppMethodBeat.o(155445);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(155445);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ccl localccl = (ccl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155445);
        return -1;
      case 1: 
        localccl.qdX = locala.NPN.zc();
        AppMethodBeat.o(155445);
        return 0;
      case 2: 
        localccl.nEt = locala.NPN.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 3: 
        localccl.FDt = locala.NPN.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 4: 
        localccl.GaD = locala.NPN.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 5: 
        localccl.nDo = locala.NPN.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 6: 
        localccl.GKD = locala.NPN.zc();
        AppMethodBeat.o(155445);
        return 0;
      case 7: 
        localccl.Gfa = locala.NPN.zc();
        AppMethodBeat.o(155445);
        return 0;
      }
      localccl.GWg = locala.NPN.readString();
      AppMethodBeat.o(155445);
      return 0;
    }
    AppMethodBeat.o(155445);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccl
 * JD-Core Version:    0.7.0.1
 */