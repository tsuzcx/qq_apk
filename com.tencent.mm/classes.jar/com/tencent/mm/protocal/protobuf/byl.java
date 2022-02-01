package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byl
  extends com.tencent.mm.bx.a
{
  public String FxN;
  public int GNc;
  public int GSF;
  public int tRT;
  public int tSp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125742);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.tRT);
      paramVarArgs.aS(2, this.tSp);
      paramVarArgs.aS(3, this.GSF);
      if (this.FxN != null) {
        paramVarArgs.d(4, this.FxN);
      }
      paramVarArgs.aS(5, this.GNc);
      AppMethodBeat.o(125742);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.tRT) + 0 + f.a.a.b.b.a.bz(2, this.tSp) + f.a.a.b.b.a.bz(3, this.GSF);
      paramInt = i;
      if (this.FxN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FxN);
      }
      i = f.a.a.b.b.a.bz(5, this.GNc);
      AppMethodBeat.o(125742);
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
      AppMethodBeat.o(125742);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      byl localbyl = (byl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125742);
        return -1;
      case 1: 
        localbyl.tRT = locala.NPN.zc();
        AppMethodBeat.o(125742);
        return 0;
      case 2: 
        localbyl.tSp = locala.NPN.zc();
        AppMethodBeat.o(125742);
        return 0;
      case 3: 
        localbyl.GSF = locala.NPN.zc();
        AppMethodBeat.o(125742);
        return 0;
      case 4: 
        localbyl.FxN = locala.NPN.readString();
        AppMethodBeat.o(125742);
        return 0;
      }
      localbyl.GNc = locala.NPN.zc();
      AppMethodBeat.o(125742);
      return 0;
    }
    AppMethodBeat.o(125742);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byl
 * JD-Core Version:    0.7.0.1
 */