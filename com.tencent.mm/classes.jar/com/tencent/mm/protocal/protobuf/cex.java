package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cex
  extends com.tencent.mm.bw.a
{
  public int Gdy;
  public int GqB;
  public int HrH;
  public String HrI;
  public String HrJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32361);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gdy);
      if (this.HrJ != null) {
        paramVarArgs.d(3, this.HrJ);
      }
      paramVarArgs.aS(4, this.HrH);
      paramVarArgs.aS(5, this.GqB);
      if (this.HrI != null) {
        paramVarArgs.d(6, this.HrI);
      }
      AppMethodBeat.o(32361);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Gdy) + 0;
      paramInt = i;
      if (this.HrJ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HrJ);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.HrH) + f.a.a.b.b.a.bz(5, this.GqB);
      paramInt = i;
      if (this.HrI != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HrI);
      }
      AppMethodBeat.o(32361);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32361);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cex localcex = (cex)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 2: 
      default: 
        AppMethodBeat.o(32361);
        return -1;
      case 1: 
        localcex.Gdy = locala.OmT.zc();
        AppMethodBeat.o(32361);
        return 0;
      case 3: 
        localcex.HrJ = locala.OmT.readString();
        AppMethodBeat.o(32361);
        return 0;
      case 4: 
        localcex.HrH = locala.OmT.zc();
        AppMethodBeat.o(32361);
        return 0;
      case 5: 
        localcex.GqB = locala.OmT.zc();
        AppMethodBeat.o(32361);
        return 0;
      }
      localcex.HrI = locala.OmT.readString();
      AppMethodBeat.o(32361);
      return 0;
    }
    AppMethodBeat.o(32361);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cex
 * JD-Core Version:    0.7.0.1
 */