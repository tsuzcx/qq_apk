package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlr
  extends com.tencent.mm.bx.a
{
  public int aaRI;
  public int aaRJ;
  public int aaRK;
  public int aaRL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169923);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaRI);
      paramVarArgs.bS(2, this.aaRJ);
      paramVarArgs.bS(3, this.aaRK);
      paramVarArgs.bS(4, this.aaRL);
      AppMethodBeat.o(169923);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aaRI);
      int i = i.a.a.b.b.a.cJ(2, this.aaRJ);
      int j = i.a.a.b.b.a.cJ(3, this.aaRK);
      int k = i.a.a.b.b.a.cJ(4, this.aaRL);
      AppMethodBeat.o(169923);
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
      AppMethodBeat.o(169923);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dlr localdlr = (dlr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169923);
        return -1;
      case 1: 
        localdlr.aaRI = locala.ajGk.aar();
        AppMethodBeat.o(169923);
        return 0;
      case 2: 
        localdlr.aaRJ = locala.ajGk.aar();
        AppMethodBeat.o(169923);
        return 0;
      case 3: 
        localdlr.aaRK = locala.ajGk.aar();
        AppMethodBeat.o(169923);
        return 0;
      }
      localdlr.aaRL = locala.ajGk.aar();
      AppMethodBeat.o(169923);
      return 0;
    }
    AppMethodBeat.o(169923);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlr
 * JD-Core Version:    0.7.0.1
 */