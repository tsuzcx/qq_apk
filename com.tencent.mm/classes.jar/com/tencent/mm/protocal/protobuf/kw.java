package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class kw
  extends com.tencent.mm.bx.a
{
  public long FCY = 0L;
  public long FCZ = 0L;
  public long FDa = 0L;
  public long FDb = 0L;
  public int FDc;
  public int dvd;
  public int zyN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110886);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.FCY);
      paramVarArgs.aY(2, this.FCZ);
      paramVarArgs.aY(3, this.FDa);
      paramVarArgs.aY(4, this.FDb);
      paramVarArgs.aS(5, this.zyN);
      paramVarArgs.aS(6, this.dvd);
      paramVarArgs.aS(7, this.FDc);
      AppMethodBeat.o(110886);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.FCY);
      int i = f.a.a.b.b.a.p(2, this.FCZ);
      int j = f.a.a.b.b.a.p(3, this.FDa);
      int k = f.a.a.b.b.a.p(4, this.FDb);
      int m = f.a.a.b.b.a.bz(5, this.zyN);
      int n = f.a.a.b.b.a.bz(6, this.dvd);
      int i1 = f.a.a.b.b.a.bz(7, this.FDc);
      AppMethodBeat.o(110886);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(110886);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      kw localkw = (kw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110886);
        return -1;
      case 1: 
        localkw.FCY = locala.NPN.zd();
        AppMethodBeat.o(110886);
        return 0;
      case 2: 
        localkw.FCZ = locala.NPN.zd();
        AppMethodBeat.o(110886);
        return 0;
      case 3: 
        localkw.FDa = locala.NPN.zd();
        AppMethodBeat.o(110886);
        return 0;
      case 4: 
        localkw.FDb = locala.NPN.zd();
        AppMethodBeat.o(110886);
        return 0;
      case 5: 
        localkw.zyN = locala.NPN.zc();
        AppMethodBeat.o(110886);
        return 0;
      case 6: 
        localkw.dvd = locala.NPN.zc();
        AppMethodBeat.o(110886);
        return 0;
      }
      localkw.FDc = locala.NPN.zc();
      AppMethodBeat.o(110886);
      return 0;
    }
    AppMethodBeat.o(110886);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kw
 * JD-Core Version:    0.7.0.1
 */