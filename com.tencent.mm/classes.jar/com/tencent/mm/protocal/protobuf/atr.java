package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class atr
  extends com.tencent.mm.bx.a
{
  public int GrF = 7;
  public long GrG = 0L;
  public int GrH = 0;
  public String GrI = "";
  public boolean GrJ = false;
  public int aHQ = 0;
  public int inh = 0;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GrF);
      paramVarArgs.aY(2, this.GrG);
      paramVarArgs.aS(3, this.GrH);
      if (this.GrI != null) {
        paramVarArgs.d(4, this.GrI);
      }
      paramVarArgs.aS(5, this.aHQ);
      paramVarArgs.aS(6, this.inh);
      paramVarArgs.bt(7, this.GrJ);
      AppMethodBeat.o(122494);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GrF) + 0 + f.a.a.b.b.a.p(2, this.GrG) + f.a.a.b.b.a.bz(3, this.GrH);
      paramInt = i;
      if (this.GrI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GrI);
      }
      i = f.a.a.b.b.a.bz(5, this.aHQ);
      int j = f.a.a.b.b.a.bz(6, this.inh);
      int k = f.a.a.b.b.a.alV(7);
      AppMethodBeat.o(122494);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(122494);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      atr localatr = (atr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122494);
        return -1;
      case 1: 
        localatr.GrF = locala.NPN.zc();
        AppMethodBeat.o(122494);
        return 0;
      case 2: 
        localatr.GrG = locala.NPN.zd();
        AppMethodBeat.o(122494);
        return 0;
      case 3: 
        localatr.GrH = locala.NPN.zc();
        AppMethodBeat.o(122494);
        return 0;
      case 4: 
        localatr.GrI = locala.NPN.readString();
        AppMethodBeat.o(122494);
        return 0;
      case 5: 
        localatr.aHQ = locala.NPN.zc();
        AppMethodBeat.o(122494);
        return 0;
      case 6: 
        localatr.inh = locala.NPN.zc();
        AppMethodBeat.o(122494);
        return 0;
      }
      localatr.GrJ = locala.NPN.grw();
      AppMethodBeat.o(122494);
      return 0;
    }
    AppMethodBeat.o(122494);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atr
 * JD-Core Version:    0.7.0.1
 */