package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxi
  extends com.tencent.mm.bx.a
{
  public String GDb;
  public long GRq;
  public long GRr;
  public int GRs;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117877);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Scene);
      if (this.GDb != null) {
        paramVarArgs.d(2, this.GDb);
      }
      paramVarArgs.aY(3, this.GRr);
      paramVarArgs.aY(4, this.GRq);
      paramVarArgs.aS(5, this.GRs);
      AppMethodBeat.o(117877);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Scene) + 0;
      paramInt = i;
      if (this.GDb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GDb);
      }
      i = f.a.a.b.b.a.p(3, this.GRr);
      int j = f.a.a.b.b.a.p(4, this.GRq);
      int k = f.a.a.b.b.a.bz(5, this.GRs);
      AppMethodBeat.o(117877);
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
      AppMethodBeat.o(117877);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bxi localbxi = (bxi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117877);
        return -1;
      case 1: 
        localbxi.Scene = locala.NPN.zc();
        AppMethodBeat.o(117877);
        return 0;
      case 2: 
        localbxi.GDb = locala.NPN.readString();
        AppMethodBeat.o(117877);
        return 0;
      case 3: 
        localbxi.GRr = locala.NPN.zd();
        AppMethodBeat.o(117877);
        return 0;
      case 4: 
        localbxi.GRq = locala.NPN.zd();
        AppMethodBeat.o(117877);
        return 0;
      }
      localbxi.GRs = locala.NPN.zc();
      AppMethodBeat.o(117877);
      return 0;
    }
    AppMethodBeat.o(117877);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxi
 * JD-Core Version:    0.7.0.1
 */