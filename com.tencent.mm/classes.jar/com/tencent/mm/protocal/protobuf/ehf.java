package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehf
  extends com.tencent.mm.bx.a
{
  public long YTK;
  public long abmu;
  public int wwu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104829);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.wwu);
      paramVarArgs.bv(2, this.YTK);
      paramVarArgs.bv(3, this.abmu);
      AppMethodBeat.o(104829);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.wwu);
      int i = i.a.a.b.b.a.q(2, this.YTK);
      int j = i.a.a.b.b.a.q(3, this.abmu);
      AppMethodBeat.o(104829);
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
      AppMethodBeat.o(104829);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ehf localehf = (ehf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104829);
        return -1;
      case 1: 
        localehf.wwu = locala.ajGk.aar();
        AppMethodBeat.o(104829);
        return 0;
      case 2: 
        localehf.YTK = locala.ajGk.aaw();
        AppMethodBeat.o(104829);
        return 0;
      }
      localehf.abmu = locala.ajGk.aaw();
      AppMethodBeat.o(104829);
      return 0;
    }
    AppMethodBeat.o(104829);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehf
 * JD-Core Version:    0.7.0.1
 */