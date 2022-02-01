package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afs
  extends com.tencent.mm.bx.a
{
  public long ZnD;
  public long ZnE;
  public int ZoC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259897);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ZnD);
      paramVarArgs.bv(2, this.ZnE);
      paramVarArgs.bS(3, this.ZoC);
      AppMethodBeat.o(259897);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.ZnD);
      int i = i.a.a.b.b.a.q(2, this.ZnE);
      int j = i.a.a.b.b.a.cJ(3, this.ZoC);
      AppMethodBeat.o(259897);
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
      AppMethodBeat.o(259897);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      afs localafs = (afs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259897);
        return -1;
      case 1: 
        localafs.ZnD = locala.ajGk.aaw();
        AppMethodBeat.o(259897);
        return 0;
      case 2: 
        localafs.ZnE = locala.ajGk.aaw();
        AppMethodBeat.o(259897);
        return 0;
      }
      localafs.ZoC = locala.ajGk.aar();
      AppMethodBeat.o(259897);
      return 0;
    }
    AppMethodBeat.o(259897);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afs
 * JD-Core Version:    0.7.0.1
 */