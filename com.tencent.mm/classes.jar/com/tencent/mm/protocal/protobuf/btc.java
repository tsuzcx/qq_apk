package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class btc
  extends com.tencent.mm.bx.a
{
  public int FqN;
  public String GFh;
  public String GNs;
  public boolean GNt;
  public String GNu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123623);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FqN);
      if (this.GNs != null) {
        paramVarArgs.d(2, this.GNs);
      }
      paramVarArgs.bt(3, this.GNt);
      if (this.GNu != null) {
        paramVarArgs.d(4, this.GNu);
      }
      if (this.GFh != null) {
        paramVarArgs.d(5, this.GFh);
      }
      AppMethodBeat.o(123623);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FqN) + 0;
      paramInt = i;
      if (this.GNs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GNs);
      }
      i = paramInt + f.a.a.b.b.a.alV(3);
      paramInt = i;
      if (this.GNu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GNu);
      }
      i = paramInt;
      if (this.GFh != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GFh);
      }
      AppMethodBeat.o(123623);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(123623);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      btc localbtc = (btc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123623);
        return -1;
      case 1: 
        localbtc.FqN = locala.NPN.zc();
        AppMethodBeat.o(123623);
        return 0;
      case 2: 
        localbtc.GNs = locala.NPN.readString();
        AppMethodBeat.o(123623);
        return 0;
      case 3: 
        localbtc.GNt = locala.NPN.grw();
        AppMethodBeat.o(123623);
        return 0;
      case 4: 
        localbtc.GNu = locala.NPN.readString();
        AppMethodBeat.o(123623);
        return 0;
      }
      localbtc.GFh = locala.NPN.readString();
      AppMethodBeat.o(123623);
      return 0;
    }
    AppMethodBeat.o(123623);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btc
 * JD-Core Version:    0.7.0.1
 */