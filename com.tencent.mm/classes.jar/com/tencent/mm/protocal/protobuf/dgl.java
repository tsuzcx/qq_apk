package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dgl
  extends com.tencent.mm.bx.a
{
  public int YVh;
  public int aaLC;
  public String aaLD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(146308);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaLC);
      if (this.aaLD != null) {
        paramVarArgs.g(2, this.aaLD);
      }
      paramVarArgs.bS(3, this.YVh);
      AppMethodBeat.o(146308);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.aaLC) + 0;
      paramInt = i;
      if (this.aaLD != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaLD);
      }
      i = i.a.a.b.b.a.cJ(3, this.YVh);
      AppMethodBeat.o(146308);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(146308);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dgl localdgl = (dgl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(146308);
        return -1;
      case 1: 
        localdgl.aaLC = locala.ajGk.aar();
        AppMethodBeat.o(146308);
        return 0;
      case 2: 
        localdgl.aaLD = locala.ajGk.readString();
        AppMethodBeat.o(146308);
        return 0;
      }
      localdgl.YVh = locala.ajGk.aar();
      AppMethodBeat.o(146308);
      return 0;
    }
    AppMethodBeat.o(146308);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgl
 * JD-Core Version:    0.7.0.1
 */