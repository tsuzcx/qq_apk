package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ade
  extends com.tencent.mm.bv.a
{
  public int fileCount;
  public int wVA;
  public int wVB;
  public int wVC;
  public int wVD;
  public int wVE;
  public int wVr;
  public int wVs;
  public int wVt;
  public int wVu;
  public int wVv;
  public int wVw;
  public int wVx;
  public int wVy;
  public int wVz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51423);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wVr);
      paramVarArgs.aO(2, this.wVs);
      paramVarArgs.aO(3, this.wVt);
      paramVarArgs.aO(4, this.wVu);
      paramVarArgs.aO(5, this.wVv);
      paramVarArgs.aO(6, this.wVw);
      paramVarArgs.aO(7, this.wVx);
      paramVarArgs.aO(8, this.fileCount);
      paramVarArgs.aO(9, this.wVy);
      paramVarArgs.aO(10, this.wVz);
      paramVarArgs.aO(11, this.wVA);
      paramVarArgs.aO(12, this.wVB);
      paramVarArgs.aO(13, this.wVC);
      paramVarArgs.aO(14, this.wVD);
      paramVarArgs.aO(15, this.wVE);
      AppMethodBeat.o(51423);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wVr);
      int i = e.a.a.b.b.a.bl(2, this.wVs);
      int j = e.a.a.b.b.a.bl(3, this.wVt);
      int k = e.a.a.b.b.a.bl(4, this.wVu);
      int m = e.a.a.b.b.a.bl(5, this.wVv);
      int n = e.a.a.b.b.a.bl(6, this.wVw);
      int i1 = e.a.a.b.b.a.bl(7, this.wVx);
      int i2 = e.a.a.b.b.a.bl(8, this.fileCount);
      int i3 = e.a.a.b.b.a.bl(9, this.wVy);
      int i4 = e.a.a.b.b.a.bl(10, this.wVz);
      int i5 = e.a.a.b.b.a.bl(11, this.wVA);
      int i6 = e.a.a.b.b.a.bl(12, this.wVB);
      int i7 = e.a.a.b.b.a.bl(13, this.wVC);
      int i8 = e.a.a.b.b.a.bl(14, this.wVD);
      int i9 = e.a.a.b.b.a.bl(15, this.wVE);
      AppMethodBeat.o(51423);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(51423);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ade localade = (ade)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(51423);
        return -1;
      case 1: 
        localade.wVr = locala.CLY.sl();
        AppMethodBeat.o(51423);
        return 0;
      case 2: 
        localade.wVs = locala.CLY.sl();
        AppMethodBeat.o(51423);
        return 0;
      case 3: 
        localade.wVt = locala.CLY.sl();
        AppMethodBeat.o(51423);
        return 0;
      case 4: 
        localade.wVu = locala.CLY.sl();
        AppMethodBeat.o(51423);
        return 0;
      case 5: 
        localade.wVv = locala.CLY.sl();
        AppMethodBeat.o(51423);
        return 0;
      case 6: 
        localade.wVw = locala.CLY.sl();
        AppMethodBeat.o(51423);
        return 0;
      case 7: 
        localade.wVx = locala.CLY.sl();
        AppMethodBeat.o(51423);
        return 0;
      case 8: 
        localade.fileCount = locala.CLY.sl();
        AppMethodBeat.o(51423);
        return 0;
      case 9: 
        localade.wVy = locala.CLY.sl();
        AppMethodBeat.o(51423);
        return 0;
      case 10: 
        localade.wVz = locala.CLY.sl();
        AppMethodBeat.o(51423);
        return 0;
      case 11: 
        localade.wVA = locala.CLY.sl();
        AppMethodBeat.o(51423);
        return 0;
      case 12: 
        localade.wVB = locala.CLY.sl();
        AppMethodBeat.o(51423);
        return 0;
      case 13: 
        localade.wVC = locala.CLY.sl();
        AppMethodBeat.o(51423);
        return 0;
      case 14: 
        localade.wVD = locala.CLY.sl();
        AppMethodBeat.o(51423);
        return 0;
      }
      localade.wVE = locala.CLY.sl();
      AppMethodBeat.o(51423);
      return 0;
    }
    AppMethodBeat.o(51423);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ade
 * JD-Core Version:    0.7.0.1
 */