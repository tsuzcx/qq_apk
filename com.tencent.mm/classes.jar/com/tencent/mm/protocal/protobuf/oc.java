package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class oc
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int YFv;
  public int YQG;
  public int YQH;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124398);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YQG);
      paramVarArgs.bS(2, this.CreateTime);
      paramVarArgs.bS(3, this.YFv);
      paramVarArgs.bS(4, this.vhJ);
      paramVarArgs.bS(5, this.YQH);
      AppMethodBeat.o(124398);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.YQG);
      int i = i.a.a.b.b.a.cJ(2, this.CreateTime);
      int j = i.a.a.b.b.a.cJ(3, this.YFv);
      int k = i.a.a.b.b.a.cJ(4, this.vhJ);
      int m = i.a.a.b.b.a.cJ(5, this.YQH);
      AppMethodBeat.o(124398);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(124398);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      oc localoc = (oc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124398);
        return -1;
      case 1: 
        localoc.YQG = locala.ajGk.aar();
        AppMethodBeat.o(124398);
        return 0;
      case 2: 
        localoc.CreateTime = locala.ajGk.aar();
        AppMethodBeat.o(124398);
        return 0;
      case 3: 
        localoc.YFv = locala.ajGk.aar();
        AppMethodBeat.o(124398);
        return 0;
      case 4: 
        localoc.vhJ = locala.ajGk.aar();
        AppMethodBeat.o(124398);
        return 0;
      }
      localoc.YQH = locala.ajGk.aar();
      AppMethodBeat.o(124398);
      return 0;
    }
    AppMethodBeat.o(124398);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oc
 * JD-Core Version:    0.7.0.1
 */