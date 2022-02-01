package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcz
  extends com.tencent.mm.bx.a
{
  public int aaIC;
  public int aaIs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259011);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaIs);
      paramVarArgs.bS(2, this.aaIC);
      AppMethodBeat.o(259011);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aaIs);
      int i = i.a.a.b.b.a.cJ(2, this.aaIC);
      AppMethodBeat.o(259011);
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
      AppMethodBeat.o(259011);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dcz localdcz = (dcz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259011);
        return -1;
      case 1: 
        localdcz.aaIs = locala.ajGk.aar();
        AppMethodBeat.o(259011);
        return 0;
      }
      localdcz.aaIC = locala.ajGk.aar();
      AppMethodBeat.o(259011);
      return 0;
    }
    AppMethodBeat.o(259011);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcz
 * JD-Core Version:    0.7.0.1
 */