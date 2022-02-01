package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxm
  extends com.tencent.mm.bx.a
{
  public boolean GRA;
  public int GRB;
  public String GRC;
  public boolean GRD;
  public boolean GRE;
  public String GRF;
  public boolean GRz;
  public String duW;
  public int sJZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127172);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.GRz);
      paramVarArgs.bt(2, this.GRA);
      paramVarArgs.aS(3, this.sJZ);
      paramVarArgs.aS(4, this.GRB);
      if (this.GRC != null) {
        paramVarArgs.d(5, this.GRC);
      }
      paramVarArgs.bt(6, this.GRD);
      if (this.duW != null) {
        paramVarArgs.d(7, this.duW);
      }
      paramVarArgs.bt(8, this.GRE);
      if (this.GRF != null) {
        paramVarArgs.d(9, this.GRF);
      }
      AppMethodBeat.o(127172);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alV(1) + 0 + f.a.a.b.b.a.alV(2) + f.a.a.b.b.a.bz(3, this.sJZ) + f.a.a.b.b.a.bz(4, this.GRB);
      paramInt = i;
      if (this.GRC != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GRC);
      }
      i = paramInt + f.a.a.b.b.a.alV(6);
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.duW);
      }
      i = paramInt + f.a.a.b.b.a.alV(8);
      paramInt = i;
      if (this.GRF != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GRF);
      }
      AppMethodBeat.o(127172);
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
      AppMethodBeat.o(127172);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bxm localbxm = (bxm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127172);
        return -1;
      case 1: 
        localbxm.GRz = locala.NPN.grw();
        AppMethodBeat.o(127172);
        return 0;
      case 2: 
        localbxm.GRA = locala.NPN.grw();
        AppMethodBeat.o(127172);
        return 0;
      case 3: 
        localbxm.sJZ = locala.NPN.zc();
        AppMethodBeat.o(127172);
        return 0;
      case 4: 
        localbxm.GRB = locala.NPN.zc();
        AppMethodBeat.o(127172);
        return 0;
      case 5: 
        localbxm.GRC = locala.NPN.readString();
        AppMethodBeat.o(127172);
        return 0;
      case 6: 
        localbxm.GRD = locala.NPN.grw();
        AppMethodBeat.o(127172);
        return 0;
      case 7: 
        localbxm.duW = locala.NPN.readString();
        AppMethodBeat.o(127172);
        return 0;
      case 8: 
        localbxm.GRE = locala.NPN.grw();
        AppMethodBeat.o(127172);
        return 0;
      }
      localbxm.GRF = locala.NPN.readString();
      AppMethodBeat.o(127172);
      return 0;
    }
    AppMethodBeat.o(127172);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxm
 * JD-Core Version:    0.7.0.1
 */