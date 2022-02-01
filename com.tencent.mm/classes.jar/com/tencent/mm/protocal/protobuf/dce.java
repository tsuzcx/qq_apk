package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dce
  extends com.tencent.mm.bx.a
{
  public long aaHS;
  public int aaHT;
  public int key;
  public int length;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111786);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.key);
      paramVarArgs.bv(2, this.aaHS);
      paramVarArgs.bS(3, this.length);
      paramVarArgs.bS(4, this.aaHT);
      AppMethodBeat.o(111786);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.key);
      int i = i.a.a.b.b.a.q(2, this.aaHS);
      int j = i.a.a.b.b.a.cJ(3, this.length);
      int k = i.a.a.b.b.a.cJ(4, this.aaHT);
      AppMethodBeat.o(111786);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(111786);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dce localdce = (dce)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(111786);
        return -1;
      case 1: 
        localdce.key = locala.ajGk.aar();
        AppMethodBeat.o(111786);
        return 0;
      case 2: 
        localdce.aaHS = locala.ajGk.aaw();
        AppMethodBeat.o(111786);
        return 0;
      case 3: 
        localdce.length = locala.ajGk.aar();
        AppMethodBeat.o(111786);
        return 0;
      }
      localdce.aaHT = locala.ajGk.aar();
      AppMethodBeat.o(111786);
      return 0;
    }
    AppMethodBeat.o(111786);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dce
 * JD-Core Version:    0.7.0.1
 */