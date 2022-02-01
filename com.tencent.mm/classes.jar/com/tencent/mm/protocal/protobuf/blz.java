package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class blz
  extends com.tencent.mm.bx.a
{
  public int ZUH;
  public long ZUI;
  public int ZUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259121);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZUH);
      paramVarArgs.bv(2, this.ZUI);
      paramVarArgs.bS(3, this.ZUJ);
      AppMethodBeat.o(259121);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.ZUH);
      int i = i.a.a.b.b.a.q(2, this.ZUI);
      int j = i.a.a.b.b.a.cJ(3, this.ZUJ);
      AppMethodBeat.o(259121);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259121);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      blz localblz = (blz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259121);
        return -1;
      case 1: 
        localblz.ZUH = locala.ajGk.aar();
        AppMethodBeat.o(259121);
        return 0;
      case 2: 
        localblz.ZUI = locala.ajGk.aaw();
        AppMethodBeat.o(259121);
        return 0;
      }
      localblz.ZUJ = locala.ajGk.aar();
      AppMethodBeat.o(259121);
      return 0;
    }
    AppMethodBeat.o(259121);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blz
 * JD-Core Version:    0.7.0.1
 */