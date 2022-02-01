package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dog
  extends com.tencent.mm.bx.a
{
  public int MNT;
  public int aaVj;
  public int aaVk;
  public int aaVl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116472);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaVj);
      paramVarArgs.bS(2, this.aaVk);
      paramVarArgs.bS(3, this.aaVl);
      paramVarArgs.bS(4, this.MNT);
      AppMethodBeat.o(116472);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aaVj);
      int i = i.a.a.b.b.a.cJ(2, this.aaVk);
      int j = i.a.a.b.b.a.cJ(3, this.aaVl);
      int k = i.a.a.b.b.a.cJ(4, this.MNT);
      AppMethodBeat.o(116472);
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
      AppMethodBeat.o(116472);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dog localdog = (dog)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116472);
        return -1;
      case 1: 
        localdog.aaVj = locala.ajGk.aar();
        AppMethodBeat.o(116472);
        return 0;
      case 2: 
        localdog.aaVk = locala.ajGk.aar();
        AppMethodBeat.o(116472);
        return 0;
      case 3: 
        localdog.aaVl = locala.ajGk.aar();
        AppMethodBeat.o(116472);
        return 0;
      }
      localdog.MNT = locala.ajGk.aar();
      AppMethodBeat.o(116472);
      return 0;
    }
    AppMethodBeat.o(116472);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dog
 * JD-Core Version:    0.7.0.1
 */