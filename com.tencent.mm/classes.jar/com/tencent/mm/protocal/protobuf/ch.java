package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ch
  extends com.tencent.mm.bx.a
{
  public String data;
  public int wuj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259671);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.wuj);
      if (this.data != null) {
        paramVarArgs.g(2, this.data);
      }
      AppMethodBeat.o(259671);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.wuj) + 0;
      paramInt = i;
      if (this.data != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.data);
      }
      AppMethodBeat.o(259671);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259671);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ch localch = (ch)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259671);
        return -1;
      case 1: 
        localch.wuj = locala.ajGk.aar();
        AppMethodBeat.o(259671);
        return 0;
      }
      localch.data = locala.ajGk.readString();
      AppMethodBeat.o(259671);
      return 0;
    }
    AppMethodBeat.o(259671);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ch
 * JD-Core Version:    0.7.0.1
 */