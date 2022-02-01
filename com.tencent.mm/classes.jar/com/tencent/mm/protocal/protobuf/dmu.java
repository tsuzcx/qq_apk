package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmu
  extends com.tencent.mm.bx.a
{
  public long HBb;
  public long HBc;
  public int HBd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125848);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.HBb);
      paramVarArgs.aY(2, this.HBc);
      paramVarArgs.aS(3, this.HBd);
      AppMethodBeat.o(125848);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.HBb);
      int i = f.a.a.b.b.a.p(2, this.HBc);
      int j = f.a.a.b.b.a.bz(3, this.HBd);
      AppMethodBeat.o(125848);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(125848);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dmu localdmu = (dmu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125848);
        return -1;
      case 1: 
        localdmu.HBb = locala.NPN.zd();
        AppMethodBeat.o(125848);
        return 0;
      case 2: 
        localdmu.HBc = locala.NPN.zd();
        AppMethodBeat.o(125848);
        return 0;
      }
      localdmu.HBd = locala.NPN.zc();
      AppMethodBeat.o(125848);
      return 0;
    }
    AppMethodBeat.o(125848);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmu
 * JD-Core Version:    0.7.0.1
 */