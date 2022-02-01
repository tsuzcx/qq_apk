package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dip
  extends com.tencent.mm.bx.a
{
  public int HxA;
  public int Hxv;
  public int Hxw;
  public int Hxx;
  public int Hxy;
  public int Hxz;
  public int Timestamp;
  public int nEe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32457);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nEe);
      paramVarArgs.aS(2, this.Timestamp);
      paramVarArgs.aS(3, this.Hxv);
      paramVarArgs.aS(4, this.Hxw);
      paramVarArgs.aS(5, this.Hxx);
      paramVarArgs.aS(6, this.Hxy);
      paramVarArgs.aS(7, this.Hxz);
      paramVarArgs.aS(8, this.HxA);
      AppMethodBeat.o(32457);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.nEe);
      int i = f.a.a.b.b.a.bz(2, this.Timestamp);
      int j = f.a.a.b.b.a.bz(3, this.Hxv);
      int k = f.a.a.b.b.a.bz(4, this.Hxw);
      int m = f.a.a.b.b.a.bz(5, this.Hxx);
      int n = f.a.a.b.b.a.bz(6, this.Hxy);
      int i1 = f.a.a.b.b.a.bz(7, this.Hxz);
      int i2 = f.a.a.b.b.a.bz(8, this.HxA);
      AppMethodBeat.o(32457);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(32457);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dip localdip = (dip)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32457);
        return -1;
      case 1: 
        localdip.nEe = locala.NPN.zc();
        AppMethodBeat.o(32457);
        return 0;
      case 2: 
        localdip.Timestamp = locala.NPN.zc();
        AppMethodBeat.o(32457);
        return 0;
      case 3: 
        localdip.Hxv = locala.NPN.zc();
        AppMethodBeat.o(32457);
        return 0;
      case 4: 
        localdip.Hxw = locala.NPN.zc();
        AppMethodBeat.o(32457);
        return 0;
      case 5: 
        localdip.Hxx = locala.NPN.zc();
        AppMethodBeat.o(32457);
        return 0;
      case 6: 
        localdip.Hxy = locala.NPN.zc();
        AppMethodBeat.o(32457);
        return 0;
      case 7: 
        localdip.Hxz = locala.NPN.zc();
        AppMethodBeat.o(32457);
        return 0;
      }
      localdip.HxA = locala.NPN.zc();
      AppMethodBeat.o(32457);
      return 0;
    }
    AppMethodBeat.o(32457);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dip
 * JD-Core Version:    0.7.0.1
 */