package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aox
  extends com.tencent.mm.bx.a
{
  public int Gnt;
  public int ddx;
  public long gGy;
  public int liveStatus;
  public String zZx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209327);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.gGy);
      paramVarArgs.aS(2, this.Gnt);
      paramVarArgs.aS(3, this.liveStatus);
      if (this.zZx != null) {
        paramVarArgs.d(4, this.zZx);
      }
      paramVarArgs.aS(5, this.ddx);
      AppMethodBeat.o(209327);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.gGy) + 0 + f.a.a.b.b.a.bz(2, this.Gnt) + f.a.a.b.b.a.bz(3, this.liveStatus);
      paramInt = i;
      if (this.zZx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.zZx);
      }
      i = f.a.a.b.b.a.bz(5, this.ddx);
      AppMethodBeat.o(209327);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(209327);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aox localaox = (aox)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209327);
        return -1;
      case 1: 
        localaox.gGy = locala.NPN.zd();
        AppMethodBeat.o(209327);
        return 0;
      case 2: 
        localaox.Gnt = locala.NPN.zc();
        AppMethodBeat.o(209327);
        return 0;
      case 3: 
        localaox.liveStatus = locala.NPN.zc();
        AppMethodBeat.o(209327);
        return 0;
      case 4: 
        localaox.zZx = locala.NPN.readString();
        AppMethodBeat.o(209327);
        return 0;
      }
      localaox.ddx = locala.NPN.zc();
      AppMethodBeat.o(209327);
      return 0;
    }
    AppMethodBeat.o(209327);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aox
 * JD-Core Version:    0.7.0.1
 */