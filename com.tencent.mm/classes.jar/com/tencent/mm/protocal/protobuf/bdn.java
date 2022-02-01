package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bdn
  extends com.tencent.mm.bx.a
{
  public int ZOe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259083);
    if (paramInt == 0)
    {
      ((i.a.a.c.a)paramVarArgs[0]).bS(101, this.ZOe);
      AppMethodBeat.o(259083);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(101, this.ZOe);
      AppMethodBeat.o(259083);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259083);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bdn localbdn = (bdn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259083);
        return -1;
      }
      localbdn.ZOe = locala.ajGk.aar();
      AppMethodBeat.o(259083);
      return 0;
    }
    AppMethodBeat.o(259083);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdn
 * JD-Core Version:    0.7.0.1
 */