package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cec
  extends com.tencent.mm.bx.a
{
  public int FKZ;
  public String FVG;
  public int FYc;
  public int FileSize;
  public int GYd;
  public int GYe;
  public String GYf;
  public int GYg;
  public String GYh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32360);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FVG != null) {
        paramVarArgs.d(1, this.FVG);
      }
      paramVarArgs.aS(2, this.GYd);
      paramVarArgs.aS(3, this.GYe);
      paramVarArgs.aS(4, this.FKZ);
      if (this.GYf != null) {
        paramVarArgs.d(5, this.GYf);
      }
      paramVarArgs.aS(6, this.FileSize);
      paramVarArgs.aS(7, this.GYg);
      paramVarArgs.aS(8, this.FYc);
      if (this.GYh != null) {
        paramVarArgs.d(9, this.GYh);
      }
      AppMethodBeat.o(32360);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FVG == null) {
        break label613;
      }
    }
    label613:
    for (paramInt = f.a.a.b.b.a.e(1, this.FVG) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GYd) + f.a.a.b.b.a.bz(3, this.GYe) + f.a.a.b.b.a.bz(4, this.FKZ);
      paramInt = i;
      if (this.GYf != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GYf);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.FileSize) + f.a.a.b.b.a.bz(7, this.GYg) + f.a.a.b.b.a.bz(8, this.FYc);
      paramInt = i;
      if (this.GYh != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GYh);
      }
      AppMethodBeat.o(32360);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32360);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cec localcec = (cec)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32360);
          return -1;
        case 1: 
          localcec.FVG = locala.NPN.readString();
          AppMethodBeat.o(32360);
          return 0;
        case 2: 
          localcec.GYd = locala.NPN.zc();
          AppMethodBeat.o(32360);
          return 0;
        case 3: 
          localcec.GYe = locala.NPN.zc();
          AppMethodBeat.o(32360);
          return 0;
        case 4: 
          localcec.FKZ = locala.NPN.zc();
          AppMethodBeat.o(32360);
          return 0;
        case 5: 
          localcec.GYf = locala.NPN.readString();
          AppMethodBeat.o(32360);
          return 0;
        case 6: 
          localcec.FileSize = locala.NPN.zc();
          AppMethodBeat.o(32360);
          return 0;
        case 7: 
          localcec.GYg = locala.NPN.zc();
          AppMethodBeat.o(32360);
          return 0;
        case 8: 
          localcec.FYc = locala.NPN.zc();
          AppMethodBeat.o(32360);
          return 0;
        }
        localcec.GYh = locala.NPN.readString();
        AppMethodBeat.o(32360);
        return 0;
      }
      AppMethodBeat.o(32360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cec
 * JD-Core Version:    0.7.0.1
 */