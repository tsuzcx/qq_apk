package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bku
  extends com.tencent.mm.bx.a
{
  public long ZTS;
  public int ZTT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259415);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ZTS);
      paramVarArgs.bS(2, this.ZTT);
      AppMethodBeat.o(259415);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.ZTS);
      int i = i.a.a.b.b.a.cJ(2, this.ZTT);
      AppMethodBeat.o(259415);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259415);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bku localbku = (bku)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259415);
        return -1;
      case 1: 
        localbku.ZTS = locala.ajGk.aaw();
        AppMethodBeat.o(259415);
        return 0;
      }
      localbku.ZTT = locala.ajGk.aar();
      AppMethodBeat.o(259415);
      return 0;
    }
    AppMethodBeat.o(259415);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bku
 * JD-Core Version:    0.7.0.1
 */