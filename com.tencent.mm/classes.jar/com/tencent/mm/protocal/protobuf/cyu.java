package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyu
  extends com.tencent.mm.bx.a
{
  public long aaDC;
  public int aaDD;
  public long aaDE;
  public int aaDF;
  public long aaDG;
  public int aaDH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115845);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aaDC);
      paramVarArgs.bS(2, this.aaDD);
      paramVarArgs.bv(3, this.aaDE);
      paramVarArgs.bS(4, this.aaDF);
      paramVarArgs.bv(5, this.aaDG);
      paramVarArgs.bS(6, this.aaDH);
      AppMethodBeat.o(115845);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.aaDC);
      int i = i.a.a.b.b.a.cJ(2, this.aaDD);
      int j = i.a.a.b.b.a.q(3, this.aaDE);
      int k = i.a.a.b.b.a.cJ(4, this.aaDF);
      int m = i.a.a.b.b.a.q(5, this.aaDG);
      int n = i.a.a.b.b.a.cJ(6, this.aaDH);
      AppMethodBeat.o(115845);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(115845);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      cyu localcyu = (cyu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115845);
        return -1;
      case 1: 
        localcyu.aaDC = locala.ajGk.aaw();
        AppMethodBeat.o(115845);
        return 0;
      case 2: 
        localcyu.aaDD = locala.ajGk.aar();
        AppMethodBeat.o(115845);
        return 0;
      case 3: 
        localcyu.aaDE = locala.ajGk.aaw();
        AppMethodBeat.o(115845);
        return 0;
      case 4: 
        localcyu.aaDF = locala.ajGk.aar();
        AppMethodBeat.o(115845);
        return 0;
      case 5: 
        localcyu.aaDG = locala.ajGk.aaw();
        AppMethodBeat.o(115845);
        return 0;
      }
      localcyu.aaDH = locala.ajGk.aar();
      AppMethodBeat.o(115845);
      return 0;
    }
    AppMethodBeat.o(115845);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyu
 * JD-Core Version:    0.7.0.1
 */